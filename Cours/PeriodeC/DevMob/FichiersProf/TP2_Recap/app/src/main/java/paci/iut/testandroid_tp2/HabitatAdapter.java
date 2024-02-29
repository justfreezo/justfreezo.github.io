package paci.iut.testandroid_tp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import paci.iut.testandroid_tp2.data.HabitatDesc;

public class HabitatAdapter extends ArrayAdapter<HabitatDesc> {
    Context context;
    int itemResourceId;
    List<HabitatDesc> items;

    public HabitatAdapter(Context context,
                          int itemResourceId,
                          List<HabitatDesc> items) {
        super(context, itemResourceId, items);

        this.context = context;
        this.itemResourceId = itemResourceId;
        this.items = items;
    }

    @Override
    public View getView(int position,
                        View convertView,
                        ViewGroup parent) {

        View layout = convertView;
        if (convertView == null) {
            //LayoutInflater inflater = activity.getLayoutInflater();
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = inflater.inflate(itemResourceId, parent, false);
        }
        TextView nameTV = (TextView) layout.findViewById(R.id.name);
        ImageView flagIV = (ImageView) layout.findViewById(R.id.flag);

        nameTV.setText(items.get(position).name);
        flagIV.setImageResource(items.get(position).flagResourceId);
        return layout;

    }
}
