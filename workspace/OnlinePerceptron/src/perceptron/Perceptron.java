package perceptron;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Object.*;





public class Perceptron {
	
	String trainingData = "/home/shannon/workspace/CS434/perceptron_train.csv";
	
	public ArrayList<DataPoint> parseCSV (String fileName) throws IOException {
		
		BufferedReader buff = null;
		
		String line = "";
		String splitter = ",";
		
		ArrayList<List<Double>> parsed = new ArrayList<List<Double>>();
		
		
		try {
			buff = new BufferedReader(new FileReader(fileName));
			
			while ( (line = buff.readLine()) != null) {
				
				List<Double> row = new ArrayList<Double>();
				
				for (String t : line.split(splitter)) {
					row.add(Double.valueOf(t));
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
		
		//parsed now holds the list<list<double>> of values
		//put into List<DataPoint>
		ArrayList<DataPoint> dataPoints = new ArrayList<DataPoint>();
		
		for(List<Double> row : parsed)
		{
			double NewY = row.remove(0);
			DataPoint addThis = new DataPoint();
			addThis.y = NewY;
			addThis.features = row;
		}
		return dataPoints;
	}
	
	public ArrayList<Double> pTrain (List<Double>> trainingSet, int epochs, String option) {
		
		
		double[] wts = null;
		Double y;
		
		int numFeats = trainingSet.get(0).size() - 1;
		Double learnGuess = null;
		double[] adjuster = null;
		double[] features = null;
				
		// initialize the wts array
		for (int i = 0; i < numFeats; i++) {
			wts[i] = 0;
		}
		
		// If we want to feed in order:
		if (option == "linear") {
			for (int j=0; j < epochs; j++) {
				for (int i = 0; i < trainingSet.size(); i++) {
					
					learnGuess = Matrix.dot(features, wts);
				
			
					if (y*learnGuess <= 0){
						wts = wts + adjuster;
					}
				}
			}
		}
		
		else if (option == "random") {
			
		}
		
		return wts;
		
	}
	
	void pClassify () {
		
	}
	
	public static void main (String [] args) throws IOException {
		
		Perceptron percy = new Perceptron();
		System.out.println("My name is Percy!\n");
		
		ArrayList<List<Double>> file = percy.parseCSV(percy.trainingData);
		
		
	}

};
