import java.util.ArrayList;
import java.util.List;

public class Converter {

	public static void main(String[] args) {
		
		System.out.println(converterCamelCase("nome"));
		System.out.println(converterCamelCase("Nome"));
		System.out.println(converterCamelCase("nomeComposto"));
		System.out.println(converterCamelCase("NomeComposto"));
		System.out.println(converterCamelCase("CPF"));
		System.out.println(converterCamelCase("numeroCPF"));
		System.out.println(converterCamelCase("numeroCPFContribuinte"));
		System.out.println(converterCamelCase("recupera10Primeiros"));
		System.out.println(converterCamelCase("10Primeiros"));
		System.out.println(converterCamelCase("nome#Composto"));

	}
	
	
	public static List<String> converterCamelCase(String original) {
		
		List<String> list = new ArrayList<String>();				
		String[] letters;	
		
		boolean hasANumber = temNumero(original);
		String[] palavras = dividirTexto(hasANumber, original);
				
		for (String letter : palavras) {
			list.add(letter.toLowerCase());
		}
		return list;
		
	}
	
	static boolean temNumero(String original) {
		char[] c = original.toCharArray();
		boolean hasANumber = false;
		for ( int i = 0; i < c.length; i++ ) {
		    if ( Character.isDigit(c[i])) {
		        hasANumber = true;
		        break;
		    }
		}
		return hasANumber;
	}
	
	static String[] dividirTexto(boolean hasANumber, String original) {
		String reg = "(?=[A-ZÀ-Ú])";
		String reg2 = "([^0-9]+)";
		String reg3 = "(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)";
		String[] letters;
		if(hasANumber) {
			letters = original.split(reg3);
		} else {
			letters = original.split(reg);
		}
		
		return letters;
	}
	
	
	
	
}
