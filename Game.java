import java.util.Scanner;
//	Player ve Board, Game'i extend ediyor.
public class Game{
	//	Player'da gelecek siralarda kullanilan ve board'da hamle olarak alinan satir ve sutur degiskenleri asagida tanimlandi.
	public int eskiSatir;
	public int eskiSutun;
	public int yeniSatir;
	public int yeniSutun;
	
	//	Player'da gelecek siralarda yapilacak hamlenin atilacagi bos string burada tanimlandi.
	public String hamle;
	
	//	Toplanan puan'lar burada tutulacak sah mat oldugu zaman da print edilecek.
	public int toplamPuan;
	
	public void tahtayiBastir() {
		Player beyaz=new Player("Beyaz");
		Player siyah= new Player("Siyah");
		Scanner keyboard = new Scanner(System.in);
		oyunuBaslat();
		Board board = new Board();
		for(int i=0;i<8;i++)
		board.getTahta()[0][i]=new Piyon("P");
		
		board.getTahta()[1][0]=new Kale("K");
		board.getTahta()[1][1]=new At("A");
		board.getTahta()[1][2]=new Fil("F");
		board.getTahta()[1][3]=new Vezir("V");
		board.getTahta()[1][4]=new Sah("S");
		board.getTahta()[1][5]=new Fil("F");
		board.getTahta()[1][6]=new At("A");
		board.getTahta()[1][7]=new Kale("K");
		
		/*	Tahta olustururken Item array'i olusturuldugu icin bos kisimlara da bir nesne kullanmaliydik Empty'ler bunun icin olusturuldu.
		Eger oyuncu bos bir yeri kullanarak hamle yapmaya kalkisirsa her turlu false donecek ve yeni input istenecek.	*/
		
		for(int i=0;i<8;i++)
			board.getTahta()[2][i]=new Empty();
		for(int i=0;i<8;i++)
			board.getTahta()[3][i]=new Empty();
		for(int i=0;i<8;i++)
			board.getTahta()[4][i]=new Empty();
		for(int i=0;i<8;i++)
			board.getTahta()[5][i]=new Empty();
		board.getTahta()[6][0]=new Kale("k");
		board.getTahta()[6][1]=new At("a");
		board.getTahta()[6][2]=new Fil("f");
		board.getTahta()[6][3]=new Vezir("v");
		board.getTahta()[6][4]=new Sah("s");
		board.getTahta()[6][5]=new Fil("f");
		board.getTahta()[6][6]=new At("a");
		board.getTahta()[6][7]=new Kale("k");
		for(int i=0;i<8;i++)
			board.getTahta()[7][i]=new Piyon("p");
		
		int harf=97; //ASCII
		tahtayiYazdir(board);
		
		//	Ilk hamle beyaz'dan baslanir ve asagidaki dongude sirasiyla once siyah istenir ve sira beyaza geri gecer.
		while(true) {
			beyaz.siraGecti();
			String hamle = keyboard.nextLine();
			if(hamle.equals("exit")) {
				oyunuSonlandir();
				beyaz.puaniYazdir();
				siyah.puaniYazdir();
				System.exit(0);
			}
			eskiSatir = ((int)hamle.charAt(0))-97;
			eskiSutun = ((int)hamle.charAt(1))-49;
			yeniSatir = ((int)hamle.charAt(3))-97;
			yeniSutun = ((int)hamle.charAt(4))-49;
			
			//	Eger piyonsa geri gitmemesi icin eklenen kontrol
			if(board.getTahta()[eskiSatir][eskiSutun] instanceof Piyon) {
				while(eskiSatir-yeniSatir>0) {
					hataliGirdi();
					hamle = keyboard.nextLine();
					if(hamle.equals("exit")) {
						oyunuSonlandir();
						beyaz.puaniYazdir();
						siyah.puaniYazdir();
						System.exit(0);
					}
					eskiSatir = ((int)hamle.charAt(0))-97;
					eskiSutun = ((int)hamle.charAt(1))-49;
					yeniSatir = ((int)hamle.charAt(3))-97;
					yeniSutun = ((int)hamle.charAt(4))-49;
				}
			}
			//	Ayni karakterden tassa yememesi icin asagidaki metod eklendi. Ayni olmayana kadar calisir.
			while((((board.getTahta()[yeniSatir][yeniSutun] instanceof Sah)&&(((int)(((Sah)board.getTahta()[yeniSatir][yeniSutun]).isim.charAt(0)))<90))||((board.getTahta()[yeniSatir][yeniSutun] instanceof Piyon)&&(((int)(((Piyon)board.getTahta()[yeniSatir][yeniSutun]).isim.charAt(0)))<90))||((board.getTahta()[yeniSatir][yeniSutun] instanceof At)&&(((int)(((At)board.getTahta()[yeniSatir][yeniSutun]).isim.charAt(0)))<90))||((board.getTahta()[yeniSatir][yeniSutun] instanceof Fil)&&(((int)(((Fil)board.getTahta()[yeniSatir][yeniSutun]).isim.charAt(0)))<90))||((board.getTahta()[yeniSatir][yeniSutun] instanceof Kale)&&(((int)(((Kale)board.getTahta()[yeniSatir][yeniSutun]).isim.charAt(0)))<90))||((board.getTahta()[yeniSatir][yeniSutun] instanceof Vezir)&&(((int)(((Vezir)board.getTahta()[yeniSatir][yeniSutun]).isim.charAt(0)))<90)))){
				hataliGirdi();
				hamle = keyboard.nextLine();
				if(hamle.equals("exit")) {
					oyunuSonlandir();
					beyaz.puaniYazdir();
					siyah.puaniYazdir();
					System.exit(0);
				}
				eskiSatir = ((int)hamle.charAt(0))-97;
				eskiSutun = ((int)hamle.charAt(1))-49;
				yeniSatir = ((int)hamle.charAt(3))-97;
				yeniSutun = ((int)hamle.charAt(4))-49;
			}
		if((board.getTahta()[eskiSatir][eskiSutun].hamleYapabilirMi(board.getTahta(),eskiSatir,eskiSutun,yeniSatir,yeniSutun))&&(((board.getTahta()[eskiSatir][eskiSutun] instanceof Sah)&&(((int)(((Sah)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))<90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Piyon)&&(((int)(((Piyon)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))<90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof At)&&(((int)(((At)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))<90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Fil)&&(((int)(((Fil)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))<90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Kale)&&(((int)(((Kale)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))<90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Vezir)&&(((int)(((Vezir)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))<90)))) {
			harf=97;
			Item temp=board.getTahta()[eskiSatir][eskiSutun];
			board.getTahta()[eskiSatir][eskiSutun]=new Empty();
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof Piyon) {
				beyaz.toplamPuan+=1;
			}
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof Fil) {
				beyaz.toplamPuan+=3;
			}
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof At) {
				beyaz.toplamPuan+=3;
			}
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof Kale) {
				beyaz.toplamPuan+=5;
			}
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof Vezir) {
				beyaz.toplamPuan+=9;
			}
			//	Eger yenen son tas sah ise son tahtayi yazdirir ve cikis yapar.
			
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof Sah) {
				board.getTahta()[yeniSatir][yeniSutun]=temp;
				tahtayiYazdir(board);
				beyazKazandi();
				beyaz.puaniYazdir();
				siyah.puaniYazdir();
				System.exit(0);
			}
			board.getTahta()[yeniSatir][yeniSutun]=temp;
			tahtayiYazdir(board);
		}
		else if(!((board.getTahta()[eskiSatir][eskiSutun].hamleYapabilirMi(board.getTahta(),eskiSatir,eskiSutun,yeniSatir,yeniSutun))&&(((board.getTahta()[eskiSatir][eskiSutun] instanceof Sah)&&(((int)(((Sah)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))<90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Piyon)&&(((int)(((Piyon)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))<90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof At)&&(((int)(((At)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))<90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Fil)&&(((int)(((Fil)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))<90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Kale)&&(((int)(((Kale)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))<90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Vezir)&&(((int)(((Vezir)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))<90))))){
			while(!((board.getTahta()[eskiSatir][eskiSutun].hamleYapabilirMi(board.getTahta(),eskiSatir,eskiSutun,yeniSatir,yeniSutun))&&(((board.getTahta()[eskiSatir][eskiSutun] instanceof Sah)&&(((int)(((Sah)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))<90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Piyon)&&(((int)(((Piyon)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))<90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof At)&&(((int)(((At)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))<90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Fil)&&(((int)(((Fil)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))<90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Kale)&&(((int)(((Kale)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))<90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Vezir)&&(((int)(((Vezir)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))<90))))){
			hataliGirdi();
			hamle = keyboard.nextLine();
			if(hamle.equals("exit")) {
				oyunuSonlandir();
				beyaz.puaniYazdir();
				siyah.puaniYazdir();
				System.exit(0);
			}
			eskiSatir = ((int)hamle.charAt(0))-97;
			eskiSutun = ((int)hamle.charAt(1))-49;
			yeniSatir = ((int)hamle.charAt(3))-97;
			yeniSutun = ((int)hamle.charAt(4))-49;
			}
			Item temp=board.getTahta()[eskiSatir][eskiSutun];
			board.getTahta()[eskiSatir][eskiSutun]=new Empty();
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof Piyon) {
				beyaz.toplamPuan+=1;
			}
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof Fil) {
				beyaz.toplamPuan+=3;
			}
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof At) {
				beyaz.toplamPuan+=3;
			}
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof Kale) {
				beyaz.toplamPuan+=5;
			}
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof Vezir) {
				beyaz.toplamPuan+=9;
			}
			//	Eger yenen son tas sah ise son tahtayi yazdirir ve cikis yapar.
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof Sah) {
				board.getTahta()[yeniSatir][yeniSutun]=temp;
				tahtayiYazdir(board);
				beyazKazandi();
				beyaz.puaniYazdir();
				siyah.puaniYazdir();
				System.exit(0);
			}
			board.getTahta()[yeniSatir][yeniSutun]=temp;
		}
		solaKaydirOutput();
		board.arrayiSolaKaydir(board.getTahta());
		tahtayiYazdir(board);
		System.out.println();
		siyah.siraGecti();
		hamle = keyboard.nextLine();
		if(hamle.equals("exit")) {
			oyunuSonlandir();
			beyaz.puaniYazdir();
			siyah.puaniYazdir();
			System.exit(0);
		}
		eskiSatir = ((int)hamle.charAt(0))-97;
		eskiSutun = ((int)hamle.charAt(1))-49;
		yeniSatir = ((int)hamle.charAt(3))-97;
		yeniSutun = ((int)hamle.charAt(4))-49;
		
		//	Eger piyonsa geri gitmemesi icin eklenen kontrol
		if(board.getTahta()[eskiSatir][eskiSutun] instanceof Piyon) {
			while(eskiSatir-yeniSatir<0) {
				hataliGirdi();
				hamle = keyboard.nextLine();
				if(hamle.equals("exit")) {
					oyunuSonlandir();
					beyaz.puaniYazdir();
					siyah.puaniYazdir();
					System.exit(0);
				}
				eskiSatir = ((int)hamle.charAt(0))-97;
				eskiSutun = ((int)hamle.charAt(1))-49;
				yeniSatir = ((int)hamle.charAt(3))-97;
				yeniSutun = ((int)hamle.charAt(4))-49;
			}
		}
		//	Ayni karakterden tassa yememesi icin asagidaki metod eklendi. Ayni olmayana kadar calisir.
		while((((board.getTahta()[yeniSatir][yeniSutun] instanceof Sah)&&(((int)(((Sah)board.getTahta()[yeniSatir][yeniSutun]).isim.charAt(0)))>90))||((board.getTahta()[yeniSatir][yeniSutun] instanceof Piyon)&&(((int)(((Piyon)board.getTahta()[yeniSatir][yeniSutun]).isim.charAt(0)))>90))||((board.getTahta()[yeniSatir][yeniSutun] instanceof At)&&(((int)(((At)board.getTahta()[yeniSatir][yeniSutun]).isim.charAt(0)))>90))||((board.getTahta()[yeniSatir][yeniSutun] instanceof Fil)&&(((int)(((Fil)board.getTahta()[yeniSatir][yeniSutun]).isim.charAt(0)))>90))||((board.getTahta()[yeniSatir][yeniSutun] instanceof Kale)&&(((int)(((Kale)board.getTahta()[yeniSatir][yeniSutun]).isim.charAt(0)))>90))||((board.getTahta()[yeniSatir][yeniSutun] instanceof Vezir)&&(((int)(((Vezir)board.getTahta()[yeniSatir][yeniSutun]).isim.charAt(0)))>90)))){
			hataliGirdi();
			hamle = keyboard.nextLine();
			if(hamle.equals("exit")) {
				oyunuSonlandir();
				beyaz.puaniYazdir();
				siyah.puaniYazdir();
				System.exit(0);
			}
			eskiSatir = ((int)hamle.charAt(0))-97;
			eskiSutun = ((int)hamle.charAt(1))-49;
			yeniSatir = ((int)hamle.charAt(3))-97;
			yeniSutun = ((int)hamle.charAt(4))-49;
		}
		if((board.getTahta()[eskiSatir][eskiSutun].hamleYapabilirMi(board.getTahta(),eskiSatir,eskiSutun,yeniSatir,yeniSutun))&&(((board.getTahta()[eskiSatir][eskiSutun] instanceof Sah)&&(((int)(((Sah)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))>90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Piyon)&&(((int)(((Piyon)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))>90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof At)&&(((int)(((At)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))>90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Fil)&&(((int)(((Fil)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))>90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Kale)&&(((int)(((Kale)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))>90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Vezir)&&(((int)(((Vezir)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))>90)))) {
			harf=97;
			Item temp=board.getTahta()[eskiSatir][eskiSutun];
			board.getTahta()[eskiSatir][eskiSutun]=new Empty();
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof Piyon) {
				siyah.toplamPuan+=1;
			}
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof Fil) {
				siyah.toplamPuan+=3;
			}
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof At) {
				siyah.toplamPuan+=3;
			}
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof Kale) {
				siyah.toplamPuan+=5;
			}
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof Vezir) {
				siyah.toplamPuan+=9;
			}
			//	Eger yenen son tas sah ise son tahtayi yazdirir ve cikis yapar.
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof Sah) {
				board.getTahta()[yeniSatir][yeniSutun]=temp;
				tahtayiYazdir(board);
				siyahKazandi();
				beyaz.puaniYazdir();
				siyah.puaniYazdir();
				System.exit(0);
			}
			board.getTahta()[yeniSatir][yeniSutun]=temp;
			tahtayiYazdir(board);
		}
		else if(!((board.getTahta()[eskiSatir][eskiSutun].hamleYapabilirMi(board.getTahta(),eskiSatir,eskiSutun,yeniSatir,yeniSutun))&&(((board.getTahta()[eskiSatir][eskiSutun] instanceof Sah)&&(((int)(((Sah)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))>90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Piyon)&&(((int)(((Piyon)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))>90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof At)&&(((int)(((At)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))>90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Fil)&&(((int)(((Fil)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))>90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Kale)&&(((int)(((Kale)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))>90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Vezir)&&(((int)(((Vezir)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))>90))))){
			while(!((board.getTahta()[eskiSatir][eskiSutun].hamleYapabilirMi(board.getTahta(),eskiSatir,eskiSutun,yeniSatir,yeniSutun))&&(((board.getTahta()[eskiSatir][eskiSutun] instanceof Sah)&&(((int)(((Sah)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))>90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Piyon)&&(((int)(((Piyon)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))>90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof At)&&(((int)(((At)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))>90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Fil)&&(((int)(((Fil)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))>90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Kale)&&(((int)(((Kale)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))>90))||((board.getTahta()[eskiSatir][eskiSutun] instanceof Vezir)&&(((int)(((Vezir)board.getTahta()[eskiSatir][eskiSutun]).isim.charAt(0)))>90))))){
			hataliGirdi();
			hamle = keyboard.nextLine();
			if(hamle.equals("exit")) {
				oyunuSonlandir();
				beyaz.puaniYazdir();
				siyah.puaniYazdir();
				System.exit(0);
			}
			eskiSatir = ((int)hamle.charAt(0))-97;
			eskiSutun = ((int)hamle.charAt(1))-49;
			yeniSatir = ((int)hamle.charAt(3))-97;
			yeniSutun = ((int)hamle.charAt(4))-49;
			}
			Item temp=board.getTahta()[eskiSatir][eskiSutun];
			board.getTahta()[eskiSatir][eskiSutun]=new Empty();
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof Piyon) {
				siyah.toplamPuan+=1;
			}
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof Fil) {
				siyah.toplamPuan+=3;
			}
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof At) {
				siyah.toplamPuan+=3;
			}
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof Kale) {
				siyah.toplamPuan+=5;
			}
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof Vezir) {
				siyah.toplamPuan+=9;
			}
			//	Eger yenen son tas sah ise son tahtayi yazdirir ve cikis yapar.
			if(board.getTahta()[yeniSatir][yeniSutun] instanceof Sah) {
				board.getTahta()[yeniSatir][yeniSutun]=temp;
				tahtayiYazdir(board);
				siyahKazandi();
				beyaz.puaniYazdir();
				siyah.puaniYazdir();
				System.exit(0);
			}
			board.getTahta()[yeniSatir][yeniSutun]=temp;
		}
		solaKaydirOutput();
		board.arrayiSolaKaydir(board.getTahta());
		tahtayiYazdir(board);
		System.out.println();
		}
	}
	public void tahtayiYazdir(Board board) {
		System.out.println("\t1\t2\t3\t4\t5\t6\t7\t8");
		for(int i=0,harf1=97;i<8;i++,harf1++) {
			System.out.print((char)harf1);
			for(int j=0;j<8;j++) {
				System.out.print("\t"+board.getTahta()[i][j]);
			}
			System.out.println();
		}
	}
	public void oyunuBaslat() {
		System.out.println("Satranc oyunu baslatiliyor...");
		System.out.println("-----------------------------------------------------------------");
	}
	public void oyunuBitir() {
		System.out.println("Sah Mat, oyun bitti.");
		System.exit(0);
	}
	public void oyunuSonlandir() {
		System.out.println("Oyun sonlandirildi. Puanlar yaziliyor...");
	}
	public void hataliGirdi() {
		System.out.println("Hatali girdiniz, gecerli bir hamle giriniz.");
	}
	public void solaKaydirOutput() {
		System.out.println("\nTahta sola kaydiriliyor...");
	}
	public void beyazKazandi() {
		System.out.println("Sah mat. Oyun bitti. Beyaz kazandi.");
	}
	public void siyahKazandi() {
		System.out.println("Sah mat. Oyun bitti. Siyah kazandi.");
	}

}
