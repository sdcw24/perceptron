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

			line = buff.readLine();
			
			while ( line != null) {
				
				List<Float> row = new ArrayList<Float>();
				
				for (String t : line.split(splitter)) {
					row.add(Float.valueOf(t));
					
				}
				
				parsed.add(row);
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
		
		ArrayList<List<Float>> file = percy.parseCSV(percy.trainingData);
		
		for (List<Float> list : file) {
			System.out.println(list);
		}
		
	}

};
