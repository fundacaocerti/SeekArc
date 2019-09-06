/*******************************************************************************
 * Copyright (c) 2019 Fundação CERTI
 * All rights reserved.
 *******************************************************************************/

package com.triggertrap.sample;

import android.os.Bundle;
import android.widget.CompoundButton;

/**
 * 
 * ColorActivity.java
 * @author Leonardo Gregório de Almeida
 * 
 */
public class ColorActivity extends SimpleActivity {

	@Override
	protected int getLayoutFile() {
		return R.layout.holo_sample;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mSeekArc.setArcWidth(50);
		mArcWidth.setMax(mSeekArc.getArcWidth());
		mArcWidth.setProgress(mArcWidth.getMax());

		mSeekArc.setArcGradient(getResources().getIntArray(R.array.arc_gradient_colors));
		mSeekArc.setProgressGradient(getResources().getIntArray(R.array.progress_gradient_colors));

		mEnabled.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mSeekArc.setEnabled(isChecked);
				mSeekArc.invalidate();

				if (mChangeColor.isChecked()) {
					if(isChecked) {
						mSeekArc.setArcGradient(getResources().getIntArray(R.array.arc_gradient_colors));
					} else {
						mSeekArc.setArcColor(getResources().getColor(R.color.progress_gray));
						//mSeekArc.setArcGradient(getResources().getIntArray(R.array.progress_gradient_colors));
					}
				}
			}
		});
	}
	
}
