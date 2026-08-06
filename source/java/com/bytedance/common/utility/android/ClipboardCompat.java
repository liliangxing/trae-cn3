package com.bytedance.common.utility.android;

import android.content.ClipData;
import android.content.Context;
import android.text.ClipboardManager;

/* loaded from: classes3.dex */
public class ClipboardCompat {
    private static final ClipboardImpl IMPL = new HoneycombClipboardImpl();

    /* loaded from: classes3.dex */
    interface ClipboardImpl {
        void setText(Context context, CharSequence charSequence, CharSequence charSequence2);
    }

    /* loaded from: classes3.dex */
    static class BaseClipboardImpl implements ClipboardImpl {
        BaseClipboardImpl() {
        }

        @Override // com.bytedance.common.utility.android.ClipboardCompat.ClipboardImpl
        public void setText(Context context, CharSequence charSequence, CharSequence charSequence2) {
            ((ClipboardManager) context.getSystemService("clipboard")).setText(charSequence2);
        }
    }

    /* loaded from: classes3.dex */
    static class HoneycombClipboardImpl implements ClipboardImpl {
        HoneycombClipboardImpl() {
        }

        @Override // com.bytedance.common.utility.android.ClipboardCompat.ClipboardImpl
        public void setText(Context context, CharSequence charSequence, CharSequence charSequence2) {
            ((android.content.ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(charSequence, charSequence2));
        }
    }

    public static void setText(Context context, CharSequence charSequence, CharSequence charSequence2) {
        if (context != null && charSequence != null && charSequence2 != null) {
            try {
                IMPL.setText(context, charSequence, charSequence2);
            } catch (Throwable unused) {
            }
        }
    }
}
