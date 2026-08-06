package com.bytedance.trae.conversation.products;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.webkit.MimeTypeMap;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.crash.Ensure;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.widget.CustomToast;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.renderer.ArtifactTrack;
import com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView;
import com.bytedance.trae.conversation.fileupload.ResourceUploadUtilKt;
import com.bytedance.trae.home.solo.setting.SettingsTracker;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.im.service.ChatSessionResponse;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.GetDownloadUrlData;
import com.bytedance.trae.im.service.GetDownloadUrlRequest;
import com.bytedance.trae.im.service.IChatSessionApi;
import com.bytedance.trae.im.service.IGetDownloadUrlApi;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.platform.service.ApmService;
import com.bytedance.trae.utils.logger.FLogger;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.business.markdown.impl.common.utils.ExtrasKt;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* compiled from: ArtifactPreviewActivity.kt */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 {2\u00020\u0001:\u0003{|}B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010E\u001a\u00020/2\b\u0010F\u001a\u0004\u0018\u00010GH\u0014J\u0010\u0010H\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001fH\u0002J\u001c\u0010I\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020\u001f2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u001fH\u0002J\u0018\u0010L\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0002J\b\u0010N\u001a\u00020/H\u0002J\u0010\u0010O\u001a\u0004\u0018\u00010\u001fH\u0082@¢\u0006\u0002\u0010PJ@\u0010Q\u001a\u00020/2\u0006\u0010R\u001a\u00020\u001f2\u0006\u0010S\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010T\u001a\u00020(2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u001fH\u0002J\u0018\u0010W\u001a\u0004\u0018\u00010\u001f2\u0006\u0010J\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010XJ\u0010\u0010Y\u001a\u00020/2\u0006\u0010Z\u001a\u00020\u001fH\u0002J\u0010\u0010[\u001a\u00020/2\u0006\u0010\\\u001a\u00020]H\u0002J\u0010\u0010^\u001a\u00020/2\u0006\u0010&\u001a\u00020\u001fH\u0002J\u0010\u0010_\u001a\u00020/2\u0006\u0010&\u001a\u00020\u001fH\u0002J\u0012\u0010`\u001a\u0004\u0018\u00010\u001f2\u0006\u0010a\u001a\u00020\u001fH\u0002J\u0010\u0010b\u001a\u00020/2\u0006\u0010&\u001a\u00020\u001fH\u0002J \u0010c\u001a\u00020/2\u0006\u0010&\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0002J \u0010d\u001a\u00020/2\u0006\u0010&\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0002J\b\u0010e\u001a\u00020/H\u0002J\b\u0010f\u001a\u00020/H\u0002J\b\u0010g\u001a\u00020/H\u0002J\u0010\u0010h\u001a\u00020/2\u0006\u0010i\u001a\u00020\u001fH\u0002J\b\u0010j\u001a\u00020/H\u0002J\b\u0010k\u001a\u00020/H\u0002J\b\u0010l\u001a\u00020/H\u0002J\b\u0010m\u001a\u00020/H\u0002J \u0010n\u001a\u00020/2\u0006\u0010a\u001a\u00020\u001f2\u0006\u0010o\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0002J\u0010\u0010p\u001a\u00020/2\u0006\u0010q\u001a\u00020\u0019H\u0002J\u0010\u0010r\u001a\u00020/2\u0006\u0010s\u001a\u000203H\u0002J\u0018\u0010t\u001a\u00020\u001f2\u0006\u0010u\u001a\u00020\u001f2\u0006\u0010v\u001a\u00020\u001fH\u0002J\u0010\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020zH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010,\u001a\u001a\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020/0-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b<\u0010=R\u001b\u0010@\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010?\u001a\u0004\bB\u0010C¨\u0006~"}, d2 = {"Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "btnBack", "Landroid/widget/ImageView;", "tvTitle", "Landroid/widget/TextView;", "progressBar", "Landroid/widget/ProgressBar;", "imageContainer", "Landroid/widget/FrameLayout;", "ivPreview", "Lcom/facebook/drawee/view/SimpleDraweeView;", "webView", "Landroid/webkit/WebView;", "scrollMarkdown", "Landroid/widget/ScrollView;", "tvMarkdown", "Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;", "scrollTxt", "tvTxt", "layoutContent", "Landroid/widget/LinearLayout;", "btnDownload", "Landroid/view/View;", "btnMainDownload", "downloadStatusTitle", "fileType", "Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$FileType;", "chatSessionId", "", "cliType", "path", "isDeleted", "", "messageId", "conversationId", "fileUrl", "createdTime", "", "startTime", "loadingDialog", "Landroid/app/Dialog;", "downloadFinishCallback", "Lkotlin/Function3;", "", "", "fileDownloadHelper", "Lcom/bytedance/trae/conversation/products/FileDownloadHelper;", "currentScale", "", "lastTouchX", "lastTouchY", "isDragging", "activePointerId", "scaleAnimator", "Landroid/animation/ValueAnimator;", "scaleGestureDetector", "Landroid/view/ScaleGestureDetector;", "getScaleGestureDetector", "()Landroid/view/ScaleGestureDetector;", "scaleGestureDetector$delegate", "Lkotlin/Lazy;", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "gestureDetector$delegate", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "getFileType", "normalizeFilePath", "filePath", "workspacePath", "buildFileUrl", "explorerUrl", "preview", "fetchFileUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportFetchFileUrlEvent", PageDataManager.EXTRA_STATUS, "reason", "fetchStartTime", AccountMonitorConstants.CommonParameter.ERROR, "errorMessage", "fetchDownloadUrlWithRetry", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showImagePreview", "imageUrl", "loadImage", "imageUri", "Landroid/net/Uri;", "showCodePreview", "showHtmlPreview", "fetchTextViaTTNet", IWeixinService.ResponseConstants.URL, "downloadAndShowTxt", "loadMarkdownPreview", "showDownloadWithUrl", "showLoadingDialog", "hideLoadingDialog", "showDownloadOnly", "openFileWithExternalApp", "savedPath", "showDirError", "showArtifactDelete", "showError", "setupBtnDownload", "setupDownloadButtons", "sessionId", "setupImageTouchHandling", "container", "animateToScale", "targetScale", "buildCodeHighlightHtml", "code", SettingsTracker.TYPE_LANGUAGE, "readAllBytes", "", "input", "Ljava/io/InputStream;", "Companion", "FileType", "TxtFetchApi", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArtifactPreviewActivity extends TraeCommonAppCompatActivity {
    private static final long ANIM_DURATION = 250;
    private static final float DOUBLE_TAP_SCALE = 2.5f;
    private static final int DOWNLOAD_URL_MAX_RETRIES = 20;
    private static final long DOWNLOAD_URL_RETRY_DELAY_MS = 2000;
    private static final String EVENT_FETCH_FILE_URL = "artifact_fetch_file_url";
    private static final String EXTRA_CHAT_SESSION_ID = "extra_chat_session_id";
    private static final String EXTRA_CLI_TYPE = "extra_cli_type";
    private static final String EXTRA_CONVERSATION_ID = "extra_conversation_id";
    private static final String EXTRA_CREATED_TIME = "extra_created_time";
    private static final String EXTRA_MESSAGE_ID = "extra_message_id";
    private static final String EXTRA_PATH = "extra_path";
    private static final String EXTRA_TURN_ID = "extra_turn_id";
    private static final int MAX_CODE_HIGHLIGHT_LENGTH = 1048576;
    private static final float MAX_SCALE = 5.0f;
    private static final float MIN_SCALE = 1.0f;
    private ImageView btnBack;
    private View btnDownload;
    private TextView btnMainDownload;
    private String chatSessionId;
    private String cliType;
    private String conversationId;
    private long createdTime;
    private TextView downloadStatusTitle;
    private FileType fileType;
    private String fileUrl;
    private FrameLayout imageContainer;
    private boolean isDeleted;
    private boolean isDragging;
    private SimpleDraweeView ivPreview;
    private float lastTouchX;
    private float lastTouchY;
    private LinearLayout layoutContent;
    private Dialog loadingDialog;
    private String messageId;
    private String path;
    private ProgressBar progressBar;
    private ValueAnimator scaleAnimator;
    private ScrollView scrollMarkdown;
    private ScrollView scrollTxt;
    private long startTime;
    private SimpleMarkdownTextView tvMarkdown;
    private TextView tvTitle;
    private TextView tvTxt;
    private WebView webView;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> IMAGE_EXTENSIONS = SetsKt.setOf(new String[]{"png", "jpg", "jpeg", "gif", "bmp", "webp", "heif", "heic"});
    private static final Set<String> MARKDOWN_EXTENSIONS = SetsKt.setOf(new String[]{"md", "markdown", "mdx"});
    private static final Set<String> CODE_EXTENSIONS = SetsKt.setOf(new String[]{"kt", "java", "py", "js", "ts", "tsx", "jsx", "c", "cpp", "h", "hpp", "cs", "go", "rs", "rb", "php", "swift", "m", "mm", "scala", "groovy", "sh", "bash", "zsh", "bat", "ps1", "pl", "lua", "r", "sql", "css", "scss", "less", "sass", "xml", "json", "yaml", "yml", "toml", "ini", "cfg", "conf", "properties", "gradle", "cmake", "makefile", "dockerfile", "dart", "vue", "svelte", "zig", "nim", "ex", "exs", "erl", "hs", "ml", "mli", "clj", "cljs", "elm"});
    private static final Set<String> TXT_EXTENSIONS = SetsKt.setOf(new String[]{"txt", MessagePart.TYPE_LOG, "csv", "tsv"});
    private static final Set<String> HTML_EXTENSIONS = SetsKt.setOf(new String[]{"html", "htm", "xhtml"});
    private final Function3<Integer, String, Long, Unit> downloadFinishCallback = new Function3() { // from class: com.bytedance.trae.conversation.products.ArtifactPreviewActivity$$ExternalSyntheticLambda4
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit downloadFinishCallback$lambda$0;
            downloadFinishCallback$lambda$0 = ArtifactPreviewActivity.downloadFinishCallback$lambda$0(ArtifactPreviewActivity.this, ((Integer) obj).intValue(), (String) obj2, ((Long) obj3).longValue());
            return downloadFinishCallback$lambda$0;
        }
    };
    private final FileDownloadHelper fileDownloadHelper = new FileDownloadHelper();
    private float currentScale = MIN_SCALE;
    private int activePointerId = -1;

    /* renamed from: scaleGestureDetector$delegate, reason: from kotlin metadata */
    private final Lazy scaleGestureDetector = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.products.ArtifactPreviewActivity$$ExternalSyntheticLambda5
        public final Object invoke() {
            ScaleGestureDetector scaleGestureDetector_delegate$lambda$1;
            scaleGestureDetector_delegate$lambda$1 = ArtifactPreviewActivity.scaleGestureDetector_delegate$lambda$1(ArtifactPreviewActivity.this);
            return scaleGestureDetector_delegate$lambda$1;
        }
    });

    /* renamed from: gestureDetector$delegate, reason: from kotlin metadata */
    private final Lazy gestureDetector = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.products.ArtifactPreviewActivity$$ExternalSyntheticLambda6
        public final Object invoke() {
            GestureDetector gestureDetector_delegate$lambda$2;
            gestureDetector_delegate$lambda$2 = ArtifactPreviewActivity.gestureDetector_delegate$lambda$2(ArtifactPreviewActivity.this);
            return gestureDetector_delegate$lambda$2;
        }
    });

    /* compiled from: ArtifactPreviewActivity.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bb\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$TxtFetchApi;", "", ApiRequest.METHOD_GET, "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", IWeixinService.ResponseConstants.URL, "", "maxLength", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface TxtFetchApi {
        @GET
        Call<TypedInput> get(@Url String str, @MaxLength int i);
    }

    /* renamed from: com_bytedance_trae_conversation_products_ArtifactPreviewActivity__onStop$___twin___ */
    public void m840x2fa42bc0() {
        super.onStop();
    }

    protected void onStop() {
        m839x3c5cde3b(this);
    }

    /* compiled from: ArtifactPreviewActivity.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JT\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$Companion;", "", "<init>", "()V", "EXTRA_CHAT_SESSION_ID", "", "EXTRA_TURN_ID", "EXTRA_CLI_TYPE", "EXTRA_PATH", "EXTRA_MESSAGE_ID", "EXTRA_CONVERSATION_ID", "EXTRA_CREATED_TIME", "MIN_SCALE", "", "MAX_SCALE", "DOUBLE_TAP_SCALE", "ANIM_DURATION", "", "MAX_CODE_HIGHLIGHT_LENGTH", "", "IMAGE_EXTENSIONS", "", "MARKDOWN_EXTENSIONS", "CODE_EXTENSIONS", "TXT_EXTENSIONS", "HTML_EXTENSIONS", "DOWNLOAD_URL_MAX_RETRIES", "DOWNLOAD_URL_RETRY_DELAY_MS", "EVENT_FETCH_FILE_URL", "start", "", "context", "Landroid/content/Context;", "chatSessionId", "turnId", "cliType", "path", "messageId", "conversationId", "createdTime", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, String str, String str2, String str3, String str4, String str5, String str6, long j, int i, Object obj) {
            companion.start(context, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, (i & 64) == 0 ? str6 : "", (i & 128) != 0 ? 0L : j);
        }

        public final void start(Context context, String chatSessionId, String turnId, String cliType, String path, String messageId, String conversationId, long createdTime) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(chatSessionId, "chatSessionId");
            Intrinsics.checkNotNullParameter(turnId, "turnId");
            Intrinsics.checkNotNullParameter(cliType, "cliType");
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            Intrinsics.checkNotNullParameter(conversationId, "conversationId");
            Intent intent = new Intent(context, (Class<?>) ArtifactPreviewActivity.class);
            intent.putExtra(ArtifactPreviewActivity.EXTRA_CHAT_SESSION_ID, chatSessionId);
            intent.putExtra(ArtifactPreviewActivity.EXTRA_TURN_ID, turnId);
            intent.putExtra(ArtifactPreviewActivity.EXTRA_CLI_TYPE, cliType);
            intent.putExtra(ArtifactPreviewActivity.EXTRA_PATH, path);
            intent.putExtra(ArtifactPreviewActivity.EXTRA_MESSAGE_ID, messageId);
            intent.putExtra("extra_conversation_id", conversationId);
            intent.putExtra(ArtifactPreviewActivity.EXTRA_CREATED_TIME, createdTime);
            context.startActivity(intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit downloadFinishCallback$lambda$0(ArtifactPreviewActivity artifactPreviewActivity, int i, String str, long j) {
        Intrinsics.checkNotNullParameter(str, "savedPath");
        if (i == 0) {
            CustomToast.showLong((Context) artifactPreviewActivity, artifactPreviewActivity.getString(R.string.trae_doc_preview_download_success) + '\n' + StringsKt.substringBeforeLast$default(str, '/', (String) null, 2, (Object) null));
        } else {
            CustomToast.showLong((Context) artifactPreviewActivity, artifactPreviewActivity.getString(R.string.trae_doc_preview_download_failed));
        }
        return Unit.INSTANCE;
    }

    private final ScaleGestureDetector getScaleGestureDetector() {
        return (ScaleGestureDetector) this.scaleGestureDetector.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final ScaleGestureDetector scaleGestureDetector_delegate$lambda$1(ArtifactPreviewActivity artifactPreviewActivity) {
        return new ScaleGestureDetector((Context) artifactPreviewActivity, new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.bytedance.trae.conversation.products.ArtifactPreviewActivity$scaleGestureDetector$2$1
            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector detector) {
                ValueAnimator valueAnimator;
                Intrinsics.checkNotNullParameter(detector, "detector");
                valueAnimator = ArtifactPreviewActivity.this.scaleAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                ArtifactPreviewActivity.this.isDragging = false;
                return true;
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector detector) {
                float f;
                SimpleDraweeView simpleDraweeView;
                float f2;
                SimpleDraweeView simpleDraweeView2;
                float f3;
                Intrinsics.checkNotNullParameter(detector, "detector");
                float scaleFactor = detector.getScaleFactor();
                f = ArtifactPreviewActivity.this.currentScale;
                ArtifactPreviewActivity.this.currentScale = RangesKt.coerceIn(f * scaleFactor, 0.5f, 5.0f);
                simpleDraweeView = ArtifactPreviewActivity.this.ivPreview;
                SimpleDraweeView simpleDraweeView3 = null;
                if (simpleDraweeView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivPreview");
                    simpleDraweeView = null;
                }
                f2 = ArtifactPreviewActivity.this.currentScale;
                simpleDraweeView.setScaleX(f2);
                simpleDraweeView2 = ArtifactPreviewActivity.this.ivPreview;
                if (simpleDraweeView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivPreview");
                } else {
                    simpleDraweeView3 = simpleDraweeView2;
                }
                f3 = ArtifactPreviewActivity.this.currentScale;
                simpleDraweeView3.setScaleY(f3);
                return true;
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector detector) {
                float f;
                Intrinsics.checkNotNullParameter(detector, "detector");
                f = ArtifactPreviewActivity.this.currentScale;
                if (f < 1.0f) {
                    ArtifactPreviewActivity.this.animateToScale(1.0f);
                }
            }
        });
    }

    private final GestureDetector getGestureDetector() {
        return (GestureDetector) this.gestureDetector.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final GestureDetector gestureDetector_delegate$lambda$2(ArtifactPreviewActivity artifactPreviewActivity) {
        return new GestureDetector((Context) artifactPreviewActivity, new GestureDetector.SimpleOnGestureListener() { // from class: com.bytedance.trae.conversation.products.ArtifactPreviewActivity$gestureDetector$2$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent e) {
                float f;
                Intrinsics.checkNotNullParameter(e, "e");
                f = ArtifactPreviewActivity.this.currentScale;
                if (f > 1.0f) {
                    ArtifactPreviewActivity.this.animateToScale(1.0f);
                    return true;
                }
                ArtifactPreviewActivity.this.animateToScale(2.5f);
                return true;
            }
        });
    }

    /* compiled from: ArtifactPreviewActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$FileType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "MARKDOWN", "CODE", "TXT", "HTML", "OTHER", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class FileType extends Enum<FileType> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ FileType[] $VALUES;
        public static final FileType IMAGE = new FileType("IMAGE", 0);
        public static final FileType MARKDOWN = new FileType("MARKDOWN", 1);
        public static final FileType CODE = new FileType("CODE", 2);
        public static final FileType TXT = new FileType("TXT", 3);
        public static final FileType HTML = new FileType("HTML", 4);
        public static final FileType OTHER = new FileType("OTHER", 5);

        private static final /* synthetic */ FileType[] $values() {
            return new FileType[]{IMAGE, MARKDOWN, CODE, TXT, HTML, OTHER};
        }

        public static EnumEntries<FileType> getEntries() {
            return $ENTRIES;
        }

        static {
            FileType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private FileType(String str, int i) {
            super(str, i);
        }

        public static FileType valueOf(String str) {
            return (FileType) Enum.valueOf(FileType.class, str);
        }

        public static FileType[] values() {
            return (FileType[]) $VALUES.clone();
        }
    }

    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0637R.layout.trae_layout_artifact_preview);
        View findViewById = findViewById(C0637R.id.btn_back);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.btnBack = (ImageView) findViewById;
        View findViewById2 = findViewById(C0637R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.tvTitle = (TextView) findViewById2;
        View findViewById3 = findViewById(C0637R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.progressBar = (ProgressBar) findViewById3;
        View findViewById4 = findViewById(C0637R.id.image_container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.imageContainer = (FrameLayout) findViewById4;
        SimpleDraweeView findViewById5 = findViewById(C0637R.id.iv_preview);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.ivPreview = findViewById5;
        View findViewById6 = findViewById(C0637R.id.webview);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.webView = (WebView) findViewById6;
        View findViewById7 = findViewById(C0637R.id.scroll_markdown);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.scrollMarkdown = (ScrollView) findViewById7;
        Object findViewById8 = findViewById(C0637R.id.tv_markdown);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        this.tvMarkdown = (SimpleMarkdownTextView) findViewById8;
        View findViewById9 = findViewById(C0637R.id.scroll_txt);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
        this.scrollTxt = (ScrollView) findViewById9;
        View findViewById10 = findViewById(C0637R.id.tv_txt);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(...)");
        this.tvTxt = (TextView) findViewById10;
        View findViewById11 = findViewById(C0637R.id.layout_content);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(...)");
        this.layoutContent = (LinearLayout) findViewById11;
        View findViewById12 = findViewById(C0637R.id.btn_download);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(...)");
        this.btnDownload = findViewById12;
        View findViewById13 = findViewById(C0637R.id.btn_main_download);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(...)");
        this.btnMainDownload = (TextView) findViewById13;
        View findViewById14 = findViewById(C0637R.id.download_status_tile);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(...)");
        this.downloadStatusTitle = (TextView) findViewById14;
        SimpleMarkdownTextView simpleMarkdownTextView = this.tvMarkdown;
        FileType fileType = null;
        if (simpleMarkdownTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvMarkdown");
            simpleMarkdownTextView = null;
        }
        simpleMarkdownTextView.setMovementMethod(LinkMovementMethod.getInstance());
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
        this.conversationId = stringExtra5 != null ? stringExtra5 : "";
        this.createdTime = getIntent().getLongExtra(EXTRA_CREATED_TIME, 0L);
        this.startTime = System.currentTimeMillis();
        String str = this.cliType;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cliType");
            str = null;
        }
        if (Intrinsics.areEqual(str, CliType.LOCAL.getValue())) {
            String str2 = this.path;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("path");
                str2 = null;
            }
            if (StringsKt.endsWith$default(str2, "/", false, 2, (Object) null)) {
                showDirError();
                return;
            }
        }
        FLogger fLogger = FLogger.INSTANCE;
        StringBuilder sb = new StringBuilder("onCreate：");
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
        fLogger.d("ArtifactPreviewActivity", append4.append(str7).toString());
        PrintStream printStream = System.out;
        Object[] objArr = new Object[1];
        StringBuilder sb2 = new StringBuilder("onCreate：");
        String str8 = this.chatSessionId;
        if (str8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatSessionId");
            str8 = null;
        }
        StringBuilder append5 = sb2.append(str8).append(' ');
        String str9 = this.cliType;
        if (str9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cliType");
            str9 = null;
        }
        StringBuilder append6 = append5.append(str9).append(' ');
        String str10 = this.path;
        if (str10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("path");
            str10 = null;
        }
        StringBuilder append7 = append6.append(str10).append(' ');
        String str11 = this.messageId;
        if (str11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageId");
            str11 = null;
        }
        StringBuilder append8 = append7.append(str11).append(' ');
        String str12 = this.conversationId;
        if (str12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("conversationId");
            str12 = null;
        }
        objArr[0] = append8.append(str12).toString();
        printStream.printf("ArtifactPreviewActivity", objArr);
        TextView textView = this.tvTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            textView = null;
        }
        String str13 = this.path;
        if (str13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("path");
            str13 = null;
        }
        textView.setText(StringsKt.substringAfterLast$default(str13, '/', (String) null, 2, (Object) null));
        ImageView imageView = this.btnBack;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnBack");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.ArtifactPreviewActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtifactPreviewActivity.onCreate$lambda$3(ArtifactPreviewActivity.this, view);
            }
        });
        String str14 = this.path;
        if (str14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("path");
            str14 = null;
        }
        FileType fileType2 = getFileType(str14);
        this.fileType = fileType2;
        if (fileType2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileType");
        } else {
            fileType = fileType2;
        }
        if (fileType == FileType.OTHER) {
            showDownloadOnly();
        } else {
            preview();
        }
        setupBtnDownload();
    }

    public static final void onCreate$lambda$3(ArtifactPreviewActivity artifactPreviewActivity, View view) {
        try {
            ArtifactTrack artifactTrack = ArtifactTrack.INSTANCE;
            String str = artifactPreviewActivity.path;
            String str2 = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("path");
                str = null;
            }
            String str3 = artifactPreviewActivity.messageId;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messageId");
            } else {
                str2 = str3;
            }
            artifactTrack.trackArtifactClose(str, str2, System.currentTimeMillis() - artifactPreviewActivity.startTime);
        } catch (Throwable unused) {
        }
        artifactPreviewActivity.finish();
    }

    private final FileType getFileType(String path) {
        String lowerCase = StringsKt.substringAfterLast(path, '.', "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return IMAGE_EXTENSIONS.contains(lowerCase) ? FileType.IMAGE : MARKDOWN_EXTENSIONS.contains(lowerCase) ? FileType.MARKDOWN : CODE_EXTENSIONS.contains(lowerCase) ? FileType.CODE : TXT_EXTENSIONS.contains(lowerCase) ? FileType.TXT : HTML_EXTENSIONS.contains(lowerCase) ? FileType.HTML : FileType.OTHER;
    }

    static /* synthetic */ String normalizeFilePath$default(ArtifactPreviewActivity artifactPreviewActivity, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return artifactPreviewActivity.normalizeFilePath(str, str2);
    }

    private final String normalizeFilePath(String filePath, String workspacePath) {
        String str = workspacePath;
        if (!(str == null || str.length() == 0)) {
            String str2 = StringsKt.endsWith$default(workspacePath, "/", false, 2, (Object) null) ? workspacePath : workspacePath + '/';
            if (StringsKt.endsWith$default(workspacePath, "/", false, 2, (Object) null)) {
                workspacePath = StringsKt.dropLast(workspacePath, 1);
            }
            for (String str3 : CollectionsKt.listOf(new String[]{str2, workspacePath})) {
                if (StringsKt.startsWith$default(filePath, str3, false, 2, (Object) null)) {
                    String substring = filePath.substring(str3.length());
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    return StringsKt.removePrefix(substring, "/");
                }
            }
        }
        if (!StringsKt.startsWith$default(filePath, "/", false, 2, (Object) null)) {
            return filePath;
        }
        String substring2 = filePath.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        return substring2;
    }

    private final String buildFileUrl(String explorerUrl, String path) {
        String encode = URLEncoder.encode(path, "UTF-8");
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        String xTToken = iLoginService != null ? iLoginService.getXTToken() : null;
        if (xTToken == null) {
            xTToken = "";
        }
        return StringsKt.trimEnd(explorerUrl, new char[]{'/'}) + "/file/" + encode + "?download=true&authorization=" + URLEncoder.encode("Cloud-IDE-JWT " + xTToken, "UTF-8");
    }

    private final void preview() {
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        progressBar.setVisibility(0);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new ArtifactPreviewActivity$preview$1(this, null), 3, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0291  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchFileUrl(Continuation<? super String> continuation) {
        ArtifactPreviewActivity$fetchFileUrl$1 artifactPreviewActivity$fetchFileUrl$1;
        int i;
        String str;
        ArtifactPreviewActivity artifactPreviewActivity;
        long j;
        Map map;
        long j2;
        Map map2;
        ArtifactPreviewActivity artifactPreviewActivity2;
        HttpDataResult.Success success;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        if (continuation instanceof ArtifactPreviewActivity$fetchFileUrl$1) {
            artifactPreviewActivity$fetchFileUrl$1 = (ArtifactPreviewActivity$fetchFileUrl$1) continuation;
            if ((artifactPreviewActivity$fetchFileUrl$1.label & Integer.MIN_VALUE) != 0) {
                artifactPreviewActivity$fetchFileUrl$1.label -= Integer.MIN_VALUE;
                Object obj = artifactPreviewActivity$fetchFileUrl$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = artifactPreviewActivity$fetchFileUrl$1.label;
                if (i == 0) {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        long j3 = artifactPreviewActivity$fetchFileUrl$1.J$0;
                        map = (Map) artifactPreviewActivity$fetchFileUrl$1.L$1;
                        ArtifactPreviewActivity artifactPreviewActivity3 = (ArtifactPreviewActivity) artifactPreviewActivity$fetchFileUrl$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        artifactPreviewActivity = artifactPreviewActivity3;
                        j = j3;
                        str = null;
                        str10 = (String) obj;
                        if (str10 != null) {
                            ExtrasKt.putExtra(map, "dowload_url", "");
                            String str13 = artifactPreviewActivity.isDeleted ? "file_deleted" : "download_url_null";
                            String str14 = artifactPreviewActivity.cliType;
                            if (str14 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("cliType");
                                str12 = str;
                            } else {
                                str12 = str14;
                            }
                            reportFetchFileUrlEvent$default(artifactPreviewActivity, "fail", str13, str12, j, null, null, 48, null);
                        } else {
                            ExtrasKt.putExtra(map, "dowload_url", str10);
                            String str15 = artifactPreviewActivity.cliType;
                            if (str15 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("cliType");
                                str11 = str;
                            } else {
                                str11 = str15;
                            }
                            reportFetchFileUrlEvent$default(artifactPreviewActivity, "success", "", str11, j, null, null, 48, null);
                        }
                        Ensure.ensureNotReachHereWithLogType("ArtifactPreviewActivity", new Throwable(), "ArtifactPreviewActivity:Error " + map);
                        return str10;
                    }
                    long j4 = artifactPreviewActivity$fetchFileUrl$1.J$0;
                    map2 = (Map) artifactPreviewActivity$fetchFileUrl$1.L$1;
                    artifactPreviewActivity2 = (ArtifactPreviewActivity) artifactPreviewActivity$fetchFileUrl$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    j2 = j4;
                    success = (HttpDataResult) obj;
                    FLogger.INSTANCE.d("ArtifactPreviewActivity", "fetchFileUrl：" + success + ' ');
                    FLogger fLogger = FLogger.INSTANCE;
                    StringBuilder sb = new StringBuilder("onCreate：");
                    str2 = artifactPreviewActivity2.chatSessionId;
                    if (str2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("chatSessionId");
                        str2 = null;
                    }
                    StringBuilder append = sb.append(str2).append(' ');
                    str3 = artifactPreviewActivity2.cliType;
                    if (str3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cliType");
                        str3 = null;
                    }
                    StringBuilder append2 = append.append(str3).append(' ');
                    str4 = artifactPreviewActivity2.path;
                    if (str4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("path");
                        str4 = null;
                    }
                    StringBuilder append3 = append2.append(str4).append(' ');
                    str5 = artifactPreviewActivity2.messageId;
                    if (str5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("messageId");
                        str5 = null;
                    }
                    StringBuilder append4 = append3.append(str5).append(' ');
                    str6 = artifactPreviewActivity2.conversationId;
                    if (str6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
                        str6 = null;
                    }
                    fLogger.d("ArtifactPreviewActivity", append4.append(str6).toString());
                    if (!(success instanceof HttpDataResult.Success)) {
                        HttpDataResult.Success success2 = success;
                        ChatSessionResponse chatSessionResponse = (ChatSessionResponse) success2.getBizResp().getData();
                        String explorerUrl = chatSessionResponse != null ? chatSessionResponse.getExplorerUrl() : null;
                        ChatSessionResponse chatSessionResponse2 = (ChatSessionResponse) success2.getBizResp().getData();
                        String workspacePath = chatSessionResponse2 != null ? chatSessionResponse2.getWorkspacePath() : null;
                        String str16 = artifactPreviewActivity2.path;
                        if (str16 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("path");
                            str16 = null;
                        }
                        String normalizeFilePath = artifactPreviewActivity2.normalizeFilePath(str16, workspacePath);
                        FLogger.INSTANCE.d("ArtifactPreviewActivity", "fetchFileUrl" + normalizeFilePath + ' ');
                        FLogger fLogger2 = FLogger.INSTANCE;
                        StringBuilder sb2 = new StringBuilder("onCreate：");
                        String str17 = artifactPreviewActivity2.chatSessionId;
                        if (str17 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("chatSessionId");
                            str17 = null;
                        }
                        StringBuilder append5 = sb2.append(str17).append(' ');
                        String str18 = artifactPreviewActivity2.cliType;
                        if (str18 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("cliType");
                            str18 = null;
                        }
                        StringBuilder append6 = append5.append(str18).append(' ').append(normalizeFilePath).append(' ');
                        String str19 = artifactPreviewActivity2.messageId;
                        if (str19 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("messageId");
                            str19 = null;
                        }
                        StringBuilder append7 = append6.append(str19).append(' ');
                        String str20 = artifactPreviewActivity2.conversationId;
                        if (str20 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("conversationId");
                            str20 = null;
                        }
                        fLogger2.d("ArtifactPreviewActivity", append7.append(str20).toString());
                        String str21 = explorerUrl;
                        if (str21 == null || str21.length() == 0) {
                            ExtrasKt.putExtra(map2, "explorerUrl", "");
                            Ensure.ensureNotReachHere("ArtifactPreviewActivity", new Throwable(), "ArtifactPreviewActivity:Success", map2);
                            String str22 = artifactPreviewActivity2.cliType;
                            if (str22 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("cliType");
                                str9 = null;
                            } else {
                                str9 = str22;
                            }
                            reportFetchFileUrlEvent$default(artifactPreviewActivity2, "fail", "explorer_url_empty", str9, j2, null, null, 48, null);
                            return null;
                        }
                        String buildFileUrl = artifactPreviewActivity2.buildFileUrl(explorerUrl, normalizeFilePath);
                        ExtrasKt.putExtra(map2, "explorerUrl", explorerUrl);
                        ExtrasKt.putExtra(map2, "buildPath", buildFileUrl);
                        Ensure.ensureNotReachHere("ArtifactPreviewActivity", new Throwable(), "ArtifactPreviewActivity:Success", map2);
                        String str23 = artifactPreviewActivity2.cliType;
                        if (str23 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("cliType");
                            str8 = null;
                        } else {
                            str8 = str23;
                        }
                        reportFetchFileUrlEvent$default(artifactPreviewActivity2, "success", "", str8, j2, null, null, 48, null);
                        return buildFileUrl;
                    }
                    if (!(success instanceof HttpDataResult.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Ensure.ensureNotReachHere("ArtifactPreviewActivity", new Throwable(), "ArtifactPreviewActivity:Error", map2);
                    String str24 = artifactPreviewActivity2.cliType;
                    if (str24 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cliType");
                        str7 = null;
                    } else {
                        str7 = str24;
                    }
                    HttpDataResult.Error error = (HttpDataResult.Error) success;
                    artifactPreviewActivity2.reportFetchFileUrlEvent("fail", "remote_request_error", str7, j2, String.valueOf(error.getCode()), error.getMsg());
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Pair[] pairArr = new Pair[5];
                String str25 = this.chatSessionId;
                if (str25 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatSessionId");
                    str25 = null;
                }
                pairArr[0] = TuplesKt.to("chatSessionId", str25);
                String str26 = this.cliType;
                if (str26 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cliType");
                    str26 = null;
                }
                pairArr[1] = TuplesKt.to("cliType", str26);
                String str27 = this.path;
                if (str27 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("path");
                    str27 = null;
                }
                pairArr[2] = TuplesKt.to("path", str27);
                String str28 = this.messageId;
                if (str28 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("messageId");
                    str28 = null;
                }
                pairArr[3] = TuplesKt.to("messageId", str28);
                String str29 = this.conversationId;
                if (str29 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("conversationId");
                    str29 = null;
                }
                pairArr[4] = TuplesKt.to("conversationId", str29);
                Map mapOf = MapsKt.mapOf(pairArr);
                long currentTimeMillis = System.currentTimeMillis();
                FLogger.INSTANCE.d("ArtifactPreviewActivity", "fetchFileUrl paramsMap: " + mapOf);
                String str30 = this.cliType;
                if (str30 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cliType");
                    str30 = null;
                }
                if (Intrinsics.areEqual(str30, CliType.REMOTE.getValue())) {
                    IChatSessionApi.Companion companion = IChatSessionApi.INSTANCE;
                    String str31 = this.chatSessionId;
                    if (str31 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("chatSessionId");
                        str31 = null;
                    }
                    artifactPreviewActivity$fetchFileUrl$1.L$0 = this;
                    artifactPreviewActivity$fetchFileUrl$1.L$1 = mapOf;
                    artifactPreviewActivity$fetchFileUrl$1.J$0 = currentTimeMillis;
                    artifactPreviewActivity$fetchFileUrl$1.label = 1;
                    Object chatSessionRawCall = companion.getChatSessionRawCall(str31, artifactPreviewActivity$fetchFileUrl$1);
                    if (chatSessionRawCall == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j2 = currentTimeMillis;
                    map2 = mapOf;
                    obj = chatSessionRawCall;
                    artifactPreviewActivity2 = this;
                    success = (HttpDataResult) obj;
                    FLogger.INSTANCE.d("ArtifactPreviewActivity", "fetchFileUrl：" + success + ' ');
                    FLogger fLogger3 = FLogger.INSTANCE;
                    StringBuilder sb3 = new StringBuilder("onCreate：");
                    str2 = artifactPreviewActivity2.chatSessionId;
                    if (str2 == null) {
                    }
                    StringBuilder append8 = sb3.append(str2).append(' ');
                    str3 = artifactPreviewActivity2.cliType;
                    if (str3 == null) {
                    }
                    StringBuilder append22 = append8.append(str3).append(' ');
                    str4 = artifactPreviewActivity2.path;
                    if (str4 == null) {
                    }
                    StringBuilder append32 = append22.append(str4).append(' ');
                    str5 = artifactPreviewActivity2.messageId;
                    if (str5 == null) {
                    }
                    StringBuilder append42 = append32.append(str5).append(' ');
                    str6 = artifactPreviewActivity2.conversationId;
                    if (str6 == null) {
                    }
                    fLogger3.d("ArtifactPreviewActivity", append42.append(str6).toString());
                    if (!(success instanceof HttpDataResult.Success)) {
                    }
                } else {
                    str = null;
                    String str32 = this.path;
                    if (str32 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("path");
                        str32 = null;
                    }
                    artifactPreviewActivity$fetchFileUrl$1.L$0 = this;
                    artifactPreviewActivity$fetchFileUrl$1.L$1 = mapOf;
                    artifactPreviewActivity$fetchFileUrl$1.J$0 = currentTimeMillis;
                    artifactPreviewActivity$fetchFileUrl$1.label = 2;
                    Object fetchDownloadUrlWithRetry = fetchDownloadUrlWithRetry(str32, artifactPreviewActivity$fetchFileUrl$1);
                    if (fetchDownloadUrlWithRetry == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    artifactPreviewActivity = this;
                    j = currentTimeMillis;
                    map = mapOf;
                    obj = fetchDownloadUrlWithRetry;
                    str10 = (String) obj;
                    if (str10 != null) {
                    }
                    Ensure.ensureNotReachHereWithLogType("ArtifactPreviewActivity", new Throwable(), "ArtifactPreviewActivity:Error " + map);
                    return str10;
                }
            }
        }
        artifactPreviewActivity$fetchFileUrl$1 = new ArtifactPreviewActivity$fetchFileUrl$1(this, continuation);
        Object obj2 = artifactPreviewActivity$fetchFileUrl$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = artifactPreviewActivity$fetchFileUrl$1.label;
        if (i == 0) {
        }
    }

    static /* synthetic */ void reportFetchFileUrlEvent$default(ArtifactPreviewActivity artifactPreviewActivity, String str, String str2, String str3, long j, String str4, String str5, int i, Object obj) {
        artifactPreviewActivity.reportFetchFileUrlEvent(str, str2, str3, j, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x009f, code lost:
    
        r6.put("error_message", r11);
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b A[Catch: all -> 0x00b1, TryCatch #0 {all -> 0x00b1, blocks: (B:2:0x0000, B:6:0x0025, B:7:0x002a, B:9:0x0045, B:10:0x004b, B:12:0x0054, B:13:0x005a, B:15:0x0063, B:16:0x0069, B:19:0x0072, B:20:0x0077, B:22:0x007f, B:27:0x008b, B:28:0x0090, B:30:0x0095, B:35:0x009f, B:36:0x00a4), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void reportFetchFileUrlEvent(String r5, String reason, String cliType, long fetchStartTime, String r10, String errorMessage) {
        boolean z;
        String str;
        try {
            Result.Companion companion = Result.Companion;
            ArtifactPreviewActivity artifactPreviewActivity = this;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PageDataManager.EXTRA_STATUS, r5);
            jSONObject.put("cli_type", cliType);
            boolean z2 = true;
            if (reason.length() > 0) {
                jSONObject.put("reason", reason);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("duration_ms", System.currentTimeMillis() - fetchStartTime);
            JSONObject jSONObject3 = new JSONObject();
            String str2 = this.chatSessionId;
            String str3 = null;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatSessionId");
                str2 = null;
            }
            jSONObject3.put("chat_session_id", str2);
            String str4 = this.conversationId;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("conversationId");
                str4 = null;
            }
            jSONObject3.put("conversation_id", str4);
            String str5 = this.messageId;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messageId");
                str5 = null;
            }
            jSONObject3.put("message_id", str5);
            String str6 = this.path;
            if (str6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("path");
            } else {
                str3 = str6;
            }
            jSONObject3.put("path", str3);
            String str7 = r10;
            if (str7 != null && str7.length() != 0) {
                z = false;
                if (!z) {
                    jSONObject3.put("error_code", r10);
                }
                str = errorMessage;
                if (str != null && str.length() != 0) {
                    z2 = false;
                }
                ApmService.INSTANCE.monitorEventForSlardar(EVENT_FETCH_FILE_URL, jSONObject, jSONObject2, jSONObject3);
                Result.constructor-impl(Unit.INSTANCE);
            }
            z = true;
            if (!z) {
            }
            str = errorMessage;
            if (str != null) {
                z2 = false;
            }
            ApmService.INSTANCE.monitorEventForSlardar(EVENT_FETCH_FILE_URL, jSONObject, jSONObject2, jSONObject3);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e2, code lost:
    
        if ((r7.length() == 0) != false) goto L114;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00f7 -> B:11:0x010a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0107 -> B:11:0x010a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchDownloadUrlWithRetry(String str, Continuation<? super String> continuation) {
        ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1 artifactPreviewActivity$fetchDownloadUrlWithRetry$1;
        ArtifactPreviewActivity artifactPreviewActivity;
        int i;
        String str2;
        ArtifactPreviewActivity artifactPreviewActivity2;
        int i2;
        ArtifactPreviewActivity artifactPreviewActivity3;
        String str3;
        HttpDataResult.Success success;
        Map<String, String> urlMap;
        Map<String, String> urlMap2;
        if (continuation instanceof ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1) {
            artifactPreviewActivity$fetchDownloadUrlWithRetry$1 = (ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1) continuation;
            if ((artifactPreviewActivity$fetchDownloadUrlWithRetry$1.label & Integer.MIN_VALUE) != 0) {
                artifactPreviewActivity$fetchDownloadUrlWithRetry$1.label -= Integer.MIN_VALUE;
                artifactPreviewActivity = this;
                Object obj = artifactPreviewActivity$fetchDownloadUrlWithRetry$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = artifactPreviewActivity$fetchDownloadUrlWithRetry$1.label;
                String str4 = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    str2 = str;
                    artifactPreviewActivity2 = artifactPreviewActivity;
                    i2 = 0;
                    if (i2 < 21) {
                    }
                } else if (i == 1) {
                    i2 = artifactPreviewActivity$fetchDownloadUrlWithRetry$1.I$0;
                    str3 = (String) artifactPreviewActivity$fetchDownloadUrlWithRetry$1.L$1;
                    artifactPreviewActivity3 = (ArtifactPreviewActivity) artifactPreviewActivity$fetchDownloadUrlWithRetry$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    success = (HttpDataResult) obj;
                    if (!(success instanceof HttpDataResult.Success)) {
                    }
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = artifactPreviewActivity$fetchDownloadUrlWithRetry$1.I$0;
                    str3 = (String) artifactPreviewActivity$fetchDownloadUrlWithRetry$1.L$1;
                    artifactPreviewActivity3 = (ArtifactPreviewActivity) artifactPreviewActivity$fetchDownloadUrlWithRetry$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    str2 = str3;
                    artifactPreviewActivity2 = artifactPreviewActivity3;
                    i2++;
                    if (i2 < 21) {
                        IGetDownloadUrlApi.Companion companion = IGetDownloadUrlApi.INSTANCE;
                        List listOf = CollectionsKt.listOf(str2);
                        String str5 = artifactPreviewActivity2.conversationId;
                        if (str5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("conversationId");
                            str5 = null;
                        }
                        String str6 = artifactPreviewActivity2.messageId;
                        if (str6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("messageId");
                            str6 = null;
                        }
                        GetDownloadUrlRequest getDownloadUrlRequest = new GetDownloadUrlRequest(listOf, str5, str6, Boxing.boxBoolean(true));
                        artifactPreviewActivity$fetchDownloadUrlWithRetry$1.L$0 = artifactPreviewActivity2;
                        artifactPreviewActivity$fetchDownloadUrlWithRetry$1.L$1 = str2;
                        artifactPreviewActivity$fetchDownloadUrlWithRetry$1.I$0 = i2;
                        artifactPreviewActivity$fetchDownloadUrlWithRetry$1.label = 1;
                        Object downloadUrlRawCall = companion.getDownloadUrlRawCall(getDownloadUrlRequest, artifactPreviewActivity$fetchDownloadUrlWithRetry$1);
                        if (downloadUrlRawCall == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ArtifactPreviewActivity artifactPreviewActivity4 = artifactPreviewActivity2;
                        str3 = str2;
                        obj = downloadUrlRawCall;
                        artifactPreviewActivity3 = artifactPreviewActivity4;
                        success = (HttpDataResult) obj;
                        if (!(success instanceof HttpDataResult.Success)) {
                            HttpDataResult.Success success2 = success;
                            GetDownloadUrlData getDownloadUrlData = (GetDownloadUrlData) success2.getBizResp().getData();
                            if (((getDownloadUrlData == null || (urlMap2 = getDownloadUrlData.getUrlMap()) == null) ? null : urlMap2.get(str3)) != null) {
                                GetDownloadUrlData getDownloadUrlData2 = (GetDownloadUrlData) success2.getBizResp().getData();
                                if (getDownloadUrlData2 != null && (urlMap = getDownloadUrlData2.getUrlMap()) != null) {
                                    str4 = urlMap.get(str3);
                                }
                                if (str4 != null) {
                                }
                                artifactPreviewActivity3.isDeleted = true;
                                return str4;
                            }
                            if (success2.getBizResp().getCode() != 202) {
                                artifactPreviewActivity3.isDeleted = true;
                                return null;
                            }
                            if (i2 < 20) {
                                artifactPreviewActivity$fetchDownloadUrlWithRetry$1.L$0 = artifactPreviewActivity3;
                                artifactPreviewActivity$fetchDownloadUrlWithRetry$1.L$1 = str3;
                                artifactPreviewActivity$fetchDownloadUrlWithRetry$1.I$0 = i2;
                                artifactPreviewActivity$fetchDownloadUrlWithRetry$1.label = 2;
                                if (DelayKt.delay(2000L, artifactPreviewActivity$fetchDownloadUrlWithRetry$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            str2 = str3;
                            artifactPreviewActivity2 = artifactPreviewActivity3;
                            i2++;
                            if (i2 < 21) {
                                return null;
                            }
                        } else {
                            if (success instanceof HttpDataResult.Error) {
                                return null;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                }
            }
        }
        artifactPreviewActivity = this;
        artifactPreviewActivity$fetchDownloadUrlWithRetry$1 = new ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1(artifactPreviewActivity, continuation);
        Object obj2 = artifactPreviewActivity$fetchDownloadUrlWithRetry$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = artifactPreviewActivity$fetchDownloadUrlWithRetry$1.label;
        String str42 = null;
        if (i != 0) {
        }
    }

    public final void showImagePreview(String imageUrl) {
        String str = this.cliType;
        FrameLayout frameLayout = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cliType");
            str = null;
        }
        if (!Intrinsics.areEqual(str, CliType.LOCAL.getValue())) {
            String str2 = this.cliType;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cliType");
                str2 = null;
            }
            if (!Intrinsics.areEqual(str2, CliType.IDE.getValue())) {
                ProgressBar progressBar = this.progressBar;
                if (progressBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                    progressBar = null;
                }
                progressBar.setVisibility(8);
                FrameLayout frameLayout2 = this.imageContainer;
                if (frameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageContainer");
                    frameLayout2 = null;
                }
                frameLayout2.setVisibility(0);
                Uri parse = Uri.parse(imageUrl);
                Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                loadImage(parse);
                ArtifactTrack artifactTrack = ArtifactTrack.INSTANCE;
                String str3 = this.path;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("path");
                    str3 = null;
                }
                String str4 = this.messageId;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("messageId");
                    str4 = null;
                }
                artifactTrack.trackArtifactOpen(str3, str4);
                FrameLayout frameLayout3 = this.imageContainer;
                if (frameLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageContainer");
                } else {
                    frameLayout = frameLayout3;
                }
                setupImageTouchHandling(frameLayout);
                return;
            }
        }
        if (StringsKt.startsWith$default(imageUrl, "content://", false, 2, (Object) null) || StringsKt.startsWith$default(imageUrl, "file://", false, 2, (Object) null)) {
            ProgressBar progressBar2 = this.progressBar;
            if (progressBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                progressBar2 = null;
            }
            progressBar2.setVisibility(8);
            FrameLayout frameLayout4 = this.imageContainer;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageContainer");
                frameLayout4 = null;
            }
            frameLayout4.setVisibility(0);
            Uri parse2 = Uri.parse(imageUrl);
            Intrinsics.checkNotNullExpressionValue(parse2, "parse(...)");
            loadImage(parse2);
            FrameLayout frameLayout5 = this.imageContainer;
            if (frameLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageContainer");
            } else {
                frameLayout = frameLayout5;
            }
            setupImageTouchHandling(frameLayout);
            return;
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new ArtifactPreviewActivity$showImagePreview$1(this, imageUrl, null), 3, (Object) null);
    }

    public final void loadImage(Uri imageUri) {
        PipelineDraweeControllerBuilder autoPlayAnimations = Fresco.newDraweeControllerBuilder().setUri(imageUri).setAutoPlayAnimations(true);
        SimpleDraweeView simpleDraweeView = this.ivPreview;
        SimpleDraweeView simpleDraweeView2 = null;
        if (simpleDraweeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPreview");
            simpleDraweeView = null;
        }
        DraweeController build = autoPlayAnimations.setOldController(simpleDraweeView.getController()).build();
        SimpleDraweeView simpleDraweeView3 = this.ivPreview;
        if (simpleDraweeView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPreview");
        } else {
            simpleDraweeView2 = simpleDraweeView3;
        }
        simpleDraweeView2.setController(build);
    }

    public final void showCodePreview(String fileUrl) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new ArtifactPreviewActivity$showCodePreview$1(this, fileUrl, null), 3, (Object) null);
    }

    private final void showHtmlPreview(String fileUrl) {
        ProgressBar progressBar = this.progressBar;
        WebView webView = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        progressBar.setVisibility(8);
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
        } else {
            webView = webView5;
        }
        webView.loadUrl(fileUrl);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, com.bytedance.trae.im.service.CliType.IDE.getValue()) != false) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String fetchTextViaTTNet(final String r6) {
        try {
            ArrayList arrayList = new ArrayList();
            String str = this.cliType;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cliType");
                str = null;
            }
            if (!Intrinsics.areEqual(str, CliType.LOCAL.getValue())) {
                String str2 = this.cliType;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cliType");
                    str2 = null;
                }
            }
            arrayList.add(new Interceptor() { // from class: com.bytedance.trae.conversation.products.ArtifactPreviewActivity$$ExternalSyntheticLambda9
                public final SsResponse intercept(Interceptor.Chain chain) {
                    SsResponse fetchTextViaTTNet$lambda$9;
                    fetchTextViaTTNet$lambda$9 = ArtifactPreviewActivity.fetchTextViaTTNet$lambda$9(r6, chain);
                    return fetchTextViaTTNet$lambda$9;
                }
            });
            TxtFetchApi txtFetchApi = (TxtFetchApi) RetrofitUtils.createSsRetrofit("https://placeholder.trae/", arrayList, (Converter.Factory) null).create(TxtFetchApi.class);
            if (txtFetchApi == null) {
                return null;
            }
            SsResponse execute = txtFetchApi.get(r6, 31457280).execute();
            Intrinsics.checkNotNullExpressionValue(execute, "execute(...)");
            TypedInput typedInput = (TypedInput) execute.body();
            if (typedInput == null) {
                return "";
            }
            InputStream in = typedInput.in();
            Intrinsics.checkNotNullExpressionValue(in, "in(...)");
            byte[] readAllBytes = readAllBytes(in);
            String str3 = this.cliType;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cliType");
                str3 = null;
            }
            if (!Intrinsics.areEqual(str3, CliType.LOCAL.getValue())) {
                String str4 = this.cliType;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cliType");
                    str4 = null;
                }
                if (!Intrinsics.areEqual(str4, CliType.IDE.getValue())) {
                    return new String(readAllBytes, Charsets.UTF_8);
                }
            }
            return new String(ResourceUploadUtilKt.decodeContent(readAllBytes), Charsets.UTF_8);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final SsResponse fetchTextViaTTNet$lambda$9(String str, Interceptor.Chain chain) {
        Request request;
        if (chain == null || (request = chain.request()) == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(Uri.parse(request.getUrl()).buildUpon().clearQuery().build().toString(), "toString(...)");
        return chain.proceed(request.newBuilder().url(str).build());
    }

    public final void downloadAndShowTxt(String fileUrl) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new ArtifactPreviewActivity$downloadAndShowTxt$1(this, fileUrl, null), 3, (Object) null);
    }

    public final void loadMarkdownPreview(String fileUrl, String chatSessionId, String path) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new ArtifactPreviewActivity$loadMarkdownPreview$1(path, this, fileUrl, chatSessionId, null), 3, (Object) null);
    }

    public final void showDownloadWithUrl(String fileUrl, String chatSessionId, String path) {
        ProgressBar progressBar = this.progressBar;
        LinearLayout linearLayout = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        LinearLayout linearLayout2 = this.layoutContent;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.setVisibility(0);
        setupDownloadButtons(fileUrl, chatSessionId, path);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void showLoadingDialog() {
        Dialog dialog = this.loadingDialog;
        if (dialog != null && dialog.isShowing()) {
            return;
        }
        Context context = (Context) this;
        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setIndeterminate(true);
        FrameLayout frameLayout = new FrameLayout(context);
        int i = (int) (24 * frameLayout.getResources().getDisplayMetrics().density);
        frameLayout.setPadding(i, i, i, i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(progressBar, layoutParams);
        Dialog dialog2 = new Dialog(context);
        dialog2.setContentView(frameLayout);
        dialog2.setCancelable(false);
        Window window = dialog2.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
        dialog2.show();
        this.loadingDialog = dialog2;
    }

    public final void hideLoadingDialog() {
        Dialog dialog = this.loadingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.loadingDialog = null;
    }

    private final void showDownloadOnly() {
        ProgressBar progressBar = this.progressBar;
        TextView textView = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        progressBar.setVisibility(0);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new ArtifactPreviewActivity$showDownloadOnly$1(this, null), 3, (Object) null);
        TextView textView2 = this.btnMainDownload;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMainDownload");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.ArtifactPreviewActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtifactPreviewActivity.showDownloadOnly$lambda$14(ArtifactPreviewActivity.this, view);
            }
        });
    }

    public static final void showDownloadOnly$lambda$14(ArtifactPreviewActivity artifactPreviewActivity, View view) {
        try {
            ArtifactTrack artifactTrack = ArtifactTrack.INSTANCE;
            String str = artifactPreviewActivity.path;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("path");
                str = null;
            }
            String str2 = artifactPreviewActivity.messageId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messageId");
                str2 = null;
            }
            artifactTrack.trackArtifactOpenLocal(str, str2);
        } catch (Throwable unused) {
        }
        FileDownloadHelper fileDownloadHelper = artifactPreviewActivity.fileDownloadHelper;
        Application application = AppHost.INSTANCE.getApplication();
        String str3 = artifactPreviewActivity.path;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("path");
            str3 = null;
        }
        String existingFilePath = fileDownloadHelper.getExistingFilePath(application, str3);
        if (existingFilePath != null) {
            artifactPreviewActivity.openFileWithExternalApp(existingFilePath);
        } else {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) artifactPreviewActivity), (CoroutineContext) null, (CoroutineStart) null, new ArtifactPreviewActivity$showDownloadOnly$2$1(artifactPreviewActivity, null), 3, (Object) null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void openFileWithExternalApp(String savedPath) {
        try {
            File file = new File(savedPath);
            if (file.exists()) {
                String lowerCase = StringsKt.substringAfterLast(savedPath, '.', "").toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                if (mimeTypeFromExtension == null) {
                    mimeTypeFromExtension = "application/octet-stream";
                }
                Uri uriForFile = FileProvider.getUriForFile((Context) this, getPackageName() + ".uri.key", file);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(uriForFile, mimeTypeFromExtension);
                intent.addFlags(1);
                intent.addFlags(268435456);
                Intent createChooser = Intent.createChooser(intent, null);
                createChooser.addFlags(268435456);
                startActivity(createChooser);
            }
        } catch (Throwable unused) {
        }
    }

    private final void showDirError() {
        ProgressBar progressBar = this.progressBar;
        TextView textView = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        progressBar.setVisibility(8);
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
        textView2.setText(getString(R.string.trae_artifact_dir_error));
        TextView textView3 = this.btnMainDownload;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMainDownload");
        } else {
            textView = textView3;
        }
        textView.setVisibility(8);
        View findViewById = findViewById(C0637R.id.ll_trailing_actions);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    public final void showArtifactDelete() {
        ProgressBar progressBar = this.progressBar;
        TextView textView = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        progressBar.setVisibility(8);
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
        textView2.setText(R.string.trae_artifact_delete);
        TextView textView3 = this.btnMainDownload;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMainDownload");
        } else {
            textView = textView3;
        }
        textView.setVisibility(8);
        View findViewById = findViewById(C0637R.id.ll_trailing_actions);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    public final void showError() {
        ProgressBar progressBar = this.progressBar;
        TextView textView = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        progressBar.setVisibility(8);
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
        textView2.setText(R.string.trae_doc_preview_connect_error);
        TextView textView3 = this.btnMainDownload;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMainDownload");
            textView3 = null;
        }
        textView3.setText(R.string.trae_doc_preview_retry);
        TextView textView4 = this.btnMainDownload;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMainDownload");
        } else {
            textView = textView4;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.ArtifactPreviewActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtifactPreviewActivity.showError$lambda$17(ArtifactPreviewActivity.this, view);
            }
        });
    }

    public static final void showError$lambda$17(ArtifactPreviewActivity artifactPreviewActivity, View view) {
        LinearLayout linearLayout = artifactPreviewActivity.layoutContent;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        artifactPreviewActivity.preview();
    }

    private final void setupBtnDownload() {
        View view = this.btnDownload;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnDownload");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.ArtifactPreviewActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ArtifactPreviewActivity.setupBtnDownload$lambda$19(ArtifactPreviewActivity.this, view2);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void setupBtnDownload$lambda$19(ArtifactPreviewActivity artifactPreviewActivity, View view) {
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        try {
            String str5 = artifactPreviewActivity.path;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("path");
                str5 = null;
            }
            String lowerCase = StringsKt.substringAfterLast(str5, '.', "").toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("artifact_type", lowerCase);
            IApplog.INSTANCE.reportEvent("icube_artifact_download", jSONObject);
        } catch (Throwable unused) {
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        String str6 = artifactPreviewActivity.cliType;
        if (str6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cliType");
            str6 = null;
        }
        if (!Intrinsics.areEqual(str6, CliType.LOCAL.getValue())) {
            String str7 = artifactPreviewActivity.cliType;
            if (str7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cliType");
                str7 = null;
            }
            if (!Intrinsics.areEqual(str7, CliType.IDE.getValue())) {
                z = false;
                booleanRef.element = z;
                str = artifactPreviewActivity.fileUrl;
                if (str != null) {
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("fileUrl");
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        FileDownloadHelper fileDownloadHelper = artifactPreviewActivity.fileDownloadHelper;
                        String str8 = artifactPreviewActivity.fileUrl;
                        if (str8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("fileUrl");
                            str2 = null;
                        } else {
                            str2 = str8;
                        }
                        String str9 = artifactPreviewActivity.chatSessionId;
                        if (str9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("chatSessionId");
                            str3 = null;
                        } else {
                            str3 = str9;
                        }
                        String str10 = artifactPreviewActivity.path;
                        if (str10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("path");
                            str4 = null;
                        } else {
                            str4 = str10;
                        }
                        fileDownloadHelper.saveFileAndLoading((Context) artifactPreviewActivity, str2, str3, str4, (CoroutineScope) LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) artifactPreviewActivity), artifactPreviewActivity.downloadFinishCallback, booleanRef.element, artifactPreviewActivity.createdTime);
                        return;
                    }
                }
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) artifactPreviewActivity), (CoroutineContext) null, (CoroutineStart) null, new ArtifactPreviewActivity$setupBtnDownload$1$1(artifactPreviewActivity, booleanRef, null), 3, (Object) null);
            }
        }
        z = true;
        booleanRef.element = z;
        str = artifactPreviewActivity.fileUrl;
        if (str != null) {
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) artifactPreviewActivity), (CoroutineContext) null, (CoroutineStart) null, new ArtifactPreviewActivity$setupBtnDownload$1$1(artifactPreviewActivity, booleanRef, null), 3, (Object) null);
    }

    public final void setupDownloadButtons(final String r2, final String sessionId, final String path) {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.ArtifactPreviewActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtifactPreviewActivity.setupDownloadButtons$lambda$20(ArtifactPreviewActivity.this, r2, sessionId, path, view);
            }
        };
        View view = this.btnDownload;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnDownload");
            view = null;
        }
        view.setOnClickListener(onClickListener);
        TextView textView2 = this.btnMainDownload;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMainDownload");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(onClickListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void setupDownloadButtons$lambda$20(ArtifactPreviewActivity artifactPreviewActivity, String str, String str2, String str3, View view) {
        boolean z;
        String str4 = artifactPreviewActivity.cliType;
        String str5 = null;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cliType");
            str4 = null;
        }
        if (!Intrinsics.areEqual(str4, CliType.LOCAL.getValue())) {
            String str6 = artifactPreviewActivity.cliType;
            if (str6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cliType");
            } else {
                str5 = str6;
            }
            if (!Intrinsics.areEqual(str5, CliType.IDE.getValue())) {
                z = false;
                boolean z2 = z;
                artifactPreviewActivity.fileDownloadHelper.saveFileAndLoading((Context) artifactPreviewActivity, str, str2, str3, (CoroutineScope) LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) artifactPreviewActivity), artifactPreviewActivity.downloadFinishCallback, z2, artifactPreviewActivity.createdTime);
            }
        }
        z = true;
        boolean z22 = z;
        artifactPreviewActivity.fileDownloadHelper.saveFileAndLoading((Context) artifactPreviewActivity, str, str2, str3, (CoroutineScope) LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) artifactPreviewActivity), artifactPreviewActivity.downloadFinishCallback, z22, artifactPreviewActivity.createdTime);
    }

    public final void setupImageTouchHandling(View container) {
        container.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.trae.conversation.products.ArtifactPreviewActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                z = ArtifactPreviewActivity.setupImageTouchHandling$lambda$21(ArtifactPreviewActivity.this, view, motionEvent);
                return z;
            }
        });
    }

    public static final boolean setupImageTouchHandling$lambda$21(ArtifactPreviewActivity artifactPreviewActivity, View view, MotionEvent motionEvent) {
        int findPointerIndex;
        artifactPreviewActivity.getScaleGestureDetector().onTouchEvent(motionEvent);
        artifactPreviewActivity.getGestureDetector().onTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            artifactPreviewActivity.activePointerId = motionEvent.getPointerId(0);
            artifactPreviewActivity.lastTouchX = motionEvent.getX();
            artifactPreviewActivity.lastTouchY = motionEvent.getY();
            artifactPreviewActivity.isDragging = true;
        } else {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 5) {
                            artifactPreviewActivity.isDragging = false;
                        } else if (actionMasked == 6) {
                            int actionIndex = motionEvent.getActionIndex();
                            if (motionEvent.getPointerId(actionIndex) == artifactPreviewActivity.activePointerId) {
                                int i = actionIndex == 0 ? 1 : 0;
                                if (i < motionEvent.getPointerCount()) {
                                    artifactPreviewActivity.lastTouchX = motionEvent.getX(i);
                                    artifactPreviewActivity.lastTouchY = motionEvent.getY(i);
                                    artifactPreviewActivity.activePointerId = motionEvent.getPointerId(i);
                                }
                            }
                        }
                    }
                } else if (artifactPreviewActivity.isDragging && !artifactPreviewActivity.getScaleGestureDetector().isInProgress() && (findPointerIndex = motionEvent.findPointerIndex(artifactPreviewActivity.activePointerId)) >= 0) {
                    float x = motionEvent.getX(findPointerIndex);
                    float y = motionEvent.getY(findPointerIndex);
                    float f = x - artifactPreviewActivity.lastTouchX;
                    float f2 = y - artifactPreviewActivity.lastTouchY;
                    if (artifactPreviewActivity.currentScale > MIN_SCALE) {
                        SimpleDraweeView simpleDraweeView = artifactPreviewActivity.ivPreview;
                        SimpleDraweeView simpleDraweeView2 = null;
                        if (simpleDraweeView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("ivPreview");
                            simpleDraweeView = null;
                        }
                        simpleDraweeView.setTranslationX(simpleDraweeView.getTranslationX() + f);
                        SimpleDraweeView simpleDraweeView3 = artifactPreviewActivity.ivPreview;
                        if (simpleDraweeView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("ivPreview");
                        } else {
                            simpleDraweeView2 = simpleDraweeView3;
                        }
                        simpleDraweeView2.setTranslationY(simpleDraweeView2.getTranslationY() + f2);
                    }
                    artifactPreviewActivity.lastTouchX = x;
                    artifactPreviewActivity.lastTouchY = y;
                }
            }
            artifactPreviewActivity.isDragging = false;
            artifactPreviewActivity.activePointerId = -1;
        }
        return true;
    }

    public final void animateToScale(final float targetScale) {
        ValueAnimator valueAnimator = this.scaleAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        final float f = this.currentScale;
        SimpleDraweeView simpleDraweeView = this.ivPreview;
        SimpleDraweeView simpleDraweeView2 = null;
        if (simpleDraweeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPreview");
            simpleDraweeView = null;
        }
        final float translationX = simpleDraweeView.getTranslationX();
        SimpleDraweeView simpleDraweeView3 = this.ivPreview;
        if (simpleDraweeView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPreview");
        } else {
            simpleDraweeView2 = simpleDraweeView3;
        }
        final float translationY = simpleDraweeView2.getTranslationY();
        boolean z = targetScale == MIN_SCALE;
        final float f2 = z ? 0.0f : translationX;
        final float f3 = z ? 0.0f : translationY;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, MIN_SCALE);
        ofFloat.setDuration(250L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.trae.conversation.products.ArtifactPreviewActivity$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ArtifactPreviewActivity.animateToScale$lambda$23$lambda$22(f, targetScale, this, translationX, f2, translationY, f3, valueAnimator2);
            }
        });
        ofFloat.start();
        this.scaleAnimator = ofFloat;
    }

    public static final void animateToScale$lambda$23$lambda$22(float f, float f2, ArtifactPreviewActivity artifactPreviewActivity, float f3, float f4, float f5, float f6, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        float f7 = f + ((f2 - f) * floatValue);
        artifactPreviewActivity.currentScale = f7;
        SimpleDraweeView simpleDraweeView = artifactPreviewActivity.ivPreview;
        SimpleDraweeView simpleDraweeView2 = null;
        if (simpleDraweeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPreview");
            simpleDraweeView = null;
        }
        simpleDraweeView.setScaleX(f7);
        SimpleDraweeView simpleDraweeView3 = artifactPreviewActivity.ivPreview;
        if (simpleDraweeView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPreview");
            simpleDraweeView3 = null;
        }
        simpleDraweeView3.setScaleY(f7);
        SimpleDraweeView simpleDraweeView4 = artifactPreviewActivity.ivPreview;
        if (simpleDraweeView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPreview");
            simpleDraweeView4 = null;
        }
        simpleDraweeView4.setTranslationX(f3 + ((f4 - f3) * floatValue));
        SimpleDraweeView simpleDraweeView5 = artifactPreviewActivity.ivPreview;
        if (simpleDraweeView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPreview");
        } else {
            simpleDraweeView2 = simpleDraweeView5;
        }
        simpleDraweeView2.setTranslationY(f5 + ((f6 - f5) * floatValue));
    }

    public final String buildCodeHighlightHtml(String code, String r7) {
        StringBuilder sb = new StringBuilder(((int) (code.length() * 1.1d)) + StatusBarUtils.FLAG_NOTCH_PORTRAIT);
        sb.append("<!DOCTYPE html>\n<html>\n<head>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/styles/github.min.css\">\n<script src=\"https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/highlight.min.js\"></script>\n<style>\n    body { margin: 0; padding: 12px; background: #F5F6F8; }\n    pre { margin: 0; white-space: pre-wrap; word-wrap: break-word; }\n    code { font-size: 13px; line-height: 1.5; font-family: monospace; }\n</style>\n</head>\n<body>\n<pre><code class=\"language-");
        sb.append(r7);
        sb.append("\">");
        int length = code.length();
        for (int i = 0; i < length; i++) {
            char charAt = code.charAt(i);
            if (charAt == '\"') {
                sb.append("&quot;");
            } else if (charAt == '&') {
                sb.append("&amp;");
            } else if (charAt == '<') {
                sb.append("&lt;");
            } else if (charAt == '>') {
                sb.append("&gt;");
            } else {
                sb.append(charAt);
            }
        }
        sb.append("</code></pre>\n<script>hljs.highlightAll();</script>\n</body>\n</html>");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
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

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_conversation_products_ArtifactPreviewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m839x3c5cde3b(ArtifactPreviewActivity artifactPreviewActivity) {
        artifactPreviewActivity.m840x2fa42bc0();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) artifactPreviewActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
