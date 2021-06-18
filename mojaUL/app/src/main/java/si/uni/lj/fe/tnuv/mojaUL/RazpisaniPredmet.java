package si.uni.lj.fe.tnuv.mojaUL;

public class RazpisaniPredmet {

    String naziv;
    String izvajalec;
    int letnik;
    String datum;
    String obdobje;
    boolean prijavljen;
}
/*JSON Generator
* // This will be serialized into a JSON Contact object
public class Izpit
{
   public string naziv;
   public string izvajalec;
   public int letnik;
   public string datum;
   public bool jePrijavljen;

}

// This will be serialized into a JSON array of Contact objects
public class OmogoceniIzpiti
{
    public ICollection<Izpit> Izpiti { get; set; }

    public OmogoceniIzpiti()
    {

        this.Izpiti = new List<Izpit>
        {
            new Izpit {naziv = "Terminalske naprave in uporabniški vmesniki",izvajalec = "prof. dr. Jaka Sodnik",
                        letnik = 3, datum = "25.06.2021", jePrijavljen = true},
           new Izpit {naziv = "Montaža in postprodukcija",izvajalec = "izr. prof. dr. Matevž Pogačnik",
                        letnik = 3, datum = "28.06.2021", jePrijavljen = true},
                  new Izpit {naziv = "Mobilnost in internet stvari",izvajalec = "prof. dr. Janez Bešter",
                        letnik = 3, datum = "01.06.2021", jePrijavljen = false

        };

    }
}
*
*
* */