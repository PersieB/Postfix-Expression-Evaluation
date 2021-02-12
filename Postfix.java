import java.util.Scanner;
public class Postfix {
    public static void main(String[] args){
        // New stack object of integer type
        Stack<Integer> my_new_stack = new Stack<Integer>();
        // Taking expression from user
        System.out.println("Enter a valid postfix expression with spaces between tokens: ");
        Scanner input = new Scanner(System.in);
        String user_expression = input.nextLine();
        // Splitting the expression by spaces into an array
        String[] tokens = user_expression.split(" ");
        for(int i = 0; i < tokens.length; i++){
            String character = tokens[i];
            //if string in the array is an operator
            if(character.equals("+") || character.equals("-") || character.equals("/") || character.equals("*")){
                //pop the last two numbers
                int previous_1 = my_new_stack.pop();
                int previous_2 = my_new_stack.pop();
                // apply the appropriate operator
                switch(character){
                    case"+":
                    my_new_stack.push(previous_2 + previous_1);
                    break;
                    case"-":
                    my_new_stack.push(previous_2 - previous_1);
                    break;
                    case"/":
                    my_new_stack.push(previous_2 / previous_1);
                    break;
                    case"*":
                    my_new_stack.push(previous_2 * previous_1);
                    break;
                }
            }else{
                //if string in the array is an operand
                // convert to integer and push into stack
                int operand = Integer.parseInt(character);
                my_new_stack.push(operand);
            }
        }System.out.println(my_new_stack.top());            //prints final the result of the operation performed
    }
}
