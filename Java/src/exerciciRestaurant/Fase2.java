package exerciciRestaurant;

/**
 * FASE 2 (3 punts)
 * ● Amb un bucle for haurem d’omplir els dos arrays anteriorment creats. Afegirem el nom del plat i després el preu. (1 punt)
 * 
 * ● Un cop plens els dos arrays haurem de mostrar-los i preguntar que es vol per menjar, guardarem la informació en una List 
 * fent servir un bucle while. (1 punt)
 * 
 * ● Haurem de preguntar si es vol seguir demanant menjar. Podeu fer servir el sistema (1:Si / 0:No), per tant haureu de 
 * crear un altre variable int per guardar la informació. (1 punt)
 * 
 * @author Enric Comes
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fase2 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		int bitllet5EUR, bitllet10EUR, bitllet20EUR, bitllet50EUR, bitllet100EUR, bitllet200EUR, bitllet500EUR;
			
		int preuTotalMenjar;
			
		ArrayList<String> menuPlat = new ArrayList<>();
			
		ArrayList<Integer> preuPlat = new ArrayList<>();
		
		List<String> comanda = new ArrayList<>();
		
		String entradaComanda="";
		int entradaVoler;
			
		//Omplir els 2 arrays amb 1 bucle for
		for(int i=0; i < 5; i++) {
			if(i==0) {
				menuPlat.add("Sopa");
				preuPlat.add(5);
			}else if(i==1) {
				menuPlat.add("Arros");
				preuPlat.add(5);
			}else if(i==2) {
				menuPlat.add("Bistec");
				preuPlat.add(10);
			}else if(i==3) {
				menuPlat.add("Paella");
				preuPlat.add(15);
			}else if (i==4) {
				menuPlat.add("Canelons");
				preuPlat.add(10);
			}	
		}
			
		//Mostrar i preguntar
		System.out.print("Menú:\n");
		for(int i=0; i<5; i++) {
			System.out.println("- " + menuPlat.get(i) + " - " + preuPlat.get(i) + " euros.");
		}
		System.out.println("Què vols per menjar?");
			
		boolean voler=true;
		
		//Va demanant plats fins que no es volguin més
		while(voler) {
			
			entradaComanda = entrada.nextLine();
			comanda.add(entradaComanda);
			
			System.out.println("Vols seguir demanant menjar?(1:Si / 0:No)");
			entradaVoler = entrada.nextInt();
			entrada.nextLine(); //Netejar fluxe d'entrada de dades
			
			if(entradaVoler==0) voler=false;
		}
		
		entrada.close();//Es tanca l'scanner
	
	}

}
