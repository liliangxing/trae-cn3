package com.bytedance.android.anniex.detect;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AnnieXBlankDetectorManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007¢\u0006\u0002\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003Jm\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u0007HÆ\u0001J\u0013\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011¨\u0006+"}, d2 = {"Lcom/bytedance/android/anniex/detect/BlankDetectorConfig;", "", "isCheckEnable", "", "isPureBlankCheckEnable", "isPartialBlankCheckEnable", "checkTimeoutMs", "", "snapShotTimeoutMs", "snapShotMaxQuality", "", "pureColorCheckThreshold", "pureColorCheckTimeoutMs", "partialBlankCheckTimeoutMs", "detectFrequencyInternal", "(ZZZJJFFJJJ)V", "getCheckTimeoutMs", "()J", "getDetectFrequencyInternal", "()Z", "getPartialBlankCheckTimeoutMs", "getPureColorCheckThreshold", "()F", "getPureColorCheckTimeoutMs", "getSnapShotMaxQuality", "getSnapShotTimeoutMs", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BlankDetectorConfig {
    private final long checkTimeoutMs;
    private final long detectFrequencyInternal;
    private final boolean isCheckEnable;
    private final boolean isPartialBlankCheckEnable;
    private final boolean isPureBlankCheckEnable;
    private final long partialBlankCheckTimeoutMs;
    private final float pureColorCheckThreshold;
    private final long pureColorCheckTimeoutMs;
    private final float snapShotMaxQuality;
    private final long snapShotTimeoutMs;

    public BlankDetectorConfig() {
        this(false, false, false, 0L, 0L, 0.0f, 0.0f, 0L, 0L, 0L, 1023, null);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsCheckEnable() {
        return this.isCheckEnable;
    }

    /* renamed from: component10, reason: from getter */
    public final long getDetectFrequencyInternal() {
        return this.detectFrequencyInternal;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsPureBlankCheckEnable() {
        return this.isPureBlankCheckEnable;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsPartialBlankCheckEnable() {
        return this.isPartialBlankCheckEnable;
    }

    /* renamed from: component4, reason: from getter */
    public final long getCheckTimeoutMs() {
        return this.checkTimeoutMs;
    }

    /* renamed from: component5, reason: from getter */
    public final long getSnapShotTimeoutMs() {
        return this.snapShotTimeoutMs;
    }

    /* renamed from: component6, reason: from getter */
    public final float getSnapShotMaxQuality() {
        return this.snapShotMaxQuality;
    }

    /* renamed from: component7, reason: from getter */
    public final float getPureColorCheckThreshold() {
        return this.pureColorCheckThreshold;
    }

    /* renamed from: component8, reason: from getter */
    public final long getPureColorCheckTimeoutMs() {
        return this.pureColorCheckTimeoutMs;
    }

    /* renamed from: component9, reason: from getter */
    public final long getPartialBlankCheckTimeoutMs() {
        return this.partialBlankCheckTimeoutMs;
    }

    public final BlankDetectorConfig copy(boolean isCheckEnable, boolean isPureBlankCheckEnable, boolean isPartialBlankCheckEnable, long checkTimeoutMs, long snapShotTimeoutMs, float snapShotMaxQuality, float pureColorCheckThreshold, long pureColorCheckTimeoutMs, long partialBlankCheckTimeoutMs, long detectFrequencyInternal) {
        return new BlankDetectorConfig(isCheckEnable, isPureBlankCheckEnable, isPartialBlankCheckEnable, checkTimeoutMs, snapShotTimeoutMs, snapShotMaxQuality, pureColorCheckThreshold, pureColorCheckTimeoutMs, partialBlankCheckTimeoutMs, detectFrequencyInternal);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlankDetectorConfig)) {
            return false;
        }
        BlankDetectorConfig blankDetectorConfig = (BlankDetectorConfig) other;
        return this.isCheckEnable == blankDetectorConfig.isCheckEnable && this.isPureBlankCheckEnable == blankDetectorConfig.isPureBlankCheckEnable && this.isPartialBlankCheckEnable == blankDetectorConfig.isPartialBlankCheckEnable && this.checkTimeoutMs == blankDetectorConfig.checkTimeoutMs && this.snapShotTimeoutMs == blankDetectorConfig.snapShotTimeoutMs && Float.compare(this.snapShotMaxQuality, blankDetectorConfig.snapShotMaxQuality) == 0 && Float.compare(this.pureColorCheckThreshold, blankDetectorConfig.pureColorCheckThreshold) == 0 && this.pureColorCheckTimeoutMs == blankDetectorConfig.pureColorCheckTimeoutMs && this.partialBlankCheckTimeoutMs == blankDetectorConfig.partialBlankCheckTimeoutMs && this.detectFrequencyInternal == blankDetectorConfig.detectFrequencyInternal;
    }

    public int hashCode() {
        return (((((((((((((((((Boolean.hashCode(this.isCheckEnable) * 31) + Boolean.hashCode(this.isPureBlankCheckEnable)) * 31) + Boolean.hashCode(this.isPartialBlankCheckEnable)) * 31) + Long.hashCode(this.checkTimeoutMs)) * 31) + Long.hashCode(this.snapShotTimeoutMs)) * 31) + Float.hashCode(this.snapShotMaxQuality)) * 31) + Float.hashCode(this.pureColorCheckThreshold)) * 31) + Long.hashCode(this.pureColorCheckTimeoutMs)) * 31) + Long.hashCode(this.partialBlankCheckTimeoutMs)) * 31) + Long.hashCode(this.detectFrequencyInternal);
    }

    public String toString() {
        return "BlankDetectorConfig(isCheckEnable=" + this.isCheckEnable + ", isPureBlankCheckEnable=" + this.isPureBlankCheckEnable + ", isPartialBlankCheckEnable=" + this.isPartialBlankCheckEnable + ", checkTimeoutMs=" + this.checkTimeoutMs + ", snapShotTimeoutMs=" + this.snapShotTimeoutMs + ", snapShotMaxQuality=" + this.snapShotMaxQuality + ", pureColorCheckThreshold=" + this.pureColorCheckThreshold + ", pureColorCheckTimeoutMs=" + this.pureColorCheckTimeoutMs + ", partialBlankCheckTimeoutMs=" + this.partialBlankCheckTimeoutMs + ", detectFrequencyInternal=" + this.detectFrequencyInternal + ')';
    }

    public BlankDetectorConfig(boolean z, boolean z2, boolean z3, long j, long j2, float f, float f2, long j3, long j4, long j5) {
        this.isCheckEnable = z;
        this.isPureBlankCheckEnable = z2;
        this.isPartialBlankCheckEnable = z3;
        this.checkTimeoutMs = j;
        this.snapShotTimeoutMs = j2;
        this.snapShotMaxQuality = f;
        this.pureColorCheckThreshold = f2;
        this.pureColorCheckTimeoutMs = j3;
        this.partialBlankCheckTimeoutMs = j4;
        this.detectFrequencyInternal = j5;
    }

    public /* synthetic */ BlankDetectorConfig(boolean z, boolean z2, boolean z3, long j, long j2, float f, float f2, long j3, long j4, long j5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) == 0 ? z3 : false, (i & 8) != 0 ? 1500L : j, (i & 16) != 0 ? 500L : j2, (i & 32) != 0 ? 360.0f : f, (i & 64) != 0 ? 0.9f : f2, (i & 128) != 0 ? 500L : j3, (i & 256) == 0 ? j4 : 500L, (i & 512) != 0 ? 60 * 1000 : j5);
    }

    public final boolean isCheckEnable() {
        return this.isCheckEnable;
    }

    public final boolean isPureBlankCheckEnable() {
        return this.isPureBlankCheckEnable;
    }

    public final boolean isPartialBlankCheckEnable() {
        return this.isPartialBlankCheckEnable;
    }

    public final long getCheckTimeoutMs() {
        return this.checkTimeoutMs;
    }

    public final long getSnapShotTimeoutMs() {
        return this.snapShotTimeoutMs;
    }

    public final float getSnapShotMaxQuality() {
        return this.snapShotMaxQuality;
    }

    public final float getPureColorCheckThreshold() {
        return this.pureColorCheckThreshold;
    }

    public final long getPureColorCheckTimeoutMs() {
        return this.pureColorCheckTimeoutMs;
    }

    public final long getPartialBlankCheckTimeoutMs() {
        return this.partialBlankCheckTimeoutMs;
    }

    public final long getDetectFrequencyInternal() {
        return this.detectFrequencyInternal;
    }
}
