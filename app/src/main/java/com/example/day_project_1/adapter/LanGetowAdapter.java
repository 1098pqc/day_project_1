package com.example.day_project_1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.day_project_1.R;
import com.example.day_project_1.data.ItemBean;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class LanGetowAdapter extends DelegateAdapter.Adapter {
    private ColumnLayoutHelper columnLayoutHelper;
    private ArrayList<ItemBean.DataDTO.ChannelDTO> channel;

    public LanGetowAdapter(ColumnLayoutHelper columnLayoutHelper, ArrayList<ItemBean.DataDTO.ChannelDTO> channel) {
        this.columnLayoutHelper = columnLayoutHelper;
        this.channel = channel;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return columnLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_channel, null, false);
        return new ChannelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChannelViewHolder channelViewHolder = (ChannelViewHolder) holder;
        ItemBean.DataDTO.ChannelDTO channelDTO = channel.get(position);
        channelViewHolder.title.setText(channelDTO.getName());
        Glide.with(channelViewHolder.image).load(channelDTO.getIcon_url()).into(channelViewHolder.image);
    }

    @Override
    public int getItemCount() {
        return channel.size();
    }

    private class ChannelViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final ImageView image;

        public ChannelViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.channel_image);
            title = view.findViewById(R.id.channel_title);
        }
    }
}
