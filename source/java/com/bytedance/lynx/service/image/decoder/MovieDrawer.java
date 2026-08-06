package com.bytedance.lynx.service.image.decoder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;

/* loaded from: classes4.dex */
public class MovieDrawer {
    private Canvas mCanvas = new Canvas();
    private Movie mMovie;
    private Bitmap mPreviousBitmap;
    private final MovieScaleHolder mScaleHolder;

    public MovieDrawer(Movie movie) {
        this.mMovie = movie;
        this.mScaleHolder = new MovieScaleHolder(movie.width(), movie.height());
    }

    public synchronized void drawFrame(int i, int i2, int i3, Bitmap bitmap) {
        this.mMovie.setTime(i);
        Bitmap bitmap2 = this.mPreviousBitmap;
        if (bitmap2 != null && bitmap2.isRecycled()) {
            this.mPreviousBitmap = null;
        }
        if (this.mPreviousBitmap != bitmap) {
            this.mPreviousBitmap = bitmap;
            this.mCanvas.setBitmap(bitmap);
        }
        this.mScaleHolder.updateViewPort(i2, i3);
        this.mCanvas.save();
        this.mCanvas.scale(this.mScaleHolder.getScale(), this.mScaleHolder.getScale());
        this.mMovie.draw(this.mCanvas, this.mScaleHolder.getLeft(), this.mScaleHolder.getTop());
        this.mCanvas.restore();
    }
}
