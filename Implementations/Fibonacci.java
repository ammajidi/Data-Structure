public class Fibonacci {
    private static int fib(int term, int result, int prev)
    {
        if(term == 0) return prev;
        if(term == 1) return result;
        return fib(term - 1, result+prev, result);
    }
    public static int fibo(int term){

        return fib(term,1,0);

    }
    public static int fibn(int n){
        if(n<=1)
            return n;
        else
            return fibn(n-1)+ fibn(n-2);
    }
    public static void main(String[] args) {
        System.out.println(fibo(5));
        System.out.println(fibn(5));
    }
}
