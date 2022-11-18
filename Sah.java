public class Sah extends Item{
	public String isim;
	public Sah() {
		//	Default constructor.
	}
	public Sah(String isim) {
	/*	Beyaz taslarda buyuk harfle siyah tasla da kucuk harfle baslamasini istendigi icin parametre alan bir constructor olusturdum
	ve bu constructor'da isim olarak S ya da s aldi charAt ile de toString'e uyarladim. */
		this.isim = isim;
	}
	
	/*	Yeni nesne olustururken siyah ya da beyaza gore buyuk ve kucuk harf ayrimini yapmak icin tanimlarken 
	isim'lerinin ilk karakterini return ettim.
	
		Asagida da toString override edildi.	*/
	
	public String toString(){
		return isim.charAt(0)+"";
	}
	public boolean hamleYapabilirMi(Item[][] tahta, int eskiSatir, int eskiSutun, int yeniSatir, int yeniSutun) {
		if((Math.abs(yeniSatir-eskiSatir)==1)&&(Math.abs(yeniSutun-eskiSutun)==0)){
			return true;
		}
		if((Math.abs(yeniSatir-eskiSatir)==0)&&(Math.abs(yeniSutun-eskiSutun)==1)){
			return true;
		}
		if((Math.abs(yeniSatir-eskiSatir)==1)&&(Math.abs(yeniSutun-eskiSutun)==1)){
			return true;
		}
		else return false;
	}
}