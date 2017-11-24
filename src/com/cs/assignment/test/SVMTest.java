package com.cs.assignment.test;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.cs.assignment.main.Evaluator;

import edu.berkeley.compbio.jlibsvm.ImmutableSvmParameter;
import edu.berkeley.compbio.jlibsvm.ImmutableSvmParameterGrid;
import edu.berkeley.compbio.jlibsvm.binary.BinaryModel;
import edu.berkeley.compbio.jlibsvm.binary.C_SVC;
import edu.berkeley.compbio.jlibsvm.binary.MutableBinaryClassificationProblemImpl;
import edu.berkeley.compbio.jlibsvm.kernel.LinearKernel;
import edu.berkeley.compbio.jlibsvm.util.SparseVector;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SVMTest {
	
    C_SVC svm = new C_SVC();
	ImmutableSvmParameterGrid.Builder builder = ImmutableSvmParameterGrid.builder();
	ImmutableSvmParameter params;
    private MutableBinaryClassificationProblemImpl problem;
    BinaryModel model;
    static float [][] data = new float [6] [2];
	
	@Before
    public void initObjects() {
        // build parameter
        // create training parameters ------------
        HashSet<Float> cSet;
        HashSet<LinearKernel> kernelSet;

        cSet = new HashSet<Float>();
        cSet.add(1.0f);

        kernelSet = new HashSet<LinearKernel>();
        kernelSet.add(new LinearKernel());
 
        // configure finetuning parameters
        builder.eps = 0.001f; // epsilon
        builder.Cset = cSet; // C values used
        builder.kernelSet = kernelSet; //Kernel used

        params = builder.build();
        // / create training parameters ------------
    }
	
	@Test
	public void testXgtYMaxMin(){
		
		float x = 10.0f;
		float y = 1.0f;
		
		boolean isXGreaterThanY = Evaluator.isXGreaterThanY(x, y);
		data[0][0] = x;
		data[0][1] = y;
		assertTrue(isXGreaterThanY);
	}
	
	@Test
	public void testXgtYHighLow(){
		
		float x = 9.0f;
		float y = 2.0f;
		
		boolean isXGreaterThanY = Evaluator.isXGreaterThanY(x, y);
		data[1][0] = x;
		data[1][1] = y;
		assertTrue(isXGreaterThanY);
	}
	
	@Test
	public void testXgtYHighBoundary(){
		
		float x = 5.0f;
		float y = 4.0f;
		
		boolean isXGreaterThanY = Evaluator.isXGreaterThanY(x, y);
		data[2][0] = x;
		data[2][1] = y;
		assertTrue(isXGreaterThanY);
	}
	
	@Test
	public void testYgtXMinMax(){
		
		float x = 1.0f;
		float y = 10.0f;
		
		boolean isXGreaterThanY = Evaluator.isXGreaterThanY(x, y);
		data[3][0] = x;
		data[3][1] = y;
		assertTrue(isXGreaterThanY);
	}
	
	@Test
	public void testYgtXLowHigh(){
		
		float x = 2.0f;
		float y = 9.0f;
		
		boolean isXGreaterThanY = Evaluator.isXGreaterThanY(x, y);
		data[4][0] = x;
		data[4][1] = y;
		assertTrue(isXGreaterThanY);
	}
	
	@Test
	public void testYgtXLowBoundary(){
		
		float x = 4.0f;
		float y = 5.0f;
		
		boolean isXGreaterThanY = Evaluator.isXGreaterThanY(x, y);
		data[5][0] = x;
		data[5][1] = y;

		assertTrue(isXGreaterThanY);
	}
	

	@Test
	public void trainSVM(){
		
		MutableBinaryClassificationProblemImpl problem = new MutableBinaryClassificationProblemImpl(String.class, 2);
		
		for(int i=0; i<data.length; i++) {
	        	
	        float q = data [i] [0];
	        float r = data [i] [1];
			
			problem.addExample(generateFeatures(new float [] {q,r}), generateLabel(q,r));
	        System.out.println("Values are " + q + " and " + r + " Label is : " + generateLabel(q,r));
	    }
	    
		System.out.println("Training model with data...");
	    model = svm.train(problem, params);
	    
	    System.out.println("Predicting Test Result for values, x = 1.0 and y = 8.0");
	    SparseVector xTest = generateFeatures(new float[]{1.0f, 8.0f});
	    int predictedLabel = (Integer) model.predictLabel(xTest);
	    System.out.println("Predicted Result: " + predictedLabel);
	    
	    System.out.println("Predicting Test Result for values, x = 7.0 and y = 3.0");
	    SparseVector xTest2 = generateFeatures(new float[]{7.0f, 3.0f});
	    int predictedLabel2 = (Integer) model.predictLabel(xTest2);
	    System.out.println("Predicted Result: " + predictedLabel2);
	}
	
	
	 private static int generateLabel(float f, float g) {

			if (Evaluator.isXGreaterThanY(f, g)){
				return 1;
			}
				
			return -1;

	 }

	/**f
	   * Helper function to generate a single featureset.
	   * @param floats
	   * @return
	   */
	 private static SparseVector generateFeatures(float[] floats) {
		    SparseVector sparseVector = new SparseVector(floats.length);
		    int[] indices = new int[2];
		    for (int i = 0; i < floats.length; i++) {
		      indices[i] = new Integer(i);
		    }
		    sparseVector.indexes = indices;
		    sparseVector.values = floats;
		    return sparseVector;
	 }


}
