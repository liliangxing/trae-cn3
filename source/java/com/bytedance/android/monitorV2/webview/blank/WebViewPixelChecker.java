package com.bytedance.android.monitorV2.webview.blank;

import android.graphics.Bitmap;
import android.util.Log;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WebViewPixelChecker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/blank/WebViewPixelChecker;", "", "mOriginPix", "", "(I)V", "doDetect", "", "bitmap", "Landroid/graphics/Bitmap;", "setOriginPix", "", "originPix", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class WebViewPixelChecker {
    private static final int DEFAULT_ORIGIN_PIX = 0;
    private static final String TAG = "WebViewPixelChecker";
    private int mOriginPix;

    public WebViewPixelChecker() {
        this(0, 1, null);
    }

    public WebViewPixelChecker(int i) {
        this.mOriginPix = i;
    }

    public /* synthetic */ WebViewPixelChecker(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public final void setOriginPix(int originPix) {
        this.mOriginPix = originPix;
    }

    public final boolean doDetect(Bitmap bitmap) {
        boolean z;
        if (bitmap == null) {
            return true;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            return false;
        }
        int i = this.mOriginPix;
        if (i == 0) {
            i = bitmap.getPixel(0, 0);
        }
        int i2 = i;
        int[] iArr = new int[width];
        Arrays.fill(iArr, i2);
        int[] iArr2 = new int[width];
        int i3 = 0;
        while (true) {
            if (i3 >= height) {
                z = true;
                break;
            }
            int i4 = i3;
            int[] iArr3 = iArr2;
            bitmap.getPixels(iArr2, 0, width, 0, i3, width, 1);
            if (!Arrays.equals(iArr, iArr3)) {
                z = false;
                break;
            }
            i3 = i4 + 1;
            iArr2 = iArr3;
        }
        if (z) {
            Log.i(TAG, "PixBlankDetector detect white screen , color : " + Integer.toHexString(i2));
        }
        return z;
    }
}
