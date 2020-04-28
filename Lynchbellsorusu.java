package lynchbellsorusu;

import java.util.ArrayList;
import java.util.Objects;

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
    
    //sayının bütün rakamlarının benzersiz olup olmaması (sayıda tekrar eden rakam olup olmaması) durumuna göre değer döndüren method.
    private static boolean benzersizRakamKontrol(ArrayList<Integer> sayilar){
        boolean benzersiz = true;
        
        for(int i = 0 ; i < sayilar.size(); i++){
             for(int j = i+1; j < sayilar.size(); j++){
                 if(Objects.equals(sayilar.get(i), sayilar.get(j))){
                     benzersiz = false;
                     i = sayilar.size(); //eğer sayı aynı rakamdan iki tane içeriyorsa döngü koşulunun sağlanması engellenerek döngüye son veriliyor.
                     j = sayilar.size();
                    }
             }
        }
        
        
        return benzersiz;
    }
   
    public static void main(String[] args) {
        
        for(int i = 1000; i <= 9999; i++){
            ArrayList<Integer> iArray = arrCevir(i);
            
            if(!iArray.contains(0) && benzersizRakamKontrol(iArray)){ //bir sayıyı 0'a böldüğümüzde program hata verdiğinden dolayı içinde sıfır olmayan sayıları işleme alıyoruz. 
                if((i % iArray.get(0) == 0) &&
                   (i % iArray.get(1) == 0) &&
                   (i % iArray.get(2) == 0) &&
                   (i % iArray.get(3) == 0)){
                    System.out.println(i);
                }
            }
        }
    }
}
