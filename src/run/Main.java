package run;

import java.util.ArrayList;
import java.util.Scanner;

import calculator.Element;
import calculator.List;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a expressão separando os números e as operações com espaços: ");

		String expression = sc.nextLine();
		sc.close();
		
		String[] expressionSplit = expression.split(" ");

		List<String> list = new List<String>();
		
		ArrayList<String> operators = new ArrayList<String>();
		
		operators.add("+");
		operators.add("-");
		operators.add("*");
		operators.add("/");
		
		// Adding vector elements to an Array list
		for (String x : expressionSplit) {
			list.add(x);
		}
		
		Element<String> lastElement = list.getLast() ;

		List<Double> finalList = new List<Double>();

		try {
			// If the last element of the list is a number there will be an error in the equation, so it's need to notify the user
			if (isNumeric(lastElement.getValue())) {
				System.out.println("o último elemento da equação não pode ser um número ");
				throw new Exception();
			}
			// If the first element of the list is an operator there will be an error in the equation, so it is need to notify the user
			if (operators.contains(list.getFirst().getValue())) {
				System.out.println("o primeiro  elemento da equação não pode ser uma operação ");
				throw new Exception();
			}

			// Go through the equation list and do your operations
			for (int i = 0; i < list.getSize(); i++) {
				
				if(finalList.getSize()>20) { 
					System.out.println("A Pilha de cálculo chegou no limite! Espaço insuficiente.");
					throw new Exception();
				}
				
				int last = finalList.getSize() - 1;
				String currentValue = list.get(i).getValue();
				
				if(finalList.getSize() < 2 && operators.contains(currentValue)) {
					System.out.println("Erro na formatação dos dados!");
					throw new Exception();
				}

				if (isNumeric(currentValue)) {
					finalList.add(Double.parseDouble(currentValue));
					continue;
				} 
				
				if(!operators.contains(currentValue)) {
					break;
				}
				
				Double result = null;
				Double finalListLastValue = finalList.get(last).getValue();
				Double finalListPrevValue = finalList.get(last - 1).getValue();
				
				if(currentValue.equals("+")) 
					result = finalListLastValue + finalListPrevValue;
				
				if (currentValue.equals("-")) 
					result = finalListLastValue - finalListPrevValue;	
				
				if (currentValue.equals("*")) 
					result = finalListLastValue * finalListPrevValue;
				
				if (currentValue.equals("/")) 
					result = finalListLastValue / finalListPrevValue;
				
				finalList.removeByIndex(last);
				finalList.removeByIndex(last - 1);
				finalList.add(result);

			}
			if (finalList.getSize() == 1) {
				// Print of the final result of the equation
				System.out.println(finalList.get(0).getValue());
			} else {
				System.out.println("Erro de sintaxe, verifique a equação");
				throw new Exception();
			}
		} catch (Exception error) {
			
		}

	}

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
