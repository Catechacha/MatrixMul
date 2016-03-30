import java.util.ArrayList;
import java.util.concurrent.Callable;

public class VectorMatrixMul implements Callable<ArrayList<Integer>>{
	public ArrayList<Integer> a;
	public Matrix b;
	
	public VectorMatrixMul(ArrayList<Integer> row, Matrix m) {
		a=row;
		b=m;
	}
	
	@Override
	public ArrayList<Integer> call(){
		int i,j,k;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(i=0;i<b.col;i++)
			result.add(0);
		for(i=0;i<a.size();i++){
			for(j=0;j<b.col;j++){
				k=result.get(j)+(a.get(i)*b.a.get(i).get(j));
				result.set(j,k);
			}
		}
		return result;
	}
}