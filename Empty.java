public class Empty extends Item{
	/*	Tahta olustururken Item array'i olusturuldugu icin bos kisimlara da bir nesne kullanmaliydik bunun icin olusturuldu,
	eger oyuncu bos bir yeri kullanarak hamle yapmaya kalkisirsa her turlu false donecek ve yeni input istenecek.	*/
	
	public boolean hamleYapabilirMi(Item[][] tahta, int eskiSatir, int eskiSutun, int yeniSatir, int yeniSutun) {
		return false;
	}
	
	/*	Empty olarak yazdigim bu class'ta tahtanin bos kareleri bulunuyor ve asagida da 
	toString'i "-" return edecek sekilde ovveride ettim.	*/
	
	public String toString() {
		return "-";
}
}
