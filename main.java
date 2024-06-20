package practice;
import java.util.Scanner;
class bankaccount {
	String accountno;
	String name;
	String accounttype;
	long balance;
	Scanner a = new Scanner(System.in);
	public void openaccount() {
		System.out.println("please enter your acccount number");
		accountno = a.nextLine();
		System.out.println("please enter your name");
		name = a.nextLine();
		System.out.println("please enter your account type");
		accounttype = a.next();
		System.out.println("please enter your balance");
		balance = a.nextLong();
	}
	public void showAccount() {
		System.out.println("Name of account holder" + name);
		
		System.out.println("Name of account holder" + accountno);
		System.out.println("Name of account holder" + accounttype);
		System.out.println("Name of account holder" + balance);
		
	}
	public void deposit() {
		long amt;
		System.out.println("Enter the amount you want to deposit ");
		amt = a.nextLong();
		amt = amt+ balance;
		System.out.println("your current balance will be" + amt);
	}
	public void withdrawal() {
		long amt;
		System.out.println("Enter the amount to be withdrawal");
		amt = a.nextLong();
		if(balance>=amt)
			{
			balance = balance - amt;
			System.out.println("current balance" + balance);
			}
		else {
			System.out.println("your balance isl less");
		}
	}
	public boolean search(String ac_no){
		if (accountno.equals(ac_no)) {
		showAccount();
		return (true);
		}
		return(false);
	}
}
public class bankingapplication {
	public static void main(String[] args) {
		System.out.println("Welcome to the MULLA  bank !!");
		Scanner b = new Scanner (System.in);
		System.out.println("How many number of costumers do you want to input ?");
	int n = b.nextInt();
	bankaccount C[] = new bankaccount[n];
	for (int i = 0;i<C.length;i++) {
		C[i] = new bankaccount();
		C[i].openaccount();
	}
	int ch;
	do {
		System.out.println("BANKING SYSTEM APPLICATION");
		System.out.println("\"1. Display all account details \\n 2. Search by Account number\\n 3. Deposit the amount \\n 4. Withdraw the amount \\n 5.Exit \"");
	System.out.println("Enter your choice");
	ch = b.nextInt()	;
	switch(ch) {
	case 1 :
		for (int i = 0;i<C.length;i++) {
			C[i].showAccount();
		}
		break;
	case 2 :
		System.out.println("Enter account no. you want to search");
	String ac_no = b.next();
	boolean found = false;
	for (int i = 0 ; i<C.length;i++) {
		found = C[i].search(ac_no);
		if(found) {
			break;
		}
	}
	if(!found) {
		System.out.println("Search failed! Account not found");
	}
	break;
	case 3 :
		System.out.println("Enter Account no :");
		ac_no = b.next();
		found = false;
		for (int i = 0; i<C.length;i++) {
			found = C[i].search(ac_no);
			 if (found) {  
                 C[i].deposit();  
                 break;  
             }  
         }  
         if (!found) {  
             System.out.println("Search failed! Account doesn't exist..!!");  
         }  
         break;  
     case 4:  
         System.out.print("Enter Account No : ");  
         ac_no = b.next();  
         found = false;  
         for (int i = 0; i < C.length; i++) {  
             found = C[i].search(ac_no);  
             if (found) {  
                 C[i].withdrawal();  
                 break;  
             }  
         }  
         if (!found) {  
             System.out.println("Search failed! Account doesn't exist..!!");  
         }  
         break;  
     case 5:  
         System.out.println("See you soon...");  
         break;  
 }  
}  
while (ch != 5);  
	}
	}
