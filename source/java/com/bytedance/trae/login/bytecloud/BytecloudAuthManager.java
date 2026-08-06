package com.bytedance.trae.login.bytecloud;

import android.net.Uri;
import com.bytedance.networkstackapplib.TTNETScoreAPI;
import com.bytedance.platform.thread.Constants;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.login.traeauth.TraeAuthStorage;
import com.bytedance.trae.network.IntranetProber;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: BytecloudAuthManager.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001d\u001a\u00020\u0005J\b\u0010\u001e\u001a\u00020\u0005H\u0002J\u000e\u0010 \u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\tH\u0002J\u0016\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0005H\u0002J\u0006\u0010(\u001a\u00020\u0016J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020\u0016J\u000e\u0010,\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010!J\u0006\u0010-\u001a\u00020\u0005J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0086@¢\u0006\u0002\u00102J\u0006\u00103\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0016X\u0082D¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;", "", "<init>", "()V", "TAG", "", "STATE_EXPIRY_MS", "", "REGION_CN", "", "REGION_SG", "INTERNAL_CHECK_LIST", "", "CONSOLE_HOST_CN", "CONSOLE_HOST_OVERSEA", "ENABLE_SSO_HOSTS", "ODIN_USER_TYPE_LOGIN", "REDIRECT_SCHEME_CN", "REDIRECT_SCHEME_OVERSEA", "REDIRECT_PATH", "LOGIN_PLATFORM_BYTECLOUD", "cachedNetworkResult", "", "Ljava/lang/Boolean;", "lastCheckTimestamp", "MIN_RECHECK_INTERVAL_MS", "forceNextCheck", "networkCheckMutex", "Lkotlinx/coroutines/sync/Mutex;", "getRedirectUri", "getConsoleHost", "OVERSEA_SSO_ENABLED", "checkBytedanceNetwork", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "regionalIndex", "fetchEnableSsoFromHost", "host", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkSingleUrl", "checkUrl", "resetNetworkCache", "forceResetNetworkCache", "", "hasEverSeenIntranet", "checkIntranetRealTime", "buildLoginUrl", "handleCallback", "Lcom/bytedance/trae/login/bytecloud/CallbackResult;", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isBytecloudLogin", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BytecloudAuthManager {
    private static final String CONSOLE_HOST_CN = "https://solo-web.bytedance.net";
    private static final String CONSOLE_HOST_OVERSEA = "https://solo-web.tiktok-row.net";
    public static final String LOGIN_PLATFORM_BYTECLOUD = "bytecloud";
    private static final long MIN_RECHECK_INTERVAL_MS = 3000;
    public static final int ODIN_USER_TYPE_LOGIN = 12;
    private static final boolean OVERSEA_SSO_ENABLED = false;
    private static final String REDIRECT_PATH = "://oauth/bytecloud/callback";
    private static final String REDIRECT_SCHEME_CN = "traecn";
    private static final String REDIRECT_SCHEME_OVERSEA = "traei18n";
    private static final int REGION_CN = 0;
    private static final int REGION_SG = 1;
    private static final long STATE_EXPIRY_MS = 300000;
    private static final String TAG = "BytecloudAuth";
    private static volatile Boolean cachedNetworkResult;
    private static volatile boolean forceNextCheck;
    private static volatile long lastCheckTimestamp;
    public static final BytecloudAuthManager INSTANCE = new BytecloudAuthManager();
    private static final List<String> INTERNAL_CHECK_LIST = IntranetProber.INSTANCE.getPING_URLS();
    private static final List<String> ENABLE_SSO_HOSTS = CollectionsKt.listOf(new String[]{"https://copilot-cn.bytedance.net", "https://copilot-sg-og.byteintl.net"});
    private static final Mutex networkCheckMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    private BytecloudAuthManager() {
    }

    public final String getRedirectUri() {
        return (AppHost.Companion.isOversea() ? REDIRECT_SCHEME_OVERSEA : REDIRECT_SCHEME_CN).concat(REDIRECT_PATH);
    }

    private final String getConsoleHost() {
        return AppHost.Companion.isOversea() ? CONSOLE_HOST_OVERSEA : CONSOLE_HOST_CN;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00ce, code lost:
    
        if (r10 == false) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b0 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:12:0x002f, B:13:0x00ac, B:15:0x00b0, B:18:0x00bb, B:20:0x00c9, B:23:0x00d0), top: B:11:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c9 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:12:0x002f, B:13:0x00ac, B:15:0x00b0, B:18:0x00bb, B:20:0x00c9, B:23:0x00d0), top: B:11:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkBytedanceNetwork(Continuation<? super Boolean> continuation) {
        BytecloudAuthManager$checkBytedanceNetwork$1 bytecloudAuthManager$checkBytedanceNetwork$1;
        Object coroutine_suspended;
        int i;
        Mutex mutex;
        Boolean bool;
        Mutex mutex2;
        Throwable th;
        Object withTimeoutOrNull;
        Boolean bool2;
        boolean booleanValue;
        try {
            if (continuation instanceof BytecloudAuthManager$checkBytedanceNetwork$1) {
                bytecloudAuthManager$checkBytedanceNetwork$1 = (BytecloudAuthManager$checkBytedanceNetwork$1) continuation;
                if ((bytecloudAuthManager$checkBytedanceNetwork$1.label & Integer.MIN_VALUE) != 0) {
                    bytecloudAuthManager$checkBytedanceNetwork$1.label -= Integer.MIN_VALUE;
                    Object obj = bytecloudAuthManager$checkBytedanceNetwork$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = bytecloudAuthManager$checkBytedanceNetwork$1.label;
                    boolean z = true;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (AppHost.Companion.isOversea() && !OVERSEA_SSO_ENABLED) {
                            return Boxing.boxBoolean(false);
                        }
                        if (!forceNextCheck && (bool = cachedNetworkResult) != null) {
                            return Boxing.boxBoolean(bool.booleanValue());
                        }
                        mutex = networkCheckMutex;
                        bytecloudAuthManager$checkBytedanceNetwork$1.L$0 = mutex;
                        bytecloudAuthManager$checkBytedanceNetwork$1.label = 1;
                        if (mutex.lock((Object) null, bytecloudAuthManager$checkBytedanceNetwork$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i == 1) {
                        Mutex mutex3 = (Mutex) bytecloudAuthManager$checkBytedanceNetwork$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex3;
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        mutex2 = (Mutex) bytecloudAuthManager$checkBytedanceNetwork$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            Boolean bool3 = (Boolean) obj;
                            booleanValue = bool3 == null ? bool3.booleanValue() : false;
                            cachedNetworkResult = Boxing.boxBoolean(!booleanValue);
                            lastCheckTimestamp = System.currentTimeMillis();
                            if (booleanValue) {
                                TraeAuthStorage.INSTANCE.markIntranetSsoSeen();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            mutex2.unlock((Object) null);
                            throw th;
                        }
                    }
                    if (forceNextCheck && (bool2 = cachedNetworkResult) != null) {
                        if (bool2.booleanValue()) {
                            mutex2 = mutex;
                            Boolean boxBoolean = Boxing.boxBoolean(z);
                            mutex2.unlock((Object) null);
                            return boxBoolean;
                        }
                        mutex2 = mutex;
                        z = false;
                        Boolean boxBoolean2 = Boxing.boxBoolean(z);
                        mutex2.unlock((Object) null);
                        return boxBoolean2;
                    }
                    BytecloudAuthManager bytecloudAuthManager = INSTANCE;
                    forceNextCheck = false;
                    BytecloudAuthManager$checkBytedanceNetwork$3$result$1 bytecloudAuthManager$checkBytedanceNetwork$3$result$1 = new BytecloudAuthManager$checkBytedanceNetwork$3$result$1(bytecloudAuthManager.regionalIndex(), null);
                    bytecloudAuthManager$checkBytedanceNetwork$1.L$0 = mutex;
                    bytecloudAuthManager$checkBytedanceNetwork$1.label = 2;
                    withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(Constants.TASK_WAIT_THRESHOLD, bytecloudAuthManager$checkBytedanceNetwork$3$result$1, bytecloudAuthManager$checkBytedanceNetwork$1);
                    if (withTimeoutOrNull != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutex2 = mutex;
                    obj = withTimeoutOrNull;
                    Boolean bool32 = (Boolean) obj;
                    if (bool32 == null) {
                    }
                    cachedNetworkResult = Boxing.boxBoolean(!booleanValue);
                    lastCheckTimestamp = System.currentTimeMillis();
                    if (booleanValue) {
                    }
                }
            }
            if (forceNextCheck) {
            }
            BytecloudAuthManager bytecloudAuthManager2 = INSTANCE;
            forceNextCheck = false;
            BytecloudAuthManager$checkBytedanceNetwork$3$result$1 bytecloudAuthManager$checkBytedanceNetwork$3$result$12 = new BytecloudAuthManager$checkBytedanceNetwork$3$result$1(bytecloudAuthManager2.regionalIndex(), null);
            bytecloudAuthManager$checkBytedanceNetwork$1.L$0 = mutex;
            bytecloudAuthManager$checkBytedanceNetwork$1.label = 2;
            withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(Constants.TASK_WAIT_THRESHOLD, bytecloudAuthManager$checkBytedanceNetwork$3$result$12, bytecloudAuthManager$checkBytedanceNetwork$1);
            if (withTimeoutOrNull != coroutine_suspended) {
            }
        } catch (Throwable th3) {
            mutex2 = mutex;
            th = th3;
            mutex2.unlock((Object) null);
            throw th;
        }
        bytecloudAuthManager$checkBytedanceNetwork$1 = new BytecloudAuthManager$checkBytedanceNetwork$1(this, continuation);
        Object obj2 = bytecloudAuthManager$checkBytedanceNetwork$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bytecloudAuthManager$checkBytedanceNetwork$1.label;
        boolean z2 = true;
        if (i != 0) {
        }
    }

    private final int regionalIndex() {
        return AppHost.Companion.isOversea() ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(10:5|6|7|(1:(2:10|11)(2:35|36))(3:37|38|(1:40))|12|(7:17|(1:19)(1:28)|20|(1:22)(1:27)|23|24|25)|29|(1:31)(1:34)|32|33))|43|6|7|(0)(0)|12|(8:14|17|(0)(0)|20|(0)(0)|23|24|25)|29|(0)(0)|32|33) */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ef, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f0, code lost:
    
        com.bytedance.trae.utils.logger.FLogger.INSTANCE.mo428i(com.bytedance.trae.login.bytecloud.BytecloudAuthManager.TAG, "enable_sso 请求异常(" + r1 + "): " + r0.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009c A[Catch: Exception -> 0x00ef, TryCatch #0 {Exception -> 0x00ef, blocks: (B:11:0x003b, B:12:0x0085, B:14:0x0089, B:17:0x0094, B:19:0x009c, B:20:0x00a2, B:23:0x00b5, B:29:0x00c2, B:31:0x00d5, B:32:0x00df, B:38:0x004a), top: B:7:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d5 A[Catch: Exception -> 0x00ef, TryCatch #0 {Exception -> 0x00ef, blocks: (B:11:0x003b, B:12:0x0085, B:14:0x0089, B:17:0x0094, B:19:0x009c, B:20:0x00a2, B:23:0x00b5, B:29:0x00c2, B:31:0x00d5, B:32:0x00df, B:38:0x004a), top: B:7:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchEnableSsoFromHost(String str, Continuation<? super Boolean> continuation) {
        BytecloudAuthManager$fetchEnableSsoFromHost$1 bytecloudAuthManager$fetchEnableSsoFromHost$1;
        int i;
        boolean z;
        boolean z2;
        BizResponse bizResponse;
        boolean enableSso;
        String str2 = str;
        if (continuation instanceof BytecloudAuthManager$fetchEnableSsoFromHost$1) {
            bytecloudAuthManager$fetchEnableSsoFromHost$1 = (BytecloudAuthManager$fetchEnableSsoFromHost$1) continuation;
            if ((bytecloudAuthManager$fetchEnableSsoFromHost$1.label & Integer.MIN_VALUE) != 0) {
                bytecloudAuthManager$fetchEnableSsoFromHost$1.label -= Integer.MIN_VALUE;
                Object obj = bytecloudAuthManager$fetchEnableSsoFromHost$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = bytecloudAuthManager$fetchEnableSsoFromHost$1.label;
                z = true;
                z2 = false;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    String versionName = AppHost.Companion.getVersionName();
                    IEnableSsoApi iEnableSsoApi = (IEnableSsoApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "enable_sso", IEnableSsoApi.class, null, str2 + '/', null, true, 20, null);
                    bytecloudAuthManager$fetchEnableSsoFromHost$1.L$0 = str2;
                    bytecloudAuthManager$fetchEnableSsoFromHost$1.label = 1;
                    obj = iEnableSsoApi.checkEnableSso("android", versionName, bytecloudAuthManager$fetchEnableSsoFromHost$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str2 = (String) bytecloudAuthManager$fetchEnableSsoFromHost$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                bizResponse = (BizResponse) obj;
                if (bizResponse != null && bizResponse.getCode() == 200) {
                    EnableSsoData enableSsoData = (EnableSsoData) bizResponse.getData();
                    enableSso = enableSsoData == null ? enableSsoData.getEnableSso() : false;
                    FLogger fLogger = FLogger.INSTANCE;
                    StringBuilder append = new StringBuilder("enable_sso 结果(").append(str2).append("): ");
                    if (enableSso) {
                        z = false;
                    }
                    fLogger.mo428i(TAG, append.append(z).toString());
                    z2 = enableSso;
                    return Boxing.boxBoolean(z2);
                }
                FLogger.INSTANCE.mo428i(TAG, "enable_sso 业务异常(" + str2 + "): code=" + (bizResponse == null ? Boxing.boxLong(bizResponse.getCode()) : null));
                return Boxing.boxBoolean(false);
            }
        }
        bytecloudAuthManager$fetchEnableSsoFromHost$1 = new BytecloudAuthManager$fetchEnableSsoFromHost$1(this, continuation);
        Object obj2 = bytecloudAuthManager$fetchEnableSsoFromHost$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bytecloudAuthManager$fetchEnableSsoFromHost$1.label;
        z = true;
        z2 = false;
        if (i != 0) {
        }
        bizResponse = (BizResponse) obj2;
        if (bizResponse != null) {
            EnableSsoData enableSsoData2 = (EnableSsoData) bizResponse.getData();
            if (enableSsoData2 == null) {
            }
            FLogger fLogger2 = FLogger.INSTANCE;
            StringBuilder append2 = new StringBuilder("enable_sso 结果(").append(str2).append("): ");
            if (enableSso) {
            }
            fLogger2.mo428i(TAG, append2.append(z).toString());
            z2 = enableSso;
            return Boxing.boxBoolean(z2);
        }
        FLogger.INSTANCE.mo428i(TAG, "enable_sso 业务异常(" + str2 + "): code=" + (bizResponse == null ? Boxing.boxLong(bizResponse.getCode()) : null));
        return Boxing.boxBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkSingleUrl(String checkUrl) {
        return IntranetProber.INSTANCE.isReachable(checkUrl, TTNETScoreAPI.MAX_WAIT_TIME);
    }

    public final boolean resetNetworkCache() {
        if (System.currentTimeMillis() - lastCheckTimestamp < 3000) {
            return false;
        }
        cachedNetworkResult = null;
        return true;
    }

    public final void forceResetNetworkCache() {
        forceNextCheck = true;
        cachedNetworkResult = null;
    }

    public final boolean hasEverSeenIntranet() {
        return TraeAuthStorage.INSTANCE.hasIntranetSsoSeen();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkIntranetRealTime(Continuation<? super Boolean> continuation) {
        BytecloudAuthManager$checkIntranetRealTime$1 bytecloudAuthManager$checkIntranetRealTime$1;
        int i;
        if (continuation instanceof BytecloudAuthManager$checkIntranetRealTime$1) {
            bytecloudAuthManager$checkIntranetRealTime$1 = (BytecloudAuthManager$checkIntranetRealTime$1) continuation;
            if ((bytecloudAuthManager$checkIntranetRealTime$1.label & Integer.MIN_VALUE) != 0) {
                bytecloudAuthManager$checkIntranetRealTime$1.label -= Integer.MIN_VALUE;
                Object obj = bytecloudAuthManager$checkIntranetRealTime$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = bytecloudAuthManager$checkIntranetRealTime$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (AppHost.Companion.isOversea() && !OVERSEA_SSO_ENABLED) {
                        return Boxing.boxBoolean(false);
                    }
                    BytecloudAuthManager$checkIntranetRealTime$2 bytecloudAuthManager$checkIntranetRealTime$2 = new BytecloudAuthManager$checkIntranetRealTime$2(regionalIndex(), null);
                    bytecloudAuthManager$checkIntranetRealTime$1.label = 1;
                    obj = TimeoutKt.withTimeoutOrNull(Constants.TASK_RUN_THRESHOLD, bytecloudAuthManager$checkIntranetRealTime$2, bytecloudAuthManager$checkIntranetRealTime$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Boolean bool = (Boolean) obj;
                return Boxing.boxBoolean(bool != null ? bool.booleanValue() : false);
            }
        }
        bytecloudAuthManager$checkIntranetRealTime$1 = new BytecloudAuthManager$checkIntranetRealTime$1(this, continuation);
        Object obj2 = bytecloudAuthManager$checkIntranetRealTime$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bytecloudAuthManager$checkIntranetRealTime$1.label;
        if (i != 0) {
        }
        Boolean bool2 = (Boolean) obj2;
        return Boxing.boxBoolean(bool2 != null ? bool2.booleanValue() : false);
    }

    public final String buildLoginUrl() {
        String consoleHost = getConsoleHost();
        String redirectUri = getRedirectUri();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        TraeAuthStorage.INSTANCE.saveBytecloudOAuthState(uuid, System.currentTimeMillis());
        return consoleHost + "/authorization?auth_callback_url=" + redirectUri + "&product_name=TRAE&client_name=mobile&client_state=" + uuid;
    }

    public final Object handleCallback(Uri uri, Continuation<? super CallbackResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BytecloudAuthManager$handleCallback$2(uri, null), continuation);
    }

    public final boolean isBytecloudLogin() {
        return Intrinsics.areEqual(TraeAuthStorage.INSTANCE.getLoginPlatform(), "bytecloud");
    }
}
