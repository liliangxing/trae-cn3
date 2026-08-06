package com.bytedance.android.livesdk.pannel.utils;

import android.util.Log;
import com.bytedance.android.livesdk.pannel.R;
import kotlin.Metadata;

/* compiled from: StyleUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u001a\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/pannel/utils/StyleUtils;", "", "()V", "getAppCompatStandardTheme", "", "isLandscape", "", "isPad", "getStandardTheme", "panel_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class StyleUtils {
    public static final StyleUtils INSTANCE = new StyleUtils();

    private StyleUtils() {
    }

    public static /* synthetic */ int getStandardTheme$default(StyleUtils styleUtils, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        return styleUtils.getStandardTheme(z, z2);
    }

    public final int getStandardTheme(boolean isLandscape, boolean isPad) {
        Log.d("StyleUtils", "old theme context is AppCompatActivity");
        if (isPad) {
            return R.style.ttlive_standard_dialog_hd_theme;
        }
        if (isLandscape) {
            return R.style.ttlive_standard_dialog_right_theme;
        }
        return R.style.ttlive_standard_dialog_bottom_theme;
    }

    public static /* synthetic */ int getAppCompatStandardTheme$default(StyleUtils styleUtils, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        return styleUtils.getAppCompatStandardTheme(z, z2);
    }

    public final int getAppCompatStandardTheme(boolean isLandscape, boolean isPad) {
        Log.d("StyleUtils", "new theme context is AppCompatActivity");
        if (isPad) {
            return R.style.ttlive_standard_dialog_hd_theme_appcompat;
        }
        if (isLandscape) {
            return R.style.ttlive_standard_dialog_right_theme_appcompat;
        }
        return R.style.ttlive_standard_dialog_bottom_theme_appcompat;
    }
}
