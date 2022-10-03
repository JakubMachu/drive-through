import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        List<McDonalds> jidlo = createFoodMenu();
        McDonalds[] objednavka = new McDonalds[2];
        BankovniUcet ucet1 = new BankovniUcet(123456, "Osobni", "Jakub Machu", 10000);
        BankovniUcet ucet2 = new BankovniUcet(789456, "Firemni", "McDonalds", 20000);

        printWelcome();
        foodSelection(userInput, jidlo, objednavka);
        drinkSelection(userInput, jidlo, objednavka);
        orderRecieving(objednavka, ucet1, ucet2);
        proccesingOrder(objednavka, ucet1);
    }

    private static List<McDonalds> createFoodMenu() {
        McDonalds hamburger = new McDonalds("Hamburger", 1500, 1);
        McDonalds cheeseburger = new McDonalds("Cheeseburger", 2800, 2);
        McDonalds bigMac = new McDonalds("Big Mac", 4000, 3);
        McDonalds cocaCola = new McDonalds("Coca-Cola", 750, 4);
        McDonalds sprite = new McDonalds("Sprite", 500, 5);
        McDonalds fanta = new McDonalds("Fanta", 450, 6);

        return Arrays.asList(hamburger, cheeseburger, bigMac, cocaCola, sprite, fanta);
    }

    private static void proccesingOrder(McDonalds[] objednavka, BankovniUcet ucet1) {
        System.out.println("\tAuto prijelo k vydejnimu oknu.");
        System.out.println("\t<---------------------------->");
        System.out.println("\t");
        System.out.println("\tPrilozte prosim kartu k platebnimu terminalu.");
        System.out.println("\tKarta byla nactena.");
        System.out.println("\tVas aktualni zustatek je: [" + ucet1.getAktualniZustatek() + ",-] po odecteni platby u obchodnika McDonald's ve vysi ["
                + (objednavka[0].getCenaProduktu() + objednavka[1].getCenaProduktu()) + ",-].");
        System.out.println();
        System.out.println("\t#################################################################");
        System.out.println("\t# Dekujeme Vam za nakup a prejeme dobrou chut a stastnou cestu! #");
        System.out.println("\t#################################################################");
    }

    private static void orderRecieving(McDonalds[] objednavka, BankovniUcet ucet1, BankovniUcet ucet2) {
        System.out.println("\tVase objednavka se zpracovava!");
        System.out.println("\tRekapitulace Vasi objednavky: [" + objednavka[0].getNazevProduktu() + " + " + objednavka[1].getNazevProduktu() + "].");
        System.out.println("\tAktualni zustatek na osobnim uctu je: [" + ucet1.getAktualniZustatek() + ",-].");
        System.out.println("\tCelkem budete platit: [" + (objednavka[0].getCenaProduktu() + objednavka[1].getCenaProduktu()) + ",-].");
        platba(ucet1, ucet2, objednavka[0].getCenaProduktu(), objednavka[1].getCenaProduktu());
        System.out.println("\t");
        System.out.println("\tPrijedte prosim k vydejnimu oknu.");
        System.out.println();
        System.out.println("\t<-------------------------->");
        System.out.println("\tAuto jede k vydejnimu oknu.");

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("->");
                System.out.println("->->");
                System.out.println("->->->");
                Thread.sleep(1000);
            }
        } catch (Exception e) {

        }
    }

    private static void drinkSelection(Scanner userInput, List<McDonalds> jidlo, McDonalds[] objednavka) {
        System.out.println("\t< Co si date k piti? >");
        System.out.println();

        while (true) {
            for (int i = 3; i < 6; i++) {
                McDonalds drink = jidlo.get(i);
                System.out.println("\t" + (i + 1) + "." + drink.getNazevProduktu() + " -> " + drink.getCenaProduktu() + ",-");

            }

            System.out.println("\tVyberte si moznost z menu pomci cisla: ");


            String drinkMenu = userInput.nextLine();
            Pattern drinkMenuPattern = Pattern.compile("[4-6]{1}");
            Matcher drinkMenuMatcher = drinkMenuPattern.matcher(drinkMenu);

            if (drinkMenuMatcher.matches()) {
                objednavka[1] = jidlo.get(Integer.parseInt(drinkMenu) - 1);
                System.out.println("\tVybral jste moznost cislo " + "[" + drinkMenu + "]" + " " + objednavka[1].getNazevProduktu() + ".");
                System.out.println("\t----------------------------------------");
                System.out.println();
                break;
            } else {
                System.out.println("\t#######################################################");
                System.out.println("\tZadal jste spatne cislo! Zadejte pouze cisla od 4 do 6!");
                System.out.println("\t#######################################################");
                System.out.println();
            }

            if (userInput.equals("4")) {
                System.out.println("Zvolil jste moznost [4] - Coca-Cola.");
            } else if (userInput.equals("5")) {
                System.out.println("Zvolil jste moznost [5] - Sprite.");
            } else if (userInput.equals("6")) {
                System.out.println("Zvolil jste moznost [6] - Fanta.");

            }
        }
    }

    private static void foodSelection(Scanner userInput, List<McDonalds> jidlo, McDonalds[] objednavka) {
        while (true) {
            System.out.println("\tVyberte si moznost z menu pomoci cisla: ");
            for (int i = 0; i < 3; i++) {
                McDonalds drink = jidlo.get(i);
                System.out.println("\t" + (i + 1) + "." + drink.getNazevProduktu() + " -> " + drink.getCenaProduktu() + ",-");

            }

            String foodMenu = userInput.nextLine();
            Pattern foodMenuPattern = Pattern.compile("[1-3]{1}");
            Matcher foodMenuMatcher = foodMenuPattern.matcher(foodMenu);

            if (foodMenuMatcher.matches()) {
                objednavka[0] = jidlo.get(Integer.parseInt(foodMenu) - 1);
                System.out.println("\tVybral jste moznost cislo " + "[" + foodMenu + "]" + " " + objednavka[0].getNazevProduktu() + ".");
                System.out.println("\t----------------------------------------");
                System.out.println();
                break;
            } else {
                System.out.println("\t#######################################################");
                System.out.println("\tZadal jste spatne cislo! Zadejte pouze cisla od 1 do 3!");
                System.out.println("\t#######################################################");
                System.out.println();
            }

            if (userInput.equals("1")) {
                System.out.println("Zvolil jste moznost [1] - Hamburger.");
            } else if (userInput.equals("2")) {
                System.out.println("Zvolil jste moznost [2] - Cheeseburger.");
            } else if (userInput.equals("3")) {
                System.out.println("Zvolil jste moznost [3] - Big Mac.");
            }
        }
    }

    private static void printWelcome() {
        System.out.println();
        System.out.println("\t#########################");
        System.out.println("\t# Vitejte v McDonald's! #");
        System.out.println("\t#########################");
        System.out.println();
        System.out.println("\t< Co si date k jidlu? >");
        System.out.println();
    }

    public static void platba(BankovniUcet ucet1, BankovniUcet ucet2, int jidlo, int piti) {
        ucet1.setAktualniZustatek(ucet1.getAktualniZustatek() - jidlo - piti);
        ucet2.setAktualniZustatek(ucet2.getAktualniZustatek() + jidlo + piti);

    }

    public boolean dostatekPenez(int sum, long aktualniZustatek) {

        return sum <= aktualniZustatek;
    }
}


