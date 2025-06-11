package projeto_POO;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;


public class Main {
	
	
    public static void main(String[] args) {
    	Scanner ler = new Scanner(System.in);
    	Scanner continuar = new Scanner(System.in);
        int op;
        int opCredencial = 0;
        boolean sucesso = false;
        boolean existe = false;
        ArrayList<Instituicao> instituicoes = new ArrayList<>();
        ArrayList<String> listaDicasAgua = new ArrayList<>();
        ArrayList<String> listaDicasEnergia = new ArrayList<>();
        
        do {
        	System.out.println("Seja bem vindo!\n");
        	do {
        	    System.out.println("1- Utilizador.");
        	    System.out.println("2- Adminisstrador de Sistema");
        	    System.out.println("3- Gestor de Sistema.");
        	    System.out.println("0- Sair");
        	    System.out.println("\nQual a sua credencial?");

        	    try{
        	        opCredencial = ler.nextInt();
        	        sucesso = true;
        	    }catch(Exception e){
        	        System.out.println("Por favor, escreva um número.\nClique enter para continuar...");
        	        sucesso = false;
        	        continuar.nextLine();
        	    }
        	    if(sucesso){
        	        sucesso = false;
        	        if(opCredencial < 0 || opCredencial > 3){
        	            System.out.println("Por favor, escreva um número presente no menu.\nClique enter para continuar...");
        	            opCredencial = 0;
            	        continuar.nextLine();
        	        }else{
        	            sucesso = true;
        	        }
        	    }
        	}while(!sucesso);
        	
        	switch(opCredencial) {
        	case 1: //Utilizador
        			do {
        				System.out.println("----------MENU----------");
        				System.out.println("1- Dicas de consumo.");
        	            System.out.println("0- SAIR.");
        	            try{
                	        op = ler.nextInt();
                	        sucesso = true;
                	    }catch(Exception e){
                	        System.out.println("Por favor, escreva um número.\nClique enter para continuar...");
                	        sucesso = false;
                	        continuar.nextLine();
                	    }
                	    if(sucesso){
                	        sucesso = false;
                	        if(op < 0 || op > 1){
                	            System.out.println("Por favor, escreva um número presente no menu.\nClique enter para continuar...");
                	            op = 0;
                	            continuar.nextLine();
                	        }else{
                	            sucesso = true;
                	        }
                	    }
                	switch(op) {
        	        	case 1:
        	        		int opdicastipo = 0;
        	        		do {	
        	        			ler.nextLine();
        		        		System.out.println("Qual tipo de dicas deseja observar?\n1-Água\n2-Energia");
        		        		try{
        		        			opdicastipo = ler.nextInt();
        			    	        sucesso = true;
        			    	    }catch(Exception e){
        			    	        System.out.println("Por favor, escreva um número.\nClique enter para continuar...");
        			    	        sucesso = false;
        			    	        opdicastipo = 0;
        			    	        continuar.nextLine();
        			    	    }
        			    	    if(sucesso){
        			    	        sucesso = false;
        			    	        if(opdicastipo < 1 || opdicastipo > 2){
        			    	            System.out.println("Por favor, escreva um número presente no menu.\nClique enter para continuar...");
        			    	            opdicastipo = 0;
        			    	            continuar.nextLine();
        			    	        }else{
        			    	            sucesso = true;
        			    	        }
        			    	    }
        	        		}while(sucesso != true);
        	        		
        	        		switch(opdicastipo) {
        		        		case 1:
        		        			System.out.println("Dicas do tipo água!");
        			        		for(String i : listaDicasAgua) {
        			        			System.out.println(i);
        			        		}
        			        		System.out.println("\nClique enter para continuar...");
        			        		continuar.nextLine();
        		        			break;
        		        		case 2:
        		        			System.out.println("Dicas do tipo energia!");
        			        		for(String i : listaDicasEnergia) {
        			        			System.out.println(i);
        			        		}
        			        		System.out.println("\nClique enter para continuar...");
        			        		continuar.nextLine();
        		        			break;
        		        		default:
        		        			System.out.println("Opção inválida, tente denovo!\nClique enter para continuar...");
        		            		continuar.nextLine();
        		            		break;
        	        		}
        	        		break;
        	        	case 0:
        	        		System.out.println("Até à proxima! 😀");
        	                break;
        	            default:
        	                System.out.println("Opção inválida, tente denovo!\nClique enter para continuar...");
        	                continuar.nextLine();
        	        		break;
        	        	}
        			}while(op != 0);
        			break;
        	case 2:
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
                    	break;
                    	
                    case 9:
                    	
                    	Sistema.editarZona();
                    	break;
                    	
                    case 10: 
                    	
                    	Sistema.editarSensor();
                    	break;
                    	
                    case 11:
                    	
                    	Sistema.consultarConsumo();
                    	break;
                    	
                    case 12:
                    	
            	        Sistema.consultarMedia(instituicoes);
                    	break;
                    	
                    case 0:
                    	
                    	System.out.println("Até à proxima! 😀");
                        break;
                    default:
                        System.out.println("Opção inválida, tente denovo!");
                        break;
                    }
                    
                }while(op != 0);
        		break;
        	case 3: //Gestor de Sistema
        		do {
        			do {
            			ler.nextLine();
        	    		System.out.println("----------MENU----------");
        				System.out.println("1- Adicionar/Observar Dicas.");
        				System.out.println("2- Monitorizar limites e picos.");
        				System.out.println("3- Consultar média de consumo.");
        				System.out.println("0- SAIR.");
        				try{
        	    	        op = ler.nextInt();
        	    	        sucesso = true;
        	    	    }catch(Exception e){
        	    	        System.out.println("Por favor, escreva um número.\nClique enter para continuar...");
        	    	        sucesso = false;
        	    	        continuar.nextLine();
        	    	    }
        	    	    if(sucesso){
        	    	        sucesso = false;
        	    	        if(op < 0 || op > 3){
        	    	            System.out.println("Por favor, escreva um número presente no menu.\nClique enter para continuar...");
        	    	            continuar.nextLine();
        	    	        }else{
        	    	            sucesso = true;
        	    	        }
        	    	    }
            		}while(sucesso != true);	     
            		switch(op) {
        		        case 1:
        		        	int opdicas = 0;
        		        	do {
        		        		ler.nextLine();
        		        		System.out.println("Deseja adicionar ou observar as dicas presentes?\n1- Adicionar\n2- Observar");
        			        	try{
        			        		opdicas = ler.nextInt();
        				    	    sucesso = true; 
        			        	}catch(Exception e){
        			    	        System.out.println("Por favor, escreva um número.\nClique enter para continuar...");
        			    	        sucesso = false;
        			    	        continuar.nextLine();
        			    	    }
        			    	    if(sucesso){
        			    	        sucesso = false;
        			    	        if(opdicas < 1 || opdicas > 2){
        			    	            System.out.println("Por favor, escreva um número presente no menu.\nClique enter para continuar...");
        			    	            opdicas = 0;
        			    	            continuar.nextLine();
        			    	        }else{
        			    	            sucesso = true;
        			    	        }
        			    	    }
        	        		}while(sucesso != true);
        	        		switch(opdicas){
        		        		case 1:
        		        			int optipo = 0;
        		        			do {
        		        				ler.nextLine();
        			        			System.out.println("Qual o tipo de dica?\n1-Água\n2-Energia");
        			        			try{
        					    	        optipo = ler.nextInt();
        					    	        ler.nextLine();
        					    	        sucesso = true;
        					    	    }catch(Exception e){
        					    	        System.out.println("Por favor, escreva um número.\nClique enter para continuar...");
        					    	        sucesso = false;
        					    	        continuar.nextLine();
        					    	    }
        					    	    if(sucesso){
        					    	        sucesso = false;
        					    	        if(optipo < 1 || optipo > 2){
        					    	            System.out.println("Por favor, escreva um número presente no menu.\nClique enter para continuar...");
        					    	            optipo = 0;
        					    	            continuar.nextLine();
        					    	        }else{
        					    	            sucesso = true;
        					    	        }
        					    	    }
        		        			}while(sucesso != true);
        		        			
        			        		String dica = "";
        			        		do {
        			        			System.out.println("Escreva a dica (máximo 100 caracters): ");
        			        			dica = ler.nextLine(); 
        			        			if(dica.length() > 100) {
        			        				System.out.println("A dica tem no máximo 100 caracteres!\nClique enter para continuar...");
        				    	            continuar.nextLine();
        			        			}
        			        		}while(dica.length() > 100);
        			        		switch(optipo) {
        			        		case 1:
        				        		listaDicasAgua.add(dica);
        				        		System.out.println("Dica adicionada com sucesso!\nClique enter para continuar...");
        			    	            continuar.nextLine();
        			        			break;
        			        		case 2:
        				        		listaDicasEnergia.add(dica);
        				        		System.out.println("Dica adicionada com sucesso!\nClique enter para continuar...");
        			    	            continuar.nextLine();
        			        			break;
        			        		default:
        			        			System.out.println("Opção inválida, tente denovo!\nClique enter para continuar...");
        			            		continuar.nextLine();
        			            		break;
        			        		}
        			        		break;
        		        		case 2:
        		        		int optipover = 0;
        		        		do {	
        		        			ler.nextLine();
        			        		System.out.println("Qual tipo de dicas deseja observar?\n1-Água\n2-Energia");
        			        		try{
        			        			optipover = ler.nextInt();
        				    	        sucesso = true;
        				    	    }catch(Exception e){
        				    	        System.out.println("Por favor, escreva um número.\nClique enter para continuar...");
        				    	        sucesso = false;
        				    	        continuar.nextLine();
        				    	    }
        				    	    if(sucesso){
        				    	        sucesso = false;
        				    	        if(optipover < 1 || optipover > 2){
        				    	            System.out.println("Por favor, escreva um número presente no menu.\nClique enter para continuar...");
        				    	            optipover = 0;
        				    	            continuar.nextLine();
        				    	        }else{
        				    	            sucesso = true;
        				    	        }
        				    	    }
        		        		}while(sucesso != true);
        		        		
        		        		switch(optipover) {
        			        		case 1:
        			        			System.out.println("Dicas do tipo água!");
        				        		for(String i : listaDicasAgua) {
        				        			System.out.println(i);
        				        		}
        				        		System.out.println("\nClique enter para continuar...");
        				        		continuar.nextLine();
        			        			break;
        			        		case 2:
        			        			System.out.println("Dicas do tipo energia!");
        				        		for(String i : listaDicasEnergia) {
        				        			System.out.println(i);
        				        		}
        				        		System.out.println("\nClique enter para continuar...");
        				        		continuar.nextLine();
        			        			break;
        			        		default:
        			        			System.out.println("Opção inválida, tente denovo!\nClique enter para continuar...");
        			            		continuar.nextLine();
        			            		break;
        		        		}
        		        		break;
        		            default:
        		            	System.out.println("Opção inválida, tente denovo!\nClique enter para continuar...");
        		            	continuar.nextLine();
        		            	break;
        		        	}
        	        		break;
        		        case 0:
        		        	System.out.println("Até à proxima! 😀");
        		    		ler.close();
        		    		continuar.close();
        		            break;
        		        default:
        	        		System.out.println("Opção inválida, tente denovo!\nClique enter para continuar...");
        	        		continuar.nextLine();
        	        		break;
        			}
        		}while(op != 0);
        		break;
        	case 0:
        		System.out.println("Até à proxima! 😀");
        		ler.close();
        		continuar.close();
                break;
        	default:
        		System.out.println("Opção inválida, tente denovo!\nClique enter para continuar...");
        		continuar.nextLine();
        		break;
        	}
        }while(opCredencial != 0);   
    }
}    
    