package com.lynx.canvas;

import android.graphics.Bitmap;

/* loaded from: classes6.dex */
public abstract class KryptonLoaderService extends KryptonService {

    /* loaded from: classes6.dex */
    public interface DataResolver {
        void reject(String str);

        void resolve(byte[] bArr, int i, int i2);
    }

    /* loaded from: classes6.dex */
    public interface ImageResolver {
        void reject(String str);

        void resolve(Bitmap bitmap);
    }

    /* loaded from: classes6.dex */
    public interface StreamDelegate {
        void onData(byte[] bArr, int i, int i2);

        void onEnd();

        void onError(String str);

        void onStart(int i);
    }

    public byte[] loadUrlSync(String str) {
        return null;
    }

    public abstract void loadUrlWithDataResolver(String str, DataResolver dataResolver);

    public abstract void loadUrlWithImageResolver(String str, ImageResolver imageResolver);

    public abstract String redirectUrl(String str);

    /* loaded from: classes6.dex */
    public static final class ImageLoadOptions {
        public final boolean decodeImageInJs;
        public final boolean usingBuiltinImageDecoder;

        public ImageLoadOptions(boolean z, boolean z2) {
            this.decodeImageInJs = z;
            this.usingBuiltinImageDecoder = z2;
        }

        public static ImageLoadOptions defaults() {
            return new ImageLoadOptions(false, false);
        }
    }

    public void loadImageWithOptions(String str, ImageLoadOptions imageLoadOptions, ImageResolver imageResolver) {
        throw new UnsupportedOperationException();
    }

    public void loadUrlWithStreamDelegate(String str, StreamDelegate streamDelegate) {
        throw new UnsupportedOperationException();
    }
}
