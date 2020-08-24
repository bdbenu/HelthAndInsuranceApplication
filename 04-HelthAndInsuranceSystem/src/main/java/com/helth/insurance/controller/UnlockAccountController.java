package com.helth.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.helth.insurance.domain.CaseWorkerMaster;
import com.helth.insurance.domain.UnlockAccount;
import com.helth.insurance.service.ICaseWorkerMaster;

@Controller
public class UnlockAccountController {
	@Autowired
	private ICaseWorkerMaster caseService;
	@GetMapping("/unlockacc")
	public String displayUnlockAcc(@RequestParam("email") String email, Model model) {
		UnlockAccount unlockacc = new UnlockAccount();

		model.addAttribute("unlockacc", unlockacc);
		 model.addAttribute("email", email);

		return "Unlock-Account";
	}
	@PostMapping("/unlockaccount")
	public String UnlockAccount(@ModelAttribute("caseworker")CaseWorkerMaster caseworkermaster,Model model) {
	
		CaseWorkerMaster useaccStatus = caseService.isTempPasswordValid(caseworkermaster.getTempPazzword());
		
		if(useaccStatus!=null) {
			useaccStatus.setAccountStatus("unlock");
			useaccStatus.setNewPazzword(caseworkermaster.getNewPazzword());
			boolean isUpdate = caseService.registerCaseWorker(useaccStatus); 
			if(isUpdate) {
				model.addAttribute("sucMsg", "sucess");
			}
			return"unlockAccountSucess";
		}else {
			model.addAttribute("errMsg", "Plz Enter correct Password");
			
			return "Unlock-Account";
		}
		
	}

}
