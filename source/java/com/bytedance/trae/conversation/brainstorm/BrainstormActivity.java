package com.bytedance.trae.conversation.brainstorm;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.common.widget.CustomConfirmDialog;
import com.bytedance.trae.conversation.AccountSettingsKeva;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment;
import com.bytedance.trae.conversation.brainstorm.fragment.IntroFragment;
import com.bytedance.trae.conversation.brainstorm.health.VoiceCheckTrigger;
import com.bytedance.trae.conversation.brainstorm.health.VoiceExceptionGuard;
import com.bytedance.trae.conversation.brainstorm.health.VoicePrompt;
import com.bytedance.trae.conversation.brainstorm.health.VoicePromptCenter;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormPhase;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState;
import com.bytedance.trae.conversation.tracker.AsrDiscussAction;
import com.bytedance.trae.conversation.tracker.TraeAITracker;
import com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptSignal;
import com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptStage;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.Mode;
import com.bytedance.trae.im.service.Source;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
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

/* compiled from: BrainstormActivity.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\u0006\u0010\u0019\u001a\u00020\u0012J\b\u0010\u001a\u001a\u00020\u0012H\u0014J\b\u0010\u001b\u001a\u00020\u0012H\u0014J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\b\u0010\u001e\u001a\u00020\u0012H\u0002J\u0006\u0010\u001f\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000f \u0010*\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "viewModel", "Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;", "value", "", "isRestoredFromMinimized", "()Z", "isMinimizeDisabled", "pendingAutoStartAfterPermission", "permissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "kotlin.jvm.PlatformType", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "observeMinimizeRequested", "requestRequiredPermissions", "hasRequiredPermissions", "startPendingDiscussionIfNeeded", "requestVoicePermissions", "onResume", "onDestroy", "observePhaseNavigation", "observeBrainstormEnded", "setupBackHandler", "showExitConfirmDialog", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormActivity extends TraeCommonAppCompatActivity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean DEBUG_ALWAYS_SHOW_INTRO = false;
    public static final String EXTRA_ATTACHMENT_SUBTASK_ENABLED = "extra_attachment_sub_task_enabled";
    public static final String EXTRA_ATTEMPT_ACTIVITY_LAUNCH_REQUESTED_MS = "extra_voice_discussion_attempt_activity_launch_requested_ms";
    public static final String EXTRA_ATTEMPT_CLICK_MS = "extra_voice_discussion_attempt_click_ms";
    public static final String EXTRA_ATTEMPT_ELIGIBILITY_PASSED_MS = "extra_voice_discussion_attempt_eligibility_passed_ms";
    public static final String EXTRA_ATTEMPT_ID = "extra_voice_discussion_attempt_id";
    public static final String EXTRA_ATTEMPT_START_ELAPSED_MS = "extra_voice_discussion_attempt_start_elapsed_ms";
    public static final String EXTRA_CLI_CONVERSATION_ID = "extra_session_id";
    public static final String EXTRA_CLI_ID = "extra_sub_task_cli_id";
    public static final String EXTRA_CLI_TYPE = "extra_sub_task_cli_type";
    public static final String EXTRA_CREATE_REMOTE_PARENT_SESSION = "extra_create_remote_parent_session";
    public static final String EXTRA_MESSAGES_TEXT = "extra_messages_text";
    public static final String EXTRA_MIC_CHECK_END_MS = "extra_mic_check_end_ms";
    public static final String EXTRA_MIC_CHECK_START_MS = "extra_mic_check_start_ms";
    public static final String EXTRA_MINIMIZE_DISABLED = "extra_minimize_disabled";
    public static final String EXTRA_MODE = "extra_sub_task_mode";
    public static final String EXTRA_PARENT_AGENT_TYPE = "extra_sub_task_parent_agent_type";
    public static final String EXTRA_PARENT_CONVERSATION_ID = "extra_parent_conversation_id";
    public static final String EXTRA_RESTORE_FROM_HOLDER = "extra_restore_from_holder";
    public static final String EXTRA_SOURCE_BRANCH_NAME = "extra_source_branch_name";
    public static final String EXTRA_SOURCE_REPO_NAME = "extra_source_repo_name";
    public static final String EXTRA_SOURCE_REPO_URL = "extra_source_repo_url";
    public static final String EXTRA_WORKSPACE_DIR = "extra_sub_task_workspace_dir";
    private static final String KEY_HAS_SEEN_INTRO = "brainstorm_has_seen_intro";
    private static final String SOURCE_TYPE_GITHUB = "github";
    private static final String TAG = "BrainstormActivity";
    private boolean isMinimizeDisabled;
    private boolean isRestoredFromMinimized;
    private boolean pendingAutoStartAfterPermission;
    private final ActivityResultLauncher<String[]> permissionLauncher;
    private BrainstormViewModel viewModel;

    /* renamed from: com_bytedance_trae_conversation_brainstorm_BrainstormActivity__onStop$___twin___ */
    public void m818x448af17e() {
        super.onStop();
    }

    protected void onStop() {
        m817x2d0d773d(this);
    }

    public BrainstormActivity() {
        ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormActivity$$ExternalSyntheticLambda0
            public final void onActivityResult(Object obj) {
                BrainstormActivity.permissionLauncher$lambda$0(BrainstormActivity.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.permissionLauncher = registerForActivityResult;
    }

    /* compiled from: BrainstormActivity.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010 \u001a\u00020\u001fH\u0000¢\u0006\u0002\b!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$Companion;", "", "<init>", "()V", "TAG", "", "EXTRA_CLI_CONVERSATION_ID", "EXTRA_PARENT_CONVERSATION_ID", "EXTRA_CREATE_REMOTE_PARENT_SESSION", "EXTRA_MESSAGES_TEXT", "EXTRA_MIC_CHECK_START_MS", "EXTRA_MIC_CHECK_END_MS", "EXTRA_ATTEMPT_ID", "EXTRA_ATTEMPT_START_ELAPSED_MS", "EXTRA_ATTEMPT_CLICK_MS", "EXTRA_ATTEMPT_ELIGIBILITY_PASSED_MS", "EXTRA_ATTEMPT_ACTIVITY_LAUNCH_REQUESTED_MS", "EXTRA_RESTORE_FROM_HOLDER", "EXTRA_CLI_ID", "EXTRA_CLI_TYPE", "EXTRA_MODE", "EXTRA_PARENT_AGENT_TYPE", "EXTRA_WORKSPACE_DIR", "EXTRA_SOURCE_REPO_URL", "EXTRA_SOURCE_REPO_NAME", "EXTRA_SOURCE_BRANCH_NAME", "EXTRA_ATTACHMENT_SUBTASK_ENABLED", "EXTRA_MINIMIZE_DISABLED", "KEY_HAS_SEEN_INTRO", "SOURCE_TYPE_GITHUB", "DEBUG_ALWAYS_SHOW_INTRO", "", "hasSeenIntro", "hasSeenIntro$conversation_mainlandRelease", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean hasSeenIntro$conversation_mainlandRelease() {
            return AccountSettingsKeva.INSTANCE.getKeva().getBoolean(BrainstormActivity.KEY_HAS_SEEN_INTRO, false);
        }
    }

    /* renamed from: isRestoredFromMinimized, reason: from getter */
    public final boolean getIsRestoredFromMinimized() {
        return this.isRestoredFromMinimized;
    }

    /* renamed from: isMinimizeDisabled, reason: from getter */
    public final boolean getIsMinimizeDisabled() {
        return this.isMinimizeDisabled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void permissionLauncher$lambda$0(BrainstormActivity brainstormActivity, Map map) {
        BrainstormViewModel brainstormViewModel;
        BrainstormViewModel brainstormViewModel2;
        Intrinsics.checkNotNull(map);
        for (Map.Entry entry : map.entrySet()) {
            FLogger.INSTANCE.d(TAG, "Permission result: " + ((String) entry.getKey()) + " = " + ((Boolean) entry.getValue()).booleanValue());
        }
        BrainstormViewModel brainstormViewModel3 = null;
        if (brainstormActivity.hasRequiredPermissions()) {
            BrainstormViewModel brainstormViewModel4 = brainstormActivity.viewModel;
            if (brainstormViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                brainstormViewModel3 = brainstormViewModel4;
            }
            brainstormViewModel3.recordVoiceAttemptStage(VoiceDiscussionAttemptStage.PERMISSION_GRANTED);
            brainstormActivity.startPendingDiscussionIfNeeded();
            return;
        }
        if (brainstormActivity.pendingAutoStartAfterPermission) {
            BrainstormViewModel brainstormViewModel5 = brainstormActivity.viewModel;
            if (brainstormViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                brainstormViewModel2 = null;
            } else {
                brainstormViewModel2 = brainstormViewModel5;
            }
            BrainstormViewModel.recordVoiceAttemptSignal$default(brainstormViewModel2, VoiceDiscussionAttemptSignal.PERMISSION_DENIED, null, 0, 6, null);
            ViewGroup viewGroup = (ViewGroup) brainstormActivity.findViewById(R.id.content);
            if (viewGroup == null) {
                return;
            }
            VoicePromptCenter.INSTANCE.enqueue(viewGroup, VoicePrompt.Runtime.MicPermissionDeniedRuntime.INSTANCE);
            return;
        }
        BrainstormViewModel brainstormViewModel6 = brainstormActivity.viewModel;
        if (brainstormViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            brainstormViewModel = null;
        } else {
            brainstormViewModel = brainstormViewModel6;
        }
        BrainstormViewModel.recordVoiceAttemptSignal$default(brainstormViewModel, VoiceDiscussionAttemptSignal.PERMISSION_DENIED, null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x013c, code lost:
    
        if (r0 != null) goto L46;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0297  */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle savedInstanceState) {
        boolean z;
        Object obj;
        CliType cliType;
        Mode mode;
        boolean z2;
        long j;
        Source source;
        BrainstormViewModel brainstormViewModel;
        BrainstormViewModel brainstormViewModel2;
        BrainstormViewModel brainstormViewModel3;
        BrainstormViewModel brainstormViewModel4;
        BrainstormViewModel brainstormViewModel5;
        BrainstormViewModel brainstormViewModel6;
        long j2;
        long j3;
        BrainstormViewModel brainstormViewModel7;
        BrainstormViewModel brainstormViewModel8;
        String stringExtra;
        String stringExtra2;
        String stringExtra3;
        Object obj2;
        super.onCreate(savedInstanceState);
        String stringExtra4 = getIntent().getStringExtra(EXTRA_CLI_CONVERSATION_ID);
        String stringExtra5 = getIntent().getStringExtra(EXTRA_PARENT_CONVERSATION_ID);
        String str = (stringExtra5 == null || !(StringsKt.isBlank(stringExtra5) ^ true)) ? null : stringExtra5;
        boolean z3 = false;
        boolean booleanExtra = getIntent().getBooleanExtra(EXTRA_CREATE_REMOTE_PARENT_SESSION, false);
        long longExtra = getIntent().getLongExtra(EXTRA_MIC_CHECK_START_MS, 0L);
        long longExtra2 = getIntent().getLongExtra(EXTRA_MIC_CHECK_END_MS, 0L);
        String stringExtra6 = getIntent().getStringExtra(EXTRA_ATTEMPT_ID);
        if (stringExtra6 == null) {
            stringExtra6 = "";
        }
        String str2 = stringExtra6;
        long longExtra3 = getIntent().getLongExtra(EXTRA_ATTEMPT_START_ELAPSED_MS, 0L);
        long longExtra4 = getIntent().getLongExtra(EXTRA_ATTEMPT_CLICK_MS, -1L);
        long longExtra5 = getIntent().getLongExtra(EXTRA_ATTEMPT_ELIGIBILITY_PASSED_MS, -1L);
        long longExtra6 = getIntent().getLongExtra(EXTRA_ATTEMPT_ACTIVITY_LAUNCH_REQUESTED_MS, -1L);
        boolean booleanExtra2 = getIntent().getBooleanExtra(EXTRA_ATTACHMENT_SUBTASK_ENABLED, true);
        boolean z4 = getIntent().getBooleanExtra(EXTRA_RESTORE_FROM_HOLDER, false) && BrainstormSessionHolder.INSTANCE.isMinimized();
        this.isMinimizeDisabled = getIntent().getBooleanExtra(EXTRA_MINIMIZE_DISABLED, false);
        setContentView(C0637R.layout.trae_activity_brainstorm);
        getWindow().addFlags(128);
        this.viewModel = new ViewModelProvider((ViewModelStoreOwner) this).get(BrainstormViewModel.class);
        if (z4) {
            BrainstormSessionHolder brainstormSessionHolder = BrainstormSessionHolder.INSTANCE;
            BrainstormViewModel brainstormViewModel9 = this.viewModel;
            if (brainstormViewModel9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                brainstormViewModel9 = null;
            }
            z3 = brainstormSessionHolder.restoreToViewModel$conversation_mainlandRelease(brainstormViewModel9);
            if (!z3) {
                FLogger.INSTANCE.w(TAG, "wantRestore but holder.restoreToViewModel returned false; fallback to fresh start");
            }
        }
        boolean z5 = z3;
        this.isRestoredFromMinimized = z5;
        if (z5) {
            z = z5;
        } else {
            String stringExtra7 = getIntent().getStringExtra(EXTRA_CLI_ID);
            String str3 = (stringExtra7 == null || !(StringsKt.isBlank(stringExtra7) ^ true)) ? null : stringExtra7;
            String stringExtra8 = getIntent().getStringExtra(EXTRA_CLI_TYPE);
            if (stringExtra8 != null) {
                try {
                    Result.Companion companion = Result.Companion;
                    BrainstormActivity brainstormActivity = this;
                    obj = Result.constructor-impl(CliType.valueOf(stringExtra8));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                cliType = (CliType) obj;
            }
            cliType = CliType.LOCAL;
            CliType cliType2 = cliType;
            String stringExtra9 = getIntent().getStringExtra(EXTRA_MODE);
            if (stringExtra9 != null) {
                Iterator it = Mode.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    } else {
                        obj2 = it.next();
                        if (Intrinsics.areEqual(((Mode) obj2).getValue(), stringExtra9)) {
                            break;
                        }
                    }
                }
                Mode mode2 = (Mode) obj2;
                if (mode2 != null) {
                    mode = mode2;
                    String stringExtra10 = getIntent().getStringExtra(EXTRA_PARENT_AGENT_TYPE);
                    String str4 = (stringExtra10 == null && (StringsKt.isBlank(stringExtra10) ^ true)) ? stringExtra10 : null;
                    String stringExtra11 = getIntent().getStringExtra(EXTRA_WORKSPACE_DIR);
                    String str5 = (stringExtra11 == null && (StringsKt.isBlank(stringExtra11) ^ true)) ? stringExtra11 : null;
                    boolean hasSeenIntro$conversation_mainlandRelease = INSTANCE.hasSeenIntro$conversation_mainlandRelease();
                    if (cliType2 == CliType.REMOTE && mode == Mode.CODE) {
                        stringExtra = getIntent().getStringExtra(EXTRA_SOURCE_REPO_URL);
                        if (stringExtra != null || !(!StringsKt.isBlank(stringExtra))) {
                            stringExtra = null;
                        }
                        stringExtra2 = getIntent().getStringExtra(EXTRA_SOURCE_BRANCH_NAME);
                        if (stringExtra2 != null || !(!StringsKt.isBlank(stringExtra2))) {
                            stringExtra2 = null;
                        }
                        if (stringExtra != null && stringExtra2 != null) {
                            z2 = z5;
                            stringExtra3 = getIntent().getStringExtra(EXTRA_SOURCE_REPO_NAME);
                            if (stringExtra3 != null || !(!StringsKt.isBlank(stringExtra3))) {
                                stringExtra3 = null;
                            }
                            j = longExtra2;
                            source = new Source(stringExtra, stringExtra3, stringExtra2, "github");
                            brainstormViewModel = this.viewModel;
                            if (brainstormViewModel == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                brainstormViewModel = null;
                            }
                            z = z2;
                            long j4 = j;
                            brainstormViewModel.initVoiceSession((Context) this, stringExtra4, str, booleanExtra, str3, cliType2, mode, str4, str5, source, booleanExtra2);
                            brainstormViewModel2 = this.viewModel;
                            if (brainstormViewModel2 != null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                brainstormViewModel3 = null;
                            } else {
                                brainstormViewModel3 = brainstormViewModel2;
                            }
                            brainstormViewModel3.initVoiceAttempt(str2, longExtra3, hasSeenIntro$conversation_mainlandRelease, longExtra4, longExtra5, longExtra6);
                            brainstormViewModel4 = this.viewModel;
                            if (brainstormViewModel4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                brainstormViewModel4 = null;
                            }
                            brainstormViewModel4.recordVoiceAttemptStage(VoiceDiscussionAttemptStage.ACTIVITY_SHOWN);
                            if (!hasRequiredPermissions()) {
                                BrainstormViewModel brainstormViewModel10 = this.viewModel;
                                if (brainstormViewModel10 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                    brainstormViewModel10 = null;
                                }
                                brainstormViewModel10.recordVoiceAttemptStage(VoiceDiscussionAttemptStage.PERMISSION_GRANTED);
                            } else {
                                BrainstormViewModel brainstormViewModel11 = this.viewModel;
                                if (brainstormViewModel11 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                    brainstormViewModel5 = null;
                                } else {
                                    brainstormViewModel5 = brainstormViewModel11;
                                }
                                BrainstormViewModel.recordVoiceAttemptSignal$default(brainstormViewModel5, VoiceDiscussionAttemptSignal.PERMISSION_DENIED, null, 0, 6, null);
                            }
                            brainstormViewModel6 = this.viewModel;
                            if (brainstormViewModel6 != null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                j2 = j4;
                                j3 = longExtra;
                                brainstormViewModel6 = null;
                            } else {
                                j2 = j4;
                                j3 = longExtra;
                            }
                            brainstormViewModel6.setPerfMicCheckTimestamps(j3, j2);
                            if (savedInstanceState == null) {
                                if (hasSeenIntro$conversation_mainlandRelease) {
                                    boolean hasRequiredPermissions = hasRequiredPermissions();
                                    this.pendingAutoStartAfterPermission = !hasRequiredPermissions;
                                    getSupportFragmentManager().beginTransaction().replace(C0637R.id.brainstorm_fragment_container, new DiscussingFragment()).commitNow();
                                    BrainstormViewModel brainstormViewModel12 = this.viewModel;
                                    if (brainstormViewModel12 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                        brainstormViewModel8 = null;
                                    } else {
                                        brainstormViewModel8 = brainstormViewModel12;
                                    }
                                    brainstormViewModel8.skipIntroAndStartBrainstorm(hasRequiredPermissions);
                                } else {
                                    BrainstormViewModel brainstormViewModel13 = this.viewModel;
                                    if (brainstormViewModel13 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                        brainstormViewModel7 = null;
                                    } else {
                                        brainstormViewModel7 = brainstormViewModel13;
                                    }
                                    brainstormViewModel7.recordVoiceAttemptStage(VoiceDiscussionAttemptStage.INTRO_SHOWN);
                                    getSupportFragmentManager().beginTransaction().replace(C0637R.id.brainstorm_fragment_container, new IntroFragment()).commitNow();
                                }
                            }
                        }
                    }
                    z2 = z5;
                    j = longExtra2;
                    source = null;
                    brainstormViewModel = this.viewModel;
                    if (brainstormViewModel == null) {
                    }
                    z = z2;
                    long j42 = j;
                    brainstormViewModel.initVoiceSession((Context) this, stringExtra4, str, booleanExtra, str3, cliType2, mode, str4, str5, source, booleanExtra2);
                    brainstormViewModel2 = this.viewModel;
                    if (brainstormViewModel2 != null) {
                    }
                    brainstormViewModel3.initVoiceAttempt(str2, longExtra3, hasSeenIntro$conversation_mainlandRelease, longExtra4, longExtra5, longExtra6);
                    brainstormViewModel4 = this.viewModel;
                    if (brainstormViewModel4 == null) {
                    }
                    brainstormViewModel4.recordVoiceAttemptStage(VoiceDiscussionAttemptStage.ACTIVITY_SHOWN);
                    if (!hasRequiredPermissions()) {
                    }
                    brainstormViewModel6 = this.viewModel;
                    if (brainstormViewModel6 != null) {
                    }
                    brainstormViewModel6.setPerfMicCheckTimestamps(j3, j2);
                    if (savedInstanceState == null) {
                    }
                }
            }
            mode = Mode.WORK;
            String stringExtra102 = getIntent().getStringExtra(EXTRA_PARENT_AGENT_TYPE);
            if (stringExtra102 == null) {
            }
            String stringExtra112 = getIntent().getStringExtra(EXTRA_WORKSPACE_DIR);
            if (stringExtra112 == null) {
            }
            boolean hasSeenIntro$conversation_mainlandRelease2 = INSTANCE.hasSeenIntro$conversation_mainlandRelease();
            if (cliType2 == CliType.REMOTE) {
                stringExtra = getIntent().getStringExtra(EXTRA_SOURCE_REPO_URL);
                if (stringExtra != null) {
                }
                stringExtra = null;
                stringExtra2 = getIntent().getStringExtra(EXTRA_SOURCE_BRANCH_NAME);
                if (stringExtra2 != null) {
                }
                stringExtra2 = null;
                if (stringExtra != null) {
                    z2 = z5;
                    stringExtra3 = getIntent().getStringExtra(EXTRA_SOURCE_REPO_NAME);
                    if (stringExtra3 != null) {
                    }
                    stringExtra3 = null;
                    j = longExtra2;
                    source = new Source(stringExtra, stringExtra3, stringExtra2, "github");
                    brainstormViewModel = this.viewModel;
                    if (brainstormViewModel == null) {
                    }
                    z = z2;
                    long j422 = j;
                    brainstormViewModel.initVoiceSession((Context) this, stringExtra4, str, booleanExtra, str3, cliType2, mode, str4, str5, source, booleanExtra2);
                    brainstormViewModel2 = this.viewModel;
                    if (brainstormViewModel2 != null) {
                    }
                    brainstormViewModel3.initVoiceAttempt(str2, longExtra3, hasSeenIntro$conversation_mainlandRelease2, longExtra4, longExtra5, longExtra6);
                    brainstormViewModel4 = this.viewModel;
                    if (brainstormViewModel4 == null) {
                    }
                    brainstormViewModel4.recordVoiceAttemptStage(VoiceDiscussionAttemptStage.ACTIVITY_SHOWN);
                    if (!hasRequiredPermissions()) {
                    }
                    brainstormViewModel6 = this.viewModel;
                    if (brainstormViewModel6 != null) {
                    }
                    brainstormViewModel6.setPerfMicCheckTimestamps(j3, j2);
                    if (savedInstanceState == null) {
                    }
                }
            }
            z2 = z5;
            j = longExtra2;
            source = null;
            brainstormViewModel = this.viewModel;
            if (brainstormViewModel == null) {
            }
            z = z2;
            long j4222 = j;
            brainstormViewModel.initVoiceSession((Context) this, stringExtra4, str, booleanExtra, str3, cliType2, mode, str4, str5, source, booleanExtra2);
            brainstormViewModel2 = this.viewModel;
            if (brainstormViewModel2 != null) {
            }
            brainstormViewModel3.initVoiceAttempt(str2, longExtra3, hasSeenIntro$conversation_mainlandRelease2, longExtra4, longExtra5, longExtra6);
            brainstormViewModel4 = this.viewModel;
            if (brainstormViewModel4 == null) {
            }
            brainstormViewModel4.recordVoiceAttemptStage(VoiceDiscussionAttemptStage.ACTIVITY_SHOWN);
            if (!hasRequiredPermissions()) {
            }
            brainstormViewModel6 = this.viewModel;
            if (brainstormViewModel6 != null) {
            }
            brainstormViewModel6.setPerfMicCheckTimestamps(j3, j2);
            if (savedInstanceState == null) {
            }
        }
        requestRequiredPermissions();
        observePhaseNavigation();
        observeBrainstormEnded();
        observeMinimizeRequested();
        setupBackHandler();
        if (z) {
            return;
        }
        BrainstormSessionHolder.INSTANCE.markActiveForeground();
    }

    private final void observeMinimizeRequested() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new BrainstormActivity$observeMinimizeRequested$1(this, null), 3, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void requestRequiredPermissions() {
        BrainstormPermissionHelper.INSTANCE.requestPermissions((Context) this, this.permissionLauncher, new Function0() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormActivity$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit requestRequiredPermissions$lambda$13;
                requestRequiredPermissions$lambda$13 = BrainstormActivity.requestRequiredPermissions$lambda$13(BrainstormActivity.this);
                return requestRequiredPermissions$lambda$13;
            }
        }, new Function0() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormActivity$$ExternalSyntheticLambda3
            public final Object invoke() {
                Unit requestRequiredPermissions$lambda$14;
                requestRequiredPermissions$lambda$14 = BrainstormActivity.requestRequiredPermissions$lambda$14(BrainstormActivity.this);
                return requestRequiredPermissions$lambda$14;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestRequiredPermissions$lambda$13(BrainstormActivity brainstormActivity) {
        BrainstormViewModel brainstormViewModel = brainstormActivity.viewModel;
        if (brainstormViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            brainstormViewModel = null;
        }
        brainstormViewModel.recordVoiceAttemptStage(VoiceDiscussionAttemptStage.PERMISSION_GRANTED);
        brainstormActivity.startPendingDiscussionIfNeeded();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestRequiredPermissions$lambda$14(BrainstormActivity brainstormActivity) {
        BrainstormViewModel brainstormViewModel = brainstormActivity.viewModel;
        if (brainstormViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            brainstormViewModel = null;
        }
        BrainstormViewModel.recordVoiceAttemptSignal$default(brainstormViewModel, VoiceDiscussionAttemptSignal.PERMISSION_DENIED, null, 0, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean hasRequiredPermissions() {
        return BrainstormPermissionHelper.INSTANCE.getUngrantedPermissions((Context) this).isEmpty();
    }

    private final void startPendingDiscussionIfNeeded() {
        if (this.pendingAutoStartAfterPermission) {
            BrainstormViewModel brainstormViewModel = this.viewModel;
            BrainstormViewModel brainstormViewModel2 = null;
            if (brainstormViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                brainstormViewModel = null;
            }
            if (((BrainstormUiState) brainstormViewModel.getUiState().getValue()).getPhase() != BrainstormPhase.Discussing) {
                return;
            }
            this.pendingAutoStartAfterPermission = false;
            BrainstormViewModel brainstormViewModel3 = this.viewModel;
            if (brainstormViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                brainstormViewModel2 = brainstormViewModel3;
            }
            brainstormViewModel2.startBrainstorm();
        }
    }

    public final void requestVoicePermissions() {
        requestRequiredPermissions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onResume() {
        super.onResume();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        if (viewGroup != null) {
            VoiceExceptionGuard.INSTANCE.checkAndToast(viewGroup, VoiceCheckTrigger.APP_RESUMED);
        }
        BrainstormViewModel brainstormViewModel = this.viewModel;
        if (brainstormViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            brainstormViewModel = null;
        }
        brainstormViewModel.onHostResumed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onDestroy() {
        VoicePromptCenter.INSTANCE.clearAll();
        super.onDestroy();
    }

    private final void observePhaseNavigation() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new BrainstormActivity$observePhaseNavigation$1(this, null), 3, (Object) null);
    }

    private final void observeBrainstormEnded() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new BrainstormActivity$observeBrainstormEnded$1(this, null), 3, (Object) null);
    }

    private final void setupBackHandler() {
        getOnBackPressedDispatcher().addCallback((LifecycleOwner) this, new OnBackPressedCallback() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormActivity$setupBackHandler$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            public void handleOnBackPressed() {
                BrainstormViewModel brainstormViewModel;
                BrainstormViewModel brainstormViewModel2;
                BrainstormViewModel brainstormViewModel3;
                brainstormViewModel = BrainstormActivity.this.viewModel;
                BrainstormViewModel brainstormViewModel4 = null;
                if (brainstormViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    brainstormViewModel = null;
                }
                if (((BrainstormUiState) brainstormViewModel.getUiState().getValue()).getPhase() == BrainstormPhase.Discussing) {
                    brainstormViewModel2 = BrainstormActivity.this.viewModel;
                    if (brainstormViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        brainstormViewModel2 = null;
                    }
                    if (((BrainstormUiState) brainstormViewModel2.getUiState().getValue()).isSubtitleMode()) {
                        brainstormViewModel3 = BrainstormActivity.this.viewModel;
                        if (brainstormViewModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        } else {
                            brainstormViewModel4 = brainstormViewModel3;
                        }
                        brainstormViewModel4.toggleSubtitleMode();
                        return;
                    }
                    BrainstormActivity.this.showExitConfirmDialog();
                    return;
                }
                setEnabled(false);
                BrainstormActivity.this.getOnBackPressedDispatcher().onBackPressed();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void showExitConfirmDialog() {
        String string = getString(C0637R.string.trae_brainstorm_exit_confirm_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(C0637R.string.trae_brainstorm_exit_confirm_message);
        String string3 = getString(C0637R.string.trae_brainstorm_exit_confirm_discard);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = getString(C0637R.string.trae_brainstorm_exit_confirm_continue);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        new CustomConfirmDialog((Context) this, new CustomConfirmDialog.Config(string, string2, null, null, string4, string3, null, 0.0f, null, null, null, null, 0, 0, 0, null, null, null, false, new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormActivity$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit showExitConfirmDialog$lambda$15;
                showExitConfirmDialog$lambda$15 = BrainstormActivity.showExitConfirmDialog$lambda$15(BrainstormActivity.this, (String) obj);
                return showExitConfirmDialog$lambda$15;
            }
        }, null, 1572812, null)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit showExitConfirmDialog$lambda$15(BrainstormActivity brainstormActivity, String str) {
        BrainstormViewModel brainstormViewModel = null;
        TraeAITracker.trackAsrDiscuss$default(TraeAITracker.INSTANCE, AsrDiscussAction.EXIT_DISCUSSION_CLICK, null, 2, null);
        BrainstormHaptics.INSTANCE.playEndDismiss((Context) brainstormActivity);
        BrainstormViewModel brainstormViewModel2 = brainstormActivity.viewModel;
        if (brainstormViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            brainstormViewModel = brainstormViewModel2;
        }
        brainstormViewModel.endBrainstorm(true);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_conversation_brainstorm_BrainstormActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m817x2d0d773d(BrainstormActivity brainstormActivity) {
        brainstormActivity.m818x448af17e();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) brainstormActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
