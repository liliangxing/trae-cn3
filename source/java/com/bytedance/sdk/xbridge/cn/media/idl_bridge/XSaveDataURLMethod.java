package com.bytedance.sdk.xbridge.cn.media.idl_bridge;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import com.bytedance.ies.bullet.service.base.settings.CommonConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.sdk.account.platform.api.IWeiboService;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.media.idl.AbsXSaveDataURLMethodIDL;
import com.bytedance.sdk.xbridge.cn.media.utils.BDMediaFileUtils;
import com.bytedance.sdk.xbridge.cn.media.utils.MediaUtils;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostCacheDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PermissionState;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeInjectLogger;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeMethodHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* compiled from: XSaveDataURLMethod.kt */
@XBridgeMethod(name = XSaveDataURLMethod.METHOD_NAME)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J>\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000e\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J&\u0010 \u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J,\u0010!\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/XSaveDataURLMethod;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXSaveDataURLMethodIDL;", "()V", "FORMAT_JPG", "", "FORMAT_NONSUPPORT_TYPE", "FORMAT_PNG", "MIME_TYPE_IMAGE_JPEG", "MIME_TYPE_IMAGE_PNG", "base64ToBitmap", "Landroid/graphics/Bitmap;", "dataUrl", "copyToAlbum", "", "context", "Landroid/app/Activity;", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXSaveDataURLMethodIDL$XSaveDataURLParamModel;", "filePath", "mimeType", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXSaveDataURLMethodIDL$XSaveDataURLResultModel;", "getCacheDir", "Ljava/io/File;", "Landroid/content/Context;", "getMimeTypeByExtension", "extension", "getPermissionDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostPermissionDepend;", "handle", "handleSaveDataURL", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XSaveDataURLMethod extends AbsXSaveDataURLMethodIDL {
    public static final String METHOD_NAME = "x.saveDataURL";
    private final String FORMAT_JPG = "jpg";
    private final String FORMAT_PNG = "png";
    private final String FORMAT_NONSUPPORT_TYPE = "nonsupportType";
    private final String MIME_TYPE_IMAGE_JPEG = "image/jpeg";
    private final String MIME_TYPE_IMAGE_PNG = "image/png";

    /* JADX INFO: Access modifiers changed from: private */
    public final IHostPermissionDepend getPermissionDependInstance(IBDXBridgeContext bridgeContext) {
        return RuntimeHelper.INSTANCE.getPermissionDependInstance(bridgeContext);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXSaveDataURLMethodIDL.XSaveDataURLParamModel params, CompletionBlock<AbsXSaveDataURLMethodIDL.XSaveDataURLResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Context not provided in host", null, 4, null);
            return;
        }
        if (XBridgeMethodHelper.INSTANCE.getActivity(ownerActivity) == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "context can not convert to activity", null, 4, null);
            return;
        }
        if (params.getDataURL().length() == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "The dataURL key is required.", null, 4, null);
            return;
        }
        if (params.getExtension().length() == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "The extension key is required.", null, 4, null);
            return;
        }
        if (params.getFilename().length() == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "The filename key is required.", null, 4, null);
        } else if (!StringsKt.startsWith$default(params.getDataURL(), "data:", false, 2, (Object) null)) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "dataURL invalid", null, 4, null);
        } else {
            handleSaveDataURL(bridgeContext, ownerActivity, params, callback);
        }
    }

    public final void handleSaveDataURL(final IBDXBridgeContext bridgeContext, final Activity context, final AbsXSaveDataURLMethodIDL.XSaveDataURLParamModel params, final CompletionBlock<AbsXSaveDataURLMethodIDL.XSaveDataURLResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String dataURL = params.getDataURL();
        if (StringsKt.contains$default(dataURL, IWeiboService.Scope.EMPTY_SCOPE, false, 2, (Object) null)) {
            final String str = (String) StringsKt.split$default(dataURL, new String[]{IWeiboService.Scope.EMPTY_SCOPE}, false, 0, 6, (Object) null).get(1);
            if (str.length() == 0) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, -3, null, null, 6, null);
                return;
            }
            String extension = params.getExtension();
            String str2 = params.getFilename() + '.' + extension;
            File cacheDir = getCacheDir(context);
            String absolutePath = cacheDir != null ? cacheDir.getAbsolutePath() : null;
            if (absolutePath == null) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "cacheDir is null", null, 4, null);
                return;
            }
            File file = new File(absolutePath, str2);
            final String absolutePath2 = file.getAbsolutePath();
            if (file.exists()) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "file path already exist", null, 4, null);
                return;
            }
            final String mimeTypeByExtension = getMimeTypeByExtension(extension);
            if (Intrinsics.areEqual(mimeTypeByExtension, this.FORMAT_NONSUPPORT_TYPE)) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, -3, null, null, 6, null);
                return;
            } else {
                RuntimeHelper.INSTANCE.getExecutorService(bridgeContext).execute(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XSaveDataURLMethod$handleSaveDataURL$1
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x012a -> B:32:0x0152). Please report as a decompilation issue!!! */
                    @Override // java.lang.Runnable
                    public final void run() {
                        Throwable th;
                        Bitmap base64ToBitmap;
                        String str3;
                        IHostPermissionDepend permissionDependInstance;
                        IHostPermissionDepend permissionDependInstance2;
                        Unit unit = null;
                        try {
                            try {
                                try {
                                    base64ToBitmap = XSaveDataURLMethod.this.base64ToBitmap(str);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } catch (Exception e2) {
                                e = e2;
                            }
                            if (base64ToBitmap == null) {
                                CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "data generate failed", null, 4, null);
                                return;
                            }
                            String str4 = mimeTypeByExtension;
                            str3 = XSaveDataURLMethod.this.MIME_TYPE_IMAGE_JPEG;
                            Bitmap.CompressFormat compressFormat = Intrinsics.areEqual(str4, str3) ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
                            Unit fileOutputStream = new FileOutputStream(absolutePath2);
                            try {
                                base64ToBitmap.compress(compressFormat, 100, (OutputStream) fileOutputStream);
                                fileOutputStream.flush();
                                if (params.getSaveToAlbum() != null) {
                                    if (Intrinsics.areEqual(params.getSaveToAlbum(), "image")) {
                                        permissionDependInstance = XSaveDataURLMethod.this.getPermissionDependInstance(bridgeContext);
                                        boolean isPermissionAllGranted = permissionDependInstance != null ? permissionDependInstance.isPermissionAllGranted(context, "android.permission.WRITE_EXTERNAL_STORAGE") : false;
                                        XBridgeInjectLogger.m174i(XSaveDataURLMethod.METHOD_NAME, "check permission before copy image to album, hasPermission=" + isPermissionAllGranted, "BridgeProcessing", bridgeContext.getContainerID());
                                        if (!isPermissionAllGranted && !MediaUtils.INSTANCE.fixBridgeStorageAboveAndroidQ()) {
                                            permissionDependInstance2 = XSaveDataURLMethod.this.getPermissionDependInstance(bridgeContext);
                                            if (permissionDependInstance2 != null) {
                                                final XSaveDataURLMethod xSaveDataURLMethod = XSaveDataURLMethod.this;
                                                final Activity activity = context;
                                                final IBDXBridgeContext iBDXBridgeContext = bridgeContext;
                                                final AbsXSaveDataURLMethodIDL.XSaveDataURLParamModel xSaveDataURLParamModel = params;
                                                final String str5 = absolutePath2;
                                                final String str6 = mimeTypeByExtension;
                                                final CompletionBlock<AbsXSaveDataURLMethodIDL.XSaveDataURLResultModel> completionBlock = callback;
                                                permissionDependInstance2.requestPermission(context, bridgeContext, XSaveDataURLMethod.this.getName(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, new OnPermissionCallback() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XSaveDataURLMethod$handleSaveDataURL$1.1
                                                    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback
                                                    public void onResult(boolean allGranted, Map<String, ? extends PermissionState> result) {
                                                        Intrinsics.checkNotNullParameter(result, "result");
                                                        if (allGranted) {
                                                            XSaveDataURLMethod xSaveDataURLMethod2 = XSaveDataURLMethod.this;
                                                            Activity activity2 = activity;
                                                            IBDXBridgeContext iBDXBridgeContext2 = iBDXBridgeContext;
                                                            AbsXSaveDataURLMethodIDL.XSaveDataURLParamModel xSaveDataURLParamModel2 = xSaveDataURLParamModel;
                                                            String str7 = str5;
                                                            Intrinsics.checkNotNullExpressionValue(str7, "filePath");
                                                            xSaveDataURLMethod2.copyToAlbum(activity2, iBDXBridgeContext2, xSaveDataURLParamModel2, str7, str6, completionBlock);
                                                            return;
                                                        }
                                                        BDMediaFileUtils.removeFile(str5);
                                                        CompletionBlock.DefaultImpls.onFailure$default(completionBlock, -6, "request permission denied", null, 4, null);
                                                    }
                                                });
                                                unit = Unit.INSTANCE;
                                            }
                                            if (unit == null) {
                                                CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "saveDataURLDepend is null", null, 4, null);
                                            }
                                        } else {
                                            XSaveDataURLMethod xSaveDataURLMethod2 = XSaveDataURLMethod.this;
                                            Activity activity2 = context;
                                            IBDXBridgeContext iBDXBridgeContext2 = bridgeContext;
                                            AbsXSaveDataURLMethodIDL.XSaveDataURLParamModel xSaveDataURLParamModel2 = params;
                                            String str7 = absolutePath2;
                                            Intrinsics.checkNotNullExpressionValue(str7, "filePath");
                                            xSaveDataURLMethod2.copyToAlbum(activity2, iBDXBridgeContext2, xSaveDataURLParamModel2, str7, mimeTypeByExtension, callback);
                                        }
                                    } else {
                                        BDMediaFileUtils.removeFile(absolutePath2);
                                        CompletionBlock.DefaultImpls.onFailure$default(callback, -3, null, null, 6, null);
                                    }
                                } else {
                                    CompletionBlock<AbsXSaveDataURLMethodIDL.XSaveDataURLResultModel> completionBlock2 = callback;
                                    XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXSaveDataURLMethodIDL.XSaveDataURLResultModel.class));
                                    ((AbsXSaveDataURLMethodIDL.XSaveDataURLResultModel) createXModel).setFilePath(absolutePath2);
                                    CompletionBlock.DefaultImpls.onSuccess$default(completionBlock2, (XBaseResultModel) createXModel, null, 2, null);
                                }
                                fileOutputStream.close();
                            } catch (Exception e3) {
                                e = e3;
                                unit = fileOutputStream;
                                CompletionBlock<AbsXSaveDataURLMethodIDL.XSaveDataURLResultModel> completionBlock3 = callback;
                                String message = e.getMessage();
                                if (message == null) {
                                    message = "store file exception";
                                }
                                CompletionBlock.DefaultImpls.onFailure$default(completionBlock3, 0, message, null, 4, null);
                                if (unit != null) {
                                    unit.close();
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                unit = fileOutputStream;
                                if (unit == null) {
                                    throw th;
                                }
                                try {
                                    unit.close();
                                    throw th;
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    throw th;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                });
                return;
            }
        }
        CompletionBlock.DefaultImpls.onFailure$default(callback, -3, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void copyToAlbum(Activity context, IBDXBridgeContext bridgeContext, AbsXSaveDataURLMethodIDL.XSaveDataURLParamModel params, String filePath, String mimeType, CompletionBlock<AbsXSaveDataURLMethodIDL.XSaveDataURLResultModel> callback) {
        Uri copyFileToGallery;
        String str;
        CommonConfig commonConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        boolean xSaveDataURLBroadcastWithFilePath = (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) ? true : commonConfig.getXSaveDataURLBroadcastWithFilePath();
        if (xSaveDataURLBroadcastWithFilePath) {
            copyFileToGallery = MediaUtils.INSTANCE.copyFileToGalleryV2(context, filePath, true, mimeType);
        } else {
            copyFileToGallery = MediaUtils.INSTANCE.copyFileToGallery(context, filePath, true, mimeType);
        }
        StringBuilder append = new StringBuilder("copyToAlbum, filePath=").append(filePath).append(", mimeType=").append(mimeType).append(", broadcastWithFilePath=").append(xSaveDataURLBroadcastWithFilePath).append(", uri=");
        if (copyFileToGallery == null || (str = copyFileToGallery.toString()) == null) {
            str = "null";
        }
        XBridgeInjectLogger.m174i(METHOD_NAME, append.append(str).toString(), "BridgeProcessing", bridgeContext.getContainerID());
        if (copyFileToGallery != null) {
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXSaveDataURLMethodIDL.XSaveDataURLResultModel.class)), null, 2, null);
            Boolean isCached = params.isCached();
            boolean booleanValue = isCached != null ? isCached.booleanValue() : false;
            IHostCacheDepend cacheDependInstance = RuntimeHelper.INSTANCE.getCacheDependInstance();
            if (cacheDependInstance == null) {
                XBridgeInjectLogger.m174i(METHOD_NAME, "cacheDepend is null", "BridgeProcessing", bridgeContext.getContainerID());
                return;
            } else {
                cacheDependInstance.onSaveImage(context, booleanValue, filePath);
                XBridgeInjectLogger.m174i(METHOD_NAME, "trigger cacheDepend.onSaveImage with isCached=" + booleanValue + ", filePath=" + filePath, "BridgeProcessing", bridgeContext.getContainerID());
                return;
            }
        }
        BDMediaFileUtils.removeFile(filePath);
        CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "saveToAlbum error", null, 4, null);
    }

    private final File getCacheDir(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        return externalCacheDir == null ? context.getCacheDir() : externalCacheDir;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap base64ToBitmap(String dataUrl) {
        byte[] decode = Base64.decode(dataUrl, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    private final String getMimeTypeByExtension(String extension) {
        return Intrinsics.areEqual(extension, this.FORMAT_JPG) ? this.MIME_TYPE_IMAGE_JPEG : Intrinsics.areEqual(extension, this.FORMAT_PNG) ? this.MIME_TYPE_IMAGE_PNG : this.FORMAT_NONSUPPORT_TYPE;
    }
}
