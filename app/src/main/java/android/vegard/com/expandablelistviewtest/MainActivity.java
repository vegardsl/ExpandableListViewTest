package android.vegard.com.expandablelistviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    HashMap<String, List<String>> parentListItems;
    List<String> childListItems;
    ExpandableListView expandableListView;
    ExpandableListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = (ExpandableListView) findViewById(R.id.exp_list);
        parentListItems = DataProvider.getInfo();
        childListItems = new ArrayList<String>(parentListItems.keySet());

        adapter = new ExpandableListAdapter(this, parentListItems, childListItems);
        expandableListView.setAdapter(adapter);
    }
}
