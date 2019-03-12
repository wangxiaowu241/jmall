package com.xt.algorithm.multithread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicReference test
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {

        AtomicReference<User> userAtomicReference = new AtomicReference<>();
        User user = new User();
        userAtomicReference.set(user);
        for (int i = 0; i < 100; i++) {
            int iIndex = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    User updateUser = new User(String.valueOf(iIndex), String.valueOf(iIndex));
                    userAtomicReference.compareAndSet(user, updateUser);
                }
            }).start();
        }

        System.out.println(userAtomicReference.get());
    }

    static class User {
        private String userName;
        private String passWord;

        public User() {

        }

        public User(String userName, String passWord) {
            this.userName = userName;
            this.passWord = passWord;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassWord() {
            return passWord;
        }

        public void setPassWord(String passWord) {
            this.passWord = passWord;
        }

        @Override
        public String toString() {
            return "User{" +
                    "userName='" + userName + '\'' +
                    ", passWord='" + passWord + '\'' +
                    '}';
        }
    }


}
