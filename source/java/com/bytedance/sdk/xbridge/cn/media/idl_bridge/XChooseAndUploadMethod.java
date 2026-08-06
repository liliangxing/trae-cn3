package com.bytedance.sdk.xbridge.cn.media.idl_bridge;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.bytedance.android.anniex.ability.service.IAnnieXActivityResult;
import com.bytedance.android.anniex.ability.service.IAnnieXCustomActivityService;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.media.idl.AbsXChooseAndUploadMethodIDL;
import com.bytedance.sdk.xbridge.cn.media.utils.AppFileUtils;
import com.bytedance.sdk.xbridge.cn.media.utils.AvatarUri;
import com.bytedance.sdk.xbridge.cn.media.utils.UploadFileResponse;
import com.bytedance.sdk.xbridge.cn.media.utils.XBridgePermissionUtils;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IChooseMediaResultCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostMediaDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostMediaDependV3;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostThreadPoolExecutorDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PermissionState;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.runtime.model.ImageParams;
import com.bytedance.sdk.xbridge.cn.runtime.model.VideoParams;
import com.bytedance.sdk.xbridge.cn.runtime.model.XChooseMediaParams;
import com.bytedance.sdk.xbridge.cn.runtime.model.XChooseMediaResults;
import com.bytedance.sdk.xbridge.cn.runtime.utils.IResponseCallback;
import com.bytedance.sdk.xbridge.cn.runtime.utils.JsonUtils;
import com.bytedance.sdk.xbridge.cn.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.sdk.xbridge.cn.runtime.utils.XDefaultHostNetworkDependImpl;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeMethodHelper;
import com.bytedance.trae.im.model.MessagePart;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* compiled from: XChooseAndUploadMethod.kt */
@XBridgeMethod(name = "x.chooseAndUpload")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0002JL\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001aj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J&\u0010\u001f\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J<\u0010#\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010$\u001a\u00020\"2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J4\u0010%\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¨\u0006'"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/XChooseAndUploadMethod;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseAndUploadMethodIDL;", "()V", "checkPath", "Ljava/io/File;", "context", "Landroid/content/Context;", IWeixinService.ResponseConstants.URL, "", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseAndUploadMethodIDL$XChooseAndUploadResultModel;", "key", "getExecutorService", "Ljava/util/concurrent/ExecutorService;", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "getMediaDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostMediaDepend;", "getMediaDependInstanceV3", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostMediaDependV3;", "getNetworkDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostNetworkDepend;", "getPermissionDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostPermissionDepend;", "getPostFilePart", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "filePathList", "", "Lcom/bytedance/sdk/xbridge/cn/runtime/model/XChooseMediaResults$FileInfo;", "handle", "", "params", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseAndUploadMethodIDL$XChooseAndUploadParamModel;", "handleUploadFile", "uploadParams", "uploadFiles", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XChooseAndUploadMethod extends AbsXChooseAndUploadMethodIDL {
    private static final String SourceTypeCamera = "camera";

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(final IBDXBridgeContext bridgeContext, final AbsXChooseAndUploadMethodIDL.XChooseAndUploadParamModel params, final CompletionBlock<AbsXChooseAndUploadMethodIDL.XChooseAndUploadResultModel> callback) {
        XChooseMediaParams xChooseMediaParams;
        Unit unit;
        Unit unit2;
        Number durationLimit;
        Number compressMaxSize;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Context not provided in host", null, 4, null);
            return;
        }
        int intValue = params.getMaxCount().intValue();
        if (intValue == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "maxCount can not be 0", null, 4, null);
            return;
        }
        List<String> mediaType = params.getMediaType();
        String sourceType = params.getSourceType();
        Boolean valueOf = Boolean.valueOf(params.getSaveToPhotoAlbum());
        String cameraType = params.getCameraType();
        if (cameraType == null) {
            cameraType = "back";
        }
        String str = cameraType;
        AbsXChooseAndUploadMethodIDL.XBridgeBeanXChooseAndUploadImageParams imageParams = params.getImageParams();
        Unit unit3 = null;
        String cropWidth = imageParams != null ? imageParams.getCropWidth() : null;
        AbsXChooseAndUploadMethodIDL.XBridgeBeanXChooseAndUploadImageParams imageParams2 = params.getImageParams();
        String cropWidth2 = imageParams2 != null ? imageParams2.getCropWidth() : null;
        AbsXChooseAndUploadMethodIDL.XBridgeBeanXChooseAndUploadImageParams imageParams3 = params.getImageParams();
        ImageParams imageParams4 = new ImageParams(cropWidth, cropWidth2, (imageParams3 == null || (compressMaxSize = imageParams3.getCompressMaxSize()) == null) ? null : Integer.valueOf(compressMaxSize.intValue()));
        AbsXChooseAndUploadMethodIDL.XBridgeBeanXChooseAndUploadVideoParams videoParams = params.getVideoParams();
        XChooseMediaParams xChooseMediaParams2 = new XChooseMediaParams(mediaType, sourceType, intValue, null, valueOf, str, false, 0, 0, imageParams4, new VideoParams((videoParams == null || (durationLimit = videoParams.getDurationLimit()) == null) ? null : Integer.valueOf(durationLimit.intValue())), 456, null);
        xChooseMediaParams2.setNeedBase64Data(params.getNeedBase64Data());
        xChooseMediaParams2.setNeedUploadFile(true);
        IChooseMediaResultCallback iChooseMediaResultCallback = new IChooseMediaResultCallback() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XChooseAndUploadMethod$handle$chooseMediaCallback$1
            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IChooseMediaResultCallback
            public void onSuccess(XChooseMediaResults result, String msg) {
                Intrinsics.checkNotNullParameter(result, "result");
                Intrinsics.checkNotNullParameter(msg, "msg");
                XChooseAndUploadMethod xChooseAndUploadMethod = XChooseAndUploadMethod.this;
                IBDXBridgeContext iBDXBridgeContext = bridgeContext;
                AbsXChooseAndUploadMethodIDL.XChooseAndUploadParamModel xChooseAndUploadParamModel = params;
                List<XChooseMediaResults.FileInfo> tempFiles = result.getTempFiles();
                if (tempFiles == null) {
                    tempFiles = CollectionsKt.emptyList();
                }
                xChooseAndUploadMethod.uploadFiles(iBDXBridgeContext, xChooseAndUploadParamModel, tempFiles, callback);
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IChooseMediaResultCallback
            public void onFailure(int code, String msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                CompletionBlock.DefaultImpls.onFailure$default(callback, code, msg, null, 4, null);
            }
        };
        IAnnieXCustomActivityService iAnnieXCustomActivityService = (IAnnieXCustomActivityService) bridgeContext.getService(IAnnieXCustomActivityService.class);
        IAnnieXActivityResult outerOnActivityResult = iAnnieXCustomActivityService != null ? iAnnieXCustomActivityService.outerOnActivityResult() : null;
        if (outerOnActivityResult != null) {
            IHostMediaDependV3 mediaDependInstanceV3 = getMediaDependInstanceV3(bridgeContext);
            if (mediaDependInstanceV3 != null) {
                mediaDependInstanceV3.handleJsInvoke(ownerActivity, xChooseMediaParams2, iChooseMediaResultCallback, outerOnActivityResult);
                unit2 = Unit.INSTANCE;
            } else {
                unit2 = null;
            }
            if (unit2 == null) {
                xChooseMediaParams = xChooseMediaParams2;
                CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "hostMediaDepend is null", null, 4, null);
            } else {
                xChooseMediaParams = xChooseMediaParams2;
            }
            unit = Unit.INSTANCE;
        } else {
            xChooseMediaParams = xChooseMediaParams2;
            unit = null;
        }
        if (unit == null) {
            IHostMediaDepend mediaDependInstance = getMediaDependInstance(bridgeContext);
            if (mediaDependInstance != null) {
                mediaDependInstance.handleJsInvoke(ownerActivity, xChooseMediaParams, iChooseMediaResultCallback);
                unit3 = Unit.INSTANCE;
            }
            if (unit3 == null) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "hostMediaDepend is null", null, 4, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uploadFiles(final IBDXBridgeContext bridgeContext, final AbsXChooseAndUploadMethodIDL.XChooseAndUploadParamModel params, final List<XChooseMediaResults.FileInfo> filePathList, final CompletionBlock<AbsXChooseAndUploadMethodIDL.XChooseAndUploadResultModel> callback) {
        boolean z;
        Unit unit;
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
        IHostPermissionDepend permissionDependInstance = getPermissionDependInstance(bridgeContext);
        if (permissionDependInstance != null) {
            String[] readExternalStorageForImageAndVideoWithArray = XBridgePermissionUtils.INSTANCE.getReadExternalStorageForImageAndVideoWithArray();
            z = permissionDependInstance.isPermissionAllGranted(activity2, (String[]) Arrays.copyOf(readExternalStorageForImageAndVideoWithArray, readExternalStorageForImageAndVideoWithArray.length));
        } else {
            z = false;
        }
        if (!z) {
            AppFileUtils appFileUtils = AppFileUtils.INSTANCE;
            List<XChooseMediaResults.FileInfo> list = filePathList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((XChooseMediaResults.FileInfo) it.next()).getTempFilePath());
            }
            if (!appFileUtils.hasAllReadPermission(activity, arrayList)) {
                IHostPermissionDepend permissionDependInstance2 = getPermissionDependInstance(bridgeContext);
                if (permissionDependInstance2 != null) {
                    String name = getName();
                    String[] readExternalStorageForImageAndVideoWithArray2 = XBridgePermissionUtils.INSTANCE.getReadExternalStorageForImageAndVideoWithArray();
                    permissionDependInstance2.requestPermission(activity2, bridgeContext, name, (String[]) Arrays.copyOf(readExternalStorageForImageAndVideoWithArray2, readExternalStorageForImageAndVideoWithArray2.length), new OnPermissionCallback() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XChooseAndUploadMethod$uploadFiles$2
                        @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback
                        public void onResult(boolean allGranted, Map<String, ? extends PermissionState> result) {
                            Intrinsics.checkNotNullParameter(result, "result");
                            if (allGranted) {
                                XChooseAndUploadMethod.this.handleUploadFile(bridgeContext, ownerActivity, filePathList, params, callback);
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
                    CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "uploadFileDepend is null", null, 4, null);
                    return;
                }
                return;
            }
        }
        handleUploadFile(bridgeContext, activity, filePathList, params, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleUploadFile(final IBDXBridgeContext bridgeContext, Context context, final List<XChooseMediaResults.FileInfo> filePathList, final AbsXChooseAndUploadMethodIDL.XChooseAndUploadParamModel uploadParams, final CompletionBlock<AbsXChooseAndUploadMethodIDL.XChooseAndUploadResultModel> callback) {
        final LinkedHashMap<String, File> postFilePart = getPostFilePart(context, filePathList, callback);
        if (postFilePart == null) {
            return;
        }
        getExecutorService(bridgeContext).execute(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XChooseAndUploadMethod$handleUploadFile$1
            @Override // java.lang.Runnable
            public final void run() {
                IHostNetworkDepend networkDependInstance;
                LinkedHashMap<String, String> filterHeaderEmptyValue = XBridgeAPIRequestUtils.INSTANCE.filterHeaderEmptyValue(AbsXChooseAndUploadMethodIDL.XChooseAndUploadParamModel.this.getHeader());
                Map<String, String> convertParamValueToString = XBridgeAPIRequestUtils.INSTANCE.convertParamValueToString(AbsXChooseAndUploadMethodIDL.XChooseAndUploadParamModel.this.getParams());
                XBridgeAPIRequestUtils.INSTANCE.addXSecurityArgusHeader(filterHeaderEmptyValue, bridgeContext);
                final CompletionBlock<AbsXChooseAndUploadMethodIDL.XChooseAndUploadResultModel> completionBlock = callback;
                final XChooseAndUploadMethod xChooseAndUploadMethod = this;
                final List<XChooseMediaResults.FileInfo> list = filePathList;
                IResponseCallback iResponseCallback = new IResponseCallback() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XChooseAndUploadMethod$handleUploadFile$1$responseCallback$1
                    @Override // com.bytedance.sdk.xbridge.cn.runtime.utils.IResponseCallback
                    public Unit onParsingFailed(JSONObject jSONObject, LinkedHashMap<String, String> linkedHashMap, String str, Throwable th, Integer num, int i) {
                        return IResponseCallback.DefaultImpls.onParsingFailed(this, jSONObject, linkedHashMap, str, th, num, i);
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.utils.IResponseCallback
                    public void onSuccess(JSONObject body, LinkedHashMap<String, String> responseHeader, Integer statusCode, int clientCode) {
                        int intValue;
                        Intrinsics.checkNotNullParameter(body, "body");
                        Intrinsics.checkNotNullParameter(responseHeader, "responseHeader");
                        if (statusCode != null) {
                            try {
                                intValue = statusCode.intValue();
                            } catch (Throwable th) {
                                CompletionBlock<AbsXChooseAndUploadMethodIDL.XChooseAndUploadResultModel> completionBlock2 = completionBlock;
                                String message = th.getMessage();
                                if (message == null) {
                                    message = "";
                                }
                                CompletionBlock.DefaultImpls.onFailure$default(completionBlock2, 0, message, null, 4, null);
                                Log.e(xChooseAndUploadMethod.getName(), "parse post reponse body failed", th);
                                return;
                            }
                        } else {
                            intValue = -1;
                        }
                        JsonUtils jsonUtils = JsonUtils.INSTANCE;
                        String jSONObject = body.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "body.toString()");
                        AvatarUri data = ((UploadFileResponse) jsonUtils.fromJson(jSONObject, UploadFileResponse.class)).getData();
                        List<String> urlList = data != null ? data.getUrlList() : null;
                        CompletionBlock<AbsXChooseAndUploadMethodIDL.XChooseAndUploadResultModel> completionBlock3 = completionBlock;
                        XBaseModel createXModel = XBridgeKTXKt.createXModel((Class<XBaseModel>) AbsXChooseAndUploadMethodIDL.XChooseAndUploadResultModel.class);
                        List<XChooseMediaResults.FileInfo> list2 = list;
                        AbsXChooseAndUploadMethodIDL.XChooseAndUploadResultModel xChooseAndUploadResultModel = (AbsXChooseAndUploadMethodIDL.XChooseAndUploadResultModel) createXModel;
                        xChooseAndUploadResultModel.setClientCode((Number) 1);
                        List<XChooseMediaResults.FileInfo> list3 = list2;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                        for (XChooseMediaResults.FileInfo fileInfo : list3) {
                            XBaseModel createXModel2 = XBridgeKTXKt.createXModel((Class<XBaseModel>) AbsXChooseAndUploadMethodIDL.XBridgeBeanXChooseAndUploadTempFiles.class);
                            AbsXChooseAndUploadMethodIDL.XBridgeBeanXChooseAndUploadTempFiles xBridgeBeanXChooseAndUploadTempFiles = (AbsXChooseAndUploadMethodIDL.XBridgeBeanXChooseAndUploadTempFiles) createXModel2;
                            xBridgeBeanXChooseAndUploadTempFiles.setPath(fileInfo.getTempFilePath());
                            xBridgeBeanXChooseAndUploadTempFiles.setSize(Long.valueOf(fileInfo.getSize()));
                            xBridgeBeanXChooseAndUploadTempFiles.setMimeType("image/png");
                            xBridgeBeanXChooseAndUploadTempFiles.setMediaType(fileInfo.getMediaType());
                            xBridgeBeanXChooseAndUploadTempFiles.setBase64Data(fileInfo.getBase64Data());
                            arrayList.add((AbsXChooseAndUploadMethodIDL.XBridgeBeanXChooseAndUploadTempFiles) createXModel2);
                        }
                        ArrayList arrayList2 = arrayList;
                        if (urlList != null) {
                            int coerceAtMost = RangesKt.coerceAtMost(arrayList2.size(), urlList.size());
                            for (int i = 0; i < coerceAtMost; i++) {
                                ((AbsXChooseAndUploadMethodIDL.XBridgeBeanXChooseAndUploadTempFiles) arrayList2.get(i)).setUrl(urlList.get(i));
                            }
                        }
                        xChooseAndUploadResultModel.setHttpCode(Integer.valueOf(intValue));
                        xChooseAndUploadResultModel.setClientCode(Integer.valueOf(clientCode));
                        xChooseAndUploadResultModel.setTempFiles(arrayList2);
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        Iterator<String> keys = body.keys();
                        Intrinsics.checkNotNullExpressionValue(keys, "body.keys()");
                        while (keys.hasNext()) {
                            String next = keys.next();
                            Intrinsics.checkNotNullExpressionValue(next, "key");
                            Object obj = body.get(next);
                            Intrinsics.checkNotNullExpressionValue(obj, "body.get(key)");
                            linkedHashMap.put(next, obj);
                        }
                        xChooseAndUploadResultModel.setResponse(linkedHashMap);
                        CompletionBlock.DefaultImpls.onSuccess$default(completionBlock3, (XBaseResultModel) createXModel, null, 2, null);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.bytedance.sdk.xbridge.cn.runtime.utils.IResponseCallback
                    public void onFailed(Integer errorCode, LinkedHashMap<String, String> responseHeader, Throwable throwable, int clientCode) {
                        Intrinsics.checkNotNullParameter(throwable, "throwable");
                        int i = throwable instanceof NetworkNotAvailabeException ? -1001 : 0;
                        CompletionBlock<AbsXChooseAndUploadMethodIDL.XChooseAndUploadResultModel> completionBlock2 = completionBlock;
                        String message = throwable.getMessage();
                        if (message == null) {
                            message = "";
                        }
                        XBaseModel createXModel = XBridgeKTXKt.createXModel((Class<XBaseModel>) AbsXChooseAndUploadMethodIDL.XChooseAndUploadResultModel.class);
                        AbsXChooseAndUploadMethodIDL.XChooseAndUploadResultModel xChooseAndUploadResultModel = (AbsXChooseAndUploadMethodIDL.XChooseAndUploadResultModel) createXModel;
                        int i2 = XBridgeAPIRequestUtils.ERROR_CODE_408;
                        xChooseAndUploadResultModel.setHttpCode(errorCode != null ? errorCode : Integer.valueOf(XBridgeAPIRequestUtils.ERROR_CODE_408));
                        xChooseAndUploadResultModel.setClientCode(Integer.valueOf(clientCode));
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (errorCode != null) {
                            i2 = errorCode.intValue();
                        }
                        linkedHashMap.put("errCode", Integer.valueOf(i2));
                        String message2 = throwable.getMessage();
                        if (message2 == null) {
                            message2 = "";
                        }
                        linkedHashMap.put("message", message2);
                        linkedHashMap.put("prompts", "");
                        xChooseAndUploadResultModel.setResponse(linkedHashMap);
                        Unit unit = Unit.INSTANCE;
                        completionBlock2.onFailure(i, message, (XBaseResultModel) createXModel);
                    }
                };
                XBridgeAPIRequestUtils xBridgeAPIRequestUtils = XBridgeAPIRequestUtils.INSTANCE;
                String url = AbsXChooseAndUploadMethodIDL.XChooseAndUploadParamModel.this.getUrl();
                LinkedHashMap<String, File> linkedHashMap = postFilePart;
                networkDependInstance = this.getNetworkDependInstance(bridgeContext);
                xBridgeAPIRequestUtils.post(url, (LinkedHashMap<String, String>) filterHeaderEmptyValue, (LinkedHashMap<String, File>) linkedHashMap, (Map<String, String>) convertParamValueToString, iResponseCallback, networkDependInstance, (r20 & 64) != 0 ? true : AbsXChooseAndUploadMethodIDL.XChooseAndUploadParamModel.this.getNeedCommonParams(), (r20 & 128) != 0 ? -1 : 0);
            }
        });
    }

    private final LinkedHashMap<String, File> getPostFilePart(Context context, List<XChooseMediaResults.FileInfo> filePathList, CompletionBlock<AbsXChooseAndUploadMethodIDL.XChooseAndUploadResultModel> callback) {
        if (!filePathList.isEmpty()) {
            LinkedHashMap<String, File> linkedHashMap = new LinkedHashMap<>();
            int i = 0;
            for (Object obj : filePathList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                File checkPath = checkPath(context, ((XChooseMediaResults.FileInfo) obj).getTempFilePath(), callback, "filePath");
                if (checkPath == null) {
                    return null;
                }
                linkedHashMap.put(MessagePart.TYPE_FILE, checkPath);
                i = i2;
            }
            return linkedHashMap;
        }
        CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "filePath or formDataBody can not be null.", null, 4, null);
        return null;
    }

    private final File checkPath(Context context, String url, CompletionBlock<AbsXChooseAndUploadMethodIDL.XChooseAndUploadResultModel> callback, String key) {
        String str = url;
        if (str == null || str.length() == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "The file path should not be empty.The key is " + key, null, 4, null);
            return null;
        }
        String absoluteFilePath = AppFileUtils.INSTANCE.getAbsoluteFilePath(context, url);
        String str2 = absoluteFilePath;
        if (str2 == null || str2.length() == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -9, "File is not exist.The key is " + key, null, 4, null);
            return null;
        }
        File file = new File(absoluteFilePath);
        if (!file.exists()) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -9, "File is not exist.The key is " + key, null, 4, null);
            return null;
        }
        if (file.isFile()) {
            return file;
        }
        CompletionBlock.DefaultImpls.onFailure$default(callback, -9, "File is not file.The key is " + key, null, 4, null);
        return null;
    }

    private final IHostMediaDepend getMediaDependInstance(IBDXBridgeContext bridgeContext) {
        IHostMediaDepend hostMediaDepend;
        XBaseRuntime xBaseRuntime = (XBaseRuntime) bridgeContext.getService(XBaseRuntime.class);
        return (xBaseRuntime == null || (hostMediaDepend = xBaseRuntime.getHostMediaDepend()) == null) ? XBaseRuntime.INSTANCE.getHostMediaDepend() : hostMediaDepend;
    }

    private final IHostMediaDependV3 getMediaDependInstanceV3(IBDXBridgeContext bridgeContext) {
        IHostMediaDependV3 hostMediaDependV3;
        XBaseRuntime xBaseRuntime = (XBaseRuntime) bridgeContext.getService(XBaseRuntime.class);
        return (xBaseRuntime == null || (hostMediaDependV3 = xBaseRuntime.getHostMediaDependV3()) == null) ? XBaseRuntime.INSTANCE.getHostMediaDependV3() : hostMediaDependV3;
    }

    private final IHostPermissionDepend getPermissionDependInstance(IBDXBridgeContext bridgeContext) {
        IHostPermissionDepend hostPermissionDepend;
        XBaseRuntime xBaseRuntime = (XBaseRuntime) bridgeContext.getService(XBaseRuntime.class);
        return (xBaseRuntime == null || (hostPermissionDepend = xBaseRuntime.getHostPermissionDepend()) == null) ? RuntimeHelper.INSTANCE.getPermissionDependInstance(bridgeContext) : hostPermissionDepend;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IHostNetworkDepend getNetworkDependInstance(IBDXBridgeContext bridgeContext) {
        IHostNetworkDepend hostNetworkDepend;
        XBaseRuntime xBaseRuntime = (XBaseRuntime) bridgeContext.getService(XBaseRuntime.class);
        if (xBaseRuntime != null && (hostNetworkDepend = xBaseRuntime.getHostNetworkDepend()) != null) {
            return hostNetworkDepend;
        }
        IHostNetworkDepend hostNetworkDepend2 = XBaseRuntime.INSTANCE.getHostNetworkDepend();
        return hostNetworkDepend2 == null ? new XDefaultHostNetworkDependImpl() : hostNetworkDepend2;
    }

    private final ExecutorService getExecutorService(IBDXBridgeContext bridgeContext) {
        IHostThreadPoolExecutorDepend hostThreadPoolExecutorDepend;
        ExecutorService normalThreadExecutor;
        XBaseRuntime xBaseRuntime = (XBaseRuntime) bridgeContext.getService(XBaseRuntime.class);
        if (xBaseRuntime == null || (hostThreadPoolExecutorDepend = xBaseRuntime.getHostThreadPoolExecutorDepend()) == null) {
            hostThreadPoolExecutorDepend = XBaseRuntime.INSTANCE.getHostThreadPoolExecutorDepend();
        }
        if (hostThreadPoolExecutorDepend != null && (normalThreadExecutor = hostThreadPoolExecutorDepend.getNormalThreadExecutor()) != null) {
            return normalThreadExecutor;
        }
        ExecutorService normalExecutor = TTExecutors.getNormalExecutor();
        Intrinsics.checkNotNullExpressionValue(normalExecutor, "getNormalExecutor()");
        return normalExecutor;
    }
}
