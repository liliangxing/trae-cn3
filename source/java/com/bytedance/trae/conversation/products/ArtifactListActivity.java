package com.bytedance.trae.conversation.products;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.conversation.C0637R;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: ArtifactListActivity.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J(\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\u0016\u0010\u0018\u001a\u00020\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/trae/conversation/products/ArtifactListActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;", "progressBar", "Landroid/widget/ProgressBar;", "layoutError", "Landroid/widget/LinearLayout;", "tvEmpty", "Landroid/widget/TextView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "loadArtifactList", "cliType", "", "chatSessionId", "turnId", "conversationId", "showContent", "items", "", "Lcom/bytedance/trae/conversation/products/ArtifactItem;", "showError", "getIconForFileName", "", "fileName", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArtifactListActivity extends TraeCommonAppCompatActivity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_CHAT_SESSION_ID = "extra_chat_session_id";
    private static final String EXTRA_CLI_TYPE = "extra_cli_type";
    private static final String EXTRA_CONVERSATION_ID = "extra_conversation_id";
    private static final String EXTRA_TURN_ID = "extra_turn_id";
    private ArtifactListAdapter adapter;
    private LinearLayout layoutError;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private TextView tvEmpty;

    /* renamed from: com_bytedance_trae_conversation_products_ArtifactListActivity__onStop$___twin___ */
    public void m838x65f78532() {
        super.onStop();
    }

    protected void onStop() {
        m837x9d26e409(this);
    }

    /* compiled from: ArtifactListActivity.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/products/ArtifactListActivity$Companion;", "", "<init>", "()V", "EXTRA_CHAT_SESSION_ID", "", "EXTRA_TURN_ID", "EXTRA_CLI_TYPE", "EXTRA_CONVERSATION_ID", "start", "", "context", "Landroid/content/Context;", "chatSessionId", "turnId", "cliType", "conversationId", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context, String chatSessionId, String turnId, String cliType, String conversationId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(chatSessionId, "chatSessionId");
            Intrinsics.checkNotNullParameter(turnId, "turnId");
            Intrinsics.checkNotNullParameter(cliType, "cliType");
            Intrinsics.checkNotNullParameter(conversationId, "conversationId");
            Intent intent = new Intent(context, (Class<?>) ArtifactListActivity.class);
            intent.putExtra(ArtifactListActivity.EXTRA_CHAT_SESSION_ID, chatSessionId);
            intent.putExtra(ArtifactListActivity.EXTRA_TURN_ID, turnId);
            intent.putExtra(ArtifactListActivity.EXTRA_CLI_TYPE, cliType);
            intent.putExtra("extra_conversation_id", conversationId);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0637R.layout.trae_activity_artifact_list);
        String stringExtra = getIntent().getStringExtra(EXTRA_CHAT_SESSION_ID);
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = getIntent().getStringExtra(EXTRA_TURN_ID);
        String str = stringExtra2 == null ? "" : stringExtra2;
        String stringExtra3 = getIntent().getStringExtra(EXTRA_CLI_TYPE);
        String str2 = stringExtra3 == null ? "" : stringExtra3;
        String stringExtra4 = getIntent().getStringExtra("extra_conversation_id");
        String str3 = stringExtra4 != null ? stringExtra4 : "";
        findViewById(C0637R.id.btn_back).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.ArtifactListActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtifactListActivity.this.finish();
            }
        });
        View findViewById = findViewById(C0637R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.progressBar = (ProgressBar) findViewById;
        View findViewById2 = findViewById(C0637R.id.layout_error);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.layoutError = (LinearLayout) findViewById2;
        View findViewById3 = findViewById(C0637R.id.tv_empty);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.tvEmpty = (TextView) findViewById3;
        final String str4 = stringExtra;
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        this.adapter = new ArtifactListAdapter(new Function1() { // from class: com.bytedance.trae.conversation.products.ArtifactListActivity$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit onCreate$lambda$1;
                onCreate$lambda$1 = ArtifactListActivity.onCreate$lambda$1(ArtifactListActivity.this, str4, str5, str6, str7, (ArtifactItem) obj);
                return onCreate$lambda$1;
            }
        });
        RecyclerView findViewById4 = findViewById(C0637R.id.rv_artifact_list);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        RecyclerView recyclerView = findViewById4;
        this.recyclerView = recyclerView;
        ArtifactListAdapter artifactListAdapter = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager((Context) this));
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        ArtifactListAdapter artifactListAdapter2 = this.adapter;
        if (artifactListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            artifactListAdapter = artifactListAdapter2;
        }
        recyclerView2.setAdapter(artifactListAdapter);
        final String str8 = str2;
        final String str9 = stringExtra;
        final String str10 = str;
        final String str11 = str3;
        findViewById(C0637R.id.btn_retry).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.ArtifactListActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtifactListActivity.this.loadArtifactList(str8, str9, str10, str11);
            }
        });
        loadArtifactList(str2, stringExtra, str, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onCreate$lambda$1(ArtifactListActivity artifactListActivity, String str, String str2, String str3, String str4, ArtifactItem artifactItem) {
        Intrinsics.checkNotNullParameter(artifactItem, "item");
        ArtifactPreviewActivity.INSTANCE.start((Context) artifactListActivity, (r19 & 2) != 0 ? "" : str, (r19 & 4) != 0 ? "" : str2, (r19 & 8) != 0 ? "" : str3, (r19 & 16) != 0 ? "" : artifactItem.getPath(), (r19 & 32) != 0 ? "" : null, (r19 & 64) == 0 ? str4 : "", (r19 & 128) != 0 ? 0L : 0L);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadArtifactList(String cliType, String chatSessionId, String turnId, String conversationId) {
        ProgressBar progressBar = this.progressBar;
        TextView textView = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        progressBar.setVisibility(0);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(8);
        LinearLayout linearLayout = this.layoutError;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutError");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        TextView textView2 = this.tvEmpty;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvEmpty");
        } else {
            textView = textView2;
        }
        textView.setVisibility(8);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new ArtifactListActivity$loadArtifactList$1(cliType, conversationId, this, chatSessionId, turnId, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showContent(List<ArtifactItem> items) {
        ProgressBar progressBar = this.progressBar;
        ArtifactListAdapter artifactListAdapter = null;
        TextView textView = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        LinearLayout linearLayout = this.layoutError;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutError");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        if (items.isEmpty()) {
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            recyclerView.setVisibility(8);
            TextView textView2 = this.tvEmpty;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvEmpty");
            } else {
                textView = textView2;
            }
            textView.setVisibility(0);
            return;
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setVisibility(0);
        TextView textView3 = this.tvEmpty;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvEmpty");
            textView3 = null;
        }
        textView3.setVisibility(8);
        ArtifactListAdapter artifactListAdapter2 = this.adapter;
        if (artifactListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            artifactListAdapter = artifactListAdapter2;
        }
        artifactListAdapter.submitList(items);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showError() {
        ProgressBar progressBar = this.progressBar;
        LinearLayout linearLayout = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(8);
        TextView textView = this.tvEmpty;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvEmpty");
            textView = null;
        }
        textView.setVisibility(8);
        LinearLayout linearLayout2 = this.layoutError;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutError");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.ic_artifact_ppt;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
    
        if (r3.equals("jpeg") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.ic_artifact_png;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
    
        if (r3.equals("java") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.ic_artifact_code;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        if (r3.equals("html") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0064, code lost:
    
        if (r3.equals("docx") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.ic_artifact_doc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007e, code lost:
    
        if (r3.equals("xls") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0089, code lost:
    
        if (r3.equals("wav") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.ic_artifact_vedio;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a2, code lost:
    
        if (r3.equals("ppt") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b0, code lost:
    
        if (r3.equals("png") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0024, code lost:
    
        if (r3.equals("xlsx") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c8, code lost:
    
        if (r3.equals("mov") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.ic_artifact_vedio;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d2, code lost:
    
        if (r3.equals("mp4") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00dc, code lost:
    
        if (r3.equals("mp3") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ea, code lost:
    
        if (r3.equals("jpg") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00f8, code lost:
    
        if (r3.equals("elx") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0106, code lost:
    
        if (r3.equals(com.bytedance.trae.im.model.MessagePart.TYPE_DOC) == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0114, code lost:
    
        if (r3.equals("css") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x011e, code lost:
    
        if (r3.equals("cpp") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.ic_artifact_excel;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0128, code lost:
    
        if (r3.equals("avi") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0135, code lost:
    
        if (r3.equals("ts") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x013e, code lost:
    
        if (r3.equals("py") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0153, code lost:
    
        if (r3.equals("kt") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x015c, code lost:
    
        if (r3.equals("js") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0165, code lost:
    
        if (r3.equals("go") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x016e, code lost:
    
        if (r3.equals("c") == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002e, code lost:
    
        if (r3.equals("pptx") == false) goto L111;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0018. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int getIconForFileName(String fileName) {
        String lowerCase = StringsKt.substringAfterLast(fileName, '.', "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -900562878:
                if (lowerCase.equals("skills")) {
                    return C0637R.drawable.ic_artifact_skill;
                }
                return C0637R.drawable.ic_artifact_custom;
            case 99:
                break;
            case 3304:
                break;
            case 3401:
                break;
            case 3433:
                break;
            case 3479:
                if (lowerCase.equals("md")) {
                    return C0637R.drawable.ic_artifact_markdown;
                }
                return C0637R.drawable.ic_artifact_custom;
            case 3593:
                break;
            case 3711:
                break;
            case 96980:
                break;
            case 98723:
                break;
            case 98819:
                break;
            case 99640:
                break;
            case 100529:
                break;
            case 105441:
                break;
            case 108272:
                break;
            case 108273:
                break;
            case 108308:
                break;
            case 110834:
                if (lowerCase.equals("pdf")) {
                    return C0637R.drawable.ic_artifact_pdf;
                }
                return C0637R.drawable.ic_artifact_custom;
            case 111145:
                break;
            case 111220:
                break;
            case 115312:
                if (lowerCase.equals("txt")) {
                    return C0637R.drawable.ic_artifact_txt;
                }
                return C0637R.drawable.ic_artifact_custom;
            case 117484:
                break;
            case 118783:
                break;
            case 120609:
                if (lowerCase.equals("zip")) {
                    return C0637R.drawable.ic_artifact_zip;
                }
                return C0637R.drawable.ic_artifact_custom;
            case 3088960:
                break;
            case 3213227:
                break;
            case 3254818:
                break;
            case 3268712:
                break;
            case 3271912:
                if (lowerCase.equals("json")) {
                    return C0637R.drawable.ic_artifact_json;
                }
                return C0637R.drawable.ic_artifact_custom;
            case 3447940:
                break;
            case 3682393:
                break;
            default:
                return C0637R.drawable.ic_artifact_custom;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_conversation_products_ArtifactListActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m837x9d26e409(ArtifactListActivity artifactListActivity) {
        artifactListActivity.m838x65f78532();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) artifactListActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
