/**
 * 
 */
package com.practice.coding;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
/**
 * @author Ganesh Shinde
 *
 */
public class DinnerPartyTest {
	DinnerParty dinnerParty;

	@Before
	public void init() {
		dinnerParty = new DinnerParty();
	}
	
	/**
	 * Test method for {@link com.practice.coding.DinnerParty#getPossibleSeatingArrangementAtDinnerParty(java.util.List, int)}.
	 */
	@Test
	public void testGetPossibleSeatingArrangementAtDinnerParty() {
		List<String> friends = new ArrayList<String>();
		friends.add("Fred");
		friends.add("Paresh");
		friends.add("Tom");
		friends.add("Greenie");
		friends.add("April");
		friends.add("Dick");
		friends.add("Harry");
		friends.add("Lucifer");
		List<List<String>> groups = dinnerParty.getPossibleSeatingArrangementAtDinnerParty(friends, 4);
		for(List<String> group : groups) {
			for(String name : group) {
				System.out.print(name + " ");
			}
			System.out.println("");
		}
		
	}
	
	@Test
	public void testGetPossibleSeatingArrangementAtDinnerPartySecond() {
		List<String> friends = new ArrayList<String>();
		friends.add("1");
		friends.add("2");
		friends.add("3");
		friends.add("4");
		List<List<String>> groups = dinnerParty.getPossibleSeatingArrangementAtDinnerParty(friends, 3);
		for(List<String> group : groups) {
			for(String name : group) {
				System.out.print(name + " ");
			}
			System.out.println("");
		}
		
	}

}
