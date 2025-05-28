package projeto_POO;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;


public class Main {
    public static void main(String[] args) {
    	Scanner ler = new Scanner(System.in);
        int op;
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
            	System.out.println("Nome da instituíção: ");
            	
            	String nomeInstituicao = ler.next();
            	Instituicao instituicao = new Instituicao(nomeInstituicao);
            	instituicoes.add(instituicao);
            	
            	break;
            case 2:
            	System.out.println("Em que instituição deseja guardar o edifício? ");
            	String insedi = ler.next();
            	System.out.println("Nome do edifício: ");
            	String nomeEdificio = ler.next();
            	Edificio edificio = new Edificio(nomeEdificio);
            	for(Instituicao i: instituicoes) {
            		if(i.getNome().equals(insedi)) {
            			i.adicionarEdificio(edificio);
            		}
            	}
            	break;
            case 3:
            	System.out.println("Em que instituição deseja guardar o edifício? ");
            	String insedi2 = ler.next();
            	System.out.println("Em que edifício deseja guardar o piso? ");
            	String nomeEdificio2 = ler.next();
            	System.out.println("Número do piso: ");
            	int numPiso = ler.nextInt();
            	Piso piso = new Piso(numPiso);
            	
            	for(Instituicao i: instituicoes) {
            		if(i.getNome().equals(insedi2)) {
            			i.addPiso(nomeEdificio2, piso);
            		}
            	}
                break;
            case 4:
            	System.out.println("Em que instituição deseja guardar o edifício? ");
            	String insedi3 = ler.next();
            	System.out.println("Em que edifício deseja guardar o piso? ");
            	String nomeEdificio3 = ler.next();
            	System.out.println("Em qual piso deseja guardar a zona? ");
            	int numPiso2 = ler.nextInt();
            	Piso piso2 = new Piso(numPiso2);
            	
            	System.out.println("Nome da zona: ");
            	String nomeZona = ler.next();
            	Zona zona = new Zona(nomeZona);
                
            	for(Instituicao i: instituicoes) {
            		if(i.getNome().equals(insedi3)) {
            			i.addPiso(nomeEdificio3, piso2);
            		}
            	}
            	break;
            case 5:
            	System.out.println("Qual a instituição onde se irá registar este sensor? ");
            	String instituicaoRegisto = ler.next();
            	System.out.println("Qual o edifício onde se irá registar este sensor? ");
            	String edificioRegisto = ler.next();
            	
            	System.out.println("Id: ");
            	int id = ler.nextInt();
            	System.out.println("Zona: ");
            	String zonac = ler.next();
            	System.out.println("Piso: ");
            	int pisoc = ler.nextInt();
            	System.out.println("Tipo (agua ou energia): ");
            	String tipo = ler.next();
            	Sensor sensor = new Sensor(id, pisoc, tipo, zonac, edificioRegisto, instituicaoRegisto);   
            	System.out.println("Sensor registado com sucesso!");
                break;
            case 6:
            	System.out.println("Data da leitura: ");
            	// LocalTime data = ler.next(); 
            	// Zona leitura = new Leitura(data, );
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
}