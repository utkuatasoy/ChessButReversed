public class Piyon extends Item{
	public String isim;
	public Piyon() {
		//	Default constructor.
	}
	public Piyon(String isim) {
		/*	Beyaz taslarda buyuk harfle siyah tasla da kucuk harfle baslamasini istendigi icin parametre alan bir constructor olusturdum
		ve bu constructor'da isim olarak P ya da p aldi charAt ile de toString'e uyarladim. */
		this.isim = isim;
	}

	/*	Yeni nesne olustururken siyah ya da beyaza gore buyuk ve kucuk harf ayrimini yapmak icin tanimlarken 
	isim'lerinin ilk karakterini return ettim.
	
		Asagida da toString override edildi.	*/
	public String toString() {
		return isim.charAt(0)+"";
	}
	public boolean hamleYapabilirMi(Item[][] tahta, int eskiSatir, int eskiSutun, int yeniSatir, int yeniSutun) {
		
		//Eger hareket edecegi yer bos degil ise ilerlerken yememesi lazim bu yuzden false doner. Asagida yiyebilecegi eklendi.
		
		if((Math.abs(yeniSatir-eskiSatir)==1)&&(Math.abs(yeniSutun-eskiSutun)==0)&&tahta[yeniSatir][yeniSutun].toString().equals("-")){
			return true;
		}
		//Asagida yiyebilecegi eklendi.
		else if((Math.abs(yeniSatir-eskiSatir)==1)&&(Math.abs(yeniSutun-eskiSutun)==1)&&!tahta[yeniSatir][yeniSutun].toString().equals("-")) {
			return true;
		}
		return false;
	}
}