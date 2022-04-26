import java.util.ArrayList;
import java.util.Collections;

public class HotelBokking {
    public static void main(String[] args) {
    ArrayList<Integer> a = new ArrayList<>();
    ArrayList<Integer> d = new ArrayList<>();
    a.add(1);a.add(2);a.add(3);a.add(4);
    d.add(10);d.add(2);d.add(6);d.add(14);
    new HotelBokking().hotel(a,d,4);
    }

    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        if(K==0 || arrive.size()==0){
            return true;
        }
        int roomCount=0;
        Collections.sort(arrive);
        Collections.sort(depart);
        roomCount++;
        int d=0;
        int a=1;
        while(a<arrive.size()){
            if(arrive.get(a)<depart.get(d)){
                roomCount++;
                a++;
            }else{
                d++;
                roomCount--;
            }
        }

        return K>=roomCount;
    }
}
