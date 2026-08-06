package com.ss.mediakit.downloader;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.mediakit.medialoader.AVMDLLog;
import java.io.IOException;
import java.util.Locale;
import okhttp3.Call;
import okhttp3.Response;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AVMDLResponse {
    private static final String TAG = "AVMDLResponse";
    public Call call;
    public long readOff;
    public AVMDLRequest request;
    public Response response;
    public long contentlength = -1;
    public int statusCode = -1;
    public boolean isReadErr = false;

    public AVMDLResponse(AVMDLRequest aVMDLRequest, Response response, Call call) {
        this.request = aVMDLRequest;
        this.response = response;
        this.call = call;
        this.readOff = aVMDLRequest.reqOff;
        parseResponse();
    }

    private void parseResponse() {
        int lastIndexOf;
        Response response = this.response;
        if (response == null) {
            return;
        }
        int code = response.code();
        this.statusCode = code;
        if (code == 200) {
            this.contentlength = toInt(this.response.header("Content-Length"));
            return;
        }
        if (code == 206) {
            String header = this.response.header(DownloadUtils.CONTENT_RANGE);
            if (TextUtils.isEmpty(header) || (lastIndexOf = header.lastIndexOf("/")) < 0 || lastIndexOf >= header.length() - 1) {
                return;
            }
            this.contentlength = toInt(header.substring(lastIndexOf + 1), -1);
        }
    }

    public int readData(byte[] bArr) {
        if (this.response.body() == null) {
            return 0;
        }
        try {
            final int read = this.response.body().byteStream().read(bArr);
            if (read <= 0) {
                return -1;
            }
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.downloader.AVMDLResponse$$ExternalSyntheticLambda1
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    return AVMDLResponse.this.m4176lambda$readData$0$comssmediakitdownloaderAVMDLResponse();
                }
            });
            long j = read;
            this.readOff += j;
            this.request.reqOff += j;
            if (this.request.size > 0) {
                this.request.size -= j;
            }
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.downloader.AVMDLResponse$$ExternalSyntheticLambda2
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    return AVMDLResponse.this.m4177lambda$readData$1$comssmediakitdownloaderAVMDLResponse(read);
                }
            });
            return read;
        } catch (IOException e) {
            this.isReadErr = true;
            AVMDLLog.m228e(TAG, "read data exception:" + e.getLocalizedMessage());
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$readData$0$com-ss-mediakit-downloader-AVMDLResponse, reason: not valid java name */
    public /* synthetic */ String m4176lambda$readData$0$comssmediakitdownloaderAVMDLResponse() {
        return String.format(Locale.US, "before read off:%d reqoff:%d req size:%d", Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$readData$1$com-ss-mediakit-downloader-AVMDLResponse, reason: not valid java name */
    public /* synthetic */ String m4177lambda$readData$1$comssmediakitdownloaderAVMDLResponse(int i) {
        return String.format(Locale.US, "after read,ret:%d off:%d reqoff:%d req size:%d", Integer.valueOf(i), Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size));
    }

    public void cancel() {
        Call call = this.call;
        if (call != null) {
            call.cancel();
        }
    }

    public void reset() {
        this.response = null;
        this.call = null;
        this.contentlength = -1L;
        this.statusCode = -1;
        this.isReadErr = false;
    }

    public boolean isOpenSuccessful() {
        int i = this.statusCode;
        return i >= 200 && i < 300;
    }

    public boolean isFinish() {
        final long j = this.request.size >= 0 ? this.request.reqOff + this.request.size : this.contentlength;
        long j2 = this.contentlength;
        if (j > j2) {
            j = j2;
        }
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.downloader.AVMDLResponse$$ExternalSyntheticLambda0
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                return AVMDLResponse.this.m4175lambda$isFinish$2$comssmediakitdownloaderAVMDLResponse(j);
            }
        });
        return this.readOff >= j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$isFinish$2$com-ss-mediakit-downloader-AVMDLResponse, reason: not valid java name */
    public /* synthetic */ String m4175lambda$isFinish$2$comssmediakitdownloaderAVMDLResponse(long j) {
        return String.format(Locale.US, "check readoff:%d reqoff:%d reqsize:%d contentlen:%d endoff:%d", Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size), Long.valueOf(this.contentlength), Long.valueOf(j));
    }

    public boolean isReadSuccessful() {
        return !this.isReadErr;
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static int toInt(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
