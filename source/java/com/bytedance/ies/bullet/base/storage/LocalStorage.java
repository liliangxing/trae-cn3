package com.bytedance.ies.bullet.base.storage;

import android.app.Application;
import android.content.SharedPreferences;
import com.bytedance.ies.bullet.core.BulletEnv;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalStorage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/base/storage/LocalStorage;", "", "()V", "LOCAL_STORAGE_NAME", "", "VERSION_NAME", "storage", "Landroid/content/SharedPreferences;", "getStorage", "()Landroid/content/SharedPreferences;", "storage$delegate", "Lkotlin/Lazy;", "read", "key", "validate", "", "write", "value", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LocalStorage {
    private static final String LOCAL_STORAGE_NAME = "annie-x-storage";
    private static final String VERSION_NAME = "version_name";
    public static final LocalStorage INSTANCE = new LocalStorage();

    /* renamed from: storage$delegate, reason: from kotlin metadata */
    private static final Lazy storage = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: com.bytedance.ies.bullet.base.storage.LocalStorage$storage$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SharedPreferences m488invoke() {
            Application application = BulletEnv.Companion.getInstance().getApplication();
            if (application != null) {
                return application.getSharedPreferences("annie-x-storage", 0);
            }
            return null;
        }
    });

    private LocalStorage() {
    }

    private final SharedPreferences getStorage() {
        return (SharedPreferences) storage.getValue();
    }

    public final void validate() {
        SharedPreferences storage2;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor clear;
        SharedPreferences.Editor putString;
        SharedPreferences storage3 = getStorage();
        if (Intrinsics.areEqual("9.0.0", storage3 != null ? storage3.getString(VERSION_NAME, null) : null) || (storage2 = getStorage()) == null || (edit = storage2.edit()) == null || (clear = edit.clear()) == null || (putString = clear.putString(VERSION_NAME, "9.0.0")) == null) {
            return;
        }
        putString.apply();
    }

    public final void write(String key, String value) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences storage2 = getStorage();
        if (storage2 == null || (edit = storage2.edit()) == null || (putString = edit.putString(key, value)) == null) {
            return;
        }
        putString.apply();
    }

    public final String read(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences storage2 = getStorage();
        if (storage2 != null) {
            return storage2.getString(key, null);
        }
        return null;
    }
}
