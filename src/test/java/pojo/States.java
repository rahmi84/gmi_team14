package pojo;

//<<<<<<< HEAD
public class States {
    private int id;
    private String name;

    public States(String s, Object o, Object o1) {

    }
//=======
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class States {
//    private int id;
//    private String name;
//    private Country country;
//>>>>>>> master

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//<<<<<<< HEAD
//=======

//    public Country getCountry() {
//        return country;
//    }
//
//    public void setCountry(Country country) {
//        this.country = country;
//    }
//>>>>>>> master
}
