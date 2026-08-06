package com.bytedance.ies.bullet.redirect;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXRedirectImplProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0004\"\u00020\u0002¢\u0006\u0002\u0010\u0005\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\u0001¨\u0006\b"}, d2 = {"isAnyOf", "", "", "args", "", "(Ljava/lang/Object;[Ljava/lang/Object;)Z", "toIntString", "", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class AnnieXRedirectImplProcessorKt {
    public static final String toIntString(boolean z) {
        return z ? "1" : "0";
    }

    public static final boolean isAnyOf(Object obj, Object... args) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        for (Object obj2 : args) {
            if (Intrinsics.areEqual(obj2, obj)) {
                return true;
            }
        }
        return false;
    }
}
