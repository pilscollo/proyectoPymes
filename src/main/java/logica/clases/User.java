package logica.clases;

public class User {
    private String username;
    private String password;
    private int cant;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.cant = 0;
    }
    public User(String username, String password,int cant) {
        this.username = username;
        this.password = password;
        this.cant = cant;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
}
