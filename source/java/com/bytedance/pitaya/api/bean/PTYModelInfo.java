package com.bytedance.pitaya.api.bean;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PTYModelInfo.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003JK\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006!"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYModelInfo;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "name", "", "version", "engineType", "", "modelGroup", "originModelPath", "extraParams", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEngineType", "()I", "getExtraParams", "()Ljava/lang/String;", "getModelGroup", "getName", "getOriginModelPath", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "Companion", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PTYModelInfo implements ReflectionCall {
    public static final int ENGINE_TYPE_BYTEDT = 2;
    public static final int ENGINE_TYPE_BYTENN = 1;
    public static final int ENGINE_TYPE_NONE = 0;
    public static final int ENGINE_TYPE_PYTORCH = 4;
    public static final int ENGINE_TYPE_TFLITE = 3;
    public static final int ENGINE_TYPE_TVM = 5;
    private final int engineType;
    private final String extraParams;
    private final String modelGroup;
    private final String name;
    private final String originModelPath;
    private final String version;

    public static /* synthetic */ PTYModelInfo copy$default(PTYModelInfo pTYModelInfo, String str, String str2, int i, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = pTYModelInfo.name;
        }
        if ((i2 & 2) != 0) {
            str2 = pTYModelInfo.version;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            i = pTYModelInfo.engineType;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str3 = pTYModelInfo.modelGroup;
        }
        String str7 = str3;
        if ((i2 & 16) != 0) {
            str4 = pTYModelInfo.originModelPath;
        }
        String str8 = str4;
        if ((i2 & 32) != 0) {
            str5 = pTYModelInfo.extraParams;
        }
        return pTYModelInfo.copy(str, str6, i3, str7, str8, str5);
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

    /* renamed from: component6, reason: from getter */
    public final String getExtraParams() {
        return this.extraParams;
    }

    public final PTYModelInfo copy(String name, String version, int engineType, String modelGroup, String originModelPath, String extraParams) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(version, "version");
        return new PTYModelInfo(name, version, engineType, modelGroup, originModelPath, extraParams);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PTYModelInfo)) {
            return false;
        }
        PTYModelInfo pTYModelInfo = (PTYModelInfo) other;
        return Intrinsics.areEqual(this.name, pTYModelInfo.name) && Intrinsics.areEqual(this.version, pTYModelInfo.version) && this.engineType == pTYModelInfo.engineType && Intrinsics.areEqual(this.modelGroup, pTYModelInfo.modelGroup) && Intrinsics.areEqual(this.originModelPath, pTYModelInfo.originModelPath) && Intrinsics.areEqual(this.extraParams, pTYModelInfo.extraParams);
    }

    public int hashCode() {
        int hashCode = ((((this.name.hashCode() * 31) + this.version.hashCode()) * 31) + Integer.hashCode(this.engineType)) * 31;
        String str = this.modelGroup;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.originModelPath;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.extraParams;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "PTYModelInfo(name=" + this.name + ", version=" + this.version + ", engineType=" + this.engineType + ", modelGroup=" + this.modelGroup + ", originModelPath=" + this.originModelPath + ", extraParams=" + this.extraParams + ')';
    }

    public PTYModelInfo(String name, String version, int i, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(version, "version");
        this.name = name;
        this.version = version;
        this.engineType = i;
        this.modelGroup = str;
        this.originModelPath = str2;
        this.extraParams = str3;
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

    public final String getExtraParams() {
        return this.extraParams;
    }
}
