package kr.pe.cshop.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.pe.cshop.model.domain.MemoryCard;
import kr.pe.cshop.model.service.MemoryCardService;

@Controller
public class MemoryCardController {

	@Autowired
	private MemoryCardService mcService;
	
	//GET,POST,PUT,DELETE - service & dao(repository app. interface abstract...)


	@RequestMapping("/getMemoryList")
	public String getMemoryList(Model model, MemoryCard memory){
		if (memory.getSn() == null) {
			return "redirect:index.html";
		}

		List<MemoryCard> memoryList = mcService.getMemoryList(memory);
		model.addAttribute(memoryList);
		System.out.println("List");
		return "getMemoryList";
	}

	@PostMapping("/insertMemory")
	public String insertMemory(MemoryCard memory) {
		if (memory.getSn() == null) {
			return "redirect:index.html";
		}
		mcService.insertMemory(memory);
		return "redirect:getBoardList";
	}

	@GetMapping("/getMemory")
	public String getMemory(MemoryCard memory, Model model) {
		if (memory.getSn() == null) {
			return "redirect:index.html";
		}

		model.addAttribute("memory", mcService.getMemory(memory));
		return "getMemory";
	}

	@PostMapping("/updateMemory")
	public String updateMemory(MemoryCard memory) {
		if (memory.getSn() == null) {
			return "redirect:index.html";
		}

		mcService.updateMemory(memory);
		return "forward:getMemoryList";
	}

	@GetMapping("/deleteMemory")
	public String deleteMemory(MemoryCard memory) {
		if (memory.getSn() == null) {
			return "redirect:index.html";
		}

		mcService.deleteMemory(memory);
		return "forward:getMemoryList";
	}
}
