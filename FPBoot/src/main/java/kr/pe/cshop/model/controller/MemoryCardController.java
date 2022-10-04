package kr.pe.cshop.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.pe.cshop.model.domain.MemoryCard;
import kr.pe.cshop.model.service.MemoryCardService;

@Controller
public class MemoryCardController {

	@Autowired
	private MemoryCardService mcService;
	
	// @RequestMapping("/getMemoryCardList")
	// public String getMemoryCardList(){

	// }
	//GET,POST,PUT,DELETE - service & dao(repository app. interface abstract...)

	@GetMappingng("/getMemoryCard")
	public String getBoard(MemoryCard mc) {
		
		return "getBoard";
	}

}
