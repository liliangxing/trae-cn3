package com.bytedance.trae.conversation.products;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.widget.CustomToast;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.fileupload.BizType;
import com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi;
import com.bytedance.trae.conversation.fileupload.GetResourceUrlRequest;
import com.bytedance.trae.conversation.fileupload.GetResourceUrlResponse;
import com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi;
import com.bytedance.trae.conversation.products.MultiImagePreviewActivity;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.GetDownloadUrlData;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.FLogger;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
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
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: MultiImagePreviewActivity.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ^2\u00020\u0001:\u0002^_B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00104\u001a\u00020\u001cH\u0016J\b\u00105\u001a\u00020#H\u0016J\u0012\u00106\u001a\u0002032\b\u00107\u001a\u0004\u0018\u000108H\u0014J\b\u00109\u001a\u000203H\u0002J\u0010\u0010:\u001a\u0002032\u0006\u0010;\u001a\u00020#H\u0002J\b\u0010<\u001a\u000203H\u0002J\b\u0010=\u001a\u000203H\u0002J\u0018\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u00020\u001cH\u0002J\b\u0010A\u001a\u000203H\u0002J(\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120C2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019H\u0082@¢\u0006\u0002\u0010EJ\u0014\u0010F\u001a\u0004\u0018\u00010\u00122\b\u0010G\u001a\u0004\u0018\u00010\u0012H\u0002J(\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120C2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019H\u0082@¢\u0006\u0002\u0010EJ\b\u0010J\u001a\u000203H\u0002J(\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120C2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019H\u0082@¢\u0006\u0002\u0010EJ\b\u0010M\u001a\u000203H\u0002J\u001c\u0010N\u001a\u00020\u00122\u0006\u0010O\u001a\u00020\u00122\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\u0012H\u0002J\u0012\u0010S\u001a\u0004\u0018\u00010\u00122\u0006\u0010@\u001a\u00020\u001cH\u0002J\u0018\u0010T\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u00020\u001cH\u0002J\u001a\u0010U\u001a\u00020\u00122\b\u0010G\u001a\u0004\u0018\u00010\u00122\u0006\u0010@\u001a\u00020\u001cH\u0002J\u0010\u0010V\u001a\u00020\u00122\u0006\u0010@\u001a\u00020\u001cH\u0002J\u0010\u0010W\u001a\u00020#2\u0006\u0010G\u001a\u00020\u0012H\u0002J\u0012\u0010X\u001a\u0004\u0018\u00010\u00122\u0006\u0010Y\u001a\u00020ZH\u0002J\u001a\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010]\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b.\u0010/R&\u00101\u001a\u001a\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020302X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "topBar", "Landroid/view/View;", "btnBack", "Landroid/widget/ImageView;", "btnDownload", "Landroid/widget/FrameLayout;", "tvIndicator", "Landroid/widget/TextView;", "tvGeneratedByAi", "progressBar", "Landroid/widget/ProgressBar;", "chatSessionId", "", "cliType", "messageId", "conversationId", "createdTime", "", "paths", "", "displayNames", "currentIndex", "", "resolveMode", "fileDownloadHelper", "Lcom/bytedance/trae/conversation/products/FileDownloadHelper;", "imageUrls", "", "isTopBarVisible", "", "topBarAnimator", "Landroid/animation/ValueAnimator;", "imageUploadApi", "Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;", "getImageUploadApi", "()Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;", "imageUploadApi$delegate", "Lkotlin/Lazy;", "resourceUploadApi", "Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;", "getResourceUploadApi", "()Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;", "resourceUploadApi$delegate", "downloadFinishCallback", "Lkotlin/Function3;", "", "getDecorViewBackgroundColor", "isLightStatusBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "toggleTopBar", "setTopBarVisible", "visible", "setupViewPager", "updateIndicator", "indicatorFileName", "path", "index", "fetchAllImageUrls", "fetchRemoteResourceUrls", "", "resourceUris", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "normalizeRemoteResourceId", AccountMonitorConstants.CommonParameter.RAW, "fetchLocalArtifactUrls", "artifactPaths", "fetchArtifactImageUrls", "fetchDownloadUrlsWithRetry", "filePaths", "downloadCurrentImage", "normalizeFilePath", "filePath", "workspacePath", "buildFileUrl", "explorerUrl", "displayNameForIndex", "downloadFileName", "sanitizeImageFileName", "fallbackImageFileName", "isLocalUri", "queryDisplayName", "uri", "Landroid/net/Uri;", "copyLocalUriToCache", "Ljava/io/File;", "fileName", "Companion", "ImagePagerAdapter", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MultiImagePreviewActivity extends TraeCommonAppCompatActivity {
    private static final long ANIM_DURATION = 250;
    private static final float DOUBLE_TAP_SCALE = 2.5f;
    private static final int DOWNLOAD_URL_MAX_RETRIES = 20;
    private static final long DOWNLOAD_URL_RETRY_DELAY_MS = 2000;
    private static final String EXTRA_CHAT_SESSION_ID = "extra_chat_session_id";
    private static final String EXTRA_CLI_TYPE = "extra_cli_type";
    private static final String EXTRA_CONVERSATION_ID = "extra_conversation_id";
    private static final String EXTRA_CREATED_TIME = "extra_created_time";
    private static final String EXTRA_CURRENT_INDEX = "extra_current_index";
    private static final String EXTRA_DISPLAY_NAMES = "extra_display_names";
    private static final String EXTRA_MESSAGE_ID = "extra_message_id";
    private static final String EXTRA_PATHS = "extra_paths";
    private static final String EXTRA_RESOLVE_MODE = "extra_resolve_mode";
    private static final String EXTRA_TURN_ID = "extra_turn_id";
    private static final String LOCAL_IMAGE_DOWNLOAD_CACHE_DIR = "multi_image_local_download";
    private static final float MAX_SCALE = 5.0f;
    private static final float MIN_SCALE = 1.0f;
    private static final String REMOTE_RESOURCE_CACHE_DIR = "multi_image_remote_resource";
    private static final String REMOTE_RESOURCE_PREFIX = "trae-res://remote_resource/";
    private static final String RESOLVE_MODE_ARTIFACT = "artifact";
    private static final String RESOLVE_MODE_IMAGE_ID = "image_id";
    private static final String RESOLVE_MODE_LOCAL_ARTIFACT = "local_artifact";
    private static final String RESOLVE_MODE_LOCAL_URI = "local_uri";
    private static final String RESOLVE_MODE_REMOTE_RESOURCE = "remote_resource";
    private static final String TAG = "MultiImagePreviewActivity";
    private ImageView btnBack;
    private FrameLayout btnDownload;
    private String chatSessionId;
    private String cliType;
    private String conversationId;
    private long createdTime;
    private int currentIndex;
    private String messageId;
    private ProgressBar progressBar;
    private View topBar;
    private ValueAnimator topBarAnimator;
    private TextView tvGeneratedByAi;
    private TextView tvIndicator;
    private ViewPager2 viewPager;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> IMAGE_EXTENSIONS = SetsKt.setOf(new String[]{"jpg", "jpeg", "png", "gif", "webp", "bmp", "heic", "heif"});
    private List<String> paths = CollectionsKt.emptyList();
    private List<String> displayNames = CollectionsKt.emptyList();
    private String resolveMode = RESOLVE_MODE_ARTIFACT;
    private final FileDownloadHelper fileDownloadHelper = new FileDownloadHelper();
    private final Map<String, String> imageUrls = new LinkedHashMap();
    private boolean isTopBarVisible = true;

    /* renamed from: imageUploadApi$delegate, reason: from kotlin metadata */
    private final Lazy imageUploadApi = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.products.MultiImagePreviewActivity$$ExternalSyntheticLambda3
        public final Object invoke() {
            ConversationCopilotImageUploadApi imageUploadApi_delegate$lambda$1;
            imageUploadApi_delegate$lambda$1 = MultiImagePreviewActivity.imageUploadApi_delegate$lambda$1();
            return imageUploadApi_delegate$lambda$1;
        }
    });

    /* renamed from: resourceUploadApi$delegate, reason: from kotlin metadata */
    private final Lazy resourceUploadApi = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.products.MultiImagePreviewActivity$$ExternalSyntheticLambda4
        public final Object invoke() {
            ConversationCopilotResourceUploadApi resourceUploadApi_delegate$lambda$3;
            resourceUploadApi_delegate$lambda$3 = MultiImagePreviewActivity.resourceUploadApi_delegate$lambda$3();
            return resourceUploadApi_delegate$lambda$3;
        }
    });
    private final Function3<Integer, String, Long, Unit> downloadFinishCallback = new Function3() { // from class: com.bytedance.trae.conversation.products.MultiImagePreviewActivity$$ExternalSyntheticLambda5
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit downloadFinishCallback$lambda$4;
            downloadFinishCallback$lambda$4 = MultiImagePreviewActivity.downloadFinishCallback$lambda$4(MultiImagePreviewActivity.this, ((Integer) obj).intValue(), (String) obj2, ((Long) obj3).longValue());
            return downloadFinishCallback$lambda$4;
        }
    };

    /* renamed from: com_bytedance_trae_conversation_products_MultiImagePreviewActivity__onStop$___twin___ */
    public void m852xb0cec710() {
        super.onStop();
    }

    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public int getDecorViewBackgroundColor() {
        return -16777216;
    }

    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public boolean isLightStatusBar() {
        return false;
    }

    protected void onStop() {
        m851x7c1814eb(this);
    }

    /* compiled from: MultiImagePreviewActivity.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jl\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u00052\b\b\u0002\u0010)\u001a\u00020\u00052\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00050+j\b\u0012\u0004\u0012\u00020\u0005`,2\b\b\u0002\u0010-\u001a\u00020\u00162\b\b\u0002\u0010.\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u00020\u00052\b\b\u0002\u00100\u001a\u00020\u0014JJ\u00101\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u00050+j\b\u0012\u0004\u0012\u00020\u0005`,2\b\b\u0002\u0010-\u001a\u00020\u00162\u0018\b\u0002\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u00050+j\b\u0012\u0004\u0012\u00020\u0005`,JJ\u00104\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u00050+j\b\u0012\u0004\u0012\u00020\u0005`,2\b\b\u0002\u0010-\u001a\u00020\u00162\u0018\b\u0002\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u00050+j\b\u0012\u0004\u0012\u00020\u0005`,JJ\u00106\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0016\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u00050+j\b\u0012\u0004\u0012\u00020\u0005`,2\b\b\u0002\u0010-\u001a\u00020\u00162\u0018\b\u0002\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u00050+j\b\u0012\u0004\u0012\u00020\u0005`,Jh\u00108\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0016\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u00050+j\b\u0012\u0004\u0012\u00020\u0005`,2\b\b\u0002\u0010-\u001a\u00020\u00162\u0018\b\u0002\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u00050+j\b\u0012\u0004\u0012\u00020\u0005`,2\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;", "", "<init>", "()V", "EXTRA_CHAT_SESSION_ID", "", "EXTRA_TURN_ID", "EXTRA_CLI_TYPE", "EXTRA_PATHS", "EXTRA_DISPLAY_NAMES", "EXTRA_CURRENT_INDEX", "EXTRA_MESSAGE_ID", "EXTRA_CONVERSATION_ID", "EXTRA_CREATED_TIME", "EXTRA_RESOLVE_MODE", "MIN_SCALE", "", "MAX_SCALE", "DOUBLE_TAP_SCALE", "ANIM_DURATION", "", "DOWNLOAD_URL_MAX_RETRIES", "", "DOWNLOAD_URL_RETRY_DELAY_MS", "TAG", "REMOTE_RESOURCE_PREFIX", "REMOTE_RESOURCE_CACHE_DIR", "LOCAL_IMAGE_DOWNLOAD_CACHE_DIR", "IMAGE_EXTENSIONS", "", "RESOLVE_MODE_ARTIFACT", "RESOLVE_MODE_IMAGE_ID", "RESOLVE_MODE_LOCAL_URI", "RESOLVE_MODE_REMOTE_RESOURCE", "RESOLVE_MODE_LOCAL_ARTIFACT", "start", "", "context", "Landroid/content/Context;", "chatSessionId", "turnId", "cliType", "paths", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "currentIndex", "messageId", "conversationId", "createdTime", "startWithImageIds", "imageIds", "displayNames", "startWithLocalUris", "localUris", "startWithRemoteResources", "resourceUris", "startWithLocalArtifacts", "artifactPaths", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context, String chatSessionId, String turnId, String cliType, ArrayList<String> paths, int currentIndex, String messageId, String conversationId, long createdTime) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(chatSessionId, "chatSessionId");
            Intrinsics.checkNotNullParameter(turnId, "turnId");
            Intrinsics.checkNotNullParameter(cliType, "cliType");
            Intrinsics.checkNotNullParameter(paths, "paths");
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            Intrinsics.checkNotNullParameter(conversationId, "conversationId");
            Intent intent = new Intent(context, (Class<?>) MultiImagePreviewActivity.class);
            intent.putExtra(MultiImagePreviewActivity.EXTRA_CHAT_SESSION_ID, chatSessionId);
            intent.putExtra(MultiImagePreviewActivity.EXTRA_TURN_ID, turnId);
            intent.putExtra(MultiImagePreviewActivity.EXTRA_CLI_TYPE, cliType);
            intent.putStringArrayListExtra(MultiImagePreviewActivity.EXTRA_PATHS, paths);
            intent.putExtra(MultiImagePreviewActivity.EXTRA_CURRENT_INDEX, currentIndex);
            intent.putExtra(MultiImagePreviewActivity.EXTRA_MESSAGE_ID, messageId);
            intent.putExtra("extra_conversation_id", conversationId);
            intent.putExtra(MultiImagePreviewActivity.EXTRA_CREATED_TIME, createdTime);
            intent.putExtra(MultiImagePreviewActivity.EXTRA_RESOLVE_MODE, MultiImagePreviewActivity.RESOLVE_MODE_ARTIFACT);
            context.startActivity(intent);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void startWithImageIds$default(Companion companion, Context context, ArrayList arrayList, int i, ArrayList arrayList2, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                i = 0;
            }
            if ((i2 & 8) != 0) {
                arrayList2 = new ArrayList();
            }
            companion.startWithImageIds(context, arrayList, i, arrayList2);
        }

        public final void startWithImageIds(Context context, ArrayList<String> imageIds, int currentIndex, ArrayList<String> displayNames) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(imageIds, "imageIds");
            Intrinsics.checkNotNullParameter(displayNames, "displayNames");
            Intent intent = new Intent(context, (Class<?>) MultiImagePreviewActivity.class);
            intent.putStringArrayListExtra(MultiImagePreviewActivity.EXTRA_PATHS, imageIds);
            intent.putStringArrayListExtra(MultiImagePreviewActivity.EXTRA_DISPLAY_NAMES, displayNames);
            intent.putExtra(MultiImagePreviewActivity.EXTRA_CURRENT_INDEX, currentIndex);
            intent.putExtra(MultiImagePreviewActivity.EXTRA_RESOLVE_MODE, MultiImagePreviewActivity.RESOLVE_MODE_IMAGE_ID);
            context.startActivity(intent);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void startWithLocalUris$default(Companion companion, Context context, ArrayList arrayList, int i, ArrayList arrayList2, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                i = 0;
            }
            if ((i2 & 8) != 0) {
                arrayList2 = new ArrayList();
            }
            companion.startWithLocalUris(context, arrayList, i, arrayList2);
        }

        public final void startWithLocalUris(Context context, ArrayList<String> localUris, int currentIndex, ArrayList<String> displayNames) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(localUris, "localUris");
            Intrinsics.checkNotNullParameter(displayNames, "displayNames");
            Intent intent = new Intent(context, (Class<?>) MultiImagePreviewActivity.class);
            intent.putStringArrayListExtra(MultiImagePreviewActivity.EXTRA_PATHS, localUris);
            intent.putStringArrayListExtra(MultiImagePreviewActivity.EXTRA_DISPLAY_NAMES, displayNames);
            intent.putExtra(MultiImagePreviewActivity.EXTRA_CURRENT_INDEX, currentIndex);
            intent.putExtra(MultiImagePreviewActivity.EXTRA_RESOLVE_MODE, MultiImagePreviewActivity.RESOLVE_MODE_LOCAL_URI);
            context.startActivity(intent);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void startWithRemoteResources$default(Companion companion, Context context, ArrayList arrayList, int i, ArrayList arrayList2, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                i = 0;
            }
            if ((i2 & 8) != 0) {
                arrayList2 = new ArrayList();
            }
            companion.startWithRemoteResources(context, arrayList, i, arrayList2);
        }

        public final void startWithRemoteResources(Context context, ArrayList<String> resourceUris, int currentIndex, ArrayList<String> displayNames) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(resourceUris, "resourceUris");
            Intrinsics.checkNotNullParameter(displayNames, "displayNames");
            Intent intent = new Intent(context, (Class<?>) MultiImagePreviewActivity.class);
            intent.putStringArrayListExtra(MultiImagePreviewActivity.EXTRA_PATHS, resourceUris);
            intent.putStringArrayListExtra(MultiImagePreviewActivity.EXTRA_DISPLAY_NAMES, displayNames);
            intent.putExtra(MultiImagePreviewActivity.EXTRA_CURRENT_INDEX, currentIndex);
            intent.putExtra(MultiImagePreviewActivity.EXTRA_RESOLVE_MODE, MultiImagePreviewActivity.RESOLVE_MODE_REMOTE_RESOURCE);
            context.startActivity(intent);
        }

        public final void startWithLocalArtifacts(Context context, ArrayList<String> artifactPaths, int currentIndex, ArrayList<String> displayNames, String chatSessionId, String conversationId, String messageId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(artifactPaths, "artifactPaths");
            Intrinsics.checkNotNullParameter(displayNames, "displayNames");
            Intrinsics.checkNotNullParameter(chatSessionId, "chatSessionId");
            Intrinsics.checkNotNullParameter(conversationId, "conversationId");
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            Intent intent = new Intent(context, (Class<?>) MultiImagePreviewActivity.class);
            intent.putStringArrayListExtra(MultiImagePreviewActivity.EXTRA_PATHS, artifactPaths);
            intent.putStringArrayListExtra(MultiImagePreviewActivity.EXTRA_DISPLAY_NAMES, displayNames);
            intent.putExtra(MultiImagePreviewActivity.EXTRA_CURRENT_INDEX, currentIndex);
            intent.putExtra(MultiImagePreviewActivity.EXTRA_CHAT_SESSION_ID, chatSessionId);
            intent.putExtra("extra_conversation_id", conversationId);
            intent.putExtra(MultiImagePreviewActivity.EXTRA_MESSAGE_ID, messageId);
            intent.putExtra(MultiImagePreviewActivity.EXTRA_RESOLVE_MODE, MultiImagePreviewActivity.RESOLVE_MODE_LOCAL_ARTIFACT);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConversationCopilotImageUploadApi getImageUploadApi() {
        return (ConversationCopilotImageUploadApi) this.imageUploadApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConversationCopilotImageUploadApi imageUploadApi_delegate$lambda$1() {
        return new ConversationCopilotImageUploadApi(new Function0() { // from class: com.bytedance.trae.conversation.products.MultiImagePreviewActivity$$ExternalSyntheticLambda1
            public final Object invoke() {
                String imageUploadApi_delegate$lambda$1$lambda$0;
                imageUploadApi_delegate$lambda$1$lambda$0 = MultiImagePreviewActivity.imageUploadApi_delegate$lambda$1$lambda$0();
                return imageUploadApi_delegate$lambda$1$lambda$0;
            }
        }, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String imageUploadApi_delegate$lambda$1$lambda$0() {
        return HostResolver.INSTANCE.getBaseUrl(HostType.AI);
    }

    private final ConversationCopilotResourceUploadApi getResourceUploadApi() {
        return (ConversationCopilotResourceUploadApi) this.resourceUploadApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConversationCopilotResourceUploadApi resourceUploadApi_delegate$lambda$3() {
        return new ConversationCopilotResourceUploadApi(new Function0() { // from class: com.bytedance.trae.conversation.products.MultiImagePreviewActivity$$ExternalSyntheticLambda2
            public final Object invoke() {
                String resourceUploadApi_delegate$lambda$3$lambda$2;
                resourceUploadApi_delegate$lambda$3$lambda$2 = MultiImagePreviewActivity.resourceUploadApi_delegate$lambda$3$lambda$2();
                return resourceUploadApi_delegate$lambda$3$lambda$2;
            }
        }, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resourceUploadApi_delegate$lambda$3$lambda$2() {
        return HostResolver.INSTANCE.getBaseUrl(HostType.AI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit downloadFinishCallback$lambda$4(MultiImagePreviewActivity multiImagePreviewActivity, int i, String str, long j) {
        Intrinsics.checkNotNullParameter(str, "savedPath");
        if (i == 0) {
            CustomToast.showLong((Context) multiImagePreviewActivity, multiImagePreviewActivity.getString(R.string.trae_doc_preview_download_success) + '\n' + StringsKt.substringBeforeLast$default(str, '/', (String) null, 2, (Object) null));
        } else {
            CustomToast.showLong((Context) multiImagePreviewActivity, multiImagePreviewActivity.getString(R.string.trae_doc_preview_download_failed));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0637R.layout.trae_layout_multi_image_preview);
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
        String stringExtra3 = getIntent().getStringExtra(EXTRA_MESSAGE_ID);
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        this.messageId = stringExtra3;
        String stringExtra4 = getIntent().getStringExtra("extra_conversation_id");
        this.conversationId = stringExtra4 != null ? stringExtra4 : "";
        this.createdTime = getIntent().getLongExtra(EXTRA_CREATED_TIME, 0L);
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra(EXTRA_PATHS);
        this.paths = stringArrayListExtra != null ? stringArrayListExtra : CollectionsKt.emptyList();
        ArrayList<String> stringArrayListExtra2 = getIntent().getStringArrayListExtra(EXTRA_DISPLAY_NAMES);
        this.displayNames = stringArrayListExtra2 != null ? stringArrayListExtra2 : CollectionsKt.emptyList();
        this.currentIndex = getIntent().getIntExtra(EXTRA_CURRENT_INDEX, 0);
        String stringExtra5 = getIntent().getStringExtra(EXTRA_RESOLVE_MODE);
        if (stringExtra5 == null) {
            stringExtra5 = RESOLVE_MODE_ARTIFACT;
        }
        this.resolveMode = stringExtra5;
        if (this.paths.isEmpty()) {
            finish();
            return;
        }
        ViewPager2 findViewById = findViewById(C0637R.id.view_pager);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.viewPager = findViewById;
        View findViewById2 = findViewById(C0637R.id.top_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.topBar = findViewById2;
        View findViewById3 = findViewById(C0637R.id.btn_back);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.btnBack = (ImageView) findViewById3;
        View findViewById4 = findViewById(C0637R.id.btn_download);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.btnDownload = (FrameLayout) findViewById4;
        View findViewById5 = findViewById(C0637R.id.tv_indicator);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.tvIndicator = (TextView) findViewById5;
        View findViewById6 = findViewById(C0637R.id.tv_generated_by_ai);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.tvGeneratedByAi = (TextView) findViewById6;
        View findViewById7 = findViewById(C0637R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.progressBar = (ProgressBar) findViewById7;
        ImageView imageView = this.btnBack;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnBack");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.MultiImagePreviewActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MultiImagePreviewActivity.this.finish();
            }
        });
        FrameLayout frameLayout = this.btnDownload;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnDownload");
            frameLayout = null;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.MultiImagePreviewActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MultiImagePreviewActivity.this.downloadCurrentImage();
            }
        });
        TextView textView2 = this.tvGeneratedByAi;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvGeneratedByAi");
        } else {
            textView = textView2;
        }
        textView.setVisibility(Intrinsics.areEqual(this.resolveMode, RESOLVE_MODE_ARTIFACT) ? 0 : 8);
        setupViewPager();
        updateIndicator();
        fetchAllImageUrls();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleTopBar() {
        setTopBarVisible(!this.isTopBarVisible);
    }

    private final void setTopBarVisible(final boolean visible) {
        if (this.isTopBarVisible == visible) {
            return;
        }
        this.isTopBarVisible = visible;
        ValueAnimator valueAnimator = this.topBarAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ViewPager2 viewPager2 = this.viewPager;
        View view = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        ViewGroup.LayoutParams layoutParams = viewPager2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        final int i = marginLayoutParams.topMargin;
        int dimensionPixelSize = visible ? getResources().getDimensionPixelSize(C0637R.dimen.trae_multi_image_preview_title_bar_height) : 0;
        View view2 = this.topBar;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topBar");
            view2 = null;
        }
        final float alpha = view2.getAlpha();
        final float f = visible ? MIN_SCALE : 0.0f;
        if (visible) {
            View view3 = this.topBar;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topBar");
            } else {
                view = view3;
            }
            view.setVisibility(0);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, MIN_SCALE);
        ofFloat.setDuration(250L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        final int i2 = dimensionPixelSize;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.trae.conversation.products.MultiImagePreviewActivity$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                MultiImagePreviewActivity.setTopBarVisible$lambda$8$lambda$7(i, i2, marginLayoutParams, this, alpha, f, valueAnimator2);
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.trae.conversation.products.MultiImagePreviewActivity$setTopBarVisible$1$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                View view4;
                View view5;
                Intrinsics.checkNotNullParameter(animation, "animation");
                marginLayoutParams.topMargin = i2;
                ViewPager2 viewPager22 = this.viewPager;
                View view6 = null;
                if (viewPager22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                    viewPager22 = null;
                }
                viewPager22.setLayoutParams(marginLayoutParams);
                view4 = this.topBar;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topBar");
                    view4 = null;
                }
                view4.setAlpha(f);
                if (visible) {
                    return;
                }
                view5 = this.topBar;
                if (view5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topBar");
                } else {
                    view6 = view5;
                }
                view6.setVisibility(8);
            }
        });
        ofFloat.start();
        this.topBarAnimator = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTopBarVisible$lambda$8$lambda$7(int i, int i2, ViewGroup.MarginLayoutParams marginLayoutParams, MultiImagePreviewActivity multiImagePreviewActivity, float f, float f2, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        marginLayoutParams.topMargin = i + ((int) ((i2 - i) * floatValue));
        ViewPager2 viewPager2 = multiImagePreviewActivity.viewPager;
        View view = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        viewPager2.setLayoutParams(marginLayoutParams);
        View view2 = multiImagePreviewActivity.topBar;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topBar");
        } else {
            view = view2;
        }
        view.setAlpha(f + ((f2 - f) * floatValue));
    }

    private final void setupViewPager() {
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(this.paths.size());
        ViewPager2 viewPager2 = this.viewPager;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        viewPager2.setAdapter(imagePagerAdapter);
        ViewPager2 viewPager23 = this.viewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager23 = null;
        }
        viewPager23.setCurrentItem(this.currentIndex, false);
        ViewPager2 viewPager24 = this.viewPager;
        if (viewPager24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager22 = viewPager24;
        }
        viewPager22.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.bytedance.trae.conversation.products.MultiImagePreviewActivity$setupViewPager$1
            public void onPageSelected(int position) {
                MultiImagePreviewActivity.this.currentIndex = position;
                MultiImagePreviewActivity.this.updateIndicator();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateIndicator() {
        String str = (String) CollectionsKt.getOrNull(this.paths, this.currentIndex);
        if (str == null) {
            return;
        }
        TextView textView = this.tvIndicator;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvIndicator");
            textView = null;
        }
        textView.setText(indicatorFileName(str, this.currentIndex));
    }

    private final String indicatorFileName(String path, int index) {
        String str;
        String displayNameForIndex = displayNameForIndex(index);
        if (displayNameForIndex != null) {
            return displayNameForIndex;
        }
        if (Intrinsics.areEqual(this.resolveMode, RESOLVE_MODE_LOCAL_URI)) {
            Uri parse = Uri.parse(path);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            str = queryDisplayName(parse);
        } else {
            str = null;
        }
        if (str != null) {
            return str;
        }
        String substringAfterLast$default = StringsKt.substringAfterLast$default(StringsKt.substringAfterLast$default(StringsKt.substringBefore$default(path, '?', (String) null, 2, (Object) null), '/', (String) null, 2, (Object) null), '\\', (String) null, 2, (Object) null);
        if (StringsKt.isBlank(substringAfterLast$default)) {
            substringAfterLast$default = fallbackImageFileName(index);
        }
        return substringAfterLast$default;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    private final void fetchAllImageUrls() {
        String str = this.resolveMode;
        switch (str.hashCode()) {
            case -1204869480:
                if (str.equals(RESOLVE_MODE_LOCAL_URI)) {
                    for (String str2 : this.paths) {
                        this.imageUrls.put(str2, str2);
                    }
                    ViewPager2 viewPager2 = this.viewPager;
                    if (viewPager2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                        viewPager2 = null;
                    }
                    RecyclerView.Adapter adapter = viewPager2.getAdapter();
                    ImagePagerAdapter imagePagerAdapter = adapter instanceof ImagePagerAdapter ? (ImagePagerAdapter) adapter : null;
                    if (imagePagerAdapter != null) {
                        imagePagerAdapter.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                fetchArtifactImageUrls();
                return;
            case -859601281:
                if (str.equals(RESOLVE_MODE_IMAGE_ID)) {
                    ProgressBar progressBar = this.progressBar;
                    if (progressBar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                        progressBar = null;
                    }
                    progressBar.setVisibility(0);
                    BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new MultiImagePreviewActivity$fetchAllImageUrls$2(this, null), 3, (Object) null);
                    return;
                }
                fetchArtifactImageUrls();
                return;
            case -843977753:
                if (str.equals(RESOLVE_MODE_REMOTE_RESOURCE)) {
                    ProgressBar progressBar2 = this.progressBar;
                    if (progressBar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                        progressBar2 = null;
                    }
                    progressBar2.setVisibility(0);
                    BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new MultiImagePreviewActivity$fetchAllImageUrls$3(this, null), 3, (Object) null);
                    return;
                }
                fetchArtifactImageUrls();
                return;
            case -471957466:
                if (str.equals(RESOLVE_MODE_LOCAL_ARTIFACT)) {
                    ProgressBar progressBar3 = this.progressBar;
                    if (progressBar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                        progressBar3 = null;
                    }
                    progressBar3.setVisibility(0);
                    BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new MultiImagePreviewActivity$fetchAllImageUrls$4(this, null), 3, (Object) null);
                    return;
                }
                fetchArtifactImageUrls();
                return;
            default:
                fetchArtifactImageUrls();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchRemoteResourceUrls(List<String> list, Continuation<? super Map<String, String>> continuation) {
        MultiImagePreviewActivity$fetchRemoteResourceUrls$1 multiImagePreviewActivity$fetchRemoteResourceUrls$1;
        int i;
        MultiImagePreviewActivity multiImagePreviewActivity;
        String str;
        if (continuation instanceof MultiImagePreviewActivity$fetchRemoteResourceUrls$1) {
            multiImagePreviewActivity$fetchRemoteResourceUrls$1 = (MultiImagePreviewActivity$fetchRemoteResourceUrls$1) continuation;
            if ((multiImagePreviewActivity$fetchRemoteResourceUrls$1.label & Integer.MIN_VALUE) != 0) {
                multiImagePreviewActivity$fetchRemoteResourceUrls$1.label -= Integer.MIN_VALUE;
                Object obj = multiImagePreviewActivity$fetchRemoteResourceUrls$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = multiImagePreviewActivity$fetchRemoteResourceUrls$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        String normalizeRemoteResourceId = normalizeRemoteResourceId((String) it.next());
                        if (normalizeRemoteResourceId != null) {
                            arrayList.add(normalizeRemoteResourceId);
                        }
                    }
                    List distinct = CollectionsKt.distinct(arrayList);
                    if (distinct.isEmpty()) {
                        return MapsKt.emptyMap();
                    }
                    ConversationCopilotResourceUploadApi resourceUploadApi = getResourceUploadApi();
                    GetResourceUrlRequest getResourceUrlRequest = new GetResourceUrlRequest(distinct, BizType.RemoteResource);
                    multiImagePreviewActivity$fetchRemoteResourceUrls$1.L$0 = this;
                    multiImagePreviewActivity$fetchRemoteResourceUrls$1.L$1 = list;
                    multiImagePreviewActivity$fetchRemoteResourceUrls$1.label = 1;
                    obj = resourceUploadApi.getResourceUrl(getResourceUrlRequest, multiImagePreviewActivity$fetchRemoteResourceUrls$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    multiImagePreviewActivity = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    list = (List) multiImagePreviewActivity$fetchRemoteResourceUrls$1.L$1;
                    multiImagePreviewActivity = (MultiImagePreviewActivity) multiImagePreviewActivity$fetchRemoteResourceUrls$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Map<String, String> urlMap = ((GetResourceUrlResponse) obj).getUrlMap();
                ArrayList arrayList2 = new ArrayList();
                for (String str2 : list) {
                    String normalizeRemoteResourceId2 = multiImagePreviewActivity.normalizeRemoteResourceId(str2);
                    Pair pair = null;
                    if (normalizeRemoteResourceId2 != null && ((str = urlMap.get(normalizeRemoteResourceId2)) != null || (str = urlMap.get(str2)) != null)) {
                        pair = TuplesKt.to(str2, str);
                    }
                    if (pair != null) {
                        arrayList2.add(pair);
                    }
                }
                return MapsKt.toMap(arrayList2);
            }
        }
        multiImagePreviewActivity$fetchRemoteResourceUrls$1 = new MultiImagePreviewActivity$fetchRemoteResourceUrls$1(this, continuation);
        Object obj2 = multiImagePreviewActivity$fetchRemoteResourceUrls$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = multiImagePreviewActivity$fetchRemoteResourceUrls$1.label;
        if (i != 0) {
        }
        Map<String, String> urlMap2 = ((GetResourceUrlResponse) obj2).getUrlMap();
        ArrayList arrayList22 = new ArrayList();
        while (r7.hasNext()) {
        }
        return MapsKt.toMap(arrayList22);
    }

    private final String normalizeRemoteResourceId(String raw) {
        String obj = raw != null ? StringsKt.trim(raw).toString() : null;
        if (obj == null) {
            obj = "";
        }
        if (StringsKt.isBlank(obj)) {
            return null;
        }
        String removePrefix = StringsKt.removePrefix(obj, REMOTE_RESOURCE_PREFIX);
        if (!StringsKt.isBlank(removePrefix)) {
            return removePrefix;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0222 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v18, types: [java.util.Map] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0210 -> B:11:0x003f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchLocalArtifactUrls(List<String> list, Continuation<? super Map<String, String>> continuation) {
        MultiImagePreviewActivity$fetchLocalArtifactUrls$1 multiImagePreviewActivity$fetchLocalArtifactUrls$1;
        int i;
        Map map;
        LinkedHashMap linkedHashMap;
        MultiImagePreviewActivity multiImagePreviewActivity;
        int i2;
        MultiImagePreviewActivity multiImagePreviewActivity2;
        Map map2;
        LinkedHashMap linkedHashMap2;
        HttpDataResult.Success success;
        if (continuation instanceof MultiImagePreviewActivity$fetchLocalArtifactUrls$1) {
            multiImagePreviewActivity$fetchLocalArtifactUrls$1 = (MultiImagePreviewActivity$fetchLocalArtifactUrls$1) continuation;
            if ((multiImagePreviewActivity$fetchLocalArtifactUrls$1.label & Integer.MIN_VALUE) != 0) {
                multiImagePreviewActivity$fetchLocalArtifactUrls$1.label -= Integer.MIN_VALUE;
                Object obj = multiImagePreviewActivity$fetchLocalArtifactUrls$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = multiImagePreviewActivity$fetchLocalArtifactUrls$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    String str = this.chatSessionId;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("chatSessionId");
                        str = null;
                    }
                    String str2 = str;
                    if (StringsKt.isBlank(str2) && (str2 = this.conversationId) == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
                        str2 = null;
                    }
                    String str3 = str2;
                    List<String> list2 = list;
                    ArrayList arrayList = new ArrayList();
                    for (String str4 : list2) {
                        String requestTarget = LocalArtifactPath.INSTANCE.requestTarget(str4);
                        FileDownloadHelper fileDownloadHelper = this.fileDownloadHelper;
                        Context applicationContext = AppHost.INSTANCE.getApplication().getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                        File cachedFile = fileDownloadHelper.getCachedFile(applicationContext, str3, requestTarget);
                        Pair pair = cachedFile != null ? TuplesKt.to(str4, Uri.fromFile(cachedFile).toString()) : null;
                        if (pair != null) {
                            arrayList.add(pair);
                        }
                    }
                    map = MapsKt.toMap(arrayList);
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj2 : list2) {
                        if (!map.containsKey((String) obj2)) {
                            arrayList2.add(obj2);
                        }
                    }
                    ArrayList arrayList3 = arrayList2;
                    if (arrayList3.isEmpty()) {
                        return map;
                    }
                    ArrayList arrayList4 = arrayList3;
                    LocalArtifactPath localArtifactPath = LocalArtifactPath.INSTANCE;
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList4, 10)), 16));
                    for (Object obj3 : arrayList4) {
                        linkedHashMap3.put(obj3, localArtifactPath.requestTarget((String) obj3));
                    }
                    linkedHashMap = linkedHashMap3;
                    multiImagePreviewActivity = this;
                    i2 = 0;
                    if (i2 < 21) {
                    }
                } else if (i == 1) {
                    i2 = multiImagePreviewActivity$fetchLocalArtifactUrls$1.I$0;
                    ?? r9 = (Map) multiImagePreviewActivity$fetchLocalArtifactUrls$1.L$2;
                    map2 = (Map) multiImagePreviewActivity$fetchLocalArtifactUrls$1.L$1;
                    multiImagePreviewActivity2 = (MultiImagePreviewActivity) multiImagePreviewActivity$fetchLocalArtifactUrls$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    linkedHashMap2 = r9;
                    success = (HttpDataResult) obj;
                    if (!(success instanceof HttpDataResult.Success)) {
                    }
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = multiImagePreviewActivity$fetchLocalArtifactUrls$1.I$0;
                    ?? r92 = (Map) multiImagePreviewActivity$fetchLocalArtifactUrls$1.L$2;
                    map2 = (Map) multiImagePreviewActivity$fetchLocalArtifactUrls$1.L$1;
                    multiImagePreviewActivity2 = (MultiImagePreviewActivity) multiImagePreviewActivity$fetchLocalArtifactUrls$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    LinkedHashMap linkedHashMap4 = r92;
                    map = map2;
                    linkedHashMap = linkedHashMap4;
                    multiImagePreviewActivity = multiImagePreviewActivity2;
                    i2++;
                    if (i2 < 21) {
                        CoroutineContext io = Dispatchers.getIO();
                        MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1 multiImagePreviewActivity$fetchLocalArtifactUrls$result$1 = new MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1(linkedHashMap, multiImagePreviewActivity, null);
                        multiImagePreviewActivity$fetchLocalArtifactUrls$1.L$0 = multiImagePreviewActivity;
                        multiImagePreviewActivity$fetchLocalArtifactUrls$1.L$1 = map;
                        multiImagePreviewActivity$fetchLocalArtifactUrls$1.L$2 = linkedHashMap;
                        multiImagePreviewActivity$fetchLocalArtifactUrls$1.I$0 = i2;
                        multiImagePreviewActivity$fetchLocalArtifactUrls$1.label = 1;
                        Object withContext = BuildersKt.withContext(io, multiImagePreviewActivity$fetchLocalArtifactUrls$result$1, multiImagePreviewActivity$fetchLocalArtifactUrls$1);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        LinkedHashMap linkedHashMap5 = linkedHashMap;
                        map2 = map;
                        obj = withContext;
                        multiImagePreviewActivity2 = multiImagePreviewActivity;
                        linkedHashMap2 = linkedHashMap5;
                        success = (HttpDataResult) obj;
                        if (!(success instanceof HttpDataResult.Success)) {
                            HttpDataResult.Success success2 = success;
                            GetDownloadUrlData getDownloadUrlData = (GetDownloadUrlData) success2.getBizResp().getData();
                            Map<String, String> urlMap = getDownloadUrlData != null ? getDownloadUrlData.getUrlMap() : null;
                            if (!(urlMap == null || urlMap.isEmpty())) {
                                ArrayList arrayList5 = new ArrayList();
                                for (Map.Entry entry : linkedHashMap2.entrySet()) {
                                    String str5 = (String) entry.getKey();
                                    String str6 = urlMap.get((String) entry.getValue());
                                    Pair pair2 = ((str6 == null && (str6 = urlMap.get(str5)) == null) || StringsKt.isBlank(str6)) ? null : TuplesKt.to(str5, str6);
                                    if (pair2 != null) {
                                        arrayList5.add(pair2);
                                    }
                                }
                                Map map3 = MapsKt.toMap(arrayList5);
                                if (!map3.isEmpty()) {
                                    return MapsKt.plus(map2, map3);
                                }
                            }
                            if (success2.getBizResp().getCode() != 202 || i2 >= 20) {
                                return map2;
                            }
                            multiImagePreviewActivity$fetchLocalArtifactUrls$1.L$0 = multiImagePreviewActivity2;
                            multiImagePreviewActivity$fetchLocalArtifactUrls$1.L$1 = map2;
                            multiImagePreviewActivity$fetchLocalArtifactUrls$1.L$2 = linkedHashMap2;
                            multiImagePreviewActivity$fetchLocalArtifactUrls$1.I$0 = i2;
                            multiImagePreviewActivity$fetchLocalArtifactUrls$1.label = 2;
                            linkedHashMap4 = linkedHashMap2;
                            if (DelayKt.delay(2000L, multiImagePreviewActivity$fetchLocalArtifactUrls$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            map = map2;
                            linkedHashMap = linkedHashMap4;
                            multiImagePreviewActivity = multiImagePreviewActivity2;
                            i2++;
                            if (i2 < 21) {
                                return map;
                            }
                        } else {
                            if (success instanceof HttpDataResult.Error) {
                                return map2;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                }
            }
        }
        multiImagePreviewActivity$fetchLocalArtifactUrls$1 = new MultiImagePreviewActivity$fetchLocalArtifactUrls$1(this, continuation);
        Object obj4 = multiImagePreviewActivity$fetchLocalArtifactUrls$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = multiImagePreviewActivity$fetchLocalArtifactUrls$1.label;
        if (i != 0) {
        }
    }

    private final void fetchArtifactImageUrls() {
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        progressBar.setVisibility(0);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new MultiImagePreviewActivity$fetchArtifactImageUrls$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00ed -> B:11:0x0100). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00fd -> B:11:0x0100). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchDownloadUrlsWithRetry(List<String> list, Continuation<? super Map<String, String>> continuation) {
        MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1 multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;
        int i;
        MultiImagePreviewActivity multiImagePreviewActivity;
        int i2;
        int i3;
        MultiImagePreviewActivity multiImagePreviewActivity2;
        List<String> list2;
        HttpDataResult.Success success;
        if (continuation instanceof MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1) {
            multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1 = (MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1) continuation;
            if ((multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1.label & Integer.MIN_VALUE) != 0) {
                multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1.label -= Integer.MIN_VALUE;
                Object obj = multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    multiImagePreviewActivity = this;
                    i2 = 0;
                    if (i2 < 21) {
                    }
                } else if (i == 1) {
                    i3 = multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1.I$0;
                    list2 = (List) multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1.L$1;
                    multiImagePreviewActivity2 = (MultiImagePreviewActivity) multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    success = (HttpDataResult) obj;
                    if (!(success instanceof HttpDataResult.Success)) {
                    }
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i3 = multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1.I$0;
                    list2 = (List) multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1.L$1;
                    multiImagePreviewActivity2 = (MultiImagePreviewActivity) multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    i2 = i3 + 1;
                    list = list2;
                    multiImagePreviewActivity = multiImagePreviewActivity2;
                    if (i2 < 21) {
                        CoroutineContext io = Dispatchers.getIO();
                        MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$result$1 multiImagePreviewActivity$fetchDownloadUrlsWithRetry$result$1 = new MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$result$1(list, multiImagePreviewActivity, null);
                        multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1.L$0 = multiImagePreviewActivity;
                        multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1.L$1 = list;
                        multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1.I$0 = i2;
                        multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1.label = 1;
                        Object withContext = BuildersKt.withContext(io, multiImagePreviewActivity$fetchDownloadUrlsWithRetry$result$1, multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        MultiImagePreviewActivity multiImagePreviewActivity3 = multiImagePreviewActivity;
                        list2 = list;
                        i3 = i2;
                        obj = withContext;
                        multiImagePreviewActivity2 = multiImagePreviewActivity3;
                        success = (HttpDataResult) obj;
                        if (!(success instanceof HttpDataResult.Success)) {
                            HttpDataResult.Success success2 = success;
                            GetDownloadUrlData getDownloadUrlData = (GetDownloadUrlData) success2.getBizResp().getData();
                            Map<String, String> urlMap = getDownloadUrlData != null ? getDownloadUrlData.getUrlMap() : null;
                            if (!(urlMap == null || urlMap.isEmpty())) {
                                LinkedHashMap linkedHashMap = new LinkedHashMap();
                                for (Map.Entry<String, String> entry : urlMap.entrySet()) {
                                    if (entry.getValue().length() > 0) {
                                        linkedHashMap.put(entry.getKey(), entry.getValue());
                                    }
                                }
                                return linkedHashMap;
                            }
                            if (success2.getBizResp().getCode() != 202) {
                                return MapsKt.emptyMap();
                            }
                            if (i3 < 20) {
                                multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1.L$0 = multiImagePreviewActivity2;
                                multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1.L$1 = list2;
                                multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1.I$0 = i3;
                                multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1.label = 2;
                                if (DelayKt.delay(2000L, multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            i2 = i3 + 1;
                            list = list2;
                            multiImagePreviewActivity = multiImagePreviewActivity2;
                            if (i2 < 21) {
                                return MapsKt.emptyMap();
                            }
                        } else {
                            if (success instanceof HttpDataResult.Error) {
                                return MapsKt.emptyMap();
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                }
            }
        }
        multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1 = new MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1(this, continuation);
        Object obj2 = multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = multiImagePreviewActivity$fetchDownloadUrlsWithRetry$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void downloadCurrentImage() {
        boolean areEqual;
        String str;
        String str2 = (String) CollectionsKt.getOrNull(this.paths, this.currentIndex);
        if (str2 == null) {
            return;
        }
        String str3 = this.imageUrls.get(str2);
        String str4 = str3;
        if (str4 == null || str4.length() == 0) {
            CustomToast.showLong((Context) this, getString(R.string.trae_doc_preview_download_failed));
            return;
        }
        String downloadFileName = downloadFileName(str2, this.currentIndex);
        String str5 = null;
        if ((Intrinsics.areEqual(this.resolveMode, RESOLVE_MODE_LOCAL_URI) || Intrinsics.areEqual(this.resolveMode, RESOLVE_MODE_LOCAL_ARTIFACT)) && isLocalUri(str3)) {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new MultiImagePreviewActivity$downloadCurrentImage$1(this, downloadFileName, str3, null), 3, (Object) null);
            return;
        }
        String str6 = this.resolveMode;
        int hashCode = str6.hashCode();
        if (hashCode != -1228798510) {
            areEqual = hashCode != -843977753 ? true : true;
        } else {
            if (str6.equals(RESOLVE_MODE_ARTIFACT)) {
                String str7 = this.cliType;
                if (str7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cliType");
                    str7 = null;
                }
                areEqual = Intrinsics.areEqual(str7, CliType.LOCAL.getValue());
            }
            areEqual = false;
        }
        FileDownloadHelper fileDownloadHelper = this.fileDownloadHelper;
        if (Intrinsics.areEqual(this.resolveMode, RESOLVE_MODE_ARTIFACT)) {
            str = this.chatSessionId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatSessionId");
                fileDownloadHelper.saveFileAndLoading((Context) this, str3, str5, downloadFileName, (CoroutineScope) LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), this.downloadFinishCallback, areEqual, this.createdTime);
            }
        } else {
            str = "";
        }
        str5 = str;
        fileDownloadHelper.saveFileAndLoading((Context) this, str3, str5, downloadFileName, (CoroutineScope) LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), this.downloadFinishCallback, areEqual, this.createdTime);
    }

    static /* synthetic */ String normalizeFilePath$default(MultiImagePreviewActivity multiImagePreviewActivity, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return multiImagePreviewActivity.normalizeFilePath(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String normalizeFilePath(String filePath, String workspacePath) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildFileUrl(String explorerUrl, String path) {
        String encode = URLEncoder.encode(path, "UTF-8");
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        String xTToken = iLoginService != null ? iLoginService.getXTToken() : null;
        if (xTToken == null) {
            xTToken = "";
        }
        return StringsKt.trimEnd(explorerUrl, new char[]{'/'}) + "/file/" + encode + "?download=true&authorization=" + URLEncoder.encode("Cloud-IDE-JWT " + xTToken, "UTF-8");
    }

    private final String displayNameForIndex(int index) {
        String obj;
        String str = (String) CollectionsKt.getOrNull(this.displayNames, index);
        if (str == null || (obj = StringsKt.trim(str).toString()) == null || !(!StringsKt.isBlank(obj))) {
            return null;
        }
        return obj;
    }

    private final String downloadFileName(String path, int index) {
        String displayNameForIndex = displayNameForIndex(index);
        if (displayNameForIndex == null) {
            String str = this.resolveMode;
            int hashCode = str.hashCode();
            if (hashCode != -1204869480) {
                if (hashCode == -859601281 ? str.equals(RESOLVE_MODE_IMAGE_ID) : hashCode == -843977753 && str.equals(RESOLVE_MODE_REMOTE_RESOURCE)) {
                    path = null;
                }
            } else if (str.equals(RESOLVE_MODE_LOCAL_URI)) {
                Uri parse = Uri.parse(path);
                Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                displayNameForIndex = queryDisplayName(parse);
                if (displayNameForIndex == null) {
                    path = Uri.parse(path).getLastPathSegment();
                }
            }
            return sanitizeImageFileName(path, index);
        }
        path = displayNameForIndex;
        return sanitizeImageFileName(path, index);
    }

    private final String sanitizeImageFileName(String raw, int index) {
        String substringBefore$default;
        String substringAfterLast$default;
        String substringAfterLast$default2;
        String str = null;
        if (raw != null && (substringBefore$default = StringsKt.substringBefore$default(raw, '?', (String) null, 2, (Object) null)) != null && (substringAfterLast$default = StringsKt.substringAfterLast$default(substringBefore$default, '/', (String) null, 2, (Object) null)) != null && (substringAfterLast$default2 = StringsKt.substringAfterLast$default(substringAfterLast$default, '\\', (String) null, 2, (Object) null)) != null) {
            str = StringsKt.trim(substringAfterLast$default2).toString();
        }
        if (str == null) {
            str = "";
        }
        if (StringsKt.isBlank(str)) {
            return fallbackImageFileName(index);
        }
        String lowerCase = StringsKt.substringAfterLast(str, '.', "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return IMAGE_EXTENSIONS.contains(lowerCase) ? str : fallbackImageFileName(index);
    }

    private final String fallbackImageFileName(int index) {
        return "trae_image_" + (index + 1) + ".jpg";
    }

    private final boolean isLocalUri(String raw) {
        return StringsKt.startsWith$default(raw, "content://", false, 2, (Object) null) || StringsKt.startsWith$default(raw, "file://", false, 2, (Object) null);
    }

    private final String queryDisplayName(Uri uri) {
        Object obj;
        String str;
        if (!Intrinsics.areEqual(uri.getScheme(), ReportConstant.COMMON_CONTENT)) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            MultiImagePreviewActivity multiImagePreviewActivity = this;
            Cursor query = getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
            if (query != null) {
                Cursor cursor = query;
                try {
                    Cursor cursor2 = cursor;
                    str = cursor2.moveToFirst() ? cursor2.getString(cursor2.getColumnIndexOrThrow("_display_name")) : null;
                    CloseableKt.closeFinally(cursor, (Throwable) null);
                } finally {
                }
            } else {
                str = null;
            }
            obj = Result.constructor-impl(str);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        String str2 = (String) obj;
        if (str2 == null || !(!StringsKt.isBlank(str2))) {
            return null;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File copyLocalUriToCache(Uri uri, String fileName) {
        Object obj;
        FileOutputStream fileOutputStream;
        long copyTo$default;
        File file = new File(new File(getCacheDir(), LOCAL_IMAGE_DOWNLOAD_CACHE_DIR), StringsKt.substringAfterLast$default(StringsKt.substringAfterLast$default(fileName, '/', (String) null, 2, (Object) null), '\\', (String) null, 2, (Object) null));
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        boolean z = false;
        try {
            Result.Companion companion = Result.Companion;
            MultiImagePreviewActivity multiImagePreviewActivity = this;
            if (Intrinsics.areEqual(uri.getScheme(), MessagePart.TYPE_FILE)) {
                String path = uri.getPath();
                if (path == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                fileOutputStream = new FileInputStream(new File(path));
                try {
                    FileInputStream fileInputStream = fileOutputStream;
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        copyTo$default = ByteStreamsKt.copyTo$default(fileInputStream, fileOutputStream, 0, 2, (Object) null);
                        CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                        CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                    } finally {
                        try {
                            throw th;
                        } finally {
                        }
                    }
                } finally {
                }
            } else {
                InputStream openInputStream = getContentResolver().openInputStream(uri);
                if (openInputStream == null) {
                    return null;
                }
                fileOutputStream = openInputStream;
                try {
                    InputStream inputStream = fileOutputStream;
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        copyTo$default = ByteStreamsKt.copyTo$default(inputStream, fileOutputStream, 0, 2, (Object) null);
                        CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                        CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                    } finally {
                    }
                } finally {
                    try {
                        throw th;
                    } finally {
                    }
                }
            }
            obj = Result.constructor-impl(Long.valueOf(copyTo$default));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            FLogger.INSTANCE.e(TAG, "copyLocalUriToCache failed: uri=" + uri + ", fileName=" + fileName, th2);
            file.delete();
            return null;
        }
        if (file.exists() && file.length() > 0) {
            z = true;
        }
        if (z) {
            return file;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MultiImagePreviewActivity.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\b\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J \u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J(\u0010\u0011\u001a\u00020\r2\u000e\u0010\u000e\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J \u0010\u0015\u001a\u00020\r2\u000e\u0010\u000e\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;", "Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;", "count", "", "<init>", "(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;I)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", NewTaskTracker.Param.POSITION, "getItemCount", "loadImageIntoView", IWeixinService.ResponseConstants.URL, "", "path", "loadUri", "uri", "Landroid/net/Uri;", "ImageViewHolder", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public final class ImagePagerAdapter extends RecyclerView.Adapter<ImageViewHolder> {
        private final int count;

        public ImagePagerAdapter(int i) {
            this.count = i;
        }

        /* compiled from: MultiImagePreviewActivity.kt */
        @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0017J\u0006\u0010>\u001a\u00020<J\u0006\u0010?\u001a\u00020<R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0011\u00103\u001a\u000204¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u00107\u001a\u000208¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:¨\u0006@"}, d2 = {"Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;Landroid/view/View;)V", "draweeView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getDraweeView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "boundPath", "", "getBoundPath", "()Ljava/lang/String;", "setBoundPath", "(Ljava/lang/String;)V", "downloadJob", "Lkotlinx/coroutines/Job;", "getDownloadJob", "()Lkotlinx/coroutines/Job;", "setDownloadJob", "(Lkotlinx/coroutines/Job;)V", "currentScale", "", "getCurrentScale", "()F", "setCurrentScale", "(F)V", "lastTouchX", "getLastTouchX", "setLastTouchX", "lastTouchY", "getLastTouchY", "setLastTouchY", "isDragging", "", "()Z", "setDragging", "(Z)V", "activePointerId", "", "getActivePointerId", "()I", "setActivePointerId", "(I)V", "scaleAnimator", "Landroid/animation/ValueAnimator;", "getScaleAnimator", "()Landroid/animation/ValueAnimator;", "setScaleAnimator", "(Landroid/animation/ValueAnimator;)V", "scaleGestureDetector", "Landroid/view/ScaleGestureDetector;", "getScaleGestureDetector", "()Landroid/view/ScaleGestureDetector;", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "animateToScale", "", "targetScale", "setupTouchHandling", "resetScale", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public final class ImageViewHolder extends RecyclerView.ViewHolder {
            private int activePointerId;
            private String boundPath;
            private float currentScale;
            private Job downloadJob;
            private final SimpleDraweeView draweeView;
            private final GestureDetector gestureDetector;
            private boolean isDragging;
            private float lastTouchX;
            private float lastTouchY;
            private ValueAnimator scaleAnimator;
            private final ScaleGestureDetector scaleGestureDetector;
            final /* synthetic */ ImagePagerAdapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ImageViewHolder(ImagePagerAdapter imagePagerAdapter, View view) {
                super(view);
                Intrinsics.checkNotNullParameter(view, "itemView");
                this.this$0 = imagePagerAdapter;
                SimpleDraweeView findViewById = view.findViewById(C0637R.id.iv_pager_image);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
                this.draweeView = findViewById;
                this.currentScale = MultiImagePreviewActivity.MIN_SCALE;
                this.activePointerId = -1;
                Context context = (Context) MultiImagePreviewActivity.this;
                final MultiImagePreviewActivity multiImagePreviewActivity = MultiImagePreviewActivity.this;
                this.scaleGestureDetector = new ScaleGestureDetector(context, new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.bytedance.trae.conversation.products.MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$scaleGestureDetector$1
                    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
                    public boolean onScaleBegin(ScaleGestureDetector detector) {
                        Intrinsics.checkNotNullParameter(detector, "detector");
                        ValueAnimator scaleAnimator = MultiImagePreviewActivity.ImagePagerAdapter.ImageViewHolder.this.getScaleAnimator();
                        if (scaleAnimator != null) {
                            scaleAnimator.cancel();
                        }
                        MultiImagePreviewActivity.ImagePagerAdapter.ImageViewHolder.this.setDragging(false);
                        ViewPager2 viewPager2 = multiImagePreviewActivity.viewPager;
                        if (viewPager2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                            viewPager2 = null;
                        }
                        viewPager2.setUserInputEnabled(false);
                        return true;
                    }

                    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
                    public boolean onScale(ScaleGestureDetector detector) {
                        Intrinsics.checkNotNullParameter(detector, "detector");
                        MultiImagePreviewActivity.ImagePagerAdapter.ImageViewHolder.this.setCurrentScale(RangesKt.coerceIn(MultiImagePreviewActivity.ImagePagerAdapter.ImageViewHolder.this.getCurrentScale() * detector.getScaleFactor(), 0.5f, 5.0f));
                        MultiImagePreviewActivity.ImagePagerAdapter.ImageViewHolder.this.getDraweeView().setScaleX(MultiImagePreviewActivity.ImagePagerAdapter.ImageViewHolder.this.getCurrentScale());
                        MultiImagePreviewActivity.ImagePagerAdapter.ImageViewHolder.this.getDraweeView().setScaleY(MultiImagePreviewActivity.ImagePagerAdapter.ImageViewHolder.this.getCurrentScale());
                        return true;
                    }

                    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
                    public void onScaleEnd(ScaleGestureDetector detector) {
                        Intrinsics.checkNotNullParameter(detector, "detector");
                        if (MultiImagePreviewActivity.ImagePagerAdapter.ImageViewHolder.this.getCurrentScale() < 1.0f) {
                            MultiImagePreviewActivity.ImagePagerAdapter.ImageViewHolder.this.animateToScale(1.0f);
                        }
                        if (MultiImagePreviewActivity.ImagePagerAdapter.ImageViewHolder.this.getCurrentScale() <= 1.0f) {
                            ViewPager2 viewPager2 = multiImagePreviewActivity.viewPager;
                            if (viewPager2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                                viewPager2 = null;
                            }
                            viewPager2.setUserInputEnabled(true);
                        }
                    }
                });
                Context context2 = (Context) MultiImagePreviewActivity.this;
                final MultiImagePreviewActivity multiImagePreviewActivity2 = MultiImagePreviewActivity.this;
                this.gestureDetector = new GestureDetector(context2, new GestureDetector.SimpleOnGestureListener() { // from class: com.bytedance.trae.conversation.products.MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$gestureDetector$1
                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                    public boolean onSingleTapConfirmed(MotionEvent e) {
                        Intrinsics.checkNotNullParameter(e, "e");
                        MultiImagePreviewActivity.this.toggleTopBar();
                        return true;
                    }

                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                    public boolean onDoubleTap(MotionEvent e) {
                        Intrinsics.checkNotNullParameter(e, "e");
                        if (this.getCurrentScale() > 1.0f) {
                            this.animateToScale(1.0f);
                            return true;
                        }
                        this.animateToScale(2.5f);
                        return true;
                    }
                });
            }

            public final SimpleDraweeView getDraweeView() {
                return this.draweeView;
            }

            public final String getBoundPath() {
                return this.boundPath;
            }

            public final void setBoundPath(String str) {
                this.boundPath = str;
            }

            public final Job getDownloadJob() {
                return this.downloadJob;
            }

            public final void setDownloadJob(Job job) {
                this.downloadJob = job;
            }

            public final float getCurrentScale() {
                return this.currentScale;
            }

            public final void setCurrentScale(float f) {
                this.currentScale = f;
            }

            public final float getLastTouchX() {
                return this.lastTouchX;
            }

            public final void setLastTouchX(float f) {
                this.lastTouchX = f;
            }

            public final float getLastTouchY() {
                return this.lastTouchY;
            }

            public final void setLastTouchY(float f) {
                this.lastTouchY = f;
            }

            /* renamed from: isDragging, reason: from getter */
            public final boolean getIsDragging() {
                return this.isDragging;
            }

            public final void setDragging(boolean z) {
                this.isDragging = z;
            }

            public final int getActivePointerId() {
                return this.activePointerId;
            }

            public final void setActivePointerId(int i) {
                this.activePointerId = i;
            }

            public final ValueAnimator getScaleAnimator() {
                return this.scaleAnimator;
            }

            public final void setScaleAnimator(ValueAnimator valueAnimator) {
                this.scaleAnimator = valueAnimator;
            }

            public final ScaleGestureDetector getScaleGestureDetector() {
                return this.scaleGestureDetector;
            }

            public final GestureDetector getGestureDetector() {
                return this.gestureDetector;
            }

            public final void animateToScale(final float targetScale) {
                ValueAnimator valueAnimator = this.scaleAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                final float f = this.currentScale;
                final float translationX = this.draweeView.getTranslationX();
                final float translationY = this.draweeView.getTranslationY();
                boolean z = targetScale == MultiImagePreviewActivity.MIN_SCALE;
                final float f2 = z ? 0.0f : translationX;
                final float f3 = z ? 0.0f : translationY;
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, MultiImagePreviewActivity.MIN_SCALE);
                final MultiImagePreviewActivity multiImagePreviewActivity = MultiImagePreviewActivity.this;
                ofFloat.setDuration(250L);
                ofFloat.setInterpolator(new DecelerateInterpolator());
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.trae.conversation.products.MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        MultiImagePreviewActivity.ImagePagerAdapter.ImageViewHolder.animateToScale$lambda$1$lambda$0(f, targetScale, this, translationX, f2, translationY, f3, valueAnimator2);
                    }
                });
                ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.trae.conversation.products.MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$animateToScale$1$2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        if (MultiImagePreviewActivity.ImagePagerAdapter.ImageViewHolder.this.getCurrentScale() <= 1.0f) {
                            ViewPager2 viewPager2 = multiImagePreviewActivity.viewPager;
                            if (viewPager2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                                viewPager2 = null;
                            }
                            viewPager2.setUserInputEnabled(true);
                        }
                    }
                });
                ofFloat.start();
                this.scaleAnimator = ofFloat;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void animateToScale$lambda$1$lambda$0(float f, float f2, ImageViewHolder imageViewHolder, float f3, float f4, float f5, float f6, ValueAnimator valueAnimator) {
                Intrinsics.checkNotNullParameter(valueAnimator, "animator");
                Object animatedValue = valueAnimator.getAnimatedValue();
                Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                float floatValue = ((Float) animatedValue).floatValue();
                float f7 = f + ((f2 - f) * floatValue);
                imageViewHolder.currentScale = f7;
                imageViewHolder.draweeView.setScaleX(f7);
                imageViewHolder.draweeView.setScaleY(f7);
                imageViewHolder.draweeView.setTranslationX(f3 + ((f4 - f3) * floatValue));
                imageViewHolder.draweeView.setTranslationY(f5 + ((f6 - f5) * floatValue));
            }

            public final void setupTouchHandling() {
                this.draweeView.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.trae.conversation.products.MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        boolean z;
                        z = MultiImagePreviewActivity.ImagePagerAdapter.ImageViewHolder.setupTouchHandling$lambda$2(MultiImagePreviewActivity.ImagePagerAdapter.ImageViewHolder.this, view, motionEvent);
                        return z;
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean setupTouchHandling$lambda$2(ImageViewHolder imageViewHolder, View view, MotionEvent motionEvent) {
                int findPointerIndex;
                imageViewHolder.scaleGestureDetector.onTouchEvent(motionEvent);
                imageViewHolder.gestureDetector.onTouchEvent(motionEvent);
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    imageViewHolder.activePointerId = motionEvent.getPointerId(0);
                    imageViewHolder.lastTouchX = motionEvent.getX();
                    imageViewHolder.lastTouchY = motionEvent.getY();
                    imageViewHolder.isDragging = true;
                } else {
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked != 3) {
                                if (actionMasked == 5) {
                                    imageViewHolder.isDragging = false;
                                } else if (actionMasked == 6) {
                                    int actionIndex = motionEvent.getActionIndex();
                                    if (motionEvent.getPointerId(actionIndex) == imageViewHolder.activePointerId) {
                                        int i = actionIndex == 0 ? 1 : 0;
                                        if (i < motionEvent.getPointerCount()) {
                                            imageViewHolder.lastTouchX = motionEvent.getX(i);
                                            imageViewHolder.lastTouchY = motionEvent.getY(i);
                                            imageViewHolder.activePointerId = motionEvent.getPointerId(i);
                                        }
                                    }
                                }
                            }
                        } else if (imageViewHolder.isDragging && !imageViewHolder.scaleGestureDetector.isInProgress() && (findPointerIndex = motionEvent.findPointerIndex(imageViewHolder.activePointerId)) >= 0) {
                            float x = motionEvent.getX(findPointerIndex);
                            float y = motionEvent.getY(findPointerIndex);
                            float f = x - imageViewHolder.lastTouchX;
                            float f2 = y - imageViewHolder.lastTouchY;
                            if (imageViewHolder.currentScale > MultiImagePreviewActivity.MIN_SCALE) {
                                SimpleDraweeView simpleDraweeView = imageViewHolder.draweeView;
                                simpleDraweeView.setTranslationX(simpleDraweeView.getTranslationX() + f);
                                SimpleDraweeView simpleDraweeView2 = imageViewHolder.draweeView;
                                simpleDraweeView2.setTranslationY(simpleDraweeView2.getTranslationY() + f2);
                            }
                            imageViewHolder.lastTouchX = x;
                            imageViewHolder.lastTouchY = y;
                        }
                    }
                    imageViewHolder.isDragging = false;
                    imageViewHolder.activePointerId = -1;
                }
                return true;
            }

            public final void resetScale() {
                ValueAnimator valueAnimator = this.scaleAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                this.currentScale = MultiImagePreviewActivity.MIN_SCALE;
                this.draweeView.setScaleX(MultiImagePreviewActivity.MIN_SCALE);
                this.draweeView.setScaleY(MultiImagePreviewActivity.MIN_SCALE);
                this.draweeView.setTranslationX(0.0f);
                this.draweeView.setTranslationY(0.0f);
                ViewPager2 viewPager2 = MultiImagePreviewActivity.this.viewPager;
                if (viewPager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                    viewPager2 = null;
                }
                viewPager2.setUserInputEnabled(true);
            }
        }

        public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(C0637R.layout.trae_item_multi_image_preview, parent, false);
            Intrinsics.checkNotNull(inflate);
            return new ImageViewHolder(this, inflate);
        }

        public void onBindViewHolder(ImageViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Job downloadJob = holder.getDownloadJob();
            boolean z = true;
            if (downloadJob != null) {
                Job.DefaultImpls.cancel$default(downloadJob, (CancellationException) null, 1, (Object) null);
            }
            holder.setDownloadJob(null);
            holder.resetScale();
            holder.setupTouchHandling();
            String str = (String) MultiImagePreviewActivity.this.paths.get(position);
            holder.setBoundPath(str);
            String str2 = (String) MultiImagePreviewActivity.this.imageUrls.get(str);
            String str3 = str2;
            if (str3 != null && str3.length() != 0) {
                z = false;
            }
            if (z) {
                holder.getDraweeView().setController((DraweeController) null);
            } else {
                loadImageIntoView(holder, str2, str);
            }
        }

        /* renamed from: getItemCount, reason: from getter */
        public int getCount() {
            return this.count;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x009a, code lost:
        
            if (r0.equals(com.bytedance.trae.conversation.products.MultiImagePreviewActivity.RESOLVE_MODE_IMAGE_ID) != false) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x00a6, code lost:
        
            r13 = android.net.Uri.parse(r13);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, "parse(...)");
            loadUri(r12, r13);
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00a3, code lost:
        
            if (r0.equals(com.bytedance.trae.conversation.products.MultiImagePreviewActivity.RESOLVE_MODE_LOCAL_URI) == false) goto L27;
         */
        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0013. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00b9  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00cb  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x010a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void loadImageIntoView(ImageViewHolder holder, String url, String path) {
            String str;
            String str2 = MultiImagePreviewActivity.this.resolveMode;
            switch (str2.hashCode()) {
                case -1204869480:
                    break;
                case -859601281:
                    break;
                case -843977753:
                    if (str2.equals(MultiImagePreviewActivity.RESOLVE_MODE_REMOTE_RESOURCE)) {
                        holder.setDownloadJob(BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(MultiImagePreviewActivity.this), (CoroutineContext) null, (CoroutineStart) null, new MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$1(holder, path, this, MultiImagePreviewActivity.this, url, null), 3, (Object) null));
                        return;
                    }
                    str = MultiImagePreviewActivity.this.cliType;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cliType");
                        str = null;
                    }
                    if (Intrinsics.areEqual(str, CliType.LOCAL.getValue())) {
                        if (StringsKt.startsWith$default(url, "content://", false, 2, (Object) null) || StringsKt.startsWith$default(url, "file://", false, 2, (Object) null)) {
                            Uri parse = Uri.parse(url);
                            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                            loadUri(holder, parse);
                            return;
                        }
                        holder.setDownloadJob(BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(MultiImagePreviewActivity.this), (CoroutineContext) null, (CoroutineStart) null, new MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$3(holder, path, this, MultiImagePreviewActivity.this, url, null), 3, (Object) null));
                        return;
                    }
                    Uri parse2 = Uri.parse(url);
                    Intrinsics.checkNotNullExpressionValue(parse2, "parse(...)");
                    loadUri(holder, parse2);
                    return;
                case -471957466:
                    if (str2.equals(MultiImagePreviewActivity.RESOLVE_MODE_LOCAL_ARTIFACT)) {
                        if (StringsKt.startsWith$default(url, "content://", false, 2, (Object) null) || StringsKt.startsWith$default(url, "file://", false, 2, (Object) null)) {
                            Uri parse3 = Uri.parse(url);
                            Intrinsics.checkNotNullExpressionValue(parse3, "parse(...)");
                            loadUri(holder, parse3);
                            return;
                        }
                        holder.setDownloadJob(BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(MultiImagePreviewActivity.this), (CoroutineContext) null, (CoroutineStart) null, new MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2(path, holder, this, MultiImagePreviewActivity.this, url, null), 3, (Object) null));
                        return;
                    }
                    str = MultiImagePreviewActivity.this.cliType;
                    if (str == null) {
                    }
                    if (Intrinsics.areEqual(str, CliType.LOCAL.getValue())) {
                    }
                    break;
                default:
                    str = MultiImagePreviewActivity.this.cliType;
                    if (str == null) {
                    }
                    if (Intrinsics.areEqual(str, CliType.LOCAL.getValue())) {
                    }
                    break;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void loadUri(ImageViewHolder holder, Uri uri) {
            holder.getDraweeView().setController(Fresco.newDraweeControllerBuilder().setUri(uri).setAutoPlayAnimations(true).setOldController(holder.getDraweeView().getController()).build());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_conversation_products_MultiImagePreviewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m851x7c1814eb(MultiImagePreviewActivity multiImagePreviewActivity) {
        multiImagePreviewActivity.m852xb0cec710();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) multiImagePreviewActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
