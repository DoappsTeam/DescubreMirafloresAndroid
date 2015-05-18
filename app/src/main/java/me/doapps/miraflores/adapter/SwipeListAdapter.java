package me.doapps.miraflores.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import me.doapps.miraflores.R;
import me.doapps.miraflores.helper.Movie;
import me.doapps.miraflores.model.Entity_DTO;
import me.doapps.miraflores.util.CircleTransform;

/**
 * Created by william on 17/05/2015.
 */
public class SwipeListAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Entity_DTO> entity_dtos;
    private Context context;


    public SwipeListAdapter(List<Entity_DTO> entity_dtos, Context context) {
        this.entity_dtos = entity_dtos;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return entity_dtos.size();
    }

    @Override
    public Object getItem(int location) {
        return entity_dtos.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        Entity_DTO entity_dto = entity_dtos.get(position);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_event, parent, false);
            holder = new Holder();

            holder.textName = (TextView) convertView.findViewById(R.id.textName);
            holder.banner = (ImageView) convertView.findViewById(R.id.banner);
            holder.imageBanner = (ImageView) convertView.findViewById(R.id.imageBanner);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.textName.setText(entity_dto.getName());
        Picasso.with(context).load(entity_dto.getUrlLogo()).transform(new CircleTransform()).into(holder.banner);
        Picasso.with(context).load(entity_dto.getUrlBanner()).centerCrop().fit().into(holder.imageBanner);

        return convertView;
    }


    /**Holder**/
    class Holder{
        TextView textName;
        ImageView banner;
        ImageView imageBanner;
    }
}