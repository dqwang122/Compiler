class Fmain{
    public static void main(String[] a){
	System.out.println(new F().func(10));
    }
}

class F {
    public int func(int num){
        int a;
        F b;
        b = new F();
        a = num;
        return b.get(10);
    }
}
