
import java.util.*;
/**
 * ASS2_MorgageCalc - Write a description here.
 * 
 * @author Brent Martin
 * @version 1.0
 */
// Standard import for the Scanner class
import java.util.*;
import java.text.SimpleDateFormat;  
import java.util.Date;
public class ASS2_MorgageCalc {
    public static void main (String [] args) {
        // Create a Scanner object attached to the keyboard
        Scanner in = new Scanner (System.in);
        //Vars
        String accountNum; 
        Integer chkDig = 0;
        String accountName;
        String mortgageProp;
        Double prinAmount;
        Integer termVal;
        Integer amorVal;
        Double intRate;
        Double totalPrin = 0.0;
        Double monthlyPrin;
        Double monthlyInt;
        Double openingBal = 0.0;
        Double closingBal = 0.0;
        Double totalInt = 0.0;
        Double emr;
        Double monthlyRate;
        Integer z = 0;
        int a = 0;

        //methods to get local time
        SimpleDateFormat formatter = new SimpleDateFormat(" E MMM dd HH:mm:ss z yyyy");  
        Date date = new Date(); 

        // Write your code here!!!!
        System.out.print("Enter account number: ");
        accountNum = in.nextLine();//assigning account number
        Boolean invalid = true;

        while(invalid == true){//loop to check if account num is valid
            if(accountNum.length() == 8){//checking lenght
                Boolean allDig = false;
                for(int i = 0; i < 8; i++){//checking if digits
                    //Character.isDigit(accountNum.charAt(i));
                    if(Character.isDigit(accountNum.charAt(i))){
                        z++; 
                    }
                    if(z == 8){
                        allDig = true;
                    }
                }   
                if(allDig){
                    char index1 = accountNum.charAt(0);
                    char index2 = accountNum.charAt(1);
                    char index3 = accountNum.charAt(2);
                    char index4 = accountNum.charAt(3);
                    char index5 = accountNum.charAt(4);
                    char index6 = accountNum.charAt(5);
                    char index7 = accountNum.charAt(6);
                    char lastDig = accountNum.charAt(7);

                    int in1 = Character.getNumericValue(index1);
                    //System.out.println(in1);
                    int in2 = (Character.getNumericValue(index2)) * 2; 
                    //System.out.println(in2);
                    int in3 = Character.getNumericValue(index3);
                    //System.out.println(in3);
                    int in4 = (Character.getNumericValue(index4)) * 2;
                    //System.out.println(in4);
                    int in5 = Character.getNumericValue(index5);
                    //System.out.println(in5);
                    int in6 = (Character.getNumericValue(index6)) * 2;
                    //System.out.println(in6);
                    int in7 = Character.getNumericValue(index7);
                    //System.out.println(in7);
                    int lastDigit = Character.getNumericValue(lastDig);

                    int sum = in1 + in2 + in3 + in4 + in5 + in6 +in7;

                    //System.out.print(sum);
                    int checkDigit = (sum % 10);
                    //System.out.print(checkDigit);

                    if(checkDigit == lastDigit){//checking if check digit is correct
                        invalid = false;
                    }else{
                        System.out.println("Invalid account number, check digit does not match last digit! ");
                        System.out.print("Enter account number: ");
                        accountNum = in.nextLine();
                        invalid = true;
                    }                    
                }else{
                    System.out.println("Invalid account number, the account number needs to be 8 digits");
                    System.out.print("Enter account number: ");
                    accountNum = in.nextLine();
                    invalid = true;
                }
            }else{
                System.out.println("Invalid account number, the account number needs to be 8 digits"); 
                System.out.print("Enter account number: ");
                accountNum = in.nextLine();
                invalid = true;
            }
        }

        System.out.print("Enter client name: ");
        accountName = in.nextLine();//assignign clients name

        System.out.print("Enter address of mortgage property: ");
        mortgageProp = in.nextLine();//assigning address

        System.out.print("Enter principal amount: ");
        prinAmount = in.nextDouble();//assigning priciple amount
        openingBal = prinAmount;

        System.out.println("Available Terms and Rates");//table of intrest rates
        System.out.printf("%10s%11s%n", "Term", "Rate");
        System.out.printf("%10s%11s%n", "1 Year", "3.59%");
        System.out.printf("%10s%11s%n", "2 Year", "3.74%");
        System.out.printf("%10s%11s%n", "3 Year", "2.96%");
        System.out.printf("%10s%11s%n", "5 Year", "3.29%");
        System.out.printf("%10s%11s%n", "10 Year", "6.10%");
        System.out.println(" ");

        System.out.print("Enter mortgage term in years (1, 2, 3, 5, 10): ");
        termVal = in.nextInt();//assigning mortgage term
        Boolean invalid1 = true;

        while(invalid1 == true){//error checking mortgage term input
            if(termVal == 1){
                invalid1 = false; 
            }else if(termVal == 2){
                invalid1 = false; 
            }else if(termVal == 3){
                invalid1 = false; 
            }else if(termVal == 5){
                invalid1 = false; 
            }else if(termVal == 10){
                invalid1 = false; 
            }else{
                invalid1 = true;
                System.out.print(termVal +" is an invaild Entry. Please re-enter.");
                System.out.print(" Enter mortgage term (1, 2, 3, 5, 10): ");
                termVal = in.nextInt();
            }
        }

        if(termVal == 1){//assigning intrest rate based on mortgage term
            intRate = 0.0359;
        }else if(termVal == 2){
            intRate = 0.0374;
        }else if(termVal == 3){
            intRate = 0.0296;
        }else if(termVal == 5){
            intRate = 0.0329;
        }else{
            intRate = 0.0610;
        }

        System.out.print("Enter mortgage amortization period (5, 10, 15, 20, 25): ");
        amorVal = in.nextInt();//assigning amortization period
        Boolean invalid2 = true;

        while(invalid2 == true){//error checking amortization input
            if(amorVal == 5){
                invalid2 = false; 
            }else if(amorVal == 10){
                invalid2 = false; 
            }else if(amorVal == 15){
                invalid2 = false; 
            }else if(amorVal == 20){
                invalid2 = false; 
            }else if(amorVal == 25){
                invalid2 = false; 
            }else{
                invalid2 = true;
                System.out.print(amorVal + " is an invaild Entry. Please re-enter.");
                System.out.print("Enter mortgage amortization period (5, 10, 15, 20, 25): ");
                amorVal = in.nextInt();
            }
        }

        emr = (Math.pow(Math.pow((1.0 + intRate/2.0),2.0),1.0/12))-1.0; //calculating EMR     
        monthlyRate = prinAmount * (emr * (Math.pow((1.0 + emr),(amorVal * 12.0))))/(Math.pow(( 1.0 + emr),(amorVal * 12.0)) - 1);// calculating monthly payment

        System.out.println("Monthly payment amount is: " + Math.round(monthlyRate * 100.0) / 100.0);//printing out rounded monthly payment amout
        System.out.println("");

        System.out.println("Payment schedule for " + accountName);//printing out client information
        System.out.println("Produced" + formatter.format(date));
        System.out.println("Property address: " + mortgageProp);
        System.out.println("Amortization period (in years): " + amorVal);
        System.out.println("Term of mortgage (in years): " + termVal);
        System.out.println("Interest rate: " + ((double) Math.round((intRate *100) * 100) / 100) + "%");//printing out rounded intrest rate

        //printing out payment sched
        System.out.printf("%54s%n", "Monthly Payment Schedule");
        System.out.println(" ");
        System.out.printf("%5s%15s%15s%15s%15s%15s%n", "Month", "Open Bal", "Payment", "Princ", "Intrest", "Closing Bal");

        for(int n = 1; n <= (termVal * 12); n++){//calculating each month for payment schedual                
            emr = (Math.pow(Math.pow((1.0 + intRate/2.0),2.0),1.0/12))-1.0; //emr calculation       
            monthlyRate = prinAmount * (emr * (Math.pow((1.0 + emr),(amorVal * 12.0))))/(Math.pow(( 1.0 + emr),(amorVal * 12.0)) - 1);//monthly payment calculation     
            monthlyInt = (openingBal * emr);//monthly intrest calculation       
            monthlyPrin = (monthlyRate - monthlyInt); //monthly pricipal calculation       
            closingBal = (openingBal - monthlyPrin);//closing balance calculation
            System.out.printf("%5d%15.2f%15.2f%15.2f%15.2f%15.2f%n", n, openingBal, monthlyRate, monthlyPrin, monthlyInt, closingBal);
            totalPrin += monthlyPrin;//adding to total values
            totalInt += monthlyInt;//adding to total values
            openingBal = closingBal;//making opening balance equal to the previous months closing balance

        }
        for(int i = 0; i < 80; i++){//printing line under table
            System.out.print("=");
        }
        System.out.println(" ");
        System.out.printf("%5s%45.2f%15.2f", "Ttls", totalPrin, totalInt);//printing out totals

    }
}
