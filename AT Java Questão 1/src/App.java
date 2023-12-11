import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner userInput = new Scanner(System.in,"UTF-16");
    public static void main(String[] args) throws Exception{

        //Declaração dos valores.
        int numeroInicial = 0; // Valor de a1.
        int diferença = 0; // A Razão;
        int quantidade = 0; // A quantidade de números da sequência finita (N).
        String entrada;  // Recebe os inputs do usuario.;
        ArrayList<Integer> PA = new ArrayList<Integer>(); // Resultado da P.A.
        
        //Pergunta para o usuario e verifica as informações necessarias.
        entrada = Perguntar("numeroInicial");
        numeroInicial = Integer.parseInt(entrada);

        entrada = Perguntar("diferença");
        diferença = Integer.parseInt(entrada);

        entrada = Perguntar("quantidade");
        quantidade = Integer.parseInt(entrada);

        //Calcula a P.A. com os valores informados e guarda em um ArrayList.
        CalcularPA(numeroInicial, diferença, quantidade, PA);

        //Mostra no console o resultado.
        mostrarPA(PA);
        
        //Calcula e Mostra o valor do calculo de gaus.
        MostrarGaus(CalcularGaus(PA));
            
    }
    
    // Recebe os inputs ao usuario.
    public static String Perguntar(String tipo){
        String pergunta = "";
        
        //Seleciona uma das opçõe de pergunta possiveis;
        switch (tipo) {
            case "numeroInicial":
                pergunta = "Qual o valor inicial da P.A. ?";
                break;
        
            case "diferença":
                pergunta = "Qual a diferença(Razão) da P.A. ?";
                break;
        
            case "quantidade":
                pergunta = "Qual a quantidade de itens da P.A. ?";
                break;
        
            default:
                break;
        }

        //Pergunta a resposta do usuario.
        userInput = new Scanner(System.in);
        System.out.println(pergunta); 
        String entrada = userInput.nextLine();
        
        //Valida e devolve a resposta do usuario.
        return ValidarEntrada(entrada,tipo); 
    }

    //Repete a pergunta se estiver invalida.
    public static String ValidarEntrada(String entrada, String pergunta){
        if (!VerificarSeNumerico(entrada)) {
           do {
               ErroNumerico();
               entrada = Perguntar(pergunta);
           } while (!VerificarSeNumerico(entrada));
        }
        return entrada;
    }
    
    //Verifica se a entrada é numerica ou não nula.
    public static Boolean VerificarSeNumerico(String entrada){
        if(entrada != null){
            try {
                int numero = Integer.parseInt(entrada);
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        else{
            return false;
        }
    }

    //Calcula a P.A. com os dados informados pelo usuario.
    public static void CalcularPA(int numeroInicial, int diferença, int quantidade, ArrayList<Integer> PA){
        int soma = 0;
        PA.add(numeroInicial);
        for (int i = 1; i < quantidade - 1; i++) {
            soma = numeroInicial + diferença;
            PA.add(soma);
            numeroInicial = soma;
        }
    }

    //Calcula o valor da soma de gaus.
    public static int CalcularGaus(ArrayList<Integer> PA){
        int primeiroNumero;
        int ultimoNumero;

        primeiroNumero = PA.get(0);
        ultimoNumero = PA.get(PA.size() - 1);

        return ((primeiroNumero + ultimoNumero) * PA.size()); 
    }
    
    //Mostra as P.A no console.
    public static void mostrarPA(ArrayList<Integer> PA){
        LimparTela();
        System.out.println("A P.A. criada com os valores apresentados é: " + TransformarLista(PA)); 
    }

    //Transforma um ArrayList numerica em uma string para facilitar a visualização.
    public static String TransformarLista(ArrayList<Integer> lista){
        String resultado = "";
        for (int index = 0; index < lista.size(); index++) {

            if (index == lista.size() -1) {
                resultado += Integer.toString(lista.get(index)) + ".";
            }
            else if (index == lista.size() -2) {
                resultado += Integer.toString(lista.get(index)) + " e ";
            }
            else{
                resultado += Integer.toString(lista.get(index)) + ", ";
            }
        }
        return resultado;
    }

    //limpa a tela de comandos.
    public static void LimparTela() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  


    //Mostra o resultado da soma de gaus.
    public static void MostrarGaus(int gaus){
        System.out.println("A soma de gaus (soma de todos os valores da lista) calculada apartir da P.A. é de: " + gaus + "."); 
    }

    //Mostra uma mensagem de erro caso a entrada não seje valida.
    public static void ErroNumerico(){
        System.out.println("Apenas numeros inteiros são permitidos!"); 
    }
}
