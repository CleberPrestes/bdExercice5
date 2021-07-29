package posutfpr.banco.ativcinco;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;

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

	DepartamentEntity depAdm = new DepartamentEntity("Administrativo");
	DepartamentEntity dpFinc = new DepartamentEntity("Financeiro");
	DepartamentEntity dpRH = new DepartamentEntity("Rec. Human");
	DepartamentEntity dpCom = new DepartamentEntity("Comercial");
	DepartamentEntity dpDir = new DepartamentEntity("Diretoria");

	@Bean
	public CommandLineRunner demo(DepartamentService departamentService) {
		return (args) -> {

			// salvando os departamentos

			departamentService.saveDepartament(depAdm);
			departamentService.saveDepartament(dpFinc);
			departamentService.saveDepartament(dpRH);
			departamentService.saveDepartament(dpCom);
			departamentService.saveDepartament(dpDir);

			/*
			 * 
			 * // retornando todos os departamentos
			 * 
			 * log.info("Departamentos encontrados com findAll():");
			 * log.info("-------------------------------"); for (DepartamentEntity
			 * departament : departamentService.findAllDepart()) {
			 * //log.info(departament.toString()); System.out.println("Departament name: " +
			 * departament.getName() + "Id: " + departament.getId());
			 * 
			 * } log.info("");
			 * 
			 * 
			 * 
			 * 
			 * 
			 * // retornando um endereço pelo ID Optional<DepartamentEntity> departament =
			 * departamentService.findDepartById(2l);
			 * log.info("Departamento encontrado com findById():");
			 * log.info("--------------------------------");
			 * log.info(departament.toString());
			 * 
			 * log.info("");
			 * 
			 * 
			 * 
			 * // retornando departamento pelo nome List<DepartamentEntity> departamento =
			 * departamentService.findByName("Administrativo");
			 * log.info("Departamento encontrado com pelo nome(Administrativo)");
			 * log.info("--------------------------------");
			 * log.info(departamento.toString());
			 * 
			 * log.info("");
			 * 
			 * 
			 * // retornando todos departamentos ordenandos pelo nome
			 * List<DepartamentEntity> departamento2 = departamentService.findAllByName();
			 * log.info("Departamentos em ordem alfabetica");
			 * log.info("--------------------------------");
			 * log.info(departamento2.toString());
			 * 
			 * log.info("");
			 * 
			 * // retornando resultados paginados em ordem alfabetica
			 * Page<DepartamentEntity> departamento3 = departamentService.paginResults();
			 * log.info("Departamentos paginados em ordem alfabetica");
			 * log.info("--------------------------------");
			 * log.info(departamento3.toString());
			 * 
			 * log.info("");
			 * 
			 * 
			 * // Delete departamento por id departamentService.delDepartament(1l);
			 * log.info("Delentando departamento com id 1");
			 * log.info("--------------------------------");
			 * 
			 * 
			 * 
			 * // Delete todos os departamentos departamentService.deleteAllDep();
			 * log.info("Delentando todos os departamentos");
			 * log.info("--------------------------------");
			 * 
			 */

		};
	}

	@Bean
	public CommandLineRunner demoFunc(FuncService funcService, DepartamentService departamentService) {
		return (args) -> {

			// populando os funcionarios
			funcService.saveFunc(new FuncEntity("João Silva", 4, 7500l, "Diretor", depAdm));
			funcService.saveFunc(new FuncEntity("Maria Santos", 2, 5500l, "Gerente", depAdm));
			funcService.saveFunc(new FuncEntity("Jorge Oliveira", 3, 6800l, "Coordenador", depAdm));
			funcService.saveFunc(new FuncEntity("Aline Ribas", 1, 4600l, "Supervisor", depAdm));

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

			/*
			 * 
			 * 
			 * // retornando todos os funcionarios
			 * log.info("Funcionarios encontrados com findAll():");
			 * log.info("-------------------------------"); for (FuncEntity func :
			 * funcService.findAllFunc()) { //log.info(func.toString());
			 * System.out.println("Nome funcionarios: "+func.getName()
			 * +"   Id   "+func.getId()+ "  depart:  " + func.getDepart().getName()); }
			 * 
			 * log.info("");
			 * 
			 * 
			 * // retornando todos os funcionarios com zero dependentes
			 * log.info("Funcionarios encontrados com findAll():");
			 * log.info("-------------------------------"); for (FuncEntity func :
			 * funcService.findByDependents(0)) { //log.info(func.toString());
			 * System.out.println("Nome funcionarios: "+func.getName()
			 * +"   Id   "+func.getId()+ "  depart:  " + func.getDepart().getName()); }
			 * 
			 * log.info("");
			 * 
			 * // Delete funcionarios por id
			 * 
			 * log.info("Departamentos paginados em ordem alfabetica");
			 * funcService.deleteFuncById(7l); log.info("--------------------------------");
			 * 
			 * 
			 * // Delete todos os funcionario
			 * 
			 * log.info("Departamentos todos os funcionarios"); funcService.deleteAllFunc();
			 * log.info("--------------------------------");
			 * 
			 */

		};

	}

}
