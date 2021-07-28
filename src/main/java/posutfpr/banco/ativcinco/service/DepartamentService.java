package posutfpr.banco.ativcinco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	

}

