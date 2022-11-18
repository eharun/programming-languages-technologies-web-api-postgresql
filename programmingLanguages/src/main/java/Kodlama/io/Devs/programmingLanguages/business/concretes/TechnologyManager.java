package Kodlama.io.Devs.programmingLanguages.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.programmingLanguages.business.abstracts.TechnologyService;
import Kodlama.io.Devs.programmingLanguages.business.requests.technology.CreateTechnologyRequest;
import Kodlama.io.Devs.programmingLanguages.business.requests.technology.DeleteTechnologyRequest;
import Kodlama.io.Devs.programmingLanguages.business.requests.technology.UpdateTechnologyRequest;
import Kodlama.io.Devs.programmingLanguages.business.responses.technology.GetAllTechnologiesResponse;
import Kodlama.io.Devs.programmingLanguages.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.programmingLanguages.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.Devs.programmingLanguages.entities.concretes.Language;
import Kodlama.io.Devs.programmingLanguages.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {

	private LanguageRepository languageRepository;
	private TechnologyRepository technologyRepository;

	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository, LanguageRepository languageRepository) {

		this.technologyRepository = technologyRepository;
		this.languageRepository = languageRepository;

	}

	@Override
	public List<GetAllTechnologiesResponse> getAll() {

		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologiesResponse> getAllTechnologiesResponse = new ArrayList<>();

		for (Technology technology : technologies) {
			GetAllTechnologiesResponse responseItem = new GetAllTechnologiesResponse();
			responseItem.setLanguageId(technology.getLanguage().getLanguageId());
			responseItem.setLanguageName(technology.getLanguage().getLanguageName());
			responseItem.setTechnologyId(technology.getTechnologyId());
			responseItem.setTechnologyName(technology.getTechnologyName());
			getAllTechnologiesResponse.add(responseItem);
		}

		return getAllTechnologiesResponse;

	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {

		Technology technology = new Technology();
		Language language = new Language();

		technology.setTechnologyName(createTechnologyRequest.getTechnologyName());

		var languageId = languageRepository.findById(createTechnologyRequest.getLanguageId()).get();

		language.setLanguageId(languageId.getLanguageId());
		language.setLanguageName(languageId.getLanguageName());

		technology.setLanguage(language);

		this.technologyRepository.save(technology);

	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		
		Technology technology = technologyRepository.findById(updateTechnologyRequest.getTechnologyId()).get();
		Language language = languageRepository.findById(updateTechnologyRequest.getLanguageId()).get();

		technology.setTechnologyName(updateTechnologyRequest.getTechnologyName());
		technology.setLanguage(language);
		
		this.technologyRepository.save(technology);

	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTecnologyRequest) {

		Technology technology = new Technology();
		technology.setTechnologyId(deleteTecnologyRequest.getTechnologyId());

		this.technologyRepository.delete(technology);

	}

}
