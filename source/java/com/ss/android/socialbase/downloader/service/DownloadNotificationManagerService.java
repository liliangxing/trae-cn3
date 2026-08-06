package com.ss.android.socialbase.downloader.service;

import android.app.Notification;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManagerImpl;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadNotificationManagerService implements IDownloadNotificationManagerService {
    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void hideNotification(int i) {
        DownloadNotificationManagerImpl.getInstance().hideNotification(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void notifyByService(int i, int i2, Notification notification) {
        DownloadNotificationManagerImpl.getInstance().notifyByService(i, i2, notification);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void cancel(int i) {
        DownloadNotificationManagerImpl.getInstance().cancel(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public SparseArray<AbsNotificationItem> getAllNotificationItems() {
        return DownloadNotificationManagerImpl.getInstance().getAllNotificationItems();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void addNotification(AbsNotificationItem absNotificationItem) {
        DownloadNotificationManagerImpl.getInstance().addNotification(absNotificationItem);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public AbsNotificationItem removeNotification(int i) {
        return DownloadNotificationManagerImpl.getInstance().removeNotification(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public AbsNotificationItem getNotificationItem(int i) {
        return DownloadNotificationManagerImpl.getInstance().getNotificationItem(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void cancelNotification(int i) {
        DownloadNotificationManagerImpl.getInstance().cancelNotification(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void clearNotification() {
        DownloadNotificationManagerImpl.getInstance().clearNotification();
    }
}
