package OnlineMCQExam;

import java.util.Scanner;

public class OnlineMCQExam {
    private String Username;
    private String Password;
    private boolean isLoggedIn;
    private int timeRemaining;
    private int noOfQuestion;
    private int[] userAns;
    private int[] correctAns;

    public static void main(String[] args) {
        System.out.println(
                "WELCOME TO ONLINE EXAMINATION - By MUSKAN \nPlease Register Your username or password");
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Your Username : ");
        String Username = s.nextLine();
        System.out.println("Enter Your Password : ");
        String Password = s.nextLine();
        OnlineMCQExam examSystem = new OnlineMCQExam(Username,Password);
        examSystem.login();
        examSystem.startExam();;

    }

    public OnlineMCQExam( String Username, String Password){
        this.Username = Username;
        this.Password = Password;
        System.out.println("Successfully register!! ");
        this.isLoggedIn = false;
        this.noOfQuestion = 10;
        this.timeRemaining = 10; //in minutes
        this.correctAns= new int[noOfQuestion];
        this.userAns = new int[noOfQuestion];

        for(int i = 0;  i < noOfQuestion; i++){
            correctAns[i] = (int) Math.round(Math.random());
        }

    }

    public void login(){

        System.out.println("Login to give exam ");
        Scanner s = new Scanner(System.in);
        System.out.println("Username :");
        String inputUsername  = s.nextLine();

        System.out.println("Password :");
        String inputPassword  = s.nextLine();

        if(inputUsername.equals(Username) && inputPassword.equals(Password)){
            isLoggedIn = true;
            System.out.println("Login Successful Best of Luck ");

        }else{
            System.out.println("Login Failed. Try Again ");

        }

    }

    public void logout(){
        isLoggedIn = false;
        System.out.println("Logout Succesful. ");
    }
    public void startExam(){
        if(!isLoggedIn){
            System.out.println("Please Login First !! ");
            return;
        }

        Scanner s1 = new Scanner(System.in);
        System.out.println("You Have " + timeRemaining + "minutes to complete the exam. ");
        for(int i = 0; i<noOfQuestion; i++){
            System.out.println("Question " + (i + 1) + ":");
            System.out.println("1. Option 1");
            System.out.println("2. Option 2");
            System.out.println("Your Answer (1 or 2):");
            int answer = s1.nextInt();
            userAns[i] = answer;
        }
        System.out.println("Would you Like to Submit ? \n1 : Yes \n2: No ");
        int n = s1.nextInt();
        if(n==1){
            submitExam();
        }else{

            try{
                Thread.sleep(timeRemaining * 10 * 1000);
            }catch(InterruptedException e){
                e.printStackTrace();

            }

        }

    }
    private void submitExam(){
        if(!isLoggedIn){
            System.out.println("Please Login first !!" );
            return;
        }
        int score = 0 ;
        for(int i = 0 ; i < noOfQuestion ; i++){
            if(userAns[i] == correctAns[i]){
                score++;
            }
        }
        System.out.println("Your Score is " + score +" out of " +noOfQuestion + ". ");
        System.out.println("Best Of Luck");
        logout();

    }
}

