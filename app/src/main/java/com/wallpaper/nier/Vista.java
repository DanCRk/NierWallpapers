package com.wallpaper.nier;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Vista extends AppCompatActivity {

    private String urlrecived;
    ImageView imageView;
    Button botonset, botonlock;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_view);

        imageView = findViewById(R.id.imagen_itemview);
        botonlock = findViewById(R.id.buttonlockwpp);
        botonset = findViewById(R.id.buttonsetwpp);

        Intent intent = getIntent();
        urlrecived = intent.getStringExtra("ItemKey");

        Glide.with(this).load(urlrecived).into(imageView);

        botonset.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(Vista.this);
                progressDialog.setMessage("Cargando..."); // Setting Message
                progressDialog.setTitle("Estableciendo"); // Setting Title
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
                progressDialog.show(); // Display Progress Dialog
                progressDialog.setCancelable(false);
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            setWallpapers(urlrecived);
                            Thread.sleep(5000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        progressDialog.dismiss();
                    }
                }).start();
            }
        });
        botonlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*progressDialog = new ProgressDialog(Vista.this);
                progressDialog.setMessage("Cargando..."); // Setting Message
                progressDialog.setTitle("Estableciendo"); // Setting Title
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
                progressDialog.show(); // Display Progress Dialog
                progressDialog.setCancelable(false);
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            setWallpapersLock(urlrecived);
                            Thread.sleep(5000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        progressDialog.dismiss();
                    }
                }).start();*/

                setWallpapersLock(urlrecived);

            }

        });
    }

    private void setWallpapersLock(final String urlImage) {
        try {
            Thread thread = new Thread(new Runnable(){
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void run() {
                    try {
                        URL url = new URL( urlImage);
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setDoInput(true);
                        connection.connect();
                        InputStream input = connection.getInputStream();
                        Bitmap myImage = BitmapFactory.decodeStream(input);
                        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                        wallpaperManager.setBitmap(myImage,null,true, WallpaperManager.FLAG_LOCK);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        } catch (Exception error) {
            Log.e("Loading Image", "Error : " + error.getMessage());
        }
    }

    private void setWallpapers(final String urlImage) {
        try {
            Thread thread = new Thread(new Runnable(){
                @Override
                public void run() {
                    try {
                        URL url = new URL( urlImage);
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setDoInput(true);
                        connection.connect();
                        InputStream input = connection.getInputStream();
                        Bitmap myImage = BitmapFactory.decodeStream(input);
                        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                        wallpaperManager.setBitmap(myImage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        } catch (Exception error) {
            Log.e("Loading Image", "Error : " + error.getMessage());
        }
    }
}