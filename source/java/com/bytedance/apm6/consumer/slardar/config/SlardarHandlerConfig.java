package com.bytedance.apm6.consumer.slardar.config;

import android.text.TextUtils;
import com.bytedance.apm6.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class SlardarHandlerConfig {
    public static final int TYPE_ZSTD = 1;
    public static final int TYPE_ZSTD_DICT = 2;
    private int compressType;
    private List<String> exceptionUrl;
    private boolean isEncrypt = true;
    private boolean isUploadInternalExcetpion = true;
    private int keepDays;
    private int maxSizeMB;
    private int maxSizeMBToday;
    private long onceReportMaxSizeBytes;
    private long reportInterval;
    private List<String> reportUrlList;
    private List<String> traceReportUrl;

    public void setCompressType(int i) {
        this.compressType = i;
    }

    public int getCompressType() {
        return this.compressType;
    }

    public void setOnceReportMaxSizeBytes(long j) {
        this.onceReportMaxSizeBytes = j;
    }

    public void setReportInterval(long j) {
        this.reportInterval = j;
    }

    public void setReportUrlList(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.reportUrlList = list;
    }

    public List<String> getReportUrlList() {
        return this.reportUrlList;
    }

    public void setExceptionUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.exceptionUrl = arrayList;
        arrayList.add(str);
    }

    public void setTraceReportUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.traceReportUrl = arrayList;
        arrayList.add(str);
    }

    public List<String> getTraceReportUrl() {
        return this.traceReportUrl;
    }

    public List<String> getExceptionUrl() {
        return this.exceptionUrl;
    }

    public void setEncrypt(boolean z) {
        this.isEncrypt = z;
    }

    public boolean isEncrypt() {
        return this.isEncrypt;
    }

    public boolean isUploadInternalException() {
        return this.isUploadInternalExcetpion;
    }

    public void setUploadInternalException(boolean z) {
        this.isUploadInternalExcetpion = z;
    }

    public long getOnceReportMaxSizeBytes() {
        return this.onceReportMaxSizeBytes;
    }

    public long getReportInterval() {
        return this.reportInterval;
    }

    public int getMaxSizeMB() {
        return this.maxSizeMB;
    }

    public void setMaxSizeMB(int i) {
        this.maxSizeMB = i;
    }

    public int getKeepDays() {
        return this.keepDays;
    }

    public void setKeepDays(int i) {
        this.keepDays = i;
    }

    public int getMaxSizeMBToday() {
        return this.maxSizeMBToday;
    }

    public void setMaxSizeMBToday(int i) {
        this.maxSizeMBToday = i;
    }

    public String toString() {
        return "SlardarHandlerConfig{onceReportMaxSizeBytes=" + this.onceReportMaxSizeBytes + ", reportUrlList=" + this.reportUrlList + ", exceptionUrl=" + this.exceptionUrl + ", traceReportUrl=" + this.traceReportUrl + ", isEncrypt=" + this.isEncrypt + ", isUploadInternalExcetpion=" + this.isUploadInternalExcetpion + ", reportInterval=" + this.reportInterval + ", maxSizeMB=" + this.maxSizeMB + ", keepDays=" + this.keepDays + ", maxSizeMBToday=" + this.maxSizeMBToday + AbstractJsonLexerKt.END_OBJ;
    }
}
