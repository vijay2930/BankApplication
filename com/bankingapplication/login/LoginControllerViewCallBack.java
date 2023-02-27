package com.bankingapplication.login;


import com.bankingapplication.dto.Account;

interface LoginControllerViewCallBack {

    void exit();

    void getAllBankNamesForNewUser();

    void createNewUser(Account account);

    void checkValidLogin(String userName, String mPin);
}
