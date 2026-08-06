package com.ss.android.download.api.download;

import com.ss.android.download.api.model.DeepLink;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public interface DownloadModel {
    void forceHideNotification();

    void forceHideToast();

    void forceWifi();

    String getAppIcon();

    List<String> getClickTrackUrl();

    DeepLink getDeepLink();

    String getDownloadUrl();

    JSONObject getExtra();

    long getExtraValue();

    String getFileName();

    String getFilePath();

    Map<String, String> getHeaders();

    long getId();

    String getLogExtra();

    String getMimeType();

    int getModelType();

    String getName();

    String getPackageName();

    boolean isAd();

    boolean isInExternalPublicDir();

    boolean isNeedWifi();

    boolean isShowNotification();

    boolean isShowToast();

    boolean isVisibleInDownloadsUi();
}
