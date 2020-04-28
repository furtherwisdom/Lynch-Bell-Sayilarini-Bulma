
package lynchbellsorusu;

import java.util.ArrayList;

public class Lynchbellsorusu {
    
    //kontrol edilecek sayıları ilk önce stringe cast edip daha sonra sayıyı oluşturan rakamları arrayListe atan method.
    private static ArrayList<Integer> arrCevir(int cevrilecekSayi){
        
        String sayiString = String.valueOf(cevrilecekSayi);
        ArrayList<Integer> intArray = new ArrayList<>(); 
        
        for(int i = 0 ; i < sayiString.length(); i++){ 
            intArray.add(Character.getNumericValue(sayiString.charAt(i))); //sayıyı stringe çevirdikten sonra elde edilen karakterlerle matematiksel işlem
                                                                           //yapamayacağımız için getNumericValue methoduyla karakterlere karşılık gelen rakamları
                                                                           //arrayListe atıyoruz. Bir bakıma string ifadedeki char karakterleri int tipine çeviriyoruz.
        }
        
        return intArray;
    }
   
    public static void main(String[] args) {
        
        for(int i = 1000; i <= 9999; i++){
            ArrayList<Integer> iArray = arrCevir(i);
            
            if(!iArray.contains(0)){ //bir sayıyı 0'a böldüğümüzde program hata vereceğinden dolayı içinde sıfır olmayan sayıları işleme alıyoruz. 
                if((i % iArray.get(0) == 0) && (i % iArray.get(1) == 0) && (i % iArray.get(2) == 0) && (i % iArray.get(3) == 0)){
                    System.out.println(i);
                }
            }
        }
    }
}
