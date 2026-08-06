package com.bytedance.timon.clipboard.suite.config;

import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClipboardCertConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/timon/clipboard/suite/config/ClipboardCertConfig;", "", "unitDisable", "", "tokenConfig", "", "", "Lcom/bytedance/timon/clipboard/suite/config/TokenConfig;", "backgroundDuration", "(ILjava/util/Map;I)V", "getBackgroundDuration", "()I", "getTokenConfig", "()Ljava/util/Map;", "getUnitDisable", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "clipboard-suite_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class ClipboardCertConfig {

    @SerializedName("enter_background_duration_threshold")
    private final int backgroundDuration;
    private final Map<String, TokenConfig> tokenConfig;

    @SerializedName("unit_disable")
    private final int unitDisable;

    public ClipboardCertConfig() {
        this(0, null, 0, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ClipboardCertConfig copy$default(ClipboardCertConfig clipboardCertConfig, int i, Map map, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = clipboardCertConfig.unitDisable;
        }
        if ((i3 & 2) != 0) {
            map = clipboardCertConfig.tokenConfig;
        }
        if ((i3 & 4) != 0) {
            i2 = clipboardCertConfig.backgroundDuration;
        }
        return clipboardCertConfig.copy(i, map, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getUnitDisable() {
        return this.unitDisable;
    }

    public final Map<String, TokenConfig> component2() {
        return this.tokenConfig;
    }

    /* renamed from: component3, reason: from getter */
    public final int getBackgroundDuration() {
        return this.backgroundDuration;
    }

    public final ClipboardCertConfig copy(int unitDisable, Map<String, TokenConfig> tokenConfig, int backgroundDuration) {
        Intrinsics.checkParameterIsNotNull(tokenConfig, "tokenConfig");
        return new ClipboardCertConfig(unitDisable, tokenConfig, backgroundDuration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClipboardCertConfig)) {
            return false;
        }
        ClipboardCertConfig clipboardCertConfig = (ClipboardCertConfig) other;
        return this.unitDisable == clipboardCertConfig.unitDisable && Intrinsics.areEqual(this.tokenConfig, clipboardCertConfig.tokenConfig) && this.backgroundDuration == clipboardCertConfig.backgroundDuration;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.unitDisable) * 31;
        Map<String, TokenConfig> map = this.tokenConfig;
        return ((hashCode + (map != null ? map.hashCode() : 0)) * 31) + Integer.hashCode(this.backgroundDuration);
    }

    public String toString() {
        return "ClipboardCertConfig(unitDisable=" + this.unitDisable + ", tokenConfig=" + this.tokenConfig + ", backgroundDuration=" + this.backgroundDuration + ")";
    }

    public ClipboardCertConfig(int i, Map<String, TokenConfig> map, int i2) {
        Intrinsics.checkParameterIsNotNull(map, "tokenConfig");
        this.unitDisable = i;
        this.tokenConfig = map;
        this.backgroundDuration = i2;
    }

    public final int getUnitDisable() {
        return this.unitDisable;
    }

    public /* synthetic */ ClipboardCertConfig(int i, Map map, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? MapsKt.emptyMap() : map, (i3 & 4) != 0 ? BaseApiResponse.API_THIRD_AUTHORIZE : i2);
    }

    public final Map<String, TokenConfig> getTokenConfig() {
        return this.tokenConfig;
    }

    public final int getBackgroundDuration() {
        return this.backgroundDuration;
    }
}
