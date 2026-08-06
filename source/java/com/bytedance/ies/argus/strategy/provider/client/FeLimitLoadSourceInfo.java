package com.bytedance.ies.argus.strategy.provider.client;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LynxLoadWhiteListStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/FeLimitLoadSourceInfo;", "", "cidList", "", "", "onlyVerifyMainTemplate", "", "(Ljava/util/List;Z)V", "getCidList", "()Ljava/util/List;", "getOnlyVerifyMainTemplate", "()Z", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class FeLimitLoadSourceInfo {

    @SerializedName("cid_list")
    private final List<String> cidList;

    @SerializedName("only_verify_main_template")
    private final boolean onlyVerifyMainTemplate;

    /* JADX WARN: Multi-variable type inference failed */
    public FeLimitLoadSourceInfo() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public FeLimitLoadSourceInfo(List<String> list, boolean z) {
        this.cidList = list;
        this.onlyVerifyMainTemplate = z;
    }

    public /* synthetic */ FeLimitLoadSourceInfo(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? true : z);
    }

    public final List<String> getCidList() {
        return this.cidList;
    }

    public final boolean getOnlyVerifyMainTemplate() {
        return this.onlyVerifyMainTemplate;
    }
}
