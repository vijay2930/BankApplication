package com.bankingapplication.user;


import com.bankingapplication.dto.Request;
import com.bankingapplication.dto.Transactions;
import com.bankingapplication.repository.Repository;
import com.bankingapplication.dto.Account;

import java.util.List;

public class UserModel implements UserModelCallBack {
    private UserControllerModelCallBack userController;
    private Repository repository;
    public UserModel(UserControllerModelCallBack UserController) {
        this.userController = UserController;repository=Repository.getInstance();
    }

    @Override
    public void getMyAccount(String userName, String mPin) {
        Account account=repository.getAccount(userName,mPin);
        if(account==null){
            userController.getMyAccountFailed("MPIN is Wrong");
        }else {
            userController.getMyAccountSuccessfully(account);
        }
    }

    @Override
    public void getMyAccountBalance(String userName, String mPin) {
        Account account=repository.getAccount(userName,mPin);
        if(account==null){
            userController.getMyAccountBalanceFailed("MPIN is Wrong");
        }else {
            userController.getMyAccountBalanceSuccessfully(account.getBalance());
        }
    }

    @Override
    public void getTheirAccount(String accountId) {
        Account account=repository.getTheirAccount(accountId);
        if(account==null){
            userController.getTheirAccountFailed("Username or Account No you provided was Incorrect.Try again.");
        }else {
            userController.getTheirAccountSuccessfully(account);
        }
    }

    @Override
    public void checkTransactionIsValid(String userName, String mtPin, float amount, Account theirAccount) {
        float balance = repository.getBalance(userName,mtPin);
        if(balance==-1.0f){
            userController.transactionFailed("mtPin is Incorrect.");
        }else if(amount>balance || amount==balance){
            userController.transactionFailed("Insufficient Balance.");
        }
        Transactions transactions=repository.addTransaction(userName,mtPin,amount,theirAccount);
        if(transactions==null){
            userController.transactionFailed("Something went wrong. Try again");
        }else {
            userController.transactionSuccessfully(transactions);
        }
    }

    @Override
    public void getTransactionHistory(String userName, String mtpin) {
        List<Transactions> transactionsList=repository.getTransactionHistory(userName,mtpin);
        if(transactionsList==null){
            userController.getTransactionHistoryFailed("mtpin you provided was Incorrect");
        }else {
            userController.getTransactionHistorySucccessfully(transactionsList);
        }
    }

    @Override
    public void checkGiveRequestPaymentDetailValid(String userName, String mtpin, float amount, String accountId) {
        Account account=repository.getTheirAccount(accountId);
        if(account==null){
            userController.giveRequestPaymentFailed("Account No/Username you provided was not Found check the details" +
                    " try again");
        }
        Request myRequest =repository.addGiveRequestPayment(userName,mtpin,amount,account.getUserName());
        if(myRequest==null){
            userController.giveRequestPaymentFailed("mtpin you provided was Incorrect.");
        }
        userController.giveRequestPaymentSuccessfully(myRequest);
    }

    @Override
    public void getMyRequests(String userName, String mtpin) {
        List<Request> requestList=repository.getMyRequests(userName,mtpin);
        if(requestList==null){
            userController.getMyRequestsFailed("mtpin you provided was InCorrect.");
        }
        userController.getMyRequestSuccessfully(requestList);
    }

    @Override
    public void getIncomingRequests(String userName, String mtpin) {
        List<Request> requestList=repository.getIncomingRequests(userName,mtpin);
        if(requestList==null){
            userController.getIncomingRequestsFailed("mtpin you provided was Incorrect");
        }
        userController.getIncomingRequestsSuccessfully(requestList);
    }

    @Override
    public void acceptingIncomingRequest(Request request, String userName, String mtpin, List<Request> requestList) {
        Request request1=repository.acceptingIncomingRequest(request,userName,mtpin);
        if(request1==null){
            userController.acceptingIncomingRequestFailed("mtpin you provided was Incorrect or Insuffice balance in " +
                    "your account" +
                    ".Try again");
        }else {
            userController.acceptingIncomingRequestSuccessfully(request,requestList);
        }
    }

    @Override
    public void cancellingIncomingRequest(Request request, String userName, String mtpin, List<Request> requestList) {
        Request request1=repository.cancellingIncomingRequest(request,userName,mtpin);
        if(request1==null){
            userController.cancellingIncomingRequestFailed("mtpin you provided was Incorrect.Try again");
        }else {
            userController.cancellingIncomingRequestSuccessfully(request,requestList);
        }
    }
}
