package com.wallpaper.nier;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.icu.text.SimpleDateFormat;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class Save {

    private Context TheThis;

    public void SaveImage(Context context, Bitmap ImageToSave) {

        TheThis = context;
        String nameOfFolder = "/WallpapersNier";
        String file_path = Environment.getExternalStorageDirectory().getAbsolutePath() + nameOfFolder;
        String CurrentDateAndTime = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            CurrentDateAndTime = getCurrentDateAndTime();
        }
        File dir = new File(file_path);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        String nameOfFile = "imagen";
        File file = new File(dir, nameOfFile + CurrentDateAndTime + ".jpg");

        try {
            FileOutputStream fOut = new FileOutputStream(file);

            ImageToSave.compress(Bitmap.CompressFormat.JPEG, 85, fOut); // error java.lang.NullPointerException
            fOut.flush();
            fOut.close();
            MakeSureFileWasCreatedThenMakeAvabile(file);
            AbleToSave();
        } catch(IOException e) {
            UnableToSave();
        }
    }

    private void MakeSureFileWasCreatedThenMakeAvabile(File file){
        MediaScannerConnection.scanFile(TheThis,
                new String[] { file.toString() } , null,
                new MediaScannerConnection.OnScanCompletedListener() {
                    @Override
                    public void onScanCompleted(String path, Uri uri) {
                    }
                });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private String getCurrentDateAndTime() {
        Calendar c = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-­ss");
        return df.format(c.getTime());
    }

    private void UnableToSave() {
        Toast.makeText(TheThis, "¡No se ha podido guardar la imagen!", Toast.LENGTH_SHORT).show();
    }

    private void AbleToSave() {
        Toast.makeText(TheThis, "Imagen guardada en la galería.", Toast.LENGTH_SHORT).show();
    }
}
