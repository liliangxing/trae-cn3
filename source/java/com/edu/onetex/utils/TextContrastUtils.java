package com.edu.onetex.utils;

import android.content.Context;
import android.provider.Settings;
import kotlin.Metadata;

/* compiled from: TextContrastUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/edu/onetex/utils/TextContrastUtils;", "", "()V", "isTextContrastMode", "", "context", "Landroid/content/Context;", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class TextContrastUtils {
    public static final TextContrastUtils INSTANCE = new TextContrastUtils();

    private TextContrastUtils() {
    }

    public final boolean isTextContrastMode(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "high_text_contrast_enabled", 0) == 1;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
