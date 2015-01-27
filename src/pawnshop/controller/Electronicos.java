package pawnshop.controller;

import java.util.ArrayList;
import java.util.List;

import pawnshop.model.ArticuloBean;


public class Electronicos implements ArticuloDao<ArticuloBean> {

	private final static Electronicos ELECTRONICOS = new Electronicos();
	
	List<ArticuloBean> articulos = new ArrayList<ArticuloBean>();
	ArticuloBean iphone = new ArticuloBean("Telefono","Apple Iphone", "5S","11524.36","recursos/","Electronicos");
	ArticuloBean tv = new ArticuloBean("Television","Samsung", "SmartTV","15166","recursos/", "Electronicos");
	ArticuloBean lap = new ArticuloBean("Laptop","Toshiba", "Satellite","8250.23","recursos/", "Electronicos");
	ArticuloBean pantalla = new ArticuloBean("Pantalla LED 55\" Ultra HD","LG", "55UB8200","18999.00","recursos/", "Electronicos");
	ArticuloBean bluray = new ArticuloBean("Blu-Ray   3D 4K UltraHD","Samsung", "BD-H6500","2199.00","recursos/", "Electronicos");
	ArticuloBean consola = new ArticuloBean("Consola PS4","Sony", "PS4","8899.50","recursos/", "Electronicos");
	ArticuloBean ipad = new ArticuloBean("iPad Air 2 16GB Dorado","Apple", "iPad Air 2","9099.23","recursos/", "Electronicos");
	
	private Electronicos() {
		articulos.add(iphone);
		articulos.add(tv);
		articulos.add(lap);
		articulos.add(pantalla);
		articulos.add(bluray);
		articulos.add(consola);
		articulos.add(ipad);
	}

	public static Electronicos getInstance(){
		return ELECTRONICOS;
	}
	
	@Override
	public List<ArticuloBean> obtenerArticulos() {
		return articulos;
	}
	
	public void deleteArticulo(int row){
		articulos.remove(row);
	}

}
