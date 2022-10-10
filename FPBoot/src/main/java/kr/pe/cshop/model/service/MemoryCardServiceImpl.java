package kr.pe.cshop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.pe.cshop.model.dao.MemoryCardRepository;
import kr.pe.cshop.model.domain.MemoryCard;

public class MemoryCardServiceImpl {
    @Autowired
    MemoryCardRepository mcRepo;

    public List<MemoryCard> getMemoryCardList(MemoryCard mc){
        return (List<MemoryCard>) mcRepo.findAll();
    }

    public MemoryCard getMemoryCardBySn(MemoryCard mc){
        return mcRepo.findById(mc.getSn()).get();
    }    

    public MemoryCard getMemoryCardByBrand(MemoryCard mc){
        return mcRepo.findById(mc.getBrand()).get();
    }
        
    public MemoryCard getMemoryCardByMcName(MemoryCard mc){
        return mcRepo.findById(mc.getMcName()).get();
    }
}
