package wizytowka;
import java.io.FileWriter;			//Biblioteka odpowiadaj¹ca za obs³uge zapisu do pliku
import java.io.File;			//Biblioteka odpowiadaj¹ca za obs³uge dostêpu do pliku
import java.io.FileReader;			//Biblioteka odpowiadaj¹ca za obs³uge odczytu z pliku
import java.io.IOException;			//Biblioteka odpowiadaj¹ca za obs³ugê wyj¹tków (try...catch)
import java.time.LocalDateTime;			//Biblioteka odpowiadaj¹ca za odczyt aktualnej daty i czasu
import java.util.Scanner;			//Biblioteka odpowiadaj¹ca za pobieranie danych z klawiatury

//Patryk Andrzejewski
//U-15565
//Wizytówka

public class wizytowka {			//G³ówna klasa
	//Funkcja z menu
	public static void menu() {
		System.out.println("Menu programu wizytowka");			//Wyœwietlanie treœci menu
		System.out.println("-----------------------");			//Wyœwietlanie treœci menu
		System.out.println("1. Zapisz dane");			//Wyœwietlanie treœci menu
		System.out.println("2. Odczytaj dane");			//Wyœwietlanie treœci menu
		System.out.println("3. Zamknij program");			//Wyœwietlanie treœci menu
		System.out.println("-----------------------");			//Wyœwietlanie treœci menu
	}
	//Funkcja odpowiadaj¹ca za dodawanie danych do pliku zapis.txt
	public static void zapis_wizytowka(String imie,String nazwisko,String n_f,String a_f,String regon,String telefon,String adresmail) {
		try {
			FileWriter Zapis = new FileWriter("zapis.txt", true);			//Utworzenie zmiennej zapis która daje dostêp do pliku "zapis.txt" znajduj¹cego siê w folderze z klas¹ oraz nadanie jej atrybutu "true" który odpowiada za dodawanie danych na koñcu pliku zamiast go nadpisywaæ
			Zapis.write(imie + "\r\n");			//Zapis danych do pliku
			Zapis.write(nazwisko + "\r\n");			//Zapis danych do pliku
			Zapis.write(n_f + "\r\n");			//Zapis danych do pliku
			Zapis.write(a_f + "\r\n");			//Zapis danych do pliku
			Zapis.write(regon + "\r\n");			//Zapis danych do pliku
			Zapis.write(telefon + "\r\n");			//Zapis danych do pliku
			Zapis.write(adresmail + "\r\n");			//Zapis danych do pliku
			Zapis.write("Data utworzenia: " + LocalDateTime.now() + "\r\n");			//Zapis aktualnej daty z komputera do pliku
			Zapis.close();			//Zamkniêcie dostêpu do pliku
		    System.out.println("*Zapisano z powodzeniem do pliku*");			//Informacja o poprawnym zapisie
		}catch (IOException a) {
			System.out.println("*Wyst¹pi³ b³¹d podczas próby zapisu do pliku*");			//Informacja o b³edzie
			a.printStackTrace();
		}
	}
	//Funkcja odpowiadaj¹ca za odczyt danych z pliku zapis.txt
	public static void odczyt_wizytowek() {
		try {
			FileReader Odczyt = new FileReader("zapis.txt");			//Utworzenie zmiennej odczyt która daje dostêp do pliku "zapis.txt" znajduj¹cego siê w folderze z klas¹.
			int i;			//Deklaracja zmiennej
			while ((i=Odczyt.read()) != -1){			//Pêtla odpowiadaj¹ca za wypisanie zawartoœci pliku 
				System.out.print((char) i); 
			}
			Odczyt.close();			//Zamkniêcie dostêpu do pliku
		    System.out.println("*Odczytano z powodzeniem dane z pliku*");			//Informacja o poprawnym odczytaniu danych
		}catch (IOException a) {
			System.out.println("Wyst¹pi³ b³¹d podczas próby zapisu do pliku");			//Informacja o b³edzie
			a.printStackTrace();
		}
	}
	//Funkcja main
	public static void main(String[] args) {
		try {
			File myObj = new File("zapis.txt");			//Utworzenie pliku zapis.txt
			if (myObj.createNewFile()) {			//pêtla sprawdzaj¹ca czy plik istnia³
				System.out.println("*Utworzono plik: " + myObj.getName() + "*");
			} else {
				System.out.println("*Plik istnieje*");
			}
		}
		catch (IOException b) {
			System.out.println("*Wyst¹pi³ b³¹d podczas próby stworzenia pliku*");			//Informacja o b³edzie
			b.printStackTrace();
		}
		Scanner in = new Scanner(System.in);			//Utworzenie zmiennej odpowiadaj¹cej za odczyt danych z klawiatury
		int kontrolka=0;			//zmienna kontrolka
		String imie = new String();			//Zmienna imie
		String nazwisko = new String();			//Zmienna nazwisko
		String n_f = new String();			//Zmienna firmy
		String a_f = new String();			//Zmienna adres firmy
		String regon = new String();			//Zmienna regon
		String telefon = new String();			//Zmienna numeru
		String adresmail = new String();			//Zmienna adresu mail
		do {			//G³ówna pêtla w której s¹ odwo³ania do innych funkcji
			menu();			//odwo³anie siê do funkcji menu
			kontrolka = in.nextInt();
			if(kontrolka==1) {
				in.nextLine();
				System.out.println("Podaj imie :");			//Wyœwietlenie informacji
				imie=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj nazwisko :");			//Wyœwietlenie informacji
				nazwisko=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj nazwe firmy :");			//Wyœwietlenie informacji
				n_f=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj adres firmy :");			//Wyœwietlenie informacji
				a_f=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj numer regon :");			//Wyœwietlenie informacji
				regon=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj numer telefonu :");			//Wyœwietlenie informacji
				telefon=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj adres email :");			//Wyœwietlenie informacji
				adresmail=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				zapis_wizytowka(imie,nazwisko,n_f,a_f,regon,telefon,adresmail);			//odwo³anie siê do funkcji zapis_wizytowka oraz w nawiasie wszystkie zmienne które s¹ przekazane
			}if(kontrolka==2) {
				odczyt_wizytowek();			//odwo³anie siê do funkcji odczyt_wizytowek
			}
		}while(kontrolka<3);			//warunek pêtli do (dzia³a je¿eli kontrolka jest mniejsza ni¿ 3)
	}
}