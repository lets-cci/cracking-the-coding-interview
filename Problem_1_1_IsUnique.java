package com.letscci.co.in.problems;

public class Problem_1_1_IsUnique {

//	Is Unique: Implement an algorithm to determine if a string has all unique characters.
//	Input: abcdefgh
//  Output: true
//	Input: abcdefgha
//  Output: false
	
//	character set is ASCII (128 character)
	
	public static void main(String[] args) {
        
		String input1 = "abcdefgh";
		String input2 = "abcdefgha";
		System.out.println("The input string: "+input1+(isUnique(input1)?" It is Unique":" Not a Unique string"));
		System.out.println("The input string: "+input2+(isUniqueByBitvector(input2)?" It is Unique":" Not a Unique string"));

    }
	
	private static boolean isUnique(String input){
				
		int length = input.length();
		if(length>128) return false;
		boolean char_set[] =  new boolean[128];
		for(int i = 0;i<length;i++){
			int val = input.charAt(i);
			if(char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}
	
//	so in the above problem we solved it O(c) time complexity - c is the size of the string and the O(1) space complexity
	
//	we can reduce space usage by a factor of eight by using a bit vector 
	
	private static boolean isUniqueByBitvector(String input){
		
		int length = input.length();
		if(length>128) return false;
		
		int dataset = 0;
//		11000000
//		abcdefgha
		for(int i = 0;i<length;i++){
			int val = input.charAt(i)-'a';
			if((dataset & (1 << val))>0) return false;
			
			dataset |= (1<< val);
			
		}
		return true;
	}
	
}
