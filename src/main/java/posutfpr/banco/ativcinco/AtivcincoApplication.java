package posutfpr.banco.ativcinco;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import posutfpr.banco.ativcinco.entity.DepartamentEntity;
import posutfpr.banco.ativcinco.entity.FuncEntity;
import posutfpr.banco.ativcinco.service.DepartamentService;
import posutfpr.banco.ativcinco.service.FuncService;


@SpringBootApplication
public class AtivcincoApplication {
	
	
	private static final org.jboss.logging.Logger log = LoggerFactory.logger(AtivcincoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AtivcincoApplication.class, args);
		
		System.out.println("The system it's ok");
		

		
		
	}
	
		DepartamentEntity depAdm =new DepartamentEntity("Administrativo");
		DepartamentEntity dpFinc = new DepartamentEntity("Financeiro");
		DepartamentEntity dpRH = new DepartamentEntity("Rec. Human");
		DepartamentEntity dpCom = new DepartamentEntity("Comercial");
		DepartamentEntity dpDir = new DepartamentEntity("Diretoria");
	
	@Bean
	public CommandLineRunner demo(DepartamentService departamentService) {
		return (args) -> {

			// salvando alguns departamentos
			departamentService.saveDepartament(depAdm);
			departamentService.saveDepartament(dpFinc);
			departamentService.saveDepartament(dpRH);
			departamentService.saveDepartament(dpCom);
			departamentService.saveDepartament(dpDir);
			
			
			
			/*
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
			*/
			
		};
	}
	
	
	@Bean
	public CommandLineRunner demoFunc(FuncService funcService, DepartamentService departamentService) {
		return (args) -> {

			
					
			 
			funcService.saveFunc(new FuncEntity("João Silva", 4, 7500l, "Diretor",depAdm ));
			funcService.saveFunc(new FuncEntity("Maria Santos", 2, 5500l, "Gerente",depAdm));
			funcService.saveFunc(new FuncEntity("Jorge Oliveira", 3, 6800l, "Coordenador",depAdm));
			funcService.saveFunc(new FuncEntity("Aline Ribas", 1, 4600l, "Supervisor",depAdm));
		
			
			funcService.saveFunc(new FuncEntity("Jhon Wick", 0, 3500l, "Contador", dpFinc));
			funcService.saveFunc(new FuncEntity("Jean Claude", 6, 4500l, "Estatistico", dpFinc));
			funcService.saveFunc(new FuncEntity("Lara Croft", 2, 3500l, "Gerente", dpFinc));
			
			
			
			funcService.saveFunc(new FuncEntity("Miguel Monet", 3, 6500l, "Supervisor", dpRH));
			funcService.saveFunc(new FuncEntity("Edgar Degas", 1, 2500l, "Recrutador", dpRH));
			
			
			funcService.saveFunc(new FuncEntity("João Debret", 4, 1500l, "Telemarketing", dpCom));
			funcService.saveFunc(new FuncEntity("Margot Robbie", 3, 3500l, "Vendedor", dpCom));
			funcService.saveFunc(new FuncEntity("Ellen Page", 2, 3500l, "Auxiliar de vendas", dpCom));
			
			
			funcService.saveFunc(new FuncEntity("Peter Parker", 0, 30000L, "COO", dpDir));
			funcService.saveFunc(new FuncEntity("Steve Rogers", 0, 37000l, "CEO", dpDir));
			funcService.saveFunc(new FuncEntity("Klark Kent", 0, 35000l, "CFO", dpDir));

			
			//funcService.saveFunc(new DepartamentEntity("Redes"));
			
			
			/*
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
			
			*/
		};
		
		
	}
	


}
