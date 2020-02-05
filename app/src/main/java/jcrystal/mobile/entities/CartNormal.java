package jcrystal.mobile.entities;
import jcrystal.mobile.*;
import jcrystal.datetime.*;
public interface CartNormal extends jcrystal.mobile.net.ISerializable{
	Long id();
	java.util.List<Long> items();
	double subtotal();
	double total();
	java.util.List<Long> favorites();
}
