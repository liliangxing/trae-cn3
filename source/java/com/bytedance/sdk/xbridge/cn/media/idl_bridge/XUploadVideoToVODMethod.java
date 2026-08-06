package com.bytedance.sdk.xbridge.cn.media.idl_bridge;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ies.argus.api.ArgusGlobalDelegate;
import com.bytedance.ies.argus.api.params.AboutToUploadFileParams;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.media.idl.AbsXUploadVideoToVODMethodIDL;
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
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;

/* compiled from: XUploadVideoToVODMethod.kt */
@XBridgeMethod(name = "x.uploadVideoToVOD")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J6\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/XUploadVideoToVODMethod;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/protocol/StatefulMethod;", "()V", "hasPermission", "", "getDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostContextDepend;", "getMediaDependV2Instance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostMediaDependV2;", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL$XUploadVideoToVODParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL$XUploadVideoToVODResultModel;", "handleUploadFile", "context", "Landroid/content/Context;", "absoluteFilePath", "", "uploadParams", "release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XUploadVideoToVODMethod extends AbsXUploadVideoToVODMethodIDL implements StatefulMethod {
    private boolean hasPermission;

    /* JADX INFO: Access modifiers changed from: private */
    public final IHostContextDepend getDependInstance() {
        return XBaseRuntime.INSTANCE.getHostContextDepend();
    }

    private final IHostMediaDependV2 getMediaDependV2Instance() {
        return XBaseRuntime.INSTANCE.getHostMediaDependV2();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(final IBDXBridgeContext bridgeContext, final AbsXUploadVideoToVODMethodIDL.XUploadVideoToVODParamModel params, final CompletionBlock<AbsXUploadVideoToVODMethodIDL.XUploadVideoToVODResultModel> callback) {
        boolean z;
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
        if (!AppFileUtils.INSTANCE.isFileExists(activity, params.getFilePath())) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "file does not exist", null, 4, null);
            return;
        }
        IHostPermissionDepend permissionDependInstance = RuntimeHelper.INSTANCE.getPermissionDependInstance(bridgeContext);
        if (permissionDependInstance != null) {
            String[] readExternalStorageForVideoWithArray = XBridgePermissionUtils.INSTANCE.getReadExternalStorageForVideoWithArray();
            z = permissionDependInstance.isPermissionAllGranted(activity2, (String[]) Arrays.copyOf(readExternalStorageForVideoWithArray, readExternalStorageForVideoWithArray.length));
        } else {
            z = false;
        }
        this.hasPermission = z;
        if (z || AppFileUtils.INSTANCE.hasReadPermission(activity, params.getFilePath())) {
            String absoluteFilePath = AppFileUtils.INSTANCE.getAbsoluteFilePath(activity, params.getFilePath());
            if (absoluteFilePath == null) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "get file absolute path failed, please check it", null, 4, null);
                return;
            } else {
                handleUploadFile(bridgeContext, activity, absoluteFilePath, params, callback);
                return;
            }
        }
        IHostPermissionDepend permissionDependInstance2 = RuntimeHelper.INSTANCE.getPermissionDependInstance(bridgeContext);
        if (permissionDependInstance2 != null) {
            String name = getName();
            String[] readExternalStorageForVideoWithArray2 = XBridgePermissionUtils.INSTANCE.getReadExternalStorageForVideoWithArray();
            permissionDependInstance2.requestPermission(activity2, bridgeContext, name, (String[]) Arrays.copyOf(readExternalStorageForVideoWithArray2, readExternalStorageForVideoWithArray2.length), new OnPermissionCallback() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XUploadVideoToVODMethod$handle$1
                @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback
                public void onResult(boolean allGranted, Map<String, ? extends PermissionState> result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (allGranted) {
                        String absoluteFilePath2 = AppFileUtils.INSTANCE.getAbsoluteFilePath(ownerActivity, params.getFilePath());
                        if (absoluteFilePath2 != null) {
                            this.handleUploadFile(bridgeContext, ownerActivity, absoluteFilePath2, params, callback);
                            return;
                        } else {
                            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "get file absolute path failed, please check it", null, 4, null);
                            return;
                        }
                    }
                    CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "request permission denied", null, 4, null);
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
    public final void handleUploadFile(final IBDXBridgeContext bridgeContext, Context context, final String absoluteFilePath, AbsXUploadVideoToVODMethodIDL.XUploadVideoToVODParamModel uploadParams, final CompletionBlock<AbsXUploadVideoToVODMethodIDL.XUploadVideoToVODResultModel> callback) {
        final String str;
        ArgusGlobalDelegate companion = ArgusGlobalDelegate.Companion.getInstance();
        Unit unit = null;
        AspectVerifyResult verifyAboutToUploadFile = companion != null ? companion.verifyAboutToUploadFile(new AboutToUploadFileParams(absoluteFilePath, "x.uploadVideoToVOD")) : null;
        boolean z = false;
        if (verifyAboutToUploadFile != null && verifyAboutToUploadFile.isBlock()) {
            z = true;
        }
        if (z) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "file path " + absoluteFilePath + " contains sensitive content", null, 4, null);
            return;
        }
        AbsXUploadVideoToVODMethodIDL.XBridgeBeanXUploadVideoToVODUploadConfig uploadConfig = uploadParams.getUploadConfig();
        if (uploadConfig == null || (str = uploadConfig.getTraceId()) == null) {
            str = FConstants.PRE_TRACE_ID + UUID.randomUUID();
        }
        IUploadVideoToVODCallback iUploadVideoToVODCallback = new IUploadVideoToVODCallback() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XUploadVideoToVODMethod$handleUploadFile$uploadVideoToVODCallback$1
            @Override // com.bytedance.sdk.xbridge.cn.media.idl_bridge.IUploadVideoToVODCallback
            public void onComplete(VODInfo info) {
                CompletionBlock<AbsXUploadVideoToVODMethodIDL.XUploadVideoToVODResultModel> completionBlock = callback;
                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXUploadVideoToVODMethodIDL.XUploadVideoToVODResultModel.class));
                AbsXUploadVideoToVODMethodIDL.XUploadVideoToVODResultModel xUploadVideoToVODResultModel = (AbsXUploadVideoToVODMethodIDL.XUploadVideoToVODResultModel) createXModel;
                xUploadVideoToVODResultModel.setTraceId(str);
                AbsXUploadVideoToVODMethodIDL.XBridgeBeanXUploadVideoToVODVideoInfo xBridgeBeanXUploadVideoToVODVideoInfo = (AbsXUploadVideoToVODMethodIDL.XBridgeBeanXUploadVideoToVODVideoInfo) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXUploadVideoToVODMethodIDL.XBridgeBeanXUploadVideoToVODVideoInfo.class));
                xBridgeBeanXUploadVideoToVODVideoInfo.setVid(info != null ? info.getMVideoId() : null);
                xBridgeBeanXUploadVideoToVODVideoInfo.setCoverUri(info != null ? info.getMCoverUri() : null);
                Map<String, Object> jsonToMap = JsonUtils.INSTANCE.jsonToMap(new JSONObject(info != null ? info.getMVideoMediaInfo() : null));
                Intrinsics.checkNotNull(jsonToMap, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                xBridgeBeanXUploadVideoToVODVideoInfo.setMetaInfo(jsonToMap);
                xUploadVideoToVODResultModel.setVideoInfo(xBridgeBeanXUploadVideoToVODVideoInfo);
                CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel, null, 2, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.sdk.xbridge.cn.media.idl_bridge.IUploadVideoToVODCallback
            public void onFail(VODInfo info) {
                CompletionBlock<AbsXUploadVideoToVODMethodIDL.XUploadVideoToVODResultModel> completionBlock = callback;
                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXUploadVideoToVODMethodIDL.XUploadVideoToVODResultModel.class));
                AbsXUploadVideoToVODMethodIDL.XUploadVideoToVODResultModel xUploadVideoToVODResultModel = (AbsXUploadVideoToVODMethodIDL.XUploadVideoToVODResultModel) createXModel;
                xUploadVideoToVODResultModel.setTraceId(str);
                AbsXUploadVideoToVODMethodIDL.XBridgeBeanXUploadVideoToVODErrorInfo xBridgeBeanXUploadVideoToVODErrorInfo = (AbsXUploadVideoToVODMethodIDL.XBridgeBeanXUploadVideoToVODErrorInfo) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXUploadVideoToVODMethodIDL.XBridgeBeanXUploadVideoToVODErrorInfo.class));
                xBridgeBeanXUploadVideoToVODErrorInfo.setErrorCode(info != null ? info.getMErrorCode() : null);
                xBridgeBeanXUploadVideoToVODErrorInfo.setErrorMessage(info != null ? info.getMErrorMsg() : null);
                xUploadVideoToVODResultModel.setErrorInfo(xBridgeBeanXUploadVideoToVODErrorInfo);
                Unit unit2 = Unit.INSTANCE;
                completionBlock.onFailure(0, "upload failed", (XBaseResultModel) createXModel);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.sdk.xbridge.cn.media.idl_bridge.IUploadVideoToVODCallback
            public void onUploadCancel(VODInfo info) {
                CompletionBlock<AbsXUploadVideoToVODMethodIDL.XUploadVideoToVODResultModel> completionBlock = callback;
                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXUploadVideoToVODMethodIDL.XUploadVideoToVODResultModel.class));
                AbsXUploadVideoToVODMethodIDL.XUploadVideoToVODResultModel xUploadVideoToVODResultModel = (AbsXUploadVideoToVODMethodIDL.XUploadVideoToVODResultModel) createXModel;
                xUploadVideoToVODResultModel.setTraceId(str);
                AbsXUploadVideoToVODMethodIDL.XBridgeBeanXUploadVideoToVODErrorInfo xBridgeBeanXUploadVideoToVODErrorInfo = (AbsXUploadVideoToVODMethodIDL.XBridgeBeanXUploadVideoToVODErrorInfo) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXUploadVideoToVODMethodIDL.XBridgeBeanXUploadVideoToVODErrorInfo.class));
                xBridgeBeanXUploadVideoToVODErrorInfo.setErrorCode(info != null ? info.getMErrorCode() : null);
                xBridgeBeanXUploadVideoToVODErrorInfo.setErrorMessage(info != null ? info.getMErrorMsg() : null);
                xUploadVideoToVODResultModel.setErrorInfo(xBridgeBeanXUploadVideoToVODErrorInfo);
                Unit unit2 = Unit.INSTANCE;
                completionBlock.onFailure(-7, "upload cancel", (XBaseResultModel) createXModel);
            }

            @Override // com.bytedance.sdk.xbridge.cn.media.idl_bridge.IUploadVideoToVODCallback
            public void onUpdateProgress(long progress) {
                bridgeContext.sendEvent("uploadVideoToVODProgress", MapsKt.mapOf(new Pair[]{TuplesKt.to("traceID", str), TuplesKt.to("traceId", str), TuplesKt.to("progress", Float.valueOf(((float) progress) / 100))}));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.sdk.xbridge.cn.media.idl_bridge.IUploadVideoToVODCallback
            public void onException(Exception e, VODInfo info) {
                Intrinsics.checkNotNullParameter(e, "e");
                CompletionBlock<AbsXUploadVideoToVODMethodIDL.XUploadVideoToVODResultModel> completionBlock = callback;
                String str2 = "some exception happened : " + e.getMessage() + "; metaInfo = " + (info != null ? info.getMVideoMediaInfo() : null);
                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXUploadVideoToVODMethodIDL.XUploadVideoToVODResultModel.class));
                AbsXUploadVideoToVODMethodIDL.XUploadVideoToVODResultModel xUploadVideoToVODResultModel = (AbsXUploadVideoToVODMethodIDL.XUploadVideoToVODResultModel) createXModel;
                xUploadVideoToVODResultModel.setTraceId(str);
                AbsXUploadVideoToVODMethodIDL.XBridgeBeanXUploadVideoToVODVideoInfo xBridgeBeanXUploadVideoToVODVideoInfo = (AbsXUploadVideoToVODMethodIDL.XBridgeBeanXUploadVideoToVODVideoInfo) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXUploadVideoToVODMethodIDL.XBridgeBeanXUploadVideoToVODVideoInfo.class));
                xBridgeBeanXUploadVideoToVODVideoInfo.setVid(info != null ? info.getMVideoId() : null);
                xBridgeBeanXUploadVideoToVODVideoInfo.setCoverUri(info != null ? info.getMCoverUri() : null);
                xUploadVideoToVODResultModel.setVideoInfo(xBridgeBeanXUploadVideoToVODVideoInfo);
                AbsXUploadVideoToVODMethodIDL.XBridgeBeanXUploadVideoToVODErrorInfo xBridgeBeanXUploadVideoToVODErrorInfo = (AbsXUploadVideoToVODMethodIDL.XBridgeBeanXUploadVideoToVODErrorInfo) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXUploadVideoToVODMethodIDL.XBridgeBeanXUploadVideoToVODErrorInfo.class));
                xBridgeBeanXUploadVideoToVODErrorInfo.setErrorCode(info != null ? info.getMErrorCode() : null);
                xBridgeBeanXUploadVideoToVODErrorInfo.setErrorMessage(info != null ? info.getMErrorMsg() : null);
                xUploadVideoToVODResultModel.setErrorInfo(xBridgeBeanXUploadVideoToVODErrorInfo);
                Unit unit2 = Unit.INSTANCE;
                completionBlock.onFailure(0, str2, (XBaseResultModel) createXModel);
            }
        };
        XUploadVideoToVODExtraData xUploadVideoToVODExtraData = new XUploadVideoToVODExtraData(str, absoluteFilePath, this) { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XUploadVideoToVODMethod$handleUploadFile$extra$1
            private final String absoluteFilePath;
            private final String curTraceId;
            private final Boolean isBoeEnable;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IHostContextDepend dependInstance;
                this.curTraceId = str;
                this.absoluteFilePath = absoluteFilePath;
                dependInstance = this.getDependInstance();
                this.isBoeEnable = dependInstance != null ? Boolean.valueOf(dependInstance.isBoeEnable()) : null;
            }

            @Override // com.bytedance.sdk.xbridge.cn.media.idl_bridge.XUploadVideoToVODExtraData
            public String getCurTraceId() {
                return this.curTraceId;
            }

            @Override // com.bytedance.sdk.xbridge.cn.media.idl_bridge.XUploadVideoToVODExtraData
            public String getAbsoluteFilePath() {
                return this.absoluteFilePath;
            }

            @Override // com.bytedance.sdk.xbridge.cn.media.idl_bridge.XUploadVideoToVODExtraData
            /* renamed from: isBoeEnable, reason: from getter */
            public Boolean getIsBoeEnable() {
                return this.isBoeEnable;
            }
        };
        IHostMediaDependV2 mediaDependV2Instance = getMediaDependV2Instance();
        if (mediaDependV2Instance != null) {
            mediaDependV2Instance.startVideoUpload(context, uploadParams, xUploadVideoToVODExtraData, iUploadVideoToVODCallback);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "hostMediaDepend is null", null, 4, null);
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod
    public void release() {
        IHostMediaDependV2 mediaDependV2Instance = getMediaDependV2Instance();
        if (mediaDependV2Instance != null) {
            mediaDependV2Instance.closeVideoUpload();
        }
    }
}
