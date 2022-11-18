package Kodlama.io.Devs.programmingLanguages.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.programmingLanguages.business.abstracts.LanguageService;
import Kodlama.io.Devs.programmingLanguages.business.requests.language.CreateLanguageRequest;
import Kodlama.io.Devs.programmingLanguages.business.requests.language.DeleteLanguageRequest;
import Kodlama.io.Devs.programmingLanguages.business.requests.language.UpdateLanguageRequest;
import Kodlama.io.Devs.programmingLanguages.business.responses.language.GetAllLanguagesResponse;
import Kodlama.io.Devs.programmingLanguages.business.responses.language.GetLanguagesByIdResponse;
import Kodlama.io.Devs.programmingLanguages.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.programmingLanguages.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		
		this.languageRepository = languageRepository;
		
	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {
		
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguagesResponse> languagesResponse = new ArrayList<GetAllLanguagesResponse>();
		
		for (Language language : languages) {
			GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
			responseItem.setLanguageId(language.getLanguageId());
			responseItem.setLanguageName(language.getLanguageName());
			languagesResponse.add(responseItem);			
		}
		
		return languagesResponse;
	
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
		
		Language language = new Language();
		language.setLanguageName(createLanguageRequest.getLanguageName());
		
		if (language.getLanguageName().isEmpty()) {		
			throw new Exception("Programming language name cannot be empty.");			
		}

		for (Language programmingLanguage : languageRepository.findAll()) {			
			if (programmingLanguage.getLanguageName().equals(language.getLanguageName())) {				
				throw new Exception("This programming language is already exists.");				
			}			
		}

		for (Language programmingLanguage : languageRepository.findAll()) {			
			if (programmingLanguage.getLanguageId() == language.getLanguageId()) {	
				throw new Exception("Enter a different id. This id is already exists.");
			}
		}
		
		this.languageRepository.save(language);
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {
		
		Language language = new Language();
		
		language.setLanguageId(updateLanguageRequest.getLanguageId());
		language.setLanguageName(updateLanguageRequest.getLanguageName());
		this.languageRepository.save(language);

	}
	
	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception {
		
		Language language = new Language();
		
		language.setLanguageId(deleteLanguageRequest.getLanguageId());
		this.languageRepository.delete(language);
		
	}

	@Override
	public GetLanguagesByIdResponse getById(int id) throws Exception {
		
		List<Language> languages = languageRepository.findAll();
		GetLanguagesByIdResponse getLanguagesByIdResponse = new GetLanguagesByIdResponse();
		
		for (Language language : languages) {		
			if (language.getLanguageId() == id) {
				getLanguagesByIdResponse.setName(language.getLanguageName());				
			}			
		}
		
		return getLanguagesByIdResponse;
		
	}

}
