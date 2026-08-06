package com.huawei.secure.android.common.zip.config;

import com.bytedance.forest.pollyfill.CDNFetchDepender;
import com.bytedance.trae.kmp.artifacts.artifact.ArtifactDiskCacheKt;

/* loaded from: classes6.dex */
public class ZipConfig {
    private String c;
    private String d;
    private String[] e;
    private long a = ArtifactDiskCacheKt.ARTIFACT_CACHE_MAX_BYTES;
    private int b = 6000;
    private String[] f = {"jsp", "php", "php2", "php3", "php4", "php5", "phps", "pht", "phtm", "phtml", "py", "pl", "elf", "lua", "sh", CDNFetchDepender.DEFAULT_EXTENSION};
    private boolean g = true;
    private boolean h = false;

    public ZipConfig(String str, String str2) {
        this.c = str;
        this.d = str2;
    }

    public String[] getBlackListSuffix() {
        return this.f;
    }

    public int getFileNumThreshold() {
        return this.b;
    }

    public String getTargetDir() {
        return this.d;
    }

    public long getTopSizeThreshold() {
        return this.a;
    }

    public String[] getWhiteListSuffix() {
        return this.e;
    }

    public String getZipFile() {
        return this.c;
    }

    public boolean isGbkZipFile() {
        return this.h;
    }

    public boolean isLoadDisk() {
        return this.g;
    }

    public void setBlackListSuffix(String[] strArr) {
        this.f = strArr;
    }

    public void setFileNumThreshold(int i) {
        this.b = i;
    }

    public void setGbkZipFile(boolean z) {
        this.h = z;
    }

    public void setLoadDisk(boolean z) {
        this.g = z;
    }

    public void setTargetDir(String str) {
        this.d = str;
    }

    public void setTopSizeThreshold(long j) {
        this.a = j;
    }

    public void setWhiteListSuffix(String[] strArr) {
        this.e = strArr;
    }

    public void setZipFile(String str) {
        this.c = str;
    }
}
