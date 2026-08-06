package com.bytedance.ies.bullet.interaction.predefine.model;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JSFileCacheModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/bullet/interaction/predefine/model/JSFileCacheModel;", "", "filePath", "", "fromOffline", "", "loadDuration", "", "(Ljava/lang/String;ZJ)V", "getFilePath", "()Ljava/lang/String;", "getFromOffline", "()Z", "getLoadDuration", "()J", "component1", "component2", "component3", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class JSFileCacheModel {
    private final String filePath;
    private final boolean fromOffline;
    private final long loadDuration;

    public static /* synthetic */ JSFileCacheModel copy$default(JSFileCacheModel jSFileCacheModel, String str, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = jSFileCacheModel.filePath;
        }
        if ((i & 2) != 0) {
            z = jSFileCacheModel.fromOffline;
        }
        if ((i & 4) != 0) {
            j = jSFileCacheModel.loadDuration;
        }
        return jSFileCacheModel.copy(str, z, j);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getFromOffline() {
        return this.fromOffline;
    }

    /* renamed from: component3, reason: from getter */
    public final long getLoadDuration() {
        return this.loadDuration;
    }

    public final JSFileCacheModel copy(String filePath, boolean fromOffline, long loadDuration) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return new JSFileCacheModel(filePath, fromOffline, loadDuration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JSFileCacheModel)) {
            return false;
        }
        JSFileCacheModel jSFileCacheModel = (JSFileCacheModel) other;
        return Intrinsics.areEqual(this.filePath, jSFileCacheModel.filePath) && this.fromOffline == jSFileCacheModel.fromOffline && this.loadDuration == jSFileCacheModel.loadDuration;
    }

    public int hashCode() {
        return (((this.filePath.hashCode() * 31) + Boolean.hashCode(this.fromOffline)) * 31) + Long.hashCode(this.loadDuration);
    }

    public String toString() {
        return "JSFileCacheModel(filePath=" + this.filePath + ", fromOffline=" + this.fromOffline + ", loadDuration=" + this.loadDuration + ')';
    }

    public JSFileCacheModel(String filePath, boolean z, long j) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.filePath = filePath;
        this.fromOffline = z;
        this.loadDuration = j;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final boolean getFromOffline() {
        return this.fromOffline;
    }

    public final long getLoadDuration() {
        return this.loadDuration;
    }
}
