package com.bytedance.reparo.download;

import android.text.TextUtils;
import com.bytedance.reparo.core.common.utils.FileUtils;
import com.bytedance.reparo.core.exception.PatchDownloadException;
import com.bytedance.reparo.secondary.Logger;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PatchDownloader {
    private static final int CONNECT_TIMEOUT = 60000;
    private static final int IO_TIMEOUT = 60000;
    private static final String TAG = "PatchDownloader";
    private DownloadCallback callback;
    private OkHttpClient client = createClient();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface DownloadCallback {
        void onDownloadFailed(PatchDownloadException patchDownloadException);

        void onDownloadSuccess(File file);
    }

    private OkHttpClient createClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(60000L, TimeUnit.MILLISECONDS);
        builder.readTimeout(60000L, TimeUnit.MILLISECONDS);
        builder.followRedirects(true);
        return builder.build();
    }

    public void downloadPatch(String str, File file, DownloadCallback downloadCallback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Logger.m328i(TAG, "start to download, will save to " + file.getAbsolutePath());
        this.callback = downloadCallback;
        try {
            Response execute = this.client.newCall(new Request.Builder().url(str).build()).execute();
            if (!execute.isSuccessful()) {
                onDownLoadFailed(new PatchDownloadException(execute.body().string()));
            } else {
                FileUtils.write(execute.body().byteStream(), file);
                onDownloadSuccess(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
            onDownLoadFailed(new PatchDownloadException("down load " + str + " failed.", e));
        }
    }

    private void onDownLoadFailed(PatchDownloadException patchDownloadException) {
        DownloadCallback downloadCallback = this.callback;
        if (downloadCallback != null) {
            downloadCallback.onDownloadFailed(patchDownloadException);
        }
    }

    private void onDownloadSuccess(File file) {
        DownloadCallback downloadCallback = this.callback;
        if (downloadCallback != null) {
            downloadCallback.onDownloadSuccess(file);
        }
    }
}
