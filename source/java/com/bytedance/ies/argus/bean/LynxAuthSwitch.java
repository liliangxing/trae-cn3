package com.bytedance.ies.argus.bean;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SignAuthBean.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/argus/bean/LynxAuthSwitch;", "", "signVerifyMode", "", "enableJsbAuth", "", "enableJsbCallLimit", "(IZZ)V", "getEnableJsbAuth", "()Z", "getEnableJsbCallLimit", "getSignVerifyMode", "()I", "component1", "component2", "component3", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LynxAuthSwitch {
    public static final int OFF = 0;
    public static final int ON = 2;
    public static final int VERIFY_ONLY = 1;
    private final boolean enableJsbAuth;
    private final boolean enableJsbCallLimit;
    private final int signVerifyMode;

    public LynxAuthSwitch() {
        this(0, false, false, 7, null);
    }

    public static /* synthetic */ LynxAuthSwitch copy$default(LynxAuthSwitch lynxAuthSwitch, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = lynxAuthSwitch.signVerifyMode;
        }
        if ((i2 & 2) != 0) {
            z = lynxAuthSwitch.enableJsbAuth;
        }
        if ((i2 & 4) != 0) {
            z2 = lynxAuthSwitch.enableJsbCallLimit;
        }
        return lynxAuthSwitch.copy(i, z, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getSignVerifyMode() {
        return this.signVerifyMode;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getEnableJsbAuth() {
        return this.enableJsbAuth;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getEnableJsbCallLimit() {
        return this.enableJsbCallLimit;
    }

    public final LynxAuthSwitch copy(int signVerifyMode, boolean enableJsbAuth, boolean enableJsbCallLimit) {
        return new LynxAuthSwitch(signVerifyMode, enableJsbAuth, enableJsbCallLimit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LynxAuthSwitch)) {
            return false;
        }
        LynxAuthSwitch lynxAuthSwitch = (LynxAuthSwitch) other;
        return this.signVerifyMode == lynxAuthSwitch.signVerifyMode && this.enableJsbAuth == lynxAuthSwitch.enableJsbAuth && this.enableJsbCallLimit == lynxAuthSwitch.enableJsbCallLimit;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.signVerifyMode) * 31) + Boolean.hashCode(this.enableJsbAuth)) * 31) + Boolean.hashCode(this.enableJsbCallLimit);
    }

    public String toString() {
        return "LynxAuthSwitch(signVerifyMode=" + this.signVerifyMode + ", enableJsbAuth=" + this.enableJsbAuth + ", enableJsbCallLimit=" + this.enableJsbCallLimit + ')';
    }

    public LynxAuthSwitch(int i, boolean z, boolean z2) {
        this.signVerifyMode = i;
        this.enableJsbAuth = z;
        this.enableJsbCallLimit = z2;
    }

    public /* synthetic */ LynxAuthSwitch(int i, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? false : z2);
    }

    public final int getSignVerifyMode() {
        return this.signVerifyMode;
    }

    public final boolean getEnableJsbAuth() {
        return this.enableJsbAuth;
    }

    public final boolean getEnableJsbCallLimit() {
        return this.enableJsbCallLimit;
    }
}
