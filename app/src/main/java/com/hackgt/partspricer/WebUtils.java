package com.hackgt.partspricer;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.util.Pair;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;

/**
 * Created by Antech Development on 5/18/16.
 */
public class WebUtils {
	private static boolean isOnline;

	static {
		isOnline = true;
		new Thread(new Runnable() {
			@Override
			public void run () {
				//noinspection InfiniteLoopStatement
				while (true) {
					updateIsOnline();

					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public static String[] getJsonsFromUrls (Pair<String, String>[] headers, @NonNull String... url) {
		String[] jsons = new String[url.length];
		if (!isOnline()) { return jsons; }

		for (int i = 0; i < url.length; ++i) {
			InputStream inputStream = null;
			try {
				HttpURLConnection urlConnection = (HttpURLConnection) new URL(url[i]).openConnection();

				for (Pair<String, String> headerPair : headers) {
					urlConnection.addRequestProperty(headerPair.first, headerPair.second);
				}

				inputStream = urlConnection.getInputStream();
			} catch (Exception e) {
				Log.e("Exception", e.toString());
				e.printStackTrace();
			}
			if (inputStream != null) {
				try {
					BufferedReader bReader  = new BufferedReader(new InputStreamReader(inputStream, "utf-8"), 8);
					StringBuilder  sBuilder = new StringBuilder();

					String line;
					while ((line = bReader.readLine()) != null) {
						sBuilder.append(line).append("\n");
					}

					inputStream.close();
					jsons[i] = sBuilder.toString();
				} catch (Exception e) {
					Log.e("StringBuilding", "Error converting result " + e.toString());
				}
			}
		}
		return jsons;
	}

	public static boolean isOnline () { return isOnline; }

	private static boolean updateIsOnline () {
		Runtime runtime = Runtime.getRuntime();
		try {
			Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
			int     exitValue = ipProcess.waitFor();
			return isOnline = (exitValue == 0);
		} catch (IOException | InterruptedException e) { e.printStackTrace(); }

		return isOnline = false;
	}

	public static abstract class HTTPAsyncTask <T, T1, T2> extends AsyncTask<T, T1, T2> {
		protected final CallbackWithType<T2> callback;
		private         View.OnClickListener retryCallback;
		private         View                 viewForOfflineNotif;

		@SuppressWarnings ("unchecked")
		protected abstract T2 doAsyncIfOnline (T... ts);

		public HTTPAsyncTask (CallbackWithType<T2> callback) { this.callback = callback; }

		@Override
		@SuppressWarnings ("unchecked")
		protected T2 doInBackground (T... ts) {
			if (isOnline()) { return doAsyncIfOnline(ts); }
			else { return null; }
		}

		@Override
		protected void onPostExecute (T2 t2) {
			if (isOnline()) { onPostExecuteIfOnline(t2); }
			else { onPostExecuteIfOffline(t2); }
			onPostExecuteFinal(t2);

			if (isOnline()) { callback(t2); }
		}

		protected void callback (T2 t2) { if (callback != null) { callback.onComplete(t2); } }

		@SuppressWarnings ("unchecked")
		protected void onPostExecuteFinal (T2 t2) { }

		@SuppressWarnings ("unchecked")
		protected void onPostExecuteIfOffline (T2 t2) {
			if (viewForOfflineNotif != null) {
				Snackbar snackbar = Snackbar.make(viewForOfflineNotif, "Offline", Snackbar.LENGTH_INDEFINITE);
				if (retryCallback != null) { snackbar.setAction("Retry", retryCallback); }
				snackbar.show();
			}
		}

		@SuppressWarnings ("unchecked")
		protected void onPostExecuteIfOnline (T2 t2) { }

		protected void setViewForOfflineNotif (View viewForOfflineNotif, @Nullable View.OnClickListener retryCallback) {
			this.viewForOfflineNotif = viewForOfflineNotif;
			this.retryCallback = retryCallback;
		}
	}

	public abstract class CallbackWithType <T2> {
		public abstract void onComplete (T2 t2);
	}

	boolean isGoogleReachableWithInetAddress () {
		try {
			InetAddress inetAddress = InetAddress.getByName("www.google.com");

			return inetAddress != null && !inetAddress.equals("");
		} catch (Exception ex) {
			return false;
		}
	}
}

