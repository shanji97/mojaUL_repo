package si.uni.lj.fe.tnuv.mojaUL;

import com.google.gson.Gson;

public class Student {
    String ime;
    String priimek;
    String osebniEmail;
    String studijskiEmail;
    String vpisnaStevilka;
    String naslov;
    String postnaStevilka;
    String kraj;
    String domaciTelefon;
    String mobilniTelefon;
    String studijskiProgram;

    String letnik;
    String dodatekKLetnik;


    public Student
            (
            ){

        this.ime = "Aleksander";
        this.priimek = "Kovač";
        this.osebniEmail = "aleksander.kovac97@hotmail.com";
        this.studijskiEmail = "ak3900@student.uni-lj.si";
        this.vpisnaStevilka = "64160021";
        this.naslov = "Lendavske gorice 409a";
        this.postnaStevilka ="9220";
        this.kraj = "Lendava";
        this.domaciTelefon = "+38625761867";
        this.mobilniTelefon = "+386840724968";
        this.studijskiProgram = "Multimedija UNI REDNI";
        this.letnik = "3";
        this.dodatekKLetnik="A";

    }

    public void shraniStudenta(Student s){


        App.nastaviPodatke(new Gson().toJson(s),"student");
    }


    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public String getOsebniEmail() {
        return osebniEmail;
    }

    public void setOsebniEmail(String osebniEmail) {
        this.osebniEmail = osebniEmail;
    }

    public String getStudijskiEmail() {
        return studijskiEmail;
    }

    public void setStudijskiEmail(String studijskiEmail) {
        this.studijskiEmail = studijskiEmail;
    }

    public String getVpisnaStevilka() {
        return vpisnaStevilka;
    }

    public void setVpisnaStevilka(String vpisnaStevilka) {
        this.vpisnaStevilka = vpisnaStevilka;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getPostnaStevilka() {
        return postnaStevilka;
    }

    public void setPostnaStevilka(String postnaStevilka) {
        this.postnaStevilka = postnaStevilka;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public String getDomaciTelefon() {
        return domaciTelefon;
    }

    public void setDomaciTelefon(String domaciTelefon) {
        this.domaciTelefon = domaciTelefon;
    }

    public String getMobilniTelefon() {
        return mobilniTelefon;
    }

    public void setMobilniTelefon(String mobilniTelefon) {
        this.mobilniTelefon = mobilniTelefon;
    }

    public String getStudijskiProgram() {
        return studijskiProgram;
    }

    public void setStudijskiProgram(String studijskiProgram) {
        this.studijskiProgram = studijskiProgram;
    }

    public String getLetnik() {
        return letnik;
    }

    public void setLetnik(String letnik) {
        this.letnik = letnik;
    }

    public String getDodatekKLetnik() {
        return dodatekKLetnik;
    }

    public void setDodatekKLetnik(String dodatekKLetnik) {
        this.dodatekKLetnik = dodatekKLetnik;
    }
}

