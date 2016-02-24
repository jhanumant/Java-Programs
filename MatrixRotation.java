
public class MatrixRotation {
	public static void rotateMatrix(int[][] matrix,int n) {
		for (int layer=0;layer<n/2;layer++) {
			int first = layer;
			int last = n-1 - layer;
			for (int i=first;i<last;i++) {
				int offset = i-first;
				int top = matrix[first][i];
				matrix[first][i] = matrix[last-offset][first];
				matrix[last-offset][first] = matrix[last][last-offset];
				matrix[last][last-offset] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
		
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		rotateMatrix(matrix, 4);
	}
}
