import java.util.*;

/**
 * Created by xiaoaxiao on 2020/4/22
 * Description:
 */
public class SortGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int num = scanner.nextInt();
            int sort = scanner.nextInt();
            scanner.nextLine();

            TreeMap<Integer,String> treeMap = null;
            if (sort == 1){
                treeMap = new TreeMap<>();


            }else {
                treeMap = new TreeMap<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2-o1;
                    }
                });

            }
            for (int i = 0; i < num; i++) {
                String str = scanner.nextLine().trim();
                treeMap.put(Integer.valueOf(str.split(" ")[1]),str.split(" ")[0]);
            }
            for (Map.Entry<Integer,String> entry : treeMap.entrySet()){
                System.out.println(entry.getValue()+" "+entry.getKey());
            }
        }
    }





}
