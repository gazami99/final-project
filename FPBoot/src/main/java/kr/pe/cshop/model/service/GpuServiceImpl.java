package kr.pe.cshop.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.cshop.model.dao.GpuRepository;
import kr.pe.cshop.model.domain.GpuDTO;
import kr.pe.cshop.model.entity.GPU;

@Service
public class GpuServiceImpl implements GpuService {
    
    @Autowired
    GpuRepository gpuRepository;

    public ArrayList<GpuDTO> getGpuAll() throws Exception{
        ArrayList<GpuDTO> all = (ArrayList<GpuDTO>) gpuRepository.findAll();
		ArrayList<GpuDTO> allDTO = new ArrayList<GpuDTO>();

        for(GPU i : all) {
            allDTO.add(GpuDTO.builder().sn(i.getSn()).brand(i.getBrand()).model(i.getModel()).price(i.getPrice()))
        }
    }


}
