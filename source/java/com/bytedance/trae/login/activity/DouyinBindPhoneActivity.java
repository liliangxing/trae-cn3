package com.bytedance.trae.login.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.push.interfaze.IMessageCallbackService;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.databinding.TraeActivityDouyinBindPhoneBinding;
import com.bytedance.trae.login.fragment.DouyinBindPhoneInputFragment;
import com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment;
import com.bytedance.trae.login.tracker.LoginTracker;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: DouyinBindPhoneActivity.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0002J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0007J\b\u0010\u0013\u001a\u00020\fH\u0002J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\tJ\u0006\u0010\u0016\u001a\u00020\fJ\u0006\u0010\u0017\u001a\u00020\fJ\b\u0010\u0018\u001a\u00020\fH\u0014J\b\u0010\u0019\u001a\u00020\fH\u0014J\b\u0010\u001a\u001a\u00020\fH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "binding", "Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;", "profileKey", "", "isBindSuccess", "", "isBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupViews", "showPhoneInput", "showVerifyCodeInput", "phoneNumber", "handleBackPressed", "setBindLoading", IMessageCallbackService.EVENT_TYPE_SHOW, "popToPhoneInput", "navigateToMainActivity", "onPause", "onResume", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DouyinBindPhoneActivity extends TraeCommonAppCompatActivity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_PROFILE_KEY = "extra_profile_key";
    private static final String MAIN_ACTIVITY_CLASS = "com.bytedance.trae.home.MainActivity";
    private static final String TAG_PHONE_INPUT = "tag_douyin_bind_phone_input";
    private static final String TAG_VERIFY_CODE = "tag_douyin_bind_verify_code";
    private TraeActivityDouyinBindPhoneBinding binding;
    private boolean isBackPressed;
    private boolean isBindSuccess;
    private String profileKey;

    /* renamed from: com_bytedance_trae_login_activity_DouyinBindPhoneActivity__onStop$___twin___ */
    public void m400xba2b329e() {
        super.onStop();
    }

    protected void onStop() {
        m399xdf856a1d(this);
    }

    /* compiled from: DouyinBindPhoneActivity.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity$Companion;", "", "<init>", "()V", "EXTRA_PROFILE_KEY", "", "TAG_PHONE_INPUT", "TAG_VERIFY_CODE", "MAIN_ACTIVITY_CLASS", TraeAuthManager.STAGE_START, "", "context", "Landroid/content/Context;", "profileKey", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context, String profileKey) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(profileKey, "profileKey");
            Intent intent = new Intent(context, (Class<?>) DouyinBindPhoneActivity.class);
            intent.putExtra(DouyinBindPhoneActivity.EXTRA_PROFILE_KEY, profileKey);
            context.startActivity(intent);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TraeActivityDouyinBindPhoneBinding inflate = TraeActivityDouyinBindPhoneBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());
        String stringExtra = getIntent().getStringExtra(EXTRA_PROFILE_KEY);
        if (stringExtra == null) {
            finish();
            return;
        }
        this.profileKey = stringExtra;
        setupViews();
        if (savedInstanceState == null) {
            LoginTracker.INSTANCE.trackDouyinBindPhonePageView();
            showPhoneInput();
        }
    }

    private final void setupViews() {
        TraeActivityDouyinBindPhoneBinding traeActivityDouyinBindPhoneBinding = this.binding;
        if (traeActivityDouyinBindPhoneBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityDouyinBindPhoneBinding = null;
        }
        traeActivityDouyinBindPhoneBinding.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.activity.DouyinBindPhoneActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DouyinBindPhoneActivity.this.handleBackPressed();
            }
        });
        getOnBackPressedDispatcher().addCallback((LifecycleOwner) this, new OnBackPressedCallback() { // from class: com.bytedance.trae.login.activity.DouyinBindPhoneActivity$setupViews$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            public void handleOnBackPressed() {
                DouyinBindPhoneActivity.this.handleBackPressed();
            }
        });
    }

    private final void showPhoneInput() {
        getSupportFragmentManager().beginTransaction().replace(C0820R.id.fragment_container, DouyinBindPhoneInputFragment.INSTANCE.newInstance(), TAG_PHONE_INPUT).commitAllowingStateLoss();
    }

    public final void showVerifyCodeInput(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_DOUYIN_BIND_VERIFY_CODE_SHOWN, "douyin", null, null, null, null, null, null, null, null, null, 2044, null);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        int i = C0820R.id.fragment_container;
        DouyinBindVerifyCodeFragment.Companion companion = DouyinBindVerifyCodeFragment.INSTANCE;
        String str = this.profileKey;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileKey");
            str = null;
        }
        beginTransaction.replace(i, companion.newInstance(phoneNumber, str), TAG_VERIFY_CODE).addToBackStack(TAG_VERIFY_CODE).commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleBackPressed() {
        TraeActivityDouyinBindPhoneBinding traeActivityDouyinBindPhoneBinding = this.binding;
        if (traeActivityDouyinBindPhoneBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityDouyinBindPhoneBinding = null;
        }
        if (traeActivityDouyinBindPhoneBinding.loadingOverlay.getVisibility() == 0) {
            return;
        }
        this.isBackPressed = true;
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_DOUYIN_BIND_VERIFY_CODE_EXIT, "douyin", null, "back_pressed", null, null, null, null, null, null, null, 2036, null);
            getSupportFragmentManager().popBackStack();
            this.isBackPressed = false;
        } else {
            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_DOUYIN_BIND_PHONE_EXIT, "douyin", null, "back_pressed", null, null, null, null, null, null, null, 2036, null);
            finish();
        }
    }

    public final void setBindLoading(boolean show) {
        TraeActivityDouyinBindPhoneBinding traeActivityDouyinBindPhoneBinding = this.binding;
        if (traeActivityDouyinBindPhoneBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityDouyinBindPhoneBinding = null;
        }
        traeActivityDouyinBindPhoneBinding.loadingOverlay.setVisibility(show ? 0 : 8);
    }

    public final void popToPhoneInput() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void navigateToMainActivity() {
        this.isBindSuccess = true;
        Intent intent = new Intent();
        intent.setClassName((Context) this, MAIN_ACTIVITY_CLASS);
        intent.setFlags(268468224);
        intent.putExtra("from_login_success", true);
        startActivity(intent);
        finish();
    }

    protected void onPause() {
        super.onPause();
        if (this.isBindSuccess || this.isBackPressed) {
            return;
        }
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, getSupportFragmentManager().getBackStackEntryCount() > 0 ? TraeAuthManager.STAGE_DOUYIN_BIND_VERIFY_CODE_PAUSE : TraeAuthManager.STAGE_DOUYIN_BIND_PHONE_PAUSE, "douyin", null, "pause_background", null, null, null, null, null, null, null, 2036, null);
    }

    protected void onResume() {
        super.onResume();
        this.isBackPressed = false;
    }

    protected void onDestroy() {
        if (!this.isBindSuccess && !this.isBackPressed && !isChangingConfigurations()) {
            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, getSupportFragmentManager().getBackStackEntryCount() > 0 ? TraeAuthManager.STAGE_DOUYIN_BIND_VERIFY_CODE_DESTROY : TraeAuthManager.STAGE_DOUYIN_BIND_PHONE_DESTROY, "douyin", null, "destroyed", null, null, null, null, null, null, null, 2036, null);
        }
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_login_activity_DouyinBindPhoneActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m399xdf856a1d(DouyinBindPhoneActivity douyinBindPhoneActivity) {
        douyinBindPhoneActivity.m400xba2b329e();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) douyinBindPhoneActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
