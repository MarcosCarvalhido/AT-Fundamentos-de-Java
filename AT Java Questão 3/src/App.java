import java.util.ArrayList;
import java.util.Scanner;
import java.text.MessageFormat;

public class App {
    static Scanner userInput = new Scanner(System.in,"UTF-16");
    public static void main(String[] args) throws Exception {
        int numero = 0; // numero informado pelo usuario que será usado como base para calcular os numeros primos.
        boolean primo;
        
        //Pergunta para o usuario e verifica as informações necessarias.
        numero = Integer.parseInt(PerguntarNumero());

        //verifica se o numero informado é prio.
        primo = VerificarPrimo(numero);

        //Mostra a resposta se é primo ou não.
        MostrarResposta(numero,primo);
    }
    //Pergunta e guarda a resposta do usuario.
    public static String PerguntarNumero(){
        final String pergunta = "Insira um numero para verificar se é primo:";
        
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
            do {                
                ErroNumerico();
                entrada = PerguntarNumero();
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
    
    //Mostra o resultado para o usuario.
    public static void MostrarResposta(int numero, boolean primo){
        LimparTela();
        String resposta;
        if (primo) {
            resposta = "é";
        }
        else{
            resposta = "não é";
        }

        System.out.println(MessageFormat.format("O numero {0} {1} primo!",numero,resposta));
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
