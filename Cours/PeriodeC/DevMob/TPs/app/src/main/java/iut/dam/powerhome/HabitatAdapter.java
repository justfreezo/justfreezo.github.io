package iut.dam.powerhome;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class HabitatAdapter extends ArrayAdapter<Habitat> {
    private Activity activity;
    private int itemResource;
    private List<Habitat> items;

    public HabitatAdapter(Activity activity, int itemResource, List<Habitat> items) {
        super(activity, itemResource, items);
        this.activity = activity;
        this.itemResource = itemResource;
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    public View initView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(itemResource, parent, false);

            holder = new ViewHolder();
            holder.residentTV = convertView.findViewById(R.id.residentTV);
            holder.numberTV = convertView.findViewById(R.id.numberFloorTV);
            holder.applianceTV = convertView.findViewById(R.id.applianceTV);
            holder.appliance1IV = convertView.findViewById(R.id.appliance1IV);
            holder.appliance2IV = convertView.findViewById(R.id.appliance2IV);
            holder.appliance3IV = convertView.findViewById(R.id.appliance3IV);
            holder.appliance4IV = convertView.findViewById(R.id.appliance4IV);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Habitat currentHabitat = getItem(position);

        if (currentHabitat != null) {
            holder.residentTV.setText(currentHabitat.getResident());
            holder.numberTV.setText(String.valueOf(currentHabitat.getNumberFloor()));
            holder.applianceTV.setText((CharSequence) currentHabitat.getAppliance());

            holder.appliance1IV.setImageResource(currentHabitat.getApplianceImage(1));
            holder.appliance2IV.setImageResource(currentHabitat.getApplianceImage(2));
            holder.appliance3IV.setImageResource(currentHabitat.getApplianceImage(3));
            holder.appliance4IV.setImageResource(currentHabitat.getApplianceImage(4));
        }

        return convertView;
    }

    static class ViewHolder {
        TextView residentTV;
        TextView numberTV;
        TextView applianceTV;
        ImageView appliance1IV;
        ImageView appliance2IV;
        ImageView appliance3IV;
        ImageView appliance4IV;
    }

}
