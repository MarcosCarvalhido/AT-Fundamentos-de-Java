public class App {
    public static void main(String[] args) throws Exception {
        ArCondicionado ar1 = new ArCondicionado(26, 20);
        ArCondicionado ar2 = new ArCondicionado(25, 19);
        ArCondicionado ar3 = new ArCondicionado(24, 18);

        System.out.println("Air 1 Temperatura: " + ar1.getTemperatura());
        ar1.aumentarTemperatura();
        System.out.println("Air 1 Temperatura: " + ar1.getTemperatura());
        
        ArCondicionadoCentral central1 = new ArCondicionadoCentral(ar1, ar2, ar3);
        
        System.out.println("Status do Ar 1: " + central1.verMaquina(ar1));
        System.out.println("Temperatura media: " + central1.temperaturaMedia());

    }
}
