package pawnshop.controller;

import java.util.ArrayList;
import java.util.List;

import pawnshop.model.ArticuloBean;

public class Varios implements ArticuloDao<ArticuloBean> {
	
	private static final Varios VARIOS = new Varios();
	
	List<ArticuloBean> articulos = new ArrayList<ArticuloBean>();
	ArticuloBean lavadora = new ArticuloBean("Lavadora","LG", "3FD-58","6352.5","recursos/","Varios");
	ArticuloBean auto = new ArticuloBean("Automovil","Volkswagen", "Jetta '04","120542.00","recursos/", "Varios");
	ArticuloBean cuadro = new ArticuloBean("Cuadro","Picasso", "Three Musicians","32584.25","recursos/", "Varios");


	private Varios() {
		articulos.add(lavadora);
		articulos.add(auto);
		articulos.add(cuadro);
	}
	
	public static Varios getInstance(){
		return VARIOS;
	}
	
	
	@Override
	public List<ArticuloBean> obtenerArticulos() {
		return articulos;
	}
	
	@Override
	public void deleteArticulo(int row) {
		articulos.remove(row);
	}
	
	

}
