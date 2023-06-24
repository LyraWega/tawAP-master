# Getting Started
### OPIS:

* RequestMapping: http://localhost:8080/api
* Test połączenia: http://localhost:8080/api/ping
* Przykładowe zapytanie: http://localhost:8080/api/getTest
* Na zaliczenie: http://localhost:8080/api/harmonogram
  * Metoda POST: wstawianie danych do harmonogramu /dodanie pozycji do listy/
    * "subject" <String>
    * "score" <Integer>
    * "room" <String>
    * "exam" <Boolean>
* Metoda GET: pobieranie danych z harmonogramu /wszystko, wg egzaminu/
  * "exam" <Boolean>
* Metoda DELETE: usuwanie danych z harmonogramu

### Raport
##### Wprowadzanie przedmiotów do bazy:
###### Przykład reprezentatywny
* Metoda: POST
* Adres: http://localhost:8080/api/harmonogram
* Nagłówek: Content-Type: application/json
* Request Body: [{"przedmiot": "Metodologie obiektowe", "punkty": 2, "sala": "216", "egzamin": true}]
* Wynik działania: 200 OK

###### Dane rozszerzone
* Request Body: [{"przedmiot": "Metodologie obiektowe", "punkty": 2, "sala": "216", "egzamin": true}]
* Request Body: [{"przedmiot": "Testowanie oprogramowania", "punkty": 1, "sala": "216", "egzamin": false}]
* Request Body: [{"przedmiot": "Technologie i aplikacje webowe", "punkty": 3, "sala": "208", "egzamin": false}]
* Request Body: [{"przedmiot": "Zarządzanie projektem informatycznym", "punkty": 2, "sala": "216", "egzamin": false}]
* Request Body: [{"przedmiot": "Zaawansowane technologie bazodanowe", "punkty": 3, "sala": "208", "egzamin": false}]
* Request Body: [{"przedmiot": "Technologie komponentowe i sieciowe", "punkty": 2, "sala": "208", "egzamin": true}]

##### Pobierania pełnego harmonogramu z bazy:
* Metoda: GET
* Adres: http://localhost:8080/api/harmonogram
* Nagłówek: Content-Type: application/json
  * Body
  *     [{"id":1,"przedmiot":"Metodologie obiektowe","punkty":2,"sala":"216","egzamin":true},
  *     {"id":2,"przedmiot":"Testowanie oprogramowania","punkty":1,"sala":"216","egzamin":false},
  *     {"id":3,"przedmiot":"Technologie i aplikacje webowe","punkty":3,"sala":"208","egzamin":false},
  *     {"id":4,"przedmiot":"Technologie i aplikacje webowe","punkty":3,"sala":"208","egzamin":false},
  *     {"id":5,"przedmiot":"Zarządzanie projektem informatycznym","punkty":2,"sala":"216","egzamin":false},
  *     {"id":6,"przedmiot":"Zaawansowane technologie bazodanowe","punkty":3,"sala":"208","egzamin":false},
  *     {"id":7,"przedmiot":"Technologie komponentowe i sieciowe","punkty":2,"sala":"208","egzamin":true}]
* Wynik działania: 200 OK

##### Pobierania przedmiotów kończące się egzaminem:
* Metoda: GET
* Adres: http://localhost:8080/api/harmonogram?exam=true
* Nagłówek: Content-Type: application/json
* Body: [{"Id":1,"Nazwa":"Technologie komponentowe i sieciowe","ECTS":2,"Sala":"208","Egzamin":true}]
* Wynik działania: 200 OK

##### Usuwanie wszystkich przedmiotów z harmonogramów:
* Metoda: DELETE
* Adres: http://localhost:8080/api/harmonogram
* Nagłówek: Content-Type: application/json
* Wynik działania: 200 OK
