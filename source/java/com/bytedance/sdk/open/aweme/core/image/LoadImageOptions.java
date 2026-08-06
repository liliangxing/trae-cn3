package com.bytedance.sdk.open.aweme.core.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import java.io.File;

/* loaded from: classes5.dex */
public class LoadImageOptions {
    public static final int CORNER_ALL = 15;
    public static final int CORNER_BOTTOM_LEFT = 4;
    public static final int CORNER_BOTTOM_RIGHT = 8;
    public static final int CORNER_TOP_LEFT = 1;
    public static final int CORNER_TOP_RIGHT = 2;
    public float bitmapAngle;
    public BitmapLoadCallback bitmapLoadCallBack;
    public Bitmap.Config config = Bitmap.Config.RGB_565;
    public int corners = 15;
    public int drawableResId;
    public int errorResId;
    public File file;
    public boolean isCenterCrop;
    public boolean isCenterInside;
    public boolean isFitXY;
    public Drawable placeholder;
    public int placeholderResId;
    public boolean skipDiskCache;
    public boolean skipMemoryCache;
    public int targetHeight;
    public View targetView;
    public int targetWidth;
    public Uri uri;
    public String url;

    public LoadImageOptions(int i) {
        this.drawableResId = i;
    }

    public LoadImageOptions(Uri uri) {
        this.uri = uri;
    }

    public LoadImageOptions(File file) {
        this.file = file;
    }

    public LoadImageOptions(String str) {
        this.url = str;
    }

    public LoadImageOptions(String str, View view) {
        this.url = str;
        this.targetView = view;
    }

    public LoadImageOptions angle(float f) {
        this.bitmapAngle = f;
        return this;
    }

    public LoadImageOptions bitmapLoadCallback(BitmapLoadCallback bitmapLoadCallback) {
        this.bitmapLoadCallBack = bitmapLoadCallback;
        return this;
    }

    public LoadImageOptions centerCrop() {
        this.isCenterCrop = true;
        return this;
    }

    public LoadImageOptions centerInside() {
        this.isCenterInside = true;
        return this;
    }

    public LoadImageOptions config(Bitmap.Config config) {
        this.config = config;
        return this;
    }

    public LoadImageOptions error(int i) {
        this.errorResId = i;
        return this;
    }

    public LoadImageOptions fitXY() {
        this.isFitXY = true;
        return this;
    }

    public LoadImageOptions into(View view) {
        this.targetView = view;
        return this;
    }

    public LoadImageOptions placeholder(int i) {
        this.placeholderResId = i;
        return this;
    }

    public LoadImageOptions placeholder(Drawable drawable) {
        this.placeholder = drawable;
        return this;
    }

    public LoadImageOptions resize(int i, int i2) {
        this.targetWidth = i;
        this.targetHeight = i2;
        return this;
    }

    public LoadImageOptions skipDiskCache(boolean z) {
        this.skipDiskCache = z;
        return this;
    }

    public LoadImageOptions skipMemoryCache(boolean z) {
        this.skipMemoryCache = z;
        return this;
    }
}
