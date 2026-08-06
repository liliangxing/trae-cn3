package com.bytedance.sdk.xbridge.cn.media.idl_bridge;

import kotlin.Metadata;

/* compiled from: XUploadImagesToImageXMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u0018X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0005\"\u0004\b\u001f\u0010\u0007R\u001a\u0010 \u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0005\"\u0004\b\"\u0010\u0007R\u001a\u0010#\u001a\u0004\u0018\u00010\u000fX¦\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013¨\u0006&"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/ImageXInfo;", "", "mEncryptionMeta", "", "getMEncryptionMeta", "()Ljava/lang/String;", "setMEncryptionMeta", "(Ljava/lang/String;)V", "mEnd2EndEncryption", "Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/ImageXEncryptionInfo;", "getMEnd2EndEncryption", "()Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/ImageXEncryptionInfo;", "setMEnd2EndEncryption", "(Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/ImageXEncryptionInfo;)V", "mErrorCode", "", "getMErrorCode", "()Ljava/lang/Long;", "setMErrorCode", "(Ljava/lang/Long;)V", "mErrorMsg", "getMErrorMsg", "setMErrorMsg", "mFileIndex", "", "getMFileIndex", "()Ljava/lang/Integer;", "setMFileIndex", "(Ljava/lang/Integer;)V", "mImageTosKey", "getMImageTosKey", "setMImageTosKey", "mMetaInfo", "getMMetaInfo", "setMMetaInfo", "mProgress", "getMProgress", "setMProgress", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface ImageXInfo {
    String getMEncryptionMeta();

    ImageXEncryptionInfo getMEnd2EndEncryption();

    Long getMErrorCode();

    String getMErrorMsg();

    Integer getMFileIndex();

    String getMImageTosKey();

    String getMMetaInfo();

    Long getMProgress();

    void setMEncryptionMeta(String str);

    void setMEnd2EndEncryption(ImageXEncryptionInfo imageXEncryptionInfo);

    void setMErrorCode(Long l);

    void setMErrorMsg(String str);

    void setMFileIndex(Integer num);

    void setMImageTosKey(String str);

    void setMMetaInfo(String str);

    void setMProgress(Long l);
}
