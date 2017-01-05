package com.practice.coding;

import java.util.ArrayList;
import java.util.List;

/*
 ref - https://jg.gg/the-unqualified-engineer-episode-02/
 Given a table for N people figure out every possible seating 
 of the table for all of your friends					
 formula = n!/(r! * (n -r))
 
 															     													start		
														Leave						   								1,2,3,4						   							 Take
														---------------------------------------------------------------|-----------------------------------------------------------------
														|																																|
														_																																1
						--------------------------------|--------------------------------																--------------------------------|--------------------------------
						|																|																|																|
						_,_																_,2																1,_																1,2
		----------------|----------------								----------------|----------------								----------------|----------------								----------------|----------------
		|								|								|								|								|								|								|								|
		_,_,_							_,_,3							_,2,_							_,2,3							1,_,_						1,_,3								1,2,_							1,2,3 *
	--------|--------			--------|--------				--------|--------				-------|--------				--------|--------				--------|--------				--------|--------				--------|--------
	|				|			|				|				|				|				|				|				|				|				|				|				|				|				|				|
	_,_,_,_		_,_,_,4			_,_,3,_		_,_,3,4				_,2,_,_			_,2,_,4			_,2,3,_		_,2,3,4*			1,_,_,_			1,_,_,4			1,_,3,_		1,_,3,4	*			1,2,_,_			1,2,_,4 *		1,2,3,_	X		1,2,3,4 X	

 123 (1,2,3 *)
 124 (1,2,_,4 *)
 134 (1,_,3,4*)	
 234 (_,2,3,4*)
 
 no of friends (n) = 4
 Table size (r) = 3
 24/(6 * (1)) = 4
 
 */

/**
 * @author Ganesh Shinde
 *
 */
public class DinnerParty {

	public List<List<String>> getPossibleSeatingArrangementAtDinnerParty(List<String> friends, int tableSize) {
		List<List<String>> groups = new ArrayList<List<String>>();
		combineFriends(friends, tableSize, groups, null, 0);
		return groups;

	}

	private void combineFriends(final List<String> friends, final int tableSize, final List<List<String>> groups,
			List<String> group, int index) {
		if (group != null && group.size() == tableSize) {
			groups.add(group);
		} else if (index < friends.size()) {
			// Leave
			combineFriends(friends, tableSize, groups, group, index + 1);
			// take
			if (group == null) {
				group = new ArrayList<String>();
			} else {
				group = new ArrayList<>(group);
			}
			group.add(friends.get(index));
			combineFriends(friends, tableSize, groups, group, index + 1);
		}
	}

}
