package org.example.fulkopinginlamning.dao;

import org.example.fulkopinginlamning.model.Account;

public class AccountDAO extends GenericDAO<Account, Integer> {

    public AccountDAO (){
        super(Account.class);
    }

}
