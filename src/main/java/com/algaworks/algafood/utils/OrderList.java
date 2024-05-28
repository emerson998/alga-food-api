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
	 
//	 void ordenarPorDataDesc(List<CidadeModel> declaracoesReport) {
//		 if (!declaracoesReport.isEmpty()) {
//			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//			 Collections.sort(declaracoesReport, new Comparator<CidadeModel>() {
//				 @Override
//				 public int compare(CidadeModel declaracao1, CidadeModel declaracao2) {
//					 if (declaracao1.getData() != null && !declaracao1.getData().isBlank() &&
//							 declaracao2.getData() != null && !declaracao2.getData().isBlank()) {
//
//						 LocalDate data1 = LocalDate.parse(declaracao1.getData(), formatter);
//						 LocalDate data2 = LocalDate.parse(declaracao2.getData(), formatter);
//
//						 return data2.compareTo(data1);
//					 }
//
//					 return 0;
//				 }
//			 });
//
//
//		 }
//	 }
//
//
//	 void ordenarPorDataAsc(List<CidadeModel> declaracoesReport) {
//		 if (!declaracoesReport.isEmpty()) {
//			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//			 Collections.sort(declaracoesReport, new Comparator<CidadeModel>() {
//				 @Override
//				 public int compare(CidadeModel declaracao1, CidadeModel declaracao2) {
//					 if (declaracao1.getData() != null && !declaracao1.getData().isBlank() &&
//							 declaracao2.getData() != null && !declaracao2.getData().isBlank()) {
//
//						 LocalDate data1 = LocalDate.parse(declaracao1.getData(), formatter);
//						 LocalDate data2 = LocalDate.parse(declaracao2.getData(), formatter);
//
//						 return data1.compareTo(data2);
//					 }
//
//					 return 0;
//				 }
//			 });
//
//
//		 }
//	 }
	
}
