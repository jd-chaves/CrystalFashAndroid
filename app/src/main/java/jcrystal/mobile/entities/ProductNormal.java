package jcrystal.mobile.entities;
import jcrystal.mobile.*;
import jcrystal.datetime.*;
public interface ProductNormal extends jcrystal.mobile.net.ISerializable{
	Long id();
	String name();
	String description();
	jcrystal.mobile.entities.enums.Categories category();
	double price();
	double discount();
	double oldPrice();
	jcrystal.mobile.entities.enums.Color color();
	jcrystal.mobile.entities.enums.Size size();
	String image();
}
