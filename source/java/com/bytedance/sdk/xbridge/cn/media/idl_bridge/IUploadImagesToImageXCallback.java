package com.bytedance.sdk.xbridge.cn.media.idl_bridge;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

/* compiled from: XUploadImagesToImageXMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J-\u0010\u0004\u001a\u00020\u00032\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010\fJ!\u0010\r\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u001f\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\tH&¢\u0006\u0002\u0010\u0017J!\u0010\u0018\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/IUploadImagesToImageXCallback;", "", "onComplete", "", "onException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCode", "", "errorMessage", "", "(Ljava/lang/Exception;Ljava/lang/Long;Ljava/lang/String;)V", "onFail", "(Ljava/lang/Long;Ljava/lang/String;)V", "onSingleImageComplete", "imageXInfo", "Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/ImageXInfo;", "onSingleImageFail", "onUpdateProgress", "fileIndex", "", NotificationCompat.CATEGORY_PROGRESS, "(Ljava/lang/Integer;J)V", "onUploadCancel", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IUploadImagesToImageXCallback {
    void onComplete();

    void onException(Exception e, Long errorCode, String errorMessage);

    void onFail(Long errorCode, String errorMessage);

    void onSingleImageComplete(ImageXInfo imageXInfo);

    void onSingleImageFail();

    void onUpdateProgress(Integer fileIndex, long progress);

    void onUploadCancel(Long errorCode, String errorMessage);
}
