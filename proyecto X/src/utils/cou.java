package utils;

public class cou {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String x="U0001";
		
		System.out.println();
			String cad = "Programador";
			
			//p r o g r a m a d o r
			//0 1 2 3 4 5 6 7 8 9 10
			System.out.println(cad.length());
			//impreme en la posicion indicada
			System.out.println(cad.charAt(6));
			
			System.out.println(cad.equals("programador"));
			
			//imprime la primera ubicacion del caracter
			System.out.println(cad.indexOf('r'));
			//busca desde la posicion que indicamos
			System.out.println(cad.indexOf('r', 2));
			System.out.println(cad.indexOf("ma"));
			//busca desde elultimo
			System.out.println(cad.lastIndexOf("ra"));
			System.out.println(cad.lastIndexOf('a'));
			
			System.out.println(cad.toLowerCase());
			System.out.println(cad.toUpperCase());
			//
			String cad2= "          Enanos chascocos";
			System.out.println(cad2.length());
			System.out.println(cad2.trim());
			//substrate desde la posicion que le indicamos
			System.out.println(cad.substring(3));
			System.out.println(cad.substring(2,5));
			//remplaza caracteres
			System.out.println(cad.replace('a', 'x'));
			System.out.println(cad.replace("dor", "ción"));
			//verifucar que sea el ultimo caracter
			System.out.println(cad.endsWith("r"));
			System.out.println(cad.startsWith("P"));
			
			String nom="luis,pedro,fernandez,luz,ana,maria";
			System.out.println(nom.length());
			
			

	}
}
