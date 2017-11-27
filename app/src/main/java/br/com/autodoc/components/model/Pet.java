package br.com.autodoc.components.model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "pet"
//        foreignKeys = @ForeignKey(entity = User.class,
//                parentColumns = "idPet",
//                childColumns = "user_id",
//                onDelete = ForeignKey.CASCADE,
//                onUpdate = ForeignKey.CASCADE)
)
public class Pet {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_pet")
    private int idPet;
    @ColumnInfo(name = "name_pet")
    private String namePet;
    private String raca;
//    @ColumnInfo(namePet = "user_id")
//    private int userId;
    @Embedded
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        if (idPet != pet.idPet) return false;
//        if (userId != pet.userId) return false;
        if (namePet != null ? !namePet.equals(pet.namePet) : pet.namePet != null) return false;
        return raca != null ? raca.equals(pet.raca) : pet.raca == null;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "idPet=" + idPet +
                ", namePet='" + namePet + '\'' +
                ", raca='" + raca + '\'' +
//                ", userId=" + userId +
                '}';
    }
}
