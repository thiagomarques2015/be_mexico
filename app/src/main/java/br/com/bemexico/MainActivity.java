package br.com.bemexico;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.nguyenhoanglam.imagepicker.activity.ImagePicker;
import com.nguyenhoanglam.imagepicker.activity.ImagePickerActivity;
import com.nguyenhoanglam.imagepicker.model.Image;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, CardPagerAdapter.ClickListener {

    private static final int REQUEST_CODE_PICKER = 1;
    private static final int CAMERA_PERMISSION = 1;
    private ViewPager mViewPager;
    private Button mButton;
    private CardPagerAdapter mCardAdapter;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private boolean mShowingFragments;
    private ShadowTransformer mCardShadowTransformer;
    private ShadowTransformer mFragmentCardShadowTransformer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        createViewPager();
    }

    private void createViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mButton = (Button) findViewById(R.id.cardTypeBtn);
        ((CheckBox) findViewById(R.id.checkBox)).setOnCheckedChangeListener(this);
        mButton.setOnClickListener(this);

        mCardAdapter = new CardPagerAdapter(Pool.toArrayList());
        mFragmentCardAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(),
                dpToPixels(2, this));

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);
        // Set Scalling enable
        onCheckedChanged(null, true);
        // Enable click
        mCardAdapter.setOnItemClick(this);
    }

    @Override
    public void onClick(View view) {
        if (!mShowingFragments) {
            mButton.setText("Views");
            mViewPager.setAdapter(mFragmentCardAdapter);
            mViewPager.setPageTransformer(false, mFragmentCardShadowTransformer);
        } else {
            mButton.setText("Fragments");
            mViewPager.setAdapter(mCardAdapter);
            mViewPager.setPageTransformer(false, mCardShadowTransformer);
        }

        mShowingFragments = !mShowingFragments;
    }

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        mCardShadowTransformer.enableScaling(b);
        mFragmentCardShadowTransformer.enableScaling(b);
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

                        Log.d("Item", vibrant + "");

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
//                Log.d("Item", "Circle blue");
//                color = Pool.Item.BURRITO;
//                break;
//            case -485376 : // C2
//                Log.d("Item", "Circle orange");
//                break;
//            case -14116792 : // C3
//                Log.d("Item", "Circle green");
//                color = Pool.Item.POBLANO;
//                break;
//        }


        if(r == 0 && g < 255 && b == 0){ // Verde
            color = Pool.Item.POBLANO;
        }else if(r == 0 && g == 0 && b < 255){ // Azul
            color = Pool.Item.BURRITO;
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

    @Override
    public void onItemClick(View view, int position) {
        Detail item = Pool.toArrayList().get(position);
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("type", item.getType());
        startActivity(intent);
    }
}
