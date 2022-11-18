package Kodlama.io.Devs.programmingLanguages.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.programmingLanguages.business.abstracts.LanguageService;
import Kodlama.io.Devs.programmingLanguages.business.requests.language.CreateLanguageRequest;
import Kodlama.io.Devs.programmingLanguages.business.requests.language.DeleteLanguageRequest;
import Kodlama.io.Devs.programmingLanguages.business.requests.language.UpdateLanguageRequest;
import Kodlama.io.Devs.programmingLanguages.business.responses.language.GetAllLanguagesResponse;
import Kodlama.io.Devs.programmingLanguages.business.responses.language.GetLanguagesByIdResponse;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {

	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("/getall")
	public List<GetAllLanguagesResponse> getAll() {
		return languageService.getAll();
	}

	@PostMapping("/add")
	public void add(CreateLanguageRequest language) throws Exception {
		languageService.add(language);
	}
	
	@PutMapping("/update")
	public void update(UpdateLanguageRequest language) throws Exception {
		languageService.update(language);
	}

	@DeleteMapping("/deleteById")
	public void delete(DeleteLanguageRequest id) throws Exception {
		languageService.delete(id);
	}

	@GetMapping("/getById")
	public GetLanguagesByIdResponse getById(int id) throws Exception {
		return languageService.getById(id);
	}

}
