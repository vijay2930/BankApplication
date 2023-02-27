package com.bankingapplication.user;


import com.bankingapplication.dto.Account;
import com.bankingapplication.dto.Request;
import com.bankingapplication.dto.Transactions;

import java.util.List;

interface UserControllerModelCallBack {

    void getMyAccountFailed(String msg);

    void getMyAccountSuccessfully(Account account);

    void getMyAccountBalanceFailed(String msg);

    void getMyAccountBalanceSuccessfully(float balance);

    void getTheirAccountFailed(String msg);

    void getTheirAccountSuccessfully(Account account);

    void transactionFailed(String msg);

    void transactionSuccessfully(Transactions transactions);

    void getTransactionHistoryFailed(String msg);

    void getTransactionHistorySucccessfully(List<Transactions> transactionsList);

    void giveRequestPaymentFailed(String s);

    void giveRequestPaymentSuccessfully(Request myRequest);

    void getMyRequestsFailed(String msg);

    void getMyRequestSuccessfully(List<Request> requestList);

    void getIncomingRequestsFailed(String msg);

    void getIncomingRequestsSuccessfully(List<Request> requestList);

    void cancellingIncomingRequestSuccessfully(Request request,List<Request> requestList);

    void cancellingIncomingRequestFailed(String msg);

    void acceptingIncomingRequestFailed(String msg);

    void acceptingIncomingRequestSuccessfully(Request request, List<Request> requestList);
}
