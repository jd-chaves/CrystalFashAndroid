package jcrystal.mobile.entities;
import jcrystal.mobile.entities.enums.*;
import jcrystal.mobile.*;
import jcrystal.mobile.net.DBUtils;
public class DBProduct{
	public static boolean store(String key, Product value){
		return store(null, key, value);
	}
	public static boolean store(String key, java.util.List<Product> values){
		return store(null, key, values);
	}
	public static Product retrieve(String key){
		return retrieve(null, key);
	}
	public static boolean store(String partKey, String key, Product value){
		return DBUtils.store(partKey, key, value);
	}
	public static boolean store(String partKey, String key, java.util.List<Product> values){
		return DBUtils.store(partKey, key, values);
	}
	public static boolean store(String partKey, String key, ProductNormal value){
		return store(partKey, key, (Product)value);
	}
	public static boolean storeNormal(String partKey, String key, java.util.List<ProductNormal> values){
		return DBUtils.store(partKey, key, values);
	}
	public static boolean appendToList(String partKey, String key, Product value){
		return DBUtils.appendToList(partKey, key, value);
	}
	public static Product retrieve(String partKey, String key){
		return DBUtils.retrieve(partKey, key, Product::new);
	}
	public static <T> java.util.List<T> retrieveList(String key){return retrieveList(null, key);}
	public static <T> java.util.List<T> retrieveList(String partKey, String key){
		return DBUtils.retrieveList(partKey, key, Product::new);
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
