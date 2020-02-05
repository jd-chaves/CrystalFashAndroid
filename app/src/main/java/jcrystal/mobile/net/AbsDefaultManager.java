package jcrystal.mobile.net;
import android.app.Activity;
import androidx.fragment.app.Fragment;
import jcrystal.mobile.net.utils.*;
public abstract class AbsDefaultManager<T> extends NetTask<T>{
	public static final String BASE_URL = "http://crystalflash.appspot.com";
	private boolean formData;
	protected String boundary;
	public AbsDefaultManager(Activity activity, Fragment fragment, OnErrorListener onError){
		super(activity, fragment, onError);
	}
	@Override protected final T doRequest()throws Exception{
		java.net.HttpURLConnection connection = (java.net.HttpURLConnection) new java.net.URL(BASE_URL + getUrl()).openConnection();
		if(jcrystal.JCrystalApp.DEBUG)System.out.println(type + " " + BASE_URL + getUrl());
		connection.setConnectTimeout(NetConfig.TIMEOUT);
		connection.setRequestMethod(type.name());
		connection.setRequestProperty("Accept", "application/json");
		if(authorization != null){
			connection.setRequestProperty("Authorization", authorization);
		}
		if(headers != null){
			for (java.util.Map.Entry<String, String> entry : headers.entrySet()){
				connection.setRequestProperty(entry.getKey(), entry.getValue());
			}
		}
		if(type.isPost){
			if(formData){
				connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=---------------------------"+boundary);
			}
			else{
				connection.setRequestProperty("Content-Type", "application/json");
			}
		}
		connection.connect();
		if(type.isPost){
			if(jcrystal.JCrystalApp.DEBUG){
				java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
				java.io.PrintStream _pw = new java.io.PrintStream(baos, false, "UTF-8");
				makeBody(_pw);
				_pw.flush();
				_pw.close();
				System.out.println(new String(baos.toByteArray()));
				connection.getOutputStream().write(baos.toByteArray());
				connection.getOutputStream().close();
			}
			else{
				java.io.PrintStream _pw = new java.io.PrintStream(connection.getOutputStream(), false, "UTF-8");
				makeBody(_pw);
				_pw.flush();
				_pw.close();
			}
		}
		final int responseCode = connection.getResponseCode();
		if(responseCode >= 200 && responseCode <= 299){
			final StringBuilder resp = HTTPUtils.readResponse(connection.getInputStream());
			connection.disconnect();
			if(jcrystal.JCrystalApp.DEBUG)System.out.println(resp);
			return getResponse(resp);
		}
		else{
			if(onError != null){
				final java.io.InputStream errorStream = connection.getErrorStream();
				final StringBuilder resp;
				if(errorStream != null){
					resp = HTTPUtils.readResponse(errorStream);
					if(jcrystal.JCrystalApp.DEBUG)System.out.println(resp);
				}
				else{
					resp = new StringBuilder("");
				}
				connection.disconnect();
				error = new RequestError(responseCode, resp.toString());
			}
			else{
				connection.disconnect();
			}
			return null;
		}
	}
	public AbsDefaultManager doFormData(){
		formData = true;
		boundary = Long.toString(System.currentTimeMillis());
		return this;
	}
	@Override
	protected void onPostExecute(T result){
		if(isContextActive()){
			if(result != null){
				try{
					onResponse(result);
				}
				catch(Exception ex){
					if(jcrystal.JCrystalApp.DEBUG)ex.printStackTrace();
					if(onError!=null)onError.onError(new RequestError(TipoError.SERVER_ERROR, "OcurriÃ³ un error con el servidor"));
				}
			}
			else if(onError != null){
				onError.onError(error);
			}
			if($chain != null)$chain.endTask();
		}
	}
	protected void makeBody(java.io.PrintStream _pw) throws java.io.UnsupportedEncodingException, java.io.IOException{
	}
	protected abstract void onResponse(T result) throws Exception;
	abstract T getResponse(StringBuilder resp) throws Exception;
	public abstract static class StringResp extends AbsDefaultManager<String>{
		public StringResp(Activity activity, Fragment fragment, OnErrorListener onError){
			super(activity, fragment, onError);
		}
		@Override protected String getResponse(StringBuilder resp)throws Exception{
			return resp.toString();
		}
	}
	public abstract static class JSONObjectResp extends AbsDefaultManager<org.json.JSONObject>{
		public JSONObjectResp(Activity activity, Fragment fragment, OnErrorListener onError){
			super(activity, fragment, onError);
		}
		@Override protected org.json.JSONObject getResponse(StringBuilder resp)throws Exception{
			org.json.JSONObject json = new org.json.JSONObject(resp.toString());
			final int success = json.optInt("success", 1);
			if(success == 1){return json;}
			if(success == 2){
				error = new RequestError(json.optInt("code",0), json.getString("mensaje"));
				return null;
			}
			if(success == 3){
				error = new RequestError(TipoError.UNAUTHORIZED, json.getString("mensaje"));
				return null;
			}
			error = new RequestError(TipoError.SERVER_ERROR, json.getString("mensaje"));
			return null;
		}
	}
	public abstract static class JSONArrayResp extends AbsDefaultManager<org.json.JSONArray>{
		public JSONArrayResp(Activity activity, Fragment fragment, OnErrorListener onError){
			super(activity, fragment, onError);
		}
		@Override protected org.json.JSONArray getResponse(StringBuilder resp)throws Exception{
			org.json.JSONArray json = new org.json.JSONArray(resp.toString());
			final int success = 1;
			if(success == 1){return json;}
			if(success == 2){
				error = new RequestError(0, "SERVER ERROR");
				return null;
			}
			if(success == 3){
				error = new RequestError(0, "SERVER ERROR");
				return null;
			}
			error = new RequestError(0, "SERVER ERROR");
			return null;
		}
	}
}
