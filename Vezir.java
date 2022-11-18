public class Vezir extends Item{
	public String isim;
	public Vezir() {
		//	Default constructor.
	}
	
	public Vezir(String isim) {
		/*	Beyaz taslarda buyuk harfle siyah tasla da kucuk harfle baslamasini istendigi icin parametre alan bir constructor olusturdum
		ve bu constructor'da isim olarak S ya da s aldi charAt ile de toString'e uyarladim.	*/
		this.isim = isim;
	}

	/*	Yeni nesne olustururken siyah ya da beyaza gore buyuk ve kucuk harf ayrimini yapmak icin tanimlarken 
	isim'lerinin ilk karakterini return ettim.
	
		Asagida da toString override edildi.	*/
	
	public String toString(){
		return isim.charAt(0)+"";
	}
	
	public boolean hamleYapabilirMi(Item[][] tahta, int eskiSatir, int eskiSutun, int yeniSatir, int yeniSutun) {
		
		/*	Vezir'in yapabilecegi hamleler fil veya kale'nin yapabilecegi hamlelere denktir fakat ikisi de ayni anda olamaz,
		bu yuzden OR(||) operatoru kullanildi.	*/
		
		return new Kale(isim).hamleYapabilirMi(tahta, eskiSatir, eskiSutun, yeniSatir, yeniSutun) || new Fil(isim).hamleYapabilirMi(tahta, eskiSatir, eskiSutun, yeniSatir, yeniSutun);
	}
}