package com.bytedance.timon.clipboard.suite.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClipboardCertConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\nHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/bytedance/timon/clipboard/suite/config/TokenConfig;", "", "expireTime", "", "unitDisable", "", "patternConfidence", "", "patterns", "", "", "(JIFLjava/util/List;)V", "getExpireTime", "()J", "getPatternConfidence", "()F", "getPatterns", "()Ljava/util/List;", "getUnitDisable", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "clipboard-suite_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class TokenConfig {

    @SerializedName("expire_time")
    private final long expireTime;

    @SerializedName("pattern_confidence")
    private final float patternConfidence;

    @SerializedName("patterns")
    private final List<String> patterns;

    @SerializedName("unit_disable")
    private final int unitDisable;

    public TokenConfig() {
        this(0L, 0, 0.0f, null, 15, null);
    }

    public static /* synthetic */ TokenConfig copy$default(TokenConfig tokenConfig, long j, int i, float f, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = tokenConfig.expireTime;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            i = tokenConfig.unitDisable;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            f = tokenConfig.patternConfidence;
        }
        float f2 = f;
        if ((i2 & 8) != 0) {
            list = tokenConfig.patterns;
        }
        return tokenConfig.copy(j2, i3, f2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final long getExpireTime() {
        return this.expireTime;
    }

    /* renamed from: component2, reason: from getter */
    public final int getUnitDisable() {
        return this.unitDisable;
    }

    /* renamed from: component3, reason: from getter */
    public final float getPatternConfidence() {
        return this.patternConfidence;
    }

    public final List<String> component4() {
        return this.patterns;
    }

    public final TokenConfig copy(long expireTime, int unitDisable, float patternConfidence, List<String> patterns) {
        Intrinsics.checkParameterIsNotNull(patterns, "patterns");
        return new TokenConfig(expireTime, unitDisable, patternConfidence, patterns);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TokenConfig)) {
            return false;
        }
        TokenConfig tokenConfig = (TokenConfig) other;
        return this.expireTime == tokenConfig.expireTime && this.unitDisable == tokenConfig.unitDisable && Float.compare(this.patternConfidence, tokenConfig.patternConfidence) == 0 && Intrinsics.areEqual(this.patterns, tokenConfig.patterns);
    }

    public int hashCode() {
        int hashCode = ((((Long.hashCode(this.expireTime) * 31) + Integer.hashCode(this.unitDisable)) * 31) + Float.hashCode(this.patternConfidence)) * 31;
        List<String> list = this.patterns;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "TokenConfig(expireTime=" + this.expireTime + ", unitDisable=" + this.unitDisable + ", patternConfidence=" + this.patternConfidence + ", patterns=" + this.patterns + ")";
    }

    public TokenConfig(long j, int i, float f, List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "patterns");
        this.expireTime = j;
        this.unitDisable = i;
        this.patternConfidence = f;
        this.patterns = list;
    }

    public final long getExpireTime() {
        return this.expireTime;
    }

    public final int getUnitDisable() {
        return this.unitDisable;
    }

    public final float getPatternConfidence() {
        return this.patternConfidence;
    }

    public /* synthetic */ TokenConfig(long j, int i, float f, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Long.MAX_VALUE : j, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? 0.0f : f, (i2 & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<String> getPatterns() {
        return this.patterns;
    }
}
