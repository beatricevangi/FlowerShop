import java.util.Scanner;

public class MenuCustomer implements Menu{

    @Override
    public void show() {
        //todo
        int menuItem;
        Program p;

        System.out.println("FLORIST SHOPPE");
        System.out.println("1: i miei ordini");
        System.out.println("2: crea un ordine");
        System.out.println("3: logout");


        Scanner input = new Scanner(System.in);
        menuItem = input.nextInt();

        switch(menuItem){
            case 1:
                // si apre menulogin
                p = Program.getInstance();
                p.setMenu(new LoginMenu());
                break;

            case 2:
                // TODO si apre il coso degli ordini fatti dall'utente
                p = Program.getInstance();
                // p.
                break;

            case 3:
                // TODO si apre il coso per fare ordini
                break;

            default:
                System.err.println("Input non valido");
        }
    }

}
