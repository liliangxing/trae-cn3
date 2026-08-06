package com.bytedance.ies.argus.repository;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContainerConfigProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ0\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/argus/repository/AspectConfigInfo;", "", "cId", "", "config", "Lcom/bytedance/ies/argus/bean/AspectConfigItem;", "version", "", "(Ljava/lang/String;Lcom/bytedance/ies/argus/bean/AspectConfigItem;Ljava/lang/Long;)V", "getCId", "()Ljava/lang/String;", "getConfig", "()Lcom/bytedance/ies/argus/bean/AspectConfigItem;", "getVersion", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Lcom/bytedance/ies/argus/bean/AspectConfigItem;Ljava/lang/Long;)Lcom/bytedance/ies/argus/repository/AspectConfigInfo;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AspectConfigInfo {
    private final String cId;
    private final AspectConfigItem config;
    private final Long version;

    public static /* synthetic */ AspectConfigInfo copy$default(AspectConfigInfo aspectConfigInfo, String str, AspectConfigItem aspectConfigItem, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aspectConfigInfo.cId;
        }
        if ((i & 2) != 0) {
            aspectConfigItem = aspectConfigInfo.config;
        }
        if ((i & 4) != 0) {
            l = aspectConfigInfo.version;
        }
        return aspectConfigInfo.copy(str, aspectConfigItem, l);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCId() {
        return this.cId;
    }

    /* renamed from: component2, reason: from getter */
    public final AspectConfigItem getConfig() {
        return this.config;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getVersion() {
        return this.version;
    }

    public final AspectConfigInfo copy(String cId, AspectConfigItem config, Long version) {
        Intrinsics.checkNotNullParameter(cId, "cId");
        return new AspectConfigInfo(cId, config, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AspectConfigInfo)) {
            return false;
        }
        AspectConfigInfo aspectConfigInfo = (AspectConfigInfo) other;
        return Intrinsics.areEqual(this.cId, aspectConfigInfo.cId) && Intrinsics.areEqual(this.config, aspectConfigInfo.config) && Intrinsics.areEqual(this.version, aspectConfigInfo.version);
    }

    public int hashCode() {
        int hashCode = this.cId.hashCode() * 31;
        AspectConfigItem aspectConfigItem = this.config;
        int hashCode2 = (hashCode + (aspectConfigItem == null ? 0 : aspectConfigItem.hashCode())) * 31;
        Long l = this.version;
        return hashCode2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "AspectConfigInfo(cId=" + this.cId + ", config=" + this.config + ", version=" + this.version + ')';
    }

    public AspectConfigInfo(String cId, AspectConfigItem aspectConfigItem, Long l) {
        Intrinsics.checkNotNullParameter(cId, "cId");
        this.cId = cId;
        this.config = aspectConfigItem;
        this.version = l;
    }

    public /* synthetic */ AspectConfigInfo(String str, AspectConfigItem aspectConfigItem, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, aspectConfigItem, (i & 4) != 0 ? null : l);
    }

    public final String getCId() {
        return this.cId;
    }

    public final AspectConfigItem getConfig() {
        return this.config;
    }

    public final Long getVersion() {
        return this.version;
    }
}
