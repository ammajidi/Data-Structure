/**here is a stack of N disks on the first of three poles (call
 them A, B and C) and your job is to move the disks from pole A to pole B without
 ever putting a larger disk on top of a smaller disk.*/
 class Hanoi {
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
            return 0;}
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
        solveHanoi(3, "A", "B", "C");
        int[][] m={{1,2,3,4},{1,0,0,0},{1,1,1,1}};
        System.out.println(sum(m));




        //        try {
//            System.out.print(toInt(s));
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }

    }


}