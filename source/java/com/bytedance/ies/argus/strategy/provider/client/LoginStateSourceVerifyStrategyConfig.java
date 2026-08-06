package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.strategy.provider.BaseStrategyConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LoginStateSourceVerifyStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/LoginStateSourceVerifyStrategyConfig;", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyConfig;", "whiteUrlRegList", "", "", "whiteUrlPrefixList", "(Ljava/util/List;Ljava/util/List;)V", "getWhiteUrlPrefixList", "()Ljava/util/List;", "getWhiteUrlRegList", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LoginStateSourceVerifyStrategyConfig extends BaseStrategyConfig {

    @SerializedName("white_url_prefix")
    private final List<String> whiteUrlPrefixList;

    @SerializedName("white_url_reg")
    private final List<String> whiteUrlRegList;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LoginStateSourceVerifyStrategyConfig() {
        this(r0, r0, 3, r0);
        List list = null;
    }

    public /* synthetic */ LoginStateSourceVerifyStrategyConfig(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2);
    }

    public final List<String> getWhiteUrlRegList() {
        return this.whiteUrlRegList;
    }

    public final List<String> getWhiteUrlPrefixList() {
        return this.whiteUrlPrefixList;
    }

    public LoginStateSourceVerifyStrategyConfig(List<String> list, List<String> list2) {
        this.whiteUrlRegList = list;
        this.whiteUrlPrefixList = list2;
    }
}
