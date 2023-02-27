package com.bankingapplication.login;


import com.bankingapplication.dto.Account;

public interface LoginModelCallBack {

    void exit();

    void getAllBankNamesForNewUser();

    void createNewUser(Account account);

    void checkValidLogin(String userName, String mPin);
}
