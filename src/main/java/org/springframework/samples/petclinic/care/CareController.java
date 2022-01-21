package org.springframework.samples.petclinic.care;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class CareController {
    
	private CareService careService;
	
	@Autowired
	public CareController(CareService careService) {
		this.careService = careService;
	}
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	@ModelAttribute("compatible_pet_types")
	public List<CareProvision> careProvision() {
		return this.careService.getAllCaresProvided();
	}
	@GetMapping(value = "/care/create")
	public String processCreationForm(Map<String, Object> model) {
		Care care = new Care();
		model.put("care", care);
		return "care/createOrUpdateRecoveryRoomForm";
	}
	@PostMapping(value = "/care/create")
	public String processCreationForm(@Valid Care care, BindingResult result, ModelMap model) throws NonCompatibleCaresException, UnfeasibleCareException {
		if (result.hasErrors()) {
			return "El cuidado seleccionado no se puede realizar durante esta visita";
		}
		else 
			this.careService.save(care);
		
		return "/";
	}
}
