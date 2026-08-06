package com.bytedance.sdk.xbridge.cn.media.idl_bridge;

import android.app.Activity;
import android.content.Context;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.ies.argus.api.ArgusGlobalDelegate;
import com.bytedance.ies.argus.api.params.AboutToUploadFileParams;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.media.idl_bridge.AbsXUploadFileMethodIDL;
import com.bytedance.sdk.xbridge.cn.media.utils.AppFileUtils;
import com.bytedance.sdk.xbridge.cn.media.utils.AvatarUri;
import com.bytedance.sdk.xbridge.cn.media.utils.UploadFileResponse;
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
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;

/* compiled from: XUploadFileMethod.kt */
@XBridgeMethod(name = "x.uploadFile")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J2\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\tH\u0002JF\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0019j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u001a2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001c2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J.\u0010 \u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/XUploadFileMethod;", "Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/AbsXUploadFileMethodIDL;", "()V", "TAG", "", "fileTypeBlackList", "", "[Ljava/lang/String;", "hasPermission", "", "checkPath", "Ljava/io/File;", "context", "Landroid/content/Context;", IWeixinService.ResponseConstants.URL, "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/AbsXUploadFileMethodIDL$XUploadFileResultModel;", "key", "getNetworkDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostNetworkDepend;", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "isPureClient", "getPostFilePart", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "uploadParams", "Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/AbsXUploadFileMethodIDL$XUploadFileParamModel;", "handle", "", "params", "handleUploadFile", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class XUploadFileMethod extends AbsXUploadFileMethodIDL {
    private final String TAG = "XUploadFileMethod";
    private final String[] fileTypeBlackList = {"xml", "db"};
    private boolean hasPermission;

    /* JADX INFO: Access modifiers changed from: private */
    public final IHostNetworkDepend getNetworkDependInstance(IBDXBridgeContext bridgeContext, boolean isPureClient) {
        if (isPureClient) {
            return RuntimeHelper.INSTANCE.getPureNetworkDependInstance(bridgeContext);
        }
        return RuntimeHelper.INSTANCE.getNetworkDependInstance(bridgeContext);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(final IBDXBridgeContext bridgeContext, final AbsXUploadFileMethodIDL.XUploadFileParamModel params, final CompletionBlock<AbsXUploadFileMethodIDL.XUploadFileResultModel> callback) {
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
            String[] readExternalStorageForAllTypeWithArray = XBridgePermissionUtils.INSTANCE.getReadExternalStorageForAllTypeWithArray();
            z = permissionDependInstance.isPermissionAllGranted(activity2, (String[]) Arrays.copyOf(readExternalStorageForAllTypeWithArray, readExternalStorageForAllTypeWithArray.length));
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
            String[] readExternalStorageForAllTypeWithArray2 = XBridgePermissionUtils.INSTANCE.getReadExternalStorageForAllTypeWithArray();
            permissionDependInstance2.requestPermission(activity2, bridgeContext, name, (String[]) Arrays.copyOf(readExternalStorageForAllTypeWithArray2, readExternalStorageForAllTypeWithArray2.length), new OnPermissionCallback() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XUploadFileMethod$handle$1
                @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback
                public void onResult(boolean allGranted, Map<String, ? extends PermissionState> result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (allGranted) {
                        XUploadFileMethod.this.handleUploadFile(bridgeContext, ownerActivity, params, callback);
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleUploadFile(final IBDXBridgeContext bridgeContext, Context context, final AbsXUploadFileMethodIDL.XUploadFileParamModel uploadParams, final CompletionBlock<AbsXUploadFileMethodIDL.XUploadFileResultModel> callback) {
        final LinkedHashMap<String, File> postFilePart = getPostFilePart(context, uploadParams, callback);
        if (postFilePart == null) {
            return;
        }
        RuntimeHelper.INSTANCE.getExecutorService(bridgeContext).execute(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XUploadFileMethod$handleUploadFile$1
            @Override // java.lang.Runnable
            public final void run() {
                IHostNetworkDepend networkDependInstance;
                LinkedHashMap<String, String> filterHeaderEmptyValue = XBridgeAPIRequestUtils.INSTANCE.filterHeaderEmptyValue(AbsXUploadFileMethodIDL.XUploadFileParamModel.this.getHeader());
                XBridgeAPIRequestUtils.INSTANCE.addXSecurityArgusHeader(filterHeaderEmptyValue, bridgeContext);
                Map<String, String> convertParamValueToString = XBridgeAPIRequestUtils.INSTANCE.convertParamValueToString(AbsXUploadFileMethodIDL.XUploadFileParamModel.this.getParams());
                final CompletionBlock<AbsXUploadFileMethodIDL.XUploadFileResultModel> completionBlock = callback;
                IResponseCallback iResponseCallback = new IResponseCallback() { // from class: com.bytedance.sdk.xbridge.cn.media.idl_bridge.XUploadFileMethod$handleUploadFile$1$responseCallback$1
                    @Override // com.bytedance.sdk.xbridge.cn.runtime.utils.IResponseCallback
                    public Unit onParsingFailed(JSONObject jSONObject, LinkedHashMap<String, String> linkedHashMap, String str, Throwable th, Integer num, int i) {
                        return IResponseCallback.DefaultImpls.onParsingFailed(this, jSONObject, linkedHashMap, str, th, num, i);
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.utils.IResponseCallback
                    public void onSuccess(JSONObject body, LinkedHashMap<String, String> responseHeader, Integer statusCode, int clientCode) {
                        int intValue;
                        ArrayList arrayList;
                        Intrinsics.checkNotNullParameter(body, "body");
                        Intrinsics.checkNotNullParameter(responseHeader, "responseHeader");
                        if (statusCode != null) {
                            try {
                                intValue = statusCode.intValue();
                            } catch (Throwable th) {
                                CompletionBlock<AbsXUploadFileMethodIDL.XUploadFileResultModel> completionBlock2 = completionBlock;
                                String message = th.getMessage();
                                CompletionBlock.DefaultImpls.onFailure$default(completionBlock2, 0, message == null ? "" : message, null, 4, null);
                                XBridge.log("parse post response body failed " + th.getMessage());
                                return;
                            }
                        } else {
                            intValue = -1;
                        }
                        JsonUtils jsonUtils = JsonUtils.INSTANCE;
                        String jSONObject = body.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "body.toString()");
                        AvatarUri data = ((UploadFileResponse) jsonUtils.fromJson(jSONObject, UploadFileResponse.class)).getData();
                        if (data == null || (arrayList = data.getUrlList()) == null) {
                            arrayList = new ArrayList();
                        }
                        CompletionBlock<AbsXUploadFileMethodIDL.XUploadFileResultModel> completionBlock3 = completionBlock;
                        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXUploadFileMethodIDL.XUploadFileResultModel.class));
                        AbsXUploadFileMethodIDL.XUploadFileResultModel xUploadFileResultModel = (AbsXUploadFileMethodIDL.XUploadFileResultModel) createXModel;
                        xUploadFileResultModel.setUrl(arrayList.isEmpty() ^ true ? arrayList.get(0) : "");
                        xUploadFileResultModel.setHttpCode(Integer.valueOf(intValue));
                        xUploadFileResultModel.setClientCode(Integer.valueOf(clientCode));
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
                        xUploadFileResultModel.setResponse(linkedHashMap);
                        CompletionBlock.DefaultImpls.onSuccess$default(completionBlock3, (XBaseResultModel) createXModel, null, 2, null);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.bytedance.sdk.xbridge.cn.runtime.utils.IResponseCallback
                    public void onFailed(Integer errorCode, LinkedHashMap<String, String> responseHeader, Throwable throwable, int clientCode) {
                        Intrinsics.checkNotNullParameter(throwable, "throwable");
                        int i = throwable instanceof NetworkNotAvailabeException ? -1001 : 0;
                        CompletionBlock<AbsXUploadFileMethodIDL.XUploadFileResultModel> completionBlock2 = completionBlock;
                        String message = throwable.getMessage();
                        if (message == null) {
                            message = "";
                        }
                        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXUploadFileMethodIDL.XUploadFileResultModel.class));
                        AbsXUploadFileMethodIDL.XUploadFileResultModel xUploadFileResultModel = (AbsXUploadFileMethodIDL.XUploadFileResultModel) createXModel;
                        int i2 = XBridgeAPIRequestUtils.ERROR_CODE_408;
                        xUploadFileResultModel.setHttpCode(errorCode != null ? errorCode : Integer.valueOf(XBridgeAPIRequestUtils.ERROR_CODE_408));
                        xUploadFileResultModel.setClientCode(Integer.valueOf(clientCode));
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
                        xUploadFileResultModel.setResponse(linkedHashMap);
                        Unit unit = Unit.INSTANCE;
                        completionBlock2.onFailure(i, message, (XBaseResultModel) createXModel);
                    }
                };
                XBridgeAPIRequestUtils xBridgeAPIRequestUtils = XBridgeAPIRequestUtils.INSTANCE;
                String url = AbsXUploadFileMethodIDL.XUploadFileParamModel.this.getUrl();
                LinkedHashMap<String, File> linkedHashMap = postFilePart;
                networkDependInstance = this.getNetworkDependInstance(bridgeContext, !AbsXUploadFileMethodIDL.XUploadFileParamModel.this.getAddCommonParams());
                xBridgeAPIRequestUtils.post(url, (LinkedHashMap<String, String>) filterHeaderEmptyValue, (LinkedHashMap<String, File>) linkedHashMap, (Map<String, String>) convertParamValueToString, iResponseCallback, networkDependInstance, (r20 & 64) != 0 ? true : AbsXUploadFileMethodIDL.XUploadFileParamModel.this.getAddCommonParams(), (r20 & 128) != 0 ? -1 : 0);
            }
        });
    }

    private final LinkedHashMap<String, File> getPostFilePart(Context context, AbsXUploadFileMethodIDL.XUploadFileParamModel uploadParams, CompletionBlock<AbsXUploadFileMethodIDL.XUploadFileResultModel> callback) {
        BulletSettings provideBulletSettings;
        if (uploadParams.getFilePath().length() > 0) {
            File checkPath = checkPath(context, uploadParams.getFilePath(), callback, "filePath");
            if (checkPath == null) {
                return null;
            }
            ISettingService iSettingService = ServiceCenter.Companion.instance().get(ISettingService.class);
            if ((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? false : provideBulletSettings.getEnableUploadFileTypeLimit()) {
                String[] strArr = this.fileTypeBlackList;
                String extension = FilesKt.getExtension(checkPath);
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                if (extension == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = extension.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (ArraysKt.contains(strArr, lowerCase)) {
                    CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "file type cannot be .db or .xml", null, 4, null);
                    return null;
                }
            }
            return MapsKt.linkedMapOf(new Pair[]{TuplesKt.to(MessagePart.TYPE_FILE, checkPath)});
        }
        CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "filePath or formDataBody can not be null.", null, 4, null);
        return null;
    }

    private final File checkPath(Context context, String url, CompletionBlock<AbsXUploadFileMethodIDL.XUploadFileResultModel> callback, String key) {
        String str = url;
        boolean z = false;
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
        if (!file.exists() || file.length() == 0) {
            if (file.exists() && file.length() == 0) {
                if (!this.hasPermission) {
                    CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "permission denied", null, 4, null);
                    return null;
                }
            }
            CompletionBlock.DefaultImpls.onFailure$default(callback, -9, "File is not exist.The key is " + key, null, 4, null);
            return null;
        }
        if (!file.isFile()) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -9, "File is not file.The key is " + key, null, 4, null);
            return null;
        }
        ArgusGlobalDelegate companion = ArgusGlobalDelegate.Companion.getInstance();
        AspectVerifyResult verifyAboutToUploadFile = companion != null ? companion.verifyAboutToUploadFile(new AboutToUploadFileParams(absoluteFilePath, "x.uploadFile")) : null;
        if (verifyAboutToUploadFile != null && verifyAboutToUploadFile.isBlock()) {
            z = true;
        }
        if (!z) {
            return file;
        }
        CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "file path " + absoluteFilePath + " contains sensitive content", null, 4, null);
        return null;
    }
}
