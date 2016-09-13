package br.com.pedrohos.ex14;

/**
 * Created by yfain11 on 4/9/16.
 */
public class Beer {

    public String name;
    public String country;
    public float price;

    Beer(final String name, final String country, final float price){
        this.name=name;
        this.country=country;
        this.price=price;
    }

    @Override
	public String toString(){
        return  "Name: " + name + "," +
                " country: " + country +
                " price: " + price;
}
	
}
