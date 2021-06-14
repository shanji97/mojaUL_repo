package si.uni.lj.fe.tnuv.mojaUL;

public class Zaposlen {
    private  String ime;
    private  String priimek;
    private  String naziv;
    private  String email;
    private  String prostor;
    private  String telefonskaStevilka;

    public Zaposlen(String ime, String priimek,String naziv, String email,String prostor, String telefonskaStevilka){

        //V kolikor za testne osebe nimam podatkov, dam notri prazen string in dam privzeto vrednost moje podatke

        if(telefonskaStevilka==""){
            telefonskaStevilka="+38640724968";

        }
        this.telefonskaStevilka=telefonskaStevilka;
        if(prostor==""){
            prostor="P12";
        }
        this.prostor = prostor;
        if(email==""){
            email="ak3900@student.uni-lj.si";
        }
        this.email = email;
        if(naziv ==""){
            naziv = "študent";
        }

        this.naziv = naziv;
        if(priimek==""){
            priimek="Kovač";
        }
        this.priimek = priimek;

        if(ime==""){
            ime="Aleksander";
        }
        this.ime = ime;

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
        return email;
    }

    public String getProstor() {
        return prostor;
    }

    public String getTelefonskaStevilka() {
        return telefonskaStevilka;
    }
}
