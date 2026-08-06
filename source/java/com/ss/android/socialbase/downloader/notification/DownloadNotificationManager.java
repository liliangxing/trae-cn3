package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadNotificationManager implements IDownloadNotificationManagerService {
    private static volatile DownloadNotificationManager instance;
    private IDownloadNotificationManagerService service = (IDownloadNotificationManagerService) DownloadServiceManager.getService(IDownloadNotificationManagerService.class);

    private DownloadNotificationManager() {
    }

    public static DownloadNotificationManager getInstance() {
        if (instance == null) {
            synchronized (DownloadNotificationManager.class) {
                if (instance == null) {
                    instance = new DownloadNotificationManager();
                }
            }
        }
        return instance;
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void hideNotification(int i) {
        this.service.hideNotification(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void notifyByService(int i, int i2, Notification notification) {
        this.service.notifyByService(i, i2, notification);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void cancel(int i) {
        this.service.cancel(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public SparseArray<AbsNotificationItem> getAllNotificationItems() {
        return this.service.getAllNotificationItems();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void addNotification(AbsNotificationItem absNotificationItem) {
        this.service.addNotification(absNotificationItem);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public AbsNotificationItem removeNotification(int i) {
        return this.service.removeNotification(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public AbsNotificationItem getNotificationItem(int i) {
        return this.service.getNotificationItem(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void cancelNotification(int i) {
        this.service.cancelNotification(i);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void clearNotification() {
        this.service.clearNotification();
    }
}
