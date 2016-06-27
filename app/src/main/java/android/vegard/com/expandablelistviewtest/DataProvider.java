package android.vegard.com.expandablelistviewtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Vegard on 27.06.2016.
 */
public class DataProvider {
    public static HashMap<String, List<String>> getInfo() {
        HashMap<String, List<String>> groupDetails = new HashMap<String, List<String>>();

        List<String> group1 = new ArrayList<String>();
        group1.add("child1");
        group1.add("child2");
        group1.add("child3");

        List<String> group2 = new ArrayList<String>();
        group2.add("child1");
        group2.add("child2");
        group2.add("child3");

        List<String> group3 = new ArrayList<String>();
        group3.add("child1");
        group3.add("child2");
        group3.add("child3");

        List<String> group4 = new ArrayList<String>();
        group4.add("child1");
        group4.add("child2");
        group4.add("child3");

        groupDetails.put("group1",group1);
        groupDetails.put("group2",group2);
        groupDetails.put("group3",group3);
        groupDetails.put("group4",group4);

        return groupDetails;
    }
}
