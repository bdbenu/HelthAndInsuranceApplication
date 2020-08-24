package com.helth.insurance.domain;

import lombok.Data;

@Data
public class UnlockAccount {
	private String email;
	private String tempPazzword;
	private String newPazzword;
	private String confirmPazzword;
}
