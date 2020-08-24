package com.helth.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.helth.insurance.domain.CaseWorkerMaster;
import com.helth.insurance.service.ICaseWorkerMaster;

@Controller
public class CaseWorkerOperationController {
	@Autowired
	private ICaseWorkerMaster caseService;
	@PostMapping("/registerWorker")
	public String registerCaseWorker(@ModelAttribute("caseworker")CaseWorkerMaster caseworkermaster,Model model) {
		boolean registerCaseWorker = caseService.registerCaseWorker(caseworkermaster);
		if(registerCaseWorker) {
			model.addAttribute("sucMsg", "REGISTER SUCESSED");
		}
		return"redirect:/sucRegister";
	}
	@GetMapping("/sucRegister")
	public String registerSucess() {
		return"rgisterSucess";
	}
	@GetMapping("/allWorker")
	public String viewsAllWorker(Model model) {
		List<CaseWorkerMaster> allCaseWorker = caseService.getAllCaseWorker();
		model.addAttribute("all", allCaseWorker);
		return"view-all-caseworker";
	}
	@RequestMapping(value = "/deletew")
	public String deleteWorker(@RequestParam("id")Integer id,Model model) {
		boolean deleteWorker = caseService.deleteWorker(id);
		List<CaseWorkerMaster> allCaseWorker = caseService.getAllCaseWorker();
		model.addAttribute("allCaseWorker", allCaseWorker);
		return"redirect:/allWorker";
	}
	@RequestMapping("/edit")
public String editCaseWorker(@RequestParam("id")Integer id,Model model) {
	CaseWorkerMaster caseworkermaster = caseService.getOneCaseWorker(id);
	model.addAttribute("caseworker", caseworkermaster);
	
	return "index";
}

}
