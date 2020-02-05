package jcrystal.mobile.net.controllers;
import jcrystal.mobile.net.utils.*;
import jcrystal.mobile.entities.*;
import jcrystal.mobile.entities.enums.*;
import jcrystal.mobile.*;
import jcrystal.datetime.*;
import jcrystal.mobile.net.*;
import android.os.AsyncTask;
import static jcrystal.JSONUtils.*;
public class ManagerProduct{
	/**
	* /api/product/filterProductsByCategory
	**/
	public static AsyncTask filterProductsByCategory(android.app.Activity $activity, Categories category, On1SuccessListener<java.util.List<jcrystal.mobile.entities.ProductNormal>> onSuccess, OnErrorListener onError){
		return filterProductsByCategory($activity, (androidx.fragment.app.Fragment)null, category, onSuccess, onError).exec();
	}
	public static AsyncTask filterProductsByCategory(androidx.fragment.app.Fragment $fragment, Categories category, On1SuccessListener<java.util.List<jcrystal.mobile.entities.ProductNormal>> onSuccess, OnErrorListener onError){
		return filterProductsByCategory(null, $fragment, category, onSuccess, onError).exec();
	}
	public static <T extends androidx.fragment.app.Fragment & OnErrorListener> AsyncTask filterProductsByCategory(T $fragment, Categories category, On1SuccessListener<java.util.List<jcrystal.mobile.entities.ProductNormal>> onSuccess){
		return filterProductsByCategory(null, $fragment, category, onSuccess, $fragment).exec();
	}
	public static <T extends android.app.Activity & OnErrorListener> AsyncTask filterProductsByCategory(T $activity, Categories category, On1SuccessListener<java.util.List<jcrystal.mobile.entities.ProductNormal>> onSuccess){
		return filterProductsByCategory($activity, (androidx.fragment.app.Fragment)null, category, onSuccess, $activity).exec();
	}
	public static void filterProductsByCategory(NetChain $chain, Categories category, On1SuccessListener<java.util.List<jcrystal.mobile.entities.ProductNormal>> onSuccess){
		if($chain.fragment != null){
			$chain.add(filterProductsByCategory(null, $chain.fragment, category, onSuccess, $chain));
		}
		else{
			$chain.add(filterProductsByCategory($chain.activity, (androidx.fragment.app.Fragment)null, category, onSuccess, $chain));
		}
	}
	private static NetTask<org.json.JSONObject> filterProductsByCategory(android.app.Activity $activity, androidx.fragment.app.Fragment $fragment, Categories category, On1SuccessListener<java.util.List<jcrystal.mobile.entities.ProductNormal>> onSuccess, OnErrorListener onError){
		return new AbsDefaultManager.JSONObjectResp($activity, $fragment, onError){
			@Override protected String getUrl()throws java.io.UnsupportedEncodingException{
				String ruta = "/api/product/filterProductsByCategory";
				String params = null;
				if(category != null)
					params = (params==null?"?":(params + "&")) + "category=" + category.id;
				if(params != null)ruta+=params;
				return ruta;
			}
			@Override
			public void onResponse(org.json.JSONObject result)throws Exception{
				org.json.JSONArray $array = result.getJSONArray("r");
				java.util.List<jcrystal.mobile.entities.ProductNormal> $lista = new java.util.ArrayList<jcrystal.mobile.entities.ProductNormal>($array.length());
				for(int pos = 0, l = $array.length(); pos < l; pos++){
					$lista.add(new jcrystal.mobile.entities.Product($array.getJSONObject(pos), JsonLevel.NORMAL));
				}
				onSuccess.onSuccess($lista);
			}
		}.doGet();
	}
	/**
	* /api/product/getCategories
	**/
	public static AsyncTask getCategories(android.app.Activity $activity, On1SuccessListener<java.util.List<String>> onSuccess, OnErrorListener onError){
		return getCategories($activity, (androidx.fragment.app.Fragment)null, onSuccess, onError).exec();
	}
	public static AsyncTask getCategories(androidx.fragment.app.Fragment $fragment, On1SuccessListener<java.util.List<String>> onSuccess, OnErrorListener onError){
		return getCategories(null, $fragment, onSuccess, onError).exec();
	}
	public static <T extends androidx.fragment.app.Fragment & OnErrorListener> AsyncTask getCategories(T $fragment, On1SuccessListener<java.util.List<String>> onSuccess){
		return getCategories(null, $fragment, onSuccess, $fragment).exec();
	}
	public static <T extends android.app.Activity & OnErrorListener> AsyncTask getCategories(T $activity, On1SuccessListener<java.util.List<String>> onSuccess){
		return getCategories($activity, (androidx.fragment.app.Fragment)null, onSuccess, $activity).exec();
	}
	public static void getCategories(NetChain $chain, On1SuccessListener<java.util.List<String>> onSuccess){
		if($chain.fragment != null){
			$chain.add(getCategories(null, $chain.fragment, onSuccess, $chain));
		}
		else{
			$chain.add(getCategories($chain.activity, (androidx.fragment.app.Fragment)null, onSuccess, $chain));
		}
	}
	private static NetTask<org.json.JSONObject> getCategories(android.app.Activity $activity, androidx.fragment.app.Fragment $fragment, On1SuccessListener<java.util.List<String>> onSuccess, OnErrorListener onError){
		return new AbsDefaultManager.JSONObjectResp($activity, $fragment, onError){
			@Override protected String getUrl()throws java.io.UnsupportedEncodingException{
				String ruta = "/api/product/getCategories";
				return ruta;
			}
			@Override
			public void onResponse(org.json.JSONObject result)throws Exception{
				org.json.JSONArray $array = result.getJSONArray("r");
				java.util.List<String> $lista = new java.util.ArrayList<String>($array.length());
				for(int pos = 0, l = $array.length(); pos < l; pos++){
					$lista.add($array.optString(pos));
				}
				onSuccess.onSuccess($lista);
			}
		}.doGet();
	}
	/**
	* /api/product/getProductById
	**/
	public static AsyncTask getProductById(android.app.Activity $activity, long id, On1SuccessListener<jcrystal.mobile.entities.ProductNormal> onSuccess, OnErrorListener onError){
		return getProductById($activity, (androidx.fragment.app.Fragment)null, id, onSuccess, onError).exec();
	}
	public static AsyncTask getProductById(androidx.fragment.app.Fragment $fragment, long id, On1SuccessListener<jcrystal.mobile.entities.ProductNormal> onSuccess, OnErrorListener onError){
		return getProductById(null, $fragment, id, onSuccess, onError).exec();
	}
	public static <T extends androidx.fragment.app.Fragment & OnErrorListener> AsyncTask getProductById(T $fragment, long id, On1SuccessListener<jcrystal.mobile.entities.ProductNormal> onSuccess){
		return getProductById(null, $fragment, id, onSuccess, $fragment).exec();
	}
	public static <T extends android.app.Activity & OnErrorListener> AsyncTask getProductById(T $activity, long id, On1SuccessListener<jcrystal.mobile.entities.ProductNormal> onSuccess){
		return getProductById($activity, (androidx.fragment.app.Fragment)null, id, onSuccess, $activity).exec();
	}
	public static void getProductById(NetChain $chain, long id, On1SuccessListener<jcrystal.mobile.entities.ProductNormal> onSuccess){
		if($chain.fragment != null){
			$chain.add(getProductById(null, $chain.fragment, id, onSuccess, $chain));
		}
		else{
			$chain.add(getProductById($chain.activity, (androidx.fragment.app.Fragment)null, id, onSuccess, $chain));
		}
	}
	private static NetTask<org.json.JSONObject> getProductById(android.app.Activity $activity, androidx.fragment.app.Fragment $fragment, long id, On1SuccessListener<jcrystal.mobile.entities.ProductNormal> onSuccess, OnErrorListener onError){
		return new AbsDefaultManager.JSONObjectResp($activity, $fragment, onError){
			@Override protected String getUrl()throws java.io.UnsupportedEncodingException{
				String ruta = "/api/product/getProductById";
				String params = null;
				params = (params==null?"?":(params + "&")) + "id=" + Long.toString(id);
				if(params != null)ruta+=params;
				return ruta;
			}
			@Override
			public void onResponse(org.json.JSONObject result)throws Exception{
				onSuccess.onSuccess(result.isNull("r")?null:new jcrystal.mobile.entities.Product(result.getJSONObject("r"), JsonLevel.NORMAL));
			}
		}.doGet();
	}
	/**
	* /api/product/getProducts
	**/
	public static AsyncTask getProducts(android.app.Activity $activity, On1SuccessListener<java.util.List<jcrystal.mobile.entities.ProductNormal>> onSuccess, OnErrorListener onError){
		return getProducts($activity, (androidx.fragment.app.Fragment)null, onSuccess, onError).exec();
	}
	public static AsyncTask getProducts(androidx.fragment.app.Fragment $fragment, On1SuccessListener<java.util.List<jcrystal.mobile.entities.ProductNormal>> onSuccess, OnErrorListener onError){
		return getProducts(null, $fragment, onSuccess, onError).exec();
	}
	public static <T extends androidx.fragment.app.Fragment & OnErrorListener> AsyncTask getProducts(T $fragment, On1SuccessListener<java.util.List<jcrystal.mobile.entities.ProductNormal>> onSuccess){
		return getProducts(null, $fragment, onSuccess, $fragment).exec();
	}
	public static <T extends android.app.Activity & OnErrorListener> AsyncTask getProducts(T $activity, On1SuccessListener<java.util.List<jcrystal.mobile.entities.ProductNormal>> onSuccess){
		return getProducts($activity, (androidx.fragment.app.Fragment)null, onSuccess, $activity).exec();
	}
	public static void getProducts(NetChain $chain, On1SuccessListener<java.util.List<jcrystal.mobile.entities.ProductNormal>> onSuccess){
		if($chain.fragment != null){
			$chain.add(getProducts(null, $chain.fragment, onSuccess, $chain));
		}
		else{
			$chain.add(getProducts($chain.activity, (androidx.fragment.app.Fragment)null, onSuccess, $chain));
		}
	}
	private static NetTask<org.json.JSONObject> getProducts(android.app.Activity $activity, androidx.fragment.app.Fragment $fragment, On1SuccessListener<java.util.List<jcrystal.mobile.entities.ProductNormal>> onSuccess, OnErrorListener onError){
		return new AbsDefaultManager.JSONObjectResp($activity, $fragment, onError){
			@Override protected String getUrl()throws java.io.UnsupportedEncodingException{
				String ruta = "/api/product/getProducts";
				return ruta;
			}
			@Override
			public void onResponse(org.json.JSONObject result)throws Exception{
				org.json.JSONArray $array = result.getJSONArray("r");
				java.util.List<jcrystal.mobile.entities.ProductNormal> $lista = new java.util.ArrayList<jcrystal.mobile.entities.ProductNormal>($array.length());
				for(int pos = 0, l = $array.length(); pos < l; pos++){
					$lista.add(new jcrystal.mobile.entities.Product($array.getJSONObject(pos), JsonLevel.NORMAL));
				}
				onSuccess.onSuccess($lista);
			}
		}.doGet();
	}
}
