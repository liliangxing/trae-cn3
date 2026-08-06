package com.bytedance.ies.bullet.service.sdk.param;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SoftInputModeParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/param/SoftInputMode;", "", "value", "", "systemValue", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getSystemValue", "()I", "getValue", "()Ljava/lang/String;", "STATE_UNSPECIFIED", "STATE_UNCHANGED", "STATE_HIDDEN", "STATE_ALWAYS_HIDDEN", "STATE_VISIBLE", "STATE_ALWAYS_VISIBLE", "ADJUST_UNSPECIFIED", "ADJUST_RESIZE", "ADJUST_PAN", "IS_FORWARD_NAVIGATION", "ADJUST_NOTHING", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public enum SoftInputMode {
    STATE_UNSPECIFIED("state_unspecified", 0),
    STATE_UNCHANGED("state_unchanged", 1),
    STATE_HIDDEN("state_hidden", 2),
    STATE_ALWAYS_HIDDEN("state_always_hidden", 3),
    STATE_VISIBLE("state_visible", 4),
    STATE_ALWAYS_VISIBLE("state_always_visible", 5),
    ADJUST_UNSPECIFIED("adjust_unspecified", 0),
    ADJUST_RESIZE("adjust_resize", 16),
    ADJUST_PAN("adjust_pan", 32),
    IS_FORWARD_NAVIGATION("is_forward_navigation", 256),
    ADJUST_NOTHING("adjust_nothing", 48);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int systemValue;
    private final String value;

    SoftInputMode(String str, int i) {
        this.value = str;
        this.systemValue = i;
    }

    public final int getSystemValue() {
        return this.systemValue;
    }

    public final String getValue() {
        return this.value;
    }

    /* compiled from: SoftInputModeParam.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/param/SoftInputMode$Companion;", "", "()V", "fromInt", "Lcom/bytedance/ies/bullet/service/sdk/param/SoftInputMode;", "input", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SoftInputMode fromInt(int input) {
            for (SoftInputMode softInputMode : SoftInputMode.values()) {
                if (softInputMode.getSystemValue() == input) {
                    return softInputMode;
                }
            }
            return null;
        }
    }
}
