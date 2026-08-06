package com.bytedance.ies.argus.bean;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ArgusSettingsConfigModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusInitSetting;", "", "geckoCdnRetryTime", "", "forceSkipInvalidGecko", "", "(IZ)V", "getForceSkipInvalidGecko", "()Z", "getGeckoCdnRetryTime", "()I", "component1", "component2", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ArgusInitSetting {

    @SerializedName("force_skip_invalid_gecko")
    private final boolean forceSkipInvalidGecko;

    @SerializedName("gecko_cdn_retry_time")
    private final int geckoCdnRetryTime;

    /* JADX WARN: Multi-variable type inference failed */
    public ArgusInitSetting() {
        this(0, 0 == true ? 1 : 0, 3, null);
    }

    public static /* synthetic */ ArgusInitSetting copy$default(ArgusInitSetting argusInitSetting, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = argusInitSetting.geckoCdnRetryTime;
        }
        if ((i2 & 2) != 0) {
            z = argusInitSetting.forceSkipInvalidGecko;
        }
        return argusInitSetting.copy(i, z);
    }

    /* renamed from: component1, reason: from getter */
    public final int getGeckoCdnRetryTime() {
        return this.geckoCdnRetryTime;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getForceSkipInvalidGecko() {
        return this.forceSkipInvalidGecko;
    }

    public final ArgusInitSetting copy(int geckoCdnRetryTime, boolean forceSkipInvalidGecko) {
        return new ArgusInitSetting(geckoCdnRetryTime, forceSkipInvalidGecko);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArgusInitSetting)) {
            return false;
        }
        ArgusInitSetting argusInitSetting = (ArgusInitSetting) other;
        return this.geckoCdnRetryTime == argusInitSetting.geckoCdnRetryTime && this.forceSkipInvalidGecko == argusInitSetting.forceSkipInvalidGecko;
    }

    public int hashCode() {
        return (Integer.hashCode(this.geckoCdnRetryTime) * 31) + Boolean.hashCode(this.forceSkipInvalidGecko);
    }

    public String toString() {
        return "ArgusInitSetting(geckoCdnRetryTime=" + this.geckoCdnRetryTime + ", forceSkipInvalidGecko=" + this.forceSkipInvalidGecko + ')';
    }

    public ArgusInitSetting(int i, boolean z) {
        this.geckoCdnRetryTime = i;
        this.forceSkipInvalidGecko = z;
    }

    public /* synthetic */ ArgusInitSetting(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? false : z);
    }

    public final int getGeckoCdnRetryTime() {
        return this.geckoCdnRetryTime;
    }

    public final boolean getForceSkipInvalidGecko() {
        return this.forceSkipInvalidGecko;
    }
}
