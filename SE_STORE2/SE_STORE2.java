package SE_STORE2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SE_STORE2 {
    public static void main(String[] args) throws FileNotFoundException {
        File Product = new File("C:\\Users\\ghost\\IdeaProjects\\untitled\\src\\SE_STORE2\\PRODUCT (4).txt");;
        Scanner countNum = new Scanner(System.in);
        int typeNumber;
        ArrayList<String> product = new ArrayList<String>();
        boolean loopOrNot = true;
        ArrayList<Double> cost = new ArrayList<Double>();
        ArrayList<Integer> quantity = new ArrayList<Integer>();
        Scanner reader = new Scanner(Product);
        ArrayList<String>id = new ArrayList<String>();
        int countProduct=0;
        ArrayList<String> idCategory = new ArrayList<String>();
        File category = new File("C:\\Users\\ghost\\IdeaProjects\\untitled\\src\\SE_STORE2\\CATEGORY.txt");
        ArrayList<String>nameCategory = new ArrayList<String>();
        String typeCategory;
        Scanner inputCategory = new Scanner(category);
        boolean quit = false;
        ArrayList<String> hostIdCategory = new ArrayList<String>();
        boolean loopCategory = true;
        Scanner inputTypeCategory = new Scanner(System.in);

        while(reader.hasNextLine()){
            String[] line = reader.nextLine().split("\\s+");
            id.add(line[0]);
            product.add(line[1]);
            cost.add(Double.parseDouble(line[2].replace("$", "")));
            quantity.add(Integer.parseInt(line[3]));
            idCategory.add(line[4]);
        }

        while(inputCategory.hasNextLine()){
            hostIdCategory.add(inputCategory.next());
            nameCategory.add(inputCategory.nextLine());
        }

        while(loopOrNot == true){
            System.out.printf(
                    "\t===== SE STORE =====\t\t\t\n" +
                    "\t1. Show Category\t\t\t\n" +
                    "\t2. Exit\t\t\t\n" +
                    "\t====================\t\t\t\n" +
                    "\tSelect (1-2) :\t");
            typeNumber = countNum.nextInt();
            if(typeNumber == 1) {
                while(loopCategory){
                    System.out.printf("\t=========== SE STORE's Product Categories ===========\t\t\t\n" +
                            "\t#\t    Category\n");
                    for (countProduct = 0; countProduct < nameCategory.size(); countProduct++) {
                        System.out.printf("\t%-3d %-15s\n",
                            countProduct + 1,
                            nameCategory.get(countProduct));
                    }
                    System.out.printf("\t=========================================\t\t\t\n" +
                            "\tSelect Category to Show Product (1-"+(nameCategory.size())+") or Q for exit\n" +
                            "\tSelect : ");
                    typeCategory = inputTypeCategory.nextLine();
                    int choosedTypeCategory = -1;
                    if(typeCategory.equalsIgnoreCase("Q")){
                        loopCategory = false;
                    }else{
                        try{
                            choosedTypeCategory = Integer.parseInt(typeCategory);
                            if (choosedTypeCategory >= 1 && choosedTypeCategory <= nameCategory.size()) {
                                System.out.println("\t============ "+nameCategory.get(choosedTypeCategory-1)+" ============\t\t\t\n" +
                                        "\t#\tName\t    \tPrice(฿)  Quantity");
                                countProduct = 1;
                                for(int i = 0 ; i < idCategory.size() ; i++){
                                    if(idCategory.get(i).equals(hostIdCategory.get(choosedTypeCategory-1))){
                                        System.out.printf("\t%-3d %-15s $%-9.2f %-10d\n",
                                                countProduct,
                                                product.get(i),
                                                cost.get(i),
                                                quantity.get(i));
                                        countProduct++;
                                    }
                                }
                                System.out.print("\t================================\t\t\t\n" +
                                        "\tPress Q to Exit\t");
                                typeCategory = inputTypeCategory.nextLine();
                                while(!typeCategory.equalsIgnoreCase("q")){
                                    System.out.print("\tPress Q to Exit\t");
                                    typeCategory = inputTypeCategory.nextLine();
                                }
                            } else {
                                System.out.println("Invalid number, please enter a value between 1-"+nameCategory.size());
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input, please enter a valid number 1-"+nameCategory.size()+" or Q/q.");
                        }
                    }
                }
                System.out.printf("\t===========================================\t\n");
            }else if(typeNumber == 2){
                System.out.printf("\t===== SE STORE =====\t\t\t\n" +
                        "Thank you for using our service :3\t");
                loopOrNot = false;
                System.exit(0);
            }
        }
    }
}
//	        Price	   Quantity
//	%-3d %-15s $%-9.2f %-10d