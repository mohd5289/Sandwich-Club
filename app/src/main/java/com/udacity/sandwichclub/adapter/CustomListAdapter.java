package com.udacity.sandwichclub.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.udacity.sandwichclub.R;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;
import com.squareup.picasso.Picasso;

public class CustomListAdapter extends BaseAdapter {

    Context mContext;
    String[] sandwiches;

    public CustomListAdapter(Context context, String[] sandwiches) {
        this.mContext = context;
        this.sandwiches = sandwiches;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        @SuppressLint("ViewHolder") View row = inflater.inflate(R.layout.list_item, viewGroup, false);


        ImageView thumbnail = row.findViewById(R.id.item_thumb);
        TextView titleTV = row.findViewById(R.id.item_title);
        final ProgressBar progressBar = row.findViewById(R.id.thumb_progressbar);

        view = thumbnail;


        String json = sandwiches[i];
        Sandwich sandwich = JsonUtils.parseSandwichJson(json);

        assert sandwich != null;
        Picasso.with(mContext)
                .load(sandwich.getImage())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error_loading)
                .into(thumbnail);


        view.setTransitionName(sandwich.getMainName());

        titleTV.setText(sandwich.getMainName());

        return row;
    }
}
