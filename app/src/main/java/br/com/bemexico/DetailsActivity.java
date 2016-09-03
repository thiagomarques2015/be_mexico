package br.com.bemexico;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Detail detail = recoveryDetails();
        displayDetails(detail);
    }

    private void displayDetails(Detail detail) {
        if(detail == null) return;
        // Title
        setTitle(detail.getTitle());
        // Image
        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setBackgroundResource(detail.getImage());
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
        }else{
            titleList1View.setVisibility(View.GONE);
        }
        // List 2
        if(detail.hasList2()){
            RecyclerView generallyView = (RecyclerView) findViewById(R.id.generally);
            generallyView.setLayoutManager(new LinearLayoutManager(this));
            generallyView.setAdapter(new ListAdapter(detail.getList2()));
        }else{
            titleList2View.setVisibility(View.GONE);
        }
    }

    private Detail recoveryDetails() {
        int color = getIntent().getIntExtra("color", 0);
        return Pool.get(color);
    }

}
