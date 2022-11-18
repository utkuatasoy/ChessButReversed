import java.util.Scanner;
//	Game'i extend ediyor buradan satir sutun girdileri ve yapilacak hamlenin alinacagi String inheritance bagi kurdu.
public class Player extends Game{
	private String oyuncuIsim;

public void siraGecti() {
	//	Burada main'de beyaz ve siyah olarak olusturulan player'larin adlari alinarak girdi ister.
	
	System.out.println("Sira "+getOyuncuIsim()+"'da. Oynamak istediginiz tasin koordinatini ve tasi koymak istediginiz koordinati giriniz.");
	if(getOyuncuIsim().equals("Beyaz"))
		System.out.println("("+getOyuncuIsim()+" ust siradir.)");
	else
		System.out.println("("+getOyuncuIsim()+" alt siradir.)");

	System.out.println("-----------------------------------------------------------------");
}
	public String getOyuncuIsim() {
		return oyuncuIsim;
	}
	public void setOyuncuIsim(String oyuncuIsim) {
		this.oyuncuIsim = oyuncuIsim;
	}
	public Player() {
	//	Default constructor.
	}
	public void puaniYazdir() {
		System.out.println(getOyuncuIsim()+" puani: "+toplamPuan+".");
	}
	public Player(String oyuncuIsim) {
		//	Burada main'de beyaz ve siyah olarak olusturulan player'larin adlarini set eder bu sayede siraGecti methodu duzgun calisir.
		setOyuncuIsim(oyuncuIsim);
	}

	public void hamleAl() {
	//	Ilk hamleyi almak icin method gerisi dongu icindedir.
	Scanner keyboard = new Scanner(System.in);
	System.out.println("Sira "+getOyuncuIsim()+"'da. Oynamak istediginiz tasin koordinatini ve tasi koymak istediginiz koordinati giriniz.");
		
	if(getOyuncuIsim().equals("Beyaz"))
		System.out.println("("+getOyuncuIsim()+" ust siradir.)");
	else
		System.out.println("("+getOyuncuIsim()+" alt siradir.)");
	
	System.out.println("(Bazen dogru hamle de olsa hatali diye output verebilir. Duzgun bir girdi girdiginizde sonuncuyu oynamayip bir oncekini oynayacaktir.)");
	hamle = keyboard.nextLine();
	eskiSatir = ((int)hamle.charAt(0))-97;
	System.out.println(eskiSatir);
	eskiSutun = ((int)hamle.charAt(1))-49;
	System.out.println(eskiSutun);
	yeniSatir = ((int)hamle.charAt(3))-97;
	System.out.println(yeniSatir);
	yeniSutun = ((int)hamle.charAt(4))-49;
	System.out.println(yeniSutun);
	
	}
}

