package com.bytedance.ies.xbridge.base.runtime.depend;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.base.runtime.model.XReportADLogParams;
import com.bytedance.ies.xbridge.model.context.XContextProviderFactory;
import com.bytedance.ies.xbridge.utils.IXLogService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHostLogDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J2\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J(\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\t2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0013H&J&\u0010\u0014\u001a\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0016H&J-\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0018J-\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostLogDepend;", "", "getLogService", "Lcom/bytedance/ies/xbridge/utils/IXLogService;", "handleReportADLog", "", "contextProviderFactory", "Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;", "name", "", "params", "Lcom/bytedance/ies/xbridge/base/runtime/model/XReportADLogParams;", "callback", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IReportADLogResultCallback;", "type", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "onEventV3Map", SchemaConstants.INNER_PARAM_EVENT_NAME, "map", "", "putCommonParams", "isApi", "", "reportJSBError", "(Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;Ljava/util/Map;)Lkotlin/Unit;", "reportJSBFetchError", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IHostLogDepend {
    IXLogService getLogService();

    void handleReportADLog(XContextProviderFactory contextProviderFactory, String name, XReportADLogParams params, IReportADLogResultCallback callback, XBridgePlatformType type);

    void onEventV3Map(String eventName, Map<String, String> map);

    void putCommonParams(Map<String, String> params, boolean isApi);

    Unit reportJSBError(XContextProviderFactory contextProviderFactory, Map<String, ? extends Object> params);

    Unit reportJSBFetchError(XContextProviderFactory contextProviderFactory, Map<String, ? extends Object> params);

    /* compiled from: IHostLogDepend.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static IXLogService getLogService(IHostLogDepend iHostLogDepend) {
            return null;
        }

        public static Unit reportJSBError(IHostLogDepend iHostLogDepend, XContextProviderFactory xContextProviderFactory, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "params");
            return null;
        }

        public static Unit reportJSBFetchError(IHostLogDepend iHostLogDepend, XContextProviderFactory xContextProviderFactory, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "params");
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
