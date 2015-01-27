package pawnshop.controller;

import java.util.List;

public interface ArticuloDao<T> {

	public List<T> obtenerArticulos();
	public void deleteArticulo(int row);
	
}
