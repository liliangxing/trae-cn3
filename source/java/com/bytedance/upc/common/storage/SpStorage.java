package com.bytedance.upc.common.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.bytedance.upc.BuildConfig;
import com.bytedance.upc.common.ICommonBusinessService;
import com.bytedance.upc.common.log.LogUtils;
import com.lynx.tasm.gesture.handler.GestureConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpStorage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001'B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0004J'\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010!J\"\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0004J\u0018\u0010#\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0002J\u001e\u0010%\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u001eJ\u001e\u0010&\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR#\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0015\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0016\u0010\u0010¨\u0006("}, d2 = {"Lcom/bytedance/upc/common/storage/SpStorage;", "", "()V", "STORAGE_PRIVACY", "", "STORAGE_SETTINGS", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "mContext$delegate", "Lkotlin/Lazy;", "mPrivacySpStorage", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getMPrivacySpStorage", "()Landroid/content/SharedPreferences;", "mPrivacySpStorage$delegate", "mPrivacyUpdateInterceptorList", "", "Lcom/bytedance/upc/common/storage/SpStorage$UpdateInterceptor;", "mSettingsSpStorage", "getMSettingsSpStorage", "mSettingsSpStorage$delegate", "checkInit", "", "clear", "", "type", "getLong", "", "key", "default", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;", "getString", GestureConstants.ON_UPDATE, "value", "setLong", "setString", "UpdateInterceptor", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes6.dex */
public final class SpStorage {
    public static final String STORAGE_PRIVACY = "upc_sdk_privacy";
    public static final String STORAGE_SETTINGS = "upc_sdk_settings";
    public static final SpStorage INSTANCE = new SpStorage();

    /* renamed from: mContext$delegate, reason: from kotlin metadata */
    private static final Lazy mContext = LazyKt.lazy(new Function0<Context>() { // from class: com.bytedance.upc.common.storage.SpStorage$mContext$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Context invoke() {
            return ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getContext();
        }
    });

    /* renamed from: mSettingsSpStorage$delegate, reason: from kotlin metadata */
    private static final Lazy mSettingsSpStorage = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: com.bytedance.upc.common.storage.SpStorage$mSettingsSpStorage$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SharedPreferences invoke() {
            Context mContext2;
            mContext2 = SpStorage.INSTANCE.getMContext();
            return mContext2.getSharedPreferences(SpStorage.STORAGE_SETTINGS, 0);
        }
    });

    /* renamed from: mPrivacySpStorage$delegate, reason: from kotlin metadata */
    private static final Lazy mPrivacySpStorage = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: com.bytedance.upc.common.storage.SpStorage$mPrivacySpStorage$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SharedPreferences invoke() {
            Context mContext2;
            mContext2 = SpStorage.INSTANCE.getMContext();
            return mContext2.getSharedPreferences(SpStorage.STORAGE_PRIVACY, 0);
        }
    });
    private static final List<UpdateInterceptor> mPrivacyUpdateInterceptorList = new ArrayList();

    /* compiled from: SpStorage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/upc/common/storage/SpStorage$UpdateInterceptor;", "", GestureConstants.ON_UPDATE, "", "key", "", "value", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes6.dex */
    public interface UpdateInterceptor {
        boolean onUpdate(String key, String value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getMContext() {
        return (Context) mContext.getValue();
    }

    private final SharedPreferences getMPrivacySpStorage() {
        return (SharedPreferences) mPrivacySpStorage.getValue();
    }

    private final SharedPreferences getMSettingsSpStorage() {
        return (SharedPreferences) mSettingsSpStorage.getValue();
    }

    private SpStorage() {
    }

    public final String getString(String type, String key, String r4) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(key, "key");
        if (!checkInit()) {
            return r4;
        }
        try {
            if (!Intrinsics.areEqual(type, STORAGE_PRIVACY)) {
                return Intrinsics.areEqual(type, STORAGE_SETTINGS) ? getMSettingsSpStorage().getString(key, r4) : r4;
            }
            SharedPreferences mPrivacySpStorage2 = getMPrivacySpStorage();
            if (mPrivacySpStorage2 != null) {
                return mPrivacySpStorage2.getString(key, r4);
            }
            return null;
        } catch (Throwable th) {
            LogUtils.e(Log.getStackTraceString(th));
            return r4;
        }
    }

    public final boolean setString(String type, String key, String value) {
        SharedPreferences mSettingsSpStorage2;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        SharedPreferences.Editor edit2;
        SharedPreferences.Editor putString2;
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        if (!checkInit() || onUpdate(key, value)) {
            return false;
        }
        try {
            if (Intrinsics.areEqual(type, STORAGE_PRIVACY)) {
                SharedPreferences mPrivacySpStorage2 = getMPrivacySpStorage();
                if (mPrivacySpStorage2 == null || (edit2 = mPrivacySpStorage2.edit()) == null || (putString2 = edit2.putString(key, value)) == null) {
                    return false;
                }
                return putString2.commit();
            }
            if (!Intrinsics.areEqual(type, STORAGE_SETTINGS) || (mSettingsSpStorage2 = getMSettingsSpStorage()) == null || (edit = mSettingsSpStorage2.edit()) == null || (putString = edit.putString(key, value)) == null) {
                return false;
            }
            return putString.commit();
        } catch (Throwable th) {
            LogUtils.e(Log.getStackTraceString(th));
            return false;
        }
    }

    public final Long getLong(String type, String key, Long r6) {
        SharedPreferences mSettingsSpStorage2;
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(key, "key");
        if (!checkInit()) {
            return r6;
        }
        try {
            if (Intrinsics.areEqual(type, STORAGE_PRIVACY)) {
                SharedPreferences mPrivacySpStorage2 = getMPrivacySpStorage();
                if (mPrivacySpStorage2 != null) {
                    return Long.valueOf(mPrivacySpStorage2.getLong(key, r6 != null ? r6.longValue() : 0L));
                }
                return null;
            }
            if (!Intrinsics.areEqual(type, STORAGE_SETTINGS) || (mSettingsSpStorage2 = getMSettingsSpStorage()) == null) {
                return r6;
            }
            return Long.valueOf(mSettingsSpStorage2.getLong(key, r6 != null ? r6.longValue() : 0L));
        } catch (Throwable th) {
            LogUtils.e(Log.getStackTraceString(th));
            return r6;
        }
    }

    public final boolean setLong(String type, String key, long value) {
        SharedPreferences mSettingsSpStorage2;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putLong;
        SharedPreferences.Editor edit2;
        SharedPreferences.Editor putLong2;
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(key, "key");
        if (!checkInit()) {
            return false;
        }
        try {
            if (Intrinsics.areEqual(type, STORAGE_PRIVACY)) {
                SharedPreferences mPrivacySpStorage2 = getMPrivacySpStorage();
                if (mPrivacySpStorage2 == null || (edit2 = mPrivacySpStorage2.edit()) == null || (putLong2 = edit2.putLong(key, value)) == null) {
                    return false;
                }
                return putLong2.commit();
            }
            if (!Intrinsics.areEqual(type, STORAGE_SETTINGS) || (mSettingsSpStorage2 = getMSettingsSpStorage()) == null || (edit = mSettingsSpStorage2.edit()) == null || (putLong = edit.putLong(key, value)) == null) {
                return false;
            }
            return putLong.commit();
        } catch (Throwable th) {
            LogUtils.e(Log.getStackTraceString(th));
            return false;
        }
    }

    public final void clear(String type) {
        SharedPreferences mSettingsSpStorage2;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor clear;
        SharedPreferences.Editor edit2;
        SharedPreferences.Editor clear2;
        Intrinsics.checkParameterIsNotNull(type, "type");
        if (Intrinsics.areEqual(type, STORAGE_PRIVACY)) {
            SharedPreferences mPrivacySpStorage2 = getMPrivacySpStorage();
            if (mPrivacySpStorage2 == null || (edit2 = mPrivacySpStorage2.edit()) == null || (clear2 = edit2.clear()) == null) {
                return;
            }
            clear2.commit();
            return;
        }
        if (!Intrinsics.areEqual(type, STORAGE_SETTINGS) || (mSettingsSpStorage2 = getMSettingsSpStorage()) == null || (edit = mSettingsSpStorage2.edit()) == null || (clear = edit.clear()) == null) {
            return;
        }
        clear.commit();
    }

    private final boolean checkInit() {
        if (getMPrivacySpStorage() != null && getMSettingsSpStorage() != null) {
            return true;
        }
        LogUtils.e("sp don't init, please init first !!!");
        return false;
    }

    private final boolean onUpdate(String key, String value) {
        try {
            Iterator<T> it = mPrivacyUpdateInterceptorList.iterator();
            while (it.hasNext()) {
                ((UpdateInterceptor) it.next()).onUpdate(key, value);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
