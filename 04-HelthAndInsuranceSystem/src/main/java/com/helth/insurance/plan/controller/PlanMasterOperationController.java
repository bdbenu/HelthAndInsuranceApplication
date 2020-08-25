package com.helth.insurance.plan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.helth.insurance.plan.domain.PlanMaster;
import com.helth.insurance.plan.service.IPlanMasterService;

@Controller
public class PlanMasterOperationController {
	@Autowired
	private IPlanMasterService plnService;

	@PostMapping("/planregister")
	public String planRegister(@ModelAttribute("planmaster") PlanMaster planmaster, RedirectAttributes attributes) {
		boolean registerPlan = plnService.registerPlan(planmaster);
		if (registerPlan) {
			attributes.addFlashAttribute("sucMsg", "Plan Regsiter Sucessfully");
		} else {
			attributes.addFlashAttribute("failMsg", "Plan Regsiter Failed");
		}
		return "redirect:/PlansucessRegister";
	}

	@GetMapping("/PlansucessRegister")
	public String planSucRegister(Model model) {
		model.addAttribute("planmaster", new PlanMaster());
		return "planregister";
	}
	@GetMapping("/getAllPlan")
	public String viewAllPlan(Model model) {
		List<PlanMaster> allPlan = plnService.getAllPlan();
		model.addAttribute("allPlan", allPlan);
		return "aplan-list-details";
	}
	@GetMapping("/deletePlan")
	public String deletePlan(@RequestParam("pid")Integer pid,Model model) {
		boolean deletePlane = plnService.deletePlane(pid);
		if(deletePlane) {
			//model.addAttribute("sucMsg", "deleted");
			return "redirect:/getAllPlan";
		}
		return "aplan-list-details";
	}
	@GetMapping("/editPlan")
	public String editPlan(@RequestParam("pid")Integer pid,Model model) {
		PlanMaster planmaster = plnService.getOnePlan(pid);
		model.addAttribute("planmaster", planmaster);
		return "planregister";
	}
}
