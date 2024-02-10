package ru.da.russianroulette;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.jar.Attributes;

public class MainActivity extends Activity {
    private SoundPool sounds;
    private int sounds_shot;
    private int sounds_misfire;
    private int sounds_drum;
    private ImageView blood_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AudioAttributes attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        sounds = new SoundPool.Builder()
                .setAudioAttributes(attributes)
                .build();
        loadSounds();
        blood_image = findViewById(R.id.imageView2);
    }



    private void loadSounds() {
        sounds_shot = sounds.load(this, R.raw.revolver_shot,1);
        sounds_misfire = sounds.load(this, R.raw.gun_false,1);
        sounds_drum = sounds.load(this, R.raw.revolver_baraban,1);

    }
    public void onShot(View view) {
        sounds.play(sounds_shot, 1.0f, 1.0f, 1, 0, 1);
        blood_image.setVisibility(View.VISIBLE);
    }

    public void onMisfire(View view) {
        sounds.play(sounds_misfire, 1.0f, 1.0f, 1, 0, 1);
        blood_image.setVisibility(View.INVISIBLE);
    }

    public void onDrum(View view) {
        sounds.play(sounds_drum, 1.0f, 1.0f, 1, 0, 1);
        blood_image.setVisibility(View.INVISIBLE);
    }
}