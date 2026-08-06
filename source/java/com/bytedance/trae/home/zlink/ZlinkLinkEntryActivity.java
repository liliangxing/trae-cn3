package com.bytedance.trae.home.zlink;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.trae.conversation.ShareWebViewActivity;
import com.bytedance.trae.home.MainActivity;
import com.bytedance.trae.home.privacy.PrivacyManager;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.utils.TrustedDomainUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: ZlinkLinkEntryActivity.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0014\u0010\u0018\u001a\u00020\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0011H\u0002¨\u0006!"}, d2 = {"Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "handleIntent", "handleLink", "uri", "Landroid/net/Uri;", "resolveAppLinkRedirect", TimonPipeline.KEY_SOURCE, "", "followRedirectToScheme", IWeixinService.ResponseConstants.URL, "extractSchemeParam", "isZlinkAppLink", "", "routeByHost", "ensureMainActivityInStack", "pendingUri", "handleWebView", "handleConversation", "fallbackToMain", "markRouted", "scheme", "isAlreadyRouted", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ZlinkLinkEntryActivity extends AppCompatActivity {
    public static final int $stable = 0;
    public static final String EXTRA_PENDING_URI = "extra_pending_uri";
    public static final String EXTRA_SOURCE = "extra_zlink_source";
    private static final String HOST_CONVERSATION = "conversation";
    private static final String HOST_WEBVIEW = "webview";
    private static final String TAG = "ZlinkLinkEntry";
    private static volatile String lastRoutedScheme;
    private static long lastRoutedTime;

    /* renamed from: com_bytedance_trae_home_zlink_ZlinkLinkEntryActivity__onStop$___twin___ */
    public void m881x41142ee8() {
        super.onStop();
    }

    protected void onStop() {
        m880x7dab3413(this);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleIntent(getIntent());
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleIntent(Intent intent) {
        Object obj;
        ILoginService iLoginService;
        boolean z;
        Uri data = intent != null ? intent.getData() : null;
        if (data == null) {
            finish();
            return;
        }
        if (!PrivacyManager.INSTANCE.checkAgreed()) {
            Log.i(TAG, "Privacy not agreed, redirect to MainActivity");
            Intent intent2 = new Intent((Context) this, (Class<?>) MainActivity.class);
            intent2.putExtra(EXTRA_PENDING_URI, data.toString());
            startActivity(intent2);
            finish();
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            ZlinkLinkEntryActivity zlinkLinkEntryActivity = this;
            iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (iLoginService != null) {
            z = true;
            if (iLoginService.isTraeLoggedIn()) {
                obj = Result.constructor-impl(Boolean.valueOf(z));
                if (Result.isFailure-impl(obj)) {
                    obj = false;
                }
                if (((Boolean) obj).booleanValue()) {
                    Log.i(TAG, "User not logged in, redirect to MainActivity for login");
                    fallbackToMain(data, "not_logged_in");
                    finish();
                    return;
                }
                handleLink(data);
                return;
            }
        }
        z = false;
        obj = Result.constructor-impl(Boolean.valueOf(z));
        if (Result.isFailure-impl(obj)) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    private final void handleLink(Uri uri) {
        String queryParameter;
        Intent intent = getIntent();
        if (intent == null || (queryParameter = intent.getStringExtra(EXTRA_SOURCE)) == null) {
            queryParameter = uri.getQueryParameter(TimonPipeline.KEY_SOURCE);
        }
        String str = queryParameter;
        if (str == null || str.length() == 0) {
            if (StringsKt.equals(ZlinkConfig.INSTANCE.getSCHEME(), uri.getScheme(), true)) {
                queryParameter = "scheme";
            } else {
                queryParameter = (Intrinsics.areEqual(uri.getScheme(), "https") || Intrinsics.areEqual(uri.getScheme(), "http")) ? "applink" : "unknown";
            }
        }
        Log.i(TAG, "handleLink, source=" + queryParameter + ", uri=" + uri);
        if (isZlinkAppLink(uri)) {
            ZlinkLaunchLog.INSTANCE.reportFromUri(queryParameter, uri);
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "toString(...)");
            String extractSchemeParam = extractSchemeParam(uri2);
            if (extractSchemeParam != null) {
                Uri parse = Uri.parse(extractSchemeParam);
                markRouted(extractSchemeParam);
                ZlinkLaunchLog.INSTANCE.reportFromSchema(extractSchemeParam);
                Intrinsics.checkNotNull(parse);
                if (routeByHost(parse, queryParameter)) {
                    return;
                }
                finish();
                return;
            }
            resolveAppLinkRedirect(uri, queryParameter);
            return;
        }
        String uri3 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri3, "toString(...)");
        if (isAlreadyRouted(uri3)) {
            finish();
            return;
        }
        String uri4 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri4, "toString(...)");
        markRouted(uri4);
        ZlinkLaunchLog.INSTANCE.reportFromUri(queryParameter, uri);
        if (routeByHost(uri, queryParameter)) {
            return;
        }
        finish();
    }

    private final void resolveAppLinkRedirect(final Uri uri, final String source) {
        ThreadsKt.thread$default(false, false, (ClassLoader) null, (String) null, 0, new Function0() { // from class: com.bytedance.trae.home.zlink.ZlinkLinkEntryActivity$$ExternalSyntheticLambda3
            public final Object invoke() {
                Unit resolveAppLinkRedirect$lambda$5;
                resolveAppLinkRedirect$lambda$5 = ZlinkLinkEntryActivity.resolveAppLinkRedirect$lambda$5(ZlinkLinkEntryActivity.this, uri, source);
                return resolveAppLinkRedirect$lambda$5;
            }
        }, 31, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resolveAppLinkRedirect$lambda$5(final ZlinkLinkEntryActivity zlinkLinkEntryActivity, final Uri uri, final String str) {
        try {
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "toString(...)");
            String followRedirectToScheme = zlinkLinkEntryActivity.followRedirectToScheme(uri2);
            if (followRedirectToScheme != null) {
                final Uri parse = Uri.parse(followRedirectToScheme);
                ZlinkLaunchLog.INSTANCE.reportFromSchema(followRedirectToScheme);
                zlinkLinkEntryActivity.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.home.zlink.ZlinkLinkEntryActivity$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZlinkLinkEntryActivity.resolveAppLinkRedirect$lambda$5$lambda$2(ZlinkLinkEntryActivity.this, parse, str);
                    }
                });
            } else {
                Log.w(TAG, "Could not resolve AppLink redirect, fallback to main");
                zlinkLinkEntryActivity.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.home.zlink.ZlinkLinkEntryActivity$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZlinkLinkEntryActivity.resolveAppLinkRedirect$lambda$5$lambda$3(ZlinkLinkEntryActivity.this, uri, str);
                    }
                });
            }
        } catch (Exception e) {
            Log.w(TAG, "resolveAppLinkRedirect failed", e);
            zlinkLinkEntryActivity.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.home.zlink.ZlinkLinkEntryActivity$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ZlinkLinkEntryActivity.resolveAppLinkRedirect$lambda$5$lambda$4(ZlinkLinkEntryActivity.this, uri, str);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resolveAppLinkRedirect$lambda$5$lambda$2(ZlinkLinkEntryActivity zlinkLinkEntryActivity, Uri uri, String str) {
        if (zlinkLinkEntryActivity.isFinishing() || zlinkLinkEntryActivity.isDestroyed()) {
            return;
        }
        Intrinsics.checkNotNull(uri);
        if (zlinkLinkEntryActivity.routeByHost(uri, str)) {
            return;
        }
        zlinkLinkEntryActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resolveAppLinkRedirect$lambda$5$lambda$3(ZlinkLinkEntryActivity zlinkLinkEntryActivity, Uri uri, String str) {
        zlinkLinkEntryActivity.fallbackToMain(uri, str);
        zlinkLinkEntryActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resolveAppLinkRedirect$lambda$5$lambda$4(ZlinkLinkEntryActivity zlinkLinkEntryActivity, Uri uri, String str) {
        zlinkLinkEntryActivity.fallbackToMain(uri, str);
        zlinkLinkEntryActivity.finish();
    }

    private final String followRedirectToScheme(String url) {
        int i = 0;
        while (i < 10) {
            URLConnection openConnection = new URL(url).openConnection();
            Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            try {
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setRequestMethod(OpenNetMethod.GET);
                int responseCode = httpURLConnection.getResponseCode();
                boolean z = true;
                if (!(300 <= responseCode && responseCode < 400)) {
                    return null;
                }
                String headerField = httpURLConnection.getHeaderField("Location");
                String str = headerField;
                if (str != null && str.length() != 0) {
                    z = false;
                }
                if (z) {
                    return null;
                }
                if (!StringsKt.startsWith$default(headerField, "http://", false, 2, (Object) null) && !StringsKt.startsWith$default(headerField, "https://", false, 2, (Object) null)) {
                    return headerField;
                }
                String extractSchemeParam = extractSchemeParam(headerField);
                if (extractSchemeParam != null) {
                    return extractSchemeParam;
                }
                i++;
                httpURLConnection.disconnect();
                url = headerField;
            } finally {
                httpURLConnection.disconnect();
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e A[Catch: Exception -> 0x003f, TRY_LEAVE, TryCatch #0 {Exception -> 0x003f, blocks: (B:3:0x0001, B:5:0x0012, B:10:0x001e), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String extractSchemeParam(String url) {
        boolean z;
        try {
            String queryParameter = Uri.parse(url).getQueryParameter("scheme");
            String str = queryParameter;
            if (str != null && str.length() != 0) {
                z = false;
                if (!z) {
                    return null;
                }
                if (StringsKt.startsWith$default(queryParameter, ZlinkConfig.INSTANCE.getSCHEME() + "://", false, 2, (Object) null)) {
                    return queryParameter;
                }
                return null;
            }
            z = true;
            if (!z) {
            }
        } catch (Exception unused) {
            return null;
        }
    }

    private final boolean isZlinkAppLink(Uri uri) {
        String host;
        String scheme = uri.getScheme();
        if (scheme == null) {
            return false;
        }
        String lowerCase = scheme.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (lowerCase == null) {
            return false;
        }
        if ((!Intrinsics.areEqual(lowerCase, "https") && !Intrinsics.areEqual(lowerCase, "http")) || (host = uri.getHost()) == null) {
            return false;
        }
        String lowerCase2 = host.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        if (lowerCase2 == null) {
            return false;
        }
        String lowerCase3 = ZlinkConfig.INSTANCE.getAPPLINK_HOST().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
        return (lowerCase3.length() > 0) && Intrinsics.areEqual(lowerCase2, lowerCase3);
    }

    private final boolean routeByHost(Uri uri, String source) {
        String host = uri.getHost();
        if (host == null) {
            host = "";
        }
        String lowerCase = host.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (Intrinsics.areEqual(lowerCase, "webview")) {
            handleWebView(uri);
            return false;
        }
        if (Intrinsics.areEqual(lowerCase, HOST_CONVERSATION)) {
            return handleConversation(uri);
        }
        fallbackToMain(uri, source);
        return false;
    }

    static /* synthetic */ boolean ensureMainActivityInStack$default(ZlinkLinkEntryActivity zlinkLinkEntryActivity, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = null;
        }
        return zlinkLinkEntryActivity.ensureMainActivityInStack(uri);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0057 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean ensureMainActivityInStack(Uri pendingUri) {
        boolean z;
        List<ActivityManager.AppTask> appTasks;
        boolean z2;
        ComponentName componentName;
        ActivityManager activityManager = (ActivityManager) getSystemService(ActivityManager.class);
        if (activityManager != null && (appTasks = activityManager.getAppTasks()) != null) {
            List<ActivityManager.AppTask> list = appTasks;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    ActivityManager.RecentTaskInfo taskInfo = ((ActivityManager.AppTask) it.next()).getTaskInfo();
                    if (Intrinsics.areEqual((taskInfo == null || (componentName = taskInfo.baseActivity) == null) ? null : componentName.getClassName(), MainActivity.class.getName())) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            if (z2) {
                z = true;
                if (!z) {
                    return true;
                }
                Intent intent = new Intent((Context) this, (Class<?>) MainActivity.class);
                intent.addFlags(268500992);
                intent.setData(pendingUri);
                startActivity(intent);
                return false;
            }
        }
        z = false;
        if (!z) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handleWebView(Uri uri) {
        String queryParameter = uri.getQueryParameter(IWeixinService.ResponseConstants.URL);
        String str = queryParameter;
        if (str == null || str.length() == 0) {
            fallbackToMain(uri, "scheme");
        } else if (!TrustedDomainUtils.INSTANCE.isTrustedUrl(queryParameter)) {
            Log.w(TAG, "handleWebView blocked untrusted url: " + queryParameter);
            fallbackToMain(uri, "scheme");
        } else {
            ensureMainActivityInStack$default(this, null, 1, null);
            ShareWebViewActivity.INSTANCE.start((Context) this, queryParameter, "", uri.getQueryParameter("share_url"), uri.getQueryParameter("post_url"), "outside");
        }
    }

    private final boolean handleConversation(Uri uri) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            ZlinkLinkEntryActivity zlinkLinkEntryActivity = this;
            ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
            obj = Result.constructor-impl(Boolean.valueOf(iLoginService != null && iLoginService.isTraeLoggedIn()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = false;
        }
        if (!((Boolean) obj).booleanValue()) {
            fallbackToMain(uri, "scheme");
            return false;
        }
        String queryParameter = uri.getQueryParameter("conversation_id");
        if (!ensureMainActivityInStack(uri)) {
            return false;
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new ZlinkLinkEntryActivity$handleConversation$1(this, queryParameter, null), 3, (Object) null);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void fallbackToMain(Uri uri, String source) {
        Intent intent = new Intent((Context) this, (Class<?>) MainActivity.class);
        intent.setData(uri);
        intent.putExtra(EXTRA_SOURCE, source);
        startActivity(intent);
    }

    private final void markRouted(String scheme) {
        lastRoutedScheme = scheme;
        lastRoutedTime = System.currentTimeMillis();
    }

    private final boolean isAlreadyRouted(String scheme) {
        return Intrinsics.areEqual(scheme, lastRoutedScheme) && System.currentTimeMillis() - lastRoutedTime < 3000;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_home_zlink_ZlinkLinkEntryActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m880x7dab3413(ZlinkLinkEntryActivity zlinkLinkEntryActivity) {
        zlinkLinkEntryActivity.m881x41142ee8();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) zlinkLinkEntryActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
