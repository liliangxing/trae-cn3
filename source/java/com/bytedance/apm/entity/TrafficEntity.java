package com.bytedance.apm.entity;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class TrafficEntity {
    private long backMobileRecBytes;
    private long backMobileSendBytes;
    public long backTotalBytes;
    private long backWifiRecBytes;
    private long backWifiSendBytes;
    private long frontMobileRecBytes;
    private long frontMobileSendBytes;
    public long frontTotalBytes;
    private long frontWifiRecBytes;
    private long frontWifiSendBytes;
    public long sid;

    public List<TrafficLogEntity> convertToTrafficLogList() {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.frontMobileRecBytes > 0) {
            arrayList.add(new TrafficLogEntity(this.frontMobileRecBytes, 1, 0, 0, currentTimeMillis));
        }
        if (this.frontMobileSendBytes > 0) {
            arrayList.add(new TrafficLogEntity(this.frontMobileSendBytes, 1, 0, 1, currentTimeMillis));
        }
        if (this.frontWifiRecBytes > 0) {
            arrayList.add(new TrafficLogEntity(this.frontWifiRecBytes, 1, 1, 0, currentTimeMillis));
        }
        if (this.frontWifiSendBytes > 0) {
            arrayList.add(new TrafficLogEntity(this.frontWifiSendBytes, 1, 1, 1, currentTimeMillis));
        }
        if (this.backMobileRecBytes > 0) {
            arrayList.add(new TrafficLogEntity(this.backMobileRecBytes, 0, 0, 0, currentTimeMillis));
        }
        if (this.backMobileSendBytes > 0) {
            arrayList.add(new TrafficLogEntity(this.backMobileSendBytes, 0, 0, 1, currentTimeMillis));
        }
        if (this.backWifiRecBytes > 0) {
            arrayList.add(new TrafficLogEntity(this.backWifiRecBytes, 0, 1, 0, currentTimeMillis));
        }
        if (this.backWifiSendBytes > 0) {
            arrayList.add(new TrafficLogEntity(this.backWifiSendBytes, 0, 1, 1, currentTimeMillis));
        }
        return arrayList;
    }

    public void setSid(long j) {
        this.sid = j;
    }

    public long getFrontWifiSendBytes() {
        return this.frontWifiSendBytes;
    }

    public void setFrontWifiSendBytes(long j) {
        this.frontWifiSendBytes = j;
    }

    public long getFrontWifiRecBytes() {
        return this.frontWifiRecBytes;
    }

    public void setFrontWifiRecBytes(long j) {
        this.frontWifiRecBytes = j;
    }

    public long getFrontMobileSendBytes() {
        return this.frontMobileSendBytes;
    }

    public void setFrontMobileSendBytes(long j) {
        this.frontMobileSendBytes = j;
    }

    public long getFrontMobileRecBytes() {
        return this.frontMobileRecBytes;
    }

    public void setFrontMobileRecBytes(long j) {
        this.frontMobileRecBytes = j;
    }

    public long getBackWifiSendBytes() {
        return this.backWifiSendBytes;
    }

    public void setBackWifiSendBytes(long j) {
        this.backWifiSendBytes = j;
    }

    public long getBackWifiRecBytes() {
        return this.backWifiRecBytes;
    }

    public void setBackWifiRecBytes(long j) {
        this.backWifiRecBytes = j;
    }

    public long getBackMobileSendBytes() {
        return this.backMobileSendBytes;
    }

    public void setBackMobileSendBytes(long j) {
        this.backMobileSendBytes = j;
    }

    public long getBackMobileRecBytes() {
        return this.backMobileRecBytes;
    }

    public void setBackMobileRecBytes(long j) {
        this.backMobileRecBytes = j;
    }

    public long getFrontTotalBytes() {
        return this.frontTotalBytes;
    }

    public void setFrontTotalBytes(long j) {
        this.frontTotalBytes = j;
    }

    public long getBackTotalBytes() {
        return this.backTotalBytes;
    }

    public void setBackTotalBytes(long j) {
        this.backTotalBytes = j;
    }

    public String toString() {
        return "TrafficEntity{frontWifiSendBytes=" + this.frontWifiSendBytes + ", frontWifiRecBytes=" + this.frontWifiRecBytes + ", frontMobileSendBytes=" + this.frontMobileSendBytes + ", frontMobileRecBytes=" + this.frontMobileRecBytes + ", backWifiSendBytes=" + this.backWifiSendBytes + ", backWifiRecBytes=" + this.backWifiRecBytes + ", backMobileSendBytes=" + this.backMobileSendBytes + ", backMobileRecBytes=" + this.backMobileRecBytes + ", frontTotalBytes=" + this.frontTotalBytes + ", backTotalBytes=" + this.backTotalBytes + ContainerUtils.KEY_VALUE_DELIMITER + this.sid + AbstractJsonLexerKt.END_OBJ;
    }
}
