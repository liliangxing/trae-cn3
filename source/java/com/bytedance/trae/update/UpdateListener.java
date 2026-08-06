package com.bytedance.trae.update;

import com.bytedance.trae.utils.logger.FLogger;
import com.ss.android.update.OnUpdateStatusChangedListener;
import kotlin.Metadata;

/* compiled from: IBitsUpdateImpl.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/update/UpdateListener;", "Lcom/ss/android/update/OnUpdateStatusChangedListener;", "<init>", "()V", "TAG", "", "saveDownloadInfo", "", "size", "", "etag", "pre", "", "updateProgress", "byteSoFar", "contentLength", "downloadResult", "isSuccess", "onPrepare", "onUpdateStatusChanged", "status", "bits-impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class UpdateListener implements OnUpdateStatusChangedListener {
    private final String TAG = "update_sdk";

    public void saveDownloadInfo(int size, String etag, boolean pre) {
        FLogger.INSTANCE.mo428i(this.TAG, "saveDownloadInfo etag:" + etag + ",pre:" + pre);
    }

    public void updateProgress(int byteSoFar, int contentLength, boolean pre) {
        FLogger.INSTANCE.mo425d(this.TAG, "updateProgress byteSoFar:" + byteSoFar + ",contentLength:" + contentLength + ",pre:" + pre);
    }

    public void downloadResult(boolean isSuccess, boolean pre) {
        FLogger.INSTANCE.mo428i(this.TAG, "downloadResult isSuccess:" + isSuccess + ",pre:" + pre);
    }

    public void onPrepare(boolean pre) {
        FLogger.INSTANCE.mo428i(this.TAG, "onPrepare pre:" + pre);
    }

    public void onUpdateStatusChanged(int status) {
        FLogger.INSTANCE.mo428i(this.TAG, "onUpdateStatusChanged status:" + status);
    }
}
