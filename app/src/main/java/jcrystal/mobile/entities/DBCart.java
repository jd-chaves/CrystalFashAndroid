package jcrystal.mobile.entities;
import jcrystal.mobile.entities.enums.*;
import jcrystal.mobile.*;
import jcrystal.mobile.net.DBUtils;
public class DBCart{
	public static boolean store(String key, Cart value){
		return store(null, key, value);
	}
	public static boolean store(String key, java.util.List<Cart> values){
		return store(null, key, values);
	}
	public static Cart retrieve(String key){
		return retrieve(null, key);
	}
	public static boolean store(String partKey, String key, Cart value){
		return DBUtils.store(partKey, key, value);
	}
	public static boolean store(String partKey, String key, java.util.List<Cart> values){
		return DBUtils.store(partKey, key, values);
	}
	public static boolean store(String partKey, String key, CartNormal value){
		return store(partKey, key, (Cart)value);
	}
	public static boolean storeNormal(String partKey, String key, java.util.List<CartNormal> values){
		return DBUtils.store(partKey, key, values);
	}
	public static boolean appendToList(String partKey, String key, Cart value){
		return DBUtils.appendToList(partKey, key, value);
	}
	public static Cart retrieve(String partKey, String key){
		return DBUtils.retrieve(partKey, key, Cart::new);
	}
	public static <T> java.util.List<T> retrieveList(String key){return retrieveList(null, key);}
	public static <T> java.util.List<T> retrieveList(String partKey, String key){
		return DBUtils.retrieveList(partKey, key, Cart::new);
	}
	public static void delete(String partKey, String key){
		DBUtils.delete(partKey, key);
	}
	public static void deleteList(String partKey, String key){
		DBUtils.deleteList(partKey, key);
	}
	public static void delete(String key){
		DBUtils.delete(key);
	}
}
