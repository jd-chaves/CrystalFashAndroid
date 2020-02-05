package jcrystal.mobile.net.controllers;
import jcrystal.mobile.net.utils.*;
import jcrystal.mobile.entities.*;
import jcrystal.mobile.entities.enums.*;
import jcrystal.mobile.*;
import jcrystal.datetime.*;
import jcrystal.mobile.net.*;
import android.os.AsyncTask;
import static jcrystal.JSONUtils.*;
public class ManagerCart{
	/**
	* /api/cart/addToCart
	**/
	public static AsyncTask addToCart(android.app.Activity $activity, Long idCart, Long idProduct, int quantity, On1SuccessListener<jcrystal.mobile.entities.CartNormal> onSuccess, OnErrorListener onError){
		return addToCart($activity, (androidx.fragment.app.Fragment)null, idCart, idProduct, quantity, onSuccess, onError).exec();
	}
	public static AsyncTask addToCart(androidx.fragment.app.Fragment $fragment, Long idCart, Long idProduct, int quantity, On1SuccessListener<jcrystal.mobile.entities.CartNormal> onSuccess, OnErrorListener onError){
		return addToCart(null, $fragment, idCart, idProduct, quantity, onSuccess, onError).exec();
	}
	public static <T extends androidx.fragment.app.Fragment & OnErrorListener> AsyncTask addToCart(T $fragment, Long idCart, Long idProduct, int quantity, On1SuccessListener<jcrystal.mobile.entities.CartNormal> onSuccess){
		return addToCart(null, $fragment, idCart, idProduct, quantity, onSuccess, $fragment).exec();
	}
	public static <T extends android.app.Activity & OnErrorListener> AsyncTask addToCart(T $activity, Long idCart, Long idProduct, int quantity, On1SuccessListener<jcrystal.mobile.entities.CartNormal> onSuccess){
		return addToCart($activity, (androidx.fragment.app.Fragment)null, idCart, idProduct, quantity, onSuccess, $activity).exec();
	}
	public static void addToCart(NetChain $chain, Long idCart, Long idProduct, int quantity, On1SuccessListener<jcrystal.mobile.entities.CartNormal> onSuccess){
		if($chain.fragment != null){
			$chain.add(addToCart(null, $chain.fragment, idCart, idProduct, quantity, onSuccess, $chain));
		}
		else{
			$chain.add(addToCart($chain.activity, (androidx.fragment.app.Fragment)null, idCart, idProduct, quantity, onSuccess, $chain));
		}
	}
	private static NetTask<org.json.JSONObject> addToCart(android.app.Activity $activity, androidx.fragment.app.Fragment $fragment, Long idCart, Long idProduct, int quantity, On1SuccessListener<jcrystal.mobile.entities.CartNormal> onSuccess, OnErrorListener onError){
		return new AbsDefaultManager.JSONObjectResp($activity, $fragment, onError){
			@Override protected String getUrl()throws java.io.UnsupportedEncodingException{
				String ruta = "/api/cart/addToCart";
				String params = null;
				if(idCart != null)
					params = (params==null?"?":(params + "&")) + "idCart=" + Long.toString(idCart);
				if(idProduct != null)
					params = (params==null?"?":(params + "&")) + "idProduct=" + Long.toString(idProduct);
				params = (params==null?"?":(params + "&")) + "quantity=" + Integer.toString(quantity);
				if(params != null)ruta+=params;
				return ruta;
			}
			@Override
			public void onResponse(org.json.JSONObject result)throws Exception{
				onSuccess.onSuccess(result.isNull("r")?null:new jcrystal.mobile.entities.Cart(result.getJSONObject("r"), JsonLevel.NORMAL));
			}
		}.doGet();
	}
	/**
	* /api/cart/addToFavorites
	**/
	public static AsyncTask addToFavorites(android.app.Activity $activity, long cartId, Long idP, OnVoidSuccessListener onSuccess, OnErrorListener onError){
		return addToFavorites($activity, (androidx.fragment.app.Fragment)null, cartId, idP, onSuccess, onError).exec();
	}
	public static AsyncTask addToFavorites(androidx.fragment.app.Fragment $fragment, long cartId, Long idP, OnVoidSuccessListener onSuccess, OnErrorListener onError){
		return addToFavorites(null, $fragment, cartId, idP, onSuccess, onError).exec();
	}
	public static <T extends androidx.fragment.app.Fragment & OnErrorListener> AsyncTask addToFavorites(T $fragment, long cartId, Long idP, OnVoidSuccessListener onSuccess){
		return addToFavorites(null, $fragment, cartId, idP, onSuccess, $fragment).exec();
	}
	public static <T extends android.app.Activity & OnErrorListener> AsyncTask addToFavorites(T $activity, long cartId, Long idP, OnVoidSuccessListener onSuccess){
		return addToFavorites($activity, (androidx.fragment.app.Fragment)null, cartId, idP, onSuccess, $activity).exec();
	}
	public static void addToFavorites(NetChain $chain, long cartId, Long idP, OnVoidSuccessListener onSuccess){
		if($chain.fragment != null){
			$chain.add(addToFavorites(null, $chain.fragment, cartId, idP, onSuccess, $chain));
		}
		else{
			$chain.add(addToFavorites($chain.activity, (androidx.fragment.app.Fragment)null, cartId, idP, onSuccess, $chain));
		}
	}
	private static NetTask<org.json.JSONObject> addToFavorites(android.app.Activity $activity, androidx.fragment.app.Fragment $fragment, long cartId, Long idP, OnVoidSuccessListener onSuccess, OnErrorListener onError){
		return new AbsDefaultManager.JSONObjectResp($activity, $fragment, onError){
			@Override protected String getUrl()throws java.io.UnsupportedEncodingException{
				String ruta = "/api/cart/addToFavorites";
				String params = null;
				params = (params==null?"?":(params + "&")) + "cartId=" + Long.toString(cartId);
				if(idP != null)
					params = (params==null?"?":(params + "&")) + "idP=" + Long.toString(idP);
				if(params != null)ruta+=params;
				return ruta;
			}
			@Override
			public void onResponse(org.json.JSONObject result)throws Exception{
				onSuccess.onSuccess();
			}
		}.doGet();
	}
	/**
	* /api/cart/createCart
	**/
	public static AsyncTask createCart(android.app.Activity $activity, On1SuccessListener<jcrystal.mobile.entities.CartNormal> onSuccess, OnErrorListener onError){
		return createCart($activity, (androidx.fragment.app.Fragment)null, onSuccess, onError).exec();
	}
	public static AsyncTask createCart(androidx.fragment.app.Fragment $fragment, On1SuccessListener<jcrystal.mobile.entities.CartNormal> onSuccess, OnErrorListener onError){
		return createCart(null, $fragment, onSuccess, onError).exec();
	}
	public static <T extends androidx.fragment.app.Fragment & OnErrorListener> AsyncTask createCart(T $fragment, On1SuccessListener<jcrystal.mobile.entities.CartNormal> onSuccess){
		return createCart(null, $fragment, onSuccess, $fragment).exec();
	}
	public static <T extends android.app.Activity & OnErrorListener> AsyncTask createCart(T $activity, On1SuccessListener<jcrystal.mobile.entities.CartNormal> onSuccess){
		return createCart($activity, (androidx.fragment.app.Fragment)null, onSuccess, $activity).exec();
	}
	public static void createCart(NetChain $chain, On1SuccessListener<jcrystal.mobile.entities.CartNormal> onSuccess){
		if($chain.fragment != null){
			$chain.add(createCart(null, $chain.fragment, onSuccess, $chain));
		}
		else{
			$chain.add(createCart($chain.activity, (androidx.fragment.app.Fragment)null, onSuccess, $chain));
		}
	}
	private static NetTask<org.json.JSONObject> createCart(android.app.Activity $activity, androidx.fragment.app.Fragment $fragment, On1SuccessListener<jcrystal.mobile.entities.CartNormal> onSuccess, OnErrorListener onError){
		return new AbsDefaultManager.JSONObjectResp($activity, $fragment, onError){
			@Override protected String getUrl()throws java.io.UnsupportedEncodingException{
				String ruta = "/api/cart/createCart";
				return ruta;
			}
			@Override
			public void onResponse(org.json.JSONObject result)throws Exception{
				onSuccess.onSuccess(result.isNull("r")?null:new jcrystal.mobile.entities.Cart(result.getJSONObject("r"), JsonLevel.NORMAL));
			}
		}.doGet();
	}
	/**
	* /api/cart/getCart
	**/
	public static AsyncTask getCart(android.app.Activity $activity, long id, On1SuccessListener<jcrystal.mobile.entities.CartNormal> onSuccess, OnErrorListener onError){
		return getCart($activity, (androidx.fragment.app.Fragment)null, id, onSuccess, onError).exec();
	}
	public static AsyncTask getCart(androidx.fragment.app.Fragment $fragment, long id, On1SuccessListener<jcrystal.mobile.entities.CartNormal> onSuccess, OnErrorListener onError){
		return getCart(null, $fragment, id, onSuccess, onError).exec();
	}
	public static <T extends androidx.fragment.app.Fragment & OnErrorListener> AsyncTask getCart(T $fragment, long id, On1SuccessListener<jcrystal.mobile.entities.CartNormal> onSuccess){
		return getCart(null, $fragment, id, onSuccess, $fragment).exec();
	}
	public static <T extends android.app.Activity & OnErrorListener> AsyncTask getCart(T $activity, long id, On1SuccessListener<jcrystal.mobile.entities.CartNormal> onSuccess){
		return getCart($activity, (androidx.fragment.app.Fragment)null, id, onSuccess, $activity).exec();
	}
	public static void getCart(NetChain $chain, long id, On1SuccessListener<jcrystal.mobile.entities.CartNormal> onSuccess){
		if($chain.fragment != null){
			$chain.add(getCart(null, $chain.fragment, id, onSuccess, $chain));
		}
		else{
			$chain.add(getCart($chain.activity, (androidx.fragment.app.Fragment)null, id, onSuccess, $chain));
		}
	}
	private static NetTask<org.json.JSONObject> getCart(android.app.Activity $activity, androidx.fragment.app.Fragment $fragment, long id, On1SuccessListener<jcrystal.mobile.entities.CartNormal> onSuccess, OnErrorListener onError){
		return new AbsDefaultManager.JSONObjectResp($activity, $fragment, onError){
			@Override protected String getUrl()throws java.io.UnsupportedEncodingException{
				String ruta = "/api/cart/getCart";
				String params = null;
				params = (params==null?"?":(params + "&")) + "id=" + Long.toString(id);
				if(params != null)ruta+=params;
				return ruta;
			}
			@Override
			public void onResponse(org.json.JSONObject result)throws Exception{
				onSuccess.onSuccess(result.isNull("r")?null:new jcrystal.mobile.entities.Cart(result.getJSONObject("r"), JsonLevel.NORMAL));
			}
		}.doGet();
	}
	/**
	* /api/cart/listFavorites
	**/
	public static AsyncTask listFavorites(android.app.Activity $activity, long cartId, On1SuccessListener<java.util.List<jcrystal.mobile.entities.ProductNormal>> onSuccess, OnErrorListener onError){
		return listFavorites($activity, (androidx.fragment.app.Fragment)null, cartId, onSuccess, onError).exec();
	}
	public static AsyncTask listFavorites(androidx.fragment.app.Fragment $fragment, long cartId, On1SuccessListener<java.util.List<jcrystal.mobile.entities.ProductNormal>> onSuccess, OnErrorListener onError){
		return listFavorites(null, $fragment, cartId, onSuccess, onError).exec();
	}
	public static <T extends androidx.fragment.app.Fragment & OnErrorListener> AsyncTask listFavorites(T $fragment, long cartId, On1SuccessListener<java.util.List<jcrystal.mobile.entities.ProductNormal>> onSuccess){
		return listFavorites(null, $fragment, cartId, onSuccess, $fragment).exec();
	}
	public static <T extends android.app.Activity & OnErrorListener> AsyncTask listFavorites(T $activity, long cartId, On1SuccessListener<java.util.List<jcrystal.mobile.entities.ProductNormal>> onSuccess){
		return listFavorites($activity, (androidx.fragment.app.Fragment)null, cartId, onSuccess, $activity).exec();
	}
	public static void listFavorites(NetChain $chain, long cartId, On1SuccessListener<java.util.List<jcrystal.mobile.entities.ProductNormal>> onSuccess){
		if($chain.fragment != null){
			$chain.add(listFavorites(null, $chain.fragment, cartId, onSuccess, $chain));
		}
		else{
			$chain.add(listFavorites($chain.activity, (androidx.fragment.app.Fragment)null, cartId, onSuccess, $chain));
		}
	}
	private static NetTask<org.json.JSONObject> listFavorites(android.app.Activity $activity, androidx.fragment.app.Fragment $fragment, long cartId, On1SuccessListener<java.util.List<jcrystal.mobile.entities.ProductNormal>> onSuccess, OnErrorListener onError){
		return new AbsDefaultManager.JSONObjectResp($activity, $fragment, onError){
			@Override protected String getUrl()throws java.io.UnsupportedEncodingException{
				String ruta = "/api/cart/listFavorites";
				String params = null;
				params = (params==null?"?":(params + "&")) + "cartId=" + Long.toString(cartId);
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
}
