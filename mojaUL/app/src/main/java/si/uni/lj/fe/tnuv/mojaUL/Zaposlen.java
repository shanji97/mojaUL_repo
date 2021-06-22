package si.uni.lj.fe.tnuv.mojaUL;


import android.content.res.Resources;

import si.uni.lj.fe.tnuv.aleksanderkovac.mojaul.R;

public class Zaposlen {
    private  String ime;
    private  String priimek;
    private  String naziv;
    private  String email;
    private  String prostor;
    private  String telefonskaStevilka;
    private  String povezavaDoProfilneFotografije;
    private String opis;

    public Zaposlen(String ime, String priimek,String naziv,String prostor, String telefonskaStevilka, String povezavaDoProfilneFotografije, String opis){

        //V kolikor za testne osebe nimam podatkov, dam notri prazen string in dam privzeto vrednost moje podatke

        //primerja z equals
        /*if(telefonskaStevilka==""){
            telefonskaStevilka="+38640724968";

        }*/
        this.telefonskaStevilka=telefonskaStevilka;
        /*if(prostor==""){
            prostor="P12";
        }*/
        this.prostor = prostor;
        /*if(email==""){
            email="ak3900@student.uni-lj.si";
        }*/

        /*if(naziv ==""){
            naziv = "študent";
        }*/

        this.naziv = naziv;

        this.priimek = priimek;

        this.ime = ime;
        /*if(opis=="") {
         opis="Lorem Ipsum";
        }*/
        this.opis=opis;
        this.email = this.ime + "."+this.priimek +"@"+ App.getRes().getString(R.string.domena_fakultete_FE);
        /*if(povezavaDoProfilneFotografije==""){
            povezavaDoProfilneFotografije = "https://www.fe.uni-lj.si/mma_bin.php?id=2014093012230537&src=min"; // privzeto bo fotografija dekana
        }*/
        this.povezavaDoProfilneFotografije = povezavaDoProfilneFotografije;
    }

    public String getOpis(){
        return opis;
    }

    public String getPovezavaDoProfilneFotografije() {
        if(povezavaDoProfilneFotografije=="")
            return null;
        return povezavaDoProfilneFotografije;
    }

    public String getIme() {
        return ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getEmail() {
        return izlociSumnike(this.email.toLowerCase());
    }

    public String getProstor() {
        return prostor;
    }

    public String getTelefonskaStevilka() {
        return telefonskaStevilka;
    }

    public String getPolniNazivZaposlenega(){
        return this.naziv + " "+ this.ime + " "+this.priimek;
    }
    private String izlociSumnike(String besedilo){

        char stari_znaki[] = "ščćž".toCharArray();
        char novi_znaki[] = "sccz".toCharArray();
        //posebni_primeri

        if(stari_znaki.length!=novi_znaki.length){
            return null;
        }
        for (int i =0; i<stari_znaki.length;i++){
            besedilo = besedilo.replace(stari_znaki[i], novi_znaki[i]);
        }

        return besedilo;

    }
}
