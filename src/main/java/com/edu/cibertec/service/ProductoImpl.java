package com.edu.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.cibertec.modelo.Producto;
import com.edu.cibertec.repository.ProductoRepository;

@Service
public class ProductoImpl implements ProductoService{

	@Autowired
	private ProductoRepository repository;
	
	
	@Override
	public List<Producto> obtenerTodos() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}


	@Override
	public void guardar(Producto x) {

		repository.save(x);
		
	}


	@Override
	public Producto getProductoById(int id) {
		// TODO Auto-generated method stub
		
		Optional<Producto> optional = repository.findById(id);
		
		Producto x = null;
		
		if (optional.isPresent()) {
			x = optional.get();
		}
		
		return x;
	}


	@Override
	public void deleteProductoById(int id) {
		repository.deleteById(id);
		
	}

	

}
