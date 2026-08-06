package com.bytedance.sdk.xbridge.cn.media.idl_bridge;

import android.app.Activity;
import com.bytedance.android.anniex.ability.service.IAnnieXActivityResult;
import com.bytedance.android.anniex.ability.service.IAnnieXCustomActivityService;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.media.idl.AbsXChooseMediaMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IChooseMediaResultCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostMediaDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostMediaDependV3;
import com.bytedance.sdk.xbridge.cn.runtime.model.ImageParams;
import com.bytedance.sdk.xbridge.cn.runtime.model.VideoParams;
import com.bytedance.sdk.xbridge.cn.runtime.model.XChooseMediaParams;
import com.bytedance.sdk.xbridge.cn.runtime.model.XChooseMediaResults;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XChooseMediaMethod.kt */
@XBridgeMethod(name = "x.chooseMedia")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/XChooseMediaMethod;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseMediaMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseMediaMethodIDL$XChooseMediaParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXChooseMediaMethodIDL$XChooseMediaResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XChooseMediaMethod extends AbsXChooseMediaMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXChooseMediaMethodIDL.XChooseMediaParamModel params, final CompletionBlock<AbsXChooseMediaMethodIDL.XChooseMediaResultModel> callback) {
        XChooseMediaParams xChooseMediaParams;
        Unit unit;
        Unit unit2;
        Number durationLimit;
        Number compressMaxSize;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String sourceType = params.getSourceType();
        String cameraType = params.getCameraType();
        if (cameraType == null) {
            cameraType = "back";
        }
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        if (sourceType == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = sourceType.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        if (Intrinsics.areEqual(lowerCase, "camera")) {
            if (cameraType.length() == 0) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "CameraType not provided with sourceType specified as camera in params", null, 4, null);
                return;
            }
        }
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Context not provided in host", null, 4, null);
            return;
        }
        List<String> mediaType = params.getMediaType();
        List<String> mediaTypes = params.getMediaTypes();
        List<String> list = mediaType;
        if (list == null || list.isEmpty()) {
            List<String> list2 = mediaTypes;
            if (list2 == null || list2.isEmpty()) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "either mediaType or mediaTypes must not be null", null, 4, null);
                return;
            }
        }
        List<String> list3 = list == null || list.isEmpty() ? mediaTypes : mediaType;
        String sourceType2 = params.getSourceType();
        Number maxCount = params.getMaxCount();
        int intValue = maxCount != null ? maxCount.intValue() : 1;
        Boolean compressImage = params.getCompressImage();
        Boolean valueOf = Boolean.valueOf(compressImage != null ? compressImage.booleanValue() : false);
        Boolean saveToPhotoAlbum = params.getSaveToPhotoAlbum();
        Boolean valueOf2 = Boolean.valueOf(saveToPhotoAlbum != null ? saveToPhotoAlbum.booleanValue() : false);
        String cameraType2 = params.getCameraType();
        if (cameraType2 == null) {
            cameraType2 = "";
        }
        String str = cameraType2;
        Boolean needBinaryData = params.getNeedBinaryData();
        boolean booleanValue = needBinaryData != null ? needBinaryData.booleanValue() : false;
        Number compressWidth = params.getCompressWidth();
        int intValue2 = compressWidth != null ? compressWidth.intValue() : 0;
        Number compressHeight = params.getCompressHeight();
        int intValue3 = compressHeight != null ? compressHeight.intValue() : 0;
        AbsXChooseMediaMethodIDL.XBridgeBeanXChooseMediaImageParams imageParams = params.getImageParams();
        Unit unit3 = null;
        String cropWidth = imageParams != null ? imageParams.getCropWidth() : null;
        AbsXChooseMediaMethodIDL.XBridgeBeanXChooseMediaImageParams imageParams2 = params.getImageParams();
        String cropWidth2 = imageParams2 != null ? imageParams2.getCropWidth() : null;
        AbsXChooseMediaMethodIDL.XBridgeBeanXChooseMediaImageParams imageParams3 = params.getImageParams();
        ImageParams imageParams4 = new ImageParams(cropWidth, cropWidth2, (imageParams3 == null || (compressMaxSize = imageParams3.getCompressMaxSize()) == null) ? null : Integer.valueOf(compressMaxSize.intValue()));
        AbsXChooseMediaMethodIDL.XBridgeBeanXChooseMediaVideoParams videoParams = params.getVideoParams();
        XChooseMediaParams xChooseMediaParams2 = new XChooseMediaParams(list3, sourceType2, intValue, valueOf, valueOf2, str, booleanValue, intValue2, intValue3, imageParams4, new VideoParams((videoParams == null || (durationLimit = videoParams.getDurationLimit()) == null) ? null : Integer.valueOf(durationLimit.intValue())));
        Boolean isNeedCut = params.isNeedCut();
        xChooseMediaParams2.setNeedCut(isNeedCut != null ? isNeedCut.booleanValue() : false);
        Number cropRatioHeight = params.getCropRatioHeight();
        xChooseMediaParams2.setCropRatioHeight(cropRatioHeight != null ? cropRatioHeight.intValue() : 0);
        Number cropRatioWidth = params.getCropRatioWidth();
        xChooseMediaParams2.setCropRatioWidth(cropRatioWidth != null ? cropRatioWidth.intValue() : 0);
        xChooseMediaParams2.setNeedBase64Data(Intrinsics.areEqual(params.getNeedBase64Data(), true));
        Boolean copyToPrivateDirection = params.getCopyToPrivateDirection();
        xChooseMediaParams2.setCopyToPrivateDirection(copyToPrivateDirection != null ? copyToPrivateDirection.booleanValue() : false);
        IChooseMediaResultCallback iChooseMediaResultCallback = new IChooseMediaResultCallback() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XChooseMediaMethod$handle$chooseMediaCallback$1
            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IChooseMediaResultCallback
            public void onSuccess(XChooseMediaResults result, String msg) {
                Intrinsics.checkNotNullParameter(result, "result");
                Intrinsics.checkNotNullParameter(msg, "msg");
                ArrayList arrayList = new ArrayList();
                List<XChooseMediaResults.FileInfo> tempFiles = result.getTempFiles();
                if (tempFiles != null) {
                    for (XChooseMediaResults.FileInfo fileInfo : tempFiles) {
                        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXChooseMediaMethodIDL.XBridgeBeanXChooseMediaTempFiles.class));
                        AbsXChooseMediaMethodIDL.XBridgeBeanXChooseMediaTempFiles xBridgeBeanXChooseMediaTempFiles = (AbsXChooseMediaMethodIDL.XBridgeBeanXChooseMediaTempFiles) createXModel;
                        xBridgeBeanXChooseMediaTempFiles.setPath(fileInfo.getTempFilePath());
                        xBridgeBeanXChooseMediaTempFiles.setTempFilePath(fileInfo.getTempFilePath());
                        xBridgeBeanXChooseMediaTempFiles.setSize(Long.valueOf(fileInfo.getSize()));
                        xBridgeBeanXChooseMediaTempFiles.setMediaType(fileInfo.getMediaType());
                        xBridgeBeanXChooseMediaTempFiles.setBase64Data(fileInfo.getBase64Data());
                        xBridgeBeanXChooseMediaTempFiles.setMimeType("image/jpeg");
                        arrayList.add(createXModel);
                    }
                }
                CompletionBlock<AbsXChooseMediaMethodIDL.XChooseMediaResultModel> completionBlock = callback;
                XBaseModel createXModel2 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXChooseMediaMethodIDL.XChooseMediaResultModel.class));
                ((AbsXChooseMediaMethodIDL.XChooseMediaResultModel) createXModel2).setTempFiles(arrayList);
                CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel2, null, 2, null);
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
            IHostMediaDependV3 mediaDependInstanceV3 = RuntimeHelper.INSTANCE.getMediaDependInstanceV3(bridgeContext);
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
            IHostMediaDepend mediaDependInstance = RuntimeHelper.INSTANCE.getMediaDependInstance(bridgeContext);
            if (mediaDependInstance != null) {
                mediaDependInstance.handleJsInvoke(ownerActivity, xChooseMediaParams, iChooseMediaResultCallback);
                unit3 = Unit.INSTANCE;
            }
            if (unit3 == null) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "hostMediaDepend is null", null, 4, null);
            }
        }
    }
}
