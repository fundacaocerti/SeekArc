/*******************************************************************************
 * Copyright (c) 2019 Fundação CERTI
 * All rights reserved.
 *******************************************************************************/

package com.triggertrap.seekarc;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;

/**
 *
 * ColorActivity.java
 * @author Leonardo Gregório de Almeida
 *
 */
public class GradientStorage {

    private Paint paint;
    private int[] colors;

    public GradientStorage(Paint paint, int... colors) {
        this.paint = paint;
        this.colors = colors;
    }

    private float[] calcPositions(float sweepAngle) {
        float[] positions = new float[this.colors.length];
        float step = (sweepAngle / 360) / (positions.length -1);

        for (int i = 0; i < positions.length; i++) {
            positions[i] = step * i;
        }

        return positions;
    }

    public void setGradient(float centerX, float centerY, float rotate, float sweepAngle) {
        Shader shader = new SweepGradient(centerX, centerY, this.colors, this.calcPositions(sweepAngle));

        Matrix gradientMatrix = new Matrix();
        gradientMatrix.preRotate(rotate, centerX, centerY);

        shader.setLocalMatrix(gradientMatrix);

        this.paint.setShader(shader);
    }
}
