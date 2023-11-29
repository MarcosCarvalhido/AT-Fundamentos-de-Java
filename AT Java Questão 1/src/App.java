import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class App {
    static Scanner userInput = new Scanner(System.in,"UTF-16");
    public static void main(String[] args) throws Exception{

        //Declaração dos valores.
        int numeroInicial = 0; // Valor de a1.
        int diferença = 0; // A Razão;
        int quantidade = 0; // A quantidade de números da sequência finita (N).
        String entrada;  // Recebe os inputs do usuario.; // O input do usuario.
        ArrayList<Integer> PA = new ArrayList<Integer>(); // Resultado da P.A.
        
        //Pergunta para o usuario e verifica as informações necessarias.
        entrada = Perguntar("numeroInicial");
        numeroInicial = Integer.parseInt(ValidarEntrada(entrada));

        entrada = Perguntar("diferença");
        diferença = Integer.parseInt(ValidarEntrada(entrada));

        entrada = Perguntar("quantidade");
        quantidade = Integer.parseInt(ValidarEntrada(entrada));

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

        //Pergunta e guarda a resposta do usuario.
        userInput = new Scanner(System.in);
        System.out.println(pergunta); 
        return userInput.nextLine();
    }

    //Repete a pergunta se estiver invalida.
    public static String ValidarEntrada(String entrada){
        boolean error = false;
       do {
            if (VerificarSeNumerico(entrada)) {
                error = false;
            }
            else{
                ErroNumerico();
                error = true;
            }
        } while (error);
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

        System.out.print("A P.A. criada com os valores apresentados é: "); 
        String listaPA = "";
        
        // Adciona uma virgula entre cada numero, menos pro ultimo item da lista, onde um ponto final é adcionado.
        for (int index = 0; index < PA.size(); index++) {

            if (index == PA.size() -1) {
                listaPA += Integer.toString(PA.get(index)) + ".";
            }
            else if (index == PA.size() -2) {
                listaPA += Integer.toString(PA.get(index)) + " e ";
            }
            else{
                listaPA += Integer.toString(PA.get(index)) + ", ";
            }
        }
        System.out.println(listaPA);
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
