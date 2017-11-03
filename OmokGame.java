
import java.util.*;

public class OmokGame {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);


		System.out.println("print the board size");
		int boardSize = keyboard.nextInt();
		int a[][] = new int [boardSize][boardSize];


		DrawBoard(a);
		playing(a);

		System.out.println("Game over!");
		keyboard.close();

	}

	public static int WiningDecision(int a[][]){
		int check =-2;
		int k=-1;
		int m=-1;
		int l=-1;
		int n=-1;

		for(int i=0; i<a.length; i++){
			for(int j=0; j<a[i].length; j++){

				if(a[i][j] ==1){

					k = Horizontal(a,i,j);
					m = Vertical(a, i, j);
					l =  DiagonalUp(a,i,j);
					n =  DiagonalDown(a,i,j);

					if(k ==1 || m == 1 || l == 1 || n ==1){

						check = 1;
						break;
					}

			}

				else if(a[i][j] == 2){
					k = Horizontal(a,i,j);
					m = Vertical(a, i, j);
					l =  DiagonalUp(a,i,j);
					n =  DiagonalDown(a,i,j);

					if(k ==2 || m == 2 || l == 2 || n ==2){

						check =2;
						break;
					}

			}

		}

	}
		if(check ==-2)

			return 0;
		else
			return check;
}



	public static int Vertical(int a[][], int x, int y){
		int k=0;
		for(int i=0; i<5; i++){
			if((x+i) <a.length){
				if(a[x+i][y] == a[x][y]){
					k++;
				}
			}
			if(k==5){
				return a[x][y];
			}
	}
		//System.out.println(k);
		return -1;
}

	public static int Horizontal(int a[][], int x, int y){
		int k=0;
		for(int i=0; i<5; i++){
			if((y+i) <a.length){
			if(a[x][y+i] == a[x][y]){
				k++;
			}

			}
			if(k==5){
				return a[x][y];
		}
	}
		return -1;
}

	public static int DiagonalUp(int a[][], int x, int y){
		int k=0;
		for(int i=0; i<5; i++){
			if((y+i) <a.length && (x+i) < a.length) {
				if(a[x+i][y+i] == a[x][y]){
					k++;
				}
			}
			if(k==5){
				return a[x][y];
			}
		}
		return -1;
}

	public static int DiagonalDown(int a[][], int x, int y){
		int k=0;
		for(int i=0; i<5; i++){
			if((y-i) >=0 && (x+i) < a.length) {
			if(a[x+i][y-i] == a[x][y]){
				k++;
			}
		}
			if(k==5){
				return a[x][y];
			}
	}
		return -1;
	}


	public static void playing(int a[][]){
		Scanner keyboard = new Scanner(System.in);
		int p=0;
		int i=0;
		int l = a.length * a.length;
		int k;

		System.out.println("Press negative integer any time to quit.");

		while(i<l){       //play until all the  cells fill up


			System.out.println("Provide stone indices for  player "+(p+1)+":");

			int x = keyboard.nextInt();
			if (x<0) return;
			int y = keyboard.nextInt();
			if (y<0) return;

			if (x>=a.length || y>=a.length || a[x][y]!=0){
				System.out.println("Invalid input. Try again.");
				continue;
			}

			a[x][y]=p+1;
			DrawBoard(a);
			k = WiningDecision(a);
			if (k!=0){
				System.out.println("Player "+k+" won the game!");
				return;
			}

			p=(p+1)%2;

			i++;
		}

		System.out.println("No body won.");
		//keyboard.close();
	}



	public static void DrawBoard(int a[][]){


		System.out.print("x\\y|");
		for(int k=0; k<a.length; k++){
			System.out.printf("%3d ",k);
		}
		System.out.println();


		for(int j=0; j<a.length; j++){
			System.out.printf("%3d|",j);


			for(int i=0; i<a[j].length; i++){
					if(a[j][i] == 1){
					System.out.print(" R "+"|");
					}
					else if(a[j][i] == 2){
						System.out.print(" G "+"|");
					}
					else
						System.out.print("   "+"|");
			}
			System.out.println(" ");
		}
	}

}
