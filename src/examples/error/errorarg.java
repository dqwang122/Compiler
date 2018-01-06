class Fmain{
    public static void main(String[] a){
	System.out.println(new F().func(10));
    }
}

class F {

    public int func(int num){
        int a;
        boolean t;
        F b;
        b = new F();
        a = b.func(t);
        a = b.func(num, num);
        return num;
    }

}