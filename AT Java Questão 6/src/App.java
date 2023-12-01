public class App {
    public static void main(String[] args) throws Exception {
        Pessoa p1 = new Pessoa("Marcos", 60, 25);
        p1.setSobrenome("Rodrigues");

        System.out.print("Nome Completo P1: ");
        System.out.println(p1.NomeCompleto());

        p1.setPeso(p1.getPeso() + 2);

        Pessoa p2 = p1;

        System.out.print("Idade P2: ");
        System.out.println(p2.getIdade());
        
        p1.setIdade(p1.getIdade() + 1);
        
        System.out.print("Idade P2: ");
        System.out.println(p2.getIdade());
        
        
        System.out.println("Pode doar sanguee P1: " + p1.DoadorDeSangue());
        System.out.println("Inicias P1: " + p1.Iniciais());
    }
}
