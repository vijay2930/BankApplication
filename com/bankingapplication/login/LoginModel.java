package com.bankingapplication.login;


import com.bankingapplication.dto.Account;
import com.bankingapplication.repository.Repository;

import java.util.List;

public class LoginModel implements LoginModelCallBack{
    private LoginControllerModelCallBack loginController;
    private Repository repository;
    public LoginModel(LoginControllerModelCallBack loginController) {
        this.loginController = loginController;repository=Repository.getInstance();
    }

    @Override
    public void exit() {
        repository.save();
    }

    @Override
    public void getAllBankNamesForNewUser() {
        List<String> bankNames=repository.getBankNames();
        loginController.getNewUserDetails(bankNames);
    }

    @Override
    public void createNewUser(Account account) {
        Account newAccount=repository.createAccount(account);
        if(newAccount==null){
            loginController.newUserCreationFailed("Something went wrong.Try again");
        }else {
            loginController.newUserCreatedSuccessfully(account.getAccountNumber(),account.getUserName());
        }
    }

    @Override
    public void checkValidLogin(String userName, String mPin) {
        Account account=repository.getAccount(userName,mPin);
        if(account==null){
            loginController.userLoginFailed("UserName or mpin is inCorrect");
        }else {
            loginController.userLoginSuccessful(account.getUserName(),account.getFirstName());
        }
    }
}
