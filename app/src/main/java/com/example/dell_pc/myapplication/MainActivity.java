package com.example.dell_pc.myapplication;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView miVideo;VideoView miVideo2;
    int oldCurrentPosition=-1;
    int oldCurrentPosition2=-1;
/*XD*/
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainAct","onResume");
        if(oldCurrentPosition!=-1) {
            miVideo.seekTo(oldCurrentPosition);
            miVideo2.seekTo(oldCurrentPosition2);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainAct","onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainAct","onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        oldCurrentPosition = miVideo.getCurrentPosition();
        Log.d("MainAct","Tiempo: "+miVideo.getCurrentPosition());
        miVideo.getCurrentPosition();
        oldCurrentPosition2 = miVideo2.getCurrentPosition();
        Log.d("MainAct","Tiempo: "+miVideo2.getCurrentPosition());
        miVideo2.getCurrentPosition();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainAct","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainAct","onDestroy");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miVideo = (VideoView) findViewById(R.id.videoView);
        miVideo2 = (VideoView) findViewById(R.id.videoView2);
        /*miVideo.setVideoPath("http://rtyrtyrtyr.mp4");--esto es para extraer directo del internet*/
        String vid = "android.resource://"+getPackageName()+"/"+R.raw.svart;
        miVideo.setVideoURI(Uri.parse(vid));
        String vid2 = "android.resource://"+getPackageName()+"/"+R.raw.zoom;
        miVideo2.setVideoURI(Uri.parse(vid2));
        miVideo.setMediaController(new MediaController( this));
        Button prev = findViewById(R.id.Prev);
        Button next = findViewById(R.id.Next);
        Button play = findViewById(R.id.Play);
        Button stop = findViewById(R.id.Stop);
        Button like = findViewById(R.id.Like);
        Button dislike = findViewById(R.id.Dislike);
        Button share = findViewById(R.id.Share);
        Button download = findViewById(R.id.Download);
        Button save = findViewById(R.id.Save);
        Button play2 = findViewById(R.id.Play2);
        Button stop2 = findViewById(R.id.Stop2);

        final TextView textoNombre = findViewById(R.id.Nombre);
        final TextView textoVistas = findViewById(R.id.Vistas);
        final TextView textoLike = findViewById(R.id.textLike);
        final TextView textoDislike = findViewById(R.id.textDislike);
        final TextView textoShare = findViewById(R.id.textShare);
        final TextView textoDownload = findViewById(R.id.textDownload);
        final TextView textoSave = findViewById(R.id.textSave);

        prev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final VideoView miVideo = (VideoView) findViewById(R.id.videoView);
                String vid = "android.resource://"+getPackageName()+"/"+R.raw.svart;
                miVideo.setVideoURI(Uri.parse(vid));
                miVideo.start();
                miVideo2.pause();
                textoNombre.setText("Svart Bil - Twenty One Two");
                textoVistas.setText("133 K Vistas");
            }
        });
        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                miVideo.start();
                miVideo2.pause();
            }
        });
        stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                miVideo.pause();
            }
        });
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final VideoView miVideo = (VideoView) findViewById(R.id.videoView);
                String vid1 = "android.resource://"+getPackageName()+"/"+R.raw.satellite;
                miVideo.setVideoURI(Uri.parse(vid1));
                miVideo.start();
                miVideo2.pause();
                textoNombre.setText("Starset - Satellite");
                textoVistas.setText("2 M Vistas");
            }
        });
        like.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                textoLike.setText("Likeado");
                Toast.makeText(MainActivity.this ,"Le Gusta el video",Toast.LENGTH_LONG  ).show();
            }
        });
        dislike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                textoDislike.setText("Dislikeado");
                Toast.makeText(MainActivity.this ,"No le Gusta el video",Toast.LENGTH_LONG  ).show();
            }
        });
        share.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                textoShare.setText("Compartido");
                Toast.makeText(MainActivity.this ,"Compartio este video",Toast.LENGTH_LONG  ).show();
            }
        });
        download.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                textoDownload.setText("Descargando");
                Toast.makeText(MainActivity.this ,"Descarga en proceso",Toast.LENGTH_LONG  ).show();
            }
        });
        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                textoSave.setText("Guardado");
                Toast.makeText(MainActivity.this ,"Guardo el video",Toast.LENGTH_LONG  ).show();
            }
        });
        play2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                miVideo2.start();
                miVideo.pause();
            }
        });
        stop2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                miVideo2.pause();
            }
        });

        System.out.println("onCreate()");
        Log.d("MainAct","onCreate");
    }
}