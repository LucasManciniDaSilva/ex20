package services;

import java.util.List;
import java.util.function.Predicate;

import entities.Products;

public class ProductService {

	public double sum(List<Products> list, Predicate<Products> predicate){
		double sum = 0;
		for(Products p : list){
			if(predicate.test(p)){
				sum += p.getValue();
			}
		}
		return sum;
	}

}
