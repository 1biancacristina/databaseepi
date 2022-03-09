package com.databasepi.databasepi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.databasepi.databasepi.repository.ClienteRepository;
import com.databasepi.databasepi.models.Cliente;

// Cadastrar Cliente - Avaliação
@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository cr;
	
	@RequestMapping(value = "/cliente", method = RequestMethod.GET)
	public String abrirCliente() { 
		return "cliente/cliente"; 
	}
	
	@RequestMapping(value = "/cliente", method = RequestMethod.POST)
	public String gravarCliente(Cliente cliente) { cr.save(cliente);
	return "redirect:/cliente";
	
	}
	
	
//Listar Cliente
	@RequestMapping("/clientes")
	public ModelAndView listaClientes() {
		ModelAndView mv = new ModelAndView("cliente/listaCliente");
		Iterable<Cliente> clientes = cr.findAll();
		mv.addObject("clientes", clientes);
		return mv;
	}
	

//Deletar Cliente
	@RequestMapping("/deletarCliente")
	public String deletarCliente(long cpf) {
		Cliente cliente = cr.findByCpf(cpf);
		cr.delete(cliente);
		return "redirect:/clientes";
}

//Atualizar Cliente
	
	@RequestMapping(value = "editarCliente", method = RequestMethod.GET)
	public ModelAndView editarCliente(long cpf) {
		Cliente cliente = cr.findByCpf(cpf);
		ModelAndView mv = new ModelAndView("cliente/updateCliente");
		mv.addObject("cliente", cliente);
		return mv;
	}

	@RequestMapping(value = "editarCliente", method = RequestMethod.POST)
	public String updateVaga(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes) {
		cr.save(cliente);
		attributes.addFlashAttribute("sucess", "Avaliação alterada com sucesso");

		long cpfLong = cliente.getCpf();
		return "redirect:/clientes";
	}
}

