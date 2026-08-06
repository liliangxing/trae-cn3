package com.larus.business.markdown.impl.common.utils;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Extras.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\u001a(\u0010\u000b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00030\f*\u00020\u0002ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u0012\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004\u001a\u001f\u0010\u0011\u001a\u0004\u0018\u0001H\u0012\"\u0004\b\u0000\u0010\u0012*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0002\u0010\u0013\u001a'\u0010\u0014\u001a\u0004\u0018\u00010\u0002\"\u0004\b\u0000\u0010\u0012*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0012¢\u0006\u0002\u0010\u0015\u001a\u0012\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004\"(\u0010\u0000\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"H\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0003*\u00020\u00022\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00038B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"allExtras", "Ljava/util/WeakHashMap;", "", "", "", "value", "extras", "getExtras", "(Ljava/lang/Object;)Ljava/util/Map;", "setExtras", "(Ljava/lang/Object;Ljava/util/Map;)V", "cleanExtra", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "containsExtra", "", "key", "getExtra", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "putExtra", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "removeExtra", "", "markdown-impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class ExtrasKt {
    private static final WeakHashMap<Object, Map<String, Object>> allExtras = new WeakHashMap<>();

    private static final Map<String, Object> getExtras(Object obj) {
        return allExtras.get(obj);
    }

    private static final void setExtras(Object obj, Map<String, Object> map) {
        allExtras.put(obj, map);
    }

    public static final <T> Object putExtra(Object obj, String key, T t) {
        Object put;
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (allExtras) {
            LinkedHashMap extras = getExtras(obj);
            if (extras == null) {
                extras = new LinkedHashMap();
                setExtras(obj, extras);
            }
            put = extras.put(key, t);
        }
        return put;
    }

    public static final <T> T getExtra(Object obj, String key) {
        T t;
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (allExtras) {
            Map<String, Object> extras = getExtras(obj);
            t = null;
            if (extras != null) {
                Object obj2 = extras.get(key);
                if (obj2 != null) {
                    t = (T) obj2;
                }
            }
        }
        return t;
    }

    public static final void removeExtra(Object obj, String key) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (allExtras) {
            Map<String, Object> extras = getExtras(obj);
            if (extras != null) {
                extras.remove(key);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final Object cleanExtra(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m10253constructorimpl(allExtras.remove(obj));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10253constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static final boolean containsExtra(Object obj, String key) {
        boolean containsKey;
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (allExtras) {
            Map<String, Object> extras = getExtras(obj);
            containsKey = extras == null ? false : extras.containsKey(key);
        }
        return containsKey;
    }
}
