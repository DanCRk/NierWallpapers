package com.wallpaper.nier;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.WallpaperManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdRequest;

public class Vista extends AppCompatActivity {

    Uri url;
    ImageView img;
    Button set, lock, dsg, comparte;

    private InterstitialAd mInterstitialAd = null;
    private InterstitialAd mInterstitialAd2= null;
    private InterstitialAd mInterstitialAd3= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_view);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2030839089746380/7018773729");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        img = findViewById(R.id.imagen_itemview);
        lock = findViewById(R.id.buttonlockwpp);
        set = findViewById(R.id.buttonsetwpp);
        dsg = findViewById(R.id.botondescarga);
        comparte = findViewById(R.id.botoncomparte);

        final Intent intent = getIntent();
        url = Uri.parse(intent.getStringExtra("ItemKey"));

        Glide.with(this).load(url).into(img);

        dsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                solicitarpermisos();
                //convertir imagen
                img.buildDrawingCache();
                Bitmap bmap = img.getDrawingCache();
                //guardar imagen
                Save savefile = new Save();
                savefile.SaveImage(Vista.this, bmap);
            }
        });
        set.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                if (mInterstitialAd2.isLoaded()) {
                    mInterstitialAd2.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                BitmapDrawable drawable = (BitmapDrawable) img.getDrawable();
                Bitmap bit = drawable.getBitmap();
                try {
                    wallpaperManager.setBitmap(bit);
                    Toast.makeText(Vista.this, "Listo!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(Vista.this, "No se establecio el wallpaper", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });

        lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd3.isLoaded()) {
                    mInterstitialAd3.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                BitmapDrawable drawable = (BitmapDrawable) img.getDrawable();
                Bitmap bit = drawable.getBitmap();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    try {
                        wallpaperManager.setBitmap(bit,null,true,WallpaperManager.FLAG_LOCK);
                        Toast.makeText(Vista.this, "Listo!", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        Toast.makeText(Vista.this, "No se establecio el wallpaper", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    private  void  solicitarpermisos(){
        int permisoguardar = ActivityCompat.checkSelfPermission(Vista.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permisoguardar != PackageManager.PERMISSION_GRANTED){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 111);
            }
        }
    }
}