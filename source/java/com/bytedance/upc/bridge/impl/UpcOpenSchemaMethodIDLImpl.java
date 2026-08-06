package com.bytedance.upc.bridge.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.webkit.ProxyConfig;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.upc.Configuration;
import com.bytedance.upc.ILoaderService;
import com.bytedance.upc.bridge.abs.AbsUpcOpenSchemaMethodIDL;
import com.bytedance.upc.common.ICommonBusinessService;
import com.bytedance.upc.common.log.LogUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: UpcOpenSchemaMethodIDLImpl.kt */
@XBridgeMethod(name = "upc.openSchema", owner = "wanglijie.skin")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/upc/bridge/impl/UpcOpenSchemaMethodIDLImpl;", "Lcom/bytedance/upc/bridge/abs/AbsUpcOpenSchemaMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/upc/bridge/abs/AbsUpcOpenSchemaMethodIDL$UpcOpenSchemaParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/upc/bridge/abs/AbsUpcOpenSchemaMethodIDL$UpcOpenSchemaResultModel;", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class UpcOpenSchemaMethodIDLImpl extends AbsUpcOpenSchemaMethodIDL {
    public /* bridge */ /* synthetic */ void handle(IBDXBridgeContext iBDXBridgeContext, XBaseParamModel xBaseParamModel, CompletionBlock completionBlock) {
        handle(iBDXBridgeContext, (AbsUpcOpenSchemaMethodIDL.UpcOpenSchemaParamModel) xBaseParamModel, (CompletionBlock<AbsUpcOpenSchemaMethodIDL.UpcOpenSchemaResultModel>) completionBlock);
    }

    public void handle(IBDXBridgeContext bridgeContext, AbsUpcOpenSchemaMethodIDL.UpcOpenSchemaParamModel params, CompletionBlock<AbsUpcOpenSchemaMethodIDL.UpcOpenSchemaResultModel> callback) {
        Context context;
        Intrinsics.checkParameterIsNotNull(bridgeContext, "bridgeContext");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        LogUtils.i("AbsViewOpenMethodIDL");
        Configuration configuration = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration();
        Uri parse = Uri.parse(params.getUrl());
        if (StringsKt.contains$default(params.getUrl(), "upcsdk://upc.webview", false, 2, (Object) null)) {
            try {
                String queryParameter = parse.getQueryParameter(StreamTrafficObservable.STREAM_URL);
                if (queryParameter != null) {
                    Uri parse2 = Uri.parse(queryParameter);
                    Intrinsics.checkExpressionValueIsNotNull(parse2, "Uri.parse(it)");
                    if (Intrinsics.areEqual(parse2.getScheme(), ProxyConfig.MATCH_HTTPS)) {
                        ILoaderService iLoaderService = configuration.mILoaderService;
                        Intrinsics.checkExpressionValueIsNotNull(queryParameter, "it");
                        iLoaderService.load(queryParameter);
                        return;
                    }
                    return;
                }
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        if (StringsKt.contains$default(params.getUrl(), "upcsdk://upc.system", false, 2, (Object) null)) {
            try {
                if (parse.getQueryParameters("target") != null) {
                    String queryParameter2 = parse.getQueryParameter("package");
                    Intent intent = new Intent(parse.getQueryParameter(StrategyConstants.ACTION));
                    intent.setData(Uri.fromParts("package", queryParameter2, null));
                    View engineView = bridgeContext.getEngineView();
                    if (engineView == null || (context = engineView.getContext()) == null) {
                        return;
                    }
                    context.startActivity(intent);
                    return;
                }
                return;
            } catch (Throwable th) {
                LogUtils.e(th);
                return;
            }
        }
        try {
            configuration.mIOpenService.open(params.getUrl());
        } catch (Throwable th2) {
            LogUtils.e(th2);
        }
    }
}
