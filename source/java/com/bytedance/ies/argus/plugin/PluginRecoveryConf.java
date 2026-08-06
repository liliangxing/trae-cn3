package com.bytedance.ies.argus.plugin;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PluginManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/argus/plugin/PluginRecoveryConf;", "", "closeKey", "", "", "(Ljava/util/List;)V", "getCloseKey", "()Ljava/util/List;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PluginRecoveryConf {

    @SerializedName("close_key")
    private final List<String> closeKey;

    /* JADX WARN: Multi-variable type inference failed */
    public PluginRecoveryConf() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PluginRecoveryConf copy$default(PluginRecoveryConf pluginRecoveryConf, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = pluginRecoveryConf.closeKey;
        }
        return pluginRecoveryConf.copy(list);
    }

    public final List<String> component1() {
        return this.closeKey;
    }

    public final PluginRecoveryConf copy(List<String> closeKey) {
        return new PluginRecoveryConf(closeKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PluginRecoveryConf) && Intrinsics.areEqual(this.closeKey, ((PluginRecoveryConf) other).closeKey);
    }

    public int hashCode() {
        List<String> list = this.closeKey;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "PluginRecoveryConf(closeKey=" + this.closeKey + ')';
    }

    public PluginRecoveryConf(List<String> list) {
        this.closeKey = list;
    }

    public /* synthetic */ PluginRecoveryConf(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public final List<String> getCloseKey() {
        return this.closeKey;
    }
}
