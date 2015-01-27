package pawnshop.controller;

import java.util.ArrayList;
import java.util.List;

import pawnshop.model.ArticuloBean;

public class Joyas implements ArticuloDao<ArticuloBean> {
	
	private final static Joyas JOYAS = new Joyas();

	List<ArticuloBean> articulos = new ArrayList<ArticuloBean>();
	
	ArticuloBean anillo = new ArticuloBean("Anillo","Thiffany & Co.", "AN-965","25645.36","recursos/", "Joyeria");
	ArticuloBean aretes = new ArticuloBean("Aretes","Cartier", "ES-955","5560","recursos/", "Joyeria");
	ArticuloBean cadena = new ArticuloBean("Cadena","Bizzarro", "SYB-96","8255.23","recursos/", "Joyeria");
	ArticuloBean collar = new ArticuloBean("Collar Kelwin","Swarovski Elements", "Co-Venz-Bl-Blanco","25645.36","recursos/", "Joyeria");
	
	
	private Joyas() {
		articulos.add(anillo);
		articulos.add(aretes);
		articulos.add(cadena);
		articulos.add(collar);
	}
	
	public static Joyas getIntance(){
		return JOYAS;
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
