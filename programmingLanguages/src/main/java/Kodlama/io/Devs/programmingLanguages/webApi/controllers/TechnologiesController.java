package Kodlama.io.Devs.programmingLanguages.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.programmingLanguages.business.abstracts.TechnologyService;
import Kodlama.io.Devs.programmingLanguages.business.requests.technology.CreateTechnologyRequest;
import Kodlama.io.Devs.programmingLanguages.business.requests.technology.DeleteTechnologyRequest;
import Kodlama.io.Devs.programmingLanguages.business.requests.technology.UpdateTechnologyRequest;
import Kodlama.io.Devs.programmingLanguages.business.responses.technology.GetAllTechnologiesResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {

	private TechnologyService technologyService;
	
	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}
	
	@GetMapping("/getall")
	public List<GetAllTechnologiesResponse> getAll() {
		return technologyService.getAll();
	}

	@PostMapping("/add")
	public void add(CreateTechnologyRequest technology) throws Exception {
		technologyService.add(technology);
	}
	
	@PutMapping("/update")
	public void update(UpdateTechnologyRequest technology) throws Exception {
		technologyService.update(technology);
	}

	@DeleteMapping("/deleteById")
	public void delete(DeleteTechnologyRequest id) throws Exception {
		technologyService.delete(id);
	}
	
}
