public class At extends Item{
	public String isim;
	public At() {
		//	Default constructor.
	}
	public At(String isim) {
		/*	Beyaz taslarda buyuk harfle siyah tasla da kucuk harfle baslamasini istendigi icin parametre alan bir constructor olusturdum
		ve bu constructor'da isim olarak A ya da a aldi charAt ile de toString'e uyarladim. */
		this.isim = isim;
	}
	
	/*	Yeni nesne olustururken siyah ya da beyaza gore buyuk ve kucuk harf ayrimini yapmak icin tanimlarken 
	isim'lerinin ilk karakterini return ettim.
	
		Asagida da toString override edildi.	*/
	public String toString(){
		return isim.charAt(0)+"";
	}
	public boolean hamleYapabilirMi(Item[][] tahta, int eskiSatir, int eskiSutun, int yeniSatir, int yeniSutun) {
		
		//Hamle yapacagi yerler 2'ye 1' artmali ya da azalmali bu yuzden absolute deger aldim.
		
		if((Math.abs(yeniSatir-eskiSatir)==2)&&(Math.abs(yeniSutun-eskiSutun)==1)){
			return true;
		}
		else if((Math.abs(yeniSatir-eskiSatir)==1)&&(Math.abs(yeniSutun-eskiSutun)==2)){
			return true;
		}
		else return false;
	}
}