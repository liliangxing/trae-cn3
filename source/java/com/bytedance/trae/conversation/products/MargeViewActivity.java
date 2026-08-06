package com.bytedance.trae.conversation.products;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.renderer.FileTreeBottomSheetFragment;
import com.bytedance.trae.conversation.products.MergeDiffManager;
import com.bytedance.trae.im.model.FileDiffInfo;
import com.bytedance.trae.im.model.MergeChangedFilesData;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.platform.service.ApmService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* compiled from: MargeViewActivity.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J \u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J.\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00192\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\b\u0010!\u001a\u00020\u0014H\u0002J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0019H\u0002J\b\u0010$\u001a\u00020\u0014H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/trae/conversation/products/MargeViewActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "webView", "Landroid/webkit/WebView;", "progressBar", "Landroid/widget/ProgressBar;", "layoutError", "Landroid/widget/LinearLayout;", "btnRetry", "Landroid/view/View;", "ivBack", "tvTitle", "Landroid/widget/TextView;", "tvSubtitle", "diffFiles", "", "Lcom/bytedance/trae/im/model/FileDiffInfo;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "loadMergeDiffs", "chatSessionId", "", "mergeData", "Lcom/bytedance/trae/im/model/MergeChangedFilesData;", "taskName", "handleResult", "result", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;", "showError", "scrollWebViewToFile", "filePath", "onDestroy", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MargeViewActivity extends TraeCommonAppCompatActivity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EVENT_MERGE_DIFF = "merge_diff_result";
    private static final String EXTRA_CHAT_SESSION_ID = "extra_chat_session_id";
    private static final String EXTRA_MERGE_DATA_JSON = "extra_merge_data_json";
    private static final String EXTRA_TASK_NAME = "extra_task_name";
    private View btnRetry;
    private List<FileDiffInfo> diffFiles = CollectionsKt.emptyList();
    private View ivBack;
    private LinearLayout layoutError;
    private ProgressBar progressBar;
    private TextView tvSubtitle;
    private TextView tvTitle;
    private WebView webView;

    /* renamed from: com_bytedance_trae_conversation_products_MargeViewActivity__onStop$___twin___ */
    public void m850xe378f275() {
        super.onStop();
    }

    protected void onStop() {
        m849xd19494a6(this);
    }

    /* compiled from: MargeViewActivity.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/products/MargeViewActivity$Companion;", "", "<init>", "()V", "EXTRA_TASK_NAME", "", "EXTRA_CHAT_SESSION_ID", "EXTRA_MERGE_DATA_JSON", "EVENT_MERGE_DIFF", "start", "", "context", "Landroid/content/Context;", "taskName", "chatSessionId", "mergeData", "Lcom/bytedance/trae/im/model/MergeChangedFilesData;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context, String taskName, String chatSessionId, MergeChangedFilesData mergeData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(taskName, "taskName");
            Intrinsics.checkNotNullParameter(chatSessionId, "chatSessionId");
            Intrinsics.checkNotNullParameter(mergeData, "mergeData");
            String json = TraeHttpConnection.INSTANCE.getHttpGson().toJson(mergeData);
            Intent intent = new Intent(context, (Class<?>) MargeViewActivity.class);
            intent.putExtra(MargeViewActivity.EXTRA_TASK_NAME, taskName);
            intent.putExtra(MargeViewActivity.EXTRA_CHAT_SESSION_ID, chatSessionId);
            intent.putExtra(MargeViewActivity.EXTRA_MERGE_DATA_JSON, json);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onCreate(Bundle savedInstanceState) {
        Object obj;
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
        View findViewById7 = findViewById(C0637R.id.tv_subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.tvSubtitle = (TextView) findViewById7;
        ViewCompat.setOnApplyWindowInsetsListener((Toolbar) findViewById(C0637R.id.toolbar), new OnApplyWindowInsetsListener() { // from class: com.bytedance.trae.conversation.products.MargeViewActivity$$ExternalSyntheticLambda0
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat onCreate$lambda$0;
                onCreate$lambda$0 = MargeViewActivity.onCreate$lambda$0(view, windowInsetsCompat);
                return onCreate$lambda$0;
            }
        });
        View view = this.ivBack;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.MargeViewActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                MargeViewActivity.this.finish();
            }
        });
        findViewById(C0637R.id.btn_extend).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.MargeViewActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                MargeViewActivity.onCreate$lambda$3(MargeViewActivity.this, view3);
            }
        });
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.setWebChromeClient(new WebChromeClient() { // from class: com.bytedance.trae.conversation.products.MargeViewActivity$onCreate$4
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view3, int newProgress) {
                ProgressBar progressBar;
                WebView webView2;
                Intrinsics.checkNotNullParameter(view3, "view");
                if (newProgress == 100) {
                    progressBar = MargeViewActivity.this.progressBar;
                    WebView webView3 = null;
                    if (progressBar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                        progressBar = null;
                    }
                    progressBar.setVisibility(8);
                    webView2 = MargeViewActivity.this.webView;
                    if (webView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("webView");
                    } else {
                        webView3 = webView2;
                    }
                    webView3.setVisibility(0);
                }
            }
        });
        final String stringExtra = getIntent().getStringExtra(EXTRA_TASK_NAME);
        if (stringExtra == null) {
            stringExtra = "";
        }
        final String stringExtra2 = getIntent().getStringExtra(EXTRA_CHAT_SESSION_ID);
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        String stringExtra3 = getIntent().getStringExtra(EXTRA_MERGE_DATA_JSON);
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        try {
            Result.Companion companion = Result.Companion;
            MargeViewActivity margeViewActivity = this;
            obj = Result.constructor-impl((MergeChangedFilesData) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(stringExtra3, MergeChangedFilesData.class));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        final MergeChangedFilesData mergeChangedFilesData = (MergeChangedFilesData) obj;
        if (mergeChangedFilesData == null) {
            showError();
            return;
        }
        String sourceBranch = mergeChangedFilesData.getSourceBranch();
        String removePrefix = sourceBranch != null ? StringsKt.removePrefix(sourceBranch, "origin/") : null;
        if (removePrefix == null) {
            removePrefix = "";
        }
        String targetBranch = mergeChangedFilesData.getTargetBranch();
        String removePrefix2 = targetBranch != null ? StringsKt.removePrefix(targetBranch, "origin/") : null;
        String str = removePrefix2 != null ? removePrefix2 : "";
        TextView textView = this.tvTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            textView = null;
        }
        textView.setText(getString(C0637R.string.trae_chat_artifact_merge_title, new Object[]{removePrefix, str}));
        View view3 = this.btnRetry;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnRetry");
        } else {
            view2 = view3;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.MargeViewActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                MargeViewActivity.this.loadMergeDiffs(stringExtra2, mergeChangedFilesData, stringExtra);
            }
        });
        loadMergeDiffs(stringExtra2, mergeChangedFilesData, stringExtra);
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
    public static final void onCreate$lambda$3(final MargeViewActivity margeViewActivity, View view) {
        if (!margeViewActivity.diffFiles.isEmpty()) {
            FileTreeBottomSheetFragment.INSTANCE.newInstance(margeViewActivity.diffFiles, new Function1() { // from class: com.bytedance.trae.conversation.products.MargeViewActivity$$ExternalSyntheticLambda5
                public final Object invoke(Object obj) {
                    Unit onCreate$lambda$3$lambda$2;
                    onCreate$lambda$3$lambda$2 = MargeViewActivity.onCreate$lambda$3$lambda$2(MargeViewActivity.this, (String) obj);
                    return onCreate$lambda$3$lambda$2;
                }
            }).show(margeViewActivity.getSupportFragmentManager(), "FileTreeBottomSheet");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$3$lambda$2(MargeViewActivity margeViewActivity, String str) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        margeViewActivity.scrollWebViewToFile(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMergeDiffs(String chatSessionId, MergeChangedFilesData mergeData, String taskName) {
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
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new MargeViewActivity$loadMergeDiffs$1(chatSessionId, mergeData, taskName, this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleResult(final String chatSessionId, final MergeChangedFilesData mergeData, String taskName, HttpDataResult<MergeDiffManager.MergeDiffResult> result) {
        WebView webView;
        String str;
        Function0 function0 = new Function0() { // from class: com.bytedance.trae.conversation.products.MargeViewActivity$$ExternalSyntheticLambda4
            public final Object invoke() {
                JSONObject handleResult$lambda$7;
                handleResult$lambda$7 = MargeViewActivity.handleResult$lambda$7(chatSessionId, mergeData);
                return handleResult$lambda$7;
            }
        };
        if (result instanceof HttpDataResult.Success) {
            MergeDiffManager.MergeDiffResult mergeDiffResult = (MergeDiffManager.MergeDiffResult) ((HttpDataResult.Success) result).getBizResp().getData();
            if (mergeDiffResult == null) {
                try {
                    Result.Companion companion = Result.Companion;
                    ApmService apmService = ApmService.INSTANCE;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(PageDataManager.EXTRA_STATUS, "fail");
                    jSONObject.put("reason", "data_null");
                    Unit unit = Unit.INSTANCE;
                    apmService.monitorEventForSlardar(EVENT_MERGE_DIFF, jSONObject, (JSONObject) null, (JSONObject) function0.invoke());
                    Result.constructor-impl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                }
                showError();
                return;
            }
            List<DiffFile> diffFiles = mergeDiffResult.getDiffFiles();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(diffFiles, 10));
            for (DiffFile diffFile : diffFiles) {
                String newPath = diffFile.getNewPath();
                if (diffFile.isNewFile()) {
                    str = "added";
                } else {
                    if (diffFile.getNewContent().length() == 0) {
                        if (diffFile.getOldContent().length() > 0) {
                            str = "deleted";
                        }
                    }
                    str = "modified";
                }
                String str2 = str;
                arrayList.add(new FileDiffInfo(Integer.valueOf(diffFile.getInsertLineCount()), Integer.valueOf(diffFile.getDeleteLineCount()), newPath, str2, diffFile.getOldContent(), diffFile.getNewContent(), Boolean.valueOf(diffFile.isConflict()), null, 128, null));
            }
            this.diffFiles = arrayList;
            try {
                Result.Companion companion3 = Result.Companion;
                MargeViewActivity margeViewActivity = this;
                ApmService apmService2 = ApmService.INSTANCE;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(PageDataManager.EXTRA_STATUS, "success");
                Unit unit2 = Unit.INSTANCE;
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("diff_file_count", this.diffFiles.size());
                Unit unit3 = Unit.INSTANCE;
                apmService2.monitorEventForSlardar(EVENT_MERGE_DIFF, jSONObject2, jSONObject3, (JSONObject) function0.invoke());
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th2));
            }
            DiffViewerHelper diffViewerHelper = DiffViewerHelper.INSTANCE;
            WebView webView2 = this.webView;
            if (webView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView = null;
            } else {
                webView = webView2;
            }
            diffViewerHelper.showDiff(webView, this.diffFiles, mergeDiffResult.getTaskName());
            return;
        }
        if (!(result instanceof HttpDataResult.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        try {
            Result.Companion companion5 = Result.Companion;
            MargeViewActivity margeViewActivity2 = this;
            ApmService apmService3 = ApmService.INSTANCE;
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(PageDataManager.EXTRA_STATUS, "fail");
            jSONObject4.put("reason", "request_error");
            jSONObject4.put("error_code", String.valueOf(((HttpDataResult.Error) result).getCode()));
            Unit unit4 = Unit.INSTANCE;
            Object invoke = function0.invoke();
            ((JSONObject) invoke).put("error_message", ((HttpDataResult.Error) result).getMsg());
            Unit unit5 = Unit.INSTANCE;
            apmService3.monitorEventForSlardar(EVENT_MERGE_DIFF, jSONObject4, (JSONObject) null, (JSONObject) invoke);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th3) {
            Result.Companion companion6 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th3));
        }
        showError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject handleResult$lambda$7(String str, MergeChangedFilesData mergeChangedFilesData) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("chat_session_id", str);
        String sourceBranchHash = mergeChangedFilesData.getSourceBranchHash();
        if (sourceBranchHash == null) {
            sourceBranchHash = "";
        }
        jSONObject.put("source_branch_hash", sourceBranchHash);
        String targetBranchHash = mergeChangedFilesData.getTargetBranchHash();
        jSONObject.put("target_branch_hash", targetBranchHash != null ? targetBranchHash : "");
        return jSONObject;
    }

    private final void showError() {
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

    private final void scrollWebViewToFile(String filePath) {
        String replace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(filePath, "\\", "\\\\", false, 4, (Object) null), "'", "\\'", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null);
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.evaluateJavascript("scrollToFile('" + replace$default + "')", null);
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
    /* renamed from: com_bytedance_trae_conversation_products_MargeViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m849xd19494a6(MargeViewActivity margeViewActivity) {
        margeViewActivity.m850xe378f275();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) margeViewActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
