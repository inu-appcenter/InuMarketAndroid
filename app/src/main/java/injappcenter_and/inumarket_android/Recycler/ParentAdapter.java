package injappcenter_and.inumarket_android.Recycler;

import android.content.Context;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Vector;

import injappcenter_and.inumarket_android.Model.Category_Parent;

import injappcenter_and.inumarket_android.R;

public class ParentAdapter extends BaseExpandableListAdapter{
    private static final int PARENT = R.layout.item_category_recycler_parent;
    private static final int CHILD = R.layout.item_category_recycler_child;
    private Context context;
    private Vector<Category_Parent> data;
    private LayoutInflater inflater = null;

    public ParentAdapter(Context context, Vector<Category_Parent> data){
        this.data = data;
        this.context = context;
        this.inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getGroupCount() {
        return data.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return data.get(groupPosition).child.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return data.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return data.get(groupPosition).child.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView ==null){
            convertView = inflater.inflate(PARENT,parent,false);
        }
        ImageView icon = (ImageView)convertView.findViewById(R.id.image_categoryicon);
        TextView name = (TextView)convertView.findViewById(R.id.txt_categoryitem_recycler);
        ImageView expand = (ImageView)convertView.findViewById(R.id.image_expandbtn);

        icon.setImageResource(data.get(groupPosition).getCategory_image());
        name.setText(data.get(groupPosition).getCategory_name());
        expand.setImageResource(data.get(groupPosition).getExpandbtn());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = inflater.inflate(CHILD, parent, false);
        }
        TextView childname = (TextView) convertView.findViewById(R.id.txt_categoryitem_recycler_child);
        childname.setText(data.get(groupPosition).child.get(childPosition).getChildname());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
