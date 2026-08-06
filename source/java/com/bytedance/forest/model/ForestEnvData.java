package com.bytedance.forest.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForestEnv.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/forest/model/ForestEnvData;", "", "type", "Lcom/bytedance/forest/model/ForestEnvType;", "name", "", "(Lcom/bytedance/forest/model/ForestEnvType;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getType", "()Lcom/bytedance/forest/model/ForestEnvType;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final /* data */ class ForestEnvData {
    private final String name;
    private final ForestEnvType type;

    public static /* synthetic */ ForestEnvData copy$default(ForestEnvData forestEnvData, ForestEnvType forestEnvType, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            forestEnvType = forestEnvData.type;
        }
        if ((i & 2) != 0) {
            str = forestEnvData.name;
        }
        return forestEnvData.copy(forestEnvType, str);
    }

    /* renamed from: component1, reason: from getter */
    public final ForestEnvType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final ForestEnvData copy(ForestEnvType type, String name) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(name, "name");
        return new ForestEnvData(type, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForestEnvData)) {
            return false;
        }
        ForestEnvData forestEnvData = (ForestEnvData) other;
        return Intrinsics.areEqual(this.type, forestEnvData.type) && Intrinsics.areEqual(this.name, forestEnvData.name);
    }

    public int hashCode() {
        ForestEnvType forestEnvType = this.type;
        int hashCode = (forestEnvType != null ? forestEnvType.hashCode() : 0) * 31;
        String str = this.name;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ForestEnvData(type=" + this.type + ", name=" + this.name + ")";
    }

    public ForestEnvData(ForestEnvType type, String name) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(name, "name");
        this.type = type;
        this.name = name;
    }

    public final String getName() {
        return this.name;
    }

    public final ForestEnvType getType() {
        return this.type;
    }
}
