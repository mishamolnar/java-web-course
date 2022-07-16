package com.bobocode.intro;

import lombok.Data;
import lombok.SneakyThrows;

import java.lang.reflect.InvocationTargetException;

public class CustomJackson {
    public static void main(String[] args) {
        String json = "{firstName: Misha,  lastName: Molnar,  email: some@mail}";
        var user = jsonToObj(json, User.class);
        System.out.println(user);
    }


    @SneakyThrows
    private static <T> T jsonToObj(String json, Class<T> type) {
        var constructor = type.getConstructor(new Class[]{String.class, String.class, String.class});
        T user = constructor.newInstance(json.substring(1, json.length() - 1).split(","));
        return user;
    }

    static class User {
        private String firstName;
        private String lastName;
        private String email;

        public User(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }
    }
}
