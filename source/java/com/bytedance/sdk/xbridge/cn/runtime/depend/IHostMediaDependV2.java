package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.content.Context;
import com.bytedance.sdk.xbridge.cn.media.idl.AbsXUploadImagesToImageXMethodIDL;
import com.bytedance.sdk.xbridge.cn.media.idl.AbsXUploadVideoToVODMethodIDL;
import com.bytedance.sdk.xbridge.cn.media.idl_bridge.IUploadImagesToImageXCallback;
import com.bytedance.sdk.xbridge.cn.media.idl_bridge.IUploadVideoToVODCallback;
import com.bytedance.sdk.xbridge.cn.media.idl_bridge.XUploadImagesToImageXExtraData;
import com.bytedance.sdk.xbridge.cn.media.idl_bridge.XUploadVideoToVODExtraData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHostMediaDependV2.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J(\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostMediaDependV2;", "", "closeImageXUpload", "", "closeVideoUpload", "startImageXUpload", "context", "Landroid/content/Context;", "params", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadImagesToImageXMethodIDL$XUploadImagesToImageXParamModel;", "extra", "Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/XUploadImagesToImageXExtraData;", "callback", "Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/IUploadImagesToImageXCallback;", "startVideoUpload", "Lcom/bytedance/sdk/xbridge/cn/media/idl/AbsXUploadVideoToVODMethodIDL$XUploadVideoToVODParamModel;", "Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/XUploadVideoToVODExtraData;", "Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/IUploadVideoToVODCallback;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IHostMediaDependV2 {

    /* compiled from: IHostMediaDependV2.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DefaultImpls {
        public static void closeImageXUpload(IHostMediaDependV2 iHostMediaDependV2) {
        }

        public static void closeVideoUpload(IHostMediaDependV2 iHostMediaDependV2) {
        }

        public static void startImageXUpload(IHostMediaDependV2 iHostMediaDependV2, Context context, AbsXUploadImagesToImageXMethodIDL.XUploadImagesToImageXParamModel xUploadImagesToImageXParamModel, XUploadImagesToImageXExtraData xUploadImagesToImageXExtraData, IUploadImagesToImageXCallback iUploadImagesToImageXCallback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(xUploadImagesToImageXParamModel, "params");
            Intrinsics.checkNotNullParameter(xUploadImagesToImageXExtraData, "extra");
            Intrinsics.checkNotNullParameter(iUploadImagesToImageXCallback, "callback");
        }

        public static void startVideoUpload(IHostMediaDependV2 iHostMediaDependV2, Context context, AbsXUploadVideoToVODMethodIDL.XUploadVideoToVODParamModel xUploadVideoToVODParamModel, XUploadVideoToVODExtraData xUploadVideoToVODExtraData, IUploadVideoToVODCallback iUploadVideoToVODCallback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(xUploadVideoToVODParamModel, "params");
            Intrinsics.checkNotNullParameter(xUploadVideoToVODExtraData, "extra");
            Intrinsics.checkNotNullParameter(iUploadVideoToVODCallback, "callback");
        }
    }

    void closeImageXUpload();

    void closeVideoUpload();

    void startImageXUpload(Context context, AbsXUploadImagesToImageXMethodIDL.XUploadImagesToImageXParamModel params, XUploadImagesToImageXExtraData extra, IUploadImagesToImageXCallback callback);

    void startVideoUpload(Context context, AbsXUploadVideoToVODMethodIDL.XUploadVideoToVODParamModel params, XUploadVideoToVODExtraData extra, IUploadVideoToVODCallback callback);
}
