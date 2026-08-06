package com.bytedance.ies.bullet.interaction.predefine.monitor;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PredefineRecordInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\b\u0010\u001c\u001a\u00020\u0003H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ies/bullet/interaction/predefine/monitor/PredefineRecordInfo;", "", "fileName", "", "duration", "", "from", "disabled", "", "(Ljava/lang/String;JLjava/lang/String;Z)V", "getDisabled", "()Z", "setDisabled", "(Z)V", "getDuration", "()J", "getFileName", "()Ljava/lang/String;", "getFrom", "component1", "component2", "component3", "component4", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PredefineRecordInfo {
    private boolean disabled;
    private final long duration;
    private final String fileName;
    private final String from;

    public static /* synthetic */ PredefineRecordInfo copy$default(PredefineRecordInfo predefineRecordInfo, String str, long j, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = predefineRecordInfo.fileName;
        }
        if ((i & 2) != 0) {
            j = predefineRecordInfo.duration;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            str2 = predefineRecordInfo.from;
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            z = predefineRecordInfo.disabled;
        }
        return predefineRecordInfo.copy(str, j2, str3, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFrom() {
        return this.from;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getDisabled() {
        return this.disabled;
    }

    public final PredefineRecordInfo copy(String fileName, long duration, String from, boolean disabled) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(from, "from");
        return new PredefineRecordInfo(fileName, duration, from, disabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PredefineRecordInfo)) {
            return false;
        }
        PredefineRecordInfo predefineRecordInfo = (PredefineRecordInfo) other;
        return Intrinsics.areEqual(this.fileName, predefineRecordInfo.fileName) && this.duration == predefineRecordInfo.duration && Intrinsics.areEqual(this.from, predefineRecordInfo.from) && this.disabled == predefineRecordInfo.disabled;
    }

    public int hashCode() {
        return (((((this.fileName.hashCode() * 31) + Long.hashCode(this.duration)) * 31) + this.from.hashCode()) * 31) + Boolean.hashCode(this.disabled);
    }

    public PredefineRecordInfo(String fileName, long j, String from, boolean z) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(from, "from");
        this.fileName = fileName;
        this.duration = j;
        this.from = from;
        this.disabled = z;
    }

    public /* synthetic */ PredefineRecordInfo(String str, long j, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, str2, (i & 8) != 0 ? false : z);
    }

    public final boolean getDisabled() {
        return this.disabled;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getFrom() {
        return this.from;
    }

    public final void setDisabled(boolean z) {
        this.disabled = z;
    }

    public String toString() {
        return "{file:" + this.fileName + ",duration:" + this.duration + ",from:" + this.from + "},is_disabled=" + this.disabled;
    }
}
