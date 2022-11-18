package Kodlama.io.Devs.programmingLanguages.business.requests.language;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLanguageRequest {
	private int languageId;
	private String languageName;
}
