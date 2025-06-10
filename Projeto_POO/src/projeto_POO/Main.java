package projeto_POO;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {	
    public static void main(String[] args) {
    	Scanner ler = new Scanner(System.in);
    	Scanner continuar = new Scanner(System.in);
        int op = 0;
        int opCredencial = 0;
        boolean sucesso = false;
        ArrayList<String> listaDicasAgua = new ArrayList<>();
        ArrayList<String> listaDicasEnergia = new ArrayList<>();
        ArrayList<Instituicao> instituicoes = new ArrayList<>();
        
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
			case 2: //Administrador do Sistema
				do {
			            do {
			            	System.out.println("----------MENU----------");
				            System.out.println("1- Registrar Institucao .");
				            System.out.println("2- Registrar Edificio.");
				            System.out.println("3- Registrar Piso.");
				            System.out.println("4- Registrar Zona");
				            System.out.println("5- Registrar Sensor.");
				            System.out.println("6- Registrar Leitura.");
				            System.out.println("7- Consultar Consumo.");
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
			        	        if(op < 0 || op > 7){
			        	            System.out.println("Por favor, escreva um número presente no menu.\nClique enter para continuar...");
			        	            op = 0;
			        	            continuar.nextLine();
			        	        }else{
			        	            sucesso = true;
			        	        }
			        	    }
			        	}while(!sucesso);
			            switch(op) {
			            
			            case 1:
			            	
			            	System.out.println("Nome da instituição: ");
			            	String nomeInstituicao = ler.next();
			            	Instituicao inst1 = existeInstituicao(nomeInstituicao, instituicoes);
			            	
			            	if(inst1 == null) {
			            		Instituicao instituicao = new Instituicao(nomeInstituicao);
			            		instituicoes.add(instituicao);
			            		System.out.println("Instituição registrada com sucesso!\nClique enter para continuar...");
			            		continuar.nextLine();
			            	}else {
			            		System.out.println("Esta instituição já existe!\nClique enter para continuar...");
			            		continuar.nextLine();
			            	}
			            	break;
			            	
			            case 2:
			            	
			            	System.out.println("Em que instituição deseja registrar o edifício?");
			            	String insedi2 = ler.next();
			            	Instituicao inst2 = existeInstituicao(insedi2, instituicoes);
			            	
			            	if(inst2 == null) {
			            		System.out.println("Esta instituição não existe!\nClique enter para continuar...");
			            		continuar.nextLine();
			            		break;
			            	}else if(inst2.getNome().equals(insedi2)) {
			            		System.out.println("Nome do edificio: ");
			            		String nomeEdificio = ler.next();
			            		if(inst2.existeEdificio(nomeEdificio) == null) {
			            			Edificio edificio = new Edificio(nomeEdificio);
			            			inst2.adicionarEdificio(edificio);
			            			System.out.println("Edificio adicionado com sucesso!\nClique enter para continuar...");
			            			continuar.nextLine();
			            		}else {
			            			System.out.println("Este edificio já existe!\nClique enter para continuar...");
			            			continuar.nextLine();
			            			break;
			            		}
			            	}
			            	break;
			            	
			            case 3:
			            	
			            	System.out.println("Em que instituição deseja guardar o edifício? ");
			            	String insedi3 = ler.next();
			            	Instituicao inst3 = existeInstituicao(insedi3, instituicoes);
			            	
			            	if(inst3 == null) {
			            		System.out.println("Esta instituição não existe!nClique enter para continuar...");
			            		continuar.nextLine();
			            		break;
			            	}else if(inst3.getNome().equals(insedi3)) {
			            		System.out.println("Em que edifício deseja guardar o piso? ");
			            		String nomeEdificio3 = ler.next();
			            		if(inst3.existeEdificio(nomeEdificio3) == null) {
			            			System.out.println("Este edificio não existe!\nClique enter para continuar...");
			            			continuar.nextLine();
			            		}else {
			            			System.out.println("Numero do piso: ");
			            			int numPiso = ler.nextInt();
			            			if(inst3.existeEdificio(nomeEdificio3).existePiso(numPiso) == null) {
			            				Piso piso = new Piso(numPiso);
			            				inst3.existeEdificio(nomeEdificio3).adicionarPiso(piso);
			            				System.out.println("Piso adicionado com sucesso!\nClique enter para continuar...");
			            				continuar.nextLine();
			            			}else {
			            				System.out.println("Este piso já existe!\nClique enter para continuar...");
			            				continuar.nextLine();
			            				break;
			            			}
			            		}
			            		break;
			            	}
			            	break;
			            	
			            case 4:
			            	
			            	System.out.println("Em que instituição deseja guardar a zona? ");
			            	String insedi4 = ler.next();
			            	Instituicao inst4 = existeInstituicao(insedi4, instituicoes);
	
			            	if (inst4 == null) {
			            	    System.out.println("Esta instituição não existe!");
			            	    break;
			            	} else if (inst4.getNome().equals(insedi4)) {
			            	    System.out.println("Em que edifício deseja guardar a zona? ");
			            	    String nomeEdificio4 = ler.next();
	
			            	    if (inst4.existeEdificio(nomeEdificio4) == null) {
			            	        System.out.println("Este edificio não existe!\nClique enter para continuar...");
			            	        continuar.nextLine();
			            	        break;
			            	    } else {
			            	        System.out.println("Em qual piso deseja guardar a zona?");
			            	        int numPiso = ler.nextInt();
	
			            	        if (inst4.existeEdificio(nomeEdificio4).existePiso(numPiso) == null) {
			            	            System.out.println("Este piso não existe!\nClique enter para continuar...");
			            	            continuar.nextLine();
			            	            break;
			            	        } else {
			            	            System.out.println("Nome da zona: ");
			            	            String nomeZona = ler.next();
	
			            	            if (inst4.existeEdificio(nomeEdificio4).existePiso(numPiso).existeZona(nomeZona) == null) {
			            	                Zona zona = new Zona(nomeZona);
			            	                inst4.existeEdificio(nomeEdificio4).existePiso(numPiso).adicionarZona(zona);
			            	                System.out.println("Zona adicionada com sucesso!\nClique enter para continuar...");
			            	                continuar.nextLine();
			            	            } else {
			            	                System.out.println("Esta zona já existe!\nClique enter para continuar...");
			            	                continuar.nextLine();
			            	            }
			            	        }
			            	    }
			            	}
			            	break;
			           
			            	case 5:
			            		
			            		System.out.println("Em que instituição deseja guardar o sensor? ");
			            		String insedi5 = ler.next();
			            		Instituicao inst5 = existeInstituicao(insedi5, instituicoes);
	
			            		if (inst5 == null) {
			            		    System.out.println("Esta instituição não existe!\nClique enter para continuar...");
			            		    continuar.nextLine();
			            		    break;
			            		} else if (inst5.getNome().equals(insedi5)) {
			            		    System.out.println("Em que edifício deseja guardar o sensor? ");
			            		    String nomeEdificio5 = ler.next();
	
			            		    if (inst5.existeEdificio(nomeEdificio5) == null) {
			            		        System.out.println("Este edificio não existe!\nClique enter para continuar...");
			            		        continuar.nextLine();
			            		        break;
			            		    } else {
			            		        System.out.println("Em qual piso deseja guardar o sensor?");
			            		        int numPiso = ler.nextInt();
	
			            		        if (inst5.existeEdificio(nomeEdificio5).existePiso(numPiso) == null) {
			            		            System.out.println("Este piso não existe!\nClique enter para continuar...");
			            		            continuar.nextLine();
			            		            break;
			            		        } else {
			            		            System.out.println("Nome da zona: ");
			            		            String nomeZona = ler.next();
	
			            		            if (inst5.existeEdificio(nomeEdificio5).existePiso(numPiso).existeZona(nomeZona) == null) {
			            		                System.out.println("Esta zona não existe!\nClique enter para continuar...");
			            		                continuar.nextLine();
			            		                break;
			            		            } else {
			            		                System.out.println("id do Sensor:");
			            		                int idSensor = ler.nextInt();
	
			            		                if (inst5.existeEdificio(nomeEdificio5).existePiso(numPiso).existeZona(nomeZona).existeSensor(idSensor) == null) {
			            		                    System.out.println("Tipo de sensor: ");
			            		                    String tipoSensor = ler.next();
			            		                    double limiteSup = 0;
			            		                    double limiteInf = 0;
			            		                    do{
			            		                    	try{
			            		                    		System.out.println("Qual o limite superior do sensor?");
														    limiteSup = ler.nextDouble();
														    sucesso = true;
			            		                    	}catch(Exception e){
														    System.out.println("Por favor, escreva um número.\nClique enter para continuar...");
														    continuar.nextLine();
													    }
			            		                    }while(sucesso != true);
													sucesso = false;
			            		                    do{
			            		                    	try{
			            		                    		System.out.println("Qual o limite inferior do sensor?");
			            		                    		limiteInf = ler.nextDouble();
			            		                    		sucesso = true;
			            		                    	}catch(Exception e){
			            		                    		System.out.println("Por favor, escreva um número.\nClique enter para continuar...");
			            		                    		continuar.nextLine();
			            		                    	}
			            		                    }while(sucesso != true);
			            		                    Sensor sensor = new Sensor(idSensor, tipoSensor, limiteSup, limiteInf);
			            		                    inst5.existeEdificio(nomeEdificio5).existePiso(numPiso).existeZona(nomeZona).addSensor(sensor);
			            		                    System.out.println("Sensor registrado com sucesso!\nClique enter para continuar...");
			            		                    continuar.nextLine();
			            		               } else {
			            		                    System.out.println("Este sensor já existe!\nClique enter para continuar...");
			            		                    continuar.nextLine();
			            		                    break;
			            		                }
			            		            }
			            		        }
			            		    }
			            		}
			            		break;
			            	
			            	 case 6:
			            	
			            	System.out.println("id do sensor: ");
			            	int idSensor = ler.nextInt();
			            	Sensor s = encontrarSensorId(idSensor, instituicoes);
			            	if(s == null) {
			            		System.out.println("Este sensor não existe!\nClique enter para continuar...");
			            		continuar.nextLine();
			            		break;
			            	}else {
			            		System.out.println("Valor da leitura: ");
			            		double valorLeitura = ler.nextDouble();
			            		Leitura leitura = new Leitura(valorLeitura);
			            		s.registrarLeitura(leitura);
			            		System.out.println("Leitura registrada com sucesso!\nClique enter para continuar...");
			            		continuar.nextLine();
			            	}
			            	break;
			            case 7:
			            	
			            	System.out.println("Qual o tipo de dados dos sensores deseja observar?\n1- Sensor de Água.\n2- Sensor de Luz.\n3- Os dois.");
			            	int opleitura = ler.nextInt();
			            	
			            	System.out.println("Deseja consultar de que forma?\n1- Geral.\n2- Instituição Específica.");
			            	int consulta = ler.nextInt();
			            	
			            	switch(consulta) {
			            		case 1:
			            		
			            			break;
			            		case 2:
				            		System.out.println("Qual a instituição que procura? ");
				                	String inst = ler.next();
				                	String instfinal = "";
				                	Instituicao instui = null;
				                	for(Instituicao i: instituicoes) {
				                		if(i.getNome().equals(inst)) {
				                			instfinal = i.getNome();
				                			instui = i;
				                			break;
				                		}	
				                	}                	
				                	System.out.println("Deseja consultar o consumo por:\n1- Instituição\n2- Edifício\n3- Piso\n4- Zona");
				                	int opcao = ler.nextInt();
				            		switch(opcao) {
				            		case 1:
				            			instui.verLeituraInstituicao();
				            			break;
				            		case 2:
				            			System.out.println("Qual o nome do edifício? ");
				            			String nomeedi = ler.next();
				            			Edificio edinome = instui.buscarEdificio(nomeedi);
				            			
				            			edinome.verLeiturasEdificio();
				            			break;
				            		case 3:
				            			System.out.println("Qual o nome do edifício? ");
				            			String nomeedi2 = ler.next();
				            			System.out.println("Qual o piso?");
				            			String pisoedi2 = ler.next();
				            			
				            			instui.buscarEdificio(nomeedi2);
				            			
				            			break;
				            		case 4:
				            			System.out.println("Qual o nome do edifício? ");
				            			String nomeedi3 = ler.next();
				            			System.out.println("Qual o piso?");
				            			String pisoedi3 = ler.next();
				            			System.out.println("Qual a zona?");
				            			String zonaedi3 = ler.next();	
				            			instui.buscarEdificio(nomeedi3);
				            			break;
				            		default:
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
			                break;
			            default:
			                System.out.println("Opção inválida, tente denovo!\nClique enter para continuar...");
			                continuar.nextLine();
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
    }

       
    
    public static Instituicao existeInstituicao(String nomeInstituicao, ArrayList<Instituicao> instituicoes) {
    	for(Instituicao i: instituicoes) {
    		if(i.getNome().equalsIgnoreCase(nomeInstituicao)) {
    			return i;
    		}
    	}
    	return null;
    }
    
    public static Sensor encontrarSensorId(int sensorId, ArrayList<Instituicao> instituicoes) {
    	for(Instituicao i: instituicoes) {
			for(Edificio e : i.getEdificios()) {
				for(Piso p: e.getPisos()) {
					for(Zona z: p.getZonas()) {
						for(Sensor s: z.getSensores()) {
							if(s.getId() == sensorId) {
								return s;
							}
						}
					}
				}
			}
		}
    	return null;
    }
 }
