package com.bytedance.trae.applog.impl;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.article.common.network.SSNetworkClient;
import com.bytedance.bdinstall.INetworkClient;
import com.bytedance.bdinstall.RangersHttpException;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultiInstanceAppLogServiceImpl.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0010H\u0096\u0002J2\u0010\u0011\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0010H\u0016J&\u0010\u0011\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0016J.\u0010\u0011\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u001a\u0010\u0016\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0018\u0018\u00010\u0017H\u0016J2\u0010\u0019\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0010H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/applog/impl/MultiInstanceAppLogNetworkClient;", "Lcom/bytedance/bdinstall/INetworkClient;", "<init>", "()V", "mClient", "Lcom/bytedance/article/common/network/SSNetworkClient;", "getMClient", "()Lcom/bytedance/article/common/network/SSNetworkClient;", "reqCtx", "Lcom/bytedance/common/utility/NetworkClient$ReqContext;", "getReqCtx", "()Lcom/bytedance/common/utility/NetworkClient$ReqContext;", ApiRequest.METHOD_GET, "", IWeixinService.ResponseConstants.URL, "requestHeaders", "", ApiRequest.METHOD_POST, "data", "", "bytes", "contentType", "params", "", "Landroid/util/Pair;", "postStream", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MultiInstanceAppLogNetworkClient implements INetworkClient {
    private final SSNetworkClient mClient = new SSNetworkClient();
    private final NetworkClient.ReqContext reqCtx;

    public MultiInstanceAppLogNetworkClient() {
        NetworkClient.ReqContext reqContext = new NetworkClient.ReqContext();
        this.reqCtx = reqContext;
        reqContext.addCommonParams = false;
    }

    public final SSNetworkClient getMClient() {
        return this.mClient;
    }

    public final NetworkClient.ReqContext getReqCtx() {
        return this.reqCtx;
    }

    public String get(String url, Map<String, String> requestHeaders) {
        try {
            HashMap hashMap = new HashMap();
            Pair buildBDNetworkTag = BDNetworkTagManager.getInstance().buildBDNetworkTag(new BDNetworkTagContextProviderAdapter() { // from class: com.bytedance.trae.applog.impl.MultiInstanceAppLogNetworkClient$get$tag$1
                public int triggerType() {
                    return 0;
                }
            });
            hashMap.put(buildBDNetworkTag.first, buildBDNetworkTag.second);
            if (requestHeaders == null) {
                requestHeaders = new LinkedHashMap();
            }
            Map mutableMap = MapsKt.toMutableMap(requestHeaders);
            Object obj = buildBDNetworkTag.first;
            Intrinsics.checkNotNullExpressionValue(obj, "first");
            Object obj2 = buildBDNetworkTag.second;
            Intrinsics.checkNotNullExpressionValue(obj2, "second");
            mutableMap.put(obj, obj2);
            String str = this.mClient.get(url, mutableMap, this.reqCtx);
            Intrinsics.checkNotNull(str);
            return str;
        } catch (Exception e) {
            if (e instanceof CommonHttpException) {
                throw new RangersHttpException(e.getResponseCode(), e.getCause());
            }
            throw new RangersHttpException(FConstants.DECOMPRESS_FAIL_CODE, e.getCause());
        }
    }

    public String post(String url, byte[] data, Map<String, String> requestHeaders) {
        try {
            HashMap hashMap = new HashMap();
            Pair buildBDNetworkTag = BDNetworkTagManager.getInstance().buildBDNetworkTag(new BDNetworkTagContextProviderAdapter() { // from class: com.bytedance.trae.applog.impl.MultiInstanceAppLogNetworkClient$post$tag$1
                public int triggerType() {
                    return 0;
                }
            });
            hashMap.put(buildBDNetworkTag.first, buildBDNetworkTag.second);
            if (requestHeaders == null) {
                requestHeaders = new LinkedHashMap();
            }
            Map mutableMap = MapsKt.toMutableMap(requestHeaders);
            Object obj = buildBDNetworkTag.first;
            Intrinsics.checkNotNullExpressionValue(obj, "first");
            Object obj2 = buildBDNetworkTag.second;
            Intrinsics.checkNotNullExpressionValue(obj2, "second");
            mutableMap.put(obj, obj2);
            String post = this.mClient.post(url, data, mutableMap, this.reqCtx);
            Intrinsics.checkNotNull(post);
            return post;
        } catch (CommonHttpException e) {
            throw new RangersHttpException(e.getResponseCode(), e.getCause());
        }
    }

    public String post(String url, byte[] bytes, String contentType) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(contentType)) {
            hashMap.put("Content-Type", contentType);
        }
        try {
            HashMap hashMap2 = new HashMap();
            Pair buildBDNetworkTag = BDNetworkTagManager.getInstance().buildBDNetworkTag(new BDNetworkTagContextProviderAdapter() { // from class: com.bytedance.trae.applog.impl.MultiInstanceAppLogNetworkClient$post$tag$2
                public int triggerType() {
                    return 0;
                }
            });
            hashMap2.put(buildBDNetworkTag.first, buildBDNetworkTag.second);
            Map mutableMap = MapsKt.toMutableMap(hashMap);
            Object obj = buildBDNetworkTag.first;
            Intrinsics.checkNotNullExpressionValue(obj, "first");
            mutableMap.put(obj, buildBDNetworkTag.second);
            String post = this.mClient.post(url, bytes, mutableMap, this.reqCtx);
            Intrinsics.checkNotNull(post);
            return post;
        } catch (CommonHttpException e) {
            throw new RangersHttpException(e.getResponseCode(), e.getCause());
        }
    }

    public String post(String url, List<Pair<String, String>> params) {
        String post = this.mClient.post(url, params);
        Intrinsics.checkNotNullExpressionValue(post, "post(...)");
        return post;
    }

    public byte[] postStream(String url, byte[] data, Map<String, String> requestHeaders) {
        try {
            HashMap hashMap = new HashMap();
            Pair buildBDNetworkTag = BDNetworkTagManager.getInstance().buildBDNetworkTag(new BDNetworkTagContextProviderAdapter() { // from class: com.bytedance.trae.applog.impl.MultiInstanceAppLogNetworkClient$postStream$tag$1
                public int triggerType() {
                    return 0;
                }
            });
            hashMap.put(buildBDNetworkTag.first, buildBDNetworkTag.second);
            if (requestHeaders == null) {
                requestHeaders = new LinkedHashMap();
            }
            Map mutableMap = MapsKt.toMutableMap(requestHeaders);
            Object obj = buildBDNetworkTag.first;
            Intrinsics.checkNotNullExpressionValue(obj, "first");
            Object obj2 = buildBDNetworkTag.second;
            Intrinsics.checkNotNullExpressionValue(obj2, "second");
            mutableMap.put(obj, obj2);
            byte[] postDataStream = this.mClient.postDataStream(url, data, mutableMap, this.reqCtx);
            Intrinsics.checkNotNull(postDataStream);
            return postDataStream;
        } catch (CommonHttpException e) {
            throw new RangersHttpException(e.getResponseCode(), e.getCause());
        }
    }
}
