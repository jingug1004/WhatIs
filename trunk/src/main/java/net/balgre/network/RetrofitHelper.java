package net.balgre.network;

import java.lang.reflect.Field;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.balgre.BalgreConstants;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper { 
	private static final String TAG = "RetrofitHelper"; 
	private static RetrofitHelper mInstance; 
	private static final Logger logger = LoggerFactory.getLogger(RetrofitHelper.class);

	private Retrofit mRetrofit; 

	private RetrofitHelper() { 
		if (mRetrofit != null) { 
			logger.debug(TAG, "Retrofit is already initialized"); 
		} 
		mRetrofit = getDefaultRetrofit();
	} 

	public static RetrofitHelper getInstance() { 
		if (mInstance == null) { 
			synchronized (RetrofitHelper.class) { 
				mInstance = new RetrofitHelper(); 
			} 
		} 
		return mInstance; 
	}

	public void init() {
		if (mRetrofit != null) { 
			logger.debug(TAG, "Retrofit is already initialized"); 
		} 
		mRetrofit = getDefaultRetrofit();
	} 

	private Retrofit getDefaultRetrofit() { 
		OkHttpClient httpClient = new OkHttpClient.Builder().build(); 
		try { 
			SSLContext sc; 
			sc = SSLContext.getInstance("SSL"); 
			sc.init(null, new TrustManager[]{ new X509TrustManager() { 

				@Override 
				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException { } 

				@Override 
				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException { } 

				@Override public X509Certificate[] getAcceptedIssuers() { 
					return null; 
				} 
			}}, new SecureRandom()); 

			HostnameVerifier hv = (hostname, session) -> true; 

			String workerClassName = "okhttp3.OkHttpClient"; 
			try { 
				Class workerClass = Class.forName(workerClassName); 
				Field hostnameVerifier = workerClass.getDeclaredField("hostnameVerifier"); 
				hostnameVerifier.setAccessible(true); 
				hostnameVerifier.set(httpClient, hv); 
				Field sslSocketFactory = workerClass.getDeclaredField("sslSocketFactory"); 
				sslSocketFactory.setAccessible(true); 
				sslSocketFactory.set(httpClient, sc.getSocketFactory()); 
			} catch (Exception e) { 
				e.printStackTrace(); 
			} 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
		return new Retrofit.Builder().baseUrl(BalgreConstants.API_URL).client(httpClient).addConverterFactory(buildGsonConverter()).build(); 
	} 

	protected GsonConverterFactory buildGsonConverter() {
		GsonBuilder gsonBuilder = new GsonBuilder();

		Gson myGson = gsonBuilder.create();

		return GsonConverterFactory.create(myGson);

	}
	
	public Retrofit getRetroFit() {
	    return mRetrofit;
	}
}

