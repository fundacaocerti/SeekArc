/*******************************************************************************
 * Copyright (c) 2019 Fundação CERTI
 * All rights reserved.
 *******************************************************************************/

package com.triggertrap.sample;

import android.os.Bundle;

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
	}
	
}
