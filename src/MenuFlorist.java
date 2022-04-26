import java.util.Scanner;

public class MenuFlorist implements Menu{

    @Override
    public void show() {
        //todo
        int menuItem;
        Program p;

        System.out.println("FLORIST SHOPPE è tuo bro, 6 della gang, rimani così, fedele alla strada ");
        System.out.println("1: View OrderList");
        System.out.println("2: ");


        Scanner input = new Scanner(System.in);
        menuItem = input.nextInt();

        switch(menuItem){

            case 1:
                // TODO si apre il coso degli ordini fatti dall'utente
                p = Program.getInstance();
                // p.
                break;

            case 2:
                // TODO si apre il coso per fare ordini
                break;

            default:
                System.err.println("Input non valido");
        }
    }
}