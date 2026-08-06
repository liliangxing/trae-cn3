package com.bytedance.dataplatform.config;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.dataplatform.ExperimentManager;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExperimentEntityUtiil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a9\u0010\u0019\u001a\u0004\u0018\u0001H\u001a\"\b\b\u0000\u0010\u001a*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u0001H\u001a2\u0006\u0010\u001e\u001a\u00020\u0001¢\u0006\u0002\u0010\u001f\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0000\u0010\u0002\"\u0004\b\u0003\u0010\u0004\"\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\"\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\"\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\"\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\b¨\u0006 "}, d2 = {"isCollecting", "", "()Z", "setCollecting", "(Z)V", "lastDefault", "", "getLastDefault", "()Ljava/lang/Object;", "setLastDefault", "(Ljava/lang/Object;)V", "lastKey", "", "getLastKey", "()Ljava/lang/String;", "setLastKey", "(Ljava/lang/String;)V", "lastType", "Ljava/lang/reflect/Type;", "getLastType", "()Ljava/lang/reflect/Type;", "setLastType", "(Ljava/lang/reflect/Type;)V", "lockObject", "getLockObject", "setting", ExifInterface.GPS_DIRECTION_TRUE, "key", "type", "defaultValue", "isSticky", "(Ljava/lang/String;Ljava/lang/reflect/Type;Ljava/lang/Object;Z)Ljava/lang/Object;", "experiment_release"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final class ExperimentEntityUtiilKt {
    private static boolean isCollecting = false;
    private static Object lastDefault = null;
    private static String lastKey = "";
    private static Type lastType = Object.class;
    private static final Object lockObject = new Object();

    public static final String getLastKey() {
        return lastKey;
    }

    public static final void setLastKey(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        lastKey = str;
    }

    public static final Type getLastType() {
        return lastType;
    }

    public static final void setLastType(Type type) {
        Intrinsics.checkParameterIsNotNull(type, "<set-?>");
        lastType = type;
    }

    public static final Object getLastDefault() {
        return lastDefault;
    }

    public static final void setLastDefault(Object obj) {
        lastDefault = obj;
    }

    public static final boolean isCollecting() {
        return isCollecting;
    }

    public static final void setCollecting(boolean z) {
        isCollecting = z;
    }

    public static final Object getLockObject() {
        return lockObject;
    }

    public static final <T> T setting(String key, Type type, T t, boolean z) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(type, "type");
        if (isCollecting) {
            synchronized (lockObject) {
                if (isCollecting) {
                    lastKey = key;
                    lastType = type;
                    lastDefault = t;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        return (T) ExperimentManager.getExperimentValue(key, type, t, true, z, true, false, null);
    }
}
