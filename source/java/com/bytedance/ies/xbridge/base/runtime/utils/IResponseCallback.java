package com.bytedance.ies.xbridge.base.runtime.utils;

import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.lynx.tasm.LynxError;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: XBridgeAPIRequestUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&¢\u0006\u0002\u0010\tJ]\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\f2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f`\u00102\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0013JK\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f`\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/utils/IResponseCallback;", "", "onFailed", "", "errorCode", "", LynxError.LYNX_THROWABLE, "", "clientCode", "(Ljava/lang/Integer;Ljava/lang/Throwable;I)V", "onParsingFailed", ReportConst.ValidationReport.BODY, "Lorg/json/JSONObject;", SlardarSettingsConsts.EXT_RESPONSE_HEADER, "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "rawResponse", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "(Lorg/json/JSONObject;Ljava/util/LinkedHashMap;Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/Integer;I)Lkotlin/Unit;", "onSuccess", "(Lorg/json/JSONObject;Ljava/util/LinkedHashMap;Ljava/lang/Integer;I)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IResponseCallback {

    /* compiled from: XBridgeAPIRequestUtils.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static Unit onParsingFailed(IResponseCallback iResponseCallback, JSONObject body, LinkedHashMap<String, String> responseHeader, String rawResponse, Throwable throwable, Integer num, int i) {
            Intrinsics.checkNotNullParameter(body, "body");
            Intrinsics.checkNotNullParameter(responseHeader, "responseHeader");
            Intrinsics.checkNotNullParameter(rawResponse, "rawResponse");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            return null;
        }
    }

    void onFailed(Integer errorCode, Throwable throwable, int clientCode);

    Unit onParsingFailed(JSONObject body, LinkedHashMap<String, String> responseHeader, String rawResponse, Throwable throwable, Integer statusCode, int clientCode);

    void onSuccess(JSONObject body, LinkedHashMap<String, String> responseHeader, Integer statusCode, int clientCode);
}
