public class ETTest {

    public static void main(String[] args) {

        ExpressionTree et = new ExpressionTree("2 12 6 / *");
        System.out.println("eval: [" + et.eval() + "]");
        //System.out.println("eval: [" + et.eval() + "]");
        System.out.println("postfix: [" + et.postfix() + "]");
        //System.out.println("postfix: [" + et.postfix() + "]");
        //System.out.println("infix: [" + et.infix() + "]");
        System.out.println("prefix: [" + et.prefix() + "]");
        //System.out.println("prefix: [" + et.prefix() + "]");
        System.out.println("infix: [" + et.infix() + "]");
        //System.out.println("infix: [" + et.infix() + "]");

    }

}