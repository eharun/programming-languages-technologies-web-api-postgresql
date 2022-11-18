package Kodlama.io.Devs.programmingLanguages.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.programmingLanguages.business.requests.technology.CreateTechnologyRequest;
import Kodlama.io.Devs.programmingLanguages.business.requests.technology.DeleteTechnologyRequest;
import Kodlama.io.Devs.programmingLanguages.business.requests.technology.UpdateTechnologyRequest;
import Kodlama.io.Devs.programmingLanguages.business.responses.technology.GetAllTechnologiesResponse;

public interface TechnologyService {
	
	List<GetAllTechnologiesResponse> getAll();
	
	void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
	void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception;
	void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception;
	
}
