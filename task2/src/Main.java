
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String,String> fiMap = new HashMap<>() ;
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        fiMap.put("Иванов", "Иван");
        fiMap.put("Петрова ", "Светлана");
        fiMap.put("Мусина  ", "Анна");
        fiMap.put("Крутова ", "Анна");
        fiMap.put("Юрин", "Иван");
        fiMap.put("Лыков", "Петр");
        fiMap.put("Чернов", "Павел");
        fiMap.put("Чернышов", "Петр");
        fiMap.put("Федорова", "Мария");
        fiMap.put("Светлова", "Марина");
        fiMap.put("Савина", "Мария");
        fiMap.put("Рыкова", "Мария");
        fiMap.put("Лугова", "Марина");
        fiMap.put("Владимирова", "Анна");
        fiMap.put("Мечников", "Иван");
        fiMap.put("Петин", "Петр");
        fiMap.put("Ежов", "Иван");


        Collections.addAll(set, fiMap.values().toArray(new String[fiMap.size()]));
        for (String item : set) {
            list.add(Integer.toString(Collections.frequency(fiMap.values(), item)) + " " + item);
        }
        Collections.sort(list);
        Collections.reverse(list);
        System.out.println(list);


    }
}