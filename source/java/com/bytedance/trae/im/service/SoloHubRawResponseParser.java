package com.bytedance.trae.im.service;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SoloHubRawResponseParser.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/im/service/SoloHubRawResponseParser;", "", "<init>", "()V", "SUCCESS_CODES", "", "", "parseBizResponse", "Lcom/bytedance/trae/network/response/BizResponse;", "T", "body", "", "dataType", "Ljava/lang/reflect/Type;", "ssResponse", "Lcom/bytedance/retrofit2/SsResponse;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SoloHubRawResponseParser {
    public static final SoloHubRawResponseParser INSTANCE = new SoloHubRawResponseParser();
    private static final Set<Long> SUCCESS_CODES = SetsKt.setOf(200L);

    private SoloHubRawResponseParser() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BizResponse parseBizResponse$default(SoloHubRawResponseParser soloHubRawResponseParser, String str, Type type, SsResponse ssResponse, int i, Object obj) {
        if ((i & 4) != 0) {
            ssResponse = null;
        }
        return soloHubRawResponseParser.parseBizResponse(str, type, ssResponse);
    }

    public final <T> BizResponse<T> parseBizResponse(String body, Type dataType, SsResponse<String> ssResponse) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(dataType, "dataType");
        BizResponse<T> bizResponse = (BizResponse) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(body, TypeToken.getParameterized(BizResponse.class, new Type[]{dataType}).getType());
        if (ssResponse != null) {
            bizResponse.setupSSResponse(ssResponse);
        }
        bizResponse.setupSuccessCodes(SUCCESS_CODES);
        Intrinsics.checkNotNull(bizResponse);
        return bizResponse;
    }
}
