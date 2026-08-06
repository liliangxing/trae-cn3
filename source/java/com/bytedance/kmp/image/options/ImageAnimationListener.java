package com.bytedance.kmp.image.options;

import kotlin.Metadata;

/* compiled from: ImageAnimationListener.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/kmp/image/options/ImageAnimationListener;", "", "onAnimateImageLoad", "", "onImageAnimateEnd", "onImageAnimateStart", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ImageAnimationListener {

    /* compiled from: ImageAnimationListener.kt */
    @Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void onAnimateImageLoad(ImageAnimationListener imageAnimationListener) {
        }

        public static void onImageAnimateEnd(ImageAnimationListener imageAnimationListener) {
        }

        public static void onImageAnimateStart(ImageAnimationListener imageAnimationListener) {
        }
    }

    void onAnimateImageLoad();

    void onImageAnimateEnd();

    void onImageAnimateStart();
}
