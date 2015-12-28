package arashincleric.com.justdoit;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.main_layout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer == null) {
                    int random = r.nextInt(13); //Get first random
                    while(current == random){ //If same as last get another
                        random = r.nextInt(13);
                    }
                    current = random; //set new selection;

                    mediaPlayer = MediaPlayer.create(v.getContext(), audioArray[random]);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                            releaseMediaPlayer();
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
}
