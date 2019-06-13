package www.inturnship.com.nss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdaptr extends BaseAdapter  {
    ArrayList<ListModel> arrayList=new ArrayList<>();
    Context context;

    public CustomAdaptr(ArrayList<ListModel> al_menus, Context context) {
        this.arrayList = al_menus;
        this.context = context;
    }

    private class ViewHolder {
        TextView txt_name;
    }



    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {
            holder=new ViewHolder();
            view = inflater.inflate(R.layout.row_item_slider, null);
            holder.txt_name=view.findViewById(R.id.txt_name);
            view.setTag(holder);

        } else {

            holder = (ViewHolder) view.getTag();
        }
        holder.txt_name.setText(arrayList.get(position).getName());



        return view;

    }
}
