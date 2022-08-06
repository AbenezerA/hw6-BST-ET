/* Abenezer Amanuel
 * ata2152
 * 3/19/2022
 * This class creates an expression tree from its postfix expression,
 * evaluates its value, prints its prefix, postfix and infix epressions
*/

import java.util.LinkedList;

public class ExpressionTree implements ExpressionTreeInterface {

    private ExpressionNode root;
    private LinkedList<ExpressionNode> expStack;
    private String postfixString = "";
    private String prefixString = "";
    private String infixString = "";

    //constructs an expression tree from a passed-in postfix expression
    public ExpressionTree(String expression) {

        root = null;
        String[] tokens = (expression.trim()).split(" ");

        if(tokens.length == 1 && tokens[0] == "" || (tokens == null))
            return ;

        expStack = new LinkedList<ExpressionNode>();

        //we utilize the push and pop methods of java.util.LinkedList itself
        for(String s : tokens) {
            //if the token is an operator string, push it as an operator node 
            //with operand nodes as its children
            if(s.equals("+") || s.equals("-") || s.equals("*") || 
                                                 s.equals("/")) {
                char charVal = s.charAt(0);
                ExpressionNode temp2 = new ExpressionNode();
                temp2.operator = charVal;
                
                if(expStack.size() <= 1)
                    throw new RuntimeException("Stack Underflow: Missing" +
                                                    " operand(s)!");

                temp2.right = expStack.pop();
                temp2.left = expStack.pop();
                expStack.push(temp2);

            } else {
                //if the token is an integer, push it as an operand node
                int intVal = Integer.parseInt(s);
                ExpressionNode temp = new ExpressionNode();
                temp.operand = intVal;
                expStack.push(temp);
            }
        }   

        //set the root of the tree; if nodes remain, print an error
        root = expStack.pop();
        if(!(expStack.isEmpty())) {
            throw new RuntimeException("Non-empty Stack: Missing" +
                                                " operator(s)!");
        }

    }

    //public driver for eval
    public int eval() {
        return eval(root);
    }

    //recursively sends operands and operators to apply() to be evaluated
    private int eval(ExpressionNode t) {
        if(t == null)
            return 0;

        if(t.left == null && t.right == null)
            return t.operand;
        
        int lval = eval(t.left);
        int rval = eval(t.right);

        return apply(t.operator, lval, rval);

    }

    //applies the operation to evaluate the expression
    public int apply(char opr, int leftOpd, int rightOpd) {

        switch(opr) {

            case '+' : return leftOpd + rightOpd;

            case '-' : return leftOpd - rightOpd;

            case '*' : return leftOpd * rightOpd;

            case '/' : return leftOpd / rightOpd;

            default  : throw new RuntimeException("Invalid Operator!");

        }
    }

    //public driver for postfix
    public String postfix() {
        postfixString = "";
        return postfix(root);
    }

    //recursively builds up the postfix expression then returns it
    private String postfix(ExpressionNode t) {

        if(t != null) {
            postfix(t.left);
            postfix(t.right);
            
            if(t.left == null && t.right == null)
                postfixString += Integer.toString(t.operand) + " ";
            else
                postfixString += Character.toString(t.operator) + " ";
        }
        //removes any extraneous white space before returning
        return postfixString.trim();

    }

    //public driver for prefix
    public String prefix() {
        prefixString = "";
        return prefix(root);
    }

    //recursively builds up the prefix expression then returns it
    private String prefix(ExpressionNode t) {

        if(t != null) {
            if(t.left == null && t.right == null)
                prefixString += Integer.toString(t.operand) + " ";
            else
                prefixString += Character.toString(t.operator) + " ";
            
            prefix(t.left);
            prefix(t.right);            
        }
        //removes any extraneous white space before returning
        return prefixString.trim();

    }

    //public driver for infix
    public String infix() {
        infixString = "";
        return infix(root);
    }

    //recursively builds up the infix expression then returns it
    private String infix(ExpressionNode t) {

        if(t != null) {
            infixString += "(";
            infix(t.left);

            if(t.left == null && t.right == null)
                infixString += Integer.toString(t.operand);
            else
                infixString += " " + Character.toString(t.operator) + " ";
            
            infix(t.right);
            infixString.trim();
            infixString += ")";           
        }
        return infixString;

    }
    //static nested class for constructing nodes
    static class ExpressionNode {
        
        ExpressionNode left;
        ExpressionNode right;
        int operand;
        char operator;

        public ExpressionNode() {
            left = null;
            right = null;
        }

        //(for testing purposes) prints legible info about a specific node
        public String toString() {
            if(left == null && right == null)
                return "Operand node: " + operand;
            else
                return "Operator node: " + left + " " + operator + " "
                        + right;
        }

    }

}