package jcrystal.mobile.entities;
import jcrystal.PrintWriterUtils;
import jcrystal.mobile.*;
import jcrystal.mobile.entities.enums.*;
import jcrystal.datetime.*;
import static jcrystal.JSONUtils.*;
public class SerializerProduct{
	public static void toJson(java.io.PrintStream _pw, Product objeto){
		_pw.print("{");
		if((!Double.isInfinite(objeto.price()) && !Double.isNaN(objeto.price()))){
			PrintWriterUtils.print(_pw, "\"price\":", objeto.price());
		}
		if((!Double.isInfinite(objeto.discount()) && !Double.isNaN(objeto.discount()))){
			PrintWriterUtils.print(_pw, ",\"discount\":", objeto.discount());
		}
		if((!Double.isInfinite(objeto.oldPrice()) && !Double.isNaN(objeto.oldPrice()))){
			PrintWriterUtils.print(_pw, ",\"oldPrice\":", objeto.oldPrice());
		}
		Long val3 = objeto.id();
		if(val3 != null){
			PrintWriterUtils.print(_pw, ",\"id\":", val3);
		}
		String val4 = objeto.name();
		if(val4 != null){
			PrintWriterUtils.print(_pw, ",\"name\":", jsonQuote(val4));
		}
		String val5 = objeto.description();
		if(val5 != null){
			PrintWriterUtils.print(_pw, ",\"description\":", jsonQuote(val5));
		}
		Categories val6 = objeto.category();
		if(val6 != null){
			PrintWriterUtils.print(_pw, ",\"category\":", val6.id);
		}
		Color val7 = objeto.color();
		if(val7 != null){
			PrintWriterUtils.print(_pw, ",\"color\":", val7.id);
		}
		Size val8 = objeto.size();
		if(val8 != null){
			PrintWriterUtils.print(_pw, ",\"size\":", val8.id);
		}
		String val9 = objeto.image();
		if(val9 != null){
			PrintWriterUtils.print(_pw, ",\"image\":", jsonQuote(val9));
		}
		_pw.print("}");
	}
	public static void toJsonProduct(java.io.PrintStream _pw, Iterable<Product> lista){
		PrintWriterUtils.toJson(_pw, lista, valor->toJson(_pw, valor));
	}
	public static void toJsonProduct(java.io.PrintStream _pw, java.util.Map<Long, Product> mapa){
		PrintWriterUtils.toJson(_pw, mapa, valor-> toJson(_pw, valor));
	}
	public static void toJsonNormal(java.io.PrintStream _pw, Product objeto){
		_pw.print("{");
		if((!Double.isInfinite(objeto.price()) && !Double.isNaN(objeto.price()))){
			PrintWriterUtils.print(_pw, "\"price\":", objeto.price());
		}
		if((!Double.isInfinite(objeto.discount()) && !Double.isNaN(objeto.discount()))){
			PrintWriterUtils.print(_pw, ",\"discount\":", objeto.discount());
		}
		if((!Double.isInfinite(objeto.oldPrice()) && !Double.isNaN(objeto.oldPrice()))){
			PrintWriterUtils.print(_pw, ",\"oldPrice\":", objeto.oldPrice());
		}
		Long val3 = objeto.id();
		if(val3 != null){
			PrintWriterUtils.print(_pw, ",\"id\":", val3);
		}
		String val4 = objeto.name();
		if(val4 != null){
			PrintWriterUtils.print(_pw, ",\"name\":", jsonQuote(val4));
		}
		String val5 = objeto.description();
		if(val5 != null){
			PrintWriterUtils.print(_pw, ",\"description\":", jsonQuote(val5));
		}
		Categories val6 = objeto.category();
		if(val6 != null){
			PrintWriterUtils.print(_pw, ",\"category\":", val6.id);
		}
		Color val7 = objeto.color();
		if(val7 != null){
			PrintWriterUtils.print(_pw, ",\"color\":", val7.id);
		}
		Size val8 = objeto.size();
		if(val8 != null){
			PrintWriterUtils.print(_pw, ",\"size\":", val8.id);
		}
		String val9 = objeto.image();
		if(val9 != null){
			PrintWriterUtils.print(_pw, ",\"image\":", jsonQuote(val9));
		}
		_pw.print("}");
	}
	public static void toJsonNormalProduct(java.io.PrintStream _pw, Iterable<Product> lista){
		PrintWriterUtils.toJson(_pw, lista, valor->toJsonNormal(_pw, valor));
	}
	public static void toJsonNormalProduct(java.io.PrintStream _pw, java.util.Map<Long, Product> mapa){
		PrintWriterUtils.toJson(_pw, mapa, valor-> toJsonNormal(_pw, valor));
	}
}
