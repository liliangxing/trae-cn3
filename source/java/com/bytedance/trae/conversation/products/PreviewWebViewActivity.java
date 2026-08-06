package com.bytedance.trae.conversation.products;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.ConversationActivity;
import com.bytedance.trae.im.service.ChatSessionResponse;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.IChatSessionApi;
import com.bytedance.trae.im.service.IChatSessionAuthApi;
import com.bytedance.trae.im.service.SessionTokenData;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.FLogger;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: PreviewWebViewActivity.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 22\u00020\u0001:\u000523456B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0014J,\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J*\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020#2\b\u0010'\u001a\u0004\u0018\u00010#2\b\u0010(\u001a\u0004\u0018\u00010#H\u0082@¢\u0006\u0002\u0010)J\u0016\u0010*\u001a\u00020+2\u0006\u0010'\u001a\u00020#H\u0082@¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010.\u001a\u0004\u0018\u00010#2\u0006\u0010'\u001a\u00020#H\u0082@¢\u0006\u0002\u0010,J \u0010/\u001a\u00020#2\u0006\u0010\"\u001a\u00020#2\u0006\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020#H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "btnBack", "Landroid/widget/ImageView;", "tvTitle", "Landroid/widget/TextView;", "progressBar", "Landroid/widget/ProgressBar;", "webView", "Landroid/webkit/WebView;", "errorContainer", "Landroid/view/View;", "statusError", "statusDesc", "btnRetry", "btnStartAgent", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupBackHandler", "onDestroy", "showError", "titleRes", "", "descRes", "showRetry", "", "showStartAgent", "setupWebView", "parseUrl", "Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;", IWeixinService.ResponseConstants.URL, "", "resolvePreviewUrl", "Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult;", "rawUrl", "chatSessionId", "cliType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchSessionPreviewUrl", "Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isUrlValid", "fetchSessionToken", "appendOrReplaceQueryParam", "name", "value", "Companion", "ParsedUrl", "ResolveResult", "FetchPreviewUrlResult", "WebFetchApi", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PreviewWebViewActivity extends TraeCommonAppCompatActivity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_CHAT_SESSION_ID = "extra_chat_session_id";
    private static final String EXTRA_CLI_TYPE = "extra_cli_type";
    private static final String EXTRA_TITLE = "extra_title";
    private static final String EXTRA_URL = "extra_url";
    private ImageView btnBack;
    private TextView btnRetry;
    private TextView btnStartAgent;
    private View errorContainer;
    private ProgressBar progressBar;
    private TextView statusDesc;
    private TextView statusError;
    private TextView tvTitle;
    private WebView webView;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PreviewWebViewActivity.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bb\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$WebFetchApi;", "", ApiRequest.METHOD_GET, "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", IWeixinService.ResponseConstants.URL, "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface WebFetchApi {
        @GET
        Call<TypedInput> get(@Url String url);
    }

    /* renamed from: com_bytedance_trae_conversation_products_PreviewWebViewActivity__onStop$___twin___ */
    public void m854xbbe88171() {
        super.onStop();
    }

    protected void onStop() {
        m853x82b7f32a(this);
    }

    /* compiled from: PreviewWebViewActivity.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005J:\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$Companion;", "", "<init>", "()V", "EXTRA_URL", "", "EXTRA_TITLE", "EXTRA_CHAT_SESSION_ID", "EXTRA_CLI_TYPE", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", IWeixinService.ResponseConstants.URL, "title", "chatSessionId", "cliType", "start", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent createIntent(Context context, String url, String title, String chatSessionId, String cliType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
            Intent intent = new Intent(context, (Class<?>) PreviewWebViewActivity.class);
            intent.putExtra(PreviewWebViewActivity.EXTRA_URL, url);
            intent.putExtra(PreviewWebViewActivity.EXTRA_TITLE, title);
            intent.putExtra(PreviewWebViewActivity.EXTRA_CHAT_SESSION_ID, chatSessionId);
            intent.putExtra(PreviewWebViewActivity.EXTRA_CLI_TYPE, cliType);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            return intent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void start(Context context, String url, String title, String chatSessionId, String cliType) {
            ConversationActivity conversationActivity;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
            Intent createIntent = createIntent(context, url, title, chatSessionId, cliType);
            if (context instanceof ConversationActivity) {
                conversationActivity = (ConversationActivity) context;
            } else {
                if (context instanceof ContextWrapper) {
                    Object baseContext = ((ContextWrapper) context).getBaseContext();
                    if (baseContext instanceof ConversationActivity) {
                        conversationActivity = (ConversationActivity) baseContext;
                    }
                }
                conversationActivity = null;
            }
            if (conversationActivity != null) {
                conversationActivity.getPreviewWebViewLauncher().launch(createIntent);
            } else {
                context.startActivity(createIntent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PreviewWebViewActivity.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ParsedUrl;", "", "pathSearchHash", "", "isLocal", "", "isValid", "<init>", "(Ljava/lang/String;ZZ)V", "getPathSearchHash", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class ParsedUrl {
        private final boolean isLocal;
        private final boolean isValid;
        private final String pathSearchHash;

        public static /* synthetic */ ParsedUrl copy$default(ParsedUrl parsedUrl, String str, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = parsedUrl.pathSearchHash;
            }
            if ((i & 2) != 0) {
                z = parsedUrl.isLocal;
            }
            if ((i & 4) != 0) {
                z2 = parsedUrl.isValid;
            }
            return parsedUrl.copy(str, z, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPathSearchHash() {
            return this.pathSearchHash;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsLocal() {
            return this.isLocal;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsValid() {
            return this.isValid;
        }

        public final ParsedUrl copy(String pathSearchHash, boolean isLocal, boolean isValid) {
            Intrinsics.checkNotNullParameter(pathSearchHash, "pathSearchHash");
            return new ParsedUrl(pathSearchHash, isLocal, isValid);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ParsedUrl)) {
                return false;
            }
            ParsedUrl parsedUrl = (ParsedUrl) other;
            return Intrinsics.areEqual(this.pathSearchHash, parsedUrl.pathSearchHash) && this.isLocal == parsedUrl.isLocal && this.isValid == parsedUrl.isValid;
        }

        public int hashCode() {
            return (((this.pathSearchHash.hashCode() * 31) + Boolean.hashCode(this.isLocal)) * 31) + Boolean.hashCode(this.isValid);
        }

        public String toString() {
            return "ParsedUrl(pathSearchHash=" + this.pathSearchHash + ", isLocal=" + this.isLocal + ", isValid=" + this.isValid + ')';
        }

        public ParsedUrl(String str, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(str, "pathSearchHash");
            this.pathSearchHash = str;
            this.isLocal = z;
            this.isValid = z2;
        }

        public final String getPathSearchHash() {
            return this.pathSearchHash;
        }

        public final boolean isLocal() {
            return this.isLocal;
        }

        public final boolean isValid() {
            return this.isValid;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PreviewWebViewActivity.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult;", "", "<init>", "()V", "Success", "ServiceNotRunning", "NetworkError", "Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$NetworkError;", "Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$ServiceNotRunning;", "Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$Success;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static abstract class ResolveResult {
        public /* synthetic */ ResolveResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: PreviewWebViewActivity.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$Success;", "Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult;", IWeixinService.ResponseConstants.URL, "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class Success extends ResolveResult {
            private final String url;

            public static /* synthetic */ Success copy$default(Success success, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = success.url;
                }
                return success.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            public final Success copy(String url) {
                Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
                return new Success(url);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Success) && Intrinsics.areEqual(this.url, ((Success) other).url);
            }

            public int hashCode() {
                return this.url.hashCode();
            }

            public String toString() {
                return "Success(url=" + this.url + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, IWeixinService.ResponseConstants.URL);
                this.url = str;
            }

            public final String getUrl() {
                return this.url;
            }
        }

        private ResolveResult() {
        }

        /* compiled from: PreviewWebViewActivity.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$ServiceNotRunning;", "Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class ServiceNotRunning extends ResolveResult {
            public static final ServiceNotRunning INSTANCE = new ServiceNotRunning();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ServiceNotRunning)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1500723465;
            }

            public String toString() {
                return "ServiceNotRunning";
            }

            private ServiceNotRunning() {
                super(null);
            }
        }

        /* compiled from: PreviewWebViewActivity.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult$NetworkError;", "Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$ResolveResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class NetworkError extends ResolveResult {
            public static final NetworkError INSTANCE = new NetworkError();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NetworkError)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 733264498;
            }

            public String toString() {
                return "NetworkError";
            }

            private NetworkError() {
                super(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PreviewWebViewActivity.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult;", "", "<init>", "()V", "Success", "Empty", "Error", "Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult$Empty;", "Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult$Error;", "Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult$Success;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static abstract class FetchPreviewUrlResult {
        public /* synthetic */ FetchPreviewUrlResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: PreviewWebViewActivity.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult$Success;", "Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult;", "previewUrl", "", "<init>", "(Ljava/lang/String;)V", "getPreviewUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class Success extends FetchPreviewUrlResult {
            private final String previewUrl;

            public static /* synthetic */ Success copy$default(Success success, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = success.previewUrl;
                }
                return success.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getPreviewUrl() {
                return this.previewUrl;
            }

            public final Success copy(String previewUrl) {
                Intrinsics.checkNotNullParameter(previewUrl, "previewUrl");
                return new Success(previewUrl);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Success) && Intrinsics.areEqual(this.previewUrl, ((Success) other).previewUrl);
            }

            public int hashCode() {
                return this.previewUrl.hashCode();
            }

            public String toString() {
                return "Success(previewUrl=" + this.previewUrl + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "previewUrl");
                this.previewUrl = str;
            }

            public final String getPreviewUrl() {
                return this.previewUrl;
            }
        }

        private FetchPreviewUrlResult() {
        }

        /* compiled from: PreviewWebViewActivity.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult$Empty;", "Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class Empty extends FetchPreviewUrlResult {
            public static final Empty INSTANCE = new Empty();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Empty)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1430632138;
            }

            public String toString() {
                return "Empty";
            }

            private Empty() {
                super(null);
            }
        }

        /* compiled from: PreviewWebViewActivity.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult$Error;", "Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$FetchPreviewUrlResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class Error extends FetchPreviewUrlResult {
            public static final Error INSTANCE = new Error();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1430782853;
            }

            public String toString() {
                return "Error";
            }

            private Error() {
                super(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onCreate(Bundle savedInstanceState) {
        String str;
        super.onCreate(savedInstanceState);
        setContentView(C0637R.layout.trae_activity_web_preview);
        View findViewById = findViewById(C0637R.id.btn_back);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.btnBack = (ImageView) findViewById;
        View findViewById2 = findViewById(C0637R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.tvTitle = (TextView) findViewById2;
        View findViewById3 = findViewById(C0637R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.progressBar = (ProgressBar) findViewById3;
        View findViewById4 = findViewById(C0637R.id.webview);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.webView = (WebView) findViewById4;
        View findViewById5 = findViewById(C0637R.id.error_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.errorContainer = findViewById5;
        View findViewById6 = findViewById(C0637R.id.status_error);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.statusError = (TextView) findViewById6;
        View findViewById7 = findViewById(C0637R.id.status_error_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.statusDesc = (TextView) findViewById7;
        View findViewById8 = findViewById(C0637R.id.btn_retry);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        this.btnRetry = (TextView) findViewById8;
        View findViewById9 = findViewById(C0637R.id.btn_start_agent);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
        this.btnStartAgent = (TextView) findViewById9;
        String stringExtra = getIntent().getStringExtra(EXTRA_URL);
        if (stringExtra == null) {
            stringExtra = "";
        }
        final String str2 = stringExtra;
        if (str2.length() == 0) {
            finish();
            return;
        }
        final String stringExtra2 = getIntent().getStringExtra(EXTRA_CHAT_SESSION_ID);
        final String stringExtra3 = getIntent().getStringExtra(EXTRA_CLI_TYPE);
        TextView textView = this.tvTitle;
        ProgressBar progressBar = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            textView = null;
        }
        String stringExtra4 = getIntent().getStringExtra(EXTRA_TITLE);
        if (stringExtra4 != null) {
            str = stringExtra4;
        } else {
            String string = getString(C0637R.string.trae_chat_artifact_preview_web);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            str = string;
        }
        textView.setText(str);
        ImageView imageView = this.btnBack;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnBack");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.PreviewWebViewActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewWebViewActivity.this.finish();
            }
        });
        setupBackHandler();
        TextView textView2 = this.btnRetry;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnRetry");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.PreviewWebViewActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewWebViewActivity.onCreate$lambda$1(PreviewWebViewActivity.this, str2, stringExtra2, stringExtra3, view);
            }
        });
        TextView textView3 = this.btnStartAgent;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnStartAgent");
            textView3 = null;
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.PreviewWebViewActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewWebViewActivity.onCreate$lambda$3(PreviewWebViewActivity.this, str2, view);
            }
        });
        setupWebView();
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar2 = null;
        }
        progressBar2.setIndeterminate(true);
        ProgressBar progressBar3 = this.progressBar;
        if (progressBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        } else {
            progressBar = progressBar3;
        }
        progressBar.setVisibility(0);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new PreviewWebViewActivity$onCreate$4(this, str2, stringExtra2, stringExtra3, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(PreviewWebViewActivity previewWebViewActivity, String str, String str2, String str3, View view) {
        View view2 = previewWebViewActivity.errorContainer;
        ProgressBar progressBar = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorContainer");
            view2 = null;
        }
        view2.setVisibility(8);
        WebView webView = previewWebViewActivity.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.setVisibility(0);
        ProgressBar progressBar2 = previewWebViewActivity.progressBar;
        if (progressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar2 = null;
        }
        progressBar2.setIndeterminate(true);
        ProgressBar progressBar3 = previewWebViewActivity.progressBar;
        if (progressBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        } else {
            progressBar = progressBar3;
        }
        progressBar.setVisibility(0);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) previewWebViewActivity), (CoroutineContext) null, (CoroutineStart) null, new PreviewWebViewActivity$onCreate$2$1(previewWebViewActivity, str, str2, str3, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(PreviewWebViewActivity previewWebViewActivity, String str, View view) {
        Intent intent = new Intent();
        intent.putExtra(ConversationActivity.EXTRA_START_SERVER_URL, str);
        previewWebViewActivity.setResult(-1, intent);
        previewWebViewActivity.finish();
    }

    private final void setupBackHandler() {
        getOnBackPressedDispatcher().addCallback((LifecycleOwner) this, new OnBackPressedCallback() { // from class: com.bytedance.trae.conversation.products.PreviewWebViewActivity$setupBackHandler$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            public void handleOnBackPressed() {
                WebView webView;
                WebView webView2;
                WebView webView3;
                webView = PreviewWebViewActivity.this.webView;
                if (webView != null) {
                    webView2 = PreviewWebViewActivity.this.webView;
                    WebView webView4 = null;
                    if (webView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("webView");
                        webView2 = null;
                    }
                    if (webView2.canGoBack()) {
                        webView3 = PreviewWebViewActivity.this.webView;
                        if (webView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("webView");
                        } else {
                            webView4 = webView3;
                        }
                        webView4.goBack();
                        return;
                    }
                }
                setEnabled(false);
                PreviewWebViewActivity.this.getOnBackPressedDispatcher().onBackPressed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onDestroy() {
        WebView webView = this.webView;
        if (webView != null) {
            WebView webView2 = null;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView = null;
            }
            webView.stopLoading();
            WebView webView3 = this.webView;
            if (webView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView3 = null;
            }
            webView3.setWebChromeClient(null);
            WebView webView4 = this.webView;
            if (webView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            } else {
                webView2 = webView4;
            }
            webView2.destroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void showError$default(PreviewWebViewActivity previewWebViewActivity, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            z2 = false;
        }
        previewWebViewActivity.showError(i, i2, z, z2);
    }

    private final void showError(int titleRes, int descRes, boolean showRetry, boolean showStartAgent) {
        ProgressBar progressBar = this.progressBar;
        TextView textView = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.setVisibility(8);
        View view = this.errorContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorContainer");
            view = null;
        }
        view.setVisibility(0);
        TextView textView2 = this.statusError;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusError");
            textView2 = null;
        }
        textView2.setText(titleRes);
        TextView textView3 = this.statusDesc;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusDesc");
            textView3 = null;
        }
        textView3.setText(descRes);
        TextView textView4 = this.btnRetry;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnRetry");
            textView4 = null;
        }
        textView4.setVisibility(showRetry ? 0 : 8);
        TextView textView5 = this.btnRetry;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnRetry");
            textView5 = null;
        }
        textView5.setText(R.string.trae_doc_preview_retry);
        TextView textView6 = this.btnStartAgent;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnStartAgent");
            textView6 = null;
        }
        textView6.setVisibility(showStartAgent ? 0 : 8);
        TextView textView7 = this.btnStartAgent;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnStartAgent");
        } else {
            textView = textView7;
        }
        textView.setText(R.string.trae_doc_preview_restart_service);
    }

    private final void setupWebView() {
        WebView webView = this.webView;
        WebView webView2 = null;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.setWebViewClient(new WebViewClient());
        WebView webView3 = this.webView;
        if (webView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView3 = null;
        }
        webView3.setWebChromeClient(new WebChromeClient() { // from class: com.bytedance.trae.conversation.products.PreviewWebViewActivity$setupWebView$1
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                ProgressBar progressBar;
                ProgressBar progressBar2;
                ProgressBar progressBar3;
                ProgressBar progressBar4;
                ProgressBar progressBar5 = null;
                if (1 <= newProgress && newProgress < 100) {
                    progressBar2 = PreviewWebViewActivity.this.progressBar;
                    if (progressBar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                        progressBar2 = null;
                    }
                    progressBar2.setIndeterminate(false);
                    progressBar3 = PreviewWebViewActivity.this.progressBar;
                    if (progressBar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                        progressBar3 = null;
                    }
                    progressBar3.setVisibility(0);
                    progressBar4 = PreviewWebViewActivity.this.progressBar;
                    if (progressBar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                    } else {
                        progressBar5 = progressBar4;
                    }
                    progressBar5.setProgress(newProgress);
                    return;
                }
                progressBar = PreviewWebViewActivity.this.progressBar;
                if (progressBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                } else {
                    progressBar5 = progressBar;
                }
                progressBar5.setVisibility(8);
            }
        });
        WebView webView4 = this.webView;
        if (webView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            webView2 = webView4;
        }
        WebSettings settings = webView2.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "getSettings(...)");
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setMixedContentMode(2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0043, code lost:
    
        if (r4 == null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ParsedUrl parseUrl(String url) {
        String str;
        ParsedUrl parsedUrl = new ParsedUrl("", false, false);
        if (StringsKt.isBlank(url)) {
            return parsedUrl;
        }
        try {
            URI uri = new URI(url);
            String host = uri.getHost();
            if (host != null) {
                str = host.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
            } else {
                str = null;
            }
            String rawPath = uri.getRawPath();
            if (rawPath != null) {
                if (!(rawPath.length() > 0)) {
                    rawPath = null;
                }
            }
            rawPath = "/";
            StringBuilder sb = new StringBuilder(rawPath);
            String rawQuery = uri.getRawQuery();
            if (rawQuery != null) {
                if (!(rawQuery.length() > 0)) {
                    rawQuery = null;
                }
                if (rawQuery != null) {
                    sb.append('?').append(rawQuery);
                }
            }
            String rawFragment = uri.getRawFragment();
            if (rawFragment != null) {
                String str2 = rawFragment.length() > 0 ? rawFragment : null;
                if (str2 != null) {
                    sb.append('#').append(str2);
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return parsedUrl.copy(sb2, CollectionsKt.contains(SetsKt.setOf(new String[]{"localhost", "127.0.0.1", "0.0.0.0", "::1"}), str), true);
        } catch (Exception unused) {
            return parsedUrl;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolvePreviewUrl(String str, String str2, String str3, Continuation<? super ResolveResult> continuation) {
        PreviewWebViewActivity$resolvePreviewUrl$1 previewWebViewActivity$resolvePreviewUrl$1;
        int i;
        String str4;
        PreviewWebViewActivity previewWebViewActivity;
        ParsedUrl parsedUrl;
        FetchPreviewUrlResult fetchPreviewUrlResult;
        String build;
        String str5;
        if (continuation instanceof PreviewWebViewActivity$resolvePreviewUrl$1) {
            previewWebViewActivity$resolvePreviewUrl$1 = (PreviewWebViewActivity$resolvePreviewUrl$1) continuation;
            if ((previewWebViewActivity$resolvePreviewUrl$1.label & Integer.MIN_VALUE) != 0) {
                previewWebViewActivity$resolvePreviewUrl$1.label -= Integer.MIN_VALUE;
                Object obj = previewWebViewActivity$resolvePreviewUrl$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = previewWebViewActivity$resolvePreviewUrl$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ParsedUrl parseUrl = parseUrl(str);
                    if (!parseUrl.isValid() || !parseUrl.isLocal()) {
                        return new ResolveResult.Success(str);
                    }
                    String str6 = str2;
                    if ((str6 == null || StringsKt.isBlank(str6)) || !Intrinsics.areEqual(str3, CliType.REMOTE.getValue())) {
                        return new ResolveResult.Success(str);
                    }
                    previewWebViewActivity$resolvePreviewUrl$1.L$0 = this;
                    previewWebViewActivity$resolvePreviewUrl$1.L$1 = str2;
                    previewWebViewActivity$resolvePreviewUrl$1.L$2 = parseUrl;
                    previewWebViewActivity$resolvePreviewUrl$1.label = 1;
                    Object fetchSessionPreviewUrl = fetchSessionPreviewUrl(str2, previewWebViewActivity$resolvePreviewUrl$1);
                    if (fetchSessionPreviewUrl == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str4 = str2;
                    previewWebViewActivity = this;
                    obj = fetchSessionPreviewUrl;
                    parsedUrl = parseUrl;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        build = (String) previewWebViewActivity$resolvePreviewUrl$1.L$1;
                        previewWebViewActivity = (PreviewWebViewActivity) previewWebViewActivity$resolvePreviewUrl$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        String str7 = (String) obj;
                        str5 = str7;
                        if (!(str5 != null || StringsKt.isBlank(str5))) {
                            build = previewWebViewActivity.appendOrReplaceQueryParam(build, "_session_token", str7);
                        }
                        if (!previewWebViewActivity.isUrlValid(build)) {
                            return new ResolveResult.Success(build);
                        }
                        return ResolveResult.ServiceNotRunning.INSTANCE;
                    }
                    parsedUrl = (ParsedUrl) previewWebViewActivity$resolvePreviewUrl$1.L$2;
                    String str8 = (String) previewWebViewActivity$resolvePreviewUrl$1.L$1;
                    PreviewWebViewActivity previewWebViewActivity2 = (PreviewWebViewActivity) previewWebViewActivity$resolvePreviewUrl$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    str4 = str8;
                    previewWebViewActivity = previewWebViewActivity2;
                }
                fetchPreviewUrlResult = (FetchPreviewUrlResult) obj;
                if (fetchPreviewUrlResult instanceof FetchPreviewUrlResult.Success) {
                    if (fetchPreviewUrlResult instanceof FetchPreviewUrlResult.Empty) {
                        return ResolveResult.ServiceNotRunning.INSTANCE;
                    }
                    if (fetchPreviewUrlResult instanceof FetchPreviewUrlResult.Error) {
                        return ResolveResult.NetworkError.INSTANCE;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                try {
                    build = SessionPreviewUrlBuilder.INSTANCE.build(((FetchPreviewUrlResult.Success) fetchPreviewUrlResult).getPreviewUrl(), parsedUrl.getPathSearchHash());
                    previewWebViewActivity$resolvePreviewUrl$1.L$0 = previewWebViewActivity;
                    previewWebViewActivity$resolvePreviewUrl$1.L$1 = build;
                    previewWebViewActivity$resolvePreviewUrl$1.L$2 = null;
                    previewWebViewActivity$resolvePreviewUrl$1.label = 2;
                    obj = previewWebViewActivity.fetchSessionToken(str4, previewWebViewActivity$resolvePreviewUrl$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    String str72 = (String) obj;
                    str5 = str72;
                    if (!(str5 != null || StringsKt.isBlank(str5))) {
                    }
                    if (!previewWebViewActivity.isUrlValid(build)) {
                    }
                } catch (Exception unused) {
                    return ResolveResult.NetworkError.INSTANCE;
                }
            }
        }
        previewWebViewActivity$resolvePreviewUrl$1 = new PreviewWebViewActivity$resolvePreviewUrl$1(this, continuation);
        Object obj2 = previewWebViewActivity$resolvePreviewUrl$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = previewWebViewActivity$resolvePreviewUrl$1.label;
        if (i != 0) {
        }
        fetchPreviewUrlResult = (FetchPreviewUrlResult) obj2;
        if (fetchPreviewUrlResult instanceof FetchPreviewUrlResult.Success) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchSessionPreviewUrl(String str, Continuation<? super FetchPreviewUrlResult> continuation) {
        PreviewWebViewActivity$fetchSessionPreviewUrl$1 previewWebViewActivity$fetchSessionPreviewUrl$1;
        int i;
        HttpDataResult.Success success;
        if (continuation instanceof PreviewWebViewActivity$fetchSessionPreviewUrl$1) {
            previewWebViewActivity$fetchSessionPreviewUrl$1 = (PreviewWebViewActivity$fetchSessionPreviewUrl$1) continuation;
            if ((previewWebViewActivity$fetchSessionPreviewUrl$1.label & Integer.MIN_VALUE) != 0) {
                previewWebViewActivity$fetchSessionPreviewUrl$1.label -= Integer.MIN_VALUE;
                Object obj = previewWebViewActivity$fetchSessionPreviewUrl$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = previewWebViewActivity$fetchSessionPreviewUrl$1.label;
                boolean z = true;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    IChatSessionApi.Companion companion = IChatSessionApi.INSTANCE;
                    previewWebViewActivity$fetchSessionPreviewUrl$1.label = 1;
                    obj = companion.getChatSessionRawCall(str, previewWebViewActivity$fetchSessionPreviewUrl$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                success = (HttpDataResult) obj;
                if (!(success instanceof HttpDataResult.Success)) {
                    ChatSessionResponse chatSessionResponse = (ChatSessionResponse) success.getBizResp().getData();
                    String previewUrl = chatSessionResponse != null ? chatSessionResponse.getPreviewUrl() : null;
                    String str2 = previewUrl;
                    if (str2 != null && !StringsKt.isBlank(str2)) {
                        z = false;
                    }
                    if (z) {
                        return FetchPreviewUrlResult.Empty.INSTANCE;
                    }
                    return new FetchPreviewUrlResult.Success(previewUrl);
                }
                if (success instanceof HttpDataResult.Error) {
                    return FetchPreviewUrlResult.Error.INSTANCE;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        previewWebViewActivity$fetchSessionPreviewUrl$1 = new PreviewWebViewActivity$fetchSessionPreviewUrl$1(this, continuation);
        Object obj2 = previewWebViewActivity$fetchSessionPreviewUrl$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = previewWebViewActivity$fetchSessionPreviewUrl$1.label;
        boolean z2 = true;
        if (i != 0) {
        }
        success = (HttpDataResult) obj2;
        if (!(success instanceof HttpDataResult.Success)) {
        }
    }

    private final boolean isUrlValid(final String url) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Interceptor() { // from class: com.bytedance.trae.conversation.products.PreviewWebViewActivity$$ExternalSyntheticLambda3
                public final SsResponse intercept(Interceptor.Chain chain) {
                    SsResponse isUrlValid$lambda$9;
                    isUrlValid$lambda$9 = PreviewWebViewActivity.isUrlValid$lambda$9(url, chain);
                    return isUrlValid$lambda$9;
                }
            });
            FLogger.INSTANCE.d("PreviewWebViewActivity", "isUrlValid:" + url);
            WebFetchApi webFetchApi = (WebFetchApi) RetrofitUtils.createSsRetrofit("https://placeholder.trae/", arrayList, (Converter.Factory) null).create(WebFetchApi.class);
            if (webFetchApi == null) {
                return false;
            }
            SsResponse execute = webFetchApi.get(url).execute();
            Intrinsics.checkNotNullExpressionValue(execute, "execute(...)");
            FLogger.INSTANCE.d("PreviewWebViewActivity", "isUrlValid:" + execute.code());
            return execute.isSuccessful();
        } catch (Throwable th) {
            FLogger.INSTANCE.e("PreviewWebViewActivity", "isUrlValid", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SsResponse isUrlValid$lambda$9(String str, Interceptor.Chain chain) {
        Request request;
        if (chain == null || (request = chain.request()) == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(Uri.parse(request.getUrl()).buildUpon().clearQuery().build().toString(), "toString(...)");
        return chain.proceed(request.newBuilder().url(str).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchSessionToken(String str, Continuation<? super String> continuation) {
        PreviewWebViewActivity$fetchSessionToken$1 previewWebViewActivity$fetchSessionToken$1;
        int i;
        HttpDataResult.Success success;
        if (continuation instanceof PreviewWebViewActivity$fetchSessionToken$1) {
            previewWebViewActivity$fetchSessionToken$1 = (PreviewWebViewActivity$fetchSessionToken$1) continuation;
            if ((previewWebViewActivity$fetchSessionToken$1.label & Integer.MIN_VALUE) != 0) {
                previewWebViewActivity$fetchSessionToken$1.label -= Integer.MIN_VALUE;
                Object obj = previewWebViewActivity$fetchSessionToken$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = previewWebViewActivity$fetchSessionToken$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    IChatSessionAuthApi.Companion companion = IChatSessionAuthApi.INSTANCE;
                    PreviewWebViewActivity$fetchSessionToken$result$1 previewWebViewActivity$fetchSessionToken$result$1 = new PreviewWebViewActivity$fetchSessionToken$result$1(str, null);
                    previewWebViewActivity$fetchSessionToken$1.label = 1;
                    obj = companion.safeCall(previewWebViewActivity$fetchSessionToken$result$1, previewWebViewActivity$fetchSessionToken$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                success = (HttpDataResult) obj;
                if (success instanceof HttpDataResult.Success) {
                    if (success instanceof HttpDataResult.Error) {
                        return null;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                SessionTokenData sessionTokenData = (SessionTokenData) success.getBizResp().getData();
                if (sessionTokenData != null) {
                    return sessionTokenData.getToken();
                }
                return null;
            }
        }
        previewWebViewActivity$fetchSessionToken$1 = new PreviewWebViewActivity$fetchSessionToken$1(this, continuation);
        Object obj2 = previewWebViewActivity$fetchSessionToken$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = previewWebViewActivity$fetchSessionToken$1.label;
        if (i != 0) {
        }
        success = (HttpDataResult) obj2;
        if (success instanceof HttpDataResult.Success) {
        }
    }

    private final String appendOrReplaceQueryParam(String url, String name, String value) {
        try {
            Uri parse = Uri.parse(url);
            Uri.Builder clearQuery = parse.buildUpon().clearQuery();
            for (String str : parse.getQueryParameterNames()) {
                if (!Intrinsics.areEqual(str, name)) {
                    List<String> queryParameters = parse.getQueryParameters(str);
                    Intrinsics.checkNotNullExpressionValue(queryParameters, "getQueryParameters(...)");
                    Iterator<T> it = queryParameters.iterator();
                    while (it.hasNext()) {
                        clearQuery.appendQueryParameter(str, (String) it.next());
                    }
                }
            }
            clearQuery.appendQueryParameter(name, value);
            String uri = clearQuery.build().toString();
            Intrinsics.checkNotNull(uri);
            return uri;
        } catch (Exception unused) {
            return url;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_conversation_products_PreviewWebViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m853x82b7f32a(PreviewWebViewActivity previewWebViewActivity) {
        previewWebViewActivity.m854xbbe88171();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) previewWebViewActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
