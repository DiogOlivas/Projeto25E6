package projeto_POO;
import java.util.Scanner;
import java.util.ArrayList;

public class Sistema {
	
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
	
	public static Zona encontrarZona(String nomeZona, ArrayList<Instituicao> instituicoes) {
    	for(Instituicao i: instituicoes) {
			for(Edificio e : i.getEdificios()) {
				for(Piso p: e.getPisos()) {
					for(Zona z: p.getZonas()) {
						if(z.getNomeZona() == nomeZona) {
								return z;
							}
						}
					}
				}
			}
    	return null;
    }
	
	ArrayList<Instituicao> instituicoes = new ArrayList<>();
	
	public static Instituicao existeInstituicao(String nomeInstituicao, ArrayList<Instituicao> instituicoes) {
    	for(Instituicao i: instituicoes) {
    		if(i.getNome().equalsIgnoreCase(nomeInstituicao)) {
    			return i;
    		}
    	}
    	return null;
    }
	
	Scanner ler = new Scanner(System.in);
	
	public void registrarInstituicao() {
		//ArrayList<Instituicao> instituicoes = new ArrayList<>(); 
		System.out.println("Nome da instituição: ");
    	String nomeInstituicao = ler.next();
    	Instituicao inst = existeInstituicao(nomeInstituicao, instituicoes);
    	if(inst != null) {
    		
    		System.out.println("Esta instituição já existe!");
    		
    	}else {
    		
    		Instituicao instituicao = new Instituicao(nomeInstituicao);
    		instituicoes.add(instituicao);
    		
    		System.out.println("Nome do edifício: ");
    		String nomeEdificio = ler.next();
    		
    		if(instituicao.existeEdificio(nomeEdificio) != null) {
    			
    			System.out.println("Este edifício já existe!");
    			
    		}else {
    			
    			Edificio edificio = new Edificio(nomeEdificio);
    			instituicao.adicionarEdificio(edificio);
    			
    			System.out.println("Numero do piso: ");
    			int numPiso = ler.nextInt();
    			
    			if(edificio.existePiso(numPiso) != null) {
    				
    				System.out.println("Este piso já existe!");
    				
    			}else {
    				
    				Piso piso = new Piso(numPiso);
    				edificio.adicionarPiso(piso);
    				
    				System.out.println("Nome da zona: ");
    				String nomeZona = ler.next();
    				
    				if(edificio.existePiso(numPiso) != null) {
    					System.out.println("Esta zona já existe!");
    				}else {
    					Zona zona = new Zona(nomeZona);
    					piso.adicionarZona(zona);
    					
    					System.out.println("Id sensor: ");
    					int idSensor = ler.nextInt();
    					
    					if(zona.existeSensor(idSensor) != null) {
    						System.out.println("Este sensor já existe!");
    					}else {
    						System.out.println("Tipo do sensor: ");
    						String tipoSensor = ler.next();
    						System.out.println("Zona do sensor: ");
    						String sensorZona = ler.next();
    						
    						Sensor sensor = new Sensor(idSensor, tipoSensor, sensorZona);
    						zona.addSensor(sensor);
    					}
    				}
    			}	
    		}
    	}
    
	}
	
	public void editarNomeInstitucao(String nomeInstituicao) {
		System.out.println("Qual instituíção deseja editar?");
		nomeInstituicao = ler.next();
		
		Instituicao inst = existeInstituicao(nomeInstituicao, instituicoes);
		if(inst != null) {
			System.out.println("Esta instituição não existe!");
		}else {
			System.out.println("Insira o novo nome: ");
			String novoNome = ler.next();
			inst.setNome(novoNome);
		}
	}


	
	public void editarNomeEdificio() {
		
		System.out.println("Em que instituição se localiza o edifício que deseja alterar");
    	String insedi = ler.next();
    	Instituicao inst = existeInstituicao(insedi, instituicoes);
    	
    	if(inst == null) {
    		System.out.println("Esta instituição não existe!");
    	}else if(inst.getNome().equals(insedi)) {
    		System.out.println("Nome do edificio: ");
    		String nomeEdificio = ler.next();
    		if(inst.existeEdificio(nomeEdificio) != null) {
    			System.out.println("Insira o novo Nome: ");
    			String novoNome = ler.next();
    			inst.existeEdificio(nomeEdificio).setNome(novoNome);
    			System.out.println("Edificio alterado com sucesso!");
    		}else {
    			System.out.println("Este edificio não existe!");
    		}
    	}
	}
	
	public void editarZona(String nomeZona) {
		System.out.println("Em que instituição se localiza a zona que deseja alterar");
    	String insedi = ler.next();
    	Instituicao inst = existeInstituicao(insedi, instituicoes);

    	if (inst == null) {
    	    System.out.println("Esta instituição não existe!");
    	} else if (inst.getNome().equals(insedi)) {
    	    System.out.println("Em que edifício se localiza a zona que deseja alterar");
    	    String nomeEdificio = ler.next();

    	    if (inst.existeEdificio(nomeEdificio) == null) {
    	        System.out.println("Este edificio não existe!");
    	    } else {
    	        System.out.println("Em que piso se localiza a zona que deseja alterar");
    	        int numPiso = ler.nextInt();

    	        if (inst.existeEdificio(nomeEdificio).existePiso(numPiso) == null) {
    	            System.out.println("Este piso não existe!");
    	        } else {
    	            System.out.println("Nome da zona: ");
    	            String nomeZona1 = ler.next();
    	            
    	            Zona zona = inst.existeEdificio(nomeEdificio).existePiso(numPiso).existeZona(nomeZona1);
    	            if (zona != null) {
    	                System.out.println("Insira o novo nome da zona: ");
    	                String novoNomeZona = ler.next(); 
    	                zona.setNomeZona(novoNomeZona);
    	                System.out.println("Zona alterada com sucesso!");
    	            } else {
    	                System.out.println("Esta zona não existe!");
    	            }
    	        }
    	    }
    	}
	}
	
	public void editarSensor(int idSensor) {
		
		System.out.println("Qual o id do sensor deseja editar?");
		int idSensor2 = ler.nextInt();
		Sensor sensor = encontrarSensorId(idSensor2, instituicoes);
		String nomeZonaSensor = sensor.getZona();
		Zona zonaSensor = encontrarZona(nomeZonaSensor, instituicoes);
		
		if(sensor != null) {
			int op;
			System.out.println("O que deseja alterar? \n1) Id \n2) tipo \n3) Zona");
			op = ler.nextInt();
			switch(op) {
			
			case 1:
				
				System.out.println("Insira o novo Id: ");
				int novoId = ler.nextInt();
				sensor.setId(novoId);
				System.out.println("Sensor alterado com sucesso!");
				
			case 2: 
				
				System.out.println("Insira o tipo do sensor: ");
				String tipoSensor = ler.next();
				sensor.setTipo(tipoSensor);
				System.out.println("Sensor alterado com sucesso!");
				
			case 3: 
				
				System.out.println("Em qual zona deseja inserir o sensor?");
				String nomeZona = ler.next();
				Zona z = encontrarZona(nomeZona, instituicoes);
				if(z == null) {
					System.out.println("Esta zona não existe!");
					break;
				}else {
					zonaSensor.removerSensor(sensor);
					z.addSensor(sensor);
					sensor.setZona(nomeZona);
					System.out.println("Sensor alterado com sucesso!");
					
				}
				
			}
			
		}else {
			System.out.println("Este sensor não existe!");
		}
		
	}
	
	public void registrarEdificio() {
		
		System.out.println("Em que instituição deseja registrar o edifício?");
    	String insedi2 = ler.next();
    	Instituicao inst2 = existeInstituicao(insedi2, instituicoes);
    	
    	if(inst2 == null) {
    		System.out.println("Esta instituição não existe!");
    		
    	}else if(inst2.getNome().equals(insedi2)) {
    		
    		System.out.println("Nome do edificio: ");
    		String nomeEdificio = ler.next();
    		if(inst2.existeEdificio(nomeEdificio) == null) {
    			Edificio edificio = new Edificio(nomeEdificio);
    			inst2.adicionarEdificio(edificio);
    			System.out.println("Edificio adicionado com sucesso!");
    			
    		}else {
    			
    			System.out.println("Este edificio já existe!");
    			
    		}
    	}
    	
	}
	
	public void registrarPiso() {
		
		System.out.println("Em que instituição deseja guardar o edifício? ");
    	String insedi3 = ler.next();
    	Instituicao inst3 = existeInstituicao(insedi3, instituicoes);
    	
    	if(inst3 == null) {
    		
    		System.out.println("Esta instituição não existe!");
    		
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
    			}
    		}
    	}
	}
	
	public void registrarZona() {
		
		System.out.println("Em que instituição deseja guardar a zona? ");
    	String insedi4 = ler.next();
    	Instituicao inst4 = existeInstituicao(insedi4, instituicoes);

    	if (inst4 == null) {
    		
    	    System.out.println("Esta instituição não existe!");

    	} else if (inst4.getNome().equals(insedi4)) {
    		
    	    System.out.println("Em que edifício deseja guardar a zona? ");
    	    String nomeEdificio4 = ler.next();

    	    if (inst4.existeEdificio(nomeEdificio4) == null) {
    	    	
    	        System.out.println("Este edificio não existe!");

    	    } else {
    	    	
    	        System.out.println("Em qual piso deseja guardar a zona?");
    	        int numPiso = ler.nextInt();

    	        if (inst4.existeEdificio(nomeEdificio4).existePiso(numPiso) == null) {
    	        	
    	            System.out.println("Este piso não existe!");
    	            
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
	}
	
	public void registrarSensor(){
		
		System.out.println("Em que instituição deseja guardar o sensor? ");
		String insedi5 = ler.next();
		Instituicao inst5 = existeInstituicao(insedi5, instituicoes);

		if (inst5 == null) {
			
		    System.out.println("Esta instituição não existe!");

		} else if (inst5.getNome().equals(insedi5)) {
			
		    System.out.println("Em que edifício deseja guardar o sensor? ");
		    String nomeEdificio5 = ler.next();

		    if (inst5.existeEdificio(nomeEdificio5) == null) {
		    	
		        System.out.println("Este edificio não existe!");

		    } else {
		    	
		        System.out.println("Em qual piso deseja guardar o sensor?");
		        int numPiso = ler.nextInt();

		        if (inst5.existeEdificio(nomeEdificio5).existePiso(numPiso) == null) {
		        	
		            System.out.println("Este piso não existe!");

		        } else {
		        	
		            System.out.println("Nome da zona: ");
		            String nomeZona = ler.next();
		            Zona zona = inst5.existeEdificio(nomeEdificio5).existePiso(numPiso).existeZona(nomeZona);

		            if (zona == null) {
		            	
		                System.out.println("Esta zona não existe!");

		            } else {
		            	
		                System.out.println("id do Sensor:");
		                int idSensor = ler.nextInt();

		                if (inst5.existeEdificio(nomeEdificio5).existePiso(numPiso).existeZona(nomeZona).existeSensor(idSensor) == null) {
		                	
		                    System.out.println("Tipo de sensor: ");
		                    String tipoSensor = ler.next();
		                    Sensor sensor = new Sensor(idSensor, tipoSensor, nomeZona);
		                    inst5.existeEdificio(nomeEdificio5).existePiso(numPiso).existeZona(nomeZona).addSensor(sensor);
		                    System.out.println("Sensor registrado com sucesso!");
		                    
		                } else {
		                	
		                    System.out.println("Este sensor já existe!");
		                }
		            }
		        }
		    }
		}
	}
	
	public void registrarLeitura() {
		
		System.out.println("id do sensor: ");
    	int idSensor = ler.nextInt();
    	Sensor s = encontrarSensorId(idSensor, instituicoes);
    	
    	if(s == null) {
    		
    		System.out.println("Este sensor não existe!");

    	}else {
    		
    		System.out.println("Valor da leitura: ");
    		double valorLeitura = ler.nextDouble();
    		Leitura leitura = new Leitura(valorLeitura);
    		s.registrarLeitura(leitura);
    		System.out.println("Leitura registrada com sucesso!");
    	}
	}
	
	public void consultarConsumo() {
		
		System.out.println("Qual o tipo de dados dos sensores deseja observar?\n1- Sensor de Água.\n2- Sensor de Luz.\n3- Os dois.");
    	int opleitura = ler.nextInt();
    	
    	System.out.println("Deseja consultar de que forma?\n1- Geral.\n2- Instituição Específica.");
    	int consulta = ler.nextInt();
    	
    	switch(consulta) {
    	
    	case 1:
    		
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

    		case 2:
    			
    			System.out.println("Qual o nome do edifício? ");
    			String nomeedi = ler.next();
    			Edificio edinome = instui.buscarEdificio(nomeedi);
    			
    			edinome.verLeiturasEdificio();

    		case 3:
    			
    			System.out.println("Qual o nome do edifício? ");
    			String nomeedi2 = ler.next();
    			System.out.println("Qual o piso?");
    			String pisoedi2 = ler.next();
    			
    			instui.buscarEdificio(nomeedi2);
    			
    		case 4:
    			
    			System.out.println("Qual o nome do edifício? ");
    			String nomeedi3 = ler.next();
    			System.out.println("Qual o piso?");
    			String pisoedi3 = ler.next();
    			System.out.println("Qual a zona?");
    			String zonaedi3 = ler.next();	
    			instui.buscarEdificio(nomeedi3);

    		default:
		}
    		default:
    		
            System.out.println("Opção inválida, tente denovo!");
    	}
	}
}
