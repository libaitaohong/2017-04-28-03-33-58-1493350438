public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
        char[] str = bowlingCode.toCharArray();
        int[] score = new int[str.length];
        int size = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '|'){
                continue;
            }else if (str[i] == 'X'){
                score[size++] = 10;
            } else if (str[i] == '/') {
                score[size] = 10 - score[size-1];
                size++;
            }else if (str[i] == '-'){
                score[size++] = 0;
            }else if (str[i] >= '0' && str[i] <= '9'){
                score[size++] = Integer.valueOf(String.valueOf(str[i]));
            }
        }
        int[] res = new int[10];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (index < 10){
                if (score[i] == 10){
                    res[index++] = 10 + score[i+1] + score[i+2];
                }else if (score[i+1] + score[i] == 10){
                    res[index++] = 10 + score[i+2];
                    i++;
                }else{
                    res[index++] = score[i] + score[i+1];
                    i++;
                }
            }
        }
        int ress = 0;
        for (int i = 0; i < 10; i++) {
            ress += res[i];
        }
        return ress;
    }
}
