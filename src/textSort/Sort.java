package textSort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Sort {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		Scanner s = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();

		String input;

		String fileContent;

		System.out.println("What is the file name?");

		input = s.nextLine();

		fileContent = getFileContent(input);

		System.out.println(fileContent);

		String[] tokens = fileContent.split("\\s+");

		for(int i = 0; i < tokens.length; i++){
			for(int j = 0; j < tokens.length; j++){
				if(Double.parseDouble(tokens[i]) < Double.parseDouble(tokens[j])){
					String toSwap = tokens[i];
					tokens[i] = tokens[j];
					tokens[j] = toSwap;
				}
			}
		}

		for(int i = 0; i < tokens.length; i++){
			System.out.println(tokens[i]);
		}
		
		System.out.println("\n" +tokens.length);

		for(int i = 0; i < tokens.length; i++){

			String[] token1 = tokens[i].split("\\.");

			if(sb.length() == 0){
				sb.append(token1[0] + " | " + token1[1]);
				continue;
			}

			String[] copy = tokens[i-1].split("\\.");

			if(token1[0].equals(copy[0])){
				sb.append(" " + token1[1]);
			}
			else if(!token1[0].equals(copy[0])){
				sb.append("\n" + token1[0] + " | " + token1[1]);
			}

		}

		System.out.print(sb);

		s.close();

	}

	public static String getFileContent(String x) throws FileNotFoundException, IOException{
		try
		(
			BufferedReader br = new BufferedReader(new FileReader(x))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String everything = sb.toString();

			return everything;
		}

	}
}
