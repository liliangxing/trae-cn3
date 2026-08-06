package com.bytedance.ies.argus.strategy.provider.client;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LynxSSRUrlVerifyStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/LynxSSRUrlVerifyStrategyConfig;", "", "allowHostList", "", "", "allowRegList", "(Ljava/util/List;Ljava/util/List;)V", "getAllowHostList", "()Ljava/util/List;", "getAllowRegList", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class LynxSSRUrlVerifyStrategyConfig {

    @SerializedName("allow_host_list")
    private final List<String> allowHostList;

    @SerializedName("allow_regex_list")
    private final List<String> allowRegList;

    /* JADX WARN: Multi-variable type inference failed */
    public LynxSSRUrlVerifyStrategyConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public LynxSSRUrlVerifyStrategyConfig(List<String> list, List<String> list2) {
        this.allowHostList = list;
        this.allowRegList = list2;
    }

    public /* synthetic */ LynxSSRUrlVerifyStrategyConfig(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
    }

    public final List<String> getAllowHostList() {
        return this.allowHostList;
    }

    public final List<String> getAllowRegList() {
        return this.allowRegList;
    }
}
