package com.bytedance.sdk.xbridge.cn.media.idl_bridge;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

/* compiled from: XUploadVideoToVODMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001e\u0010\u0006\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\bj\u0002`\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/IUploadVideoToVODCallback;", "", "onComplete", "", "info", "Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/VODInfo;", "onException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onFail", "onUpdateProgress", NotificationCompat.CATEGORY_PROGRESS, "", "onUploadCancel", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IUploadVideoToVODCallback {
    void onComplete(VODInfo info);

    void onException(Exception e, VODInfo info);

    void onFail(VODInfo info);

    void onUpdateProgress(long progress);

    void onUploadCancel(VODInfo info);
}
