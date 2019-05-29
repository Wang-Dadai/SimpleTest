package TestPackage;

import java.util.Scanner;
import java.util.Stack;

import TestModle.StackByListTest;

public class StackTest {
	
	public static void main(String[] args) {
		
		testStackByList();
		
		System.out.println("输入表达式：");
		Scanner in = new Scanner(System.in);
		
		String expression = in.next();
		
		in.close();
		System.out.println(expression+"="+evaluate(expression));
		
	}

	public static String insertBlanks(String expression){
		
		String result = "";
		
		for(int i=0;i<expression.length();i++){
			
			if(expression.charAt(i)=='+' || expression.charAt(i)=='-'
					|| expression.charAt(i)=='*' || expression.charAt(i)==('/')
					|| expression.charAt(i)=='(' || expression.charAt(i)==(')')){
				result = result + " " + expression.charAt(i) + " ";
			}else{
				result = result + expression.charAt(i);
			}
		}
		
		return result;
		
	}
	
	public static void processOperator(Stack<Integer> operandStack,Stack<Character> operatorStack){
		
		char op = operatorStack.pop();
		int op1 = operandStack.pop();
		int op2 = operandStack.pop();
		
		if(op=='+'){
			operandStack.push(op2+op1);
		}else if(op=='-'){
			operandStack.push(op2-op1);
		}else if(op=='*'){
			operandStack.push(op2*op1);
		}else if(op=='/'){
			operandStack.push(op2/op1);
		}
		
	}
	
	public static Integer evaluate(String expression){
		
		Stack<Integer> operandStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();
		
		expression = insertBlanks(expression);
		String[] tokens = expression.split(" ");
		
		for(String token : tokens){
			if(token.length()==0){
				continue;
			}else if(token.charAt(0)=='+' || token.charAt(0)=='-'){
				
				while(!operatorStack.isEmpty() && (operatorStack.peek() == '+' 
						|| operatorStack.peek() == '-' || operatorStack.peek() == '*'
						|| operatorStack.peek() == '/')){
					
					processOperator(operandStack, operatorStack);
					
				}
				
				operatorStack.push(token.charAt(0));
			}else if(token.charAt(0)=='*' || token.charAt(0)=='/'){
				
				while(!operatorStack.isEmpty() && (operatorStack.peek()=='*' || operatorStack.peek()=='/')){
					
					processOperator(operandStack, operatorStack);
				}
				
				operatorStack.push(token.charAt(0));
			}else if(token.charAt(0)=='('){
				
				operatorStack.push('(');
			}else if(token.charAt(0)==')'){
				
				while(!operatorStack.isEmpty() && (operatorStack.peek()!='(')){
					
					processOperator(operandStack, operatorStack);
				}
				
				operatorStack.pop();
			}
			else{
				operandStack.push(Integer.parseInt(token));
			}
			
			
		}
		
		while(!operatorStack.isEmpty()){
			
			processOperator(operandStack, operatorStack);
		}
		
		
		return operandStack.pop();
	}
	public static void testStackByList(){
		
		StackByListTest<String> stack = new StackByListTest<String>();
		stack.push("asdfa");
		
		System.out.println(stack.isEmpty());
	}
	
	
	
}
