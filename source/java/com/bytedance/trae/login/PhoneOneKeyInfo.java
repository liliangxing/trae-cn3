package com.bytedance.trae.login;

import com.bytedance.bdinstall.Api;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPhoneOneKeyCallback.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/login/PhoneOneKeyInfo;", "", "maskPhone", "", Api.KEY_CARRIER, "Lcom/bytedance/trae/login/PhoneOneKeyPlatform;", "<init>", "(Ljava/lang/String;Lcom/bytedance/trae/login/PhoneOneKeyPlatform;)V", "getMaskPhone", "()Ljava/lang/String;", "getCarrier", "()Lcom/bytedance/trae/login/PhoneOneKeyPlatform;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PhoneOneKeyInfo {
    private final PhoneOneKeyPlatform carrier;
    private final String maskPhone;

    public static /* synthetic */ PhoneOneKeyInfo copy$default(PhoneOneKeyInfo phoneOneKeyInfo, String str, PhoneOneKeyPlatform phoneOneKeyPlatform, int i, Object obj) {
        if ((i & 1) != 0) {
            str = phoneOneKeyInfo.maskPhone;
        }
        if ((i & 2) != 0) {
            phoneOneKeyPlatform = phoneOneKeyInfo.carrier;
        }
        return phoneOneKeyInfo.copy(str, phoneOneKeyPlatform);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMaskPhone() {
        return this.maskPhone;
    }

    /* renamed from: component2, reason: from getter */
    public final PhoneOneKeyPlatform getCarrier() {
        return this.carrier;
    }

    public final PhoneOneKeyInfo copy(String maskPhone, PhoneOneKeyPlatform carrier) {
        return new PhoneOneKeyInfo(maskPhone, carrier);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhoneOneKeyInfo)) {
            return false;
        }
        PhoneOneKeyInfo phoneOneKeyInfo = (PhoneOneKeyInfo) other;
        return Intrinsics.areEqual(this.maskPhone, phoneOneKeyInfo.maskPhone) && this.carrier == phoneOneKeyInfo.carrier;
    }

    public int hashCode() {
        String str = this.maskPhone;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        PhoneOneKeyPlatform phoneOneKeyPlatform = this.carrier;
        return hashCode + (phoneOneKeyPlatform != null ? phoneOneKeyPlatform.hashCode() : 0);
    }

    public String toString() {
        return "PhoneOneKeyInfo(maskPhone=" + this.maskPhone + ", carrier=" + this.carrier + ')';
    }

    public PhoneOneKeyInfo(String str, PhoneOneKeyPlatform phoneOneKeyPlatform) {
        this.maskPhone = str;
        this.carrier = phoneOneKeyPlatform;
    }

    public final String getMaskPhone() {
        return this.maskPhone;
    }

    public final PhoneOneKeyPlatform getCarrier() {
        return this.carrier;
    }
}
