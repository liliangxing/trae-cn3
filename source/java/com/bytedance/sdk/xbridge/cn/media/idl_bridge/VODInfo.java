package com.bytedance.sdk.xbridge.cn.media.idl_bridge;

import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: XUploadVideoToVODMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001bX¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u0004\u0018\u00010\u000fX¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001a\u0010#\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0005\"\u0004\b%\u0010\u0007R\u001a\u0010&\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0005\"\u0004\b(\u0010\u0007R\u001a\u0010)\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b*\u0010\u0005\"\u0004\b+\u0010\u0007¨\u0006,"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/idl_bridge/VODInfo;", "", "mCallbackArgs", "", "getMCallbackArgs", "()Ljava/lang/String;", "setMCallbackArgs", "(Ljava/lang/String;)V", "mCoverUri", "getMCoverUri", "setMCoverUri", "mEncryptionMeta", "getMEncryptionMeta", "setMEncryptionMeta", "mErrorCode", "", "getMErrorCode", "()Ljava/lang/Long;", "setMErrorCode", "(Ljava/lang/Long;)V", "mErrorMsg", "getMErrorMsg", "setMErrorMsg", "mFileIndex", "getMFileIndex", "setMFileIndex", "mLog", "Lorg/json/JSONObject;", "getMLog", "()Lorg/json/JSONObject;", "setMLog", "(Lorg/json/JSONObject;)V", "mProgress", "getMProgress", "setMProgress", "mTosKey", "getMTosKey", "setMTosKey", "mVideoId", "getMVideoId", "setMVideoId", "mVideoMediaInfo", "getMVideoMediaInfo", "setMVideoMediaInfo", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface VODInfo {
    String getMCallbackArgs();

    String getMCoverUri();

    String getMEncryptionMeta();

    Long getMErrorCode();

    String getMErrorMsg();

    Long getMFileIndex();

    JSONObject getMLog();

    Long getMProgress();

    String getMTosKey();

    String getMVideoId();

    String getMVideoMediaInfo();

    void setMCallbackArgs(String str);

    void setMCoverUri(String str);

    void setMEncryptionMeta(String str);

    void setMErrorCode(Long l);

    void setMErrorMsg(String str);

    void setMFileIndex(Long l);

    void setMLog(JSONObject jSONObject);

    void setMProgress(Long l);

    void setMTosKey(String str);

    void setMVideoId(String str);

    void setMVideoMediaInfo(String str);
}
