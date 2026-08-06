package com.bytedance.lynx.service.image.decoder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
class GifMetadataMovieDecoder implements GifMetadataDecoder {
    private static final int FRAME_TIME_AT_60_FPS = 17;
    private final List<Integer> mFrameDurations = new ArrayList();
    private final Movie mMovie;

    @Override // com.bytedance.lynx.service.image.decoder.GifMetadataDecoder
    public int getLoopCount() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifMetadataMovieDecoder(Movie movie) {
        this.mMovie = movie;
    }

    @Override // com.bytedance.lynx.service.image.decoder.GifMetadataDecoder
    public void decode() {
        determineFrameDurations();
    }

    @Override // com.bytedance.lynx.service.image.decoder.GifMetadataDecoder
    public int getFrameCount() {
        return this.mFrameDurations.size();
    }

    @Override // com.bytedance.lynx.service.image.decoder.GifMetadataDecoder
    public AnimatedDrawableFrameInfo.DisposalMethod getFrameDisposal(int i) {
        return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
    }

    @Override // com.bytedance.lynx.service.image.decoder.GifMetadataDecoder
    public int getFrameDurationMs(int i) {
        return this.mFrameDurations.get(i).intValue();
    }

    private void determineFrameDurations() {
        Canvas canvas = new Canvas(Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888));
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < this.mMovie.duration(); i2 += 17) {
            if (this.mMovie.setTime(i2) || i2 == 0) {
                this.mMovie.draw(canvas, 0.0f, 0.0f);
                arrayList.add(Integer.valueOf(i2));
            }
        }
        int size = arrayList.size() - 1;
        while (i < size) {
            int i3 = i + 1;
            this.mFrameDurations.add(Integer.valueOf(((Integer) arrayList.get(i3)).intValue() - ((Integer) arrayList.get(i)).intValue()));
            i = i3;
        }
        this.mFrameDurations.add(Integer.valueOf(this.mMovie.duration() - ((Integer) arrayList.get(arrayList.size() - 1)).intValue()));
    }
}
