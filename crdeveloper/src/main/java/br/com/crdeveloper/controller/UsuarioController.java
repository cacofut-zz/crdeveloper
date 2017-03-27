package br.com.crdeveloper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.crdeveloper.dao.UsuarioDAO;
import br.com.crdeveloper.model.Usuario;


@Controller
@RequestMapping(value="/admin/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@RequestMapping(value="/lista", method=RequestMethod.GET)
	public String listar(Model model){
		
		List<Usuario> listaUsuarios = usuarioDAO.listarTodos();
		
		model.addAttribute("usuarios", listaUsuarios);
		
		return "admin/usuario/lista";
	}
}
