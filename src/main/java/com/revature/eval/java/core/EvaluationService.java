package com.revature.eval.java.core;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class EvaluationService {
	
	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		//Creates new char with same length as string
		char[] reversed = new char[string.length()];
		//switches characters at specified index
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		//Returns new String object of reversed
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		//Split phrase into spaces and dashes
		String [] splitPhrase = phrase.split(" |-");
		//Create empty string object
		String newString = new String("");
		for (String element : splitPhrase) {
			//Concatenate the acronym
			newString = newString.concat(element.substring(0,1).toUpperCase());
		}
		//Return 
		return newString;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			//If all sides are equal
			if (sideOne == sideTwo && sideTwo == sideThree) {
				return true;
			}
			return false;
		}

		public boolean isIsosceles() {
			//Initialize a counter variable
			int comp = 0;
			//If a side equals another, add to counter
			if(sideOne == sideTwo) {
				comp++;
			}
			if (sideTwo == sideThree) {
				comp++;
			}
			if (sideOne == sideThree) {
				comp++;
			}
			//If ONLY one side is equal, return true
			if (comp == 1) {
				return true;
			}
			//else return false
			return false;
		}

		public boolean isScalene() {
			//No sides are equal
			if (sideOne != sideTwo && sideTwo != sideThree && sideThree != sideOne) {
				return true;
			}
			return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		//Scoring  variable
		int score = 0;
		String lowercaseString = string.toLowerCase(); 
		//Switch statements to add to score.
		for (int i = 0; i < string.length(); i++) {
			switch (lowercaseString.charAt(i)) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
				case 'l':
				case 'n':
				case 'r':
				case 's':
				case 't':
					score++; //Add 1
					break;
				case 'd':
				case 'g':
					score+=2; //Add 2
					break;
				case 'b':
				case 'c':
				case 'm':
				case 'p': 
					score+=3; //Add 3
					break;
				case 'f':
				case 'h':
				case 'v':
				case 'w':
				case 'y':
					score+=4; //Add 4
					break;
				case 'k': 
					score +=5; //Add 5
					break;
				case 'j':
				case 'x':
					score += 8; //Add 8
					break;
				case 'q':
				case 'z':
					score +=10; //Add 10
					break;
			}
		}
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) throws IllegalArgumentException {
		String new_num = "";
		
		//clean up phone number, if character is number, concat it.
		for (int i = 0; i < string.length(); i++) {
			if (Character.isDigit(string.charAt(i))) {
				new_num = new_num.concat(Character.toString(string.charAt(i)));
			}
		}
		//Contains the +1 code, remove it
		if (new_num.length() == 11) {
			if (new_num.charAt(0) == '1') {
				new_num = new_num.substring(1);
			}
		}
		//Illegal length (covers both characters in number and excess numbers
		else if (new_num.length() > 11 || new_num.length() < 10) {
			throw new IllegalArgumentException("Enter a valid phone number.");
		}
		//If the first character or 4th character is a 1, then number is invalid
		if ((Character.getNumericValue(new_num.charAt(0)) < 2) || 
		   (Character.getNumericValue(new_num.charAt(3)) < 2)) {
			return "Invalid";
		}
		return new_num;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		Map <String, Integer> countWords = new HashMap<String,Integer>();
		//Removes spaces, commas, and new lines from the string
		String[] stringSplit = string.split(" |,|\n");
		//If the element is in the HashMap, then add 1, else add a new key.
		for (String element : stringSplit) {
			if (countWords.containsKey(element)) {
				int count = countWords.get(element);
				countWords.put(element, count +1);
			}
			else if (!element.isEmpty()) {
				countWords.put(element,1);
			}
		}
		return countWords;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>> {
		private List<T> sortedList;
		public int indexOf(T t) {
			//Low and high variable of the Generic type
			int low = 0;
			int high = sortedList.size()-1; 
			while (low <= high) {	
				int index = (low + high)/2;
				T comp = sortedList.get(index);
				//Compare to method compares two objects, if 
				// s1.compareTo(s2) is > 1, then s1 < s2
				// s1.compareTo(s2) is < 1. then s1 > s2
				// s1.compareTo(s2) is 0, then s1 == s2
				if (t.compareTo(comp) > 0) {
					 low = index + 1;
				}
				else if (t.compareTo(comp) < 0) {
					high = index - 1;
				}
				else {
					return index;
				}
			}
			//The object is not found in the List
			System.out.println("Not found");
			return -1;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		ArrayList<Character> vowels = new ArrayList<Character>();
		//Adds vowels to an arrayList
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');	
		//String array with no spaces
		String [] stringSplit = string.split(" ");
		String newString = "";
		for (int i = 0; i < stringSplit.length; i++) {
			//Vowel is first
			if (vowels.contains(stringSplit[i].charAt(0))) {
				stringSplit[i] = stringSplit[i].concat("ay");
			}
			//if it equals two character consonants "th" and "qu"
			else if (stringSplit[i].substring(0,2).toLowerCase().equals("th") ||
					stringSplit[i].substring(0,2).toLowerCase().equals("qu")) {
				String firstCharacters = stringSplit[i].substring(0,2);
				stringSplit[i] = stringSplit[i].substring(2);
				stringSplit[i] = stringSplit[i].concat(firstCharacters + "ay");
			}
			//if it equals three character consonant "sch"
			else if (stringSplit[i].substring(0,3).toLowerCase().equals("sch")) {
				String firstCharacters = stringSplit[i].substring(0,3);
				stringSplit[i] = stringSplit[i].substring(3);
				stringSplit[i] = stringSplit[i].concat(firstCharacters + "ay");
			}
			//Generic consonant
			else {
				String character = stringSplit[i].substring(0,1);
				stringSplit[i] = stringSplit[i].substring(1);
				stringSplit[i] = stringSplit[i].concat(character + "ay");
			}
			//If it's at the end of a sentence don't add space
			if (i == stringSplit.length-1) {
				newString = newString.concat(stringSplit[i]);
			}
			else {
				newString = newString.concat(stringSplit[i] +" ");
			}
			
		}
		return newString;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		String string = Integer.toString(input);
		//The length of the string is where you start the exponent
		int pow = string.length();
		//sum
		int sum = 0;
		//temp integer
		int temp = input;
		for (int i = 0; i < string.length(); i++) {
			//Get (temp%10)^pow
			sum += (int) Math.pow(temp % 10, pow);
			//Divide temp by 10 to get new number
			temp /= 10;
		}
		//If the sum is the same as input, its armstrong number
		if (sum == input) {
			return true;
		}
		return false;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> prime_factors = new ArrayList<Long>();
		//First prime number
		long factor = 2;
		//Set parameter l to true_num
		long tru_num = l;
		while (l !=1) {
			//If (long l) mod the factor equals 0, it is a prime factor
			if (l % factor == 0) {
				l /= factor;
				prime_factors.add(factor);
			}
			//Increase factor till mod equals 0
			else {
				factor++;
			}
		}
		//The number is prime if the factor is long l.
		if (factor == tru_num) {
			System.out.println("The number is prime.");
		}
		return prime_factors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			//Increase the ascii number for each character of the string.
			for (int i =0; i < key; i++) {
				String new_string = "";
				for (int j = 0; j < string.length(); j++) {
					int ascii = (int)string.charAt(j); // 97 to 122 and 65 to 90
					if ((ascii <= 122 && ascii >= 97) || (ascii >= 65 && ascii <= 90))
						ascii++;
						if (ascii == 123) {
							ascii = 97;
						}
						else if (ascii == 91) {
							ascii = 65;
						}
					//Concatenates string
					new_string =new_string.concat(Character.toString((char) ascii));
				}
				string = new_string;
				
			}
			
			return string;
		}

	}


	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) throws IllegalArgumentException {
		if (i <= 0) {
			//Integer is negative
			throw new IllegalArgumentException("Integer cannot be less than 1.");
		}
		
		int current_num = 2;
		int current_type = 1;
		int current_prime = 2;
		while (current_type <= i) {
			boolean prime = true;
			//Iterates through each number and mods the current num to parameter
			for (int j = 2; j <= current_num/2; j++) {
				if (current_num % j == 0) {
					prime = false;
				}
			}
			//If its true set the current prime equal to the num.
			if (prime == true) {
				current_type++;
				current_prime = current_num;
			}
			current_num++;
			
		}
		
		return current_prime;
		
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {
		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			Hashtable <Character, Character> key = new Hashtable<Character,Character>();
			//Create hashtable with the key cipher
			char first = 97;
			char last = 122;
			for (int i = 0; i < 26; i++) {
				key.put(first, last);
				first++;
				last--;				
			}
			//Replace all special characters	
			string = string.replaceAll("[\\.|\\?|\\+|\\*|\\^|\\$|,]", "");
			String[] stringSplit = string.toLowerCase().split(" ");
			String encodedCypher = "";
			for (String element : stringSplit) {
				for (int i = 0;i < element.length(); i++) {
					if (Character.isLetter(element.charAt(i))) {
						encodedCypher = encodedCypher.concat(Character.toString(key.get
								(element.charAt(i))));	
					}
					else {
						encodedCypher = encodedCypher.concat(Character.toString(element.charAt(i)));
					}	
				}
			}
			//The encodedCypher is not separated by spaces/ needs to be.
			String returnCypher = "";
			for (int i = 1; i <= encodedCypher.length(); i++) {
				returnCypher = returnCypher.concat(
						Character.toString(encodedCypher.charAt(i-1)));
			//Separates/adds spaces between the 5 characters in string
				if ((i % 5) == 0 && i != encodedCypher.length()) {
					returnCypher = returnCypher.concat(" ");
				}
			}
			
			return returnCypher;
			
		}
			

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			//Same as encode
			Hashtable <Character, Character> key = new Hashtable<Character,Character>();
			char first = 122;
			char last = 97;
			//Encodes cipher
			for (int i = 0; i < 26; i++) {
				key.put(first, last);
				first--;
				last++;
			}
			//Splits string by spaces
			String [] stringSplit = string.split(" ");
			String decodedCypher = "";
			for (String element : stringSplit) {
				for (int j = 0;j < element.length(); j++) {
					if (key.get(element.charAt(j)) != null) {
						//No need to worry about spaces for words, just concat
						decodedCypher = decodedCypher.concat(Character.toString(key.get
								(element.charAt(j))));	
					}
					else {
						decodedCypher = decodedCypher.concat(Character.toString(element.charAt(j)));
					}
				}
			}
			
			return decodedCypher;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		List<Integer> ISBN = new ArrayList<Integer>();
		for (int i = 0; i < string.length(); i++) {
			//If it is a number add to a List
			if (Character.isDigit(string.charAt(i))) {
				ISBN.add(Character.getNumericValue(string.charAt(i)));
			}
		}
		int check = 0;
		int counter = 10;
		
		for (int j = 0; j < ISBN.size(); j++) {
			//Performs the math needed for ISBN
			check += (ISBN.get(j)*counter);
			counter--;
		}
		//If check % 11 == 0, is valid.
		if (Math.floorMod(check,11) == 0) {
			return true;
		}
		//X = 10, so check if 10 added and string contains X
		else if (Math.floorMod(check+10,11) == 0 && string.contains("X")) {
			return true;
		}
		return false;
	}
	
	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		//Get rid of spaces
		string = string.replaceAll(" ", "");
		List<Character> alphabet = new ArrayList<Character>();
		List<Character> stringCheck = new ArrayList<Character>();
		//Adds alphabet to alphabet list
		char ascii = 97;
		for (int i = 0; i < 26; i++) {
			alphabet.add(ascii);
			ascii++;
		}
		//Lower all characters to prevent null exceptions
		string = string.toLowerCase();
		for (int j = 0; j < string.length(); j++) {
			if (!stringCheck.contains(string.charAt(j))) {
				//If the character is not in alphabet, add it to stringCheck
				stringCheck.add(string.charAt(j));
			}
			
		}
		//if the sizes are the same, then it contains all letters
		if (alphabet.size() == stringCheck.size()) {
			return true;
		}
		return false;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		//Year, Month, Day, Hour, Minute, Second (Paired Programming)
		LocalDateTime time = LocalDateTime.of(1,Month.JANUARY,1,0,0,0);
		time = time.withYear(given.get(ChronoField.YEAR));
		time = time.withMonth(given.get(ChronoField.MONTH_OF_YEAR));
		time = time.withDayOfMonth(given.get(ChronoField.DAY_OF_MONTH));
		try {
			//These parameters may not be specified string
			time = time.withHour(given.get(ChronoField.HOUR_OF_DAY));
			time = time.withMinute(given.get(ChronoField.MINUTE_OF_HOUR));
			time = time.withSecond(given.get(ChronoField.SECOND_OF_MINUTE));
	
		} catch (Exception e) {
		}
		//Add gigasecond
		return time.plusSeconds(1_000_000_000);
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		int sum = 0;
		boolean flag = false;
		for (int j = 0; j < i; j++) {
			for (int k = 0; k < set.length;k++) {
				if (j % set[k] == 0) {
					//Flag is true when it is a multiple
					flag = true;
				}
			}
			if (flag) {
				//Adds multiple to sum, resets flag
				sum += j;
				flag = false;
			}
		}
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		//Replace all spaces
		String noSpace = string.replaceAll(" ", "");
		int sum = 0;
		for (int i = 0; i < noSpace.length(); i++) {
			if (((i+1) % 2) == 0) {
				//Multiply number by 2, if its greater than 10, subtract 9
				int temp = 2*Character.getNumericValue(noSpace.charAt(i));
				if (temp > 9) {
					sum += temp -9;
				}
				else {
					sum += temp;
				}			
			}
			else {
				sum += Character.getNumericValue(noSpace.charAt(i));
			}
		}
		//If sum contains no reminder when divided by 10, return true
		if (sum % 10 == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		//Replace all ? in the string
		String noQ = string.replaceAll("\\?","");
		ArrayList<Integer> nums = new ArrayList<Integer>();
		//Splits string by spaces
		List<String> stringSplit = Arrays.asList(noQ.split(" "));
		int i = 0;
		while (i < stringSplit.size()) {
			int tmp = 0;
			//Try catch statement adds only numbers, if its not a number, skip it
			try {
				tmp = Integer.parseInt(stringSplit.get(i));
				nums.add(tmp);
				i++;
			}catch (Exception e) {
				i++;
			}
		}
			//Performs operation based on the text
			if (string.contains("multiplied")) {
				return (int) (nums.get(0)*nums.get(1));
			}
			else if (noQ.contains("divided")) {
				return (int) (nums.get(0)/nums.get(1));
			}
			else if (noQ.contains("minus")) {
				return (int) (nums.get(0)-nums.get(1));
			}
			else {
				return (int) (nums.get(0)+nums.get(1));
			}		
	}
			
}
