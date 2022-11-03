package com.edu.cibertec.service;

import java.util.List;

import com.edu.cibertec.modelo.Producto;


public interface ProductoService {

	//MATRICULAR LA CABECERA DE LOS METODOS QUE SE VAN A UTILIZAR
	
	List<Producto> obtenerTodos();
	
	void guardar(Producto x);
	
	Producto getProductoById(int id);
	
	void deleteProductoById(int id);
		
	
}
