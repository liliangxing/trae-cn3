package com.bytedance.rts.foundation;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.monitorV2.constant.MonitorConstant;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RTSSet.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a5\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005\"\u0002H\u0002¢\u0006\u0002\u0010\u0006\u001a-\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u0006\u0010\t\u001a\u0002H\u0002¢\u0006\u0002\u0010\n\u001a-\u0010\u000b\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u0006\u0010\t\u001a\u0002H\u0002¢\u0006\u0002\u0010\n*\u001c\u0010\f\u001a\u0004\b\u0000\u0010\u0002\"\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\u0012\u0004\u0012\u0002H\u00020\u0001¨\u0006\r"}, d2 = {"rtsSetOf", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/rts/foundation/RTSSet;", MonitorConstant.BLANK_ALL_ELEMENTS, "", "([Ljava/lang/Object;)Ljava/util/Set;", "delete", "", "element", "(Ljava/util/Set;Ljava/lang/Object;)Z", "has", "RTSSet", "lib_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class RTSSetKt {
    public static final <T> Set<T> rtsSetOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return SetsKt.mutableSetOf(java.util.Arrays.copyOf(elements, elements.length));
    }

    public static final <T> boolean has(Set<T> set, T t) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        return set.contains(t);
    }

    public static final <T> boolean delete(Set<T> set, T t) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        return set.remove(t);
    }
}
