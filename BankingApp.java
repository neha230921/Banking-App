import java.util.Scanner;  
class BankDetails {  
    private String accno;  
    private String name;  
    private long balance;  
    Scanner sc = new Scanner(System.in);  
    public void openNewAccount() {  
        System.out.print("Enter Account No: ");  
        accno = sc.next();  
        System.out.print("Enter Name: ");  
        name = sc.next();  
        System.out.print("Enter Balance: ");  
        balance = sc.nextLong();  
    }  
    public void details() {  
        System.out.println("Name of account holder: " + name);  
        System.out.println("Account no.: " + accno);  
        System.out.println("Balance: " + balance);  
    }  
    public void deposit() {  
        long amt;  
        System.out.println("Enter the amount you want to deposit: ");  
        amt = sc.nextLong();  
        balance = balance + amt;  
    }  
      
    public void withdrawal() {  
        long amt;  
        System.out.println("Enter the amount you want to withdraw: ");  
        amt = sc.nextLong();  
        if (balance >= amt) {  
            balance = balance - amt;  
            System.out.println("Balance after withdrawal: " + balance);  
        } else {  
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!" );  
        }  
    }  
    
    public boolean search(String ac_no) {  
        if (accno.equals(ac_no)) {  
            details();  
            return (true);  
        }  
        return (false);  
    }  
}  
public class BankingApp {  
    public static void main(String arg[]) {  
        Scanner sc = new Scanner(System.in);  
        
        System.out.print("How many number of users do you want to create an account? ");  
        int n = sc.nextInt();  
        BankDetails C[] = new BankDetails[n];  
        for (int i = 0; i < C.length; i++) {  
            C[i] = new BankDetails();  
            C[i].openNewAccount();  
        }  
       
        int ch;  
        do {  
            System.out.println("\n *****Banking Application*****");  
            System.out.println("1. Display all details \n 2. Search by Account number\n 3. Deposit the amount \n 4. Withdraw the amount \n 5.Exit ");  
            System.out.println("Enter your choice: ");  
            ch = sc.nextInt();  
                switch (ch) {  
                    case 1:  
                        for (int i = 0; i < C.length; i++) {  
                            C[i].details();  
                        }  
                        break;  
                    case 2:  
                        System.out.print("Enter account no. you want to search: ");  
                        String ac_no = sc.next();  
                        boolean found = false;  
                        for (int i = 0; i < C.length; i++) {  
                            found = C[i].search(ac_no);  
                            if (found) {  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Search failed! Account doesn't exist!!");  
                        }  
                        break;  
                    case 3:  
                        System.out.print("Enter Account no. : ");  
                        ac_no = sc.next();  
                        found = false;  
                        for (int i = 0; i < C.length; i++) {  
                            found = C[i].search(ac_no);  
                            if (found) {  
                                C[i].deposit();  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Search failed! Account doesn't exist!!");  
                        }  
                        break;  
                    case 4:  
                        System.out.print("Enter Account No : ");  
                        ac_no = sc.next();  
                        found = false;  
                        for (int i = 0; i < C.length; i++) {  
                            found = C[i].search(ac_no);  
                            if (found) {  
                                C[i].withdrawal();  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Search failed! Account doesn't exist!!");  
                        }  
                        break;  
                    case 5:  
                        System.out.println("Exit");  
                        break;  
                }  
            }  
            while (ch != 5);  
        }  
    }  