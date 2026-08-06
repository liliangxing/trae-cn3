package com.bytedance.ies.uikit.rtl;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AutoRTLTextView extends AppCompatTextView {
    public AutoRTLTextView(Context context) {
        this(context, null);
    }

    public AutoRTLTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public AutoRTLTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        Drawable background = getBackground();
        Drawable[] compoundDrawables = getCompoundDrawables();
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        if (background != null) {
            background.setAutoMirrored(true);
        }
        for (Drawable drawable : compoundDrawables) {
            if (drawable != null) {
                drawable.setAutoMirrored(true);
            }
        }
        for (Drawable drawable2 : compoundDrawablesRelative) {
            if (drawable2 != null) {
                drawable2.setAutoMirrored(true);
            }
        }
    }
}
