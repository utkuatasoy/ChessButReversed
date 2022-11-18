public class Item {
	public String isim;
	//	Burada Item class'i diger taslarin extend edebilmesi ve inheritance bagi kurmasi icin olusturuldu.
	
	
	/* Class'in ve methodlarin abstract olarak tanimlanmamasinin sebebi tahta olusturulurken Item class'inin two dimensional array'i 
	 * kullaniliyor ve board olusturulurken de nesne olusturularak cagirilmasi isteniyor. Bu yuzden abstract class olarak tanimlanmadi. */
	
	public boolean hamleYapabilirMi(Item[][] tahta, int eskiSatir, int eskiSutun, int yeniSatir, int yeniSutun) {
		return false;
	}
}