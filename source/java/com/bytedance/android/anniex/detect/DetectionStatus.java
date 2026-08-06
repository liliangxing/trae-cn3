package com.bytedance.android.anniex.detect;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DetectorConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b&\u0018\u00002\u00020\u0001BË\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\f\b\u0002\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0014¢\u0006\u0002\u0010\u0019J\u0006\u0010<\u001a\u00020\u0003J\b\u0010=\u001a\u00020\u0015H\u0016R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001e\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010$\"\u0004\b%\u0010&R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b\u000f\u0010'\"\u0004\b(\u0010)R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b\u000b\u0010'\"\u0004\b+\u0010)R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010$\"\u0004\b,\u0010&R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010$\"\u0004\b-\u0010&R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010$\"\u0004\b.\u0010&R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b\u0006\u0010/\"\u0004\b0\u00101R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010$\"\u0004\b3\u0010&R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010$\"\u0004\b4\u0010&R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010$\"\u0004\b5\u0010&R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b6\u0010/\"\u0004\b7\u00101R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b8\u0010/\"\u0004\b9\u00101R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001b\"\u0004\b;\u0010\u001d¨\u0006>"}, d2 = {"Lcom/bytedance/android/anniex/detect/DetectionStatus;", "", "isDetectFinish", "", "isPitayaReady", "isPixelCopySuccess", "isPixelCopyCost", "", "isPureBlank", "isPureBlankTimeout", "pureBlankCost", "isEnablePureBlankCheck", "isPartialBlank", "isPartialBlankTimeout", "partialBlankCost", "isEnablePartialBlankCheck", "errorMsg", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "bboxs", "", "", "classLabels", "scores", "", "(ZZZLjava/lang/Long;ZZLjava/lang/Long;Ljava/lang/Boolean;ZZLjava/lang/Long;Ljava/lang/Boolean;Ljava/lang/StringBuilder;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBboxs", "()Ljava/util/List;", "setBboxs", "(Ljava/util/List;)V", "getClassLabels", "setClassLabels", "getErrorMsg", "()Ljava/lang/StringBuilder;", "setErrorMsg", "(Ljava/lang/StringBuilder;)V", "()Z", "setDetectFinish", "(Z)V", "()Ljava/lang/Boolean;", "setEnablePartialBlankCheck", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setEnablePureBlankCheck", "setPartialBlank", "setPartialBlankTimeout", "setPitayaReady", "()Ljava/lang/Long;", "setPixelCopyCost", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "setPixelCopySuccess", "setPureBlank", "setPureBlankTimeout", "getPartialBlankCost", "setPartialBlankCost", "getPureBlankCost", "setPureBlankCost", "getScores", "setScores", "isBlank", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class DetectionStatus {
    private List<String> bboxs;
    private List<String> classLabels;
    private StringBuilder errorMsg;
    private boolean isDetectFinish;
    private Boolean isEnablePartialBlankCheck;
    private Boolean isEnablePureBlankCheck;
    private boolean isPartialBlank;
    private boolean isPartialBlankTimeout;
    private boolean isPitayaReady;
    private Long isPixelCopyCost;
    private boolean isPixelCopySuccess;
    private boolean isPureBlank;
    private boolean isPureBlankTimeout;
    private Long partialBlankCost;
    private Long pureBlankCost;
    private List<Float> scores;

    public DetectionStatus() {
        this(false, false, false, null, false, false, null, null, false, false, null, null, null, null, null, null, 65535, null);
    }

    public DetectionStatus(boolean z, boolean z2, boolean z3, Long l, boolean z4, boolean z5, Long l2, Boolean bool, boolean z6, boolean z7, Long l3, Boolean bool2, StringBuilder errorMsg, List<String> list, List<String> list2, List<Float> list3) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        this.isDetectFinish = z;
        this.isPitayaReady = z2;
        this.isPixelCopySuccess = z3;
        this.isPixelCopyCost = l;
        this.isPureBlank = z4;
        this.isPureBlankTimeout = z5;
        this.pureBlankCost = l2;
        this.isEnablePureBlankCheck = bool;
        this.isPartialBlank = z6;
        this.isPartialBlankTimeout = z7;
        this.partialBlankCost = l3;
        this.isEnablePartialBlankCheck = bool2;
        this.errorMsg = errorMsg;
        this.bboxs = list;
        this.classLabels = list2;
        this.scores = list3;
    }

    /* renamed from: isDetectFinish, reason: from getter */
    public final boolean getIsDetectFinish() {
        return this.isDetectFinish;
    }

    public final void setDetectFinish(boolean z) {
        this.isDetectFinish = z;
    }

    /* renamed from: isPitayaReady, reason: from getter */
    public final boolean getIsPitayaReady() {
        return this.isPitayaReady;
    }

    public final void setPitayaReady(boolean z) {
        this.isPitayaReady = z;
    }

    /* renamed from: isPixelCopySuccess, reason: from getter */
    public final boolean getIsPixelCopySuccess() {
        return this.isPixelCopySuccess;
    }

    public final void setPixelCopySuccess(boolean z) {
        this.isPixelCopySuccess = z;
    }

    /* renamed from: isPixelCopyCost, reason: from getter */
    public final Long getIsPixelCopyCost() {
        return this.isPixelCopyCost;
    }

    public final void setPixelCopyCost(Long l) {
        this.isPixelCopyCost = l;
    }

    /* renamed from: isPureBlank, reason: from getter */
    public final boolean getIsPureBlank() {
        return this.isPureBlank;
    }

    public final void setPureBlank(boolean z) {
        this.isPureBlank = z;
    }

    /* renamed from: isPureBlankTimeout, reason: from getter */
    public final boolean getIsPureBlankTimeout() {
        return this.isPureBlankTimeout;
    }

    public final void setPureBlankTimeout(boolean z) {
        this.isPureBlankTimeout = z;
    }

    public final Long getPureBlankCost() {
        return this.pureBlankCost;
    }

    public final void setPureBlankCost(Long l) {
        this.pureBlankCost = l;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ DetectionStatus(boolean z, boolean z2, boolean z3, Long l, boolean z4, boolean z5, Long l2, Boolean bool, boolean z6, boolean z7, Long l3, Boolean bool2, StringBuilder sb, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? null : l, (i & 16) != 0 ? false : z4, (i & 32) != 0 ? false : z5, (i & 64) != 0 ? null : l2, (i & 128) != 0 ? r3 : bool, (i & 256) != 0 ? false : z6, (i & 512) == 0 ? z7 : false, (i & 1024) != 0 ? null : l3, (i & 2048) == 0 ? bool2 : false, (i & 4096) != 0 ? new StringBuilder() : sb, (i & 8192) != 0 ? null : list, (i & 16384) != 0 ? null : list2, (i & 32768) != 0 ? null : list3);
    }

    /* renamed from: isEnablePureBlankCheck, reason: from getter */
    public final Boolean getIsEnablePureBlankCheck() {
        return this.isEnablePureBlankCheck;
    }

    public final void setEnablePureBlankCheck(Boolean bool) {
        this.isEnablePureBlankCheck = bool;
    }

    /* renamed from: isPartialBlank, reason: from getter */
    public final boolean getIsPartialBlank() {
        return this.isPartialBlank;
    }

    public final void setPartialBlank(boolean z) {
        this.isPartialBlank = z;
    }

    /* renamed from: isPartialBlankTimeout, reason: from getter */
    public final boolean getIsPartialBlankTimeout() {
        return this.isPartialBlankTimeout;
    }

    public final void setPartialBlankTimeout(boolean z) {
        this.isPartialBlankTimeout = z;
    }

    public final Long getPartialBlankCost() {
        return this.partialBlankCost;
    }

    public final void setPartialBlankCost(Long l) {
        this.partialBlankCost = l;
    }

    /* renamed from: isEnablePartialBlankCheck, reason: from getter */
    public final Boolean getIsEnablePartialBlankCheck() {
        return this.isEnablePartialBlankCheck;
    }

    public final void setEnablePartialBlankCheck(Boolean bool) {
        this.isEnablePartialBlankCheck = bool;
    }

    public final StringBuilder getErrorMsg() {
        return this.errorMsg;
    }

    public final void setErrorMsg(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "<set-?>");
        this.errorMsg = sb;
    }

    public final List<String> getBboxs() {
        return this.bboxs;
    }

    public final void setBboxs(List<String> list) {
        this.bboxs = list;
    }

    public final List<String> getClassLabels() {
        return this.classLabels;
    }

    public final void setClassLabels(List<String> list) {
        this.classLabels = list;
    }

    public final List<Float> getScores() {
        return this.scores;
    }

    public final void setScores(List<Float> list) {
        this.scores = list;
    }

    public final boolean isBlank() {
        return this.isPureBlank || this.isPartialBlank;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("isDetectFinish:");
        sb.append(this.isDetectFinish).append(", isPitayaReady:").append(this.isPitayaReady).append(", isPixelCopySuccess").append(this.isPixelCopySuccess).append(", isPixelCopyCost").append(this.isPixelCopyCost).append(", isPureBlank").append(this.isPureBlank).append(", isPureBlankTimeout").append(this.isPureBlankTimeout).append(", pureBlankCost").append(this.pureBlankCost).append(", isPartialBlank").append(this.isPartialBlank).append(", isPartialBlankTimeout").append(this.isPartialBlankTimeout).append(", partialBlankCost").append(this.partialBlankCost).append(", errorMsg").append((Object) this.errorMsg).append("bboxs");
        sb.append(this.bboxs).append(", classLabels").append(this.classLabels).append(", scores").append(this.scores);
        return sb.toString();
    }
}
