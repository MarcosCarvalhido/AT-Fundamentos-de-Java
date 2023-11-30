import java.util.ArrayList;
import java.util.Scanner;
import java.text.MessageFormat;

public class App {
    static Scanner userInput = new Scanner(System.in,"UTF-16");
    public static void main(String[] args) throws Exception {
        int numero = 10; // numero informado pelo usuario que será usado como base para calcular os numeros primos.
        ArrayList<Integer> primos = new ArrayList<Integer>(); // Lista de numeros primos encontrados.
        
        //Pergunta para o usuario e verifica as informações necessarias.
        numero = Integer.parseInt(PerguntarNumero());

        //Calcula a sequencia de primos e guarda no array list;
        GuardarPrimos(numero, primos);

        //Exibe a lista de numeros primos.
        MostrarPrimos(primos,numero);
    }

    //Pergunta e guarda a resposta do usuario.
    public static String PerguntarNumero(){
        final String pergunta = "A partir de qual numero você deseja criar uma sequencia de numeros primos ?";
        
        //Pergunta a resposta do usuario.
        userInput = new Scanner(System.in);
        System.out.println(pergunta); 
        String entrada = userInput.nextLine();
        
        //Valida e devolve a resposta do usuario.
        return ValidarEntrada(entrada); 
    }

    //Repete a pergunta se estiver invalida.
    public static String ValidarEntrada(String entrada){
        if (!VerificarSeNumerico(entrada)) {
            ErroNumerico();
            entrada = PerguntarNumero();
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

    //Calcula a sequencia de numeros primos e guarda na array list.
    public static void GuardarPrimos(int numero,ArrayList<Integer> primos){
        for (int index = numero; index >= 2 ; index--) {
            if (VerificarPrimo(index)){
                primos.add(index);
            }
        }
    }

    //Verifica se o numero é primo.
    public static boolean VerificarPrimo(int numero){
        boolean possuiPrimo = true;
    
        for (int index = 2; index < numero; index++) {
            if (numero % index == 0) {
                possuiPrimo = false;
            }
        }
        return possuiPrimo;
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

    //Exibe a lista de numeros primos.
    public static void MostrarPrimos(ArrayList<Integer> primos,int numero){
        LimparTela();
        System.out.println(MessageFormat.format("A sequencia de numeros primos apartir do numero {0} é: {1}",numero,TransformarLista(primos))); 
    }
    
    //limpa a tela de comandos.
    public static void LimparTela() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    //Mostra uma mensagem de erro caso a entrada não seje valida.
    public static void ErroNumerico(){
        System.out.println("Apenas numeros inteiros são permitidos!"); 
    }
}
