package com.bytedance.trae.home;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.CliListRepository;
import com.bytedance.trae.conversation.ConversationActivity;
import com.bytedance.trae.conversation.ConversationUtils;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.conversation.voice.VoiceChatConfigWarmup;
import com.bytedance.trae.home.onboarding.OnboardingFragment;
import com.bytedance.trae.home.privacy.InitPeriodWrapper;
import com.bytedance.trae.home.privacy.PrivacyAgreeActivity;
import com.bytedance.trae.home.privacy.PrivacyCache;
import com.bytedance.trae.home.privacy.PrivacyDialogHelper;
import com.bytedance.trae.home.privacy.PrivacyManager;
import com.bytedance.trae.home.solo.task.TaskFragment;
import com.bytedance.trae.home.solo.task.TaskViewModel;
import com.bytedance.trae.home.zlink.PendingDeepLinkRoute;
import com.bytedance.trae.home.zlink.PendingDeepLinkRoutePolicy;
import com.bytedance.trae.home.zlink.ZlinkInitializer;
import com.bytedance.trae.home.zlink.ZlinkLinkEntryActivity;
import com.bytedance.trae.im.service.Conversation;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.push.api.PushDeeplinkPendingStore;
import com.bytedance.trae.update.AppUpdateChecker;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0013H\u0002J\b\u0010\u001e\u001a\u00020\u0013H\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0014J\b\u0010 \u001a\u00020\u0013H\u0002J\b\u0010!\u001a\u00020\u0013H\u0002J\b\u0010\"\u001a\u00020\u0013H\u0002J\b\u0010#\u001a\u00020\u0013H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J\b\u0010%\u001a\u00020\u0013H\u0002J\b\u0010&\u001a\u00020\u0013H\u0002J\b\u0010'\u001a\u00020\u0013H\u0002J\b\u0010(\u001a\u00020\u0013H\u0002J\n\u0010)\u001a\u0004\u0018\u00010*H\u0002J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020*H\u0002J\b\u00100\u001a\u00020\u0013H\u0002J\b\u00101\u001a\u00020\u0013H\u0002J\b\u00102\u001a\u00020\u0013H\u0002J\b\u00103\u001a\u00020\u0013H\u0002J\b\u00104\u001a\u00020\u0013H\u0014J\b\u00105\u001a\u00020\u0015H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/bytedance/trae/home/MainActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "alreadyInit", "", "onboardingShowing", "isFirstEnterMainPage", "splashView", "Landroid/view/View;", "handler", "Landroid/os/Handler;", "dismissSplashRunnable", "Ljava/lang/Runnable;", "isSplashDismissed", "splashShowTime", "", "pendingNavigate", "Lkotlin/Function0;", "", "onboardingContainerId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "initDebugFloatingButton", "addSplashView", "rootLayout", "Landroid/widget/FrameLayout;", "dismissSplashAndNavigate", "dismissSplash", "onResume", "showOnboardingOrMainPage", "showOnboarding", "dismissOnboarding", "enterMainPage", "doResumeInternal", "fetchStarbucksIfLoggedIn", "tryInitWhenOnResume", "observeContentReady", "navigateToLoginActivity", "getDeepLinkConversationId", "", "handlePendingDeepLink", "uri", "Landroid/net/Uri;", "navigateToConversationById", "conversationId", "navigateToConversationActivity", "navigateToMainTabFragment", "onPrivacyAgreed", "onPrivacyDisagreed", "onDestroy", "getDecorViewBackgroundColor", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MainActivity extends TraeCommonAppCompatActivity {
    public static final String EXTRA_FROM_LANGUAGE_SWITCH = "from_language_switch";
    private static final long SPLASH_AUTO_DISMISS_MS = 1500;
    private static final long SPLASH_MIN_SHOW_MS = 800;
    private static final String TAG = "MainActivity";
    private static final String TAG_MAIN_TAB_FRAGMENT = "tag_main_tab_fragment";
    private static final String TAG_ONBOARDING_FRAGMENT = "tag_onboarding_fragment";
    private static Uri pendingDeepLinkUri;
    private boolean alreadyInit;
    private boolean isSplashDismissed;
    private boolean onboardingShowing;
    private Function0<Unit> pendingNavigate;
    private long splashShowTime;
    private View splashView;
    public static final int $stable = 8;
    private static boolean isColdStart = true;
    private boolean isFirstEnterMainPage = true;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable dismissSplashRunnable = new Runnable() { // from class: com.bytedance.trae.home.MainActivity$$ExternalSyntheticLambda3
        @Override // java.lang.Runnable
        public final void run() {
            MainActivity.this.dismissSplashAndNavigate();
        }
    };
    private int onboardingContainerId = -1;

    public void com_bytedance_trae_home_MainActivity__onStop$___twin___() {
        super.onStop();
    }

    protected void onStop() {
        m869x8bb741d(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onCreate(Bundle savedInstanceState) {
        if (AppHost.INSTANCE.isPreinstallApp() && !PrivacyManager.INSTANCE.checkAgreed()) {
            super.onCreate(savedInstanceState);
            Log.i(TAG, "preinstall app, start PrivacyAgreeActivity in :privacy process");
            Context context = (Context) this;
            PrivacyManager.INSTANCE.registerReceiver(context);
            Intent intent = new Intent(context, (Class<?>) PrivacyAgreeActivity.class);
            intent.setFlags(268435456);
            startActivity(intent);
            super.finish();
            return;
        }
        Intent intent2 = getIntent();
        String stringExtra = intent2 != null ? intent2.getStringExtra(ZlinkLinkEntryActivity.EXTRA_PENDING_URI) : null;
        String str = stringExtra;
        if (!(str == null || str.length() == 0)) {
            pendingDeepLinkUri = Uri.parse(stringExtra);
            Log.i(TAG, "Received pending URI from extra: " + stringExtra);
        }
        InitPeriodWrapper.INSTANCE.beforeSuperCreate((Activity) this);
        super.onCreate(savedInstanceState);
        InitPeriodWrapper.INSTANCE.afterSuperCreateStart();
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "<get-onBackPressedDispatcher>(...)");
        OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, (LifecycleOwner) this, false, new Function1() { // from class: com.bytedance.trae.home.MainActivity$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit onCreate$lambda$1;
                onCreate$lambda$1 = MainActivity.onCreate$lambda$1(MainActivity.this, (OnBackPressedCallback) obj);
                return onCreate$lambda$1;
            }
        }, 2, (Object) null);
        if (!PrivacyManager.INSTANCE.checkAgreed()) {
            Log.i(TAG, "privacy not agreed, show privacy dialog");
            PrivacyCache.INSTANCE.savePrivacyWindowShow((Context) this);
            PrivacyDialogHelper.INSTANCE.showDialog((ComponentActivity) this, new Function0() { // from class: com.bytedance.trae.home.MainActivity$$ExternalSyntheticLambda6
                public final Object invoke() {
                    Unit onCreate$lambda$2;
                    onCreate$lambda$2 = MainActivity.onCreate$lambda$2(MainActivity.this);
                    return onCreate$lambda$2;
                }
            }, new Function0() { // from class: com.bytedance.trae.home.MainActivity$$ExternalSyntheticLambda7
                public final Object invoke() {
                    Unit onCreate$lambda$3;
                    onCreate$lambda$3 = MainActivity.onCreate$lambda$3(MainActivity.this);
                    return onCreate$lambda$3;
                }
            });
        }
        Context context2 = (Context) this;
        FrameLayout frameLayout = new FrameLayout(context2);
        FrameLayout frameLayout2 = new FrameLayout(context2);
        frameLayout2.setId(C0820R.id.fragment_container);
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2);
        FrameLayout frameLayout3 = new FrameLayout(context2);
        frameLayout3.setId(View.generateViewId());
        frameLayout3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout3.setVisibility(8);
        this.onboardingContainerId = frameLayout3.getId();
        frameLayout.addView(frameLayout3);
        setContentView(frameLayout);
        getWindow().setBackgroundDrawableResource(C0591R.color.trae_bg_bg_base_secondary);
        Function0<Unit> function0 = this.pendingNavigate;
        this.pendingNavigate = null;
        if (function0 != null) {
            function0.invoke();
        }
        String str2 = isColdStart ? "cold_start" : "background_resume";
        IApplog.Companion companion = IApplog.INSTANCE;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("enter_from", str2);
        Unit unit = Unit.INSTANCE;
        companion.reportEvent("splash_page_view", jSONObject);
        isColdStart = false;
        InitPeriodWrapper.INSTANCE.afterSuperCreateEnd();
        initDebugFloatingButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1(MainActivity mainActivity, OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "$this$addCallback");
        if (!mainActivity.onboardingShowing) {
            onBackPressedCallback.setEnabled(false);
            mainActivity.getOnBackPressedDispatcher().onBackPressed();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$2(MainActivity mainActivity) {
        mainActivity.onPrivacyAgreed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$3(MainActivity mainActivity) {
        mainActivity.onPrivacyDisagreed();
        return Unit.INSTANCE;
    }

    private final void initDebugFloatingButton() {
        if (AppHost.INSTANCE.isDebug()) {
            try {
                Class.forName("com.bytedance.trae.home.solo.setting.DebugFloatingButtonManager").getMethod("init", Application.class).invoke(null, getApplication());
            } catch (ClassNotFoundException unused) {
            } catch (Exception e) {
                Log.w(TAG, "initDebugFloatingButton failed", e);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void addSplashView(FrameLayout rootLayout) {
        this.splashShowTime = SystemClock.elapsedRealtime();
        View inflate = LayoutInflater.from((Context) this).inflate(C0820R.layout.view_splash, (ViewGroup) rootLayout, false);
        this.splashView = inflate;
        rootLayout.addView(inflate, new ViewGroup.LayoutParams(-1, -1));
        View view = this.splashView;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.MainActivity$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    MainActivity.this.dismissSplashAndNavigate();
                }
            });
        }
        this.handler.postDelayed(this.dismissSplashRunnable, SPLASH_AUTO_DISMISS_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissSplashAndNavigate() {
        if (this.isSplashDismissed) {
            return;
        }
        this.isSplashDismissed = true;
        this.handler.removeCallbacks(this.dismissSplashRunnable);
        final Function0<Unit> function0 = this.pendingNavigate;
        this.pendingNavigate = null;
        final View view = this.splashView;
        if (view != null) {
            view.animate().alpha(0.0f).setDuration(200L).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.trae.home.MainActivity$dismissSplashAndNavigate$1$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    ViewParent parent = view.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup != null) {
                        viewGroup.removeView(view);
                    }
                    this.splashView = null;
                    Function0<Unit> function02 = function0;
                    if (function02 != null) {
                        function02.invoke();
                    }
                }
            }).start();
        } else if (function0 != null) {
            function0.invoke();
        }
    }

    private final void dismissSplash() {
        this.pendingNavigate = null;
        dismissSplashAndNavigate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onResume() {
        AccountInfo accountInfo;
        InitPeriodWrapper.INSTANCE.beforeSuperResume();
        super.onResume();
        InitPeriodWrapper.INSTANCE.afterSuperResume();
        try {
            ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
            if (iLoginService != null && (accountInfo = iLoginService.getAccountInfo()) != null) {
                accountInfo.getUserId();
            }
            if (iLoginService != null && iLoginService.getAccountInfo().isLogin()) {
                VoiceChatConfigWarmup.INSTANCE.warmup();
            }
        } catch (Throwable unused) {
        }
        boolean checkAgreed = PrivacyManager.INSTANCE.checkAgreed();
        Log.i(TAG, "onResume: privacyAgreed=" + checkAgreed);
        if (checkAgreed) {
            showOnboardingOrMainPage();
        }
    }

    private final void showOnboardingOrMainPage() {
        if (this.onboardingShowing) {
            return;
        }
        if (!OnboardingFragment.INSTANCE.hasShown()) {
            showOnboarding();
        } else {
            enterMainPage();
        }
    }

    private final void showOnboarding() {
        if (this.onboardingShowing) {
            return;
        }
        this.onboardingShowing = true;
        dismissSplash();
        View findViewById = findViewById(this.onboardingContainerId);
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
        OnboardingFragment onboardingFragment = new OnboardingFragment();
        onboardingFragment.setOnFinished(new Function0() { // from class: com.bytedance.trae.home.MainActivity$$ExternalSyntheticLambda4
            public final Object invoke() {
                Unit showOnboarding$lambda$10;
                showOnboarding$lambda$10 = MainActivity.showOnboarding$lambda$10(MainActivity.this);
                return showOnboarding$lambda$10;
            }
        });
        getSupportFragmentManager().beginTransaction().replace(this.onboardingContainerId, onboardingFragment, TAG_ONBOARDING_FRAGMENT).commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showOnboarding$lambda$10(MainActivity mainActivity) {
        mainActivity.dismissOnboarding();
        return Unit.INSTANCE;
    }

    private final void dismissOnboarding() {
        View view;
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator listener;
        this.onboardingShowing = false;
        final Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(TAG_ONBOARDING_FRAGMENT);
        if (findFragmentByTag != null && (view = findFragmentByTag.getView()) != null && (animate = view.animate()) != null && (alpha = animate.alpha(0.0f)) != null && (duration = alpha.setDuration(300L)) != null && (listener = duration.setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.trae.home.MainActivity$dismissOnboarding$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                int i;
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (MainActivity.this.isFinishing() || MainActivity.this.isDestroyed()) {
                    return;
                }
                MainActivity.this.getSupportFragmentManager().beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
                MainActivity mainActivity = MainActivity.this;
                i = mainActivity.onboardingContainerId;
                View findViewById = mainActivity.findViewById(i);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
            }
        })) != null) {
            listener.start();
        }
        enterMainPage();
    }

    private final void enterMainPage() {
        doResumeInternal();
        if (this.isFirstEnterMainPage) {
            this.isFirstEnterMainPage = false;
        } else {
            navigateToMainTabFragment();
        }
    }

    private final void doResumeInternal() {
        tryInitWhenOnResume();
        fetchStarbucksIfLoggedIn();
    }

    private final void fetchStarbucksIfLoggedIn() {
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null || !accountInfo.isLogin()) {
            return;
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new MainActivity$fetchStarbucksIfLoggedIn$1(accountInfo, null), 3, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void tryInitWhenOnResume() {
        if (this.alreadyInit) {
            return;
        }
        Log.i(TAG, "tryInitWhenOnResume");
        boolean z = false;
        if (getIntent().getBooleanExtra(EXTRA_FROM_LANGUAGE_SWITCH, false)) {
            getIntent().removeExtra(EXTRA_FROM_LANGUAGE_SWITCH);
            this.alreadyInit = true;
            this.isFirstEnterMainPage = false;
            Log.i(TAG, "Language switch recreate, staying on task list");
            return;
        }
        boolean booleanExtra = getIntent().getBooleanExtra("from_login_success", false);
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        AccountInfo accountInfo = iLoginService != null ? iLoginService.getAccountInfo() : null;
        boolean z2 = iLoginService != null && iLoginService.isTraeLoggedIn();
        Log.i(TAG, "loginService=" + (iLoginService != null) + ", isLogin=" + (accountInfo != null ? Boolean.valueOf(accountInfo.isLogin()) : null) + ", traeLoggedIn=" + z2 + ", fromLoginSuccess=" + booleanExtra);
        if (!booleanExtra && !z2) {
            if (accountInfo != null && accountInfo.isLogin()) {
                z = true;
            }
            if (!z) {
                Log.i(TAG, "Not logged in, navigating to login");
                if (pendingDeepLinkUri == null) {
                    Intent intent = getIntent();
                    pendingDeepLinkUri = intent != null ? intent.getData() : null;
                }
                dismissSplash();
                navigateToLoginActivity();
                finish();
                this.alreadyInit = true;
            }
        }
        final Uri uri = pendingDeepLinkUri;
        if (uri == null) {
            Intent intent2 = getIntent();
            uri = intent2 != null ? intent2.getData() : null;
        }
        if (uri != null) {
            PushDeeplinkPendingStore.INSTANCE.clear((Context) this);
        }
        if (uri == null) {
            uri = PushDeeplinkPendingStore.INSTANCE.consumeIfPresent((Context) this);
        }
        pendingDeepLinkUri = null;
        if (uri != null) {
            Log.i(TAG, "Handling pending deep link after login: " + uri);
            Intent intent3 = getIntent();
            if (intent3 != null) {
                intent3.setData(null);
            }
            final PendingDeepLinkRoute resolve = PendingDeepLinkRoutePolicy.INSTANCE.resolve(uri.getHost(), uri.getQueryParameter("conversation_id"));
            if (resolve instanceof PendingDeepLinkRoute.Conversation) {
                this.pendingNavigate = new Function0() { // from class: com.bytedance.trae.home.MainActivity$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit tryInitWhenOnResume$lambda$11;
                        tryInitWhenOnResume$lambda$11 = MainActivity.tryInitWhenOnResume$lambda$11(PendingDeepLinkRoute.this, this);
                        return tryInitWhenOnResume$lambda$11;
                    }
                };
            } else {
                if (!Intrinsics.areEqual(resolve, PendingDeepLinkRoute.RoutedByZlink.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                this.pendingNavigate = new Function0() { // from class: com.bytedance.trae.home.MainActivity$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit tryInitWhenOnResume$lambda$12;
                        tryInitWhenOnResume$lambda$12 = MainActivity.tryInitWhenOnResume$lambda$12(MainActivity.this, uri);
                        return tryInitWhenOnResume$lambda$12;
                    }
                };
            }
        } else {
            Log.i(TAG, "Logged in, navigating to task");
            this.pendingNavigate = new Function0() { // from class: com.bytedance.trae.home.MainActivity$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit tryInitWhenOnResume$lambda$13;
                    tryInitWhenOnResume$lambda$13 = MainActivity.tryInitWhenOnResume$lambda$13(MainActivity.this);
                    return tryInitWhenOnResume$lambda$13;
                }
            };
        }
        observeContentReady();
        if (!AppHost.INSTANCE.isOversea()) {
            AppUpdateChecker.INSTANCE.checkUpdate(true);
        }
        this.alreadyInit = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit tryInitWhenOnResume$lambda$11(PendingDeepLinkRoute pendingDeepLinkRoute, MainActivity mainActivity) {
        PendingDeepLinkRoute.Conversation conversation = (PendingDeepLinkRoute.Conversation) pendingDeepLinkRoute;
        if (conversation.getConversationId() == null) {
            mainActivity.navigateToConversationActivity();
        } else {
            mainActivity.navigateToConversationById(conversation.getConversationId());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit tryInitWhenOnResume$lambda$12(MainActivity mainActivity, Uri uri) {
        mainActivity.handlePendingDeepLink(uri);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit tryInitWhenOnResume$lambda$13(MainActivity mainActivity) {
        mainActivity.navigateToConversationActivity();
        return Unit.INSTANCE;
    }

    private final void observeContentReady() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new MainActivity$observeContentReady$1(new ViewModelProvider((ViewModelStoreOwner) this).get(TaskViewModel.class), this, null), 3, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void navigateToLoginActivity() {
        Intent intent = new Intent();
        intent.setClassName((Context) this, "com.bytedance.trae.login.activity.AccountLoginActivity");
        intent.setFlags(268468224);
        intent.putExtra("login_enter_from", NewTaskTracker.EnterFrom.DEEPLINK);
        intent.putExtra("login_page_source", "cold_launch");
        startActivity(intent);
    }

    private final String getDeepLinkConversationId() {
        Uri data;
        Intent intent = getIntent();
        if (intent == null || (data = intent.getData()) == null || !Intrinsics.areEqual(data.getHost(), "conversation")) {
            return null;
        }
        return data.getQueryParameter("conversation_id");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handlePendingDeepLink(Uri uri) {
        Intent intent = new Intent((Context) this, (Class<?>) ZlinkLinkEntryActivity.class);
        intent.setData(uri);
        startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void navigateToConversationById(String conversationId) {
        if (conversationId.length() == 0) {
            startActivity(new Intent((Context) this, (Class<?>) ConversationActivity.class));
            overridePendingTransition(0, 0);
            return;
        }
        Conversation resolveInitialConversation = ConversationUtils.INSTANCE.resolveInitialConversation(conversationId, null);
        if (resolveInitialConversation != null) {
            Intent intent = new Intent((Context) this, (Class<?>) ConversationActivity.class);
            String cliTypeById = CliListRepository.INSTANCE.getInstance().getCliTypeById(resolveInitialConversation.getCliId());
            if (cliTypeById != null) {
                resolveInitialConversation.setEnvironment(cliTypeById);
                intent.putExtra(ConversationActivity.EXTRA_CONVERSATION, resolveInitialConversation);
            }
            startActivity(intent);
            overridePendingTransition(0, 0);
            return;
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new MainActivity$navigateToConversationById$1(conversationId, this, null), 3, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void navigateToConversationActivity() {
        String deepLinkConversationId = getDeepLinkConversationId();
        Intent intent = getIntent();
        if (intent != null) {
            intent.setData(null);
        }
        String str = deepLinkConversationId;
        if (!(str == null || str.length() == 0)) {
            Conversation resolveInitialConversation = ConversationUtils.INSTANCE.resolveInitialConversation(deepLinkConversationId, null);
            if (resolveInitialConversation != null) {
                Intent intent2 = new Intent((Context) this, (Class<?>) ConversationActivity.class);
                if (CliListRepository.INSTANCE.getInstance().getCliTypeById(resolveInitialConversation.getCliId()) != null) {
                    resolveInitialConversation.setEnvironment(CliListRepository.INSTANCE.getInstance().getCliTypeById(resolveInitialConversation.getCliId()));
                    intent2.putExtra(ConversationActivity.EXTRA_CONVERSATION, resolveInitialConversation);
                }
                startActivity(intent2);
                overridePendingTransition(0, 0);
                return;
            }
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new MainActivity$navigateToConversationActivity$1(deepLinkConversationId, this, null), 3, (Object) null);
            return;
        }
        startActivity(new Intent((Context) this, (Class<?>) ConversationActivity.class));
        overridePendingTransition(0, 0);
    }

    private final void navigateToMainTabFragment() {
        if (getSupportFragmentManager().findFragmentByTag(TAG_MAIN_TAB_FRAGMENT) != null) {
            return;
        }
        getSupportFragmentManager().beginTransaction().replace(C0820R.id.fragment_container, new TaskFragment(), TAG_MAIN_TAB_FRAGMENT).commitAllowingStateLoss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void onPrivacyAgreed() {
        PrivacyCache.INSTANCE.savePrivacyWindowClick((Context) this, true);
        PrivacyManager.INSTANCE.notifyAgree(true);
        PrivacyManager.INSTANCE.updateIsFirstStartMark(true);
        ZlinkInitializer zlinkInitializer = ZlinkInitializer.INSTANCE;
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        zlinkInitializer.initAfterPrivacyAgreed(application);
        InitPeriodWrapper.INSTANCE.notifyAllPeriod((Activity) this);
        showOnboardingOrMainPage();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void onPrivacyDisagreed() {
        PrivacyCache.INSTANCE.savePrivacyWindowClick((Context) this, false);
        Process.killProcess(Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacks(this.dismissSplashRunnable);
    }

    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public int getDecorViewBackgroundColor() {
        return getColor(C0591R.color.trae_bg_bg_base_secondary);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_home_MainActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m869x8bb741d(MainActivity mainActivity) {
        mainActivity.com_bytedance_trae_home_MainActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) mainActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
