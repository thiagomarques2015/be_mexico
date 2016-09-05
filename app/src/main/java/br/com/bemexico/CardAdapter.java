package br.com.bemexico;

import android.support.v7.widget.CardView;

/**
 * Created by Thiago on 04/09/2016.
 */
public interface CardAdapter {
    int MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    CardView getCardViewAt(int position);

    int getCount();
}
