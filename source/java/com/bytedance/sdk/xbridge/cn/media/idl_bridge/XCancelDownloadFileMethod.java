package com.bytedance.sdk.xbridge.cn.media.idl_bridge;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.media.idl.AbsXCancelDownloadFileMethodIDL;
import com.bytedance.sdk.xbridge.cn.media.utils.BdFileUtils;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.thread.ThreadUtils;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: XCancelDownloadFileMethod.kt */
@XBridgeMethod(name = "x.cancelDownloadFile")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/XCancelDownloadFileMethod;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXCancelDownloadFileMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXCancelDownloadFileMethodIDL$XCancelDownloadFileParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXCancelDownloadFileMethodIDL$XCancelDownloadFileResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XCancelDownloadFileMethod extends AbsXCancelDownloadFileMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, final AbsXCancelDownloadFileMethodIDL.XCancelDownloadFileParamModel params, final CompletionBlock<AbsXCancelDownloadFileMethodIDL.XCancelDownloadFileResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        View engineView = bridgeContext.getEngineView();
        final Context context = engineView != null ? engineView.getContext() : null;
        if (context == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Context not provided in host", null, 4, null);
            return;
        }
        boolean z = true;
        if (!(params.getUrl().length() == 0)) {
            String extension = params.getExtension();
            if (extension != null && extension.length() != 0) {
                z = false;
            }
            if (!z) {
                final String cacheDirAbsolutePath = BdFileUtils.getCacheDirAbsolutePath(context);
                if (cacheDirAbsolutePath == null) {
                    CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "cacheDir is null", null, 4, null);
                    return;
                } else {
                    RuntimeHelper.INSTANCE.getExecutorService(bridgeContext).execute(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XCancelDownloadFileMethod$handle$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            Downloader downloader = Downloader.getInstance(context);
                            int downloadId = downloader.getDownloadId(params.getUrl(), cacheDirAbsolutePath);
                            final boolean isDownloading = downloader.isDownloading(downloadId);
                            if (isDownloading) {
                                downloader.cancel(downloadId);
                            }
                            Handler mainThreadHandler = ThreadUtils.getMainThreadHandler();
                            final CompletionBlock<AbsXCancelDownloadFileMethodIDL.XCancelDownloadFileResultModel> completionBlock = callback;
                            mainThreadHandler.post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XCancelDownloadFileMethod$handle$1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    if (isDownloading) {
                                        CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXCancelDownloadFileMethodIDL.XCancelDownloadFileResultModel.class)), null, 2, null);
                                    } else {
                                        CompletionBlock.DefaultImpls.onFailure$default(completionBlock, 0, "no downloading task for current resource", null, 4, null);
                                    }
                                }
                            });
                        }
                    });
                    return;
                }
            }
        }
        CompletionBlock.DefaultImpls.onFailure$default(callback, -3, null, null, 6, null);
    }
}
