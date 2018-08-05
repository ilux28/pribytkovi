package test;

public class ReplaceNullToOne {
    public int repl(int number) {
        String str = Integer.toString(number);
        String[] masChar = str.split("0");
        int length = masChar.length;
        if (str.charAt(str.length() - 1) == '0') {
            number = number + 1;
        } else {
            number = number + masChar[length - 1].length() * 10;
        }
        return number;
    }
}
