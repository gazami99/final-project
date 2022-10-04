package kr.pe.cshop.model.service;

import java.util.List;

import kr.pe.cshop.model.domain.MemoryCard;

public interface MemoryCardService {

    List<MemoryCard> getBoardList(MemoryCard memorycard);

    MemoryCard getBoard(MemoryCard board);
}
