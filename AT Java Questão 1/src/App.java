import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner userInput = new Scanner(System.in,"UTF-16");
    public static void main(String[] args) throws Exception {

        //Declaração dos valores.
        int numeroInicial = 0; // Valor de a1.
        int diferença = 0; // A Razão;
        int quantidade = 0; // A quantidade de números da sequência finita (N).
        String entrada; // O input do usuario.
        ArrayList<Integer> PA = new ArrayList<Integer>(); // Resultado da P.A.

        //Executa o codigo enquanto os valores forem validos.
        do {
            
            //Pergunta para o usuario e verifica as informações necessarias.
            entrada = PerguntarnumeroInicial();
            if (VerificarEntrada(entrada)) {
                numeroInicial = Integer.parseInt(entrada);
            }
            else{
                ErroNumerico();
                break;
            }
            entrada = PerguntarDiferença();
            if (VerificarEntrada(entrada)) {
                diferença = Integer.parseInt(entrada);
            }
            else{
                ErroNumerico();
                break;
            }
            entrada = PerguntarDiferença();
            if (VerificarEntrada(entrada)) {
                quantidade = Integer.parseInt(entrada);
            }
            else{
                ErroNumerico();
                break;
            }
    
            //Calcula a P.A. com os valores informados e guarda em um ArrayList.
            CalcularPA(numeroInicial, diferença, quantidade, PA);
    
            //Mostra no console o resultado.
            mostrarPA(PA);
        } while (true);
    }
    // Recebe os inputs do usuario.
    public static String PerguntarnumeroInicial(){
        userInput = new Scanner(System.in);
        System.out.println("Qual o valor inicial da P.A. ?"); 
        return userInput.nextLine();
    }
    public static String PerguntarDiferença(){
        userInput = new Scanner(System.in);
        System.out.println("Qual a diferença(Razão) da P.A. ?"); 
        return  userInput.nextLine();
    }
    public static String PerguntarQuantidade(){
        userInput = new Scanner(System.in);
        System.out.println("Qual a quantidade de itens da P.A. ?"); 
        return userInput.nextLine();
    }

    //Verifica se uma entrada é numerica ou não nula.
    public static Boolean VerificarEntrada(String entrada){
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
    
    //Mostra as P.A no console.
    public static void mostrarPA(ArrayList<Integer> PA){
        System.out.println("A P.A. criada com os valores apresentados é: "); 
        String listaPA = " ";
        for (int item : PA) {
            // listaPA.concat(Double.toString(item) + ", ");
            String a = "a";
            a.concat(listaPA);
        }
        System.out.println(listaPA);
    }

    //Mostra uma mensagem de erro caso a entrada não seje valida.
    public static void ErroNumerico(){
        System.out.println("Apenas numeros inteiros são permitidos!"); 
    }
}
