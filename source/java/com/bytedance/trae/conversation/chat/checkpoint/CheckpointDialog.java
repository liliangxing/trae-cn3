package com.bytedance.trae.conversation.chat.checkpoint;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.ParsedPlanItem;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CheckpointDialog.kt */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 v2\u00020\u0001:\u0001vB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010C\u001a\u0002082\u0006\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u001a\u0010J\u001a\u00020\u00152\u0006\u0010K\u001a\u0002082\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u0010\u0010L\u001a\u00020\u00152\u0006\u0010K\u001a\u000208H\u0002J\u0010\u0010M\u001a\u00020\u00152\u0006\u0010K\u001a\u000208H\u0002J\b\u0010N\u001a\u00020\u0015H\u0002J\b\u0010O\u001a\u00020\u0015H\u0002J\b\u0010P\u001a\u00020\u0015H\u0002J\b\u0010Q\u001a\u00020\u0015H\u0002J\b\u0010R\u001a\u00020\u0015H\u0002J\b\u0010S\u001a\u00020\u0015H\u0002J\b\u0010T\u001a\u00020\u0015H\u0002J\b\u0010U\u001a\u00020\u0015H\u0002J\u0010\u0010V\u001a\u00020\u00152\u0006\u0010W\u001a\u00020\u000eH\u0002J\"\u0010X\u001a\u00020\u00152\b\u0010Y\u001a\u0004\u0018\u00010\u00072\u0006\u0010Z\u001a\u00020[2\u0006\u0010W\u001a\u00020\u000eH\u0002J\u0010\u0010\\\u001a\u00020\u00152\u0006\u0010]\u001a\u00020[H\u0002J\u0010\u0010^\u001a\u00020\u00152\u0006\u0010_\u001a\u00020\u0007H\u0002J\u0010\u0010`\u001a\u00020[2\u0006\u0010_\u001a\u00020\u0007H\u0002J\b\u0010a\u001a\u00020\u0015H\u0002J\u0010\u0010b\u001a\u00020\u000e2\u0006\u0010c\u001a\u00020$H\u0002J\b\u0010d\u001a\u00020\u000eH\u0002J\u0018\u0010e\u001a\u00020\u00152\u0006\u0010K\u001a\u0002082\u0006\u0010f\u001a\u00020\u000eH\u0002J\f\u0010g\u001a\u00020\u000e*\u00020\u000eH\u0002J\"\u0010h\u001a\u00020\u00152\u0006\u0010i\u001a\u00020\f2\b\u0010j\u001a\u0004\u0018\u00010k2\u0006\u0010Z\u001a\u00020[H\u0002J\b\u0010l\u001a\u00020\u0015H\u0002J,\u0010m\u001a\u00020\u00152\u0006\u0010i\u001a\u00020\f2\b\u0010n\u001a\u0004\u0018\u00010\u00072\b\u0010j\u001a\u0004\u0018\u00010k2\u0006\u0010Z\u001a\u00020[H\u0002J\u0012\u0010o\u001a\u00020\u00152\b\u0010p\u001a\u0004\u0018\u00010:H\u0002J\b\u0010q\u001a\u00020\u0015H\u0002J\u0010\u0010r\u001a\u00020\u00152\u0006\u0010i\u001a\u00020\fH\u0002J\u0010\u0010s\u001a\u00020\u00152\u0006\u0010i\u001a\u00020\fH\u0002J\b\u0010t\u001a\u00020\u0015H\u0002J\b\u0010u\u001a\u00020\u0015H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006w"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "planItem", "Lcom/bytedance/trae/im/model/ParsedPlanItem;", "taskId", "", "conversationId", "questionsJson", "pages", "", "Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;", "currentPageIndex", "", "callback", "Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;", "confirmInfo", "Lcom/bytedance/trae/im/model/ConfirmInfo;", "onDismissAction", "Lkotlin/Function0;", "", "onFileClick", "Lkotlin/Function1;", "resolvedPluginDisplayName", "getResolvedPluginDisplayName", "()Ljava/lang/String;", "setResolvedPluginDisplayName", "(Ljava/lang/String;)V", "pageResults", "", "Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPageResult;", "normalContent", "Landroid/widget/LinearLayout;", "headerNavGroup", "tvProgress", "Landroid/widget/TextView;", "tvQuestion", "tvScrollView", "Landroidx/core/widget/NestedScrollView;", "rvOptions", "Landroidx/recyclerview/widget/RecyclerView;", "btnHeaderPrev", "Landroid/widget/FrameLayout;", "btnHeaderNext", "ivHeaderPrev", "Landroid/widget/ImageView;", "ivHeaderNext", "btnClose", "btnCancel", "btnPrev", "btnNext", "actionGroup", "optionAdapter", "Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;", "inputContainer", "Landroid/view/View;", "etCustomAnswer", "Landroid/widget/EditText;", "btnCustomSend", "customCheckContainer", "ivCustomEdit", "ivCustomCheck", "ivCustomSend", "contentView", "questionLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "hideKeyboard", "bindViews", "applyCloseButtonShadow", "applyFigmaTextMetrics", "setupQuestionScrolling", "dismiss", "handleBackPress", "setupListeners", "navigateToPreviousPage", "advanceToNextPageOrSubmit", "renderPage", "index", "updateHeader", "headerLabel", "isAskUserQuestion", "", "updateTitleTopMargin", "showHeader", "setQuestionText", "text", "applyQuestionViewportIfReady", "applyQuestionCollapsedViewport", "measureNaturalLineCount", "textView", "questionCollapsedHeightPx", "setViewHeight", "height", "dp", "updateActionArea", "page", "creator", "Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;", "removeContentView", "addCustomInputView", "restoredText", "showKeyboard", "editText", "submitCustomInput", "updateCustomInputState", "clearSingleSelectionForCustomInputIfNeeded", "removeCustomInputView", "saveCurrentPageResult", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CheckpointDialog extends Fragment {
    private static final String CHECK_POINT_TAG = "CheckPointDialog";
    private static final float CLOSE_BUTTON_LEGACY_SHADOW_ELEVATION_DP = 2.0f;
    private static final int CLOSE_BUTTON_SHADOW_ALPHA = 13;
    private static final float CLOSE_BUTTON_SHADOW_ELEVATION_DP = 5.0f;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int INPUT_MAX_LENGTH = 500;
    private static final String OTHER_OPTION_ID = "__other__";
    private static final int QUESTION_COLLAPSED_FULL_LINES = 5;
    private static final int QUESTION_COLLAPSED_TEXT_LENGTH_THRESHOLD = 120;
    private static final int QUESTION_LINE_HEIGHT_DP = 24;
    private static final float QUESTION_PARTIAL_VISIBLE_LINE_RATIO = 0.75f;
    private static final long SINGLE_SELECT_FEEDBACK_MS = 250;
    public static final String TAG = "CheckpointDialog";
    private LinearLayout actionGroup;
    private TextView btnCancel;
    private FrameLayout btnClose;
    private FrameLayout btnCustomSend;
    private FrameLayout btnHeaderNext;
    private FrameLayout btnHeaderPrev;
    private TextView btnNext;
    private TextView btnPrev;
    private CheckpointInteractionCallback callback;
    private ConfirmInfo confirmInfo;
    private View contentView;
    private String conversationId;
    private int currentPageIndex;
    private FrameLayout customCheckContainer;
    private EditText etCustomAnswer;
    private LinearLayout headerNavGroup;
    private View inputContainer;
    private ImageView ivCustomCheck;
    private ImageView ivCustomEdit;
    private ImageView ivCustomSend;
    private ImageView ivHeaderNext;
    private ImageView ivHeaderPrev;
    private LinearLayout normalContent;
    private Function0<Unit> onDismissAction;
    private Function1<? super String, Unit> onFileClick;
    private CheckpointOptionAdapter optionAdapter;
    private ParsedPlanItem planItem;
    private View.OnLayoutChangeListener questionLayoutListener;
    private String resolvedPluginDisplayName;
    private RecyclerView rvOptions;
    private TextView tvProgress;
    private TextView tvQuestion;
    private NestedScrollView tvScrollView;
    private String taskId = "";
    private String questionsJson = "[]";
    private List<CheckpointPage> pages = CollectionsKt.emptyList();
    private final List<CheckpointPageResult> pageResults = new ArrayList();

    public final String getResolvedPluginDisplayName() {
        return this.resolvedPluginDisplayName;
    }

    public final void setResolvedPluginDisplayName(String str) {
        this.resolvedPluginDisplayName = str;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(C0637R.layout.trae_dialog_human_checkpoint, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        ParsedToolCallInfo toolCallInfo;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FLogger fLogger = FLogger.INSTANCE;
        StringBuilder append = new StringBuilder("[Dialog] onViewCreated: pages=").append(this.pages.size()).append(", taskId=").append(this.taskId).append(", toolName=");
        ParsedPlanItem parsedPlanItem = this.planItem;
        fLogger.i(CHECK_POINT_TAG, append.append((parsedPlanItem == null || (toolCallInfo = parsedPlanItem.getToolCallInfo()) == null) ? null : toolCallInfo.getName()).toString());
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 != null) {
            view2.setBackgroundColor(0);
        }
        bindViews(view);
        setupListeners();
        if (!this.pages.isEmpty()) {
            renderPage(this.currentPageIndex);
        }
        hideKeyboard(view);
    }

    private final void hideKeyboard(View view) {
        IBinder windowToken;
        View currentFocus;
        Object systemService = view.getContext().getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        FragmentActivity activity = getActivity();
        if (activity == null || (currentFocus = activity.getCurrentFocus()) == null || (windowToken = currentFocus.getWindowToken()) == null) {
            windowToken = view.getWindowToken();
        }
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        }
    }

    private final void bindViews(View view) {
        View findViewById = view.findViewById(C0637R.id.normal_content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.normalContent = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(C0637R.id.header_nav_group);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.headerNavGroup = (LinearLayout) findViewById2;
        View findViewById3 = view.findViewById(C0637R.id.tv_progress);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.tvProgress = (TextView) findViewById3;
        View findViewById4 = view.findViewById(C0637R.id.tv_question);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.tvQuestion = (TextView) findViewById4;
        NestedScrollView findViewById5 = view.findViewById(C0637R.id.title_scroll_view);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.tvScrollView = findViewById5;
        RecyclerView findViewById6 = view.findViewById(C0637R.id.rv_options);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.rvOptions = findViewById6;
        View findViewById7 = view.findViewById(C0637R.id.btn_header_prev);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.btnHeaderPrev = (FrameLayout) findViewById7;
        View findViewById8 = view.findViewById(C0637R.id.btn_header_next);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        this.btnHeaderNext = (FrameLayout) findViewById8;
        View findViewById9 = view.findViewById(C0637R.id.iv_header_prev);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
        this.ivHeaderPrev = (ImageView) findViewById9;
        View findViewById10 = view.findViewById(C0637R.id.iv_header_next);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(...)");
        this.ivHeaderNext = (ImageView) findViewById10;
        View findViewById11 = view.findViewById(C0637R.id.btn_close);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(...)");
        this.btnClose = (FrameLayout) findViewById11;
        View findViewById12 = view.findViewById(C0637R.id.btn_cancel);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(...)");
        this.btnCancel = (TextView) findViewById12;
        View findViewById13 = view.findViewById(C0637R.id.btn_prev);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(...)");
        this.btnPrev = (TextView) findViewById13;
        View findViewById14 = view.findViewById(C0637R.id.btn_next);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(...)");
        this.btnNext = (TextView) findViewById14;
        View findViewById15 = view.findViewById(C0637R.id.action_group);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(...)");
        this.actionGroup = (LinearLayout) findViewById15;
        RecyclerView recyclerView = this.rvOptions;
        LinearLayout linearLayout = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvOptions");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        LinearLayout linearLayout2 = this.normalContent;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("normalContent");
            linearLayout2 = null;
        }
        linearLayout2.setClipChildren(false);
        LinearLayout linearLayout3 = this.normalContent;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("normalContent");
        } else {
            linearLayout = linearLayout3;
        }
        linearLayout.setClipToPadding(false);
        applyCloseButtonShadow();
        applyFigmaTextMetrics();
        setupQuestionScrolling();
    }

    private final void applyCloseButtonShadow() {
        float f = Build.VERSION.SDK_INT >= 28 ? CLOSE_BUTTON_SHADOW_ELEVATION_DP : CLOSE_BUTTON_LEGACY_SHADOW_ELEVATION_DP;
        FrameLayout frameLayout = this.btnClose;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnClose");
            frameLayout = null;
        }
        frameLayout.setElevation(f * getResources().getDisplayMetrics().density);
        FrameLayout frameLayout3 = this.btnClose;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnClose");
            frameLayout3 = null;
        }
        frameLayout3.setTranslationZ(0.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            int argb = Color.argb(13, 0, 0, 0);
            FrameLayout frameLayout4 = this.btnClose;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnClose");
                frameLayout4 = null;
            }
            frameLayout4.setOutlineAmbientShadowColor(argb);
            FrameLayout frameLayout5 = this.btnClose;
            if (frameLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnClose");
            } else {
                frameLayout2 = frameLayout5;
            }
            frameLayout2.setOutlineSpotShadowColor(argb);
        }
    }

    private final void applyFigmaTextMetrics() {
        float f = getResources().getDisplayMetrics().density;
        TextView textView = this.tvQuestion;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
            textView = null;
        }
        textView.setTypeface(CheckpointTypefaces.INSTANCE.defaultMedium());
        TextView textView3 = this.tvQuestion;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
            textView3 = null;
        }
        TextViewCompat.setLineHeight(textView3, (int) (24 * f));
        TextView textView4 = this.tvProgress;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvProgress");
            textView4 = null;
        }
        int i = (int) (20 * f);
        TextViewCompat.setLineHeight(textView4, i);
        TextView[] textViewArr = new TextView[3];
        TextView textView5 = this.btnCancel;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
            textView5 = null;
        }
        textViewArr[0] = textView5;
        TextView textView6 = this.btnPrev;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnPrev");
            textView6 = null;
        }
        textViewArr[1] = textView6;
        TextView textView7 = this.btnNext;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnNext");
        } else {
            textView2 = textView7;
        }
        textViewArr[2] = textView2;
        for (TextView textView8 : CollectionsKt.listOf(textViewArr)) {
            textView8.setTypeface(CheckpointTypefaces.INSTANCE.defaultMedium());
            TextViewCompat.setLineHeight(textView8, i);
        }
    }

    private final void setupQuestionScrolling() {
        TextView textView = this.tvQuestion;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
            textView = null;
        }
        textView.setMovementMethod(null);
        TextView textView3 = this.tvQuestion;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
            textView3 = null;
        }
        textView3.setVerticalScrollBarEnabled(false);
        TextView textView4 = this.tvQuestion;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
            textView4 = null;
        }
        textView4.setVerticalFadingEdgeEnabled(false);
        TextView textView5 = this.tvQuestion;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
            textView5 = null;
        }
        textView5.setMaxLines(Integer.MAX_VALUE);
        NestedScrollView nestedScrollView = this.tvScrollView;
        if (nestedScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvScrollView");
            nestedScrollView = null;
        }
        nestedScrollView.setClipChildren(true);
        NestedScrollView nestedScrollView2 = this.tvScrollView;
        if (nestedScrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvScrollView");
            nestedScrollView2 = null;
        }
        nestedScrollView2.setClipToPadding(true);
        NestedScrollView nestedScrollView3 = this.tvScrollView;
        if (nestedScrollView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvScrollView");
            nestedScrollView3 = null;
        }
        nestedScrollView3.setVerticalScrollBarEnabled(false);
        NestedScrollView nestedScrollView4 = this.tvScrollView;
        if (nestedScrollView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvScrollView");
            nestedScrollView4 = null;
        }
        nestedScrollView4.setVerticalFadingEdgeEnabled(true);
        NestedScrollView nestedScrollView5 = this.tvScrollView;
        if (nestedScrollView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvScrollView");
            nestedScrollView5 = null;
        }
        nestedScrollView5.setFadingEdgeLength(m825dp(24));
        NestedScrollView nestedScrollView6 = this.tvScrollView;
        if (nestedScrollView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvScrollView");
            nestedScrollView6 = null;
        }
        nestedScrollView6.setOverScrollMode(1);
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$$ExternalSyntheticLambda9
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                z = CheckpointDialog.setupQuestionScrolling$lambda$1(CheckpointDialog.this, view, motionEvent);
                return z;
            }
        };
        NestedScrollView nestedScrollView7 = this.tvScrollView;
        if (nestedScrollView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvScrollView");
            nestedScrollView7 = null;
        }
        nestedScrollView7.setOnTouchListener(onTouchListener);
        TextView textView6 = this.tvQuestion;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
        } else {
            textView2 = textView6;
        }
        textView2.setOnTouchListener(onTouchListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r7.canScrollVertically(1) != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean setupQuestionScrolling$lambda$1(CheckpointDialog checkpointDialog, View view, MotionEvent motionEvent) {
        boolean z = (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) ? false : true;
        NestedScrollView nestedScrollView = checkpointDialog.tvScrollView;
        NestedScrollView nestedScrollView2 = null;
        if (nestedScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvScrollView");
            nestedScrollView = null;
        }
        if (!nestedScrollView.canScrollVertically(-1)) {
            NestedScrollView nestedScrollView3 = checkpointDialog.tvScrollView;
            if (nestedScrollView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvScrollView");
                nestedScrollView3 = null;
            }
        }
        NestedScrollView nestedScrollView4 = checkpointDialog.tvScrollView;
        if (nestedScrollView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvScrollView");
        } else {
            nestedScrollView2 = nestedScrollView4;
        }
        ViewParent parent = nestedScrollView2.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismiss() {
        FLogger.INSTANCE.i(CHECK_POINT_TAG, "[Dialog] dismiss");
        Function0<Unit> function0 = this.onDismissAction;
        this.onDismissAction = null;
        getParentFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void handleBackPress() {
        ParsedToolCallInfo toolCallInfo;
        ParsedToolCallInfo toolCallInfo2;
        FLogger fLogger = FLogger.INSTANCE;
        StringBuilder sb = new StringBuilder("[Dialog] handleBackPress: planItemId=");
        ParsedPlanItem parsedPlanItem = this.planItem;
        StringBuilder append = sb.append(parsedPlanItem != null ? parsedPlanItem.getId() : null).append(", toolName=");
        ParsedPlanItem parsedPlanItem2 = this.planItem;
        fLogger.i(CHECK_POINT_TAG, append.append((parsedPlanItem2 == null || (toolCallInfo2 = parsedPlanItem2.getToolCallInfo()) == null) ? null : toolCallInfo2.getName()).toString());
        ParsedPlanItem parsedPlanItem3 = this.planItem;
        String name = (parsedPlanItem3 == null || (toolCallInfo = parsedPlanItem3.getToolCallInfo()) == null) ? null : toolCallInfo.getName();
        CheckpointInteractionCallback checkpointInteractionCallback = this.callback;
        if (checkpointInteractionCallback != null) {
            String id = parsedPlanItem3 != null ? parsedPlanItem3.getId() : null;
            if (id == null) {
                id = "";
            }
            checkpointInteractionCallback.onDecision(new CheckpointDecision.Skip(id, name, this.taskId, this.conversationId));
        }
        dismiss();
    }

    private final void setupListeners() {
        ParsedToolCallInfo toolCallInfo;
        final ParsedPlanItem parsedPlanItem = this.planItem;
        TextView textView = null;
        final String name = (parsedPlanItem == null || (toolCallInfo = parsedPlanItem.getToolCallInfo()) == null) ? null : toolCallInfo.getName();
        FrameLayout frameLayout = this.btnClose;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnClose");
            frameLayout = null;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckpointDialog.setupListeners$lambda$2(CheckpointDialog.this, parsedPlanItem, name, view);
            }
        });
        TextView textView2 = this.btnCancel;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckpointDialog.setupListeners$lambda$3(CheckpointDialog.this, parsedPlanItem, name, view);
            }
        });
        FrameLayout frameLayout2 = this.btnHeaderPrev;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnHeaderPrev");
            frameLayout2 = null;
        }
        frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckpointDialog.this.navigateToPreviousPage();
            }
        });
        FrameLayout frameLayout3 = this.btnHeaderNext;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnHeaderNext");
            frameLayout3 = null;
        }
        frameLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckpointDialog.setupListeners$lambda$5(CheckpointDialog.this, view);
            }
        });
        TextView textView3 = this.btnPrev;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnPrev");
            textView3 = null;
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckpointDialog.this.navigateToPreviousPage();
            }
        });
        TextView textView4 = this.btnNext;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnNext");
        } else {
            textView = textView4;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckpointDialog.setupListeners$lambda$7(CheckpointDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$2(CheckpointDialog checkpointDialog, ParsedPlanItem parsedPlanItem, String str, View view) {
        FLogger.INSTANCE.i(CHECK_POINT_TAG, "[Dialog] btnClose clicked, skip decision");
        CheckpointInteractionCallback checkpointInteractionCallback = checkpointDialog.callback;
        if (checkpointInteractionCallback != null) {
            String id = parsedPlanItem != null ? parsedPlanItem.getId() : null;
            if (id == null) {
                id = "";
            }
            checkpointInteractionCallback.onDecision(new CheckpointDecision.Skip(id, str, checkpointDialog.taskId, checkpointDialog.conversationId));
        }
        checkpointDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$3(CheckpointDialog checkpointDialog, ParsedPlanItem parsedPlanItem, String str, View view) {
        FLogger.INSTANCE.i(CHECK_POINT_TAG, "[Dialog] btnCancel clicked, skip decision");
        CheckpointInteractionCallback checkpointInteractionCallback = checkpointDialog.callback;
        if (checkpointInteractionCallback != null) {
            String id = parsedPlanItem != null ? parsedPlanItem.getId() : null;
            if (id == null) {
                id = "";
            }
            checkpointInteractionCallback.onDecision(new CheckpointDecision.Skip(id, str, checkpointDialog.taskId, checkpointDialog.conversationId));
        }
        checkpointDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$5(CheckpointDialog checkpointDialog, View view) {
        FLogger.INSTANCE.i(CHECK_POINT_TAG, "[Dialog] btnHeaderNext clicked, currentPage=" + checkpointDialog.currentPageIndex + ", totalPages=" + checkpointDialog.pages.size());
        checkpointDialog.saveCurrentPageResult();
        checkpointDialog.advanceToNextPageOrSubmit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$7(CheckpointDialog checkpointDialog, View view) {
        FLogger.INSTANCE.i(CHECK_POINT_TAG, "[Dialog] btnNext clicked, currentPage=" + checkpointDialog.currentPageIndex + ", totalPages=" + checkpointDialog.pages.size());
        checkpointDialog.saveCurrentPageResult();
        checkpointDialog.advanceToNextPageOrSubmit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToPreviousPage() {
        if (this.currentPageIndex > 0) {
            FLogger.INSTANCE.i(CHECK_POINT_TAG, "[Dialog] previous clicked, page " + this.currentPageIndex + " -> " + (this.currentPageIndex - 1));
            saveCurrentPageResult();
            int i = this.currentPageIndex - 1;
            this.currentPageIndex = i;
            renderPage(i);
            return;
        }
        FLogger.INSTANCE.w(CHECK_POINT_TAG, "[Dialog] previous clicked, already at first page");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00ee A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[LOOP:4: B:117:0x00bb->B:132:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0188  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void advanceToNextPageOrSubmit() {
        Object obj;
        String str;
        List<CheckpointPageResult> list;
        boolean z;
        boolean z2;
        CheckpointInteractionCallback checkpointInteractionCallback;
        String id;
        List<String> emptyList;
        boolean z3;
        ParsedToolCallInfo toolCallInfo;
        ParsedPlanItem parsedPlanItem = this.planItem;
        String name = (parsedPlanItem == null || (toolCallInfo = parsedPlanItem.getToolCallInfo()) == null) ? null : toolCallInfo.getName();
        if (this.currentPageIndex < this.pages.size() - 1) {
            this.currentPageIndex++;
            FLogger.INSTANCE.i(CHECK_POINT_TAG, "[Dialog] advanceToNextPage: page=" + this.currentPageIndex);
            renderPage(this.currentPageIndex);
            return;
        }
        List<CheckpointPage> list2 = this.pages;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list2) {
            if (!((CheckpointPage) obj2).isSupplementaryPage()) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = arrayList;
        Iterator<T> it = this.pages.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((CheckpointPage) obj).isSupplementaryPage()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        CheckpointPage checkpointPage = (CheckpointPage) obj;
        if (checkpointPage != null) {
            CheckpointPageResult checkpointPageResult = (CheckpointPageResult) CollectionsKt.getOrNull(this.pageResults, this.pages.indexOf(checkpointPage));
            if (checkpointPageResult != null) {
                str = checkpointPageResult.getCustomInput();
                list = this.pageResults;
                if ((list instanceof Collection) || !list.isEmpty()) {
                    for (CheckpointPageResult checkpointPageResult2 : list) {
                        if (!(!checkpointPageResult2.getSelectedLabels().isEmpty())) {
                            String customInput = checkpointPageResult2.getCustomInput();
                            if (customInput == null || StringsKt.isBlank(customInput)) {
                                z = false;
                                if (!z) {
                                    z2 = true;
                                    break;
                                }
                            }
                        }
                        z = true;
                        if (!z) {
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    ArrayList arrayList3 = arrayList2;
                    if (!(arrayList3 instanceof Collection) || !arrayList3.isEmpty()) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            if (!((CheckpointPage) it2.next()).getOptions().isEmpty()) {
                                z3 = false;
                                break;
                            }
                        }
                    }
                    z3 = true;
                    if (z3 && str == null) {
                        FLogger.INSTANCE.i(CHECK_POINT_TAG, "[Dialog] submit: Confirm (no answers), planItemId=" + (parsedPlanItem != null ? parsedPlanItem.getId() : null) + ", toolName=" + name);
                        CheckpointInteractionCallback checkpointInteractionCallback2 = this.callback;
                        if (checkpointInteractionCallback2 != null) {
                            id = parsedPlanItem != null ? parsedPlanItem.getId() : null;
                            checkpointInteractionCallback2.onDecision(new CheckpointDecision.Confirm(id == null ? "" : id, name, this.taskId, this.conversationId, null, 16, null));
                        }
                        dismiss();
                    }
                }
                ArrayList arrayList4 = arrayList2;
                ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
                int i = 0;
                for (Object obj3 : arrayList4) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    CheckpointPage checkpointPage2 = (CheckpointPage) obj3;
                    CheckpointPageResult checkpointPageResult3 = (CheckpointPageResult) CollectionsKt.getOrNull(this.pageResults, i);
                    if (checkpointPageResult3 == null || (emptyList = checkpointPageResult3.getSelectedLabels()) == null) {
                        emptyList = CollectionsKt.emptyList();
                    }
                    String customInput2 = checkpointPageResult3 != null ? checkpointPageResult3.getCustomInput() : null;
                    if (!checkpointPage2.getOptions().isEmpty()) {
                        String str2 = customInput2;
                        if (!(str2 == null || StringsKt.isBlank(str2))) {
                            emptyList = CollectionsKt.distinct(CollectionsKt.plus(emptyList, OTHER_OPTION_ID));
                        }
                    }
                    arrayList5.add(new AnswerEntry(emptyList, customInput2));
                    i = i2;
                }
                ArrayList arrayList6 = arrayList5;
                FLogger.INSTANCE.i(CHECK_POINT_TAG, "[Dialog] submit: SubmitAnswer, planItemId=" + (parsedPlanItem == null ? parsedPlanItem.getId() : null) + ", toolName=" + name + ", answers=" + arrayList6.size() + ", supplementary=" + (str != null));
                checkpointInteractionCallback = this.callback;
                if (checkpointInteractionCallback != null) {
                    id = parsedPlanItem != null ? parsedPlanItem.getId() : null;
                    checkpointInteractionCallback.onDecision(new CheckpointDecision.SubmitAnswer(id == null ? "" : id, name, this.taskId, this.conversationId, this.questionsJson, arrayList6, str));
                }
                dismiss();
            }
        }
        str = null;
        list = this.pageResults;
        if (list instanceof Collection) {
        }
        while (r2.hasNext()) {
        }
        z2 = false;
        if (!z2) {
        }
        ArrayList arrayList42 = arrayList2;
        ArrayList arrayList52 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList42, 10));
        int i3 = 0;
        while (r3.hasNext()) {
        }
        ArrayList arrayList62 = arrayList52;
        FLogger.INSTANCE.i(CHECK_POINT_TAG, "[Dialog] submit: SubmitAnswer, planItemId=" + (parsedPlanItem == null ? parsedPlanItem.getId() : null) + ", toolName=" + name + ", answers=" + arrayList62.size() + ", supplementary=" + (str != null));
        checkpointInteractionCallback = this.callback;
        if (checkpointInteractionCallback != null) {
        }
        dismiss();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e6 A[LOOP:0: B:73:0x01e0->B:75:0x01e6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0264  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void renderPage(final int index) {
        boolean z;
        FrameLayout frameLayout;
        String str;
        boolean z2;
        NestedScrollView nestedScrollView;
        TextView textView;
        CheckpointPageResult checkpointPageResult;
        Set emptySet;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        int contentTopMarginRes;
        int contentTopMarginDp;
        List<String> selectedLabels;
        int titleTextColorRes;
        TextView textView2;
        TextView textView3;
        Class<?> cls;
        final CheckpointPage checkpointPage = this.pages.get(index);
        ParsedPlanItem parsedPlanItem = this.planItem;
        ParsedToolCallInfo toolCallInfo = parsedPlanItem != null ? parsedPlanItem.getToolCallInfo() : null;
        final ICheckpointDialogCreator creator = toolCallInfo != null ? CheckpointDialogFactory.INSTANCE.getCreator(toolCallInfo) : null;
        final String name = toolCallInfo != null ? toolCallInfo.getName() : null;
        FLogger.INSTANCE.i(CHECK_POINT_TAG, "[Dialog] renderPage: index=" + index + ", question=" + StringsKt.take(checkpointPage.getQuestion(), 50) + ", options=" + checkpointPage.getOptions().size() + ", multiSelect=" + checkpointPage.getMultiSelect() + ", allowCustomInput=" + checkpointPage.getAllowCustomInput() + ", creator=" + ((creator == null || (cls = creator.getClass()) == null) ? null : cls.getSimpleName()));
        final boolean areEqual = Intrinsics.areEqual(name, "AskUserQuestion");
        if (!areEqual) {
            if (!(creator != null && creator.showCloseButton())) {
                z = false;
                frameLayout = this.btnClose;
                if (frameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnClose");
                    frameLayout = null;
                }
                frameLayout.setVisibility(!z ? 0 : 8);
                if (creator == null) {
                    Context requireContext = requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                    str = creator.getHeaderLabel(requireContext);
                } else {
                    str = null;
                }
                updateHeader(str, areEqual, index);
                if (!z) {
                    LinearLayout linearLayout = this.headerNavGroup;
                    if (linearLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("headerNavGroup");
                        linearLayout = null;
                    }
                    if (linearLayout.getVisibility() != 0) {
                        z2 = false;
                        updateTitleTopMargin(z2);
                        removeContentView();
                        if (toolCallInfo == null && creator != null) {
                            Context requireContext2 = requireContext();
                            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
                            String title = creator.getTitle(requireContext2, toolCallInfo);
                            if (title.length() == 0) {
                                if (checkpointPage.getQuestion().length() == 0) {
                                    TextView textView4 = this.tvQuestion;
                                    if (textView4 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
                                        textView4 = null;
                                    }
                                    textView4.setVisibility(8);
                                    NestedScrollView nestedScrollView2 = this.tvScrollView;
                                    if (nestedScrollView2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("tvScrollView");
                                        nestedScrollView2 = null;
                                    }
                                    nestedScrollView2.setVisibility(8);
                                    titleTextColorRes = creator.getTitleTextColorRes();
                                    textView2 = this.tvQuestion;
                                    if (textView2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
                                        textView2 = null;
                                    }
                                    Context requireContext3 = requireContext();
                                    if (titleTextColorRes == 0) {
                                        titleTextColorRes = C0637R.color.trae_checkpoint_text_primary;
                                    }
                                    textView2.setTextColor(ContextCompat.getColor(requireContext3, titleTextColorRes));
                                    textView3 = this.tvQuestion;
                                    if (textView3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
                                        textView3 = null;
                                    }
                                    textView3.setLetterSpacing(creator.getTitleLetterSpacing());
                                }
                            }
                            NestedScrollView nestedScrollView3 = this.tvScrollView;
                            if (nestedScrollView3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("tvScrollView");
                                nestedScrollView3 = null;
                            }
                            nestedScrollView3.setVisibility(0);
                            TextView textView5 = this.tvQuestion;
                            if (textView5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
                                textView5 = null;
                            }
                            textView5.setVisibility(0);
                            if (checkpointPage.getQuestion().length() > 0) {
                                title = checkpointPage.getQuestion();
                            }
                            setQuestionText(title);
                            titleTextColorRes = creator.getTitleTextColorRes();
                            textView2 = this.tvQuestion;
                            if (textView2 == null) {
                            }
                            Context requireContext32 = requireContext();
                            if (titleTextColorRes == 0) {
                            }
                            textView2.setTextColor(ContextCompat.getColor(requireContext32, titleTextColorRes));
                            textView3 = this.tvQuestion;
                            if (textView3 == null) {
                            }
                            textView3.setLetterSpacing(creator.getTitleLetterSpacing());
                        } else {
                            nestedScrollView = this.tvScrollView;
                            if (nestedScrollView == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("tvScrollView");
                                nestedScrollView = null;
                            }
                            nestedScrollView.setVisibility(0);
                            textView = this.tvQuestion;
                            if (textView == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
                                textView = null;
                            }
                            textView.setVisibility(0);
                            setQuestionText(checkpointPage.getQuestion());
                        }
                        checkpointPageResult = (CheckpointPageResult) CollectionsKt.getOrNull(this.pageResults, index);
                        if (checkpointPageResult != null || (selectedLabels = checkpointPageResult.getSelectedLabels()) == null || (emptySet = CollectionsKt.toSet(selectedLabels)) == null) {
                            emptySet = SetsKt.emptySet();
                        }
                        for (CheckpointOption checkpointOption : checkpointPage.getOptions()) {
                            checkpointOption.setSelected(emptySet.contains(checkpointOption.getLabel()));
                        }
                        if (!checkpointPage.getOptions().isEmpty()) {
                            RecyclerView recyclerView4 = this.rvOptions;
                            if (recyclerView4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("rvOptions");
                                recyclerView4 = null;
                            }
                            recyclerView4.setVisibility(0);
                            this.optionAdapter = new CheckpointOptionAdapter(checkpointPage.getMultiSelect(), new Function0() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$$ExternalSyntheticLambda2
                                public final Object invoke() {
                                    Unit renderPage$lambda$15;
                                    renderPage$lambda$15 = CheckpointDialog.renderPage$lambda$15(CheckpointDialog.this, checkpointPage, creator, areEqual);
                                    return renderPage$lambda$15;
                                }
                            }, !checkpointPage.getMultiSelect() ? new Function1() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$$ExternalSyntheticLambda3
                                public final Object invoke(Object obj) {
                                    Unit renderPage$lambda$17;
                                    renderPage$lambda$17 = CheckpointDialog.renderPage$lambda$17(CheckpointDialog.this, index, (CheckpointOption) obj);
                                    return renderPage$lambda$17;
                                }
                            } : null);
                            RecyclerView recyclerView5 = this.rvOptions;
                            if (recyclerView5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("rvOptions");
                                recyclerView5 = null;
                            }
                            recyclerView5.setAdapter(this.optionAdapter);
                            CheckpointOptionAdapter checkpointOptionAdapter = this.optionAdapter;
                            if (checkpointOptionAdapter != null) {
                                checkpointOptionAdapter.submitList(checkpointPage.getOptions());
                            }
                            recyclerView = null;
                        } else {
                            RecyclerView recyclerView6 = this.rvOptions;
                            if (recyclerView6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("rvOptions");
                                recyclerView6 = null;
                            }
                            recyclerView6.setVisibility(8);
                            recyclerView = null;
                            this.optionAdapter = null;
                        }
                        if (checkpointPage.getOptions().isEmpty() && !checkpointPage.getAllowCustomInput() && toolCallInfo != null && creator != null) {
                            creator.setFileClickListener(this.onFileClick);
                            creator.setResolvedDisplayName(this.resolvedPluginDisplayName);
                            Context requireContext4 = requireContext();
                            Intrinsics.checkNotNullExpressionValue(requireContext4, "requireContext(...)");
                            View createContentView = creator.createContentView(requireContext4, toolCallInfo, this.confirmInfo);
                            recyclerView2 = this.rvOptions;
                            if (recyclerView2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("rvOptions");
                                recyclerView2 = recyclerView;
                            }
                            ViewParent parent = recyclerView2.getParent();
                            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                            ViewGroup viewGroup = (ViewGroup) parent;
                            recyclerView3 = this.rvOptions;
                            if (recyclerView3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("rvOptions");
                                recyclerView3 = recyclerView;
                            }
                            int indexOfChild = viewGroup.indexOfChild((View) recyclerView3);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                            contentTopMarginRes = creator.getContentTopMarginRes();
                            if (contentTopMarginRes == 0) {
                                contentTopMarginDp = getResources().getDimensionPixelSize(contentTopMarginRes);
                            } else {
                                contentTopMarginDp = (int) (creator.getContentTopMarginDp() * getResources().getDisplayMetrics().density);
                            }
                            layoutParams.topMargin = contentTopMarginDp;
                            viewGroup.addView(createContentView, indexOfChild + 1, layoutParams);
                            this.contentView = createContentView;
                            if (creator.hideDefaultButtons()) {
                                creator.bindActions(createContentView, new Function0() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$$ExternalSyntheticLambda4
                                    public final Object invoke() {
                                        Unit renderPage$lambda$19;
                                        renderPage$lambda$19 = CheckpointDialog.renderPage$lambda$19(CheckpointDialog.this, name);
                                        return renderPage$lambda$19;
                                    }
                                }, new Function0() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$$ExternalSyntheticLambda5
                                    public final Object invoke() {
                                        Unit renderPage$lambda$20;
                                        renderPage$lambda$20 = CheckpointDialog.renderPage$lambda$20(CheckpointDialog.this, name);
                                        return renderPage$lambda$20;
                                    }
                                }, new Function1() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$$ExternalSyntheticLambda6
                                    public final Object invoke(Object obj) {
                                        Unit renderPage$lambda$21;
                                        renderPage$lambda$21 = CheckpointDialog.renderPage$lambda$21(CheckpointDialog.this, name, (String) obj);
                                        return renderPage$lambda$21;
                                    }
                                });
                            }
                        }
                        if (checkpointPage.getAllowCustomInput()) {
                            addCustomInputView(checkpointPage, checkpointPageResult != null ? checkpointPageResult.getCustomInput() : recyclerView, creator, areEqual);
                        } else {
                            removeCustomInputView();
                        }
                        updateActionArea(checkpointPage, creator, areEqual);
                    }
                }
                z2 = true;
                updateTitleTopMargin(z2);
                removeContentView();
                if (toolCallInfo == null) {
                }
                nestedScrollView = this.tvScrollView;
                if (nestedScrollView == null) {
                }
                nestedScrollView.setVisibility(0);
                textView = this.tvQuestion;
                if (textView == null) {
                }
                textView.setVisibility(0);
                setQuestionText(checkpointPage.getQuestion());
                checkpointPageResult = (CheckpointPageResult) CollectionsKt.getOrNull(this.pageResults, index);
                if (checkpointPageResult != null) {
                }
                emptySet = SetsKt.emptySet();
                while (r14.hasNext()) {
                }
                if (!checkpointPage.getOptions().isEmpty()) {
                }
                if (checkpointPage.getOptions().isEmpty()) {
                    creator.setFileClickListener(this.onFileClick);
                    creator.setResolvedDisplayName(this.resolvedPluginDisplayName);
                    Context requireContext42 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext42, "requireContext(...)");
                    View createContentView2 = creator.createContentView(requireContext42, toolCallInfo, this.confirmInfo);
                    recyclerView2 = this.rvOptions;
                    if (recyclerView2 == null) {
                    }
                    ViewParent parent2 = recyclerView2.getParent();
                    Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
                    ViewGroup viewGroup2 = (ViewGroup) parent2;
                    recyclerView3 = this.rvOptions;
                    if (recyclerView3 == null) {
                    }
                    int indexOfChild2 = viewGroup2.indexOfChild((View) recyclerView3);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    contentTopMarginRes = creator.getContentTopMarginRes();
                    if (contentTopMarginRes == 0) {
                    }
                    layoutParams2.topMargin = contentTopMarginDp;
                    viewGroup2.addView(createContentView2, indexOfChild2 + 1, layoutParams2);
                    this.contentView = createContentView2;
                    if (creator.hideDefaultButtons()) {
                    }
                }
                if (checkpointPage.getAllowCustomInput()) {
                }
                updateActionArea(checkpointPage, creator, areEqual);
            }
        }
        z = true;
        frameLayout = this.btnClose;
        if (frameLayout == null) {
        }
        frameLayout.setVisibility(!z ? 0 : 8);
        if (creator == null) {
        }
        updateHeader(str, areEqual, index);
        if (!z) {
        }
        z2 = true;
        updateTitleTopMargin(z2);
        removeContentView();
        if (toolCallInfo == null) {
        }
        nestedScrollView = this.tvScrollView;
        if (nestedScrollView == null) {
        }
        nestedScrollView.setVisibility(0);
        textView = this.tvQuestion;
        if (textView == null) {
        }
        textView.setVisibility(0);
        setQuestionText(checkpointPage.getQuestion());
        checkpointPageResult = (CheckpointPageResult) CollectionsKt.getOrNull(this.pageResults, index);
        if (checkpointPageResult != null) {
        }
        emptySet = SetsKt.emptySet();
        while (r14.hasNext()) {
        }
        if (!checkpointPage.getOptions().isEmpty()) {
        }
        if (checkpointPage.getOptions().isEmpty()) {
        }
        if (checkpointPage.getAllowCustomInput()) {
        }
        updateActionArea(checkpointPage, creator, areEqual);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit renderPage$lambda$15(CheckpointDialog checkpointDialog, CheckpointPage checkpointPage, ICheckpointDialogCreator iCheckpointDialogCreator, boolean z) {
        checkpointDialog.saveCurrentPageResult();
        checkpointDialog.updateActionArea(checkpointPage, iCheckpointDialogCreator, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit renderPage$lambda$17(final CheckpointDialog checkpointDialog, final int i, CheckpointOption checkpointOption) {
        Intrinsics.checkNotNullParameter(checkpointOption, "<unused var>");
        View view = checkpointDialog.getView();
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    CheckpointDialog.renderPage$lambda$17$lambda$16(CheckpointDialog.this, i);
                }
            }, 250L);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderPage$lambda$17$lambda$16(CheckpointDialog checkpointDialog, int i) {
        if (checkpointDialog.isAdded() && checkpointDialog.currentPageIndex == i) {
            checkpointDialog.saveCurrentPageResult();
            checkpointDialog.advanceToNextPageOrSubmit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit renderPage$lambda$19(CheckpointDialog checkpointDialog, String str) {
        CheckpointInteractionCallback checkpointInteractionCallback = checkpointDialog.callback;
        if (checkpointInteractionCallback != null) {
            ParsedPlanItem parsedPlanItem = checkpointDialog.planItem;
            String id = parsedPlanItem != null ? parsedPlanItem.getId() : null;
            if (id == null) {
                id = "";
            }
            checkpointInteractionCallback.onDecision(new CheckpointDecision.Confirm(id, str, checkpointDialog.taskId, checkpointDialog.conversationId, null, 16, null));
        }
        checkpointDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit renderPage$lambda$20(CheckpointDialog checkpointDialog, String str) {
        CheckpointInteractionCallback checkpointInteractionCallback = checkpointDialog.callback;
        if (checkpointInteractionCallback != null) {
            ParsedPlanItem parsedPlanItem = checkpointDialog.planItem;
            String id = parsedPlanItem != null ? parsedPlanItem.getId() : null;
            if (id == null) {
                id = "";
            }
            checkpointInteractionCallback.onDecision(new CheckpointDecision.Skip(id, str, checkpointDialog.taskId, checkpointDialog.conversationId));
        }
        checkpointDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit renderPage$lambda$21(CheckpointDialog checkpointDialog, String str, String str2) {
        CheckpointInteractionCallback checkpointInteractionCallback = checkpointDialog.callback;
        if (checkpointInteractionCallback != null) {
            ParsedPlanItem parsedPlanItem = checkpointDialog.planItem;
            String id = parsedPlanItem != null ? parsedPlanItem.getId() : null;
            if (id == null) {
                id = "";
            }
            checkpointInteractionCallback.onDecision(new CheckpointDecision.Confirm(id, str, checkpointDialog.taskId, checkpointDialog.conversationId, str2));
        }
        checkpointDialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void updateHeader(String headerLabel, boolean isAskUserQuestion, int index) {
        String string;
        boolean z = isAskUserQuestion || headerLabel != null || this.pages.size() > 1;
        LinearLayout linearLayout = this.headerNavGroup;
        TextView textView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerNavGroup");
            linearLayout = null;
        }
        linearLayout.setVisibility(z ? 0 : 8);
        TextView textView2 = this.tvProgress;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvProgress");
            textView2 = null;
        }
        textView2.setVisibility(z ? 0 : 8);
        FrameLayout frameLayout = this.btnHeaderPrev;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnHeaderPrev");
            frameLayout = null;
        }
        frameLayout.setVisibility(isAskUserQuestion ? 0 : 8);
        FrameLayout frameLayout2 = this.btnHeaderNext;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnHeaderNext");
            frameLayout2 = null;
        }
        frameLayout2.setVisibility(isAskUserQuestion ? 0 : 8);
        FrameLayout frameLayout3 = this.btnHeaderPrev;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnHeaderPrev");
            frameLayout3 = null;
        }
        frameLayout3.setEnabled(index > 0);
        FrameLayout frameLayout4 = this.btnHeaderNext;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnHeaderNext");
            frameLayout4 = null;
        }
        frameLayout4.setEnabled(index < this.pages.size() - 1);
        int i = index > 0 ? C0591R.color.trae_icon_icon_default : C0591R.color.trae_icon_icon_disabled;
        ImageView imageView = this.ivHeaderPrev;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivHeaderPrev");
            imageView = null;
        }
        imageView.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), i)));
        int i2 = index < this.pages.size() - 1 ? C0591R.color.trae_icon_icon_default : C0591R.color.trae_icon_icon_disabled;
        ImageView imageView2 = this.ivHeaderNext;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivHeaderNext");
            imageView2 = null;
        }
        imageView2.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), i2)));
        TextView textView3 = this.tvProgress;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvProgress");
        } else {
            textView = textView3;
        }
        if (isAskUserQuestion || this.pages.size() > 1) {
            string = getString(C0637R.string.trae_checkpoint_progress, new Object[]{Integer.valueOf(index + 1), Integer.valueOf(this.pages.size())});
        } else if (headerLabel != null) {
            string = headerLabel;
        }
        textView.setText(string);
    }

    private final void updateTitleTopMargin(boolean showHeader) {
        NestedScrollView nestedScrollView = this.tvScrollView;
        NestedScrollView nestedScrollView2 = null;
        if (nestedScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvScrollView");
            nestedScrollView = null;
        }
        ViewGroup.LayoutParams layoutParams = nestedScrollView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            return;
        }
        int i = showHeader ? (int) (16 * getResources().getDisplayMetrics().density) : 0;
        if (marginLayoutParams.topMargin != i) {
            marginLayoutParams.topMargin = i;
            NestedScrollView nestedScrollView3 = this.tvScrollView;
            if (nestedScrollView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvScrollView");
            } else {
                nestedScrollView2 = nestedScrollView3;
            }
            nestedScrollView2.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$setQuestionText$listener$1] */
    private final void setQuestionText(final String text) {
        View.OnLayoutChangeListener onLayoutChangeListener = this.questionLayoutListener;
        TextView textView = null;
        if (onLayoutChangeListener != null) {
            TextView textView2 = this.tvQuestion;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
                textView2 = null;
            }
            textView2.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
        this.questionLayoutListener = null;
        TextView textView3 = this.tvQuestion;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
            textView3 = null;
        }
        textView3.setText(text);
        TextView textView4 = this.tvQuestion;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
            textView4 = null;
        }
        textView4.scrollTo(0, 0);
        NestedScrollView nestedScrollView = this.tvScrollView;
        if (nestedScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvScrollView");
            nestedScrollView = null;
        }
        nestedScrollView.scrollTo(0, 0);
        TextView textView5 = this.tvQuestion;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
            textView5 = null;
        }
        textView5.setMaxLines(Integer.MAX_VALUE);
        TextView textView6 = this.tvQuestion;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
            textView6 = null;
        }
        textView6.setVerticalFadingEdgeEnabled(false);
        NestedScrollView nestedScrollView2 = this.tvScrollView;
        if (nestedScrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvScrollView");
            nestedScrollView2 = null;
        }
        nestedScrollView2.setVerticalFadingEdgeEnabled(false);
        TextView textView7 = this.tvQuestion;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
            textView7 = null;
        }
        setViewHeight(textView7, -2);
        NestedScrollView nestedScrollView3 = this.tvScrollView;
        if (nestedScrollView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvScrollView");
            nestedScrollView3 = null;
        }
        setViewHeight((View) nestedScrollView3, -2);
        if (text.length() > 120) {
            applyQuestionCollapsedViewport();
        }
        final ?? r0 = new View.OnLayoutChangeListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$setQuestionText$listener$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                boolean applyQuestionViewportIfReady;
                TextView textView8;
                View.OnLayoutChangeListener onLayoutChangeListener2;
                Intrinsics.checkNotNullParameter(v, "v");
                applyQuestionViewportIfReady = CheckpointDialog.this.applyQuestionViewportIfReady(text);
                if (applyQuestionViewportIfReady) {
                    textView8 = CheckpointDialog.this.tvQuestion;
                    if (textView8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
                        textView8 = null;
                    }
                    textView8.removeOnLayoutChangeListener(this);
                    onLayoutChangeListener2 = CheckpointDialog.this.questionLayoutListener;
                    if (onLayoutChangeListener2 == this) {
                        CheckpointDialog.this.questionLayoutListener = null;
                    }
                }
            }
        };
        View.OnLayoutChangeListener onLayoutChangeListener2 = (View.OnLayoutChangeListener) r0;
        this.questionLayoutListener = onLayoutChangeListener2;
        TextView textView8 = this.tvQuestion;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
            textView8 = null;
        }
        textView8.addOnLayoutChangeListener(onLayoutChangeListener2);
        TextView textView9 = this.tvQuestion;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
        } else {
            textView = textView9;
        }
        textView.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                CheckpointDialog.setQuestionText$lambda$22(CheckpointDialog.this, text, r0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setQuestionText$lambda$22(CheckpointDialog checkpointDialog, String str, CheckpointDialog$setQuestionText$listener$1 checkpointDialog$setQuestionText$listener$1) {
        if (checkpointDialog.applyQuestionViewportIfReady(str)) {
            TextView textView = checkpointDialog.tvQuestion;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
                textView = null;
            }
            textView.removeOnLayoutChangeListener(checkpointDialog$setQuestionText$listener$1);
            if (checkpointDialog.questionLayoutListener == checkpointDialog$setQuestionText$listener$1) {
                checkpointDialog.questionLayoutListener = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean applyQuestionViewportIfReady(String text) {
        if (isAdded()) {
            TextView textView = this.tvQuestion;
            NestedScrollView nestedScrollView = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
                textView = null;
            }
            CharSequence text2 = textView.getText();
            if (Intrinsics.areEqual(text2 != null ? text2.toString() : null, text)) {
                TextView textView2 = this.tvQuestion;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
                    textView2 = null;
                }
                int measureNaturalLineCount = measureNaturalLineCount(textView2);
                if (measureNaturalLineCount <= 0) {
                    return false;
                }
                if (measureNaturalLineCount > 5) {
                    applyQuestionCollapsedViewport();
                } else {
                    TextView textView3 = this.tvQuestion;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
                        textView3 = null;
                    }
                    textView3.setVerticalFadingEdgeEnabled(false);
                    NestedScrollView nestedScrollView2 = this.tvScrollView;
                    if (nestedScrollView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvScrollView");
                        nestedScrollView2 = null;
                    }
                    nestedScrollView2.setVerticalFadingEdgeEnabled(false);
                    TextView textView4 = this.tvQuestion;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
                        textView4 = null;
                    }
                    setViewHeight(textView4, -2);
                    NestedScrollView nestedScrollView3 = this.tvScrollView;
                    if (nestedScrollView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvScrollView");
                    } else {
                        nestedScrollView = nestedScrollView3;
                    }
                    setViewHeight((View) nestedScrollView, -2);
                }
            }
        }
        return true;
    }

    private final void applyQuestionCollapsedViewport() {
        TextView textView = this.tvQuestion;
        NestedScrollView nestedScrollView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvQuestion");
            textView = null;
        }
        setViewHeight(textView, -2);
        NestedScrollView nestedScrollView2 = this.tvScrollView;
        if (nestedScrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvScrollView");
            nestedScrollView2 = null;
        }
        setViewHeight((View) nestedScrollView2, questionCollapsedHeightPx());
        NestedScrollView nestedScrollView3 = this.tvScrollView;
        if (nestedScrollView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvScrollView");
            nestedScrollView3 = null;
        }
        nestedScrollView3.setVerticalFadingEdgeEnabled(true);
        NestedScrollView nestedScrollView4 = this.tvScrollView;
        if (nestedScrollView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvScrollView");
        } else {
            nestedScrollView = nestedScrollView4;
        }
        nestedScrollView.setFadingEdgeLength(m825dp(24));
    }

    private final int measureNaturalLineCount(TextView textView) {
        CharSequence text = textView.getText();
        if (text == null) {
            return 0;
        }
        int width = (textView.getWidth() - textView.getCompoundPaddingLeft()) - textView.getCompoundPaddingRight();
        if ((text.length() == 0) || width <= 0) {
            return 0;
        }
        StaticLayout build = StaticLayout.Builder.obtain(text, 0, text.length(), textView.getPaint(), width).setAlignment(Layout.Alignment.ALIGN_NORMAL).setIncludePad(textView.getIncludeFontPadding()).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).build();
        Intrinsics.checkNotNull(build);
        return build.getLineCount();
    }

    private final int questionCollapsedHeightPx() {
        return (int) (24 * 5.75f * getResources().getDisplayMetrics().density);
    }

    private final void setViewHeight(View view, int height) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null || layoutParams.height == height) {
            return;
        }
        layoutParams.height = height;
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: dp */
    private final int m825dp(int i) {
        return (int) (i * getResources().getDisplayMetrics().density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0094, code lost:
    
        if (r12 == null) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateActionArea(CheckpointPage page, ICheckpointDialogCreator creator, boolean isAskUserQuestion) {
        String str;
        Editable text;
        List<CheckpointOption> selectedOptions;
        String string;
        boolean z = true;
        LinearLayout linearLayout = null;
        if (creator != null && creator.hideDefaultButtons()) {
            LinearLayout linearLayout2 = this.actionGroup;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionGroup");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.setVisibility(8);
            return;
        }
        if (creator != null) {
            TextView textView = this.btnCancel;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
                textView = null;
            }
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            textView.setText(creator.getSecondaryButtonText(requireContext));
            int primaryButtonBackgroundRes = creator.getPrimaryButtonBackgroundRes();
            TextView textView2 = this.btnNext;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnNext");
                textView2 = null;
            }
            if (primaryButtonBackgroundRes == 0) {
                primaryButtonBackgroundRes = C0637R.drawable.trae_bg_checkpoint_btn_primary;
            }
            textView2.setBackgroundResource(primaryButtonBackgroundRes);
        } else {
            TextView textView3 = this.btnNext;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnNext");
                textView3 = null;
            }
            textView3.setBackgroundResource(C0637R.drawable.trae_bg_checkpoint_btn_primary);
        }
        TextView textView4 = this.btnNext;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnNext");
            textView4 = null;
        }
        if (this.currentPageIndex == this.pages.size() - 1) {
            if (!page.getOptions().isEmpty() || page.getAllowCustomInput()) {
                string = getString(C0637R.string.trae_checkpoint_submit);
                Intrinsics.checkNotNull(string);
            } else {
                if (creator != null) {
                    Context requireContext2 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
                    string = creator.getPrimaryButtonText(requireContext2);
                }
                string = getString(C0637R.string.trae_checkpoint_submit);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            }
            str = string;
        } else {
            String string2 = getString(C0637R.string.trae_checkpoint_next);
            Intrinsics.checkNotNull(string2);
            str = string2;
        }
        textView4.setText(str);
        if (isAskUserQuestion) {
            TextView textView5 = this.btnCancel;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
                textView5 = null;
            }
            textView5.setVisibility(8);
            TextView textView6 = this.btnPrev;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnPrev");
                textView6 = null;
            }
            textView6.setVisibility(8);
            CheckpointOptionAdapter checkpointOptionAdapter = this.optionAdapter;
            boolean z2 = (checkpointOptionAdapter == null || (selectedOptions = checkpointOptionAdapter.getSelectedOptions()) == null || !(selectedOptions.isEmpty() ^ true)) ? false : true;
            EditText editText = this.etCustomAnswer;
            String obj = (editText == null || (text = editText.getText()) == null) ? null : text.toString();
            boolean z3 = !(obj == null || StringsKt.isBlank(obj));
            if (!page.getMultiSelect() || (!z2 && !z3)) {
                z = false;
            }
            LinearLayout linearLayout3 = this.actionGroup;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionGroup");
            } else {
                linearLayout = linearLayout3;
            }
            linearLayout.setVisibility(z ? 0 : 8);
            return;
        }
        TextView textView7 = this.btnCancel;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
            textView7 = null;
        }
        textView7.setVisibility(0);
        TextView textView8 = this.btnPrev;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnPrev");
            textView8 = null;
        }
        textView8.setVisibility(this.currentPageIndex > 0 ? 0 : 8);
        LinearLayout linearLayout4 = this.actionGroup;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionGroup");
        } else {
            linearLayout = linearLayout4;
        }
        linearLayout.setVisibility(0);
    }

    private final void removeContentView() {
        View view = this.contentView;
        if (view != null) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
        this.contentView = null;
    }

    private final void addCustomInputView(final CheckpointPage page, String restoredText, final ICheckpointDialogCreator creator, final boolean isAskUserQuestion) {
        EditText editText;
        removeCustomInputView();
        LayoutInflater from = LayoutInflater.from(requireContext());
        int i = C0637R.layout.trae_item_checkpoint_input;
        RecyclerView recyclerView = this.rvOptions;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvOptions");
            recyclerView = null;
        }
        ViewParent parent = recyclerView.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        View inflate = from.inflate(i, (ViewGroup) parent, false);
        this.inputContainer = inflate;
        this.etCustomAnswer = (EditText) inflate.findViewById(C0637R.id.et_custom_answer);
        this.btnCustomSend = (FrameLayout) inflate.findViewById(C0637R.id.btn_custom_send);
        this.customCheckContainer = (FrameLayout) inflate.findViewById(C0637R.id.checkbox_container);
        this.ivCustomEdit = (ImageView) inflate.findViewById(C0637R.id.iv_custom_edit);
        this.ivCustomCheck = (ImageView) inflate.findViewById(C0637R.id.iv_check);
        this.ivCustomSend = (ImageView) inflate.findViewById(C0637R.id.iv_custom_send);
        if (restoredText != null && (editText = this.etCustomAnswer) != null) {
            editText.setText(restoredText);
        }
        EditText editText2 = this.etCustomAnswer;
        if (editText2 != null) {
            editText2.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(500)});
        }
        EditText editText3 = this.etCustomAnswer;
        if (editText3 != null) {
            editText3.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$$ExternalSyntheticLambda15
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    CheckpointDialog.this.updateCustomInputState(page);
                }
            });
        }
        EditText editText4 = this.etCustomAnswer;
        if (editText4 != null) {
            editText4.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$addCustomInputView$3
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    CheckpointDialog.this.clearSingleSelectionForCustomInputIfNeeded(page);
                    CheckpointDialog.this.updateCustomInputState(page);
                    CheckpointDialog.this.updateActionArea(page, creator, isAskUserQuestion);
                }
            });
        }
        EditText editText5 = this.etCustomAnswer;
        if (editText5 != null) {
            editText5.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$$ExternalSyntheticLambda16
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                    boolean addCustomInputView$lambda$26;
                    addCustomInputView$lambda$26 = CheckpointDialog.addCustomInputView$lambda$26(CheckpointDialog.this, textView, i2, keyEvent);
                    return addCustomInputView$lambda$26;
                }
            });
        }
        FrameLayout frameLayout = this.btnCustomSend;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$$ExternalSyntheticLambda17
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CheckpointDialog.addCustomInputView$lambda$27(CheckpointDialog.this, view);
                }
            });
        }
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckpointDialog.addCustomInputView$lambda$28(CheckpointDialog.this, view);
            }
        });
        RecyclerView recyclerView3 = this.rvOptions;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvOptions");
            recyclerView3 = null;
        }
        ViewParent parent2 = recyclerView3.getParent();
        Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent2;
        RecyclerView recyclerView4 = this.rvOptions;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvOptions");
        } else {
            recyclerView2 = recyclerView4;
        }
        viewGroup.addView(inflate, viewGroup.indexOfChild((View) recyclerView2) + 1);
        clearSingleSelectionForCustomInputIfNeeded(page);
        updateCustomInputState(page);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean addCustomInputView$lambda$26(CheckpointDialog checkpointDialog, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        FrameLayout frameLayout = checkpointDialog.btnCustomSend;
        if (!(frameLayout != null && frameLayout.isEnabled())) {
            return false;
        }
        checkpointDialog.submitCustomInput();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addCustomInputView$lambda$27(CheckpointDialog checkpointDialog, View view) {
        FrameLayout frameLayout = checkpointDialog.btnCustomSend;
        boolean z = false;
        if (frameLayout != null && frameLayout.isEnabled()) {
            z = true;
        }
        if (z) {
            checkpointDialog.submitCustomInput();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addCustomInputView$lambda$28(CheckpointDialog checkpointDialog, View view) {
        EditText editText = checkpointDialog.etCustomAnswer;
        if (editText != null) {
            editText.requestFocus();
        }
        checkpointDialog.showKeyboard(checkpointDialog.etCustomAnswer);
    }

    private final void showKeyboard(final EditText editText) {
        if (editText == null) {
            return;
        }
        editText.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                CheckpointDialog.showKeyboard$lambda$29(editText);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showKeyboard$lambda$29(EditText editText) {
        Object systemService = editText.getContext().getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(editText, 1);
        }
    }

    private final void submitCustomInput() {
        saveCurrentPageResult();
        advanceToNextPageOrSubmit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCustomInputState(CheckpointPage page) {
        int i;
        int i2;
        Editable text;
        EditText editText = this.etCustomAnswer;
        String obj = (editText == null || (text = editText.getText()) == null) ? null : text.toString();
        boolean z = !(obj == null || StringsKt.isBlank(obj));
        EditText editText2 = this.etCustomAnswer;
        boolean z2 = editText2 != null && editText2.hasFocus();
        FrameLayout frameLayout = this.btnCustomSend;
        if (frameLayout != null) {
            frameLayout.setVisibility((z2 || z) ? 0 : 8);
        }
        FrameLayout frameLayout2 = this.btnCustomSend;
        if (frameLayout2 != null) {
            frameLayout2.setEnabled(z);
        }
        FrameLayout frameLayout3 = this.btnCustomSend;
        if (frameLayout3 != null) {
            frameLayout3.setAlpha(1.0f);
        }
        FrameLayout frameLayout4 = this.btnCustomSend;
        if (frameLayout4 != null) {
            if (z) {
                i2 = C0637R.drawable.trae_bg_checkpoint_btn_primary;
            } else {
                i2 = C0637R.drawable.trae_bg_checkpoint_send_disabled;
            }
            frameLayout4.setBackgroundResource(i2);
        }
        ImageView imageView = this.ivCustomSend;
        if (imageView != null) {
            imageView.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), z ? C0591R.color.trae_text_text_onaccent : C0637R.color.trae_checkpoint_icon_disabled)));
        }
        if (page.getMultiSelect()) {
            ImageView imageView2 = this.ivCustomEdit;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            FrameLayout frameLayout5 = this.customCheckContainer;
            if (frameLayout5 != null) {
                if (z) {
                    i = C0637R.drawable.trae_bg_checkpoint_checkbox_checked;
                } else {
                    i = C0637R.drawable.trae_bg_checkpoint_checkbox_unchecked;
                }
                frameLayout5.setBackgroundResource(i);
            }
            ImageView imageView3 = this.ivCustomCheck;
            if (imageView3 != null) {
                imageView3.setVisibility(z ? 0 : 8);
                return;
            }
            return;
        }
        FrameLayout frameLayout6 = this.customCheckContainer;
        if (frameLayout6 != null) {
            frameLayout6.setBackground(null);
        }
        ImageView imageView4 = this.ivCustomEdit;
        if (imageView4 != null) {
            imageView4.setVisibility(0);
        }
        ImageView imageView5 = this.ivCustomCheck;
        if (imageView5 != null) {
            imageView5.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearSingleSelectionForCustomInputIfNeeded(CheckpointPage page) {
        CheckpointOptionAdapter checkpointOptionAdapter;
        Editable text;
        EditText editText = this.etCustomAnswer;
        String obj = (editText == null || (text = editText.getText()) == null) ? null : text.toString();
        boolean z = !(obj == null || StringsKt.isBlank(obj));
        if (page.getMultiSelect() || !z || (checkpointOptionAdapter = this.optionAdapter) == null) {
            return;
        }
        checkpointOptionAdapter.clearSelection();
    }

    private final void removeCustomInputView() {
        View view = this.inputContainer;
        if (view != null) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
        this.inputContainer = null;
        this.etCustomAnswer = null;
        this.btnCustomSend = null;
        this.customCheckContainer = null;
        this.ivCustomEdit = null;
        this.ivCustomCheck = null;
        this.ivCustomSend = null;
    }

    private final void saveCurrentPageResult() {
        List<CheckpointOption> emptyList;
        Editable text;
        String obj;
        CheckpointOptionAdapter checkpointOptionAdapter = this.optionAdapter;
        if (checkpointOptionAdapter == null || (emptyList = checkpointOptionAdapter.getSelectedOptions()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        EditText editText = this.etCustomAnswer;
        String str = null;
        if (editText != null && (text = editText.getText()) != null && (obj = text.toString()) != null && (!StringsKt.isBlank(obj))) {
            str = obj;
        }
        int i = this.currentPageIndex;
        List<CheckpointOption> list = emptyList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((CheckpointOption) it.next()).getLabel());
        }
        CheckpointPageResult checkpointPageResult = new CheckpointPageResult(i, arrayList, str);
        if (this.currentPageIndex < this.pageResults.size()) {
            this.pageResults.set(this.currentPageIndex, checkpointPageResult);
            return;
        }
        while (this.pageResults.size() < this.currentPageIndex) {
            this.pageResults.add(new CheckpointPageResult(this.pageResults.size(), null, null, 6, null));
        }
        this.pageResults.add(checkpointPageResult);
    }

    /* compiled from: CheckpointDialog.kt */
    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0090\u0001\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001f\u001a\u00020\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010(2\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0015\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$Companion;", "", "<init>", "()V", "TAG", "", "CHECK_POINT_TAG", "INPUT_MAX_LENGTH", "", "SINGLE_SELECT_FEEDBACK_MS", "", "OTHER_OPTION_ID", "QUESTION_LINE_HEIGHT_DP", "QUESTION_COLLAPSED_FULL_LINES", "QUESTION_PARTIAL_VISIBLE_LINE_RATIO", "", "QUESTION_COLLAPSED_TEXT_LENGTH_THRESHOLD", "CLOSE_BUTTON_SHADOW_ELEVATION_DP", "CLOSE_BUTTON_LEGACY_SHADOW_ELEVATION_DP", "CLOSE_BUTTON_SHADOW_ALPHA", "dismissIfShowing", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "show", "Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;", "containerId", "planItem", "Lcom/bytedance/trae/im/model/ParsedPlanItem;", "taskId", "conversationId", "questionsJson", "pages", "", "Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;", "confirmInfo", "Lcom/bytedance/trae/im/model/ConfirmInfo;", "callback", "Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;", "onDismiss", "Lkotlin/Function0;", "onFileClick", "Lkotlin/Function1;", "resolvedPluginDisplayName", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void dismissIfShowing(FragmentManager fragmentManager) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag(CheckpointDialog.TAG);
            if (findFragmentByTag instanceof CheckpointDialog) {
                FLogger.INSTANCE.i(CheckpointDialog.CHECK_POINT_TAG, "[Dialog] dismissIfShowing: found existing, dismissing");
                ((CheckpointDialog) findFragmentByTag).dismiss();
            }
        }

        public final CheckpointDialog show(FragmentManager fragmentManager, int containerId, ParsedPlanItem planItem, String taskId, String conversationId, String questionsJson, List<CheckpointPage> pages, ConfirmInfo confirmInfo, CheckpointInteractionCallback callback, Function0<Unit> onDismiss, Function1<? super String, Unit> onFileClick, String resolvedPluginDisplayName) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(planItem, "planItem");
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            Intrinsics.checkNotNullParameter(questionsJson, "questionsJson");
            Intrinsics.checkNotNullParameter(pages, "pages");
            Intrinsics.checkNotNullParameter(callback, "callback");
            FLogger fLogger = FLogger.INSTANCE;
            StringBuilder append = new StringBuilder("[Dialog] show: containerId=").append(containerId).append(", taskId=").append(taskId).append(", pages=").append(pages.size()).append(", toolName=");
            ParsedToolCallInfo toolCallInfo = planItem.getToolCallInfo();
            fLogger.i(CheckpointDialog.CHECK_POINT_TAG, append.append(toolCallInfo != null ? toolCallInfo.getName() : null).toString());
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag(CheckpointDialog.TAG);
            if (findFragmentByTag instanceof CheckpointDialog) {
                FLogger.INSTANCE.i(CheckpointDialog.CHECK_POINT_TAG, "[Dialog] show: removing existing dialog");
                ((CheckpointDialog) findFragmentByTag).onDismissAction = null;
                fragmentManager.beginTransaction().remove(findFragmentByTag).commitNowAllowingStateLoss();
            }
            CheckpointDialog checkpointDialog = new CheckpointDialog();
            checkpointDialog.planItem = planItem;
            checkpointDialog.taskId = taskId;
            checkpointDialog.conversationId = conversationId;
            checkpointDialog.questionsJson = questionsJson;
            checkpointDialog.pages = pages;
            checkpointDialog.confirmInfo = confirmInfo;
            checkpointDialog.callback = callback;
            checkpointDialog.onDismissAction = onDismiss;
            checkpointDialog.onFileClick = onFileClick;
            checkpointDialog.setResolvedPluginDisplayName(resolvedPluginDisplayName);
            fragmentManager.beginTransaction().add(containerId, checkpointDialog, CheckpointDialog.TAG).commitNowAllowingStateLoss();
            return checkpointDialog;
        }
    }
}
