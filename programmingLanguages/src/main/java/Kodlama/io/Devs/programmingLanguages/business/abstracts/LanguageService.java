package Kodlama.io.Devs.programmingLanguages.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.programmingLanguages.business.requests.language.CreateLanguageRequest;
import Kodlama.io.Devs.programmingLanguages.business.requests.language.DeleteLanguageRequest;
import Kodlama.io.Devs.programmingLanguages.business.requests.language.UpdateLanguageRequest;
import Kodlama.io.Devs.programmingLanguages.business.responses.language.GetAllLanguagesResponse;
import Kodlama.io.Devs.programmingLanguages.business.responses.language.GetLanguagesByIdResponse;

public interface LanguageService {

	List<GetAllLanguagesResponse> getAll();
	
	GetLanguagesByIdResponse getById(int id) throws Exception;
	
	void add(CreateLanguageRequest createLanguageRequest) throws Exception;
	void update(UpdateLanguageRequest updateLanguageRequest) throws Exception;
	void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception;

}
