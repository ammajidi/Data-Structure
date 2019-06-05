import java.util.Scanner;
public class HW <E> {
    static void solveHanoi(int n, String from, String temp, String to) {
        if (n == 1)
            System.out.println(from + " -------> " + to);
        else {
            solveHanoi(n - 1, from, to, temp);
            System.out.println(from + " -------> " + to);
            solveHanoi(n - 1, temp, from, to);
        }
    }
    static int awnser=0;
    static int toInt(String s) {
        if (s.length() == 0){
            System.out.println("you cant milk the bull");
            return 0;
        }
        if(s.substring(0,1).equals("-")){
            //System.out.println(s);
            s=s.substring(1,s.length());
            return toInt(s)*-1;
        }
        else {

            if (s.length() == 1) {
                // System.out.println(s);
                awnser = (awnser * 10) + Integer.parseInt(s);
                //System.out.println(awnser);
                return awnser;
            } else {
                //System.out.println(awnser);
                awnser = (awnser * 10) + Integer.parseInt(s.substring(0, 1));
                return toInt(s.substring(1, s.length()));
            }
        }
    }
    public static int sum(int[][] matrix) {
        return sum (matrix, 0, 0, 0);
    }
    private static int sum(int[][] matrix, int awnser, int i, int j) { // simply like navigating in 2d array

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        if (i == matrix.length) {
            return awnser;
        }
        if (j ==  matrix[0].length) {
            return sum(matrix, awnser, i + 1, 0);
        }
        return sum(matrix,awnser + matrix[i][j], i, j + 1);

    }
    public static void main(String[] args) {
        //solveHanoi(3, "A", "B", "C");
        //int[][] m={{1,2,3,4},{1,0,0,0},{1,1,1,1}};
        //System.out.println(sum(m));
        Scanner s=new Scanner(System.in);
        System.out.println("Enter N and N^2 (both positive): ");
        int n=s.nextInt();
        int n2=s.nextInt();
        if(!(n>0&&n2>0))
            System.out.println("The input is erroneous.");
        else{
            //nextSquare
            for(int i=1;i<6;i++){
                System.out.println(nextSquare(n,n2));
                n=n+i;
                n2=n*n;

            }
        }


    }
    static int nextSquare(int x,int x2) {
        return x2 + x + (x + 1);
    }

}

