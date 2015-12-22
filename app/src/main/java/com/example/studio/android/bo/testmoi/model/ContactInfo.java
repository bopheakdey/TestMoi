package com.example.studio.android.bo.testmoi.model;

/**
 * Created by User on 12/18/2015.
 */
public class ContactInfo {

        public String name;
        public String surname;
        public String email;
        protected static final String NAME_PREFIX = "Name_";
        protected static final String SURNAME_PREFIX = "Surname_";
        protected static final String EMAIL_PREFIX = "Email_";

        public ContactInfo(){

        }

        public String getEmail() {
            return email;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

}
