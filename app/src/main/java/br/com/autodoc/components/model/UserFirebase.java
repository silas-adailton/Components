package br.com.autodoc.components.model;


public class UserFirebase {

    private String name;

    public UserFirebase() {
    }

    public UserFirebase(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserFirebase userFirebase1 = (UserFirebase) o;

        return name != null ? name.equals(userFirebase1.name) : userFirebase1.name == null;
    }

    @Override
    public String toString() {
        return "UserFirebase{" +
                "name='" + name + '\'' +
                '}';
    }
}
