import java.util.Scanner;

public class App {
    static Scanner userInput = new Scanner(System.in,"UTF-16");
    public static void main(String[] args) throws Exception {
        int tipo;  // Tipo de investimento a ser aplicado.
        String nome; //Nome titular da aplicação.
        String cpf; //CPF do titular da aplicação.
        String banco; //Banco onde a aplicação vai ser feita
        
        double capital; //Quantidade de capital aplicado.
        double cdi; //valor do juros CDI mensal
        int meses; //Tempo em meses gasto na aplicação.

        RendaFixa investimento = null; //Objeto renda fixa que sera usado para guardar as informações.

        //Mostra o menu com as perguntas.
        MostrarMenu(Pergunta.MENU_INICIAL);
        
        //Pergunta qual tipo de investimento vai ser calculado.
        tipo = Integer.parseInt(PerguntarNumeros(Pergunta.TIPO_DE_INVESTIMENTO));
            
        //Coleta cada uma das informações necessarias.
        nome = PerguntarNomes(Pergunta.NOME);
        cpf = PerguntarNomes(Pergunta.CPF);
        banco = PerguntarNomes(Pergunta.BANCO);
        
        capital = Double.parseDouble(PerguntarNumeros(Pergunta.CAPITAL));
        cdi = Double.parseDouble(PerguntarNumeros(Pergunta.CDI));
        meses = Integer.parseInt(PerguntarNumeros(Pergunta.MESES));
        
        //Agrupa as informações e guarda.
        investimento = GuardarInformações(investimento,tipo,nome,cpf,banco,capital,cdi,meses);
        
        //Mostra o menu com as respostas finais.
        MostrarMenu(Pergunta.MENU_FINAL);

        System.out.println(investimento.toString());
        System.out.println(investimento.calcularResgate());
    }

    //Seleciona uma das opçõe de pergunta possiveis;
    public static String EscolherPergunta(Pergunta tipo){
        String pergunta = "";
        switch (tipo) {
            case TIPO_DE_INVESTIMENTO:
                pergunta = "Qual o tipo de investimento que você quer aplicar? \n [0] - CDB \n [1] - LCA \n [2] - LCI \n [3] - Poupança ";
                break;
        
            case NOME:
                pergunta = "Qual o Nome do titular da aplicação ?";
                break;
        
            case CPF:
                pergunta = "Qual O CPF do titular da aplicação ?";
                break;
        
            case BANCO:
                pergunta = "Qual o banco onde a aplicação sera feita ?";
                break;
        
            case CAPITAL:
                pergunta = "Qual o valor inicial que será aplicado ?";
                break;
        
            case CDI:
                pergunta = "Qual o CDI atual ?";
                break;
        
            case MESES:
                pergunta = "Qual a quantidade de meses que o valor será aplicado?";
                break;
        
            default:
                break;
        }
        return pergunta;        
    }

    // Recebe os inputs numericos do usuario.
    public static String PerguntarNumeros(Pergunta tipo){
        String pergunta = "";
        pergunta = EscolherPergunta(tipo);
        //Pergunta a resposta do usuario.
        userInput = new Scanner(System.in);
        System.out.println(pergunta); 
        String entrada = userInput.nextLine();
        
        //Valida e devolve a resposta do usuario.
        return ValidarEntradaNumeros(entrada,tipo); 
    }

    // Recebe os string ao usuario.
    public static String PerguntarNomes(Pergunta tipo){
        String pergunta = "";
        pergunta = EscolherPergunta(tipo);
        //Pergunta a resposta do usuario.
        userInput = new Scanner(System.in);
        System.out.println(pergunta); 
        String entrada = userInput.nextLine();
        
        //Valida e devolve a resposta do usuario.
        return ValidarEntradaNomes(entrada,tipo); 
    }

    //Repete a pergunta se o numero invalida.
    public static String ValidarEntradaNumeros(String entrada, Pergunta pergunta){
        if (!VerificarSeNumerico(entrada)) {
           do {
                LimparTela();
                ErroNumerico();
               entrada = PerguntarNumeros(pergunta);
           } while (!VerificarSeNumerico(entrada));
        }
        LimparTela();
        return entrada;
    }

    //Repete a pergunta se o nome invalida.
    public static String ValidarEntradaNomes(String entrada, Pergunta pergunta){
        if (!VerificarSeString(entrada)) {
           do { 
                LimparTela();
                ErroNome();
               entrada = PerguntarNomes(pergunta);
           } while (!VerificarSeNumerico(entrada));
        }
        LimparTela();
        return entrada;
    }

    //Verifica se a entrada é numerica ou não nula.
    public static Boolean VerificarSeNumerico(String entrada){
        if(entrada != null){
            try {
                double numero = Double.parseDouble(entrada);
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        else{
            return false;
        }
    }

    //Verifica se a entrada é palavra ou não nula.
    public static Boolean VerificarSeString(String entrada){
        // if(entrada != null || entrada == ""){
        if(entrada == ""){
            return true;
        }
        else{
            return false;
        }
    }

    //Guarda as informações criando uma instancia da classe do tipo correto.
    public static RendaFixa GuardarInformações(RendaFixa investimento, int tipo, String nome, String cpf, String banco, double capital, double cdi, int meses){
    switch (tipo) {
        case 0:
            investimento = new CDB(nome, cpf, banco, capital, cdi, meses);
            break;
    
        case 1:
            investimento = new LCI(nome, cpf, banco, capital, cdi, meses);
            break;
    
        case 2:
            investimento = new LCA(nome, cpf, banco, capital, cdi, meses);
            break;
    
        case 3:
            investimento = new Poupança(nome, cpf, banco, capital, cdi, meses);
            break;
    
        default:
            ErroNumerico();
            break;
        }
        return investimento;
    }

    //Seleciona um dos menus e exibe no consolee.
    public static void MostrarMenu(Pergunta tipo){
        switch (tipo) {
            case MENU_INICIAL:
                LimparTela();
                System.out.println("SISTEMA DE APLICAÇÃO FINANCEIRA!"); 
                System.out.println("Siga os passos e preencha as informações:");                
                break;
        
            case MENU_FINAL:
                System.out.println("APLICAÇÃO PROCESSADA!"); 
                System.out.println("Resultados:");        
                break;
        
            default:
                ErroNumerico();
                break;
        }
    }

    //limpa a tela de comandos.
    public static void LimparTela() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    //Mostra uma mensagem de erro caso a entrada não seje valida.
    public static void ErroNumerico(){
        System.out.println("Apenas numeros são permitidos!"); 
    }

    //Mostra uma mensagem de erro caso a entrada não seje valida.
    public static void ErroNome(){
        System.out.println("Apenas Palavras são permitidas!"); 
    }
}
