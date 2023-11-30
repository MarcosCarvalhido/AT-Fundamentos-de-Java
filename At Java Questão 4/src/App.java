import java.text.MessageFormat;
import java.util.Scanner;

public class App {
    static Scanner userInput = new Scanner(System.in,"UTF-16");
    public static void main(String[] args) throws Exception {
        
        final int FAIXAMAX = 5; //O numero maximo para a verificação de faixa.
        final int FAIXAMIN = 1; // o numero minimo para a verificação de faixa
        int numero = 0; // numero informado pelo usuario.

        //Pergunta para o usuario e verifica as informações necessarias.
        numero = Integer.parseInt(PerguntarNumero(FAIXAMIN,FAIXAMAX));

        //Valida se o numero informado esta na faixa.
        ValidarFaixa(numero,FAIXAMIN,FAIXAMAX);

        System.out.println("ok!");
        // MostrarResposta(numero,primo);
    }

    
    //Pergunta e guarda a resposta do usuario.
    public static String PerguntarNumero(int FAIXAMIN,int FAIXAMAX){
        
        //Pergunta a resposta do usuario.
        userInput = new Scanner(System.in);
        System.out.println(MessageFormat.format("Digite um numeros entre {0} e {1}:",FAIXAMIN,FAIXAMAX)); 
        String entrada = userInput.nextLine();
        
        //Valida e devolve a resposta do usuario.
        return ValidarEntrada(entrada,FAIXAMIN,FAIXAMAX); 
    }
    
    //Repete a pergunta se o numero não for valido.
    public static String ValidarEntrada(String entrada,int FAIXAMIN,int FAIXAMAX){
        if (!VerificarSeNumerico(entrada)) {
            ErroNumerico();
            entrada = PerguntarNumero(FAIXAMIN,FAIXAMAX);
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
    //Repete a pergunta se o numero não estiver na faixa.
    public static int ValidarFaixa(int numero,int FAIXAMIN,int FAIXAMAX){
        if (!VerificarFaixa(numero,FAIXAMIN,FAIXAMAX)) {
           do {
               ErroDeFaixa();
               numero = Integer.parseInt(PerguntarNumero(FAIXAMIN,FAIXAMAX)) ;
           } while (!VerificarFaixa(numero,FAIXAMIN,FAIXAMAX));
        }
        return numero;        
    }
    
    //Verifica se o numero informado esta dentro de uma determinada faixa.
    public static boolean VerificarFaixa(int numero, int FAIXAMIN,int FAIXAMAX) {

        if (numero > FAIXAMAX || numero < FAIXAMIN) {
            return false;
        }
        else{
            return true;
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

    //Mostra uma mensagem de erro caso a entrada não seje valida.
    public static void ErroNumerico(){
        System.out.println("Apenas numeros inteiros são permitidos!"); 
    }

    //Mostra uma mensagem de erro caso a entrada não esteje na faixa.
    public static void ErroDeFaixa(){
        System.out.println("Apenas numeros dentro da faixa são permitidos!"); 
    }
}
