package org.example.oris_cw_01.Models;
//account_id BIGSERIAL PRIMARY KEY,
//login      VARCHAR(50),
//name       VARCHAR(50),
//surname    VARCHAR(50),
//role       VARCHAR(50),
//status     VARCHAR(200),
//biography  VARCHAR(500)
public class User {
    private Long id;
    private String login;
    private String name;
    private String surname;
    private String role;
    private String status;
    private String biography;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                ", biography='" + biography + '\'' +
                '}';
    }
}
