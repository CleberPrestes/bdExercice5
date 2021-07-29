package posutfpr.banco.ativcinco.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import posutfpr.banco.ativcinco.entity.DepartamentEntity;
import posutfpr.banco.ativcinco.repository.DepartamentRepository;

@Service
public class DepartamentService {
	
	
	@Autowired
	private DepartamentRepository departamentRepository;
	
	public DepartamentEntity saveDepartament(DepartamentEntity departament) {
		return departamentRepository.save(departament);
	   }
	
	  public Optional <DepartamentEntity> findDepartById(Long id) {
	      return departamentRepository.findById(id);
	   }

	   public List<DepartamentEntity> findAllDepart() {
	      return departamentRepository.findAll();
	   }
	
	   
	   public List<DepartamentEntity> findByName(String name) {

		   DepartamentEntity depart = new DepartamentEntity(); 
		      depart.setName(name);

		      ExampleMatcher matcher = ExampleMatcher
		         .matching()
		         .withIgnoreCase()
		         .withStringMatcher(ExampleMatcher.StringMatcher.ENDING);

		      Example<DepartamentEntity> example = Example.of(depart, matcher);

		      return departamentRepository.findAll(example);
		   }
	   
	   
	   		public List<DepartamentEntity>findAllByName(){
	   			
	   		
		      Sort sort = Sort.by(Sort.Direction.DESC,"name");
		      
		      return departamentRepository.findAll(sort);
		   }
	   
	   
	   
	   public Page<DepartamentEntity> paginResults() {
		   
		    Pageable pageable = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC,"name"));
				  		   
		   return departamentRepository.findAll(pageable);
		   }
	   

}

