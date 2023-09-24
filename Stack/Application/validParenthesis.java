package Stack.Application;

import java.util.Stack;

public class validParenthesis {
    public static void main(String[] args) {
        String s = "(a*{b+c)}";
        String para = "";
        for(int i =0; i < s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}'){
                para += c;
            }
        }
        Stack<Character> st = new Stack<> (); 
        for(int i =0; i < para.length();i++){
            char c = para.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                st.push(c);
            }
            else{
                if((st.peek() == '(' && c == ')') || (st.peek() == '{' && c == '}') || (st.peek() == '[' && c == ']')){
                    st.pop();
                }
                else{
                    System.out.println("Not Valid");
                    break;
                }
            }
        }
        System.out.println(st.empty());
    }
}
