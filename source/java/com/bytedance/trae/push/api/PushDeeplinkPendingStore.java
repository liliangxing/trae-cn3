package com.bytedance.trae.push.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushDeeplinkPendingStore.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0005J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/push/api/PushDeeplinkPendingStore;", "", "<init>", "()V", "SP_NAME", "", "KEY_PENDING_URI", "KEY_SAVED_AT", "EXPIRE_MS", "", CloudControlInf.SP, "Landroid/content/SharedPreferences;", "getSp", "context", "Landroid/content/Context;", "save", "", "uriString", "consumeIfPresent", "Landroid/net/Uri;", "clear", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PushDeeplinkPendingStore {
    private static final long EXPIRE_MS = 2000;
    public static final PushDeeplinkPendingStore INSTANCE = new PushDeeplinkPendingStore();
    private static final String KEY_PENDING_URI = "pending_uri";
    private static final String KEY_SAVED_AT = "saved_at";
    private static final String SP_NAME = "push_deeplink_pending";
    private static volatile SharedPreferences sp;

    private PushDeeplinkPendingStore() {
    }

    private final SharedPreferences getSp(Context context) {
        SharedPreferences sharedPreferences = sp;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = context.getApplicationContext().getSharedPreferences(SP_NAME, 0);
        sp = sharedPreferences2;
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "also(...)");
        return sharedPreferences2;
    }

    public final void save(Context context, String uriString) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uriString, "uriString");
        getSp(context).edit().putString(KEY_PENDING_URI, uriString).putLong(KEY_SAVED_AT, System.currentTimeMillis()).apply();
    }

    public final Uri consumeIfPresent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sp2 = getSp(context);
        String string = sp2.getString(KEY_PENDING_URI, null);
        if (string == null) {
            return null;
        }
        long j = sp2.getLong(KEY_SAVED_AT, 0L);
        sp2.edit().remove(KEY_PENDING_URI).remove(KEY_SAVED_AT).apply();
        if (System.currentTimeMillis() - j > 2000) {
            return null;
        }
        try {
            return Uri.parse(string);
        } catch (Exception unused) {
            return null;
        }
    }

    public final void clear(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        getSp(context).edit().remove(KEY_PENDING_URI).remove(KEY_SAVED_AT).apply();
    }
}
