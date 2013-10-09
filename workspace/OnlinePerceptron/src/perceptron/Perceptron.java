package perceptron;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Perceptron {
	
	String trainingData = "/home/shannon/workspace/CS434/perceptron_train.csv";
	
	ArrayList<List<Float>> parseCSV (String fileName) throws IOException {
		
		BufferedReader buff = null;
		
		String line = "";
		String splitter = ",";
		
		ArrayList<List<Float>> parsed = new ArrayList<List<Float>>();
		
		
		try {
			buff = new BufferedReader(new FileReader(fileName));
			
			while ( (line = buff.readLine()) != null) {
				
				List<Float> row = new ArrayList<Float>();
				
				for (String t : line.split(splitter)) {
					row.add(Float.valueOf(t));
					//System.out.println("Row:  ");
					//System.out.println(row.toString());
					//System.out.println("\n");
				}
				
				parsed.add(row);
				//System.out.println("Parsed:  ");
				//System.out.println(parsed.toString());
				//System.out.println("\n");
			}
		} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
			
		
		} finally {
	
			if (buff != null) {
				buff.close();
			}
		}
		return parsed;
	}
	
	void pTrain () {
		
	}
	
	void pClassify () {
		
	}
	
	public static void main (String [] args) throws IOException {
		
		Perceptron percy = new Perceptron();
		System.out.println("My name is Percy!\n");
		
		ArrayList<List<Float>> file = percy.parseCSV(percy.trainingData);
		
		
	}

};
