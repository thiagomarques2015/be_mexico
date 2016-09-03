package br.com.bemexico;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nguyenhoanglam.imagepicker.activity.ImagePicker;
import com.nguyenhoanglam.imagepicker.activity.ImagePickerActivity;
import com.nguyenhoanglam.imagepicker.model.Image;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_PICKER = 1;
    private static final int CAMERA_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView buttonView = (ImageView) findViewById(R.id.picture);
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {

                        requestPermissions(new String[]{Manifest.permission.CAMERA},
                                CAMERA_PERMISSION);
                    }else{
                        selectImage();
                    }
                }else{
                    selectImage();
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    private void selectImage() {
        ImagePicker.create(MainActivity.this)
                .single() // single mode
                .limit(10) // max images can be selected
                .showCamera(true) // show camera or not (true by default)
                .start(REQUEST_CODE_PICKER); // start image picker activity with request code
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Now user should be able to use camera
                selectImage();
            }
            else {
                // Your app will not have this permission. Turn off all functions
                // that require this permission or it will force close like your
                // original question
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICKER && resultCode == RESULT_OK && data != null) {
            ArrayList<Image> images = data.getParcelableArrayListExtra(ImagePickerActivity.INTENT_EXTRA_SELECTED_IMAGES);
            Log.d("Image", "Imagem recebida");
            // do your logic ....

            for(Image image : images){
                Bitmap bitmap = BitmapFactory.decodeFile(image.getPath());
                // Asynchronous
                Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                    public void onGenerated(Palette p) {
                        // Use generated instance
                        int color = 0x000000;
                        int vibrant = p.getVibrantColor(color);

                        TextView colorV = (TextView) findViewById(R.id.color);
                        colorV.setBackgroundColor(vibrant);

                        Log.d("Color", vibrant + "");

                        delegateAction(vibrant);
                    }
                });
            }

        }
    }

    private void delegateAction(int vibrant) {
        int color = 0;

        int r = (vibrant >> 16) & 0xFF;
        int g = (vibrant >> 8) & 0xFF;
        int b = (vibrant >> 0) & 0xFF;

        Log.d("RGB", r + "," + g + "," + b);

//        switch (vibrant){
//            case -13618952 : // C1
//                Log.d("Color", "Circle blue");
//                color = Pool.Color.BURRITO;
//                break;
//            case -485376 : // C2
//                Log.d("Color", "Circle orange");
//                break;
//            case -14116792 : // C3
//                Log.d("Color", "Circle green");
//                color = Pool.Color.POBLANO;
//                break;
//        }


        if(r == 0 && g < 255 && b == 0){ // Verde
            color = Pool.Color.POBLANO;
        }else if(r == 0 && g == 0 && b < 255){ // Azul
            color = Pool.Color.BURRITO;
        }

        if(color == 0){
            Toast.makeText(MainActivity.this, R.string.no_foods_with_this_color, Toast.LENGTH_SHORT).show();
            return;
        }
        
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("color", color);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
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
