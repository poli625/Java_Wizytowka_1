package wizytowka;
import java.io.FileWriter;			//Biblioteka odpowiadaj�ca za obs�uge zapisu do pliku
import java.io.File;			//Biblioteka odpowiadaj�ca za obs�uge dost�pu do pliku
import java.io.FileReader;			//Biblioteka odpowiadaj�ca za obs�uge odczytu z pliku
import java.io.IOException;			//Biblioteka odpowiadaj�ca za obs�ug� wyj�tk�w (try...catch)
import java.time.LocalDateTime;			//Biblioteka odpowiadaj�ca za odczyt aktualnej daty i czasu
import java.util.Scanner;			//Biblioteka odpowiadaj�ca za pobieranie danych z klawiatury

//Patryk Andrzejewski
//U-15565
//Wizyt�wka

public class wizytowka {			//G��wna klasa
	//Funkcja z menu
	public static void menu() {
		System.out.println("Menu programu wizytowka");			//Wy�wietlanie tre�ci menu
		System.out.println("-----------------------");			//Wy�wietlanie tre�ci menu
		System.out.println("1. Zapisz dane");			//Wy�wietlanie tre�ci menu
		System.out.println("2. Odczytaj dane");			//Wy�wietlanie tre�ci menu
		System.out.println("3. Zamknij program");			//Wy�wietlanie tre�ci menu
		System.out.println("-----------------------");			//Wy�wietlanie tre�ci menu
	}
	//Funkcja odpowiadaj�ca za dodawanie danych do pliku zapis.txt
	public static void zapis_wizytowka(String imie,String nazwisko,String n_f,String a_f,String regon,String telefon,String adresmail) {
		try {
			FileWriter Zapis = new FileWriter("zapis.txt", true);			//Utworzenie zmiennej zapis kt�ra daje dost�p do pliku "zapis.txt" znajduj�cego si� w folderze z klas� oraz nadanie jej atrybutu "true" kt�ry odpowiada za dodawanie danych na ko�cu pliku zamiast go nadpisywa�
			Zapis.write(imie + "\r\n");			//Zapis danych do pliku
			Zapis.write(nazwisko + "\r\n");			//Zapis danych do pliku
			Zapis.write(n_f + "\r\n");			//Zapis danych do pliku
			Zapis.write(a_f + "\r\n");			//Zapis danych do pliku
			Zapis.write(regon + "\r\n");			//Zapis danych do pliku
			Zapis.write(telefon + "\r\n");			//Zapis danych do pliku
			Zapis.write(adresmail + "\r\n");			//Zapis danych do pliku
			Zapis.write("Data utworzenia: " + LocalDateTime.now() + "\r\n");			//Zapis aktualnej daty z komputera do pliku
			Zapis.close();			//Zamkni�cie dost�pu do pliku
		    System.out.println("*Zapisano z powodzeniem do pliku*");			//Informacja o poprawnym zapisie
		}catch (IOException a) {
			System.out.println("*Wyst�pi� b��d podczas pr�by zapisu do pliku*");			//Informacja o b�edzie
			a.printStackTrace();
		}
	}
	//Funkcja odpowiadaj�ca za odczyt danych z pliku zapis.txt
	public static void odczyt_wizytowek() {
		try {
			FileReader Odczyt = new FileReader("zapis.txt");			//Utworzenie zmiennej odczyt kt�ra daje dost�p do pliku "zapis.txt" znajduj�cego si� w folderze z klas�.
			int i;			//Deklaracja zmiennej
			while ((i=Odczyt.read()) != -1){			//P�tla odpowiadaj�ca za wypisanie zawarto�ci pliku 
				System.out.print((char) i); 
			}
			Odczyt.close();			//Zamkni�cie dost�pu do pliku
		    System.out.println("*Odczytano z powodzeniem dane z pliku*");			//Informacja o poprawnym odczytaniu danych
		}catch (IOException a) {
			System.out.println("Wyst�pi� b��d podczas pr�by zapisu do pliku");			//Informacja o b�edzie
			a.printStackTrace();
		}
	}
	//Funkcja main
	public static void main(String[] args) {
		try {
			File myObj = new File("zapis.txt");			//Utworzenie pliku zapis.txt
			if (myObj.createNewFile()) {			//p�tla sprawdzaj�ca czy plik istnia�
				System.out.println("*Utworzono plik: " + myObj.getName() + "*");
			} else {
				System.out.println("*Plik istnieje*");
			}
		}
		catch (IOException b) {
			System.out.println("*Wyst�pi� b��d podczas pr�by stworzenia pliku*");			//Informacja o b�edzie
			b.printStackTrace();
		}
		Scanner in = new Scanner(System.in);			//Utworzenie zmiennej odpowiadaj�cej za odczyt danych z klawiatury
		int kontrolka=0;			//zmienna kontrolka
		String imie = new String();			//Zmienna imie
		String nazwisko = new String();			//Zmienna nazwisko
		String n_f = new String();			//Zmienna firmy
		String a_f = new String();			//Zmienna adres firmy
		String regon = new String();			//Zmienna regon
		String telefon = new String();			//Zmienna numeru
		String adresmail = new String();			//Zmienna adresu mail
		do {			//G��wna p�tla w kt�rej s� odwo�ania do innych funkcji
			menu();			//odwo�anie si� do funkcji menu
			kontrolka = in.nextInt();
			if(kontrolka==1) {
				in.nextLine();
				System.out.println("Podaj imie :");			//Wy�wietlenie informacji
				imie=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj nazwisko :");			//Wy�wietlenie informacji
				nazwisko=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj nazwe firmy :");			//Wy�wietlenie informacji
				n_f=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj adres firmy :");			//Wy�wietlenie informacji
				a_f=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj numer regon :");			//Wy�wietlenie informacji
				regon=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj numer telefonu :");			//Wy�wietlenie informacji
				telefon=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj adres email :");			//Wy�wietlenie informacji
				adresmail=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				zapis_wizytowka(imie,nazwisko,n_f,a_f,regon,telefon,adresmail);			//odwo�anie si� do funkcji zapis_wizytowka oraz w nawiasie wszystkie zmienne kt�re s� przekazane
			}if(kontrolka==2) {
				odczyt_wizytowek();			//odwo�anie si� do funkcji odczyt_wizytowek
			}
		}while(kontrolka<3);			//warunek p�tli do (dzia�a je�eli kontrolka jest mniejsza ni� 3)
	}
}