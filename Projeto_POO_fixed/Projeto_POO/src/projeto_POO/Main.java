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
            System.out.println("7- Consultar Consumo.");
            System.out.println("0- SAIR.");
            op = ler.nextInt();
            switch(op) {
            
            case 1:
            	
            	System.out.println("Nome da instituição: ");
            	String nomeInstituicao = ler.next();
            	Instituicao inst1 = existeInstituicao(nomeInstituicao, instituicoes);
            	
            	if(inst1 == null) {
            		Instituicao instituicao = new Instituicao(nomeInstituicao);
            		instituicoes.add(instituicao);
            		System.out.println("Instituição registrada com sucesso!");
            	}else {
            		System.out.println("Esta instituição já existe!");
            	}
            	break;
            	
            case 2:
            	
            	System.out.println("Em que instituição deseja registrar o edifício?");
            	String insedi2 = ler.next();
            	Instituicao inst2 = existeInstituicao(insedi2, instituicoes);
            	
            	if(inst2 == null) {
            		System.out.println("Esta instituição não existe!");
            		break;
            	}else if(inst2.getNome().equals(insedi2)) {
            		System.out.println("Nome do edificio: ");
            		String nomeEdificio = ler.next();
            		if(inst2.existeEdificio(nomeEdificio) == null) {
            			Edificio edificio = new Edificio(nomeEdificio);
            			inst2.adicionarEdificio(edificio);
            			System.out.println("Edificio adicionado com sucesso!");
            		}else {
            			System.out.println("Este edificio já existe!");
            			break;
            		}
            	}
            	break;
            	
            case 3:
            	
            	System.out.println("Em que instituição deseja guardar o edifício? ");
            	String insedi3 = ler.next();
            	Instituicao inst3 = existeInstituicao(insedi3, instituicoes);
            	
            	if(inst3 == null) {
            		System.out.println("Esta instituição não existe!");
            		break;
            	}else if(inst3.getNome().equals(insedi3)) {
            		System.out.println("Em que edifício deseja guardar o piso? ");
            		String nomeEdificio3 = ler.next();
            		if(inst3.existeEdificio(nomeEdificio3) == null) {
            			System.out.println("Este edificio não existe!");
            		}else {
            			System.out.println("Numero do piso: ");
            			int numPiso = ler.nextInt();
            			if(inst3.existeEdificio(nomeEdificio3).existePiso(numPiso) == null) {
            				Piso piso = new Piso(numPiso);
            				inst3.existeEdificio(nomeEdificio3).adicionarPiso(piso);
            				System.out.println("Piso adicionado com sucesso!");
            			}else {
            				System.out.println("Este piso já existe!");
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
            	        System.out.println("Este edificio não existe!");
            	        break;
            	    } else {
            	        System.out.println("Em qual piso deseja guardar a zona?");
            	        int numPiso = ler.nextInt();

            	        if (inst4.existeEdificio(nomeEdificio4).existePiso(numPiso) == null) {
            	            System.out.println("Este piso não existe!");
            	            break;
            	        } else {
            	            System.out.println("Nome da zona: ");
            	            String nomeZona = ler.next();

            	            if (inst4.existeEdificio(nomeEdificio4).existePiso(numPiso).existeZona(nomeZona) == null) {
            	                Zona zona = new Zona(nomeZona);
            	                inst4.existeEdificio(nomeEdificio4).existePiso(numPiso).adicionarZona(zona);
            	                System.out.println("Zona adicionada com sucesso!");
            	            } else {
            	                System.out.println("Esta zona já existe!");
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
            		    System.out.println("Esta instituição não existe!");
            		    break;
            		} else if (inst5.getNome().equals(insedi5)) {
            		    System.out.println("Em que edifício deseja guardar o sensor? ");
            		    String nomeEdificio5 = ler.next();

            		    if (inst5.existeEdificio(nomeEdificio5) == null) {
            		        System.out.println("Este edificio não existe!");
            		        break;
            		    } else {
            		        System.out.println("Em qual piso deseja guardar o sensor?");
            		        int numPiso = ler.nextInt();

            		        if (inst5.existeEdificio(nomeEdificio5).existePiso(numPiso) == null) {
            		            System.out.println("Este piso não existe!");
            		            break;
            		        } else {
            		            System.out.println("Nome da zona: ");
            		            String nomeZona = ler.next();

            		            if (inst5.existeEdificio(nomeEdificio5).existePiso(numPiso).existeZona(nomeZona) == null) {
            		                System.out.println("Esta zona não existe!");
            		                break;
            		            } else {
            		                System.out.println("id do Sensor:");
            		                int idSensor = ler.nextInt();

            		                if (inst5.existeEdificio(nomeEdificio5).existePiso(numPiso).existeZona(nomeZona).existeSensor(idSensor) == null) {
            		                    System.out.println("Tipo de sensor: ");
            		                    String tipoSensor = ler.next();
					   do{
						Try{
						     System.out.println("Qual o limite superior do sensor?");
						     double limiteSup = ler.nextdouble;
					    	}catch(exception e){
						     System.out.println("Por favor, escreva um número.");
					    	}
					   }while();
						
					   do{
						Try{
						     System.out.println("Qual o limite inferior do sensor?");
						     double limiteInf = ler.nextdouble;
						}catch(exception e){
						     System.out.println("Por favor, escreva um número.");
						}
					   }while();
						
            		                    Sensor sensor = new Sensor(idSensor, tipoSensor, limiteSup, limiteInf);
            		                    inst5.existeEdificio(nomeEdificio5).existePiso(numPiso).existeZona(nomeZona).addSensor(sensor);
            		                    System.out.println("Sensor registrado com sucesso!");
            		                } else {
            		                    System.out.println("Este sensor já existe!");
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
            		System.out.println("Este sensor não existe!");
            		break;
            	}else {
            		System.out.println("Valor da leitura: ");
            		double valorLeitura = ler.nextDouble();
            		Leitura leitura = new Leitura(valorLeitura);
            		s.registrarLeitura(leitura);
            		System.out.println("Leitura registrada com sucesso!");
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
                    System.out.println("Opção inválida, tente denovo!");
            		break;
            	}
                break;
                
            case 0:
            	
            	System.out.println("Até à proxima! 😀");
                break;
            default:
                System.out.println("Opção inválida, tente denovo!");
                break;
            }
        }while(op != 0);
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
