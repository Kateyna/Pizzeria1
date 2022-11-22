package it.mirea.pizzeria;

public class Owner {
    private String avatar_url;
    private String login;

    public Owner(String avatar_url,String login) {
        this.avatar_url = avatar_url;
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getLogin(){
        return login;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
