package com.bytedance.trae.login.region;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.trae.login.bytecloud.BytecloudAuthManager;
import com.bytedance.trae.login.traeauth.TraeAuthConfig;
import com.bytedance.trae.login.traeauth.TraeAuthStorage;
import com.bytedance.trae.login.traeauth.TraeResponse;
import com.bytedance.trae.login.user.TraeUserInfoResult;
import com.bytedance.trae.login.user.UserInfoFetcher;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: UserRegionManager.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u000f\u001a\u00020\rH\u0002J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/login/region/UserRegionManager;", "", "<init>", "()V", "TAG", "", "coldStartDone", "", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "registerLifecycle", "", "refreshRegion", "performCheckLoginOnWarmLaunch", "applyRegionFromUserInfo", "userInfo", "Lcom/bytedance/trae/login/user/TraeUserInfoResult;", "doFetchUserRegion", "jwtToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performCheckLoginSync", "doPerformCheckLogin", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class UserRegionManager {
    public static final UserRegionManager INSTANCE = new UserRegionManager();
    private static final String TAG = "UserRegionManager";
    private static volatile boolean coldStartDone;
    private static final CoroutineExceptionHandler exceptionHandler;
    private static final CoroutineScope scope;

    private UserRegionManager() {
    }

    public final void registerLifecycle() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.trae.login.region.UserRegionManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                UserRegionManager.registerLifecycle$lambda$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerLifecycle$lambda$1() {
        ProcessLifecycleOwner.Companion.get().getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: com.bytedance.trae.login.region.UserRegionManager$registerLifecycle$1$1
            public void onStart(LifecycleOwner owner) {
                boolean z;
                Intrinsics.checkNotNullParameter(owner, "owner");
                z = UserRegionManager.coldStartDone;
                if (!z) {
                    UserRegionManager userRegionManager = UserRegionManager.INSTANCE;
                    UserRegionManager.coldStartDone = true;
                } else {
                    FLogger.INSTANCE.mo428i("UserRegionManager", "ProcessLifecycleOwner onStart: warm launch, performCheckLogin");
                    UserRegionManager.INSTANCE.performCheckLoginOnWarmLaunch();
                }
            }
        });
    }

    public final void refreshRegion() {
        String jwtToken = TraeAuthStorage.INSTANCE.getJwtToken();
        if (jwtToken.length() == 0) {
            FLogger.INSTANCE.mo430w(TAG, "refreshRegion: not logged in, skip");
        } else {
            BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new UserRegionManager$refreshRegion$1(jwtToken, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performCheckLoginOnWarmLaunch() {
        String jwtToken = TraeAuthStorage.INSTANCE.getJwtToken();
        if (jwtToken.length() == 0) {
            return;
        }
        BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new UserRegionManager$performCheckLoginOnWarmLaunch$1(jwtToken, null), 3, (Object) null);
    }

    public final void applyRegionFromUserInfo(TraeUserInfoResult userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        String storeCountry = userInfo.getStoreCountry();
        String str = storeCountry;
        if (!(str == null || str.length() == 0)) {
            String regionForStoreCountry = UserRegionMapper.INSTANCE.regionForStoreCountry(storeCountry);
            TraeAuthStorage.INSTANCE.saveUserRegion(regionForStoreCountry);
            TraeAuthStorage.INSTANCE.saveUploadRegion(regionForStoreCountry);
            FLogger.INSTANCE.mo428i(TAG, "applyRegionFromUserInfo: storeCountry=" + storeCountry + ", region=" + regionForStoreCountry);
            if (Intrinsics.areEqual(userInfo.getMigrateToSG(), true)) {
                TraeAuthStorage.INSTANCE.saveUploadRegion("SG");
                FLogger.INSTANCE.mo428i(TAG, "applyRegionFromUserInfo: MigrateToSG=true, uploadRegion overridden to SG");
                return;
            }
            return;
        }
        FLogger.INSTANCE.mo430w(TAG, "applyRegionFromUserInfo: storeCountry is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(8:5|6|7|(1:(2:10|11)(2:23|24))(2:25|(2:27|28)(2:29|(1:31)(1:32)))|12|(3:17|18|19)|21|22))|35|6|7|(0)(0)|12|(4:14|17|18|19)|21|22) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006d, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006e, code lost:
    
        com.bytedance.trae.utils.logger.FLogger.INSTANCE.mo426e(com.bytedance.trae.login.region.UserRegionManager.TAG, "doFetchUserRegion exception: " + r6.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object doFetchUserRegion(String str, Continuation<? super Unit> continuation) {
        UserRegionManager$doFetchUserRegion$1 userRegionManager$doFetchUserRegion$1;
        int i;
        UserRegionManager userRegionManager;
        UserInfoFetcher.UserInfoResponse userInfoResponse;
        TraeUserInfoResult result;
        if (continuation instanceof UserRegionManager$doFetchUserRegion$1) {
            userRegionManager$doFetchUserRegion$1 = (UserRegionManager$doFetchUserRegion$1) continuation;
            if ((userRegionManager$doFetchUserRegion$1.label & Integer.MIN_VALUE) != 0) {
                userRegionManager$doFetchUserRegion$1.label -= Integer.MIN_VALUE;
                Object obj = userRegionManager$doFetchUserRegion$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = userRegionManager$doFetchUserRegion$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (BytecloudAuthManager.INSTANCE.isBytecloudLogin()) {
                        FLogger.INSTANCE.mo428i(TAG, "doFetchUserRegion: bytecloud login, skip");
                        return Unit.INSTANCE;
                    }
                    UserInfoFetcher userInfoFetcher = UserInfoFetcher.INSTANCE;
                    userRegionManager$doFetchUserRegion$1.L$0 = this;
                    userRegionManager$doFetchUserRegion$1.label = 1;
                    obj = userInfoFetcher.doFetch(str, userRegionManager$doFetchUserRegion$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userRegionManager = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    userRegionManager = (UserRegionManager) userRegionManager$doFetchUserRegion$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                userInfoResponse = (UserInfoFetcher.UserInfoResponse) obj;
                if (userInfoResponse != null && (result = userInfoResponse.getResult()) != null) {
                    userRegionManager.applyRegionFromUserInfo(result);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        }
        userRegionManager$doFetchUserRegion$1 = new UserRegionManager$doFetchUserRegion$1(this, continuation);
        Object obj2 = userRegionManager$doFetchUserRegion$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = userRegionManager$doFetchUserRegion$1.label;
        if (i != 0) {
        }
        userInfoResponse = (UserInfoFetcher.UserInfoResponse) obj2;
        if (userInfoResponse != null) {
            userRegionManager.applyRegionFromUserInfo(result);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final Object performCheckLoginSync(String str, Continuation<? super Unit> continuation) {
        Object doPerformCheckLogin = doPerformCheckLogin(str, continuation);
        return doPerformCheckLogin == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? doPerformCheckLogin : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(8:5|6|7|(1:(2:10|11)(2:33|34))(3:35|36|(1:38)(1:39))|12|(3:17|(1:19)(1:30)|(2:21|22)(4:24|(1:26)(1:29)|27|28))|31|32))|42|6|7|(0)(0)|12|(4:14|17|(0)(0)|(0)(0))|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x010a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x010b, code lost:
    
        com.bytedance.trae.utils.logger.FLogger.INSTANCE.mo426e(com.bytedance.trae.login.region.UserRegionManager.TAG, "doPerformCheckLogin exception: " + r0.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00af A[Catch: Exception -> 0x010a, TryCatch #0 {Exception -> 0x010a, blocks: (B:11:0x0032, B:12:0x0081, B:14:0x0085, B:17:0x008e, B:19:0x00af, B:21:0x00b9, B:24:0x00c3, B:26:0x00d1, B:29:0x00e0, B:31:0x00fe, B:36:0x0041), top: B:7:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b9 A[Catch: Exception -> 0x010a, TryCatch #0 {Exception -> 0x010a, blocks: (B:11:0x0032, B:12:0x0081, B:14:0x0085, B:17:0x008e, B:19:0x00af, B:21:0x00b9, B:24:0x00c3, B:26:0x00d1, B:29:0x00e0, B:31:0x00fe, B:36:0x0041), top: B:7:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c3 A[Catch: Exception -> 0x010a, TryCatch #0 {Exception -> 0x010a, blocks: (B:11:0x0032, B:12:0x0081, B:14:0x0085, B:17:0x008e, B:19:0x00af, B:21:0x00b9, B:24:0x00c3, B:26:0x00d1, B:29:0x00e0, B:31:0x00fe, B:36:0x0041), top: B:7:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object doPerformCheckLogin(String str, Continuation<? super Unit> continuation) {
        UserRegionManager$doPerformCheckLogin$1 userRegionManager$doPerformCheckLogin$1;
        int i;
        UserRegionManager userRegionManager;
        SsResponse ssResponse;
        String str2;
        CheckLoginResult checkLoginResult;
        if (continuation instanceof UserRegionManager$doPerformCheckLogin$1) {
            userRegionManager$doPerformCheckLogin$1 = (UserRegionManager$doPerformCheckLogin$1) continuation;
            if ((userRegionManager$doPerformCheckLogin$1.label & Integer.MIN_VALUE) != 0) {
                userRegionManager$doPerformCheckLogin$1.label -= Integer.MIN_VALUE;
                Object obj = userRegionManager$doPerformCheckLogin$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = userRegionManager$doPerformCheckLogin$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    String baseUrl = TraeAuthConfig.INSTANCE.getBaseUrl();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("x-ide-token", str);
                    CheckLoginApi checkLoginApi = (CheckLoginApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "trae_region", CheckLoginApi.class, null, baseUrl, linkedHashMap, false, 36, null);
                    CheckLoginRequest checkLoginRequest = new CheckLoginRequest(null, false, null, 7, null);
                    userRegionManager$doPerformCheckLogin$1.L$0 = this;
                    userRegionManager$doPerformCheckLogin$1.label = 1;
                    obj = checkLoginApi.checkLogin(checkLoginRequest, userRegionManager$doPerformCheckLogin$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    userRegionManager = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    userRegionManager = (UserRegionManager) userRegionManager$doPerformCheckLogin$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                ssResponse = (SsResponse) obj;
                if (ssResponse != null && (str2 = (String) ssResponse.body()) != null) {
                    TraeResponse traeResponse = (TraeResponse) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(str2, TypeToken.getParameterized(TraeResponse.class, new Type[]{CheckLoginResult.class}).getType());
                    checkLoginResult = traeResponse == null ? (CheckLoginResult) traeResponse.getResult() : null;
                    if (checkLoginResult != null) {
                        FLogger.INSTANCE.mo430w(TAG, "doPerformCheckLogin: result is null");
                        return Unit.INSTANCE;
                    }
                    if (Intrinsics.areEqual(checkLoginResult.getMigrateToSG(), Boxing.boxBoolean(true))) {
                        TraeAuthStorage.INSTANCE.saveUploadRegion("SG");
                        FLogger.INSTANCE.mo428i(TAG, "doPerformCheckLogin: MigrateToSG=true, uploadRegion set to SG");
                    } else {
                        String userRegion = TraeAuthStorage.INSTANCE.getUserRegion();
                        TraeAuthStorage.INSTANCE.saveUploadRegion(userRegion);
                        FLogger.INSTANCE.mo428i(TAG, "doPerformCheckLogin: MigrateToSG=false, uploadRegion=" + userRegion);
                    }
                    return Unit.INSTANCE;
                }
                UserRegionManager userRegionManager2 = userRegionManager;
                FLogger.INSTANCE.mo430w(TAG, "doPerformCheckLogin: response body is null");
                return Unit.INSTANCE;
            }
        }
        userRegionManager$doPerformCheckLogin$1 = new UserRegionManager$doPerformCheckLogin$1(this, continuation);
        Object obj2 = userRegionManager$doPerformCheckLogin$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = userRegionManager$doPerformCheckLogin$1.label;
        if (i != 0) {
        }
        ssResponse = (SsResponse) obj2;
        if (ssResponse != null) {
            TraeResponse traeResponse2 = (TraeResponse) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(str2, TypeToken.getParameterized(TraeResponse.class, new Type[]{CheckLoginResult.class}).getType());
            if (traeResponse2 == null) {
            }
            if (checkLoginResult != null) {
            }
        }
        UserRegionManager userRegionManager22 = userRegionManager;
        FLogger.INSTANCE.mo430w(TAG, "doPerformCheckLogin: response body is null");
        return Unit.INSTANCE;
    }

    static {
        CoroutineContext coroutineContext = (CoroutineExceptionHandler) new UserRegionManager$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
        exceptionHandler = coroutineContext;
        scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()).plus(coroutineContext));
    }
}
