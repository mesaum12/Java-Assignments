package java_assignments;
import java.io.FileReader;
import java.util.*;
import java.io.IOException;
public class DictionaryMapping {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("C:\\Users\\Public\\src\\java_assignments\\saurabh.txt");
        Scanner sc = new Scanner(fr);

        HashMap<String, ArrayList<Integer>> h_map = new HashMap<>();
        int count = 1;
        String line;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            String[] key_of_map = line.split("[.,?/;:' !]");
            for(int i=0;i<key_of_map.length;i++)
                key_of_map[i]=key_of_map[i].toUpperCase();
            //traversing and storing the keys in the HashMap
            for(int i=0;i<key_of_map.length;i++)
            {
                    if(!h_map.containsKey(key_of_map[i]))
                    {
                        h_map.put(key_of_map[i],new ArrayList<Integer>());
                        h_map.get(key_of_map[i]).add(count);
                    }
                    else
                    {
                        if(!h_map.get(key_of_map[i]).contains(count))
                       h_map.get(key_of_map[i]).add(count);
                    }
            }
            count++;
        }
        ArrayList<String>key_list=new ArrayList<String>();

        //storing the keySet obtained in a new ArrayList and then sorting it
        for (String str:h_map.keySet()) {
            key_list.add(str);
        }

        Collections.sort(key_list);

       //displaying the key list and the string corresponding to it
        for (String str:key_list) {
            ArrayList<Integer> list=h_map.get(str);
            System.out.print(str+": ");
            for(int i=0;i<list.size();i++)
                System.out.print(list.get(i)+" ");
            System.out.println("\n");
        }
    }
}

