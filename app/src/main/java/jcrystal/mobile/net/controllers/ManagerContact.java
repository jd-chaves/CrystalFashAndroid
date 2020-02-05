package jcrystal.mobile.net.controllers;
import jcrystal.mobile.net.utils.*;
import jcrystal.mobile.entities.*;
import jcrystal.mobile.entities.enums.*;
import jcrystal.mobile.*;
import jcrystal.datetime.*;
import jcrystal.mobile.net.*;
import android.os.AsyncTask;
import static jcrystal.JSONUtils.*;
public class ManagerContact{
	/**
	* /api/contact/contact
	**/
	public static AsyncTask contact(android.app.Activity $activity, String name, String email, String message, OnVoidSuccessListener onSuccess, OnErrorListener onError){
		return contact($activity, (androidx.fragment.app.Fragment)null, name, email, message, onSuccess, onError).exec();
	}
	public static AsyncTask contact(androidx.fragment.app.Fragment $fragment, String name, String email, String message, OnVoidSuccessListener onSuccess, OnErrorListener onError){
		return contact(null, $fragment, name, email, message, onSuccess, onError).exec();
	}
	public static <T extends androidx.fragment.app.Fragment & OnErrorListener> AsyncTask contact(T $fragment, String name, String email, String message, OnVoidSuccessListener onSuccess){
		return contact(null, $fragment, name, email, message, onSuccess, $fragment).exec();
	}
	public static <T extends android.app.Activity & OnErrorListener> AsyncTask contact(T $activity, String name, String email, String message, OnVoidSuccessListener onSuccess){
		return contact($activity, (androidx.fragment.app.Fragment)null, name, email, message, onSuccess, $activity).exec();
	}
	public static void contact(NetChain $chain, String name, String email, String message, OnVoidSuccessListener onSuccess){
		if($chain.fragment != null){
			$chain.add(contact(null, $chain.fragment, name, email, message, onSuccess, $chain));
		}
		else{
			$chain.add(contact($chain.activity, (androidx.fragment.app.Fragment)null, name, email, message, onSuccess, $chain));
		}
	}
	private static NetTask<org.json.JSONObject> contact(android.app.Activity $activity, androidx.fragment.app.Fragment $fragment, String name, String email, String message, OnVoidSuccessListener onSuccess, OnErrorListener onError){
		return new AbsDefaultManager.JSONObjectResp($activity, $fragment, onError){
			@Override protected String getUrl()throws java.io.UnsupportedEncodingException{
				String ruta = "/api/contact/contact";
				String params = null;
				if(name != null)
					params = (params==null?"?":(params + "&")) + "name=" + java.net.URLEncoder.encode(name, "UTF-8");
				if(email != null)
					params = (params==null?"?":(params + "&")) + "email=" + java.net.URLEncoder.encode(email, "UTF-8");
				if(message != null)
					params = (params==null?"?":(params + "&")) + "message=" + java.net.URLEncoder.encode(message, "UTF-8");
				if(params != null)ruta+=params;
				return ruta;
			}
			@Override
			public void onResponse(org.json.JSONObject result)throws Exception{
				onSuccess.onSuccess();
			}
		}.doGet();
	}
}
