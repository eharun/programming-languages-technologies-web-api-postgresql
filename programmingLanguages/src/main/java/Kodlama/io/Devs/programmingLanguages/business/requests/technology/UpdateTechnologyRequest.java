package Kodlama.io.Devs.programmingLanguages.business.requests.technology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTechnologyRequest {
	private int technologyId;
	private int languageId;
	private String technologyName;
}
