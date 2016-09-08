package br.com.bemexico;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Detail detail = recoveryDetails();
        displayDetails(detail);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharing(detail);
            }
        });

        final NestedScrollView scrollView = (NestedScrollView) findViewById(R.id.scroll);
        scrollView.postDelayed(new Runnable() {
            @Override
            public void run() {
                scrollView.smoothScrollTo(0, 0);
            }
        }, 200);
    }

    private void sharing(Detail detail) {
        if(detail == null) return;
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, String.format("Come to Mexico in Yazigi. Have you heard of \"%s\"?", detail.getTitle()));
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.send_to)));
    }

    private void displayDetails(final Detail detail) {
        if(detail == null) return;
        // Title
        setTitle(detail.getTitle());
        // Image
        ImageView imageView = (ImageView) findViewById(R.id.image);
        //imageView.setBackgroundResource(detail.getImage());
        Picasso.with(this).load(detail.getImage()).into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //openInGallery(detail.getTitle(), detail.getImage());
            }
        });

        // Titles
        TextView titleList1View = (TextView) findViewById(R.id.title_list_1);
        TextView titleList2View = (TextView) findViewById(R.id.title_list_2);
        // Extra
        TextView extraView = (TextView) findViewById(R.id.extra);
        extraView.setText(detail.getExtra());
        // List 1
        if(detail.hasList1()){
            RecyclerView mainView = (RecyclerView) findViewById(R.id.main);
            mainView.setLayoutManager(new LinearLayoutManager(this));
            mainView.setAdapter(new ListAdapter(detail.getList1()));
            titleList1View.setText(detail.getTitleList1());
        }else{
            titleList1View.setVisibility(View.GONE);
        }
        // List 2
        if(detail.hasList2()){
            RecyclerView generallyView = (RecyclerView) findViewById(R.id.generally);
            generallyView.setLayoutManager(new LinearLayoutManager(this));
            generallyView.setAdapter(new ListAdapter(detail.getList2()));
            titleList2View.setText(detail.getTitleList2());
        }else{
            titleList2View.setVisibility(View.GONE);
        }
    }

    private Detail recoveryDetails() {
        int color = getIntent().getIntExtra("type", 0);
        return Pool.get(color);
    }

    public void openInGallery(String name, int imageId) {
        Intent intent = new Intent(this, ImageActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("image", imageId);
        startActivity(intent);
    }
}
