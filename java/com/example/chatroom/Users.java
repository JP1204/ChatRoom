package com.example.chatroom;

import java.util.HashMap;

public class Users {
    private HashMap<String, String> accounts;

    public Users() {
        accounts = new HashMap<>();
    }

    public void addUser(String username, String password){
        accounts.put(username, password);
    }

    public void removeUser(String username){
        accounts.remove(username);
    }

    public boolean isValidUser(String username){
        return accounts.containsKey(username);
    }

    public boolean authenticate(String username, String password){
        return (accounts.containsKey(username) && (accounts.get(username) == password));
    }

    public int getNumUsers(){
        return accounts.size();
    }
}
