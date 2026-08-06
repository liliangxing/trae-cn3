package com.bytedance.webx.blankdetect;

import android.graphics.Bitmap;
import android.util.Log;
import java.util.Arrays;

/* loaded from: classes6.dex */
public class PixBlankDetector implements IBlankDetector {
    private static final int DEFAULT_ORIGIN_PIX = 0;
    private static final String TAG = "PixBlankDetector";
    private int mOriginPix;

    public PixBlankDetector() {
        this(0);
    }

    public PixBlankDetector(int i) {
        this.mOriginPix = i;
    }

    public void setOriginPix(int i) {
        this.mOriginPix = i;
    }

    @Override // com.bytedance.webx.blankdetect.IBlankDetector
    public boolean doDetect(Bitmap bitmap) {
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
