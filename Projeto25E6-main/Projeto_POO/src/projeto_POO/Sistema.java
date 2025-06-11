package projeto_POO;
import java.util.Scanner;
import java.util.ArrayList;

public class Sistema {


 // Método principal para consultar médias
    public static void consultarMedia(ArrayList<Instituicao> instituicoes) {
        Scanner ler = new Scanner(System.in);
        int op = -1; // variável para guardar a opção do utilizador

        // Menu de opções que se repete até o utilizador escolher sair (0)
        while (op != 0) {
            System.out.println("---- Consultar Média ----");
            System.out.println("1 - Média por Instituição ");
            System.out.println("2 - Média por Edifício ");
            System.out.println("3 - Média por Piso ");
            System.out.println("4 - Média por Zona ");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            op = ler.nextInt();
            ler.nextLine(); // limpar o buffer

            // Utilização de switch no estilo convencional
            switch (op) {
                case 1:
                    consultarMediaPorInstituicao(instituicoes, ler);
                    break;
                case 2:
                    consultarMediaPorEdificio(instituicoes, ler);
                    break;
                case 3:
                    consultarMediaPorPiso(instituicoes, ler);
                    break;
                case 4:
                    consultarMediaPorZona(instituicoes, ler);
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    // Consulta da média por instituição
    public static void consultarMediaPorInstituicao(ArrayList<Instituicao> instituicoes, Scanner ler) {
        if (instituicoes.size() == 0) {
            System.out.println("Não existem instituições registadas.");
            return;
        }

        // Listar instituições
        for (int i = 0; i < instituicoes.size(); i++) {
            Instituicao inst = instituicoes.get(i);
            System.out.println((i + 1) + " - " + inst.getNome());
        }

        System.out.print("Escolha a instituição: ");
        int escolha = ler.nextInt();
        ler.nextLine();

        // Verificar se a escolha está dentro dos limites
        if (escolha < 1) {
            System.out.println("Escolha inválida.");
            return;
        }

        if (escolha > instituicoes.size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        Instituicao instSelecionada = instituicoes.get(escolha - 1);
        ArrayList<Edificio> edificios = instSelecionada.getEdificios();
        calcularEMostrarMedia(edificios, instSelecionada.getNome(), "instituição");
    }

    // Consulta da média por edifício
    public static void consultarMediaPorEdificio(ArrayList<Instituicao> instituicoes, Scanner ler) {
        ArrayList<Edificio> todosEdificios = new ArrayList<Edificio>();

        for (int i = 0; i < instituicoes.size(); i++) {
            Instituicao inst = instituicoes.get(i);
            ArrayList<Edificio> edificios = inst.getEdificios();

            for (int j = 0; j < edificios.size(); j++) {
                todosEdificios.add(edificios.get(j));
            }
        }

        if (todosEdificios.size() == 0) {
            System.out.println("Não existem edifícios registados.");
            return;
        }

        for (int i = 0; i < todosEdificios.size(); i++) {
            System.out.println((i + 1) + " - " + todosEdificios.get(i).getNome());
        }

        System.out.print("Escolha o edifício: ");
        int escolha = ler.nextInt();
        ler.nextLine();

        if (escolha < 1) {
            System.out.println("Escolha inválida.");
            return;
        }

        if (escolha > todosEdificios.size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        Edificio edif = todosEdificios.get(escolha - 1);
        ArrayList<Piso> pisos = edif.getPisos();
        calcularEMostrarMedia(pisos, edif.getNome(), "edifício");
    }

    // Consulta da média por piso
    public static void consultarMediaPorPiso(ArrayList<Instituicao> instituicoes, Scanner ler) {
        ArrayList<Piso> todosPisos = new ArrayList<Piso>();

        for (int i = 0; i < instituicoes.size(); i++) {
            Instituicao inst = instituicoes.get(i);
            ArrayList<Edificio> edificios = inst.getEdificios();

            for (int j = 0; j < edificios.size(); j++) {
                Edificio edif = edificios.get(j);
                ArrayList<Piso> pisos = edif.getPisos();

                for (int k = 0; k < pisos.size(); k++) {
                    todosPisos.add(pisos.get(k));
                }
            }
        }

        if (todosPisos.size() == 0) {
            System.out.println("Não existem pisos registados.");
            return;
        }

        for (int i = 0; i < todosPisos.size(); i++) {
            Piso p = todosPisos.get(i);
            System.out.println((i + 1) + " - Piso " + p.getNumeroPiso());
        }

        System.out.print("Escolha o piso: ");
        int escolha = ler.nextInt();
        ler.nextLine();

        if (escolha < 1) {
            System.out.println("Escolha inválida.");
            return;
        }

        if (escolha > todosPisos.size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        Piso piso = todosPisos.get(escolha - 1);
        ArrayList<Zona> zonas = piso.getZonas();
        calcularEMostrarMedia(zonas, "Piso " + piso.getNumeroPiso(), "piso");
    }

    // Consulta da média por zona
    public static void consultarMediaPorZona(ArrayList<Instituicao> instituicoes, Scanner ler) {
        ArrayList<Zona> todasZonas = new ArrayList<Zona>();

        for (int i = 0; i < instituicoes.size(); i++) {
            Instituicao inst = instituicoes.get(i);
            ArrayList<Edificio> edificios = inst.getEdificios();

            for (int j = 0; j < edificios.size(); j++) {
                Edificio edif = edificios.get(j);
                ArrayList<Piso> pisos = edif.getPisos();

                for (int k = 0; k < pisos.size(); k++) {
                    Piso piso = pisos.get(k);
                    ArrayList<Zona> zonas = piso.getZonas();

                    for (int l = 0; l < zonas.size(); l++) {
                        todasZonas.add(zonas.get(l));
                    }
                }
            }
        }

        if (todasZonas.size() == 0) {
            System.out.println("Não existem zonas registadas.");
            return;
        }

        for (int i = 0; i < todasZonas.size(); i++) {
            System.out.println((i + 1) + " - " + todasZonas.get(i).getNomeZona());
        }

        System.out.print("Escolha a zona: ");
        int escolha = ler.nextInt();
        ler.nextLine();

        if (escolha < 1) {
            System.out.println("Escolha inválida.");
            return;
        }

        if (escolha > todasZonas.size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        Zona zona = todasZonas.get(escolha - 1);
        ArrayList<Sensor> sensores = zona.getSensores();
        calcularEMostrarMedia(sensores, zona.getNomeZona(), "zona");
    }

    // Método que calcula e mostra a média de consumo de água e energia
    private static void calcularEMostrarMedia(ArrayList<?> lista, String nome, String tipo) {
        double somaAgua = 0.0;
        double somaEnergia = 0.0;
        int countAgua = 0;
        int countEnergia = 0;

        // Verificar o tipo de lista e percorrer os elementos conforme a hierarquia
        for (int i = 0; i < lista.size(); i++) {
            Object obj = lista.get(i);

            if (obj instanceof Edificio) {
                Edificio edif = (Edificio) obj;
                ArrayList<Piso> pisos = edif.getPisos();

                for (int j = 0; j < pisos.size(); j++) {
                    Piso piso = pisos.get(j);
                    ArrayList<Zona> zonas = piso.getZonas();

                    for (int k = 0; k < zonas.size(); k++) {
                        Zona zona = zonas.get(k);
                        ArrayList<Sensor> sensores = zona.getSensores();

                        for (int l = 0; l < sensores.size(); l++) {
                            Sensor s = sensores.get(l);
                            ArrayList<Leitura> leituras = s.getLeituras();

                            for (int m = 0; m < leituras.size(); m++) {
                                Leitura lida = leituras.get(m);

                                if (s.getTipo().equalsIgnoreCase("agua")) {
                                    somaAgua += lida.getValor();
                                    countAgua++;
                                }

                                if (s.getTipo().equalsIgnoreCase("energia")) {
                                    somaEnergia += lida.getValor();
                                    countEnergia++;
                                }
                            }
                        }
                    }
                }
            }

            // O mesmo processo repete-se para Piso, Zona ou Sensor
            if (obj instanceof Piso) {
                Piso piso = (Piso) obj;
                ArrayList<Zona> zonas = piso.getZonas();

                for (int j = 0; j < zonas.size(); j++) {
                    Zona zona = zonas.get(j);
                    ArrayList<Sensor> sensores = zona.getSensores();

                    for (int k = 0; k < sensores.size(); k++) {
                        Sensor s = sensores.get(k);
                        ArrayList<Leitura> leituras = s.getLeituras();

                        for (int l = 0; l < leituras.size(); l++) {
                            Leitura lida = leituras.get(l);

                            if (s.getTipo().equalsIgnoreCase("agua")) {
                                somaAgua += lida.getValor();
                                countAgua++;
                            }

                            if (s.getTipo().equalsIgnoreCase("energia")) {
                                somaEnergia += lida.getValor();
                                countEnergia++;
                            }
                        }
                    }
                }
            }

            if (obj instanceof Zona) {
                Zona zona = (Zona) obj;
                ArrayList<Sensor> sensores = zona.getSensores();

                for (int j = 0; j < sensores.size(); j++) {
                    Sensor s = sensores.get(j);
                    ArrayList<Leitura> leituras = s.getLeituras();

                    for (int k = 0; k < leituras.size(); k++) {
                        Leitura lida = leituras.get(k);

                        if (s.getTipo().equalsIgnoreCase("agua")) {
                            somaAgua += lida.getValor();
                            countAgua++;
                        }

                        if (s.getTipo().equalsIgnoreCase("energia")) {
                            somaEnergia += lida.getValor();
                            countEnergia++;
                        }
                    }
                }
            }

            if (obj instanceof Sensor) {
                Sensor s = (Sensor) obj;
                ArrayList<Leitura> leituras = s.getLeituras();

                for (int j = 0; j < leituras.size(); j++) {
                    Leitura lida = leituras.get(j);

                    if (s.getTipo().equalsIgnoreCase("agua")) {
                        somaAgua += lida.getValor();
                        countAgua++;
                    }

                    if (s.getTipo().equalsIgnoreCase("energia")) {
                        somaEnergia += lida.getValor();
                        countEnergia++;
                    }
                }
            }
        }

        // Mostrar resultados das médias
        if (countAgua > 0) {
            System.out.println("Média do consumo de água na " + tipo + " " + nome + ": " + (somaAgua / countAgua));
        } else {
            System.out.println("Não existem leituras de água na " + tipo + " " + nome + ".");
        }

        if (countEnergia > 0) {
            System.out.println("Média do consumo de energia na " + tipo + " " + nome + ": " + (somaEnergia / countEnergia));
        } else {
            System.out.println("Não existem leituras de energia na " + tipo + " " + nome + ".");
        }
    }
















	
	// Class encontrar Edificio
	public static Edificio encontrarEdificio(String nomeEdificio, ArrayList<Instituicao> instituicoes) {
    	for(Instituicao i: instituicoes) {
			for(Edificio e : i.getEdificios()) {
				if(e.getNome() == nomeEdificio) {
					return e;
							}
						}
					}
    			return null;
				}

	// Método encontrar e retornar o Piso com base no Número do piso
	public static Piso encontrarPiso(int numPiso, ArrayList<Instituicao> instituicoes) {
    	for(Instituicao i: instituicoes) {
			for(Edificio e : i.getEdificios()) {
				for(Piso p: e.getPisos()) {
					if(p.getNumeroPiso() == numPiso) {
						return p; 
							}
						}
					}
				}
    			return null;
			}

	// Método encontrar e retornar a Zona com base no nome fornecido
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

	// Método encontrar e retornar o sensor com base no id fornecido
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
			
	static ArrayList<Instituicao> instituicoes = new ArrayList<>();

	// Verifica se o nome duma isntituição já existe
	public static Instituicao existeInstituicao(String nomeInstituicao, ArrayList<Instituicao> instituicoes) {
    	for(Instituicao i: instituicoes) {
    		if(i.getNome().equalsIgnoreCase(nomeInstituicao)) {
    			return i;
    		}
    	}
    	return null;
    }
	
	static Scanner ler = new Scanner(System.in);
	
	public static void registrarInstituicao() {
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
    				
    				if(piso.existeZona(nomeZona) != null) {
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
    						System.out.println("Instituição registrada com sucesso!");
    					}
    				}
    			}	
    		}
    	}
    
	}

	// Procura uma instituição, informa se existe, se existir pede para colocar o novo nome e altera
	public static void editarNomeInstitucao() {
		System.out.println("Qual instituíção deseja editar?");
		String nomeInstituicao = ler.next();
		
		Instituicao inst = existeInstituicao(nomeInstituicao, instituicoes);
		if(inst != null) {
			System.out.println("Esta instituição não existe!");
		}else {
			System.out.println("Insira o novo nome: ");
			String novoNome = ler.next();
			inst.setNome(novoNome);
		}
	}


	
	public static void editarNomeEdificio() {
		
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
	
	public static void editarZona() {
		
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
	
	public static void editarSensor() {
		
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
	
	public static void registrarEdificio() {
		
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
	
	public static void registrarPiso() {
		
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
	
	public static void registrarZona() {
		
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
	
	public static void registrarSensor(){
		
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
	
	public static void registrarLeitura() {
		
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
	
	public static void consultarConsumo() {
		
		System.out.println("Qual o tipo de dados dos sensores deseja observar?\n1- Sensor de Água.\n2- Sensor de Luz.\n3- Os dois.");
    	int tipoLeitura = ler.nextInt();
    	
    	System.out.println("Deseja consultar de que forma?\n1- Geral.\n2- Específico");
    	int tipoConsulta = ler.nextInt();
    	
    	System.out.println("Deseja consultar o consumo por:\n1- Instituição\n2- Edifício\n3- Piso\n4- Zona\n5- Sensor");
    	int elementoConsulta = ler.nextInt();
    	
    	switch(tipoConsulta) {
    	
    	case 1: 
    		
    		switch(elementoConsulta) {
    		
    		case 1:
    			
    			for(Instituicao i : instituicoes) {
    	    		System.out.println("Instituição: " + i.getNome());
    	    		i.verLeituraInstituicao(tipoLeitura);
    			}
    		
    		case 2:
    			
    			for(Instituicao i : instituicoes) {
    				
    			}
    	
    		
    		}
    		
    		break;
    		
    	case 2: 
    		
    		switch(elementoConsulta) {
    		
    		case 1:
    			
    			System.out.println("Instituição: ");
    			String nomeInstituicao = ler.next();
    			Instituicao i = existeInstituicao(nomeInstituicao, instituicoes);
    			
    			if(i == null) {
    				System.out.println("Esta instituição não existe!");
    				break;
    			}else {
    				i.verLeituraInstituicao();
    			}
    			
    		case 2: 
    			
    			System.out.println("Em que instituição se localiza o edifício?");
    	    	String insedi = ler.next();
    	    	Instituicao inst = existeInstituicao(insedi, instituicoes);
    	    	
    	    	if(inst == null) {
    	    		
    	    		System.out.println("Esta instituição não existe!");
    	    		
    	    	}else if(inst.getNome().equals(insedi)) {
    	    		
    	    		System.out.println("Nome do edificio: ");
    	    		String nomeEdificio = ler.next();
    	    		
    	    		if(inst.existeEdificio(nomeEdificio) != null) {
    	    			
    	    			inst.existeEdificio(nomeEdificio).verLeiturasEdificio();
    	    			
    	    		}else {
    	    			
    	    			System.out.println("Este edificio não existe!");
    	    		}
    	    	}
    	    	
    		case 3:
    			
    			System.out.println("Em que instituição se localiza o piso?");
    	    	String insedi3 = ler.next();
    	    	Instituicao inst3 = existeInstituicao(insedi3, instituicoes);
    	    	
    	    	if(inst == null) {
    	    		
    	    		System.out.println("Esta instituição não existe!");
    	    		
    	    	}else if(inst.getNome().equals(insedi3)) {
    	    		
    	    		System.out.println("Em que edifício se localiza o piso?");
    	    		String nomeEdificio = ler.next();
    	    		
    	    		if(inst3.existeEdificio(nomeEdificio) == null) {
    	    			
    	    			System.out.println("Este edifício não existe!");
    	    			break;
    	    			
    	    		}else {
    	    			
    	    			System.out.println("Número do piso: ");
    	    			int numPiso = ler.nextInt();
    	    			
    	    			if(inst3.existeEdificio(nomeEdificio).existePiso(numPiso) != null) {
    	    				
    	    				inst3.existeEdificio(nomeEdificio).existePiso(numPiso).verLeituraPisos();
    	    				
    	    			}else {
    	    				
    	    				System.out.println("Este piso não existe!");
    	    			}
    	    				
    	    		}
    	    	}
    	    	
    		case 4: 
    			
    			System.out.println("Em que instituição se localiza a zona?");
    	    	String insedi4 = ler.next();
    	    	Instituicao inst4 = existeInstituicao(insedi, instituicoes);

    	    	if (inst4 == null) {
    	    		
    	    	    System.out.println("Esta instituição não existe!");
    	    	    
    	    	} else if (inst4.getNome().equals(insedi4)) {
    	    		
    	    	    System.out.println("Em que edifício se localiza a zona?");
    	    	    String nomeEdificio = ler.next();

    	    	    if (inst4.existeEdificio(nomeEdificio) == null) {
    	    	    	
    	    	        System.out.println("Este edificio não existe!");
    	    	        
    	    	    } else {
    	    	    	
    	    	        System.out.println("Em que piso se localiza a zona?");
    	    	        int numPiso = ler.nextInt();

    	    	        if (inst.existeEdificio(nomeEdificio).existePiso(numPiso) == null) {
    	    	        	
    	    	            System.out.println("Este piso não existe!");
    	    	            
    	    	        } else {
    	    	        	
    	    	            System.out.println("Nome da zona: ");
    	    	            String nomeZona1 = ler.next();
    	    	            Zona zona = inst.existeEdificio(nomeEdificio).existePiso(numPiso).existeZona(nomeZona1);
    	    	            
    	    	            if (zona != null) {
    	    	            	
    	    	                zona.verLeiturasZonas();
    	    	                
    	    	            } else {
    	    	            	
    	    	                System.out.println("Esta zona não existe!");
    	    	            }
    	    	        }
    	    	    }
    	    	}
    	    	
    		case 5:
    			
    			System.out.println("Id do sensor: ");
    			int idSensor = ler.nextInt();
    			Sensor s = encontrarSensorId(idSensor, instituicoes);
    			
    			if(s != null) {
    				
    				s.verLeituras();
    				
    			}else {
    				
    				System.out.println("Este sensor não existe!");
    				break;
    			}
    			
    			
    		}// Aqui termina o case elementoConsulta
    		
    	}
        
	}
}
