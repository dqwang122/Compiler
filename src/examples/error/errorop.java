class Fmain{
    public static void main(String[] a){
	System.out.println(new F().func(10));
    }
}

class F {
    public int func(int num){
        int a;
        boolean b;
        a = 1;
        b = true;
        if(a + b)
            a = true;
        else
            a = false;
        return a;
    }
}
