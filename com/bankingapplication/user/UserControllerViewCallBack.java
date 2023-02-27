package com.bankingapplication.user;


import com.bankingapplication.dto.Account;
import com.bankingapplication.dto.Request;

import java.util.List;

interface UserControllerViewCallBack {

    void getMyAccount(String userName, String mPin);

    void getMyAccountBalance(String userName, String mPin);

    void getTheirAccount(String accountId);

    void checkTransactionIsValid(String userName, String mtPin, float amount, Account theirAccount);

    void getTransactionHistory(String userName, String mtpin);

    void checkGiveRequestPaymentDetailValid(String userName, String mtpin, float amount, String accountId);

    void getMyRequests(String userName, String mtpin);

    void getIncomingRequests(String userName, String mtpin);

    void acceptingIncomingRequest(Request request, String userName, String mtpin, List<Request> requestList);

    void cancellingIncomingRequest(Request request, String userName, String mtpin, List<Request> requestList);
}
