package com.bytedance.android.anniex.pitaya;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PitayaModelInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/anniex/pitaya/PitayaModelInfo;", "", "name", "", "version", "engineType", "", "modelGroup", "originModelPath", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getEngineType", "()I", "getModelGroup", "()Ljava/lang/String;", "getName", "getOriginModelPath", "getVersion", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class PitayaModelInfo {
    private final int engineType;
    private final String modelGroup;
    private final String name;
    private final String originModelPath;
    private final String version;

    public static /* synthetic */ PitayaModelInfo copy$default(PitayaModelInfo pitayaModelInfo, String str, String str2, int i, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = pitayaModelInfo.name;
        }
        if ((i2 & 2) != 0) {
            str2 = pitayaModelInfo.version;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            i = pitayaModelInfo.engineType;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str3 = pitayaModelInfo.modelGroup;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = pitayaModelInfo.originModelPath;
        }
        return pitayaModelInfo.copy(str, str5, i3, str6, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component3, reason: from getter */
    public final int getEngineType() {
        return this.engineType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getModelGroup() {
        return this.modelGroup;
    }

    /* renamed from: component5, reason: from getter */
    public final String getOriginModelPath() {
        return this.originModelPath;
    }

    public final PitayaModelInfo copy(String name, String version, int engineType, String modelGroup, String originModelPath) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(version, "version");
        return new PitayaModelInfo(name, version, engineType, modelGroup, originModelPath);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PitayaModelInfo)) {
            return false;
        }
        PitayaModelInfo pitayaModelInfo = (PitayaModelInfo) other;
        return Intrinsics.areEqual(this.name, pitayaModelInfo.name) && Intrinsics.areEqual(this.version, pitayaModelInfo.version) && this.engineType == pitayaModelInfo.engineType && Intrinsics.areEqual(this.modelGroup, pitayaModelInfo.modelGroup) && Intrinsics.areEqual(this.originModelPath, pitayaModelInfo.originModelPath);
    }

    public int hashCode() {
        int hashCode = ((((this.name.hashCode() * 31) + this.version.hashCode()) * 31) + Integer.hashCode(this.engineType)) * 31;
        String str = this.modelGroup;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.originModelPath;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "PitayaModelInfo(name=" + this.name + ", version=" + this.version + ", engineType=" + this.engineType + ", modelGroup=" + this.modelGroup + ", originModelPath=" + this.originModelPath + ')';
    }

    public PitayaModelInfo(String name, String version, int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(version, "version");
        this.name = name;
        this.version = version;
        this.engineType = i;
        this.modelGroup = str;
        this.originModelPath = str2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getVersion() {
        return this.version;
    }

    public final int getEngineType() {
        return this.engineType;
    }

    public final String getModelGroup() {
        return this.modelGroup;
    }

    public final String getOriginModelPath() {
        return this.originModelPath;
    }
}
