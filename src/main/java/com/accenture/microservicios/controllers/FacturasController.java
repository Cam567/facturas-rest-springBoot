package com.accenture.microservicios.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.microservicios.modals.Factura;

@RestController
@RequestMapping("/facturas")
public class FacturasController {

	// post - crear factura
	@PostMapping()
	public String crearFactura(@RequestBody Factura factura) {
		// recuperar los datos de la factura 
		String concepto = factura.getConcepto();
		String cif = factura.getCif();
		double importe =  factura.getImporte();
		
		//Insertar la factura en base de datos
		return concepto +": " +importe + " / " + cif;
	}

	// get - listar facturas
	@GetMapping("/{facturaId}")
	public Factura recuperarFactura(@PathVariable double facturaId) {
		
		System.out.println(facturaId);
		
		Factura f = new Factura();
		f.setConcepto("Servicio de formación");
		f.setCif("dk3DKS");
		f.setImporte(facturaId);
		
		return f;
	}

	// update
	public String actualizarFactura() {
		return "Super ok!! actualizar";
	}

	// delete
	@DeleteMapping("/{facturaId}")
	public String borrarFactura(@PathVariable String facturaId) {
		
		System.out.println(facturaId);
		
		return "La factura se ha borrado";
	}

}
