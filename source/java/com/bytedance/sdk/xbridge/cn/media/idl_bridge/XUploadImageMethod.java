package com.bytedance.sdk.xbridge.cn.media.idl_bridge;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.bytedance.ies.argus.api.ArgusGlobalDelegate;
import com.bytedance.ies.argus.api.params.AboutToUploadFileParams;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.media.idl.AbsXUploadImageMethodIDL;
import com.bytedance.sdk.xbridge.cn.media.utils.AppFileUtils;
import com.bytedance.sdk.xbridge.cn.media.utils.AvatarUri;
import com.bytedance.sdk.xbridge.cn.media.utils.UploadFileResponse;
import com.bytedance.sdk.xbridge.cn.media.utils.XBridgePermissionUtils;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PermissionState;
import com.bytedance.sdk.xbridge.cn.runtime.utils.IResponseCallback;
import com.bytedance.sdk.xbridge.cn.runtime.utils.JsonUtils;
import com.bytedance.sdk.xbridge.cn.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeMethodHelper;
import com.bytedance.trae.im.model.MessagePart;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: XUploadImageMethod.kt */
@XBridgeMethod(name = "x.uploadImage")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J2\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0002JF\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u00152\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00172\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J.\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\"\u0010\u001e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006 "}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/XUploadImageMethod;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImageMethodIDL;", "()V", "TAG", "", "hasPermission", "", "imageTypeArray", "", "[Ljava/lang/String;", "checkPath", "Ljava/io/File;", "context", "Landroid/content/Context;", IWeixinService.ResponseConstants.URL, "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImageMethodIDL$XUploadImageResultModel;", "key", "getPostFilePart", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "uploadParams", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImageMethodIDL$XUploadImageParamModel;", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "handleUploadFile", "isMediaImage", MessagePart.TYPE_FILE, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XUploadImageMethod extends AbsXUploadImageMethodIDL {
    private boolean hasPermission;
    private final String TAG = "XUploadImageMethod";
    private final String[] imageTypeArray = {"jpg", "jpeg", "png", "gif", "bmp", "webp"};

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(final IBDXBridgeContext bridgeContext, final AbsXUploadImageMethodIDL.XUploadImageParamModel params, final CompletionBlock<AbsXUploadImageMethodIDL.XUploadImageResultModel> callback) {
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
            String[] readExternalStorageForImageWithArray = XBridgePermissionUtils.INSTANCE.getReadExternalStorageForImageWithArray();
            z = permissionDependInstance.isPermissionAllGranted(activity2, (String[]) Arrays.copyOf(readExternalStorageForImageWithArray, readExternalStorageForImageWithArray.length));
        } else {
            z = false;
        }
        this.hasPermission = z;
        if (z || AppFileUtils.INSTANCE.hasReadPermission(activity, params.getFilePath())) {
            handleUploadFile(bridgeContext, activity, params, callback);
            return;
        }
        IHostPermissionDepend permissionDependInstance2 = RuntimeHelper.INSTANCE.getPermissionDependInstance(bridgeContext);
        if (permissionDependInstance2 != null) {
            String name = getName();
            String[] readExternalStorageForImageWithArray2 = XBridgePermissionUtils.INSTANCE.getReadExternalStorageForImageWithArray();
            permissionDependInstance2.requestPermission(activity2, bridgeContext, name, (String[]) Arrays.copyOf(readExternalStorageForImageWithArray2, readExternalStorageForImageWithArray2.length), new OnPermissionCallback() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XUploadImageMethod$handle$1
                @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback
                public void onResult(boolean allGranted, Map<String, ? extends PermissionState> result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (allGranted) {
                        XUploadImageMethod.this.handleUploadFile(bridgeContext, ownerActivity, params, callback);
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
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "uploadImageDepend is null", null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleUploadFile(final IBDXBridgeContext bridgeContext, Context context, final AbsXUploadImageMethodIDL.XUploadImageParamModel uploadParams, final CompletionBlock<AbsXUploadImageMethodIDL.XUploadImageResultModel> callback) {
        final LinkedHashMap<String, File> postFilePart = getPostFilePart(context, uploadParams, callback);
        if (postFilePart == null) {
            return;
        }
        RuntimeHelper.INSTANCE.getExecutorService(bridgeContext).execute(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XUploadImageMethod$handleUploadFile$1
            @Override // java.lang.Runnable
            public final void run() {
                LinkedHashMap<String, String> filterHeaderEmptyValue = XBridgeAPIRequestUtils.INSTANCE.filterHeaderEmptyValue(AbsXUploadImageMethodIDL.XUploadImageParamModel.this.getHeader());
                Map<String, String> convertParamValueToString = XBridgeAPIRequestUtils.INSTANCE.convertParamValueToString(AbsXUploadImageMethodIDL.XUploadImageParamModel.this.getParams());
                XBridgeAPIRequestUtils.INSTANCE.addXSecurityArgusHeader(filterHeaderEmptyValue, bridgeContext);
                final CompletionBlock<AbsXUploadImageMethodIDL.XUploadImageResultModel> completionBlock = callback;
                IResponseCallback iResponseCallback = new IResponseCallback() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XUploadImageMethod$handleUploadFile$1$responseCallback$1
                    @Override // com.bytedance.sdk.xbridge.cn.runtime.utils.IResponseCallback
                    public Unit onParsingFailed(JSONObject jSONObject, LinkedHashMap<String, String> linkedHashMap, String str, Throwable th, Integer num, int i) {
                        return IResponseCallback.DefaultImpls.onParsingFailed(this, jSONObject, linkedHashMap, str, th, num, i);
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.utils.IResponseCallback
                    public void onSuccess(JSONObject body, LinkedHashMap<String, String> responseHeader, Integer statusCode, int clientCode) {
                        ArrayList arrayList;
                        String valueOf;
                        Intrinsics.checkNotNullParameter(body, "body");
                        Intrinsics.checkNotNullParameter(responseHeader, "responseHeader");
                        try {
                            JsonUtils jsonUtils = JsonUtils.INSTANCE;
                            String jSONObject = body.toString();
                            Intrinsics.checkNotNullExpressionValue(jSONObject, "body.toString()");
                            AvatarUri data = ((UploadFileResponse) jsonUtils.fromJson(jSONObject, UploadFileResponse.class)).getData();
                            if (data == null || (arrayList = data.getUrlList()) == null) {
                                arrayList = new ArrayList();
                            }
                            CompletionBlock<AbsXUploadImageMethodIDL.XUploadImageResultModel> completionBlock2 = completionBlock;
                            XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXUploadImageMethodIDL.XUploadImageResultModel.class));
                            AbsXUploadImageMethodIDL.XUploadImageResultModel xUploadImageResultModel = (AbsXUploadImageMethodIDL.XUploadImageResultModel) createXModel;
                            xUploadImageResultModel.setUrl(arrayList.isEmpty() ^ true ? arrayList.get(0) : "");
                            if (IConditionCallKt.enableXUploadImageUriFix()) {
                                valueOf = String.valueOf(data != null ? data.getUri() : null);
                            } else {
                                valueOf = String.valueOf(data);
                            }
                            xUploadImageResultModel.setUri(valueOf);
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
                            xUploadImageResultModel.setResponse(linkedHashMap);
                            CompletionBlock.DefaultImpls.onSuccess$default(completionBlock2, (XBaseResultModel) createXModel, null, 2, null);
                        } catch (Throwable th) {
                            CompletionBlock<AbsXUploadImageMethodIDL.XUploadImageResultModel> completionBlock3 = completionBlock;
                            String message = th.getMessage();
                            CompletionBlock.DefaultImpls.onFailure$default(completionBlock3, 0, message == null ? "" : message, null, 4, null);
                            XBridge.log("parse post response body failed " + th.getMessage());
                        }
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.utils.IResponseCallback
                    public void onFailed(Integer errorCode, LinkedHashMap<String, String> responseHeader, Throwable throwable, int clientCode) {
                        Intrinsics.checkNotNullParameter(throwable, "throwable");
                        CompletionBlock<AbsXUploadImageMethodIDL.XUploadImageResultModel> completionBlock2 = completionBlock;
                        String message = throwable.getMessage();
                        if (message == null) {
                            message = "";
                        }
                        CompletionBlock.DefaultImpls.onFailure$default(completionBlock2, 0, message, null, 4, null);
                    }
                };
                XBridgeAPIRequestUtils.INSTANCE.post(AbsXUploadImageMethodIDL.XUploadImageParamModel.this.getUrl(), (LinkedHashMap<String, String>) filterHeaderEmptyValue, (LinkedHashMap<String, File>) postFilePart, (Map<String, String>) convertParamValueToString, iResponseCallback, RuntimeHelper.INSTANCE.getNetworkDependInstance(bridgeContext), (r20 & 64) != 0, (r20 & 128) != 0 ? -1 : 0);
            }
        });
    }

    private final LinkedHashMap<String, File> getPostFilePart(Context context, AbsXUploadImageMethodIDL.XUploadImageParamModel uploadParams, CompletionBlock<AbsXUploadImageMethodIDL.XUploadImageResultModel> callback) {
        if (uploadParams.getFormDataBody() != null) {
            List<AbsXUploadImageMethodIDL.XBridgeBeanXUploadImageFormDataBodyBDXBridgeFormDataParamModel> formDataBody = uploadParams.getFormDataBody();
            Intrinsics.checkNotNull(formDataBody);
            List<AbsXUploadImageMethodIDL.XBridgeBeanXUploadImageFormDataBodyBDXBridgeFormDataParamModel> list = formDataBody;
            ArrayList<Pair> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (AbsXUploadImageMethodIDL.XBridgeBeanXUploadImageFormDataBodyBDXBridgeFormDataParamModel xBridgeBeanXUploadImageFormDataBodyBDXBridgeFormDataParamModel : list) {
                File checkPath = checkPath(context, xBridgeBeanXUploadImageFormDataBodyBDXBridgeFormDataParamModel.getValue(), callback, xBridgeBeanXUploadImageFormDataBodyBDXBridgeFormDataParamModel.getKey());
                if (checkPath == null) {
                    return null;
                }
                arrayList.add(new Pair(xBridgeBeanXUploadImageFormDataBodyBDXBridgeFormDataParamModel.getKey(), checkPath));
            }
            LinkedHashMap<String, File> linkedHashMap = new LinkedHashMap<>();
            for (Pair pair : arrayList) {
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
        if (uploadParams.getFilePath().length() > 0) {
            File checkPath2 = checkPath(context, uploadParams.getFilePath(), callback, "filePath");
            if (checkPath2 == null) {
                return null;
            }
            return MapsKt.linkedMapOf(new Pair[]{TuplesKt.to(MessagePart.TYPE_FILE, checkPath2)});
        }
        CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "filePath or formDataBody can not be null.", null, 4, null);
        return null;
    }

    private final boolean isMediaImage(Context context, String url, File file) {
        Uri parse = Uri.parse(url);
        String scheme = parse.getScheme();
        boolean z = true;
        if (scheme == null || scheme.length() == 0) {
            String[] strArr = this.imageTypeArray;
            String extension = FilesKt.getExtension(file);
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            if (extension == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = extension.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            return ArraysKt.contains(strArr, lowerCase);
        }
        String type = context.getContentResolver().getType(parse);
        String str = type;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            return false;
        }
        return StringsKt.startsWith$default(type, "image/", false, 2, (Object) null);
    }

    private final File checkPath(Context context, String url, CompletionBlock<AbsXUploadImageMethodIDL.XUploadImageResultModel> callback, String key) {
        BulletSettings provideBulletSettings;
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
        ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
        if (((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? false : provideBulletSettings.getEnableUploadImageTypeLimit()) && !isMediaImage(context, url, file)) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "File is not of image type", null, 4, null);
            return null;
        }
        if (!file.exists() || file.length() == 0) {
            if (file.exists() && file.length() == 0 && !this.hasPermission) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "file.length is 0, permission denied", null, 4, null);
            } else {
                CompletionBlock.DefaultImpls.onFailure$default(callback, -9, "File is not exist.The key is " + key, null, 4, null);
            }
            return null;
        }
        if (!file.isFile()) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -9, "File is not file.The key is " + key, null, 4, null);
            return null;
        }
        ArgusGlobalDelegate companion = ArgusGlobalDelegate.Companion.getInstance();
        AspectVerifyResult verifyAboutToUploadFile = companion != null ? companion.verifyAboutToUploadFile(new AboutToUploadFileParams(absoluteFilePath, "x.uploadImage")) : null;
        if (!(verifyAboutToUploadFile != null && verifyAboutToUploadFile.isBlock())) {
            return file;
        }
        CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "file path " + absoluteFilePath + " contains sensitive content", null, 4, null);
        return null;
    }
}
