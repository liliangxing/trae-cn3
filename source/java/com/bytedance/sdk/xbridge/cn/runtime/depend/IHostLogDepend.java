package com.bytedance.sdk.xbridge.cn.runtime.depend;

import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.runtime.model.XReportADLogParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHostLogDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J(\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00072\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000fH&J&\u0010\u0010\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H&J-\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0014J-\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostLogDepend;", "", "handleReportADLog", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "name", "", "params", "Lcom/bytedance/sdk/xbridge/cn/runtime/model/XReportADLogParams;", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IReportADLogResultCallback;", "onEventV3Map", SchemaConstants.INNER_PARAM_EVENT_NAME, "map", "", "putCommonParams", "isApi", "", "reportJSBError", "(Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;Ljava/util/Map;)Lkotlin/Unit;", "reportJSBFetchError", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IHostLogDepend {
    void handleReportADLog(IBDXBridgeContext bridgeContext, String name, XReportADLogParams params, IReportADLogResultCallback callback);

    void onEventV3Map(String eventName, Map<String, String> map);

    void putCommonParams(Map<String, String> params, boolean isApi);

    Unit reportJSBError(IBDXBridgeContext bridgeContext, Map<String, ? extends Object> params);

    Unit reportJSBFetchError(IBDXBridgeContext bridgeContext, Map<String, ? extends Object> params);

    /* compiled from: IHostLogDepend.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static Unit reportJSBError(IHostLogDepend iHostLogDepend, IBDXBridgeContext iBDXBridgeContext, Map<String, ? extends Object> params) {
            Intrinsics.checkNotNullParameter(params, "params");
            return null;
        }

        public static Unit reportJSBFetchError(IHostLogDepend iHostLogDepend, IBDXBridgeContext iBDXBridgeContext, Map<String, ? extends Object> params) {
            Intrinsics.checkNotNullParameter(params, "params");
            return null;
        }

        public static /* synthetic */ void putCommonParams$default(IHostLogDepend iHostLogDepend, Map map, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: putCommonParams");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            iHostLogDepend.putCommonParams(map, z);
        }
    }
}
