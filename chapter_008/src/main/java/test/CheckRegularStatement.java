package test;

class CheckRegularStatemet {
    public boolean checkReg(String line) {
        int s1 = 0, s2 = 0, s3 = 0, s4 = 0, s5 = 0, s6 = 0;
        for (int i = 0; i < line.length(); i++) {
            if ('(' == line.charAt(i)) {
                s1++;
            } else if (')' == line.charAt(i)){
                s2++;
            } else if ('[' == line.charAt(i)) {
                s3++;
            } else if (']' == line.charAt(i)) {
                s4++;
            }
        }
        if ((s1 == s2) && (s3 == s4) && (s5 == s6)) {
            return true;
        } else {return false;}
    }

}
