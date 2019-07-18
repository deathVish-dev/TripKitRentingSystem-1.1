package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.app.dao.ICartDao;
import com.app.dao.IProductDao;
import com.app.pojos.Cart;
import com.app.pojos.Customer;
import com.app.pojos.Login;
import com.app.pojos.Product;

@Controller //mandatory
@RequestMapping("/user") //optional BUT reco
public class UserController {

	@Autowired
	IProductDao productdao;
	@Autowired
	ICartDao cartdao;
	
	
	public UserController() {
		
		System.out.println("In User Controller");
	}
	
	
	@GetMapping("/userpage")
	public String loadHomePage(Model map)
	{
		
		List<Product> ls=productdao.getAllProduct();
		map.addAttribute("productlist",ls);
		return "user/userpage";
	}
	
	@GetMapping("/product")
	public String loadProductPage(@RequestParam long id,Model map)
	{
		System.out.println(id);
		map.addAttribute("product",productdao.getProduct(id));
		return "user/product";
	}
	
	@PostMapping("/product")
	public String storeInCart(@RequestParam int count,@RequestParam long pid,HttpSession hs)
	{
		System.out.println(pid);
		Customer c=(Customer)hs.getAttribute("loginuser");
		Cart cart=new Cart(pid, count, c);
		cartdao.saveInCart(cart);
		//map.addAttribute("product",productdao.getProduct(id));
		return "user/cart";
	}
	
	@GetMapping("/cart")
	public String loadCartPage(HttpSession hs,Model map)
	{
		System.out.println("In Cart Load");
		Customer c=(Customer)hs.getAttribute("loginuser");
		List<Cart> cartitems=cartdao.getUserCart(c.getId());
		map.addAttribute("cartitems", cartitems);
		List<Double> rents=new ArrayList<Double>();
		for (Cart cart : cartitems) {
			
		}
		
		return "user/usercart";
	}

}
