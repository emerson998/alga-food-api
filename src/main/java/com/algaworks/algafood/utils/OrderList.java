package com.algaworks.algafood.utils;

import java.util.List;

import com.algaworks.algafood.api.model.CidadeModel;

public class OrderList {

	OrderList(){}
	
	 static void orderList(List<CidadeModel> cidades) {
		for (int i = 0; i < cidades.size() - 1; ++i) {
		    for (int j = i + 1; j < cidades.size(); ++j) {
		    	CidadeModel tmp = cidades.get(i);
		    	CidadeModel tmp2 = cidades.get(j);
		        if (tmp.getId().compareTo(tmp2.getId()) > 0) {
		        	CidadeModel temp = tmp;
		        	cidades.set(i, tmp2);
		        	cidades.set(j, temp);
		        }
		    }
		}
	}
	
	
}
