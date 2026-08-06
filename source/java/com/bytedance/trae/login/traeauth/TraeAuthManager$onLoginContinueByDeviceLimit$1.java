package com.bytedance.trae.login.traeauth;

import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.login.region.UserRegionManager;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.login.user.TraeUserInfoResult;
import com.bytedance.trae.login.user.UserInfo;
import com.bytedance.trae.login.user.UserInfoFetcher;
import com.bytedance.trae.utils.logger.FLogger;
import com.bytedance.ug.sdk.share.api.entity.ToastCode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TraeAuthManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.traeauth.TraeAuthManager$onLoginContinueByDeviceLimit$1", f = "TraeAuthManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5}, l = {ToastCode.TWITTER_NOT_INSTALL, 221, 238, 261, 279, 303, 327, 348}, m = "invokeSuspend", n = {"$this$launch", "stepLoginMs", "stepRefreshMs", "stepExchangeMs", "stepUserInfoMs", "stepCheckLoginMs", "startTime", "stepRefreshStart", "startTime", "$this$launch", "stepLoginMs", "stepRefreshMs", "stepExchangeMs", "stepUserInfoMs", "stepCheckLoginMs", "startTime", "stepExchangeStart", "stepLoginMs", "stepRefreshMs", "stepExchangeMs", "stepUserInfoMs", "stepCheckLoginMs", "exchangeResult", "startTime", "stepUserInfoStart", "stepLoginMs", "stepRefreshMs", "stepExchangeMs", "stepUserInfoMs", "stepCheckLoginMs", "startTime", "stepCheckLoginStart", "startTime"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "J$1", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "J$1", "J$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeAuthManager$onLoginContinueByDeviceLimit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TraeAuthManager.TraeAuthCallback $callback;
    final /* synthetic */ String $loginPlatform;
    long J$0;
    long J$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TraeAuthManager$onLoginContinueByDeviceLimit$1(String str, TraeAuthManager.TraeAuthCallback traeAuthCallback, Continuation<? super TraeAuthManager$onLoginContinueByDeviceLimit$1> continuation) {
        super(2, continuation);
        this.$loginPlatform = str;
        this.$callback = traeAuthCallback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> traeAuthManager$onLoginContinueByDeviceLimit$1 = new TraeAuthManager$onLoginContinueByDeviceLimit$1(this.$loginPlatform, this.$callback, continuation);
        traeAuthManager$onLoginContinueByDeviceLimit$1.L$0 = obj;
        return traeAuthManager$onLoginContinueByDeviceLimit$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x002b. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0481 A[Catch: all -> 0x04c4, TryCatch #16 {all -> 0x04c4, blocks: (B:118:0x047d, B:120:0x0481, B:122:0x0489, B:124:0x048f, B:127:0x0499, B:129:0x04a1, B:134:0x04ad, B:136:0x04bd), top: B:117:0x047d }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x04ad A[Catch: all -> 0x04c4, TryCatch #16 {all -> 0x04c4, blocks: (B:118:0x047d, B:120:0x0481, B:122:0x0489, B:124:0x048f, B:127:0x0499, B:129:0x04a1, B:134:0x04ad, B:136:0x04bd), top: B:117:0x047d }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0507  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x055b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x055c  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x04de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0477 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x042b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0809  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x02ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0819  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0827  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0892 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0765  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x07e0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x062e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x062f  */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v3, types: [long] */
    /* JADX WARN: Type inference failed for: r2v31, types: [long] */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r2v74 */
    /* JADX WARN: Type inference failed for: r2v75 */
    /* JADX WARN: Type inference failed for: r2v77 */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v88 */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r2v94 */
    /* JADX WARN: Type inference failed for: r2v98 */
    /* JADX WARN: Type inference failed for: r2v99 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Object obj3;
        String str6;
        String str7;
        String str8;
        Object obj4;
        String str9;
        long j;
        String str10;
        String message;
        long j2;
        String userFacingMessage;
        String code;
        Ref.LongRef longRef;
        String str11;
        Ref.LongRef longRef2;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        long currentTimeMillis;
        TraeAuthManager traeAuthManager;
        String str17;
        String str18;
        String str19;
        Object retryOnTransient;
        Ref.LongRef longRef3;
        long j3;
        Ref.LongRef longRef4;
        CoroutineScope coroutineScope;
        long j4;
        Ref.LongRef longRef5;
        TraeGetRefreshTokenResult traeGetRefreshTokenResult;
        String str20;
        long j5;
        String str21;
        String str22;
        long currentTimeMillis2;
        TraeAuthManager traeAuthManager2;
        String str23;
        TraeAuthManager$onLoginContinueByDeviceLimit$1$exchangeResult$1 traeAuthManager$onLoginContinueByDeviceLimit$1$exchangeResult$1;
        Continuation continuation;
        Ref.LongRef longRef6;
        Object retryOnTransient2;
        Ref.LongRef longRef7;
        Ref.LongRef longRef8;
        Ref.LongRef longRef9;
        TraeExchangeTokenResult traeExchangeTokenResult;
        String refreshToken;
        long j6;
        String str24;
        long currentTimeMillis3;
        Object obj5;
        long j7;
        long j8;
        Object doFetch;
        Object obj6;
        long j9;
        long j10;
        long j11;
        Throwable th;
        String str25;
        String str26;
        UserRegionManager userRegionManager;
        String token;
        Ref.LongRef longRef10;
        long j12;
        long j13;
        UserInfoFetcher.UserInfoResponse userInfoResponse;
        TraeUserInfoResult result;
        String userId;
        boolean z;
        TraeResponseMetadata responseMetadata;
        long j14;
        String str27;
        Object obj7;
        long j15;
        CoroutineContext main;
        C08776 c08776;
        Continuation continuation2;
        long j16;
        ?? r2 = "onPassportLoginSuccess: fetchUserInfo done in ";
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (TraeAuthException e) {
            e = e;
            str = "failed_step";
            str2 = "device_limit_continue_";
            str3 = "login_platform";
            str4 = "duration_ms";
            str5 = "icube_login_failure";
            obj3 = "device_limit";
            j = r2;
        } catch (Throwable th2) {
            th = th2;
            obj2 = "device_limit";
        }
        switch (this.label) {
            case 0:
                obj2 = "device_limit";
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                str6 = "failed_step";
                long currentTimeMillis4 = System.currentTimeMillis();
                str7 = ISignalReportConstants.KEY_REASON;
                longRef = new Ref.LongRef();
                str11 = "login_platform";
                Ref.LongRef longRef11 = new Ref.LongRef();
                str8 = "duration_ms";
                longRef2 = new Ref.LongRef();
                str12 = "onPassportLoginSuccess: performCheckLoginSync done in ";
                Ref.LongRef longRef12 = new Ref.LongRef();
                str13 = "onPassportLoginSuccess: fetchUserInfo done in ";
                Ref.LongRef longRef13 = new Ref.LongRef();
                str14 = "fetchUserInfo failed (non-blocking): ";
                str15 = "onPassportLoginSuccess: doExchangeToken done in ";
                str16 = "ms";
                FLogger.INSTANCE.mo428i("TraeAuthManager", "onPassportLoginSuccess: begin, deviceId=" + IApplog.Companion.getDeviceId() + ", baseUrl=" + TraeAuthConfig.INSTANCE.getBaseUrl() + ", loginChannel=" + TraeAuthConfig.INSTANCE.getLoginChannel());
                try {
                    try {
                        currentTimeMillis = System.currentTimeMillis();
                        try {
                            traeAuthManager = TraeAuthManager.INSTANCE;
                            str17 = this.$loginPlatform;
                            str18 = "TraeAuthManager";
                            try {
                                str19 = "device_limit_continue_";
                            } catch (Throwable th3) {
                                th = th3;
                                obj4 = coroutine_suspended;
                                str2 = "device_limit_continue_";
                                str3 = str11;
                                str9 = str18;
                            }
                        } catch (TraeAuthException e2) {
                            e = e2;
                            obj4 = coroutine_suspended;
                            str2 = "device_limit_continue_";
                            str3 = str11;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        obj4 = coroutine_suspended;
                        str2 = "device_limit_continue_";
                        str9 = "TraeAuthManager";
                        str3 = str11;
                    }
                } catch (TraeAuthException e3) {
                    e = e3;
                    obj4 = coroutine_suspended;
                    str2 = "device_limit_continue_";
                    str5 = "icube_login_failure";
                    obj3 = obj2;
                    str = str6;
                    str10 = str7;
                    str3 = str11;
                    str4 = str8;
                    j2 = currentTimeMillis4;
                    long currentTimeMillis5 = System.currentTimeMillis() - j2;
                    IApplog.Companion companion = IApplog.Companion;
                    JSONObject jSONObject = new JSONObject();
                    userFacingMessage = e.getUserFacingMessage();
                    if (userFacingMessage == null) {
                    }
                    jSONObject.put(str10, userFacingMessage);
                    code = e.getCode();
                    if (code == null) {
                    }
                    jSONObject.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                    String step = e.getStep();
                    jSONObject.put(str, step != null ? step : "unknown");
                    jSONObject.put(str4, currentTimeMillis5);
                    jSONObject.put(str3, obj3);
                    Unit unit = Unit.INSTANCE;
                    companion.reportEvent(str5, jSONObject);
                    TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, null, e.getStep(), e.getCode(), null, null, e.getHttpCode(), e.getLogId(), null, null, 1636, null);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.label = 7;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C08788(this.$callback, e, null), (Continuation) this) == obj4) {
                    }
                    return Unit.INSTANCE;
                }
                try {
                    this.L$0 = coroutineScope2;
                    this.L$1 = longRef;
                    this.L$2 = longRef11;
                    this.L$3 = longRef2;
                    this.L$4 = longRef12;
                    this.L$5 = longRef13;
                    this.J$0 = currentTimeMillis4;
                    this.J$1 = currentTimeMillis;
                    this.label = 1;
                    retryOnTransient = traeAuthManager.retryOnTransient(2, "doGetRefreshToken", str17, new TraeAuthManager$onLoginContinueByDeviceLimit$1$refreshResult$1(null), (Continuation) this);
                    if (retryOnTransient == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    longRef3 = longRef12;
                    j3 = currentTimeMillis;
                    longRef4 = longRef13;
                    coroutineScope = coroutineScope2;
                    j4 = currentTimeMillis4;
                    longRef5 = longRef11;
                    try {
                        traeGetRefreshTokenResult = (TraeGetRefreshTokenResult) retryOnTransient;
                        Ref.LongRef longRef14 = longRef4;
                        if (!Intrinsics.areEqual(traeGetRefreshTokenResult.getDeviceLimitReached(), Boxing.boxBoolean(true))) {
                            try {
                                str20 = str19;
                                try {
                                    TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str20 + this.$loginPlatform, null, "login_continue_with_device_limit_error", null, null, null, null, null, null, null, 2036, null);
                                    this.L$0 = null;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.L$4 = null;
                                    this.L$5 = null;
                                    this.J$0 = j4;
                                    this.label = 2;
                                    j4 = j4;
                                    if (BuildersKt.withContext(Dispatchers.getMain(), new C08751(this.$callback, null), (Continuation) this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    return Unit.INSTANCE;
                                } catch (TraeAuthException e4) {
                                    e = e4;
                                    obj4 = coroutine_suspended;
                                    j9 = j4;
                                    str2 = str20;
                                    j6 = j9;
                                    str5 = "icube_login_failure";
                                    obj3 = obj2;
                                    str = str6;
                                    str10 = str7;
                                    str3 = str11;
                                    j16 = j6;
                                    str4 = str8;
                                    j2 = j16;
                                    long currentTimeMillis52 = System.currentTimeMillis() - j2;
                                    IApplog.Companion companion2 = IApplog.Companion;
                                    JSONObject jSONObject2 = new JSONObject();
                                    userFacingMessage = e.getUserFacingMessage();
                                    if (userFacingMessage == null) {
                                    }
                                    jSONObject2.put(str10, userFacingMessage);
                                    code = e.getCode();
                                    if (code == null) {
                                    }
                                    jSONObject2.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                                    String step2 = e.getStep();
                                    jSONObject2.put(str, step2 != null ? step2 : "unknown");
                                    jSONObject2.put(str4, currentTimeMillis52);
                                    jSONObject2.put(str3, obj3);
                                    Unit unit2 = Unit.INSTANCE;
                                    companion2.reportEvent(str5, jSONObject2);
                                    TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, null, e.getStep(), e.getCode(), null, null, e.getHttpCode(), e.getLogId(), null, null, 1636, null);
                                    this.L$0 = null;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.L$4 = null;
                                    this.L$5 = null;
                                    this.label = 7;
                                    if (BuildersKt.withContext(Dispatchers.getMain(), new C08788(this.$callback, e, null), (Continuation) this) == obj4) {
                                    }
                                    return Unit.INSTANCE;
                                } catch (Throwable th5) {
                                    th = th5;
                                    obj4 = coroutine_suspended;
                                    r2 = j4;
                                    str2 = str20;
                                    str3 = str11;
                                    str9 = str18;
                                    long currentTimeMillis6 = System.currentTimeMillis() - r2;
                                    FLogger.INSTANCE.mo426e(str9, "Auth flow unexpected exception: " + th.getMessage());
                                    IApplog.Companion companion3 = IApplog.Companion;
                                    JSONObject jSONObject3 = new JSONObject();
                                    message = th.getMessage();
                                    if (message == null) {
                                    }
                                    jSONObject3.put(str7, message);
                                    jSONObject3.put(str6, "unexpected");
                                    jSONObject3.put(str8, currentTimeMillis6);
                                    jSONObject3.put(str3, obj2);
                                    Unit unit3 = Unit.INSTANCE;
                                    companion3.reportEvent("icube_login_failure", jSONObject3);
                                    TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, Boxing.boxLong(currentTimeMillis6), "unexpected", null, th.getMessage(), null, null, null, null, null, 2000, null);
                                    this.L$0 = null;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.L$4 = null;
                                    this.L$5 = null;
                                    this.label = 8;
                                    if (BuildersKt.withContext(Dispatchers.getMain(), new C087610(this.$callback, th, null), (Continuation) this) == obj4) {
                                    }
                                    return Unit.INSTANCE;
                                }
                            } catch (TraeAuthException e5) {
                                e = e5;
                                obj4 = coroutine_suspended;
                                j10 = j4;
                                str5 = "icube_login_failure";
                                obj3 = obj2;
                                str = str6;
                                str10 = str7;
                                str3 = str11;
                                str4 = str8;
                                str2 = str19;
                                j2 = j10;
                                long currentTimeMillis522 = System.currentTimeMillis() - j2;
                                IApplog.Companion companion22 = IApplog.Companion;
                                JSONObject jSONObject22 = new JSONObject();
                                userFacingMessage = e.getUserFacingMessage();
                                if (userFacingMessage == null) {
                                }
                                jSONObject22.put(str10, userFacingMessage);
                                code = e.getCode();
                                if (code == null) {
                                }
                                jSONObject22.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                                String step22 = e.getStep();
                                jSONObject22.put(str, step22 != null ? step22 : "unknown");
                                jSONObject22.put(str4, currentTimeMillis522);
                                jSONObject22.put(str3, obj3);
                                Unit unit22 = Unit.INSTANCE;
                                companion22.reportEvent(str5, jSONObject22);
                                TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, null, e.getStep(), e.getCode(), null, null, e.getHttpCode(), e.getLogId(), null, null, 1636, null);
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.L$5 = null;
                                this.label = 7;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new C08788(this.$callback, e, null), (Continuation) this) == obj4) {
                                }
                                return Unit.INSTANCE;
                            } catch (Throwable th6) {
                                th = th6;
                                obj4 = coroutine_suspended;
                                j11 = j4;
                                str3 = str11;
                                str9 = str18;
                                r2 = j11;
                                str2 = str19;
                                long currentTimeMillis62 = System.currentTimeMillis() - r2;
                                FLogger.INSTANCE.mo426e(str9, "Auth flow unexpected exception: " + th.getMessage());
                                IApplog.Companion companion32 = IApplog.Companion;
                                JSONObject jSONObject32 = new JSONObject();
                                message = th.getMessage();
                                if (message == null) {
                                }
                                jSONObject32.put(str7, message);
                                jSONObject32.put(str6, "unexpected");
                                jSONObject32.put(str8, currentTimeMillis62);
                                jSONObject32.put(str3, obj2);
                                Unit unit32 = Unit.INSTANCE;
                                companion32.reportEvent("icube_login_failure", jSONObject32);
                                TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, Boxing.boxLong(currentTimeMillis62), "unexpected", null, th.getMessage(), null, null, null, null, null, 2000, null);
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.L$5 = null;
                                this.label = 8;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new C087610(this.$callback, th, null), (Continuation) this) == obj4) {
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        str20 = str19;
                        try {
                            longRef5.element = System.currentTimeMillis() - j3;
                            long j17 = j4;
                            try {
                                try {
                                    str21 = str16;
                                    str22 = str18;
                                    try {
                                        FLogger.INSTANCE.mo428i(str22, "onPassportLoginSuccess: doGetRefreshToken done in " + longRef5.element + str21);
                                        TraeAuthStorage traeAuthStorage = TraeAuthStorage.INSTANCE;
                                        String refreshToken2 = traeGetRefreshTokenResult.getRefreshToken();
                                        Intrinsics.checkNotNull(refreshToken2);
                                        traeAuthStorage.saveRefreshToken(refreshToken2, traeGetRefreshTokenResult.getRefreshExpireAt());
                                        currentTimeMillis2 = System.currentTimeMillis();
                                        traeAuthManager2 = TraeAuthManager.INSTANCE;
                                        str23 = this.$loginPlatform;
                                        traeAuthManager$onLoginContinueByDeviceLimit$1$exchangeResult$1 = new TraeAuthManager$onLoginContinueByDeviceLimit$1$exchangeResult$1(traeGetRefreshTokenResult, null);
                                        continuation = (Continuation) this;
                                        this.L$0 = coroutineScope;
                                        this.L$1 = longRef;
                                        this.L$2 = longRef5;
                                        this.L$3 = longRef2;
                                        this.L$4 = longRef3;
                                        this.L$5 = longRef14;
                                        longRef6 = longRef5;
                                        j5 = j17;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        obj4 = coroutine_suspended;
                                        str2 = str20;
                                        str3 = str11;
                                        j5 = j17;
                                        str9 = str22;
                                        r2 = j5;
                                        long currentTimeMillis622 = System.currentTimeMillis() - r2;
                                        FLogger.INSTANCE.mo426e(str9, "Auth flow unexpected exception: " + th.getMessage());
                                        IApplog.Companion companion322 = IApplog.Companion;
                                        JSONObject jSONObject322 = new JSONObject();
                                        message = th.getMessage();
                                        if (message == null) {
                                        }
                                        jSONObject322.put(str7, message);
                                        jSONObject322.put(str6, "unexpected");
                                        jSONObject322.put(str8, currentTimeMillis622);
                                        jSONObject322.put(str3, obj2);
                                        Unit unit322 = Unit.INSTANCE;
                                        companion322.reportEvent("icube_login_failure", jSONObject322);
                                        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, Boxing.boxLong(currentTimeMillis622), "unexpected", null, th.getMessage(), null, null, null, null, null, 2000, null);
                                        this.L$0 = null;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.L$3 = null;
                                        this.L$4 = null;
                                        this.L$5 = null;
                                        this.label = 8;
                                        if (BuildersKt.withContext(Dispatchers.getMain(), new C087610(this.$callback, th, null), (Continuation) this) == obj4) {
                                        }
                                        return Unit.INSTANCE;
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    obj4 = coroutine_suspended;
                                    str2 = str20;
                                    str3 = str11;
                                    j5 = j17;
                                    str9 = str18;
                                    r2 = j5;
                                    long currentTimeMillis6222 = System.currentTimeMillis() - r2;
                                    FLogger.INSTANCE.mo426e(str9, "Auth flow unexpected exception: " + th.getMessage());
                                    IApplog.Companion companion3222 = IApplog.Companion;
                                    JSONObject jSONObject3222 = new JSONObject();
                                    message = th.getMessage();
                                    if (message == null) {
                                    }
                                    jSONObject3222.put(str7, message);
                                    jSONObject3222.put(str6, "unexpected");
                                    jSONObject3222.put(str8, currentTimeMillis6222);
                                    jSONObject3222.put(str3, obj2);
                                    Unit unit3222 = Unit.INSTANCE;
                                    companion3222.reportEvent("icube_login_failure", jSONObject3222);
                                    TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, Boxing.boxLong(currentTimeMillis6222), "unexpected", null, th.getMessage(), null, null, null, null, null, 2000, null);
                                    this.L$0 = null;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.L$4 = null;
                                    this.L$5 = null;
                                    this.label = 8;
                                    if (BuildersKt.withContext(Dispatchers.getMain(), new C087610(this.$callback, th, null), (Continuation) this) == obj4) {
                                    }
                                    return Unit.INSTANCE;
                                }
                            } catch (TraeAuthException e6) {
                                e = e6;
                                obj4 = coroutine_suspended;
                                str2 = str20;
                                str3 = str11;
                                j5 = j17;
                                r2 = j5;
                                str5 = "icube_login_failure";
                                obj3 = obj2;
                                str = str6;
                                str10 = str7;
                                j16 = r2;
                                str4 = str8;
                                j2 = j16;
                                long currentTimeMillis5222 = System.currentTimeMillis() - j2;
                                IApplog.Companion companion222 = IApplog.Companion;
                                JSONObject jSONObject222 = new JSONObject();
                                userFacingMessage = e.getUserFacingMessage();
                                if (userFacingMessage == null) {
                                }
                                jSONObject222.put(str10, userFacingMessage);
                                code = e.getCode();
                                if (code == null) {
                                }
                                jSONObject222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                                String step222 = e.getStep();
                                jSONObject222.put(str, step222 != null ? step222 : "unknown");
                                jSONObject222.put(str4, currentTimeMillis5222);
                                jSONObject222.put(str3, obj3);
                                Unit unit222 = Unit.INSTANCE;
                                companion222.reportEvent(str5, jSONObject222);
                                TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, null, e.getStep(), e.getCode(), null, null, e.getHttpCode(), e.getLogId(), null, null, 1636, null);
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.L$5 = null;
                                this.label = 7;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new C08788(this.$callback, e, null), (Continuation) this) == obj4) {
                                }
                                return Unit.INSTANCE;
                            }
                            try {
                                this.J$0 = j5;
                                this.J$1 = currentTimeMillis2;
                                this.label = 3;
                                retryOnTransient2 = traeAuthManager2.retryOnTransient(2, "doExchangeToken", str23, traeAuthManager$onLoginContinueByDeviceLimit$1$exchangeResult$1, continuation);
                                if (retryOnTransient2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                longRef7 = longRef;
                                longRef8 = longRef6;
                                longRef9 = longRef14;
                                traeExchangeTokenResult = (TraeExchangeTokenResult) retryOnTransient2;
                                longRef2.element = System.currentTimeMillis() - currentTimeMillis2;
                                try {
                                    try {
                                        FLogger.INSTANCE.mo428i(str22, str15 + longRef2.element + str21);
                                        TraeAuthStorage traeAuthStorage2 = TraeAuthStorage.INSTANCE;
                                        String token2 = traeExchangeTokenResult.getToken();
                                        Intrinsics.checkNotNull(token2);
                                        traeAuthStorage2.saveJwtToken(token2, traeExchangeTokenResult.getTokenExpireAt());
                                        refreshToken = traeExchangeTokenResult.getRefreshToken();
                                        if (refreshToken != null) {
                                            try {
                                                TraeAuthStorage.INSTANCE.saveRefreshToken(refreshToken, traeExchangeTokenResult.getRefreshExpireAt());
                                            } catch (TraeAuthException e7) {
                                                e = e7;
                                                j6 = j5;
                                                str2 = str20;
                                                obj4 = coroutine_suspended;
                                                str5 = "icube_login_failure";
                                                obj3 = obj2;
                                                str = str6;
                                                str10 = str7;
                                                str3 = str11;
                                                j16 = j6;
                                                str4 = str8;
                                                j2 = j16;
                                                long currentTimeMillis52222 = System.currentTimeMillis() - j2;
                                                IApplog.Companion companion2222 = IApplog.Companion;
                                                JSONObject jSONObject2222 = new JSONObject();
                                                userFacingMessage = e.getUserFacingMessage();
                                                if (userFacingMessage == null) {
                                                    userFacingMessage = "unknown";
                                                }
                                                jSONObject2222.put(str10, userFacingMessage);
                                                code = e.getCode();
                                                if (code == null) {
                                                }
                                                jSONObject2222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                                                String step2222 = e.getStep();
                                                jSONObject2222.put(str, step2222 != null ? step2222 : "unknown");
                                                jSONObject2222.put(str4, currentTimeMillis52222);
                                                jSONObject2222.put(str3, obj3);
                                                Unit unit2222 = Unit.INSTANCE;
                                                companion2222.reportEvent(str5, jSONObject2222);
                                                TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, null, e.getStep(), e.getCode(), null, null, e.getHttpCode(), e.getLogId(), null, null, 1636, null);
                                                this.L$0 = null;
                                                this.L$1 = null;
                                                this.L$2 = null;
                                                this.L$3 = null;
                                                this.L$4 = null;
                                                this.L$5 = null;
                                                this.label = 7;
                                                if (BuildersKt.withContext(Dispatchers.getMain(), new C08788(this.$callback, e, null), (Continuation) this) == obj4) {
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }
                                        str24 = str21;
                                        str18 = str22;
                                        try {
                                            TraeAuthStorage.INSTANCE.saveLastExchangeSuccessAt(System.currentTimeMillis() / BytePatchException.ErrorCode.paramsError);
                                            currentTimeMillis3 = System.currentTimeMillis();
                                            try {
                                                Result.Companion companion4 = Result.Companion;
                                                UserInfoFetcher userInfoFetcher = UserInfoFetcher.INSTANCE;
                                                String token3 = traeExchangeTokenResult.getToken();
                                                Intrinsics.checkNotNull(token3);
                                                this.L$0 = longRef7;
                                                this.L$1 = longRef8;
                                                this.L$2 = longRef2;
                                                this.L$3 = longRef3;
                                                this.L$4 = longRef9;
                                                this.L$5 = traeExchangeTokenResult;
                                                this.J$0 = j5;
                                                this.J$1 = currentTimeMillis3;
                                                this.label = 4;
                                                doFetch = userInfoFetcher.doFetch(token3, this);
                                                obj5 = coroutine_suspended;
                                            } catch (Throwable th9) {
                                                th = th9;
                                                obj5 = coroutine_suspended;
                                                j7 = j5;
                                                j8 = currentTimeMillis3;
                                                try {
                                                    try {
                                                        Result.Companion companion5 = Result.Companion;
                                                        obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                                                        j7 = j7;
                                                        th = Result.exceptionOrNull-impl(obj6);
                                                        if (th != null) {
                                                        }
                                                        try {
                                                            longRef3.element = System.currentTimeMillis() - j8;
                                                            str26 = str24;
                                                            FLogger.INSTANCE.mo428i(str25, str13 + longRef3.element + str26);
                                                            str18 = str25;
                                                            long currentTimeMillis7 = System.currentTimeMillis();
                                                            userRegionManager = UserRegionManager.INSTANCE;
                                                            token = traeExchangeTokenResult.getToken();
                                                            Intrinsics.checkNotNull(token);
                                                            this.L$0 = longRef7;
                                                            this.L$1 = longRef8;
                                                            this.L$2 = longRef2;
                                                            this.L$3 = longRef3;
                                                            this.L$4 = longRef9;
                                                            this.L$5 = null;
                                                            this.J$0 = j7;
                                                            this.J$1 = currentTimeMillis7;
                                                            this.label = 5;
                                                            if (userRegionManager.performCheckLoginSync(token, (Continuation) this) == obj5) {
                                                            }
                                                        } catch (TraeAuthException e8) {
                                                            e = e8;
                                                            obj4 = obj5;
                                                            r2 = j7;
                                                            str3 = str11;
                                                            str2 = str19;
                                                            str5 = "icube_login_failure";
                                                            obj3 = obj2;
                                                            str = str6;
                                                            str10 = str7;
                                                            j16 = r2;
                                                            str4 = str8;
                                                            j2 = j16;
                                                            long currentTimeMillis522222 = System.currentTimeMillis() - j2;
                                                            IApplog.Companion companion22222 = IApplog.Companion;
                                                            JSONObject jSONObject22222 = new JSONObject();
                                                            userFacingMessage = e.getUserFacingMessage();
                                                            if (userFacingMessage == null) {
                                                            }
                                                            jSONObject22222.put(str10, userFacingMessage);
                                                            code = e.getCode();
                                                            if (code == null) {
                                                            }
                                                            jSONObject22222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                                                            String step22222 = e.getStep();
                                                            jSONObject22222.put(str, step22222 != null ? step22222 : "unknown");
                                                            jSONObject22222.put(str4, currentTimeMillis522222);
                                                            jSONObject22222.put(str3, obj3);
                                                            Unit unit22222 = Unit.INSTANCE;
                                                            companion22222.reportEvent(str5, jSONObject22222);
                                                            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, null, e.getStep(), e.getCode(), null, null, e.getHttpCode(), e.getLogId(), null, null, 1636, null);
                                                            this.L$0 = null;
                                                            this.L$1 = null;
                                                            this.L$2 = null;
                                                            this.L$3 = null;
                                                            this.L$4 = null;
                                                            this.L$5 = null;
                                                            this.label = 7;
                                                            if (BuildersKt.withContext(Dispatchers.getMain(), new C08788(this.$callback, e, null), (Continuation) this) == obj4) {
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    } catch (Throwable th10) {
                                                        th = th10;
                                                        obj4 = obj5;
                                                        r2 = j7;
                                                        str2 = str20;
                                                        str3 = str11;
                                                        str9 = str18;
                                                        long currentTimeMillis62222 = System.currentTimeMillis() - r2;
                                                        FLogger.INSTANCE.mo426e(str9, "Auth flow unexpected exception: " + th.getMessage());
                                                        IApplog.Companion companion32222 = IApplog.Companion;
                                                        JSONObject jSONObject32222 = new JSONObject();
                                                        message = th.getMessage();
                                                        if (message == null) {
                                                            message = "unexpected_exception";
                                                        }
                                                        jSONObject32222.put(str7, message);
                                                        jSONObject32222.put(str6, "unexpected");
                                                        jSONObject32222.put(str8, currentTimeMillis62222);
                                                        jSONObject32222.put(str3, obj2);
                                                        Unit unit32222 = Unit.INSTANCE;
                                                        companion32222.reportEvent("icube_login_failure", jSONObject32222);
                                                        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, Boxing.boxLong(currentTimeMillis62222), "unexpected", null, th.getMessage(), null, null, null, null, null, 2000, null);
                                                        this.L$0 = null;
                                                        this.L$1 = null;
                                                        this.L$2 = null;
                                                        this.L$3 = null;
                                                        this.L$4 = null;
                                                        this.L$5 = null;
                                                        this.label = 8;
                                                        if (BuildersKt.withContext(Dispatchers.getMain(), new C087610(this.$callback, th, null), (Continuation) this) == obj4) {
                                                            return obj4;
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                } catch (TraeAuthException e9) {
                                                    e = e9;
                                                    obj4 = obj5;
                                                    r2 = j7;
                                                    str2 = str20;
                                                    str3 = str11;
                                                    str5 = "icube_login_failure";
                                                    obj3 = obj2;
                                                    str = str6;
                                                    str10 = str7;
                                                    j16 = r2;
                                                    str4 = str8;
                                                    j2 = j16;
                                                    long currentTimeMillis5222222 = System.currentTimeMillis() - j2;
                                                    IApplog.Companion companion222222 = IApplog.Companion;
                                                    JSONObject jSONObject222222 = new JSONObject();
                                                    userFacingMessage = e.getUserFacingMessage();
                                                    if (userFacingMessage == null) {
                                                    }
                                                    jSONObject222222.put(str10, userFacingMessage);
                                                    code = e.getCode();
                                                    if (code == null) {
                                                    }
                                                    jSONObject222222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                                                    String step222222 = e.getStep();
                                                    jSONObject222222.put(str, step222222 != null ? step222222 : "unknown");
                                                    jSONObject222222.put(str4, currentTimeMillis5222222);
                                                    jSONObject222222.put(str3, obj3);
                                                    Unit unit222222 = Unit.INSTANCE;
                                                    companion222222.reportEvent(str5, jSONObject222222);
                                                    TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, null, e.getStep(), e.getCode(), null, null, e.getHttpCode(), e.getLogId(), null, null, 1636, null);
                                                    this.L$0 = null;
                                                    this.L$1 = null;
                                                    this.L$2 = null;
                                                    this.L$3 = null;
                                                    this.L$4 = null;
                                                    this.L$5 = null;
                                                    this.label = 7;
                                                    if (BuildersKt.withContext(Dispatchers.getMain(), new C08788(this.$callback, e, null), (Continuation) this) == obj4) {
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }
                                            if (doFetch != obj5) {
                                                return obj5;
                                            }
                                            j7 = j5;
                                            j8 = currentTimeMillis3;
                                            try {
                                                userInfoResponse = (UserInfoFetcher.UserInfoResponse) doFetch;
                                                result = userInfoResponse == null ? userInfoResponse.getResult() : null;
                                                if (((userInfoResponse != null || (responseMetadata = userInfoResponse.getResponseMetadata()) == null) ? null : responseMetadata.getError()) == null && result != null) {
                                                    userId = result.getUserId();
                                                    if (userId != null && userId.length() != 0) {
                                                        z = false;
                                                        if (!z) {
                                                            TraeAuthStorage.INSTANCE.saveUserInfo(UserInfo.INSTANCE.from(result));
                                                            UserRegionManager.INSTANCE.applyRegionFromUserInfo(result);
                                                        }
                                                    }
                                                    z = true;
                                                    if (!z) {
                                                    }
                                                }
                                                obj6 = Result.constructor-impl(Unit.INSTANCE);
                                                j7 = j7;
                                            } catch (Throwable th11) {
                                                th = th11;
                                                Result.Companion companion52 = Result.Companion;
                                                obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                                                j7 = j7;
                                                th = Result.exceptionOrNull-impl(obj6);
                                                if (th != null) {
                                                }
                                                longRef3.element = System.currentTimeMillis() - j8;
                                                str26 = str24;
                                                FLogger.INSTANCE.mo428i(str25, str13 + longRef3.element + str26);
                                                str18 = str25;
                                                long currentTimeMillis72 = System.currentTimeMillis();
                                                userRegionManager = UserRegionManager.INSTANCE;
                                                token = traeExchangeTokenResult.getToken();
                                                Intrinsics.checkNotNull(token);
                                                this.L$0 = longRef7;
                                                this.L$1 = longRef8;
                                                this.L$2 = longRef2;
                                                this.L$3 = longRef3;
                                                this.L$4 = longRef9;
                                                this.L$5 = null;
                                                this.J$0 = j7;
                                                this.J$1 = currentTimeMillis72;
                                                this.label = 5;
                                                if (userRegionManager.performCheckLoginSync(token, (Continuation) this) == obj5) {
                                                }
                                            }
                                            th = Result.exceptionOrNull-impl(obj6);
                                            if (th != null) {
                                                try {
                                                    str19 = str20;
                                                } catch (TraeAuthException e10) {
                                                    e = e10;
                                                    obj4 = obj5;
                                                    j9 = j7;
                                                    str2 = str20;
                                                    j6 = j9;
                                                    str5 = "icube_login_failure";
                                                    obj3 = obj2;
                                                    str = str6;
                                                    str10 = str7;
                                                    str3 = str11;
                                                    j16 = j6;
                                                    str4 = str8;
                                                    j2 = j16;
                                                    long currentTimeMillis52222222 = System.currentTimeMillis() - j2;
                                                    IApplog.Companion companion2222222 = IApplog.Companion;
                                                    JSONObject jSONObject2222222 = new JSONObject();
                                                    userFacingMessage = e.getUserFacingMessage();
                                                    if (userFacingMessage == null && (userFacingMessage = e.getMessage()) == null) {
                                                        userFacingMessage = "unknown";
                                                    }
                                                    jSONObject2222222.put(str10, userFacingMessage);
                                                    code = e.getCode();
                                                    if (code == null) {
                                                        code = "";
                                                    }
                                                    jSONObject2222222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                                                    String step2222222 = e.getStep();
                                                    jSONObject2222222.put(str, step2222222 != null ? step2222222 : "unknown");
                                                    jSONObject2222222.put(str4, currentTimeMillis52222222);
                                                    jSONObject2222222.put(str3, obj3);
                                                    Unit unit2222222 = Unit.INSTANCE;
                                                    companion2222222.reportEvent(str5, jSONObject2222222);
                                                    TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, null, e.getStep(), e.getCode(), null, null, e.getHttpCode(), e.getLogId(), null, null, 1636, null);
                                                    this.L$0 = null;
                                                    this.L$1 = null;
                                                    this.L$2 = null;
                                                    this.L$3 = null;
                                                    this.L$4 = null;
                                                    this.L$5 = null;
                                                    this.label = 7;
                                                    if (BuildersKt.withContext(Dispatchers.getMain(), new C08788(this.$callback, e, null), (Continuation) this) == obj4) {
                                                        return obj4;
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                                try {
                                                    try {
                                                        str25 = str18;
                                                    } catch (Throwable th12) {
                                                        th = th12;
                                                        obj4 = obj5;
                                                        j11 = j7;
                                                        str3 = str11;
                                                        str9 = str18;
                                                        r2 = j11;
                                                        str2 = str19;
                                                        long currentTimeMillis622222 = System.currentTimeMillis() - r2;
                                                        FLogger.INSTANCE.mo426e(str9, "Auth flow unexpected exception: " + th.getMessage());
                                                        IApplog.Companion companion322222 = IApplog.Companion;
                                                        JSONObject jSONObject322222 = new JSONObject();
                                                        message = th.getMessage();
                                                        if (message == null) {
                                                        }
                                                        jSONObject322222.put(str7, message);
                                                        jSONObject322222.put(str6, "unexpected");
                                                        jSONObject322222.put(str8, currentTimeMillis622222);
                                                        jSONObject322222.put(str3, obj2);
                                                        Unit unit322222 = Unit.INSTANCE;
                                                        companion322222.reportEvent("icube_login_failure", jSONObject322222);
                                                        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, Boxing.boxLong(currentTimeMillis622222), "unexpected", null, th.getMessage(), null, null, null, null, null, 2000, null);
                                                        this.L$0 = null;
                                                        this.L$1 = null;
                                                        this.L$2 = null;
                                                        this.L$3 = null;
                                                        this.L$4 = null;
                                                        this.L$5 = null;
                                                        this.label = 8;
                                                        if (BuildersKt.withContext(Dispatchers.getMain(), new C087610(this.$callback, th, null), (Continuation) this) == obj4) {
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                    try {
                                                        FLogger.INSTANCE.mo430w(str25, str14 + th.getMessage());
                                                    } catch (Throwable th13) {
                                                        th = th13;
                                                        obj4 = obj5;
                                                        str9 = str25;
                                                        str3 = str11;
                                                        r2 = j7;
                                                        str2 = str19;
                                                        long currentTimeMillis6222222 = System.currentTimeMillis() - r2;
                                                        FLogger.INSTANCE.mo426e(str9, "Auth flow unexpected exception: " + th.getMessage());
                                                        IApplog.Companion companion3222222 = IApplog.Companion;
                                                        JSONObject jSONObject3222222 = new JSONObject();
                                                        message = th.getMessage();
                                                        if (message == null) {
                                                        }
                                                        jSONObject3222222.put(str7, message);
                                                        jSONObject3222222.put(str6, "unexpected");
                                                        jSONObject3222222.put(str8, currentTimeMillis6222222);
                                                        jSONObject3222222.put(str3, obj2);
                                                        Unit unit3222222 = Unit.INSTANCE;
                                                        companion3222222.reportEvent("icube_login_failure", jSONObject3222222);
                                                        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, Boxing.boxLong(currentTimeMillis6222222), "unexpected", null, th.getMessage(), null, null, null, null, null, 2000, null);
                                                        this.L$0 = null;
                                                        this.L$1 = null;
                                                        this.L$2 = null;
                                                        this.L$3 = null;
                                                        this.L$4 = null;
                                                        this.L$5 = null;
                                                        this.label = 8;
                                                        if (BuildersKt.withContext(Dispatchers.getMain(), new C087610(this.$callback, th, null), (Continuation) this) == obj4) {
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                } catch (TraeAuthException e11) {
                                                    e = e11;
                                                    obj4 = obj5;
                                                    j10 = j7;
                                                    str5 = "icube_login_failure";
                                                    obj3 = obj2;
                                                    str = str6;
                                                    str10 = str7;
                                                    str3 = str11;
                                                    str4 = str8;
                                                    str2 = str19;
                                                    j2 = j10;
                                                    long currentTimeMillis522222222 = System.currentTimeMillis() - j2;
                                                    IApplog.Companion companion22222222 = IApplog.Companion;
                                                    JSONObject jSONObject22222222 = new JSONObject();
                                                    userFacingMessage = e.getUserFacingMessage();
                                                    if (userFacingMessage == null) {
                                                    }
                                                    jSONObject22222222.put(str10, userFacingMessage);
                                                    code = e.getCode();
                                                    if (code == null) {
                                                    }
                                                    jSONObject22222222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                                                    String step22222222 = e.getStep();
                                                    jSONObject22222222.put(str, step22222222 != null ? step22222222 : "unknown");
                                                    jSONObject22222222.put(str4, currentTimeMillis522222222);
                                                    jSONObject22222222.put(str3, obj3);
                                                    Unit unit22222222 = Unit.INSTANCE;
                                                    companion22222222.reportEvent(str5, jSONObject22222222);
                                                    TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, null, e.getStep(), e.getCode(), null, null, e.getHttpCode(), e.getLogId(), null, null, 1636, null);
                                                    this.L$0 = null;
                                                    this.L$1 = null;
                                                    this.L$2 = null;
                                                    this.L$3 = null;
                                                    this.L$4 = null;
                                                    this.L$5 = null;
                                                    this.label = 7;
                                                    if (BuildersKt.withContext(Dispatchers.getMain(), new C08788(this.$callback, e, null), (Continuation) this) == obj4) {
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            } else {
                                                str19 = str20;
                                                str25 = str18;
                                            }
                                            longRef3.element = System.currentTimeMillis() - j8;
                                            str26 = str24;
                                            FLogger.INSTANCE.mo428i(str25, str13 + longRef3.element + str26);
                                            str18 = str25;
                                            long currentTimeMillis722 = System.currentTimeMillis();
                                            userRegionManager = UserRegionManager.INSTANCE;
                                            token = traeExchangeTokenResult.getToken();
                                            Intrinsics.checkNotNull(token);
                                            this.L$0 = longRef7;
                                            this.L$1 = longRef8;
                                            this.L$2 = longRef2;
                                            this.L$3 = longRef3;
                                            this.L$4 = longRef9;
                                            this.L$5 = null;
                                            this.J$0 = j7;
                                            this.J$1 = currentTimeMillis722;
                                            this.label = 5;
                                            if (userRegionManager.performCheckLoginSync(token, (Continuation) this) == obj5) {
                                                return obj5;
                                            }
                                            longRef10 = longRef9;
                                            long j18 = j7;
                                            j12 = currentTimeMillis722;
                                            j13 = j18;
                                            try {
                                                try {
                                                    longRef10.element = System.currentTimeMillis() - j12;
                                                    str9 = str18;
                                                    try {
                                                        FLogger.INSTANCE.mo428i(str9, str12 + longRef10.element + str26);
                                                        long currentTimeMillis8 = System.currentTimeMillis() - j13;
                                                        IApplog.Companion companion6 = IApplog.Companion;
                                                        JSONObject jSONObject4 = new JSONObject();
                                                        str27 = str8;
                                                    } catch (Throwable th14) {
                                                        th = th14;
                                                        obj4 = obj5;
                                                        j14 = j13;
                                                    }
                                                } catch (TraeAuthException e12) {
                                                    e = e12;
                                                    obj4 = obj5;
                                                    j14 = j13;
                                                    str3 = str11;
                                                }
                                            } catch (Throwable th15) {
                                                th = th15;
                                                obj4 = obj5;
                                                j14 = j13;
                                                str3 = str11;
                                                str9 = str18;
                                            }
                                            try {
                                                jSONObject4.put(str27, currentTimeMillis8);
                                                str8 = str27;
                                                obj7 = obj5;
                                                j15 = j13;
                                                try {
                                                    jSONObject4.put("step_login_ms", longRef7.element);
                                                    jSONObject4.put("step_refresh_token_ms", longRef8.element);
                                                    jSONObject4.put("step_exchange_token_ms", longRef2.element);
                                                    jSONObject4.put("step_user_info_ms", longRef3.element);
                                                    jSONObject4.put("step_check_login_ms", longRef10.element);
                                                    str3 = str11;
                                                    try {
                                                        jSONObject4.put(str3, "kick_off_login_continue");
                                                        Unit unit4 = Unit.INSTANCE;
                                                        companion6.reportEvent("icube_login_success", jSONObject4);
                                                        str2 = str19;
                                                        try {
                                                            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_SUCCESS, str2 + this.$loginPlatform, Boxing.boxLong(currentTimeMillis8), null, null, null, null, null, null, null, null, 2040, null);
                                                            main = Dispatchers.getMain();
                                                            c08776 = new C08776(this.$callback, null);
                                                            continuation2 = (Continuation) this;
                                                            this.L$0 = null;
                                                            this.L$1 = null;
                                                            this.L$2 = null;
                                                            this.L$3 = null;
                                                            this.L$4 = null;
                                                            j14 = j15;
                                                            try {
                                                                this.J$0 = j14;
                                                                this.label = 6;
                                                                obj4 = obj7;
                                                                if (BuildersKt.withContext(main, c08776, continuation2) != obj4) {
                                                                    return obj4;
                                                                }
                                                                r2 = j14;
                                                                try {
                                                                    return Unit.INSTANCE;
                                                                } catch (TraeAuthException e13) {
                                                                    e = e13;
                                                                    str5 = "icube_login_failure";
                                                                    obj3 = obj2;
                                                                    str = str6;
                                                                    str10 = str7;
                                                                    j16 = r2;
                                                                    str4 = str8;
                                                                    j2 = j16;
                                                                    long currentTimeMillis5222222222 = System.currentTimeMillis() - j2;
                                                                    IApplog.Companion companion222222222 = IApplog.Companion;
                                                                    JSONObject jSONObject222222222 = new JSONObject();
                                                                    userFacingMessage = e.getUserFacingMessage();
                                                                    if (userFacingMessage == null) {
                                                                    }
                                                                    jSONObject222222222.put(str10, userFacingMessage);
                                                                    code = e.getCode();
                                                                    if (code == null) {
                                                                    }
                                                                    jSONObject222222222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                                                                    String step222222222 = e.getStep();
                                                                    jSONObject222222222.put(str, step222222222 != null ? step222222222 : "unknown");
                                                                    jSONObject222222222.put(str4, currentTimeMillis5222222222);
                                                                    jSONObject222222222.put(str3, obj3);
                                                                    Unit unit222222222 = Unit.INSTANCE;
                                                                    companion222222222.reportEvent(str5, jSONObject222222222);
                                                                    TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, null, e.getStep(), e.getCode(), null, null, e.getHttpCode(), e.getLogId(), null, null, 1636, null);
                                                                    this.L$0 = null;
                                                                    this.L$1 = null;
                                                                    this.L$2 = null;
                                                                    this.L$3 = null;
                                                                    this.L$4 = null;
                                                                    this.L$5 = null;
                                                                    this.label = 7;
                                                                    if (BuildersKt.withContext(Dispatchers.getMain(), new C08788(this.$callback, e, null), (Continuation) this) == obj4) {
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                } catch (Throwable th16) {
                                                                    th = th16;
                                                                    long currentTimeMillis62222222 = System.currentTimeMillis() - r2;
                                                                    FLogger.INSTANCE.mo426e(str9, "Auth flow unexpected exception: " + th.getMessage());
                                                                    IApplog.Companion companion32222222 = IApplog.Companion;
                                                                    JSONObject jSONObject32222222 = new JSONObject();
                                                                    message = th.getMessage();
                                                                    if (message == null) {
                                                                    }
                                                                    jSONObject32222222.put(str7, message);
                                                                    jSONObject32222222.put(str6, "unexpected");
                                                                    jSONObject32222222.put(str8, currentTimeMillis62222222);
                                                                    jSONObject32222222.put(str3, obj2);
                                                                    Unit unit32222222 = Unit.INSTANCE;
                                                                    companion32222222.reportEvent("icube_login_failure", jSONObject32222222);
                                                                    TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, Boxing.boxLong(currentTimeMillis62222222), "unexpected", null, th.getMessage(), null, null, null, null, null, 2000, null);
                                                                    this.L$0 = null;
                                                                    this.L$1 = null;
                                                                    this.L$2 = null;
                                                                    this.L$3 = null;
                                                                    this.L$4 = null;
                                                                    this.L$5 = null;
                                                                    this.label = 8;
                                                                    if (BuildersKt.withContext(Dispatchers.getMain(), new C087610(this.$callback, th, null), (Continuation) this) == obj4) {
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            } catch (TraeAuthException e14) {
                                                                e = e14;
                                                                obj4 = obj7;
                                                                r2 = j14;
                                                                str5 = "icube_login_failure";
                                                                obj3 = obj2;
                                                                str = str6;
                                                                str10 = str7;
                                                                j16 = r2;
                                                                str4 = str8;
                                                                j2 = j16;
                                                                long currentTimeMillis52222222222 = System.currentTimeMillis() - j2;
                                                                IApplog.Companion companion2222222222 = IApplog.Companion;
                                                                JSONObject jSONObject2222222222 = new JSONObject();
                                                                userFacingMessage = e.getUserFacingMessage();
                                                                if (userFacingMessage == null) {
                                                                }
                                                                jSONObject2222222222.put(str10, userFacingMessage);
                                                                code = e.getCode();
                                                                if (code == null) {
                                                                }
                                                                jSONObject2222222222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                                                                String step2222222222 = e.getStep();
                                                                jSONObject2222222222.put(str, step2222222222 != null ? step2222222222 : "unknown");
                                                                jSONObject2222222222.put(str4, currentTimeMillis52222222222);
                                                                jSONObject2222222222.put(str3, obj3);
                                                                Unit unit2222222222 = Unit.INSTANCE;
                                                                companion2222222222.reportEvent(str5, jSONObject2222222222);
                                                                TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, null, e.getStep(), e.getCode(), null, null, e.getHttpCode(), e.getLogId(), null, null, 1636, null);
                                                                this.L$0 = null;
                                                                this.L$1 = null;
                                                                this.L$2 = null;
                                                                this.L$3 = null;
                                                                this.L$4 = null;
                                                                this.L$5 = null;
                                                                this.label = 7;
                                                                if (BuildersKt.withContext(Dispatchers.getMain(), new C08788(this.$callback, e, null), (Continuation) this) == obj4) {
                                                                }
                                                                return Unit.INSTANCE;
                                                            } catch (Throwable th17) {
                                                                th = th17;
                                                                obj4 = obj7;
                                                                r2 = j14;
                                                                long currentTimeMillis622222222 = System.currentTimeMillis() - r2;
                                                                FLogger.INSTANCE.mo426e(str9, "Auth flow unexpected exception: " + th.getMessage());
                                                                IApplog.Companion companion322222222 = IApplog.Companion;
                                                                JSONObject jSONObject322222222 = new JSONObject();
                                                                message = th.getMessage();
                                                                if (message == null) {
                                                                }
                                                                jSONObject322222222.put(str7, message);
                                                                jSONObject322222222.put(str6, "unexpected");
                                                                jSONObject322222222.put(str8, currentTimeMillis622222222);
                                                                jSONObject322222222.put(str3, obj2);
                                                                Unit unit322222222 = Unit.INSTANCE;
                                                                companion322222222.reportEvent("icube_login_failure", jSONObject322222222);
                                                                TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, Boxing.boxLong(currentTimeMillis622222222), "unexpected", null, th.getMessage(), null, null, null, null, null, 2000, null);
                                                                this.L$0 = null;
                                                                this.L$1 = null;
                                                                this.L$2 = null;
                                                                this.L$3 = null;
                                                                this.L$4 = null;
                                                                this.L$5 = null;
                                                                this.label = 8;
                                                                if (BuildersKt.withContext(Dispatchers.getMain(), new C087610(this.$callback, th, null), (Continuation) this) == obj4) {
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        } catch (TraeAuthException e15) {
                                                            e = e15;
                                                            obj4 = obj7;
                                                            j14 = j15;
                                                        } catch (Throwable th18) {
                                                            th = th18;
                                                            obj4 = obj7;
                                                            j14 = j15;
                                                        }
                                                    } catch (TraeAuthException e16) {
                                                        e = e16;
                                                        obj4 = obj7;
                                                        j14 = j15;
                                                        str2 = str19;
                                                        r2 = j14;
                                                        str5 = "icube_login_failure";
                                                        obj3 = obj2;
                                                        str = str6;
                                                        str10 = str7;
                                                        j16 = r2;
                                                        str4 = str8;
                                                        j2 = j16;
                                                        long currentTimeMillis522222222222 = System.currentTimeMillis() - j2;
                                                        IApplog.Companion companion22222222222 = IApplog.Companion;
                                                        JSONObject jSONObject22222222222 = new JSONObject();
                                                        userFacingMessage = e.getUserFacingMessage();
                                                        if (userFacingMessage == null) {
                                                        }
                                                        jSONObject22222222222.put(str10, userFacingMessage);
                                                        code = e.getCode();
                                                        if (code == null) {
                                                        }
                                                        jSONObject22222222222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                                                        String step22222222222 = e.getStep();
                                                        jSONObject22222222222.put(str, step22222222222 != null ? step22222222222 : "unknown");
                                                        jSONObject22222222222.put(str4, currentTimeMillis522222222222);
                                                        jSONObject22222222222.put(str3, obj3);
                                                        Unit unit22222222222 = Unit.INSTANCE;
                                                        companion22222222222.reportEvent(str5, jSONObject22222222222);
                                                        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, null, e.getStep(), e.getCode(), null, null, e.getHttpCode(), e.getLogId(), null, null, 1636, null);
                                                        this.L$0 = null;
                                                        this.L$1 = null;
                                                        this.L$2 = null;
                                                        this.L$3 = null;
                                                        this.L$4 = null;
                                                        this.L$5 = null;
                                                        this.label = 7;
                                                        if (BuildersKt.withContext(Dispatchers.getMain(), new C08788(this.$callback, e, null), (Continuation) this) == obj4) {
                                                        }
                                                        return Unit.INSTANCE;
                                                    } catch (Throwable th19) {
                                                        th = th19;
                                                        obj4 = obj7;
                                                        j14 = j15;
                                                        str2 = str19;
                                                        r2 = j14;
                                                        long currentTimeMillis6222222222 = System.currentTimeMillis() - r2;
                                                        FLogger.INSTANCE.mo426e(str9, "Auth flow unexpected exception: " + th.getMessage());
                                                        IApplog.Companion companion3222222222 = IApplog.Companion;
                                                        JSONObject jSONObject3222222222 = new JSONObject();
                                                        message = th.getMessage();
                                                        if (message == null) {
                                                        }
                                                        jSONObject3222222222.put(str7, message);
                                                        jSONObject3222222222.put(str6, "unexpected");
                                                        jSONObject3222222222.put(str8, currentTimeMillis6222222222);
                                                        jSONObject3222222222.put(str3, obj2);
                                                        Unit unit3222222222 = Unit.INSTANCE;
                                                        companion3222222222.reportEvent("icube_login_failure", jSONObject3222222222);
                                                        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, Boxing.boxLong(currentTimeMillis6222222222), "unexpected", null, th.getMessage(), null, null, null, null, null, 2000, null);
                                                        this.L$0 = null;
                                                        this.L$1 = null;
                                                        this.L$2 = null;
                                                        this.L$3 = null;
                                                        this.L$4 = null;
                                                        this.L$5 = null;
                                                        this.label = 8;
                                                        if (BuildersKt.withContext(Dispatchers.getMain(), new C087610(this.$callback, th, null), (Continuation) this) == obj4) {
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                } catch (TraeAuthException e17) {
                                                    e = e17;
                                                    obj4 = obj7;
                                                    str3 = str11;
                                                } catch (Throwable th20) {
                                                    th = th20;
                                                    obj4 = obj7;
                                                    str3 = str11;
                                                }
                                            } catch (TraeAuthException e18) {
                                                e = e18;
                                                obj4 = obj5;
                                                long j19 = j13;
                                                str3 = str11;
                                                str2 = str19;
                                                j2 = j19;
                                                str4 = str27;
                                                str5 = "icube_login_failure";
                                                obj3 = obj2;
                                                str = str6;
                                                str10 = str7;
                                                long currentTimeMillis5222222222222 = System.currentTimeMillis() - j2;
                                                IApplog.Companion companion222222222222 = IApplog.Companion;
                                                JSONObject jSONObject222222222222 = new JSONObject();
                                                userFacingMessage = e.getUserFacingMessage();
                                                if (userFacingMessage == null) {
                                                }
                                                jSONObject222222222222.put(str10, userFacingMessage);
                                                code = e.getCode();
                                                if (code == null) {
                                                }
                                                jSONObject222222222222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                                                String step222222222222 = e.getStep();
                                                jSONObject222222222222.put(str, step222222222222 != null ? step222222222222 : "unknown");
                                                jSONObject222222222222.put(str4, currentTimeMillis5222222222222);
                                                jSONObject222222222222.put(str3, obj3);
                                                Unit unit222222222222 = Unit.INSTANCE;
                                                companion222222222222.reportEvent(str5, jSONObject222222222222);
                                                TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, null, e.getStep(), e.getCode(), null, null, e.getHttpCode(), e.getLogId(), null, null, 1636, null);
                                                this.L$0 = null;
                                                this.L$1 = null;
                                                this.L$2 = null;
                                                this.L$3 = null;
                                                this.L$4 = null;
                                                this.L$5 = null;
                                                this.label = 7;
                                                if (BuildersKt.withContext(Dispatchers.getMain(), new C08788(this.$callback, e, null), (Continuation) this) == obj4) {
                                                }
                                                return Unit.INSTANCE;
                                            } catch (Throwable th21) {
                                                th = th21;
                                                obj4 = obj5;
                                                j14 = j13;
                                                str8 = str27;
                                                str3 = str11;
                                                str2 = str19;
                                                r2 = j14;
                                                long currentTimeMillis62222222222 = System.currentTimeMillis() - r2;
                                                FLogger.INSTANCE.mo426e(str9, "Auth flow unexpected exception: " + th.getMessage());
                                                IApplog.Companion companion32222222222 = IApplog.Companion;
                                                JSONObject jSONObject32222222222 = new JSONObject();
                                                message = th.getMessage();
                                                if (message == null) {
                                                }
                                                jSONObject32222222222.put(str7, message);
                                                jSONObject32222222222.put(str6, "unexpected");
                                                jSONObject32222222222.put(str8, currentTimeMillis62222222222);
                                                jSONObject32222222222.put(str3, obj2);
                                                Unit unit32222222222 = Unit.INSTANCE;
                                                companion32222222222.reportEvent("icube_login_failure", jSONObject32222222222);
                                                TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, Boxing.boxLong(currentTimeMillis62222222222), "unexpected", null, th.getMessage(), null, null, null, null, null, 2000, null);
                                                this.L$0 = null;
                                                this.L$1 = null;
                                                this.L$2 = null;
                                                this.L$3 = null;
                                                this.L$4 = null;
                                                this.L$5 = null;
                                                this.label = 8;
                                                if (BuildersKt.withContext(Dispatchers.getMain(), new C087610(this.$callback, th, null), (Continuation) this) == obj4) {
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        } catch (Throwable th22) {
                                            th = th22;
                                            str2 = str20;
                                            obj4 = coroutine_suspended;
                                            str3 = str11;
                                            str9 = str18;
                                            r2 = j5;
                                            long currentTimeMillis622222222222 = System.currentTimeMillis() - r2;
                                            FLogger.INSTANCE.mo426e(str9, "Auth flow unexpected exception: " + th.getMessage());
                                            IApplog.Companion companion322222222222 = IApplog.Companion;
                                            JSONObject jSONObject322222222222 = new JSONObject();
                                            message = th.getMessage();
                                            if (message == null) {
                                            }
                                            jSONObject322222222222.put(str7, message);
                                            jSONObject322222222222.put(str6, "unexpected");
                                            jSONObject322222222222.put(str8, currentTimeMillis622222222222);
                                            jSONObject322222222222.put(str3, obj2);
                                            Unit unit322222222222 = Unit.INSTANCE;
                                            companion322222222222.reportEvent("icube_login_failure", jSONObject322222222222);
                                            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, Boxing.boxLong(currentTimeMillis622222222222), "unexpected", null, th.getMessage(), null, null, null, null, null, 2000, null);
                                            this.L$0 = null;
                                            this.L$1 = null;
                                            this.L$2 = null;
                                            this.L$3 = null;
                                            this.L$4 = null;
                                            this.L$5 = null;
                                            this.label = 8;
                                            if (BuildersKt.withContext(Dispatchers.getMain(), new C087610(this.$callback, th, null), (Continuation) this) == obj4) {
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    } catch (Throwable th23) {
                                        th = th23;
                                        str2 = str20;
                                        obj4 = coroutine_suspended;
                                        str3 = str11;
                                        str9 = str22;
                                        r2 = j5;
                                        long currentTimeMillis6222222222222 = System.currentTimeMillis() - r2;
                                        FLogger.INSTANCE.mo426e(str9, "Auth flow unexpected exception: " + th.getMessage());
                                        IApplog.Companion companion3222222222222 = IApplog.Companion;
                                        JSONObject jSONObject3222222222222 = new JSONObject();
                                        message = th.getMessage();
                                        if (message == null) {
                                        }
                                        jSONObject3222222222222.put(str7, message);
                                        jSONObject3222222222222.put(str6, "unexpected");
                                        jSONObject3222222222222.put(str8, currentTimeMillis6222222222222);
                                        jSONObject3222222222222.put(str3, obj2);
                                        Unit unit3222222222222 = Unit.INSTANCE;
                                        companion3222222222222.reportEvent("icube_login_failure", jSONObject3222222222222);
                                        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, Boxing.boxLong(currentTimeMillis6222222222222), "unexpected", null, th.getMessage(), null, null, null, null, null, 2000, null);
                                        this.L$0 = null;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.L$3 = null;
                                        this.L$4 = null;
                                        this.L$5 = null;
                                        this.label = 8;
                                        if (BuildersKt.withContext(Dispatchers.getMain(), new C087610(this.$callback, th, null), (Continuation) this) == obj4) {
                                        }
                                        return Unit.INSTANCE;
                                    }
                                } catch (TraeAuthException e19) {
                                    e = e19;
                                    str2 = str20;
                                    obj4 = coroutine_suspended;
                                    str3 = str11;
                                    r2 = j5;
                                    str5 = "icube_login_failure";
                                    obj3 = obj2;
                                    str = str6;
                                    str10 = str7;
                                    j16 = r2;
                                    str4 = str8;
                                    j2 = j16;
                                    long currentTimeMillis52222222222222 = System.currentTimeMillis() - j2;
                                    IApplog.Companion companion2222222222222 = IApplog.Companion;
                                    JSONObject jSONObject2222222222222 = new JSONObject();
                                    userFacingMessage = e.getUserFacingMessage();
                                    if (userFacingMessage == null) {
                                    }
                                    jSONObject2222222222222.put(str10, userFacingMessage);
                                    code = e.getCode();
                                    if (code == null) {
                                    }
                                    jSONObject2222222222222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                                    String step2222222222222 = e.getStep();
                                    jSONObject2222222222222.put(str, step2222222222222 != null ? step2222222222222 : "unknown");
                                    jSONObject2222222222222.put(str4, currentTimeMillis52222222222222);
                                    jSONObject2222222222222.put(str3, obj3);
                                    Unit unit2222222222222 = Unit.INSTANCE;
                                    companion2222222222222.reportEvent(str5, jSONObject2222222222222);
                                    TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, null, e.getStep(), e.getCode(), null, null, e.getHttpCode(), e.getLogId(), null, null, 1636, null);
                                    this.L$0 = null;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.L$4 = null;
                                    this.L$5 = null;
                                    this.label = 7;
                                    if (BuildersKt.withContext(Dispatchers.getMain(), new C08788(this.$callback, e, null), (Continuation) this) == obj4) {
                                    }
                                    return Unit.INSTANCE;
                                }
                            } catch (TraeAuthException e20) {
                                e = e20;
                                obj4 = coroutine_suspended;
                                str2 = str20;
                                str3 = str11;
                                r2 = j5;
                                str5 = "icube_login_failure";
                                obj3 = obj2;
                                str = str6;
                                str10 = str7;
                                j16 = r2;
                                str4 = str8;
                                j2 = j16;
                                long currentTimeMillis522222222222222 = System.currentTimeMillis() - j2;
                                IApplog.Companion companion22222222222222 = IApplog.Companion;
                                JSONObject jSONObject22222222222222 = new JSONObject();
                                userFacingMessage = e.getUserFacingMessage();
                                if (userFacingMessage == null) {
                                }
                                jSONObject22222222222222.put(str10, userFacingMessage);
                                code = e.getCode();
                                if (code == null) {
                                }
                                jSONObject22222222222222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                                String step22222222222222 = e.getStep();
                                jSONObject22222222222222.put(str, step22222222222222 != null ? step22222222222222 : "unknown");
                                jSONObject22222222222222.put(str4, currentTimeMillis522222222222222);
                                jSONObject22222222222222.put(str3, obj3);
                                Unit unit22222222222222 = Unit.INSTANCE;
                                companion22222222222222.reportEvent(str5, jSONObject22222222222222);
                                TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, null, e.getStep(), e.getCode(), null, null, e.getHttpCode(), e.getLogId(), null, null, 1636, null);
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.L$5 = null;
                                this.label = 7;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new C08788(this.$callback, e, null), (Continuation) this) == obj4) {
                                }
                                return Unit.INSTANCE;
                            } catch (Throwable th24) {
                                th = th24;
                                obj4 = coroutine_suspended;
                                str2 = str20;
                                str3 = str11;
                                str9 = str22;
                                r2 = j5;
                                long currentTimeMillis62222222222222 = System.currentTimeMillis() - r2;
                                FLogger.INSTANCE.mo426e(str9, "Auth flow unexpected exception: " + th.getMessage());
                                IApplog.Companion companion32222222222222 = IApplog.Companion;
                                JSONObject jSONObject32222222222222 = new JSONObject();
                                message = th.getMessage();
                                if (message == null) {
                                }
                                jSONObject32222222222222.put(str7, message);
                                jSONObject32222222222222.put(str6, "unexpected");
                                jSONObject32222222222222.put(str8, currentTimeMillis62222222222222);
                                jSONObject32222222222222.put(str3, obj2);
                                Unit unit32222222222222 = Unit.INSTANCE;
                                companion32222222222222.reportEvent("icube_login_failure", jSONObject32222222222222);
                                TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, Boxing.boxLong(currentTimeMillis62222222222222), "unexpected", null, th.getMessage(), null, null, null, null, null, 2000, null);
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.L$5 = null;
                                this.label = 8;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new C087610(this.$callback, th, null), (Continuation) this) == obj4) {
                                }
                                return Unit.INSTANCE;
                            }
                        } catch (TraeAuthException e21) {
                            e = e21;
                            obj4 = coroutine_suspended;
                            r2 = j4;
                            str2 = str20;
                            str3 = str11;
                            str5 = "icube_login_failure";
                            obj3 = obj2;
                            str = str6;
                            str10 = str7;
                            j16 = r2;
                            str4 = str8;
                            j2 = j16;
                            long currentTimeMillis5222222222222222 = System.currentTimeMillis() - j2;
                            IApplog.Companion companion222222222222222 = IApplog.Companion;
                            JSONObject jSONObject222222222222222 = new JSONObject();
                            userFacingMessage = e.getUserFacingMessage();
                            if (userFacingMessage == null) {
                            }
                            jSONObject222222222222222.put(str10, userFacingMessage);
                            code = e.getCode();
                            if (code == null) {
                            }
                            jSONObject222222222222222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                            String step222222222222222 = e.getStep();
                            jSONObject222222222222222.put(str, step222222222222222 != null ? step222222222222222 : "unknown");
                            jSONObject222222222222222.put(str4, currentTimeMillis5222222222222222);
                            jSONObject222222222222222.put(str3, obj3);
                            Unit unit222222222222222 = Unit.INSTANCE;
                            companion222222222222222.reportEvent(str5, jSONObject222222222222222);
                            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, null, e.getStep(), e.getCode(), null, null, e.getHttpCode(), e.getLogId(), null, null, 1636, null);
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.L$5 = null;
                            this.label = 7;
                            if (BuildersKt.withContext(Dispatchers.getMain(), new C08788(this.$callback, e, null), (Continuation) this) == obj4) {
                            }
                            return Unit.INSTANCE;
                        } catch (Throwable th25) {
                            th = th25;
                            obj4 = coroutine_suspended;
                            r2 = j4;
                            str2 = str20;
                            str3 = str11;
                            str9 = str18;
                            long currentTimeMillis622222222222222 = System.currentTimeMillis() - r2;
                            FLogger.INSTANCE.mo426e(str9, "Auth flow unexpected exception: " + th.getMessage());
                            IApplog.Companion companion322222222222222 = IApplog.Companion;
                            JSONObject jSONObject322222222222222 = new JSONObject();
                            message = th.getMessage();
                            if (message == null) {
                            }
                            jSONObject322222222222222.put(str7, message);
                            jSONObject322222222222222.put(str6, "unexpected");
                            jSONObject322222222222222.put(str8, currentTimeMillis622222222222222);
                            jSONObject322222222222222.put(str3, obj2);
                            Unit unit322222222222222 = Unit.INSTANCE;
                            companion322222222222222.reportEvent("icube_login_failure", jSONObject322222222222222);
                            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, Boxing.boxLong(currentTimeMillis622222222222222), "unexpected", null, th.getMessage(), null, null, null, null, null, 2000, null);
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.L$5 = null;
                            this.label = 8;
                            if (BuildersKt.withContext(Dispatchers.getMain(), new C087610(this.$callback, th, null), (Continuation) this) == obj4) {
                            }
                            return Unit.INSTANCE;
                        }
                    } catch (TraeAuthException e22) {
                        e = e22;
                        obj4 = coroutine_suspended;
                        r2 = j4;
                        str3 = str11;
                        str2 = str19;
                        str5 = "icube_login_failure";
                        obj3 = obj2;
                        str = str6;
                        str10 = str7;
                        j16 = r2;
                        str4 = str8;
                        j2 = j16;
                        long currentTimeMillis52222222222222222 = System.currentTimeMillis() - j2;
                        IApplog.Companion companion2222222222222222 = IApplog.Companion;
                        JSONObject jSONObject2222222222222222 = new JSONObject();
                        userFacingMessage = e.getUserFacingMessage();
                        if (userFacingMessage == null) {
                        }
                        jSONObject2222222222222222.put(str10, userFacingMessage);
                        code = e.getCode();
                        if (code == null) {
                        }
                        jSONObject2222222222222222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                        String step2222222222222222 = e.getStep();
                        jSONObject2222222222222222.put(str, step2222222222222222 != null ? step2222222222222222 : "unknown");
                        jSONObject2222222222222222.put(str4, currentTimeMillis52222222222222222);
                        jSONObject2222222222222222.put(str3, obj3);
                        Unit unit2222222222222222 = Unit.INSTANCE;
                        companion2222222222222222.reportEvent(str5, jSONObject2222222222222222);
                        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, null, e.getStep(), e.getCode(), null, null, e.getHttpCode(), e.getLogId(), null, null, 1636, null);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.L$5 = null;
                        this.label = 7;
                        if (BuildersKt.withContext(Dispatchers.getMain(), new C08788(this.$callback, e, null), (Continuation) this) == obj4) {
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th26) {
                        th = th26;
                    }
                } catch (TraeAuthException e23) {
                    e = e23;
                    obj4 = coroutine_suspended;
                    str3 = str11;
                    str2 = str19;
                    r2 = currentTimeMillis4;
                    str5 = "icube_login_failure";
                    obj3 = obj2;
                    str = str6;
                    str10 = str7;
                    j16 = r2;
                    str4 = str8;
                    j2 = j16;
                    long currentTimeMillis522222222222222222 = System.currentTimeMillis() - j2;
                    IApplog.Companion companion22222222222222222 = IApplog.Companion;
                    JSONObject jSONObject22222222222222222 = new JSONObject();
                    userFacingMessage = e.getUserFacingMessage();
                    if (userFacingMessage == null) {
                    }
                    jSONObject22222222222222222.put(str10, userFacingMessage);
                    code = e.getCode();
                    if (code == null) {
                    }
                    jSONObject22222222222222222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                    String step22222222222222222 = e.getStep();
                    jSONObject22222222222222222.put(str, step22222222222222222 != null ? step22222222222222222 : "unknown");
                    jSONObject22222222222222222.put(str4, currentTimeMillis522222222222222222);
                    jSONObject22222222222222222.put(str3, obj3);
                    Unit unit22222222222222222 = Unit.INSTANCE;
                    companion22222222222222222.reportEvent(str5, jSONObject22222222222222222);
                    TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, null, e.getStep(), e.getCode(), null, null, e.getHttpCode(), e.getLogId(), null, null, 1636, null);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.label = 7;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C08788(this.$callback, e, null), (Continuation) this) == obj4) {
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th27) {
                    th = th27;
                    obj4 = coroutine_suspended;
                    str3 = str11;
                    str9 = str18;
                    str2 = str19;
                    r2 = currentTimeMillis4;
                    long currentTimeMillis6222222222222222 = System.currentTimeMillis() - r2;
                    FLogger.INSTANCE.mo426e(str9, "Auth flow unexpected exception: " + th.getMessage());
                    IApplog.Companion companion3222222222222222 = IApplog.Companion;
                    JSONObject jSONObject3222222222222222 = new JSONObject();
                    message = th.getMessage();
                    if (message == null) {
                    }
                    jSONObject3222222222222222.put(str7, message);
                    jSONObject3222222222222222.put(str6, "unexpected");
                    jSONObject3222222222222222.put(str8, currentTimeMillis6222222222222222);
                    jSONObject3222222222222222.put(str3, obj2);
                    Unit unit3222222222222222 = Unit.INSTANCE;
                    companion3222222222222222.reportEvent("icube_login_failure", jSONObject3222222222222222);
                    TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, Boxing.boxLong(currentTimeMillis6222222222222222), "unexpected", null, th.getMessage(), null, null, null, null, null, 2000, null);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.label = 8;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C087610(this.$callback, th, null), (Continuation) this) == obj4) {
                    }
                    return Unit.INSTANCE;
                }
                break;
            case 1:
                obj2 = "device_limit";
                long j20 = this.J$1;
                long j21 = this.J$0;
                Ref.LongRef longRef15 = (Ref.LongRef) this.L$5;
                Ref.LongRef longRef16 = (Ref.LongRef) this.L$4;
                Ref.LongRef longRef17 = (Ref.LongRef) this.L$3;
                Ref.LongRef longRef18 = (Ref.LongRef) this.L$2;
                Ref.LongRef longRef19 = (Ref.LongRef) this.L$1;
                CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    str19 = "device_limit_continue_";
                    str18 = "TraeAuthManager";
                    str16 = "ms";
                    retryOnTransient = obj;
                    longRef3 = longRef16;
                    coroutineScope = coroutineScope3;
                    longRef5 = longRef18;
                    str14 = "fetchUserInfo failed (non-blocking): ";
                    str13 = "onPassportLoginSuccess: fetchUserInfo done in ";
                    j4 = j21;
                    str11 = "login_platform";
                    str8 = "duration_ms";
                    longRef2 = longRef17;
                    str15 = "onPassportLoginSuccess: doExchangeToken done in ";
                    str12 = "onPassportLoginSuccess: performCheckLoginSync done in ";
                    j3 = j20;
                    str6 = "failed_step";
                    str7 = ISignalReportConstants.KEY_REASON;
                    longRef4 = longRef15;
                    longRef = longRef19;
                    traeGetRefreshTokenResult = (TraeGetRefreshTokenResult) retryOnTransient;
                    Ref.LongRef longRef142 = longRef4;
                    if (!Intrinsics.areEqual(traeGetRefreshTokenResult.getDeviceLimitReached(), Boxing.boxBoolean(true))) {
                    }
                } catch (TraeAuthException e24) {
                    e = e24;
                    str = "failed_step";
                    str2 = "device_limit_continue_";
                    str3 = "login_platform";
                    str4 = "duration_ms";
                    str5 = "icube_login_failure";
                    obj3 = obj2;
                    j = j21;
                    str10 = ISignalReportConstants.KEY_REASON;
                    obj4 = coroutine_suspended;
                    j2 = j;
                    long currentTimeMillis5222222222222222222 = System.currentTimeMillis() - j2;
                    IApplog.Companion companion222222222222222222 = IApplog.Companion;
                    JSONObject jSONObject222222222222222222 = new JSONObject();
                    userFacingMessage = e.getUserFacingMessage();
                    if (userFacingMessage == null) {
                    }
                    jSONObject222222222222222222.put(str10, userFacingMessage);
                    code = e.getCode();
                    if (code == null) {
                    }
                    jSONObject222222222222222222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                    String step222222222222222222 = e.getStep();
                    jSONObject222222222222222222.put(str, step222222222222222222 != null ? step222222222222222222 : "unknown");
                    jSONObject222222222222222222.put(str4, currentTimeMillis5222222222222222222);
                    jSONObject222222222222222222.put(str3, obj3);
                    Unit unit222222222222222222 = Unit.INSTANCE;
                    companion222222222222222222.reportEvent(str5, jSONObject222222222222222222);
                    TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, null, e.getStep(), e.getCode(), null, null, e.getHttpCode(), e.getLogId(), null, null, 1636, null);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.label = 7;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C08788(this.$callback, e, null), (Continuation) this) == obj4) {
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th28) {
                    th = th28;
                    str6 = "failed_step";
                    str7 = ISignalReportConstants.KEY_REASON;
                    str2 = "device_limit_continue_";
                    str3 = "login_platform";
                    r2 = j21;
                    obj4 = coroutine_suspended;
                    str9 = "TraeAuthManager";
                    str8 = "duration_ms";
                    long currentTimeMillis62222222222222222 = System.currentTimeMillis() - r2;
                    FLogger.INSTANCE.mo426e(str9, "Auth flow unexpected exception: " + th.getMessage());
                    IApplog.Companion companion32222222222222222 = IApplog.Companion;
                    JSONObject jSONObject32222222222222222 = new JSONObject();
                    message = th.getMessage();
                    if (message == null) {
                    }
                    jSONObject32222222222222222.put(str7, message);
                    jSONObject32222222222222222.put(str6, "unexpected");
                    jSONObject32222222222222222.put(str8, currentTimeMillis62222222222222222);
                    jSONObject32222222222222222.put(str3, obj2);
                    Unit unit32222222222222222 = Unit.INSTANCE;
                    companion32222222222222222.reportEvent("icube_login_failure", jSONObject32222222222222222);
                    TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, Boxing.boxLong(currentTimeMillis62222222222222222), "unexpected", null, th.getMessage(), null, null, null, null, null, 2000, null);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.label = 8;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C087610(this.$callback, th, null), (Continuation) this) == obj4) {
                    }
                    return Unit.INSTANCE;
                }
                break;
            case 2:
                obj2 = "device_limit";
                r2 = this.J$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    str6 = "failed_step";
                    str7 = ISignalReportConstants.KEY_REASON;
                    str18 = "TraeAuthManager";
                    str11 = "login_platform";
                    str8 = "duration_ms";
                    str20 = "device_limit_continue_";
                    j4 = r2;
                    return Unit.INSTANCE;
                } catch (TraeAuthException e25) {
                    e = e25;
                    str = "failed_step";
                    str2 = "device_limit_continue_";
                    str3 = "login_platform";
                    str4 = "duration_ms";
                    str5 = "icube_login_failure";
                    obj3 = obj2;
                    j = r2;
                    str10 = ISignalReportConstants.KEY_REASON;
                    obj4 = coroutine_suspended;
                    j2 = j;
                    long currentTimeMillis52222222222222222222 = System.currentTimeMillis() - j2;
                    IApplog.Companion companion2222222222222222222 = IApplog.Companion;
                    JSONObject jSONObject2222222222222222222 = new JSONObject();
                    userFacingMessage = e.getUserFacingMessage();
                    if (userFacingMessage == null) {
                    }
                    jSONObject2222222222222222222.put(str10, userFacingMessage);
                    code = e.getCode();
                    if (code == null) {
                    }
                    jSONObject2222222222222222222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                    String step2222222222222222222 = e.getStep();
                    jSONObject2222222222222222222.put(str, step2222222222222222222 != null ? step2222222222222222222 : "unknown");
                    jSONObject2222222222222222222.put(str4, currentTimeMillis52222222222222222222);
                    jSONObject2222222222222222222.put(str3, obj3);
                    Unit unit2222222222222222222 = Unit.INSTANCE;
                    companion2222222222222222222.reportEvent(str5, jSONObject2222222222222222222);
                    TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, null, e.getStep(), e.getCode(), null, null, e.getHttpCode(), e.getLogId(), null, null, 1636, null);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.label = 7;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C08788(this.$callback, e, null), (Continuation) this) == obj4) {
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th29) {
                    th = th29;
                    str6 = "failed_step";
                    str7 = ISignalReportConstants.KEY_REASON;
                    str2 = "device_limit_continue_";
                    str3 = "login_platform";
                    str8 = "duration_ms";
                    obj4 = coroutine_suspended;
                    str9 = "TraeAuthManager";
                    long currentTimeMillis622222222222222222 = System.currentTimeMillis() - r2;
                    FLogger.INSTANCE.mo426e(str9, "Auth flow unexpected exception: " + th.getMessage());
                    IApplog.Companion companion322222222222222222 = IApplog.Companion;
                    JSONObject jSONObject322222222222222222 = new JSONObject();
                    message = th.getMessage();
                    if (message == null) {
                    }
                    jSONObject322222222222222222.put(str7, message);
                    jSONObject322222222222222222.put(str6, "unexpected");
                    jSONObject322222222222222222.put(str8, currentTimeMillis622222222222222222);
                    jSONObject322222222222222222.put(str3, obj2);
                    Unit unit322222222222222222 = Unit.INSTANCE;
                    companion322222222222222222.reportEvent("icube_login_failure", jSONObject322222222222222222);
                    TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, Boxing.boxLong(currentTimeMillis622222222222222222), "unexpected", null, th.getMessage(), null, null, null, null, null, 2000, null);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.label = 8;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C087610(this.$callback, th, null), (Continuation) this) == obj4) {
                    }
                    return Unit.INSTANCE;
                }
            case 3:
                obj2 = "device_limit";
                long j22 = this.J$1;
                j5 = this.J$0;
                Ref.LongRef longRef20 = (Ref.LongRef) this.L$5;
                Ref.LongRef longRef21 = (Ref.LongRef) this.L$4;
                Ref.LongRef longRef22 = (Ref.LongRef) this.L$3;
                Ref.LongRef longRef23 = (Ref.LongRef) this.L$2;
                Ref.LongRef longRef24 = (Ref.LongRef) this.L$1;
                try {
                    ResultKt.throwOnFailure(obj);
                    retryOnTransient2 = obj;
                    str15 = "onPassportLoginSuccess: doExchangeToken done in ";
                    str13 = "onPassportLoginSuccess: fetchUserInfo done in ";
                    str21 = "ms";
                    str14 = "fetchUserInfo failed (non-blocking): ";
                    str22 = "TraeAuthManager";
                    longRef3 = longRef21;
                    str8 = "duration_ms";
                    longRef2 = longRef22;
                    str12 = "onPassportLoginSuccess: performCheckLoginSync done in ";
                    currentTimeMillis2 = j22;
                    str6 = "failed_step";
                    str7 = ISignalReportConstants.KEY_REASON;
                    longRef9 = longRef20;
                    longRef8 = longRef23;
                    str11 = "login_platform";
                    str20 = "device_limit_continue_";
                    longRef7 = longRef24;
                    traeExchangeTokenResult = (TraeExchangeTokenResult) retryOnTransient2;
                    longRef2.element = System.currentTimeMillis() - currentTimeMillis2;
                    FLogger.INSTANCE.mo428i(str22, str15 + longRef2.element + str21);
                    TraeAuthStorage traeAuthStorage22 = TraeAuthStorage.INSTANCE;
                    String token22 = traeExchangeTokenResult.getToken();
                    Intrinsics.checkNotNull(token22);
                    traeAuthStorage22.saveJwtToken(token22, traeExchangeTokenResult.getTokenExpireAt());
                    refreshToken = traeExchangeTokenResult.getRefreshToken();
                    if (refreshToken != null) {
                    }
                    str24 = str21;
                    str18 = str22;
                    TraeAuthStorage.INSTANCE.saveLastExchangeSuccessAt(System.currentTimeMillis() / BytePatchException.ErrorCode.paramsError);
                    currentTimeMillis3 = System.currentTimeMillis();
                    Result.Companion companion42 = Result.Companion;
                    UserInfoFetcher userInfoFetcher2 = UserInfoFetcher.INSTANCE;
                    String token32 = traeExchangeTokenResult.getToken();
                    Intrinsics.checkNotNull(token32);
                    this.L$0 = longRef7;
                    this.L$1 = longRef8;
                    this.L$2 = longRef2;
                    this.L$3 = longRef3;
                    this.L$4 = longRef9;
                    this.L$5 = traeExchangeTokenResult;
                    this.J$0 = j5;
                    this.J$1 = currentTimeMillis3;
                    this.label = 4;
                    doFetch = userInfoFetcher2.doFetch(token32, this);
                    obj5 = coroutine_suspended;
                    if (doFetch != obj5) {
                    }
                } catch (TraeAuthException e26) {
                    e = e26;
                    r2 = j5;
                    str = "failed_step";
                    str2 = "device_limit_continue_";
                    str3 = "login_platform";
                    str4 = "duration_ms";
                    str5 = "icube_login_failure";
                    obj3 = obj2;
                    j = r2;
                    str10 = ISignalReportConstants.KEY_REASON;
                    obj4 = coroutine_suspended;
                    j2 = j;
                    long currentTimeMillis522222222222222222222 = System.currentTimeMillis() - j2;
                    IApplog.Companion companion22222222222222222222 = IApplog.Companion;
                    JSONObject jSONObject22222222222222222222 = new JSONObject();
                    userFacingMessage = e.getUserFacingMessage();
                    if (userFacingMessage == null) {
                    }
                    jSONObject22222222222222222222.put(str10, userFacingMessage);
                    code = e.getCode();
                    if (code == null) {
                    }
                    jSONObject22222222222222222222.put(CDNLoader.DIAGNOSE_ERROR_CODE, code);
                    String step22222222222222222222 = e.getStep();
                    jSONObject22222222222222222222.put(str, step22222222222222222222 != null ? step22222222222222222222 : "unknown");
                    jSONObject22222222222222222222.put(str4, currentTimeMillis522222222222222222222);
                    jSONObject22222222222222222222.put(str3, obj3);
                    Unit unit22222222222222222222 = Unit.INSTANCE;
                    companion22222222222222222222.reportEvent(str5, jSONObject22222222222222222222);
                    TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, null, e.getStep(), e.getCode(), null, null, e.getHttpCode(), e.getLogId(), null, null, 1636, null);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.label = 7;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C08788(this.$callback, e, null), (Continuation) this) == obj4) {
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th30) {
                    th = th30;
                    r2 = j5;
                    str6 = "failed_step";
                    str7 = ISignalReportConstants.KEY_REASON;
                    str2 = "device_limit_continue_";
                    str3 = "login_platform";
                    str8 = "duration_ms";
                    obj4 = coroutine_suspended;
                    str9 = "TraeAuthManager";
                    long currentTimeMillis6222222222222222222 = System.currentTimeMillis() - r2;
                    FLogger.INSTANCE.mo426e(str9, "Auth flow unexpected exception: " + th.getMessage());
                    IApplog.Companion companion3222222222222222222 = IApplog.Companion;
                    JSONObject jSONObject3222222222222222222 = new JSONObject();
                    message = th.getMessage();
                    if (message == null) {
                    }
                    jSONObject3222222222222222222.put(str7, message);
                    jSONObject3222222222222222222.put(str6, "unexpected");
                    jSONObject3222222222222222222.put(str8, currentTimeMillis6222222222222222222);
                    jSONObject3222222222222222222.put(str3, obj2);
                    Unit unit3222222222222222222 = Unit.INSTANCE;
                    companion3222222222222222222.reportEvent("icube_login_failure", jSONObject3222222222222222222);
                    TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, str2 + this.$loginPlatform, Boxing.boxLong(currentTimeMillis6222222222222222222), "unexpected", null, th.getMessage(), null, null, null, null, null, 2000, null);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.label = 8;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C087610(this.$callback, th, null), (Continuation) this) == obj4) {
                    }
                    return Unit.INSTANCE;
                }
                break;
            case 4:
                obj2 = "device_limit";
                long j23 = this.J$1;
                long j24 = this.J$0;
                TraeExchangeTokenResult traeExchangeTokenResult2 = (TraeExchangeTokenResult) this.L$5;
                Ref.LongRef longRef25 = (Ref.LongRef) this.L$4;
                Ref.LongRef longRef26 = (Ref.LongRef) this.L$3;
                Ref.LongRef longRef27 = (Ref.LongRef) this.L$2;
                Ref.LongRef longRef28 = (Ref.LongRef) this.L$1;
                Ref.LongRef longRef29 = (Ref.LongRef) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    doFetch = obj;
                    str18 = "TraeAuthManager";
                    str24 = "ms";
                    longRef3 = longRef26;
                    traeExchangeTokenResult = traeExchangeTokenResult2;
                    obj5 = coroutine_suspended;
                    str8 = "duration_ms";
                    longRef2 = longRef27;
                    str12 = "onPassportLoginSuccess: performCheckLoginSync done in ";
                    str13 = "onPassportLoginSuccess: fetchUserInfo done in ";
                    str14 = "fetchUserInfo failed (non-blocking): ";
                    j7 = j24;
                    j8 = j23;
                    str6 = "failed_step";
                    str7 = ISignalReportConstants.KEY_REASON;
                    longRef9 = longRef25;
                    longRef8 = longRef28;
                    str11 = "login_platform";
                    str20 = "device_limit_continue_";
                    longRef7 = longRef29;
                    userInfoResponse = (UserInfoFetcher.UserInfoResponse) doFetch;
                    if (userInfoResponse == null) {
                    }
                    if (userInfoResponse != null) {
                        break;
                    }
                    if (((userInfoResponse != null || (responseMetadata = userInfoResponse.getResponseMetadata()) == null) ? null : responseMetadata.getError()) == null) {
                        userId = result.getUserId();
                        if (userId != null) {
                            z = false;
                            if (!z) {
                            }
                            break;
                        }
                        z = true;
                        if (!z) {
                        }
                    }
                    obj6 = Result.constructor-impl(Unit.INSTANCE);
                    j7 = j7;
                } catch (Throwable th31) {
                    th = th31;
                    str18 = "TraeAuthManager";
                    str24 = "ms";
                    longRef3 = longRef26;
                    traeExchangeTokenResult = traeExchangeTokenResult2;
                    obj5 = coroutine_suspended;
                    str8 = "duration_ms";
                    longRef2 = longRef27;
                    str12 = "onPassportLoginSuccess: performCheckLoginSync done in ";
                    str13 = "onPassportLoginSuccess: fetchUserInfo done in ";
                    str14 = "fetchUserInfo failed (non-blocking): ";
                    j7 = j24;
                    j8 = j23;
                    str6 = "failed_step";
                    str7 = ISignalReportConstants.KEY_REASON;
                    longRef9 = longRef25;
                    longRef8 = longRef28;
                    str11 = "login_platform";
                    str20 = "device_limit_continue_";
                    longRef7 = longRef29;
                    Result.Companion companion522 = Result.Companion;
                    obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                    j7 = j7;
                    th = Result.exceptionOrNull-impl(obj6);
                    if (th != null) {
                    }
                    longRef3.element = System.currentTimeMillis() - j8;
                    str26 = str24;
                    FLogger.INSTANCE.mo428i(str25, str13 + longRef3.element + str26);
                    str18 = str25;
                    long currentTimeMillis7222 = System.currentTimeMillis();
                    userRegionManager = UserRegionManager.INSTANCE;
                    token = traeExchangeTokenResult.getToken();
                    Intrinsics.checkNotNull(token);
                    this.L$0 = longRef7;
                    this.L$1 = longRef8;
                    this.L$2 = longRef2;
                    this.L$3 = longRef3;
                    this.L$4 = longRef9;
                    this.L$5 = null;
                    this.J$0 = j7;
                    this.J$1 = currentTimeMillis7222;
                    this.label = 5;
                    if (userRegionManager.performCheckLoginSync(token, (Continuation) this) == obj5) {
                    }
                }
                th = Result.exceptionOrNull-impl(obj6);
                if (th != null) {
                }
                longRef3.element = System.currentTimeMillis() - j8;
                str26 = str24;
                FLogger.INSTANCE.mo428i(str25, str13 + longRef3.element + str26);
                str18 = str25;
                long currentTimeMillis72222 = System.currentTimeMillis();
                userRegionManager = UserRegionManager.INSTANCE;
                token = traeExchangeTokenResult.getToken();
                Intrinsics.checkNotNull(token);
                this.L$0 = longRef7;
                this.L$1 = longRef8;
                this.L$2 = longRef2;
                this.L$3 = longRef3;
                this.L$4 = longRef9;
                this.L$5 = null;
                this.J$0 = j7;
                this.J$1 = currentTimeMillis72222;
                this.label = 5;
                if (userRegionManager.performCheckLoginSync(token, (Continuation) this) == obj5) {
                }
                break;
            case 5:
                long j25 = this.J$1;
                long j26 = this.J$0;
                Ref.LongRef longRef30 = (Ref.LongRef) this.L$4;
                Ref.LongRef longRef31 = (Ref.LongRef) this.L$3;
                Ref.LongRef longRef32 = (Ref.LongRef) this.L$2;
                Ref.LongRef longRef33 = (Ref.LongRef) this.L$1;
                Ref.LongRef longRef34 = (Ref.LongRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                str12 = "onPassportLoginSuccess: performCheckLoginSync done in ";
                str19 = "device_limit_continue_";
                str18 = "TraeAuthManager";
                str11 = "login_platform";
                str8 = "duration_ms";
                longRef7 = longRef34;
                longRef3 = longRef31;
                obj5 = coroutine_suspended;
                longRef2 = longRef32;
                str26 = "ms";
                longRef10 = longRef30;
                j13 = j26;
                j12 = j25;
                obj2 = "device_limit";
                str6 = "failed_step";
                str7 = ISignalReportConstants.KEY_REASON;
                longRef8 = longRef33;
                longRef10.element = System.currentTimeMillis() - j12;
                str9 = str18;
                FLogger.INSTANCE.mo428i(str9, str12 + longRef10.element + str26);
                long currentTimeMillis82 = System.currentTimeMillis() - j13;
                IApplog.Companion companion62 = IApplog.Companion;
                JSONObject jSONObject42 = new JSONObject();
                str27 = str8;
                jSONObject42.put(str27, currentTimeMillis82);
                str8 = str27;
                obj7 = obj5;
                j15 = j13;
                jSONObject42.put("step_login_ms", longRef7.element);
                jSONObject42.put("step_refresh_token_ms", longRef8.element);
                jSONObject42.put("step_exchange_token_ms", longRef2.element);
                jSONObject42.put("step_user_info_ms", longRef3.element);
                jSONObject42.put("step_check_login_ms", longRef10.element);
                str3 = str11;
                jSONObject42.put(str3, "kick_off_login_continue");
                Unit unit42 = Unit.INSTANCE;
                companion62.reportEvent("icube_login_success", jSONObject42);
                str2 = str19;
                TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_SUCCESS, str2 + this.$loginPlatform, Boxing.boxLong(currentTimeMillis82), null, null, null, null, null, null, null, null, 2040, null);
                main = Dispatchers.getMain();
                c08776 = new C08776(this.$callback, null);
                continuation2 = (Continuation) this;
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                j14 = j15;
                this.J$0 = j14;
                this.label = 6;
                obj4 = obj7;
                if (BuildersKt.withContext(main, c08776, continuation2) != obj4) {
                }
                break;
            case 6:
                long j27 = this.J$0;
                ResultKt.throwOnFailure(obj);
                obj2 = "device_limit";
                str6 = "failed_step";
                str7 = ISignalReportConstants.KEY_REASON;
                str2 = "device_limit_continue_";
                str3 = "login_platform";
                str8 = "duration_ms";
                obj4 = coroutine_suspended;
                str9 = "TraeAuthManager";
                r2 = j27;
                return Unit.INSTANCE;
            case 7:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 8:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TraeAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.login.traeauth.TraeAuthManager$onLoginContinueByDeviceLimit$1$1", f = "TraeAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.login.traeauth.TraeAuthManager$onLoginContinueByDeviceLimit$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class C08751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TraeAuthManager.TraeAuthCallback $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08751(TraeAuthManager.TraeAuthCallback traeAuthCallback, Continuation<? super C08751> continuation) {
            super(2, continuation);
            this.$callback = traeAuthCallback;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08751(this.$callback, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TraeAuthManager.TraeAuthCallback traeAuthCallback = this.$callback;
            if (traeAuthCallback == null) {
                return null;
            }
            traeAuthCallback.onFailure("-1", "");
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TraeAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.login.traeauth.TraeAuthManager$onLoginContinueByDeviceLimit$1$6", f = "TraeAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.login.traeauth.TraeAuthManager$onLoginContinueByDeviceLimit$1$6 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class C08776 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TraeAuthManager.TraeAuthCallback $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08776(TraeAuthManager.TraeAuthCallback traeAuthCallback, Continuation<? super C08776> continuation) {
            super(2, continuation);
            this.$callback = traeAuthCallback;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08776(this.$callback, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TraeAuthManager.TraeAuthCallback traeAuthCallback = this.$callback;
            if (traeAuthCallback == null) {
                return null;
            }
            traeAuthCallback.onSuccess();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TraeAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.login.traeauth.TraeAuthManager$onLoginContinueByDeviceLimit$1$8", f = "TraeAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.login.traeauth.TraeAuthManager$onLoginContinueByDeviceLimit$1$8 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class C08788 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TraeAuthManager.TraeAuthCallback $callback;

        /* renamed from: $e */
        final /* synthetic */ TraeAuthException f134$e;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08788(TraeAuthManager.TraeAuthCallback traeAuthCallback, TraeAuthException traeAuthException, Continuation<? super C08788> continuation) {
            super(2, continuation);
            this.$callback = traeAuthCallback;
            this.f134$e = traeAuthException;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08788(this.$callback, this.f134$e, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TraeAuthManager.TraeAuthCallback traeAuthCallback = this.$callback;
            if (traeAuthCallback == null) {
                return null;
            }
            String code = this.f134$e.getCode();
            String userFacingMessage = this.f134$e.getUserFacingMessage();
            if (userFacingMessage == null) {
                userFacingMessage = this.f134$e.getMessage();
            }
            traeAuthCallback.onFailure(code, userFacingMessage);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TraeAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.login.traeauth.TraeAuthManager$onLoginContinueByDeviceLimit$1$10", f = "TraeAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.login.traeauth.TraeAuthManager$onLoginContinueByDeviceLimit$1$10 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class C087610 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TraeAuthManager.TraeAuthCallback $callback;

        /* renamed from: $e */
        final /* synthetic */ Throwable f133$e;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C087610(TraeAuthManager.TraeAuthCallback traeAuthCallback, Throwable th, Continuation<? super C087610> continuation) {
            super(2, continuation);
            this.$callback = traeAuthCallback;
            this.f133$e = th;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C087610(this.$callback, this.f133$e, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TraeAuthManager.TraeAuthCallback traeAuthCallback = this.$callback;
            if (traeAuthCallback == null) {
                return null;
            }
            traeAuthCallback.onFailure(null, this.f133$e.getMessage());
            return Unit.INSTANCE;
        }
    }
}
