package com.bytedance.rts.foundation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RTSType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/rts/foundation/Type;", "", "()V", "Companion", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class Type {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: RTSType.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001¨\u0006\u000b"}, d2 = {"Lcom/bytedance/rts/foundation/Type$Companion;", "", "()V", "isBoolean", "", "arg", "isFloat64", "isInt32", "isInt64", "isNil", "isString", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isNil(Object arg) {
            Intrinsics.checkNotNullParameter(arg, "arg");
            return arg instanceof Boolean;
        }

        public final boolean isInt64(Object arg) {
            Intrinsics.checkNotNullParameter(arg, "arg");
            return arg instanceof Long;
        }

        public final boolean isInt32(Object arg) {
            Intrinsics.checkNotNullParameter(arg, "arg");
            return arg instanceof Integer;
        }

        public final boolean isFloat64(Object arg) {
            Intrinsics.checkNotNullParameter(arg, "arg");
            return arg instanceof Double;
        }

        public final boolean isBoolean(Object arg) {
            Intrinsics.checkNotNullParameter(arg, "arg");
            return arg instanceof Boolean;
        }

        public final boolean isString(Object arg) {
            Intrinsics.checkNotNullParameter(arg, "arg");
            return arg instanceof String;
        }
    }
}
