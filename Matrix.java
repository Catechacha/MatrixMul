import java.util.*;

public class Matrix {
	public ArrayList<ArrayList<Integer>> a;
	public int row,col;
	
	public Matrix(int r, int c) {
		this.row = r;
		this.col = c;
		a = new ArrayList<ArrayList<Integer>>();
	}
	
	public void setRandomMatrix(){
		int i,j;
		Random rnd = new Random();
		for(i=0;i<this.row;i++){
			ArrayList<Integer> numbers=new ArrayList<Integer>();
			for(j=0;j<this.col;j++)
				numbers.add(j,rnd.nextInt(100));
			a.add(i,numbers);
		}
	}
	
	public void PrintMatrix(){ //print the matrix
		int i,j;
		for(i=0;i<this.row;i++){
			for(j=0;j<this.col;j++){
				if (j==col-1)
					System.out.println(this.a.get(i).get(j));
				else
					System.out.print(this.a.get(i).get(j) + " ");
			}
		}
	}

	public ArrayList<Integer> get(int i){
		return this.a.get(i);
	}
}