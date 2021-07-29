package posutfpr.banco.ativcinco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import posutfpr.banco.ativcinco.entity.FuncEntity;
import posutfpr.banco.ativcinco.repository.FuncRepository;

@Service
public class FuncService {
	
	
	@Autowired
	private FuncRepository funcRepository;
	
	public FuncEntity saveFunc(FuncEntity funcEntity) {
		return funcRepository.save(funcEntity);
	   }
	
	  public Optional <FuncEntity> findFuncById(Long id) {
	      return funcRepository.findById(id);
	   }

	   public List<FuncEntity> findAllFunc() {
	      return funcRepository.findAll();
	   }
	
	   
	   public List<FuncEntity> findByName(String name) {

		   FuncEntity funct = new FuncEntity(); 
		      funct.setName(name);

		      ExampleMatcher matcher = ExampleMatcher
		         .matching()
		         .withIgnoreCase()
		         .withStringMatcher(ExampleMatcher.StringMatcher.ENDING);

		      Example<FuncEntity> example = Example.of(funct, matcher);

		      return funcRepository.findAll(example);
		   }
	   
	   
	   public List<FuncEntity> findByDependents(Integer depend){

		   FuncEntity funct = new FuncEntity();
		      funct.setDependents(depend);
		      Example<FuncEntity> example = Example.of(funct);

		      return funcRepository.findAll(example);
		   }  

}

