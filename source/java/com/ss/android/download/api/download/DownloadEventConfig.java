package com.ss.android.download.api.download;

/* loaded from: classes7.dex */
public interface DownloadEventConfig {
    String getClickButtonTag();

    String getClickContinueLabel();

    String getClickContinueTag();

    String getClickInstallLabel();

    String getClickInstallTag();

    String getClickItemTag();

    String getClickLabel();

    String getClickOpenLabel();

    String getClickOpenTag();

    String getClickPauseLabel();

    String getClickPauseTag();

    String getClickStartLabel();

    String getClickStartTag();

    String getClickTag();

    String getCompletedEventTag();

    String getDownloadFailedLabel();

    int getDownloadScene();

    Object getExtraEventObject();

    String getOpenLabel();

    String getOpenTag();

    String getStorageDenyLabel();

    String getStorageDenyTag();

    boolean isEnableClickEvent();

    boolean isEnableCompletedEvent();

    boolean isEnableNoChargeClickEvent();

    boolean isEnableV3Event();
}
