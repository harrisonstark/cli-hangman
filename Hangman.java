import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Hangman{
	private final String shortWord  = "AEOITSUPRNDBGMYLHWFCKXVJZG";
    private final String mediumWord    = "ESIARNTOLDUCGPMHBYFKWVZXJQ";
    private final String longWord    = "IETNSOARLCPUMDHGYBVFZXWKQJ";
    private String letterList;
    int count = 0;
	Scanner sc = new Scanner(System.in);
	Player player = new Player("");
	Player playerPossesive = new Player("");
	char[] wordStateArray;
	int tries = 0;
	int num = (int) ((Math.random() * 215) + 1);
	String word = "";

	public void state(int triesInput, String wordInput) {
		if (triesInput == 0) {
			System.out.println("/---" + "\n" + "| | " + "\n" + "|   " + "\n" + "|   " + "\n" + "|   " + "\n" + "===="
					+ "\n" + playerPossesive.name + " new word is " + "\"" + wordInput + "\"" + ".");
		} else if (triesInput == 1) {
			System.out.println("/---" + "\n" + "| | " + "\n" + "| O " + "\n" + "|   " + "\n" + "|   " + "\n" + "===="
					+ "\n" + playerPossesive.name + " new word is " + "\"" + wordInput + "\"" + ".");
		} else if (triesInput == 2) {
			System.out.println("/---" + "\n" + "| | " + "\n" + "| O " + "\n" + "| l " + "\n" + "|   " + "\n" + "===="
					+ "\n" + playerPossesive.name + " new word is " + "\"" + wordInput + "\"" + ".");
		} else if (triesInput == 3) {
			System.out.println("/---" + "\n" + "| | " + "\n" + "| O " + "\n" + "| l-" + "\n" + "|   " + "\n" + "===="
					+ "\n" + playerPossesive.name + " new word is " + "\"" + wordInput + "\"" + ".");
		} else if (triesInput == 4) {
			System.out.println("/---" + "\n" + "| | " + "\n" + "| O " + "\n" + "|-l-" + "\n" + "|   " + "\n" + "===="
					+ "\n" + playerPossesive.name + " new word is " + "\"" + wordInput + "\"" + ".");
		} else if (triesInput == 5) {
			System.out.println("/---" + "\n" + "| | " + "\n" + "| O " + "\n" + "|-l-" + "\n" + "|  \\" + "\n" + "===="
					+ "\n" + playerPossesive.name + " new word is " + "\"" + wordInput + "\"" + ".");
		} else if (triesInput == 6) {
			System.out.println("/---" + "\n" + "| | " + "\n" + "| O " + "\n" + "|-l-" + "\n" + "|/ \\" + "\n" + "===="
					+ "\n" + playerPossesive.name + " word was \"" + word + "\", " + player.name + " lose.");
		}
	}

	public void state(int triesInput, String wordInput, String actualWord) {
		if (triesInput == 0) {
			System.out.println("/---" + "\n" + "| | " + "\n" + "|   " + "\n" + "|   " + "\n" + "|   " + "\n" + "===="
					+ "\n" + playerPossesive.name + " new word is " + "\"" + wordInput + "\"" + ".");
		} else if (triesInput == 1) {
			System.out.println("/---" + "\n" + "| | " + "\n" + "| O " + "\n" + "|   " + "\n" + "|   " + "\n" + "===="
					+ "\n" + playerPossesive.name + " new word is " + "\"" + wordInput + "\"" + ".");
		} else if (triesInput == 2) {
			System.out.println("/---" + "\n" + "| | " + "\n" + "| O " + "\n" + "| l " + "\n" + "|   " + "\n" + "===="
					+ "\n" + playerPossesive.name + " new word is " + "\"" + wordInput + "\"" + ".");
		} else if (triesInput == 3) {
			System.out.println("/---" + "\n" + "| | " + "\n" + "| O " + "\n" + "| l-" + "\n" + "|   " + "\n" + "===="
					+ "\n" + playerPossesive.name + " new word is " + "\"" + wordInput + "\"" + ".");
		} else if (triesInput == 4) {
			System.out.println("/---" + "\n" + "| | " + "\n" + "| O " + "\n" + "|-l-" + "\n" + "|   " + "\n" + "===="
					+ "\n" + playerPossesive.name + " new word is " + "\"" + wordInput + "\"" + ".");
		} else if (triesInput == 5) {
			System.out.println("/---" + "\n" + "| | " + "\n" + "| O " + "\n" + "|-l-" + "\n" + "|  \\" + "\n" + "===="
					+ "\n" + playerPossesive.name + " new word is " + "\"" + wordInput + "\"" + ".");
		} else if (triesInput == 6) {
			System.out.println("/---" + "\n" + "| | " + "\n" + "| O " + "\n" + "|-l-" + "\n" + "|/ \\" + "\n" + "===="
					+ "\n" + playerPossesive.name + " word was \"" + actualWord + "\", " + player.name + " lose.");
		}
	}

	public void hangmanGame(int tries, char[] wordState) {
		File words = new File("./bin/hangman.txt");
		Scanner sc2 = null;
		try {
			sc2 = new Scanner(words);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 1; i <= num; i++) {
			word = sc2.nextLine();
		}
		char[] wordStateArray = new char[wordToALMethod().size()];
		int firstTime = 0;
		if (firstTime == 0) {
			wordStateArray = wordStarsMethod().toCharArray();
		}
		while (tries <= 5 && wordStateHasNoStarsMethod(wordStateArray) == false) {
			if (firstTime == 0) {
				state(tries, wordStarsMethod());
			}
			char guess = guess();
			System.out.println("Your guess was " + "\"" + guess + "\"" + ".");
			if (contains(wordToALMethod(), guess) == true) {
				System.out.println("\"" + guess + "\"" + " is in the word!");
				for (int j = 0; j < wordToALMethod().size(); j++) {
					if (wordToCharMethod()[j] == guess) {
						wordStateArray[j] = guess;
					}
				}
				state(tries, charArraytoStringMethod(wordStateArray));
				firstTime++;
			} else {
				System.out.println("\"" + guess + "\"" + " is not in the word.");
				state(++tries, charArraytoStringMethod(wordStateArray));
				firstTime++;
			}
		}
		if (wordStateHasNoStarsMethod(wordStateArray) == true) {
			System.out.println("You win!");
		}
	}

	public char guess() {
		System.out.println("Please make a guess.");
		String G = sc.next();
		
		return G.toCharArray()[0];
	}

	public String charArraytoStringMethod(char[] charArray) {
		String S = "";
		for (int i = 0; i < charArray.length; i++) {
			S += charArray[i];
		}
		return S;
	}

	public boolean wordStateHasNoStarsMethod(char[] charArray) {
		for (int i = 0; i < word.length(); i++) {
			if (charArray[i] == '*') {
				return false;
			}
		}
		return true;
	}

	public ArrayList<Character> wordToALMethod() {
		ArrayList<Character> wordToAL = new ArrayList<Character>();
		for (char parse : wordToCharMethod()) {
			wordToAL.add(parse);
		}
		return wordToAL;
	}

	public char[] wordToCharMethod() {
		char[] wordToChar = word.toCharArray();
		return wordToChar;
	}

	public String wordStarsMethod() {
		String wordStars = "";
		for (int i = 0; i < word.length(); i++) {
			wordStars += "*";
		}
		return wordStars;
	}

	public String wordStarsMethodBot(ArrayList<Character> wordInput) {
		String wordStars = "";
		for (int i = 0; i < wordInput.size(); i++) {
			wordStars += "*";
		}
		return wordStars;
	}

	public boolean contains(ArrayList<Character> phraseOrWord, char guess) {
		if (phraseOrWord.contains(guess))
			return true;
		return false;
	}

	public char[] inputWordToCharArrayMethod(ArrayList<Character> wordInput) {
		char[] wordToChar = new char[wordInput.size()];
		for (int i = 0; i < wordInput.size(); i++) {
			wordToChar[i] = wordInput.get(i);
		}
		return wordToChar;
	}

	public boolean wordStateHasNoStarsBotMethod(char[] charArray) {
		for (int i = 0; i < charArraytoStringMethod(charArray).length(); i++) {
			if (charArray[i] == '*') {
				return false;
			}
		}
		return true;
	}

	public void botGame(int tries, char[] wordState, ArrayList<Character> wordInput) {
		int firstTime = 0;
		if (firstTime == 0) {
			wordStateArray = wordStarsMethodBot(wordInput).toCharArray();
		}
		while (tries <= 5 && wordStateHasNoStarsBotMethod(wordStateArray) == false) {
			if (firstTime == 0) {
				state(tries, wordStarsMethodBot(wordInput));
			}
			char guess = botGuess();
			System.out.println("Their guess was " + "\"" + guess + "\"" + ".");
			if (contains(wordInput, guess) == true) {
				System.out.println("\"" + guess + "\"" + " is in the word!");
				for (int j = 0; j < wordInput.size(); j++) {
					if (inputWordToCharArrayMethod(wordInput)[j] == guess) {
						wordStateArray[j] = guess;
					}
				}
				state(tries, charArraytoStringMethod(wordStateArray),
						charArraytoStringMethod(inputWordToCharArrayMethod(wordInput)));
				firstTime++;
			} else {
				System.out.println("\"" + guess + "\"" + " is not in the word.");
				state(++tries, charArraytoStringMethod(wordStateArray),
						charArraytoStringMethod(inputWordToCharArrayMethod(wordInput)));
				firstTime++;
			}
		}
		if (wordStateHasNoStarsBotMethod(wordStateArray) == true) {
			System.out.println("They win!");
		}
	}

	public char botGuess() {
		int wordSize = wordStateArray.length;
		if(wordSize < 5) {
			letterList = shortWord;
		} else if(wordSize >= 5 && wordSize < 10) {
			letterList = mediumWord;
		} else {
			letterList = longWord;
		}
		char guess = letterList.substring(count, ++count).toCharArray()[0];
		return guess;
	}

	public void start() {
		System.out.println("If you are making a word, please input 1, if the bot is making a word, please input 0.");
		int choice = sc.nextInt();
		if (choice == 0) {
			player.name = "you";
			playerPossesive.name = "Your";
			hangmanGame(0, new char[0]);
		} else if (choice == 1) {
			player.name = "they";
			playerPossesive.name = "Their";
			System.out.println("What is your phrase or word?");
			String voidLineTwo = sc.nextLine();
			String phraseOrWord = sc.nextLine();
			char[] phraseOrWordInCharacters = phraseOrWord.toCharArray();
			ArrayList<Character> phraseOrWordInCharactersArrayList = new ArrayList<Character>();
			for (char parse : phraseOrWordInCharacters) {
				phraseOrWordInCharactersArrayList.add(parse);
			}
			botGame(0, new char[0], phraseOrWordInCharactersArrayList);
		}
	}
}