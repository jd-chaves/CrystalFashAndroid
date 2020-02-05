package jcrystal.mobile.entities;
import jcrystal.mobile.*;
import jcrystal.mobile.entities.enums.*;
import jcrystal.datetime.*;
import static jcrystal.JSONUtils.*;
public class Cart implements CartNormal,jcrystal.mobile.net.ISerializable{
	private Long id;
	public Long id(){return this.id;}
	public void id(Long val){id = val;}
	private java.util.List<Long> items;
	public java.util.List<Long> items(){return this.items;}
	public void items(java.util.List<Long> val){items = val;}
	private double subtotal;
	public double subtotal(){return this.subtotal;}
	public void subtotal(double val){subtotal = val;}
	private double total;
	public double total(){return this.total;}
	public void total(double val){total = val;}
	private java.util.List<Long> favorites;
	public java.util.List<Long> favorites(){return this.favorites;}
	public void favorites(java.util.List<Long> val){favorites = val;}
	public Cart(){
	}
	protected Cart(org.json.JSONObject json)throws org.json.JSONException{
		this.id = json.has("id")&&!json.isNull("id")?json.getLong("id"):null;
		{
			org.json.JSONArray $Arrayitems = json.optJSONArray("items");
			if($Arrayitems != null){
				this.items = new java.util.ArrayList<>();
				for(int i = 0; i < $Arrayitems.length(); i++){
					this.items.add($Arrayitems.getLong(i));
				}
			}
		}
		this.subtotal = json.optDouble("subtotal");
		this.total = json.optDouble("total");
		{
			org.json.JSONArray $Arrayfavorites = json.optJSONArray("favorites");
			if($Arrayfavorites != null){
				this.favorites = new java.util.ArrayList<>();
				for(int i = 0; i < $Arrayfavorites.length(); i++){
					this.favorites.add($Arrayfavorites.getLong(i));
				}
			}
		}
	}
	public Cart(org.json.JSONObject json, JsonLevel level)throws org.json.JSONException{
		if(level != null){
			switch(level){
				case NORMAL: {
					this.id = json.has("id")&&!json.isNull("id")?json.getLong("id"):null;
					{
						org.json.JSONArray $Arrayitems = json.optJSONArray("items");
						if($Arrayitems != null){
							this.items = new java.util.ArrayList<>();
							for(int i = 0; i < $Arrayitems.length(); i++){
								this.items.add($Arrayitems.getLong(i));
							}
						}
					}
					this.subtotal = json.optDouble("subtotal");
					this.total = json.optDouble("total");
					{
						org.json.JSONArray $Arrayfavorites = json.optJSONArray("favorites");
						if($Arrayfavorites != null){
							this.favorites = new java.util.ArrayList<>();
							for(int i = 0; i < $Arrayfavorites.length(); i++){
								this.favorites.add($Arrayfavorites.getLong(i));
							}
						}
					}
				}
				break;
			}
		}
		else{
			this.id = json.has("id")&&!json.isNull("id")?json.getLong("id"):null;
			{
				org.json.JSONArray $Arrayitems = json.optJSONArray("items");
				if($Arrayitems != null){
					this.items = new java.util.ArrayList<>();
					for(int i = 0; i < $Arrayitems.length(); i++){
						this.items.add($Arrayitems.getLong(i));
					}
				}
			}
			this.subtotal = json.optDouble("subtotal");
			this.total = json.optDouble("total");
			{
				org.json.JSONArray $Arrayfavorites = json.optJSONArray("favorites");
				if($Arrayfavorites != null){
					this.favorites = new java.util.ArrayList<>();
					for(int i = 0; i < $Arrayfavorites.length(); i++){
						this.favorites.add($Arrayfavorites.getLong(i));
					}
				}
			}
		}
	}
	@Override public void toJson(java.io.PrintStream _pw){
		SerializerCart.toJson(_pw, this);
	}
	public static class ListUtils{
		public static java.util.ArrayList<Cart> listFromJson(org.json.JSONArray json)throws org.json.JSONException{
			java.util.ArrayList<Cart> ret = new java.util.ArrayList<Cart>(json.length());
			for(int e = 0, i = json.length(); e < i; e++){
				ret.add(new Cart(json.getJSONObject(e)));
			}
			return ret;
		}
		public static java.util.ArrayList<CartNormal> listFromJsonNormal(org.json.JSONArray json)throws org.json.JSONException{
			java.util.ArrayList<CartNormal> ret = new java.util.ArrayList<CartNormal>(json.length());
			for(int e = 0, i = json.length(); e < i; e++){
				ret.add(new Cart(json.getJSONObject(e), JsonLevel.NORMAL));
			}
			return ret;
		}
	}
	public static class MapList{
	}
	public static class Group{
	}
}
