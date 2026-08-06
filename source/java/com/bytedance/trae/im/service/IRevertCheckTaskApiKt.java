package com.bytedance.trae.im.service;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.HttpDataResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: IRevertCheckTaskApi.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0002¨\u0006\u0004"}, d2 = {"toHttpResultPreservingBizError", "Lcom/bytedance/trae/network/response/HttpDataResult;", "T", "Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;", "im_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IRevertCheckTaskApiKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> HttpDataResult<T> toHttpResultPreservingBizError(TraeHttpConnection.RawBizCallResult<T> rawBizCallResult) {
        String str;
        HttpDataResult.Success result = rawBizCallResult.getResult();
        SsResponse ssResponse = rawBizCallResult.getSsResponse();
        Integer valueOf = ssResponse != null ? Integer.valueOf(ssResponse.code()) : null;
        if (!(result instanceof HttpDataResult.Success) || valueOf == null || valueOf.intValue() == 200) {
            return result;
        }
        HttpDataResult.Success success = result;
        int code = (int) success.getBizResp().getCode();
        String message = success.getBizResp().getMessage();
        if (message == null) {
            String msg = success.getBizResp().getMsg();
            if (msg == null) {
                msg = "Empty response body";
            }
            str = msg;
        } else {
            str = message;
        }
        return new HttpDataResult.Error<>(code, str, (Throwable) null, (String) null, 8, (DefaultConstructorMarker) null);
    }
}
