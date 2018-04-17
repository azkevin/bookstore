/**  
* A model shopping cart that holds shopping cart entries  
* @author  Shagun Kazan
* @see CartBean
* 
*/ 


package model;

import java.util.ArrayList;
import bean.CartBean;

public class ShoppingCart 
{
	/**
	 * An ArrayList holding cart entries
	 */
	private ArrayList<CartBean> cart;
	
	/**
	 * The total for the shopping cart
	 */
	private float total;
	
	/**
	 * Create an empty shopping cart with 0 total cost
	 */
	public ShoppingCart()
	{
		cart = new ArrayList<CartBean>();
		total = 0;
	}
	
	/**
	 * Add an entry to the cart and updates price
	 * @param cb an entry being added to the cart
	 */
	public void add(CartBean cb) throws IllegalArgumentException
	{
		if (cb.getQuantity() <= 0)
		{
			throw new IllegalArgumentException("Quantity must be positive.");
		}
		if (cb.getPrice() < 0)
		{
			throw new IllegalArgumentException("Price must be non-negative.");
		}
		//if the book is in the cart, add to existing entry
		String bid = cb.getBid();
		for (CartBean ele : cart)
		{
			if (bid.equals(ele.getBid()))
			{
				ele.setQuantity(ele.getQuantity() + cb.getQuantity());
				total += cb.getPrice() * cb.getQuantity();
				return;
			}
		}
		
		//if it is not in the cart, add it
		cart.add(cb);
		total += cb.getPrice() * cb.getQuantity();
		
	}
	
	/**
	 * Increment a book purchase by 1
	 * @param bid the ID of the book being incremented
	 */
	public void increment(String bid)
	{

		//find the entry holding the book then add 1 to the quantity
		//and increase the total cost
		for (CartBean ele : cart)
		{
			if (bid.equals(ele.getBid()))
			{
				ele.setQuantity(ele.getQuantity() + 1);
				total += ele.getPrice();
				return;
			}
		}
	}
	
	
	/**
	 * Decrements a book purchase by 1
	 * @param bid the ID of the book being decremented
	 */
	public void decrement(String bid)
	{
		
		//find the entry holding the book then remove 1 from the quantity
		//and decrease the total cost
		for (CartBean ele : cart)
		{
			if (bid.equals(ele.getBid()))
			{
				total -= ele.getPrice();
				
				//if it's the last entry then remove it from the cart completely
				if (ele.getQuantity() == 1)
				{
					cart.remove(ele);
				}
				else
				{
					ele.setQuantity(ele.getQuantity() - 1);
				}
				return;
			}
		}
	}
	
	/**
	 * Removes all of a certain book from the cart
	 * @param bid the ID of the book being removed
	 */
	public void removeAll(String bid)
	{
		for (CartBean ele : cart)
		{
			if (bid.equals(ele.getBid()))
			{
				total -= ele.getQuantity() * ele.getPrice();
				cart.remove(ele);
				return;
			}
		}
	}
	
	/**
	 * Changes the quantity from the previous entry value to a new one
	 * @param cb the new entry for the cart
	 */
	public void changeQuantity(CartBean cb) throws IllegalArgumentException
	{
		if (cb.getQuantity() <= 0)
		{
			throw new IllegalArgumentException("Enter positive quantity.");
		}
		if (cb.getPrice() < 0)
		{
			throw new IllegalArgumentException("Enter non-negative price.");
		}
		this.removeAll(cb.getBid());
		this.add(cb);
	}
	
	/**
	* Class invariant 1: Shopping cart total reflects sum of entry totals
	* 
	* total = (float i, forAll e in cart i += e.getQuantity * e.getPrice)
	* 
	* Preserved by each method adjusting the total accordingly.
	* 
	* Class invariant 2: Non-negative total
	* 
	* Do not have any negative quantities or negative prices. Can only
	* decrement if non-zero quantity exists.
	*/
}

