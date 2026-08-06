package com.bytedance.trae.login.user;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.trae.login.traeauth.TraeResponse;
import com.bytedance.trae.login.traeauth.TraeResponseMetadata;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BytecloudUserInfoFetcher.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u0004\u0018\u00010\u00072\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher;", "", "<init>", "()V", "TAG", "", "doFetch", "Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher$BytecloudUserInfoResponse;", "cloudideToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseResponse", "ssResponse", "Lcom/bytedance/retrofit2/SsResponse;", "BytecloudUserInfoResponse", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BytecloudUserInfoFetcher {
    public static final BytecloudUserInfoFetcher INSTANCE = new BytecloudUserInfoFetcher();
    private static final String TAG = "BytecloudUserInfoFetcher";

    private BytecloudUserInfoFetcher() {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object doFetch(String str, Continuation<? super BytecloudUserInfoResponse> continuation) {
        BytecloudUserInfoFetcher$doFetch$1 bytecloudUserInfoFetcher$doFetch$1;
        int i;
        BytecloudUserInfoFetcher bytecloudUserInfoFetcher;
        try {
            if (continuation instanceof BytecloudUserInfoFetcher$doFetch$1) {
                bytecloudUserInfoFetcher$doFetch$1 = (BytecloudUserInfoFetcher$doFetch$1) continuation;
                if ((bytecloudUserInfoFetcher$doFetch$1.label & Integer.MIN_VALUE) != 0) {
                    bytecloudUserInfoFetcher$doFetch$1.label -= Integer.MIN_VALUE;
                    Object obj = bytecloudUserInfoFetcher$doFetch$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = bytecloudUserInfoFetcher$doFetch$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        String baseUrl = HostResolver.INSTANCE.getBaseUrl(HostType.ONLINE);
                        FLogger.INSTANCE.mo428i(TAG, "doFetch: " + baseUrl);
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        linkedHashMap.put("X-Cloudide-Token", str);
                        BytecloudUserInfoApi bytecloudUserInfoApi = (BytecloudUserInfoApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "trae_bytecloud_auth", BytecloudUserInfoApi.class, null, baseUrl, linkedHashMap, true, 4, null);
                        bytecloudUserInfoFetcher$doFetch$1.L$0 = this;
                        bytecloudUserInfoFetcher$doFetch$1.label = 1;
                        obj = bytecloudUserInfoApi.getBytecloudUserInfo(bytecloudUserInfoFetcher$doFetch$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        bytecloudUserInfoFetcher = this;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        bytecloudUserInfoFetcher = (BytecloudUserInfoFetcher) bytecloudUserInfoFetcher$doFetch$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    return bytecloudUserInfoFetcher.parseResponse((SsResponse) obj);
                }
            }
            if (i != 0) {
            }
            return bytecloudUserInfoFetcher.parseResponse((SsResponse) obj);
        } catch (Exception e) {
            FLogger.INSTANCE.mo426e(TAG, "doFetch exception: " + e.getMessage());
            return null;
        }
        bytecloudUserInfoFetcher$doFetch$1 = new BytecloudUserInfoFetcher$doFetch$1(this, continuation);
        Object obj2 = bytecloudUserInfoFetcher$doFetch$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bytecloudUserInfoFetcher$doFetch$1.label;
    }

    private final BytecloudUserInfoResponse parseResponse(SsResponse<String> ssResponse) {
        String body;
        if (ssResponse == null || (body = ssResponse.body()) == null) {
            return null;
        }
        TraeResponse traeResponse = (TraeResponse) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(body, TypeToken.getParameterized(TraeResponse.class, new Type[]{BytecloudUserInfoResult.class}).getType());
        Intrinsics.checkNotNull(traeResponse);
        return new BytecloudUserInfoResponse(traeResponse, ssResponse);
    }

    /* compiled from: BytecloudUserInfoFetcher.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0013\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/login/user/BytecloudUserInfoFetcher$BytecloudUserInfoResponse;", "", "response", "Lcom/bytedance/trae/login/traeauth/TraeResponse;", "Lcom/bytedance/trae/login/user/BytecloudUserInfoResult;", "ssResponse", "Lcom/bytedance/retrofit2/SsResponse;", "", "<init>", "(Lcom/bytedance/trae/login/traeauth/TraeResponse;Lcom/bytedance/retrofit2/SsResponse;)V", "getResponse", "()Lcom/bytedance/trae/login/traeauth/TraeResponse;", "getSsResponse", "()Lcom/bytedance/retrofit2/SsResponse;", "responseMetadata", "Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;", "getResponseMetadata", "()Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;", "result", "getResult", "()Lcom/bytedance/trae/login/user/BytecloudUserInfoResult;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class BytecloudUserInfoResponse {
        private final TraeResponse<BytecloudUserInfoResult> response;
        private final SsResponse<String> ssResponse;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BytecloudUserInfoResponse copy$default(BytecloudUserInfoResponse bytecloudUserInfoResponse, TraeResponse traeResponse, SsResponse ssResponse, int i, Object obj) {
            if ((i & 1) != 0) {
                traeResponse = bytecloudUserInfoResponse.response;
            }
            if ((i & 2) != 0) {
                ssResponse = bytecloudUserInfoResponse.ssResponse;
            }
            return bytecloudUserInfoResponse.copy(traeResponse, ssResponse);
        }

        public final TraeResponse<BytecloudUserInfoResult> component1() {
            return this.response;
        }

        public final SsResponse<String> component2() {
            return this.ssResponse;
        }

        public final BytecloudUserInfoResponse copy(TraeResponse<BytecloudUserInfoResult> response, SsResponse<String> ssResponse) {
            Intrinsics.checkNotNullParameter(response, "response");
            return new BytecloudUserInfoResponse(response, ssResponse);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BytecloudUserInfoResponse)) {
                return false;
            }
            BytecloudUserInfoResponse bytecloudUserInfoResponse = (BytecloudUserInfoResponse) other;
            return Intrinsics.areEqual(this.response, bytecloudUserInfoResponse.response) && Intrinsics.areEqual(this.ssResponse, bytecloudUserInfoResponse.ssResponse);
        }

        public int hashCode() {
            int hashCode = this.response.hashCode() * 31;
            SsResponse<String> ssResponse = this.ssResponse;
            return hashCode + (ssResponse == null ? 0 : ssResponse.hashCode());
        }

        public String toString() {
            return "BytecloudUserInfoResponse(response=" + this.response + ", ssResponse=" + this.ssResponse + ')';
        }

        public BytecloudUserInfoResponse(TraeResponse<BytecloudUserInfoResult> traeResponse, SsResponse<String> ssResponse) {
            Intrinsics.checkNotNullParameter(traeResponse, "response");
            this.response = traeResponse;
            this.ssResponse = ssResponse;
        }

        public final TraeResponse<BytecloudUserInfoResult> getResponse() {
            return this.response;
        }

        public final SsResponse<String> getSsResponse() {
            return this.ssResponse;
        }

        public final TraeResponseMetadata getResponseMetadata() {
            return this.response.getResponseMetadata();
        }

        public final BytecloudUserInfoResult getResult() {
            return this.response.getResult();
        }
    }
}
