package com.example.demo.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.Model.ReconciliationServiceModel;
import com.example.demo.Model.RuleServiceCondition;
import com.example.demo.Reposistory.ReconciliationServiceReposistory;
import com.example.demo.Reposistory.RuleServiceConditionReposistory;

@Controller
public class MainController {

	@Autowired
	RuleServiceConditionReposistory ruleServiceConditionReposistory;

	@Autowired
	ReconciliationServiceReposistory reconciliationServiceReposistory;

	@GetMapping(value = "/")
	public String data(ReconciliationServiceModel reconciliationServiceModel) {

		return "index";
	}

	@GetMapping(value = "/addData")
	public String adddata(ReconciliationServiceModel reconciliationServiceModel) {

		return "addData";
	}

	@PostMapping("/addReconciliationService")
	public String addService(@Validated ReconciliationServiceModel reconciliationServiceModel, BindingResult result,
			Model model) {
		try {
			if (result.hasErrors()) {
				return "addData";
			}
			reconciliationServiceReposistory.save(reconciliationServiceModel);
			return "redirect:/index";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@PostMapping("/addReconciliationcondition")
	public String addUCondition(@Validated RuleServiceCondition ruleServiceCondition, BindingResult result,
			Model model) {
		try {
			if (result.hasErrors()) {
				return "addcondition";
			}
			ArrayList<RuleServiceCondition> list = new ArrayList<RuleServiceCondition>();
			list.add(ruleServiceCondition);
			ruleServiceConditionReposistory.saveAll(list);
	        ReconciliationServiceModel st1=new ReconciliationServiceModel();  
	        st1.setService_issued(list);
	        reconciliationServiceReposistory.saveAndFlush(st1);

			return "redirect:/index";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@GetMapping("/index")
	public String showUserList(Model model) {
		model.addAttribute("reconciliationServiceModels", reconciliationServiceReposistory.findAll());
		return "index";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long s_id, Model model) {
		System.out.println("inside in Getmapping");
		ReconciliationServiceModel reconciliationServiceModel = reconciliationServiceReposistory.findBysid(s_id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Service Id:" + s_id));

		model.addAttribute("reconciliationServiceModel", reconciliationServiceModel);
		return "/update";
	}

	@PutMapping("/update/{id}")
	public String updateService(@PathVariable("id") long s_id,
			@Validated ReconciliationServiceModel reconciliationServiceModel, BindingResult result, Model model) {
		if (result.hasErrors()) {
			reconciliationServiceModel.setS_id(s_id);
			return "update";
		}

		reconciliationServiceReposistory.save(reconciliationServiceModel);
		return "redirect:/index";
	}

	@GetMapping("/delete/{id}")
	public String deleteService(@PathVariable("id") long s_id, Model model) {
		ReconciliationServiceModel reconciliationServiceModel = reconciliationServiceReposistory.findBysid(s_id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + s_id));
		reconciliationServiceReposistory.delete(reconciliationServiceModel);
		return "redirect:/index";
	}

}
