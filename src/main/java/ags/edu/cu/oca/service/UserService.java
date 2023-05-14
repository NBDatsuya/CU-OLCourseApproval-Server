package ags.edu.cu.oca.service;

import ags.edu.cu.oca.bean.User;

public class UserService {
    private static UserService instance;

    public static UserService getInstance() {
        if (instance == null) instance = new UserService();
        return instance;
    }

    public User getUserByID(int userID){
        return null;
    }
}
