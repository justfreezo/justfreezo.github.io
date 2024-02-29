package iut.dam.powerhome;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryAdapter extends ArrayAdapter<Country> {

    Activity activity;
    List<Country> items;
    int itemResourceId;

    public CountryAdapter(Activity activity, int itemResourceId, List<Country> items) {
        super(activity, itemResourceId, items);

        this.activity = activity;
        this.itemResourceId = itemResourceId;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_country, parent, false
            );
        }

        ImageView imageViewFlag = convertView.findViewById(R.id.flag);
        TextView textViewName = convertView.findViewById(R.id.name);

        Country currentItem = getItem(position);

        if (currentItem != null) {
            imageViewFlag.setImageResource(currentItem.getFlagImage());
            textViewName.setText(currentItem.getName());
        }

        return convertView;
    }
}
