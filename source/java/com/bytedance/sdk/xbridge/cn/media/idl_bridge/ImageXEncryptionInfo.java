package com.bytedance.sdk.xbridge.cn.media.idl_bridge;

import kotlin.Metadata;

/* compiled from: XUploadImagesToImageXMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/ImageXEncryptionInfo;", "", "mAESIV", "", "getMAESIV", "()Ljava/lang/String;", "mAESKey", "getMAESKey", "mRSAKey", "getMRSAKey", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface ImageXEncryptionInfo {
    String getMAESIV();

    String getMAESKey();

    String getMRSAKey();
}
