package com.bytedance.rts.foundation;

import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.push.Configuration;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RTSArray.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\u001a5\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u0005\"\u0004\b\u0000\u0010\u00032\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00030\n\"\u0002H\u0003¢\u0006\u0002\u0010\u0014\u001a \u0010\u0015\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u0005\u001ai\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u0005\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u000522\u0010\u0017\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u00050\n\"\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u0005¢\u0006\u0002\u0010\u0018\u001aL\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u0005\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u00052\u0006\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u0001\u001aC\u0010\u001d\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u00052!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0000\u0012\u0004\u0012\u00020\u001e0 \u001aQ\u0010#\u001a\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u0005\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u00052\u0006\u0010$\u001a\u0002H\u00032\b\b\u0002\u0010%\u001a\u00020\u00012\b\b\u0002\u0010&\u001a\u00020\u0001¢\u0006\u0002\u0010'\u001aD\u0010(\u001a\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u0005\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u00052\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u001e0 \u001a4\u0010)\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u00052\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u001e0 \u001a7\u0010*\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u00052\u0006\u0010+\u001a\u0002H\u00032\b\b\u0002\u0010,\u001a\u00020\u0001¢\u0006\u0002\u0010-\u001a7\u0010.\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u00052\u0006\u0010+\u001a\u0002H\u00032\b\b\u0002\u0010,\u001a\u00020\u0001¢\u0006\u0002\u0010/\u001a*\u00100\u001a\u000201\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u00052\b\b\u0002\u00102\u001a\u000201\u001a7\u00103\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u00052\u0006\u0010+\u001a\u0002H\u00032\b\b\u0002\u0010,\u001a\u00020\u0001¢\u0006\u0002\u0010/\u001aY\u00104\u001a\u0012\u0012\u0004\u0012\u0002H50\u0004j\b\u0012\u0004\u0012\u0002H5`\u0005\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u00105*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u00052!\u00106\u001a\u001d\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0000\u0012\u0004\u0012\u0002H50 \u001an\u00104\u001a\u0012\u0012\u0004\u0012\u0002H50\u0004j\b\u0012\u0004\u0012\u0002H5`\u0005\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u00105*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u000526\u00106\u001a2\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0000\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(8\u0012\u0004\u0012\u0002H507\u001a\u0093\u0001\u00104\u001a\u0012\u0012\u0004\u0012\u0002H50\u0004j\b\u0012\u0004\u0012\u0002H5`\u0005\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u00105*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u00052[\u00106\u001aW\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0000\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(8\u0012#\u0012!\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u0005¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(:\u0012\u0004\u0012\u0002H509\u001a'\u0010;\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u0005¢\u0006\u0002\u0010<\u001a-\u0010=\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u00052\u0006\u0010>\u001a\u0002H\u0003¢\u0006\u0002\u0010?\u001a?\u0010@\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u00052\u0018\u0010A\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u000307¢\u0006\u0002\u0010B\u001a0\u0010C\u001a\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u0005\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u0005\u001a'\u0010D\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u0005¢\u0006\u0002\u0010<\u001aD\u0010E\u001a\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u0005\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u0001\u001a4\u0010F\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u00052\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u001e0 \u001ah\u0010G\u001a\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u0005\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u000526\u0010H\u001a2\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(I\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020\u000107\u001a0\u0010K\u001a\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u0005\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u0005\u001ah\u0010K\u001a\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u0005\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u000526\u0010H\u001a2\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(I\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020\u000107\u001aY\u0010L\u001a\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u0005\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u00052\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010M\u001a\u00020\u00012\u0012\u0010N\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00030\n\"\u0002H\u0003¢\u0006\u0002\u0010O\u001a9\u0010P\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u00052\u0012\u0010N\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00030\n\"\u0002H\u0003¢\u0006\u0002\u0010Q\">\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u0012\u0012\u0004\u0012\u0002H\u00030\u0004j\b\u0012\u0004\u0012\u0002H\u0003`\u00052\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\"!\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\n8F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u000b\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\r\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u000f\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0011*\u001c\u0010R\u001a\u0004\b\u0000\u0010\u0003\"\b\u0012\u0004\u0012\u0002H\u0003`S2\b\u0012\u0004\u0012\u0002H\u00030\u0004¨\u0006T"}, d2 = {"value", "", "length", "T", "Ljava/util/ArrayList;", "Lcom/bytedance/rts/foundation/RTSArray;", "getLength", "(Ljava/util/ArrayList;)I", "setLength", "(Ljava/util/ArrayList;I)V", "", "([Ljava/lang/Object;)I", "", "([Z)I", "", "([D)I", "", "([I)I", "rtsArrayOf", "elements", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "capacity", "concat", "arrays", "(Ljava/util/ArrayList;[Ljava/util/ArrayList;)Ljava/util/ArrayList;", "copyWithin", "target", TraeAuthManager.STAGE_START, MetricConstant.MONITOR_STAGE_LOAD_TEMPLATE, "every", "", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "fill", "element", "startIndex", "endIndex", "(Ljava/util/ArrayList;Ljava/lang/Object;II)Ljava/util/ArrayList;", "filterTo", "findIndex", "includes", "searchElement", "fromIndex", "(Ljava/util/ArrayList;Ljava/lang/Object;I)Z", "indexOf", "(Ljava/util/ArrayList;Ljava/lang/Object;I)I", "join", "", "separator", "lastIndexOf", "map", "R", "transform", "Lkotlin/Function2;", "index", "Lkotlin/Function3;", "array", "pop", "(Ljava/util/ArrayList;)Ljava/lang/Object;", Configuration.NOTIFICATION_ID, "elem", "(Ljava/util/ArrayList;Ljava/lang/Object;)Z", "reduceTo", "callbackFn", "(Ljava/util/ArrayList;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "reverseTo", "shift", "slice", "some", "sort", "compareFn", "a", "b", "sortTo", "splice", "deleteCount", "items", "(Ljava/util/ArrayList;II[Ljava/lang/Object;)Ljava/util/ArrayList;", "unshift", "(Ljava/util/ArrayList;[Ljava/lang/Object;)I", "RTSArray", "Lkotlin/collections/ArrayList;", "lib_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RTSArrayKt {
    public static final <T> ArrayList<T> rtsArrayOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return CollectionsKt.arrayListOf(java.util.Arrays.copyOf(tArr, tArr.length));
    }

    public static final <T> int getLength(ArrayList<T> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        return arrayList.size();
    }

    public static final <T> void setLength(ArrayList<T> arrayList, int i) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        if (i == 0) {
            arrayList.clear();
            return;
        }
        for (int size = arrayList.size() - i; size > 0; size--) {
            pop(arrayList);
        }
    }

    public static final int getLength(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr.length;
    }

    public static final int getLength(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr.length;
    }

    public static final int getLength(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr.length;
    }

    public static final <T> int getLength(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr.length;
    }

    public static final <T> int findIndex(ArrayList<T> arrayList, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<T> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (((Boolean) function1.invoke(it.next())).booleanValue()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final <T> boolean push(ArrayList<T> arrayList, T t) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        return arrayList.add(t);
    }

    public static /* synthetic */ ArrayList fill$default(ArrayList arrayList, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = capacity(arrayList);
        }
        return fill(arrayList, obj, i, i2);
    }

    public static final <T> ArrayList<T> fill(ArrayList<T> arrayList, T t, int i, int i2) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        int capacity = capacity(arrayList);
        if (i < 0) {
            i += capacity;
        }
        if (i2 < 0) {
            i2 += capacity;
        }
        int min = java.lang.Math.min(i2, capacity);
        if (arrayList.isEmpty()) {
            for (int i3 = 0; i3 < capacity; i3++) {
                arrayList.add(null);
            }
        }
        while (arrayList.size() < min) {
            arrayList.add(null);
        }
        for (int min2 = java.lang.Math.min(i, arrayList.size()); min2 < min; min2++) {
            arrayList.set(min2, t);
        }
        return arrayList;
    }

    public static final <T> int capacity(ArrayList<T> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        try {
            Field declaredField = ArrayList.class.getDeclaredField("elementData");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(arrayList);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
            return ((Object[]) obj).length;
        } catch (Exception unused) {
            return arrayList.size();
        }
    }

    public static final <T> ArrayList<T> filterTo(ArrayList<T> arrayList, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList2 = new ArrayList();
        for (T t : arrayList) {
            if (((Boolean) function1.invoke(t)).booleanValue()) {
                arrayList2.add(t);
            }
        }
        return new ArrayList<>(arrayList2);
    }

    public static /* synthetic */ int indexOf$default(ArrayList arrayList, Object obj, int i, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return indexOf(arrayList, obj, i);
    }

    public static final <T> int indexOf(ArrayList<T> arrayList, T t, int i) {
        int indexOf;
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        if (i < arrayList.size() && (indexOf = CollectionsKt.drop(arrayList, i).indexOf(t)) != -1) {
            return indexOf + i;
        }
        return -1;
    }

    public static /* synthetic */ ArrayList copyWithin$default(ArrayList arrayList, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = arrayList.size();
        }
        return copyWithin(arrayList, i, i2, i3);
    }

    public static final <T> ArrayList<T> copyWithin(ArrayList<T> arrayList, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        int size = arrayList.size();
        int i4 = i < 0 ? size + i : i;
        if (i2 < 0) {
            i2 += size;
        }
        if (i3 < 0) {
            i3 += size;
        }
        int min = java.lang.Math.min(i3 - i2, size - i4);
        if (i >= i2) {
            while (true) {
                min--;
                if (-1 >= min) {
                    break;
                }
                arrayList.set(i4 + min, arrayList.get(i2 + min));
            }
        } else {
            for (int i5 = 0; i5 < min; i5++) {
                arrayList.set(i4 + i5, arrayList.get(i2 + i5));
            }
        }
        return arrayList;
    }

    public static final <T, R> ArrayList<R> map(ArrayList<T> arrayList, Function3<? super T, ? super Integer, ? super ArrayList<T>, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(function3, "transform");
        ArrayList<R> arrayList2 = new ArrayList<>();
        int length = getLength(arrayList);
        for (int i = 0; i < length; i++) {
            push(arrayList2, function3.invoke(arrayList.get(i), Integer.valueOf(i), arrayList));
        }
        return arrayList2;
    }

    public static final <T, R> ArrayList<R> map(ArrayList<T> arrayList, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList<R> arrayList2 = new ArrayList<>();
        int length = getLength(arrayList);
        for (int i = 0; i < length; i++) {
            push(arrayList2, function1.invoke(arrayList.get(i)));
        }
        return arrayList2;
    }

    public static final <T, R> ArrayList<R> map(ArrayList<T> arrayList, Function2<? super T, ? super Integer, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(function2, "transform");
        ArrayList<R> arrayList2 = new ArrayList<>();
        int length = getLength(arrayList);
        for (int i = 0; i < length; i++) {
            push(arrayList2, function2.invoke(arrayList.get(i), Integer.valueOf(i)));
        }
        return arrayList2;
    }

    public static final <T> T pop(ArrayList<T> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        if (!arrayList.isEmpty()) {
            return arrayList.remove(arrayList.size() - 1);
        }
        return null;
    }

    public static final <T> ArrayList<T> concat(ArrayList<T> arrayList, ArrayList<T>... arrayListArr) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(arrayListArr, "arrays");
        ArrayList<T> arrayList2 = new ArrayList<>();
        arrayList2.addAll(arrayList);
        for (ArrayList<T> arrayList3 : arrayListArr) {
            arrayList2.addAll(arrayList3);
        }
        return arrayList2;
    }

    public static final <T> String join(ArrayList<T> arrayList, String str) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(str, "separator");
        return CollectionsKt.joinToString$default(arrayList, str, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public static /* synthetic */ String join$default(ArrayList arrayList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ",";
        }
        return join(arrayList, str);
    }

    public static final <T> ArrayList<T> reverseTo(ArrayList<T> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        CollectionsKt.reverse(arrayList);
        return arrayList;
    }

    public static final <T> T shift(ArrayList<T> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        if (!arrayList.isEmpty()) {
            return arrayList.remove(0);
        }
        return null;
    }

    public static final <T> ArrayList<T> sort(ArrayList<T> arrayList, final Function2<? super T, ? super T, Integer> function2) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(function2, "compareFn");
        CollectionsKt.sortWith(arrayList, new Comparator() { // from class: com.bytedance.rts.foundation.RTSArrayKt$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int sort$lambda$1;
                sort$lambda$1 = RTSArrayKt.sort$lambda$1(function2, obj, obj2);
                return sort$lambda$1;
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sort$lambda$1(Function2 function2, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(function2, "$tmp0");
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    public static final <T> ArrayList<T> sortTo(ArrayList<T> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        if (!arrayList.isEmpty()) {
            ArrayList<T> arrayList2 = arrayList;
            if (CollectionsKt.first(arrayList2) instanceof Comparable) {
                CollectionsKt.sort(arrayList2);
                return arrayList;
            }
        }
        throw new IllegalArgumentException("RTSArray elements are not comparable");
    }

    public static final <T> ArrayList<T> sortTo(ArrayList<T> arrayList, final Function2<? super T, ? super T, Integer> function2) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(function2, "compareFn");
        CollectionsKt.sortWith(arrayList, new Comparator() { // from class: com.bytedance.rts.foundation.RTSArrayKt$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int sortTo$lambda$2;
                sortTo$lambda$2 = RTSArrayKt.sortTo$lambda$2(function2, obj, obj2);
                return sortTo$lambda$2;
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sortTo$lambda$2(Function2 function2, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(function2, "$tmp0");
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    public static final <T> ArrayList<T> splice(ArrayList<T> arrayList, int i, int i2, T... tArr) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "items");
        if (i > arrayList.size()) {
            return rtsArrayOf(new Object[0]);
        }
        int size = arrayList.size();
        int max = i < 0 ? java.lang.Math.max(size + i, 0) : java.lang.Math.min(i, size);
        int min = java.lang.Math.min(java.lang.Math.max(i2, 0), arrayList.size() - max);
        ArrayList<T> arrayList2 = new ArrayList<>();
        for (int i3 = 0; i3 < min; i3++) {
            arrayList2.add(arrayList.get(max));
            arrayList.remove(max);
        }
        int length = tArr.length;
        while (true) {
            length--;
            if (-1 >= length) {
                return arrayList2;
            }
            arrayList.add(max, tArr[length]);
        }
    }

    public static final <T> int unshift(ArrayList<T> arrayList, T... tArr) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "items");
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            arrayList.add(i, tArr[i]);
        }
        return arrayList.size();
    }

    public static /* synthetic */ int lastIndexOf$default(ArrayList arrayList, Object obj, int i, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            i = arrayList.size() - 1;
        }
        return lastIndexOf(arrayList, obj, i);
    }

    public static final <T> int lastIndexOf(ArrayList<T> arrayList, T t, int i) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        return arrayList.subList(0, (i < 0 ? getLength(arrayList) + i : java.lang.Math.min(i, arrayList.size() - 1)) + 1).lastIndexOf(t);
    }

    public static final <T> boolean every(ArrayList<T> arrayList, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList<T> arrayList2 = arrayList;
        if ((arrayList2 instanceof Collection) && arrayList2.isEmpty()) {
            return true;
        }
        Iterator<T> it = arrayList2.iterator();
        while (it.hasNext()) {
            if (!((Boolean) function1.invoke(it.next())).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean some(ArrayList<T> arrayList, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList<T> arrayList2 = arrayList;
        if ((arrayList2 instanceof Collection) && arrayList2.isEmpty()) {
            return false;
        }
        Iterator<T> it = arrayList2.iterator();
        while (it.hasNext()) {
            if (((Boolean) function1.invoke(it.next())).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final <T> T reduceTo(ArrayList<T> arrayList, Function2<? super T, ? super T, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(function2, "callbackFn");
        Iterator<T> it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = (T) function2.invoke(next, it.next());
        }
        return next;
    }

    public static /* synthetic */ boolean includes$default(ArrayList arrayList, Object obj, int i, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return includes(arrayList, obj, i);
    }

    public static final <T> boolean includes(ArrayList<T> arrayList, T t, int i) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        if (i >= arrayList.size()) {
            return false;
        }
        if (i < 0) {
            i += getLength(arrayList);
        }
        return CollectionsKt.drop(arrayList, i).contains(t);
    }

    public static /* synthetic */ ArrayList slice$default(ArrayList arrayList, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = arrayList.size();
        }
        return slice(arrayList, i, i2);
    }

    public static final <T> ArrayList<T> slice(ArrayList<T> arrayList, int i, int i2) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        int size = arrayList.size();
        if (i < 0) {
            i += size;
        }
        if (i2 < 0) {
            i2 += size;
        }
        ArrayList<T> arrayList2 = new ArrayList<>();
        arrayList2.addAll(arrayList.subList(i, java.lang.Math.min(i2, arrayList.size())));
        return arrayList2;
    }
}
