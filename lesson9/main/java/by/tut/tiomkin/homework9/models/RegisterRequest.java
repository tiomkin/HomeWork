package by.tut.tiomkin.homework9.models;


public class RegisterRequest {

    private String email;
    private String password;

    public RegisterRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
