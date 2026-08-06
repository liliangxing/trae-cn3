package com.bytedance.ies.argus.plugin;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PluginManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/argus/plugin/ContainerPluginConf;", "", "secLink", "Lcom/bytedance/ies/argus/plugin/SecLinkPluginConfig;", "(Lcom/bytedance/ies/argus/plugin/SecLinkPluginConfig;)V", "getSecLink", "()Lcom/bytedance/ies/argus/plugin/SecLinkPluginConfig;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ContainerPluginConf {

    @SerializedName("sec_link")
    private final SecLinkPluginConfig secLink;

    /* JADX WARN: Multi-variable type inference failed */
    public ContainerPluginConf() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ContainerPluginConf copy$default(ContainerPluginConf containerPluginConf, SecLinkPluginConfig secLinkPluginConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            secLinkPluginConfig = containerPluginConf.secLink;
        }
        return containerPluginConf.copy(secLinkPluginConfig);
    }

    /* renamed from: component1, reason: from getter */
    public final SecLinkPluginConfig getSecLink() {
        return this.secLink;
    }

    public final ContainerPluginConf copy(SecLinkPluginConfig secLink) {
        return new ContainerPluginConf(secLink);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ContainerPluginConf) && Intrinsics.areEqual(this.secLink, ((ContainerPluginConf) other).secLink);
    }

    public int hashCode() {
        SecLinkPluginConfig secLinkPluginConfig = this.secLink;
        if (secLinkPluginConfig == null) {
            return 0;
        }
        return secLinkPluginConfig.hashCode();
    }

    public String toString() {
        return "ContainerPluginConf(secLink=" + this.secLink + ')';
    }

    public ContainerPluginConf(SecLinkPluginConfig secLinkPluginConfig) {
        this.secLink = secLinkPluginConfig;
    }

    public /* synthetic */ ContainerPluginConf(SecLinkPluginConfig secLinkPluginConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : secLinkPluginConfig);
    }

    public final SecLinkPluginConfig getSecLink() {
        return this.secLink;
    }
}
