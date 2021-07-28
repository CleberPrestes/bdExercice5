package posutfpr.banco.ativcinco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	

}

