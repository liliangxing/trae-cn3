package com.bytedance.trae.home.privacy;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrivacyCache.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/home/privacy/PrivacyCache;", "", "<init>", "()V", "PREF_NAME", "", "KEY_SHOW_TIME", "KEY_CLICK_ACCEPT_TIME", "KEY_CLICK_CANCEL_TIME", "getPrefs", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "savePrivacyWindowShow", "", "savePrivacyWindowClick", "agreed", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PrivacyCache {
    public static final int $stable = 0;
    public static final PrivacyCache INSTANCE = new PrivacyCache();
    private static final String KEY_CLICK_ACCEPT_TIME = "privacy_window_click_accept_time";
    private static final String KEY_CLICK_CANCEL_TIME = "privacy_window_click_cancel_time";
    private static final String KEY_SHOW_TIME = "privacy_window_show_time";
    private static final String PREF_NAME = "privacy_cache";

    private PrivacyCache() {
    }

    private final SharedPreferences getPrefs(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, 4);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences;
    }

    public final void savePrivacyWindowShow(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences prefs = getPrefs(context);
        String string = prefs.getString(KEY_SHOW_TIME, "");
        String str = string != null ? string : "";
        String valueOf = String.valueOf(System.currentTimeMillis());
        if (!(str.length() == 0)) {
            valueOf = str + ',' + valueOf;
        }
        prefs.edit().putString(KEY_SHOW_TIME, valueOf).apply();
    }

    public final void savePrivacyWindowClick(Context context, boolean agreed) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences prefs = getPrefs(context);
        String str = agreed ? KEY_CLICK_ACCEPT_TIME : KEY_CLICK_CANCEL_TIME;
        String string = prefs.getString(str, "");
        String str2 = string != null ? string : "";
        String valueOf = String.valueOf(System.currentTimeMillis());
        if (!(str2.length() == 0)) {
            valueOf = str2 + ',' + valueOf;
        }
        prefs.edit().putString(str, valueOf).apply();
    }
}
