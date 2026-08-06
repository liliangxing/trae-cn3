package com.bytedance.ies.argus.api.interfaces;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdturing.methods.JsCallParser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ArgusInitDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J3\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00030\u0007H&J;\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00030\u0007H&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/argus/api/interfaces/IArgusGeckoDepend;", "", "fetchResourceAsync", "", "url", "", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function1;", "Lcom/bytedance/ies/argus/api/interfaces/ArgusGeckoResponse;", "Lkotlin/ParameterName;", "name", ApmTrafficStats.TTNET_RESPONSE, "getBuiltinResource", "channel", "bundle", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public interface IArgusGeckoDepend {
    void fetchResourceAsync(String url, Function1<? super ArgusGeckoResponse, Unit> callback);

    void getBuiltinResource(String channel, String bundle, Function1<? super ArgusGeckoResponse, Unit> callback);
}
