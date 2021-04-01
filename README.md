# Projekteszkozok-2021
### Használati útmutató + magyarázatok:

GITHUB használata:
- mindenki a saját branch-én dolgozik, melyeket a célnak megfelelően nevez el
- commitokat, kódot, branch neveket az egyszerűség kedvéért lehetőleg angolul írjuk, dokumentációkat/wikit, issuekat magyarul a tárgykövetelmény miatt
- git config --global user.name és .email commitolás előtt Git Bash-ben beírásra kerültek, ennek ellenére nem látszik a commitokon a név és inf-es email. Manuálisan a github settings-ben a felhasználónév megváltoztatása "Changing your username can have unintended side effects." warningot ad, ezért itt szeretnénk tisztázni, hogy ki milyen néven dolgozik:
- faragobruno Faragó Brúnó ZVC7UI (zvc7ui@inf.elte.hu)
- cszsofi3 Csákány Zsófia G41I7L (g41i7l@inf.elte.hu)
- CsDavidB Csintalan Dávid Balázs X0YR3H (x0yr3h@inf.elte.hu)
- hipirobi Hippenmayer Róbert AL7O3Q (al7o3q@inf.elte.hu)
- ha egy funkció elkészült pull requestet kérünk, melyet a csapat másik tagja(i) elfogad és mergeli developba, majd a végén masterre
- master branch a végleges branch
- további részletek a workflowról a wiki menüpont alatt találhatók.

Használati útmutató a kezdeti api-hoz:
- master branch pull

FRONTEND:
- node.js letöltése után cmd-be beírni: 
	npm install -g vue 
vagy
	npm install -g @vue/cli
- a cd projekt mappájába belépni cmdben és beírni:
	npm install
- utána cmd-be beírni:
	vue ui
- a felugró ablakban importálni a projekt mappáját
- Feladatok menüpontra kattintani
- Serve (feladat elindítása)

BACKEND:
- futtatás
- postman lekérdezések (pl. user létrehozás, ételek lekérdezése stb.) 
- az adatbázissal való összekötés még jelenleg nem funkcionál jól, beégetett data.sql-el azonban ki lettek próbálva az endpointok (következő beadandóig javítva lesznek a hibák, kérem ezektől eltekinteni most)

MÁSODIK BEADANDÓ (CI):
- Az Actions fül alatt találhatók a workflow futások (CI dashboard) amelyekből egyre rákattintva látható a CI futása. Az artifact a package fájlban található. A .github/workflows mappában található a CI configja. A CI-ban a megírt tesztek is lefutnak, melyek a Build stageben láthatók.

