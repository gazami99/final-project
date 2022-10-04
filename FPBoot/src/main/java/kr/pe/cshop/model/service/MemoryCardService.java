package kr.pe.cshop.model.service;

import java.util.List;

import kr.pe.cshop.model.domain.MemoryCard;

public interface MemoryCardService {

	List<MemoryCard> getMemoryList(MemoryCard memory);
	
	void insertMemory(MemoryCard memory);
	
	MemoryCard getMemory(MemoryCard memory);
	
	void updateMemory(MemoryCard memory);
	
	void deleteMemory(MemoryCard memory);
}
