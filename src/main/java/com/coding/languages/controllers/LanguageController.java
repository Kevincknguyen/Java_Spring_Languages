package com.coding.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coding.languages.models.Language;
import com.coding.languages.services.LanguageService;

@Controller
public class LanguageController{
	
	
	@Autowired
	LanguageService languageService;
	
	
//	HOME
	 @GetMapping("/") 
	 public String language(Model model, @ModelAttribute("language") Language language){
	 
		 List<Language> languages=languageService.allLanguages();
		 model.addAttribute("languages", languages);
		return "Home.jsp" ;
	 }
	 
//	 CREATE
	 @PostMapping("/") 
	 public String newLanguage(
			 @Valid @ModelAttribute("language") Language language,
			 BindingResult result, Model model)  {
		 
		 if (result.hasErrors()) {
			 List<Language> languages=languageService.allLanguages();
			 model.addAttribute("languages", languages);
			 return "Home.jsp";
		 }
		 languageService.createLanguage(language);
	 
		return "redirect:/" ;
	 }
	 
	 //	 READ ONE AND SHOW PAGE
	 @GetMapping("/language/{id}") 
	 public String showLanguage(Model model,@PathVariable("id") Long id){
		 
		 
		Language language=languageService.findLanguage(id);
		 if (language !=null) {
			 
			 model.addAttribute("language", language);
			 return "ShowLanguage.jsp" ;
		 }
		 else {
			 return "redirect:/";
		 }
	 }
	 
	 
//	 DELETE
	 @DeleteMapping("/language/{id}")
	 public String delete(@PathVariable("id")Long id) {
		languageService.deleteLanguage(id);
		 return "redirect:/";
	 }
//	 READ ONE AND RENDER TO EDIT PAGE
	 @GetMapping("/language/edit/{id}") 
	 public String editLanguage(Model model,@PathVariable("id") Long id){
		 
		 
		 Language language=languageService.findLanguage(id);
		 if (language !=null) {
			 
			 model.addAttribute("language", language);
			 return "EditLanguage.jsp" ;
		 }
		 else {
			 return "redirect:/";
		 }
	 }
	 

	 
//	 EDIT
	 @RequestMapping(value="/language/edit/{id}", method=RequestMethod.PUT)
		public String editAction(@PathVariable ("id")Long id,
				@Valid @ModelAttribute("language") Language language, BindingResult result) {
			
		 if (result.hasErrors()) {
			 return "EditLanguage.jsp";
		 } else {
			 languageService.updateLanguage(language);
			 return "redirect:/";
		 }
			
			
		}
}