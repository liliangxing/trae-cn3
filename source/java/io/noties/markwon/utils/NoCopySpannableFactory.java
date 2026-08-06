package io.noties.markwon.utils;

import android.text.Spannable;
import android.text.SpannableString;

/* loaded from: classes3.dex */
public class NoCopySpannableFactory extends Spannable.Factory {
    public static NoCopySpannableFactory getInstance() {
        return Holder.INSTANCE;
    }

    @Override // android.text.Spannable.Factory
    public Spannable newSpannable(CharSequence charSequence) {
        return charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
    }

    /* loaded from: classes3.dex */
    static class Holder {
        private static final NoCopySpannableFactory INSTANCE = new NoCopySpannableFactory();

        Holder() {
        }
    }
}
