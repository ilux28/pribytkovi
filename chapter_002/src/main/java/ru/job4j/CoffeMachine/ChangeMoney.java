package ru.job4j.CoffeMachine;

public class ChangeMoney {
    int[] result = new int[15];
    int[] num = {1, 2, 5, 10};

    public int[] changes(int value, int price) {
        int j = 0;
        int cach = value - price;
        for (int i = 0; i < result.length; i++) {
            if (cach > num[num.length - 1 - j]) {
                cach = cach - num[num.length - 1 - j];
                result[i] = num[num.length - 1 - j];
            } else if (cach == num[num.length - 1 - j]) {
                result[i] = num[num.length - 1 - j];
                cach = cach - num[num.length - 1 - j];

                break;
            } else if (num.length - 1 > j){
                i--;
                j++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        ChangeMoney op = new ChangeMoney();
        int[] res = op.changes(50, 35);
        for (int v : res)
        System.out.println(v);
    }
}