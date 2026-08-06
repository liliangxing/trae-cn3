package com.bytedance.trae.conversation.products;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.renderer.ArtifactTrack;
import com.bytedance.trae.im.model.ChangedFileData;
import com.bytedance.trae.im.model.FileDiffInfo;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.network.TraeHttpConnection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: CodeChangedListActivity.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J@\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onFileItemClick", MessagePart.TYPE_FILE, "Lcom/bytedance/trae/im/model/FileDiffInfo;", "chatSessionId", "", "turnId", "cliType", "messageId", "conversationId", "createdTime", "", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CodeChangedListActivity extends TraeCommonAppCompatActivity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_CHANGED_FILE_DATA_JSON = "extra_changed_file_data_json";
    private static final String EXTRA_CHAT_SESSION_ID = "extra_chat_session_id";
    private static final String EXTRA_CLI_TYPE = "extra_cli_type";
    private static final String EXTRA_CONVERSATION_ID = "extra_conversation_id";
    private static final String EXTRA_CREATED_TIME = "extra_created_time";
    private static final String EXTRA_MESSAGE_ID = "extra_message_id";
    private static final String EXTRA_TURN_ID = "extra_turn_id";

    /* renamed from: com_bytedance_trae_conversation_products_CodeChangedListActivity__onStop$___twin___ */
    public void m842x7fd3fab1() {
        super.onStop();
    }

    protected void onStop() {
        m841xc65b41ea(this);
    }

    /* compiled from: CodeChangedListActivity.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JR\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$Companion;", "", "<init>", "()V", "EXTRA_CHANGED_FILE_DATA_JSON", "", "EXTRA_CHAT_SESSION_ID", "EXTRA_TURN_ID", "EXTRA_CLI_TYPE", "EXTRA_MESSAGE_ID", "EXTRA_CONVERSATION_ID", "EXTRA_CREATED_TIME", "start", "", "context", "Landroid/content/Context;", "changedFileData", "Lcom/bytedance/trae/im/model/ChangedFileData;", "chatSessionId", "turnId", "cliType", "messageId", "conversationId", "createdTime", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context, ChangedFileData changedFileData, String chatSessionId, String turnId, String cliType, String messageId, String conversationId, long createdTime) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(changedFileData, "changedFileData");
            Intrinsics.checkNotNullParameter(chatSessionId, "chatSessionId");
            Intrinsics.checkNotNullParameter(turnId, "turnId");
            Intrinsics.checkNotNullParameter(cliType, "cliType");
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            Intrinsics.checkNotNullParameter(conversationId, "conversationId");
            String json = TraeHttpConnection.INSTANCE.getHttpGson().toJson(changedFileData);
            Intent intent = new Intent(context, (Class<?>) CodeChangedListActivity.class);
            intent.putExtra(CodeChangedListActivity.EXTRA_CHANGED_FILE_DATA_JSON, json);
            intent.putExtra(CodeChangedListActivity.EXTRA_CHAT_SESSION_ID, chatSessionId);
            intent.putExtra(CodeChangedListActivity.EXTRA_TURN_ID, turnId);
            intent.putExtra(CodeChangedListActivity.EXTRA_CLI_TYPE, cliType);
            intent.putExtra(CodeChangedListActivity.EXTRA_MESSAGE_ID, messageId);
            intent.putExtra("extra_conversation_id", conversationId);
            intent.putExtra(CodeChangedListActivity.EXTRA_CREATED_TIME, createdTime);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onCreate(Bundle savedInstanceState) {
        ChangedFileData changedFileData;
        super.onCreate(savedInstanceState);
        setContentView(C0637R.layout.trae_activity_code_changed_list);
        String stringExtra = getIntent().getStringExtra(EXTRA_CHANGED_FILE_DATA_JSON);
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = getIntent().getStringExtra(EXTRA_CHAT_SESSION_ID);
        final String str = stringExtra2 == null ? "" : stringExtra2;
        String stringExtra3 = getIntent().getStringExtra(EXTRA_TURN_ID);
        final String str2 = stringExtra3 == null ? "" : stringExtra3;
        String stringExtra4 = getIntent().getStringExtra(EXTRA_CLI_TYPE);
        final String str3 = stringExtra4 == null ? "" : stringExtra4;
        String stringExtra5 = getIntent().getStringExtra(EXTRA_MESSAGE_ID);
        final String str4 = stringExtra5 == null ? "" : stringExtra5;
        String stringExtra6 = getIntent().getStringExtra("extra_conversation_id");
        final String str5 = stringExtra6 == null ? "" : stringExtra6;
        final long longExtra = getIntent().getLongExtra(EXTRA_CREATED_TIME, 0L);
        try {
            changedFileData = (ChangedFileData) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(stringExtra, ChangedFileData.class);
        } catch (Exception unused) {
            changedFileData = null;
        }
        List<FileDiffInfo> fileDiffInfos = changedFileData != null ? changedFileData.getFileDiffInfos() : null;
        if (fileDiffInfos == null) {
            fileDiffInfos = CollectionsKt.emptyList();
        }
        int size = fileDiffInfos.size();
        findViewById(C0637R.id.btn_back).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.products.CodeChangedListActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CodeChangedListActivity.this.finish();
            }
        });
        ((TextView) findViewById(C0637R.id.tv_title)).setText(getString(C0637R.string.trae_chat_artifact_code_files, new Object[]{Integer.valueOf(size)}));
        RecyclerView findViewById = findViewById(C0637R.id.rv_code_changed_list);
        findViewById.setLayoutManager(new LinearLayoutManager((Context) this));
        CodeChangedListAdapter codeChangedListAdapter = new CodeChangedListAdapter(new Function1() { // from class: com.bytedance.trae.conversation.products.CodeChangedListActivity$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit onCreate$lambda$1;
                onCreate$lambda$1 = CodeChangedListActivity.onCreate$lambda$1(CodeChangedListActivity.this, str, str2, str3, str4, str5, longExtra, (FileDiffInfo) obj);
                return onCreate$lambda$1;
            }
        });
        findViewById.setAdapter(codeChangedListAdapter);
        codeChangedListAdapter.submitList(fileDiffInfos);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1(CodeChangedListActivity codeChangedListActivity, String str, String str2, String str3, String str4, String str5, long j, FileDiffInfo fileDiffInfo) {
        Intrinsics.checkNotNullParameter(fileDiffInfo, MessagePart.TYPE_FILE);
        codeChangedListActivity.onFileItemClick(fileDiffInfo, str, str2, str3, str4, str5, j);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void onFileItemClick(FileDiffInfo file, String chatSessionId, String turnId, String cliType, String messageId, String conversationId, long createdTime) {
        String filePath = file.getFilePath();
        String str = filePath;
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            try {
                ArtifactTrack.INSTANCE.trackArtifactClick(filePath, messageId);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
        }
        if (Intrinsics.areEqual(cliType, CliType.LOCAL.getValue())) {
            filePath = (StringsKt.startsWith$default(filePath, "/", false, 2, (Object) null) ? new StringBuilder("files") : new StringBuilder("files/")).append(filePath).toString();
        }
        ArtifactPreviewActivity.INSTANCE.start((Context) this, chatSessionId, turnId, cliType, filePath, messageId, conversationId, createdTime);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_conversation_products_CodeChangedListActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m841xc65b41ea(CodeChangedListActivity codeChangedListActivity) {
        codeChangedListActivity.m842x7fd3fab1();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) codeChangedListActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
