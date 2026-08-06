package com.bytedance.android.live.setting;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.setting.v2.tools.SettingV2Monitor;
import java.lang.reflect.Type;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LiveSettingKey.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\t\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0019\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006B#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bB3\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rB=\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\f¢\u0006\u0002\u0010\u0011B+\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0002\u0010\u0013B3\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0012\u001a\u00028\u0000\u0012\u0006\u0010\u0014\u001a\u00020\f¢\u0006\u0002\u0010\u0015B;\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0017\"\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0018BC\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0012\u001a\u00028\u0000\u0012\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0017\"\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0019BK\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0012\u001a\u00028\u0000\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0017\"\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u001aB!\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n¢\u0006\u0002\u0010\u001bB+\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u001cB;\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0002\u0010\u001dBC\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0012\u001a\u00028\u0000\u0012\u0006\u0010\u0014\u001a\u00020\f¢\u0006\u0002\u0010\u001eB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0002\u0010\u001f¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/setting/LiveSettingKey;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/live/core/setting/SettingKey;", "name", "", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "description", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "clazz", "Ljava/lang/Class;", "isOnlyRemote", "", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Z)V", "type", "Ljava/lang/reflect/Type;", "isSticky", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/reflect/Type;ZZ)V", "debugValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", SettingV2Monitor.STICKY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Z)V", "option", "", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Z[Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/Class;)V", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Z)V", "(Ljava/lang/String;Ljava/lang/reflect/Type;Ljava/lang/Object;)V", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public class LiveSettingKey<T> extends SettingKey<T> {
    public LiveSettingKey(String str, T t) {
        super(str, t);
    }

    public LiveSettingKey(String str, T t, String str2) {
        super(str, t, str2);
    }

    public LiveSettingKey(String str, Class<T> cls, String str2, boolean z) {
        super(str, cls, str2, z);
    }

    public LiveSettingKey(String str, String str2, T t, Type type, boolean z, boolean z2) {
        super(str, str2, t, type, z, z2);
    }

    public LiveSettingKey(String str, String str2, T t, T t2) {
        super(str, str2, t, t2);
    }

    public LiveSettingKey(String str, String str2, T t, T t2, boolean z) {
        super(str, str2, t, t2, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveSettingKey(String str, T t, String str2, String... option) {
        super(str, t, str2, (String[]) Arrays.copyOf(option, option.length));
        Intrinsics.checkNotNullParameter(option, "option");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveSettingKey(String str, String str2, T t, T t2, String... option) {
        super(str, str2, t, t2, (String[]) Arrays.copyOf(option, option.length));
        Intrinsics.checkNotNullParameter(option, "option");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveSettingKey(String str, String str2, T t, T t2, boolean z, String... option) {
        super(str, str2, t, t2, z, (String[]) Arrays.copyOf(option, option.length));
        Intrinsics.checkNotNullParameter(option, "option");
    }

    public LiveSettingKey(String str, Class<T> cls) {
        super(str, (Class) cls);
    }

    public LiveSettingKey(String str, Class<T> cls, String str2) {
        super(str, (Class) cls, str2);
    }

    public LiveSettingKey(String str, Class<T> cls, String str2, T t, T t2) {
        super(str, cls, str2, t, t2);
    }

    public LiveSettingKey(String str, Class<T> cls, String str2, T t, T t2, boolean z) {
        super(str, cls, str2, t, t2, z);
    }

    public LiveSettingKey(String str, Type type, T t) {
        super(str, type, t);
    }
}
