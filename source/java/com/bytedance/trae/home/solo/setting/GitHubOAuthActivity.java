package com.bytedance.trae.home.solo.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.conversation.git.GitHubConnectorError;
import com.bytedance.trae.conversation.git.GitHubConnectorManager;
import com.bytedance.trae.home.C0820R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: GitHubOAuthActivity.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u000fH\u0014J\u0012\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "connectorManager", "Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;", "getConnectorManager", "()Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;", "connectorManager$delegate", "Lkotlin/Lazy;", "settingsRedirectUri", "", "getSettingsRedirectUri", "()Ljava/lang/String;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "handleCallbackUri", "uri", "Landroid/net/Uri;", "Mode", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class GitHubOAuthActivity extends AppCompatActivity {
    public static final String EXTRA_MODE = "extra_mode";

    /* renamed from: connectorManager$delegate, reason: from kotlin metadata */
    private final Lazy connectorManager = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.home.solo.setting.GitHubOAuthActivity$$ExternalSyntheticLambda0
        public final Object invoke() {
            GitHubConnectorManager connectorManager_delegate$lambda$0;
            connectorManager_delegate$lambda$0 = GitHubOAuthActivity.connectorManager_delegate$lambda$0(GitHubOAuthActivity.this);
            return connectorManager_delegate$lambda$0;
        }
    });

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: GitHubOAuthActivity.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Mode.values().length];
            try {
                iArr[Mode.CONNECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Mode.MODIFY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: com_bytedance_trae_home_solo_setting_GitHubOAuthActivity__onStop$___twin___ */
    public void m877xde5971b2() {
        super.onStop();
    }

    protected void onStop() {
        m876x4f16c789(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final GitHubConnectorManager connectorManager_delegate$lambda$0(GitHubOAuthActivity gitHubOAuthActivity) {
        return new GitHubConnectorManager((Context) gitHubOAuthActivity, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GitHubConnectorManager getConnectorManager() {
        return (GitHubConnectorManager) this.connectorManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getSettingsRedirectUri() {
        return getPackageName() + "://github-settings-callback";
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        String str;
        Object obj;
        String message;
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            return;
        }
        Intent intent = getIntent();
        if (intent == null || (str = intent.getStringExtra("extra_mode")) == null) {
            str = OpenNetMethod.CONNECT;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[Mode.valueOf(str).ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://github.com/apps/" + getConnectorManager().getConfig().getGitHubApp().getSlug() + "/installations/new")));
            setResult(-1);
            finish();
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            GitHubOAuthActivity gitHubOAuthActivity = this;
            obj = Result.constructor-impl(getConnectorManager().buildOAuthUrl(getSettingsRedirectUri()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            GitHubConnectorError gitHubConnectorError = th2 instanceof GitHubConnectorError ? (GitHubConnectorError) th2 : null;
            if ((gitHubConnectorError == null || (message = gitHubConnectorError.localizedMessage((Context) this)) == null) && (message = th2.getMessage()) == null) {
                message = "";
            }
            Toast.makeText((Context) this, getString(C0820R.string.trae_setting_connector_connect_failed) + ": " + message, 0).show();
            setResult(0);
            finish();
            return;
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String) obj)));
    }

    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        handleCallbackUri(intent.getData());
    }

    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        Uri data = intent != null ? intent.getData() : null;
        if (data == null || !Intrinsics.areEqual(data.getHost(), "github-settings-callback")) {
            return;
        }
        handleCallbackUri(data);
        Intent intent2 = getIntent();
        if (intent2 != null) {
            intent2.setData(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handleCallbackUri(Uri uri) {
        if (uri == null || !Intrinsics.areEqual(uri.getHost(), "github-settings-callback")) {
            return;
        }
        String queryParameter = uri.getQueryParameter("error");
        String str = queryParameter;
        if (!(str == null || StringsKt.isBlank(str))) {
            Toast.makeText((Context) this, getString(C0820R.string.trae_setting_connector_connect_failed) + ": " + queryParameter, 0).show();
            setResult(0);
            finish();
            return;
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new GitHubOAuthActivity$handleCallbackUri$1(this, uri, null), 3, (Object) null);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: GitHubOAuthActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$Mode;", "", "<init>", "(Ljava/lang/String;I)V", OpenNetMethod.CONNECT, "MODIFY", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Mode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final Mode CONNECT = new Mode(OpenNetMethod.CONNECT, 0);
        public static final Mode MODIFY = new Mode("MODIFY", 1);

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{CONNECT, MODIFY};
        }

        public static EnumEntries<Mode> getEntries() {
            return $ENTRIES;
        }

        static {
            Mode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Mode(String str, int i) {
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    /* compiled from: GitHubOAuthActivity.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$Companion;", "", "<init>", "()V", "EXTRA_MODE", "", "newConnectIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "newModifyIntent", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent newConnectIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) GitHubOAuthActivity.class);
            intent.putExtra("extra_mode", OpenNetMethod.CONNECT);
            return intent;
        }

        public final Intent newModifyIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) GitHubOAuthActivity.class);
            intent.putExtra("extra_mode", "MODIFY");
            return intent;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_home_solo_setting_GitHubOAuthActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m876x4f16c789(GitHubOAuthActivity gitHubOAuthActivity) {
        gitHubOAuthActivity.m877xde5971b2();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) gitHubOAuthActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
