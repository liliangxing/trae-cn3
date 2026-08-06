package com.bytedance.ies.argus.repository;

import com.bytedance.forest.model.PreloadConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContainerConfigProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B3\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/argus/repository/ContainerConfigModel;", "Lcom/bytedance/ies/argus/repository/BaseRemoteConfig;", "conf", "", "", "Lcom/bytedance/ies/argus/repository/ContainerConfigItem;", "from", "Lcom/bytedance/ies/argus/repository/ArgusGeckoFetchType;", "version", "(Ljava/util/Map;Lcom/bytedance/ies/argus/repository/ArgusGeckoFetchType;Ljava/lang/String;)V", "getConf", "()Ljava/util/Map;", "getFrom", "()Lcom/bytedance/ies/argus/repository/ArgusGeckoFetchType;", "getVersion", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final /* data */ class ContainerConfigModel extends BaseRemoteConfig {
    private final Map<String, ContainerConfigItem> conf;
    private final ArgusGeckoFetchType from;
    private final String version;

    public ContainerConfigModel() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ContainerConfigModel copy$default(ContainerConfigModel containerConfigModel, Map map, ArgusGeckoFetchType argusGeckoFetchType, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            map = containerConfigModel.conf;
        }
        if ((i & 2) != 0) {
            argusGeckoFetchType = containerConfigModel.from;
        }
        if ((i & 4) != 0) {
            str = containerConfigModel.version;
        }
        return containerConfigModel.copy(map, argusGeckoFetchType, str);
    }

    public final Map<String, ContainerConfigItem> component1() {
        return this.conf;
    }

    /* renamed from: component2, reason: from getter */
    public final ArgusGeckoFetchType getFrom() {
        return this.from;
    }

    /* renamed from: component3, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final ContainerConfigModel copy(Map<String, ContainerConfigItem> conf, ArgusGeckoFetchType from, String version) {
        Intrinsics.checkNotNullParameter(conf, "conf");
        return new ContainerConfigModel(conf, from, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContainerConfigModel)) {
            return false;
        }
        ContainerConfigModel containerConfigModel = (ContainerConfigModel) other;
        return Intrinsics.areEqual(this.conf, containerConfigModel.conf) && this.from == containerConfigModel.from && Intrinsics.areEqual(this.version, containerConfigModel.version);
    }

    public int hashCode() {
        int hashCode = this.conf.hashCode() * 31;
        ArgusGeckoFetchType argusGeckoFetchType = this.from;
        int hashCode2 = (hashCode + (argusGeckoFetchType == null ? 0 : argusGeckoFetchType.hashCode())) * 31;
        String str = this.version;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ContainerConfigModel(conf=" + this.conf + ", from=" + this.from + ", version=" + this.version + ')';
    }

    public /* synthetic */ ContainerConfigModel(Map map, ArgusGeckoFetchType argusGeckoFetchType, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map, (i & 2) != 0 ? null : argusGeckoFetchType, (i & 4) != 0 ? null : str);
    }

    public final Map<String, ContainerConfigItem> getConf() {
        return this.conf;
    }

    public final ArgusGeckoFetchType getFrom() {
        return this.from;
    }

    public final String getVersion() {
        return this.version;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContainerConfigModel(Map<String, ContainerConfigItem> map, ArgusGeckoFetchType argusGeckoFetchType, String str) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(map, "conf");
        this.conf = map;
        this.from = argusGeckoFetchType;
        this.version = str;
    }
}
