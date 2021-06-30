package leetcode;

public class ParkingSystem {

    public int big;
    public int medium;
    public int small;
    public ParkingSystem(int big, int medium, int small) {
        this.big=big;
        this.medium=medium;
        this.small=small;
    }

    public boolean addCar(int carType) {
        if (carType==3){
            big--;
            return big>=0;
        }else if (carType==2){
            medium--;
            return medium>=0;
        }else {
            small--;
            return small>=0;
        }

    }

}
