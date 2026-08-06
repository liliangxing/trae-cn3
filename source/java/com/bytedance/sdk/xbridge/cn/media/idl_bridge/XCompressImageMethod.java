package com.bytedance.sdk.xbridge.cn.media.idl_bridge;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import bolts.Task;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.media.idl.AbsXCompressImageMethodIDL;
import com.bytedance.sdk.xbridge.cn.media.utils.AppFileUtils;
import com.bytedance.sdk.xbridge.cn.media.utils.XBridgePermissionUtils;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XCompressImageMethod.kt */
@XBridgeMethod(name = "x.compressImage")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J&\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J>\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¨\u0006\u001b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/XCompressImageMethod;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXCompressImageMethodIDL;", "()V", "canRunInBackground", "", "checkFormat", "", "format", "", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXCompressImageMethodIDL$XCompressImageResultModel;", "checkQuality", "quality", "checkScalingRatio", "scalingRatio", "", "checkSourceFile", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "path", "handle", "", "params", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXCompressImageMethodIDL$XCompressImageParamModel;", "handleInBackground", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XCompressImageMethod extends AbsXCompressImageMethodIDL {
    private static final int ERROR_CODE_DECODE_ISSUE = 1000;
    private static final int ERROR_CODE_INVALID_PARAMS = -3;
    private static final int ERROR_CODE_PERMISSION_ISSUE = -6;
    private static final int ERROR_CODE_SUCCESS = 1;
    private static final int ERROR_CODE_UNKNOWN = 0;
    private static final String[] FORMAT_ARRAY = {"jpg", "png", "webp"};

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return true;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(final IBDXBridgeContext bridgeContext, AbsXCompressImageMethodIDL.XCompressImageParamModel params, final CompletionBlock<AbsXCompressImageMethodIDL.XCompressImageResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final String uri = params.getUri();
        final float floatValue = params.getScalingRatio().floatValue();
        String format = params.getFormat();
        if (format == null) {
            format = "jpg";
        }
        final String str = format;
        Number quality = params.getQuality();
        final int intValue = quality != null ? quality.intValue() : 100;
        if (checkSourceFile(bridgeContext, uri, callback) == 1 && checkScalingRatio(floatValue, callback) == 1 && checkFormat(str, callback) == 1 && checkQuality(intValue, callback) == 1) {
            Task.callInBackground(new Callable() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XCompressImageMethod$handle$1
                @Override // java.util.concurrent.Callable
                public /* bridge */ /* synthetic */ Object call() {
                    call();
                    return Unit.INSTANCE;
                }

                @Override // java.util.concurrent.Callable
                public final void call() {
                    XCompressImageMethod.this.handleInBackground(bridgeContext, uri, floatValue, str, intValue, callback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleInBackground(IBDXBridgeContext bridgeContext, String path, float scalingRatio, String format, int quality, CompletionBlock<AbsXCompressImageMethodIDL.XCompressImageResultModel> callback) {
        Bitmap.CompressFormat compressFormat;
        AppFileUtils appFileUtils = AppFileUtils.INSTANCE;
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity);
        String absoluteFilePath = appFileUtils.getAbsoluteFilePath(ownerActivity, path);
        if (Intrinsics.areEqual(format, "jpg")) {
            compressFormat = Bitmap.CompressFormat.JPEG;
        } else if (Intrinsics.areEqual(format, "png")) {
            compressFormat = Bitmap.CompressFormat.PNG;
        } else if (Build.VERSION.SDK_INT >= 30) {
            compressFormat = Bitmap.CompressFormat.WEBP_LOSSY;
        } else {
            compressFormat = Bitmap.CompressFormat.WEBP;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = (int) (1 / scalingRatio);
        Bitmap decodeFile = BitmapFactory.decodeFile(absoluteFilePath, options);
        if (decodeFile == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 1000, "decode image failed", null, 4, null);
            return;
        }
        String str = UUID.randomUUID().toString() + '.' + format;
        Activity ownerActivity2 = bridgeContext.getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity2);
        File file = new File(ownerActivity2.getCacheDir(), "AnnieX/xCompressImage/" + str);
        File parentFile = file.getParentFile();
        Intrinsics.checkNotNull(parentFile);
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                decodeFile.compress(compressFormat, quality, fileOutputStream);
                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                long length = file.length();
                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXCompressImageMethodIDL.XCompressImageResultModel.class));
                AbsXCompressImageMethodIDL.XCompressImageResultModel xCompressImageResultModel = (AbsXCompressImageMethodIDL.XCompressImageResultModel) createXModel;
                xCompressImageResultModel.setTempFilePath(file.getAbsolutePath());
                xCompressImageResultModel.setSize(Long.valueOf(length));
                CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel, null, 2, null);
            } finally {
            }
        } catch (Exception e) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "compress image failed， error message is " + e.getMessage(), null, 4, null);
        }
    }

    private final int checkSourceFile(IBDXBridgeContext bridgeContext, String path, CompletionBlock<AbsXCompressImageMethodIDL.XCompressImageResultModel> callback) {
        if (StringUtils.isEmpty(path)) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "uri is empty", null, 4, null);
            return -3;
        }
        if (bridgeContext.getOwnerActivity() == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "bridge context is invalid", null, 4, null);
            return 0;
        }
        IHostPermissionDepend permissionDependInstance = RuntimeHelper.INSTANCE.getPermissionDependInstance(bridgeContext);
        if (permissionDependInstance == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "permission depend missing, please seek help from client RD", null, 4, null);
            return 0;
        }
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity);
        String[] readExternalStorageForImageWithArray = XBridgePermissionUtils.INSTANCE.getReadExternalStorageForImageWithArray();
        Activity activity = ownerActivity;
        boolean isPermissionAllGranted = permissionDependInstance.isPermissionAllGranted(activity, (String[]) Arrays.copyOf(readExternalStorageForImageWithArray, readExternalStorageForImageWithArray.length));
        if (!AppFileUtils.INSTANCE.isFileExists(activity, path)) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "file specified by uri not exists", null, 4, null);
            return -3;
        }
        if (isPermissionAllGranted || AppFileUtils.INSTANCE.hasReadPermission(activity, path)) {
            return 1;
        }
        CompletionBlock.DefaultImpls.onFailure$default(callback, -6, "need permission to access file specified by uri， please request permission with x.requestPermission", null, 4, null);
        return -6;
    }

    private final int checkScalingRatio(float scalingRatio, CompletionBlock<AbsXCompressImageMethodIDL.XCompressImageResultModel> callback) {
        if (scalingRatio > 1.0f) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "scalingRatio must less than 1", null, 4, null);
            return -3;
        }
        if (scalingRatio > 0.0f) {
            return 1;
        }
        CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "scalingRatio must bigger then 0", null, 4, null);
        return -3;
    }

    private final int checkFormat(String format, CompletionBlock<AbsXCompressImageMethodIDL.XCompressImageResultModel> callback) {
        if (ArraysKt.contains(FORMAT_ARRAY, format)) {
            return 1;
        }
        CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "invalid format, which support 'jpg'，'png'，'webp'", null, 4, null);
        return -3;
    }

    private final int checkQuality(int quality, CompletionBlock<AbsXCompressImageMethodIDL.XCompressImageResultModel> callback) {
        if (quality > 100) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "quality must less than 100", null, 4, null);
            return -3;
        }
        if (quality >= 0.0f) {
            return 1;
        }
        CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "quality must bigger then 0", null, 4, null);
        return -3;
    }
}
