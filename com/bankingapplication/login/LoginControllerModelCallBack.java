package com.bankingapplication.login;


import java.util.List;

interface LoginControllerModelCallBack {
    void getNewUserDetails(List<String> bankNames);

    void newUserCreationFailed(String msg);

    void newUserCreatedSuccessfully(String accountNumber, String userName);

    void userLoginFailed(String msg);

    void userLoginSuccessful(String userName, String firstName);
}
