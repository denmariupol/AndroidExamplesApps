package com.example.recyclesview.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclesview.R;
import com.example.recyclesview.activities.MainActivity;
import com.example.recyclesview.model.Station;

import java.util.ArrayList;

/**
 * Created by den on 2017-04-26.
 */

public class StationsAdapter extends RecyclerView.Adapter<StationsAdapter.StationViewHolder> {
    private ArrayList<Station> stations;

    public StationsAdapter(ArrayList<Station> stations) {
        this.stations = stations;
    }

    @Override
    public StationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  stationCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_station,parent,false);

        return new StationViewHolder(stationCard);
    }

    @Override
    public void onBindViewHolder(StationViewHolder holder, final int position) {
        Station station = stations.get(position);
        holder.updateUI(station);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getMainActivity().loadDetailScreen();
            }
        });
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }

    public class StationViewHolder extends RecyclerView.ViewHolder{

        private ImageView mainImage;
        private TextView titleText;
        public StationViewHolder(View itemView) {
            super(itemView);
            this.mainImage = (ImageView)itemView.findViewById(R.id.main_immage);
            this.titleText = (TextView)itemView.findViewById(R.id.main_text);
        }

        public void updateUI(Station station){
            String uri = station.getImageUri();
            int resource = mainImage.getResources().getIdentifier(uri,null,mainImage.getContext().getPackageName());
//            mainImage.setImageResource(resource);

            titleText.setText(station.getStationTitle());
        }
    }
}
