package utils;

public class Codigo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//remplaza caracteres
		String cad="U0001";
		int x=1;
		System.out.println(cad);
		System.out.println(cad.replace('1', '2'));
		//System.out.println(cad.replace("dor", "ci�n"));
		
		for (int i = 0; i < 20; i++) {
			System.out.println("cod : "+i);
			if (i==1) {
				System.out.println("sad "+i);;
			}
			else if(i<20) {
				i-=100;
			}
		}
	}

}
