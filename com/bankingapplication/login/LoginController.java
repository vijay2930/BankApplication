package com.bankingapplication.login;


import com.bankingapplication.dto.Account;

import java.util.List;

class LoginController implements LoginControllerViewCallBack,LoginControllerModelCallBack{
    private LoginModelCallBack loginModel;
    private LoginViewCallBack loginView;
    public LoginController(LoginViewCallBack loginView) {
        this.loginView = loginView;
        this.loginModel=new LoginModel(this);
    }

    @Override
    public void exit() {
        loginModel.exit();
    }

    @Override
    public void getAllBankNamesForNewUser() {
        loginModel.getAllBankNamesForNewUser();
    }

    @Override
    public void createNewUser(Account account) {
        loginModel.createNewUser(account);
    }

    @Override
    public void checkValidLogin(String userName, String mPin) {
        loginModel.checkValidLogin(userName,mPin);
    }


    @Override
    public void getNewUserDetails(List<String> bankNames) {
        loginView.getNewUserDetails(bankNames);
    }

    @Override
    public void newUserCreationFailed(String msg) {
        loginView.newUserCreationFailed(msg);
    }

    @Override
    public void newUserCreatedSuccessfully(String accountNumber, String userName) {
        loginView.newUserCreatedSuccessfully(accountNumber,userName);
    }

    @Override
    public void userLoginFailed(String msg) {
        loginView.userLoginFailed(msg);
    }

    @Override
    public void userLoginSuccessful(String userName, String firstName) {
        loginView.userLoginSuccessful(userName,firstName);
    }
}