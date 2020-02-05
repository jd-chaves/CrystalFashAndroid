package jcrystal.mobile.entities;
import jcrystal.PrintWriterUtils;
import jcrystal.mobile.*;
import jcrystal.mobile.entities.enums.*;
import jcrystal.datetime.*;
import static jcrystal.JSONUtils.*;
public class SerializerCart{
	public static void toJson(java.io.PrintStream _pw, Cart objeto){
		_pw.print("{");
		if((!Double.isInfinite(objeto.subtotal()) && !Double.isNaN(objeto.subtotal()))){
			PrintWriterUtils.print(_pw, "\"subtotal\":", objeto.subtotal());
		}
		if((!Double.isInfinite(objeto.total()) && !Double.isNaN(objeto.total()))){
			PrintWriterUtils.print(_pw, ",\"total\":", objeto.total());
		}
		Long val2 = objeto.id();
		if(val2 != null){
			PrintWriterUtils.print(_pw, ",\"id\":", val2);
		}
		java.util.List<Long> val3 = objeto.items();
		if(val3 != null){
			_pw.print(",\"items\":");
			jsonQuoteLong(_pw, val3);
		}
		java.util.List<Long> val4 = objeto.favorites();
		if(val4 != null){
			_pw.print(",\"favorites\":");
			jsonQuoteLong(_pw, val4);
		}
		_pw.print("}");
	}
	public static void toJsonCart(java.io.PrintStream _pw, Iterable<Cart> lista){
		PrintWriterUtils.toJson(_pw, lista, valor->toJson(_pw, valor));
	}
	public static void toJsonCart(java.io.PrintStream _pw, java.util.Map<Long, Cart> mapa){
		PrintWriterUtils.toJson(_pw, mapa, valor-> toJson(_pw, valor));
	}
	public static void toJsonNormal(java.io.PrintStream _pw, Cart objeto){
		_pw.print("{");
		if((!Double.isInfinite(objeto.subtotal()) && !Double.isNaN(objeto.subtotal()))){
			PrintWriterUtils.print(_pw, "\"subtotal\":", objeto.subtotal());
		}
		if((!Double.isInfinite(objeto.total()) && !Double.isNaN(objeto.total()))){
			PrintWriterUtils.print(_pw, ",\"total\":", objeto.total());
		}
		Long val2 = objeto.id();
		if(val2 != null){
			PrintWriterUtils.print(_pw, ",\"id\":", val2);
		}
		java.util.List<Long> val3 = objeto.items();
		if(val3 != null){
			_pw.print(",\"items\":");
			jsonQuoteLong(_pw, val3);
		}
		java.util.List<Long> val4 = objeto.favorites();
		if(val4 != null){
			_pw.print(",\"favorites\":");
			jsonQuoteLong(_pw, val4);
		}
		_pw.print("}");
	}
	public static void toJsonNormalCart(java.io.PrintStream _pw, Iterable<Cart> lista){
		PrintWriterUtils.toJson(_pw, lista, valor->toJsonNormal(_pw, valor));
	}
	public static void toJsonNormalCart(java.io.PrintStream _pw, java.util.Map<Long, Cart> mapa){
		PrintWriterUtils.toJson(_pw, mapa, valor-> toJsonNormal(_pw, valor));
	}
}
