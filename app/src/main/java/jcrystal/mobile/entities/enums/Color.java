package jcrystal.mobile.entities.enums;
public enum Color{
	RED(1000),
	BLUE(2000),
	YELLOW(3000),
	;
	public final long id;
	Color(long id){
		this.id = id;
	}
	public String rawName(){
		switch(this){
			case RED : return "RED";
			case BLUE : return "BLUE";
			case YELLOW : return "YELLOW";
		}
		return null;
	}
	public static Color fromId(long id){
		if(id ==1000){return RED;}
		if(id ==2000){return BLUE;}
		if(id ==3000){return YELLOW;}
		return null;
	}
	public static <T> T[] mapped(Class<T> clase, jcrystal.mobile.net.utils.Function<Color, T> mapper){
		@SuppressWarnings("unchecked")
		Color[] vals = values();
		final T[] a = (T[]) java.lang.reflect.Array.newInstance(clase, vals.length);
		for(int e = 0; e < a.length; e++){
			a[e] = mapper.eval(vals[e]);
		}
		return a;
	}
	public static <T> T[] mapped(Class<T> clase, jcrystal.mobile.net.utils.Predicate<Color> p, jcrystal.mobile.net.utils.Function<Color, T> mapper){
		@SuppressWarnings("unchecked")
		Color[] vals = values();
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
