package com.helth.insurance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.helth.insurance.domain.CaseWorkerMaster;

@Controller
public class CaseWorkerController {
	@GetMapping(value = { "/", "/loadPage" })
	public String loadPage(Model model) {
		CaseWorkerMaster caseworker = new CaseWorkerMaster();
		model.addAttribute("caseworker", caseworker);
		return "index";
	}
}
