import java.util.Scanner;
import java.util.List;

import dictionary.Dictionary;
import dictionary.helper.DictionaryHelper;
import dictionary.helper.trie.TrieDictionaryHelper;

public class Main {

	private static void printMessage(Dictionary.Operation operation, boolean isSuccess){
		System.out.printf("<<<<< %s operation, success = %s >>>>>\n", operation, isSuccess);
	}

	private static void printMessage(Dictionary.Operation operation, List<String> output){
		System.out.printf("<<<<< %s operation, and here is the list:", operation);

		for(String s : output){
			System.out.printf("----> %s\n", s);
		}
	}
	public static void main(String[] args){
		DictionaryHelper dictionaryHelper = new TrieDictionaryHelper();
		Dictionary dictionary = new Dictionary(dictionaryHelper);
		Scanner sc = new Scanner(System.in);

		boolean outOfLoop = false;

		System.out.println("This is a dictionary application and it supports the following operations:");

		for(Dictionary.Operation operation : Dictionary.Operation.values()){
			System.out.println(operation);
		}

		System.out.println("Input EXIT to terminate the program");

		while(!outOfLoop){
			System.out.println(" <<<<< Input the operation: >>>>> ");
			
			try{
				Dictionary.Operation requestedOperation = Dictionary.Operation.parse(sc.next());
				String word = "";

				switch (requestedOperation){
					case INSERT:
					System.out.println("Input the desired word:");
					word = sc.next();
					printMessage(requestedOperation, dictionary.insert(word));
					break;

					case SEARCH:
					System.out.println("Input the desired word:");
					word = sc.next();
					printMessage(requestedOperation, dictionary.search(word));
					break;

					case DELETE:
					System.out.println("Input the desired word:");
					word = sc.next();
					printMessage(requestedOperation, dictionary.delete(word));
					break;

					case AUTOCORRECT:
					System.out.println("Input the desired word:");
					word = sc.next();
					printMessage(requestedOperation, dictionary.autoCorrect(word));
					break;

					case AUTOSUGGEST:
					System.out.println("Input the desired word:");
					word = sc.next();
					printMessage(requestedOperation, dictionary.autoSuggest(word));
					break;
				}
			} catch (IllegalArgumentException exception){
				outOfLoop = true;
				System.out.println("Good bye, exiting ...");
			}
		}
		sc.close();
	}
}