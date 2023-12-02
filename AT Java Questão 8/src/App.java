public class App {
    public static void main(String[] args) throws Exception {
        Autor a1 = new Autor("john", "ronald reuel tolkien");
        Autor a2 = new Autor("clive ", "staples lewis");
        Autor a3 = new Autor("george", "raymond richard martin");

        Livro l1 = new Livro("the hobbit", "harper colins", "1937");
        Livro l2 = new Livro("a guerra dos tronos", "suma", "1996");
        
        l1.adicionarAutor(a1);
        l1.adicionarAutor(a2);
        l2.adicionarAutor(a1);
        l2.adicionarAutor(a2);
        l2.adicionarAutor(a3);

        System.out.println(l1.imprimirFichaCatalografica());
        System.out.println(l2.imprimirFichaCatalografica());

        System.out.println(l1.buscarAutor("john ronald reuel tolkien"));
        System.out.println(l2.buscarAutor("clive staples lewis"));
        
        System.out.println(l1.removerAutor("george raymond richard martin"));
        System.out.println(l2.removerAutor("john ronald reuel tolkien"));

    }
}
