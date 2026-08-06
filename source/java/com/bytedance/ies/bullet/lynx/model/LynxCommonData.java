package com.bytedance.ies.bullet.lynx.model;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxCommonData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/model/LynxCommonData;", "", "containerID", "", SchemaConstants.INNER_PARAM_PROTOCOL_VERSION, "(Ljava/lang/String;Ljava/lang/String;)V", "getContainerID", "()Ljava/lang/String;", "getProtocolVersion", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LynxCommonData {
    private final String containerID;
    private final String protocolVersion;

    public static /* synthetic */ LynxCommonData copy$default(LynxCommonData lynxCommonData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = lynxCommonData.containerID;
        }
        if ((i & 2) != 0) {
            str2 = lynxCommonData.protocolVersion;
        }
        return lynxCommonData.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getContainerID() {
        return this.containerID;
    }

    /* renamed from: component2, reason: from getter */
    public final String getProtocolVersion() {
        return this.protocolVersion;
    }

    public final LynxCommonData copy(String containerID, String protocolVersion) {
        Intrinsics.checkNotNullParameter(containerID, "containerID");
        Intrinsics.checkNotNullParameter(protocolVersion, "protocolVersion");
        return new LynxCommonData(containerID, protocolVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LynxCommonData)) {
            return false;
        }
        LynxCommonData lynxCommonData = (LynxCommonData) other;
        return Intrinsics.areEqual(this.containerID, lynxCommonData.containerID) && Intrinsics.areEqual(this.protocolVersion, lynxCommonData.protocolVersion);
    }

    public int hashCode() {
        return (this.containerID.hashCode() * 31) + this.protocolVersion.hashCode();
    }

    public String toString() {
        return "LynxCommonData(containerID=" + this.containerID + ", protocolVersion=" + this.protocolVersion + ')';
    }

    public LynxCommonData(String containerID, String protocolVersion) {
        Intrinsics.checkNotNullParameter(containerID, "containerID");
        Intrinsics.checkNotNullParameter(protocolVersion, "protocolVersion");
        this.containerID = containerID;
        this.protocolVersion = protocolVersion;
    }

    public /* synthetic */ LynxCommonData(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "1.0" : str2);
    }

    public final String getContainerID() {
        return this.containerID;
    }

    public final String getProtocolVersion() {
        return this.protocolVersion;
    }
}
