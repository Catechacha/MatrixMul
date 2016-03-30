import java.util.*;
import java.util.concurrent.*;
public class Main {
	public static Matrix m1,m2,m3;
	public static int THREAD_COUNT=1000;
	
	public static void main(String[] args) throws ImpossibleToMulException {
		int i;
		Scanner input = new Scanner(System.in);
		System.out.println("Matrix one: give me the number of rows");
		int r1 = Integer.parseInt(input.nextLine());
		System.out.println("Matrix one: give me the number of cols");
		int c1 = Integer.parseInt(input.nextLine());
		System.out.println("Matrix two: give me the number of rows");
		int r2 = Integer.parseInt(input.nextLine());
		System.out.println("Matrix two: give me the number of cols");
		int c2 = Integer.parseInt(input.nextLine());
		input.close();
		
		ExecutorService ex = Executors.newFixedThreadPool(THREAD_COUNT);
		if(c1!=r2)
			throw new ImpossibleToMulException("The m2's number of rows is different from m1's number of cols");
		//create and set matrix
		m1=new Matrix(r1,c1);
		m2=new Matrix(r2,c2);
		m1.setRandomMatrix();
		m2.setRandomMatrix();
		
	/*	If you want, you can print matrix one and two
	    System.out.println("Matrix 1 is:");
		m1.PrintMatrix();
		System.out.println("Matrix 2 is:");
		m2.PrintMatrix();		*/
		
		m3=new Matrix(r1,c2);//matrix result
		try{
			long startTime=System.currentTimeMillis();
			ArrayList<VectorMatrixMul> tasks = new ArrayList<>();	
			for(i=0;i<m1.row;i++){
				tasks.add(new VectorMatrixMul(m1.get(i),m2));
			}
			try {
				List<Future<ArrayList<Integer>>> resultList=ex.invokeAll(tasks);
				System.out.println("Finish work in "+(System.currentTimeMillis()-startTime)+" using "+ THREAD_COUNT+" threads");
				for(Future<ArrayList<Integer>> res: resultList){
					m3.a.add(res.get());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		catch(ExecutionException e){
			e.printStackTrace();
			System.out.println("Some thread failed");
		}
		finally{ex.shutdown();}
		
	/*	If you want you can print matrix 3
		System.out.println("");
		System.out.println("Matrix result is: ");
		m3.PrintMatrix();//print matrix result		*/
	}
}