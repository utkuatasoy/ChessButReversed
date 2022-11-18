public class Board extends Player{
//	Game'i extend ediyor buradan satir sutun girdileri ve yapilacak hamlenin alinacagi String inheritance bagi kurdu.
	public Item[][]tahta= new Item[8][8];

	public Item[][] getTahta() {
		return tahta;
	}

	public void setTahta(Item[][] tahta) {
		this.tahta = tahta;
	}

	public Board() {
		//	Default constructor.
	}
	public void arrayiSolaKaydir(Item[][] tahta) {
		
		/*	Bu method'da array 1 sola kayar, parametre olarak karistirmamak icin array ismi yine tahta olarak kullanildi.	
		Direkt clone olarak yeni array olusturup orda kaydirmayi denedim fakat bu sefer dongu icinde her array'i cagirdigimda sorun ortaya cikti.	*/
		
	    for(int satir = 0; satir < tahta.length; satir++){
	        int satirUzunlugu = tahta[satir].length;
	        Item[] temp = new Item[1];	
	        // Ilk boyutta  kaydirma yaparken verilerin kaybolmamasi icin temp olarak saklanirlar (Item nesnesi olarak)
	        for(int i = 0; i < 1; i++){
	        	temp[i] = tahta[satir][i];
	        }
	        for (int sutun = 0; sutun < satirUzunlugu-1; sutun++) {
	        	//	Normal olarak sola kaydirma yapilir asagidaki dongude kaybolan verilere mudahale edilecek.
	        	tahta[satir][sutun] = tahta[satir][sutun+1];
	        }
	        for (int i = 0; i < 1; i++) {
	        //	Kaybolan veriler icin burada elementler temp'lere esitlenir.
	        	tahta[satir][i+(satirUzunlugu-1)] = temp[i];
	        }
	    }
	}
}
