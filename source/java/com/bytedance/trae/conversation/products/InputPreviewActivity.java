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
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.webkit.MimeTypeMap;
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
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.widget.CustomToast;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView;
import com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi;
import com.bytedance.trae.conversation.fileupload.ResourceUploadUtilKt;
import com.bytedance.trae.conversation.imageupload.ResourceRepoManager;
import com.bytedance.trae.home.solo.setting.SettingsTracker;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.im.service.ChatSessionResponse;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.GetDownloadUrlData;
import com.bytedance.trae.im.service.GetDownloadUrlRequest;
import com.bytedance.trae.im.service.IChatSessionApi;
import com.bytedance.trae.im.service.IGetDownloadUrlApi;
import com.bytedance.trae.im.service.Mode;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.FLogger;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
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
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: InputPreviewActivity.kt */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 t2\u00020\u0001:\u0003tuvB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010K\u001a\u0002062\b\u0010L\u001a\u0004\u0018\u00010MH\u0014J\u0010\u0010N\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020\u001fH\u0002J\b\u0010P\u001a\u000206H\u0002J\u0010\u0010Q\u001a\u0004\u0018\u00010\u001fH\u0082@¢\u0006\u0002\u0010RJ\u0010\u0010S\u001a\u0004\u0018\u00010\u001fH\u0082@¢\u0006\u0002\u0010RJ\u0010\u0010T\u001a\u0004\u0018\u00010\u001fH\u0082@¢\u0006\u0002\u0010RJ\u0010\u0010U\u001a\u0002062\u0006\u0010V\u001a\u00020\u001fH\u0002J\u0010\u0010W\u001a\u0002062\u0006\u0010&\u001a\u00020\u001fH\u0002J\u0012\u0010X\u001a\u0004\u0018\u00010\u001f2\u0006\u0010Y\u001a\u00020\u001fH\u0002J\u0010\u0010Z\u001a\u0002062\u0006\u0010&\u001a\u00020\u001fH\u0002J\u0010\u0010[\u001a\u0002062\u0006\u0010&\u001a\u00020\u001fH\u0002J\u0010\u0010\\\u001a\u0002062\u0006\u0010&\u001a\u00020\u001fH\u0002J\b\u0010]\u001a\u000206H\u0002J\b\u0010^\u001a\u000206H\u0002J\b\u0010_\u001a\u000206H\u0002J\u0010\u0010`\u001a\u0002062\u0006\u0010a\u001a\u00020\u001fH\u0002J\b\u0010b\u001a\u000206H\u0002J\u0010\u0010c\u001a\u0002062\u0006\u0010d\u001a\u00020eH\u0002J\b\u0010f\u001a\u000206H\u0002J\u0010\u0010g\u001a\u0002062\u0006\u0010Y\u001a\u00020\u001fH\u0002J\u0010\u0010h\u001a\u0002062\u0006\u0010i\u001a\u00020\u0019H\u0002J\u0010\u0010j\u001a\u0002062\u0006\u0010k\u001a\u00020:H\u0002J\u0018\u0010l\u001a\u00020\u001f2\u0006\u0010m\u001a\u00020\u001f2\u0006\u0010n\u001a\u00020\u001fH\u0002J\u0010\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020rH\u0002J\u0010\u0010s\u001a\u0004\u0018\u00010\u001fH\u0082@¢\u0006\u0002\u0010RR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b.\u0010/R&\u00102\u001a\u001a\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020603X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010A\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u00101\u001a\u0004\bC\u0010DR\u001b\u0010F\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u00101\u001a\u0004\bH\u0010I¨\u0006w"}, d2 = {"Lcom/bytedance/trae/conversation/products/InputPreviewActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "btnBack", "Landroid/widget/ImageView;", "tvTitle", "Landroid/widget/TextView;", "progressBar", "Landroid/widget/ProgressBar;", "imageContainer", "Landroid/widget/FrameLayout;", "ivPreview", "Lcom/facebook/drawee/view/SimpleDraweeView;", "webView", "Landroid/webkit/WebView;", "scrollMarkdown", "Landroid/widget/ScrollView;", "tvMarkdown", "Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;", "scrollTxt", "tvTxt", "layoutContent", "Landroid/widget/LinearLayout;", "btnDownload", "Landroid/view/View;", "btnMainDownload", "downloadStatusTitle", "fileType", "Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;", "oidId", "", "extraOidId", "fileName", "conversationId", "chatSessionId", "needDecode", "", "fileUrl", "cliType", "mode", "messageId", "loadingDialog", "Landroid/app/Dialog;", "resourceUploadApi", "Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;", "getResourceUploadApi", "()Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;", "resourceUploadApi$delegate", "Lkotlin/Lazy;", "downloadFinishCallback", "Lkotlin/Function3;", "", "", "", "fileDownloadHelper", "Lcom/bytedance/trae/conversation/products/FileDownloadHelper;", "currentScale", "", "lastTouchX", "lastTouchY", "isDragging", "activePointerId", "scaleAnimator", "Landroid/animation/ValueAnimator;", "scaleGestureDetector", "Landroid/view/ScaleGestureDetector;", "getScaleGestureDetector", "()Landroid/view/ScaleGestureDetector;", "scaleGestureDetector$delegate", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "gestureDetector$delegate", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "getFileType", "path", "preview", "fetchFileUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchRemoteResourceUrl", "fetchAssetDownloadUrlWithRetry", "showImagePreview", "imageUrl", "showCodePreview", "fetchTextViaTTNet", IWeixinService.ResponseConstants.URL, "downloadAndShowTxt", "loadMarkdownPreview", "showDownloadWithUrl", "showLoadingDialog", "hideLoadingDialog", "showDownloadOnly", "openFileWithExternalApp", "savedPath", "showError", "loadImage", "imageUri", "Landroid/net/Uri;", "setupBtnDownload", "setupDownloadButtons", "setupImageTouchHandling", "container", "animateToScale", "targetScale", "buildCodeHighlightHtml", "code", SettingsTracker.TYPE_LANGUAGE, "readAllBytes", "", "input", "Ljava/io/InputStream;", "fetchUrl", "Companion", "FileType", "FetchApi", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InputPreviewActivity extends TraeCommonAppCompatActivity {
    private static final long ANIM_DURATION = 250;
    private static final float DOUBLE_TAP_SCALE = 2.5f;
    private static final int DOWNLOAD_URL_MAX_RETRIES = 30;
    private static final long DOWNLOAD_URL_RETRY_DELAY_MS = 2000;
    private static final String EXTRA_CHAT_SESSION_ID = "extra_chat_session_id";
    private static final String EXTRA_CLI_TYPE = "extra_cli_type";
    private static final String EXTRA_CONVERSATION_ID = "extra_conversation_id";
    private static final String EXTRA_FILE_NAME = "extra_file_name";
    private static final String EXTRA_MESSAGE_ID = "extra_message_id";
    private static final String EXTRA_MODE = "extra_mode";
    private static final String EXTRA_OID_ID = "extra_oid_id";
    private static final float MAX_SCALE = 5.0f;
    private static final float MIN_SCALE = 1.0f;
    private static final String REMOTE_RESOURCE_PREFIX = "trae-res://remote_resource/";
    private ImageView btnBack;
    private View btnDownload;
    private TextView btnMainDownload;
    private String conversationId;
    private TextView downloadStatusTitle;
    private String fileName;
    private FileType fileType;
    private String fileUrl;
    private FrameLayout imageContainer;
    private boolean isDragging;
    private SimpleDraweeView ivPreview;
    private float lastTouchX;
    private float lastTouchY;
    private LinearLayout layoutContent;
    private Dialog loadingDialog;
    private boolean needDecode;
    private String oidId;
    private ProgressBar progressBar;
    private ValueAnimator scaleAnimator;
    private ScrollView scrollMarkdown;
    private ScrollView scrollTxt;
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
    private String extraOidId = "";
    private String chatSessionId = "";
    private String cliType = "";
    private String mode = "";
    private String messageId = "";

    /* renamed from: resourceUploadApi$delegate, reason: from kotlin metadata */
    private final Lazy resourceUploadApi = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.products.InputPreviewActivity$$ExternalSyntheticLambda11
        public final Object invoke() {
            ConversationCopilotResourceUploadApi resourceUploadApi_delegate$lambda$1;
            resourceUploadApi_delegate$lambda$1 = InputPreviewActivity.resourceUploadApi_delegate$lambda$1();
            return resourceUploadApi_delegate$lambda$1;
        }
    });
    private final Function3<Integer, String, Long, Unit> downloadFinishCallback = new Function3() { // from class: com.bytedance.trae.conversation.products.InputPreviewActivity$$ExternalSyntheticLambda12
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit downloadFinishCallback$lambda$2;
            downloadFinishCallback$lambda$2 = InputPreviewActivity.downloadFinishCallback$lambda$2(InputPreviewActivity.this, ((Integer) obj).intValue(), (String) obj2, ((Long) obj3).longValue());
            return downloadFinishCallback$lambda$2;
        }
    };
    private final FileDownloadHelper fileDownloadHelper = new FileDownloadHelper();
    private float currentScale = MIN_SCALE;
    private int activePointerId = -1;

    /* renamed from: scaleGestureDetector$delegate, reason: from kotlin metadata */
    private final Lazy scaleGestureDetector = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.products.InputPreviewActivity$$ExternalSyntheticLambda1
        public final Object invoke() {
            ScaleGestureDetector scaleGestureDetector_delegate$lambda$3;
            scaleGestureDetector_delegate$lambda$3 = InputPreviewActivity.scaleGestureDetector_delegate$lambda$3(InputPreviewActivity.this);
            return scaleGestureDetector_delegate$lambda$3;
        }
    });

    /* renamed from: gestureDetector$delegate, reason: from kotlin metadata */
    private final Lazy gestureDetector = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.products.InputPreviewActivity$$ExternalSyntheticLambda2
        public final Object invoke() {
            GestureDetector gestureDetector_delegate$lambda$4;
            gestureDetector_delegate$lambda$4 = InputPreviewActivity.gestureDetector_delegate$lambda$4(InputPreviewActivity.this);
            return gestureDetector_delegate$lambda$4;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: InputPreviewActivity.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bb\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FetchApi;", "", ApiRequest.METHOD_GET, "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", IWeixinService.ResponseConstants.URL, "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface FetchApi {
        @GET
        Call<TypedInput> get(@Url String url);
    }

    /* renamed from: com_bytedance_trae_conversation_products_InputPreviewActivity__onStop$___twin___ */
    public void m848x40e05164() {
        super.onStop();
    }

    protected void onStop() {
        m847xca302f17(this);
    }

    /* compiled from: InputPreviewActivity.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JR\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/trae/conversation/products/InputPreviewActivity$Companion;", "", "<init>", "()V", "EXTRA_OID_ID", "", "EXTRA_FILE_NAME", "EXTRA_CONVERSATION_ID", "EXTRA_CHAT_SESSION_ID", "EXTRA_CLI_TYPE", "EXTRA_MODE", "EXTRA_MESSAGE_ID", "REMOTE_RESOURCE_PREFIX", "DOWNLOAD_URL_MAX_RETRIES", "", "DOWNLOAD_URL_RETRY_DELAY_MS", "", "MIN_SCALE", "", "MAX_SCALE", "DOUBLE_TAP_SCALE", "ANIM_DURATION", "IMAGE_EXTENSIONS", "", "MARKDOWN_EXTENSIONS", "CODE_EXTENSIONS", "TXT_EXTENSIONS", "HTML_EXTENSIONS", "start", "", "context", "Landroid/content/Context;", "oidId", "fileName", "conversationId", "chatSessionId", "cliType", "mode", "messageId", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context, String oidId, String fileName, String conversationId, String chatSessionId, String cliType, String mode, String messageId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(oidId, "oidId");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            Intrinsics.checkNotNullParameter(conversationId, "conversationId");
            Intrinsics.checkNotNullParameter(chatSessionId, "chatSessionId");
            Intrinsics.checkNotNullParameter(cliType, "cliType");
            Intrinsics.checkNotNullParameter(mode, "mode");
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            Intent intent = new Intent(context, (Class<?>) InputPreviewActivity.class);
            intent.putExtra(InputPreviewActivity.EXTRA_OID_ID, oidId);
            intent.putExtra(InputPreviewActivity.EXTRA_FILE_NAME, fileName);
            intent.putExtra("extra_conversation_id", conversationId);
            intent.putExtra(InputPreviewActivity.EXTRA_CHAT_SESSION_ID, chatSessionId);
            intent.putExtra(InputPreviewActivity.EXTRA_CLI_TYPE, cliType);
            intent.putExtra("extra_mode", mode);
            intent.putExtra(InputPreviewActivity.EXTRA_MESSAGE_ID, messageId);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConversationCopilotResourceUploadApi getResourceUploadApi() {
        return (ConversationCopilotResourceUploadApi) this.resourceUploadApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConversationCopilotResourceUploadApi resourceUploadApi_delegate$lambda$1() {
        return new ConversationCopilotResourceUploadApi(new Function0() { // from class: com.bytedance.trae.conversation.products.InputPreviewActivity$$ExternalSyntheticLambda4
            public final Object invoke() {
                String resourceUploadApi_delegate$lambda$1$lambda$0;
                resourceUploadApi_delegate$lambda$1$lambda$0 = InputPreviewActivity.resourceUploadApi_delegate$lambda$1$lambda$0();
                return resourceUploadApi_delegate$lambda$1$lambda$0;
            }
        }, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resourceUploadApi_delegate$lambda$1$lambda$0() {
        return HostResolver.INSTANCE.getBaseUrl(HostType.AI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit downloadFinishCallback$lambda$2(InputPreviewActivity inputPreviewActivity, int i, String str, long j) {
        Intrinsics.checkNotNullParameter(str, "savedPath");
        if (i == 0) {
            CustomToast.showLong((Context) inputPreviewActivity, inputPreviewActivity.getString(R.string.trae_doc_preview_download_success) + '\n' + StringsKt.substringBeforeLast$default(str, '/', (String) null, 2, (Object) null));
        } else {
            CustomToast.showLong((Context) inputPreviewActivity, inputPreviewActivity.getString(R.string.trae_doc_preview_download_failed));
        }
        return Unit.INSTANCE;
    }

    private final ScaleGestureDetector getScaleGestureDetector() {
        return (ScaleGestureDetector) this.scaleGestureDetector.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final ScaleGestureDetector scaleGestureDetector_delegate$lambda$3(final InputPreviewActivity inputPreviewActivity) {
        return new ScaleGestureDetector((Context) inputPreviewActivity, new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.bytedance.trae.conversation.products.InputPreviewActivity$scaleGestureDetector$2$1
            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector detector) {
                ValueAnimator valueAnimator;
                Intrinsics.checkNotNullParameter(detector, "detector");
                valueAnimator = InputPreviewActivity.this.scaleAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                InputPreviewActivity.this.isDragging = false;
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
                f = InputPreviewActivity.this.currentScale;
                InputPreviewActivity.this.currentScale = RangesKt.coerceIn(f * scaleFactor, 0.5f, 5.0f);
                simpleDraweeView = InputPreviewActivity.this.ivPreview;
                SimpleDraweeView simpleDraweeView3 = null;
                if (simpleDraweeView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivPreview");
                    simpleDraweeView = null;
                }
                f2 = InputPreviewActivity.this.currentScale;
                simpleDraweeView.setScaleX(f2);
                simpleDraweeView2 = InputPreviewActivity.this.ivPreview;
                if (simpleDraweeView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivPreview");
                } else {
                    simpleDraweeView3 = simpleDraweeView2;
                }
                f3 = InputPreviewActivity.this.currentScale;
                simpleDraweeView3.setScaleY(f3);
                return true;
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector detector) {
                float f;
                Intrinsics.checkNotNullParameter(detector, "detector");
                f = InputPreviewActivity.this.currentScale;
                if (f < 1.0f) {
                    InputPreviewActivity.this.animateToScale(1.0f);
                }
            }
        });
    }

    private final GestureDetector getGestureDetector() {
        return (GestureDetector) this.gestureDetector.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final GestureDetector gestureDetector_delegate$lambda$4(final InputPreviewActivity inputPreviewActivity) {
        return new GestureDetector((Context) inputPreviewActivity, new GestureDetector.SimpleOnGestureListener() { // from class: com.bytedance.trae.conversation.products.InputPreviewActivity$gestureDetector$2$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent e) {
                float f;
                Intrinsics.checkNotNullParameter(e, "e");
                f = InputPreviewActivity.this.currentScale;
                if (f > 1.0f) {
                    InputPreviewActivity.this.animateToScale(1.0f);
                    return true;
                }
                InputPreviewActivity.this.animateToScale(2.5f);
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: InputPreviewActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "MARKDOWN", "CODE", "TXT", "HTML", "OTHER", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class FileType {
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
        }

        public static FileType valueOf(String str) {
            return (FileType) Enum.valueOf(FileType.class, str);
        }

        public static FileType[] values() {
            return (FileType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onCreate(Bundle savedInstanceState) {
        String str;
        super.onCreate(savedInstanceState);
        setContentView(C0637R.layout.trae_input_preview);
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
        String stringExtra = getIntent().getStringExtra(EXTRA_OID_ID);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.extraOidId = stringExtra;
        String stringExtra2 = getIntent().getStringExtra(EXTRA_OID_ID);
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.oidId = StringsKt.removePrefix(stringExtra2, REMOTE_RESOURCE_PREFIX);
        FLogger fLogger = FLogger.INSTANCE;
        StringBuilder sb = new StringBuilder("oidId:");
        String str2 = this.oidId;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("oidId");
            str2 = null;
        }
        fLogger.d("InputPreviewActivity", sb.append(str2).toString());
        String stringExtra3 = getIntent().getStringExtra(EXTRA_FILE_NAME);
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        this.fileName = stringExtra3;
        String stringExtra4 = getIntent().getStringExtra("extra_conversation_id");
        if (stringExtra4 == null) {
            stringExtra4 = "";
        }
        this.conversationId = stringExtra4;
        String stringExtra5 = getIntent().getStringExtra(EXTRA_CHAT_SESSION_ID);
        if (stringExtra5 == null) {
            stringExtra5 = "";
        }
        this.chatSessionId = stringExtra5;
        String stringExtra6 = getIntent().getStringExtra(EXTRA_CLI_TYPE);
        if (stringExtra6 == null) {
            stringExtra6 = "";
        }
        this.cliType = stringExtra6;
        String stringExtra7 = getIntent().getStringExtra("extra_mode");
        if (stringExtra7 == null) {
            stringExtra7 = "";
        }
        this.mode = stringExtra7;
        String stringExtra8 = getIntent().getStringExtra(EXTRA_MESSAGE_ID);
        this.messageId = stringExtra8 != null ? stringExtra8 : "";
        TextView textView = this.tvTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            textView = null;
        }
        String str3 = this.fileName;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileName");
            str3 = null;
        }
        if (str3.length() > 0) {
            String str4 = this.fileName;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileName");
                str4 = null;
            }
            str = StringsKt.substringAfterLast$default(str4, '/', (String) null, 2, (Object) null);
        } else {
            str = this.oidId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("oidId");
                str = null;
            }
        }
        textView.setText(str);
        ImageView imageView = this.btnBack;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnBack");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.InputPreviewActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputPreviewActivity.this.finish();
            }
        });
        String str5 = this.fileName;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileName");
            str5 = null;
        }
        FileType fileType2 = getFileType(str5);
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

    private final FileType getFileType(String path) {
        String lowerCase = StringsKt.substringAfterLast(path, '.', "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return IMAGE_EXTENSIONS.contains(lowerCase) ? FileType.IMAGE : MARKDOWN_EXTENSIONS.contains(lowerCase) ? FileType.MARKDOWN : CODE_EXTENSIONS.contains(lowerCase) ? FileType.CODE : TXT_EXTENSIONS.contains(lowerCase) ? FileType.TXT : HTML_EXTENSIONS.contains(lowerCase) ? FileType.HTML : FileType.OTHER;
    }

    private final void preview() {
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        progressBar.setVisibility(0);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new InputPreviewActivity$preview$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchFileUrl(Continuation<? super String> continuation) {
        String str = null;
        if (StringsKt.startsWith$default(this.extraOidId, REMOTE_RESOURCE_PREFIX, false, 2, (Object) null)) {
            this.needDecode = true;
            return fetchRemoteResourceUrl(continuation);
        }
        if (Intrinsics.areEqual(this.cliType, CliType.LOCAL.getValue()) && Intrinsics.areEqual(this.mode, Mode.WORK.getValue())) {
            this.needDecode = true;
            if (!StringsKt.startsWith$default(this.extraOidId, "trae-res:", false, 2, (Object) null)) {
                return fetchAssetDownloadUrlWithRetry(continuation);
            }
            return fetchRemoteResourceUrl(continuation);
        }
        FileType fileType = this.fileType;
        if (fileType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileType");
            fileType = null;
        }
        if (fileType == FileType.IMAGE) {
            ResourceRepoManager resourceRepoManager = ResourceRepoManager.INSTANCE;
            String str2 = this.oidId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("oidId");
            } else {
                str = str2;
            }
            String str3 = resourceRepoManager.get(str);
            String str4 = str3;
            if (!(str4 == null || str4.length() == 0)) {
                return str3;
            }
        }
        return fetchUrl(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchRemoteResourceUrl(Continuation<? super String> continuation) {
        String str = this.oidId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("oidId");
            str = null;
        }
        if (!(!StringsKt.isBlank(str))) {
            str = null;
        }
        if (str == null) {
            str = StringsKt.removePrefix(this.extraOidId, REMOTE_RESOURCE_PREFIX);
            if (!(!StringsKt.isBlank(str))) {
                str = null;
            }
            if (str == null) {
                return null;
            }
        }
        return BuildersKt.withContext(Dispatchers.getIO(), new InputPreviewActivity$fetchRemoteResourceUrl$2(this, str, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x013e -> B:11:0x003e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchAssetDownloadUrlWithRetry(Continuation<? super String> continuation) {
        InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1 inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;
        int i;
        String sb;
        int i2;
        InputPreviewActivity inputPreviewActivity;
        InputPreviewActivity inputPreviewActivity2;
        String str;
        HttpDataResult.Success success;
        Map<String, String> urlMap;
        Map<String, String> urlMap2;
        String str2;
        if (continuation instanceof InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1) {
            inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1 = (InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1) continuation;
            if ((inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1.label & Integer.MIN_VALUE) != 0) {
                inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1.label -= Integer.MIN_VALUE;
                Object obj = inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    StringBuilder sb2 = new StringBuilder("asset");
                    String str3 = this.oidId;
                    if (str3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("oidId");
                        str3 = null;
                    }
                    sb = sb2.append(str3).toString();
                    StringBuilder append = new StringBuilder("fetchAssetDownloadUrlWithRetry: target=").append(sb).append(", conversationId=");
                    String str4 = this.conversationId;
                    if (str4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
                        str4 = null;
                    }
                    Log.d("InputPreviewActivity", append.append(str4).append(", messageId=").append(this.messageId).toString());
                    i2 = 0;
                    inputPreviewActivity = this;
                    if (i2 < 31) {
                    }
                } else if (i == 1) {
                    i2 = inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1.I$0;
                    str = (String) inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1.L$1;
                    inputPreviewActivity2 = (InputPreviewActivity) inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    success = (HttpDataResult) obj;
                    if (!(success instanceof HttpDataResult.Success)) {
                    }
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1.I$0;
                    str = (String) inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1.L$1;
                    inputPreviewActivity2 = (InputPreviewActivity) inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    sb = str;
                    inputPreviewActivity = inputPreviewActivity2;
                    i2++;
                    if (i2 < 31) {
                        IGetDownloadUrlApi.Companion companion = IGetDownloadUrlApi.INSTANCE;
                        List listOf = CollectionsKt.listOf(sb);
                        String str5 = inputPreviewActivity.conversationId;
                        if (str5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("conversationId");
                            str2 = null;
                        } else {
                            str2 = str5;
                        }
                        GetDownloadUrlRequest getDownloadUrlRequest = new GetDownloadUrlRequest(listOf, str2, inputPreviewActivity.messageId, null, 8, null);
                        inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1.L$0 = inputPreviewActivity;
                        inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1.L$1 = sb;
                        inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1.I$0 = i2;
                        inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1.label = 1;
                        Object downloadUrlRawCall = companion.getDownloadUrlRawCall(getDownloadUrlRequest, inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1);
                        if (downloadUrlRawCall == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        inputPreviewActivity2 = inputPreviewActivity;
                        str = sb;
                        obj = downloadUrlRawCall;
                        success = (HttpDataResult) obj;
                        if (!(success instanceof HttpDataResult.Success)) {
                            HttpDataResult.Success success2 = success;
                            GetDownloadUrlData getDownloadUrlData = (GetDownloadUrlData) success2.getBizResp().getData();
                            if (((getDownloadUrlData == null || (urlMap2 = getDownloadUrlData.getUrlMap()) == null) ? null : urlMap2.get(str)) != null) {
                                GetDownloadUrlData getDownloadUrlData2 = (GetDownloadUrlData) success2.getBizResp().getData();
                                if (getDownloadUrlData2 == null || (urlMap = getDownloadUrlData2.getUrlMap()) == null) {
                                    return null;
                                }
                                return urlMap.get(str);
                            }
                            long code = success2.getBizResp().getCode();
                            if (code == 202) {
                                inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1.L$0 = inputPreviewActivity2;
                                inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1.L$1 = str;
                                inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1.I$0 = i2;
                                inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1.label = 2;
                                if (DelayKt.delay(2000L, inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                sb = str;
                                inputPreviewActivity = inputPreviewActivity2;
                                i2++;
                                if (i2 < 31) {
                                    return null;
                                }
                            } else {
                                FLogger fLogger = FLogger.INSTANCE;
                                StringBuilder append2 = new StringBuilder("fetchAssetDownloadUrlWithRetry: unexpected code=").append(code).append(", msg=");
                                String msg = success2.getBizResp().getMsg();
                                if (msg == null) {
                                    msg = success2.getBizResp().getMessage();
                                }
                                fLogger.d("InputPreviewActivity", append2.append(msg).toString());
                                return null;
                            }
                        } else {
                            if (!(success instanceof HttpDataResult.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            HttpDataResult.Error error = (HttpDataResult.Error) success;
                            Log.e("InputPreviewActivity", "fetchAssetDownloadUrlWithRetry: error code=" + error.getCode() + ", msg=" + error.getMsg(), error.getThrowable());
                            return null;
                        }
                    }
                }
            }
        }
        inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1 = new InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1(this, continuation);
        Object obj2 = inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = inputPreviewActivity$fetchAssetDownloadUrlWithRetry$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showImagePreview(String imageUrl) {
        FLogger.INSTANCE.d("InputPreviewActivity", "showImagePreview:" + imageUrl);
        boolean z = false;
        FrameLayout frameLayout = null;
        if (StringsKt.startsWith$default(imageUrl, "content://", false, 2, (Object) null) || StringsKt.startsWith$default(imageUrl, "file://", false, 2, (Object) null)) {
            View view = this.btnDownload;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnDownload");
                view = null;
            }
            view.setVisibility(8);
            View findViewById = findViewById(C0637R.id.ll_trailing_actions);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
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
            FrameLayout frameLayout3 = this.imageContainer;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageContainer");
            } else {
                frameLayout = frameLayout3;
            }
            setupImageTouchHandling(frameLayout);
            return;
        }
        if (Intrinsics.areEqual(this.cliType, CliType.LOCAL.getValue()) && Intrinsics.areEqual(this.mode, Mode.WORK.getValue())) {
            z = true;
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new InputPreviewActivity$showImagePreview$1(this, imageUrl, z, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCodePreview(String fileUrl) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new InputPreviewActivity$showCodePreview$1(this, fileUrl, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String fetchTextViaTTNet(final String url) {
        if (!this.needDecode) {
            FetchApi fetchApi = (FetchApi) RetrofitUtils.createSsRetrofit("https://placeholder.trae/", (List) null, (Converter.Factory) null).create(FetchApi.class);
            if (fetchApi == null) {
                return null;
            }
            SsResponse execute = fetchApi.get(url).execute();
            Intrinsics.checkNotNullExpressionValue(execute, "execute(...)");
            TypedInput typedInput = (TypedInput) execute.body();
            if (typedInput == null) {
                return "";
            }
            InputStream in = typedInput.in();
            Intrinsics.checkNotNullExpressionValue(in, "in(...)");
            return new String(readAllBytes(in), Charsets.UTF_8);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Interceptor() { // from class: com.bytedance.trae.conversation.products.InputPreviewActivity$$ExternalSyntheticLambda8
            public final SsResponse intercept(Interceptor.Chain chain) {
                SsResponse fetchTextViaTTNet$lambda$8;
                fetchTextViaTTNet$lambda$8 = InputPreviewActivity.fetchTextViaTTNet$lambda$8(url, chain);
                return fetchTextViaTTNet$lambda$8;
            }
        });
        FetchApi fetchApi2 = (FetchApi) RetrofitUtils.createSsRetrofit("https://placeholder.trae/", arrayList, (Converter.Factory) null).create(FetchApi.class);
        if (fetchApi2 == null) {
            return null;
        }
        SsResponse execute2 = fetchApi2.get(url).execute();
        Intrinsics.checkNotNullExpressionValue(execute2, "execute(...)");
        TypedInput typedInput2 = (TypedInput) execute2.body();
        if (typedInput2 == null) {
            return "";
        }
        InputStream in2 = typedInput2.in();
        Intrinsics.checkNotNullExpressionValue(in2, "in(...)");
        return new String(ResourceUploadUtilKt.decodeContent(readAllBytes(in2)), Charsets.UTF_8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SsResponse fetchTextViaTTNet$lambda$8(String str, Interceptor.Chain chain) {
        Request request;
        if (chain == null || (request = chain.request()) == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(Uri.parse(request.getUrl()).buildUpon().clearQuery().build().toString(), "toString(...)");
        return chain.proceed(request.newBuilder().url(str).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadAndShowTxt(String fileUrl) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new InputPreviewActivity$downloadAndShowTxt$1(this, fileUrl, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMarkdownPreview(String fileUrl) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new InputPreviewActivity$loadMarkdownPreview$1(this, fileUrl, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDownloadWithUrl(String fileUrl) {
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
        setupDownloadButtons(fileUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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
        progressBar.setVisibility(8);
        LinearLayout linearLayout = this.layoutContent;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
            linearLayout = null;
        }
        final boolean z = false;
        linearLayout.setVisibility(0);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new InputPreviewActivity$showDownloadOnly$1(this, null), 3, (Object) null);
        if (Intrinsics.areEqual(this.cliType, CliType.LOCAL.getValue()) && Intrinsics.areEqual(this.mode, Mode.WORK.getValue())) {
            z = true;
        }
        TextView textView2 = this.btnMainDownload;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMainDownload");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.InputPreviewActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputPreviewActivity.showDownloadOnly$lambda$13(InputPreviewActivity.this, z, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDownloadOnly$lambda$13(InputPreviewActivity inputPreviewActivity, boolean z, View view) {
        FileDownloadHelper fileDownloadHelper = inputPreviewActivity.fileDownloadHelper;
        Application application = AppHost.INSTANCE.getApplication();
        String str = inputPreviewActivity.fileName;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileName");
            str = null;
        }
        String existingFilePath = fileDownloadHelper.getExistingFilePath(application, str);
        if (existingFilePath != null) {
            inputPreviewActivity.openFileWithExternalApp(existingFilePath);
        } else {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) inputPreviewActivity), (CoroutineContext) null, (CoroutineStart) null, new InputPreviewActivity$showDownloadOnly$2$1(inputPreviewActivity, z, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.InputPreviewActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputPreviewActivity.showError$lambda$16(InputPreviewActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showError$lambda$16(InputPreviewActivity inputPreviewActivity, View view) {
        LinearLayout linearLayout = inputPreviewActivity.layoutContent;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        inputPreviewActivity.preview();
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    private final void setupBtnDownload() {
        final boolean z = Intrinsics.areEqual(this.cliType, CliType.LOCAL.getValue()) && Intrinsics.areEqual(this.mode, Mode.WORK.getValue());
        View view = this.btnDownload;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnDownload");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.InputPreviewActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                InputPreviewActivity.setupBtnDownload$lambda$17(InputPreviewActivity.this, z, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void setupBtnDownload$lambda$17(InputPreviewActivity inputPreviewActivity, boolean z, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = inputPreviewActivity.fileUrl;
        if (str6 != null) {
            if (str6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileUrl");
                str6 = null;
            }
            if (!TextUtils.isEmpty(str6)) {
                FileDownloadHelper fileDownloadHelper = inputPreviewActivity.fileDownloadHelper;
                String str7 = inputPreviewActivity.fileUrl;
                if (str7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileUrl");
                    str = null;
                } else {
                    str = str7;
                }
                String str8 = inputPreviewActivity.conversationId;
                if (str8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("conversationId");
                    str2 = null;
                } else {
                    str2 = str8;
                }
                if (z) {
                    str3 = inputPreviewActivity.oidId;
                    if (str3 == null) {
                        str4 = "oidId";
                        Intrinsics.throwUninitializedPropertyAccessException(str4);
                        str5 = null;
                    }
                    str5 = str3;
                } else {
                    str3 = inputPreviewActivity.fileName;
                    if (str3 == null) {
                        str4 = "fileName";
                        Intrinsics.throwUninitializedPropertyAccessException(str4);
                        str5 = null;
                    }
                    str5 = str3;
                }
                fileDownloadHelper.saveFileAndLoading((Context) inputPreviewActivity, str, str2, str5, LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) inputPreviewActivity), inputPreviewActivity.downloadFinishCallback, (r22 & 64) != 0 ? false : inputPreviewActivity.needDecode, (r22 & 128) != 0 ? 0L : 0L);
                return;
            }
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) inputPreviewActivity), (CoroutineContext) null, (CoroutineStart) null, new InputPreviewActivity$setupBtnDownload$1$1(inputPreviewActivity, z, null), 3, (Object) null);
    }

    private final void setupDownloadButtons(final String url) {
        final boolean z = Intrinsics.areEqual(this.cliType, CliType.LOCAL.getValue()) && Intrinsics.areEqual(this.mode, Mode.WORK.getValue());
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.InputPreviewActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputPreviewActivity.setupDownloadButtons$lambda$18(InputPreviewActivity.this, z, url, view);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void setupDownloadButtons$lambda$18(InputPreviewActivity inputPreviewActivity, boolean z, String str, View view) {
        String str2;
        String str3;
        String str4;
        String str5;
        FileDownloadHelper fileDownloadHelper = inputPreviewActivity.fileDownloadHelper;
        String str6 = inputPreviewActivity.conversationId;
        if (str6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("conversationId");
            str2 = null;
        } else {
            str2 = str6;
        }
        boolean z2 = inputPreviewActivity.needDecode;
        if (z) {
            str3 = inputPreviewActivity.oidId;
            if (str3 == null) {
                str4 = "oidId";
                Intrinsics.throwUninitializedPropertyAccessException(str4);
                str5 = null;
            }
            str5 = str3;
        } else {
            str3 = inputPreviewActivity.fileName;
            if (str3 == null) {
                str4 = "fileName";
                Intrinsics.throwUninitializedPropertyAccessException(str4);
                str5 = null;
            }
            str5 = str3;
        }
        fileDownloadHelper.saveFileAndLoading((Context) inputPreviewActivity, str, str2, str5, LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) inputPreviewActivity), inputPreviewActivity.downloadFinishCallback, (r22 & 64) != 0 ? false : z2, (r22 & 128) != 0 ? 0L : 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupImageTouchHandling(View container) {
        container.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.trae.conversation.products.InputPreviewActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                z = InputPreviewActivity.setupImageTouchHandling$lambda$19(InputPreviewActivity.this, view, motionEvent);
                return z;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupImageTouchHandling$lambda$19(InputPreviewActivity inputPreviewActivity, View view, MotionEvent motionEvent) {
        int findPointerIndex;
        inputPreviewActivity.getScaleGestureDetector().onTouchEvent(motionEvent);
        inputPreviewActivity.getGestureDetector().onTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            inputPreviewActivity.activePointerId = motionEvent.getPointerId(0);
            inputPreviewActivity.lastTouchX = motionEvent.getX();
            inputPreviewActivity.lastTouchY = motionEvent.getY();
            inputPreviewActivity.isDragging = true;
        } else {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 5) {
                            inputPreviewActivity.isDragging = false;
                        } else if (actionMasked == 6) {
                            int actionIndex = motionEvent.getActionIndex();
                            if (motionEvent.getPointerId(actionIndex) == inputPreviewActivity.activePointerId) {
                                int i = actionIndex == 0 ? 1 : 0;
                                if (i < motionEvent.getPointerCount()) {
                                    inputPreviewActivity.lastTouchX = motionEvent.getX(i);
                                    inputPreviewActivity.lastTouchY = motionEvent.getY(i);
                                    inputPreviewActivity.activePointerId = motionEvent.getPointerId(i);
                                }
                            }
                        }
                    }
                } else if (inputPreviewActivity.isDragging && !inputPreviewActivity.getScaleGestureDetector().isInProgress() && (findPointerIndex = motionEvent.findPointerIndex(inputPreviewActivity.activePointerId)) >= 0) {
                    float x = motionEvent.getX(findPointerIndex);
                    float y = motionEvent.getY(findPointerIndex);
                    float f = x - inputPreviewActivity.lastTouchX;
                    float f2 = y - inputPreviewActivity.lastTouchY;
                    if (inputPreviewActivity.currentScale > MIN_SCALE) {
                        SimpleDraweeView simpleDraweeView = inputPreviewActivity.ivPreview;
                        SimpleDraweeView simpleDraweeView2 = null;
                        if (simpleDraweeView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("ivPreview");
                            simpleDraweeView = null;
                        }
                        simpleDraweeView.setTranslationX(simpleDraweeView.getTranslationX() + f);
                        SimpleDraweeView simpleDraweeView3 = inputPreviewActivity.ivPreview;
                        if (simpleDraweeView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("ivPreview");
                        } else {
                            simpleDraweeView2 = simpleDraweeView3;
                        }
                        simpleDraweeView2.setTranslationY(simpleDraweeView2.getTranslationY() + f2);
                    }
                    inputPreviewActivity.lastTouchX = x;
                    inputPreviewActivity.lastTouchY = y;
                }
            }
            inputPreviewActivity.isDragging = false;
            inputPreviewActivity.activePointerId = -1;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
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
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.trae.conversation.products.InputPreviewActivity$$ExternalSyntheticLambda5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                InputPreviewActivity.animateToScale$lambda$21$lambda$20(f, targetScale, this, translationX, f2, translationY, f3, valueAnimator2);
            }
        });
        ofFloat.start();
        this.scaleAnimator = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateToScale$lambda$21$lambda$20(float f, float f2, InputPreviewActivity inputPreviewActivity, float f3, float f4, float f5, float f6, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        float f7 = f + ((f2 - f) * floatValue);
        inputPreviewActivity.currentScale = f7;
        SimpleDraweeView simpleDraweeView = inputPreviewActivity.ivPreview;
        SimpleDraweeView simpleDraweeView2 = null;
        if (simpleDraweeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPreview");
            simpleDraweeView = null;
        }
        simpleDraweeView.setScaleX(f7);
        SimpleDraweeView simpleDraweeView3 = inputPreviewActivity.ivPreview;
        if (simpleDraweeView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPreview");
            simpleDraweeView3 = null;
        }
        simpleDraweeView3.setScaleY(f7);
        SimpleDraweeView simpleDraweeView4 = inputPreviewActivity.ivPreview;
        if (simpleDraweeView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPreview");
            simpleDraweeView4 = null;
        }
        simpleDraweeView4.setTranslationX(f3 + ((f4 - f3) * floatValue));
        SimpleDraweeView simpleDraweeView5 = inputPreviewActivity.ivPreview;
        if (simpleDraweeView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPreview");
        } else {
            simpleDraweeView2 = simpleDraweeView5;
        }
        simpleDraweeView2.setTranslationY(f5 + ((f6 - f5) * floatValue));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildCodeHighlightHtml(String code, String language) {
        return StringsKt.trimIndent("\n            <!DOCTYPE html>\n            <html>\n            <head>\n            <meta charset=\"UTF-8\">\n            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n            <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/styles/github.min.css\">\n            <script src=\"https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/highlight.min.js\"></script>\n            <style>\n                body { margin: 0; padding: 12px; background: #F5F6F8; }\n                pre { margin: 0; white-space: pre-wrap; word-wrap: break-word; }\n                code { font-size: 13px; line-height: 1.5; font-family: monospace; }\n            </style>\n            </head>\n            <body>\n            <pre><code class=\"language-" + language + "\">" + StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(code, "&", "&amp;", false, 4, (Object) null), "<", "&lt;", false, 4, (Object) null), ">", "&gt;", false, 4, (Object) null), "\"", "&quot;", false, 4, (Object) null) + "</code></pre>\n            <script>hljs.highlightAll();</script>\n            </body>\n            </html>\n        ");
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchUrl(Continuation<? super String> continuation) {
        InputPreviewActivity$fetchUrl$1 inputPreviewActivity$fetchUrl$1;
        int i;
        InputPreviewActivity inputPreviewActivity;
        HttpDataResult.Success success;
        String explorerUrl;
        String str;
        String str2;
        if (continuation instanceof InputPreviewActivity$fetchUrl$1) {
            inputPreviewActivity$fetchUrl$1 = (InputPreviewActivity$fetchUrl$1) continuation;
            if ((inputPreviewActivity$fetchUrl$1.label & Integer.MIN_VALUE) != 0) {
                inputPreviewActivity$fetchUrl$1.label -= Integer.MIN_VALUE;
                Object obj = inputPreviewActivity$fetchUrl$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = inputPreviewActivity$fetchUrl$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (StringsKt.isBlank(this.chatSessionId)) {
                        FLogger fLogger = FLogger.INSTANCE;
                        StringBuilder sb = new StringBuilder("fetchUrl: chatSessionId is blank, oidId=");
                        String str3 = this.oidId;
                        if (str3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("oidId");
                            str3 = null;
                        }
                        StringBuilder append = sb.append(str3).append(", fileName=");
                        String str4 = this.fileName;
                        if (str4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("fileName");
                            str4 = null;
                        }
                        fLogger.w("InputPreviewActivity", append.append(str4).toString());
                        return null;
                    }
                    IChatSessionApi.Companion companion = IChatSessionApi.INSTANCE;
                    String str5 = this.chatSessionId;
                    inputPreviewActivity$fetchUrl$1.L$0 = this;
                    inputPreviewActivity$fetchUrl$1.label = 1;
                    obj = companion.getChatSessionRawCall(str5, inputPreviewActivity$fetchUrl$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    inputPreviewActivity = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    inputPreviewActivity = (InputPreviewActivity) inputPreviewActivity$fetchUrl$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                success = (HttpDataResult) obj;
                if (!(success instanceof HttpDataResult.Success)) {
                    HttpDataResult.Success success2 = success;
                    ChatSessionResponse chatSessionResponse = (ChatSessionResponse) success2.getBizResp().getData();
                    if (chatSessionResponse != null && (explorerUrl = chatSessionResponse.getExplorerUrl()) != null) {
                        if (!(!StringsKt.isBlank(explorerUrl))) {
                            explorerUrl = null;
                        }
                        if (explorerUrl != null) {
                            if (!StringsKt.endsWith$default(explorerUrl, "/", false, 2, (Object) null)) {
                                explorerUrl = explorerUrl + '/';
                            }
                            String str6 = inputPreviewActivity.oidId;
                            if (str6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("oidId");
                                str6 = null;
                            }
                            String substringBeforeLast$default = StringsKt.substringBeforeLast$default(StringsKt.substringAfterLast$default(str6, '/', (String) null, 2, (Object) null), '.', (String) null, 2, (Object) null);
                            ChatSessionResponse chatSessionResponse2 = (ChatSessionResponse) success2.getBizResp().getData();
                            if (chatSessionResponse2 == null || (str = chatSessionResponse2.getUploadsPath()) == null) {
                                str = ".uploads";
                            }
                            String str7 = inputPreviewActivity.fileName;
                            if (str7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("fileName");
                                str7 = null;
                            }
                            String encode = URLEncoder.encode(str7, "UTF-8");
                            Intrinsics.checkNotNullExpressionValue(encode, "encode(...)");
                            String str8 = explorerUrl + "file/" + str + '/' + substringBeforeLast$default + '_' + StringsKt.replace$default(encode, "+", "%20", false, 4, (Object) null);
                            ChatSessionResponse chatSessionResponse3 = (ChatSessionResponse) success2.getBizResp().getData();
                            if (chatSessionResponse3 == null || (str2 = chatSessionResponse3.getWorkspacePath()) == null) {
                                str2 = "/workspace";
                            }
                            String encode2 = URLEncoder.encode(str2, "UTF-8");
                            ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
                            String xTToken = iLoginService != null ? iLoginService.getXTToken() : null;
                            if (xTToken == null) {
                                xTToken = "";
                            }
                            return str8 + "?cwd=" + encode2 + "&use_cache=1&authorization=" + URLEncoder.encode("Cloud-IDE-JWT " + xTToken, "UTF-8");
                        }
                    }
                    FLogger fLogger2 = FLogger.INSTANCE;
                    StringBuilder append2 = new StringBuilder("fetchUrl: explorerUrl is blank, chatSessionId=").append(inputPreviewActivity.chatSessionId).append(", oidId=");
                    String str9 = inputPreviewActivity.oidId;
                    if (str9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("oidId");
                        str9 = null;
                    }
                    StringBuilder append3 = append2.append(str9).append(", fileName=");
                    String str10 = inputPreviewActivity.fileName;
                    if (str10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("fileName");
                        str10 = null;
                    }
                    fLogger2.w("InputPreviewActivity", append3.append(str10).toString());
                    return null;
                }
                if (success instanceof HttpDataResult.Error) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        inputPreviewActivity$fetchUrl$1 = new InputPreviewActivity$fetchUrl$1(this, continuation);
        Object obj2 = inputPreviewActivity$fetchUrl$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = inputPreviewActivity$fetchUrl$1.label;
        if (i != 0) {
        }
        success = (HttpDataResult) obj2;
        if (!(success instanceof HttpDataResult.Success)) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_conversation_products_InputPreviewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m847xca302f17(InputPreviewActivity inputPreviewActivity) {
        inputPreviewActivity.m848x40e05164();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) inputPreviewActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
