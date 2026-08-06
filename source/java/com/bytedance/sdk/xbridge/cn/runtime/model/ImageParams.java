package com.bytedance.sdk.xbridge.cn.runtime.model;

import kotlin.Metadata;

/* compiled from: XChooseMediaParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/model/ImageParams;", "", "cropWidth", "", "cropHeight", "compressMaxSize", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getCompressMaxSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCropHeight", "()Ljava/lang/String;", "getCropWidth", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class ImageParams {
    private final Integer compressMaxSize;
    private final String cropHeight;
    private final String cropWidth;

    public ImageParams(String str, String str2, Integer num) {
        this.cropWidth = str;
        this.cropHeight = str2;
        this.compressMaxSize = num;
    }

    public final String getCropWidth() {
        return this.cropWidth;
    }

    public final String getCropHeight() {
        return this.cropHeight;
    }

    public final Integer getCompressMaxSize() {
        return this.compressMaxSize;
    }
}
