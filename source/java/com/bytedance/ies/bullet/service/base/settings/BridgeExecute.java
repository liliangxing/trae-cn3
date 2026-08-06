package com.bytedance.ies.bullet.service.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: CommonConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/settings/BridgeExecute;", "", "()V", "bridgeAsyncExecute", "", "getBridgeAsyncExecute", "()I", "setBridgeAsyncExecute", "(I)V", "bridgeAsyncExecuteList", "", "", "getBridgeAsyncExecuteList", "()Ljava/util/List;", "setBridgeAsyncExecuteList", "(Ljava/util/List;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class BridgeExecute {

    @SerializedName("bridge_execute_strategy")
    private int bridgeAsyncExecute;

    @SerializedName("bridge_async_execute_list")
    private List<String> bridgeAsyncExecuteList = new ArrayList();

    public final int getBridgeAsyncExecute() {
        return this.bridgeAsyncExecute;
    }

    public final void setBridgeAsyncExecute(int i) {
        this.bridgeAsyncExecute = i;
    }

    public final List<String> getBridgeAsyncExecuteList() {
        return this.bridgeAsyncExecuteList;
    }

    public final void setBridgeAsyncExecuteList(List<String> list) {
        this.bridgeAsyncExecuteList = list;
    }
}
