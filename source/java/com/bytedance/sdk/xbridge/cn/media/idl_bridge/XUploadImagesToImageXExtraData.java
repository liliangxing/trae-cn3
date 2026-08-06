package com.bytedance.sdk.xbridge.cn.media.idl_bridge;

import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: XUploadImagesToImageXMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/XUploadImagesToImageXExtraData;", "", "absoluteFilePaths", "Ljava/util/ArrayList;", "", "getAbsoluteFilePaths", "()Ljava/util/ArrayList;", "curTraceId", "getCurTraceId", "()Ljava/lang/String;", "isBoeEnable", "", "()Ljava/lang/Boolean;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface XUploadImagesToImageXExtraData {
    ArrayList<String> getAbsoluteFilePaths();

    String getCurTraceId();

    Boolean isBoeEnable();
}
