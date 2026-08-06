package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes7.dex */
public abstract class AbsNotificationItem {
    private long curBytes;
    private String description;
    private long firstShowTime;
    private int id;
    protected Notification notification;
    private boolean ongoing;
    private String title;
    private long totalBytes;
    private int status = 0;
    private AtomicInteger clickInstallTimes = new AtomicInteger(0);

    public abstract void updateNotification(BaseException baseException, boolean z);

    public AbsNotificationItem(int i, String str) {
        this.id = i;
        this.title = str;
    }

    public void updateNotificationItem(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.id = downloadInfo.getId();
        this.title = downloadInfo.getTitle();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public long getCurBytes() {
        return this.curBytes;
    }

    public void setCurBytes(long j) {
        this.curBytes = j;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public void setTotalBytes(long j) {
        this.totalBytes = j;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void refreshStatus(int i, BaseException baseException, boolean z) {
        refreshStatus(i, baseException, z, false);
    }

    public void refreshStatus(int i, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.status != i) {
            this.status = i;
            updateNotification(baseException, z);
        }
    }

    public long getFirstShowTime() {
        if (this.firstShowTime == 0) {
            this.firstShowTime = System.currentTimeMillis();
        }
        return this.firstShowTime;
    }

    public void refreshProgress(long j, long j2) {
        this.curBytes = j;
        this.totalBytes = j2;
        this.status = 4;
        updateNotification(null, false);
    }

    public void notify(Notification notification) {
        if (this.id == 0 || notification == null) {
            return;
        }
        DownloadNotificationManager.getInstance().notifyByService(this.id, this.status, notification);
    }

    public void cancel() {
        if (this.id == 0) {
            return;
        }
        DownloadNotificationManager.getInstance().cancel(this.id);
    }

    public void recordClickInstall() {
        this.clickInstallTimes.incrementAndGet();
    }

    public int getClickInstallTimes() {
        return this.clickInstallTimes.get();
    }

    public boolean isOngoing() {
        return this.ongoing;
    }

    protected void setOngoing(boolean z) {
        this.ongoing = z;
    }

    public Notification getNotification() {
        return this.notification;
    }
}
