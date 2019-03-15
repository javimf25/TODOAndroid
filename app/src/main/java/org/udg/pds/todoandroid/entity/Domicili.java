package org.udg.pds.todoandroid.entity;

import com.google.gson.annotations.SerializedName;

public class Domicili {
    @SerializedName("id")
    public Long id;
    @SerializedName("direccio")
    private String direccio;
    @SerializedName("poblacio")
    private String   poblacio;
    @SerializedName("provincia")
    private String   provincia;
    @SerializedName("metresQuadrats")
    private int metresQuadrats;
    @SerializedName("nHab")
    private int   nHab;

    public Domicili(Long id, String direccio, String poblacio, String provincia, int m2, int nHabitacions) {
        this.id=id;
        this.direccio = direccio;
        this.poblacio = poblacio;
        this.provincia = provincia;
        this.metresQuadrats = m2;
        this.nHab = nHabitacions;
    }

    public Long getId() {
        return id;
    }

    public String getDireccio() {
        return direccio;
    }


    public String getPoblacio() {
        return poblacio;
    }


    public String getProvincia() {
        return provincia;
    }


    public int getm2() {
        return metresQuadrats;
    }


    public int getnHabitacions() {
        return nHab;
    }


}
