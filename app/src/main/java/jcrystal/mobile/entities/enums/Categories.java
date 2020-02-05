package jcrystal.mobile.entities.enums;
public enum Categories{
	MEN(1000),
	WOMEN(2000),
	KIDS(3000),
	;
	public final long id;
	Categories(long id){
		this.id = id;
	}
	public String getName(){
		switch(this){
			case MEN : return "Men";
			case WOMEN : return "Women";
			case KIDS : return "Kids";
		}
		return null;
	}
	public String rawName(){
		switch(this){
			case MEN : return "MEN";
			case WOMEN : return "WOMEN";
			case KIDS : return "KIDS";
		}
		return null;
	}
	public static Categories fromId(long id){
		if(id ==1000){return MEN;}
		if(id ==2000){return WOMEN;}
		if(id ==3000){return KIDS;}
		return null;
	}
	public static <T> T[] mapped(Class<T> clase, jcrystal.mobile.net.utils.Function<Categories, T> mapper){
		@SuppressWarnings("unchecked")
		Categories[] vals = values();
		final T[] a = (T[]) java.lang.reflect.Array.newInstance(clase, vals.length);
		for(int e = 0; e < a.length; e++){
			a[e] = mapper.eval(vals[e]);
		}
		return a;
	}
	public static <T> T[] mapped(Class<T> clase, jcrystal.mobile.net.utils.Predicate<Categories> p, jcrystal.mobile.net.utils.Function<Categories, T> mapper){
		@SuppressWarnings("unchecked")
		Categories[] vals = values();
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
