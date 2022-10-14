package kr.pe.cshop.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.pe.cshop.model.domain.MemoryCard;

@Service
public interface MemoryCardService {

    List<MemoryCard> getMemoryCardList(MemoryCard memorycard);

    MemoryCard getBoard(MemoryCard board);
}
