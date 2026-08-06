package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.webx.addr.AddressParam;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: UploadFileVerifyStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/RegexConfig;", "", AddressParam.SETTING_BDWK_EXTENSION_PATTERN, "", "blockEntryList", "", "(Ljava/lang/String;Ljava/util/List;)V", "getBlockEntryList", "()Ljava/util/List;", "getPattern", "()Ljava/lang/String;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class RegexConfig {

    @SerializedName("block_entry_list")
    private final List<String> blockEntryList;

    @SerializedName(AddressParam.SETTING_BDWK_EXTENSION_PATTERN)
    private final String pattern;

    /* JADX WARN: Multi-variable type inference failed */
    public RegexConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public RegexConfig(String str, List<String> list) {
        this.pattern = str;
        this.blockEntryList = list;
    }

    public /* synthetic */ RegexConfig(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list);
    }

    public final String getPattern() {
        return this.pattern;
    }

    public final List<String> getBlockEntryList() {
        return this.blockEntryList;
    }
}
