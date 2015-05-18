package me.doapps.miraflores.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import me.doapps.miraflores.R;
import me.doapps.miraflores.model.Entity_DTO;
import me.doapps.miraflores.util.CircleTransform;

/**
 * Created by william on 17/05/2015.
 */
public class ArrayAdapterEntity extends BaseAdapter {

    private Context context;
    List<Entity_DTO> entities;

    public ArrayAdapterEntity(Context context, List<Entity_DTO> entities) {
        this.context = context;
        this.entities = entities;
    }

    @Override
    public int getCount() {
        return entities.size();
    }

    @Override
    public Object getItem(int position) {
        return entities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            rowView = inflater.inflate(R.layout.item_event,parent,false);
        }

        ImageView imageViewBanner = (ImageView) rowView.findViewById(R.id.imageBanner);
        TextView textViewName = (TextView) rowView.findViewById(R.id.textName);
        ImageView imageViewLogo = (ImageView) rowView.findViewById(R.id.banner);
        TextView textViewAddress = (TextView) rowView.findViewById(R.id.address);
        TextView textViewHour = (TextView) rowView.findViewById(R.id.hour);
        TextView textViewPrice = (TextView) rowView.findViewById(R.id.price);

        Entity_DTO entity_dto = this.entities.get(position);


        textViewName.setText(entity_dto.getName());

        textViewAddress.setText(entity_dto.getAddress());
        textViewHour.setText("");
        textViewPrice.setText("");

        return rowView;
    }
}
