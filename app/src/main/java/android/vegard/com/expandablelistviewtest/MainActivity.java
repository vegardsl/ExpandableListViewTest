package android.vegard.com.expandablelistviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    HashMap<String, List<String>> parentListItems;
    List<String> childListItems;
    //ExpandableListView expandableListView;
    AnimatedExpandableListView expandableListView;
    ExpandableListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = (AnimatedExpandableListView) findViewById(R.id.exp_list);
        parentListItems = DataProvider.getInfo();
        childListItems = new ArrayList<String>(parentListItems.keySet());

        adapter = new ExpandableListAdapter(this, parentListItems, childListItems);

        expandableListView.setAdapter(adapter);
/*
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Log.i("Tag","GroupExpanded");
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Log.i("Tag","GroupCollapsed");
            }
        });
*/
        // In order to show animations, we need to use a custom click handler
        // for our ExpandableListView.
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                // We call collapseGroupWithAnimation(int) and
                // expandGroupWithAnimation(int) to animate group
                // expansion/collapse.
                if (expandableListView.isGroupExpanded(groupPosition)) {
                    expandableListView.collapseGroupWithAnimation(groupPosition);
                } else {
                    expandableListView.expandGroupWithAnimation(groupPosition);
                }
                Log.i("Tag","Group Clicked!");
                return true;
            }

        });
    }
}
