package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.pojos.Cart;
import com.app.pojos.Login;

public class CartDao implements ICartDao {

	@Autowired
	SessionFactory sf;
	


	@Override
	public Cart saveInCart(Cart c) {
		Cart cart=null;
		String jpql="select i from Cart i where i.id=:id and i.custid.id=:uid";
		System.out.println("in get cart items");
		try{
			cart=sf.getCurrentSession().createQuery(jpql,Cart.class)
			.setParameter("id", c.getId()).setParameter("uid", c.getCustid().getId()).getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
		}
		if(cart==null)
		{
			sf.getCurrentSession().save(c);
		}
		else
		{
			System.out.println(cart);
			cart.setQuantity(cart.getQuantity()+c.getQuantity());
			sf.getCurrentSession().saveOrUpdate(cart);
		}
		return c;
	}



	@Override
	public List<Cart> getUserCart(long uid) {
		List<Cart> cartitems=new ArrayList<Cart>();
		String jpql="select i from Cart i where i.custid.id=:uid";
		System.out.println("in get cart items");
		try{
			cartitems=sf.getCurrentSession().createQuery(jpql,Cart.class).setParameter("uid", uid).getResultList();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return cartitems;
	}

}
