package br.com.bemexico;

import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thiago on 04/09/2016.
 */
public class CardPagerAdapter extends PagerAdapter implements CardAdapter {
    private List<CardView> mViews;
    private List<Detail> mData;
    private float mBaseElevation;
    private ClickListener listener;

    public CardPagerAdapter(ArrayList<Detail> mData) {

        this.mData = mData;
        mViews = new ArrayList<>();

        for (int i = 0; i < mData.size(); i++) {
            mViews.add(null);
        }
    }

    public void setOnItemClick(ClickListener listener) {
        this.listener = listener;
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.adapter, container, false);
        container.addView(view);
        CardView cardView = (CardView) view.findViewById(R.id.cardView);
        TextView titleView = (TextView) view.findViewById(R.id.title);
        TextView descriptionView = (TextView) view.findViewById(R.id.description);
        ImageView iconView = (ImageView) view.findViewById(R.id.icon);
        Button enterView = (Button) view.findViewById(R.id.enter);

        Detail detail = mData.get(position);
        // Set Title
        titleView.setText(detail.getTitle());
        // Set Description
        descriptionView.setText(detail.getDescription());
        // Set icon
        iconView.setImageResource(detail.getIcon());

        enterView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null)
                    listener.onItemClick(view, position);
            }
        });

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    public interface ClickListener{
        void onItemClick(View view, int position);
    }
}
