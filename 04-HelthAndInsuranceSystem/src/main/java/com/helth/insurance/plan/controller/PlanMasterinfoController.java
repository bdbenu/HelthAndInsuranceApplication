package com.helth.insurance.plan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.helth.insurance.plan.domain.PlanMaster;

@Controller
public class PlanMasterinfoController {
	@GetMapping("/plan")
	public String loadPlanPage(Model model) {
		PlanMaster planmaster = new PlanMaster();
		model.addAttribute("planmaster", planmaster);
		return"planregister";
	}
	

}
