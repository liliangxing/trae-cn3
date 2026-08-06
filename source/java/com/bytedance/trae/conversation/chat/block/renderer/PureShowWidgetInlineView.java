package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import com.bytedance.sdk.account.platform.api.IWeiboService;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetFullscreenActivity;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* compiled from: PureShowWidgetInlineView.kt */
@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001/\b\u0000\u0018\u0000 W2\u00020\u0001:\u0001WB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\u001bJ\b\u00105\u001a\u000202H\u0014J\b\u00106\u001a\u000202H\u0014J\u0006\u00107\u001a\u000202J\b\u00108\u001a\u00020\u0012H\u0002J\u001a\u00109\u001a\u0002022\u0006\u0010:\u001a\u00020\u00122\b\b\u0002\u0010;\u001a\u00020\u001bH\u0002J\u0018\u0010<\u001a\u0002022\u0006\u0010:\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u001bH\u0002J\b\u0010>\u001a\u000202H\u0002J\f\u0010?\u001a\u000202*\u00020\u0012H\u0002J\u0018\u0010@\u001a\u0002022\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00170\u001eH\u0002J\b\u0010B\u001a\u000202H\u0002J\b\u0010C\u001a\u000202H\u0002J\b\u0010D\u001a\u000202H\u0002J\b\u0010E\u001a\u000202H\u0002J\b\u0010F\u001a\u000202H\u0002J\b\u0010G\u001a\u000202H\u0002J\b\u0010H\u001a\u000202H\u0002J\u0018\u0010I\u001a\u0002022\u0006\u00103\u001a\u00020\"2\u0006\u0010J\u001a\u00020\u0017H\u0002J\u0010\u0010K\u001a\u00020\u001b2\u0006\u0010L\u001a\u00020MH\u0002J\b\u0010N\u001a\u000202H\u0002J\b\u0010O\u001a\u000202H\u0002J\b\u0010P\u001a\u000202H\u0002J\u0012\u0010Q\u001a\u0002022\b\b\u0002\u0010R\u001a\u00020\tH\u0002J\b\u0010S\u001a\u000202H\u0002J\u0014\u0010T\u001a\u0004\u0018\u00010U2\b\u0010V\u001a\u0004\u0018\u00010\u0017H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100¨\u0006X"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "handler", "Landroid/os/Handler;", "bootstrapHeightPx", "", "tapSlopPx", "loadingIconView", "Landroid/widget/ImageView;", "loadingTextView", "Landroid/widget/TextView;", "loadingContainer", "Landroid/widget/LinearLayout;", "webView", "Landroid/webkit/WebView;", "fullscreenButton", "Landroidx/appcompat/widget/AppCompatImageButton;", "createWebView", "lastWidgetCode", "", "presentationState", "Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationState;", "hasLoggedFinishedRegression", "", "currentHeightPx", "currentLoadingMessages", "", "loadingMessageIndex", "loadingMessageRotationActive", "fullscreenPayload", "Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;", "touchDownX", "", "touchDownY", "pendingHeightChecksAfterAttach", "pendingHeightCheckCount", "heightMeasuredForCurrentLoad", "released", "renderProcessFailed", "currentHeightCacheKey", "heightCheckRunnable", "Ljava/lang/Runnable;", "loadingMessageRunnable", "com/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$loadingMessageRunnable$1", "Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$loadingMessageRunnable$1;", "bind", "", "payload", "groupFinished", "onAttachedToWindow", "onDetachedFromWindow", "release", "attachNewWebView", "destroyWebView", "view", "rendererGone", "handleRenderProcessGone", "didCrash", "notifyInlineViewCreated", "setupSettings", "showLoading", "messages", "showWebView", "showRenderProcessFailure", "updateLoadingMessage", "startLoadingAnimation", "stopLoadingAnimation", "startLoadingMessageRotation", "stopLoadingMessageRotation", "loadWidgetCode", "widgetCode", "handleWebViewTouch", Fields.EVENT, "Landroid/view/MotionEvent;", "openFullscreenPreview", "scheduleHeightChecks", "updateHeightFromContent", "resetWebViewHeight", "targetHeightPx", "notifyContentChanged", "parseHeightMeasurement", "Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;", "value", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PureShowWidgetInlineView extends FrameLayout {

    @Deprecated
    public static final int HEIGHT_CACHE_MAX_SIZE = 20;

    @Deprecated
    public static final int HEIGHT_CHANGE_THRESHOLD_PX = 1;

    @Deprecated
    public static final String HEIGHT_SCRIPT = "\n            (function() {\n                var doc = document.documentElement || {};\n                var root = document.getElementById('trae-widget-root');\n                if (!root || !root.getBoundingClientRect) {\n                    return '0,0';\n                }\n                var rootRect = root.getBoundingClientRect();\n                var height = Math.max(rootRect.height || 0, root.scrollHeight || 0, root.offsetHeight || 0);\n                var children = root.children || [];\n                for (var i = 0; i < children.length; i++) {\n                    var childRect = children[i].getBoundingClientRect();\n                    height = Math.max(height, childRect.bottom - rootRect.top);\n                }\n                var viewportWidth = window.innerWidth || doc.clientWidth || rootRect.width || 0;\n                return height + ',' + viewportWidth;\n            })();\n        ";

    @Deprecated
    public static final long LOADING_MESSAGE_INTERVAL_MS = 3000;

    @Deprecated
    public static final int MIN_RENDERED_HEIGHT_PX = 1;

    @Deprecated
    public static final String TAG = "PureShowWidget";
    private final int bootstrapHeightPx;
    private String currentHeightCacheKey;
    private int currentHeightPx;
    private List<String> currentLoadingMessages;
    private final AppCompatImageButton fullscreenButton;
    private PureShowWidgetPayload fullscreenPayload;
    private final Handler handler;
    private boolean hasLoggedFinishedRegression;
    private final Runnable heightCheckRunnable;
    private boolean heightMeasuredForCurrentLoad;
    private String lastWidgetCode;
    private final LinearLayout loadingContainer;
    private final ImageView loadingIconView;
    private int loadingMessageIndex;
    private boolean loadingMessageRotationActive;
    private final PureShowWidgetInlineView$loadingMessageRunnable$1 loadingMessageRunnable;
    private final TextView loadingTextView;
    private int pendingHeightCheckCount;
    private boolean pendingHeightChecksAfterAttach;
    private final PureShowWidgetPresentationState presentationState;
    private boolean released;
    private boolean renderProcessFailed;
    private final int tapSlopPx;
    private float touchDownX;
    private float touchDownY;
    private WebView webView;
    private static final Companion Companion = new Companion(null);
    private static final long[] HEIGHT_CHECK_DELAYS_MS = {80, 200, 400, 800, 1200, 2000};
    private static final LinkedHashMap<String, Integer> HEIGHT_CACHE = new LinkedHashMap<String, Integer>() { // from class: com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView$Companion$HEIGHT_CACHE$1
        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof String) {
                return containsKey((String) obj);
            }
            return false;
        }

        public /* bridge */ boolean containsKey(String str) {
            return super.containsKey((Object) str);
        }

        public /* bridge */ boolean containsValue(Integer num) {
            return super.containsValue((Object) num);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof Integer) {
                return containsValue((Integer) obj);
            }
            return false;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, Integer>> entrySet() {
            return getEntries();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Integer get(Object obj) {
            if (obj instanceof String) {
                return get((String) obj);
            }
            return null;
        }

        public /* bridge */ Integer get(String str) {
            return (Integer) super.get((Object) str);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof String) {
                return get((String) obj);
            }
            return null;
        }

        public /* bridge */ Set<Map.Entry<String, Integer>> getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set<String> getKeys() {
            return super.keySet();
        }

        public final /* bridge */ Integer getOrDefault(Object obj, Integer num) {
            return !(obj instanceof String) ? num : getOrDefault((String) obj, num);
        }

        public /* bridge */ Integer getOrDefault(String str, Integer num) {
            return (Integer) super.getOrDefault((Object) str, (String) num);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, (Integer) obj2);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection<Integer> getValues() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return getKeys();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Integer remove(Object obj) {
            if (obj instanceof String) {
                return remove((String) obj);
            }
            return null;
        }

        public /* bridge */ Integer remove(String str) {
            return (Integer) super.remove((Object) str);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof String) {
                return remove((String) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof String) && (obj2 instanceof Integer)) {
                return remove((String) obj, (Integer) obj2);
            }
            return false;
        }

        public /* bridge */ boolean remove(String str, Integer num) {
            return super.remove((Object) str, (Object) num);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<Integer> values() {
            return getValues();
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
            return size() > 20;
        }
    };

    /* compiled from: PureShowWidgetInlineView.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PureShowWidgetPresentationMode.values().length];
            try {
                iArr[PureShowWidgetPresentationMode.SHOW_LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PureShowWidgetPresentationMode.SHOW_COMPLETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PureShowWidgetPresentationMode.KEEP_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r11v11, types: [com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView$loadingMessageRunnable$1] */
    public PureShowWidgetInlineView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.handler = new Handler(Looper.getMainLooper());
        int dimensionPixelSize = getResources().getDimensionPixelSize(C0637R.dimen.trae_pure_show_widget_bootstrap_height);
        this.bootstrapHeightPx = dimensionPixelSize;
        this.tapSlopPx = ViewConfiguration.get(context).getScaledTouchSlop();
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageResource(C0637R.drawable.status_loading_anim);
        this.loadingIconView = imageView;
        TextView textView = new TextView(context);
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
        textView.setTextSize(0, textView.getResources().getDimension(C0591R.dimen.trae_body_md_font_size_sp));
        TextViewCompat.setLineHeight(textView, textView.getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_24));
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setText(context.getString(C0637R.string.trae_artifact_loading));
        this.loadingTextView = textView;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(linearLayout.getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_20), linearLayout.getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_20)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMarginStart(linearLayout.getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_4));
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(textView, layoutParams);
        this.loadingContainer = linearLayout;
        AppCompatImageButton appCompatImageButton = new AppCompatImageButton(context);
        appCompatImageButton.setImageResource(C0637R.drawable.trae_ic_brainstorm_maximize);
        appCompatImageButton.setBackgroundResource(C0637R.drawable.trae_bg_brainstorm_expand_button_ripple);
        appCompatImageButton.setContentDescription(context.getString(C0637R.string.trae_chat_artifact_preview_web));
        appCompatImageButton.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int dimensionPixelSize2 = appCompatImageButton.getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_4);
        appCompatImageButton.setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
        appCompatImageButton.setVisibility(8);
        appCompatImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PureShowWidgetInlineView.this.openFullscreenPreview();
            }
        });
        this.fullscreenButton = appCompatImageButton;
        this.presentationState = new PureShowWidgetPresentationState();
        this.currentHeightPx = dimensionPixelSize;
        this.currentLoadingMessages = CollectionsKt.emptyList();
        this.heightCheckRunnable = new Runnable() { // from class: com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                PureShowWidgetInlineView.heightCheckRunnable$lambda$6(PureShowWidgetInlineView.this);
            }
        };
        this.loadingMessageRunnable = new Runnable() { // from class: com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView$loadingMessageRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                LinearLayout linearLayout2;
                List list;
                int i;
                List list2;
                Handler handler;
                if (PureShowWidgetInlineView.this.isAttachedToWindow()) {
                    linearLayout2 = PureShowWidgetInlineView.this.loadingContainer;
                    if (linearLayout2.getVisibility() == 0) {
                        list = PureShowWidgetInlineView.this.currentLoadingMessages;
                        if (list.size() > 1) {
                            PureShowWidgetInlineView pureShowWidgetInlineView = PureShowWidgetInlineView.this;
                            i = pureShowWidgetInlineView.loadingMessageIndex;
                            list2 = PureShowWidgetInlineView.this.currentLoadingMessages;
                            pureShowWidgetInlineView.loadingMessageIndex = (i + 1) % list2.size();
                            PureShowWidgetInlineView.this.updateLoadingMessage();
                            handler = PureShowWidgetInlineView.this.handler;
                            handler.postDelayed(this, 3000L);
                            return;
                        }
                    }
                }
                PureShowWidgetInlineView.this.loadingMessageRotationActive = false;
            }
        };
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PureShowWidgetInlineView.this.openFullscreenPreview();
            }
        });
        attachNewWebView();
        addView(linearLayout, new FrameLayout.LayoutParams(-1, -2, 8388659));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_32), getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_32), 8388661);
        layoutParams2.topMargin = getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_8);
        layoutParams2.setMarginEnd(getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_8));
        Unit unit2 = Unit.INSTANCE;
        addView((View) appCompatImageButton, layoutParams2);
        showLoading$default(this, null, 1, null);
    }

    private final WebView createWebView(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        WebView webView = new WebView(context);
        TraeLogUtil.INSTANCE.d(TAG, "[InlineView] WebView(context) costMs=" + (SystemClock.elapsedRealtime() - elapsedRealtime));
        webView.setBackgroundColor(0);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setOverScrollMode(2);
        setupSettings(webView);
        webView.setWebViewClient(new WebViewClient() { // from class: com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView$createWebView$1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return true;
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return true;
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                boolean z;
                WebView webView2;
                z = PureShowWidgetInlineView.this.released;
                if (z) {
                    return;
                }
                webView2 = PureShowWidgetInlineView.this.webView;
                if (view != webView2) {
                    return;
                }
                if (!PureShowWidgetInlineView.this.isAttachedToWindow()) {
                    PureShowWidgetInlineView.this.pendingHeightChecksAfterAttach = true;
                } else {
                    PureShowWidgetInlineView.this.scheduleHeightChecks();
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(detail, "detail");
                PureShowWidgetInlineView.this.handleRenderProcessGone(view, detail.didCrash());
                return true;
            }
        });
        return webView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void heightCheckRunnable$lambda$6(PureShowWidgetInlineView pureShowWidgetInlineView) {
        int i = pureShowWidgetInlineView.pendingHeightCheckCount;
        if (i > 0) {
            pureShowWidgetInlineView.pendingHeightCheckCount = i - 1;
        }
        pureShowWidgetInlineView.updateHeightFromContent();
    }

    public final void bind(PureShowWidgetPayload payload, boolean groupFinished) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (this.released) {
            return;
        }
        String widgetCode = payload.getWidgetCode();
        PureShowWidgetPresentationDecision resolve = this.presentationState.resolve(payload.getWidgetId(), groupFinished, !StringsKt.isBlank(widgetCode));
        if (resolve.getWidgetChanged()) {
            this.renderProcessFailed = false;
            if (this.webView == null) {
                attachNewWebView();
            }
            this.lastWidgetCode = null;
            this.fullscreenPayload = null;
            this.hasLoggedFinishedRegression = false;
            resetWebViewHeight$default(this, 0, 1, null);
        }
        int i = WhenMappings.$EnumSwitchMapping$0[resolve.getMode().ordinal()];
        if (i == 1) {
            this.fullscreenPayload = null;
            setClickable(false);
            showLoading(payload.getLoadingMessages());
            return;
        }
        if (i == 2) {
            this.fullscreenPayload = payload;
            setClickable(true);
            if (this.renderProcessFailed) {
                showRenderProcessFailure();
                return;
            }
            showWebView();
            if (Intrinsics.areEqual(widgetCode, this.lastWidgetCode)) {
                return;
            }
            loadWidgetCode(payload, widgetCode);
            return;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        if (!this.hasLoggedFinishedRegression) {
            TraeLogUtil.INSTANCE.w(TAG, "[InlineView] keep completed content after groupFinished regression, widgetId=" + payload.getWidgetId());
            this.hasLoggedFinishedRegression = true;
        }
        setClickable(this.fullscreenPayload != null);
        if (this.renderProcessFailed) {
            showRenderProcessFailure();
        } else {
            showWebView();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.released) {
            return;
        }
        notifyInlineViewCreated();
        if (this.loadingContainer.getVisibility() == 0) {
            startLoadingAnimation();
            startLoadingMessageRotation();
        }
        WebView webView = this.webView;
        if (!(webView != null && webView.getVisibility() == 0) || this.lastWidgetCode == null) {
            return;
        }
        if (this.pendingHeightChecksAfterAttach || this.pendingHeightCheckCount > 0 || !this.heightMeasuredForCurrentLoad) {
            this.pendingHeightChecksAfterAttach = false;
            scheduleHeightChecks();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.handler.removeCallbacks(this.heightCheckRunnable);
        stopLoadingAnimation();
        stopLoadingMessageRotation();
        super.onDetachedFromWindow();
    }

    public final void release() {
        if (this.released) {
            return;
        }
        this.released = true;
        this.handler.removeCallbacksAndMessages(null);
        this.pendingHeightCheckCount = 0;
        this.pendingHeightChecksAfterAttach = false;
        this.heightMeasuredForCurrentLoad = false;
        stopLoadingAnimation();
        stopLoadingMessageRotation();
        this.fullscreenPayload = null;
        this.lastWidgetCode = null;
        this.renderProcessFailed = false;
        this.presentationState.reset();
        this.hasLoggedFinishedRegression = false;
        this.currentLoadingMessages = CollectionsKt.emptyList();
        setOnClickListener(null);
        this.fullscreenButton.setOnClickListener((View.OnClickListener) null);
        WebView webView = this.webView;
        this.webView = null;
        if (webView != null) {
            destroyWebView$default(this, webView, false, 2, null);
        }
    }

    private final WebView attachNewWebView() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        WebView createWebView = createWebView(context);
        createWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean attachNewWebView$lambda$9;
                attachNewWebView$lambda$9 = PureShowWidgetInlineView.attachNewWebView$lambda$9(PureShowWidgetInlineView.this, view, motionEvent);
                return attachNewWebView$lambda$9;
            }
        });
        this.webView = createWebView;
        addView(createWebView, 0, new FrameLayout.LayoutParams(-1, this.currentHeightPx));
        return createWebView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean attachNewWebView$lambda$9(PureShowWidgetInlineView pureShowWidgetInlineView, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNull(motionEvent);
        return pureShowWidgetInlineView.handleWebViewTouch(motionEvent);
    }

    static /* synthetic */ void destroyWebView$default(PureShowWidgetInlineView pureShowWidgetInlineView, WebView webView, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        pureShowWidgetInlineView.destroyWebView(webView, z);
    }

    private final void destroyWebView(WebView view, boolean rendererGone) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        if (!rendererGone) {
            view.setOnTouchListener(null);
            view.stopLoading();
            view.removeAllViews();
        }
        view.destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleRenderProcessGone(WebView view, boolean didCrash) {
        TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
        StringBuilder append = new StringBuilder("[InlineView] WebView render process gone, didCrash=").append(didCrash).append(", widgetId=");
        PureShowWidgetPayload pureShowWidgetPayload = this.fullscreenPayload;
        traeLogUtil.e(TAG, append.append(pureShowWidgetPayload != null ? pureShowWidgetPayload.getWidgetId() : null).toString());
        if (view == this.webView) {
            this.webView = null;
            this.renderProcessFailed = this.lastWidgetCode != null;
            this.lastWidgetCode = null;
            this.handler.removeCallbacks(this.heightCheckRunnable);
            this.pendingHeightCheckCount = 0;
            this.pendingHeightChecksAfterAttach = false;
            this.heightMeasuredForCurrentLoad = false;
        }
        destroyWebView(view, true);
        if (this.released || !this.renderProcessFailed) {
            return;
        }
        showRenderProcessFailure();
    }

    private final void notifyInlineViewCreated() {
        PureShowWidgetInlineView pureShowWidgetInlineView = this;
        while (pureShowWidgetInlineView != null) {
            Object tag = pureShowWidgetInlineView.getTag(C0637R.id.tag_on_pure_show_widget_inline_view_created);
            if (TypeIntrinsics.isFunctionOfArity(tag, 1)) {
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Function1<com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView, kotlin.Unit>");
                ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(tag, 1)).invoke(this);
                return;
            } else {
                Object parent = pureShowWidgetInlineView.getParent();
                pureShowWidgetInlineView = parent instanceof View ? (View) parent : null;
            }
        }
    }

    private final void setupSettings(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(false);
        settings.setMixedContentMode(1);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setMediaPlaybackRequiresUserGesture(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void showLoading$default(PureShowWidgetInlineView pureShowWidgetInlineView, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        pureShowWidgetInlineView.showLoading(list);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void showLoading(List<String> messages) {
        boolean z;
        boolean z2;
        WebView webView;
        if (this.loadingContainer.getVisibility() == 0) {
            WebView webView2 = this.webView;
            if ((webView2 != null ? webView2.getVisibility() : 8) == 8 && this.fullscreenButton.getVisibility() == 8) {
                z = false;
                ArrayList arrayList = new ArrayList();
                for (Object obj : messages) {
                    if (!StringsKt.isBlank((String) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = arrayList;
                z2 = !Intrinsics.areEqual(arrayList2, this.currentLoadingMessages);
                if (!z2) {
                    this.currentLoadingMessages = arrayList2;
                    this.loadingMessageIndex = 0;
                } else if ((true ^ this.currentLoadingMessages.isEmpty()) && this.loadingMessageIndex >= this.currentLoadingMessages.size()) {
                    this.loadingMessageIndex %= this.currentLoadingMessages.size();
                }
                updateLoadingMessage();
                this.loadingIconView.setVisibility(0);
                this.loadingContainer.setVisibility(0);
                webView = this.webView;
                if (webView != null) {
                    webView.setVisibility(8);
                }
                this.fullscreenButton.setVisibility(8);
                if (!z2 || !this.loadingMessageRotationActive) {
                    startLoadingMessageRotation();
                }
                startLoadingAnimation();
                if (z) {
                    return;
                }
                notifyContentChanged();
                return;
            }
        }
        z = true;
        ArrayList arrayList3 = new ArrayList();
        while (r8.hasNext()) {
        }
        ArrayList arrayList22 = arrayList3;
        z2 = !Intrinsics.areEqual(arrayList22, this.currentLoadingMessages);
        if (!z2) {
        }
        updateLoadingMessage();
        this.loadingIconView.setVisibility(0);
        this.loadingContainer.setVisibility(0);
        webView = this.webView;
        if (webView != null) {
        }
        this.fullscreenButton.setVisibility(8);
        if (!z2) {
        }
        startLoadingMessageRotation();
        startLoadingAnimation();
        if (z) {
        }
    }

    private final void showWebView() {
        WebView webView = this.webView;
        if (webView == null) {
            webView = attachNewWebView();
        }
        int i = this.fullscreenPayload != null ? 0 : 8;
        boolean z = (this.loadingContainer.getVisibility() == 8 && webView.getVisibility() == 0 && this.fullscreenButton.getVisibility() == i) ? false : true;
        this.loadingContainer.setVisibility(8);
        stopLoadingAnimation();
        stopLoadingMessageRotation();
        webView.setVisibility(0);
        this.fullscreenButton.setVisibility(i);
        if (z) {
            notifyContentChanged();
        }
    }

    private final void showRenderProcessFailure() {
        int i = this.fullscreenPayload != null ? 0 : 8;
        boolean z = (this.loadingContainer.getVisibility() == 0 && this.webView == null && this.fullscreenButton.getVisibility() == i) ? false : true;
        stopLoadingAnimation();
        stopLoadingMessageRotation();
        this.currentLoadingMessages = CollectionsKt.emptyList();
        this.loadingMessageIndex = 0;
        this.loadingIconView.setVisibility(8);
        this.loadingTextView.setText(C0637R.string.trae_chat_artifact_preview_failed);
        this.loadingContainer.setVisibility(0);
        this.fullscreenButton.setVisibility(i);
        if (z) {
            notifyContentChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLoadingMessage() {
        String str;
        TextView textView = this.loadingTextView;
        String str2 = (String) CollectionsKt.getOrNull(this.currentLoadingMessages, this.loadingMessageIndex);
        if (str2 != null) {
            str = str2;
        } else {
            String string = getContext().getString(C0637R.string.trae_artifact_loading);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            str = string;
        }
        textView.setText(str);
    }

    private final void startLoadingAnimation() {
        if (isAttachedToWindow() && this.loadingContainer.getVisibility() == 0) {
            Drawable drawable = this.loadingIconView.getDrawable();
            AnimationDrawable animationDrawable = drawable instanceof AnimationDrawable ? (AnimationDrawable) drawable : null;
            if (animationDrawable == null || animationDrawable.isRunning()) {
                return;
            }
            animationDrawable.start();
        }
    }

    private final void stopLoadingAnimation() {
        Drawable drawable = this.loadingIconView.getDrawable();
        AnimationDrawable animationDrawable = drawable instanceof AnimationDrawable ? (AnimationDrawable) drawable : null;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    private final void startLoadingMessageRotation() {
        this.handler.removeCallbacks(this.loadingMessageRunnable);
        this.loadingMessageRotationActive = false;
        if (isAttachedToWindow() && this.loadingContainer.getVisibility() == 0 && this.currentLoadingMessages.size() > 1) {
            this.loadingMessageRotationActive = true;
            this.handler.postDelayed(this.loadingMessageRunnable, 3000L);
        }
    }

    private final void stopLoadingMessageRotation() {
        this.handler.removeCallbacks(this.loadingMessageRunnable);
        this.loadingMessageRotationActive = false;
    }

    private final void loadWidgetCode(PureShowWidgetPayload payload, String widgetCode) {
        WebView webView = this.webView;
        if (webView == null) {
            return;
        }
        this.lastWidgetCode = widgetCode;
        this.handler.removeCallbacks(this.heightCheckRunnable);
        this.pendingHeightCheckCount = 0;
        this.pendingHeightChecksAfterAttach = false;
        this.heightMeasuredForCurrentLoad = false;
        Companion companion = Companion;
        String buildHeightCacheKey = companion.buildHeightCacheKey(payload, widgetCode);
        this.currentHeightCacheKey = buildHeightCacheKey;
        Integer cachedHeight = companion.getCachedHeight(buildHeightCacheKey);
        resetWebViewHeight(cachedHeight != null ? cachedHeight.intValue() : this.bootstrapHeightPx);
        webView.loadDataWithBaseURL(PureShowWidgetHtml.WIDGET_BASE_URL, PureShowWidgetHtml.INSTANCE.build(widgetCode, false), PureShowWidgetHtml.MIME_TYPE, "UTF-8", null);
    }

    private final boolean handleWebViewTouch(MotionEvent event) {
        if (this.fullscreenPayload == null) {
            return false;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.touchDownX = event.getX();
            this.touchDownY = event.getY();
        } else if (actionMasked == 1) {
            float abs = Math.abs(event.getX() - this.touchDownX);
            float abs2 = Math.abs(event.getY() - this.touchDownY);
            int i = this.tapSlopPx;
            if (abs <= i && abs2 <= i) {
                performClick();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openFullscreenPreview() {
        PureShowWidgetPayload pureShowWidgetPayload = this.fullscreenPayload;
        if (pureShowWidgetPayload == null) {
            return;
        }
        PureShowWidgetFullscreenActivity.Companion companion = PureShowWidgetFullscreenActivity.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        companion.start$conversation_mainlandRelease(context, pureShowWidgetPayload);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleHeightChecks() {
        if (this.released) {
            return;
        }
        this.handler.removeCallbacks(this.heightCheckRunnable);
        long[] jArr = HEIGHT_CHECK_DELAYS_MS;
        this.pendingHeightCheckCount = jArr.length;
        for (long j : jArr) {
            this.handler.postDelayed(this.heightCheckRunnable, j);
        }
    }

    private final void updateHeightFromContent() {
        final WebView webView;
        if (!this.released && (webView = this.webView) != null && isAttachedToWindow() && webView.getVisibility() == 0) {
            final String str = this.currentHeightCacheKey;
            webView.evaluateJavascript(HEIGHT_SCRIPT, new ValueCallback() { // from class: com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView$$ExternalSyntheticLambda0
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    PureShowWidgetInlineView.updateHeightFromContent$lambda$16(PureShowWidgetInlineView.this, webView, str, (String) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateHeightFromContent$lambda$16(PureShowWidgetInlineView pureShowWidgetInlineView, WebView webView, String str, String str2) {
        HeightMeasurement parseHeightMeasurement;
        float f;
        if (pureShowWidgetInlineView.released || pureShowWidgetInlineView.webView != webView || !pureShowWidgetInlineView.isAttachedToWindow() || webView.getVisibility() != 0 || !Intrinsics.areEqual(pureShowWidgetInlineView.currentHeightCacheKey, str) || (parseHeightMeasurement = pureShowWidgetInlineView.parseHeightMeasurement(str2)) == null || parseHeightMeasurement.getHeightCss() <= 0.0f || webView.getWidth() <= 0) {
            return;
        }
        Float valueOf = Float.valueOf(parseHeightMeasurement.getViewportWidthCss());
        if (!(valueOf.floatValue() > 0.0f)) {
            valueOf = null;
        }
        if (valueOf != null) {
            f = webView.getWidth() / valueOf.floatValue();
        } else {
            f = pureShowWidgetInlineView.getResources().getDisplayMetrics().density;
        }
        int max = Math.max(1, (int) Math.ceil(parseHeightMeasurement.getHeightCss() * f));
        pureShowWidgetInlineView.heightMeasuredForCurrentLoad = true;
        Companion.putCachedHeight(str, max);
        if (Math.abs(max - pureShowWidgetInlineView.currentHeightPx) > 1) {
            pureShowWidgetInlineView.currentHeightPx = max;
            ViewGroup.LayoutParams layoutParams = webView.getLayoutParams();
            layoutParams.height = pureShowWidgetInlineView.currentHeightPx;
            webView.setLayoutParams(layoutParams);
            webView.requestLayout();
            pureShowWidgetInlineView.requestLayout();
            pureShowWidgetInlineView.notifyContentChanged();
        }
    }

    static /* synthetic */ void resetWebViewHeight$default(PureShowWidgetInlineView pureShowWidgetInlineView, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = pureShowWidgetInlineView.bootstrapHeightPx;
        }
        pureShowWidgetInlineView.resetWebViewHeight(i);
    }

    private final void resetWebViewHeight(int targetHeightPx) {
        if (Math.abs(targetHeightPx - this.currentHeightPx) <= 1) {
            return;
        }
        this.currentHeightPx = targetHeightPx;
        WebView webView = this.webView;
        if (webView != null) {
            ViewGroup.LayoutParams layoutParams = webView.getLayoutParams();
            layoutParams.height = targetHeightPx;
            webView.setLayoutParams(layoutParams);
            webView.requestLayout();
        }
        requestLayout();
        notifyContentChanged();
    }

    private final void notifyContentChanged() {
        PureShowWidgetInlineView pureShowWidgetInlineView = this;
        while (pureShowWidgetInlineView != null) {
            Object tag = pureShowWidgetInlineView.getTag(C0637R.id.tag_on_content_changed);
            if (TypeIntrinsics.isFunctionOfArity(tag, 0)) {
                ((Function0) tag).invoke();
                return;
            } else {
                Object parent = pureShowWidgetInlineView.getParent();
                pureShowWidgetInlineView = parent instanceof View ? (View) parent : null;
            }
        }
    }

    private final HeightMeasurement parseHeightMeasurement(String value) {
        String obj;
        String trim;
        Float floatOrNull;
        Float floatOrNull2;
        if (value != null && (obj = StringsKt.trim(value).toString()) != null && (trim = StringsKt.trim(obj, new char[]{'\"'})) != null) {
            List split$default = StringsKt.split$default(trim, new String[]{IWeiboService.Scope.EMPTY_SCOPE}, false, 0, 6, (Object) null);
            String str = (String) CollectionsKt.getOrNull(split$default, 0);
            if (str != null && (floatOrNull = StringsKt.toFloatOrNull(str)) != null) {
                float floatValue = floatOrNull.floatValue();
                String str2 = (String) CollectionsKt.getOrNull(split$default, 1);
                return new HeightMeasurement(floatValue, (str2 == null || (floatOrNull2 = StringsKt.toFloatOrNull(str2)) == null) ? 0.0f : floatOrNull2.floatValue());
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PureShowWidgetInlineView.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fJ\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001e\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$Companion;", "", "<init>", "()V", "LOADING_MESSAGE_INTERVAL_MS", "", "HEIGHT_CHECK_DELAYS_MS", "", "getHEIGHT_CHECK_DELAYS_MS", "()[J", "MIN_RENDERED_HEIGHT_PX", "", "HEIGHT_CHANGE_THRESHOLD_PX", "HEIGHT_CACHE_MAX_SIZE", "TAG", "", "HEIGHT_SCRIPT", "HEIGHT_CACHE", "Ljava/util/LinkedHashMap;", "getHEIGHT_CACHE", "()Ljava/util/LinkedHashMap;", "buildHeightCacheKey", "payload", "Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;", "widgetCode", "getCachedHeight", "cacheKey", "(Ljava/lang/String;)Ljava/lang/Integer;", "putCachedHeight", "", "heightPx", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long[] getHEIGHT_CHECK_DELAYS_MS() {
            return PureShowWidgetInlineView.HEIGHT_CHECK_DELAYS_MS;
        }

        public final LinkedHashMap<String, Integer> getHEIGHT_CACHE() {
            return PureShowWidgetInlineView.HEIGHT_CACHE;
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x001e, code lost:
        
            if (r3 == null) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String buildHeightCacheKey(PureShowWidgetPayload payload, String widgetCode) {
            Intrinsics.checkNotNullParameter(payload, "payload");
            Intrinsics.checkNotNullParameter(widgetCode, "widgetCode");
            String widgetId = payload.getWidgetId();
            if (widgetId != null) {
                if (!(!StringsKt.isBlank(widgetId))) {
                    widgetId = null;
                }
            }
            widgetId = "widget";
            return widgetId + ':' + widgetCode.length() + ':' + widgetCode.hashCode();
        }

        public final Integer getCachedHeight(String cacheKey) {
            if (cacheKey == null) {
                return null;
            }
            return getHEIGHT_CACHE().get(cacheKey);
        }

        public final void putCachedHeight(String cacheKey, int heightPx) {
            if (cacheKey == null || heightPx <= 1) {
                return;
            }
            getHEIGHT_CACHE().put(cacheKey, Integer.valueOf(heightPx));
        }
    }
}
