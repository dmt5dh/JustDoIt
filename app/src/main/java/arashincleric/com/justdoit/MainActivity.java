package arashincleric.com.justdoit;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends Activity {

    MediaPlayer mediaPlayer = null;
    int[] audioArray = {
            R.raw.doit,
            R.raw.doit2,
            R.raw.dontletdreams,
            R.raw.justdoit,
            R.raw.justdoit2,
            R.raw.justdoit3,
            R.raw.justdoit4,
            R.raw.makeyouredreams,
            R.raw.nothingimpossible,
            R.raw.stopgivingup,
            R.raw.yesterday,
            R.raw.yesyoucan,
            R.raw.yourenotgoingtostop
    };
    Random r = new Random();
    int current = -1;

    ImageView image;
    AnimationDrawable animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.main_layout);
        image = (ImageView)findViewById(R.id.imageView);
        image.setImageResource(R.drawable.shia);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer == null) {
                    int random = r.nextInt(13); //Get first random
                    while(current == random){ //If same as last get another
                        random = r.nextInt(13);
                    }
                    current = random; //set new selection;

                    mediaPlayer = MediaPlayer.create(v.getContext(), audioArray[current]);

                    mediaPlayer.start();
                    switch (current){
                        case 0:
                            image.setImageResource(R.drawable.animation0);
                            break;
                        case 1:
                            image.setImageResource(R.drawable.animation1);
                            break;
                        case 2:
                            image.setImageResource(R.drawable.animation2);
                            break;
                        case 3:
                            image.setImageResource(R.drawable.animation3);
                            break;
                        case 4:
                            image.setImageResource(R.drawable.animation4);
                            break;
                        case 5:
                            image.setImageResource(R.drawable.animation5);
                            break;
                        case 6:
                            image.setImageResource(R.drawable.animation6);
                            break;
                        case 7:
                            image.setImageResource(R.drawable.animation7);
                            break;
                        case 8:
                            image.setImageResource(R.drawable.animation8);
                            break;
                        case 9:
                            image.setImageResource(R.drawable.animation9);
                            break;
                        case 10:
                            image.setImageResource(R.drawable.animation10);
                            break;
                        case 11:
                            image.setImageResource(R.drawable.animation11);
                            break;
                        case 12:
                            image.setImageResource(R.drawable.animation12);
                            break;
                    }

                    animation = (AnimationDrawable)image.getDrawable();
                    animation.start();

                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                            releaseMediaPlayer();
                            image.setImageResource(R.drawable.shia);
                        }
                    });
                }
            }
        });
    }

    public void releaseMediaPlayer(){
        mediaPlayer = null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume(){
        super.onResume();

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        if(getActionBar() != null){
            getActionBar().hide();
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        image.setImageResource(R.drawable.shia);
    }
}
