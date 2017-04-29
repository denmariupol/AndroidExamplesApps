package com.example.imageapp.model;

import android.net.Uri;

/**
 * Created by den on 2017-04-29.
 */

public class Image {
    private Uri imageResourceUrl;

    public Image(Uri imageResourceUrl) {
        this.imageResourceUrl = imageResourceUrl;
    }

    public Uri getImageResourceUrl() {
        return imageResourceUrl;
    }
}
