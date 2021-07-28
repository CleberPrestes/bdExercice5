package posutfpr.banco.ativcinco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import posutfpr.banco.ativcinco.entity.FuncEntity;
import posutfpr.banco.ativcinco.service.FuncService;

@RestController
@RequestMapping("/func")
public class FuncController {
	
	@Autowired
	FuncService funcService;
	
	
	@PostMapping	
	public FuncEntity createFunc(@RequestBody FuncEntity funcEntity) {
		
		System.out.println("Entrou no metodo Post");
		
		return funcService.saveFunc(funcEntity);
		
				
				
	}
	
		@GetMapping
		public List<FuncEntity> getFuncList(){
		
		System.out.println("Todos os departamentos");
		return funcService.findAllFunc();
		
	}

}
