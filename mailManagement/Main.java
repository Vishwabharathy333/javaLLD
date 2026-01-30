package maailManagement;

import java.util.*;

class Main{
    public static void main(String[] args){
        MailManagementSystem system = new MailManagementSystem();
        int choice;
        do{
            system.displayMenu();
            choice = system.getUserChoice();

            switch(choice){
                case 1:
                    system.storeMail();
                    break;
                case 2:
                    system.deleteMail();
                    break;
                case 3:
                    system.addTag();
                    break;
                case 4:
                    system.showStats();
                    break;
                case 5:
                    system.search();
                    break;
                case 6:
                    system.wildcardSearch();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
            }
        } while(choice != 7);
    }
}
