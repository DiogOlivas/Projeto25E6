/**
 * 
 */
package Projeto;
import java.util.Scanner;

/**
 * 
 */
public class Main {
    public static void main(String[] args) {
    	Scanner ler = new Scanner(System.in);
    	int op;
    	do {
	    	System.out.println("----------MENU----------");
	    	System.out.println("1- .");
	    	System.out.println("2- .");
	    	System.out.println("3- .");
	    	System.out.println("4- .");
	    	System.out.println("5- .");
	    	System.out.println("6- .");
	    	System.out.println("7- .");
	    	System.out.println("8- .");
	    	System.out.println("0- SAIR.");
	    	op = ler.nextInt();
	    	switch(op) {
	    	case 1:
	    		System.out.println("Teste");
	    		break;
	    	case 2:
	    		System.out.println("Teste2");
	    		break;
	    	case 3:
			System.out.println("Teste3");
	    		
	    		break;
	    	case 4:
	    		
	    		break;
	    	case 5:
	    		
	    		break;
	    	case 6:
	    		
	    		break;
	    	case 7:
	    		
	    		break;
	    	case 8:
	    		
	    		break;
	    	case 0:
	    		break;
	    	default:
	    		System.out.println("Opção inválida, tente denovo!");
	    		break;
	    	}
    	}while(op != 0);
    }
}
