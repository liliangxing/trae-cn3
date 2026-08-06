package com.bytedance.trae.conversation.products;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.common.widget.ContextMenuPopupWindow;
import com.bytedance.trae.common.widget.CustomToast;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.CliListRepository;
import com.bytedance.trae.conversation.network.IdeVersionComparator;
import com.bytedance.trae.conversation.products.HtmlArtifactDownloadTarget;
import com.bytedance.trae.conversation.products.ShareLinkBottomSheet;
import com.bytedance.trae.im.service.Cli;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.GetDownloadUrlData;
import com.bytedance.trae.im.service.GetDownloadUrlRequest;
import com.bytedance.trae.im.service.IGetDownloadUrlApi;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.AccountType;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.platform.service.ApmService;
import com.bytedance.trae.settings.api.feature.Feature;
import com.bytedance.trae.settings.api.feature.FeatureCapability;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* compiled from: HtmlArtifactPreviewActivity.kt */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 a2\u00020\u0001:\u0001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'H\u0002J\u0012\u0010/\u001a\u00020$2\b\u00100\u001a\u0004\u0018\u000101H\u0014J\u0010\u00102\u001a\u00020'2\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u00020.H\u0002J\b\u00108\u001a\u00020.H\u0002J0\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u00122\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010=\u001a\u0004\u0018\u000106H\u0002J\u0012\u0010>\u001a\u00020$2\b\b\u0002\u0010?\u001a\u00020@H\u0002J\u0018\u0010A\u001a\u0004\u0018\u00010\u00122\u0006\u0010?\u001a\u00020@H\u0082@¢\u0006\u0002\u0010BJ\u0018\u0010C\u001a\u0004\u0018\u00010\u00122\u0006\u0010D\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010EJ\u0016\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010EJ\u0018\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020\u001a2\u0006\u0010K\u001a\u00020\u001aH\u0002J\u0018\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00020\u001a2\u0006\u0010N\u001a\u00020\u001aH\u0002J\u0010\u0010O\u001a\u00020$2\u0006\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020$H\u0002J\b\u0010S\u001a\u00020$H\u0002J\b\u0010T\u001a\u00020$H\u0002J\b\u0010U\u001a\u00020$H\u0002J\u0010\u0010V\u001a\u00020@2\u0006\u0010P\u001a\u00020QH\u0002J\b\u0010W\u001a\u00020$H\u0002J\u0010\u0010X\u001a\u00020$2\u0006\u0010Y\u001a\u00020'H\u0002J\b\u0010Z\u001a\u00020$H\u0002J\b\u0010[\u001a\u00020$H\u0002J\u001c\u0010\\\u001a\u00020'2\b\u0010]\u001a\u0004\u0018\u00010\u00122\b\u0010^\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010_\u001a\u00020$2\u0006\u0010N\u001a\u00020\u001aH\u0002J\b\u0010`\u001a\u00020$H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010!\u001a\u001a\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020$0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "titleBar", "Lcom/bytedance/trae/common/widget/TraeTitleBar;", "progressBar", "Landroid/view/View;", "loadingIcon", "Landroid/widget/ImageView;", "webView", "Landroid/webkit/WebView;", "layoutContent", "Landroid/widget/LinearLayout;", "btnMainDownload", "Landroid/widget/TextView;", "downloadStatusTitle", "chatSessionId", "", "cliType", "path", "downloadTarget", "Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;", "messageId", "conversationId", "archiveCacheFile", "Ljava/io/File;", "createdTime", "", "cliId", "realPath", "existingShareUrl", "existingShareId", "downloadFinishCallback", "Lkotlin/Function3;", "", "", "trackDownloadZip", "isSuccess", "", "fileDownloadHelper", "Lcom/bytedance/trae/conversation/products/FileDownloadHelper;", "remoteArchiveUrlResolver", "Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;", "shareItems", "", "Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "isShareEnable", "setting", "Lcom/bytedance/trae/conversation/products/HtmlShareSettingsItem;", "buildBaseExtraLog", "Lorg/json/JSONObject;", "createShareItem", "createDownloadItem", "reportApm", PageDataManager.EXTRA_STATUS, "step", "reason", "extras", "startDownloadAndPreview", "remoteResolveMode", "Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;", "fetchFileUrl", "(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchDownloadUrlWithRetry", "filePath", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadAndUnzip", "Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult;", IWeixinService.ResponseConstants.URL, "unzipFile", "zipFile", "targetDir", "showWebView", "entryFile", "archiveFile", "showError", "failure", "Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;", "setupDownloadButton", "showExportMenu", "queryExistingShareLink", "createShareLink", "nextResolveModeAfter", "showLoading", "setDownloadEnabled", "enabled", "startLoadingAnimation", "stopLoadingAnimation", "isHtmlShareSupported", "ideVersion", "minSupportedIdeVersion", "saveZipToDevice", "onDestroy", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class HtmlArtifactPreviewActivity extends TraeCommonAppCompatActivity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DOWNLOAD_URL_MAX_RETRIES = 20;
    private static final long DOWNLOAD_URL_RETRY_DELAY_MS = 2000;
    private static final String EVENT_HTML_ARTIFACT_PREVIEW = "html_artifact_preview";
    private static final String EXTRA_CHAT_SESSION_ID = "extra_chat_session_id";
    private static final String EXTRA_CLI_ID = "extra_cli_id";
    private static final String EXTRA_CLI_TYPE = "extra_cli_type";
    private static final String EXTRA_CONVERSATION_ID = "extra_conversation_id";
    private static final String EXTRA_CREATED_TIME = "extra_created_time";
    private static final String EXTRA_MESSAGE_ID = "extra_message_id";
    private static final String EXTRA_PATH = "extra_path";
    private static final String EXTRA_REAL_PATH = "extra_real_path";
    private static final String EXTRA_TURN_ID = "extra_turn_id";
    private static final String TAG = "HtmlArtifactPreview";
    private File archiveCacheFile;
    private TextView btnMainDownload;
    private String chatSessionId;
    private String cliType;
    private String conversationId;
    private long createdTime;
    private TextView downloadStatusTitle;
    private HtmlArtifactDownloadTarget downloadTarget;
    private String existingShareId;
    private String existingShareUrl;
    private LinearLayout layoutContent;
    private ImageView loadingIcon;
    private String messageId;
    private String path;
    private View progressBar;
    private List<ContextMenuPopupWindow.Item> shareItems;
    private TraeTitleBar titleBar;
    private WebView webView;
    private String cliId = "";
    private String realPath = "";
    private final Function3<Integer, String, Long, Unit> downloadFinishCallback = new Function3() { // from class: com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit downloadFinishCallback$lambda$0;
            downloadFinishCallback$lambda$0 = HtmlArtifactPreviewActivity.downloadFinishCallback$lambda$0(HtmlArtifactPreviewActivity.this, ((Integer) obj).intValue(), (String) obj2, ((Long) obj3).longValue());
            return downloadFinishCallback$lambda$0;
        }
    };
    private final FileDownloadHelper fileDownloadHelper = new FileDownloadHelper();
    private final HtmlArtifactRemoteArchiveUrlResolver remoteArchiveUrlResolver = new HtmlArtifactRemoteArchiveUrlResolver(null, null, 0, null, 15, null);

    /* renamed from: com_bytedance_trae_conversation_products_HtmlArtifactPreviewActivity__onStop$___twin___ */
    public void m846x568514cb() {
        super.onStop();
    }

    protected void onStop() {
        m845x40965010(this);
    }

    /* compiled from: HtmlArtifactPreviewActivity.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jh\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$Companion;", "", "<init>", "()V", "TAG", "", "EXTRA_CHAT_SESSION_ID", "EXTRA_TURN_ID", "EXTRA_CLI_TYPE", "EXTRA_PATH", "EXTRA_MESSAGE_ID", "EXTRA_CONVERSATION_ID", "EXTRA_CREATED_TIME", "EXTRA_CLI_ID", "EXTRA_REAL_PATH", "DOWNLOAD_URL_MAX_RETRIES", "", "DOWNLOAD_URL_RETRY_DELAY_MS", "", "EVENT_HTML_ARTIFACT_PREVIEW", "start", "", "context", "Landroid/content/Context;", "chatSessionId", "turnId", "cliType", "path", "messageId", "conversationId", "createdTime", "cliId", "realPath", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context, String chatSessionId, String turnId, String cliType, String path, String messageId, String conversationId, long createdTime, String cliId, String realPath) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(chatSessionId, "chatSessionId");
            Intrinsics.checkNotNullParameter(turnId, "turnId");
            Intrinsics.checkNotNullParameter(cliType, "cliType");
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            Intrinsics.checkNotNullParameter(conversationId, "conversationId");
            Intrinsics.checkNotNullParameter(cliId, "cliId");
            Intrinsics.checkNotNullParameter(realPath, "realPath");
            Intent intent = new Intent(context, (Class<?>) HtmlArtifactPreviewActivity.class);
            intent.putExtra(HtmlArtifactPreviewActivity.EXTRA_CHAT_SESSION_ID, chatSessionId);
            intent.putExtra(HtmlArtifactPreviewActivity.EXTRA_TURN_ID, turnId);
            intent.putExtra(HtmlArtifactPreviewActivity.EXTRA_CLI_TYPE, cliType);
            intent.putExtra(HtmlArtifactPreviewActivity.EXTRA_PATH, path);
            intent.putExtra(HtmlArtifactPreviewActivity.EXTRA_MESSAGE_ID, messageId);
            intent.putExtra("extra_conversation_id", conversationId);
            intent.putExtra(HtmlArtifactPreviewActivity.EXTRA_CREATED_TIME, createdTime);
            intent.putExtra(HtmlArtifactPreviewActivity.EXTRA_CLI_ID, cliId);
            intent.putExtra(HtmlArtifactPreviewActivity.EXTRA_REAL_PATH, realPath);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit downloadFinishCallback$lambda$0(HtmlArtifactPreviewActivity htmlArtifactPreviewActivity, int i, String str, long j) {
        Intrinsics.checkNotNullParameter(str, "savedPath");
        if (i == 0) {
            htmlArtifactPreviewActivity.trackDownloadZip(true);
            CustomToast.showLong((Context) htmlArtifactPreviewActivity, htmlArtifactPreviewActivity.getString(R.string.trae_doc_preview_download_success) + '\n' + StringsKt.substringBeforeLast$default(str, '/', (String) null, 2, (Object) null));
        } else {
            htmlArtifactPreviewActivity.trackDownloadZip(false);
            CustomToast.showLong((Context) htmlArtifactPreviewActivity, htmlArtifactPreviewActivity.getString(R.string.trae_doc_preview_download_failed));
        }
        return Unit.INSTANCE;
    }

    private final void trackDownloadZip(boolean isSuccess) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (isSuccess) {
                jSONObject.put(PageDataManager.EXTRA_STATUS, "success");
            } else {
                jSONObject.put(PageDataManager.EXTRA_STATUS, "fail");
            }
            String str = this.cliType;
            String str2 = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cliType");
                str = null;
            }
            jSONObject.put("artifact_type", str);
            jSONObject.put("export_format", "zip");
            if (!TextUtils.isEmpty(this.realPath)) {
                StringBuilder sb = new StringBuilder();
                String str3 = this.messageId;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("messageId");
                } else {
                    str2 = str3;
                }
                jSONObject.put("artifact_id", sb.append(str2).append('_').append(this.realPath).toString());
            } else {
                StringBuilder sb2 = new StringBuilder();
                String str4 = this.messageId;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("messageId");
                    str4 = null;
                }
                StringBuilder append = sb2.append(str4).append('_');
                String str5 = this.path;
                if (str5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("path");
                } else {
                    str2 = str5;
                }
                jSONObject.put("artifact_id", append.append(str2).toString());
            }
            IApplog.INSTANCE.reportEvent("icube_artifact_html_export_click", jSONObject);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onCreate(Bundle savedInstanceState) {
        Object obj;
        super.onCreate(savedInstanceState);
        setContentView(C0637R.layout.trae_layout_html_artifact_preview);
        View findViewById = findViewById(C0637R.id.title_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.titleBar = (TraeTitleBar) findViewById;
        View findViewById2 = findViewById(C0637R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.progressBar = findViewById2;
        View findViewById3 = findViewById(C0637R.id.iv_loading);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.loadingIcon = (ImageView) findViewById3;
        View findViewById4 = findViewById(C0637R.id.webview);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.webView = (WebView) findViewById4;
        View findViewById5 = findViewById(C0637R.id.layout_content);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.layoutContent = (LinearLayout) findViewById5;
        View findViewById6 = findViewById(C0637R.id.btn_main_download);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.btnMainDownload = (TextView) findViewById6;
        View findViewById7 = findViewById(C0637R.id.download_status_tile);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.downloadStatusTitle = (TextView) findViewById7;
        String stringExtra = getIntent().getStringExtra(EXTRA_CHAT_SESSION_ID);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.chatSessionId = stringExtra;
        String stringExtra2 = getIntent().getStringExtra(EXTRA_CLI_TYPE);
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.cliType = stringExtra2;
        String stringExtra3 = getIntent().getStringExtra(EXTRA_PATH);
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        this.path = stringExtra3;
        String stringExtra4 = getIntent().getStringExtra(EXTRA_MESSAGE_ID);
        if (stringExtra4 == null) {
            stringExtra4 = "";
        }
        this.messageId = stringExtra4;
        String stringExtra5 = getIntent().getStringExtra("extra_conversation_id");
        if (stringExtra5 == null) {
            stringExtra5 = "";
        }
        this.conversationId = stringExtra5;
        this.createdTime = getIntent().getLongExtra(EXTRA_CREATED_TIME, 0L);
        String stringExtra6 = getIntent().getStringExtra(EXTRA_CLI_ID);
        if (stringExtra6 == null) {
            stringExtra6 = "";
        }
        this.cliId = stringExtra6;
        String stringExtra7 = getIntent().getStringExtra(EXTRA_REAL_PATH);
        this.realPath = stringExtra7 != null ? stringExtra7 : "";
        HtmlArtifactDownloadTarget.Companion companion = HtmlArtifactDownloadTarget.INSTANCE;
        String str = this.path;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("path");
            str = null;
        }
        this.downloadTarget = companion.fromPreviewPath(str);
        HtmlShareSettingsItem htmlShareSettingsItem = HtmlShareSettings.INSTANCE.getHtmlShareSettingsItem();
        if (isShareEnable(htmlShareSettingsItem)) {
            String str2 = this.cliType;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cliType");
                str2 = null;
            }
            if (!Intrinsics.areEqual(str2, CliType.LOCAL.getValue())) {
                this.shareItems = CollectionsKt.listOf(new ContextMenuPopupWindow.Item[]{createShareItem(), createDownloadItem()});
            } else {
                Iterator<T> it = CliListRepository.INSTANCE.getInstance().getCacheClis().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (Intrinsics.areEqual(((Cli) obj).getId(), this.cliId)) {
                            break;
                        }
                    }
                }
                Cli cli = (Cli) obj;
                this.shareItems = isHtmlShareSupported(cli != null ? cli.getIdeVersion() : null, htmlShareSettingsItem.getMinSupportedIdeVersion()) ? CollectionsKt.listOf(new ContextMenuPopupWindow.Item[]{createShareItem(), createDownloadItem()}) : null;
            }
        } else {
            this.shareItems = null;
        }
        List<ContextMenuPopupWindow.Item> list = this.shareItems;
        if ((list != null ? list.size() : 0) > 1) {
            queryExistingShareLink();
        }
        FLogger fLogger = FLogger.INSTANCE;
        StringBuilder sb = new StringBuilder("onCreate: ");
        String str3 = this.chatSessionId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatSessionId");
            str3 = null;
        }
        StringBuilder append = sb.append(str3).append(' ');
        String str4 = this.cliType;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cliType");
            str4 = null;
        }
        StringBuilder append2 = append.append(str4).append(' ');
        String str5 = this.path;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("path");
            str5 = null;
        }
        StringBuilder append3 = append2.append(str5).append(' ');
        String str6 = this.messageId;
        if (str6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageId");
            str6 = null;
        }
        StringBuilder append4 = append3.append(str6).append(' ');
        String str7 = this.conversationId;
        if (str7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("conversationId");
            str7 = null;
        }
        fLogger.d(TAG, append4.append(str7).toString());
        String str8 = this.realPath;
        if ((str8.length() == 0) && (str8 = this.path) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("path");
            str8 = null;
        }
        String substringAfterLast$default = StringsKt.substringAfterLast$default(str8, '/', (String) null, 2, (Object) null);
        TraeTitleBar traeTitleBar = this.titleBar;
        if (traeTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            traeTitleBar = null;
        }
        String str9 = substringAfterLast$default;
        if (str9.length() == 0) {
            str9 = getString(C0637R.string.trae_html_artifact_title_file_management);
            Intrinsics.checkNotNullExpressionValue(str9, "getString(...)");
        }
        traeTitleBar.setTitle(str9);
        TraeTitleBar traeTitleBar2 = this.titleBar;
        if (traeTitleBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            traeTitleBar2 = null;
        }
        traeTitleBar2.setRightActionViewId(0, C0637R.id.btn_download);
        TraeTitleBar traeTitleBar3 = this.titleBar;
        if (traeTitleBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            traeTitleBar3 = null;
        }
        traeTitleBar3.setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HtmlArtifactPreviewActivity.this.finish();
            }
        });
        setupDownloadButton();
        startDownloadAndPreview$default(this, null, 1, null);
    }

    private final JSONObject buildBaseExtraLog() {
        JSONObject jSONObject = new JSONObject();
        String str = this.chatSessionId;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatSessionId");
            str = null;
        }
        jSONObject.put("chat_session_id", str);
        String str3 = this.conversationId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("conversationId");
            str3 = null;
        }
        jSONObject.put("conversation_id", str3);
        String str4 = this.messageId;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageId");
            str4 = null;
        }
        jSONObject.put("message_id", str4);
        String str5 = this.cliType;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cliType");
            str5 = null;
        }
        jSONObject.put("cli_type", str5);
        String str6 = this.path;
        if (str6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("path");
        } else {
            str2 = str6;
        }
        jSONObject.put("path", str2);
        return jSONObject;
    }

    private final ContextMenuPopupWindow.Item createShareItem() {
        int i = C0637R.drawable.trae_ic_chain_link;
        String string = getString(C0637R.string.trae_html_artifact_temporary_link);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return new ContextMenuPopupWindow.Item(i, string, false, null, null, 0, new Function0() { // from class: com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity$$ExternalSyntheticLambda5
            public final Object invoke() {
                Unit createShareItem$lambda$7;
                createShareItem$lambda$7 = HtmlArtifactPreviewActivity.createShareItem$lambda$7(HtmlArtifactPreviewActivity.this);
                return createShareItem$lambda$7;
            }
        }, 60, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createShareItem$lambda$7(HtmlArtifactPreviewActivity htmlArtifactPreviewActivity) {
        htmlArtifactPreviewActivity.createShareLink();
        return Unit.INSTANCE;
    }

    private final ContextMenuPopupWindow.Item createDownloadItem() {
        int i = C0591R.drawable.trae_ic_title_bar_download;
        String string = getString(C0637R.string.trae_html_artifact_export_as_zip);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return new ContextMenuPopupWindow.Item(i, string, false, null, null, 0, new Function0() { // from class: com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity$$ExternalSyntheticLambda6
            public final Object invoke() {
                Unit createDownloadItem$lambda$9;
                createDownloadItem$lambda$9 = HtmlArtifactPreviewActivity.createDownloadItem$lambda$9(HtmlArtifactPreviewActivity.this);
                return createDownloadItem$lambda$9;
            }
        }, 60, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createDownloadItem$lambda$9(HtmlArtifactPreviewActivity htmlArtifactPreviewActivity) {
        File file = htmlArtifactPreviewActivity.archiveCacheFile;
        if (file != null) {
            if (!(file.exists() && file.length() > 0)) {
                file = null;
            }
            if (file != null) {
                htmlArtifactPreviewActivity.saveZipToDevice(file);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void reportApm$default(HtmlArtifactPreviewActivity htmlArtifactPreviewActivity, String str, String str2, String str3, JSONObject jSONObject, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            jSONObject = null;
        }
        htmlArtifactPreviewActivity.reportApm(str, str2, str3, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportApm(String status, String step, String reason, JSONObject extras) {
        try {
            Result.Companion companion = Result.Companion;
            HtmlArtifactPreviewActivity htmlArtifactPreviewActivity = this;
            ApmService apmService = ApmService.INSTANCE;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PageDataManager.EXTRA_STATUS, status);
            jSONObject.put("step", step);
            String str = this.cliType;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cliType");
                str = null;
            }
            jSONObject.put("cliType", str);
            if (reason != null) {
                jSONObject.put("reason", reason);
            }
            Unit unit = Unit.INSTANCE;
            apmService.monitorEventForSlardar(EVENT_HTML_ARTIFACT_PREVIEW, jSONObject, extras, buildBaseExtraLog());
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    static /* synthetic */ void startDownloadAndPreview$default(HtmlArtifactPreviewActivity htmlArtifactPreviewActivity, HtmlArtifactRemoteArchiveResolveMode htmlArtifactRemoteArchiveResolveMode, int i, Object obj) {
        if ((i & 1) != 0) {
            htmlArtifactRemoteArchiveResolveMode = HtmlArtifactRemoteArchiveResolveMode.ENSURE_SANDBOX_READY;
        }
        htmlArtifactPreviewActivity.startDownloadAndPreview(htmlArtifactRemoteArchiveResolveMode);
    }

    private final void startDownloadAndPreview(HtmlArtifactRemoteArchiveResolveMode remoteResolveMode) {
        showLoading();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new HtmlArtifactPreviewActivity$startDownloadAndPreview$1(this, remoteResolveMode, System.currentTimeMillis(), null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchFileUrl(HtmlArtifactRemoteArchiveResolveMode htmlArtifactRemoteArchiveResolveMode, Continuation<? super String> continuation) {
        HtmlArtifactDownloadTarget htmlArtifactDownloadTarget = this.downloadTarget;
        String str = null;
        if (htmlArtifactDownloadTarget == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadTarget");
            htmlArtifactDownloadTarget = null;
        }
        String localRequestPath = htmlArtifactDownloadTarget.getLocalRequestPath();
        FLogger fLogger = FLogger.INSTANCE;
        StringBuilder sb = new StringBuilder("fetchFileUrl: chatSessionId=");
        String str2 = this.chatSessionId;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatSessionId");
            str2 = null;
        }
        StringBuilder append = sb.append(str2).append(", cliType=");
        String str3 = this.cliType;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cliType");
            str3 = null;
        }
        fLogger.d(TAG, append.append(str3).append(", path=").append(localRequestPath).toString());
        String str4 = this.cliType;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cliType");
            str4 = null;
        }
        if (Intrinsics.areEqual(str4, CliType.REMOTE.getValue())) {
            HtmlArtifactRemoteArchiveUrlResolver htmlArtifactRemoteArchiveUrlResolver = this.remoteArchiveUrlResolver;
            String str5 = this.chatSessionId;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatSessionId");
            } else {
                str = str5;
            }
            return htmlArtifactRemoteArchiveUrlResolver.resolve(str, localRequestPath, htmlArtifactRemoteArchiveResolveMode, continuation);
        }
        return fetchDownloadUrlWithRetry(localRequestPath, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0115 -> B:11:0x003c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchDownloadUrlWithRetry(String str, Continuation<? super String> continuation) {
        HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1 htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;
        HtmlArtifactPreviewActivity htmlArtifactPreviewActivity;
        int i;
        HtmlArtifactPreviewActivity htmlArtifactPreviewActivity2;
        Object obj;
        HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1 htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$12;
        int i2;
        String str2;
        HtmlArtifactPreviewActivity htmlArtifactPreviewActivity3;
        String str3;
        int i3;
        HttpDataResult.Success success;
        Map<String, String> urlMap;
        Map<String, String> urlMap2;
        String str4;
        String str5;
        if (continuation instanceof HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1) {
            htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1 = (HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1) continuation;
            if ((htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1.label & Integer.MIN_VALUE) != 0) {
                htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1.label -= Integer.MIN_VALUE;
                htmlArtifactPreviewActivity = this;
                Object obj2 = htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    htmlArtifactPreviewActivity2 = htmlArtifactPreviewActivity;
                    obj = coroutine_suspended;
                    htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$12 = htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;
                    i2 = 0;
                    str2 = str;
                    if (i2 < 21) {
                    }
                } else if (i == 1) {
                    i3 = htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1.I$0;
                    str3 = (String) htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1.L$1;
                    htmlArtifactPreviewActivity3 = (HtmlArtifactPreviewActivity) htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    success = (HttpDataResult) obj2;
                    if (!(success instanceof HttpDataResult.Success)) {
                    }
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i3 = htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1.I$0;
                    str3 = (String) htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1.L$1;
                    htmlArtifactPreviewActivity3 = (HtmlArtifactPreviewActivity) htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    str2 = str3;
                    htmlArtifactPreviewActivity2 = htmlArtifactPreviewActivity3;
                    Object obj3 = coroutine_suspended;
                    htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$12 = htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;
                    int i4 = i3 + 1;
                    obj = obj3;
                    i2 = i4;
                    if (i2 < 21) {
                        IGetDownloadUrlApi.Companion companion = IGetDownloadUrlApi.INSTANCE;
                        List listOf = CollectionsKt.listOf(str2);
                        String str6 = htmlArtifactPreviewActivity2.conversationId;
                        if (str6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("conversationId");
                            str4 = null;
                        } else {
                            str4 = str6;
                        }
                        String str7 = htmlArtifactPreviewActivity2.messageId;
                        if (str7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("messageId");
                            str5 = null;
                        } else {
                            str5 = str7;
                        }
                        GetDownloadUrlRequest getDownloadUrlRequest = new GetDownloadUrlRequest(listOf, str4, str5, null, 8, null);
                        htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$12.L$0 = htmlArtifactPreviewActivity2;
                        htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$12.L$1 = str2;
                        htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$12.I$0 = i2;
                        htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$12.label = 1;
                        Object downloadUrlRawCall = companion.getDownloadUrlRawCall(getDownloadUrlRequest, htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$12);
                        if (downloadUrlRawCall == obj) {
                            return obj;
                        }
                        htmlArtifactPreviewActivity3 = htmlArtifactPreviewActivity2;
                        str3 = str2;
                        obj2 = downloadUrlRawCall;
                        Object obj4 = obj;
                        i3 = i2;
                        htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1 = htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$12;
                        coroutine_suspended = obj4;
                        success = (HttpDataResult) obj2;
                        if (!(success instanceof HttpDataResult.Success)) {
                            HttpDataResult.Success success2 = success;
                            GetDownloadUrlData getDownloadUrlData = (GetDownloadUrlData) success2.getBizResp().getData();
                            if (((getDownloadUrlData == null || (urlMap2 = getDownloadUrlData.getUrlMap()) == null) ? null : urlMap2.get(str3)) != null) {
                                GetDownloadUrlData getDownloadUrlData2 = (GetDownloadUrlData) success2.getBizResp().getData();
                                if (getDownloadUrlData2 == null || (urlMap = getDownloadUrlData2.getUrlMap()) == null) {
                                    return null;
                                }
                                return urlMap.get(str3);
                            }
                            long code = success2.getBizResp().getCode();
                            if (code == 202 && i3 < 20) {
                                htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1.L$0 = htmlArtifactPreviewActivity3;
                                htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1.L$1 = str3;
                                htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1.I$0 = i3;
                                htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1.label = 2;
                                if (DelayKt.delay(2000L, htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                str2 = str3;
                                htmlArtifactPreviewActivity2 = htmlArtifactPreviewActivity3;
                                Object obj32 = coroutine_suspended;
                                htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$12 = htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;
                                int i42 = i3 + 1;
                                obj = obj32;
                                i2 = i42;
                                if (i2 < 21) {
                                    return null;
                                }
                            } else {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("attempt", i3);
                                jSONObject.put("biz_code", code);
                                Unit unit = Unit.INSTANCE;
                                htmlArtifactPreviewActivity3.reportApm("fail", "fetch_download_url", "retry_exhausted", jSONObject);
                                return null;
                            }
                        } else {
                            if (!(success instanceof HttpDataResult.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("attempt", i3);
                            HttpDataResult.Error error = (HttpDataResult.Error) success;
                            jSONObject2.put("error_code", String.valueOf(error.getCode()));
                            jSONObject2.put("error_message", error.getMsg());
                            Unit unit2 = Unit.INSTANCE;
                            htmlArtifactPreviewActivity3.reportApm("fail", "fetch_download_url", "request_error", jSONObject2);
                            return null;
                        }
                    }
                }
            }
        }
        htmlArtifactPreviewActivity = this;
        htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1 = new HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1(htmlArtifactPreviewActivity, continuation);
        Object obj22 = htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = htmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object downloadAndUnzip(String str, Continuation<? super ArchiveExtractionResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new HtmlArtifactPreviewActivity$downloadAndUnzip$2(this, str, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unzipFile(File zipFile, File targetDir) {
        FileOutputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFile));
        try {
            ZipInputStream zipInputStream2 = zipInputStream;
            for (ZipEntry nextEntry = zipInputStream2.getNextEntry(); nextEntry != null; nextEntry = zipInputStream2.getNextEntry()) {
                File file = new File(targetDir, nextEntry.getName());
                String canonicalPath = file.getCanonicalPath();
                Intrinsics.checkNotNullExpressionValue(canonicalPath, "getCanonicalPath(...)");
                String canonicalPath2 = targetDir.getCanonicalPath();
                Intrinsics.checkNotNullExpressionValue(canonicalPath2, "getCanonicalPath(...)");
                if (!StringsKt.startsWith$default(canonicalPath, canonicalPath2, false, 2, (Object) null)) {
                    throw new SecurityException("Zip entry is outside of the target dir: " + nextEntry.getName());
                }
                if (nextEntry.isDirectory()) {
                    file.mkdirs();
                } else {
                    File parentFile = file.getParentFile();
                    if (parentFile != null) {
                        parentFile.mkdirs();
                    }
                    zipInputStream = new FileOutputStream(file);
                    try {
                        Long.valueOf(ByteStreamsKt.copyTo$default(zipInputStream2, zipInputStream, 0, 2, (Object) null));
                        CloseableKt.closeFinally(zipInputStream, (Throwable) null);
                    } finally {
                    }
                }
                zipInputStream2.closeEntry();
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(zipInputStream, (Throwable) null);
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showWebView(File entryFile, File archiveFile) {
        this.archiveCacheFile = archiveFile;
        setDownloadEnabled(true);
        View view = this.progressBar;
        WebView webView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            view = null;
        }
        view.setVisibility(8);
        stopLoadingAnimation();
        LinearLayout linearLayout = this.layoutContent;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        WebView webView2 = this.webView;
        if (webView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView2 = null;
        }
        webView2.setVisibility(0);
        WebView webView3 = this.webView;
        if (webView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView3 = null;
        }
        WebSettings settings = webView3.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setDefaultTextEncodingName("UTF-8");
        WebView webView4 = this.webView;
        if (webView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView4 = null;
        }
        webView4.setWebChromeClient(new WebChromeClient());
        WebView webView5 = this.webView;
        if (webView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView5 = null;
        }
        webView5.setWebViewClient(new WebViewClient());
        WebView webView6 = this.webView;
        if (webView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            webView = webView6;
        }
        webView.loadUrl("file://" + entryFile.getAbsolutePath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showError(final HtmlArtifactPreviewFailure failure) {
        TextView textView = null;
        this.archiveCacheFile = null;
        setDownloadEnabled(false);
        View view = this.progressBar;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            view = null;
        }
        view.setVisibility(8);
        stopLoadingAnimation();
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.setVisibility(8);
        LinearLayout linearLayout = this.layoutContent;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        TextView textView2 = this.downloadStatusTitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadStatusTitle");
            textView2 = null;
        }
        textView2.setText(C0637R.string.trae_html_artifact_unable_to_open);
        TextView textView3 = this.btnMainDownload;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMainDownload");
            textView3 = null;
        }
        textView3.setText(C0637R.string.trae_html_artifact_reload);
        TextView textView4 = this.btnMainDownload;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMainDownload");
        } else {
            textView = textView4;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HtmlArtifactPreviewActivity.showError$lambda$17(HtmlArtifactPreviewActivity.this, failure, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showError$lambda$17(HtmlArtifactPreviewActivity htmlArtifactPreviewActivity, HtmlArtifactPreviewFailure htmlArtifactPreviewFailure, View view) {
        LinearLayout linearLayout = htmlArtifactPreviewActivity.layoutContent;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        htmlArtifactPreviewActivity.startDownloadAndPreview(htmlArtifactPreviewActivity.nextResolveModeAfter(htmlArtifactPreviewFailure));
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
    
        if ((!r1.isEmpty()) == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setupDownloadButton() {
        boolean z;
        setDownloadEnabled(false);
        if (this.shareItems != null) {
            z = true;
        }
        z = false;
        TraeTitleBar traeTitleBar = null;
        if (z) {
            TraeTitleBar traeTitleBar2 = this.titleBar;
            if (traeTitleBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBar");
                traeTitleBar2 = null;
            }
            traeTitleBar2.setRightActionResource(0, C0637R.drawable.trae_ic_title_bar_share);
            TraeTitleBar traeTitleBar3 = this.titleBar;
            if (traeTitleBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            } else {
                traeTitleBar = traeTitleBar3;
            }
            traeTitleBar.setOnRightActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HtmlArtifactPreviewActivity.this.showExportMenu();
                }
            });
            return;
        }
        TraeTitleBar traeTitleBar4 = this.titleBar;
        if (traeTitleBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            traeTitleBar4 = null;
        }
        traeTitleBar4.setRightActionResource(0, C0591R.drawable.trae_ic_title_bar_download);
        TraeTitleBar traeTitleBar5 = this.titleBar;
        if (traeTitleBar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        } else {
            traeTitleBar = traeTitleBar5;
        }
        traeTitleBar.setOnRightActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HtmlArtifactPreviewActivity.setupDownloadButton$lambda$21(HtmlArtifactPreviewActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupDownloadButton$lambda$21(HtmlArtifactPreviewActivity htmlArtifactPreviewActivity, View view) {
        File file = htmlArtifactPreviewActivity.archiveCacheFile;
        if (file != null) {
            if (!(file.exists() && file.length() > 0)) {
                file = null;
            }
            if (file != null) {
                htmlArtifactPreviewActivity.saveZipToDevice(file);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showExportMenu() {
        View findViewById;
        List<ContextMenuPopupWindow.Item> list = this.shareItems;
        if (list == null || (findViewById = findViewById(C0637R.id.btn_download)) == null) {
            return;
        }
        new ContextMenuPopupWindow((Context) this, list, 0, 4, null).showBelow(findViewById, findViewById.getResources().getDimensionPixelSize(C0591R.dimen.trae_title_bar_page_height) + ((int) (10 * findViewById.getResources().getDisplayMetrics().density)));
    }

    private final void queryExistingShareLink() {
        String str = this.cliType;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cliType");
            str = null;
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new HtmlArtifactPreviewActivity$queryExistingShareLink$1(Intrinsics.areEqual(str, CliType.LOCAL.getValue()), this, null), 3, (Object) null);
    }

    private final void createShareLink() {
        String str;
        String normalizeFilePath;
        String str2;
        String str3;
        String str4 = this.cliType;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cliType");
            str4 = null;
        }
        boolean areEqual = Intrinsics.areEqual(str4, CliType.LOCAL.getValue());
        ShareLinkBottomSheet.Companion companion = ShareLinkBottomSheet.INSTANCE;
        String str5 = this.chatSessionId;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatSessionId");
            str = null;
        } else {
            str = str5;
        }
        if (areEqual) {
            String str6 = this.realPath;
            if (str6.length() == 0) {
                HtmlArtifactDownloadTarget htmlArtifactDownloadTarget = this.downloadTarget;
                if (htmlArtifactDownloadTarget == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downloadTarget");
                    htmlArtifactDownloadTarget = null;
                }
                str6 = StringsKt.removePrefix(htmlArtifactDownloadTarget.getLocalRequestPath(), "package/");
            }
            normalizeFilePath = str6;
        } else {
            HtmlArtifactRemoteArchiveUrlResolver htmlArtifactRemoteArchiveUrlResolver = this.remoteArchiveUrlResolver;
            HtmlArtifactDownloadTarget htmlArtifactDownloadTarget2 = this.downloadTarget;
            if (htmlArtifactDownloadTarget2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("downloadTarget");
                htmlArtifactDownloadTarget2 = null;
            }
            normalizeFilePath = htmlArtifactRemoteArchiveUrlResolver.normalizeFilePath(htmlArtifactDownloadTarget2.getLocalRequestPath(), this.remoteArchiveUrlResolver.getWorkSpace());
        }
        String str7 = this.conversationId;
        if (str7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("conversationId");
            str2 = null;
        } else {
            str2 = str7;
        }
        String str8 = this.existingShareUrl;
        String str9 = this.existingShareId;
        String str10 = this.messageId;
        if (str10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageId");
            str3 = null;
        } else {
            str3 = str10;
        }
        ShareLinkBottomSheet newInstance = companion.newInstance(str, normalizeFilePath, str2, areEqual, str8, str9, str3);
        newInstance.setOnShareStateChangedListener(new ShareLinkBottomSheet.OnShareStateChangedListener() { // from class: com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity$createShareLink$1
            @Override // com.bytedance.trae.conversation.products.ShareLinkBottomSheet.OnShareStateChangedListener
            public void onShareCreated(String shareUrl, String shareId) {
                Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
                HtmlArtifactPreviewActivity.this.existingShareUrl = shareUrl;
                HtmlArtifactPreviewActivity.this.existingShareId = shareId;
            }

            @Override // com.bytedance.trae.conversation.products.ShareLinkBottomSheet.OnShareStateChangedListener
            public void onShareStopped() {
                HtmlArtifactPreviewActivity.this.existingShareUrl = null;
                HtmlArtifactPreviewActivity.this.existingShareId = null;
            }
        });
        newInstance.show(getSupportFragmentManager(), ShareLinkBottomSheet.TAG);
    }

    private final HtmlArtifactRemoteArchiveResolveMode nextResolveModeAfter(HtmlArtifactPreviewFailure failure) {
        String str = this.cliType;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cliType");
            str = null;
        }
        if (Intrinsics.areEqual(str, CliType.REMOTE.getValue())) {
            return HtmlArtifactPreviewRetryPolicy.INSTANCE.nextRemoteResolveMode(failure);
        }
        return HtmlArtifactRemoteArchiveResolveMode.ENSURE_SANDBOX_READY;
    }

    private final void showLoading() {
        View view = null;
        this.archiveCacheFile = null;
        setDownloadEnabled(false);
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.setVisibility(8);
        LinearLayout linearLayout = this.layoutContent;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        View view2 = this.progressBar;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        } else {
            view = view2;
        }
        view.setVisibility(0);
        startLoadingAnimation();
    }

    private final void setDownloadEnabled(boolean enabled) {
        TraeTitleBar traeTitleBar = this.titleBar;
        if (traeTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            traeTitleBar = null;
        }
        traeTitleBar.setRightActionEnabled(0, enabled);
    }

    private final void startLoadingAnimation() {
        ImageView imageView = this.loadingIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingIcon");
            imageView = null;
        }
        Object drawable = imageView.getDrawable();
        Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
        if (animatable != null) {
            animatable.start();
        }
    }

    private final void stopLoadingAnimation() {
        ImageView imageView = this.loadingIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingIcon");
            imageView = null;
        }
        Object drawable = imageView.getDrawable();
        Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
        if (animatable != null) {
            animatable.stop();
        }
    }

    private final boolean isHtmlShareSupported(String ideVersion, String minSupportedIdeVersion) {
        String str = minSupportedIdeVersion;
        if (str == null || StringsKt.isBlank(str)) {
            return false;
        }
        return IdeVersionComparator.INSTANCE.isGreaterOrEqual(ideVersion, minSupportedIdeVersion);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void saveZipToDevice(File archiveFile) {
        String str;
        FileDownloadHelper fileDownloadHelper = this.fileDownloadHelper;
        Context context = (Context) this;
        String str2 = this.chatSessionId;
        HtmlArtifactDownloadTarget htmlArtifactDownloadTarget = null;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatSessionId");
            str = null;
        } else {
            str = str2;
        }
        HtmlArtifactDownloadTarget htmlArtifactDownloadTarget2 = this.downloadTarget;
        if (htmlArtifactDownloadTarget2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadTarget");
        } else {
            htmlArtifactDownloadTarget = htmlArtifactDownloadTarget2;
        }
        fileDownloadHelper.copyCachedFileAndLoading(context, archiveFile, str, htmlArtifactDownloadTarget.getSavePath(), (CoroutineScope) LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), this.downloadFinishCallback, this.createdTime);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onDestroy() {
        stopLoadingAnimation();
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.destroy();
        super.onDestroy();
    }

    private final boolean isShareEnable(HtmlShareSettingsItem setting) {
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        AccountInfo accountInfo = iLoginService != null ? iLoginService.getAccountInfo() : null;
        if ((accountInfo != null ? accountInfo.getAccountType() : null) == AccountType.BYTEDANCE) {
            return setting.getBytedanceEnable();
        }
        return FeatureCapability.INSTANCE.isEnabled(Feature.HTML_SHARE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_conversation_products_HtmlArtifactPreviewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m845x40965010(HtmlArtifactPreviewActivity htmlArtifactPreviewActivity) {
        htmlArtifactPreviewActivity.m846x568514cb();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) htmlArtifactPreviewActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
