package com.example.javatdl;

public class TDLs {

    public TDLs(int id, String name, String items) {
        this.id = id;
        this.name = name;
        this.items=items;
    }

    private int id;
    private String name;
    private String items;

    @Override
    public String toString() {
        return "TDLs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", items='" + items +'\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public static String valueOf(int i) {
        return Integer.toString(i);
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

    public String getItems() {return items;}

    public void setItems(String items) {this.items=items;}
}
