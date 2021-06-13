# mojaUL

<!-- [![N|Solid](https://cldup.com/dTxpPi9lDf.thumb.png)](https://nodesource.com/products/nsolid) -->

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)
<br>
Aplikacija **mojaUL** je aplikacija namenjena študentom, ki obiskujejo katerokoli članico Univerze v Ljubljani. Cilj aplikacije je študentom omaogočiti pregled nad osnovnimi študijskimi stvarmi, kot tudi ponuditi dodatne informacije za katere študent ponavadi porabi več časa, ko išče omenjene informacije na spletnih straneh, kot so na primer jedilnik, informacija o osnovnih kontaktnih podatkih (vseh) zaposlenih (na posamezni fakulteti). Aplikacija pri predmetu **"Terminalske naprave in uporabniški vmesniki** bo napisana za operacijski sistem Android.

[//]: # (Type some Markdown on the left   - See HTML in the right  - Magic.)
 
# Funkcije aplikacije v trenutni različici za oddajo pri TNUV!
  - Aplikacija uporablja statično generirane podatke
  - Aplikacija ima vstopno stran, ki ima napis "Univerza v Ljubljani", njen logotip ter gumb za vstop v samo aplikacijo. Stran je narejena v skladu z navodili o uporabi celostne grafične podobe UL.
  - Sledi osnovna stran z opcijama za prijavo v sistem za uporabo aplikacije in obisk spletne strani UL.
  - Na glavni strani "sistema" je na voljo več različnih opcij
  - Po prijavi z e-poštnim naslovom in geslom UL, sledi glavn panel kjer se nahaja kopica opcij za uporabo.
    -   Jedilnik prikazuje meni za tekoči teden v menzah, ki so del članic(e) in jih/jo študent obiskuje, kot tudi stalno ponudbo vključno s ceno, ki velja v primeru študentskega bona. Ponujena je tudi možnost preusmeritve v druge aplikacije, ki nudijo pregled drugih ponudnikov.
    - Prikazan je seznam zaposlenih po abecedi (najprej ime in potem priimek), pri katerih študent obiskuje enega ali več predmetov tekom študija. Na voljo so tudi njihovi kontaktni podatki in kratke informacije, ki jih profesorji sami dajejo v opis, fotografija se naloži glede na to ali je na uradni spletni strani fakultete, med prikazom profila na voljo dejanska fotografija, sicer se prikaže generična fotografija. Na voljo bo tudi povezava do dejanske spletne strani (informacija o vseh zaposlenih bo na voljo v prihodnjih različicah aplikacije -> daj v future stuff)
    - Nastavitve omogočajo povezovanja prstnega odtisa, prijave napake razvijalcem ter obisk strani aplikacije v trgovini Google Play
    - Študent se lahko prijavi v STUDIS in se lahko prijavlja in odjavlja na izpite, za katere je dobil pogoje, postopek poteka enako, kot v klasičnem spletnem načinu. Dosegljivi so tudi podatki o študentu in druge funkcije, ponujena pa je tudi funkcija za urejanje, da zaradi trenutnih omejitev, lahko uporabljamo spletno različico
    - Za zavihku "Prijavi škodo" lahko poslikamo fotografijo nastale škode 

 
## Imaginarni podatki in spletni računi za testne potrebe aplikacije
  - Študentski mail - študent bo prejemal razlčina obvestila, podatki bodo služili kot prijavni podatki v virtualni sistem: **"test.aplikacija00tnuv00moja11ul@gmail.com"** ter geslo **"Terminalske_naprave22"**

  - Vzdrževalčev mail - vzdrževalec bo prejemal obvestila o morebitni škodi, nastali v notranjosti zgradbe:
  **moram še dopisati**
  - Razvijalčev mail - razvijalec bo sprejemal razne predloge na svoj e-mail in jih na  zahtevo nadrejenega tudi prikazal (sporočila bodo shranjena kot PDF v ločeno mapo v oblaku na [povezavi](shorturl.at/kmCG1)  ): **ak3900@student.uni-lj.si**
## Funkcije aplikacije v prihodnosti različici!
V prihodnosti bo tudi vljučenene naslenje funkcionalnosti:
 

## Druge podrobnosti (dodane med razvojem aplikacije)
### Dovoljenja

### Dodatne funkcionalnosti & plugini in drugi dodatki aplikacijam bodo dodani tu

### Povezave do aplikacije (dodane sproti)


[//]: # (| Plugin | README |
| ------ | ------ |
| Dropbox | [plugins/dropbox/README.md][PlDb] |
| GitHub | [plugins/github/README.md][PlGh] |
| Google Drive | [plugins/googledrive/README.md][PlGd] |
| OneDrive | [plugins/onedrive/README.md][PlOd] |
| Medium | [plugins/medium/README.md][PlMe] |
| Google Analytics | [plugins/googleanalytics/README.md][PlGa] |)


[//]: # (This will create the dillinger image and pull in the necessary dependencies. Be sure to swap out `${package.json.version}` with the actual version of Dillinger.)


[//]: # (Verify the deployment by navigating to your server address in your preferred browser.)
[//]: # ( ```sh <br> 127.0.0.1:8000 <br>``` )



[//]: #  (See [KUBERNETES.md](https://github.com/joemccann/dillinger/blob/master/KUBERNETES.md)

[//]: # ( ### Todos  - Write MORE Tests  - Add Night Mode License --- MIT **Free Software, Hell Yeah!** )

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
