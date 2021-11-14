package dev.dinesh.leetcode.companies.amazon;

public class DesignParkingSystem {

    int big;
    int medium;
    int small;

    public DesignParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if(carType == 1 && this.big > 0) {
            this.big--;
            return true;
        } else if(carType == 2 && this.medium > 0) {
            this.medium--;
            return true;
        } else if(carType == 3 && this.small > 0) {
            this.small--;
            return true;
        } else {
            return false;
        }
    }

}