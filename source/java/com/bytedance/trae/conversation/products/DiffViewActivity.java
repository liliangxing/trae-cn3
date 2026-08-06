package com.bytedance.trae.conversation.products;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.renderer.FileTreeBottomSheetFragment;
import com.bytedance.trae.conversation.fileupload.ResourceUploadUtilKt;
import com.bytedance.trae.im.model.ChangedFileData;
import com.bytedance.trae.im.model.FileDiffInfo;
import com.bytedance.trae.im.service.DiffViewResponse;
import com.bytedance.trae.im.service.GetDownloadUrlData;
import com.bytedance.trae.im.service.GetDownloadUrlRequest;
import com.bytedance.trae.im.service.IGetDownloadUrlApi;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.platform.service.ApmService;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* compiled from: DiffViewActivity.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 52\u00020\u0001:\u000256B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0013H\u0002J(\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0013H\u0002J\u001e\u0010 \u001a\u00020\u00162\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010\u001f\u001a\u00020\u0013H\u0002J\b\u0010$\u001a\u00020\u0016H\u0002J\u0018\u0010%\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001a\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010&J&\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010)J\u001a\u0010*\u001a\u0004\u0018\u00010\u00132\u0006\u0010+\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u00101\u001a\u00020#H\u0002J\u0010\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u0013H\u0002J\b\u00104\u001a\u00020\u0016H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/bytedance/trae/conversation/products/DiffViewActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "webView", "Landroid/webkit/WebView;", "progressBar", "Landroid/widget/ProgressBar;", "layoutError", "Landroid/widget/LinearLayout;", "btnRetry", "Landroid/view/View;", "ivBack", "tvTitle", "Landroid/widget/TextView;", "diffFiles", "", "Lcom/bytedance/trae/im/model/FileDiffInfo;", "conversationId", "", "messageId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "scrollWebViewToFile", "filePath", "loadDiffView", "cliType", "chatSessionId", "turnId", "taskName", "handleDiffViewResult", "result", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/im/service/DiffViewResponse;", "showDiffError", "fetchDownloadUrlWithRetry", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadDiffFromUrl", "downloadUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchJsonViaTTNet", IWeixinService.ResponseConstants.URL, "readAllBytes", "", "input", "Ljava/io/InputStream;", "collectDiffFilesFromResponse", "response", "decodeContentString", "encoded", "onDestroy", "Companion", "DiffFetchApi", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DiffViewActivity extends TraeCommonAppCompatActivity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DOWNLOAD_URL_MAX_RETRIES = 3;
    private static final long DOWNLOAD_URL_RETRY_DELAY_MS = 500;
    private static final String EVENT_DIFF_VIEW_RESULT = "diff_view_result";
    private static final String EVENT_FETCH_DOWNLOAD_URL = "diff_view_fetch_download_url";
    private static final String EXTRA_CHAT_SESSION_ID = "extra_chat_session_id";
    private static final String EXTRA_CLI_TYPE = "extra_cli_type";
    private static final String EXTRA_CONVERSATION_ID = "extra_conversation_id";
    private static final String EXTRA_MESSAGE_ID = "extra_message_id";
    private static final String EXTRA_TASK_NAME = "extra_task_name";
    private static final String EXTRA_TURN_ID = "extra_turn_id";
    private View btnRetry;
    private View ivBack;
    private LinearLayout layoutError;
    private ProgressBar progressBar;
    private TextView tvTitle;
    private WebView webView;
    private List<FileDiffInfo> diffFiles = CollectionsKt.emptyList();
    private String conversationId = "";
    private String messageId = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiffViewActivity.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bb\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/conversation/products/DiffViewActivity$DiffFetchApi;", "", ApiRequest.METHOD_GET, "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", IWeixinService.ResponseConstants.URL, "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface DiffFetchApi {
        @GET
        Call<TypedInput> get(@Url String url);
    }

    /* renamed from: com_bytedance_trae_conversation_products_DiffViewActivity__onStop$___twin___ */
    public void m844x54decd38() {
        super.onStop();
    }

    protected void onStop() {
        m843x469c47c3(this);
    }

    /* compiled from: DiffViewActivity.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JL\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/products/DiffViewActivity$Companion;", "", "<init>", "()V", "EXTRA_TASK_NAME", "", "EXTRA_CHAT_SESSION_ID", "EXTRA_TURN_ID", "EXTRA_CLI_TYPE", "EXTRA_CONVERSATION_ID", "EXTRA_MESSAGE_ID", "DOWNLOAD_URL_MAX_RETRIES", "", "DOWNLOAD_URL_RETRY_DELAY_MS", "", "EVENT_FETCH_DOWNLOAD_URL", "EVENT_DIFF_VIEW_RESULT", "start", "", "context", "Landroid/content/Context;", "taskName", "chatSessionId", "turnId", "cliType", "conversationId", "messageId", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context, String taskName, String chatSessionId, String turnId, String cliType, String conversationId, String messageId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(taskName, "taskName");
            Intrinsics.checkNotNullParameter(chatSessionId, "chatSessionId");
            Intrinsics.checkNotNullParameter(turnId, "turnId");
            Intrinsics.checkNotNullParameter(cliType, "cliType");
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            Intent intent = new Intent(context, (Class<?>) DiffViewActivity.class);
            intent.putExtra(DiffViewActivity.EXTRA_TASK_NAME, taskName);
            intent.putExtra(DiffViewActivity.EXTRA_CHAT_SESSION_ID, chatSessionId);
            intent.putExtra(DiffViewActivity.EXTRA_TURN_ID, turnId);
            intent.putExtra(DiffViewActivity.EXTRA_CLI_TYPE, cliType);
            intent.putExtra("extra_conversation_id", conversationId);
            intent.putExtra(DiffViewActivity.EXTRA_MESSAGE_ID, messageId);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0637R.layout.trae_activity_diff_view);
        View findViewById = findViewById(C0637R.id.webview_diff);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.webView = (WebView) findViewById;
        View findViewById2 = findViewById(C0637R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.progressBar = (ProgressBar) findViewById2;
        View findViewById3 = findViewById(C0637R.id.layout_error);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.layoutError = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(C0637R.id.btn_retry);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.btnRetry = findViewById4;
        View findViewById5 = findViewById(C0637R.id.btn_back);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.ivBack = findViewById5;
        View findViewById6 = findViewById(C0637R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.tvTitle = (TextView) findViewById6;
        ViewCompat.setOnApplyWindowInsetsListener((Toolbar) findViewById(C0637R.id.toolbar), new OnApplyWindowInsetsListener() { // from class: com.bytedance.trae.conversation.products.DiffViewActivity$$ExternalSyntheticLambda1
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat onCreate$lambda$0;
                onCreate$lambda$0 = DiffViewActivity.onCreate$lambda$0(view, windowInsetsCompat);
                return onCreate$lambda$0;
            }
        });
        View view = this.ivBack;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.DiffViewActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                DiffViewActivity.this.finish();
            }
        });
        findViewById(C0637R.id.btn_extend).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.DiffViewActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                DiffViewActivity.onCreate$lambda$3(DiffViewActivity.this, view3);
            }
        });
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.setWebChromeClient(new WebChromeClient() { // from class: com.bytedance.trae.conversation.products.DiffViewActivity$onCreate$4
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view3, int newProgress) {
                ProgressBar progressBar;
                WebView webView2;
                Intrinsics.checkNotNullParameter(view3, "view");
                if (newProgress == 100) {
                    progressBar = DiffViewActivity.this.progressBar;
                    WebView webView3 = null;
                    if (progressBar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                        progressBar = null;
                    }
                    progressBar.setVisibility(8);
                    webView2 = DiffViewActivity.this.webView;
                    if (webView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("webView");
                    } else {
                        webView3 = webView2;
                    }
                    webView3.setVisibility(0);
                }
            }
        });
        String stringExtra = getIntent().getStringExtra(EXTRA_TASK_NAME);
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = getIntent().getStringExtra(EXTRA_CHAT_SESSION_ID);
        String str = stringExtra2 == null ? "" : stringExtra2;
        String stringExtra3 = getIntent().getStringExtra(EXTRA_TURN_ID);
        String str2 = stringExtra3 == null ? "" : stringExtra3;
        String stringExtra4 = getIntent().getStringExtra(EXTRA_CLI_TYPE);
        String str3 = stringExtra4 == null ? "" : stringExtra4;
        String stringExtra5 = getIntent().getStringExtra(EXTRA_MESSAGE_ID);
        if (stringExtra5 == null) {
            stringExtra5 = "";
        }
        this.messageId = stringExtra5;
        String stringExtra6 = getIntent().getStringExtra("extra_conversation_id");
        this.conversationId = stringExtra6 != null ? stringExtra6 : "";
        View view3 = this.btnRetry;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnRetry");
        } else {
            view2 = view3;
        }
        final String str4 = str3;
        final String str5 = str;
        final String str6 = str2;
        final String str7 = stringExtra;
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.DiffViewActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                DiffViewActivity.this.loadDiffView(str4, str5, str6, str7);
            }
        });
        loadDiffView(str3, str, str2, stringExtra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onCreate$lambda$0(View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(view, "v");
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "insets");
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.statusBars());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        view.setPadding(view.getPaddingLeft(), insets.top, view.getPaddingRight(), view.getPaddingBottom());
        return windowInsetsCompat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(final DiffViewActivity diffViewActivity, View view) {
        if (!diffViewActivity.diffFiles.isEmpty()) {
            FileTreeBottomSheetFragment.INSTANCE.newInstance(diffViewActivity.diffFiles, new Function1() { // from class: com.bytedance.trae.conversation.products.DiffViewActivity$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit onCreate$lambda$3$lambda$2;
                    onCreate$lambda$3$lambda$2 = DiffViewActivity.onCreate$lambda$3$lambda$2(DiffViewActivity.this, (String) obj);
                    return onCreate$lambda$3$lambda$2;
                }
            }).show(diffViewActivity.getSupportFragmentManager(), "FileTreeBottomSheet");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$3$lambda$2(DiffViewActivity diffViewActivity, String str) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        diffViewActivity.scrollWebViewToFile(str);
        return Unit.INSTANCE;
    }

    private final void scrollWebViewToFile(String filePath) {
        String replace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(filePath, "\\", "\\\\", false, 4, (Object) null), "'", "\\'", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null);
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.evaluateJavascript("scrollToFile('" + replace$default + "')", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadDiffView(String cliType, String chatSessionId, String turnId, String taskName) {
        LinearLayout linearLayout = this.layoutError;
        ProgressBar progressBar = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutError");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.setVisibility(8);
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        } else {
            progressBar = progressBar2;
        }
        progressBar.setVisibility(0);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new DiffViewActivity$loadDiffView$1(cliType, turnId, this, taskName, chatSessionId, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleDiffViewResult(HttpDataResult<DiffViewResponse> result, String taskName) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("conversation_id", this.conversationId);
        jSONObject.put("message_id", this.messageId);
        WebView webView = null;
        if (result instanceof HttpDataResult.Success) {
            DiffViewResponse diffViewResponse = (DiffViewResponse) ((HttpDataResult.Success) result).getBizResp().getData();
            if (diffViewResponse != null) {
                this.diffFiles = collectDiffFilesFromResponse(diffViewResponse);
                DiffViewerHelper diffViewerHelper = DiffViewerHelper.INSTANCE;
                WebView webView2 = this.webView;
                if (webView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                } else {
                    webView = webView2;
                }
                diffViewerHelper.showDiff(webView, this.diffFiles, taskName);
                try {
                    Result.Companion companion = Result.Companion;
                    DiffViewActivity diffViewActivity = this;
                    ApmService apmService = ApmService.INSTANCE;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(PageDataManager.EXTRA_STATUS, "success");
                    jSONObject2.put(DBData.FIELD_TYPE, "remote");
                    Unit unit = Unit.INSTANCE;
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("size", this.diffFiles.size());
                    Unit unit2 = Unit.INSTANCE;
                    apmService.monitorEventForSlardar(EVENT_DIFF_VIEW_RESULT, jSONObject2, jSONObject3, jSONObject);
                    Result.constructor-impl(Unit.INSTANCE);
                    return;
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                    return;
                }
            }
            try {
                Result.Companion companion3 = Result.Companion;
                DiffViewActivity diffViewActivity2 = this;
                ApmService apmService2 = ApmService.INSTANCE;
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(PageDataManager.EXTRA_STATUS, "fail");
                jSONObject4.put("reason", "empty_data");
                jSONObject4.put(DBData.FIELD_TYPE, "remote");
                Unit unit3 = Unit.INSTANCE;
                jSONObject.put("biz_code", String.valueOf(((HttpDataResult.Success) result).getBizResp().getCode()));
                Unit unit4 = Unit.INSTANCE;
                apmService2.monitorEventForSlardar(EVENT_DIFF_VIEW_RESULT, jSONObject4, (JSONObject) null, jSONObject);
                Result.constructor-impl(Unit.INSTANCE);
                return;
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th2));
                return;
            }
        }
        if (!(result instanceof HttpDataResult.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        WebView webView3 = this.webView;
        if (webView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView3 = null;
        }
        webView3.setVisibility(8);
        LinearLayout linearLayout = this.layoutError;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutError");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        try {
            Result.Companion companion5 = Result.Companion;
            DiffViewActivity diffViewActivity3 = this;
            ApmService apmService3 = ApmService.INSTANCE;
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(PageDataManager.EXTRA_STATUS, "fail");
            jSONObject5.put("reason", "request_error");
            jSONObject5.put(DBData.FIELD_TYPE, "remote");
            jSONObject5.put("error_code", String.valueOf(((HttpDataResult.Error) result).getCode()));
            Unit unit5 = Unit.INSTANCE;
            jSONObject.put("error_message", ((HttpDataResult.Error) result).getMsg());
            Unit unit6 = Unit.INSTANCE;
            apmService3.monitorEventForSlardar(EVENT_DIFF_VIEW_RESULT, jSONObject5, (JSONObject) null, jSONObject);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th3) {
            Result.Companion companion6 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDiffError() {
        ProgressBar progressBar = this.progressBar;
        LinearLayout linearLayout = null;
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
        LinearLayout linearLayout2 = this.layoutError;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutError");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0034  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0132 -> B:11:0x0135). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0137 -> B:11:0x0135). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchDownloadUrlWithRetry(String str, Continuation<? super String> continuation) {
        DiffViewActivity$fetchDownloadUrlWithRetry$1 diffViewActivity$fetchDownloadUrlWithRetry$1;
        int i;
        Function0 function0;
        final String str2;
        int i2;
        DiffViewActivity diffViewActivity;
        String str3;
        Function0 function02;
        DiffViewActivity diffViewActivity2;
        int i3;
        HttpDataResult.Success success;
        Map<String, String> urlMap;
        if (continuation instanceof DiffViewActivity$fetchDownloadUrlWithRetry$1) {
            diffViewActivity$fetchDownloadUrlWithRetry$1 = (DiffViewActivity$fetchDownloadUrlWithRetry$1) continuation;
            if ((diffViewActivity$fetchDownloadUrlWithRetry$1.label & Integer.MIN_VALUE) != 0) {
                diffViewActivity$fetchDownloadUrlWithRetry$1.label -= Integer.MIN_VALUE;
                Object obj = diffViewActivity$fetchDownloadUrlWithRetry$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = diffViewActivity$fetchDownloadUrlWithRetry$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    str2 = str;
                    function0 = new Function0() { // from class: com.bytedance.trae.conversation.products.DiffViewActivity$$ExternalSyntheticLambda6
                        public final Object invoke() {
                            JSONObject fetchDownloadUrlWithRetry$lambda$16;
                            fetchDownloadUrlWithRetry$lambda$16 = DiffViewActivity.fetchDownloadUrlWithRetry$lambda$16(DiffViewActivity.this, str2);
                            return fetchDownloadUrlWithRetry$lambda$16;
                        }
                    };
                    i2 = 0;
                    diffViewActivity = this;
                    if (i2 < 4) {
                    }
                } else if (i == 1) {
                    i3 = diffViewActivity$fetchDownloadUrlWithRetry$1.I$0;
                    Function0 function03 = (Function0) diffViewActivity$fetchDownloadUrlWithRetry$1.L$2;
                    String str4 = (String) diffViewActivity$fetchDownloadUrlWithRetry$1.L$1;
                    DiffViewActivity diffViewActivity3 = (DiffViewActivity) diffViewActivity$fetchDownloadUrlWithRetry$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    function02 = function03;
                    diffViewActivity2 = diffViewActivity3;
                    str3 = str4;
                    success = (HttpDataResult) obj;
                    if (!(success instanceof HttpDataResult.Success)) {
                    }
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i3 = diffViewActivity$fetchDownloadUrlWithRetry$1.I$0;
                    function02 = (Function0) diffViewActivity$fetchDownloadUrlWithRetry$1.L$2;
                    str3 = (String) diffViewActivity$fetchDownloadUrlWithRetry$1.L$1;
                    diffViewActivity2 = (DiffViewActivity) diffViewActivity$fetchDownloadUrlWithRetry$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    char c = 2;
                    function0 = function02;
                    diffViewActivity = diffViewActivity2;
                    i2 = i3 + 1;
                    str2 = str3;
                    if (i2 < 4) {
                        IGetDownloadUrlApi.Companion companion = IGetDownloadUrlApi.INSTANCE;
                        GetDownloadUrlRequest getDownloadUrlRequest = new GetDownloadUrlRequest(CollectionsKt.listOf(str2), diffViewActivity.conversationId, diffViewActivity.messageId, null, 8, null);
                        diffViewActivity$fetchDownloadUrlWithRetry$1.L$0 = diffViewActivity;
                        diffViewActivity$fetchDownloadUrlWithRetry$1.L$1 = str2;
                        diffViewActivity$fetchDownloadUrlWithRetry$1.L$2 = function0;
                        diffViewActivity$fetchDownloadUrlWithRetry$1.I$0 = i2;
                        diffViewActivity$fetchDownloadUrlWithRetry$1.label = 1;
                        Object downloadUrlRawCall = companion.getDownloadUrlRawCall(getDownloadUrlRequest, diffViewActivity$fetchDownloadUrlWithRetry$1);
                        if (downloadUrlRawCall == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str3 = str2;
                        i3 = i2;
                        diffViewActivity2 = diffViewActivity;
                        function02 = function0;
                        obj = downloadUrlRawCall;
                        success = (HttpDataResult) obj;
                        if (!(success instanceof HttpDataResult.Success)) {
                            HttpDataResult.Success success2 = success;
                            GetDownloadUrlData getDownloadUrlData = (GetDownloadUrlData) success2.getBizResp().getData();
                            String str5 = (getDownloadUrlData == null || (urlMap = getDownloadUrlData.getUrlMap()) == null) ? null : urlMap.get(str3);
                            if (str5 != null) {
                                try {
                                    Result.Companion companion2 = Result.Companion;
                                    DiffViewActivity diffViewActivity4 = diffViewActivity2;
                                    ApmService apmService = ApmService.INSTANCE;
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put(PageDataManager.EXTRA_STATUS, "success");
                                    jSONObject.put(DBData.FIELD_TYPE, "local");
                                    Unit unit = Unit.INSTANCE;
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("attempt", i3);
                                    Unit unit2 = Unit.INSTANCE;
                                    apmService.monitorEventForSlardar(EVENT_FETCH_DOWNLOAD_URL, jSONObject, jSONObject2, (JSONObject) function02.invoke());
                                    Result.constructor-impl(Unit.INSTANCE);
                                } catch (Throwable th) {
                                    Result.Companion companion3 = Result.Companion;
                                    Result.constructor-impl(ResultKt.createFailure(th));
                                }
                                return str5;
                            }
                            long code = success2.getBizResp().getCode();
                            if (code != 202) {
                                try {
                                    Result.Companion companion4 = Result.Companion;
                                    DiffViewActivity diffViewActivity5 = diffViewActivity2;
                                    ApmService apmService2 = ApmService.INSTANCE;
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put(PageDataManager.EXTRA_STATUS, "fail");
                                    jSONObject3.put("reason", "unexpected_code");
                                    jSONObject3.put(DBData.FIELD_TYPE, "local");
                                    Unit unit3 = Unit.INSTANCE;
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put("attempt", i3);
                                    Unit unit4 = Unit.INSTANCE;
                                    Object invoke = function02.invoke();
                                    ((JSONObject) invoke).put("biz_code", String.valueOf(code));
                                    Unit unit5 = Unit.INSTANCE;
                                    apmService2.monitorEventForSlardar(EVENT_FETCH_DOWNLOAD_URL, jSONObject3, jSONObject4, (JSONObject) invoke);
                                    Result.constructor-impl(Unit.INSTANCE);
                                    return null;
                                } catch (Throwable th2) {
                                    Result.Companion companion5 = Result.Companion;
                                    Result.constructor-impl(ResultKt.createFailure(th2));
                                    return null;
                                }
                            }
                            if (i3 < 3) {
                                diffViewActivity$fetchDownloadUrlWithRetry$1.L$0 = diffViewActivity2;
                                diffViewActivity$fetchDownloadUrlWithRetry$1.L$1 = str3;
                                diffViewActivity$fetchDownloadUrlWithRetry$1.L$2 = function02;
                                diffViewActivity$fetchDownloadUrlWithRetry$1.I$0 = i3;
                                c = 2;
                                diffViewActivity$fetchDownloadUrlWithRetry$1.label = 2;
                                if (DelayKt.delay(500L, diffViewActivity$fetchDownloadUrlWithRetry$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                c = 2;
                            }
                            function0 = function02;
                            diffViewActivity = diffViewActivity2;
                            i2 = i3 + 1;
                            str2 = str3;
                            if (i2 < 4) {
                                try {
                                    Result.Companion companion6 = Result.Companion;
                                    DiffViewActivity diffViewActivity6 = diffViewActivity;
                                    ApmService apmService3 = ApmService.INSTANCE;
                                    JSONObject jSONObject5 = new JSONObject();
                                    jSONObject5.put(PageDataManager.EXTRA_STATUS, "fail");
                                    jSONObject5.put("reason", "retry_exhausted");
                                    Unit unit6 = Unit.INSTANCE;
                                    JSONObject jSONObject6 = new JSONObject();
                                    jSONObject6.put("attempt", 3);
                                    Unit unit7 = Unit.INSTANCE;
                                    apmService3.monitorEventForSlardar(EVENT_FETCH_DOWNLOAD_URL, jSONObject5, jSONObject6, (JSONObject) function0.invoke());
                                    Result.constructor-impl(Unit.INSTANCE);
                                    return null;
                                } catch (Throwable th3) {
                                    Result.Companion companion7 = Result.Companion;
                                    Result.constructor-impl(ResultKt.createFailure(th3));
                                    return null;
                                }
                            }
                        } else {
                            if (!(success instanceof HttpDataResult.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            try {
                                Result.Companion companion8 = Result.Companion;
                                DiffViewActivity diffViewActivity7 = diffViewActivity2;
                                ApmService apmService4 = ApmService.INSTANCE;
                                JSONObject jSONObject7 = new JSONObject();
                                jSONObject7.put(PageDataManager.EXTRA_STATUS, "fail");
                                jSONObject7.put("reason", "request_error");
                                jSONObject7.put(DBData.FIELD_TYPE, "local");
                                jSONObject7.put("error_code", String.valueOf(((HttpDataResult.Error) success).getCode()));
                                Unit unit8 = Unit.INSTANCE;
                                JSONObject jSONObject8 = new JSONObject();
                                jSONObject8.put("attempt", i3);
                                Unit unit9 = Unit.INSTANCE;
                                Object invoke2 = function02.invoke();
                                ((JSONObject) invoke2).put("error_message", ((HttpDataResult.Error) success).getMsg());
                                Unit unit10 = Unit.INSTANCE;
                                apmService4.monitorEventForSlardar(EVENT_FETCH_DOWNLOAD_URL, jSONObject7, jSONObject8, (JSONObject) invoke2);
                                Result.constructor-impl(Unit.INSTANCE);
                                return null;
                            } catch (Throwable th4) {
                                Result.Companion companion9 = Result.Companion;
                                Result.constructor-impl(ResultKt.createFailure(th4));
                                return null;
                            }
                        }
                    }
                }
            }
        }
        diffViewActivity$fetchDownloadUrlWithRetry$1 = new DiffViewActivity$fetchDownloadUrlWithRetry$1(this, continuation);
        Object obj2 = diffViewActivity$fetchDownloadUrlWithRetry$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = diffViewActivity$fetchDownloadUrlWithRetry$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject fetchDownloadUrlWithRetry$lambda$16(DiffViewActivity diffViewActivity, String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("conversation_id", diffViewActivity.conversationId);
        jSONObject.put("message_id", diffViewActivity.messageId);
        jSONObject.put("file_path", str);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadDiffFromUrl(final String str, String str2, String str3, Continuation<? super Unit> continuation) {
        DiffViewActivity$loadDiffFromUrl$1 diffViewActivity$loadDiffFromUrl$1;
        int i;
        Function0 function0;
        Object withContext;
        String str4;
        DiffViewActivity diffViewActivity;
        String str5;
        Object obj;
        FileDiffInfo copy;
        if (continuation instanceof DiffViewActivity$loadDiffFromUrl$1) {
            diffViewActivity$loadDiffFromUrl$1 = (DiffViewActivity$loadDiffFromUrl$1) continuation;
            if ((diffViewActivity$loadDiffFromUrl$1.label & Integer.MIN_VALUE) != 0) {
                diffViewActivity$loadDiffFromUrl$1.label -= Integer.MIN_VALUE;
                Object obj2 = diffViewActivity$loadDiffFromUrl$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = diffViewActivity$loadDiffFromUrl$1.label;
                WebView webView = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    function0 = new Function0() { // from class: com.bytedance.trae.conversation.products.DiffViewActivity$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            JSONObject loadDiffFromUrl$lambda$32;
                            loadDiffFromUrl$lambda$32 = DiffViewActivity.loadDiffFromUrl$lambda$32(DiffViewActivity.this, str);
                            return loadDiffFromUrl$lambda$32;
                        }
                    };
                    CoroutineContext io = Dispatchers.getIO();
                    DiffViewActivity$loadDiffFromUrl$json$1 diffViewActivity$loadDiffFromUrl$json$1 = new DiffViewActivity$loadDiffFromUrl$json$1(this, str, str2, null);
                    diffViewActivity$loadDiffFromUrl$1.L$0 = this;
                    diffViewActivity$loadDiffFromUrl$1.L$1 = str3;
                    diffViewActivity$loadDiffFromUrl$1.L$2 = function0;
                    diffViewActivity$loadDiffFromUrl$1.label = 1;
                    withContext = BuildersKt.withContext(io, diffViewActivity$loadDiffFromUrl$json$1, diffViewActivity$loadDiffFromUrl$1);
                    if (withContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str4 = str3;
                    diffViewActivity = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Function0 function02 = (Function0) diffViewActivity$loadDiffFromUrl$1.L$2;
                    str4 = (String) diffViewActivity$loadDiffFromUrl$1.L$1;
                    DiffViewActivity diffViewActivity2 = (DiffViewActivity) diffViewActivity$loadDiffFromUrl$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    diffViewActivity = diffViewActivity2;
                    withContext = obj2;
                    function0 = function02;
                }
                str5 = (String) withContext;
                if (str5 != null) {
                    try {
                        Result.Companion companion = Result.Companion;
                        DiffViewActivity diffViewActivity3 = diffViewActivity;
                        ApmService apmService = ApmService.INSTANCE;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(PageDataManager.EXTRA_STATUS, "fail");
                        jSONObject.put("reason", "fetch_json_failed");
                        jSONObject.put(DBData.FIELD_TYPE, "local");
                        Unit unit = Unit.INSTANCE;
                        apmService.monitorEventForSlardar(EVENT_DIFF_VIEW_RESULT, jSONObject, (JSONObject) null, (JSONObject) function0.invoke());
                        Result.constructor-impl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    diffViewActivity.showDiffError();
                    return Unit.INSTANCE;
                }
                try {
                    Result.Companion companion3 = Result.Companion;
                    DiffViewActivity diffViewActivity4 = diffViewActivity;
                    obj = Result.constructor-impl((DiffViewResponse) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(str5, DiffViewResponse.class));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th2));
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                DiffViewResponse diffViewResponse = (DiffViewResponse) obj;
                if (diffViewResponse == null) {
                    try {
                        Result.Companion companion5 = Result.Companion;
                        DiffViewActivity diffViewActivity5 = diffViewActivity;
                        ApmService apmService2 = ApmService.INSTANCE;
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(PageDataManager.EXTRA_STATUS, "fail");
                        jSONObject2.put("reason", "json_parse_failed");
                        jSONObject2.put(DBData.FIELD_TYPE, "local");
                        Unit unit2 = Unit.INSTANCE;
                        apmService2.monitorEventForSlardar(EVENT_DIFF_VIEW_RESULT, jSONObject2, (JSONObject) null, (JSONObject) function0.invoke());
                        Result.constructor-impl(Unit.INSTANCE);
                    } catch (Throwable th3) {
                        Result.Companion companion6 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th3));
                    }
                    diffViewActivity.showDiffError();
                    return Unit.INSTANCE;
                }
                List<FileDiffInfo> collectDiffFilesFromResponse = diffViewActivity.collectDiffFilesFromResponse(diffViewResponse);
                diffViewActivity.diffFiles = collectDiffFilesFromResponse;
                List<FileDiffInfo> list = collectDiffFilesFromResponse;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (FileDiffInfo fileDiffInfo : list) {
                    copy = fileDiffInfo.copy((r18 & 1) != 0 ? fileDiffInfo.insertLineCount : null, (r18 & 2) != 0 ? fileDiffInfo.deleteLineCount : null, (r18 & 4) != 0 ? fileDiffInfo.filePath : null, (r18 & 8) != 0 ? fileDiffInfo.fileAction : null, (r18 & 16) != 0 ? fileDiffInfo.beforeContent : fileDiffInfo.getBeforeContent(), (r18 & 32) != 0 ? fileDiffInfo.afterContent : fileDiffInfo.getAfterContent(), (r18 & 64) != 0 ? fileDiffInfo.isConflict : null, (r18 & 128) != 0 ? fileDiffInfo.htmlRender : null);
                    arrayList.add(copy);
                }
                diffViewActivity.diffFiles = arrayList;
                DiffViewerHelper diffViewerHelper = DiffViewerHelper.INSTANCE;
                WebView webView2 = diffViewActivity.webView;
                if (webView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                } else {
                    webView = webView2;
                }
                diffViewerHelper.showDiff(webView, diffViewActivity.diffFiles, str4);
                try {
                    Result.Companion companion7 = Result.Companion;
                    DiffViewActivity diffViewActivity6 = diffViewActivity;
                    ApmService apmService3 = ApmService.INSTANCE;
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(PageDataManager.EXTRA_STATUS, "success");
                    jSONObject3.put(DBData.FIELD_TYPE, "local");
                    Unit unit3 = Unit.INSTANCE;
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("size", diffViewActivity.diffFiles.size());
                    Unit unit4 = Unit.INSTANCE;
                    apmService3.monitorEventForSlardar(EVENT_DIFF_VIEW_RESULT, jSONObject3, jSONObject4, (JSONObject) function0.invoke());
                    Result.constructor-impl(Unit.INSTANCE);
                } catch (Throwable th4) {
                    Result.Companion companion8 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th4));
                }
                return Unit.INSTANCE;
            }
        }
        diffViewActivity$loadDiffFromUrl$1 = new DiffViewActivity$loadDiffFromUrl$1(this, continuation);
        Object obj22 = diffViewActivity$loadDiffFromUrl$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = diffViewActivity$loadDiffFromUrl$1.label;
        WebView webView3 = null;
        if (i != 0) {
        }
        str5 = (String) withContext;
        if (str5 != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject loadDiffFromUrl$lambda$32(DiffViewActivity diffViewActivity, String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("conversation_id", diffViewActivity.conversationId);
        jSONObject.put("message_id", diffViewActivity.messageId);
        jSONObject.put("download_url", str);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String fetchJsonViaTTNet(String url, String cliType) {
        DiffFetchApi diffFetchApi = (DiffFetchApi) RetrofitUtils.createSsRetrofit("https://placeholder.trae/", CollectionsKt.emptyList(), (Converter.Factory) null).create(DiffFetchApi.class);
        if (diffFetchApi == null) {
            return null;
        }
        SsResponse execute = diffFetchApi.get(url).execute();
        Intrinsics.checkNotNullExpressionValue(execute, "execute(...)");
        TypedInput typedInput = (TypedInput) execute.body();
        if (typedInput == null) {
            return null;
        }
        InputStream in = typedInput.in();
        Intrinsics.checkNotNullExpressionValue(in, "in(...)");
        return new String(ResourceUploadUtilKt.decodeContent(readAllBytes(in)), Charsets.UTF_8);
    }

    private final byte[] readAllBytes(InputStream input) {
        InputStream inputStream = input;
        try {
            InputStream inputStream2 = inputStream;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[FConstants.DOWNLOAD_BUFFER_SIZE];
            while (true) {
                int read = inputStream2.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
                    CloseableKt.closeFinally(inputStream, (Throwable) null);
                    return byteArray;
                }
            }
        } finally {
        }
    }

    private final List<FileDiffInfo> collectDiffFilesFromResponse(DiffViewResponse response) {
        ChangedFileData changedCodes = response.getChangedCodes();
        return CollectionsKt.flatten(CollectionsKt.listOfNotNull(changedCodes != null ? changedCodes.getFileDiffInfos() : null));
    }

    private final String decodeContentString(String encoded) {
        try {
            byte[] decode = Base64.decode(encoded, 0);
            Intrinsics.checkNotNull(decode);
            return new String(ResourceUploadUtilKt.decodeContent(decode), Charsets.UTF_8);
        } catch (Exception unused) {
            return encoded;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onDestroy() {
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.destroy();
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_conversation_products_DiffViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m843x469c47c3(DiffViewActivity diffViewActivity) {
        diffViewActivity.m844x54decd38();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) diffViewActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
