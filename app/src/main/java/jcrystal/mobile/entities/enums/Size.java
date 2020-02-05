package jcrystal.mobile.entities.enums;
public enum Size{
	XS(1000),
	S(2000),
	M(3000),
	L(4000),
	XL(5000),
	;
	public final long id;
	Size(long id){
		this.id = id;
	}
	public String rawName(){
		switch(this){
			case XS : return "XS";
			case S : return "S";
			case M : return "M";
			case L : return "L";
			case XL : return "XL";
		}
		return null;
	}
	public static Size fromId(long id){
		if(id ==1000){return XS;}
		if(id ==2000){return S;}
		if(id ==3000){return M;}
		if(id ==4000){return L;}
		if(id ==5000){return XL;}
		return null;
	}
	public static <T> T[] mapped(Class<T> clase, jcrystal.mobile.net.utils.Function<Size, T> mapper){
		@SuppressWarnings("unchecked")
		Size[] vals = values();
		final T[] a = (T[]) java.lang.reflect.Array.newInstance(clase, vals.length);
		for(int e = 0; e < a.length; e++){
			a[e] = mapper.eval(vals[e]);
		}
		return a;
	}
	public static <T> T[] mapped(Class<T> clase, jcrystal.mobile.net.utils.Predicate<Size> p, jcrystal.mobile.net.utils.Function<Size, T> mapper){
		@SuppressWarnings("unchecked")
		Size[] vals = values();
		int size = 0;
		for(int e = 0; e < vals.length; e++){
			if(p.eval(vals[e]))size++;
		}
		final T[] a = (T[]) java.lang.reflect.Array.newInstance(clase, size);
		for(int e = 0, i = 0; e < vals.length; e++){
			if(p.eval(vals[e])){
				a[i++] = mapper.eval(vals[e]);
			}
		}
		return a;
	}
}
