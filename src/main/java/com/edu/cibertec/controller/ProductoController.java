package com.edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.cibertec.modelo.Producto;
import com.edu.cibertec.service.ProductoService;

@Controller
public class ProductoController {

	@Autowired
	private ProductoService service;
	
	@GetMapping("/productos")
	public String index(Model modelo) {
		modelo.addAttribute("productos",service.obtenerTodos());
		
		//indicamos el nombre de la vista
		return "productos";
	}
	
	@GetMapping("/nuevoProductoForm")
	public String nuevoProductoForm(Model model) {
		
		//creamos un producto vacio
		Producto x = new Producto();
		
		
		model.addAttribute("producto",x);
		
		return "nuevoProducto";
	}
	
	
	@PostMapping("/guardarProducto")
	public String guardar(@RequestBody Producto x) {
		
		service.guardar(x);
		
		return "redirect:/productos";
		
	}
	
	@GetMapping("/eliminarProducto")
	public String eliminar(@RequestParam("id")int id) {
		
		service.deleteProductoById(id);
		
		return "redirect:/";
		
	}
	
	
}
