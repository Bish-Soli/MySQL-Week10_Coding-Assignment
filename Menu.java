package application;

import dao.FruitDao;
import entity.Fruit;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private  FruitDao fruitDao = new FruitDao();
    private Scanner sc = new Scanner(System.in);
    private List<String> options = Arrays.asList(
            "Display Fruits",
            "Delete a Fruit",
            "Update a Fruit",
            "Create a Fruit");

    public void start() {
        String selection = "";
        do {
            printMenu();
            selection = sc.nextLine();
            try{
                if (selection.equals("1")) {
                    displayFruits();

                } else if (selection.equals("2")) {
                    deleteFruit();
                } else if (selection.equals("3")) {
                    updateFruit();
                } else if (selection.equals("4")) {
                    createFruit();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }



            System.out.println("Press enter to continue...");
            sc.nextLine();

        } while (!selection.equals("-1"));
    }




    private void printMenu() {
        System.out.println("Select an Option:\n---------------" );
        for(int i = 0 ; i < options.size(); i++)
        {
            System.out.println(i+1+") "+options.get(i));
        }
    }

    private void displayFruits() throws SQLException {
        List<Fruit> fruits = fruitDao.getFruit();
        for(Fruit fruit : fruits)
        {
            System.out.println(fruit.getFruitId() + " " + fruit.getName() + " "+ fruit.getScientific_name());
        }


    }
    private void deleteFruit() throws SQLException {
        System.out.println("Enter ID: ");
        int entry = sc.nextInt();

        fruitDao.deleteFruit(entry);
        sc.nextLine();

    }

    private void updateFruit() throws SQLException {
        System.out.println("Enter ID: ");
        int entry = sc.nextInt();
        sc.nextLine(); //clear buffer
        System.out.println("Enter name:");
        String newName = sc.nextLine();
        System.out.println("Enter scientific name:");
        String newSN = sc.nextLine();
        fruitDao.updateFruit(entry, newName, newSN);

    }

    private void createFruit()throws SQLException {
        System.out.println("Enter a name: ");
        String name = sc.nextLine();
        System.out.println("Enter a Scientific name: ");
        String SN = sc.nextLine();
        fruitDao.createFruit(name,SN);
        sc.nextLine();

    }








}
