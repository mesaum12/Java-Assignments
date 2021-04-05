package java_assignments;

import java.util.Scanner;
import java.lang.String;

class Stack
{
    private int tos;
    private char[] stack;
    Stack()
    {
        tos=-1;
        stack=new char[100];
    }
    public void push(char element)
    {
        if(tos==99)
            System.out.println("Stack Overflow");
        else
            stack[++tos]=element;
    }
    public char pop()
    {
        return stack[tos--];
    }
    boolean isEmpty()
    {
        return (tos==-1);
    }
}
class CheckBalanceBrackets
{
    public boolean solve(String str)
    {
        Stack s=new Stack();
        char choice,c;
        for(int i=0;i<str.length();i++)
        {
            choice=str.charAt(i);
            switch(choice)
            {
                case '(':
                case '[':
                case '{':
                    s.push(choice);
                    break;
                case ')':
                    c=s.pop();
                    if(c!='(')
                        return false;
                    break;
                case '}':
                    c=s.pop();
                    if(c!='{')
                        return false;
                    break;
                case ']':
                    if((c=s.pop())!='[')
                        return false;
                    break;
            }
        }
        if(s.isEmpty())return true;
        return false;
    }
}
public class Parentheses {
    public static void main(String[] args) {
        System.out.println("Enter the string which we want to check balanced brackets for:");
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();//taking the string input
        CheckBalanceBrackets c=new CheckBalanceBrackets();
        System.out.println(c.solve(str));
    }
}
