public class Fil extends Item{
	public String isim;
	public Fil(){
		//	Default constructor.
	}
	public Fil(String isim) {
		/*	Beyaz taslarda buyuk harfle siyah tasla da kucuk harfle baslamasini istendigi icin parametre alan bir constructor olusturdum
		ve bu constructor'da isim olarak F ya da f aldi charAt ile de toString'e uyarladim. */
		this.isim = isim;
	}
	
	/*	Yeni nesne olustururken siyah ya da beyaza gore buyuk ve kucuk harf ayrimini yapmak icin tanimlarken 
	isim'lerinin ilk karakterini return ettim.
	
		Asagida da toString override edildi.	*/
	public String toString(){
		return isim.charAt(0)+"";
	}
	public boolean hamleYapabilirMi(Item[][] tahta, int eskiSatir, int eskiSutun, int yeniSatir, int yeniSutun) {
		
		//	Fil hamlelerini satir ve sutunda esit miktarda hamle yaparak uygular, bu yuzden kontrol asagida boyle yapildi.
		
		if((Math.abs(yeniSutun-eskiSutun))==(Math.abs(yeniSutun-eskiSutun))){
			return true;
		}
		else
			return false;
	}
}