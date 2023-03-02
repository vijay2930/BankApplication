package com.bankingapplication.user;


import com.bankingapplication.dto.Account;
import com.bankingapplication.dto.Request;
import com.bankingapplication.dto.Transactions;

import java.util.List;

class UserController implements UserControllerViewCallBack, UserControllerModelCallBack {
    private UserModelCallBack userModel;
    private UserViewCallBack userView;
    public UserController(UserViewCallBack UserView) {
        this.userView = UserView;
        this.userModel =new UserModel(this);
    }

    @Override
    public void getMyAccount(String userName, String mPin) {
        this.userModel.getMyAccount(userName,mPin);
    }

    @Override
    public void getMyAccountBalance(String userName, String mPin) {
        this.userModel.getMyAccountBalance(userName, mPin );
    }

    @Override
    public void getTheirAccount(String accountId) {
        this.userModel.getTheirAccount(accountId);
    }

    @Override
    public void checkTransactionIsValid(String userName, String mtPin, float amount, Account theirAccount) {
        this.userModel.checkTransactionIsValid(userName,mtPin,amount,theirAccount);
    }

    @Override
    public void getTransactionHistory(String userName, String mtpin) {
        this.userModel.getTransactionHistory(userName,mtpin);
    }

    @Override
    public void checkGiveRequestPaymentDetailValid(String userName, String mtpin, float amount, String accountId) {
        this.userModel.checkGiveRequestPaymentDetailValid(userName,mtpin,amount,accountId);
    }

    @Override
    public void getMyRequests(String userName, String mtpin) {
        userModel.getMyRequests(userName,mtpin);
    }

    @Override
    public void getIncomingRequests(String userName, String mtpin) {
        userModel.getIncomingRequests(userName,mtpin);
    }

    @Override
    public void acceptingIncomingRequest(Request request, String userName, String mtpin, List<Request> requestList) {
        userModel.acceptingIncomingRequest(request,userName,mtpin,requestList);
    }

    @Override
    public void cancellingIncomingRequest(Request request, String userName, String mtpin, List<Request> requestList) {
        userModel.cancellingIncomingRequest(request,userName,mtpin,requestList);

    }

    @Override
    public void getMyAccountFailed(String msg) {
        this.userView.getMyAccountFailed(msg);
    }

    @Override
    public void getMyAccountSuccessfully(Account account) {
        this.userView.getMyAccountSuccessfully(account);
    }

    @Override
    public void getMyAccountBalanceFailed(String msg) {
        this.userView.getMyAccountBalanceFailed(msg);
    }

    @Override
    public void getMyAccountBalanceSuccessfully(float balance) {
        this.userView.getMyAccountBalanceSuccessfully(balance);
    }

    @Override
    public void getTheirAccountFailed(String msg) {
        this.userView.getTheirAccountFailed(msg);
    }

    @Override
    public void getTheirAccountSuccessfully(Account account) {
        this.userView.getTheirAccountSuccessfully(account);
    }

    @Override
    public void transactionFailed(String msg) {
        this.userView.transactionFailed(msg);
    }

    @Override
    public void transactionSuccessfully(Transactions transactions) {
        this.userView.transactionSuccessfully(transactions);
    }

    @Override
    public void getTransactionHistoryFailed(String msg) {
        this.userView.getTransactionHistoryFailed(msg);
    }

    @Override
    public void getTransactionHistorySucccessfully(List<Transactions> transactionsList) {
        this.userView.getTransactionHistorySuccessfully(transactionsList);
    }

    @Override
    public void giveRequestPaymentFailed(String msg) {
        this.userView.giveRequestPaymentFailed(msg);
    }

    @Override
    public void giveRequestPaymentSuccessfully(Request myRequest) {
        this.userView.giveRequestPaymentSuccessfully(myRequest);
    }

    @Override
    public void getMyRequestsFailed(String msg) {
        userView.getMyRequestFailed(msg);
    }

    @Override
    public void getMyRequestSuccessfully(List<Request> requestList) {
        userView.getMyRequestSuccessfully(requestList);
    }

    @Override
    public void getIncomingRequestsFailed(String msg) {
        userView.getIncomingRequestsFailed(msg);
    }

    @Override
    public void getIncomingRequestsSuccessfully(List<Request> requestList) {
        userView.getIncomingRequestsSuccessfully(requestList);
    }

    @Override
    public void cancellingIncomingRequestSuccessfully(Request request,  List<Request> requestList) {
        userView.cancellingIncomingRequestSuccessfully(request,requestList);
    }

    @Override
    public void cancellingIncomingRequestFailed(String msg) {
        userView.cancellingIncomingRequestFailed(msg);

    }

    @Override
    public void acceptingIncomingRequestFailed(String msg) {
        userView.acceptingIncomingRequetFailed(msg);
    }

    @Override
    public void acceptingIncomingRequestSuccessfully(Request request, List<Request> requestList) {
        userView.acceptingIncomingRequestSuccessfully(request,requestList);
    }
}