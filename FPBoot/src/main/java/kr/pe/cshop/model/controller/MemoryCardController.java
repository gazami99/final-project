package kr.pe.cshop.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.pe.cshop.model.service.MemoryCardService;

@Controller
public class MemoryCardController {

	@Autowired
	private MemoryCardService mcService;
	
	//GET,POST,PUT,DELETE - service & dao(repository app. interface abstract...)
}
