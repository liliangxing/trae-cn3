package com.bytedance.trae.conversation.network;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.trae.conversation.network.ThirdPartyTokenException;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.network.TraeHttpConnection;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: ThirdPartyTokenRepository.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u000eJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0013H\u0002J\u001a\u0010\u0014\u001a\u00020\u00152\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository;", "", "<init>", "()V", "TYPE_BYTECLOUD", "", "TYPE_GITHUB", "setThirdPartyToken", "", DBData.FIELD_TYPE, "code", "redirectUri", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getThirdPartyToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnectThirdPartyToken", "createService", "Lcom/bytedance/trae/conversation/network/IThirdPartyTokenApi;", "cloudideHeaders", "", "parseEnvelopeOrThrow", "Lcom/bytedance/trae/conversation/network/ThirdPartyTokenEnvelope;", "response", "Lcom/bytedance/retrofit2/SsResponse;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ThirdPartyTokenRepository {
    public static final ThirdPartyTokenRepository INSTANCE = new ThirdPartyTokenRepository();
    public static final String TYPE_BYTECLOUD = "bytecloud";
    public static final String TYPE_GITHUB = "github";

    private ThirdPartyTokenRepository() {
    }

    public static /* synthetic */ Object setThirdPartyToken$default(ThirdPartyTokenRepository thirdPartyTokenRepository, String str, String str2, String str3, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        return thirdPartyTokenRepository.setThirdPartyToken(str, str2, str3, continuation);
    }

    public final Object setThirdPartyToken(String str, String str2, String str3, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new ThirdPartyTokenRepository$setThirdPartyToken$2(str, str2, str3, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object getThirdPartyToken(String str, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ThirdPartyTokenRepository$getThirdPartyToken$2(str, null), continuation);
    }

    public final Object disconnectThirdPartyToken(String str, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new ThirdPartyTokenRepository$disconnectThirdPartyToken$2(str, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IThirdPartyTokenApi createService() {
        return (IThirdPartyTokenApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "third_party_token", IThirdPartyTokenApi.class, (Converter.Factory) null, HostResolver.INSTANCE.getBaseUrl(HostType.LOGIN), cloudideHeaders(), false, 36, (Object) null);
    }

    private final Map<String, String> cloudideHeaders() {
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        String xTToken = iLoginService != null ? iLoginService.getXTToken() : null;
        if (xTToken == null) {
            xTToken = "";
        }
        if (StringsKt.isBlank(xTToken)) {
            return MapsKt.emptyMap();
        }
        return MapsKt.mapOf(TuplesKt.to("X-Cloudide-Token", xTToken));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ThirdPartyTokenEnvelope parseEnvelopeOrThrow(SsResponse<String> response) {
        Object obj;
        ThirdPartyTokenMetadata responseMetadata;
        InputStream in;
        if (response == null) {
            throw new ThirdPartyTokenException.DecodingFailed("response is null");
        }
        int code = response.code();
        String str = (String) response.body();
        ThirdPartyTokenMetaError thirdPartyTokenMetaError = null;
        if (str == null) {
            TypedInput errorBody = response.errorBody();
            if (errorBody == null || (in = errorBody.in()) == null) {
                str = null;
            } else {
                Reader inputStreamReader = new InputStreamReader(in, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, FConstants.DOWNLOAD_BUFFER_SIZE);
                try {
                    str = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                } finally {
                }
            }
        }
        try {
            Result.Companion companion = Result.Companion;
            ThirdPartyTokenRepository thirdPartyTokenRepository = this;
            obj = Result.constructor-impl((ThirdPartyTokenEnvelope) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(str == null ? "{}" : str, ThirdPartyTokenEnvelope.class));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        ThirdPartyTokenEnvelope thirdPartyTokenEnvelope = (ThirdPartyTokenEnvelope) obj;
        if (thirdPartyTokenEnvelope != null && (responseMetadata = thirdPartyTokenEnvelope.getResponseMetadata()) != null) {
            thirdPartyTokenMetaError = responseMetadata.getError();
        }
        if (thirdPartyTokenMetaError != null) {
            String code2 = thirdPartyTokenMetaError.getCode();
            if (code2 == null) {
                code2 = "";
            }
            String message = thirdPartyTokenMetaError.getMessage();
            throw new ThirdPartyTokenException.ServerError(code2, message != null ? message : "", code, str);
        }
        boolean z = false;
        if (200 <= code && code < 300) {
            z = true;
        }
        if (!z) {
            throw new ThirdPartyTokenException.HttpError(code, str);
        }
        if (thirdPartyTokenEnvelope != null) {
            return thirdPartyTokenEnvelope;
        }
        throw new ThirdPartyTokenException.DecodingFailed("failed to parse response");
    }
}
