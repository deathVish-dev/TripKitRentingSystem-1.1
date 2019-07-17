package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.IProductDao;
import com.app.pojos.Login;
import com.app.pojos.Product;

@Controller //mandatory
@RequestMapping("/user") //optional BUT reco
public class UserController {

	@Autowired
	IProductDao dao;
	public UserController() {
		
		System.out.println("In User Controller");
	}
	
	
	@GetMapping("/userpage")
	public String loadHomePage(Model map)
	{
		List<Product> ls=dao.getAllProduct();
		map.addAttribute("productlist",ls);
		return "user/userpage";
	}
	
	@GetMapping("/product")
	public String loadProductPage(@RequestParam long id,Model map)
	{
		System.out.println(id);
		map.addAttribute("product",dao.getProduct(id));
		return "user/product";
	}
	
}
