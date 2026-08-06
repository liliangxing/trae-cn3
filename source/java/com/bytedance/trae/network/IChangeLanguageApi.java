package com.bytedance.trae.network;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.LocaleManager;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* compiled from: IChangeLanguageApi.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ<\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/network/IChangeLanguageApi;", "", "changeLanguage", "Lcom/bytedance/trae/network/response/BizResponse;", "deviceId", "", "userId", "language", "request", "Lcom/bytedance/trae/network/ChangeLanguageRequest;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/network/ChangeLanguageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IChangeLanguageApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @JvmStatic
    static void syncLanguage() {
        INSTANCE.syncLanguage();
    }

    @JvmStatic
    static void syncLanguage(String str) {
        INSTANCE.syncLanguage(str);
    }

    @POST("api/solo_hub/v1/apps/change_language")
    Object changeLanguage(@Query("device_id") String str, @Query("user_id") String str2, @Query("language") String str3, @Body ChangeLanguageRequest changeLanguageRequest, Continuation<? super BizResponse<Object>> continuation);

    /* compiled from: IChangeLanguageApi.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0007R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/network/IChangeLanguageApi$Companion;", "", "<init>", "()V", "DEFAULT_HEADERS", "", "", "getDEFAULT_HEADERS", "()Ljava/util/Map;", "safeCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "language", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncLanguage", "", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @JvmStatic
        public final void syncLanguage() {
            syncLanguage$default(this, null, 1, null);
        }

        private Companion() {
        }

        private final Map<String, String> getDEFAULT_HEADERS() {
            return DebugSettings.buildDefaultHeaders$default(DebugSettings.INSTANCE, null, 1, null);
        }

        public static /* synthetic */ Object safeCall$default(Companion companion, String str, Continuation continuation, int i, Object obj) {
            if ((i & 1) != 0) {
                str = LocaleManager.INSTANCE.getEffectiveLanguage();
            }
            return companion.safeCall(str, continuation);
        }

        public final Object safeCall(String str, Continuation<? super HttpDataResult<? extends Object>> continuation) {
            Object safeCall;
            String deviceId = IApplog.Companion.getDeviceId();
            String userID = IApplog.Companion.getUserID();
            safeCall = TraeHttpConnection.INSTANCE.safeCall("change_language", IChangeLanguageApi.class, (Map<String, String>) getDEFAULT_HEADERS(), new IChangeLanguageApi$Companion$safeCall$2(deviceId, userID, str, null), (r17 & 16) != 0 ? null : null, (Set<Long>) ((r17 & 32) != 0 ? BizResponse.INSTANCE.getDEFAULT_SUCCESS_CODES() : null), continuation);
            return safeCall;
        }

        public static /* synthetic */ void syncLanguage$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = LocaleManager.INSTANCE.getEffectiveLanguage();
            }
            companion.syncLanguage(str);
        }

        @JvmStatic
        public final void syncLanguage(String language) {
            Intrinsics.checkNotNullParameter(language, "language");
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new IChangeLanguageApi$Companion$syncLanguage$1(language, null), 2, (Object) null);
        }
    }
}
