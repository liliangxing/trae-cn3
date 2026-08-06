package com.bytedance.sdk.xbridge.cn.media.idl_bridge;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ies.argus.api.ArgusGlobalDelegate;
import com.bytedance.ies.argus.api.params.AboutToUploadFileParams;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.media.idl.AbsXUploadImagesToImageXMethodIDL;
import com.bytedance.sdk.xbridge.cn.media.utils.AppFileUtils;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.media.utils.XBridgePermissionUtils;
import com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.JsonUtils;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostMediaDependV2;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PermissionState;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeMethodHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;

/* compiled from: XUploadImagesToImageXMethod.kt */
@XBridgeMethod(name = "x.uploadImagesToImageX")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J<\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\b\u0010\u001a\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/XUploadImagesToImageXMethod;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/protocol/StatefulMethod;", "()V", "hasPermission", "", "getDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostContextDepend;", "getMediaDependV2Instance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostMediaDependV2;", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$XUploadImagesToImageXParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$XUploadImagesToImageXResultModel;", "handleUploadFile", "context", "Landroid/content/Context;", "absoluteFilePaths", "Ljava/util/ArrayList;", "", "uploadParams", "release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XUploadImagesToImageXMethod extends AbsXUploadImagesToImageXMethodIDL implements StatefulMethod {
    private boolean hasPermission;

    /* JADX INFO: Access modifiers changed from: private */
    public final IHostContextDepend getDependInstance() {
        return XBaseRuntime.INSTANCE.getHostContextDepend();
    }

    private final IHostMediaDependV2 getMediaDependV2Instance() {
        return XBaseRuntime.INSTANCE.getHostMediaDependV2();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(final IBDXBridgeContext bridgeContext, final AbsXUploadImagesToImageXMethodIDL.XUploadImagesToImageXParamModel params, final CompletionBlock<AbsXUploadImagesToImageXMethodIDL.XUploadImagesToImageXResultModel> callback) {
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
        if (params.getFilePaths().isEmpty()) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "filePaths is empty", null, 4, null);
            return;
        }
        String mainNetworkType = params.getMainNetworkType();
        boolean z = false;
        if (mainNetworkType == null || mainNetworkType.length() == 0) {
            params.setMainNetworkType("ttnet");
        }
        if (!AppFileUtils.INSTANCE.isAllFileExists(activity, params.getFilePaths())) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "file does not exist", null, 4, null);
            return;
        }
        IHostPermissionDepend permissionDependInstance = RuntimeHelper.INSTANCE.getPermissionDependInstance(bridgeContext);
        if (permissionDependInstance != null) {
            String[] readExternalStorageForImageWithArray = XBridgePermissionUtils.INSTANCE.getReadExternalStorageForImageWithArray();
            z = permissionDependInstance.isPermissionAllGranted(activity2, (String[]) Arrays.copyOf(readExternalStorageForImageWithArray, readExternalStorageForImageWithArray.length));
        }
        this.hasPermission = z;
        if (z || AppFileUtils.INSTANCE.hasAllReadPermission(activity, params.getFilePaths())) {
            ArrayList<String> absoluteFilePaths = AppFileUtils.INSTANCE.getAbsoluteFilePaths(activity, params.getFilePaths());
            if (absoluteFilePaths.size() != params.getFilePaths().size()) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "get absolute file path failed, please check it", null, 4, null);
                return;
            } else {
                handleUploadFile(bridgeContext, activity, absoluteFilePaths, params, callback);
                return;
            }
        }
        IHostPermissionDepend permissionDependInstance2 = RuntimeHelper.INSTANCE.getPermissionDependInstance(bridgeContext);
        if (permissionDependInstance2 != null) {
            String name = getName();
            String[] readExternalStorageForImageWithArray2 = XBridgePermissionUtils.INSTANCE.getReadExternalStorageForImageWithArray();
            permissionDependInstance2.requestPermission(activity2, bridgeContext, name, (String[]) Arrays.copyOf(readExternalStorageForImageWithArray2, readExternalStorageForImageWithArray2.length), new OnPermissionCallback() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XUploadImagesToImageXMethod$handle$1
                @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback
                public void onResult(boolean allGranted, Map<String, ? extends PermissionState> result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (allGranted) {
                        ArrayList<String> absoluteFilePaths2 = AppFileUtils.INSTANCE.getAbsoluteFilePaths(ownerActivity, params.getFilePaths());
                        if (absoluteFilePaths2.size() == params.getFilePaths().size()) {
                            this.handleUploadFile(bridgeContext, ownerActivity, absoluteFilePaths2, params, callback);
                            return;
                        } else {
                            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "get absolute file path failed, please check it", null, 4, null);
                            return;
                        }
                    }
                    CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "request permission denied.", null, 4, null);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "uploadFileDepend is null", null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleUploadFile(final IBDXBridgeContext bridgeContext, Context context, final ArrayList<String> absoluteFilePaths, AbsXUploadImagesToImageXMethodIDL.XUploadImagesToImageXParamModel uploadParams, final CompletionBlock<AbsXUploadImagesToImageXMethodIDL.XUploadImagesToImageXResultModel> callback) {
        final String str;
        String str2;
        boolean z;
        Iterator<T> it = absoluteFilePaths.iterator();
        do {
            if (it.hasNext()) {
                str2 = (String) it.next();
                ArgusGlobalDelegate companion = ArgusGlobalDelegate.Companion.getInstance();
                r2 = companion != null ? companion.verifyAboutToUploadFile(new AboutToUploadFileParams(str2, "x.uploadImagesToImageX")) : null;
                z = false;
                if (r2 != null && r2.isBlock()) {
                    z = true;
                }
            } else {
                AbsXUploadImagesToImageXMethodIDL.XBridgeBeanXUploadImagesToImageXUploadConfig uploadConfig = uploadParams.getUploadConfig();
                if (uploadConfig == null || (str = uploadConfig.getTraceId()) == null) {
                    str = FConstants.PRE_TRACE_ID + UUID.randomUUID();
                }
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = new ArrayList();
                IUploadImagesToImageXCallback iUploadImagesToImageXCallback = new IUploadImagesToImageXCallback() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XUploadImagesToImageXMethod$handleUploadFile$uploadImagesToImageXCallback$1
                    @Override // com.bytedance.sdk.xbridge.cn.media.idl_bridge.IUploadImagesToImageXCallback
                    public void onSingleImageFail() {
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.media.idl_bridge.IUploadImagesToImageXCallback
                    public void onComplete() {
                        CompletionBlock<AbsXUploadImagesToImageXMethodIDL.XUploadImagesToImageXResultModel> completionBlock = callback;
                        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXUploadImagesToImageXMethodIDL.XUploadImagesToImageXResultModel.class));
                        String str3 = str;
                        Ref.ObjectRef<ArrayList<AbsXUploadImagesToImageXMethodIDL.XBridgeBeanXUploadImagesToImageXImageInfos>> objectRef2 = objectRef;
                        AbsXUploadImagesToImageXMethodIDL.XUploadImagesToImageXResultModel xUploadImagesToImageXResultModel = (AbsXUploadImagesToImageXMethodIDL.XUploadImagesToImageXResultModel) createXModel;
                        xUploadImagesToImageXResultModel.setTraceId(str3);
                        xUploadImagesToImageXResultModel.setImageInfos((List) objectRef2.element);
                        CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel, null, 2, null);
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.media.idl_bridge.IUploadImagesToImageXCallback
                    public void onSingleImageComplete(ImageXInfo imageXInfo) {
                        ImageXEncryptionInfo mEnd2EndEncryption;
                        String mAESKey;
                        ArrayList arrayList = (ArrayList) objectRef.element;
                        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXUploadImagesToImageXMethodIDL.XBridgeBeanXUploadImagesToImageXImageInfos.class));
                        AbsXUploadImagesToImageXMethodIDL.XBridgeBeanXUploadImagesToImageXImageInfos xBridgeBeanXUploadImagesToImageXImageInfos = (AbsXUploadImagesToImageXMethodIDL.XBridgeBeanXUploadImagesToImageXImageInfos) createXModel;
                        xBridgeBeanXUploadImagesToImageXImageInfos.setUri(imageXInfo != null ? imageXInfo.getMImageTosKey() : null);
                        Map<String, Object> jsonToMap = JsonUtils.INSTANCE.jsonToMap(new JSONObject(imageXInfo != null ? imageXInfo.getMMetaInfo() : null));
                        Intrinsics.checkNotNull(jsonToMap, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                        xBridgeBeanXUploadImagesToImageXImageInfos.setMetaInfo(jsonToMap);
                        if (imageXInfo != null && (mEnd2EndEncryption = imageXInfo.getMEnd2EndEncryption()) != null && (mAESKey = mEnd2EndEncryption.getMAESKey()) != null) {
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            linkedHashMap.put("aesKey", mAESKey);
                            xBridgeBeanXUploadImagesToImageXImageInfos.setEncryptionInfo(linkedHashMap);
                        }
                        arrayList.add(createXModel);
                        IBDXBridgeContext iBDXBridgeContext = bridgeContext;
                        Pair[] pairArr = new Pair[5];
                        pairArr[0] = TuplesKt.to("traceID", str);
                        pairArr[1] = TuplesKt.to("traceId", str);
                        pairArr[2] = TuplesKt.to("fileIndex", imageXInfo != null ? imageXInfo.getMFileIndex() : null);
                        pairArr[3] = TuplesKt.to("uri", imageXInfo != null ? imageXInfo.getMImageTosKey() : null);
                        Map<String, Object> jsonToMap2 = JsonUtils.INSTANCE.jsonToMap(new JSONObject(imageXInfo != null ? imageXInfo.getMMetaInfo() : null));
                        Intrinsics.checkNotNull(jsonToMap2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                        pairArr[4] = TuplesKt.to("metaInfo", jsonToMap2);
                        iBDXBridgeContext.sendEvent("uploadImagesToImageXSingleImageComplete", MapsKt.mapOf(pairArr));
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.bytedance.sdk.xbridge.cn.media.idl_bridge.IUploadImagesToImageXCallback
                    public void onFail(Long errorCode, String errorMessage) {
                        CompletionBlock<AbsXUploadImagesToImageXMethodIDL.XUploadImagesToImageXResultModel> completionBlock = callback;
                        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXUploadImagesToImageXMethodIDL.XUploadImagesToImageXResultModel.class));
                        AbsXUploadImagesToImageXMethodIDL.XUploadImagesToImageXResultModel xUploadImagesToImageXResultModel = (AbsXUploadImagesToImageXMethodIDL.XUploadImagesToImageXResultModel) createXModel;
                        xUploadImagesToImageXResultModel.setTraceId(str);
                        AbsXUploadImagesToImageXMethodIDL.XBridgeBeanXUploadImagesToImageXErrorInfo xBridgeBeanXUploadImagesToImageXErrorInfo = (AbsXUploadImagesToImageXMethodIDL.XBridgeBeanXUploadImagesToImageXErrorInfo) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXUploadImagesToImageXMethodIDL.XBridgeBeanXUploadImagesToImageXErrorInfo.class));
                        xBridgeBeanXUploadImagesToImageXErrorInfo.setErrorCode(errorCode);
                        xBridgeBeanXUploadImagesToImageXErrorInfo.setErrorMessage(errorMessage);
                        xUploadImagesToImageXResultModel.setErrorInfo(xBridgeBeanXUploadImagesToImageXErrorInfo);
                        Unit unit = Unit.INSTANCE;
                        completionBlock.onFailure(0, "upload failed", (XBaseResultModel) createXModel);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.bytedance.sdk.xbridge.cn.media.idl_bridge.IUploadImagesToImageXCallback
                    public void onUploadCancel(Long errorCode, String errorMessage) {
                        CompletionBlock<AbsXUploadImagesToImageXMethodIDL.XUploadImagesToImageXResultModel> completionBlock = callback;
                        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXUploadImagesToImageXMethodIDL.XUploadImagesToImageXResultModel.class));
                        AbsXUploadImagesToImageXMethodIDL.XUploadImagesToImageXResultModel xUploadImagesToImageXResultModel = (AbsXUploadImagesToImageXMethodIDL.XUploadImagesToImageXResultModel) createXModel;
                        xUploadImagesToImageXResultModel.setTraceId(str);
                        AbsXUploadImagesToImageXMethodIDL.XBridgeBeanXUploadImagesToImageXErrorInfo xBridgeBeanXUploadImagesToImageXErrorInfo = (AbsXUploadImagesToImageXMethodIDL.XBridgeBeanXUploadImagesToImageXErrorInfo) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXUploadImagesToImageXMethodIDL.XBridgeBeanXUploadImagesToImageXErrorInfo.class));
                        xBridgeBeanXUploadImagesToImageXErrorInfo.setErrorCode(errorCode);
                        xBridgeBeanXUploadImagesToImageXErrorInfo.setErrorMessage(errorMessage);
                        xUploadImagesToImageXResultModel.setErrorInfo(xBridgeBeanXUploadImagesToImageXErrorInfo);
                        Unit unit = Unit.INSTANCE;
                        completionBlock.onFailure(-7, "upload cancelled", (XBaseResultModel) createXModel);
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.media.idl_bridge.IUploadImagesToImageXCallback
                    public void onUpdateProgress(Integer fileIndex, long progress) {
                        bridgeContext.sendEvent("uploadImagesToImageXProgress", MapsKt.mapOf(new Pair[]{TuplesKt.to("traceID", str), TuplesKt.to("traceId", str), TuplesKt.to("fileIndex", fileIndex), TuplesKt.to("progress", Float.valueOf(((float) progress) / 100))}));
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.bytedance.sdk.xbridge.cn.media.idl_bridge.IUploadImagesToImageXCallback
                    public void onException(Exception e, Long errorCode, String errorMessage) {
                        Intrinsics.checkNotNullParameter(e, "e");
                        CompletionBlock<AbsXUploadImagesToImageXMethodIDL.XUploadImagesToImageXResultModel> completionBlock = callback;
                        String str3 = "some exception happened: " + e.getMessage() + "; metaInfo : " + errorMessage;
                        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXUploadImagesToImageXMethodIDL.XUploadImagesToImageXResultModel.class));
                        AbsXUploadImagesToImageXMethodIDL.XUploadImagesToImageXResultModel xUploadImagesToImageXResultModel = (AbsXUploadImagesToImageXMethodIDL.XUploadImagesToImageXResultModel) createXModel;
                        xUploadImagesToImageXResultModel.setTraceId(str);
                        AbsXUploadImagesToImageXMethodIDL.XBridgeBeanXUploadImagesToImageXErrorInfo xBridgeBeanXUploadImagesToImageXErrorInfo = (AbsXUploadImagesToImageXMethodIDL.XBridgeBeanXUploadImagesToImageXErrorInfo) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXUploadImagesToImageXMethodIDL.XBridgeBeanXUploadImagesToImageXErrorInfo.class));
                        xBridgeBeanXUploadImagesToImageXErrorInfo.setErrorCode(errorCode);
                        xBridgeBeanXUploadImagesToImageXErrorInfo.setErrorMessage(errorMessage);
                        xUploadImagesToImageXResultModel.setErrorInfo(xBridgeBeanXUploadImagesToImageXErrorInfo);
                        Unit unit = Unit.INSTANCE;
                        completionBlock.onFailure(0, str3, (XBaseResultModel) createXModel);
                    }
                };
                XUploadImagesToImageXExtraData xUploadImagesToImageXExtraData = new XUploadImagesToImageXExtraData(str, absoluteFilePaths, this) { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XUploadImagesToImageXMethod$handleUploadFile$extra$1
                    private final ArrayList<String> absoluteFilePaths;
                    private final String curTraceId;
                    private final Boolean isBoeEnable;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        IHostContextDepend dependInstance;
                        this.curTraceId = str;
                        this.absoluteFilePaths = absoluteFilePaths;
                        dependInstance = this.getDependInstance();
                        this.isBoeEnable = dependInstance != null ? Boolean.valueOf(dependInstance.isBoeEnable()) : null;
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.media.idl_bridge.XUploadImagesToImageXExtraData
                    public String getCurTraceId() {
                        return this.curTraceId;
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.media.idl_bridge.XUploadImagesToImageXExtraData
                    public ArrayList<String> getAbsoluteFilePaths() {
                        return this.absoluteFilePaths;
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.media.idl_bridge.XUploadImagesToImageXExtraData
                    /* renamed from: isBoeEnable, reason: from getter */
                    public Boolean getIsBoeEnable() {
                        return this.isBoeEnable;
                    }
                };
                IHostMediaDependV2 mediaDependV2Instance = getMediaDependV2Instance();
                if (mediaDependV2Instance != null) {
                    mediaDependV2Instance.startImageXUpload(context, uploadParams, xUploadImagesToImageXExtraData, iUploadImagesToImageXCallback);
                    r2 = Unit.INSTANCE;
                }
                if (r2 == null) {
                    CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "hostMediaDepend is null", null, 4, null);
                    return;
                }
                return;
            }
        } while (!z);
        CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "file path " + str2 + " contains sensitive content", null, 4, null);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod
    public void release() {
        IHostMediaDependV2 mediaDependV2Instance = getMediaDependV2Instance();
        if (mediaDependV2Instance != null) {
            mediaDependV2Instance.closeImageXUpload();
        }
    }
}
