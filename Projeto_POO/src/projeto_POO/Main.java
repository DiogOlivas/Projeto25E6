package projeto_POO;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;


public class Main {
	
	
    public static void main(String[] args) {
    	Scanner ler = new Scanner(System.in);
        int op;
        boolean existe = false;
        ArrayList<Instituicao> instituicoes = new ArrayList<>();
        
        do {
            System.out.println("----------MENU----------");
            System.out.println("1- Registrar Institucao .");
            System.out.println("2- Registrar Edificio.");
            System.out.println("3- Registrar Piso.");
            System.out.println("4- Registrar Zona");
            System.out.println("5- Registrar Sensor.");
            System.out.println("6- Registrar Leitura.");
            System.out.println("7- Editar o nome de uma instituição. ");
            System.out.println("8- Editar o nome de um edifício. ");
            System.out.println("9- Editar uma zona. ");
            System.out.println("10- Editar um sensor");
            System.out.println("11- Consultar Consumo.");
            System.out.println("0- SAIR.");
            op = ler.nextInt();
            
            switch(op) {
            
            case 1:
            	
            	Sistema.registrarInstituicao();
            	break;
            	
            case 2:
            	
            	Sistema.registrarEdificio();
            	break;
            	
            case 3:
            	
            	Sistema.registrarPiso();
            	break;
            	
            case 4:
            	
            	Sistema.registrarZona();
            	break;
            	
            case 5:
            		
            	Sistema.registrarSensor();	
            	break;
            	
            case 6:
            	
            	Sistema.registrarLeitura();
            	break;
            	
            case 7:
            	
            	Sistema.editarNomeInstitucao();
            	break;
            
            case 8: 
            	
            	Sistema.editarNomeEdificio();
            	
            case 9:
            	
            	Sistema.editarZona();
            	
            case 10: 
            	
            	Sistema.editarSensor();
            	
            case 11:
            	
            	Sistema.consultarConsumo();
            	
            case 0:
            	
            	System.out.println("Até à proxima! 😀");
                break;
            default:
                System.out.println("Opção inválida, tente denovo!");
                break;
            }
            
        }while(op != 0);
   
    }
}    
    