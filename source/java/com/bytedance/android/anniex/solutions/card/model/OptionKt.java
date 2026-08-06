package com.bytedance.android.anniex.solutions.card.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Option.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"toBool", "", "dataSource", "", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class OptionKt {
    public static final boolean toBool(Object obj) {
        if (obj == null || Intrinsics.areEqual(obj, (Object) 0) || Intrinsics.areEqual(obj, "")) {
            return false;
        }
        if ((obj instanceof Number) || (obj instanceof String) || !(obj instanceof Boolean)) {
            return true;
        }
        return ((Boolean) obj).booleanValue();
    }
}
