package com.coding.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coding.languages.models.Language;
import com.coding.languages.repositories.LanguageRepository;


@Service
public class LanguageService {
	private final LanguageRepository languageRepo;
	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo=languageRepo;
	}

	
	public List<Language> allLanguages() {
	     return languageRepo.findAll();
	 }
	
	
	public Language createLanguage(Language b) {
		 return languageRepo.save(b);
	 }
	
	public Language findLanguage(Long id) {
	     Optional<Language> optionalLanguage = languageRepo.findById(id);
	     if(optionalLanguage.isPresent()) {
	         return optionalLanguage.get();
	     } else {
	         return null;
	     }
	 	}
	
	
	public String findById(Long id) {
	     Optional<Language> optionalLanguage = languageRepo.findById(id);
	     if(optionalLanguage.isPresent()) {
	         languageRepo.deleteById(id);
	         return "Completed delete";
	         
	     } 
	     else {
	    	 return "No language with ID found";
	     }
	 	}
	
	public String deleteLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepo.findById(id);
	     if(optionalLanguage.isPresent()) {
	    	languageRepo.deleteById(id);
	         return "Completed delete";
	         
	     } 
	     else {
	    	 return "No language with ID found";
	     }
	 	}
	
	 public Language updateLanguage(Language language) {
	     Optional<Language> optionalLanguage = languageRepo.findById(language.getId());
	     if(optionalLanguage.isPresent()) {
	    	 Language newLanguage=optionalLanguage.get();
	    	 newLanguage.setName(language.getName());
	    	 newLanguage.setCreator(language.getCreator());
	    	 newLanguage.setVersion(language.getVersion());
	    	 
	    
	    	 
	    	
	         languageRepo.save(newLanguage);
	         return newLanguage;
	         
	     } 
	     else {
	    	 return null;
	     }
	 	}
	
	
	
	
}
