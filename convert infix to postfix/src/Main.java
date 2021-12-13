import java.io.IOException;
import java.util.Scanner;
        public class Main {
            private Stack theStack;
            private String[] input;
            private String output = "";
            public Main(String[] in) {
                input = in;
                int stackSize = in.length;
                theStack = new Stack(stackSize);
            }
            public String doTrans() {
                for (int j = 0; j < input.length; j++) {
                    String ch = input[j];
                    switch (ch) {
                        case "+":
                        case "-":
                            gotOper(ch, 1);
                            break;
                        case "*":
                        case "/":
                            gotOper(ch, 2);
                            break;
                        case "(":
                            theStack.push(ch);
                            break;
                        case ")":
                            gotParen(ch);
                            break;
                        default:
                            output = output+ch+" ";
                            break;
                    }
                }
                while (!theStack.isEmpty()) {
                    String nop =theStack.pop();
                    if(!nop.equals("(") && !nop.equals(")"))
                    output = output+nop+" ";
                }
                System.out.println(output.substring(0,output.length()-1));
                return output;
            }
            public void gotOper(String opThis, int prec1) {
                while (!theStack.isEmpty()) {
                    String opTop = theStack.pop();
                    if (opTop.equals("(")) {
                        theStack.push(opTop);
                        break;
                    } else {
                        int prec2;
                        if (opTop.equals("+") || opTop.equals("-"))
                            prec2 = 1;
                        else
                            prec2 = 2;
                        if (prec2 < prec1) {
                            theStack.push(opTop);
                            break;
                        }
                        else output =output+opTop+" ";
                    }
                }
                theStack.push(opThis);
            }
            public void gotParen(String ch) {
                while (!theStack.isEmpty()) {
                    String ch2 = theStack.pop();
                    if (ch2.equals("("))
                        break;
                    else output=output+ch2+" ";
                }
            }
            public static void main(String[] args) throws IOException {
                int n;

                Scanner scanner=new Scanner(System.in);
                n=Integer.parseInt( scanner.nextLine());
                String[] x= new String[n];
                for (int i = 0; i <n ; i++) {
                     x[i] = scanner.next();
                }

                String output;
                Main theTrans = new Main(x);
                output = theTrans.doTrans();
            }
            class Stack {
                private int maxSize;
                private String[] stackArray;
                private int top;

                public Stack(int max) {
                    maxSize = max;
                    stackArray = new String[maxSize];
                    top = -1;
                }
                public void push(String j) {
                    stackArray[++top] = j;
                }
                public String pop() {
                    return stackArray[top--];
                }
                public String peek() {
                    return stackArray[top];
                }
                public boolean isEmpty() {
                    return (top == -1);
                }
            }
        }


