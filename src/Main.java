import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int currNum = 0;
        ArrayList<Integer> inputNumbers = new ArrayList<>();
        while(true){
            try{
                currNum = Integer.parseInt(sc.nextLine());
                inputNumbers.add(currNum);
            }catch (java.lang.NumberFormatException e){
                break;
            }
        }

        System.out.println(inputNumbers);

        for(int currInputNumber: inputNumbers){ //для каждого числа по отдельности
            int startDegree = 7;
            String currStrInputNumber = String.valueOf(currInputNumber);
            int minLengthForNum = currStrInputNumber.length() * 2 + 1;
            boolean numIsFind = false;

            for(int i = startDegree;  i < 31 ;i++){ //ищем наименьшую степень, подходящую двум условиям

                int potentialNumber = (int) Math.pow(2, i);
                String potentialStrNumber = String.valueOf(potentialNumber);
                if (potentialStrNumber.length() >= minLengthForNum){//проверка подходящей разрядности потенциального числа
                    //проверка совпадения первых цифр в строке
                    char [] potentialNumArray = potentialStrNumber.toCharArray();
                    char [] currentInputNumArray = currStrInputNumber.toCharArray();
                    boolean potNumIsMatches = true;
                    for(int j = 0; j<currentInputNumArray.length; j++){
                        if(potentialNumArray[j] != currentInputNumArray[j]){
                            potNumIsMatches = false;
                            break;
                        }

                    }
                    if(potNumIsMatches){
                        numIsFind = true;
                        System.out.println(i);
                        break;
                    }
                }
            }
            if(!numIsFind){//если не удалось найти степень в рамках предела 2^30:1073741824
                System.out.println("No power of 2");
            }
        }
    }
}