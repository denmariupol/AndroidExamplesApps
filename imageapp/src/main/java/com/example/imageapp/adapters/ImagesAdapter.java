package com.example.imageapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.imageapp.R;
import com.example.imageapp.model.Image;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by den on 2017-04-29.
 */

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {

    ArrayList<Image> images;
    ImageView containerImage;
    Context context;
    public ImagesAdapter(ArrayList<Image> images, ImageView containerImage, Context context) {
        this.images = images;
        this.containerImage = containerImage;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_image,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Image image = images.get(position);
        holder.updateUI(image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                containerImage.setImageDrawable(holder.image.getDrawable());
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.image_thumb);
        }

        public void updateUI(final Image image){
//            this.image.setImageBitmap(decodeURI(image.getImageResourceUrl().getPath()));
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                    final Bitmap bmp = decodeURI(image.getImageResourceUrl().getPath());
                    //using weakreferences to avoid memory leak
                    final WeakReference<ImageView> img = new WeakReference<ImageView>(ViewHolder.this.image);
                    ((Activity)context).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ImageView imageViev = img.get();
                            //check if exist
                            if(imageViev != null)
                                imageViev.setImageBitmap(bmp);
                        }
                    });
                }

            });

        }
    }
    public Bitmap decodeURI(String file){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file,options);
        boolean scaleByHeight = Math.abs(options.outHeight - 100) >= Math.abs(options.outWidth - 100);

        if(options.outHeight * options.outWidth * 2 >= 16384){
            double sampleSize = scaleByHeight ? options.outHeight /1000 : options.outWidth / 1000;
            options.inSampleSize = (int)Math.pow(2d,Math.floor(Math.log(sampleSize)/Math.log(2d)));
        }
        options.inJustDecodeBounds = false;
        options.inTempStorage = new byte[512];
        return BitmapFactory.decodeFile(file,options);
    }
}
