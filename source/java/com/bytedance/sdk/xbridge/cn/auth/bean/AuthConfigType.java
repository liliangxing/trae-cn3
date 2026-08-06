package com.bytedance.sdk.xbridge.cn.auth.bean;

import com.bytedance.ies.xbridge.BridgeDataConverterHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BridgeCallRecord.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthConfigType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", BridgeDataConverterHolder.PLATFORM_WEB, BridgeDataConverterHolder.PLATFORM_LYNX, "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public enum AuthConfigType {
    UNKNOWN("unknown"),
    WEB("web"),
    LYNX("lynx");


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String value;

    AuthConfigType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    /* compiled from: BridgeCallRecord.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthConfigType$Companion;", "", "()V", "getType", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthConfigType;", "value", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AuthConfigType getType(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return Intrinsics.areEqual(value, "h5") ? AuthConfigType.WEB : Intrinsics.areEqual(value, "lynx") ? AuthConfigType.LYNX : AuthConfigType.UNKNOWN;
        }
    }
}
