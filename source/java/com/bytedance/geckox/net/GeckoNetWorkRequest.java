package com.bytedance.geckox.net;

import com.bytedance.geckox.buffer.stream.BufferOutputStream;
import com.bytedance.iesgurd.meta.PrepareMeta;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeckoNetWorkRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000eJ4\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/geckox/net/GeckoNetWorkRequest;", "", "()V", "requestWithDownloadFile", "", "netWork", "Lcom/bytedance/geckox/net/INetWork;", "url", "", "outputStream", "Lcom/bytedance/geckox/buffer/stream/BufferOutputStream;", "updatePackage", "Lcom/bytedance/iesgurd/meta/PrepareMeta;", "headers", "", "requestWithMethodPost", "Lcom/bytedance/geckox/net/Response;", "requestBody", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GeckoNetWorkRequest {
    public static final GeckoNetWorkRequest INSTANCE = new GeckoNetWorkRequest();

    private GeckoNetWorkRequest() {
    }

    public final Response requestWithMethodPost(INetWork netWork, String url, String requestBody, Map<String, String> headers) throws Exception {
        Intrinsics.checkParameterIsNotNull(netWork, "netWork");
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(requestBody, "requestBody");
        if ((netWork instanceof IExtendNetWork) && headers != null) {
            Response doPost = ((IExtendNetWork) netWork).doPost(url, requestBody, headers);
            Intrinsics.checkExpressionValueIsNotNull(doPost, "netWork.doPost(url, requestBody, headers)");
            return doPost;
        }
        Response doPost2 = netWork.doPost(url, requestBody);
        Intrinsics.checkExpressionValueIsNotNull(doPost2, "netWork.doPost(url, requestBody)");
        return doPost2;
    }

    public final void requestWithDownloadFile(INetWork netWork, String url, BufferOutputStream outputStream, PrepareMeta updatePackage, Map<String, String> headers) throws Exception {
        Intrinsics.checkParameterIsNotNull(netWork, "netWork");
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(outputStream, "outputStream");
        Intrinsics.checkParameterIsNotNull(updatePackage, "updatePackage");
        if ((netWork instanceof IExtendNetWork) && headers != null) {
            ((IExtendNetWork) netWork).downloadFile(url, updatePackage.getPackage().getLength(), outputStream, headers);
        } else {
            netWork.downloadFile(url, updatePackage.getPackage().getLength(), outputStream);
        }
    }
}
