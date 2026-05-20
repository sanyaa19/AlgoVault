class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        if(x == 1) return 1.0;
        if(x == -1) return(n%2==0)? 1.0 : -1.0;

        double result =1;
        if(n<0){
            x = (1/x);
            n = -n;
        }
        while(n>0){
            if(n%2 != 0){
                result *= x;
            }
            x *= x;
            n/=2;
        }
        return result;
    }
}
