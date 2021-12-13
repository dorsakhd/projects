package ir.javacup.oo;

public class D extends B {
    @Override
    public String method2() {
        return(this.getClass().getSimpleName()+1+this.getClass().getSuperclass().getSimpleName()+2);
    }
}
