/*
 * The MIT License (MIT)
 * Copyright © 2016 Steve Guidetti
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the “Software”), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.ultramegasoft.radarchart.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.ultramegasoft.radarchart.RadarEditWidget;
import com.ultramegasoft.radarchart.RadarHolder;
import com.ultramegasoft.radarchart.RadarView;

import java.util.ArrayList;

/**
 * Shows an example radar chart with an edit button that enables interactive mode and shows the
 * edit
 * widget.
 *
 * @author Steve Guidetti
 */
public class MainActivity extends Activity {

    /**
     * The RadarView
     */
    private RadarView mRadarView;

    /**
     * The RadarEditWidget
     */
    private RadarEditWidget mEditWidget;

    /**
     * The animation to use when showing the RadarEditWidget
     */
    private Animation mEditInAnimation;

    /**
     * The animation to use when hiding the RadarEditWidget
     */
    private Animation mEditOutAnimation;

    /**
     * The data for the RadarView
     */
    @NonNull
    private ArrayList<RadarHolder> mData = new ArrayList<RadarHolder>() {
        {
            add(new RadarHolder("Body", 3));
            add(new RadarHolder("Charcoal", 4));
            add(new RadarHolder("Oak", 4));
            add(new RadarHolder("Leather", 4));
            add(new RadarHolder("Spice", 2));
            add(new RadarHolder("Alcohol", 3));
            add(new RadarHolder("Astringent", 3));
            add(new RadarHolder("Linger", 4));
            add(new RadarHolder("Sweet", 2));
            add(new RadarHolder("Maple", 2));
            add(new RadarHolder("Fruit", 3));
            add(new RadarHolder("Vanilla", 2));
            add(new RadarHolder("Smoke", 1));
            add(new RadarHolder("Peat", 0));
            add(new RadarHolder("Nut", 1));
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the views in the layout.
        mRadarView = findViewById(R.id.radar);
        mEditWidget = findViewById(R.id.edit_widget);

        // Set the data for the RadarView to display.
        mRadarView.setData(mData);

        // Set the target RadarView for the RadarEditWidget to control.
        mEditWidget.setTarget(mRadarView);

        // Set the callbacks for the RadarEditWidget buttons.
        mEditWidget.setOnButtonClickListener(new RadarEditWidget.OnButtonClickListener() {
            @Override
            public void onSave() {
                mData = mRadarView.getData();
                setEditMode(false);
            }

            @Override
            public void onCancel() {
                mRadarView.setData(mData);
                setEditMode(false);
            }
        });

        // Set the listener for the edit button.
        findViewById(R.id.button_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEditMode(true);
            }
        });

        // Load the animations.
        mEditInAnimation = AnimationUtils.loadAnimation(this, R.anim.flavor_edit_in);
        mEditOutAnimation = AnimationUtils.loadAnimation(this, R.anim.flavor_edit_out);
    }

    /**
     * Enable or disable interactive mode.
     *
     * @param editMode Whether to enable interactive mode
     */
    private void setEditMode(boolean editMode) {
        if(editMode == mRadarView.isInteractive()) {
            return;
        }

        if(editMode) {
            // Enable interactive mode.
            mRadarView.setInteractive(true);

            // Show the RadarEditWidget.
            mEditWidget.startAnimation(mEditInAnimation);
            mEditWidget.setVisibility(View.VISIBLE);
        } else {
            // Disable interactive mode.
            mRadarView.setInteractive(false);

            // Hide the RadarEditWidget.
            mEditWidget.startAnimation(mEditOutAnimation);
            mEditWidget.setVisibility(View.GONE);
        }
    }
}
