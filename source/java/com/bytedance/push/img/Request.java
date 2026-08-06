package com.bytedance.push.img;

import android.graphics.Bitmap;
import android.net.Uri;

/* loaded from: classes4.dex */
public class Request {
    public final Bitmap.Config config;
    public final int targetHeight;
    public final int targetWidth;
    public final Uri uri;

    public Request(Uri uri, int i, int i2, Bitmap.Config config) {
        this.uri = uri;
        this.targetWidth = i;
        this.targetHeight = i2;
        this.config = config;
    }

    public boolean hasSize() {
        return this.targetWidth != 0;
    }
}
