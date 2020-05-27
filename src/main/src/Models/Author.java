package Models;

import java.util.Date;

public class Author {

    private int idAuthor;
    private String name;
    private String surname;
    private Date birthdate;

    public Author(int idAuthor, String name, String surname, Date birthdate) {
        this.idAuthor = idAuthor;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

}
