package posutfpr.banco.ativcinco;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import posutfpr.banco.ativcinco.entity.DepartamentEntity;
import posutfpr.banco.ativcinco.service.DepartamentService;


@SpringBootApplication
public class AtivcincoApplication {
	
	
	private static final org.jboss.logging.Logger log = LoggerFactory.logger(AtivcincoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AtivcincoApplication.class, args);
		
		System.out.println("The system it's ok");
		
		
		
	}
	
	@Bean
	public CommandLineRunner demo(DepartamentService departamentService) {
		return (args) -> {

			// salvando alguns departamentos
			//departamentService.saveDepartament(new DepartamentEntity("Java"));
			//departamentService.saveDepartament(new DepartamentEntity("Redes"));
			
			
			
			// retornando todos os contatos
			log.info("Departamentos encontrados com findAll():");
			log.info("-------------------------------");
			for (DepartamentEntity departamento : departamentService.findAllDepart()) {
				log.info(departamento.toString());
				System.out.println("Departament name: " + departamento.getName());
			}
			log.info("");
			
			// retornando um endereço pelo ID
			java.util.Optional<DepartamentEntity> departamento = departamentService.findDepartById(2L);
			log.info("Departamento encontrado com findById(2L):");
			log.info("--------------------------------");
			log.info(departamento.toString());
			log.info("");	
			
			
		};
	}
	
	/*
	@Bean
	public CommandLineRunner demoFunc(FuncService funcService) {
		return (args) -> {

			// salvando alguns departamentos
		//	funcService.saveFunc(new FuncEntity("Peter", 7, 4500l, "Dev", new DepartamentEntity("Java")));
		//	funcService.saveFunc(new FuncEntity("Mary", 2, 5500l, "Dev", new DepartamentEntity("Kotlin")));
			//funcService.saveFunc(new DepartamentEntity("Redes"));
			
			
			
			// retornando todos os contatos
			log.info("Departamentos encontrados com findAll():");
			log.info("-------------------------------");
			for (DepartamentEntity departamento : departamentService.buscarTodos()) {
				log.info(departamento.toString());
			}
			log.info("");
			
			// retornando um endereço pelo ID
			Optional<Departamento> departamento = departamentoService.buscaPorId(1L);
			log.info("Departamento encontrado com findById(1L):");
			log.info("--------------------------------");
			log.info(departamento.toString());
			log.info("");	
			
			
		};
	}
	
	*/

}
