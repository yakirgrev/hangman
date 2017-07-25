import java.util.Random;
import java.util.Scanner;

public class Game {
	
	static int guessCounter=0;

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String [] words = {"star wars","gremlins","james bond","iron man","harry potter","spiderman","mission impossible"};
		Random r = new Random();
		int guessCounter=0;
		
		int num = r.nextInt((words.length-1 - 0) + 1) + 0;		
		//System.out.println(words[num]);
		char [] revealedWord = wordPrep(words[num]);
			
		char c = '1';
		
		while(c!='0' && guessCounter<words[num].length()) {
			System.out.println("Please guess a letter: ");
			c = reader.next().charAt(0);
			for(int i=0; i<words[num].length(); i++) {
				if(words[num].charAt(i)==c) {
					revealedWord[i]=c;
					wordRevealer(revealedWord);
					guessCounter++;
					
				}
			}
		}
		if(guessCounter==words[num].length()) {
			System.out.println("You win!");
		}
		

	}
	
	public static char[] wordPrep(String word) {
		char res [] = new char[word.length()];

		for(int i=0; i<word.length(); i++) {
			
			if(word.charAt(i)==' ') {
				res[i]=' ';
				guessCounter++;
			}
		}
		return res;
	}
	
	public static void wordRevealer (char[] word) {
		for(int i=0; i<word.length; i++) {
			
			if(word[i]<'A' && word[i]>'Z' || word[i]<'a' && word[i]>'z') System.out.print("_");
			System.out.print(word[i]);
		}
		System.out.println();
	}

}
