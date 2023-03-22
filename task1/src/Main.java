//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, List<String>> directory = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String action = "";
        while(true){
            System.out.print("Введите имя человека или команду \"exit\": ");
            action = scanner.nextLine();
            if(action.equals("exit")){
                System.out.println(directory);
                System.exit(0);
            }else{
                System.out.print("Введите номер: ");
                String num = scanner.nextLine();
                addNum(directory, num, action);
                System.out.println(directory);
            }
        }
    }

    public static void addNum(HashMap<String, List<String>> directory, String num, String name){
        if (directory.containsKey(name)){
           List<String> abonent =  directory.get(name);
           abonent.add(num);
        }else{
            List<String> numList = new ArrayList<>();
            numList.add(num);
            directory.put(name,numList);
        }
    }
}