package com.bytedance.sdk.xbridge.cn.network;

import android.util.Log;
import com.bytedance.ies.bullet.prefetchv2.PrefetchResult;
import com.bytedance.sdk.xbridge.cn.network.AbsXRequestMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* compiled from: XRequestMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"toResultModel", "Lcom/bytedance/sdk/xbridge/cn/network/AbsXRequestMethodIDL$XRequestResultModel;", "result", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchResult;", "prefetchStatus", "", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XRequestMethodKt {
    public static final AbsXRequestMethodIDL.XRequestResultModel toResultModel(PrefetchResult prefetchResult, Number number) {
        Intrinsics.checkNotNullParameter(prefetchResult, "result");
        Intrinsics.checkNotNullParameter(number, "prefetchStatus");
        AbsXRequestMethodIDL.XRequestResultModel xRequestResultModel = (AbsXRequestMethodIDL.XRequestResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXRequestMethodIDL.XRequestResultModel.class));
        xRequestResultModel.setHttpCode(prefetchResult.getHttpCode());
        xRequestResultModel.setClientCode(prefetchResult.getClientCode());
        xRequestResultModel.setHeader(prefetchResult.getHeader());
        xRequestResultModel.setPrefetchStatus(number);
        try {
            ConvertUtils convertUtils = ConvertUtils.INSTANCE;
            JSONObject body = prefetchResult.getBody();
            if (body == null) {
                body = new JSONObject();
            }
            xRequestResultModel.setResponse(convertUtils.jsonToMap(body));
        } catch (Throwable th) {
            Log.e(XRequestMethod.INSTANCE.getTAG(), "parse response body failed", th);
        }
        return xRequestResultModel;
    }
}
