package com.bytedance.sdk.xbridge.cn.media.idl_bridge;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.bytedance.ies.bullet.kit.web.download.WebResourceDownloader;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.auth.SecurityContextUtils;
import com.bytedance.sdk.xbridge.cn.media.idl.AbsXDownloadFileMethodIDL;
import com.bytedance.sdk.xbridge.cn.media.utils.BdFileUtils;
import com.bytedance.sdk.xbridge.cn.media.utils.Md5Utils;
import com.bytedance.sdk.xbridge.cn.media.utils.MediaUtils;
import com.bytedance.sdk.xbridge.cn.media.utils.XBridgePermissionUtils;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PermissionState;
import com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection;
import com.bytedance.sdk.xbridge.cn.runtime.thread.ThreadUtils;
import com.bytedance.sdk.xbridge.cn.runtime.utils.IStreamResponseCallback;
import com.bytedance.sdk.xbridge.cn.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeMethodHelper;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadStartCallback;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XDownloadFileMethod.kt */
@XBridgeMethod(name = "x.downloadFile")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J.\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002JF\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002¨\u0006\u001b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/XDownloadFileMethod;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXDownloadFileMethodIDL;", "()V", "getPermissionDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostPermissionDepend;", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "getXSecurityArgusHeaderForDownloader", "", "Lcom/ss/android/socialbase/downloader/model/HttpHeader;", "handle", "", "params", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXDownloadFileMethodIDL$XDownloadFileParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXDownloadFileMethodIDL$XDownloadFileResultModel;", "handleDownloadFile", "context", "Landroid/content/Context;", "downloadParams", "handleDownloadFileInProgress", "fileName", "", "savePath", "filePath", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XDownloadFileMethod extends AbsXDownloadFileMethodIDL {
    private static final String DOWNLOAD_EVENT_FIELD_EXTENSION = "extension";
    private static final String DOWNLOAD_EVENT_FIELD_PROGRESS = "progress";
    private static final String DOWNLOAD_EVENT_FIELD_URL = "url";
    private static final String DOWNLOAD_EVENT_NAME = "x.onDownloadProgress";
    private static final String DOWNLOAD_SCENE = "XBridge";

    private final IHostPermissionDepend getPermissionDependInstance(IBDXBridgeContext bridgeContext) {
        return RuntimeHelper.INSTANCE.getPermissionDependInstance(bridgeContext);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(final IBDXBridgeContext bridgeContext, final AbsXDownloadFileMethodIDL.XDownloadFileParamModel params, final CompletionBlock<AbsXDownloadFileMethodIDL.XDownloadFileResultModel> callback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Context not provided in host", null, 4, null);
            return;
        }
        Activity activity = ownerActivity;
        Activity activity2 = XBridgeMethodHelper.INSTANCE.getActivity(activity);
        if (activity2 == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "context can not convert to activity", null, 4, null);
            return;
        }
        boolean z = true;
        boolean z2 = false;
        if (!(params.getUrl().length() == 0)) {
            String extension = params.getExtension();
            if (extension != null && extension.length() != 0) {
                z = false;
            }
            if (!z) {
                IHostPermissionDepend permissionDependInstance = getPermissionDependInstance(bridgeContext);
                if (permissionDependInstance != null) {
                    String[] readAndWriteExternalStorageForAllTypeWithArray = XBridgePermissionUtils.INSTANCE.getReadAndWriteExternalStorageForAllTypeWithArray();
                    z2 = permissionDependInstance.isPermissionAllGranted(activity2, (String[]) Arrays.copyOf(readAndWriteExternalStorageForAllTypeWithArray, readAndWriteExternalStorageForAllTypeWithArray.length));
                }
                if (z2 || MediaUtils.INSTANCE.fixBridgeStorageAboveAndroidQ()) {
                    handleDownloadFile(bridgeContext, activity, params, callback);
                    return;
                }
                IHostPermissionDepend permissionDependInstance2 = getPermissionDependInstance(bridgeContext);
                if (permissionDependInstance2 != null) {
                    String name = getName();
                    String[] readAndWriteExternalStorageForAllTypeWithArray2 = XBridgePermissionUtils.INSTANCE.getReadAndWriteExternalStorageForAllTypeWithArray();
                    permissionDependInstance2.requestPermission(activity2, bridgeContext, name, (String[]) Arrays.copyOf(readAndWriteExternalStorageForAllTypeWithArray2, readAndWriteExternalStorageForAllTypeWithArray2.length), new OnPermissionCallback() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XDownloadFileMethod$handle$1
                        @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback
                        public void onResult(boolean allGranted, Map<String, ? extends PermissionState> result) {
                            Intrinsics.checkNotNullParameter(result, "result");
                            if (allGranted) {
                                XDownloadFileMethod.this.handleDownloadFile(bridgeContext, ownerActivity, params, callback);
                            } else {
                                CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "request permission denied", null, 4, null);
                            }
                        }
                    });
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "DownloadFileDepend is null", null, 4, null);
                    return;
                }
                return;
            }
        }
        CompletionBlock.DefaultImpls.onFailure$default(callback, -3, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleDownloadFile(final IBDXBridgeContext bridgeContext, final Context context, final AbsXDownloadFileMethodIDL.XDownloadFileParamModel downloadParams, final CompletionBlock<AbsXDownloadFileMethodIDL.XDownloadFileResultModel> callback) {
        final String str = (Md5Utils.INSTANCE.hexDigest(downloadParams.getUrl()) + System.currentTimeMillis()) + '.' + downloadParams.getExtension();
        final String cacheDirAbsolutePath = BdFileUtils.getCacheDirAbsolutePath(context);
        if (cacheDirAbsolutePath == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "cacheDir is null", null, 4, null);
            return;
        }
        final String str2 = cacheDirAbsolutePath + '/' + str;
        if (new File(str2).exists()) {
            ThreadUtils.getMainThreadHandler().post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XDownloadFileMethod$handleDownloadFile$1
                @Override // java.lang.Runnable
                public final void run() {
                    CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "file path already exist", null, 4, null);
                }
            });
        } else if (IConditionCallKt.switchBridgeDownloadToDownloader()) {
            RuntimeHelper.INSTANCE.getExecutorService(bridgeContext).execute(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XDownloadFileMethod$handleDownloadFile$2
                @Override // java.lang.Runnable
                public final void run() {
                    XDownloadFileMethod.this.handleDownloadFileInProgress(bridgeContext, context, downloadParams, callback, str, cacheDirAbsolutePath, str2);
                }
            });
        } else {
            RuntimeHelper.INSTANCE.getExecutorService(bridgeContext).execute(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XDownloadFileMethod$handleDownloadFile$3
                @Override // java.lang.Runnable
                public final void run() {
                    String addParametersToUrl$default = XBridgeAPIRequestUtils.addParametersToUrl$default(XBridgeAPIRequestUtils.INSTANCE, AbsXDownloadFileMethodIDL.XDownloadFileParamModel.this.getUrl(), AbsXDownloadFileMethodIDL.XDownloadFileParamModel.this.getParams(), bridgeContext.getPlatformType(), false, 8, null);
                    LinkedHashMap<String, String> filterHeaderEmptyValue = XBridgeAPIRequestUtils.INSTANCE.filterHeaderEmptyValue(AbsXDownloadFileMethodIDL.XDownloadFileParamModel.this.getHeader());
                    XBridgeAPIRequestUtils.INSTANCE.addXSecurityArgusHeader(filterHeaderEmptyValue, bridgeContext);
                    final String str3 = str2;
                    final AbsXDownloadFileMethodIDL.XDownloadFileParamModel xDownloadFileParamModel = AbsXDownloadFileMethodIDL.XDownloadFileParamModel.this;
                    final Context context2 = context;
                    final CompletionBlock<AbsXDownloadFileMethodIDL.XDownloadFileResultModel> completionBlock = callback;
                    IStreamResponseCallback iStreamResponseCallback = new IStreamResponseCallback() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XDownloadFileMethod$handleDownloadFile$3$responseCallback$1
                        /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
                        
                            if ((r0.length() > 0) != false) goto L25;
                         */
                        /* JADX WARN: Removed duplicated region for block: B:67:0x0134 A[Catch: IOException -> 0x013d, TryCatch #6 {IOException -> 0x013d, blocks: (B:65:0x012f, B:67:0x0134, B:69:0x0139), top: B:64:0x012f }] */
                        /* JADX WARN: Removed duplicated region for block: B:69:0x0139 A[Catch: IOException -> 0x013d, TRY_LEAVE, TryCatch #6 {IOException -> 0x013d, blocks: (B:65:0x012f, B:67:0x0134, B:69:0x0139), top: B:64:0x012f }] */
                        @Override // com.bytedance.sdk.xbridge.cn.runtime.utils.IStreamResponseCallback
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void handleConnection(AbsStreamConnection connection) {
                            BufferedOutputStream bufferedOutputStream;
                            BufferedInputStream bufferedInputStream;
                            if (connection == null) {
                                Handler mainThreadHandler = ThreadUtils.getMainThreadHandler();
                                final CompletionBlock<AbsXDownloadFileMethodIDL.XDownloadFileResultModel> completionBlock2 = completionBlock;
                                mainThreadHandler.post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XDownloadFileMethod$handleDownloadFile$3$responseCallback$1$handleConnection$1
                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        CompletionBlock<AbsXDownloadFileMethodIDL.XDownloadFileResultModel> completionBlock3 = completionBlock2;
                                        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXDownloadFileMethodIDL.XDownloadFileResultModel.class));
                                        AbsXDownloadFileMethodIDL.XDownloadFileResultModel xDownloadFileResultModel = (AbsXDownloadFileMethodIDL.XDownloadFileResultModel) createXModel;
                                        xDownloadFileResultModel.setHttpCode((Number) 0);
                                        xDownloadFileResultModel.setClientCode((Number) 0);
                                        xDownloadFileResultModel.setFilePath("");
                                        Unit unit = Unit.INSTANCE;
                                        completionBlock3.onFailure(0, "connection failed", (XBaseResultModel) createXModel);
                                    }
                                });
                                return;
                            }
                            final String errorMsg = connection.getErrorMsg();
                            BufferedInputStream bufferedInputStream2 = null;
                            if (!(errorMsg.length() > 0)) {
                                errorMsg = null;
                            }
                            if (errorMsg == null) {
                                Throwable exception = connection.getException();
                                if (exception != null && (errorMsg = exception.getMessage()) != null) {
                                }
                                errorMsg = null;
                            }
                            InputStream inputStreamResponseBody = connection.getInputStreamResponseBody();
                            final int responseCode = connection.getResponseCode();
                            final Integer clientCode = connection.getClientCode();
                            if (inputStreamResponseBody == null) {
                                Handler mainThreadHandler2 = ThreadUtils.getMainThreadHandler();
                                final CompletionBlock<AbsXDownloadFileMethodIDL.XDownloadFileResultModel> completionBlock3 = completionBlock;
                                mainThreadHandler2.post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XDownloadFileMethod$handleDownloadFile$3$responseCallback$1$handleConnection$2
                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        Object obj;
                                        Object obj2;
                                        CompletionBlock<AbsXDownloadFileMethodIDL.XDownloadFileResultModel> completionBlock4 = completionBlock3;
                                        String str4 = errorMsg;
                                        if (str4 == null) {
                                            str4 = "body is null";
                                        }
                                        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXDownloadFileMethodIDL.XDownloadFileResultModel.class));
                                        int i = responseCode;
                                        Integer num = clientCode;
                                        AbsXDownloadFileMethodIDL.XDownloadFileResultModel xDownloadFileResultModel = (AbsXDownloadFileMethodIDL.XDownloadFileResultModel) createXModel;
                                        try {
                                            Result.Companion companion = Result.Companion;
                                            obj = Result.constructor-impl(Integer.valueOf(i));
                                        } catch (Throwable th) {
                                            Result.Companion companion2 = Result.Companion;
                                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                                        }
                                        if (Result.isFailure-impl(obj)) {
                                            obj = 0;
                                        }
                                        xDownloadFileResultModel.setHttpCode((Number) obj);
                                        try {
                                            Result.Companion companion3 = Result.Companion;
                                            obj2 = Result.constructor-impl(num);
                                        } catch (Throwable th2) {
                                            Result.Companion companion4 = Result.Companion;
                                            obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
                                        }
                                        if (Result.isFailure-impl(obj2)) {
                                            obj2 = 0;
                                        }
                                        xDownloadFileResultModel.setClientCode((Number) obj2);
                                        xDownloadFileResultModel.setFilePath("");
                                        Unit unit = Unit.INSTANCE;
                                        completionBlock4.onFailure(0, str4, (XBaseResultModel) createXModel);
                                    }
                                });
                                return;
                            }
                            final LinkedHashMap<String, String> responseHeader = connection.getResponseHeader();
                            try {
                                try {
                                    bufferedInputStream = new BufferedInputStream(inputStreamResponseBody);
                                    try {
                                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str3));
                                    } catch (Exception e) {
                                        e = e;
                                        bufferedOutputStream = null;
                                    } catch (Throwable th) {
                                        th = th;
                                        bufferedOutputStream = null;
                                    }
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                bufferedOutputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedOutputStream = null;
                            }
                            try {
                                Ref.IntRef intRef = new Ref.IntRef();
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int read = bufferedInputStream.read(bArr);
                                    intRef.element = read;
                                    if (read == -1) {
                                        break;
                                    } else {
                                        bufferedOutputStream.write(bArr, 0, intRef.element);
                                    }
                                }
                                bufferedOutputStream.flush();
                                if (xDownloadFileParamModel.getSaveToAlbum() == null) {
                                    Handler mainThreadHandler3 = ThreadUtils.getMainThreadHandler();
                                    final CompletionBlock<AbsXDownloadFileMethodIDL.XDownloadFileResultModel> completionBlock4 = completionBlock;
                                    final String str4 = str3;
                                    mainThreadHandler3.post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XDownloadFileMethod$handleDownloadFile$3$responseCallback$1$handleConnection$5
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            Object obj;
                                            Object obj2;
                                            CompletionBlock<AbsXDownloadFileMethodIDL.XDownloadFileResultModel> completionBlock5 = completionBlock4;
                                            XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXDownloadFileMethodIDL.XDownloadFileResultModel.class));
                                            LinkedHashMap<String, String> linkedHashMap = responseHeader;
                                            String str5 = str4;
                                            int i = responseCode;
                                            Integer num = clientCode;
                                            AbsXDownloadFileMethodIDL.XDownloadFileResultModel xDownloadFileResultModel = (AbsXDownloadFileMethodIDL.XDownloadFileResultModel) createXModel;
                                            try {
                                                Result.Companion companion = Result.Companion;
                                                obj = Result.constructor-impl(Integer.valueOf(i));
                                            } catch (Throwable th3) {
                                                Result.Companion companion2 = Result.Companion;
                                                obj = Result.constructor-impl(ResultKt.createFailure(th3));
                                            }
                                            if (Result.isFailure-impl(obj)) {
                                                obj = 0;
                                            }
                                            xDownloadFileResultModel.setHttpCode((Number) obj);
                                            try {
                                                Result.Companion companion3 = Result.Companion;
                                                obj2 = Result.constructor-impl(num);
                                            } catch (Throwable th4) {
                                                Result.Companion companion4 = Result.Companion;
                                                obj2 = Result.constructor-impl(ResultKt.createFailure(th4));
                                            }
                                            if (Result.isFailure-impl(obj2)) {
                                                obj2 = 0;
                                            }
                                            xDownloadFileResultModel.setClientCode((Number) obj2);
                                            xDownloadFileResultModel.setHeader(linkedHashMap);
                                            xDownloadFileResultModel.setFilePath(str5);
                                            CompletionBlock.DefaultImpls.onSuccess$default(completionBlock5, (XBaseResultModel) createXModel, null, 2, null);
                                        }
                                    });
                                    connection.cancel();
                                    bufferedInputStream.close();
                                    bufferedOutputStream.close();
                                    return;
                                }
                                MediaUtils mediaUtils = MediaUtils.INSTANCE;
                                Context context3 = context2;
                                String str5 = str3;
                                String saveToAlbum = xDownloadFileParamModel.getSaveToAlbum();
                                Intrinsics.checkNotNull(saveToAlbum);
                                final Uri copyFileToGallery = mediaUtils.copyFileToGallery(context3, str5, Intrinsics.areEqual(saveToAlbum, "image"));
                                Handler mainThreadHandler4 = ThreadUtils.getMainThreadHandler();
                                final CompletionBlock<AbsXDownloadFileMethodIDL.XDownloadFileResultModel> completionBlock5 = completionBlock;
                                mainThreadHandler4.post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XDownloadFileMethod$handleDownloadFile$3$responseCallback$1$handleConnection$4
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        Object obj;
                                        Object obj2;
                                        CompletionBlock<AbsXDownloadFileMethodIDL.XDownloadFileResultModel> completionBlock6 = completionBlock5;
                                        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXDownloadFileMethodIDL.XDownloadFileResultModel.class));
                                        LinkedHashMap<String, String> linkedHashMap = responseHeader;
                                        Uri uri = copyFileToGallery;
                                        int i = responseCode;
                                        Integer num = clientCode;
                                        AbsXDownloadFileMethodIDL.XDownloadFileResultModel xDownloadFileResultModel = (AbsXDownloadFileMethodIDL.XDownloadFileResultModel) createXModel;
                                        try {
                                            Result.Companion companion = Result.Companion;
                                            obj = Result.constructor-impl(Integer.valueOf(i));
                                        } catch (Throwable th3) {
                                            Result.Companion companion2 = Result.Companion;
                                            obj = Result.constructor-impl(ResultKt.createFailure(th3));
                                        }
                                        if (Result.isFailure-impl(obj)) {
                                            obj = 0;
                                        }
                                        xDownloadFileResultModel.setHttpCode((Number) obj);
                                        try {
                                            Result.Companion companion3 = Result.Companion;
                                            obj2 = Result.constructor-impl(num);
                                        } catch (Throwable th4) {
                                            Result.Companion companion4 = Result.Companion;
                                            obj2 = Result.constructor-impl(ResultKt.createFailure(th4));
                                        }
                                        if (Result.isFailure-impl(obj2)) {
                                            obj2 = 0;
                                        }
                                        xDownloadFileResultModel.setClientCode((Number) obj2);
                                        xDownloadFileResultModel.setHeader(linkedHashMap);
                                        xDownloadFileResultModel.setFilePath(String.valueOf(uri));
                                        CompletionBlock.DefaultImpls.onSuccess$default(completionBlock6, (XBaseResultModel) createXModel, null, 2, null);
                                    }
                                });
                                try {
                                    connection.cancel();
                                    bufferedInputStream.close();
                                    bufferedOutputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            } catch (Exception e5) {
                                e = e5;
                                bufferedInputStream2 = bufferedInputStream;
                                try {
                                    Handler mainThreadHandler5 = ThreadUtils.getMainThreadHandler();
                                    final CompletionBlock<AbsXDownloadFileMethodIDL.XDownloadFileResultModel> completionBlock6 = completionBlock;
                                    mainThreadHandler5.post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XDownloadFileMethod$handleDownloadFile$3$responseCallback$1$handleConnection$6
                                        /* JADX WARN: Multi-variable type inference failed */
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            Object obj;
                                            Object obj2;
                                            CompletionBlock<AbsXDownloadFileMethodIDL.XDownloadFileResultModel> completionBlock7 = completionBlock6;
                                            String message = e.getMessage();
                                            if (message == null) {
                                                message = "store file exception";
                                            }
                                            XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXDownloadFileMethodIDL.XDownloadFileResultModel.class));
                                            int i = responseCode;
                                            Integer num = clientCode;
                                            AbsXDownloadFileMethodIDL.XDownloadFileResultModel xDownloadFileResultModel = (AbsXDownloadFileMethodIDL.XDownloadFileResultModel) createXModel;
                                            try {
                                                Result.Companion companion = Result.Companion;
                                                obj = Result.constructor-impl(Integer.valueOf(i));
                                            } catch (Throwable th3) {
                                                Result.Companion companion2 = Result.Companion;
                                                obj = Result.constructor-impl(ResultKt.createFailure(th3));
                                            }
                                            if (Result.isFailure-impl(obj)) {
                                                obj = 0;
                                            }
                                            xDownloadFileResultModel.setHttpCode((Number) obj);
                                            try {
                                                Result.Companion companion3 = Result.Companion;
                                                obj2 = Result.constructor-impl(num);
                                            } catch (Throwable th4) {
                                                Result.Companion companion4 = Result.Companion;
                                                obj2 = Result.constructor-impl(ResultKt.createFailure(th4));
                                            }
                                            if (Result.isFailure-impl(obj2)) {
                                                obj2 = 0;
                                            }
                                            xDownloadFileResultModel.setClientCode((Number) obj2);
                                            xDownloadFileResultModel.setFilePath("");
                                            Unit unit = Unit.INSTANCE;
                                            completionBlock7.onFailure(0, message, (XBaseResultModel) createXModel);
                                        }
                                    });
                                    connection.cancel();
                                    if (bufferedInputStream2 != null) {
                                        bufferedInputStream2.close();
                                    }
                                    if (bufferedOutputStream != null) {
                                        bufferedOutputStream.close();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    try {
                                        connection.cancel();
                                        if (bufferedInputStream2 != null) {
                                            bufferedInputStream2.close();
                                        }
                                        if (bufferedOutputStream != null) {
                                            bufferedOutputStream.close();
                                        }
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                bufferedInputStream2 = bufferedInputStream;
                                connection.cancel();
                                if (bufferedInputStream2 != null) {
                                }
                                if (bufferedOutputStream != null) {
                                }
                                throw th;
                            }
                        }
                    };
                    XBridgeAPIRequestUtils xBridgeAPIRequestUtils = XBridgeAPIRequestUtils.INSTANCE;
                    IStreamResponseCallback iStreamResponseCallback2 = iStreamResponseCallback;
                    IHostNetworkDepend networkDependInstance = RuntimeHelper.INSTANCE.getNetworkDependInstance(bridgeContext);
                    Boolean needCommonParams = AbsXDownloadFileMethodIDL.XDownloadFileParamModel.this.getNeedCommonParams();
                    xBridgeAPIRequestUtils.downloadFile(addParametersToUrl$default, filterHeaderEmptyValue, iStreamResponseCallback2, networkDependInstance, needCommonParams != null ? needCommonParams.booleanValue() : true);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleDownloadFileInProgress(final IBDXBridgeContext bridgeContext, final Context context, final AbsXDownloadFileMethodIDL.XDownloadFileParamModel downloadParams, final CompletionBlock<AbsXDownloadFileMethodIDL.XDownloadFileResultModel> callback, String fileName, String savePath, final String filePath) {
        final Context applicationContext = context.getApplicationContext();
        IDownloadListener iDownloadListener = new AbsDownloadListener() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XDownloadFileMethod$handleDownloadFileInProgress$downloadListener$1
            private long preTimestamp;

            /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:9:0x0034  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private final void sendDownloadEvent(long progress) {
                boolean z = true;
                if (!Intrinsics.areEqual(AbsXDownloadFileMethodIDL.XDownloadFileParamModel.this.getEnableProgress(), true)) {
                    return;
                }
                if (progress != 0) {
                    if (progress != 100) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.preTimestamp > 300) {
                            this.preTimestamp = currentTimeMillis;
                        }
                    }
                    if (z) {
                        return;
                    }
                    IBDXBridgeContext iBDXBridgeContext = bridgeContext;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    AbsXDownloadFileMethodIDL.XDownloadFileParamModel xDownloadFileParamModel = AbsXDownloadFileMethodIDL.XDownloadFileParamModel.this;
                    linkedHashMap.put(IWeixinService.ResponseConstants.URL, xDownloadFileParamModel.getUrl());
                    linkedHashMap.put("progress", Long.valueOf(progress));
                    String extension = xDownloadFileParamModel.getExtension();
                    if (extension != null) {
                        linkedHashMap.put("extension", extension);
                    }
                    Unit unit = Unit.INSTANCE;
                    iBDXBridgeContext.sendEvent("x.onDownloadProgress", linkedHashMap);
                    return;
                }
                z = false;
                if (z) {
                }
            }

            public void onProgress(DownloadInfo entity) {
                super.onProgress(entity);
                if (entity != null) {
                    sendDownloadEvent((entity.getCurBytes() * 100) / entity.getTotalBytes());
                }
            }

            private final void release(DownloadInfo entity) {
                if (entity != null) {
                    Downloader.getInstance(applicationContext).removeMainThreadListener(entity.getId(), (IDownloadListener) this);
                }
            }

            public void onCanceled(final DownloadInfo entity) {
                super.onCanceled(entity);
                Handler mainThreadHandler = ThreadUtils.getMainThreadHandler();
                final CompletionBlock<AbsXDownloadFileMethodIDL.XDownloadFileResultModel> completionBlock = callback;
                mainThreadHandler.post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XDownloadFileMethod$handleDownloadFileInProgress$downloadListener$1$onCanceled$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public final void run() {
                        Integer num;
                        CompletionBlock<AbsXDownloadFileMethodIDL.XDownloadFileResultModel> completionBlock2 = completionBlock;
                        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXDownloadFileMethodIDL.XDownloadFileResultModel.class));
                        DownloadInfo downloadInfo = entity;
                        AbsXDownloadFileMethodIDL.XDownloadFileResultModel xDownloadFileResultModel = (AbsXDownloadFileMethodIDL.XDownloadFileResultModel) createXModel;
                        xDownloadFileResultModel.setHttpCode(downloadInfo != null ? Integer.valueOf(downloadInfo.getHttpStatusCode()) : (Number) 0);
                        if (downloadInfo == null) {
                            num = (Number) 0;
                        } else {
                            num = Integer.valueOf(downloadInfo.getStatus());
                        }
                        xDownloadFileResultModel.setClientCode(num);
                        xDownloadFileResultModel.setFilePath("");
                        Unit unit = Unit.INSTANCE;
                        completionBlock2.onFailure(-7, "downloader cancel", (XBaseResultModel) createXModel);
                    }
                });
                release(entity);
            }

            /* JADX WARN: Code restructure failed: missing block: B:4:0x0024, code lost:
            
                if (r0 == null) goto L6;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onSuccessed(final DownloadInfo entity) {
                final String str;
                super.onSuccessed(entity);
                sendDownloadEvent(100L);
                String saveToAlbum = AbsXDownloadFileMethodIDL.XDownloadFileParamModel.this.getSaveToAlbum();
                if (saveToAlbum != null) {
                    str = String.valueOf(MediaUtils.INSTANCE.copyFileToGallery(context, filePath, Intrinsics.areEqual(saveToAlbum, "image")));
                }
                str = filePath;
                Handler mainThreadHandler = ThreadUtils.getMainThreadHandler();
                final CompletionBlock<AbsXDownloadFileMethodIDL.XDownloadFileResultModel> completionBlock = callback;
                mainThreadHandler.post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XDownloadFileMethod$handleDownloadFileInProgress$downloadListener$1$onSuccessed$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Integer num;
                        CompletionBlock<AbsXDownloadFileMethodIDL.XDownloadFileResultModel> completionBlock2 = completionBlock;
                        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXDownloadFileMethodIDL.XDownloadFileResultModel.class));
                        DownloadInfo downloadInfo = entity;
                        String str2 = str;
                        AbsXDownloadFileMethodIDL.XDownloadFileResultModel xDownloadFileResultModel = (AbsXDownloadFileMethodIDL.XDownloadFileResultModel) createXModel;
                        xDownloadFileResultModel.setHttpCode(downloadInfo != null ? Integer.valueOf(downloadInfo.getHttpStatusCode()) : (Number) 0);
                        if (downloadInfo == null) {
                            num = (Number) 0;
                        } else {
                            num = Integer.valueOf(downloadInfo.getStatus());
                        }
                        xDownloadFileResultModel.setClientCode(num);
                        xDownloadFileResultModel.setFilePath(str2);
                        CompletionBlock.DefaultImpls.onSuccess$default(completionBlock2, (XBaseResultModel) createXModel, null, 2, null);
                    }
                });
                release(entity);
            }

            public void onFailed(final DownloadInfo entity, final BaseException e) {
                super.onFailed(entity, e);
                Handler mainThreadHandler = ThreadUtils.getMainThreadHandler();
                final CompletionBlock<AbsXDownloadFileMethodIDL.XDownloadFileResultModel> completionBlock = callback;
                mainThreadHandler.post(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XDownloadFileMethod$handleDownloadFileInProgress$downloadListener$1$onFailed$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public final void run() {
                        CompletionBlock<AbsXDownloadFileMethodIDL.XDownloadFileResultModel> completionBlock2 = completionBlock;
                        BaseException baseException = e;
                        String errorMessage = baseException != null ? baseException.getErrorMessage() : null;
                        if (errorMessage == null) {
                            errorMessage = "downloader fail";
                        }
                        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXDownloadFileMethodIDL.XDownloadFileResultModel.class));
                        DownloadInfo downloadInfo = entity;
                        AbsXDownloadFileMethodIDL.XDownloadFileResultModel xDownloadFileResultModel = (AbsXDownloadFileMethodIDL.XDownloadFileResultModel) createXModel;
                        xDownloadFileResultModel.setHttpCode(downloadInfo != null ? Integer.valueOf(downloadInfo.getHttpStatusCode()) : 0);
                        xDownloadFileResultModel.setClientCode(downloadInfo != null ? Integer.valueOf(downloadInfo.getStatus()) : 0);
                        xDownloadFileResultModel.setFilePath("");
                        Unit unit = Unit.INSTANCE;
                        completionBlock2.onFailure(0, errorMessage, (XBaseResultModel) createXModel);
                    }
                });
                release(entity);
            }
        };
        DownloadTask addListenerToSameTask = Downloader.with(applicationContext).url(downloadParams.getUrl()).name(fileName).savePath(savePath).addListenerToSameTask(true);
        Boolean needCommonParams = downloadParams.getNeedCommonParams();
        DownloadTask extraHeaders = addListenerToSameTask.addTTNetCommonParam(needCommonParams != null ? needCommonParams.booleanValue() : true).deleteCacheIfCheckFailed(true).retryCount(0).autoSetHashCodeForSameTask(true).expiredRedownload(true).mainThreadListener(iDownloadListener).monitorScene(DOWNLOAD_SCENE).extraHeaders(getXSecurityArgusHeaderForDownloader(bridgeContext));
        try {
            Result.Companion companion = Result.Companion;
            Method methodSetCacheLifeMaxTime = WebResourceDownloader.Companion.getMethodSetCacheLifeMaxTime();
            Result.constructor-impl(methodSetCacheLifeMaxTime != null ? methodSetCacheLifeMaxTime.invoke(extraHeaders, 1209600L) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        extraHeaders.asyncDownload((IDownloadStartCallback) null);
    }

    private final List<HttpHeader> getXSecurityArgusHeaderForDownloader(IBDXBridgeContext bridgeContext) {
        return CollectionsKt.listOf(new HttpHeader(SecurityContextUtils.INSTANCE.getXSecurityArgusHeaderKey(bridgeContext), SecurityContextUtils.INSTANCE.getXSecurityArgusHeaderValue(bridgeContext)));
    }
}
