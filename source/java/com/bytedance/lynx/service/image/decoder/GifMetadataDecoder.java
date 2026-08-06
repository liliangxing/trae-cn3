package com.bytedance.lynx.service.image.decoder;

import android.graphics.Movie;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public interface GifMetadataDecoder {
    void decode() throws IOException;

    int getFrameCount();

    AnimatedDrawableFrameInfo.DisposalMethod getFrameDisposal(int i);

    int getFrameDurationMs(int i);

    int getLoopCount();

    /* loaded from: classes4.dex */
    public static class Factory {
        public static GifMetadataDecoder create(boolean z, Movie movie, InputStream inputStream) throws IOException {
            GifMetadataDecoder gifMetadataMovieDecoder = z ? new GifMetadataMovieDecoder(movie) : new GifMetadataStreamDecoder(inputStream);
            gifMetadataMovieDecoder.decode();
            return gifMetadataMovieDecoder;
        }
    }
}
