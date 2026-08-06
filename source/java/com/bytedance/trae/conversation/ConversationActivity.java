package com.bytedance.trae.conversation;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.widget.CustomConfirmDialog;
import com.bytedance.trae.common.widget.CustomToast;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.ConversationViewModel;
import com.bytedance.trae.conversation.billing.BillingUpgradePromptBottomSheet;
import com.bytedance.trae.conversation.billing.BillingUpgradePromptCoordinator;
import com.bytedance.trae.conversation.billing.BillingUpgradePromptData;
import com.bytedance.trae.conversation.billing.BillingUpgradePromptLifecycleKt;
import com.bytedance.trae.conversation.brainstorm.BrainstormActivity;
import com.bytedance.trae.conversation.brainstorm.BrainstormPermissionHelper;
import com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder;
import com.bytedance.trae.conversation.brainstorm.BrainstormVoiceForegroundService;
import com.bytedance.trae.conversation.brainstorm.VoiceDiscussionPhase2Policy;
import com.bytedance.trae.conversation.chat.ConversationDetailFragment;
import com.bytedance.trae.conversation.chat.MessageManager;
import com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision;
import com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog;
import com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialogManager;
import com.bytedance.trae.conversation.chat.checkpoint.CheckpointInteractionCallback;
import com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet;
import com.bytedance.trae.conversation.databinding.TraeActivityConversationBinding;
import com.bytedance.trae.conversation.devices.BindingTarget;
import com.bytedance.trae.conversation.devices.DeviceProductType;
import com.bytedance.trae.conversation.devices.MobileDevice;
import com.bytedance.trae.conversation.devices.MobileIdeFeatureGate;
import com.bytedance.trae.conversation.devices.SelectedDeviceItem;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowExistingDeviceIdsKt;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowRequest;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute;
import com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConfig;
import com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConnectionAction;
import com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConnectionPolicy;
import com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptDecision;
import com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptEntry;
import com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptEntryPolicy;
import com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptPolicy;
import com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptSettingsProvider;
import com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptState;
import com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptStore;
import com.bytedance.trae.conversation.extract.ExtractHelper;
import com.bytedance.trae.conversation.git.BranchItem;
import com.bytedance.trae.conversation.git.GitHubConnectorManager;
import com.bytedance.trae.conversation.git.GitRepoItem;
import com.bytedance.trae.conversation.git.GitSelectionViewModel;
import com.bytedance.trae.conversation.ideproject.IDEProjectNameUtil;
import com.bytedance.trae.conversation.model.QueryItem;
import com.bytedance.trae.conversation.network.BrainstormingSettings;
import com.bytedance.trae.conversation.network.ModelSelectionRepository;
import com.bytedance.trae.conversation.network.RemoteModelItem;
import com.bytedance.trae.conversation.network.ThirdPartyTokenRepository;
import com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager;
import com.bytedance.trae.conversation.products.ArtifactListActivity;
import com.bytedance.trae.conversation.products.ArtifactPreviewActivity;
import com.bytedance.trae.conversation.prompt.ManagedPromptArbitrationPolicy;
import com.bytedance.trae.conversation.prompt.ManagedPromptAttemptPolicy;
import com.bytedance.trae.conversation.prompt.ManagedPromptCandidate;
import com.bytedance.trae.conversation.prompt.ManagedPromptCandidateState;
import com.bytedance.trae.conversation.prompt.ManagedPromptDecision;
import com.bytedance.trae.conversation.prompt.ManagedPromptDisplayOutcome;
import com.bytedance.trae.conversation.prompt.ManagedPromptLedgerState;
import com.bytedance.trae.conversation.prompt.ManagedPromptLedgerStore;
import com.bytedance.trae.conversation.prompt.ManagedPromptRoundAction;
import com.bytedance.trae.conversation.tracker.AIEventContext;
import com.bytedance.trae.conversation.tracker.AISendMessageContext;
import com.bytedance.trae.conversation.tracker.AsrDiscussAction;
import com.bytedance.trae.conversation.tracker.InputTracker;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.conversation.tracker.PluginTracker;
import com.bytedance.trae.conversation.tracker.SoloChatMode;
import com.bytedance.trae.conversation.tracker.TraeAITracker;
import com.bytedance.trae.conversation.upgrade.UpgradeReminderUpdateActionSpy;
import com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptContext;
import com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptOutcome;
import com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptStage;
import com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptState;
import com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker;
import com.bytedance.trae.conversation.voice.VoiceDiscussionMetrics;
import com.bytedance.trae.conversation.voice.rtc.VolcRtcClient;
import com.bytedance.trae.conversation.widget.AiDataNoticeHelper;
import com.bytedance.trae.conversation.widget.ChatMode;
import com.bytedance.trae.conversation.widget.InputFragment;
import com.bytedance.trae.conversation.widget.MenuPopupWindow;
import com.bytedance.trae.conversation.widget.PluginTagItem;
import com.bytedance.trae.conversation.widget.WelcomeFragment;
import com.bytedance.trae.im.database.ConversationDao;
import com.bytedance.trae.im.database.DatabaseManager;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.model.ParsedPlanItem;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.im.network.INetworkDepend;
import com.bytedance.trae.im.service.Cli;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.Conversation;
import com.bytedance.trae.im.service.IMMessageKt;
import com.bytedance.trae.im.service.IMService;
import com.bytedance.trae.im.service.Mode;
import com.bytedance.trae.im.service.ModelSelectionConstants;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.IAccountCallback;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.login.api.LoginPlatform;
import com.bytedance.trae.push.api.ActiveConversationTracker;
import com.bytedance.trae.push.api.IPushService;
import com.bytedance.trae.settings.api.feature.Feature;
import com.bytedance.trae.settings.api.feature.FeatureCapability;
import com.bytedance.trae.update.AppUpdateChecker;
import com.bytedance.trae.utils.logger.FLogger;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: ConversationActivity.kt */
@Metadata(d1 = {"\u0000à\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013*\u0004S\\ch\u0018\u0000 æ\u00012\u00020\u0001:\u0006æ\u0001ç\u0001è\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010r\u001a\u00020s2\b\u0010t\u001a\u0004\u0018\u00010uH\u0014J\b\u0010v\u001a\u00020sH\u0002J\u0010\u0010w\u001a\u00020s2\u0006\u0010x\u001a\u00020yH\u0002J\b\u0010z\u001a\u00020sH\u0002J\"\u0010{\u001a\u00020s2\u0006\u0010|\u001a\u00020}2\u0006\u0010~\u001a\u00020\u001b2\b\u0010\u007f\u001a\u0004\u0018\u00010\u001bH\u0002J\t\u0010\u0080\u0001\u001a\u00020sH\u0002J\t\u0010\u0081\u0001\u001a\u00020sH\u0002J\t\u0010\u0082\u0001\u001a\u00020sH\u0002J\t\u0010\u0083\u0001\u001a\u00020sH\u0002J\t\u0010\u0084\u0001\u001a\u00020sH\u0002J\t\u0010\u0085\u0001\u001a\u00020sH\u0002J\u001d\u0010\u0086\u0001\u001a\u00020s2\u0007\u0010\u0087\u0001\u001a\u00020\u001b2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u001bH\u0002J\t\u0010\u0089\u0001\u001a\u00020sH\u0002J\t\u0010\u008a\u0001\u001a\u00020sH\u0002J\t\u0010\u008b\u0001\u001a\u00020sH\u0002J\u0012\u0010\u008c\u0001\u001a\u00020s2\u0007\u0010\u008d\u0001\u001a\u00020\u001eH\u0002J\t\u0010\u008e\u0001\u001a\u00020sH\u0002J\t\u0010\u008f\u0001\u001a\u00020sH\u0002J\u001d\u0010\u0090\u0001\u001a\u00020s2\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001H\u0002J\u0013\u0010\u0095\u0001\u001a\u00020s2\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0002J\t\u0010\u0098\u0001\u001a\u00020sH\u0002J\t\u0010\u0099\u0001\u001a\u00020sH\u0002J\t\u0010\u009a\u0001\u001a\u00020sH\u0002J.\u0010\u009b\u0001\u001a\u00020s2\u0007\u0010\u009c\u0001\u001a\u00020\u001b2\u0007\u0010\u009d\u0001\u001a\u00020\u001b2\u0011\b\u0002\u0010\u009e\u0001\u001a\n\u0012\u0005\u0012\u00030 \u00010\u009f\u0001H\u0002J\t\u0010¡\u0001\u001a\u00020\u0011H\u0002J\t\u0010¢\u0001\u001a\u00020sH\u0002J\u0012\u0010£\u0001\u001a\u00020s2\u0007\u0010¤\u0001\u001a\u00020\u0011H\u0002J\t\u0010¥\u0001\u001a\u00020sH\u0002J\t\u0010¦\u0001\u001a\u00020!H\u0002J\u0014\u0010§\u0001\u001a\u00020\u00112\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010!H\u0002J\t\u0010¨\u0001\u001a\u00020sH\u0002J\t\u0010©\u0001\u001a\u00020sH\u0002J\t\u0010ª\u0001\u001a\u00020sH\u0002J\u0013\u0010«\u0001\u001a\u00020\u00112\b\u0010¬\u0001\u001a\u00030\u00ad\u0001H\u0016J\u0013\u0010®\u0001\u001a\u00020\u00112\b\u0010¬\u0001\u001a\u00030\u00ad\u0001H\u0002J\t\u0010¯\u0001\u001a\u00020sH\u0002J\u0010\u0010°\u0001\u001a\u00020sH\u0082@¢\u0006\u0003\u0010±\u0001J\t\u0010²\u0001\u001a\u00020sH\u0014J\u001c\u0010³\u0001\u001a\u0005\u0018\u00010´\u00012\u0007\u0010µ\u0001\u001a\u00020\u001bH\u0082@¢\u0006\u0003\u0010¶\u0001J.\u0010·\u0001\u001a\u00030¸\u00012\b\u0010¹\u0001\u001a\u00030´\u00012\u000f\u0010º\u0001\u001a\n\u0012\u0005\u0012\u00030\u0092\u00010\u009f\u00012\u0007\u0010µ\u0001\u001a\u00020\u001bH\u0002J\u0012\u0010»\u0001\u001a\u00020\u00112\u0007\u0010¼\u0001\u001a\u00020\u0014H\u0002J\u001c\u0010½\u0001\u001a\u00020s2\u0007\u0010µ\u0001\u001a\u00020\u001b2\b\u0010¹\u0001\u001a\u00030´\u0001H\u0002J\t\u0010¾\u0001\u001a\u00020\u0011H\u0002J\u000b\u0010¿\u0001\u001a\u0004\u0018\u00010\u001bH\u0002J\t\u0010À\u0001\u001a\u00020\u0011H\u0002J\t\u0010Á\u0001\u001a\u00020sH\u0002J\t\u0010Â\u0001\u001a\u00020sH\u0014J\t\u0010Ã\u0001\u001a\u00020sH\u0014J\u0012\u0010Ä\u0001\u001a\u00020s2\u0007\u0010Å\u0001\u001a\u00020WH\u0014J\u001b\u0010Æ\u0001\u001a\u00020s2\u0007\u0010Ç\u0001\u001a\u00020\u001b2\u0007\u0010È\u0001\u001a\u00020WH\u0002J\u0017\u0010É\u0001\u001a\u00020s2\u000e\u0010Ê\u0001\u001a\t\u0012\u0004\u0012\u00020}0\u009f\u0001J\u0012\u0010Ë\u0001\u001a\u00020\u001b2\u0007\u0010Ì\u0001\u001a\u00020\u001bH\u0002J\u001b\u0010Í\u0001\u001a\u00020s2\u0007\u0010Ì\u0001\u001a\u00020\u001b2\u0007\u0010Î\u0001\u001a\u00020\u001bH\u0002J\u0012\u0010Ï\u0001\u001a\u00020s2\u0007\u0010Ì\u0001\u001a\u00020\u001bH\u0002J\u0018\u0010Ð\u0001\u001a\u00030Ñ\u00012\f\b\u0002\u0010Ò\u0001\u001a\u0005\u0018\u00010Ó\u0001H\u0002J\u001f\u0010Ô\u0001\u001a\u00020*2\b\u0010\u008d\u0001\u001a\u00030Ó\u00012\n\b\u0002\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0002J\u001f\u0010×\u0001\u001a\u00020s2\t\u0010Ø\u0001\u001a\u0004\u0018\u00010\u001b2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u001bH\u0002J\u001b\u0010Ù\u0001\u001a\u00020s2\u0007\u0010\u0088\u0001\u001a\u00020\u001b2\u0007\u0010Ú\u0001\u001a\u00020\u001bH\u0002J\t\u0010Û\u0001\u001a\u00020sH\u0002J\t\u0010Ü\u0001\u001a\u00020MH\u0002J\t\u0010Ý\u0001\u001a\u00020sH\u0002J\n\u0010Þ\u0001\u001a\u00030Ó\u0001H\u0002J\t\u0010ß\u0001\u001a\u00020sH\u0002J\t\u0010à\u0001\u001a\u00020sH\u0002J\t\u0010á\u0001\u001a\u00020sH\u0002J\t\u0010â\u0001\u001a\u00020sH\u0002J\t\u0010ã\u0001\u001a\u00020sH\u0002J\u0014\u0010ä\u0001\u001a\u00020s2\t\u0010Å\u0001\u001a\u0004\u0018\u00010WH\u0002J\t\u0010å\u0001\u001a\u00020sH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020!0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010@\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\r\u001a\u0004\bB\u0010CR\u001b\u0010E\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\r\u001a\u0004\bG\u0010HR\u000e\u0010J\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010N\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001b Q*\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010P0P0OX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u00020SX\u0082\u0004¢\u0006\u0004\n\u0002\u0010TR\u000e\u0010U\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010V\u001a\u0010\u0012\f\u0012\n Q*\u0004\u0018\u00010W0W0OX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010X\u001a\u0010\u0012\f\u0012\n Q*\u0004\u0018\u00010W0W0O¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0010\u0010[\u001a\u00020\\X\u0082\u0004¢\u0006\u0004\n\u0002\u0010]R\u000e\u0010^\u001a\u00020_X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u00020cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010dR\u000e\u0010e\u001a\u00020fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010g\u001a\u00020hX\u0082\u0004¢\u0006\u0004\n\u0002\u0010iR\u0014\u0010j\u001a\u00020k8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0016\u0010n\u001a\u0004\u0018\u00010o8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bp\u0010q¨\u0006é\u0001"}, d2 = {"Lcom/bytedance/trae/conversation/ConversationActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "binding", "Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;", "viewModel", "Lcom/bytedance/trae/conversation/ConversationViewModel;", "conversationDao", "Lcom/bytedance/trae/im/database/ConversationDao;", "getConversationDao", "()Lcom/bytedance/trae/im/database/ConversationDao;", "conversationDao$delegate", "Lkotlin/Lazy;", "menuPopupWindow", "Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;", "isNewConversation", "", "hasEnteredBackground", "newFeaturePromptSheet", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;", "managedPromptResolutionJob", "Lkotlinx/coroutines/Job;", "loadingDialog", "Landroid/app/Dialog;", "isCheckpointDialogVisible", "showingCheckpointToolCallId", "", "draftByMode", "", "Lcom/bytedance/trae/conversation/widget/ChatMode;", "Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;", "selectedDeviceByMode", "Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;", "initialChatMode", "getInitialChatMode", "()Lcom/bytedance/trae/conversation/widget/ChatMode;", "setInitialChatMode", "(Lcom/bytedance/trae/conversation/widget/ChatMode;)V", "pendingTriggerTracker", "Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;", "lastSendContext", "Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;", "hasReportedStreamShow", "streamingStartTimeMs", "", "wasUserInitiatedCancel", "streamingMessageId", "streamingChatModel", "anchorCreatedAtMs", "hasScrolledToAnchorCreatedAt", "snapToBottomAfterLatestPageSubmit", "notificationPermissionRequested", "pendingConnectDeviceType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "pendingConnectDeviceFlowActive", "suppressNaturalGuideForPendingConnect", "checkpointVisibleFrame", "Landroid/graphics/Rect;", "checkpointOverlayLocation", "", "isCheckpointKeyboardListenerRegistered", "checkpointKeyboardLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "gitHubConnectorManager", "Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;", "getGitHubConnectorManager", "()Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;", "gitHubConnectorManager$delegate", "gitSelectionViewModel", "Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;", "getGitSelectionViewModel", "()Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;", "gitSelectionViewModel$delegate", "brainstormMicCheckStartMs", "brainstormMicCheckEndMs", "voiceDiscussionAttemptTracker", "Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;", "brainstormPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "voiceMinimizedBackCallback", "com/bytedance/trae/conversation/ConversationActivity$voiceMinimizedBackCallback$1", "Lcom/bytedance/trae/conversation/ConversationActivity$voiceMinimizedBackCallback$1;", "iLaunchedActiveBrainstorm", "brainstormResultLauncher", "Landroid/content/Intent;", "previewWebViewLauncher", "getPreviewWebViewLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "deleteMessageListener", "com/bytedance/trae/conversation/ConversationActivity$deleteMessageListener$1", "Lcom/bytedance/trae/conversation/ConversationActivity$deleteMessageListener$1;", "remoteDeleteMessagePushListener", "Lcom/bytedance/trae/im/service/IMService$RemoteDeleteMessagePushListener;", "cliStatusChangeListener", "Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;", "deleteConversationListener", "com/bytedance/trae/conversation/ConversationActivity$deleteConversationListener$1", "Lcom/bytedance/trae/conversation/ConversationActivity$deleteConversationListener$1;", "conversationChangeListener", "Lcom/bytedance/trae/im/service/IMService$ConversationChangeListener;", "revertMessageListener", "com/bytedance/trae/conversation/ConversationActivity$revertMessageListener$1", "Lcom/bytedance/trae/conversation/ConversationActivity$revertMessageListener$1;", "inputFragment", "Lcom/bytedance/trae/conversation/widget/InputFragment;", "getInputFragment", "()Lcom/bytedance/trae/conversation/widget/InputFragment;", "detailFragment", "Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;", "getDetailFragment", "()Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "requestNotificationPermissionIfNeeded", "openAppInPlayStore", "context", "Landroid/content/Context;", "dismissPluginAuthBottomSheetIfShowing", "checkConfirmRequired", "message", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "taskId", "conversationId", "registerCheckpointKeyboardListener", "unregisterCheckpointKeyboardListener", "syncCheckpointOverlayWithKeyboard", "observeViewModel", "observeStarbucks", "initCheckpointDialog", "openFile", "filePath", "messageId", "initTitleBar", "showRenameDialog", "showDeleteDialog", "updateModeTab", "mode", "switchToCodeMode", "switchToWorkMode", "autoSelectConnectedDevice", "device", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "action", "Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;", "updateConversationTitleInfo", "conversation", "Lcom/bytedance/trae/im/service/Conversation;", "showWelcomeScreen", "hideWelcomeScreen", "initWelcomeFragment", "sendQuery", "query", "text", "plugins", "", "Lcom/bytedance/trae/conversation/widget/PluginTagItem;", "exitAnchorWindowAndShowLatestPage", "initInputFragment", "setTitleBarInteraction", "enabled", "showCliSelectionDialog", "defaultRemoteDevice", "canStartBrainstormForDevice", "handleGitError", "showLoading", "hideLoading", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isTouchOnInputArea", "observeManagedPrompts", "resolveManagedPromptsWhileResumed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onResume", "prepareNewFeaturePrompt", "Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;", "userId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showNewFeaturePrompt", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;", "prepared", "devices", "isCommittedNewFeaturePrompt", "sheet", "recordNewFeaturePromptShown", "isManagedPromptHostReady", "currentLoggedInUserId", "shouldDelayManagedPromptsForPendingConnect", "executePendingConnectDevice", "onStop", "onDestroy", "onNewIntent", "intent", "handlePushNewIntent", "pushConversationId", "newIntent", "submitMessages", "messages", "findUserMessageId", "agentMessageId", "trackFeedback", "resultType", "trackCopy", "resolveCurrentChatMode", "Lcom/bytedance/trae/conversation/tracker/SoloChatMode;", "fallbackMode", "Lcom/bytedance/trae/im/service/Mode;", "buildSendMessageContext", "pluginCount", "", "flushPendingTriggerTracker", "sessionId", "submitReport", ReportConstant.COMMON_CONTENT, "requestBrainstormPermissions", "createVoiceDiscussionAttempt", "launchBrainstormActivity", "resolveTaskModeForCurrentConversation", "observeMinimizedVoice", "applyMinimizedVoiceVisibility", "observeBrainstormEnded", "showEndVoiceDiscussionDialog", "maximizeBrainstorm", "handleStartServerIntent", "performForceLogout", "Companion", "PendingTriggerTracker", "PreparedNewFeaturePrompt", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationActivity extends TraeCommonAppCompatActivity {
    private static final String AGENT_FLOW_TAG = "AgentDataFlow";
    private static final String CHECK_POINT_TAG = "CheckPointDialog";
    public static final String EXTRA_ANCHOR_CREATED_AT_MS = "extra_anchor_created_at_ms";
    public static final String EXTRA_CONVERSATION = "extra_conversation";
    public static final String EXTRA_CONVERSATION_ID = "extra_conversation_id";
    public static final String EXTRA_ENTER_FROM = "extra_enter_from";
    public static final String EXTRA_ICON_TYPE = "extra_icon_type";
    public static final String EXTRA_MODE = "extra_mode";
    public static final String EXTRA_PENDING_CONNECT_DEVICE_TYPE = "extra_pending_connect_device_type";
    public static final String EXTRA_START_SERVER_URL = "extra_start_server_url";
    private static final float KEYBOARD_VISIBLE_THRESHOLD = 0.15f;
    private static final String KEY_LAST_CHAT_MODE = "last_selected_chat_mode";
    private static final long MANAGED_PROMPT_RETRY_DELAY_MS = 500;
    private static final String TAG = "ConversationActivity";
    private String anchorCreatedAtMs;
    private TraeActivityConversationBinding binding;
    private long brainstormMicCheckEndMs;
    private long brainstormMicCheckStartMs;
    private final ActivityResultLauncher<String[]> brainstormPermissionLauncher;
    private final ActivityResultLauncher<Intent> brainstormResultLauncher;
    private final IMService.CliStatusChangeListener cliStatusChangeListener;
    private final IMService.ConversationChangeListener conversationChangeListener;
    private final ConversationActivity$deleteConversationListener$1 deleteConversationListener;
    private final ConversationActivity$deleteMessageListener$1 deleteMessageListener;
    private boolean hasEnteredBackground;
    private boolean hasReportedStreamShow;
    private boolean hasScrolledToAnchorCreatedAt;
    private boolean iLaunchedActiveBrainstorm;
    private boolean isCheckpointDialogVisible;
    private boolean isCheckpointKeyboardListenerRegistered;
    private boolean isNewConversation;
    private AISendMessageContext lastSendContext;
    private Dialog loadingDialog;
    private Job managedPromptResolutionJob;
    private MenuPopupWindow menuPopupWindow;
    private DeviceFlowContainerBottomSheet newFeaturePromptSheet;
    private boolean notificationPermissionRequested;
    private boolean pendingConnectDeviceFlowActive;
    private DeviceProductType pendingConnectDeviceType;
    private PendingTriggerTracker pendingTriggerTracker;
    private final ActivityResultLauncher<Intent> previewWebViewLauncher;
    private final IMService.RemoteDeleteMessagePushListener remoteDeleteMessagePushListener;
    private final ConversationActivity$revertMessageListener$1 revertMessageListener;
    private String showingCheckpointToolCallId;
    private boolean snapToBottomAfterLatestPageSubmit;
    private String streamingChatModel;
    private String streamingMessageId;
    private long streamingStartTimeMs;
    private boolean suppressNaturalGuideForPendingConnect;
    private ConversationViewModel viewModel;
    private VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker;
    private final ConversationActivity$voiceMinimizedBackCallback$1 voiceMinimizedBackCallback;
    private boolean wasUserInitiatedCancel;

    /* renamed from: conversationDao$delegate, reason: from kotlin metadata */
    private final Lazy conversationDao = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda31
        public final Object invoke() {
            ConversationDao conversationDao_delegate$lambda$0;
            conversationDao_delegate$lambda$0 = ConversationActivity.conversationDao_delegate$lambda$0(ConversationActivity.this);
            return conversationDao_delegate$lambda$0;
        }
    });
    private final Map<ChatMode, InputFragment.ModeDraft> draftByMode = new LinkedHashMap();
    private final Map<ChatMode, SelectedDeviceItem> selectedDeviceByMode = new LinkedHashMap();
    private ChatMode initialChatMode = ChatMode.MTC;
    private final Rect checkpointVisibleFrame = new Rect();
    private final int[] checkpointOverlayLocation = new int[2];
    private final ViewTreeObserver.OnGlobalLayoutListener checkpointKeyboardLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda32
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            ConversationActivity.this.syncCheckpointOverlayWithKeyboard();
        }
    };

    /* renamed from: gitHubConnectorManager$delegate, reason: from kotlin metadata */
    private final Lazy gitHubConnectorManager = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda34
        public final Object invoke() {
            GitHubConnectorManager gitHubConnectorManager_delegate$lambda$2;
            gitHubConnectorManager_delegate$lambda$2 = ConversationActivity.gitHubConnectorManager_delegate$lambda$2(ConversationActivity.this);
            return gitHubConnectorManager_delegate$lambda$2;
        }
    });

    /* renamed from: gitSelectionViewModel$delegate, reason: from kotlin metadata */
    private final Lazy gitSelectionViewModel = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda35
        public final Object invoke() {
            GitSelectionViewModel gitSelectionViewModel_delegate$lambda$3;
            gitSelectionViewModel_delegate$lambda$3 = ConversationActivity.gitSelectionViewModel_delegate$lambda$3(ConversationActivity.this);
            return gitSelectionViewModel_delegate$lambda$3;
        }
    });

    /* compiled from: ConversationActivity.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[ChatMode.values().length];
            try {
                iArr[ChatMode.MTC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ChatMode.CODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ManagedPromptRoundAction.values().length];
            try {
                iArr2[ManagedPromptRoundAction.Complete.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ManagedPromptRoundAction.Retry.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ManagedPromptRoundAction.ContinueToLowerPriority.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[Mode.values().length];
            try {
                iArr3[Mode.WORK.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[Mode.CODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[CliType.values().length];
            try {
                iArr4[CliType.LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr4[CliType.REMOTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr4[CliType.IDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    protected void onStop() {
        m811xbeb733c3(this);
    }

    /* JADX WARN: Type inference failed for: r0v18, types: [com.bytedance.trae.conversation.ConversationActivity$voiceMinimizedBackCallback$1] */
    /* JADX WARN: Type inference failed for: r0v25, types: [com.bytedance.trae.conversation.ConversationActivity$deleteMessageListener$1] */
    /* JADX WARN: Type inference failed for: r0v28, types: [com.bytedance.trae.conversation.ConversationActivity$deleteConversationListener$1] */
    /* JADX WARN: Type inference failed for: r0v30, types: [com.bytedance.trae.conversation.ConversationActivity$revertMessageListener$1] */
    public ConversationActivity() {
        ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda36
            public final void onActivityResult(Object obj) {
                ConversationActivity.brainstormPermissionLauncher$lambda$4(ConversationActivity.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.brainstormPermissionLauncher = registerForActivityResult;
        this.voiceMinimizedBackCallback = new OnBackPressedCallback() { // from class: com.bytedance.trae.conversation.ConversationActivity$voiceMinimizedBackCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(false);
            }

            public void handleOnBackPressed() {
                ConversationActivity.this.showEndVoiceDiscussionDialog();
            }
        };
        ActivityResultLauncher<Intent> registerForActivityResult2 = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda37
            public final void onActivityResult(Object obj) {
                ConversationActivity.brainstormResultLauncher$lambda$6(ConversationActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResult(...)");
        this.brainstormResultLauncher = registerForActivityResult2;
        ActivityResultLauncher<Intent> registerForActivityResult3 = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda38
            public final void onActivityResult(Object obj) {
                ConversationActivity.previewWebViewLauncher$lambda$7(ConversationActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult3, "registerForActivityResult(...)");
        this.previewWebViewLauncher = registerForActivityResult3;
        this.deleteMessageListener = new MessageManager.IDeleteMessage() { // from class: com.bytedance.trae.conversation.ConversationActivity$deleteMessageListener$1
            @Override // com.bytedance.trae.conversation.chat.MessageManager.IDeleteMessage
            public void onMessageDeleted(String conversationId, String messageId) {
                ConversationViewModel conversationViewModel;
                ConversationViewModel conversationViewModel2;
                Intrinsics.checkNotNullParameter(conversationId, "conversationId");
                Intrinsics.checkNotNullParameter(messageId, "messageId");
                conversationViewModel = ConversationActivity.this.viewModel;
                ConversationViewModel conversationViewModel3 = null;
                if (conversationViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    conversationViewModel = null;
                }
                if (Intrinsics.areEqual(conversationId, conversationViewModel.getConversationId().getValue())) {
                    conversationViewModel2 = ConversationActivity.this.viewModel;
                    if (conversationViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        conversationViewModel3 = conversationViewModel2;
                    }
                    conversationViewModel3.deleteMessageAndReplies(conversationId, messageId);
                }
            }
        };
        this.remoteDeleteMessagePushListener = new IMService.RemoteDeleteMessagePushListener() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda39
            @Override // com.bytedance.trae.im.service.IMService.RemoteDeleteMessagePushListener
            public final void onMessagesDeletedRemotely(IMService.DeleteMessagePushPayload deleteMessagePushPayload) {
                ConversationActivity.remoteDeleteMessagePushListener$lambda$9(ConversationActivity.this, deleteMessagePushPayload);
            }
        };
        this.cliStatusChangeListener = new IMService.CliStatusChangeListener() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda40
            @Override // com.bytedance.trae.im.service.IMService.CliStatusChangeListener
            public final void onCliStatusChanged(IMService.CliStatusChangePayload cliStatusChangePayload) {
                ConversationActivity.cliStatusChangeListener$lambda$11(ConversationActivity.this, cliStatusChangePayload);
            }
        };
        this.deleteConversationListener = new MessageManager.IDeleteConversation() { // from class: com.bytedance.trae.conversation.ConversationActivity$deleteConversationListener$1
            @Override // com.bytedance.trae.conversation.chat.MessageManager.IDeleteConversation
            public void onMessageDeleted(String conversationId) {
                ConversationViewModel conversationViewModel;
                Intrinsics.checkNotNullParameter(conversationId, "conversationId");
                conversationViewModel = ConversationActivity.this.viewModel;
                if (conversationViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    conversationViewModel = null;
                }
                if (Intrinsics.areEqual(conversationId, conversationViewModel.getConversationId().getValue())) {
                    ConversationActivity.this.finish();
                }
            }
        };
        this.conversationChangeListener = new IMService.ConversationChangeListener() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda41
            @Override // com.bytedance.trae.im.service.IMService.ConversationChangeListener
            public final void onConversationChanged(IMService.ConversationChangeEvent conversationChangeEvent) {
                ConversationActivity.conversationChangeListener$lambda$14(ConversationActivity.this, conversationChangeEvent);
            }
        };
        this.revertMessageListener = new MessageManager.IRevertMessage() { // from class: com.bytedance.trae.conversation.ConversationActivity$revertMessageListener$1
            @Override // com.bytedance.trae.conversation.chat.MessageManager.IRevertMessage
            public void onMessageReverted(String conversationId, String messageId, ParsedChatMessage message) {
                ConversationViewModel conversationViewModel;
                ConversationViewModel conversationViewModel2;
                InputFragment inputFragment;
                Intrinsics.checkNotNullParameter(conversationId, "conversationId");
                Intrinsics.checkNotNullParameter(messageId, "messageId");
                conversationViewModel = ConversationActivity.this.viewModel;
                ConversationViewModel conversationViewModel3 = null;
                if (conversationViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    conversationViewModel = null;
                }
                if (Intrinsics.areEqual(conversationId, conversationViewModel.getConversationId().getValue())) {
                    conversationViewModel2 = ConversationActivity.this.viewModel;
                    if (conversationViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        conversationViewModel3 = conversationViewModel2;
                    }
                    conversationViewModel3.revertMessageAndFollowingUsers(conversationId, messageId, message);
                    if (message != null) {
                        inputFragment = ConversationActivity.this.getInputFragment();
                        inputFragment.addRevertMessage(message);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConversationDao getConversationDao() {
        return (ConversationDao) this.conversationDao.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final ConversationDao conversationDao_delegate$lambda$0(ConversationActivity conversationActivity) {
        String str;
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null || (str = accountInfo.getUserId()) == null) {
            str = "anonymous";
        }
        return new ConversationDao(DatabaseManager.INSTANCE.getDatabase((Context) conversationActivity, str));
    }

    public final ChatMode getInitialChatMode() {
        return this.initialChatMode;
    }

    public final void setInitialChatMode(ChatMode chatMode) {
        Intrinsics.checkNotNullParameter(chatMode, "<set-?>");
        this.initialChatMode = chatMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConversationActivity.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;", "", "eventContext", "Lcom/bytedance/trae/conversation/tracker/AIEventContext;", "sendContext", "Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;", "chatMode", "Lcom/bytedance/trae/conversation/tracker/SoloChatMode;", "<init>", "(Lcom/bytedance/trae/conversation/tracker/AIEventContext;Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V", "getEventContext", "()Lcom/bytedance/trae/conversation/tracker/AIEventContext;", "getSendContext", "()Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;", "getChatMode", "()Lcom/bytedance/trae/conversation/tracker/SoloChatMode;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class PendingTriggerTracker {
        private final SoloChatMode chatMode;
        private final AIEventContext eventContext;
        private final AISendMessageContext sendContext;

        public static /* synthetic */ PendingTriggerTracker copy$default(PendingTriggerTracker pendingTriggerTracker, AIEventContext aIEventContext, AISendMessageContext aISendMessageContext, SoloChatMode soloChatMode, int i, Object obj) {
            if ((i & 1) != 0) {
                aIEventContext = pendingTriggerTracker.eventContext;
            }
            if ((i & 2) != 0) {
                aISendMessageContext = pendingTriggerTracker.sendContext;
            }
            if ((i & 4) != 0) {
                soloChatMode = pendingTriggerTracker.chatMode;
            }
            return pendingTriggerTracker.copy(aIEventContext, aISendMessageContext, soloChatMode);
        }

        /* renamed from: component1, reason: from getter */
        public final AIEventContext getEventContext() {
            return this.eventContext;
        }

        /* renamed from: component2, reason: from getter */
        public final AISendMessageContext getSendContext() {
            return this.sendContext;
        }

        /* renamed from: component3, reason: from getter */
        public final SoloChatMode getChatMode() {
            return this.chatMode;
        }

        public final PendingTriggerTracker copy(AIEventContext eventContext, AISendMessageContext sendContext, SoloChatMode chatMode) {
            Intrinsics.checkNotNullParameter(eventContext, "eventContext");
            Intrinsics.checkNotNullParameter(sendContext, "sendContext");
            Intrinsics.checkNotNullParameter(chatMode, "chatMode");
            return new PendingTriggerTracker(eventContext, sendContext, chatMode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingTriggerTracker)) {
                return false;
            }
            PendingTriggerTracker pendingTriggerTracker = (PendingTriggerTracker) other;
            return Intrinsics.areEqual(this.eventContext, pendingTriggerTracker.eventContext) && Intrinsics.areEqual(this.sendContext, pendingTriggerTracker.sendContext) && this.chatMode == pendingTriggerTracker.chatMode;
        }

        public int hashCode() {
            return (((this.eventContext.hashCode() * 31) + this.sendContext.hashCode()) * 31) + this.chatMode.hashCode();
        }

        public String toString() {
            return "PendingTriggerTracker(eventContext=" + this.eventContext + ", sendContext=" + this.sendContext + ", chatMode=" + this.chatMode + ')';
        }

        public PendingTriggerTracker(AIEventContext aIEventContext, AISendMessageContext aISendMessageContext, SoloChatMode soloChatMode) {
            Intrinsics.checkNotNullParameter(aIEventContext, "eventContext");
            Intrinsics.checkNotNullParameter(aISendMessageContext, "sendContext");
            Intrinsics.checkNotNullParameter(soloChatMode, "chatMode");
            this.eventContext = aIEventContext;
            this.sendContext = aISendMessageContext;
            this.chatMode = soloChatMode;
        }

        public final AIEventContext getEventContext() {
            return this.eventContext;
        }

        public final AISendMessageContext getSendContext() {
            return this.sendContext;
        }

        public final SoloChatMode getChatMode() {
            return this.chatMode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConversationActivity.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;", "", "candidate", "Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "hasRegisteredWork", "", "hasRegisteredIDE", "config", "Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;", "<init>", "(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;Lcom/bytedance/trae/conversation/devices/DeviceProductType;ZZLcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;)V", "getCandidate", "()Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;", "getProductType", "()Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "getHasRegisteredWork", "()Z", "getHasRegisteredIDE", "getConfig", "()Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class PreparedNewFeaturePrompt {
        private final ManagedPromptCandidate candidate;
        private final NewFeaturePromptConfig config;
        private final boolean hasRegisteredIDE;
        private final boolean hasRegisteredWork;
        private final DeviceProductType productType;

        public static /* synthetic */ PreparedNewFeaturePrompt copy$default(PreparedNewFeaturePrompt preparedNewFeaturePrompt, ManagedPromptCandidate managedPromptCandidate, DeviceProductType deviceProductType, boolean z, boolean z2, NewFeaturePromptConfig newFeaturePromptConfig, int i, Object obj) {
            if ((i & 1) != 0) {
                managedPromptCandidate = preparedNewFeaturePrompt.candidate;
            }
            if ((i & 2) != 0) {
                deviceProductType = preparedNewFeaturePrompt.productType;
            }
            DeviceProductType deviceProductType2 = deviceProductType;
            if ((i & 4) != 0) {
                z = preparedNewFeaturePrompt.hasRegisteredWork;
            }
            boolean z3 = z;
            if ((i & 8) != 0) {
                z2 = preparedNewFeaturePrompt.hasRegisteredIDE;
            }
            boolean z4 = z2;
            if ((i & 16) != 0) {
                newFeaturePromptConfig = preparedNewFeaturePrompt.config;
            }
            return preparedNewFeaturePrompt.copy(managedPromptCandidate, deviceProductType2, z3, z4, newFeaturePromptConfig);
        }

        /* renamed from: component1, reason: from getter */
        public final ManagedPromptCandidate getCandidate() {
            return this.candidate;
        }

        /* renamed from: component2, reason: from getter */
        public final DeviceProductType getProductType() {
            return this.productType;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getHasRegisteredWork() {
            return this.hasRegisteredWork;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getHasRegisteredIDE() {
            return this.hasRegisteredIDE;
        }

        /* renamed from: component5, reason: from getter */
        public final NewFeaturePromptConfig getConfig() {
            return this.config;
        }

        public final PreparedNewFeaturePrompt copy(ManagedPromptCandidate candidate, DeviceProductType productType, boolean hasRegisteredWork, boolean hasRegisteredIDE, NewFeaturePromptConfig config) {
            Intrinsics.checkNotNullParameter(candidate, "candidate");
            Intrinsics.checkNotNullParameter(productType, "productType");
            Intrinsics.checkNotNullParameter(config, "config");
            return new PreparedNewFeaturePrompt(candidate, productType, hasRegisteredWork, hasRegisteredIDE, config);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PreparedNewFeaturePrompt)) {
                return false;
            }
            PreparedNewFeaturePrompt preparedNewFeaturePrompt = (PreparedNewFeaturePrompt) other;
            return Intrinsics.areEqual(this.candidate, preparedNewFeaturePrompt.candidate) && this.productType == preparedNewFeaturePrompt.productType && this.hasRegisteredWork == preparedNewFeaturePrompt.hasRegisteredWork && this.hasRegisteredIDE == preparedNewFeaturePrompt.hasRegisteredIDE && Intrinsics.areEqual(this.config, preparedNewFeaturePrompt.config);
        }

        public int hashCode() {
            return (((((((this.candidate.hashCode() * 31) + this.productType.hashCode()) * 31) + Boolean.hashCode(this.hasRegisteredWork)) * 31) + Boolean.hashCode(this.hasRegisteredIDE)) * 31) + this.config.hashCode();
        }

        public String toString() {
            return "PreparedNewFeaturePrompt(candidate=" + this.candidate + ", productType=" + this.productType + ", hasRegisteredWork=" + this.hasRegisteredWork + ", hasRegisteredIDE=" + this.hasRegisteredIDE + ", config=" + this.config + ')';
        }

        public PreparedNewFeaturePrompt(ManagedPromptCandidate managedPromptCandidate, DeviceProductType deviceProductType, boolean z, boolean z2, NewFeaturePromptConfig newFeaturePromptConfig) {
            Intrinsics.checkNotNullParameter(managedPromptCandidate, "candidate");
            Intrinsics.checkNotNullParameter(deviceProductType, "productType");
            Intrinsics.checkNotNullParameter(newFeaturePromptConfig, "config");
            this.candidate = managedPromptCandidate;
            this.productType = deviceProductType;
            this.hasRegisteredWork = z;
            this.hasRegisteredIDE = z2;
            this.config = newFeaturePromptConfig;
        }

        public final ManagedPromptCandidate getCandidate() {
            return this.candidate;
        }

        public final DeviceProductType getProductType() {
            return this.productType;
        }

        public final boolean getHasRegisteredWork() {
            return this.hasRegisteredWork;
        }

        public final boolean getHasRegisteredIDE() {
            return this.hasRegisteredIDE;
        }

        public final NewFeaturePromptConfig getConfig() {
            return this.config;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GitHubConnectorManager getGitHubConnectorManager() {
        return (GitHubConnectorManager) this.gitHubConnectorManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final GitHubConnectorManager gitHubConnectorManager_delegate$lambda$2(ConversationActivity conversationActivity) {
        return new GitHubConnectorManager((Context) conversationActivity, null, 2, null);
    }

    private final GitSelectionViewModel getGitSelectionViewModel() {
        return (GitSelectionViewModel) this.gitSelectionViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GitSelectionViewModel gitSelectionViewModel_delegate$lambda$3(ConversationActivity conversationActivity) {
        return (GitSelectionViewModel) new ViewModelProvider((ViewModelStoreOwner) conversationActivity).get(GitSelectionViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void brainstormPermissionLauncher$lambda$4(ConversationActivity conversationActivity, Map map) {
        Intrinsics.checkNotNull(map);
        for (Map.Entry entry : map.entrySet()) {
            FLogger.INSTANCE.d(TAG, "Brainstorm permission result: " + ((String) entry.getKey()) + " = " + ((Boolean) entry.getValue()).booleanValue());
        }
        conversationActivity.brainstormMicCheckEndMs = System.currentTimeMillis();
        conversationActivity.launchBrainstormActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object] */
    public static final void brainstormResultLauncher$lambda$6(ConversationActivity conversationActivity, ActivityResult activityResult) {
        Mode mode;
        Mode mode2;
        if (activityResult.getResultCode() == -1) {
            ConversationViewModel conversationViewModel = null;
            if (conversationActivity.isNewConversation) {
                TraeActivityConversationBinding traeActivityConversationBinding = conversationActivity.binding;
                if (traeActivityConversationBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    traeActivityConversationBinding = null;
                }
                mode2 = traeActivityConversationBinding.titleBar.getSegmentedSelectedIndex() == 0 ? Mode.WORK : Mode.CODE;
            } else {
                Iterator it = Mode.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        mode = 0;
                        break;
                    }
                    mode = it.next();
                    String value = ((Mode) mode).getValue();
                    ConversationViewModel conversationViewModel2 = conversationActivity.viewModel;
                    if (conversationViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        conversationViewModel2 = null;
                    }
                    Conversation conversation = (Conversation) conversationViewModel2.getConversation().getValue();
                    if (Intrinsics.areEqual(value, conversation != null ? conversation.getMode() : null)) {
                        break;
                    }
                }
                mode2 = mode;
                if (mode2 == null) {
                    mode2 = Mode.WORK;
                }
            }
            FLogger.INSTANCE.d(TAG, "brainstorm relay mode: " + mode2);
            Intent data = activityResult.getData();
            String stringExtra = data != null ? data.getStringExtra(BrainstormActivity.EXTRA_MESSAGES_TEXT) : null;
            Intent data2 = activityResult.getData();
            String stringExtra2 = data2 != null ? data2.getStringExtra(BrainstormActivity.EXTRA_CLI_CONVERSATION_ID) : null;
            Intent data3 = activityResult.getData();
            String stringExtra3 = data3 != null ? data3.getStringExtra(BrainstormActivity.EXTRA_PARENT_CONVERSATION_ID) : null;
            String str = stringExtra;
            if (!(str == null || StringsKt.isBlank(str))) {
                String str2 = stringExtra2;
                if (!(str2 == null || StringsKt.isBlank(str2))) {
                    ConversationViewModel conversationViewModel3 = conversationActivity.viewModel;
                    if (conversationViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        conversationViewModel = conversationViewModel3;
                    }
                    conversationViewModel.handleBrainstormResult(stringExtra, mode2, stringExtra2, stringExtra3);
                    return;
                }
            }
            FLogger.INSTANCE.d(TAG, "Brainstorm result is empty");
        }
    }

    public final ActivityResultLauncher<Intent> getPreviewWebViewLauncher() {
        return this.previewWebViewLauncher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void previewWebViewLauncher$lambda$7(ConversationActivity conversationActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(activityResult, "result");
        if (activityResult.getResultCode() == -1) {
            conversationActivity.handleStartServerIntent(activityResult.getData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void remoteDeleteMessagePushListener$lambda$9(final ConversationActivity conversationActivity, final IMService.DeleteMessagePushPayload deleteMessagePushPayload) {
        Intrinsics.checkNotNullParameter(deleteMessagePushPayload, "payload");
        conversationActivity.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ConversationActivity.remoteDeleteMessagePushListener$lambda$9$lambda$8(IMService.DeleteMessagePushPayload.this, conversationActivity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void remoteDeleteMessagePushListener$lambda$9$lambda$8(IMService.DeleteMessagePushPayload deleteMessagePushPayload, ConversationActivity conversationActivity) {
        String conversationId = deleteMessagePushPayload.getConversationId();
        ConversationViewModel conversationViewModel = conversationActivity.viewModel;
        ConversationViewModel conversationViewModel2 = null;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        if (!Intrinsics.areEqual(conversationId, conversationViewModel.getConversationId().getValue())) {
            ConversationViewModel conversationViewModel3 = conversationActivity.viewModel;
            if (conversationViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                conversationViewModel2 = conversationViewModel3;
            }
            conversationViewModel2.deleteCachedMessages(deleteMessagePushPayload.getConversationId(), deleteMessagePushPayload.getMessageIds());
            return;
        }
        ConversationViewModel conversationViewModel4 = conversationActivity.viewModel;
        if (conversationViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            conversationViewModel2 = conversationViewModel4;
        }
        conversationViewModel2.deleteMessagesAndReplies(deleteMessagePushPayload.getConversationId(), deleteMessagePushPayload.getMessageIds());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cliStatusChangeListener$lambda$11(final ConversationActivity conversationActivity, final IMService.CliStatusChangePayload cliStatusChangePayload) {
        Intrinsics.checkNotNullParameter(cliStatusChangePayload, "payload");
        conversationActivity.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                ConversationActivity.cliStatusChangeListener$lambda$11$lambda$10(IMService.CliStatusChangePayload.this, conversationActivity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void cliStatusChangeListener$lambda$11$lambda$10(IMService.CliStatusChangePayload cliStatusChangePayload, ConversationActivity conversationActivity) {
        TraeActivityConversationBinding traeActivityConversationBinding = null;
        ConversationViewModel conversationViewModel = null;
        if (!cliStatusChangePayload.getAvailable()) {
            ConversationViewModel conversationViewModel2 = conversationActivity.viewModel;
            if (conversationViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                conversationViewModel2 = null;
            }
            Conversation conversation = (Conversation) conversationViewModel2.getConversation().getValue();
            if (conversation == null) {
                return;
            }
            String environment = conversation.getEnvironment();
            if (!((environment == null || StringsKt.startsWith$default(environment, "local", false, 2, (Object) null)) ? false : true) && Intrinsics.areEqual(conversation.getCliId(), cliStatusChangePayload.getCliId())) {
                TraeActivityConversationBinding traeActivityConversationBinding2 = conversationActivity.binding;
                if (traeActivityConversationBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    traeActivityConversationBinding2 = null;
                }
                traeActivityConversationBinding2.titleBar.setConversationDetailSubtitleIcon(C0591R.drawable.trae_ic_title_bar_computer_offline);
                ConversationViewModel conversationViewModel3 = conversationActivity.viewModel;
                if (conversationViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    conversationViewModel3 = null;
                }
                if (((ConversationViewModel.SessionTurnStatus) conversationViewModel3.getSessionTurnStatus().getValue()) == ConversationViewModel.SessionTurnStatus.STREAMING) {
                    ConversationViewModel conversationViewModel4 = conversationActivity.viewModel;
                    if (conversationViewModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        conversationViewModel = conversationViewModel4;
                    }
                    conversationViewModel.handleCliDisconnected();
                    conversationActivity.getInputFragment().switchInputState(InputFragment.InputState.Input);
                    CustomToast.showLong((Context) conversationActivity, com.bytedance.trae.multilanguage.R.string.trae_device_disconnected);
                    return;
                }
                return;
            }
            return;
        }
        ConversationViewModel conversationViewModel5 = conversationActivity.viewModel;
        if (conversationViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel5 = null;
        }
        Conversation conversation2 = (Conversation) conversationViewModel5.getConversation().getValue();
        if (conversation2 == null) {
            return;
        }
        String environment2 = conversation2.getEnvironment();
        if (!((environment2 == null || StringsKt.startsWith$default(environment2, "local", false, 2, (Object) null)) ? false : true) && Intrinsics.areEqual(conversation2.getCliId(), cliStatusChangePayload.getCliId())) {
            TraeActivityConversationBinding traeActivityConversationBinding3 = conversationActivity.binding;
            if (traeActivityConversationBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                traeActivityConversationBinding = traeActivityConversationBinding3;
            }
            traeActivityConversationBinding.titleBar.setConversationDetailSubtitleIcon(C0591R.drawable.trae_ic_title_bar_computer_online);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void conversationChangeListener$lambda$14(final ConversationActivity conversationActivity, final IMService.ConversationChangeEvent conversationChangeEvent) {
        Intrinsics.checkNotNullParameter(conversationChangeEvent, Fields.EVENT);
        String conversationId = conversationChangeEvent.getConversationId();
        ConversationViewModel conversationViewModel = conversationActivity.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        if (Intrinsics.areEqual(conversationId, conversationViewModel.getConversationId().getValue())) {
            if (Intrinsics.areEqual(conversationChangeEvent.getChangeType(), "delete")) {
                String conversationId2 = conversationChangeEvent.getConversationId();
                if (conversationId2 != null) {
                    BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) conversationActivity), Dispatchers.getIO(), (CoroutineStart) null, new ConversationActivity$conversationChangeListener$1$1$1(conversationActivity, conversationId2, null), 2, (Object) null);
                    return;
                }
                return;
            }
            conversationActivity.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    ConversationActivity.conversationChangeListener$lambda$14$lambda$13(IMService.ConversationChangeEvent.this, conversationActivity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void conversationChangeListener$lambda$14$lambda$13(IMService.ConversationChangeEvent conversationChangeEvent, ConversationActivity conversationActivity) {
        Conversation conversation = conversationChangeEvent.getConversation();
        if (conversation != null) {
            ConversationViewModel conversationViewModel = conversationActivity.viewModel;
            if (conversationViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                conversationViewModel = null;
            }
            conversationViewModel.updateConversation(conversation);
            conversationActivity.updateConversationTitleInfo(conversation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InputFragment getInputFragment() {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(InputFragment.TAG);
        Intrinsics.checkNotNull(findFragmentByTag, "null cannot be cast to non-null type com.bytedance.trae.conversation.widget.InputFragment");
        return (InputFragment) findFragmentByTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConversationDetailFragment getDetailFragment() {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(ConversationDetailFragment.TAG);
        if (findFragmentByTag instanceof ConversationDetailFragment) {
            return (ConversationDetailFragment) findFragmentByTag;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01cd  */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle savedInstanceState) {
        String stringExtra;
        Object obj;
        DeviceProductType deviceProductType;
        ChatMode chatMode;
        ConversationDetailFragment detailFragment;
        boolean z;
        String id;
        super.onCreate(savedInstanceState);
        TraeActivityConversationBinding inflate = TraeActivityConversationBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());
        registerCheckpointKeyboardListener();
        BillingUpgradePromptCoordinator.INSTANCE.prewarm();
        ExpressPassBenefitManager.INSTANCE.init();
        this.viewModel = (ConversationViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(ConversationViewModel.class);
        Serializable serializableExtra = getIntent().getSerializableExtra(EXTRA_CONVERSATION);
        Conversation conversation = serializableExtra instanceof Conversation ? (Conversation) serializableExtra : null;
        if (conversation == null || (stringExtra = conversation.getId()) == null) {
            stringExtra = getIntent().getStringExtra(EXTRA_CONVERSATION_ID);
        }
        this.anchorCreatedAtMs = getIntent().getStringExtra(EXTRA_ANCHOR_CREATED_AT_MS);
        String stringExtra2 = getIntent().getStringExtra(EXTRA_PENDING_CONNECT_DEVICE_TYPE);
        if (stringExtra2 != null) {
            try {
                Result.Companion companion = Result.Companion;
                ConversationActivity conversationActivity = this;
                obj = Result.constructor-impl(DeviceProductType.valueOf(stringExtra2));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            deviceProductType = (DeviceProductType) obj;
        } else {
            deviceProductType = null;
        }
        this.pendingConnectDeviceType = deviceProductType;
        this.suppressNaturalGuideForPendingConnect = deviceProductType != null;
        ConversationViewModel conversationViewModel = this.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        Conversation init = conversationViewModel.init(stringExtra, conversation, this.anchorCreatedAtMs);
        if (conversation == null) {
            conversation = init;
        }
        ConversationViewModel conversationViewModel2 = this.viewModel;
        if (conversationViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel2 = null;
        }
        this.isNewConversation = conversationViewModel2.getIsNewConversation();
        observeManagedPrompts();
        boolean z2 = this.isNewConversation;
        String str = NewTaskTracker.EnterFrom.TASK_LIST;
        if (z2) {
            String stringExtra3 = getIntent().getStringExtra(EXTRA_ENTER_FROM);
            String str2 = stringExtra3 != null ? stringExtra3 : "";
            if (!(str2.length() == 0)) {
                str = str2;
            }
            NewTaskTracker.INSTANCE.trackPageView(str);
        } else {
            String stringExtra4 = getIntent().getStringExtra(EXTRA_ENTER_FROM);
            if (stringExtra4 == null) {
                stringExtra4 = "";
            }
            String str3 = stringExtra4;
            if (!(str3.length() == 0)) {
                str = str3;
            }
            String str4 = str;
            String latestTaskStatus = init != null ? init.getLatestTaskStatus() : null;
            if (latestTaskStatus == null) {
                latestTaskStatus = "";
            }
            String lowerCase = latestTaskStatus.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String str5 = lowerCase;
            if (str5.length() == 0) {
                String status = init != null ? init.getStatus() : null;
                if (status == null) {
                    status = "";
                }
                str5 = status.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(str5, "toLowerCase(...)");
            }
            String str6 = str5;
            NewTaskTracker newTaskTracker = NewTaskTracker.INSTANCE;
            if (stringExtra == null) {
                stringExtra = "";
            }
            newTaskTracker.trackTaskDetailPageView(stringExtra, str6, str4);
        }
        if (conversation != null) {
            ConversationViewModel conversationViewModel3 = this.viewModel;
            if (conversationViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                conversationViewModel3 = null;
            }
            if (conversationViewModel3.shouldCheckIdeProject(conversation) && (id = conversation.getId()) != null) {
                ConversationViewModel conversationViewModel4 = this.viewModel;
                if (conversationViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    conversationViewModel4 = null;
                }
                conversationViewModel4.createTaskCheck(id);
            }
            String id2 = conversation.getId();
            if (id2 != null) {
                if (!Intrinsics.areEqual(conversation.getEnvironment(), CliType.IDE.getValue()) || conversation.getOwnerProjectId() != null) {
                    String mode = conversation.getMode();
                    if (!(mode == null || mode.length() == 0) && (Intrinsics.areEqual(conversation.getEnvironment(), CliType.REMOTE.getValue()) || conversation.getCliConversationId() != null)) {
                        z = false;
                        if (z) {
                            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$onCreate$3$1(id2, this, null), 3, (Object) null);
                        }
                    }
                }
                z = true;
                if (z) {
                }
            }
        }
        if (savedInstanceState == null) {
            FragmentTransaction replace = getSupportFragmentManager().beginTransaction().replace(C0637R.id.detail_fragment_container, ConversationDetailFragment.INSTANCE.newInstance(), ConversationDetailFragment.TAG).replace(C0637R.id.input_fragment_container, InputFragment.INSTANCE.newInstance(), InputFragment.TAG);
            Intrinsics.checkNotNullExpressionValue(replace, "replace(...)");
            if (this.isNewConversation) {
                replace.replace(C0637R.id.welcome_fragment_container, WelcomeFragment.INSTANCE.newInstance(), WelcomeFragment.TAG);
            }
            replace.commitNow();
        }
        if (this.isNewConversation) {
            showWelcomeScreen();
        }
        String stringExtra5 = getIntent().getStringExtra("extra_mode");
        if (stringExtra5 != null) {
            chatMode = Intrinsics.areEqual(stringExtra5, "code") ? ChatMode.CODE : ChatMode.MTC;
        } else {
            chatMode = Intrinsics.areEqual(AccountSettingsKeva.INSTANCE.getKeva().getString(KEY_LAST_CHAT_MODE, (String) null), "code") ? ChatMode.CODE : ChatMode.MTC;
        }
        this.initialChatMode = chatMode;
        initInputFragment();
        initTitleBar();
        initCheckpointDialog();
        observeViewModel();
        String str7 = this.anchorCreatedAtMs;
        if (!(str7 == null || StringsKt.isBlank(str7)) && (detailFragment = getDetailFragment()) != null) {
            detailFragment.setAnchorLoading(true);
        }
        observeMinimizedVoice();
        observeBrainstormEnded();
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        getOnBackPressedDispatcher().addCallback(lifecycleOwner, this.voiceMinimizedBackCallback);
        if (this.isNewConversation) {
            observeStarbucks();
        }
        IMService.INSTANCE.addConversationChangeListener(this.conversationChangeListener);
        MessageManager.INSTANCE.addDeleteMessageListener(this.deleteMessageListener);
        MessageManager.INSTANCE.addDeleteConversationListener(this.deleteConversationListener);
        MessageManager.INSTANCE.addRevertMessageListener(this.revertMessageListener);
        IMService.INSTANCE.addCliStatusChangeListener(this.cliStatusChangeListener);
        IMService.INSTANCE.addRemoteDeleteMessagePushListener(this.remoteDeleteMessagePushListener);
        TraeActivityConversationBinding traeActivityConversationBinding = this.binding;
        if (traeActivityConversationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityConversationBinding = null;
        }
        traeActivityConversationBinding.btnRetryLoad.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda55
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConversationActivity.onCreate$lambda$22(ConversationActivity.this, view);
            }
        });
        ConversationDetailFragment detailFragment2 = getDetailFragment();
        if (detailFragment2 != null) {
            detailFragment2.setOnLoadMore(new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda62
                public final Object invoke() {
                    Unit onCreate$lambda$24;
                    onCreate$lambda$24 = ConversationActivity.onCreate$lambda$24(ConversationActivity.this);
                    return onCreate$lambda$24;
                }
            });
        }
        ConversationDetailFragment detailFragment3 = getDetailFragment();
        if (detailFragment3 != null) {
            detailFragment3.setOnLoadNewer(new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda63
                public final Object invoke() {
                    Unit onCreate$lambda$26;
                    onCreate$lambda$26 = ConversationActivity.onCreate$lambda$26(ConversationActivity.this);
                    return onCreate$lambda$26;
                }
            });
        }
        ConversationDetailFragment detailFragment4 = getDetailFragment();
        if (detailFragment4 != null) {
            detailFragment4.setOnJumpToBottomClick(new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda64
                public final Object invoke() {
                    boolean exitAnchorWindowAndShowLatestPage;
                    exitAnchorWindowAndShowLatestPage = ConversationActivity.this.exitAnchorWindowAndShowLatestPage();
                    return Boolean.valueOf(exitAnchorWindowAndShowLatestPage);
                }
            });
        }
        ConversationDetailFragment detailFragment5 = getDetailFragment();
        if (detailFragment5 != null) {
            detailFragment5.setOnRetryClick(new Function1() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda1
                public final Object invoke(Object obj2) {
                    Unit onCreate$lambda$29;
                    onCreate$lambda$29 = ConversationActivity.onCreate$lambda$29(ConversationActivity.this, (String) obj2);
                    return onCreate$lambda$29;
                }
            });
        }
        ConversationDetailFragment detailFragment6 = getDetailFragment();
        if (detailFragment6 != null) {
            detailFragment6.setOnUseExpressPassClick(new Function1() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda2
                public final Object invoke(Object obj2) {
                    Unit onCreate$lambda$30;
                    onCreate$lambda$30 = ConversationActivity.onCreate$lambda$30(ConversationActivity.this, (String) obj2);
                    return onCreate$lambda$30;
                }
            });
        }
        ConversationDetailFragment detailFragment7 = getDetailFragment();
        if (detailFragment7 != null) {
            detailFragment7.setOnFeedbackClick(new Function2() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda3
                public final Object invoke(Object obj2, Object obj3) {
                    Unit onCreate$lambda$31;
                    onCreate$lambda$31 = ConversationActivity.onCreate$lambda$31(ConversationActivity.this, (String) obj2, (String) obj3);
                    return onCreate$lambda$31;
                }
            });
        }
        ConversationDetailFragment detailFragment8 = getDetailFragment();
        if (detailFragment8 != null) {
            detailFragment8.setOnCopyClick(new Function1() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda4
                public final Object invoke(Object obj2) {
                    Unit onCreate$lambda$32;
                    onCreate$lambda$32 = ConversationActivity.onCreate$lambda$32(ConversationActivity.this, (String) obj2);
                    return onCreate$lambda$32;
                }
            });
        }
        ConversationDetailFragment detailFragment9 = getDetailFragment();
        if (detailFragment9 != null) {
            detailFragment9.setOnReportClick(new Function2() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda5
                public final Object invoke(Object obj2, Object obj3) {
                    Unit onCreate$lambda$33;
                    onCreate$lambda$33 = ConversationActivity.onCreate$lambda$33(ConversationActivity.this, (String) obj2, (String) obj3);
                    return onCreate$lambda$33;
                }
            });
        }
        ConversationDetailFragment detailFragment10 = getDetailFragment();
        if (detailFragment10 != null) {
            detailFragment10.setOnUserScrolled(new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda6
                public final Object invoke() {
                    Unit onCreate$lambda$34;
                    onCreate$lambda$34 = ConversationActivity.onCreate$lambda$34(ConversationActivity.this);
                    return onCreate$lambda$34;
                }
            });
        }
        ConversationDetailFragment detailFragment11 = getDetailFragment();
        if (detailFragment11 != null) {
            detailFragment11.setOnUpgradeReminderClick(new Function1() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda61
                public final Object invoke(Object obj2) {
                    Unit onCreate$lambda$35;
                    onCreate$lambda$35 = ConversationActivity.onCreate$lambda$35(ConversationActivity.this, (String) obj2);
                    return onCreate$lambda$35;
                }
            });
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$onCreate$15(null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$onCreate$16(null), 3, (Object) null);
        requestNotificationPermissionIfNeeded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$22(ConversationActivity conversationActivity, View view) {
        TraeActivityConversationBinding traeActivityConversationBinding = conversationActivity.binding;
        ConversationViewModel conversationViewModel = null;
        if (traeActivityConversationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityConversationBinding = null;
        }
        traeActivityConversationBinding.layoutLoadError.setVisibility(8);
        TraeActivityConversationBinding traeActivityConversationBinding2 = conversationActivity.binding;
        if (traeActivityConversationBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityConversationBinding2 = null;
        }
        traeActivityConversationBinding2.detailFragmentContainer.setVisibility(0);
        TraeActivityConversationBinding traeActivityConversationBinding3 = conversationActivity.binding;
        if (traeActivityConversationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityConversationBinding3 = null;
        }
        traeActivityConversationBinding3.inputFragmentContainer.setVisibility(0);
        ConversationViewModel conversationViewModel2 = conversationActivity.viewModel;
        if (conversationViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            conversationViewModel = conversationViewModel2;
        }
        conversationViewModel.retryLoad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$24(final ConversationActivity conversationActivity) {
        ConversationViewModel conversationViewModel = conversationActivity.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        conversationViewModel.loadMoreMessages(new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda42
            public final Object invoke() {
                Unit onCreate$lambda$24$lambda$23;
                onCreate$lambda$24$lambda$23 = ConversationActivity.onCreate$lambda$24$lambda$23(ConversationActivity.this);
                return onCreate$lambda$24$lambda$23;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$24$lambda$23(ConversationActivity conversationActivity) {
        Fragment findFragmentByTag = conversationActivity.getSupportFragmentManager().findFragmentByTag(ConversationDetailFragment.TAG);
        ConversationDetailFragment conversationDetailFragment = findFragmentByTag instanceof ConversationDetailFragment ? (ConversationDetailFragment) findFragmentByTag : null;
        if (conversationDetailFragment != null) {
            conversationDetailFragment.setLoadingMore(false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$26(final ConversationActivity conversationActivity) {
        ConversationViewModel conversationViewModel = conversationActivity.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        conversationViewModel.loadNewerAnchorMessages(new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda60
            public final Object invoke() {
                Unit onCreate$lambda$26$lambda$25;
                onCreate$lambda$26$lambda$25 = ConversationActivity.onCreate$lambda$26$lambda$25(ConversationActivity.this);
                return onCreate$lambda$26$lambda$25;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$26$lambda$25(ConversationActivity conversationActivity) {
        ConversationDetailFragment detailFragment = conversationActivity.getDetailFragment();
        if (detailFragment != null) {
            detailFragment.setLoadingNewer(false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$29(ConversationActivity conversationActivity, String str) {
        Object obj;
        String str2;
        Intrinsics.checkNotNullParameter(str, "assistantMessageId");
        SoloChatMode resolveCurrentChatMode$default = resolveCurrentChatMode$default(conversationActivity, null, 1, null);
        RemoteModelItem selectedModelForRequest = conversationActivity.getInputFragment().getSelectedModelForRequest();
        ConversationViewModel conversationViewModel = conversationActivity.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        List list = (List) conversationViewModel.getMessages().getValue();
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((ParsedChatMessage) obj).getMessageId(), str)) {
                break;
            }
        }
        ParsedChatMessage parsedChatMessage = (ParsedChatMessage) obj;
        String taskId = parsedChatMessage != null ? IMMessageKt.getTaskId(parsedChatMessage) : null;
        String str3 = taskId == null ? "" : taskId;
        ConversationViewModel conversationViewModel2 = conversationActivity.viewModel;
        if (conversationViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel2 = null;
        }
        String str4 = (String) conversationViewModel2.getConversationId().getValue();
        String str5 = str4 == null ? "" : str4;
        if (selectedModelForRequest == null || (str2 = selectedModelForRequest.getName()) == null) {
            str2 = ModelSelectionConstants.AUTO;
        }
        TraeAITracker.INSTANCE.trackRetryClick(new AIEventContext(null, str5, str, str2, 1, null), str3, resolveCurrentChatMode$default);
        conversationActivity.hasReportedStreamShow = false;
        conversationActivity.streamingStartTimeMs = SystemClock.elapsedRealtime();
        conversationActivity.wasUserInitiatedCancel = false;
        conversationActivity.streamingMessageId = null;
        conversationActivity.streamingChatModel = null;
        ConversationViewModel conversationViewModel3 = conversationActivity.viewModel;
        if (conversationViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel3 = null;
        }
        ConversationViewModel.retryMessage$default(conversationViewModel3, str, list, selectedModelForRequest, false, 8, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$30(ConversationActivity conversationActivity, String str) {
        Intrinsics.checkNotNullParameter(str, "assistantMessageId");
        if (TocCreditsPolicy.INSTANCE.isEnabled()) {
            return Unit.INSTANCE;
        }
        RemoteModelItem selectedModelForRequest = conversationActivity.getInputFragment().getSelectedModelForRequest();
        conversationActivity.hasReportedStreamShow = false;
        conversationActivity.streamingStartTimeMs = SystemClock.elapsedRealtime();
        conversationActivity.wasUserInitiatedCancel = false;
        ConversationViewModel conversationViewModel = null;
        conversationActivity.streamingMessageId = null;
        conversationActivity.streamingChatModel = null;
        ConversationViewModel conversationViewModel2 = conversationActivity.viewModel;
        if (conversationViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel2 = null;
        }
        ConversationViewModel conversationViewModel3 = conversationActivity.viewModel;
        if (conversationViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            conversationViewModel = conversationViewModel3;
        }
        conversationViewModel2.retryMessage(str, (List) conversationViewModel.getMessages().getValue(), selectedModelForRequest, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$31(ConversationActivity conversationActivity, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        Intrinsics.checkNotNullParameter(str2, "resultType");
        conversationActivity.trackFeedback(str, str2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$32(ConversationActivity conversationActivity, String str) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        conversationActivity.trackCopy(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$33(ConversationActivity conversationActivity, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        Intrinsics.checkNotNullParameter(str2, ReportConstant.COMMON_CONTENT);
        conversationActivity.submitReport(str, str2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$34(ConversationActivity conversationActivity) {
        conversationActivity.getInputFragment().hideKeyboard();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onCreate$lambda$35(ConversationActivity conversationActivity, String str) {
        Intrinsics.checkNotNullParameter(str, "conversationId");
        ConversationViewModel conversationViewModel = conversationActivity.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        conversationViewModel.dismissUpgradeReminder(str);
        if (!UpgradeReminderUpdateActionSpy.INSTANCE.record(false)) {
            if (AppHost.INSTANCE.isOversea()) {
                conversationActivity.openAppInPlayStore((Context) conversationActivity);
            } else {
                AppUpdateChecker.INSTANCE.checkUpdate(false);
            }
        }
        return Unit.INSTANCE;
    }

    private final void requestNotificationPermissionIfNeeded() {
        if (this.notificationPermissionRequested) {
            return;
        }
        this.notificationPermissionRequested = true;
        TraeActivityConversationBinding traeActivityConversationBinding = this.binding;
        if (traeActivityConversationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityConversationBinding = null;
        }
        traeActivityConversationBinding.getRoot().postDelayed(new Runnable() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda44
            @Override // java.lang.Runnable
            public final void run() {
                ConversationActivity.requestNotificationPermissionIfNeeded$lambda$36(ConversationActivity.this);
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestNotificationPermissionIfNeeded$lambda$36(ConversationActivity conversationActivity) {
        if (conversationActivity.isFinishing() || conversationActivity.isDestroyed()) {
            return;
        }
        IPushService.Companion.requestNotificationPermission();
    }

    private final void openAppInPlayStore(Context context) {
        String packageName = context.getPackageName();
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName));
            intent.setPackage("com.android.vending");
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
            intent2.addFlags(268435456);
            context.startActivity(intent2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissPluginAuthBottomSheetIfShowing() {
        PluginAuthorizationBottomSheet findFragmentByTag = getSupportFragmentManager().findFragmentByTag(PluginAuthorizationBottomSheet.TAG);
        if (findFragmentByTag instanceof PluginAuthorizationBottomSheet) {
            FLogger.INSTANCE.i(CHECK_POINT_TAG, "dismissPluginAuthBottomSheetIfShowing: dismissing");
            findFragmentByTag.dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0069 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[LOOP:1: B:58:0x0041->B:73:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void checkConfirmRequired(ParsedChatMessage message, String taskId, String conversationId) {
        boolean z;
        boolean z2;
        Object obj;
        List<ParsedPlanItem> items = IMMessageKt.getItems(message);
        TraeActivityConversationBinding traeActivityConversationBinding = null;
        if (this.isCheckpointDialogVisible) {
            FLogger.INSTANCE.i(CHECK_POINT_TAG, "checkConfirmRequired: isCheckpointDialogVisible, showingCheckpointToolCallId=" + this.showingCheckpointToolCallId);
            List<ParsedPlanItem> list = items;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (ParsedPlanItem parsedPlanItem : list) {
                    if (parsedPlanItem.getConfirmInfo() != null) {
                        ConfirmInfo confirmInfo = parsedPlanItem.getConfirmInfo();
                        if (confirmInfo != null && confirmInfo.isWaitingConfirm()) {
                            z = true;
                            if (!z) {
                                z2 = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                }
            }
            z2 = false;
            if (z2) {
                FLogger.INSTANCE.i(CHECK_POINT_TAG, "checkConfirmRequired: items is isWaitingConfirm");
                return;
            }
            String str = this.showingCheckpointToolCallId;
            if (str != null) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    ParsedToolCallInfo toolCallInfo = ((ParsedPlanItem) obj).getToolCallInfo();
                    if (Intrinsics.areEqual(toolCallInfo != null ? toolCallInfo.getId() : null, str)) {
                        break;
                    }
                }
                ParsedPlanItem parsedPlanItem2 = (ParsedPlanItem) obj;
                ConfirmInfo confirmInfo2 = parsedPlanItem2 != null ? parsedPlanItem2.getConfirmInfo() : null;
                String confirmStatus = confirmInfo2 != null ? confirmInfo2.getConfirmStatus() : null;
                if (!(confirmInfo2 != null && confirmInfo2.isEnterpriseCommandBlacklist()) && (confirmStatus == null || Intrinsics.areEqual(confirmStatus, ConfirmInfo.STATUS_UNCONFIRMED))) {
                    FLogger.INSTANCE.i(CHECK_POINT_TAG, "checkConfirmRequired: showing toolCallId=" + str + " confirmStatus=" + confirmStatus + ", keep dialog");
                    return;
                }
                FLogger.INSTANCE.i(CHECK_POINT_TAG, "checkConfirmRequired: showing toolCallId=" + str + " confirmStatus=" + confirmStatus + ", dismiss");
            }
            CheckpointDialog.Companion companion = CheckpointDialog.INSTANCE;
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            companion.dismissIfShowing(supportFragmentManager);
            dismissPluginAuthBottomSheetIfShowing();
            this.isCheckpointDialogVisible = false;
            this.showingCheckpointToolCallId = null;
            TraeActivityConversationBinding traeActivityConversationBinding2 = this.binding;
            if (traeActivityConversationBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                traeActivityConversationBinding2 = null;
            }
            traeActivityConversationBinding2.checkpointOverlayContainer.setTranslationY(0.0f);
            TraeActivityConversationBinding traeActivityConversationBinding3 = this.binding;
            if (traeActivityConversationBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                traeActivityConversationBinding3 = null;
            }
            traeActivityConversationBinding3.checkpointOverlayContainer.setVisibility(8);
            TraeActivityConversationBinding traeActivityConversationBinding4 = this.binding;
            if (traeActivityConversationBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                traeActivityConversationBinding4 = null;
            }
            traeActivityConversationBinding4.inputFragmentContainer.setVisibility(0);
        }
        if (message.isHistory()) {
            FLogger.INSTANCE.i(CHECK_POINT_TAG, "checkConfirmRequired: skip history message");
            return;
        }
        for (ParsedPlanItem parsedPlanItem3 : items) {
            ConfirmInfo confirmInfo3 = parsedPlanItem3.getConfirmInfo();
            if (confirmInfo3 != null && confirmInfo3.isWaitingConfirm() && parsedPlanItem3.getToolCallInfo() != null) {
                String id = parsedPlanItem3.getId();
                if (id == null || id.length() == 0) {
                    continue;
                } else {
                    ParsedToolCallInfo toolCallInfo2 = parsedPlanItem3.getToolCallInfo();
                    String id2 = toolCallInfo2 != null ? toolCallInfo2.getId() : null;
                    String str2 = id2;
                    if (str2 == null || str2.length() == 0) {
                        FLogger.INSTANCE.i(CHECK_POINT_TAG, "checkConfirmRequired: skip empty toolCallId");
                    } else {
                        if (!(str2 == null || str2.length() == 0)) {
                            ConversationViewModel conversationViewModel = this.viewModel;
                            if (conversationViewModel == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                conversationViewModel = null;
                            }
                            if (!conversationViewModel.shouldShowCheckpoint(id2)) {
                                FLogger.INSTANCE.i(CHECK_POINT_TAG, "checkConfirmRequired: skip duplicate toolCallId=" + id2);
                            }
                        }
                        TraeActivityConversationBinding traeActivityConversationBinding5 = this.binding;
                        if (traeActivityConversationBinding5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            traeActivityConversationBinding5 = null;
                        }
                        traeActivityConversationBinding5.inputFragmentContainer.setVisibility(8);
                        TraeActivityConversationBinding traeActivityConversationBinding6 = this.binding;
                        if (traeActivityConversationBinding6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            traeActivityConversationBinding6 = null;
                        }
                        traeActivityConversationBinding6.checkpointOverlayContainer.setVisibility(0);
                        FLogger.INSTANCE.i(CHECK_POINT_TAG, "checkConfirmRequired: showCheckpointDialog item=" + parsedPlanItem3 + ", taskId=" + taskId + ", conversationId=" + conversationId);
                        CheckpointDialogManager checkpointDialogManager = CheckpointDialogManager.INSTANCE;
                        FragmentManager supportFragmentManager2 = getSupportFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
                        checkpointDialogManager.showCheckpointDialog(supportFragmentManager2, parsedPlanItem3, taskId, conversationId, message.getMessageId(), resolveCurrentChatMode$default(this, null, 1, null).getValue());
                        this.isCheckpointDialogVisible = true;
                        this.showingCheckpointToolCallId = id2;
                        TraeActivityConversationBinding traeActivityConversationBinding7 = this.binding;
                        if (traeActivityConversationBinding7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            traeActivityConversationBinding = traeActivityConversationBinding7;
                        }
                        traeActivityConversationBinding.checkpointOverlayContainer.post(new Runnable() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda14
                            @Override // java.lang.Runnable
                            public final void run() {
                                ConversationActivity.this.syncCheckpointOverlayWithKeyboard();
                            }
                        });
                        return;
                    }
                }
            }
        }
    }

    private final void registerCheckpointKeyboardListener() {
        if (this.isCheckpointKeyboardListenerRegistered) {
            return;
        }
        TraeActivityConversationBinding traeActivityConversationBinding = this.binding;
        if (traeActivityConversationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityConversationBinding = null;
        }
        traeActivityConversationBinding.getRoot().getViewTreeObserver().addOnGlobalLayoutListener(this.checkpointKeyboardLayoutListener);
        this.isCheckpointKeyboardListenerRegistered = true;
    }

    private final void unregisterCheckpointKeyboardListener() {
        if (this.isCheckpointKeyboardListenerRegistered) {
            TraeActivityConversationBinding traeActivityConversationBinding = this.binding;
            if (traeActivityConversationBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                traeActivityConversationBinding = null;
            }
            ViewTreeObserver viewTreeObserver = traeActivityConversationBinding.getRoot().getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnGlobalLayoutListener(this.checkpointKeyboardLayoutListener);
            }
            this.isCheckpointKeyboardListenerRegistered = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncCheckpointOverlayWithKeyboard() {
        TraeActivityConversationBinding traeActivityConversationBinding = this.binding;
        TraeActivityConversationBinding traeActivityConversationBinding2 = null;
        if (traeActivityConversationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityConversationBinding = null;
        }
        FragmentContainerView fragmentContainerView = traeActivityConversationBinding.checkpointOverlayContainer;
        Intrinsics.checkNotNullExpressionValue(fragmentContainerView, "checkpointOverlayContainer");
        if (fragmentContainerView.getVisibility() != 0 || fragmentContainerView.getHeight() == 0) {
            fragmentContainerView.setTranslationY(0.0f);
            return;
        }
        TraeActivityConversationBinding traeActivityConversationBinding3 = this.binding;
        if (traeActivityConversationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            traeActivityConversationBinding2 = traeActivityConversationBinding3;
        }
        ConstraintLayout root = traeActivityConversationBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.getWindowVisibleDisplayFrame(this.checkpointVisibleFrame);
        int height = root.getRootView().getHeight();
        if (!(((float) (height - this.checkpointVisibleFrame.bottom)) > ((float) height) * KEYBOARD_VISIBLE_THRESHOLD)) {
            fragmentContainerView.setTranslationY(0.0f);
            return;
        }
        fragmentContainerView.getLocationOnScreen(this.checkpointOverlayLocation);
        float translationY = ((this.checkpointOverlayLocation[1] - fragmentContainerView.getTranslationY()) + fragmentContainerView.getHeight()) - this.checkpointVisibleFrame.bottom;
        fragmentContainerView.setTranslationY(translationY > 0.0f ? -translationY : 0.0f);
    }

    private final void observeViewModel() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$1(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$2(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$3(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$4(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$5(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$6(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$7(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$8(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$9(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$10(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$11(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$12(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$13(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$14(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$15(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$16(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$17(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$18(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$19(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$20(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$21(this, null), 3, (Object) null);
        getInputFragment().setOnPauseClickListener(new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda30
            public final Object invoke() {
                Unit observeViewModel$lambda$42;
                observeViewModel$lambda$42 = ConversationActivity.observeViewModel$lambda$42(ConversationActivity.this);
                return observeViewModel$lambda$42;
            }
        });
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$23(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$24(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeViewModel$25(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$42(ConversationActivity conversationActivity) {
        conversationActivity.wasUserInitiatedCancel = true;
        ConversationViewModel conversationViewModel = conversationActivity.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        conversationViewModel.cancelCurrentTask();
        return Unit.INSTANCE;
    }

    private final void observeStarbucks() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeStarbucks$1(this, null), 3, (Object) null);
    }

    private final void initCheckpointDialog() {
        CheckpointDialogManager.INSTANCE.init(new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda43
            public final Object invoke() {
                Context initCheckpointDialog$lambda$43;
                initCheckpointDialog$lambda$43 = ConversationActivity.initCheckpointDialog$lambda$43(ConversationActivity.this);
                return initCheckpointDialog$lambda$43;
            }
        });
        CheckpointDialogManager.INSTANCE.setContainerId(C0637R.id.checkpoint_overlay_container);
        CheckpointDialogManager.INSTANCE.setOnDismissAction(new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda45
            public final Object invoke() {
                Unit initCheckpointDialog$lambda$44;
                initCheckpointDialog$lambda$44 = ConversationActivity.initCheckpointDialog$lambda$44(ConversationActivity.this);
                return initCheckpointDialog$lambda$44;
            }
        });
        CheckpointDialogManager.INSTANCE.setInteractionCallback(new CheckpointInteractionCallback() { // from class: com.bytedance.trae.conversation.ConversationActivity$initCheckpointDialog$3
            @Override // com.bytedance.trae.conversation.chat.checkpoint.CheckpointInteractionCallback
            public void onDecision(CheckpointDecision decision) {
                ConversationViewModel conversationViewModel;
                Intrinsics.checkNotNullParameter(decision, "decision");
                conversationViewModel = ConversationActivity.this.viewModel;
                if (conversationViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    conversationViewModel = null;
                }
                conversationViewModel.handleCheckpointDecision(decision);
            }
        });
        CheckpointDialogManager.INSTANCE.setOnFileClick(new Function2() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda46
            public final Object invoke(Object obj, Object obj2) {
                Unit initCheckpointDialog$lambda$45;
                initCheckpointDialog$lambda$45 = ConversationActivity.initCheckpointDialog$lambda$45(ConversationActivity.this, (String) obj, (String) obj2);
                return initCheckpointDialog$lambda$45;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Context initCheckpointDialog$lambda$43(ConversationActivity conversationActivity) {
        Context applicationContext = conversationActivity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return applicationContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initCheckpointDialog$lambda$44(ConversationActivity conversationActivity) {
        TraeActivityConversationBinding traeActivityConversationBinding = conversationActivity.binding;
        if (traeActivityConversationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityConversationBinding = null;
        }
        traeActivityConversationBinding.checkpointOverlayContainer.setTranslationY(0.0f);
        TraeActivityConversationBinding traeActivityConversationBinding2 = conversationActivity.binding;
        if (traeActivityConversationBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityConversationBinding2 = null;
        }
        traeActivityConversationBinding2.checkpointOverlayContainer.setVisibility(8);
        TraeActivityConversationBinding traeActivityConversationBinding3 = conversationActivity.binding;
        if (traeActivityConversationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityConversationBinding3 = null;
        }
        traeActivityConversationBinding3.inputFragmentContainer.setVisibility(0);
        conversationActivity.isCheckpointDialogVisible = false;
        conversationActivity.showingCheckpointToolCallId = null;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initCheckpointDialog$lambda$45(ConversationActivity conversationActivity, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        conversationActivity.openFile(str, str2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0086 A[Catch: Exception -> 0x00d7, TryCatch #0 {Exception -> 0x00d7, blocks: (B:3:0x000a, B:6:0x0023, B:7:0x0027, B:9:0x003e, B:10:0x0042, B:12:0x004e, B:13:0x0054, B:15:0x0060, B:19:0x007d, B:21:0x0086, B:22:0x008a, B:24:0x0096, B:31:0x00a9, B:33:0x00b0, B:34:0x00b4, B:36:0x00c0, B:39:0x00cb, B:47:0x006f), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0096 A[Catch: Exception -> 0x00d7, TRY_LEAVE, TryCatch #0 {Exception -> 0x00d7, blocks: (B:3:0x000a, B:6:0x0023, B:7:0x0027, B:9:0x003e, B:10:0x0042, B:12:0x004e, B:13:0x0054, B:15:0x0060, B:19:0x007d, B:21:0x0086, B:22:0x008a, B:24:0x0096, B:31:0x00a9, B:33:0x00b0, B:34:0x00b4, B:36:0x00c0, B:39:0x00cb, B:47:0x006f), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b0 A[Catch: Exception -> 0x00d7, TryCatch #0 {Exception -> 0x00d7, blocks: (B:3:0x000a, B:6:0x0023, B:7:0x0027, B:9:0x003e, B:10:0x0042, B:12:0x004e, B:13:0x0054, B:15:0x0060, B:19:0x007d, B:21:0x0086, B:22:0x008a, B:24:0x0096, B:31:0x00a9, B:33:0x00b0, B:34:0x00b4, B:36:0x00c0, B:39:0x00cb, B:47:0x006f), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c0 A[Catch: Exception -> 0x00d7, TryCatch #0 {Exception -> 0x00d7, blocks: (B:3:0x000a, B:6:0x0023, B:7:0x0027, B:9:0x003e, B:10:0x0042, B:12:0x004e, B:13:0x0054, B:15:0x0060, B:19:0x007d, B:21:0x0086, B:22:0x008a, B:24:0x0096, B:31:0x00a9, B:33:0x00b0, B:34:0x00b4, B:36:0x00c0, B:39:0x00cb, B:47:0x006f), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void openFile(String filePath, String messageId) {
        ConversationViewModel conversationViewModel;
        ConversationViewModel conversationViewModel2;
        String str = filePath;
        try {
            FLogger fLogger = FLogger.INSTANCE;
            StringBuilder append = new StringBuilder("openFile filePath: ").append(str).append(", conversation: ");
            ConversationViewModel conversationViewModel3 = this.viewModel;
            if (conversationViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                conversationViewModel3 = null;
            }
            fLogger.i(CHECK_POINT_TAG, append.append(conversationViewModel3.getConversation().getValue()).toString());
            ConversationViewModel conversationViewModel4 = this.viewModel;
            if (conversationViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                conversationViewModel4 = null;
            }
            Conversation conversation = (Conversation) conversationViewModel4.getConversation().getValue();
            String environment = conversation != null ? conversation.getEnvironment() : null;
            if (!Intrinsics.areEqual(environment, CliType.LOCAL.getValue())) {
                if (Intrinsics.areEqual(environment, CliType.IDE.getValue())) {
                }
                String str2 = str;
                ArtifactPreviewActivity.Companion companion = ArtifactPreviewActivity.INSTANCE;
                Context context = (Context) this;
                conversationViewModel = this.viewModel;
                if (conversationViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    conversationViewModel = null;
                }
                Conversation conversation2 = (Conversation) conversationViewModel.getConversation().getValue();
                String cliConversationId = conversation2 == null ? conversation2.getCliConversationId() : null;
                String str3 = cliConversationId != null ? "" : cliConversationId;
                String str4 = environment != null ? "" : environment;
                Intrinsics.checkNotNull(messageId);
                conversationViewModel2 = this.viewModel;
                if (conversationViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    conversationViewModel2 = null;
                }
                Conversation conversation3 = (Conversation) conversationViewModel2.getConversation().getValue();
                String id = conversation3 != null ? conversation3.getId() : null;
                ArtifactPreviewActivity.Companion.start$default(companion, context, str3, null, str4, str2, messageId, id != null ? "" : id, 0L, 132, null);
            }
            str = "files" + str;
            String str22 = str;
            ArtifactPreviewActivity.Companion companion2 = ArtifactPreviewActivity.INSTANCE;
            Context context2 = (Context) this;
            conversationViewModel = this.viewModel;
            if (conversationViewModel == null) {
            }
            Conversation conversation22 = (Conversation) conversationViewModel.getConversation().getValue();
            if (conversation22 == null) {
            }
            if (cliConversationId != null) {
            }
            if (environment != null) {
            }
            Intrinsics.checkNotNull(messageId);
            conversationViewModel2 = this.viewModel;
            if (conversationViewModel2 == null) {
            }
            Conversation conversation32 = (Conversation) conversationViewModel2.getConversation().getValue();
            if (conversation32 != null) {
            }
            ArtifactPreviewActivity.Companion.start$default(companion2, context2, str3, null, str4, str22, messageId, id != null ? "" : id, 0L, 132, null);
        } catch (Exception e) {
            FLogger.INSTANCE.e(CHECK_POINT_TAG, "openFile error", e);
        }
    }

    private final void initTitleBar() {
        ConversationViewModel conversationViewModel = this.viewModel;
        TraeActivityConversationBinding traeActivityConversationBinding = null;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        Conversation conversation = (Conversation) conversationViewModel.getConversation().getValue();
        if (conversation != null) {
            updateConversationTitleInfo(conversation);
        } else {
            TraeActivityConversationBinding traeActivityConversationBinding2 = this.binding;
            if (traeActivityConversationBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                traeActivityConversationBinding2 = null;
            }
            traeActivityConversationBinding2.titleBar.showNewConversationHeader();
        }
        TraeActivityConversationBinding traeActivityConversationBinding3 = this.binding;
        if (traeActivityConversationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityConversationBinding3 = null;
        }
        traeActivityConversationBinding3.titleBar.setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda54
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConversationActivity.initTitleBar$lambda$46(ConversationActivity.this, view);
            }
        });
        TraeActivityConversationBinding traeActivityConversationBinding4 = this.binding;
        if (traeActivityConversationBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityConversationBinding4 = null;
        }
        traeActivityConversationBinding4.titleBar.setOnRightActionClickListener(0, new View.OnClickListener() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda56
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConversationActivity.initTitleBar$lambda$48(ConversationActivity.this, view);
            }
        });
        TraeActivityConversationBinding traeActivityConversationBinding5 = this.binding;
        if (traeActivityConversationBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityConversationBinding5 = null;
        }
        traeActivityConversationBinding5.titleBar.setOnRightActionClickListener(1, new View.OnClickListener() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda57
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConversationActivity.initTitleBar$lambda$49(ConversationActivity.this, view);
            }
        });
        updateModeTab(ChatMode.MTC);
        TraeActivityConversationBinding traeActivityConversationBinding6 = this.binding;
        if (traeActivityConversationBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            traeActivityConversationBinding = traeActivityConversationBinding6;
        }
        traeActivityConversationBinding.titleBar.setOnSegmentedTabSelectedListener(new Function2() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda58
            public final Object invoke(Object obj, Object obj2) {
                Unit initTitleBar$lambda$53;
                initTitleBar$lambda$53 = ConversationActivity.initTitleBar$lambda$53(ConversationActivity.this, ((Integer) obj).intValue(), (String) obj2);
                return initTitleBar$lambda$53;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTitleBar$lambda$46(ConversationActivity conversationActivity, View view) {
        conversationActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initTitleBar$lambda$48(ConversationActivity conversationActivity, View view) {
        if (BrainstormSessionHolder.INSTANCE.isMinimized() && conversationActivity.iLaunchedActiveBrainstorm) {
            conversationActivity.showEndVoiceDiscussionDialog();
            return;
        }
        conversationActivity.finish();
        Intent intent = new Intent((Context) conversationActivity, (Class<?>) ConversationActivity.class);
        ConversationViewModel conversationViewModel = conversationActivity.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        Conversation conversation = (Conversation) conversationViewModel.getConversation().getValue();
        intent.putExtra("extra_mode", conversation != null ? conversation.getMode() : null);
        intent.putExtra(EXTRA_ENTER_FROM, NewTaskTracker.EnterFrom.HISTORY_CHAT);
        conversationActivity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initTitleBar$lambda$49(final ConversationActivity conversationActivity, View view) {
        MenuPopupWindow menuPopupWindow = conversationActivity.menuPopupWindow;
        if (menuPopupWindow != null && menuPopupWindow.isShowing()) {
            MenuPopupWindow menuPopupWindow2 = conversationActivity.menuPopupWindow;
            if (menuPopupWindow2 != null) {
                menuPopupWindow2.dismiss();
                return;
            }
            return;
        }
        ConversationViewModel conversationViewModel = conversationActivity.viewModel;
        ConversationViewModel conversationViewModel2 = null;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        Conversation conversation = (Conversation) conversationViewModel.getConversation().getValue();
        boolean z = !Intrinsics.areEqual(conversation != null ? conversation.getMode() : null, "code");
        ConversationViewModel conversationViewModel3 = conversationActivity.viewModel;
        if (conversationViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel3 = null;
        }
        boolean z2 = conversationViewModel3.supportsPin() && FeatureCapability.INSTANCE.isEnabled(Feature.TASK_LIST_PIN);
        ConversationViewModel conversationViewModel4 = conversationActivity.viewModel;
        if (conversationViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel4 = null;
        }
        Conversation conversation2 = (Conversation) conversationViewModel4.getConversation().getValue();
        MenuPopupWindow menuPopupWindow3 = new MenuPopupWindow((Context) conversationActivity, new MenuPopupWindow.OnMenuClickListener() { // from class: com.bytedance.trae.conversation.ConversationActivity$initTitleBar$3$1
            /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.trae.conversation.ConversationActivity, android.app.Activity] */
            @Override // com.bytedance.trae.conversation.widget.MenuPopupWindow.OnMenuClickListener
            public void onExtractClick() {
                MenuPopupWindow menuPopupWindow4;
                ConversationViewModel conversationViewModel5;
                ?? r0 = ConversationActivity.this;
                menuPopupWindow4 = ((ConversationActivity) r0).menuPopupWindow;
                if (menuPopupWindow4 != null) {
                    menuPopupWindow4.dismiss();
                }
                conversationViewModel5 = ((ConversationActivity) r0).viewModel;
                if (conversationViewModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    conversationViewModel5 = null;
                }
                Conversation conversation3 = (Conversation) conversationViewModel5.getConversation().getValue();
                if (conversation3 != null) {
                    String latestTaskId = conversation3.getLatestTaskId();
                    if (latestTaskId == null) {
                        latestTaskId = "";
                    }
                    String title = conversation3.getTitle();
                    if (title == null) {
                        title = "conversation";
                    }
                    ExtractHelper.INSTANCE.start((Activity) r0, latestTaskId, title);
                }
            }

            @Override // com.bytedance.trae.conversation.widget.MenuPopupWindow.OnMenuClickListener
            public void onArtifactClick() {
                MenuPopupWindow menuPopupWindow4;
                ConversationViewModel conversationViewModel5;
                ConversationDetailFragment detailFragment;
                ConversationViewModel conversationViewModel6;
                menuPopupWindow4 = ConversationActivity.this.menuPopupWindow;
                if (menuPopupWindow4 != null) {
                    menuPopupWindow4.dismiss();
                }
                conversationViewModel5 = ConversationActivity.this.viewModel;
                ConversationViewModel conversationViewModel7 = null;
                if (conversationViewModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    conversationViewModel5 = null;
                }
                Conversation conversation3 = (Conversation) conversationViewModel5.getConversation().getValue();
                detailFragment = ConversationActivity.this.getDetailFragment();
                ParsedChatMessage lastMessage = detailFragment != null ? detailFragment.getLastMessage() : null;
                if (conversation3 == null || lastMessage == null) {
                    return;
                }
                ArtifactListActivity.Companion companion = ArtifactListActivity.INSTANCE;
                Context context = (Context) ConversationActivity.this;
                String cliConversationId = conversation3.getCliConversationId();
                if (cliConversationId == null) {
                    cliConversationId = "";
                }
                String turnId = lastMessage.getTurnId();
                if (turnId == null) {
                    turnId = "";
                }
                String environment = conversation3.getEnvironment();
                String str = environment == null ? "" : environment;
                conversationViewModel6 = ConversationActivity.this.viewModel;
                if (conversationViewModel6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    conversationViewModel7 = conversationViewModel6;
                }
                String str2 = (String) conversationViewModel7.getConversationId().getValue();
                companion.start(context, cliConversationId, turnId, str, str2 == null ? "" : str2);
            }

            @Override // com.bytedance.trae.conversation.widget.MenuPopupWindow.OnMenuClickListener
            public void onPinClick() {
                MenuPopupWindow menuPopupWindow4;
                ConversationViewModel conversationViewModel5;
                ConversationViewModel conversationViewModel6;
                ConversationViewModel conversationViewModel7;
                menuPopupWindow4 = ConversationActivity.this.menuPopupWindow;
                if (menuPopupWindow4 != null) {
                    menuPopupWindow4.dismiss();
                }
                conversationViewModel5 = ConversationActivity.this.viewModel;
                ConversationViewModel conversationViewModel8 = null;
                if (conversationViewModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    conversationViewModel5 = null;
                }
                Conversation conversation3 = (Conversation) conversationViewModel5.getConversation().getValue();
                if (conversation3 != null ? Intrinsics.areEqual(conversation3.isPinned(), true) : false) {
                    conversationViewModel7 = ConversationActivity.this.viewModel;
                    if (conversationViewModel7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        conversationViewModel8 = conversationViewModel7;
                    }
                    conversationViewModel8.unpinConversation();
                    return;
                }
                conversationViewModel6 = ConversationActivity.this.viewModel;
                if (conversationViewModel6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    conversationViewModel8 = conversationViewModel6;
                }
                conversationViewModel8.pinConversation();
            }

            @Override // com.bytedance.trae.conversation.widget.MenuPopupWindow.OnMenuClickListener
            public void onRenameClick() {
                MenuPopupWindow menuPopupWindow4;
                menuPopupWindow4 = ConversationActivity.this.menuPopupWindow;
                if (menuPopupWindow4 != null) {
                    menuPopupWindow4.dismiss();
                }
                ConversationActivity.this.showRenameDialog();
            }

            @Override // com.bytedance.trae.conversation.widget.MenuPopupWindow.OnMenuClickListener
            public void onDeleteClick() {
                MenuPopupWindow menuPopupWindow4;
                menuPopupWindow4 = ConversationActivity.this.menuPopupWindow;
                if (menuPopupWindow4 != null) {
                    menuPopupWindow4.dismiss();
                }
                ConversationActivity.this.showDeleteDialog();
            }
        }, z, z2, conversation2 != null ? Intrinsics.areEqual(conversation2.isPinned(), true) : false);
        conversationActivity.menuPopupWindow = menuPopupWindow3;
        menuPopupWindow3.showAsDropDown(view, 0, 0);
        InputTracker inputTracker = InputTracker.INSTANCE;
        ConversationViewModel conversationViewModel5 = conversationActivity.viewModel;
        if (conversationViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            conversationViewModel2 = conversationViewModel5;
        }
        String str = (String) conversationViewModel2.getConversationId().getValue();
        if (str == null) {
            str = "";
        }
        inputTracker.trackMenuClick(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initTitleBar$lambda$53(ConversationActivity conversationActivity, int i, String str) {
        SelectedDeviceItem selectedDeviceItem;
        InputFragment.ModeDraft saveDraft;
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        ChatMode chatMode = i == 0 ? ChatMode.MTC : ChatMode.CODE;
        ChatMode chatMode2 = chatMode == ChatMode.MTC ? ChatMode.CODE : ChatMode.MTC;
        InputTracker.INSTANCE.trackModeSwitchClick(chatMode == ChatMode.MTC ? ModelSelectionRepository.MODE_MTC : "code");
        Fragment findFragmentByTag = conversationActivity.getSupportFragmentManager().findFragmentByTag(InputFragment.TAG);
        InputFragment inputFragment = findFragmentByTag instanceof InputFragment ? (InputFragment) findFragmentByTag : null;
        if (inputFragment != null && (saveDraft = inputFragment.saveDraft()) != null) {
            conversationActivity.draftByMode.put(chatMode2, saveDraft);
            SelectedDeviceItem currentDevice = saveDraft.getCurrentDevice();
            if (currentDevice != null) {
                conversationActivity.selectedDeviceByMode.put(chatMode2, currentDevice);
            }
        }
        if (inputFragment != null) {
            inputFragment.clearInput();
        }
        ConversationViewModel conversationViewModel = conversationActivity.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        conversationViewModel.setMode(chatMode);
        AccountSettingsKeva.INSTANCE.getKeva().storeString(KEY_LAST_CHAT_MODE, chatMode != ChatMode.CODE ? "work" : "code");
        if (inputFragment != null) {
            inputFragment.switchMode(chatMode);
        }
        InputFragment.ModeDraft remove = conversationActivity.draftByMode.remove(chatMode);
        if ((remove == null || (selectedDeviceItem = remove.getCurrentDevice()) == null) && (selectedDeviceItem = conversationActivity.selectedDeviceByMode.get(chatMode)) == null) {
            selectedDeviceItem = conversationActivity.defaultRemoteDevice();
        }
        if (remove != null && inputFragment != null) {
            inputFragment.restoreDraft(remove);
        }
        if ((remove != null ? remove.getCurrentDevice() : null) == null && inputFragment != null) {
            inputFragment.setSelectedDevice(selectedDeviceItem);
        }
        conversationActivity.selectedDeviceByMode.put(chatMode, selectedDeviceItem);
        ConversationViewModel conversationViewModel2 = conversationActivity.viewModel;
        if (conversationViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel2 = null;
        }
        conversationViewModel2.setSelectedDevice(selectedDeviceItem);
        Fragment findFragmentByTag2 = conversationActivity.getSupportFragmentManager().findFragmentByTag(WelcomeFragment.TAG);
        WelcomeFragment welcomeFragment = findFragmentByTag2 instanceof WelcomeFragment ? (WelcomeFragment) findFragmentByTag2 : null;
        if (welcomeFragment != null) {
            welcomeFragment.setMode(chatMode);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showRenameDialog() {
        CustomConfirmDialog rename;
        ConversationViewModel conversationViewModel = this.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        Conversation conversation = (Conversation) conversationViewModel.getConversation().getValue();
        String title = conversation != null ? conversation.getTitle() : null;
        if (title == null) {
            title = "";
        }
        String string = getString(com.bytedance.trae.multilanguage.R.string.trae_conversation_dialog_rename_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(com.bytedance.trae.multilanguage.R.string.trae_conversation_dialog_rename_hint);
        String string3 = getString(com.bytedance.trae.multilanguage.R.string.trae_conversation_dialog_btn_cancel);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = getString(com.bytedance.trae.multilanguage.R.string.trae_conversation_dialog_btn_confirm);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        rename = CustomConfirmDialog.INSTANCE.rename((Context) this, string, title, (r20 & 8) != 0 ? null : string2, string3, string4, new Function1() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda59
            public final Object invoke(Object obj) {
                Unit showRenameDialog$lambda$54;
                showRenameDialog$lambda$54 = ConversationActivity.showRenameDialog$lambda$54(ConversationActivity.this, (String) obj);
                return showRenameDialog$lambda$54;
            }
        }, (r20 & 128) != 0 ? new Function0() { // from class: com.bytedance.trae.common.widget.CustomConfirmDialog$Companion$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        } : null);
        rename.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showRenameDialog$lambda$54(ConversationActivity conversationActivity, String str) {
        String str2 = str;
        if (!(str2 == null || StringsKt.isBlank(str2))) {
            ConversationViewModel conversationViewModel = conversationActivity.viewModel;
            if (conversationViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                conversationViewModel = null;
            }
            conversationViewModel.renameConversation(str);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showDeleteDialog() {
        CustomConfirmDialog delete;
        ConversationViewModel conversationViewModel = this.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        if (((String) conversationViewModel.getConversationId().getValue()) == null) {
            return;
        }
        String string = getString(com.bytedance.trae.multilanguage.R.string.trae_conversation_dialog_delete_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(com.bytedance.trae.multilanguage.R.string.trae_conversation_dialog_delete_message);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = getString(com.bytedance.trae.multilanguage.R.string.trae_conversation_dialog_btn_cancel);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = getString(com.bytedance.trae.multilanguage.R.string.trae_conversation_dialog_btn_delete);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        delete = CustomConfirmDialog.INSTANCE.delete((Context) this, string, string2, (r38 & 8) != 0 ? "" : string3, string4, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : null, (r38 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? 0 : 0, (r38 & 16384) != 0 ? C0591R.drawable.trae_bg_custom_dialog_btn_primary : 0, new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda13
            public final Object invoke() {
                Unit showDeleteDialog$lambda$55;
                showDeleteDialog$lambda$55 = ConversationActivity.showDeleteDialog$lambda$55(ConversationActivity.this);
                return showDeleteDialog$lambda$55;
            }
        }, (r38 & 65536) != 0 ? new Function0() { // from class: com.bytedance.trae.common.widget.CustomConfirmDialog$Companion$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        } : null);
        delete.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showDeleteDialog$lambda$55(ConversationActivity conversationActivity) {
        ConversationViewModel conversationViewModel = conversationActivity.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        conversationViewModel.deleteConversation();
        return Unit.INSTANCE;
    }

    private final void updateModeTab(ChatMode mode) {
        int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        if (i == 1) {
            TraeActivityConversationBinding traeActivityConversationBinding = this.binding;
            if (traeActivityConversationBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                traeActivityConversationBinding = null;
            }
            TraeTitleBar.setSegmentedSelectedIndex$default(traeActivityConversationBinding.titleBar, 0, false, 2, null);
            return;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        TraeActivityConversationBinding traeActivityConversationBinding2 = this.binding;
        if (traeActivityConversationBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityConversationBinding2 = null;
        }
        TraeTitleBar.setSegmentedSelectedIndex$default(traeActivityConversationBinding2.titleBar, 1, false, 2, null);
    }

    private final void switchToCodeMode() {
        InputFragment.ModeDraft saveDraft;
        ConversationViewModel conversationViewModel = this.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        if (conversationViewModel.getCurrentMode().getValue() == ChatMode.CODE) {
            return;
        }
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(InputFragment.TAG);
        InputFragment inputFragment = findFragmentByTag instanceof InputFragment ? (InputFragment) findFragmentByTag : null;
        if (inputFragment != null && (saveDraft = inputFragment.saveDraft()) != null) {
            this.draftByMode.put(ChatMode.MTC, saveDraft);
            SelectedDeviceItem currentDevice = saveDraft.getCurrentDevice();
            if (currentDevice != null) {
                this.selectedDeviceByMode.put(ChatMode.MTC, currentDevice);
            }
        }
        if (inputFragment != null) {
            inputFragment.clearInput();
        }
        ConversationViewModel conversationViewModel2 = this.viewModel;
        if (conversationViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel2 = null;
        }
        conversationViewModel2.setMode(ChatMode.CODE);
        if (inputFragment != null) {
            inputFragment.switchMode(ChatMode.CODE);
        }
        updateModeTab(ChatMode.CODE);
        Fragment findFragmentByTag2 = getSupportFragmentManager().findFragmentByTag(WelcomeFragment.TAG);
        WelcomeFragment welcomeFragment = findFragmentByTag2 instanceof WelcomeFragment ? (WelcomeFragment) findFragmentByTag2 : null;
        if (welcomeFragment != null) {
            welcomeFragment.setMode(ChatMode.CODE);
        }
    }

    private final void switchToWorkMode() {
        ConversationViewModel conversationViewModel = this.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        if (conversationViewModel.getCurrentMode().getValue() == ChatMode.MTC) {
            return;
        }
        updateModeTab(ChatMode.MTC);
    }

    private final void autoSelectConnectedDevice(MobileDevice device, NewFeaturePromptConnectionAction action) {
        SelectedDeviceItem selectedDeviceItem = new SelectedDeviceItem(device.getId(), device.getName(), action.getSelectedCliType(), null, device.getIdeVersion(), null, false, null, action.getDestinationMode() == ChatMode.CODE, 224, null);
        ChatMode destinationMode = action.getDestinationMode();
        this.selectedDeviceByMode.put(destinationMode, selectedDeviceItem);
        ConversationViewModel conversationViewModel = this.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        conversationViewModel.setSelectedDevice(selectedDeviceItem);
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(InputFragment.TAG);
        InputFragment inputFragment = findFragmentByTag instanceof InputFragment ? (InputFragment) findFragmentByTag : null;
        if (inputFragment != null) {
            inputFragment.setSelectedDevice(selectedDeviceItem);
        }
        if (destinationMode != ChatMode.CODE || inputFragment == null) {
            return;
        }
        inputFragment.setMultipleProducts(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void updateConversationTitleInfo(Conversation conversation) {
        String title;
        Object obj;
        int i;
        String cliId;
        Object obj2;
        int i2;
        String cliId2;
        TraeActivityConversationBinding traeActivityConversationBinding = this.binding;
        TraeActivityConversationBinding traeActivityConversationBinding2 = null;
        if (traeActivityConversationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityConversationBinding = null;
        }
        traeActivityConversationBinding.titleBar.showConversationDetailHeader();
        TraeActivityConversationBinding traeActivityConversationBinding3 = this.binding;
        if (traeActivityConversationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityConversationBinding3 = null;
        }
        TraeTitleBar traeTitleBar = traeActivityConversationBinding3.titleBar;
        String str = "";
        if (TextUtils.isEmpty(conversation.getTitle())) {
            title = getString(com.bytedance.trae.multilanguage.R.string.trae_conversation_new_task);
        } else {
            title = conversation.getTitle();
            if (title == null) {
                title = "";
            }
        }
        traeTitleBar.setConversationDetailTitle(title);
        if (Intrinsics.areEqual(conversation.getDisplayEnvironment(), CliType.REMOTE.getValue())) {
            ConversationViewModel conversationViewModel = this.viewModel;
            if (conversationViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                conversationViewModel = null;
            }
            String parseGitDisplayName = conversationViewModel.parseGitDisplayName(conversation.getDisplayGitUri());
            TraeActivityConversationBinding traeActivityConversationBinding4 = this.binding;
            if (traeActivityConversationBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                traeActivityConversationBinding2 = traeActivityConversationBinding4;
            }
            traeActivityConversationBinding2.titleBar.setConversationDetailSubtitle(getString(com.bytedance.trae.multilanguage.R.string.trae_input_cloud), parseGitDisplayName, C0591R.drawable.trae_ic_title_bar_cloud);
            return;
        }
        if (Intrinsics.areEqual(conversation.getEnvironment(), CliType.IDE.getValue())) {
            Iterator<T> it = CliListRepository.INSTANCE.getInstance().getCacheClis().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                } else {
                    obj2 = it.next();
                    if (Intrinsics.areEqual(((Cli) obj2).getId(), conversation.getCliId())) {
                        break;
                    }
                }
            }
            Cli cli = (Cli) obj2;
            if (conversation.getOwnerProjectAbsolutePath() != null && conversation.getOwnerProjectWorkSpaceStatus() != null) {
                String ownerProjectAbsolutePath = conversation.getOwnerProjectAbsolutePath();
                Intrinsics.checkNotNull(ownerProjectAbsolutePath);
                String ownerProjectWorkSpaceStatus = conversation.getOwnerProjectWorkSpaceStatus();
                Intrinsics.checkNotNull(ownerProjectWorkSpaceStatus);
                str = IDEProjectNameUtil.INSTANCE.getProjectName((Context) this, ownerProjectAbsolutePath, ownerProjectWorkSpaceStatus);
            }
            if (Intrinsics.areEqual(cli != null ? cli.getStatus() : null, "online")) {
                i2 = C0591R.drawable.trae_ic_title_bar_computer_online;
            } else {
                i2 = C0591R.drawable.trae_ic_title_bar_computer_offline;
            }
            TraeActivityConversationBinding traeActivityConversationBinding5 = this.binding;
            if (traeActivityConversationBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                traeActivityConversationBinding2 = traeActivityConversationBinding5;
            }
            TraeTitleBar traeTitleBar2 = traeActivityConversationBinding2.titleBar;
            if (cli == null || (cliId2 = cli.getName()) == null) {
                cliId2 = conversation.getCliId();
            }
            traeTitleBar2.setConversationDetailSubtitle(cliId2, str, i2);
            return;
        }
        Iterator<T> it2 = CliListRepository.INSTANCE.getInstance().getCacheClis().iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it2.next();
                if (Intrinsics.areEqual(((Cli) obj).getId(), conversation.getCliId())) {
                    break;
                }
            }
        }
        Cli cli2 = (Cli) obj;
        ConversationViewModel conversationViewModel2 = this.viewModel;
        if (conversationViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel2 = null;
        }
        String parseWorkspaceDisplayName = conversationViewModel2.parseWorkspaceDisplayName(conversation.getDisplayWorkspace());
        if (Intrinsics.areEqual(cli2 != null ? cli2.getStatus() : null, "online")) {
            i = C0591R.drawable.trae_ic_title_bar_computer_online;
        } else {
            i = C0591R.drawable.trae_ic_title_bar_computer_offline;
        }
        TraeActivityConversationBinding traeActivityConversationBinding6 = this.binding;
        if (traeActivityConversationBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            traeActivityConversationBinding2 = traeActivityConversationBinding6;
        }
        TraeTitleBar traeTitleBar3 = traeActivityConversationBinding2.titleBar;
        if (cli2 == null || (cliId = cli2.getName()) == null) {
            cliId = conversation.getCliId();
        }
        traeTitleBar3.setConversationDetailSubtitle(cliId, parseWorkspaceDisplayName, i);
    }

    private final void showWelcomeScreen() {
        TraeActivityConversationBinding traeActivityConversationBinding = this.binding;
        TraeActivityConversationBinding traeActivityConversationBinding2 = null;
        if (traeActivityConversationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityConversationBinding = null;
        }
        traeActivityConversationBinding.welcomeFragmentContainer.setVisibility(0);
        TraeActivityConversationBinding traeActivityConversationBinding3 = this.binding;
        if (traeActivityConversationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            traeActivityConversationBinding2 = traeActivityConversationBinding3;
        }
        traeActivityConversationBinding2.detailFragmentContainer.setVisibility(8);
        initWelcomeFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideWelcomeScreen() {
        if (this.isNewConversation) {
            this.isNewConversation = false;
            getInputFragment().setNewConversation(false);
            TraeActivityConversationBinding traeActivityConversationBinding = this.binding;
            TraeActivityConversationBinding traeActivityConversationBinding2 = null;
            if (traeActivityConversationBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                traeActivityConversationBinding = null;
            }
            traeActivityConversationBinding.welcomeFragmentContainer.setVisibility(8);
            TraeActivityConversationBinding traeActivityConversationBinding3 = this.binding;
            if (traeActivityConversationBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                traeActivityConversationBinding2 = traeActivityConversationBinding3;
            }
            traeActivityConversationBinding2.detailFragmentContainer.setVisibility(0);
            getInputFragment().hideTaskTemplates();
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(WelcomeFragment.TAG);
            if (findFragmentByTag != null) {
                getSupportFragmentManager().beginTransaction().remove(findFragmentByTag).commitNowAllowingStateLoss();
            }
        }
    }

    private final void initWelcomeFragment() {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(WelcomeFragment.TAG);
        TraeActivityConversationBinding traeActivityConversationBinding = null;
        WelcomeFragment welcomeFragment = findFragmentByTag instanceof WelcomeFragment ? (WelcomeFragment) findFragmentByTag : null;
        if (welcomeFragment == null) {
            return;
        }
        TraeActivityConversationBinding traeActivityConversationBinding2 = this.binding;
        if (traeActivityConversationBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            traeActivityConversationBinding = traeActivityConversationBinding2;
        }
        welcomeFragment.setMode(traeActivityConversationBinding.titleBar.getSegmentedSelectedIndex() == 0 ? ChatMode.MTC : ChatMode.CODE);
        welcomeFragment.setOnModeSwipe(new Function1() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda24
            public final Object invoke(Object obj) {
                Unit initWelcomeFragment$lambda$60;
                initWelcomeFragment$lambda$60 = ConversationActivity.initWelcomeFragment$lambda$60(ConversationActivity.this, (ChatMode) obj);
                return initWelcomeFragment$lambda$60;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initWelcomeFragment$lambda$60(ConversationActivity conversationActivity, ChatMode chatMode) {
        Intrinsics.checkNotNullParameter(chatMode, "targetMode");
        if (conversationActivity.isNewConversation) {
            conversationActivity.updateModeTab(chatMode);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void sendQuery$default(ConversationActivity conversationActivity, String str, String str2, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        conversationActivity.sendQuery(str, str2, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void sendQuery(final String query, final String text, final List<PluginTagItem> plugins) {
        Object obj;
        Mode mode;
        if (this.isNewConversation) {
            TraeActivityConversationBinding traeActivityConversationBinding = this.binding;
            if (traeActivityConversationBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                traeActivityConversationBinding = null;
            }
            mode = traeActivityConversationBinding.titleBar.getSegmentedSelectedIndex() == 0 ? Mode.WORK : Mode.CODE;
            AccountSettingsKeva.INSTANCE.getKeva().storeString(KEY_LAST_CHAT_MODE, mode == Mode.CODE ? "code" : "work");
        } else {
            Iterator it = Mode.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                String value = ((Mode) obj).getValue();
                ConversationViewModel conversationViewModel = this.viewModel;
                if (conversationViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    conversationViewModel = null;
                }
                Conversation conversation = (Conversation) conversationViewModel.getConversation().getValue();
                if (Intrinsics.areEqual(value, conversation != null ? conversation.getMode() : null)) {
                    break;
                }
            }
            mode = (Mode) obj;
            if (mode == null) {
                mode = Mode.WORK;
            }
        }
        final Mode mode2 = mode;
        ConversationViewModel conversationViewModel2 = this.viewModel;
        if (conversationViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel2 = null;
        }
        if (conversationViewModel2.getConversation().getValue() == null && mode2 == Mode.CODE) {
            ConversationViewModel conversationViewModel3 = this.viewModel;
            if (conversationViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                conversationViewModel3 = null;
            }
            SelectedDeviceItem selectedDeviceItem = (SelectedDeviceItem) conversationViewModel3.getSelectedDevice().getValue();
            if ((selectedDeviceItem != null ? selectedDeviceItem.getType() : null) != CliType.LOCAL) {
                ConversationViewModel conversationViewModel4 = this.viewModel;
                if (conversationViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    conversationViewModel4 = null;
                }
                SelectedDeviceItem selectedDeviceItem2 = (SelectedDeviceItem) conversationViewModel4.getSelectedDevice().getValue();
                if ((selectedDeviceItem2 != null ? selectedDeviceItem2.getType() : null) != CliType.IDE && getGitSelectionViewModel().getSelectedRepo().getValue() != null && getGitSelectionViewModel().getSelectedBranch().getValue() == null) {
                    Toast.makeText((Context) this, com.bytedance.trae.multilanguage.R.string.trae_git_please_select_branch, 0).show();
                    getInputFragment().setSendingState(false);
                    return;
                }
            }
        }
        AiDataNoticeHelper.INSTANCE.showIfNeeded((ComponentActivity) this, new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda47
            public final Object invoke() {
                Unit sendQuery$lambda$63;
                sendQuery$lambda$63 = ConversationActivity.sendQuery$lambda$63(ConversationActivity.this, mode2, plugins, text, query);
                return sendQuery$lambda$63;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendQuery$lambda$63(ConversationActivity conversationActivity, Mode mode, List list, String str, String str2) {
        ConversationViewModel conversationViewModel;
        ConversationViewModel conversationViewModel2 = conversationActivity.viewModel;
        if (conversationViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel2 = null;
        }
        GitRepoItem gitRepoItem = (GitRepoItem) conversationActivity.getGitSelectionViewModel().getSelectedRepo().getValue();
        conversationViewModel2.setSelectedRepoUrl(gitRepoItem != null ? gitRepoItem.getRepoUrl() : null);
        ConversationViewModel conversationViewModel3 = conversationActivity.viewModel;
        if (conversationViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel3 = null;
        }
        conversationViewModel3.setSelectedRepo((GitRepoItem) conversationActivity.getGitSelectionViewModel().getSelectedRepo().getValue());
        ConversationViewModel conversationViewModel4 = conversationActivity.viewModel;
        if (conversationViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel4 = null;
        }
        ConversationViewModel conversationViewModel5 = conversationActivity.viewModel;
        if (conversationViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel5 = null;
        }
        ConversationViewModel conversationViewModel6 = conversationActivity.viewModel;
        if (conversationViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel6 = null;
        }
        conversationViewModel4.setSelectedRepoName(conversationViewModel5.parseGitDisplayName(conversationViewModel6.getSelectedRepoUrl()));
        ConversationViewModel conversationViewModel7 = conversationActivity.viewModel;
        if (conversationViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel7 = null;
        }
        BranchItem branchItem = (BranchItem) conversationActivity.getGitSelectionViewModel().getSelectedBranch().getValue();
        conversationViewModel7.setSelectedBranchName(branchItem != null ? branchItem.getName() : null);
        RemoteModelItem selectedModelForRequest = conversationActivity.getInputFragment().getSelectedModelForRequest();
        String name = selectedModelForRequest != null ? selectedModelForRequest.getName() : null;
        AISendMessageContext buildSendMessageContext = conversationActivity.buildSendMessageContext(mode, list.size());
        conversationActivity.lastSendContext = buildSendMessageContext;
        conversationActivity.hasReportedStreamShow = false;
        conversationActivity.wasUserInitiatedCancel = false;
        conversationActivity.streamingStartTimeMs = SystemClock.elapsedRealtime();
        conversationActivity.streamingMessageId = null;
        conversationActivity.streamingChatModel = null;
        SoloChatMode resolveCurrentChatMode = conversationActivity.resolveCurrentChatMode(mode);
        ConversationViewModel conversationViewModel8 = conversationActivity.viewModel;
        if (conversationViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel8 = null;
        }
        String str3 = (String) conversationViewModel8.getConversationId().getValue();
        if (str3 == null) {
            str3 = "";
        }
        String str4 = str3;
        if (name == null) {
            name = ModelSelectionConstants.AUTO;
        }
        conversationActivity.pendingTriggerTracker = new PendingTriggerTracker(new AIEventContext(null, str4, null, name, 5, null), buildSendMessageContext, resolveCurrentChatMode);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PluginTracker.INSTANCE.trackPluginInclude(((PluginTagItem) it.next()).getId(), "plugin", resolveCurrentChatMode.getValue());
        }
        ConversationViewModel conversationViewModel9 = conversationActivity.viewModel;
        if (conversationViewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        } else {
            conversationViewModel = conversationViewModel9;
        }
        ConversationViewModel.sendMessage$default(conversationViewModel, str, str2, mode, selectedModelForRequest, false, 16, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean exitAnchorWindowAndShowLatestPage() {
        this.snapToBottomAfterLatestPageSubmit = true;
        ConversationViewModel conversationViewModel = this.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        if (!conversationViewModel.exitAnchorWindowAndLoadLatest()) {
            this.snapToBottomAfterLatestPageSubmit = false;
            return false;
        }
        this.anchorCreatedAtMs = null;
        this.hasScrolledToAnchorCreatedAt = true;
        return true;
    }

    private final void initInputFragment() {
        InputFragment inputFragment = getInputFragment();
        TraeActivityConversationBinding traeActivityConversationBinding = this.binding;
        if (traeActivityConversationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityConversationBinding = null;
        }
        inputFragment.setVoiceRecordingOverlay(traeActivityConversationBinding.voiceRecordingOverlay);
        getInputFragment().setTaskRunning(new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda16
            public final Object invoke() {
                boolean initInputFragment$lambda$64;
                initInputFragment$lambda$64 = ConversationActivity.initInputFragment$lambda$64(ConversationActivity.this);
                return Boolean.valueOf(initInputFragment$lambda$64);
            }
        });
        getInputFragment().setOnSendAudioText(new Function2() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda17
            public final Object invoke(Object obj, Object obj2) {
                Unit initInputFragment$lambda$65;
                initInputFragment$lambda$65 = ConversationActivity.initInputFragment$lambda$65(ConversationActivity.this, (String) obj, (String) obj2);
                return initInputFragment$lambda$65;
            }
        });
        getInputFragment().setOnSendText(new Function1() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda18
            public final Object invoke(Object obj) {
                Unit initInputFragment$lambda$66;
                initInputFragment$lambda$66 = ConversationActivity.initInputFragment$lambda$66(ConversationActivity.this, (String) obj);
                return initInputFragment$lambda$66;
            }
        });
        getInputFragment().setOnInputFocus(new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda19
            public final Object invoke() {
                Unit initInputFragment$lambda$67;
                initInputFragment$lambda$67 = ConversationActivity.initInputFragment$lambda$67(ConversationActivity.this);
                return initInputFragment$lambda$67;
            }
        });
        getInputFragment().setOnTemplateClick(new Function1() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda20
            public final Object invoke(Object obj) {
                Unit initInputFragment$lambda$69;
                initInputFragment$lambda$69 = ConversationActivity.initInputFragment$lambda$69(ConversationActivity.this, (String) obj);
                return initInputFragment$lambda$69;
            }
        });
        getInputFragment().setOnChatNewClick(new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda21
            public final Object invoke() {
                Unit initInputFragment$lambda$70;
                initInputFragment$lambda$70 = ConversationActivity.initInputFragment$lambda$70(ConversationActivity.this);
                return initInputFragment$lambda$70;
            }
        });
        getInputFragment().setOnReady(new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda23
            public final Object invoke() {
                Unit initInputFragment$lambda$78;
                initInputFragment$lambda$78 = ConversationActivity.initInputFragment$lambda$78(ConversationActivity.this);
                return initInputFragment$lambda$78;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initInputFragment$lambda$64(ConversationActivity conversationActivity) {
        ConversationViewModel conversationViewModel = conversationActivity.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        return conversationViewModel.getIsTaskRunning();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initInputFragment$lambda$65(ConversationActivity conversationActivity, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "query");
        Intrinsics.checkNotNullParameter(str2, "text");
        sendQuery$default(conversationActivity, str, str2, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initInputFragment$lambda$66(ConversationActivity conversationActivity, String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) conversationActivity), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$initInputFragment$3$1(conversationActivity, str, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initInputFragment$lambda$67(ConversationActivity conversationActivity) {
        ConversationDetailFragment detailFragment;
        if (!conversationActivity.exitAnchorWindowAndShowLatestPage() && (detailFragment = conversationActivity.getDetailFragment()) != null) {
            detailFragment.forceScrollToBottom();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initInputFragment$lambda$69(ConversationActivity conversationActivity, String str) {
        Intrinsics.checkNotNullParameter(str, "template");
        Gson gson = new Gson();
        List createListBuilder = CollectionsKt.createListBuilder();
        createListBuilder.add(QueryItem.INSTANCE.text(str));
        String json = gson.toJson(CollectionsKt.build(createListBuilder));
        Intrinsics.checkNotNull(json);
        sendQuery$default(conversationActivity, json, str, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initInputFragment$lambda$70(ConversationActivity conversationActivity) {
        VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker = conversationActivity.voiceDiscussionAttemptTracker;
        if (voiceDiscussionAttemptTracker != null) {
            voiceDiscussionAttemptTracker.finish(VoiceDiscussionAttemptOutcome.ACTIVITY_NOT_SHOWN, "replaced_by_new_click");
        }
        VoiceDiscussionAttemptTracker createVoiceDiscussionAttempt = conversationActivity.createVoiceDiscussionAttempt();
        conversationActivity.voiceDiscussionAttemptTracker = createVoiceDiscussionAttempt;
        TraeAITracker.INSTANCE.trackAsrDiscuss(AsrDiscussAction.DISCUSSION_BUTTON_CLICK, createVoiceDiscussionAttempt.snapshot().getAttemptId());
        ConversationViewModel conversationViewModel = conversationActivity.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        if (conversationActivity.canStartBrainstormForDevice((SelectedDeviceItem) conversationViewModel.getSelectedDevice().getValue())) {
            createVoiceDiscussionAttempt.recordStage(VoiceDiscussionAttemptStage.ELIGIBILITY_PASSED);
            conversationActivity.requestBrainstormPermissions();
        } else {
            createVoiceDiscussionAttempt.finish(VoiceDiscussionAttemptOutcome.BLOCKED_IDE_VERSION, "desktop_ide_version_below_minimum");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initInputFragment$lambda$78(final ConversationActivity conversationActivity) {
        ConversationViewModel conversationViewModel = conversationActivity.viewModel;
        TraeActivityConversationBinding traeActivityConversationBinding = null;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        conversationViewModel.setMode(conversationActivity.initialChatMode);
        if (conversationActivity.isNewConversation) {
            conversationActivity.updateModeTab(conversationActivity.initialChatMode);
        } else {
            ConversationViewModel conversationViewModel2 = conversationActivity.viewModel;
            if (conversationViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                conversationViewModel2 = null;
            }
            Conversation conversation = (Conversation) conversationViewModel2.getConversation().getValue();
            if (conversation != null) {
                ChatMode chatMode = Intrinsics.areEqual(conversation.getMode(), "code") ? ChatMode.CODE : ChatMode.MTC;
                if (Intrinsics.areEqual(conversation.getEnvironment(), CliType.IDE.getValue())) {
                    conversationActivity.getInputFragment().setMode(ChatMode.CODE);
                } else {
                    conversationActivity.getInputFragment().setMode(chatMode);
                }
            }
        }
        ConversationViewModel conversationViewModel3 = conversationActivity.viewModel;
        if (conversationViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel3 = null;
        }
        SelectedDeviceItem selectedDeviceItem = (SelectedDeviceItem) conversationViewModel3.getSelectedDevice().getValue();
        if (selectedDeviceItem != null) {
            conversationActivity.selectedDeviceByMode.put(conversationActivity.getInputFragment().getCurrentMode(), selectedDeviceItem);
            conversationActivity.getInputFragment().setSelectedDevice(selectedDeviceItem);
        }
        InputFragment inputFragment = conversationActivity.getInputFragment();
        ConversationViewModel conversationViewModel4 = conversationActivity.viewModel;
        if (conversationViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel4 = null;
        }
        inputFragment.setConversationId((String) conversationViewModel4.getConversationId().getValue());
        conversationActivity.getInputFragment().setOnDeviceClick(new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda48
            public final Object invoke() {
                Unit initInputFragment$lambda$78$lambda$72;
                initInputFragment$lambda$78$lambda$72 = ConversationActivity.initInputFragment$lambda$78$lambda$72(ConversationActivity.this);
                return initInputFragment$lambda$78$lambda$72;
            }
        });
        conversationActivity.getInputFragment().setOnSelectedDeviceChanged(new Function1() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda49
            public final Object invoke(Object obj) {
                Unit initInputFragment$lambda$78$lambda$73;
                initInputFragment$lambda$78$lambda$73 = ConversationActivity.initInputFragment$lambda$78$lambda$73(ConversationActivity.this, (SelectedDeviceItem) obj);
                return initInputFragment$lambda$78$lambda$73;
            }
        });
        conversationActivity.getInputFragment().setOnRequestSkillProjectCheck(new Function1() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda50
            public final Object invoke(Object obj) {
                Unit initInputFragment$lambda$78$lambda$74;
                initInputFragment$lambda$78$lambda$74 = ConversationActivity.initInputFragment$lambda$78$lambda$74(ConversationActivity.this, (Function1) obj);
                return initInputFragment$lambda$78$lambda$74;
            }
        });
        conversationActivity.getInputFragment().setOnAuthFailed(new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda51
            public final Object invoke() {
                Unit initInputFragment$lambda$78$lambda$75;
                initInputFragment$lambda$78$lambda$75 = ConversationActivity.initInputFragment$lambda$78$lambda$75(ConversationActivity.this);
                return initInputFragment$lambda$78$lambda$75;
            }
        });
        ConversationViewModel conversationViewModel5 = conversationActivity.viewModel;
        if (conversationViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel5 = null;
        }
        String str = (String) conversationViewModel5.getConversationId().getValue();
        ConversationViewModel conversationViewModel6 = conversationActivity.viewModel;
        if (conversationViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel6 = null;
        }
        Conversation conversation2 = (Conversation) conversationViewModel6.getConversation().getValue();
        String str2 = str;
        boolean z = true;
        if (!(str2 == null || str2.length() == 0)) {
            conversationActivity.getInputFragment().setCloudEnabled(false);
            if (conversation2 != null) {
                conversationActivity.getInputFragment().setBottomContextualBarVisible(false);
                conversationActivity.getInputFragment().setDeviceFolderBarVisible(false);
            }
            String cliId = conversation2 != null ? conversation2.getCliId() : null;
            String str3 = cliId;
            if (str3 != null && str3.length() != 0) {
                z = false;
            }
            if (!z) {
                conversationActivity.getInputFragment().setCloudName(cliId);
            }
        } else {
            conversationActivity.getInputFragment().setCloudEnabled(true);
            conversationActivity.getInputFragment().setOnCloudClick(new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda52
                public final Object invoke() {
                    Unit initInputFragment$lambda$78$lambda$76;
                    initInputFragment$lambda$78$lambda$76 = ConversationActivity.initInputFragment$lambda$78$lambda$76(ConversationActivity.this);
                    return initInputFragment$lambda$78$lambda$76;
                }
            });
        }
        conversationActivity.getInputFragment().setNewConversation(conversationActivity.isNewConversation);
        if (conversationActivity.isNewConversation) {
            conversationActivity.getInputFragment().showTaskTemplates();
        }
        TraeActivityConversationBinding traeActivityConversationBinding2 = conversationActivity.binding;
        if (traeActivityConversationBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            traeActivityConversationBinding = traeActivityConversationBinding2;
        }
        traeActivityConversationBinding.getRoot().post(new Runnable() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda53
            @Override // java.lang.Runnable
            public final void run() {
                ConversationActivity.initInputFragment$lambda$78$lambda$77(ConversationActivity.this);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initInputFragment$lambda$78$lambda$72(ConversationActivity conversationActivity) {
        conversationActivity.showCliSelectionDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initInputFragment$lambda$78$lambda$73(ConversationActivity conversationActivity, SelectedDeviceItem selectedDeviceItem) {
        Intrinsics.checkNotNullParameter(selectedDeviceItem, "device");
        conversationActivity.selectedDeviceByMode.put(conversationActivity.getInputFragment().getCurrentMode(), selectedDeviceItem);
        ConversationViewModel conversationViewModel = conversationActivity.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        conversationViewModel.setSelectedDevice(selectedDeviceItem);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initInputFragment$lambda$78$lambda$74(ConversationActivity conversationActivity, Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "onResult");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) conversationActivity), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$initInputFragment$7$4$1(conversationActivity, function1, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initInputFragment$lambda$78$lambda$75(ConversationActivity conversationActivity) {
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (Intrinsics.areEqual((iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getLoginPlatform(), ThirdPartyTokenRepository.TYPE_BYTECLOUD)) {
            String string = conversationActivity.getString(com.bytedance.trae.multilanguage.R.string.trae_codebase_error_oauth_authorized_failed);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Toast.makeText((Context) conversationActivity, string, 0).show();
        } else {
            conversationActivity.handleGitError();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initInputFragment$lambda$78$lambda$76(ConversationActivity conversationActivity) {
        conversationActivity.showCliSelectionDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initInputFragment$lambda$78$lambda$77(ConversationActivity conversationActivity) {
        Fragment findFragmentByTag = conversationActivity.getSupportFragmentManager().findFragmentByTag(InputFragment.TAG);
        InputFragment inputFragment = findFragmentByTag instanceof InputFragment ? (InputFragment) findFragmentByTag : null;
        if (inputFragment != null) {
            inputFragment.showDeviceTipsPopWindow();
        }
    }

    private final void setTitleBarInteraction(boolean enabled) {
        TraeActivityConversationBinding traeActivityConversationBinding = this.binding;
        TraeActivityConversationBinding traeActivityConversationBinding2 = null;
        if (traeActivityConversationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityConversationBinding = null;
        }
        traeActivityConversationBinding.titleBar.setInteractionEnabled(enabled);
        float f = enabled ? 1.0f : 0.5f;
        TraeActivityConversationBinding traeActivityConversationBinding3 = this.binding;
        if (traeActivityConversationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            traeActivityConversationBinding2 = traeActivityConversationBinding3;
        }
        traeActivityConversationBinding2.titleBar.setAlpha(f);
    }

    private final void showCliSelectionDialog() {
        String id;
        ConversationViewModel conversationViewModel = this.viewModel;
        String str = null;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        final ChatMode chatMode = (ChatMode) conversationViewModel.getCurrentMode().getValue();
        SelectedDeviceItem selectedDeviceItem = this.selectedDeviceByMode.get(chatMode);
        if (selectedDeviceItem == null || (id = selectedDeviceItem.getId()) == null) {
            ConversationViewModel conversationViewModel2 = this.viewModel;
            if (conversationViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                conversationViewModel2 = null;
            }
            SelectedDeviceItem selectedDeviceItem2 = (SelectedDeviceItem) conversationViewModel2.getSelectedDevice().getValue();
            if (selectedDeviceItem2 != null) {
                str = selectedDeviceItem2.getId();
            }
        } else {
            str = id;
        }
        DeviceFlowContainerBottomSheet.INSTANCE.newInstance(new DeviceFlowRequest(new DeviceFlowRoute.DeviceSelect(chatMode, str, chatMode == ChatMode.CODE), new DeviceFlowCallbacks(new Function1() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda25
            public final Object invoke(Object obj) {
                Unit showCliSelectionDialog$lambda$79;
                showCliSelectionDialog$lambda$79 = ConversationActivity.showCliSelectionDialog$lambda$79(ConversationActivity.this, chatMode, (SelectedDeviceItem) obj);
                return showCliSelectionDialog$lambda$79;
            }
        }, new Function1() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda26
            public final Object invoke(Object obj) {
                Unit showCliSelectionDialog$lambda$80;
                showCliSelectionDialog$lambda$80 = ConversationActivity.showCliSelectionDialog$lambda$80(ChatMode.this, this, (List) obj);
                return showCliSelectionDialog$lambda$80;
            }
        }, null, null, null, null, 60, null))).show(getSupportFragmentManager(), DeviceFlowContainerBottomSheet.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showCliSelectionDialog$lambda$79(ConversationActivity conversationActivity, ChatMode chatMode, SelectedDeviceItem selectedDeviceItem) {
        Intrinsics.checkNotNullParameter(selectedDeviceItem, "device");
        conversationActivity.selectedDeviceByMode.put(chatMode, selectedDeviceItem);
        ConversationViewModel conversationViewModel = conversationActivity.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        conversationViewModel.setSelectedDevice(selectedDeviceItem);
        if (chatMode == ChatMode.CODE) {
            conversationActivity.getInputFragment().setMultipleProducts(selectedDeviceItem.getShowProductType());
        }
        conversationActivity.getInputFragment().setSelectedDevice(selectedDeviceItem);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showCliSelectionDialog$lambda$80(ChatMode chatMode, ConversationActivity conversationActivity, List list) {
        Intrinsics.checkNotNullParameter(list, "devices");
        ConversationViewModel conversationViewModel = null;
        if (chatMode == ChatMode.CODE) {
            ConversationViewModel conversationViewModel2 = conversationActivity.viewModel;
            if (conversationViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                conversationViewModel = conversationViewModel2;
            }
            conversationViewModel.syncCodeSelectedDeviceWithItems(list);
        } else {
            ConversationViewModel conversationViewModel3 = conversationActivity.viewModel;
            if (conversationViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                conversationViewModel = conversationViewModel3;
            }
            conversationViewModel.syncSelectedDeviceWithItems(list);
        }
        return Unit.INSTANCE;
    }

    private final SelectedDeviceItem defaultRemoteDevice() {
        return new SelectedDeviceItem("", "", CliType.REMOTE, null, null, null, false, null, false, 496, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean canStartBrainstormForDevice(SelectedDeviceItem device) {
        CliType cliType;
        if (device == null || (cliType = device.getType()) == null) {
            cliType = CliType.LOCAL;
        }
        if (cliType != CliType.LOCAL) {
            return true;
        }
        if (!BrainstormingSettings.INSTANCE.isBelowConfiguredV2MinIdeVersion(device != null ? device.getIdeVersion() : null)) {
            return true;
        }
        TraeLogUtil.INSTANCE.w(TAG, "canStartBrainstormForDevice: blocked by desktop ide version, cliId=" + (device != null ? device.getId() : null) + ", ideVersion=" + (device != null ? device.getIdeVersion() : null));
        Toast.makeText((Context) this, C0637R.string.trae_brainstorm_desktop_upgrade_required, 0).show();
        return false;
    }

    private final void handleGitError() {
        showLoading();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$handleGitError$1(this, null), 3, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showLoading() {
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
    public final void hideLoading() {
        Dialog dialog = this.loadingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.loadingDialog = null;
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getAction() == 0) {
            View currentFocus = getCurrentFocus();
            if (currentFocus instanceof EditText) {
                Rect rect = new Rect();
                EditText editText = (EditText) currentFocus;
                editText.getGlobalVisibleRect(rect);
                if (!rect.contains((int) ev.getRawX(), (int) ev.getRawY()) && !isTouchOnInputArea(ev)) {
                    editText.clearFocus();
                    Object systemService = getSystemService("input_method");
                    InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
                    if (inputMethodManager != null) {
                        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                    }
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    private final boolean isTouchOnInputArea(MotionEvent ev) {
        FragmentContainerView fragmentContainerView;
        TraeActivityConversationBinding traeActivityConversationBinding = this.binding;
        TraeActivityConversationBinding traeActivityConversationBinding2 = null;
        if (traeActivityConversationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            traeActivityConversationBinding = null;
        }
        if (traeActivityConversationBinding.checkpointOverlayContainer.getVisibility() == 0) {
            TraeActivityConversationBinding traeActivityConversationBinding3 = this.binding;
            if (traeActivityConversationBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                traeActivityConversationBinding2 = traeActivityConversationBinding3;
            }
            fragmentContainerView = traeActivityConversationBinding2.checkpointOverlayContainer;
        } else {
            TraeActivityConversationBinding traeActivityConversationBinding4 = this.binding;
            if (traeActivityConversationBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                traeActivityConversationBinding2 = traeActivityConversationBinding4;
            }
            fragmentContainerView = traeActivityConversationBinding2.inputFragmentContainer;
        }
        Intrinsics.checkNotNull(fragmentContainerView);
        if (fragmentContainerView.getVisibility() != 0) {
            return false;
        }
        Rect rect = new Rect();
        fragmentContainerView.getGlobalVisibleRect(rect);
        return rect.contains((int) ev.getRawX(), (int) ev.getRawY());
    }

    private final void observeManagedPrompts() {
        Job job = this.managedPromptResolutionJob;
        boolean z = false;
        if (job != null && job.isActive()) {
            z = true;
        }
        if (z) {
            return;
        }
        CoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this);
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
        this.managedPromptResolutionJob = BillingUpgradePromptLifecycleKt.launchManagedPromptResolutionWhenResumed(lifecycleScope, lifecycle, new ConversationActivity$observeManagedPrompts$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x002c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:117:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0284  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:137:0x035f -> B:12:0x0385). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:148:0x0383 -> B:12:0x0385). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x014d -> B:13:0x00d8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x01b5 -> B:13:0x00d8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolveManagedPromptsWhileResumed(Continuation<? super Unit> continuation) {
        ConversationActivity$resolveManagedPromptsWhileResumed$1 conversationActivity$resolveManagedPromptsWhileResumed$1;
        ConversationActivity conversationActivity;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        ConversationActivity conversationActivity2;
        ManagedPromptCandidateState managedPromptCandidateState;
        String str;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        ConversationActivity conversationActivity3;
        Ref.ObjectRef objectRef5;
        int i;
        PreparedNewFeaturePrompt preparedNewFeaturePrompt;
        ManagedPromptDecision managedPromptDecision;
        String str2;
        Ref.ObjectRef objectRef6;
        ConversationActivity conversationActivity4;
        List<MobileDevice> list;
        int i2;
        DeviceDiscoveryRefreshResult deviceDiscoveryRefreshResult;
        ManagedPromptCandidateState managedPromptCandidateState2;
        PreparedNewFeaturePrompt preparedNewFeaturePrompt2;
        ManagedPromptCandidateState.Ineligible ineligible;
        ManagedPromptCandidateState.Ineligible ineligible2;
        ManagedPromptDisplayOutcome showCandidate$conversation_mainlandRelease;
        if (continuation instanceof ConversationActivity$resolveManagedPromptsWhileResumed$1) {
            conversationActivity$resolveManagedPromptsWhileResumed$1 = (ConversationActivity$resolveManagedPromptsWhileResumed$1) continuation;
            if ((conversationActivity$resolveManagedPromptsWhileResumed$1.label & Integer.MIN_VALUE) != 0) {
                conversationActivity$resolveManagedPromptsWhileResumed$1.label -= Integer.MIN_VALUE;
                conversationActivity = this;
                Object obj = conversationActivity$resolveManagedPromptsWhileResumed$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = 3;
                switch (conversationActivity$resolveManagedPromptsWhileResumed$1.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        Ref.ObjectRef objectRef7 = new Ref.ObjectRef();
                        objectRef = new Ref.ObjectRef();
                        objectRef2 = objectRef7;
                        conversationActivity2 = conversationActivity;
                        while (JobKt.isActive(conversationActivity$resolveManagedPromptsWhileResumed$1.getContext())) {
                            String currentLoggedInUserId = conversationActivity2.currentLoggedInUserId();
                            if (currentLoggedInUserId == null) {
                                return Unit.INSTANCE;
                            }
                            if (ManagedPromptArbitrationPolicy.INSTANCE.decide(System.currentTimeMillis(), ManagedPromptLedgerStore.INSTANCE.snapshot(currentLoggedInUserId), ManagedPromptCandidateState.Preparing.INSTANCE, ManagedPromptCandidateState.Preparing.INSTANCE) instanceof ManagedPromptDecision.CoolingDown) {
                                return Unit.INSTANCE;
                            }
                            if (conversationActivity2.shouldDelayManagedPromptsForPendingConnect()) {
                                conversationActivity$resolveManagedPromptsWhileResumed$1.L$0 = conversationActivity2;
                                conversationActivity$resolveManagedPromptsWhileResumed$1.L$1 = objectRef2;
                                conversationActivity$resolveManagedPromptsWhileResumed$1.L$2 = objectRef;
                                conversationActivity$resolveManagedPromptsWhileResumed$1.label = 1;
                                if (DelayKt.delay(500L, conversationActivity$resolveManagedPromptsWhileResumed$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                BillingUpgradePromptCoordinator billingUpgradePromptCoordinator = BillingUpgradePromptCoordinator.INSTANCE;
                                conversationActivity$resolveManagedPromptsWhileResumed$1.L$0 = conversationActivity2;
                                conversationActivity$resolveManagedPromptsWhileResumed$1.L$1 = objectRef2;
                                conversationActivity$resolveManagedPromptsWhileResumed$1.L$2 = objectRef;
                                conversationActivity$resolveManagedPromptsWhileResumed$1.label = 2;
                                obj = billingUpgradePromptCoordinator.awaitReady(30000L, conversationActivity$resolveManagedPromptsWhileResumed$1);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                objectRef4 = objectRef2;
                                conversationActivity3 = conversationActivity2;
                                objectRef3 = objectRef;
                                if (!((Boolean) obj).booleanValue()) {
                                    conversationActivity$resolveManagedPromptsWhileResumed$1.L$0 = conversationActivity3;
                                    conversationActivity$resolveManagedPromptsWhileResumed$1.L$1 = objectRef4;
                                    conversationActivity$resolveManagedPromptsWhileResumed$1.L$2 = objectRef3;
                                    conversationActivity$resolveManagedPromptsWhileResumed$1.label = i3;
                                    if (DelayKt.delay(500L, conversationActivity$resolveManagedPromptsWhileResumed$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    objectRef = objectRef3;
                                    objectRef2 = objectRef4;
                                    conversationActivity2 = conversationActivity3;
                                    while (JobKt.isActive(conversationActivity$resolveManagedPromptsWhileResumed$1.getContext())) {
                                    }
                                } else {
                                    str = conversationActivity3.currentLoggedInUserId();
                                    if (str == null) {
                                        return Unit.INSTANCE;
                                    }
                                    BillingUpgradePromptCoordinator.CandidateSnapshot candidateSnapshot$conversation_mainlandRelease = BillingUpgradePromptCoordinator.INSTANCE.candidateSnapshot$conversation_mainlandRelease();
                                    boolean z = conversationActivity3.isNewConversation && !conversationActivity3.suppressNaturalGuideForPendingConnect && NewFeaturePromptEntryPolicy.INSTANCE.canRequestNaturalPrompt(NewFeaturePromptEntry.NEW_CHAT);
                                    ManagedPromptArbitrationPolicy managedPromptArbitrationPolicy = ManagedPromptArbitrationPolicy.INSTANCE;
                                    long currentTimeMillis = System.currentTimeMillis();
                                    ManagedPromptLedgerState snapshot = ManagedPromptLedgerStore.INSTANCE.snapshot(str);
                                    ManagedPromptCandidateState state = candidateSnapshot$conversation_mainlandRelease.getState();
                                    if (z) {
                                        ineligible2 = ManagedPromptCandidateState.Preparing.INSTANCE;
                                    } else {
                                        ineligible2 = ManagedPromptCandidateState.Ineligible.INSTANCE;
                                    }
                                    ManagedPromptDecision decide = managedPromptArbitrationPolicy.decide(currentTimeMillis, snapshot, state, ineligible2);
                                    ManagedPromptCandidateState state2 = candidateSnapshot$conversation_mainlandRelease.getState();
                                    if (Intrinsics.areEqual(decide, ManagedPromptDecision.WaitForBilling.INSTANCE)) {
                                        conversationActivity$resolveManagedPromptsWhileResumed$1.L$0 = conversationActivity3;
                                        conversationActivity$resolveManagedPromptsWhileResumed$1.L$1 = objectRef4;
                                        conversationActivity$resolveManagedPromptsWhileResumed$1.L$2 = objectRef3;
                                        conversationActivity$resolveManagedPromptsWhileResumed$1.label = 4;
                                        if (DelayKt.delay(500L, conversationActivity$resolveManagedPromptsWhileResumed$1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if ((decide instanceof ManagedPromptDecision.CoolingDown) || Intrinsics.areEqual(decide, ManagedPromptDecision.NothingToShow.INSTANCE)) {
                                            return Unit.INSTANCE;
                                        }
                                        if (decide instanceof ManagedPromptDecision.Show) {
                                            BillingUpgradePromptData promptData = candidateSnapshot$conversation_mainlandRelease.getPromptData();
                                            if (promptData == null) {
                                                showCandidate$conversation_mainlandRelease = ManagedPromptDisplayOutcome.NotShown;
                                            } else {
                                                showCandidate$conversation_mainlandRelease = BillingUpgradePromptCoordinator.INSTANCE.showCandidate$conversation_mainlandRelease((FragmentActivity) conversationActivity3, str, promptData);
                                            }
                                            int i4 = WhenMappings.$EnumSwitchMapping$1[ManagedPromptAttemptPolicy.INSTANCE.afterAttempt(((ManagedPromptDecision.Show) decide).getCandidate(), showCandidate$conversation_mainlandRelease).ordinal()];
                                            if (i4 == 1) {
                                                return Unit.INSTANCE;
                                            }
                                            if (i4 == 2) {
                                                conversationActivity$resolveManagedPromptsWhileResumed$1.L$0 = conversationActivity3;
                                                conversationActivity$resolveManagedPromptsWhileResumed$1.L$1 = objectRef4;
                                                conversationActivity$resolveManagedPromptsWhileResumed$1.L$2 = objectRef3;
                                                conversationActivity$resolveManagedPromptsWhileResumed$1.label = 5;
                                                if (DelayKt.delay(500L, conversationActivity$resolveManagedPromptsWhileResumed$1) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                            } else {
                                                if (i4 != 3) {
                                                    throw new NoWhenBranchMatchedException();
                                                }
                                                state2 = ManagedPromptCandidateState.Ineligible.INSTANCE;
                                            }
                                        } else if (!Intrinsics.areEqual(decide, ManagedPromptDecision.WaitForGuide.INSTANCE)) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        if (!z || !Intrinsics.areEqual(conversationActivity3.currentLoggedInUserId(), str)) {
                                            return Unit.INSTANCE;
                                        }
                                        preparedNewFeaturePrompt2 = (PreparedNewFeaturePrompt) objectRef4.element;
                                        if (preparedNewFeaturePrompt2 != null) {
                                            managedPromptCandidateState2 = state2;
                                            conversationActivity4 = conversationActivity3;
                                            objectRef6 = objectRef4;
                                            objectRef5 = objectRef3;
                                            str2 = str;
                                            if (preparedNewFeaturePrompt2 != null) {
                                            }
                                            managedPromptDecision = ManagedPromptArbitrationPolicy.INSTANCE.decide(System.currentTimeMillis(), ManagedPromptLedgerStore.INSTANCE.snapshot(str2), managedPromptCandidateState2, ineligible);
                                            if (!(managedPromptDecision instanceof ManagedPromptDecision.CoolingDown)) {
                                            }
                                            return Unit.INSTANCE;
                                        }
                                        conversationActivity$resolveManagedPromptsWhileResumed$1.L$0 = conversationActivity3;
                                        conversationActivity$resolveManagedPromptsWhileResumed$1.L$1 = objectRef4;
                                        conversationActivity$resolveManagedPromptsWhileResumed$1.L$2 = objectRef3;
                                        conversationActivity$resolveManagedPromptsWhileResumed$1.L$3 = str;
                                        conversationActivity$resolveManagedPromptsWhileResumed$1.L$4 = state2;
                                        conversationActivity$resolveManagedPromptsWhileResumed$1.label = 6;
                                        obj = conversationActivity3.prepareNewFeaturePrompt(str, conversationActivity$resolveManagedPromptsWhileResumed$1);
                                        if (obj == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        managedPromptCandidateState = state2;
                                        preparedNewFeaturePrompt2 = (PreparedNewFeaturePrompt) obj;
                                        if (preparedNewFeaturePrompt2 == null) {
                                            objectRef4.element = preparedNewFeaturePrompt2;
                                            managedPromptCandidateState2 = managedPromptCandidateState;
                                            conversationActivity4 = conversationActivity3;
                                            objectRef6 = objectRef4;
                                            objectRef5 = objectRef3;
                                            str2 = str;
                                            if (preparedNewFeaturePrompt2 != null) {
                                                ineligible = new ManagedPromptCandidateState.Eligible(preparedNewFeaturePrompt2.getCandidate());
                                            } else {
                                                ineligible = ManagedPromptCandidateState.Ineligible.INSTANCE;
                                            }
                                            managedPromptDecision = ManagedPromptArbitrationPolicy.INSTANCE.decide(System.currentTimeMillis(), ManagedPromptLedgerStore.INSTANCE.snapshot(str2), managedPromptCandidateState2, ineligible);
                                            if (!(managedPromptDecision instanceof ManagedPromptDecision.CoolingDown) || Intrinsics.areEqual(managedPromptDecision, ManagedPromptDecision.NothingToShow.INSTANCE)) {
                                                return Unit.INSTANCE;
                                            }
                                            if (Intrinsics.areEqual(managedPromptDecision, ManagedPromptDecision.WaitForBilling.INSTANCE) || Intrinsics.areEqual(managedPromptDecision, ManagedPromptDecision.WaitForGuide.INSTANCE)) {
                                                i = 3;
                                                conversationActivity$resolveManagedPromptsWhileResumed$1.L$0 = conversationActivity4;
                                                conversationActivity$resolveManagedPromptsWhileResumed$1.L$1 = objectRef6;
                                                conversationActivity$resolveManagedPromptsWhileResumed$1.L$2 = objectRef5;
                                                conversationActivity$resolveManagedPromptsWhileResumed$1.L$3 = null;
                                                conversationActivity$resolveManagedPromptsWhileResumed$1.L$4 = null;
                                                conversationActivity$resolveManagedPromptsWhileResumed$1.label = 7;
                                                if (DelayKt.delay(500L, conversationActivity$resolveManagedPromptsWhileResumed$1) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                objectRef2 = objectRef6;
                                                conversationActivity2 = conversationActivity4;
                                                i3 = i;
                                                objectRef = objectRef5;
                                                while (JobKt.isActive(conversationActivity$resolveManagedPromptsWhileResumed$1.getContext())) {
                                                }
                                            } else {
                                                if (!(managedPromptDecision instanceof ManagedPromptDecision.Show)) {
                                                    throw new NoWhenBranchMatchedException();
                                                }
                                                if (preparedNewFeaturePrompt2 != null) {
                                                    preparedNewFeaturePrompt = Intrinsics.areEqual(preparedNewFeaturePrompt2.getCandidate(), ((ManagedPromptDecision.Show) managedPromptDecision).getCandidate()) ? preparedNewFeaturePrompt2 : null;
                                                    if (preparedNewFeaturePrompt != null) {
                                                        if (!conversationActivity4.isManagedPromptHostReady()) {
                                                            conversationActivity$resolveManagedPromptsWhileResumed$1.L$0 = conversationActivity4;
                                                            conversationActivity$resolveManagedPromptsWhileResumed$1.L$1 = objectRef6;
                                                            conversationActivity$resolveManagedPromptsWhileResumed$1.L$2 = objectRef5;
                                                            conversationActivity$resolveManagedPromptsWhileResumed$1.L$3 = null;
                                                            conversationActivity$resolveManagedPromptsWhileResumed$1.L$4 = null;
                                                            conversationActivity$resolveManagedPromptsWhileResumed$1.label = 8;
                                                            if (DelayKt.delay(500L, conversationActivity$resolveManagedPromptsWhileResumed$1) == coroutine_suspended) {
                                                                return coroutine_suspended;
                                                            }
                                                            objectRef = objectRef5;
                                                            objectRef2 = objectRef6;
                                                            conversationActivity2 = conversationActivity4;
                                                            i3 = 3;
                                                            while (JobKt.isActive(conversationActivity$resolveManagedPromptsWhileResumed$1.getContext())) {
                                                            }
                                                        } else {
                                                            list = (List) objectRef5.element;
                                                            if (list == null) {
                                                                CliListRepository companion = CliListRepository.INSTANCE.getInstance();
                                                                conversationActivity$resolveManagedPromptsWhileResumed$1.L$0 = conversationActivity4;
                                                                conversationActivity$resolveManagedPromptsWhileResumed$1.L$1 = objectRef6;
                                                                conversationActivity$resolveManagedPromptsWhileResumed$1.L$2 = objectRef5;
                                                                conversationActivity$resolveManagedPromptsWhileResumed$1.L$3 = str2;
                                                                conversationActivity$resolveManagedPromptsWhileResumed$1.L$4 = managedPromptDecision;
                                                                conversationActivity$resolveManagedPromptsWhileResumed$1.L$5 = preparedNewFeaturePrompt;
                                                                conversationActivity$resolveManagedPromptsWhileResumed$1.label = 9;
                                                                obj = companion.refreshDiscoverableDevices(conversationActivity$resolveManagedPromptsWhileResumed$1);
                                                                if (obj == coroutine_suspended) {
                                                                    return coroutine_suspended;
                                                                }
                                                                if (!((DeviceDiscoveryRefreshResult) obj).isSuccess()) {
                                                                    obj = null;
                                                                }
                                                                deviceDiscoveryRefreshResult = (DeviceDiscoveryRefreshResult) obj;
                                                                if (deviceDiscoveryRefreshResult != null || (list = deviceDiscoveryRefreshResult.getDevices()) == null) {
                                                                    list = null;
                                                                } else {
                                                                    objectRef5.element = list;
                                                                }
                                                                if (list == null) {
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }
                                                            String str3 = str2;
                                                            conversationActivity2 = conversationActivity4;
                                                            i2 = WhenMappings.$EnumSwitchMapping$1[ManagedPromptAttemptPolicy.INSTANCE.afterAttempt(((ManagedPromptDecision.Show) managedPromptDecision).getCandidate(), conversationActivity2.showNewFeaturePrompt(preparedNewFeaturePrompt, list, str3)).ordinal()];
                                                            if (i2 != 1) {
                                                                if (i2 == 2) {
                                                                    i = 3;
                                                                    conversationActivity$resolveManagedPromptsWhileResumed$1.L$0 = conversationActivity2;
                                                                    conversationActivity$resolveManagedPromptsWhileResumed$1.L$1 = objectRef6;
                                                                    conversationActivity$resolveManagedPromptsWhileResumed$1.L$2 = objectRef5;
                                                                    conversationActivity$resolveManagedPromptsWhileResumed$1.L$3 = null;
                                                                    conversationActivity$resolveManagedPromptsWhileResumed$1.L$4 = null;
                                                                    conversationActivity$resolveManagedPromptsWhileResumed$1.L$5 = null;
                                                                    conversationActivity$resolveManagedPromptsWhileResumed$1.label = 10;
                                                                    if (DelayKt.delay(500L, conversationActivity$resolveManagedPromptsWhileResumed$1) == coroutine_suspended) {
                                                                        return coroutine_suspended;
                                                                    }
                                                                    objectRef2 = objectRef6;
                                                                    i3 = i;
                                                                    objectRef = objectRef5;
                                                                    while (JobKt.isActive(conversationActivity$resolveManagedPromptsWhileResumed$1.getContext())) {
                                                                    }
                                                                } else if (i2 != 3) {
                                                                    throw new NoWhenBranchMatchedException();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        } else {
                                            managedPromptCandidateState2 = managedPromptCandidateState;
                                            conversationActivity4 = conversationActivity3;
                                            preparedNewFeaturePrompt2 = null;
                                            objectRef6 = objectRef4;
                                            objectRef5 = objectRef3;
                                            str2 = str;
                                            if (preparedNewFeaturePrompt2 != null) {
                                            }
                                            managedPromptDecision = ManagedPromptArbitrationPolicy.INSTANCE.decide(System.currentTimeMillis(), ManagedPromptLedgerStore.INSTANCE.snapshot(str2), managedPromptCandidateState2, ineligible);
                                            if (!(managedPromptDecision instanceof ManagedPromptDecision.CoolingDown)) {
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }
                                    objectRef = objectRef3;
                                    objectRef2 = objectRef4;
                                    conversationActivity2 = conversationActivity3;
                                    i3 = 3;
                                    while (JobKt.isActive(conversationActivity$resolveManagedPromptsWhileResumed$1.getContext())) {
                                    }
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                    case 3:
                        objectRef = (Ref.ObjectRef) conversationActivity$resolveManagedPromptsWhileResumed$1.L$2;
                        objectRef2 = (Ref.ObjectRef) conversationActivity$resolveManagedPromptsWhileResumed$1.L$1;
                        conversationActivity2 = (ConversationActivity) conversationActivity$resolveManagedPromptsWhileResumed$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        while (JobKt.isActive(conversationActivity$resolveManagedPromptsWhileResumed$1.getContext())) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        objectRef = (Ref.ObjectRef) conversationActivity$resolveManagedPromptsWhileResumed$1.L$2;
                        objectRef2 = (Ref.ObjectRef) conversationActivity$resolveManagedPromptsWhileResumed$1.L$1;
                        conversationActivity2 = (ConversationActivity) conversationActivity$resolveManagedPromptsWhileResumed$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        objectRef4 = objectRef2;
                        conversationActivity3 = conversationActivity2;
                        objectRef3 = objectRef;
                        if (!((Boolean) obj).booleanValue()) {
                        }
                        break;
                    case 4:
                    case 5:
                    case 8:
                        objectRef = (Ref.ObjectRef) conversationActivity$resolveManagedPromptsWhileResumed$1.L$2;
                        objectRef2 = (Ref.ObjectRef) conversationActivity$resolveManagedPromptsWhileResumed$1.L$1;
                        conversationActivity2 = (ConversationActivity) conversationActivity$resolveManagedPromptsWhileResumed$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        i3 = 3;
                        while (JobKt.isActive(conversationActivity$resolveManagedPromptsWhileResumed$1.getContext())) {
                        }
                        return Unit.INSTANCE;
                    case 6:
                        managedPromptCandidateState = (ManagedPromptCandidateState) conversationActivity$resolveManagedPromptsWhileResumed$1.L$4;
                        str = (String) conversationActivity$resolveManagedPromptsWhileResumed$1.L$3;
                        objectRef3 = (Ref.ObjectRef) conversationActivity$resolveManagedPromptsWhileResumed$1.L$2;
                        objectRef4 = (Ref.ObjectRef) conversationActivity$resolveManagedPromptsWhileResumed$1.L$1;
                        conversationActivity3 = (ConversationActivity) conversationActivity$resolveManagedPromptsWhileResumed$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        preparedNewFeaturePrompt2 = (PreparedNewFeaturePrompt) obj;
                        if (preparedNewFeaturePrompt2 == null) {
                        }
                        break;
                    case 7:
                        Ref.ObjectRef objectRef8 = (Ref.ObjectRef) conversationActivity$resolveManagedPromptsWhileResumed$1.L$2;
                        objectRef2 = (Ref.ObjectRef) conversationActivity$resolveManagedPromptsWhileResumed$1.L$1;
                        conversationActivity2 = (ConversationActivity) conversationActivity$resolveManagedPromptsWhileResumed$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        objectRef5 = objectRef8;
                        i = 3;
                        i3 = i;
                        objectRef = objectRef5;
                        while (JobKt.isActive(conversationActivity$resolveManagedPromptsWhileResumed$1.getContext())) {
                        }
                        return Unit.INSTANCE;
                    case 9:
                        preparedNewFeaturePrompt = (PreparedNewFeaturePrompt) conversationActivity$resolveManagedPromptsWhileResumed$1.L$5;
                        managedPromptDecision = (ManagedPromptDecision) conversationActivity$resolveManagedPromptsWhileResumed$1.L$4;
                        str2 = (String) conversationActivity$resolveManagedPromptsWhileResumed$1.L$3;
                        objectRef5 = (Ref.ObjectRef) conversationActivity$resolveManagedPromptsWhileResumed$1.L$2;
                        objectRef6 = (Ref.ObjectRef) conversationActivity$resolveManagedPromptsWhileResumed$1.L$1;
                        conversationActivity4 = (ConversationActivity) conversationActivity$resolveManagedPromptsWhileResumed$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (!((DeviceDiscoveryRefreshResult) obj).isSuccess()) {
                        }
                        deviceDiscoveryRefreshResult = (DeviceDiscoveryRefreshResult) obj;
                        if (deviceDiscoveryRefreshResult != null) {
                            break;
                        }
                        list = null;
                        if (list == null) {
                        }
                        String str32 = str2;
                        conversationActivity2 = conversationActivity4;
                        i2 = WhenMappings.$EnumSwitchMapping$1[ManagedPromptAttemptPolicy.INSTANCE.afterAttempt(((ManagedPromptDecision.Show) managedPromptDecision).getCandidate(), conversationActivity2.showNewFeaturePrompt(preparedNewFeaturePrompt, list, str32)).ordinal()];
                        if (i2 != 1) {
                        }
                        return Unit.INSTANCE;
                    case 10:
                        Ref.ObjectRef objectRef9 = (Ref.ObjectRef) conversationActivity$resolveManagedPromptsWhileResumed$1.L$2;
                        objectRef2 = (Ref.ObjectRef) conversationActivity$resolveManagedPromptsWhileResumed$1.L$1;
                        conversationActivity2 = (ConversationActivity) conversationActivity$resolveManagedPromptsWhileResumed$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        objectRef5 = objectRef9;
                        i = 3;
                        i3 = i;
                        objectRef = objectRef5;
                        while (JobKt.isActive(conversationActivity$resolveManagedPromptsWhileResumed$1.getContext())) {
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        conversationActivity = this;
        conversationActivity$resolveManagedPromptsWhileResumed$1 = new ConversationActivity$resolveManagedPromptsWhileResumed$1(conversationActivity, continuation);
        Object obj2 = conversationActivity$resolveManagedPromptsWhileResumed$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i32 = 3;
        switch (conversationActivity$resolveManagedPromptsWhileResumed$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onResume() {
        super.onResume();
        if (this.isNewConversation) {
            getGitSelectionViewModel().fetchRepos();
        }
        executePendingConnectDevice();
        applyMinimizedVoiceVisibility();
        if (BrainstormSessionHolder.INSTANCE.isMinimized()) {
            if (BrainstormSessionHolder.INSTANCE.isMicMuted()) {
                VolcRtcClient.INSTANCE.stopAudioCapture();
                BrainstormVoiceForegroundService.INSTANCE.update((Context) this, true);
            } else {
                BrainstormVoiceForegroundService.INSTANCE.update((Context) this, false);
                VolcRtcClient.INSTANCE.startAudioCapture();
            }
        }
        INetworkDepend.INSTANCE.getInstance().checkAlive();
        if (this.hasEnteredBackground) {
            this.hasEnteredBackground = false;
            ConversationViewModel conversationViewModel = this.viewModel;
            if (conversationViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                conversationViewModel = null;
            }
            conversationViewModel.refreshMessagesOnResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object prepareNewFeaturePrompt(String str, Continuation<? super PreparedNewFeaturePrompt> continuation) {
        ConversationActivity$prepareNewFeaturePrompt$1 conversationActivity$prepareNewFeaturePrompt$1;
        int i;
        NewFeaturePromptConfig config$default;
        Object onboardingState;
        OnboardingStateResult onboardingStateResult;
        OnboardingState state;
        NewFeaturePromptState copy;
        NewFeaturePromptDecision choosePrompt$default;
        String str2 = str;
        if (continuation instanceof ConversationActivity$prepareNewFeaturePrompt$1) {
            conversationActivity$prepareNewFeaturePrompt$1 = (ConversationActivity$prepareNewFeaturePrompt$1) continuation;
            if ((conversationActivity$prepareNewFeaturePrompt$1.label & Integer.MIN_VALUE) != 0) {
                conversationActivity$prepareNewFeaturePrompt$1.label -= Integer.MIN_VALUE;
                Object obj = conversationActivity$prepareNewFeaturePrompt$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = conversationActivity$prepareNewFeaturePrompt$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    config$default = NewFeaturePromptSettingsProvider.getConfig$default(NewFeaturePromptSettingsProvider.INSTANCE, null, 1, null);
                    if (config$default.getEnable() && Intrinsics.areEqual(currentLoggedInUserId(), str2)) {
                        CliListRepository companion = CliListRepository.INSTANCE.getInstance();
                        conversationActivity$prepareNewFeaturePrompt$1.L$0 = str2;
                        conversationActivity$prepareNewFeaturePrompt$1.L$1 = config$default;
                        conversationActivity$prepareNewFeaturePrompt$1.label = 1;
                        onboardingState = companion.getOnboardingState(conversationActivity$prepareNewFeaturePrompt$1);
                        if (onboardingState == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return null;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                NewFeaturePromptConfig newFeaturePromptConfig = (NewFeaturePromptConfig) conversationActivity$prepareNewFeaturePrompt$1.L$1;
                String str3 = (String) conversationActivity$prepareNewFeaturePrompt$1.L$0;
                ResultKt.throwOnFailure(obj);
                config$default = newFeaturePromptConfig;
                str2 = str3;
                onboardingState = obj;
                onboardingStateResult = (OnboardingStateResult) onboardingState;
                state = onboardingStateResult.getState();
                if (onboardingStateResult.isSuccess() && state != null) {
                    NewFeaturePromptPolicy newFeaturePromptPolicy = NewFeaturePromptPolicy.INSTANCE;
                    NewFeaturePromptState snapshot = NewFeaturePromptStore.INSTANCE.snapshot(str2, config$default);
                    Set<DeviceProductType> eligibleNewFeaturePromptProducts = MobileIdeFeatureGate.INSTANCE.eligibleNewFeaturePromptProducts();
                    Set createSetBuilder = SetsKt.createSetBuilder();
                    if (state.getHasRegisteredWork()) {
                        createSetBuilder.add(DeviceProductType.WORK);
                    }
                    if (state.getHasRegisteredIDE()) {
                        createSetBuilder.add(DeviceProductType.IDE);
                    }
                    Unit unit = Unit.INSTANCE;
                    copy = snapshot.copy((r23 & 1) != 0 ? snapshot.shownProductTypes : null, (r23 & 2) != 0 ? snapshot.eligibleProductTypes : eligibleNewFeaturePromptProducts, (r23 & 4) != 0 ? snapshot.registeredProductTypes : SetsKt.build(createSetBuilder), (r23 & 8) != 0 ? snapshot.shownRecords : null, (r23 & 16) != 0 ? snapshot.highestShownVersions : null, (r23 & 32) != 0 ? snapshot.firstLoginObservedAtMillis : 0L, (r23 & 64) != 0 ? snapshot.hasConversation : state.getHasConversation(), (r23 & 128) != 0 ? snapshot.lastShownAtMillis : 0L);
                    choosePrompt$default = NewFeaturePromptPolicy.choosePrompt$default(newFeaturePromptPolicy, copy, config$default, 0L, 4, null);
                    if (choosePrompt$default != null) {
                        return null;
                    }
                    return new PreparedNewFeaturePrompt(NewFeaturePromptPolicy.INSTANCE.managedCandidate$conversation_mainlandRelease(choosePrompt$default.getProductType(), config$default), choosePrompt$default.getProductType(), state.getHasRegisteredWork(), state.getHasRegisteredIDE(), config$default);
                }
                return null;
            }
        }
        conversationActivity$prepareNewFeaturePrompt$1 = new ConversationActivity$prepareNewFeaturePrompt$1(this, continuation);
        Object obj2 = conversationActivity$prepareNewFeaturePrompt$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = conversationActivity$prepareNewFeaturePrompt$1.label;
        if (i != 0) {
        }
        onboardingStateResult = (OnboardingStateResult) onboardingState;
        state = onboardingStateResult.getState();
        if (onboardingStateResult.isSuccess()) {
            NewFeaturePromptPolicy newFeaturePromptPolicy2 = NewFeaturePromptPolicy.INSTANCE;
            NewFeaturePromptState snapshot2 = NewFeaturePromptStore.INSTANCE.snapshot(str2, config$default);
            Set<DeviceProductType> eligibleNewFeaturePromptProducts2 = MobileIdeFeatureGate.INSTANCE.eligibleNewFeaturePromptProducts();
            Set createSetBuilder2 = SetsKt.createSetBuilder();
            if (state.getHasRegisteredWork()) {
            }
            if (state.getHasRegisteredIDE()) {
            }
            Unit unit2 = Unit.INSTANCE;
            copy = snapshot2.copy((r23 & 1) != 0 ? snapshot2.shownProductTypes : null, (r23 & 2) != 0 ? snapshot2.eligibleProductTypes : eligibleNewFeaturePromptProducts2, (r23 & 4) != 0 ? snapshot2.registeredProductTypes : SetsKt.build(createSetBuilder2), (r23 & 8) != 0 ? snapshot2.shownRecords : null, (r23 & 16) != 0 ? snapshot2.highestShownVersions : null, (r23 & 32) != 0 ? snapshot2.firstLoginObservedAtMillis : 0L, (r23 & 64) != 0 ? snapshot2.hasConversation : state.getHasConversation(), (r23 & 128) != 0 ? snapshot2.lastShownAtMillis : 0L);
            choosePrompt$default = NewFeaturePromptPolicy.choosePrompt$default(newFeaturePromptPolicy2, copy, config$default, 0L, 4, null);
            if (choosePrompt$default != null) {
            }
        }
        return null;
    }

    private final ManagedPromptDisplayOutcome showNewFeaturePrompt(PreparedNewFeaturePrompt prepared, List<MobileDevice> devices, String userId) {
        DeviceFlowContainerBottomSheet deviceFlowContainerBottomSheet;
        PreparedNewFeaturePrompt preparedNewFeaturePrompt;
        DeviceFlowContainerBottomSheet deviceFlowContainerBottomSheet2;
        DeviceFlowContainerBottomSheet deviceFlowContainerBottomSheet3;
        DeviceFlowContainerBottomSheet deviceFlowContainerBottomSheet4;
        ManagedPromptDisplayOutcome managedPromptDisplayOutcome;
        if (!Intrinsics.areEqual(currentLoggedInUserId(), userId)) {
            return ManagedPromptDisplayOutcome.NotShown;
        }
        if (!isManagedPromptHostReady()) {
            return ManagedPromptDisplayOutcome.TemporarilyBlocked;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = DeviceFlowContainerBottomSheet.INSTANCE.newInstance(new DeviceFlowRequest(new DeviceFlowRoute.NewFeaturePrompt(prepared.getProductType(), devices, prepared.getHasRegisteredWork(), prepared.getHasRegisteredIDE()), new DeviceFlowCallbacks(null, null, new Function1() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Unit showNewFeaturePrompt$lambda$91;
                showNewFeaturePrompt$lambda$91 = ConversationActivity.showNewFeaturePrompt$lambda$91(ConversationActivity.this, (DeviceProductType) obj);
                return showNewFeaturePrompt$lambda$91;
            }
        }, new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda8
            public final Object invoke() {
                Unit showNewFeaturePrompt$lambda$92;
                showNewFeaturePrompt$lambda$92 = ConversationActivity.showNewFeaturePrompt$lambda$92(ConversationActivity.this, objectRef);
                return showNewFeaturePrompt$lambda$92;
            }
        }, new Function1() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                Unit showNewFeaturePrompt$lambda$93;
                showNewFeaturePrompt$lambda$93 = ConversationActivity.showNewFeaturePrompt$lambda$93(ConversationActivity.this, objectRef, (MobileDevice) obj);
                return showNewFeaturePrompt$lambda$93;
            }
        }, new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda10
            public final Object invoke() {
                Unit showNewFeaturePrompt$lambda$94;
                showNewFeaturePrompt$lambda$94 = ConversationActivity.showNewFeaturePrompt$lambda$94(ConversationActivity.this, objectRef);
                return showNewFeaturePrompt$lambda$94;
            }
        }, 3, null)));
        if (objectRef.element == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sheet");
            deviceFlowContainerBottomSheet = null;
        } else {
            deviceFlowContainerBottomSheet = (DeviceFlowContainerBottomSheet) objectRef.element;
        }
        this.newFeaturePromptSheet = deviceFlowContainerBottomSheet;
        try {
            if (objectRef.element == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sheet");
                deviceFlowContainerBottomSheet3 = null;
            } else {
                deviceFlowContainerBottomSheet3 = (DeviceFlowContainerBottomSheet) objectRef.element;
            }
            preparedNewFeaturePrompt = getSupportFragmentManager();
            deviceFlowContainerBottomSheet3.showNow(preparedNewFeaturePrompt, DeviceFlowContainerBottomSheet.TAG);
            if (objectRef.element == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sheet");
                deviceFlowContainerBottomSheet4 = null;
            } else {
                deviceFlowContainerBottomSheet4 = (DeviceFlowContainerBottomSheet) objectRef.element;
            }
            try {
                if (isCommittedNewFeaturePrompt(deviceFlowContainerBottomSheet4)) {
                    preparedNewFeaturePrompt = prepared;
                    recordNewFeaturePromptShown(userId, preparedNewFeaturePrompt);
                    managedPromptDisplayOutcome = ManagedPromptDisplayOutcome.Shown;
                } else {
                    preparedNewFeaturePrompt = prepared;
                    this.newFeaturePromptSheet = null;
                    managedPromptDisplayOutcome = ManagedPromptDisplayOutcome.NotShown;
                }
                return managedPromptDisplayOutcome;
            } catch (Throwable th) {
                th = th;
                TraeLogUtil.INSTANCE.w(TAG, "show new feature prompt failed", th);
                if (objectRef.element == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sheet");
                    deviceFlowContainerBottomSheet2 = null;
                } else {
                    deviceFlowContainerBottomSheet2 = (DeviceFlowContainerBottomSheet) objectRef.element;
                }
                if (isCommittedNewFeaturePrompt(deviceFlowContainerBottomSheet2)) {
                    recordNewFeaturePromptShown(userId, preparedNewFeaturePrompt);
                    return ManagedPromptDisplayOutcome.Shown;
                }
                this.newFeaturePromptSheet = null;
                return ManagedPromptDisplayOutcome.NotShown;
            }
        } catch (Throwable th2) {
            th = th2;
            preparedNewFeaturePrompt = prepared;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showNewFeaturePrompt$lambda$91(ConversationActivity conversationActivity, DeviceProductType deviceProductType) {
        Intrinsics.checkNotNullParameter(deviceProductType, "confirmedProduct");
        if (deviceProductType == DeviceProductType.IDE) {
            conversationActivity.switchToCodeMode();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showNewFeaturePrompt$lambda$93(ConversationActivity conversationActivity, Ref.ObjectRef objectRef, MobileDevice mobileDevice) {
        DeviceFlowContainerBottomSheet deviceFlowContainerBottomSheet;
        Intrinsics.checkNotNullParameter(mobileDevice, "newDevice");
        NewFeaturePromptConnectionAction actionFor = NewFeaturePromptConnectionPolicy.INSTANCE.actionFor(mobileDevice.getProductType());
        int i = WhenMappings.$EnumSwitchMapping$0[actionFor.getDestinationMode().ordinal()];
        if (i == 1) {
            conversationActivity.switchToWorkMode();
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            conversationActivity.switchToCodeMode();
        }
        conversationActivity.autoSelectConnectedDevice(mobileDevice, actionFor);
        if (actionFor.getOpenDeviceSelection()) {
            conversationActivity.showCliSelectionDialog();
        }
        DeviceFlowContainerBottomSheet deviceFlowContainerBottomSheet2 = conversationActivity.newFeaturePromptSheet;
        if (objectRef.element == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sheet");
            deviceFlowContainerBottomSheet = null;
        } else {
            deviceFlowContainerBottomSheet = (DeviceFlowContainerBottomSheet) objectRef.element;
        }
        if (Intrinsics.areEqual(deviceFlowContainerBottomSheet2, deviceFlowContainerBottomSheet)) {
            conversationActivity.newFeaturePromptSheet = null;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showNewFeaturePrompt$lambda$92(ConversationActivity conversationActivity, Ref.ObjectRef objectRef) {
        DeviceFlowContainerBottomSheet deviceFlowContainerBottomSheet;
        DeviceFlowContainerBottomSheet deviceFlowContainerBottomSheet2 = conversationActivity.newFeaturePromptSheet;
        if (objectRef.element == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sheet");
            deviceFlowContainerBottomSheet = null;
        } else {
            deviceFlowContainerBottomSheet = (DeviceFlowContainerBottomSheet) objectRef.element;
        }
        if (Intrinsics.areEqual(deviceFlowContainerBottomSheet2, deviceFlowContainerBottomSheet)) {
            conversationActivity.newFeaturePromptSheet = null;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showNewFeaturePrompt$lambda$94(ConversationActivity conversationActivity, Ref.ObjectRef objectRef) {
        DeviceFlowContainerBottomSheet deviceFlowContainerBottomSheet;
        DeviceFlowContainerBottomSheet deviceFlowContainerBottomSheet2 = conversationActivity.newFeaturePromptSheet;
        if (objectRef.element == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sheet");
            deviceFlowContainerBottomSheet = null;
        } else {
            deviceFlowContainerBottomSheet = (DeviceFlowContainerBottomSheet) objectRef.element;
        }
        if (Intrinsics.areEqual(deviceFlowContainerBottomSheet2, deviceFlowContainerBottomSheet)) {
            conversationActivity.newFeaturePromptSheet = null;
        }
        return Unit.INSTANCE;
    }

    private final boolean isCommittedNewFeaturePrompt(DeviceFlowContainerBottomSheet sheet) {
        return sheet.isAdded() && getSupportFragmentManager().findFragmentByTag(DeviceFlowContainerBottomSheet.TAG) == sheet;
    }

    private final void recordNewFeaturePromptShown(String userId, PreparedNewFeaturePrompt prepared) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            ConversationActivity conversationActivity = this;
            NewFeaturePromptStore.markShown$default(NewFeaturePromptStore.INSTANCE, userId, prepared.getProductType(), prepared.getConfig(), 0L, 8, null);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            TraeLogUtil.INSTANCE.w(TAG, "persist new feature prompt state failed", th2);
        }
    }

    private final boolean isManagedPromptHostReady() {
        return !isFinishing() && !isDestroyed() && getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) && !getSupportFragmentManager().isStateSaved() && getSupportFragmentManager().findFragmentByTag(BillingUpgradePromptBottomSheet.TAG) == null && getSupportFragmentManager().findFragmentByTag(DeviceFlowContainerBottomSheet.TAG) == null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String currentLoggedInUserId() {
        Object obj;
        ILoginService iLoginService;
        String str;
        AccountInfo accountInfo;
        try {
            Result.Companion companion = Result.Companion;
            ConversationActivity conversationActivity = this;
            iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (iLoginService != null && (accountInfo = iLoginService.getAccountInfo()) != null) {
            if (!accountInfo.isLogin()) {
                accountInfo = null;
            }
            if (accountInfo != null && (str = accountInfo.getUserId()) != null && (!StringsKt.isBlank(str))) {
                obj = Result.constructor-impl(str);
                return (String) (Result.isFailure-impl(obj) ? null : obj);
            }
        }
        str = null;
        obj = Result.constructor-impl(str);
        return (String) (Result.isFailure-impl(obj) ? null : obj);
    }

    private final boolean shouldDelayManagedPromptsForPendingConnect() {
        return this.pendingConnectDeviceType != null || this.pendingConnectDeviceFlowActive;
    }

    private final void executePendingConnectDevice() {
        DeviceProductType deviceProductType = this.pendingConnectDeviceType;
        if (deviceProductType == null || isFinishing() || isDestroyed() || getSupportFragmentManager().isStateSaved() || getSupportFragmentManager().findFragmentByTag(BillingUpgradePromptBottomSheet.TAG) != null || getSupportFragmentManager().findFragmentByTag(DeviceFlowContainerBottomSheet.TAG) != null) {
            return;
        }
        this.pendingConnectDeviceType = null;
        this.pendingConnectDeviceFlowActive = true;
        DeviceFlowContainerBottomSheet.Companion companion = DeviceFlowContainerBottomSheet.INSTANCE;
        Set<String> set = DeviceFlowExistingDeviceIdsKt.mobileDeviceIdsByProduct(CliListRepository.INSTANCE.getInstance().getCachedDevices()).get(deviceProductType);
        if (set == null) {
            set = SetsKt.emptySet();
        }
        Fragment newInstance = companion.newInstance(new DeviceFlowRequest(new DeviceFlowRoute.ConnectGuide(new BindingTarget(deviceProductType, set, "site_message", null, null, null, 56, null)), new DeviceFlowCallbacks(null, null, null, null, null, new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda27
            public final Object invoke() {
                Unit executePendingConnectDevice$lambda$100;
                executePendingConnectDevice$lambda$100 = ConversationActivity.executePendingConnectDevice$lambda$100(ConversationActivity.this);
                return executePendingConnectDevice$lambda$100;
            }
        }, 31, null)));
        try {
            newInstance.showNow(getSupportFragmentManager(), DeviceFlowContainerBottomSheet.TAG);
            if (getSupportFragmentManager().findFragmentByTag(DeviceFlowContainerBottomSheet.TAG) != newInstance) {
                this.pendingConnectDeviceFlowActive = false;
                this.pendingConnectDeviceType = deviceProductType;
            }
        } catch (IllegalStateException e) {
            this.pendingConnectDeviceFlowActive = false;
            this.pendingConnectDeviceType = deviceProductType;
            TraeLogUtil.INSTANCE.w(TAG, "show pending connect device flow failed", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit executePendingConnectDevice$lambda$100(ConversationActivity conversationActivity) {
        conversationActivity.pendingConnectDeviceFlowActive = false;
        return Unit.INSTANCE;
    }

    /* renamed from: com_bytedance_trae_conversation_ConversationActivity__onStop$___twin___ */
    public void m812xa5f06138() {
        super.onStop();
        this.hasEnteredBackground = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onDestroy() {
        hideLoading();
        unregisterCheckpointKeyboardListener();
        CheckpointDialogManager.INSTANCE.release();
        ActiveConversationTracker.INSTANCE.setActiveConversationId((String) null);
        IMService.INSTANCE.removeConversationChangeListener(this.conversationChangeListener);
        MessageManager.INSTANCE.removeDeleteMessageListener(this.deleteMessageListener);
        MessageManager.INSTANCE.removeDeleteConversationListener(this.deleteConversationListener);
        MessageManager.INSTANCE.removeRevertMessageListener(this.revertMessageListener);
        IMService.INSTANCE.removeCliStatusChangeListener(this.cliStatusChangeListener);
        DeviceFlowContainerBottomSheet deviceFlowContainerBottomSheet = this.newFeaturePromptSheet;
        if (deviceFlowContainerBottomSheet != null) {
            deviceFlowContainerBottomSheet.dismissAllowingStateLoss();
        }
        this.newFeaturePromptSheet = null;
        IMService.INSTANCE.removeRemoteDeleteMessagePushListener(this.remoteDeleteMessagePushListener);
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        String stringExtra = intent.getStringExtra("conversation_id");
        String str = stringExtra;
        if (!(str == null || str.length() == 0)) {
            handlePushNewIntent(stringExtra, intent);
            return;
        }
        Uri data = intent.getData();
        if (data == null) {
            return;
        }
        if (Intrinsics.areEqual(data.getHost(), "oauth")) {
            String path = data.getPath();
            if (path != null && StringsKt.startsWith$default(path, "/plugin-connector/callback", false, 2, (Object) null)) {
                PluginConnectorOAuthManager.INSTANCE.handleCallback(data);
                return;
            }
        }
        if (Intrinsics.areEqual(data.getHost(), "github-connector-callback")) {
            String queryParameter = data.getQueryParameter("error");
            String str2 = queryParameter;
            if (!(str2 == null || StringsKt.isBlank(str2))) {
                Toast.makeText((Context) this, getString(com.bytedance.trae.multilanguage.R.string.trae_github_error_oauth_authorized_failed, new Object[]{queryParameter}), 0).show();
            } else {
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$onNewIntent$1(this, data, null), 3, (Object) null);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handlePushNewIntent(String pushConversationId, Intent newIntent) {
        ConversationViewModel conversationViewModel = this.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        if (Intrinsics.areEqual(pushConversationId, (String) conversationViewModel.getConversationId().getValue())) {
            return;
        }
        finish();
        Intent intent = new Intent((Context) this, (Class<?>) ConversationActivity.class);
        intent.putExtras(newIntent);
        intent.putExtra(EXTRA_CONVERSATION_ID, pushConversationId);
        startActivity(intent);
    }

    public final void submitMessages(List<ParsedChatMessage> messages) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        ConversationDetailFragment detailFragment = getDetailFragment();
        if (detailFragment != null) {
            ConversationDetailFragment.submitMessages$default(detailFragment, messages, false, null, 6, null);
        }
    }

    private final String findUserMessageId(String agentMessageId) {
        int i;
        Object obj;
        ConversationViewModel conversationViewModel = this.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        List list = (List) conversationViewModel.getMessages().getValue();
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                i = -1;
                break;
            }
            if (Intrinsics.areEqual(((ParsedChatMessage) listIterator.previous()).getMessageId(), agentMessageId)) {
                i = listIterator.nextIndex();
                break;
            }
        }
        if (i <= 0) {
            return "";
        }
        List subList = list.subList(0, i);
        ListIterator listIterator2 = subList.listIterator(subList.size());
        while (true) {
            if (!listIterator2.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator2.previous();
            if (Intrinsics.areEqual(((ParsedChatMessage) obj).getRole(), ParsedChatMessage.ROLE_USER)) {
                break;
            }
        }
        ParsedChatMessage parsedChatMessage = (ParsedChatMessage) obj;
        String messageId = parsedChatMessage != null ? parsedChatMessage.getMessageId() : null;
        return messageId == null ? "" : messageId;
    }

    private final void trackFeedback(String agentMessageId, String resultType) {
        ConversationViewModel conversationViewModel = this.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        String str = (String) conversationViewModel.getConversationId().getValue();
        String str2 = str == null ? "" : str;
        String findUserMessageId = findUserMessageId(agentMessageId);
        SoloChatMode resolveCurrentChatMode$default = resolveCurrentChatMode$default(this, null, 1, null);
        TraeAITracker traeAITracker = TraeAITracker.INSTANCE;
        String str3 = this.streamingChatModel;
        traeAITracker.trackFeedbackClick(new AIEventContext(null, str2, findUserMessageId, str3 == null ? "" : str3, 1, null), resultType, agentMessageId, findUserMessageId, resolveCurrentChatMode$default);
    }

    private final void trackCopy(String agentMessageId) {
        ConversationViewModel conversationViewModel = this.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        String str = (String) conversationViewModel.getConversationId().getValue();
        if (str == null) {
            str = "";
        }
        TraeAITracker.trackCopyClick$default(TraeAITracker.INSTANCE, new AIEventContext(null, str, agentMessageId, null, 9, null), null, resolveCurrentChatMode$default(this, null, 1, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ SoloChatMode resolveCurrentChatMode$default(ConversationActivity conversationActivity, Mode mode, int i, Object obj) {
        if ((i & 1) != 0) {
            mode = null;
        }
        return conversationActivity.resolveCurrentChatMode(mode);
    }

    private final SoloChatMode resolveCurrentChatMode(Mode fallbackMode) {
        ConversationViewModel conversationViewModel = this.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        Conversation conversation = (Conversation) conversationViewModel.getConversation().getValue();
        String mode = conversation != null ? conversation.getMode() : null;
        if (mode != null) {
            return Intrinsics.areEqual(mode, "work") ? SoloChatMode.WORK : Intrinsics.areEqual(mode, "code") ? SoloChatMode.CODE : SoloChatMode.DEFAULT;
        }
        int i = fallbackMode == null ? -1 : WhenMappings.$EnumSwitchMapping$2[fallbackMode.ordinal()];
        if (i == 1) {
            return SoloChatMode.WORK;
        }
        if (i == 2) {
            return SoloChatMode.CODE;
        }
        return SoloChatMode.DEFAULT;
    }

    static /* synthetic */ AISendMessageContext buildSendMessageContext$default(ConversationActivity conversationActivity, Mode mode, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return conversationActivity.buildSendMessageContext(mode, i);
    }

    private final AISendMessageContext buildSendMessageContext(Mode mode, int pluginCount) {
        AISendMessageContext aISendMessageContext = new AISendMessageContext(null, false, null, null, false, false, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 134217727, null);
        ConversationViewModel conversationViewModel = this.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        SelectedDeviceItem selectedDeviceItem = (SelectedDeviceItem) conversationViewModel.getSelectedDevice().getValue();
        CliType type = selectedDeviceItem != null ? selectedDeviceItem.getType() : null;
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$3[type.ordinal()];
        aISendMessageContext.setEnvDeployment(i != 1 ? i != 2 ? i != 3 ? "" : "local_ide" : "cloud" : "local");
        boolean z = getGitSelectionViewModel().getSelectedRepo().getValue() != null;
        aISendMessageContext.setHasGit(z);
        if (z) {
            aISendMessageContext.setGitType(ThirdPartyTokenRepository.TYPE_GITHUB);
        }
        aISendMessageContext.setAsrCount(getInputFragment().consumeAsrCount());
        aISendMessageContext.setPluginCount(pluginCount);
        return aISendMessageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void flushPendingTriggerTracker(String sessionId, String messageId) {
        PendingTriggerTracker pendingTriggerTracker = this.pendingTriggerTracker;
        if (pendingTriggerTracker == null) {
            return;
        }
        this.pendingTriggerTracker = null;
        TraeAITracker.trackTrigger$default(TraeAITracker.INSTANCE, AIEventContext.copy$default(pendingTriggerTracker.getEventContext(), null, sessionId == null ? "" : sessionId, messageId == null ? "" : messageId, null, 9, null), pendingTriggerTracker.getSendContext(), pendingTriggerTracker.getChatMode(), null, 8, null);
    }

    private final void submitReport(String messageId, String content) {
        ConversationViewModel conversationViewModel = this.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        String str = (String) conversationViewModel.getConversationId().getValue();
        if (str == null) {
            str = "";
        }
        String str2 = str;
        if (str2.length() == 0) {
            return;
        }
        TraeAITracker.trackReportClick$default(TraeAITracker.INSTANCE, null, 1, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$submitReport$1(this, str2, messageId, content, null), 3, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void requestBrainstormPermissions() {
        this.brainstormMicCheckStartMs = System.currentTimeMillis();
        BrainstormPermissionHelper.INSTANCE.requestPermissions((Context) this, this.brainstormPermissionLauncher, new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda28
            public final Object invoke() {
                Unit requestBrainstormPermissions$lambda$104;
                requestBrainstormPermissions$lambda$104 = ConversationActivity.requestBrainstormPermissions$lambda$104(ConversationActivity.this);
                return requestBrainstormPermissions$lambda$104;
            }
        }, new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda29
            public final Object invoke() {
                Unit requestBrainstormPermissions$lambda$105;
                requestBrainstormPermissions$lambda$105 = ConversationActivity.requestBrainstormPermissions$lambda$105(ConversationActivity.this);
                return requestBrainstormPermissions$lambda$105;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestBrainstormPermissions$lambda$104(ConversationActivity conversationActivity) {
        conversationActivity.brainstormMicCheckEndMs = System.currentTimeMillis();
        conversationActivity.launchBrainstormActivity();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestBrainstormPermissions$lambda$105(ConversationActivity conversationActivity) {
        conversationActivity.brainstormMicCheckEndMs = System.currentTimeMillis();
        VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker = conversationActivity.voiceDiscussionAttemptTracker;
        if (voiceDiscussionAttemptTracker != null) {
            voiceDiscussionAttemptTracker.finish(VoiceDiscussionAttemptOutcome.PERMISSION_DENIED, "permission_rationale_denied");
        }
        return Unit.INSTANCE;
    }

    private final VoiceDiscussionAttemptTracker createVoiceDiscussionAttempt() {
        CliType cliType;
        ConversationViewModel conversationViewModel = this.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        SelectedDeviceItem selectedDeviceItem = (SelectedDeviceItem) conversationViewModel.getSelectedDevice().getValue();
        if (selectedDeviceItem == null || (cliType = selectedDeviceItem.getType()) == null) {
            cliType = CliType.LOCAL;
        }
        CliType cliType2 = cliType;
        Mode resolveTaskModeForCurrentConversation = resolveTaskModeForCurrentConversation();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ConversationViewModel conversationViewModel2 = this.viewModel;
        if (conversationViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel2 = null;
        }
        Conversation conversation = (Conversation) conversationViewModel2.getConversation().getValue();
        String cliConversationId = conversation != null ? conversation.getCliConversationId() : null;
        if (cliConversationId == null) {
            cliConversationId = "";
        }
        String str = cliConversationId;
        ConversationViewModel conversationViewModel3 = this.viewModel;
        if (conversationViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel3 = null;
        }
        Conversation conversation2 = (Conversation) conversationViewModel3.getConversation().getValue();
        String cliConversationId2 = conversation2 != null ? conversation2.getCliConversationId() : null;
        VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker = new VoiceDiscussionAttemptTracker(new VoiceDiscussionAttemptState(uuid, elapsedRealtime, new VoiceDiscussionAttemptContext(cliType2, resolveTaskModeForCurrentConversation, str, null, cliConversationId2 == null || StringsKt.isBlank(cliConversationId2), BrainstormActivity.INSTANCE.hasSeenIntro$conversation_mainlandRelease(), 8, null), null, null, null, null, null, 0, false, BaseApiResponse.API_USER_PASSWORD_LOGIN, null), null, null, null, 14, null);
        voiceDiscussionAttemptTracker.recordStage(VoiceDiscussionAttemptStage.CLICK);
        return voiceDiscussionAttemptTracker;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void launchBrainstormActivity() {
        String str;
        CliType cliType;
        String str2;
        String str3;
        String str4;
        VoiceDiscussionAttemptState snapshot;
        String name;
        String repoUrl;
        VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker = this.voiceDiscussionAttemptTracker;
        ConversationViewModel conversationViewModel = this.viewModel;
        if (conversationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        }
        Conversation conversation = (Conversation) conversationViewModel.getConversation().getValue();
        String cliConversationId = conversation != null ? conversation.getCliConversationId() : null;
        ConversationViewModel conversationViewModel2 = this.viewModel;
        if (conversationViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel2 = null;
        }
        String str5 = (String) conversationViewModel2.getConversationId().getValue();
        if (str5 == null) {
            ConversationViewModel conversationViewModel3 = this.viewModel;
            if (conversationViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                conversationViewModel3 = null;
            }
            Conversation conversation2 = (Conversation) conversationViewModel3.getConversation().getValue();
            str5 = conversation2 != null ? conversation2.getId() : null;
        }
        ConversationViewModel conversationViewModel4 = this.viewModel;
        if (conversationViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel4 = null;
        }
        SelectedDeviceItem selectedDeviceItem = (SelectedDeviceItem) conversationViewModel4.getSelectedDevice().getValue();
        if (selectedDeviceItem == null || (str = selectedDeviceItem.getId()) == null || !(!StringsKt.isBlank(str))) {
            str = null;
        }
        if (selectedDeviceItem == null || (cliType = selectedDeviceItem.getType()) == null) {
            cliType = CliType.LOCAL;
        }
        Mode resolveTaskModeForCurrentConversation = resolveTaskModeForCurrentConversation();
        if (selectedDeviceItem == null || (str2 = selectedDeviceItem.getSelectedDirectory()) == null || !(!StringsKt.isBlank(str2))) {
            str2 = null;
        }
        ConversationViewModel conversationViewModel5 = this.viewModel;
        if (conversationViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel5 = null;
        }
        String resolveParentAgentTypeForSubTask = conversationViewModel5.resolveParentAgentTypeForSubTask(resolveTaskModeForCurrentConversation, cliType);
        boolean isAttachmentSubTaskEnabled = VoiceDiscussionPhase2Policy.INSTANCE.isAttachmentSubTaskEnabled();
        boolean z = isAttachmentSubTaskEnabled && this.isNewConversation && cliType == CliType.REMOTE;
        GitRepoItem gitRepoItem = (GitRepoItem) getGitSelectionViewModel().getSelectedRepo().getValue();
        String str6 = (gitRepoItem == null || (repoUrl = gitRepoItem.getRepoUrl()) == null || !(StringsKt.isBlank(repoUrl) ^ true)) ? null : repoUrl;
        BranchItem branchItem = (BranchItem) getGitSelectionViewModel().getSelectedBranch().getValue();
        String str7 = (branchItem == null || (name = branchItem.getName()) == null || !(StringsKt.isBlank(name) ^ true)) ? null : name;
        if (!canStartBrainstormForDevice(selectedDeviceItem)) {
            if (voiceDiscussionAttemptTracker != null) {
                voiceDiscussionAttemptTracker.finish(VoiceDiscussionAttemptOutcome.BLOCKED_IDE_VERSION, "desktop_ide_version_below_minimum");
                return;
            }
            return;
        }
        if (z && resolveTaskModeForCurrentConversation == Mode.CODE && str6 != null && str7 == null) {
            Toast.makeText((Context) this, com.bytedance.trae.multilanguage.R.string.trae_git_please_select_branch, 0).show();
            if (voiceDiscussionAttemptTracker != null) {
                voiceDiscussionAttemptTracker.finish(VoiceDiscussionAttemptOutcome.PREREQUISITE_FAILED, "remote_code_branch_not_selected");
                return;
            }
            return;
        }
        this.iLaunchedActiveBrainstorm = true;
        if (voiceDiscussionAttemptTracker != null) {
            voiceDiscussionAttemptTracker.recordStage(VoiceDiscussionAttemptStage.ACTIVITY_LAUNCH_REQUESTED);
        }
        ActivityResultLauncher<Intent> activityResultLauncher = this.brainstormResultLauncher;
        Intent intent = new Intent((Context) this, (Class<?>) BrainstormActivity.class);
        if (voiceDiscussionAttemptTracker == null || (snapshot = voiceDiscussionAttemptTracker.snapshot()) == null) {
            str3 = "viewModel";
            str4 = str6;
        } else {
            intent.putExtra(BrainstormActivity.EXTRA_ATTEMPT_ID, snapshot.getAttemptId());
            str3 = "viewModel";
            str4 = str6;
            intent.putExtra(BrainstormActivity.EXTRA_ATTEMPT_START_ELAPSED_MS, snapshot.getStartedAtElapsedMs());
            Long l = snapshot.getStageElapsedMs().get(VoiceDiscussionAttemptStage.CLICK.getValue());
            intent.putExtra(BrainstormActivity.EXTRA_ATTEMPT_CLICK_MS, l != null ? l.longValue() : -1L);
            Long l2 = snapshot.getStageElapsedMs().get(VoiceDiscussionAttemptStage.ELIGIBILITY_PASSED.getValue());
            intent.putExtra(BrainstormActivity.EXTRA_ATTEMPT_ELIGIBILITY_PASSED_MS, l2 != null ? l2.longValue() : -1L);
            Long l3 = snapshot.getStageElapsedMs().get(VoiceDiscussionAttemptStage.ACTIVITY_LAUNCH_REQUESTED.getValue());
            intent.putExtra(BrainstormActivity.EXTRA_ATTEMPT_ACTIVITY_LAUNCH_REQUESTED_MS, l3 != null ? l3.longValue() : -1L);
        }
        String str8 = cliConversationId;
        if (!(str8 == null || StringsKt.isBlank(str8))) {
            intent.putExtra(BrainstormActivity.EXTRA_CLI_CONVERSATION_ID, cliConversationId);
        }
        String str9 = str5;
        if (!(str9 == null || StringsKt.isBlank(str9))) {
            intent.putExtra(BrainstormActivity.EXTRA_PARENT_CONVERSATION_ID, str5);
        }
        intent.putExtra(BrainstormActivity.EXTRA_MIC_CHECK_START_MS, this.brainstormMicCheckStartMs);
        intent.putExtra(BrainstormActivity.EXTRA_MIC_CHECK_END_MS, this.brainstormMicCheckEndMs);
        if (str != null) {
            intent.putExtra(BrainstormActivity.EXTRA_CLI_ID, str);
        }
        intent.putExtra(BrainstormActivity.EXTRA_CLI_TYPE, cliType.name());
        intent.putExtra(BrainstormActivity.EXTRA_MODE, resolveTaskModeForCurrentConversation.getValue());
        intent.putExtra(BrainstormActivity.EXTRA_PARENT_AGENT_TYPE, resolveParentAgentTypeForSubTask);
        if (str2 != null) {
            intent.putExtra(BrainstormActivity.EXTRA_WORKSPACE_DIR, str2);
        }
        if (z && resolveTaskModeForCurrentConversation == Mode.CODE && str4 != null && str7 != null) {
            String str10 = str4;
            intent.putExtra(BrainstormActivity.EXTRA_SOURCE_REPO_URL, str10);
            ConversationViewModel conversationViewModel6 = this.viewModel;
            if (conversationViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str3);
                conversationViewModel6 = null;
            }
            String parseGitDisplayName = conversationViewModel6.parseGitDisplayName(str10);
            if (parseGitDisplayName != null) {
                intent.putExtra(BrainstormActivity.EXTRA_SOURCE_REPO_NAME, parseGitDisplayName);
            }
            intent.putExtra(BrainstormActivity.EXTRA_SOURCE_BRANCH_NAME, str7);
        }
        intent.putExtra(BrainstormActivity.EXTRA_CREATE_REMOTE_PARENT_SESSION, z);
        intent.putExtra(BrainstormActivity.EXTRA_ATTACHMENT_SUBTASK_ENABLED, isAttachmentSubTaskEnabled);
        intent.putExtra(BrainstormActivity.EXTRA_MINIMIZE_DISABLED, this.isNewConversation);
        activityResultLauncher.launch(intent);
        this.voiceDiscussionAttemptTracker = null;
    }

    private final Mode resolveTaskModeForCurrentConversation() {
        Object obj = null;
        TraeActivityConversationBinding traeActivityConversationBinding = null;
        if (this.isNewConversation) {
            TraeActivityConversationBinding traeActivityConversationBinding2 = this.binding;
            if (traeActivityConversationBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                traeActivityConversationBinding = traeActivityConversationBinding2;
            }
            return traeActivityConversationBinding.titleBar.getSegmentedSelectedIndex() == 0 ? Mode.WORK : Mode.CODE;
        }
        Iterator it = Mode.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String value = ((Mode) next).getValue();
            ConversationViewModel conversationViewModel = this.viewModel;
            if (conversationViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                conversationViewModel = null;
            }
            Conversation conversation = (Conversation) conversationViewModel.getConversation().getValue();
            if (Intrinsics.areEqual(value, conversation != null ? conversation.getMode() : null)) {
                obj = next;
                break;
            }
        }
        Mode mode = (Mode) obj;
        return mode == null ? Mode.WORK : mode;
    }

    private final void observeMinimizedVoice() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeMinimizedVoice$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyMinimizedVoiceVisibility() {
        boolean z = BrainstormSessionHolder.INSTANCE.isMinimized() && this.iLaunchedActiveBrainstorm;
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(InputFragment.TAG);
        InputFragment inputFragment = findFragmentByTag instanceof InputFragment ? (InputFragment) findFragmentByTag : null;
        if (inputFragment != null) {
            inputFragment.setOnMaximizeBrainstormClick(new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda12
                public final Object invoke() {
                    Unit applyMinimizedVoiceVisibility$lambda$115;
                    applyMinimizedVoiceVisibility$lambda$115 = ConversationActivity.applyMinimizedVoiceVisibility$lambda$115(ConversationActivity.this);
                    return applyMinimizedVoiceVisibility$lambda$115;
                }
            });
        }
        if (inputFragment != null) {
            inputFragment.setMinimizedVoiceMode(z);
        }
        setEnabled(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyMinimizedVoiceVisibility$lambda$115(ConversationActivity conversationActivity) {
        conversationActivity.maximizeBrainstorm();
        return Unit.INSTANCE;
    }

    private final void observeBrainstormEnded() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$observeBrainstormEnded$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showEndVoiceDiscussionDialog() {
        String string = getString(C0637R.string.trae_brainstorm_switch_session_confirm_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(C0637R.string.trae_brainstorm_switch_session_confirm_message);
        String string3 = getString(C0637R.string.trae_brainstorm_switch_session_exit);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = getString(C0637R.string.trae_brainstorm_switch_session_continue);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        new CustomConfirmDialog((Context) this, new CustomConfirmDialog.Config(string, string2, null, null, string4, string3, null, 0.0f, null, null, null, null, 0, 0, 0, null, null, null, false, new Function1() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda22
            public final Object invoke(Object obj) {
                Unit showEndVoiceDiscussionDialog$lambda$116;
                showEndVoiceDiscussionDialog$lambda$116 = ConversationActivity.showEndVoiceDiscussionDialog$lambda$116(ConversationActivity.this, (String) obj);
                return showEndVoiceDiscussionDialog$lambda$116;
            }
        }, null, 1572812, null)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showEndVoiceDiscussionDialog$lambda$116(ConversationActivity conversationActivity, String str) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) conversationActivity), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$showEndVoiceDiscussionDialog$1$1(null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void maximizeBrainstorm() {
        BrainstormSessionHolder.INSTANCE.reportWindowStateClick(VoiceDiscussionMetrics.WINDOW_ACTION_RESTORE, VoiceDiscussionMetrics.WINDOW_STATE_MINIMIZED);
        boolean z = true;
        this.iLaunchedActiveBrainstorm = true;
        String cliConversationId = BrainstormSessionHolder.INSTANCE.getCliConversationId();
        ActivityResultLauncher<Intent> activityResultLauncher = this.brainstormResultLauncher;
        Intent intent = new Intent((Context) this, (Class<?>) BrainstormActivity.class);
        intent.putExtra(BrainstormActivity.EXTRA_RESTORE_FROM_HOLDER, true);
        String str = cliConversationId;
        if (str != null && !StringsKt.isBlank(str)) {
            z = false;
        }
        if (!z) {
            intent.putExtra(BrainstormActivity.EXTRA_CLI_CONVERSATION_ID, cliConversationId);
        }
        activityResultLauncher.launch(intent);
    }

    private final void handleStartServerIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(EXTRA_START_SERVER_URL);
        String str = stringExtra;
        if (str == null || str.length() == 0) {
            return;
        }
        intent.removeExtra(EXTRA_START_SERVER_URL);
        final String string = getString(com.bytedance.trae.multilanguage.R.string.trae_doc_preview_start_server_message, new Object[]{stringExtra});
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        AiDataNoticeHelper.INSTANCE.showIfNeeded((ComponentActivity) this, new Function0() { // from class: com.bytedance.trae.conversation.ConversationActivity$$ExternalSyntheticLambda33
            public final Object invoke() {
                Unit handleStartServerIntent$lambda$120;
                handleStartServerIntent$lambda$120 = ConversationActivity.handleStartServerIntent$lambda$120(ConversationActivity.this, string);
                return handleStartServerIntent$lambda$120;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object] */
    public static final Unit handleStartServerIntent$lambda$120(ConversationActivity conversationActivity, String str) {
        Mode mode;
        Mode mode2;
        ConversationViewModel conversationViewModel;
        if (conversationActivity.isNewConversation) {
            TraeActivityConversationBinding traeActivityConversationBinding = conversationActivity.binding;
            if (traeActivityConversationBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                traeActivityConversationBinding = null;
            }
            mode2 = traeActivityConversationBinding.titleBar.getSegmentedSelectedIndex() == 0 ? Mode.WORK : Mode.CODE;
        } else {
            Iterator it = Mode.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    mode = 0;
                    break;
                }
                mode = it.next();
                String value = ((Mode) mode).getValue();
                ConversationViewModel conversationViewModel2 = conversationActivity.viewModel;
                if (conversationViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    conversationViewModel2 = null;
                }
                Conversation conversation = (Conversation) conversationViewModel2.getConversation().getValue();
                if (Intrinsics.areEqual(value, conversation != null ? conversation.getMode() : null)) {
                    break;
                }
            }
            mode2 = mode;
            if (mode2 == null) {
                mode2 = Mode.WORK;
            }
        }
        Mode mode3 = mode2;
        Gson gson = new Gson();
        List createListBuilder = CollectionsKt.createListBuilder();
        createListBuilder.add(QueryItem.INSTANCE.text(str));
        String json = gson.toJson(CollectionsKt.build(createListBuilder));
        RemoteModelItem selectedModelForRequest = conversationActivity.getInputFragment().getSelectedModelForRequest();
        String name = selectedModelForRequest != null ? selectedModelForRequest.getName() : null;
        AISendMessageContext buildSendMessageContext$default = buildSendMessageContext$default(conversationActivity, mode3, 0, 2, null);
        conversationActivity.lastSendContext = buildSendMessageContext$default;
        conversationActivity.hasReportedStreamShow = false;
        conversationActivity.wasUserInitiatedCancel = false;
        conversationActivity.streamingStartTimeMs = SystemClock.elapsedRealtime();
        conversationActivity.streamingMessageId = null;
        conversationActivity.streamingChatModel = null;
        ConversationViewModel conversationViewModel3 = conversationActivity.viewModel;
        if (conversationViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel3 = null;
        }
        String str2 = (String) conversationViewModel3.getConversationId().getValue();
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str2;
        if (name == null) {
            name = ModelSelectionConstants.AUTO;
        }
        conversationActivity.pendingTriggerTracker = new PendingTriggerTracker(new AIEventContext(null, str3, null, name, 5, null), buildSendMessageContext$default, conversationActivity.resolveCurrentChatMode(mode3));
        ConversationViewModel conversationViewModel4 = conversationActivity.viewModel;
        if (conversationViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            conversationViewModel = null;
        } else {
            conversationViewModel = conversationViewModel4;
        }
        Intrinsics.checkNotNull(json);
        ConversationViewModel.sendMessage$default(conversationViewModel, str, json, mode3, selectedModelForRequest, false, 16, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void performForceLogout() {
        Toast.makeText((Context) this, com.bytedance.trae.multilanguage.R.string.login_error_refresh_token_expired, 1).show();
        DatabaseManager.INSTANCE.onUserLogout();
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (iLoginService == null) {
            return;
        }
        iLoginService.logout(true, new IAccountCallback() { // from class: com.bytedance.trae.conversation.ConversationActivity$performForceLogout$1
            public void onDeviceOverLimit(String token, Map<String, ? extends Object> extras) {
            }

            public void onFailed(LoginPlatform platform, int errorCode, String errorMessage, String businessScene, Throwable throwable, String profileKey, Integer originErrorCode, String originErrorMessage, Map<String, Object> ext) {
            }

            public void onSuccess(LoginPlatform platform, String businessScene, Boolean isNewUserLogin) {
            }
        }, "risk_control");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_conversation_ConversationActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m811xbeb733c3(ConversationActivity conversationActivity) {
        conversationActivity.m812xa5f06138();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) conversationActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
