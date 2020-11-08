package com.wallpaper.nier;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SugerenciasActivity extends Activity {

    TextView textView;
    EditText tMe;
    Button btEn;
    String eM,tAs, pas, tMa;

    // Hacer bien esta mmda por que no c como se hace

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencias);
        textView = findViewById(R.id.boton_atras2);

        tMa = "futurefix.19@gmail.com";
        tAs = "Sugerencias wallpapers";
        tMe = findViewById(R.id.t_Men);
        tMe.setText(null);
        btEn =findViewById(R.id.b_en);
        // Correo Elecronico
        eM = "aheilyx@gmail.com";
        // Contraseña
        pas = "Disenos2020";

        btEn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tMe.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Debe escribir algo.", Toast.LENGTH_SHORT).show();
                }
                else {
                    correo();
                }
            }
        });

        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SugerenciasActivity.this, AyudaActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @SuppressLint("StaticFieldLeak")
    private class SendMail extends AsyncTask<Message, String, String> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute(){
            super.onPreExecute();

            progressDialog = ProgressDialog.show(SugerenciasActivity.this
                    ,"Porfavor Espere", "Enviando Mail...", true, false);
        }
        @Override
        protected String doInBackground(Message... messages) {
            try {
                Transport.send(messages[0]);
                return  "Enviado";
            } catch (MessagingException e) {
                e.printStackTrace();

                return "Error";
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            progressDialog.dismiss();

            if (s.equals(("Enviado"))){

                AlertDialog.Builder builder = new AlertDialog.Builder(SugerenciasActivity.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color='#506324'>Success</font>"));
                builder.setMessage("Correo enviado ");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        tMe.setText("");
                    }
                });

                builder.show();
            }else {
                Toast.makeText(getApplicationContext()
                        ,"Algo salio mal!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void correo(){
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.googlemail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");


        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(eM, pas);
            }
        });
        try {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(eM));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(tMa.trim()));
            message.setSubject(tAs.trim());

            message.setText(tMe.getText().toString().trim());

            new SendMail().execute(message);


        } catch (MessagingException e) {

            e.printStackTrace();
        }
    }
}
