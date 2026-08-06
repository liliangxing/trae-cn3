package com.ss.android.download.api;

import android.content.Context;
import com.ss.android.download.api.download.extend.DownloadInfoChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.socialbase.appdownloader.AppTaskBuilder;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface DownloadHelper {
    long addDownloadTaskWithEvent(String str, String str2, Context context, String str3, Map<String, String> map, JSONObject jSONObject, boolean z);

    long addDownloadTaskWithEvent(String str, String str2, Context context, String str3, Map<String, String> map, JSONObject jSONObject, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str4, String str5, boolean z6);

    int addDownloadTaskWithNewDownloader(boolean z, boolean z2, JSONObject jSONObject, AppTaskBuilder appTaskBuilder);

    String getDownloadExtra(long j);

    void handleStatusClick(Context context, int i, long j);

    void handleStatusClick(Context context, int i, long j, String str);

    boolean isDownloadSuccessAndFileNotExist(DownloadShortInfo downloadShortInfo);

    void markRowDeleted(long... jArr);

    void pauseDownload(long... jArr);

    DownloadShortInfo queryDownloadInfo(String str);

    void remove(long... jArr);

    void restartDownload(int i, long... jArr);

    void resumeDownload(long... jArr);

    void setDownloadExtra(Long l, String str, int i, String str2, boolean z);

    void setDownloadExtra(Long l, String str, int i, String str2, boolean z, long j);

    void setDownloadListener(Long l, DownloadInfoChangeListener downloadInfoChangeListener);

    void setDownloadListenerAndExtra(Long l, DownloadInfoChangeListener downloadInfoChangeListener, String str, int i, String str2);

    void startViewIntent(Context context, long j, int i);

    void unsetDownloadListener(Long l, DownloadInfoChangeListener downloadInfoChangeListener);
}
