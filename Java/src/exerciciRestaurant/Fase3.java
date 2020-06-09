package exerciciRestaurant;

/**
 * FASE 3 (5 punts)
 * 
 * ● Un cop hem acabat de demanar el menjar, haurem de comparar la llista amb l’array que hem fet al principi. 
 * En el cas que la informació que hem introduït a la List coincideixi amb la del array, haurem de sumar el preu
 * del producte demanat; en el cas contrari haurem de mostrar un missatge que digui que el producte que hem 
 * demanat no existeix.
 * 
 * Exercici:
 * L’exercici consisteix a mostrar per consola una carta d’un restaurant on afegirem diferents plats i després 
 * escollirem que volem per menjar. 
 * Un cop fet això s’haurà de calcular el preu del menjar el programa ens dirà amb quins bitllets hem de pagar.
 * 
 * @author Enric Comes
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fase3 {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		int bitllet5EUR, bitllet10EUR, bitllet20EUR, bitllet50EUR, bitllet100EUR, bitllet200EUR, bitllet500EUR;
			
		int preuTotalMenjar=0;
			
		ArrayList<String> menuPlat = new ArrayList<>();
			
		ArrayList<Integer> preuPlat = new ArrayList<>();
		
		List<String> comanda = new ArrayList<>();
		
		boolean voler=true;
		
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
			
		//Mostrar menú i preguntar
		System.out.print("Menú:\n");
		for(int i=0; i<5; i++) {
			System.out.println("- " + menuPlat.get(i) + " - " + preuPlat.get(i) + " euros.");
		}
		System.out.println("\nQuè vols per menjar?");
			
		
		
		//Va demanant plats fins que no es volguin més
		while(voler) {
			
			entradaComanda = entrada.nextLine();
			comanda.add(entradaComanda); //cada plat s'inclou al List de comanda
			
			System.out.println("Vols seguir demanant menjar?(1:Si / 0:No)");
			entradaVoler = entrada.nextInt(); //Ha de ser un número real
			entrada.nextLine(); //Netejar fluxe d'entrada de dades al entrar números per a evitar l'error del salt de línia
			
			//Si  es respon 0, es surt del while; sinó, es pregunta i se segueix demanant entrades
			if(entradaVoler==0) voler=false;
			else System.out.println("Què més vols?");
				
			
		}
		
		entrada.close();//Es tanca l'scanner		
		
		//Comparar List comanda amb l'Array menuPlat i suma preus al preuTotalMenjar
		for(int i=0; i<comanda.size(); i++) {
			
			for(int j=0; j < menuPlat.size(); j++) {
				
				//Quan hi hagi un plat de la comanda que coincideix amb un altre del menú, es suma el seu preu al total
				if(comanda.get(i).equals(menuPlat.get(j))) {
					preuTotalMenjar = preuTotalMenjar + preuPlat.get(j);
					j=menuPlat.size(); // Quan hagi sumat, es surt del bucle for de j adelantant iteracions de j
					
					//Si s'ha passat per tots els plats del menú i la iteració j és el total-1 del menú, s'informa de que el plat no existeix
				}else if (j == menuPlat.size() - 1) {
					System.out.println("El producte que heu demanat no existeix: ("+comanda.get(i)+")");
				}
				
			}
			
		}
		
		
		//Dir el preu total a pagar del menjar
		System.out.println("\nEl preu total a pagar és de: "+preuTotalMenjar);
		
		//Calcular amb quins bitllets i quants d'aquests es necessiten per a pagar el total del menjar
		
		int preuTotal = preuTotalMenjar; //es pot fer sense aquesta variable, però per si ens interessa mantenir el preu total original, fem còpia
		
		bitllet500EUR = preuTotal / 500; preuTotal = preuTotal%500;
		bitllet200EUR = preuTotal / 200; preuTotal = preuTotal%200;
		bitllet100EUR = preuTotal / 100; preuTotal = preuTotal%100;
		bitllet50EUR = preuTotal / 50; preuTotal = preuTotal%50;
		bitllet20EUR = preuTotal / 20; preuTotal = preuTotal%20;
		bitllet10EUR = preuTotal / 10; preuTotal = preuTotal%10;
		bitllet5EUR = preuTotal;
		
		System.out.println("\nBitllets d'Euro amb els que pots pagar:\n"+
							bitllet500EUR + " de 500\n"+
							bitllet200EUR + " de 200\n"+
							bitllet100EUR + " de 100\n"+
							bitllet50EUR + " de 50\n"+
							bitllet20EUR + " de 20\n"+
							bitllet10EUR + " de 10\n"+
							bitllet5EUR + " de 5");
		
	
	}

}
