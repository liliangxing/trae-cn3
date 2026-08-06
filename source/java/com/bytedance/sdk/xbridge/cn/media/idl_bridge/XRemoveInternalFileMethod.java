package com.bytedance.sdk.xbridge.cn.media.idl_bridge;

import android.app.Activity;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.media.idl.AbsXRemoveInternalFileMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* compiled from: XRemoveInternalFileMethod.kt */
@XBridgeMethod(name = "x.removeInternalFile")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/XRemoveInternalFileMethod;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXRemoveInternalFileMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXRemoveInternalFileMethodIDL$XRemoveInternalFileParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXRemoveInternalFileMethodIDL$XRemoveInternalFileResultModel;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XRemoveInternalFileMethod extends AbsXRemoveInternalFileMethodIDL {
    public static final int ERROR_CODE_FILE_DELETE_FAIL = 13;
    public static final int ERROR_CODE_FILE_IS_FOLDER = 12;
    public static final int ERROR_CODE_FILE_NOT_EXIST = 11;
    public static final int ERROR_CODE_FILE_NOT_INTERNAL_FILE = 14;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXRemoveInternalFileMethodIDL.XRemoveInternalFileParamModel params, CompletionBlock<AbsXRemoveInternalFileMethodIDL.XRemoveInternalFileResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String absolutePath = params.getAbsolutePath();
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -10, "context is invalid", null, 4, null);
            return;
        }
        if (absolutePath.length() == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "absolutePath can not be empty", null, 4, null);
            return;
        }
        String[] strArr = new String[2];
        String absolutePath2 = ownerActivity.getCacheDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath2, "context.cacheDir.absolutePath");
        strArr[0] = absolutePath2;
        File externalCacheDir = ownerActivity.getExternalCacheDir();
        String absolutePath3 = externalCacheDir != null ? externalCacheDir.getAbsolutePath() : null;
        if (absolutePath3 == null) {
            absolutePath3 = "INVALID_PATH";
        }
        strArr[1] = absolutePath3;
        Iterator it = CollectionsKt.listOf(strArr).iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (StringsKt.startsWith$default(absolutePath, (String) it.next(), false, 2, (Object) null)) {
                z = true;
            }
        }
        if (!z) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 14, "non internal file is not support", null, 4, null);
            return;
        }
        File file = new File(absolutePath);
        if (!file.exists()) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 11, "file not exist", null, 4, null);
            return;
        }
        if (file.isDirectory()) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 12, "directory is not support", null, 4, null);
        } else if (!file.delete()) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 13, "delete file fail", null, 4, null);
        } else {
            callback.onSuccess((XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXRemoveInternalFileMethodIDL.XRemoveInternalFileResultModel.class)), "success");
        }
    }
}
