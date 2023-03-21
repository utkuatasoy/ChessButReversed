public class Main {

	public static void main(String[] args) {
		Main baslat = new Main();
		baslat.tahtayiOlusturVeHamleleriAl();
	}

	public void tahtayiOlusturVeHamleleriAl() {
		//	Oyuncular game icinde olusturuldu, board ve diger gerekli methodlar tahtayiBastir'da invoke edilmistir.
		Game board = new Game();
		board.tahtayiBastir();
		//	Tahtayi bastirdi, gerekli tum methodlar bu methodun icine implement edilmistir.
		
}
}
