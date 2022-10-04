package kr.pe.cshop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.cshop.model.dao.MemoryCardRepository;
import kr.pe.cshop.model.domain.MemoryCard;

@Service
public class MemoryCardServiceImpl implements MemoryCardService{

	@Autowired
	private MemoryCardRepository memoryRepo;
	
	public List<MemoryCard> getMemoryList(MemoryCard memorycard){
		return (List<MemoryCard>) memoryRepo.findAll();
	}

	public void insertMemory(MemoryCard memory) {
		System.out.println(memory);
		memoryRepo.save(memory);
	}

	public MemoryCard getMemory(MemoryCard memory) {
		return memoryRepo.findById(memory.getSn()).get();
	}
	
	public void updateMemory(MemoryCard memory) {
		MemoryCard findMemory = memoryRepo.findById(memory.getSn()).get();
		
		findMemory.setBrand(memory.getBrand());
		findMemory.setMcName(memory.getMcName());
		findMemory.setPrice128GB(memory.getPrice128GB());
		findMemory.setPrice256GB(memory.getPrice256GB());
		findMemory.setPrice512GB(memory.getPrice512GB());
		findMemory.setPrice64GB(memory.getPrice64GB());
		memoryRepo.save(findMemory);
	}
	
	public void deleteMemory(MemoryCard memory) {
		memoryRepo.deleteById(memory.getSn());
	}
	
	
	
}
