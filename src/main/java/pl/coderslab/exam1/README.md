![Coders-Lab-1920px-no-background](https://user-images.githubusercontent.com/152855/73064373-5ed69780-3ea1-11ea-8a71-3d370a5e7dd8.png)


## Zadanie 1 

W pliku `Main01.java` umieść metodę o sygnaturze `public static int rectangle(int a, int b)`.

1. Uzupełnij ciało metody tak, by obliczyła i zwróciła pole prostokąta.

## Zadanie 2

W pliku `Main02.java` umieść metodę o sygnaturze `public static String shorten(String str, int length)`.

1. Uzupełnij ciało metody tak, by dla otrzymanego napisu zwracała jego skrót o ilości znaków podanych w parametrze `length`.

Przykład dla napisu `Naucz się programować od podstaw` oraz ilości znaków 2 otrzymamy `Na`. 

## Zadanie 3

W pliku `Main03.java` umieść metodę o sygnaturze `public static int[] div(int size, int interval)`.

1. Uzupełnij ciało metody tak by zwracała tablicę losowych liczb z zakresu `[1 - interval]`.
2. Elementy tablicy mają być jednocześnie podzielne przez 2 i niepodzielne przez 3.
3. Ilość elementów w tablicy ma być równa parametrowi `size`.
4. Tablica nie może zawierać pustych elementów. (pamiętaj że domyślna wartość w tablicy dla typu `int` to 0)

Przykład dla size = 4  oraz interval = 20 
```
[8,4,20,16]
```

## Zadanie 4

W pliku `Main04.java` umieść metodę o sygnaturze `public static int[] returnTab()`.

1. Uzupełnij ciało metody tak by pobierała z konsoli parametr `n`, tworzyła tablicę o ilości elementów `n`.
2. Elementy tablicy mają być kolejnymi liczbami naturalnymi zaczynając od 1.

## Zadanie 5 

W pliku `Main05.java` umieść metodę o sygnaturze `public static double sphere()`.  
Uzupełnij ciało metody tak, aby:

1. pobierała z konsoli promień `r`,
2. zwracała obliczoną objętość kuli.

## Zadanie 6

W pliku `Main06.java` umieść metodę o sygnaturze `public static String replaceStr(String str, String forReplace, String replacement)`.
1. Uzupełnij ciało metody tak aby zwracała napis powstały z zamiany w napisie `str`
 wszystkich wystąpień napisu `forReplace` przez napis `replacement`.

## Zadanie 7

W pliku `Main07.java` umieść metodę o sygnaturze `public static int countNumbers(String str) `.

1. Uzupełnij ciało metody tak aby zwracała sumę **cyfr** umieszczonych w napisie

Przykład 1: Dla napisu: `Wynik dodawania 1 i 2 to 3` zwróci `6`.  
Przykład 2: Dla napisu: `PO5ZUK4J I DOD4J UKRYT3 CYFRY` zwróci `16`. 

Aby zamienić napis na wartość liczbową typu int możesz skorzystać z poniższego przykładu:
```java
int num = Integer.parseInt("3");
```
Dodaj obsługę możliwego wyjątku.

## Zadanie 8

W pliku `Main08.java` umieść metodę o sygnaturze `public static void create(int max)`.

1. Uzupełnij ciało metody tak aby pobrała z konsoli parametr `n` - oznaczający ilość osób w grupie.
2. Następnie dla podanej ilości osób pobierze z konsoli loginy github oraz ilość punktów z egzaminu, 
zapisze je do pliku `exam.txt`, każde imię razem z oceną w nowej lini oddzielone znakiem spacji.

    Przykład pobierania dla 2 osób:
    
 ```
 Podaj login:
 arek-jozwiak-coderslab
 Podaj ilość punktów:
 11
 Podaj login:
 pawel321a
 Podaj ilość punktów:
 20
 ```
    
 Przykład wynikowego pliku (struktura pliku musi być dokładnie taka):
 ```
 arek-jozwiak-coderslab 11
 pawel321a 20
 ```

3. Następnie wczytamy dane z pliku `exam.txt` i na ich podstawie utworzymy nowy plik `exam_passed.txt` ,
w którym znajdą się tylko te osoby, których ilość punktów przekracza 60% z maksymalnej ilości punktów określonych w parametrze `max`.
4. Struktura pliku `exam_passed.txt` musi być taka sama jak pliku `exam.txt`.

**Pliki muszą się znajdować w katalogu głównym projektu**

##### Możemy utworzyć dodatkowe metody pomocnicze natomiast całość programu ma się wykonać po wywołaniu metody create()
##### Pliki `exam.txt` oraz `exam_passed.txt` nie powinny być dodane do repozytorium.
