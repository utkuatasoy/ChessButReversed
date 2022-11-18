public class Kale extends Item{
	public String isim;
	public Kale() {
		//	Default constructor.
	}
	public Kale(String isim) {
		/*	Beyaz taslarda buyuk harfle siyah tasla da kucuk harfle baslamasini istendigi icin parametre alan bir constructor olusturdum
		ve bu constructor'da isim olarak K ya da k aldi charAt ile de toString'e uyarladim. */
		this.isim = isim;
	}

	/*	Yeni nesne olustururken siyah ya da beyaza gore buyuk ve kucuk harf ayrimini yapmak icin tanimlarken 
	isim'lerinin ilk karakterini return ettim.
	
		Asagida da toString override edildi.	*/
	
	public String toString(){
		return isim.charAt(0)+"";
	}
	public boolean hamleYapabilirMi(Item[][] tahta, int eskiSatir, int eskiSutun, int yeniSatir, int yeniSutun) {
		
	//	Kale hamlesinde ya sutun farki sabit kalir ya da satir farki, bu yuzden kontrol boyle yapildi.
		
		if(((yeniSatir-eskiSatir)==0)&&((yeniSutun-eskiSutun)!=0))
			return true;
		else if(((yeniSatir-eskiSatir)!=0)&&((yeniSutun-eskiSutun)==0))
			return true;
		else 
			return false;
	}
}