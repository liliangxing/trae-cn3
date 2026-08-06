package com.bytedance.trae.login.service;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.account.impl.BDAccountDelegateInner;
import com.bytedance.sdk.account.impl.BDAccountPlatformImpl;
import com.bytedance.sdk.account.platform.api.IDouYin2Service;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.base.Request;
import com.bytedance.sdk.account.platform.douyin.DouYinServiceIniter;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.api.IAccountCallback;
import com.bytedance.trae.login.api.IDouyinLoginService;
import com.bytedance.trae.login.api.LoginPlatform;
import com.ss.android.account.model2.BDAccountPlatformEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DouyinLoginServiceImpl.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0002J\"\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0016JP\u0010\u0014\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\n28\u0010\u0016\u001a4\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00070\u0017H\u0016JX\u0010\u001d\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\n28\u0010\u0016\u001a4\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00070\u0017H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;", "Lcom/bytedance/trae/login/api/IDouyinLoginService;", "<init>", "()V", "initialized", "", "ensureInitialized", "", "postToMain", "block", "Lkotlin/Function0;", "authorize", "activity", "Landroid/app/Activity;", "callback", "Lcom/bytedance/trae/login/api/IAccountCallback;", "businessScene", "", "isBound", "getDouyinNickname", "unbind", "onSuccess", "onFail", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "errorCode", "errorMsg", "bindToAccount", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DouyinLoginServiceImpl implements IDouyinLoginService {
    private static final String CALLER_LOCAL_ENTRY = "com.bytedance.trae.login.DouyinEntryActivity";
    private static final String CLIENT_KEY = "awu8u4pfmz7hocvm";
    private static final String EXT_FAILED_STEP = "failed_step";
    private static final String FAILED_STEP_TRAE_AUTH_AFTER_DOUYIN_AUTH = "trae_auth_after_douyin_auth";
    private static final String PLATFORM_ID = "23081";
    private volatile boolean initialized;
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    private final void ensureInitialized() {
        if (this.initialized) {
            return;
        }
        synchronized (this) {
            if (this.initialized) {
                return;
            }
            AuthorizeFramework.init(AppHost.Companion.getApplication(), new DouYinServiceIniter[]{new DouYinServiceIniter(CLIENT_KEY)});
            this.initialized = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postToMain(final Function0<Unit> block) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            block.invoke();
        } else {
            mainHandler.post(new Runnable() { // from class: com.bytedance.trae.login.service.DouyinLoginServiceImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    block.invoke();
                }
            });
        }
    }

    @Override // com.bytedance.trae.login.api.IDouyinLoginService
    public void authorize(Activity activity, final IAccountCallback callback, final String businessScene) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ensureInitialized();
        Request build = new Request.Builder().setScopes(SetsKt.hashSetOf(new String[]{"user_info"})).setState("dy_authorize").setCallerLocalEntry(CALLER_LOCAL_ENTRY).setAuthType(0).build();
        AuthorizeCallback douyinLoginServiceImpl$authorize$platformCallback$1 = new DouyinLoginServiceImpl$authorize$platformCallback$1(this, businessScene, callback, AppHost.Companion.getApplication().getApplicationContext());
        IDouYin2Service service = AuthorizeFramework.getService(IDouYin2Service.class);
        if (Intrinsics.areEqual(service != null ? Boolean.valueOf(service.authorize(activity, build, douyinLoginServiceImpl$authorize$platformCallback$1)) : null, true)) {
            return;
        }
        postToMain(new Function0() { // from class: com.bytedance.trae.login.service.DouyinLoginServiceImpl$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit authorize$lambda$2;
                authorize$lambda$2 = DouyinLoginServiceImpl.authorize$lambda$2(IAccountCallback.this, businessScene);
                return authorize$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit authorize$lambda$2(IAccountCallback iAccountCallback, String str) {
        IAccountCallback.DefaultImpls.onFailed$default(iAccountCallback, LoginPlatform.DOUYIN, -1, AppHost.Companion.getApplication().getString(C0820R.string.trae_douyin_authorize_start_failed), str, null, null, null, null, null, 480, null);
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.login.api.IDouyinLoginService
    public boolean isBound() {
        BDAccountPlatformEntity platformByName = BDAccountDelegateInner.instance().getPlatformByName("aweme_v2");
        return platformByName != null && platformByName.mLogin;
    }

    @Override // com.bytedance.trae.login.api.IDouyinLoginService
    public String getDouyinNickname() {
        String str;
        BDAccountPlatformEntity platformByName = BDAccountDelegateInner.instance().getPlatformByName("aweme_v2");
        if (platformByName == null || (str = platformByName.mNickname) == null) {
            return null;
        }
        if (str.length() > 0) {
            return str;
        }
        return null;
    }

    @Override // com.bytedance.trae.login.api.IDouyinLoginService
    public void unbind(Function0<Unit> onSuccess, Function2<? super Integer, ? super String, Unit> onFail) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFail, "onFail");
        BDAccountPlatformImpl.instance().unbindPlatform("aweme_v2", new DouyinLoginServiceImpl$unbind$1(this, onSuccess, onFail));
    }

    @Override // com.bytedance.trae.login.api.IDouyinLoginService
    public void bindToAccount(Activity activity, Function0<Unit> onSuccess, final Function2<? super Integer, ? super String, Unit> onFail) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFail, "onFail");
        ensureInitialized();
        Request build = new Request.Builder().setScopes(SetsKt.hashSetOf(new String[]{"user_info"})).setState("dy_bind").setCallerLocalEntry(CALLER_LOCAL_ENTRY).setAuthType(0).build();
        DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1 douyinLoginServiceImpl$bindToAccount$authorizeCallback$1 = new DouyinLoginServiceImpl$bindToAccount$authorizeCallback$1(new DouyinLoginServiceImpl$bindToAccount$bindCallback$1(this, onSuccess, onFail), this, onFail);
        IDouYin2Service service = AuthorizeFramework.getService(IDouYin2Service.class);
        if (Intrinsics.areEqual(service != null ? Boolean.valueOf(service.authorize(activity, build, douyinLoginServiceImpl$bindToAccount$authorizeCallback$1)) : null, true)) {
            return;
        }
        postToMain(new Function0() { // from class: com.bytedance.trae.login.service.DouyinLoginServiceImpl$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit bindToAccount$lambda$4;
                bindToAccount$lambda$4 = DouyinLoginServiceImpl.bindToAccount$lambda$4(onFail);
                return bindToAccount$lambda$4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindToAccount$lambda$4(Function2 function2) {
        function2.invoke(-1, AppHost.Companion.getApplication().getString(C0820R.string.trae_douyin_authorize_unavailable));
        return Unit.INSTANCE;
    }
}
