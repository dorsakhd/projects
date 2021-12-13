package ir.javacup.oo;

public class B extends A {
    @Override
    public String method2() {
         return(this.getClass().getSuperclass().getSimpleName()+1+this.getClass().getSimpleName()+2);
    }
}
