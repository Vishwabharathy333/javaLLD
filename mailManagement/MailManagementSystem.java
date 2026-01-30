package maailManagement;

import java.util.*;
import java.util.stream.Collectors;

class MailManagementSystem{
    private List<Mail> mails;
    private Set<String> spamWord;
    private Scanner sc;

    public MailManagementSystem(){
        mails = new ArrayList<>();
        spamWord = new HashSet<>(Arrays.asList("lottery", "winner", "prize", "free", "urgent", "congratulations"));
        sc = new Scanner(System.in);
    }

    public void storeMail(){
        System.out.println("Enter the Sender Email: ");
        String sender = sc.nextLine();
        System.out.println("Enter the Reciever Email: ");
        String receiver = sc.nextLine();
        System.out.println("Enter Subject: ");
        String subject = sc.nextLine();
        System.out.println("Enter Content");
        String content = sc.nextLine();

    Mail mail = new Mail(sender, receiver, subject, content);
    checkSpam(mail);
    mails.add(mail);
    System.out.println("Mail Stored Successfully.");
    }

    public void deleteMail(){
        System.out.println("Enter the mail Index to delete: ");
        int index = sc.nextInt();
        sc.nextLine();
        if (index >= 0 && index < mails.size()){
            mails.remove(index);
            System.out.println("Mail deleted successfully!");
        } else {
            System.out.println("Invalid mail index!");
        }
    }

    public void addTag(){
        System.out.println("Enter the mail Index: ");
        int index = sc.nextInt();
        sc.nextLine();
        if (index >= 0 && index < mails.size()){
            System.out.println("Enter tag: ");
            String tag = sc.nextLine();
            mails.get(index).addTag(tag);
            System.out.println("Tag added successfully!");
        } else {
            System.out.println("Invalid mail index!");
        }
    }

    public void showStats(){
        System.out.println("Mail Statistics: ");
        System.out.println("Total Mails: " + mails.size());

        System.out.println("Enter the number of recent Mails: ");
        int n = sc.nextInt();
        sc.nextLine();
        mails.stream().skip(Math.max(0, mails.size() - n)).forEach(System.out::println);
    }

    public void checkSpam(Mail mail){
        String content = mail.getContent().toLowerCase();
        for (String word : spamWord){
            if (content.contains(word)){
                mail.setSpam(true);
            }
        }
    }

    public void search(){
        System.out.println("Enter search query:");
        String query = sc.nextLine().toLowerCase();

        List<Mail> results = mails.stream()
            .filter(mail ->
                mail.getSender().toLowerCase().contains(query) ||
                mail.getReceiver().toLowerCase().contains(query) ||
                mail.getSubject().toLowerCase().contains(query) ||
                mail.getContent().toLowerCase().contains(query)||
                mail.getTags().stream().anyMatch(tag -> tag.toLowerCase().contains(query)))
            .collect(Collectors.toList());

        if (results.isEmpty()){
            System.out.println("No mail found the match of the querry.");
        }else{
            System.out.println("\n Search Result: ");
            results.forEach(System.out::println);
        }
    }
    public void wildcardSearch(){
        System.out.println("Enter wildcard pattern (use * for any characters):");
        final String Pattern = sc.nextLine().toLowerCase().replace("*",".*");

        List<Mail> results = mails.stream()
            .filter(mail ->
                mail.getSender().toLowerCase().matches(Pattern) ||
                mail.getReceiver().toLowerCase().matches(Pattern) ||
                mail.getSubject().toLowerCase().matches(Pattern) ||
                mail.getContent().toLowerCase().matches(Pattern)||
                mail.getTags().stream().anyMatch(tag -> tag.toLowerCase().matches(Pattern)))
            .collect(Collectors.toList());

        if (results.isEmpty()){
            System.out.println("No mail found the match of the querry.");
        }else{
            System.out.println("\n WildSearch Result: ");
            results.forEach(System.out::println);
        }
    }

    public int getUserChoice() {
        int choice = sc.nextInt();
        sc.nextLine(); // clear buffer
        return choice;
    }
    
    public void displayMenu(){
        System.out.println("\nMail Management System");
        System.out.println("1. Store Mail");
        System.out.println("2. Delete Mail");
        System.out.println("3. Add Tag");
        System.out.println("4. Show Statistics");
        System.out.println("5. Search");
        System.out.println("6. Wildcard Search");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }
}
