package com.lynx.tasm.fontface;

import android.graphics.Typeface;
import com.lynx.tasm.base.LLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class StyledTypeface {
    private static final String TAG = "StyledTypeface";
    private Typeface mOriginTypeface;
    private Typeface[] mStyledFontFace;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StyledTypeface(Typeface typeface) {
        Typeface[] typefaceArr = new Typeface[4];
        this.mStyledFontFace = typefaceArr;
        this.mOriginTypeface = typeface;
        typefaceArr[0] = typeface;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Typeface getStyledTypeFace(int i) {
        if (i < 0 || i > 3) {
            i = 0;
        }
        Typeface[] typefaceArr = this.mStyledFontFace;
        if (typefaceArr[i] == null) {
            try {
                typefaceArr[i] = Typeface.create(this.mOriginTypeface, i);
            } catch (ArrayIndexOutOfBoundsException e) {
                LLog.e(TAG, "create typeface failed, style: " + i + ", origin typeface: " + this.mOriginTypeface + ", Typeface.create function is not thread safe lower than Android 9, exception: " + e);
            }
        }
        return this.mStyledFontFace[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean checkTypefaceHasCreated(int i) {
        return this.mStyledFontFace[i] != null;
    }
}
