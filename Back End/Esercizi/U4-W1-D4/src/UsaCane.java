public class UsaCane {

    public static void main(String[] args) {
        Cane cane = new Cane();

        String nome = cane.SetNome("Thor");
        String pelo = cane.coloePelo("Nero");

        System.out.println(nome);
        System.out.println(pelo);
    }
}
