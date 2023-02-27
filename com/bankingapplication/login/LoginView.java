package com.bankingapplication.login;


import com.bankingapplication.dto.Account;
import com.bankingapplication.user.UserView;
import com.bankingapplication.util.Read;

import java.util.List;

public class LoginView implements LoginViewCallBack{
    private LoginControllerViewCallBack loginController;
    public LoginView() {
        loginController=new LoginController(this);
    }
    public void init(){this.start();}

    private void start() {
        System.out.println("-------------------");
        System.out.println("Banking Application");
        System.out.println("-------------------");
        System.out.println("Main Page");
        System.out.println("----------");
        System.out.println("1. New User");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        int choice=0;
        try{
            choice= Read.changeToInt(Read.input("Enter your choice:"));
        }catch (NumberFormatException e){}
        this.checkValidChoice(choice);
    }

    private void checkValidChoice(int choice) {
        switch (choice){
            case 1:
                loginController.getAllBankNamesForNewUser();
            case 2:
                this.getLoginInfo();
            case 3:
                this.exit();
            default:
                System.out.println("Please enter the Valid choice only...");
                this.init();
        }
    }

    private void getLoginInfo() {
        System.out.println("Login Page");
        System.out.println("----------");
        String userName=Read.getUserName("Enter UserName: ");
        String mPin=Read.getPinNo("Enter MPIN: ");
        loginController.checkValidLogin(userName,mPin);
    }

    private void exit() {
        System.out.println("Thank You");
        loginController.exit();
        System.exit(0);
    }


    @Override
    public void getNewUserDetails(List<String> bankNames) {
        System.out.println("Create New User");
        System.out.println("---------------");
        String firstName=Read.input("Enter FirsName: ");
        String lastName=Read.input("Enter LastName: ");
        String dob=Read.input("Enter DOB<dd/mm/yy>: ");
        String bankName=Read.getBankName("Select Bank: ",bankNames);
        String mobile=Read.getMobile("Enter Mobile No: ");
        String mPin=Read.getPinNo("Enter MPIN: ");
        String mtPin=Read.getPinNo("Enter MTPIN: ");
        loginController.createNewUser(new Account(firstName,lastName,dob,bankName,mobile,mPin,mtPin));

    }

    @Override
    public void newUserCreationFailed(String msg) {
        System.out.println("Unable to create new User.");
        System.out.println(msg);
        System.out.println("Returning to the Main Page");
        this.init();
    }

    @Override
    public void newUserCreatedSuccessfully(String accountNumber, String userName) {
        System.out.println("User Created Successfully");
        System.out.println("Your Account No is "+accountNumber);
        System.out.println("Your UserName is "+userName);
        new UserView(userName).init();
//        Redirect
    }

    @Override
    public void userLoginFailed(String msg) {
        System.out.println("User Login Failed");
        System.out.println(msg);
        System.out.println("Returning to the Main Page");
        this.init();
    }

    @Override
    public void userLoginSuccessful(String userName, String firstName) {
        System.out.println("User Login Successfully");
        System.out.println("Welcome "+firstName);
        new UserView(userName).init();
//        Redirect
    }
}
