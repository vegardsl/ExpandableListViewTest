package android.vegard.com.expandablelistviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Vegard on 27.06.2016.
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter{

    private Context context;
    private HashMap<String, List<String>> listGroups;
    private List<String> listItems;

    public ExpandableListAdapter(Context context,
                                 HashMap<String, List<String>> listGroups,
                                 List<String> listItems){
        this.context = context;
        this.listGroups = listGroups;
        this.listItems = listItems;
    }

    @Override
    public int getGroupCount() {
        return listItems.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return listGroups.get(listItems.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return listItems.get(i);
    }

    @Override
    public Object getChild(int parent, int child) {
        return listGroups.get(listItems.get(parent)).get(child);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int parent,
                             boolean isExpaned,
                             View convertView,
                             ViewGroup parentView) {
        String groupTitle = (String) getGroup(parent);
        if(convertView == null){
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.parent_layout, parentView, false);
        }

        TextView parentTextView = (TextView) convertView.findViewById(R.id.parent_txt);
        parentTextView.setText(groupTitle);

        return convertView;
    }

    @Override
    public View getChildView(int parent,
                             int child,
                             boolean lastChild,
                             View convertView,
                             ViewGroup parentView) {
        String childTitle = (String) getChild(parent, child);
        if(convertView == null){
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_layout,parentView, false);
        }

        TextView childTextView = (TextView) convertView.findViewById(R.id.child_txt);
        childTextView.setText(childTitle);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
