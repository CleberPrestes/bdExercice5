package posutfpr.banco.ativcinco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import posutfpr.banco.ativcinco.entity.DepartamentEntity;
import posutfpr.banco.ativcinco.service.DepartamentService;

@RestController
@RequestMapping("/dep")
public class DepartamentController {

	@Autowired
	DepartamentService departamentService;

	@PostMapping
	public DepartamentEntity createDepartament(@RequestBody DepartamentEntity departament) {

		System.out.println("Entrou no metodo Post");

		return departamentService.saveDepartament(departament);

	}

	@GetMapping

	public List<DepartamentEntity> getUsuarioList() {

		System.out.println("Todos os departamentos");
		return departamentService.findAllDepart();

	}

}
