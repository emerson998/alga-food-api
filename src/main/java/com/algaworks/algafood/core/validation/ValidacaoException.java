package com.algaworks.algafood.core.validation;

import org.springframework.validation.BindingResult;

public class ValidacaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private BindingResult bindingResult;

	public ValidacaoException(BindingResult bindingResult) {
		super();
		this.bindingResult = bindingResult;
	}

	public BindingResult getBindingResult() {
		return bindingResult;
	}

	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}

}
