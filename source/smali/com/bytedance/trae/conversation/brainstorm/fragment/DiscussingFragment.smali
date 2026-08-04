# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
.super Landroidx/fragment/app/Fragment;
.source "DiscussingFragment.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$Companion;
.field private static final IN_FLIGHT_SUB_TASK_STATES:Ljava/util/Set;
.field private static final SUBTITLE_MODE_EXIT_HOLD_MS:J
.field private static final TAG:Ljava/lang/String;
.field private static final TERMINAL_BOTTOM_SUB_TASK_STATES:Ljava/util/Set;
.field private aiDisplaySwitcher:Landroid/widget/FrameLayout;
.field private aiSubtitleContainer:Landroid/widget/FrameLayout;
.field private final bottomActionButtonRect:Landroid/graphics/Rect;
.field private final bottomActionShadowTargets:Ljava/util/List;
.field private bottomBar:Landroid/view/ViewGroup;
.field private bottomStatusCopyArea:Landroid/view/View;
.field private bottomStatusText:Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
.field private bottomTaskDoneClearRunnable:Ljava/lang/Runnable;
.field private bottomTaskDoneTaskId:Ljava/lang/String;
.field private bottomTaskDoneUntilMs:J
.field private btnAttach:Landroid/widget/Button;
.field private btnConfirm:Landroid/widget/Button;
.field private btnMic:Landroid/widget/Button;
.field private btnScrollToBottom:Landroid/widget/ImageView;
.field private final cameraPermissionLauncher:Landroidx/activity/result/ActivityResultLauncher;
.field private chatModeContainer:Landroid/view/View;
.field private curAiDisplayMode:Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
.field private curBottomStatus:Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
.field private curIsMicMuted:Z
.field private curIsSubtitleMode:Z
.field private curSphereState:Ljava/lang/String;
.field private curTimeoutState:Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
.field private curTimerSeconds:I
.field private final displaySwitchDelayMs:J
.field private final displaySwitchHandler:Landroid/os/Handler;
.field private enterMediaPlayer:Landroid/media/MediaPlayer;
.field private final filePickerLauncher:Landroidx/activity/result/ActivityResultLauncher;
.field private footerContainer:Landroidx/constraintlayout/widget/ConstraintLayout;
.field private hasEverBeenActive:Z
.field private final historySubtitleAdapter:Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;
.field private isDragging:Z
.field private isUserScrolling:Z
.field private isWaitingAnswerFinish:Z
.field private final lastSubTaskRouteLogs:Ljava/util/Map;
.field private lastSubtitleRenderSnapshot:Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;
.field private mainWaveform:Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
.field private final mediaChooseLauncher:Landroidx/activity/result/ActivityResultLauncher;
.field private final micPermissionLauncher:Landroidx/activity/result/ActivityResultLauncher;
.field private pendingCameraUri:Landroid/net/Uri;
.field private pendingDisplaySwitch:Ljava/lang/Runnable;
.field private rvAiSubtitle:Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;
.field private rvHistorySubtitle:Landroidx/recyclerview/widget/RecyclerView;
.field private final seenBottomTerminalTaskIds:Ljava/util/Set;
.field private sphereController:Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;
.field private subtitleEmptyHint:Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
.field private subtitleModeContainer:Landroid/view/View;
.field private subtitleModeHideRunnable:Ljava/lang/Runnable;
.field private subtitleTopGradient:Landroid/view/View;
.field private final takePictureLauncher:Landroidx/activity/result/ActivityResultLauncher;
.field private final taskDoneHoldMs:J
.field private final taskRunningLongDelayMs:J
.field private taskRunningLongRunnable:Ljava/lang/Runnable;
.field private taskRunningSinceMs:J
.field private topBar:Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;
.field private tvAiStatus:Landroid/widget/TextView;
.field private viewModel:Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;


.method public static synthetic $r8$lambda$-MI43pRMglnTGo-UXPYT-bTS1Hk(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  android.view.View  int  int  int  int  int  int  int  int)void
    .registers 10
    # ins_size=10
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->setupBottomButtonShadows$lambda$23(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Landroid/view/View; I I I I I I I I)V
    return-void 
.end method

.method public static synthetic $r8$lambda$0AWvOCppPHfJqPC9YoRW47UWqic(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->setupBottomButtons$lambda$17(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$2KKZBOWqQkqg7l-fM9_tHF0CCNg(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  android.view.View  int  int  int  int  int  int  int  int)void
    .registers 10
    # ins_size=10
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->setupBottomButtonShadows$lambda$24(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Landroid/view/View; I I I I I I I I)V
    return-void 
.end method

.method public static synthetic $r8$lambda$5Y4o41RwF6H3n6u9O1MgE9clFas(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateTaskDoneHold$lambda$66(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$8BFD3kcWDsp9ZpuRh5PeIePalrI(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  com.bytedance.trae.conversation.widget.ChatAttachmentDialog$AttachmentType)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->showAttachmentPicker$lambda$29$lambda$28(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$8m_dxHmwPPzhCIo5SX6Wi4EqR8I(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->setupBottomButtonShadows$lambda$25(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$95x-XnVtVJixYlqTq1cs5YAsBOU(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->hideScrollToBottomButton$lambda$47(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$HP72AA4RxjadMstH1sHN5n4Gxb0(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->scheduleTaskRunningLongRefresh$lambda$55(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$HRJSQRfAY_UM65B0mwMQdyqXKdE(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  java.lang.Boolean)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->micPermissionLauncher$lambda$0(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Ljava/lang/Boolean;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$I_8q8qmMbRvHcwUqpAe5Isnnm5Q(android.view.GestureDetector  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->setupBottomDebugCopyGesture$lambda$9(Landroid/view/GestureDetector; Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$Ic8a4Ph2OzddVw9iuGS3RrFJgk8(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->setupBottomButtons$lambda$15(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$LAuJKV_cHJKFO2AfpTWSHRKxlw8(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->setupBottomButtons$lambda$16(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$NOXvoohF8kiXAeFhUyQeVTeSEQA(android.view.View)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->fadeOutView$lambda$67(Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$O0wh6WBlId8jL84JbyVnnChP5v0(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requestCameraThenLaunch$lambda$30(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$PpCNF9qDabLEw-pJh9JZ-W0Ovbw(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  android.media.MediaPlayer)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->playEnterSound$lambda$44$lambda$43(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Landroid/media/MediaPlayer;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$QmQJBrFLoezV-nmSJCnjheN3UF0(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->seedSubtitleHistoryFromState$lambda$45(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Yiteez4bKOPQCu6nWhyslwXxkE0(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  java.lang.Boolean)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->cameraPermissionLauncher$lambda$1(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Ljava/lang/Boolean;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$a2zlijUnX9wbQq_1VKIcLzecSfA(android.view.View  android.view.MotionEvent)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->setupSphereWebView$lambda$13(Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$d407uukwY-jllbIQvYhLvB8wD4A(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->setupTopBar$lambda$11(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$de-hXyGgfN1Oiq56H7hf5n2cV5I(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->setupSphereWebView$lambda$14(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$e2nhPTyBewJwokwfdFcBkDgUykk(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateContentMode$lambda$70(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$iavZ3WhAHgBTYvEb0fx959QJApc(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  java.lang.Boolean)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->takePictureLauncher$lambda$3(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Ljava/lang/Boolean;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$jnSjX4g9CpuV74qeBoDTvXwQxUw(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->setupTopBar$lambda$12(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$mlYAtakd6oBhC_Q2gzYBXC9v6fc(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  java.util.List)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->filePickerLauncher$lambda$7(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Ljava/util/List;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$njcFIv7mTXa_KK0j1Fy_kMDVHJ4(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->setupSubtitleRecyclerView$lambda$46(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$rKZbh2hdpaGUTskmFMeNhVjaLAg(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  androidx.activity.result.ActivityResult)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->mediaChooseLauncher$lambda$5(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Landroidx/activity/result/ActivityResult;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$urfaDf-H0bDqsRCVvYUtjkdArxQ(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateContentMode$lambda$69(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$z8doiP9gZEliAUXTVLmKPWdNB-U(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->setupTopBar$lambda$10(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 5
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->Companion Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$Companion;
    const/4 v0, 3
    new-array v0, v0, [Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Creating Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    const/4 v2, 0
    aput-object v1, v0, v2
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Thinking Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    const/4 v3, 1
    aput-object v1, v0, v3
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Streaming Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    const/4 v4, 2
    aput-object v1, v0, v4
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->IN_FLIGHT_SUB_TASK_STATES Ljava/util/Set;
    new-array v0, v4, [Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Done Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    aput-object v1, v0, v2
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Failed Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    aput-object v1, v0, v3
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->TERMINAL_BOTTOM_SUB_TASK_STATES Ljava/util/Set;
    return-void 
.end method

.method public constructor <init>()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Landroidx/fragment/app/Fragment;-><init>()V
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomActionShadowTargets Ljava/util/List;
    new-instance v0, Landroid/graphics/Rect;
    invoke-direct v0, Landroid/graphics/Rect;-><init>()V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomActionButtonRect Landroid/graphics/Rect;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;-><init>()V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->historySubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->lastSubTaskRouteLogs Ljava/util/Map;
    const/4 v0, -1
    iput v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->curTimerSeconds I
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;->Normal Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->curTimeoutState Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->Prompt Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->curBottomStatus Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    new-instance v0, Ljava/util/LinkedHashSet;
    invoke-direct v0, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v0, Ljava/util/Set;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->seenBottomTerminalTaskIds Ljava/util/Set;
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;->HIDDEN Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->curAiDisplayMode Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    const-wide/16 v0, 200
    iput-wide v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->displaySwitchDelayMs J
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->displaySwitchHandler Landroid/os/Handler;
    const-wide/16 v0, 3000
    iput-wide v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->taskDoneHoldMs J
    const-wide/16 v0, 10000
    iput-wide v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->taskRunningLongDelayMs J
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$RequestPermission;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$RequestPermission;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda20;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda20;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    const-string v1, "registerForActivityResult(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->micPermissionLauncher Landroidx/activity/result/ActivityResultLauncher;
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$RequestPermission;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$RequestPermission;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda21;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda21;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    invoke-virtual v3, v0, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->cameraPermissionLauncher Landroidx/activity/result/ActivityResultLauncher;
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$TakePicture;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$TakePicture;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda22;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda22;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    invoke-virtual v3, v0, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->takePictureLauncher Landroidx/activity/result/ActivityResultLauncher;
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda23;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda23;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    invoke-virtual v3, v0, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->mediaChooseLauncher Landroidx/activity/result/ActivityResultLauncher;
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$OpenMultipleDocuments;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$OpenMultipleDocuments;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda24;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda24;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    invoke-virtual v3, v0, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->filePickerLauncher Landroidx/activity/result/ActivityResultLauncher;
    return-void 
.end method

.method public static final synthetic access$getCurIsMicMuted$p(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->curIsMicMuted Z
    return v0
.end method

.method public static final synthetic access$getMainWaveform$p(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)com.bytedance.trae.conversation.brainstorm.widget.VoiceStatusWaveIconView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->mainWaveform Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    return-object v0
.end method

.method public static final synthetic access$getViewModel$p(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)com.bytedance.trae.conversation.brainstorm.BrainstormViewModel
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    return-object v0
.end method

.method public static final synthetic access$hideScrollToBottomButton(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->hideScrollToBottomButton()V
    return-void 
.end method

.method public static final synthetic access$isUserScrolling$p(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->isUserScrolling Z
    return v0
.end method

.method public static final synthetic access$previewAttachment(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->previewAttachment(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)V
    return-void 
.end method

.method public static final synthetic access$setDragging$p(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->isDragging Z
    return-void 
.end method

.method public static final synthetic access$setUserScrolling$p(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->isUserScrolling Z
    return-void 
.end method

.method public static final synthetic access$showScrollToBottomButton(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->showScrollToBottomButton()V
    return-void 
.end method

.method public static final synthetic access$updateAiDisplay(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateAiDisplay(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)V
    return-void 
.end method

.method public static final synthetic access$updateContentMode(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  boolean)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateContentMode(Z)V
    return-void 
.end method

.method public static final synthetic access$updateMicUi(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  boolean)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateMicUi(Z)V
    return-void 
.end method

.method public static final synthetic access$updateParticipantStates(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateParticipantStates(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)V
    return-void 
.end method

.method public static final synthetic access$updateSubtitleListIfNeeded(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateSubtitleListIfNeeded(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)V
    return-void 
.end method

.method public static final synthetic access$updateSubtitleTopGradient(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateSubtitleTopGradient()V
    return-void 
.end method

.method public static final synthetic access$updateTimeoutState(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  com.bytedance.trae.conversation.brainstorm.model.TimeoutState  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateTimeoutState(Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I)V
    return-void 
.end method

.method public static final synthetic access$updateTimer(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateTimer(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)V
    return-void 
.end method

.method public static final synthetic access$updateWaveformAnimating(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  boolean)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateWaveformAnimating(Z)V
    return-void 
.end method

.method private final addBottomActionShadow(android.view.View  int  int  int  int)void
    .registers 19
    # ins_size=6
    move-object v0, v13
    move/from16 v4, v17
    move/from16 v1, v18
    sub-int v2, v4, v1
    const/4 v3, 0
    invoke-static v2, v3, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v5
    add-int v6, v4, v1
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireContext()Landroid/content/Context;
    move-result-object v8
    const-string/jumbo v7, requireContext(...)
    invoke-static v8, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 6
    const/4 v12, 0
    move-object v7, v2
    invoke-direct/range v7 ... v12, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v13, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireContext()Landroid/content/Context;
    move-result-object v7
    move v8, v15
    invoke-static v7, v15, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v9
    int-to-float v10, v4
    int-to-float v11, v1
    int-to-float v12, v5
    move-object v7, v2
    move/from16 v8, v16
    invoke-virtual/range v7 ... v12, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->configure(I I F F F)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->footerContainer Landroidx/constraintlayout/widget/ConstraintLayout;
    if-nez v1, +008h
    const-string v1, "footerContainer"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    move-object v7, v2
    check-cast v7, Landroid/view/View;
    new-instance v8, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;
    invoke-direct v8, v3, v3, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;-><init>(I I)V
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v7, v3, v8, Landroidx/constraintlayout/widget/ConstraintLayout;->addView(Landroid/view/View; I Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomActionShadowTargets Ljava/util/List;
    move-object v7, v1
    check-cast v7, Ljava/util/Collection;
    new-instance v8, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;
    move-object v1, v8
    move-object v3, v14
    move/from16 v4, v17
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView; Landroid/view/View; I I I)V
    invoke-interface v7, v8, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method private final bindViews(android.view.View)void
    .registers 5
    # ins_size=2
    sget v0, Lcom/bytedance/trae/conversation/R$id;->top_bar I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const-string v1, "findViewById(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->topBar Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->chat_mode_container I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->chatModeContainer Landroid/view/View;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->subtitle_mode_container I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleModeContainer Landroid/view/View;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->webview_sphere I
    invoke-virtual v4, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/webkit/WebView;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;-><init>(Landroid/webkit/WebView;)V
    const v2, 1059984507
    invoke-static v2, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v2
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->setSphereRatio(Ljava/lang/Float;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->sphereController Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_ai_status I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->tvAiStatus Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->ai_display_switcher I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/FrameLayout;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->aiDisplaySwitcher Landroid/widget/FrameLayout;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->ai_subtitle_container I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/FrameLayout;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->aiSubtitleContainer Landroid/widget/FrameLayout;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->rv_ai_subtitle I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->rvAiSubtitle Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->test_frame I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomStatusCopyArea Landroid/view/View;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->main_waveform I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->mainWaveform Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_bottom_status I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomStatusText Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_subtitle_empty_hint I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleEmptyHint Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->footer_container I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroidx/constraintlayout/widget/ConstraintLayout;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->footerContainer Landroidx/constraintlayout/widget/ConstraintLayout;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->bottom_bar I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/view/ViewGroup;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomBar Landroid/view/ViewGroup;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_mic I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/Button;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnMic Landroid/widget/Button;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_attach I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/Button;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnAttach Landroid/widget/Button;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_confirm I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/Button;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnConfirm Landroid/widget/Button;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->rv_subtitle I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->rvHistorySubtitle Landroidx/recyclerview/widget/RecyclerView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_scroll_to_bottom I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ImageView;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnScrollToBottom Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->subtitle_top_gradient I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v4, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleTopGradient Landroid/view/View;
    return-void 
.end method

.method private static final cameraPermissionLauncher$lambda$1(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  java.lang.Boolean)void
    .registers 3
    # ins_size=2
    invoke-virtual v2, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    if-nez v2, +011h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_camera_message I
    const/4 v0, 0
    invoke-static v1, v2, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v1
    invoke-virtual v1, Landroid/widget/Toast;->show()V
    return-void 
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->openCamera()V
    return-void 
.end method

.method private final createImageUri()android.net.Uri
    .registers 7
    # ins_size=1
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    const-string/jumbo v1, requireContext(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Ljava/io/File;
    invoke-virtual v0, Landroid/content/Context;->getCacheDir()Ljava/io/File;
    move-result-object v2
    const-string v3, "camera"
    invoke-direct v1, v2, v3, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-virtual v1, Ljava/io/File;->mkdirs()Z
    new-instance v2, Ljava/io/File;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, trae_brainstorm_camera_
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v4
    invoke-virtual v3, v4, v5, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ".jpg"
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-direct v2, v1, v3, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ".uri.key"
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, v2, Landroidx/core/content/FileProvider;->getUriForFile(Landroid/content/Context; Ljava/lang/String; Ljava/io/File;)Landroid/net/Uri;
    move-result-object v0
    goto +eh
    move-exception v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "createImageUri failed"
    check-cast v0, Ljava/lang/Throwable;
    const-string v3, "DiscussingFragment"
    invoke-virtual v1, v3, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    const/4 v0, 0
    return-object v0
    :try_start_0x37
.end method

.method private final dispatchPickedUri(android.net.Uri  java.lang.String)void
    .registers 14
    # ins_size=3
    invoke-virtual v11, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v0, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v0, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v1
    invoke-virtual v1, v12, Landroid/content/ContentResolver;->getType(Landroid/net/Uri;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +016h
    invoke-static Landroid/webkit/MimeTypeMap;->getSingleton()Landroid/webkit/MimeTypeMap;
    move-result-object v0
    invoke-virtual v12, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, Landroid/webkit/MimeTypeMap;->getFileExtensionFromUrl(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Landroid/webkit/MimeTypeMap;->getMimeTypeFromExtension(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, "application/octet-stream"
    invoke-virtual v12, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    const-string v2, "attachment"
    move-object v7, v2
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v8, 0
    const-wide/16 v9, -1
    move-object v2, v12
    invoke-virtual/range v1 ... v6, Landroid/content/ContentResolver;->query(Landroid/net/Uri; [Ljava/lang/String; Ljava/lang/String; [Ljava/lang/String; Ljava/lang/String;)Landroid/database/Cursor;
    move-result-object v1
    if-eqz v1, +055h
    check-cast v1, Ljava/io/Closeable;
    move-object v2, v1
    check-cast v2, Landroid/database/Cursor;
    invoke-interface v2, Landroid/database/Cursor;->moveToFirst()Z
    move-result v3
    if-eqz v3, +024h
    const-string v3, "_display_name"
    invoke-interface v2, v3, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I
    move-result v3
    if-ltz v3, +009h
    invoke-interface v2, v3, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +003h
    move-object v7, v3
    const-string v3, "_size"
    invoke-interface v2, v3, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I
    move-result v3
    if-ltz v3, +00dh
    invoke-interface v2, v3, Landroid/database/Cursor;->isNull(I)Z
    move-result v4
    if-nez v4, +007h
    invoke-interface v2, v3, Landroid/database/Cursor;->getLong(I)J
    move-result-wide v2
    move-wide v9, v2
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v1, v8, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    goto +21h
    move-exception v2
    throw v2
    move-exception v3
    invoke-static v1, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v3
    move-exception v1
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "dispatchPickedUri: resolve meta failed for "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    check-cast v1, Ljava/lang/Throwable;
    const-string v4, "DiscussingFragment"
    invoke-virtual v2, v4, v3, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    move-object v5, v7
    move-wide v6, v9
    const/4 v1, 0
    const/4 v2, 2
    const-string v3, "image/"
    invoke-static v0, v3, v1, v2, v8, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    iget-object v2, v11, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v2, +009h
    const-string/jumbo v2, viewModel
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v8
    move-object v3, v12
    move-object v4, v0
    move v8, v1
    move-object v9, v13
    invoke-virtual/range v2 ... v9, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->pickAndUpload(Landroid/net/Uri; Ljava/lang/String; Ljava/lang/String; J Z Ljava/lang/String;)V
    return-void 
    :try_start_0x37
    :try_start_0x3f
    :try_start_0x6c
    :try_start_0x71
    :try_start_0x73
.end method

.method static synthetic dispatchPickedUri$default(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  android.net.Uri  java.lang.String  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->dispatchPickedUri(Landroid/net/Uri; Ljava/lang/String;)V
    return-void 
.end method

.method private final fadeInView(android.view.View)void
    .registers 5
    # ins_size=2
    invoke-virtual v4, Landroid/view/View;->getVisibility()I
    move-result v0
    const/high16 v1, 1065353216
    const/4 v2, 0
    if-nez v0, +010h
    invoke-virtual v4, Landroid/view/View;->getAlpha()F
    move-result v0
    cmpg-float v0, v0, v1
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    move v0, v2
    if-eqz v0, +003h
    return-void 
    const/4 v0, 0
    invoke-virtual v4, v0, Landroid/view/View;->setAlpha(F)V
    invoke-virtual v4, v2, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v4, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;
    move-result-object v4
    invoke-virtual v4, v1, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;
    move-result-object v4
    const-wide/16 v0, 150
    invoke-virtual v4, v0, v1, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;
    move-result-object v4
    invoke-virtual v4, Landroid/view/ViewPropertyAnimator;->start()V
    return-void 
.end method

.method private final fadeOutView(android.view.View)void
    .registers 5
    # ins_size=2
    invoke-virtual v4, Landroid/view/View;->getVisibility()I
    move-result v0
    const/16 v1, 8
    if-ne v0, v1, +003h
    return-void 
    invoke-virtual v4, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    const-wide/16 v1, 150
    invoke-virtual v0, v1, v2, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda0;
    invoke-direct v1, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda0;-><init>(Landroid/view/View;)V
    invoke-virtual v0, v1, Landroid/view/ViewPropertyAnimator;->withEndAction(Ljava/lang/Runnable;)Landroid/view/ViewPropertyAnimator;
    move-result-object v4
    invoke-virtual v4, Landroid/view/ViewPropertyAnimator;->start()V
    return-void 
.end method

.method private static final fadeOutView$lambda$67(android.view.View)void
    .registers 2
    # ins_size=1
    const/16 v0, 8
    invoke-virtual v1, v0, Landroid/view/View;->setVisibility(I)V
    return-void 
.end method

.method private static final filePickerLauncher$lambda$7(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  java.util.List)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, uris
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v3, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v0
    const/4 v1, 1
    if-le v0, v1, +00bh
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v0
    invoke-virtual v0, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    check-cast v3, Ljava/lang/Iterable;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Landroid/net/Uri;
    invoke-direct v2, v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->dispatchPickedUri(Landroid/net/Uri; Ljava/lang/String;)V
    goto -fh
    return-void 
.end method

.method private final hasMeaningfulUserInput(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)boolean
    .registers 7
    # ins_size=2
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getCurrentTranscript()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    const/4 v1, 1
    xor-int/2addr v0, v1
    if-nez v0, +054h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAttachments()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/2addr v0, v1
    if-nez v0, +047h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubtitleHistory()Ljava/util/List;
    move-result-object v6
    check-cast v6, Ljava/lang/Iterable;
    instance-of v0, v6, Ljava/util/Collection;
    const/4 v2, 0
    if-eqz v0, +00dh
    move-object v0, v6
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +004h
    move v6, v2
    goto +2ch
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, -00ah
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getRole()Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;->User Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    if-ne v3, v4, +011h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getContent()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/2addr v0, v1
    if-eqz v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, -024h
    move v6, v1
    if-eqz v6, +003h
    goto +2h
    move v1, v2
    return v1
.end method

.method private final hasPendingAnchoredSubTask(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)boolean
    .registers 10
    # ins_size=2
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubtitleHistory()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    instance-of v1, v0, Ljava/util/Collection;
    const/4 v2, 0
    if-eqz v1, +00dh
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +004h
    goto/16 +075h
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +06bh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getAttachedSubTaskId()Ljava/lang/String;
    move-result-object v3
    const/4 v4, 1
    if-nez v3, +004h
    move v1, v2
    goto +58h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getSubTaskTerminalState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v1
    if-eqz v1, +003h
    goto -8h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubTask()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v1
    const/4 v5, 0
    if-eqz v1, +00dh
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move-object v1, v5
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->IN_FLIGHT_SUB_TASK_STATES Ljava/util/Set;
    check-cast v6, Ljava/lang/Iterable;
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v7
    goto +2h
    move-object v7, v5
    invoke-static v6, v7, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +004h
    move v1, v4
    goto +2ah
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->TERMINAL_BOTTOM_SUB_TASK_STATES Ljava/util/Set;
    move-object v7, v6
    check-cast v7, Ljava/lang/Iterable;
    if-eqz v1, +006h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v5
    invoke-static v7, v5, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto -41h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getFinishedSubTasks()Ljava/util/Map;
    move-result-object v1
    invoke-interface v1, v3, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    if-eqz v1, -04ch
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v1
    invoke-interface v6, v1, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, -056h
    goto -2ah
    if-eqz v1, -06ch
    move v2, v4
    return v2
.end method

.method private final hideScrollToBottomButton()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnScrollToBottom Landroid/widget/ImageView;
    const/4 v1, 0
    const-string v2, "btnScrollToBottom"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Landroid/widget/ImageView;->getVisibility()I
    move-result v0
    if-eqz v0, +003h
    return-void 
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnScrollToBottom Landroid/widget/ImageView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, Landroid/widget/ImageView;->animate()Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    const-wide/16 v1, 150
    invoke-virtual v0, v1, v2, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda3;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    invoke-virtual v0, v1, Landroid/view/ViewPropertyAnimator;->withEndAction(Ljava/lang/Runnable;)Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    invoke-virtual v0, Landroid/view/ViewPropertyAnimator;->start()V
    return-void 
.end method

.method private static final hideScrollToBottomButton$lambda$47(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)void
    .registers 2
    # ins_size=1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnScrollToBottom Landroid/widget/ImageView;
    if-nez v1, +008h
    const-string v1, "btnScrollToBottom"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    const/16 v0, 8
    invoke-virtual v1, v0, Landroid/widget/ImageView;->setVisibility(I)V
    return-void 
.end method

.method private final isAiReplying(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)boolean
    .registers 5
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAiParticipantState()Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Speaking Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    const/4 v2, 1
    if-eq v0, v1, +011h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getBotTranscript()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/2addr v4, v2
    if-eqz v4, +003h
    goto +2h
    const/4 v2, 0
    return v2
.end method

.method private final isTaskProcessingForSphere(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)boolean
    .registers 4
    # ins_size=2
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubTask()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->IN_FLIGHT_SUB_TASK_STATES Ljava/util/Set;
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, v0, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00bh
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->hasPendingAnchoredSubTask(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)Z
    move-result v3
    if-eqz v3, +003h
    goto +3h
    const/4 v3, 0
    goto +2h
    const/4 v3, 1
    return v3
.end method

.method private final launchMediaChooser()void
    .registers 4
    # ins_size=1
    new-instance v0, Landroid/content/Intent;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseActivity;
    invoke-direct v0, v1, v2, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->mediaChooseLauncher Landroidx/activity/result/ActivityResultLauncher;
    invoke-virtual v1, v0, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    return-void 
.end method

.method private final layoutBottomActions()void
    .registers 10
    # ins_size=1
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnAttach Landroid/widget/Button;
    const-string v1, "btnAttach"
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    iget-object v3, v9, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    const-string/jumbo v4, viewModel
    if-nez v3, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v2
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->getAttachmentSubTaskEnabled()Z
    move-result v3
    const/4 v5, 0
    if-eqz v3, +004h
    move v3, v5
    goto +3h
    const/16 v3, 8
    invoke-virtual v0, v3, Landroid/widget/Button;->setVisibility(I)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->getAttachmentSubTaskEnabled()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v3, Lcom/bytedance/trae/conversation/R$dimen;->trae_brainstorm_bottom_action_gap I
    invoke-virtual v0, v3, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v0
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/conversation/R$dimen;->trae_brainstorm_bottom_status_height I
    invoke-virtual v3, v4, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v3
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    sget v6, Lcom/bytedance/trae/conversation/R$dimen;->trae_brainstorm_bottom_status_width I
    invoke-virtual v4, v6, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v4
    iget-object v6, v9, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomStatusCopyArea Landroid/view/View;
    const-string v7, "bottomStatusCopyArea"
    if-nez v6, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v2
    invoke-virtual v6, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v6
    instance-of v8, v6, Landroid/view/ViewGroup;
    if-eqz v8, +005h
    check-cast v6, Landroid/view/ViewGroup;
    goto +2h
    move-object v6, v2
    if-eqz v6, +00dh
    iget-object v8, v9, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomStatusCopyArea Landroid/view/View;
    if-nez v8, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v2
    invoke-virtual v6, v8, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v6, v4, v3, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v6, v0, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    invoke-virtual v6, v0, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    iget-object v3, v9, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomBar Landroid/view/ViewGroup;
    const-string v4, "bottomBar"
    if-nez v3, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v2
    iget-object v8, v9, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomStatusCopyArea Landroid/view/View;
    if-nez v8, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v2
    const/4 v7, 1
    check-cast v6, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v8, v7, v6, Landroid/view/ViewGroup;->addView(Landroid/view/View; I Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v3, v9, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomBar Landroid/view/ViewGroup;
    if-nez v3, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v2
    invoke-virtual v3, Landroid/view/ViewGroup;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v3
    instance-of v6, v3, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;
    if-eqz v6, +005h
    check-cast v3, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;
    goto +2h
    move-object v3, v2
    if-eqz v3, +016h
    const/4 v6, -1
    iput v6, v3, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->topToBottom I
    iput v5, v3, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->topToTop I
    iput v0, v3, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->topMargin I
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomBar Landroid/view/ViewGroup;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v3, Landroid/view/ViewGroup;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnConfirm Landroid/widget/Button;
    if-nez v0, +008h
    const-string v0, "btnConfirm"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    check-cast v0, Landroid/view/View;
    invoke-direct v9, v0, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->setStartMargin(Landroid/view/View; I)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnAttach Landroid/widget/Button;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    check-cast v2, Landroid/view/View;
    invoke-direct v9, v2, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->setStartMargin(Landroid/view/View; I)V
    return-void 
.end method

.method private final logSubTaskBadgeRoute(java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState  com.bytedance.trae.conversation.voice.subtask.SubTaskRenderState)void
    .registers 10
    # ins_size=7
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 58
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getLongRunning()Z
    move-result v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getFailureReason()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    iget-object v2, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->lastSubTaskRouteLogs Ljava/util/Map;
    invoke-interface v2, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    return-void 
    iget-object v2, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->lastSubTaskRouteLogs Ljava/util/Map;
    invoke-interface v2, v4, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v2, subTaskBadgeRoute: messageId=
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v0, ", taskId="
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v0, ", route="
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v0, ", badge="
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v0
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v0, ", longRunning="
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getLongRunning()Z
    move-result v7
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v7, ", terminal="
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v7, ", active="
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubTask()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v7
    const/4 v9, 0
    if-eqz v7, +007h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v7
    goto +2h
    move-object v7, v9
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubTask()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v7
    if-eqz v7, +006h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v9
    invoke-virtual v4, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v7, ", finishedHit="
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getFinishedSubTasks()Ljava/util/Map;
    move-result-object v7
    invoke-interface v7, v5, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", historySize="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubtitleHistory()Ljava/util/List;
    move-result-object v5
    invoke-interface v5, Ljava/util/List;->size()I
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v5, "placeholder"
    invoke-static v6, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    const-string v6, "DiscussingFragment"
    if-eqz v5, +008h
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-virtual v5, v6, v4, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    goto +6h
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-virtual v5, v6, v4, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private static final mediaChooseLauncher$lambda$5(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  androidx.activity.result.ActivityResult)void
    .registers 4
    # ins_size=2
    invoke-virtual v3, Landroidx/activity/result/ActivityResult;->getResultCode()I
    move-result v0
    const/4 v1, -1
    if-eq v0, v1, +003h
    return-void 
    invoke-virtual v3, Landroidx/activity/result/ActivityResult;->getData()Landroid/content/Intent;
    move-result-object v3
    if-eqz v3, +036h
    const-string/jumbo v0, trae_media_choose_result_selected
    invoke-virtual v3, v0, Landroid/content/Intent;->getParcelableArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;
    move-result-object v3
    if-eqz v3, +02dh
    invoke-virtual v3, Ljava/util/ArrayList;->size()I
    move-result v0
    const/4 v1, 1
    if-le v0, v1, +00bh
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v0
    invoke-virtual v0, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    check-cast v3, Ljava/lang/Iterable;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +010h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getUri()Landroid/net/Uri;
    move-result-object v1
    invoke-direct v2, v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->dispatchPickedUri(Landroid/net/Uri; Ljava/lang/String;)V
    goto -13h
    return-void 
.end method

.method private static final micPermissionLauncher$lambda$0(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  java.lang.Boolean)void
    .registers 3
    # ins_size=2
    invoke-virtual v2, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    const/4 v0, 0
    if-eqz v2, +012h
    iget-object v1, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v1, +009h
    const-string/jumbo v1, viewModel
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->startRecording()V
    goto +18h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->getView()Landroid/view/View;
    move-result-object v1
    instance-of v2, v1, Landroid/view/ViewGroup;
    if-eqz v2, +005h
    move-object v0, v1
    check-cast v0, Landroid/view/ViewGroup;
    if-nez v0, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$MicPermissionDeniedRuntime;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$MicPermissionDeniedRuntime;
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->enqueue(Landroid/view/ViewGroup; Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;)V
    return-void 
.end method

.method private final observeState()void
    .registers 10
    # ins_size=1
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    const-string v1, "getViewLifecycleOwner(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$1;
    const/4 v8, 0
    invoke-direct v0, v9, v8, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Lkotlin/coroutines/Continuation;)V
    move-object v5, v0
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$2;
    invoke-direct v0, v9, v8, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$2;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Lkotlin/coroutines/Continuation;)V
    move-object v5, v0
    check-cast v5, Lkotlin/jvm/functions/Function2;
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$3;
    invoke-direct v0, v9, v8, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$3;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final openCamera()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->createImageUri()Landroid/net/Uri;
    move-result-object v0
    if-nez v0, +014h
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_media_choose_camera_create_failed I
    const/4 v2, 0
    invoke-static v0, v1, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    return-void 
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->pendingCameraUri Landroid/net/Uri;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->takePictureLauncher Landroidx/activity/result/ActivityResultLauncher;
    invoke-virtual v1, v0, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    return-void 
.end method

.method private final performAiDisplaySwitch(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$AiDisplayMode)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->curAiDisplayMode Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    if-ne v0, v5, +003h
    return-void 
    iput-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->curAiDisplayMode Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$WhenMappings;->$EnumSwitchMapping$3 [I
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;->ordinal()I
    move-result v5
    aget v5, v0, v5
    const/4 v0, 1
    const-string v1, "aiSubtitleContainer"
    const-string/jumbo v2, tvAiStatus
    const/4 v3, 0
    if-eq v5, v0, +046h
    const/4 v0, 2
    if-eq v5, v0, +027h
    const/4 v0, 3
    if-ne v5, v0, +01eh
    iget-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->tvAiStatus Landroid/widget/TextView;
    if-nez v5, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v3
    check-cast v5, Landroid/view/View;
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->fadeOutView(Landroid/view/View;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->aiSubtitleContainer Landroid/widget/FrameLayout;
    if-nez v5, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v5
    check-cast v3, Landroid/view/View;
    invoke-direct v4, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->fadeInView(Landroid/view/View;)V
    goto +3eh
    new-instance v5, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v5, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v5
    iget-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->tvAiStatus Landroid/widget/TextView;
    if-nez v5, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v3
    check-cast v5, Landroid/view/View;
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->fadeInView(Landroid/view/View;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->aiSubtitleContainer Landroid/widget/FrameLayout;
    if-nez v5, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v5
    check-cast v3, Landroid/view/View;
    invoke-direct v4, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->fadeOutView(Landroid/view/View;)V
    goto +1ch
    iget-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->tvAiStatus Landroid/widget/TextView;
    if-nez v5, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v3
    check-cast v5, Landroid/view/View;
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->fadeOutView(Landroid/view/View;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->aiSubtitleContainer Landroid/widget/FrameLayout;
    if-nez v5, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v5
    check-cast v3, Landroid/view/View;
    invoke-direct v4, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->fadeOutView(Landroid/view/View;)V
    return-void 
.end method

.method private final playEnterSound()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->enterMediaPlayer Landroid/media/MediaPlayer;
    if-eqz v0, +01ch
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v0, Landroid/media/MediaPlayer;->release()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->box-impl(Ljava/lang/Object;)Lkotlin/Result;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$raw;->trae_brainstorm_enter I
    invoke-static v0, v1, Landroid/media/MediaPlayer;->create(Landroid/content/Context; I)Landroid/media/MediaPlayer;
    move-result-object v0
    if-eqz v0, +00eh
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda25;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda25;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    invoke-virtual v0, v1, Landroid/media/MediaPlayer;->setOnCompletionListener(Landroid/media/MediaPlayer$OnCompletionListener;)V
    invoke-virtual v0, Landroid/media/MediaPlayer;->start()V
    goto +2h
    const/4 v0, 0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->enterMediaPlayer Landroid/media/MediaPlayer;
    return-void 
    :try_start_0x4
.end method

.method private static final playEnterSound$lambda$44$lambda$43(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  android.media.MediaPlayer)void
    .registers 3
    # ins_size=2
    invoke-virtual v2, Landroid/media/MediaPlayer;->release()V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->enterMediaPlayer Landroid/media/MediaPlayer;
    if-ne v0, v2, +005h
    const/4 v2, 0
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->enterMediaPlayer Landroid/media/MediaPlayer;
    return-void 
.end method

.method private final previewAttachment(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)void
    .registers 22
    # ins_size=2
    move-object/from16 v0, v20
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->isImage()Z
    move-result v1
    const/4 v2, 2
    const-string v3, "image/"
    const/4 v4, 0
    const/4 v5, 1
    const/4 v6, 0
    if-nez v1, +00fh
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getMimeType()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v3, v4, v2, v6, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    move v1, v4
    goto +2h
    move v1, v5
    const-string/jumbo v7, requireContext(...)
    const-string/jumbo v8, viewModel
    if-eqz v1, +0f1h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->historySubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->currentImageAttachments()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v9
    if-eqz v9, +05bh
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v1, +006h
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v6
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->getUiState()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAttachments()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    new-instance v8, Ljava/util/ArrayList;
    invoke-direct v8, Ljava/util/ArrayList;-><init>()V
    check-cast v8, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +02fh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    move-object v10, v9
    check-cast v10, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->isImage()Z
    move-result v11
    if-nez v11, +00ch
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getMimeType()Ljava/lang/String;
    move-result-object v11
    invoke-static v11, v3, v4, v2, v6, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v11
    if-eqz v11, +011h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getLocalUri()Ljava/lang/String;
    move-result-object v10
    check-cast v10, Ljava/lang/CharSequence;
    invoke-static v10, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v10
    xor-int/2addr v10, v5
    if-eqz v10, +004h
    move v10, v5
    goto +2h
    move v10, v4
    if-eqz v10, -02dh
    invoke-interface v8, v9, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -32h
    move-object v1, v8
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +01eh
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getLocalUri()Ljava/lang/String;
    move-result-object v8
    move-object v9, v8
    check-cast v9, Ljava/lang/CharSequence;
    invoke-static v9, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v9
    xor-int/2addr v9, v5
    if-eqz v9, +003h
    goto +2h
    move-object v8, v6
    if-eqz v8, -01ch
    invoke-interface v2, v8, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -21h
    check-cast v2, Ljava/util/List;
    new-instance v3, Ljava/util/ArrayList;
    const/16 v6, 10
    invoke-static v1, v6, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v6
    invoke-direct v3, v6, Ljava/util/ArrayList;-><init>(I)V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +010h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getDisplayName()Ljava/lang/String;
    move-result-object v6
    invoke-interface v3, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v3, Ljava/util/List;
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getLocalUri()Ljava/lang/String;
    move-result-object v1
    invoke-interface v2, v1, Ljava/util/List;->indexOf(Ljava/lang/Object;)I
    move-result v1
    invoke-static v1, v4, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v1
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    xor-int/2addr v4, v5
    if-eqz v4, +01ah
    sget-object v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->Companion Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireContext()Landroid/content/Context;
    move-result-object v5
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v6, Ljava/util/ArrayList;
    invoke-direct v6, v2, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    new-instance v2, Ljava/util/ArrayList;
    check-cast v3, Ljava/util/Collection;
    invoke-direct v2, v3, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    invoke-virtual v4, v5, v6, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;->startWithLocalUris(Landroid/content/Context; Ljava/util/ArrayList; I Ljava/util/ArrayList;)V
    return-void 
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getUploadedRef()Ljava/lang/String;
    move-result-object v1
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Uploaded Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    if-ne v2, v3, +0b7h
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +008h
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    move v4, v5
    if-eqz v4, +004h
    goto/16 +0a7h
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->getProxyConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    const-string v3, ""
    if-eqz v2, +011h
    move-object v4, v2
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/2addr v4, v5
    if-eqz v4, +003h
    goto +2h
    move-object v2, v6
    if-eqz v2, +003h
    goto +11h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v2, +006h
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v6
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->getCliConversationId()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    move-object v13, v3
    goto +2h
    move-object v13, v2
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->getParentChatSessionId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    if-eqz v2, +011h
    move-object v4, v2
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/2addr v4, v5
    if-eqz v4, +003h
    goto +2h
    move-object v2, v6
    if-eqz v2, +003h
    goto +11h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v2, +006h
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v6
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->getCliConversationId()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    move-object v14, v3
    goto +2h
    move-object v14, v2
    sget-object v9, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->Companion Lcom/bytedance/trae/conversation/products/InputPreviewActivity$Companion;
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireContext()Landroid/content/Context;
    move-result-object v10
    invoke-static v10, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, trae-res://remote_resource/
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getDisplayName()Ljava/lang/String;
    move-result-object v12
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v1, +006h
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v6
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->getVoiceCliType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v15
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v1, +006h
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v6, v1
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->getVoiceMode()Lcom/bytedance/trae/im/service/Mode;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v16
    const/16 v17, 0
    const/16 v18, 128
    const/16 v19, 0
    invoke-static/range v9 ... v19, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$Companion;->start$default(Lcom/bytedance/trae/conversation/products/InputPreviewActivity$Companion; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method private final requestCameraThenLaunch()void
    .registers 12
    # ins_size=1
    invoke-virtual v11, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    const-string/jumbo v0, requireContext(...)
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "android.permission.CAMERA"
    invoke-static v1, v0, Landroidx/core/content/ContextCompat;->checkSelfPermission(Landroid/content/Context; Ljava/lang/String;)I
    move-result v0
    if-nez v0, +006h
    invoke-direct v11, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->openCamera()V
    return-void 
    sget-object v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->Companion Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;
    sget v2, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_permission_camera I
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_camera_title I
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_camera_message I
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_allow I
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_deny I
    new-instance v7, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda10;
    invoke-direct v7, v11, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda10;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    const/4 v8, 0
    const/16 v9, 128
    const/4 v10, 0
    invoke-static/range v0 ... v10, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;->showForPermission$default(Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion; Landroid/content/Context; I I I I I Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;
    return-void 
.end method

.method private static final requestCameraThenLaunch$lambda$30(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)kotlin.Unit
    .registers 2
    # ins_size=1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->cameraPermissionLauncher Landroidx/activity/result/ActivityResultLauncher;
    const-string v0, "android.permission.CAMERA"
    invoke-virtual v1, v0, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final resetTaskRunningClock()void
    .registers 5
    # ins_size=1
    iget-wide v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->taskRunningSinceMs J
    const-wide/16 v2, 0
    cmp-long v0, v0, v2
    if-nez v0, +007h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->taskRunningLongRunnable Ljava/lang/Runnable;
    if-nez v0, +003h
    return-void 
    iput-wide v2, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->taskRunningSinceMs J
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->taskRunningLongRunnable Ljava/lang/Runnable;
    if-eqz v0, +007h
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->displaySwitchHandler Landroid/os/Handler;
    invoke-virtual v1, v0, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    const/4 v0, 0
    iput-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->taskRunningLongRunnable Ljava/lang/Runnable;
    return-void 
.end method

.method private final resolveBottomStatus(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$BottomStatus
    .registers 6
    # ins_size=2
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateTaskDoneHold(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubTask()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->IN_FLIGHT_SUB_TASK_STATES Ljava/util/Set;
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, v0, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +007h
    invoke-direct v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->resolveTaskRunningStatus()Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    move-result-object v5
    return-object v5
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->hasPendingAnchoredSubTask(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)Z
    move-result v0
    if-eqz v0, +007h
    invoke-direct v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->resolveTaskRunningStatus()Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    move-result-object v5
    return-object v5
    invoke-direct v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->resetTaskRunningClock()V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomTaskDoneUntilMs J
    cmp-long v0, v0, v2
    if-gez v0, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->TaskDone Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    return-object v5
    iget-boolean v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->hasEverBeenActive Z
    const/4 v1, 1
    if-nez v0, +00bh
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->hasMeaningfulUserInput(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    move v0, v1
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->isAiReplying(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)Z
    move-result v2
    if-eqz v2, +007h
    if-eqz v0, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->Answering Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    goto +20h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAiParticipantState()Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Thinking Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    if-ne v2, v3, +007h
    if-eqz v0, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->Thinking Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    goto +13h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getCurrentTranscript()Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    xor-int/2addr v5, v1
    if-eqz v5, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->Listening Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    goto +3h
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->Prompt Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    return-object v5
.end method

.method private final resolveSphereState(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)java.lang.String
    .registers 4
    # ins_size=2
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAiParticipantState()Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Speaking Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    if-ne v0, v1, +006h
    const-string/jumbo v3, speaking
    goto +23h
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->isTaskProcessingForSphere(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)Z
    move-result v0
    if-eqz v0, +005h
    const-string v3, "processing"
    goto +1ah
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAiParticipantState()Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Thinking Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    if-ne v0, v1, +006h
    const-string/jumbo v3, thinking
    goto +eh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getUserParticipantState()Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    move-result-object v3
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Speaking Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    if-ne v3, v0, +005h
    const-string v3, "listening"
    goto +3h
    const-string v3, "idle"
    return-object v3
.end method

.method private final resolveTaskRunningStatus()com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$BottomStatus
    .registers 7
    # ins_size=1
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    iget-wide v2, v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->taskRunningSinceMs J
    const-wide/16 v4, 0
    cmp-long v2, v2, v4
    if-nez v2, +007h
    iput-wide v0, v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->taskRunningSinceMs J
    invoke-direct v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->scheduleTaskRunningLongRefresh()V
    iget-wide v2, v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->taskRunningSinceMs J
    sub-long/2addr v0, v2
    iget-wide v2, v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->taskRunningLongDelayMs J
    cmp-long v0, v0, v2
    if-ltz v0, +005h
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->TaskRunningLong Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    goto +3h
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->TaskRunning Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    return-object v0
.end method

.method private final scheduleTaskRunningLongRefresh()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->taskRunningLongRunnable Ljava/lang/Runnable;
    if-eqz v0, +007h
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->displaySwitchHandler Landroid/os/Handler;
    invoke-virtual v1, v0, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda11;
    invoke-direct v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda11;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    iput-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->taskRunningLongRunnable Ljava/lang/Runnable;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->displaySwitchHandler Landroid/os/Handler;
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->taskRunningLongDelayMs J
    invoke-virtual v1, v0, v2, v3, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method private static final scheduleTaskRunningLongRefresh$lambda$55(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->taskRunningLongRunnable Ljava/lang/Runnable;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v1, +009h
    const-string/jumbo v1, viewModel
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->getUiState()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->resolveBottomStatus(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    move-result-object v0
    const/4 v1, 1
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateBottomStatusText(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus; Z)V
    return-void 
.end method

.method private final seedSubtitleHistoryFromState()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->getUiState()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubtitleHistory()Ljava/util/List;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAttachments()Ljava/util/List;
    move-result-object v0
    move-object v3, v2
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    xor-int/lit8 v3, v3, 1
    if-nez v3, +00dh
    move-object v3, v0
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    xor-int/lit8 v3, v3, 1
    if-eqz v3, +01bh
    iget-object v3, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->historySubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;
    invoke-virtual v3, v2, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->seedHistoryWithAttachments(Ljava/util/List; Ljava/util/List;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->rvHistorySubtitle Landroidx/recyclerview/widget/RecyclerView;
    if-nez v0, +009h
    const-string/jumbo v0, rvHistorySubtitle
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda16;
    invoke-direct v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda16;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    invoke-virtual v1, v0, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final seedSubtitleHistoryFromState$lambda$45(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->historySubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->getTotalItemCount()I
    move-result v0
    if-lez v0, +012h
    iget-object v1, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->rvHistorySubtitle Landroidx/recyclerview/widget/RecyclerView;
    if-nez v1, +009h
    const-string/jumbo v1, rvHistorySubtitle
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    add-int/lit8 v0, v0, -1
    invoke-virtual v1, v0, Landroidx/recyclerview/widget/RecyclerView;->scrollToPosition(I)V
    return-void 
.end method

.method private final setStartMargin(android.view.View  int)void
    .registers 5
    # ins_size=3
    invoke-virtual v3, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v0
    instance-of v1, v0, Landroid/widget/LinearLayout$LayoutParams;
    if-eqz v1, +005h
    check-cast v0, Landroid/widget/LinearLayout$LayoutParams;
    goto +2h
    const/4 v0, 0
    if-eqz v0, +00ah
    invoke-virtual v0, v4, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v0, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method private final setupBottomButtonShadows()void
    .registers 16
    # ins_size=1
    iget-object v0, v15, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->footerContainer Landroidx/constraintlayout/widget/ConstraintLayout;
    const-string v1, "footerContainer"
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    const/4 v3, 0
    invoke-virtual v0, v3, Landroidx/constraintlayout/widget/ConstraintLayout;->setClipChildren(Z)V
    iget-object v0, v15, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->footerContainer Landroidx/constraintlayout/widget/ConstraintLayout;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v3, Landroidx/constraintlayout/widget/ConstraintLayout;->setClipToPadding(Z)V
    iget-object v0, v15, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomBar Landroid/view/ViewGroup;
    const-string v4, "bottomBar"
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v3, Landroid/view/ViewGroup;->setClipChildren(Z)V
    iget-object v0, v15, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomBar Landroid/view/ViewGroup;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v3, Landroid/view/ViewGroup;->setClipToPadding(Z)V
    iget-object v0, v15, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->footerContainer Landroidx/constraintlayout/widget/ConstraintLayout;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Landroidx/constraintlayout/widget/ConstraintLayout;->getParent()Landroid/view/ViewParent;
    move-result-object v0
    instance-of v5, v0, Landroid/view/ViewGroup;
    if-eqz v5, +005h
    check-cast v0, Landroid/view/ViewGroup;
    goto +2h
    move-object v0, v2
    if-eqz v0, +008h
    invoke-virtual v0, v3, Landroid/view/ViewGroup;->setClipChildren(Z)V
    invoke-virtual v0, v3, Landroid/view/ViewGroup;->setClipToPadding(Z)V
    const/4 v0, 3
    new-array v0, v0, [Landroid/widget/Button;
    iget-object v5, v15, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnMic Landroid/widget/Button;
    const-string v6, "btnMic"
    if-nez v5, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    aput-object v5, v0, v3
    iget-object v3, v15, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnConfirm Landroid/widget/Button;
    const-string v5, "btnConfirm"
    if-nez v3, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v2
    const/4 v7, 1
    aput-object v3, v0, v7
    iget-object v3, v15, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnAttach Landroid/widget/Button;
    const-string v7, "btnAttach"
    if-nez v3, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v2
    const/4 v8, 2
    aput-object v3, v0, v8
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +013h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Landroid/widget/Button;
    const/4 v8, 0
    invoke-virtual v3, v8, Landroid/widget/Button;->setElevation(F)V
    invoke-virtual v3, v8, Landroid/widget/Button;->setTranslationZ(F)V
    invoke-virtual v3, v2, Landroid/widget/Button;->setStateListAnimator(Landroid/animation/StateListAnimator;)V
    goto -16h
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v3, Lcom/bytedance/trae/conversation/R$dimen;->trae_brainstorm_action_shadow_blur_radius I
    invoke-virtual v0, v3, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v0
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    sget v8, Lcom/bytedance/trae/conversation/R$dimen;->trae_brainstorm_action_shadow_offset_y I
    invoke-virtual v3, v8, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v3
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireContext()Landroid/content/Context;
    move-result-object v8
    sget v9, Lcom/bytedance/trae/common_ui/R$color;->trae_brainstorm_action_shadow I
    invoke-static v8, v9, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v14
    iget-object v8, v15, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomActionShadowTargets Ljava/util/List;
    invoke-interface v8, Ljava/util/List;->clear()V
    iget-object v8, v15, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnMic Landroid/widget/Button;
    if-nez v8, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v2
    move-object v9, v8
    check-cast v9, Landroid/view/View;
    sget v10, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_base_default I
    move-object v8, v15
    move v11, v14
    move v12, v0
    move v13, v3
    invoke-direct/range v8 ... v13, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->addBottomActionShadow(Landroid/view/View; I I I I)V
    iget-object v6, v15, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnConfirm Landroid/widget/Button;
    if-nez v6, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v2
    move-object v9, v6
    check-cast v9, Landroid/view/View;
    sget v10, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_invert I
    move-object v8, v15
    move v11, v14
    move v12, v0
    move v13, v3
    invoke-direct/range v8 ... v13, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->addBottomActionShadow(Landroid/view/View; I I I I)V
    iget-object v5, v15, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v5, +009h
    const-string/jumbo v5, viewModel
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->getAttachmentSubTaskEnabled()Z
    move-result v5
    if-eqz v5, +016h
    iget-object v5, v15, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnAttach Landroid/widget/Button;
    if-nez v5, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    move-object v9, v5
    check-cast v9, Landroid/view/View;
    sget v10, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_base_default I
    move-object v8, v15
    move v11, v14
    move v12, v0
    move v13, v3
    invoke-direct/range v8 ... v13, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->addBottomActionShadow(Landroid/view/View; I I I I)V
    iget-object v0, v15, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->footerContainer Landroidx/constraintlayout/widget/ConstraintLayout;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda26;
    invoke-direct v3, v15, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda26;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    invoke-virtual v0, v3, Landroidx/constraintlayout/widget/ConstraintLayout;->addOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V
    iget-object v0, v15, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomBar Landroid/view/ViewGroup;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda27;
    invoke-direct v3, v15, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda27;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    invoke-virtual v0, v3, Landroid/view/ViewGroup;->addOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V
    iget-object v0, v15, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->footerContainer Landroidx/constraintlayout/widget/ConstraintLayout;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda1;
    invoke-direct v0, v15, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    invoke-virtual v2, v0, Landroidx/constraintlayout/widget/ConstraintLayout;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final setupBottomButtonShadows$lambda$23(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  android.view.View  int  int  int  int  int  int  int  int)void
    .registers 10
    # ins_size=10
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateBottomActionShadows()V
    return-void 
.end method

.method private static final setupBottomButtonShadows$lambda$24(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  android.view.View  int  int  int  int  int  int  int  int)void
    .registers 10
    # ins_size=10
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateBottomActionShadows()V
    return-void 
.end method

.method private static final setupBottomButtonShadows$lambda$25(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateBottomActionShadows()V
    return-void 
.end method

.method private final setupBottomButtons(android.view.View)void
    .registers 4
    # ins_size=2
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->layoutBottomActions()V
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->setupBottomButtonShadows()V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnMic Landroid/widget/Button;
    const/4 v0, 0
    if-nez v3, +008h
    const-string v3, "btnMic"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v0
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda17;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda17;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    invoke-virtual v3, v1, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v3, +009h
    const-string/jumbo v3, viewModel
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v0
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->getAttachmentSubTaskEnabled()Z
    move-result v3
    const-string v1, "btnAttach"
    if-eqz v3, +013h
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnAttach Landroid/widget/Button;
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v0
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda18;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda18;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    invoke-virtual v3, v1, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    goto +ch
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnAttach Landroid/widget/Button;
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v0
    invoke-virtual v3, v0, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnConfirm Landroid/widget/Button;
    if-nez v3, +008h
    const-string v3, "btnConfirm"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v3
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda19;
    invoke-direct v3, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda19;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    invoke-virtual v0, v3, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupBottomButtons$lambda$15(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->toggleMic()V
    return-void 
.end method

.method private static final setupBottomButtons$lambda$16(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  android.view.View)void
    .registers 5
    # ins_size=2
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    const/4 v0, 0
    const/4 v1, 2
    const-string v2, "discussion_attach_button_click"
    invoke-static v4, v2, v0, v1, v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackAsrDiscuss$default(Lcom/bytedance/trae/conversation/tracker/TraeAITracker; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->showAttachmentPicker()V
    return-void 
.end method

.method private static final setupBottomButtons$lambda$17(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  android.view.View)void
    .registers 5
    # ins_size=2
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    const/4 v0, 2
    const-string v1, "end_discussion_click"
    const/4 v2, 0
    invoke-static v4, v1, v2, v0, v2, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackAsrDiscuss$default(Lcom/bytedance/trae/conversation/tracker/TraeAITracker; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    const-string/jumbo v1, requireContext(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;->playEndDismiss(Landroid/content/Context;)V
    iget-object v3, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v3, +009h
    const-string/jumbo v3, viewModel
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v2
    const/4 v4, 0
    const/4 v0, 1
    invoke-static v3, v4, v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->endBrainstorm$default(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Z I Ljava/lang/Object;)V
    return-void 
.end method

.method private final setupBottomDebugCopyGesture()void
    .registers 6
    # ins_size=1
    new-instance v0, Landroid/view/GestureDetector;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupBottomDebugCopyGesture$detector$1;
    invoke-direct v2, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupBottomDebugCopyGesture$detector$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    check-cast v2, Landroid/view/GestureDetector$OnGestureListener;
    invoke-direct v0, v1, v2, Landroid/view/GestureDetector;-><init>(Landroid/content/Context; Landroid/view/GestureDetector$OnGestureListener;)V
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomStatusCopyArea Landroid/view/View;
    const/4 v2, 0
    const-string v3, "bottomStatusCopyArea"
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    const/4 v4, 1
    invoke-virtual v1, v4, Landroid/view/View;->setClickable(Z)V
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomStatusCopyArea Landroid/view/View;
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v1
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda7;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda7;-><init>(Landroid/view/GestureDetector;)V
    invoke-virtual v2, v1, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    return-void 
.end method

.method private static final setupBottomDebugCopyGesture$lambda$9(android.view.GestureDetector  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    invoke-virtual v0, v2, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z
    const/4 v0, 1
    return v0
.end method

.method private final setupBottomStatusView()void
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->mainWaveform Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    const-string v1, "mainWaveform"
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireContext()Landroid/content/Context;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v3, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->setWaveColor(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->mainWaveform Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView$State;->Slow Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView$State;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->setState(Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView$State;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomStatusText Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    if-nez v0, +008h
    const-string v0, "bottomStatusText"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    const-string v1, "#4D5360"
    invoke-static v1, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v3
    const-string v4, "#D5DFF6"
    invoke-static v4, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v5
    invoke-virtual v0, v3, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->setShimmerColors(I I)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->Prompt Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    const/4 v3, 1
    invoke-direct v6, v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateBottomStatusText(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus; Z)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleEmptyHint Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    const-string/jumbo v3, subtitleEmptyHint
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-static v1, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v1
    invoke-static v4, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v4
    invoke-virtual v0, v1, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->setShimmerColors(I I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleEmptyHint Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->startShimmer()V
    iget-boolean v0, v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->hasEverBeenActive Z
    const/16 v1, 8
    const-string/jumbo v3, tvAiStatus
    if-nez v0, +01ch
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->tvAiStatus Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_sphere_welcome I
    invoke-virtual v0, v4, Landroid/widget/TextView;->setText(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->tvAiStatus Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    const/4 v3, 0
    invoke-virtual v0, v3, Landroid/widget/TextView;->setVisibility(I)V
    goto +ch
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->tvAiStatus Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->aiSubtitleContainer Landroid/widget/FrameLayout;
    if-nez v0, +008h
    const-string v0, "aiSubtitleContainer"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    invoke-virtual v2, v1, Landroid/widget/FrameLayout;->setVisibility(I)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->setupBottomDebugCopyGesture()V
    return-void 
.end method

.method private final setupSphereWebView()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->sphereController Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;
    const-string/jumbo v1, sphereController
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->init()V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->sphereController Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    const/4 v1, 0
    const/4 v3, 1
    invoke-static v0, v1, v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->intro$default(Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController; I I Ljava/lang/Object;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->getView()Landroid/view/View;
    move-result-object v0
    if-eqz v0, +00bh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->webview_sphere I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Landroid/webkit/WebView;
    if-eqz v2, +00ah
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda8;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda8;-><init>()V
    invoke-virtual v2, v0, Landroid/webkit/WebView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    if-eqz v2, +00ah
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda9;
    invoke-direct v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    invoke-virtual v2, v0, Landroid/webkit/WebView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupSphereWebView$lambda$13(android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=2
    invoke-virtual v2, Landroid/view/MotionEvent;->getAction()I
    move-result v2
    const/4 v0, 1
    if-ne v2, v0, +005h
    invoke-virtual v1, Landroid/view/View;->performClick()Z
    return v0
.end method

.method private static final setupSphereWebView$lambda$14(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->toggleSubtitleMode()V
    return-void 
.end method

.method private final setupSubtitleRecyclerView()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->rvHistorySubtitle Landroidx/recyclerview/widget/RecyclerView;
    const-string/jumbo v1, rvHistorySubtitle
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    const/4 v3, 1
    invoke-virtual v0, v3, Landroidx/recyclerview/widget/RecyclerView;->setHasFixedSize(Z)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->rvHistorySubtitle Landroidx/recyclerview/widget/RecyclerView;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    new-instance v3, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireContext()Landroid/content/Context;
    move-result-object v4
    invoke-direct v3, v4, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v0, v3, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->rvHistorySubtitle Landroidx/recyclerview/widget/RecyclerView;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->historySubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v0, v3, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->historySubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupSubtitleRecyclerView$1;
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupSubtitleRecyclerView$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->setAttachmentCallback(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->rvHistorySubtitle Landroidx/recyclerview/widget/RecyclerView;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupSubtitleRecyclerView$2;
    invoke-direct v1, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupSubtitleRecyclerView$2;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->addOnScrollListener(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnScrollToBottom Landroid/widget/ImageView;
    if-nez v0, +008h
    const-string v0, "btnScrollToBottom"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda6;
    invoke-direct v0, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    invoke-virtual v2, v0, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupSubtitleRecyclerView$lambda$46(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  android.view.View)void
    .registers 2
    # ins_size=2
    const/4 v1, 0
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->isUserScrolling Z
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->hideScrollToBottomButton()V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->historySubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->getItemCount()I
    move-result v1
    if-lez v1, +012h
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->rvHistorySubtitle Landroidx/recyclerview/widget/RecyclerView;
    if-nez v0, +009h
    const-string/jumbo v0, rvHistorySubtitle
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    add-int/lit8 v1, v1, -1
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->smoothScrollToPosition(I)V
    return-void 
.end method

.method private final setupTopBar()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->topBar Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;
    const-string/jumbo v1, topBar
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$TopBarMode;->DISCUSSING Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$TopBarMode;
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->setMode(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$TopBarMode;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->topBar Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda12;
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda12;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->setOnBackClick(Lkotlin/jvm/functions/Function0;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->topBar Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda13;
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda13;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->setOnSubtitleToggleClick(Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    const-string v3, "null cannot be cast to non-null type com.bytedance.trae.conversation.brainstorm.BrainstormActivity"
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->isMinimizeDisabled()Z
    move-result v0
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->topBar Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v2
    xor-int/lit8 v4, v0, 1
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->setMinimizeVisible(Z)V
    if-eqz v0, +00eh
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->topBar Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->setOnMinimizeClick(Lkotlin/jvm/functions/Function0;)V
    return-void 
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->topBar Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda14;
    invoke-direct v0, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda14;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->setOnMinimizeClick(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private static final setupTopBar$lambda$10(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)kotlin.Unit
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v1
    const-string v0, "null cannot be cast to non-null type com.bytedance.trae.conversation.brainstorm.BrainstormActivity"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->showExitConfirmDialog()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final setupTopBar$lambda$11(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->toggleSubtitleMode()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final setupTopBar$lambda$12(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)kotlin.Unit
    .registers 7
    # ins_size=1
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    const-string v1, "null cannot be cast to non-null type com.bytedance.trae.conversation.brainstorm.BrainstormActivity"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string/jumbo v1, viewModel
    const/4 v2, 0
    if-eqz v0, +00bh
    const-string v3, "extra_session_id"
    invoke-virtual v0, v3, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +003h
    goto +dh
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->getCliConversationId()Ljava/lang/String;
    move-result-object v0
    iget-object v3, v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v2
    const-string v4, "minimize_click"
    const-string v5, "normal"
    invoke-virtual v3, v4, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->reportWindowStateClick(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v3, v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v2
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->minimize(Ljava/lang/String;)Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult$Refused;
    if-eqz v1, +034h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "minimize refused: "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult$Refused;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult$Refused;->getReason()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v3, "DiscussingFragment"
    invoke-virtual v1, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->getView()Landroid/view/View;
    move-result-object v6
    instance-of v0, v6, Landroid/view/ViewGroup;
    if-eqz v0, +005h
    move-object v2, v6
    check-cast v2, Landroid/view/ViewGroup;
    if-eqz v2, +00bh
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$MinimizeRefused;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$MinimizeRefused;
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;
    invoke-virtual v6, v2, v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->enqueue(Landroid/view/ViewGroup; Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method

.method private final showAttachmentPicker()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->Companion Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$Companion;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v1, +009h
    const-string/jumbo v1, viewModel
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->getCurrentChatMode()Lcom/bytedance/trae/conversation/widget/ChatMode;
    move-result-object v1
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$Companion;->newInstance(Lcom/bytedance/trae/conversation/widget/ChatMode; Z)Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda15;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda15;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->setOnAttachmentSelected(Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    const-string v2, "getParentFragmentManager(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->showOnce(Landroidx/fragment/app/FragmentManager;)Z
    return-void 
.end method

.method private static final showAttachmentPicker$lambda$29$lambda$28(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  com.bytedance.trae.conversation.widget.ChatAttachmentDialog$AttachmentType)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string/jumbo v0, type
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->ordinal()I
    move-result v2
    aget v2, v0, v2
    const/4 v0, 1
    if-eq v2, v0, +025h
    const/4 v0, 2
    if-eq v2, v0, +01eh
    const/4 v0, 3
    if-eq v2, v0, +00fh
    const/4 v1, 4
    if-eq v2, v1, +01fh
    const/4 v1, 5
    if-ne v2, v1, +003h
    goto +1ah
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->filePickerLauncher Landroidx/activity/result/ActivityResultLauncher;
    const-string v2, "*/*"
    filled-new-array v2, [Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    goto +8h
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->launchMediaChooser()V
    goto +4h
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requestCameraThenLaunch()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final showAudioSwitchToast()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->getUiState()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getCurrentAudioDevice()Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    move-result-object v0
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;->ordinal()I
    move-result v0
    aget v0, v2, v0
    const/4 v2, 1
    if-eq v0, v2, +012h
    const/4 v3, 2
    if-ne v0, v3, +009h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_device_earpiece I
    invoke-virtual v5, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    goto +dh
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_device_speaker I
    invoke-virtual v5, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_switched_to_device I
    new-array v2, v2, [Ljava/lang/Object;
    const/4 v4, 0
    aput-object v0, v2, v4
    invoke-virtual v5, v3, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    const-string v2, "getString(...)"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->getView()Landroid/view/View;
    move-result-object v2
    instance-of v3, v2, Landroid/view/ViewGroup;
    if-eqz v3, +005h
    move-object v1, v2
    check-cast v1, Landroid/view/ViewGroup;
    if-nez v1, +003h
    return-void 
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioSwitchToast;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/widget/AudioSwitchToast;
    invoke-virtual v2, v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioSwitchToast;->show(Landroid/view/ViewGroup; Ljava/lang/String;)V
    return-void 
.end method

.method private final showScrollToBottomButton()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnScrollToBottom Landroid/widget/ImageView;
    const/4 v1, 0
    const-string v2, "btnScrollToBottom"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Landroid/widget/ImageView;->getVisibility()I
    move-result v0
    if-nez v0, +003h
    return-void 
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnScrollToBottom Landroid/widget/ImageView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v3, 0
    invoke-virtual v0, v3, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnScrollToBottom Landroid/widget/ImageView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v3, 0
    invoke-virtual v0, v3, Landroid/widget/ImageView;->setAlpha(F)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnScrollToBottom Landroid/widget/ImageView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, Landroid/widget/ImageView;->animate()Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    const/high16 v1, 1065353216
    invoke-virtual v0, v1, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    const-wide/16 v1, 200
    invoke-virtual v0, v1, v2, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    invoke-virtual v0, Landroid/view/ViewPropertyAnimator;->start()V
    return-void 
.end method

.method private static final takePictureLauncher$lambda$3(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  java.lang.Boolean)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->pendingCameraUri Landroid/net/Uri;
    const/4 v1, 0
    iput-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->pendingCameraUri Landroid/net/Uri;
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    if-eqz v3, +009h
    if-eqz v0, +007h
    const/4 v3, 2
    invoke-static v2, v0, v1, v3, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->dispatchPickedUri$default(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Landroid/net/Uri; Ljava/lang/String; I Ljava/lang/Object;)V
    goto +eh
    if-eqz v0, +00dh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    invoke-virtual v2, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v2
    invoke-virtual v2, v0, v1, v1, Landroid/content/ContentResolver;->delete(Landroid/net/Uri; Ljava/lang/String; [Ljava/lang/String;)I
    return-void 
    :try_start_0x14
.end method

.method private final updateAiDisplay(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)void
    .registers 9
    # ins_size=2
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->hasMeaningfulUserInput(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)Z
    move-result v0
    const/4 v1, 0
    const/4 v2, 1
    if-nez v0, +01ah
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAiParticipantState()Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Thinking Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    if-eq v3, v4, +012h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getBotTranscript()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/2addr v3, v2
    if-eqz v3, +003h
    goto +3h
    move v3, v1
    goto +2h
    move v3, v2
    iget-boolean v4, v7, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->hasEverBeenActive Z
    const-string/jumbo v5, tvAiStatus
    const/4 v6, 0
    if-nez v4, +013h
    if-eqz v3, +011h
    iput-boolean v2, v7, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->hasEverBeenActive Z
    iget-object v2, v7, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->tvAiStatus Landroid/widget/TextView;
    if-nez v2, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v6
    check-cast v2, Landroid/view/View;
    invoke-direct v7, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->fadeOutView(Landroid/view/View;)V
    iget-object v2, v7, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v2, +009h
    const-string/jumbo v2, viewModel
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v6
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->drainBotSubtitleChars()Ljava/lang/String;
    iget-boolean v2, v7, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->hasEverBeenActive Z
    const/16 v3, 8
    if-eqz v2, +00dh
    iget-object v2, v7, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->tvAiStatus Landroid/widget/TextView;
    if-nez v2, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v6
    invoke-virtual v2, v3, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v2, v7, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->aiSubtitleContainer Landroid/widget/FrameLayout;
    if-nez v2, +008h
    const-string v2, "aiSubtitleContainer"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v6
    invoke-virtual v2, v3, Landroid/widget/FrameLayout;->setVisibility(I)V
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->resolveBottomStatus(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, updateBottomStatus: aiState=
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAiParticipantState()Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, " userState="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getUserParticipantState()Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, " subTask="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubTask()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v5
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v5
    goto +2h
    move-object v5, v6
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, " botLen="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getBotTranscript()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/String;->length()I
    move-result v8
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v4, " target="
    invoke-virtual v8, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v4, " hasUserInput="
    invoke-virtual v8, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v0, " hasEverBeenActive="
    invoke-virtual v8, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    iget-boolean v0, v7, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->hasEverBeenActive Z
    invoke-virtual v8, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    const-string v0, "DiscussingFragment"
    invoke-virtual v3, v0, v8, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v8, 2
    invoke-static v7, v2, v1, v8, v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateBottomStatusText$default(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus; Z I Ljava/lang/Object;)V
    return-void 
.end method

.method private final updateBottomActionShadow(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$BottomShadowEntry)void
    .registers 7
    # ins_size=2
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->getShadowView()Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;
    move-result-object v0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->getTarget()Landroid/view/View;
    move-result-object v1
    invoke-virtual v1, Landroid/view/View;->getVisibility()I
    move-result v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->setVisibility(I)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->getTarget()Landroid/view/View;
    move-result-object v0
    invoke-virtual v0, Landroid/view/View;->getVisibility()I
    move-result v0
    if-nez v0, +09bh
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->getTarget()Landroid/view/View;
    move-result-object v0
    invoke-virtual v0, Landroid/view/View;->getWidth()I
    move-result v0
    if-lez v0, +091h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->getTarget()Landroid/view/View;
    move-result-object v0
    invoke-virtual v0, Landroid/view/View;->getHeight()I
    move-result v0
    if-gtz v0, +004h
    goto/16 +085h
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomActionButtonRect Landroid/graphics/Rect;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->getTarget()Landroid/view/View;
    move-result-object v1
    invoke-virtual v1, Landroid/view/View;->getWidth()I
    move-result v1
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->getTarget()Landroid/view/View;
    move-result-object v2
    invoke-virtual v2, Landroid/view/View;->getHeight()I
    move-result v2
    const/4 v3, 0
    invoke-virtual v0, v3, v3, v1, v2, Landroid/graphics/Rect;->set(I I I I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->footerContainer Landroidx/constraintlayout/widget/ConstraintLayout;
    if-nez v0, +008h
    const-string v0, "footerContainer"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->getTarget()Landroid/view/View;
    move-result-object v1
    iget-object v2, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomActionButtonRect Landroid/graphics/Rect;
    invoke-virtual v0, v1, v2, Landroidx/constraintlayout/widget/ConstraintLayout;->offsetDescendantRectToMyCoords(Landroid/view/View; Landroid/graphics/Rect;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->getShadowView()Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;
    move-result-object v0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->getTarget()Landroid/view/View;
    move-result-object v1
    invoke-virtual v1, Landroid/view/View;->getWidth()I
    move-result v1
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->getTarget()Landroid/view/View;
    move-result-object v2
    invoke-virtual v2, Landroid/view/View;->getHeight()I
    move-result v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->setContentSize(I I)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->getTarget()Landroid/view/View;
    move-result-object v0
    invoke-virtual v0, Landroid/view/View;->getWidth()I
    move-result v0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->getRadius()I
    move-result v1
    mul-int/lit8 v1, v1, 2
    add-int/2addr v0, v1
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->getTarget()Landroid/view/View;
    move-result-object v1
    invoke-virtual v1, Landroid/view/View;->getHeight()I
    move-result v1
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->getPaddingTop()I
    move-result v2
    add-int/2addr v1, v2
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->getPaddingBottom()I
    move-result v2
    add-int/2addr v1, v2
    iget-object v2, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomActionButtonRect Landroid/graphics/Rect;
    iget v2, v2, Landroid/graphics/Rect;->left I
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->getRadius()I
    move-result v3
    sub-int/2addr v2, v3
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomActionButtonRect Landroid/graphics/Rect;
    iget v3, v3, Landroid/graphics/Rect;->top I
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->getPaddingTop()I
    move-result v4
    sub-int/2addr v3, v4
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->getShadowView()Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;
    move-result-object v4
    add-int/2addr v0, v2
    add-int/2addr v1, v3
    invoke-virtual v4, v2, v3, v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->layout(I I I I)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->getShadowView()Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->invalidate()V
    return-void 
.end method

.method private final updateBottomActionShadows()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomActionShadowTargets Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;
    invoke-direct v2, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateBottomActionShadow(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;)V
    goto -fh
    return-void 
.end method

.method private final updateBottomStatusText(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$BottomStatus  boolean)void
    .registers 7
    # ins_size=3
    const/4 v0, 0
    const-string v1, "bottomStatusText"
    if-nez v6, +023h
    iget-object v6, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->curBottomStatus Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    if-ne v5, v6, +01fh
    iget-object v6, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomStatusText Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    if-nez v6, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->getText()Ljava/lang/CharSequence;
    move-result-object v6
    const-string v2, "getText(...)"
    invoke-static v6, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-lez v6, +004h
    const/4 v6, 1
    goto +2h
    const/4 v6, 0
    if-eqz v6, +003h
    return-void 
    iput-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->curBottomStatus Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    iget-object v6, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomStatusText Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    if-nez v6, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v0
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$WhenMappings;->$EnumSwitchMapping$2 [I
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->ordinal()I
    move-result v3
    aget v2, v2, v3
    packed-switch v2, +0000048h
    new-instance v5, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v5, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v5
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_bottom_status_task_done I
    goto +12h
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_bottom_status_task_running_long I
    goto +fh
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_bottom_status_task_running I
    goto +ch
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_bottom_status_answering I
    goto +9h
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_bottom_status_thinking I
    goto +6h
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_bottom_status_listening I
    goto +3h
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_bottom_status_prompt I
    invoke-virtual v6, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->setText(I)V
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->TaskRunning Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    if-eq v5, v6, +018h
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->TaskRunningLong Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    if-eq v5, v6, +014h
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;->TaskDone Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    if-ne v5, v6, +003h
    goto +eh
    iget-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomStatusText Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    if-nez v5, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v5
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->stopShimmer()V
    goto +dh
    iget-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomStatusText Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    if-nez v5, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v5
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->startShimmer()V
    return-void 
    nop 
    packed-switch-payload 1 2 3 4 5 6 7
.end method

.method static synthetic updateBottomStatusText$default(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$BottomStatus  boolean  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateBottomStatusText(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus; Z)V
    return-void 
.end method

.method private final updateContentMode(boolean)void
    .registers 16
    # ins_size=2
    iget-boolean v0, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->curIsSubtitleMode Z
    if-ne v0, v15, +003h
    return-void 
    iput-boolean v15, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->curIsSubtitleMode Z
    iget-object v0, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->topBar Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, topBar
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v15, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->setSubtitleToggleActive(Z)V
    iget-object v0, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->aiDisplaySwitcher Landroid/widget/FrameLayout;
    const-string v2, "aiDisplaySwitcher"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Landroid/widget/FrameLayout;->animate()Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    invoke-virtual v0, Landroid/view/ViewPropertyAnimator;->cancel()V
    iget-object v0, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleModeContainer Landroid/view/View;
    const-string/jumbo v3, subtitleModeContainer
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    invoke-virtual v0, Landroid/view/ViewPropertyAnimator;->cancel()V
    iget-object v0, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleModeHideRunnable Ljava/lang/Runnable;
    if-eqz v0, +007h
    iget-object v4, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->displaySwitchHandler Landroid/os/Handler;
    invoke-virtual v4, v0, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    iput-object v1, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleModeHideRunnable Ljava/lang/Runnable;
    const-wide/16 v4, 0
    const-string/jumbo v0, sphereController
    const/4 v6, 2
    const-wide/16 v7, 250
    const/high16 v9, 1065353216
    const/4 v10, 0
    const/4 v11, 0
    if-eqz v15, +083h
    sget-object v15, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    const-string/jumbo v12, subtitle_mode_enbale
    invoke-static v15, v12, v1, v6, v1, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackAsrDiscuss$default(Lcom/bytedance/trae/conversation/tracker/TraeAITracker; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->aiDisplaySwitcher Landroid/widget/FrameLayout;
    if-nez v15, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v1
    invoke-virtual v15, Landroid/widget/FrameLayout;->animate()Landroid/view/ViewPropertyAnimator;
    move-result-object v15
    invoke-virtual v15, v10, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;
    move-result-object v15
    const-wide/16 v12, 200
    invoke-virtual v15, v12, v13, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;
    move-result-object v15
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda4;
    invoke-direct v2, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    invoke-virtual v15, v2, Landroid/view/ViewPropertyAnimator;->withEndAction(Ljava/lang/Runnable;)Landroid/view/ViewPropertyAnimator;
    move-result-object v15
    invoke-virtual v15, Landroid/view/ViewPropertyAnimator;->start()V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->sphereController Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;
    if-nez v15, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v1
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->stop()V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleModeContainer Landroid/view/View;
    if-nez v15, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v1
    invoke-virtual v15, Landroid/view/View;->getVisibility()I
    move-result v15
    if-nez v15, +004h
    const/4 v15, 1
    goto +2h
    move v15, v11
    iget-object v0, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleModeContainer Landroid/view/View;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v11, Landroid/view/View;->setVisibility(I)V
    if-nez v15, +00dh
    iget-object v15, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleModeContainer Landroid/view/View;
    if-nez v15, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v1
    invoke-virtual v15, v10, Landroid/view/View;->setAlpha(F)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleModeContainer Landroid/view/View;
    if-nez v15, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v1
    invoke-virtual v15, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;
    move-result-object v15
    invoke-virtual v15, v9, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;
    move-result-object v15
    invoke-virtual v15, v4, v5, Landroid/view/ViewPropertyAnimator;->setStartDelay(J)Landroid/view/ViewPropertyAnimator;
    move-result-object v15
    invoke-virtual v15, v7, v8, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;
    move-result-object v15
    invoke-virtual v15, v1, Landroid/view/ViewPropertyAnimator;->withEndAction(Ljava/lang/Runnable;)Landroid/view/ViewPropertyAnimator;
    move-result-object v15
    invoke-virtual v15, Landroid/view/ViewPropertyAnimator;->start()V
    invoke-direct v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateSubtitleTopGradient()V
    goto +6ah
    sget-object v15, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    const-string/jumbo v12, subtitle_mode_disable
    invoke-static v15, v12, v1, v6, v1, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackAsrDiscuss$default(Lcom/bytedance/trae/conversation/tracker/TraeAITracker; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    iput-boolean v11, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->isUserScrolling Z
    iget-object v15, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleModeContainer Landroid/view/View;
    if-nez v15, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v1
    invoke-virtual v15, v11, Landroid/view/View;->setVisibility(I)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleModeContainer Landroid/view/View;
    if-nez v15, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v1
    invoke-virtual v15, v9, Landroid/view/View;->setAlpha(F)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->aiDisplaySwitcher Landroid/widget/FrameLayout;
    if-nez v15, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v1
    invoke-virtual v15, v11, Landroid/widget/FrameLayout;->setVisibility(I)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->aiDisplaySwitcher Landroid/widget/FrameLayout;
    if-nez v15, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v1
    invoke-virtual v15, v10, Landroid/widget/FrameLayout;->setAlpha(F)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->aiDisplaySwitcher Landroid/widget/FrameLayout;
    if-nez v15, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v1
    invoke-virtual v15, Landroid/widget/FrameLayout;->animate()Landroid/view/ViewPropertyAnimator;
    move-result-object v15
    invoke-virtual v15, v9, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;
    move-result-object v15
    invoke-virtual v15, v4, v5, Landroid/view/ViewPropertyAnimator;->setStartDelay(J)Landroid/view/ViewPropertyAnimator;
    move-result-object v15
    invoke-virtual v15, v7, v8, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;
    move-result-object v15
    invoke-virtual v15, Landroid/view/ViewPropertyAnimator;->start()V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->sphereController Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;
    if-nez v15, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v15
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->start()V
    new-instance v15, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda5;
    invoke-direct v15, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    iput-object v15, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleModeHideRunnable Ljava/lang/Runnable;
    iget-object v0, v14, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->displaySwitchHandler Landroid/os/Handler;
    invoke-virtual v0, v15, v7, v8, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method private static final updateContentMode$lambda$69(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)void
    .registers 2
    # ins_size=1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->aiDisplaySwitcher Landroid/widget/FrameLayout;
    if-nez v1, +008h
    const-string v1, "aiDisplaySwitcher"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    const/4 v0, 4
    invoke-virtual v1, v0, Landroid/widget/FrameLayout;->setVisibility(I)V
    return-void 
.end method

.method private static final updateContentMode$lambda$70(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)void
    .registers 5
    # ins_size=1
    iget-boolean v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->curIsSubtitleMode Z
    const/4 v1, 0
    if-nez v0, +03ah
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleTopGradient Landroid/view/View;
    if-nez v0, +009h
    const-string/jumbo v0, subtitleTopGradient
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnScrollToBottom Landroid/widget/ImageView;
    if-nez v0, +008h
    const-string v0, "btnScrollToBottom"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleModeContainer Landroid/view/View;
    const-string/jumbo v3, subtitleModeContainer
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleModeContainer Landroid/view/View;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/high16 v2, 1065353216
    invoke-virtual v0, v2, Landroid/view/View;->setAlpha(F)V
    iput-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleModeHideRunnable Ljava/lang/Runnable;
    return-void 
.end method

.method private final updateMicUi(boolean)void
    .registers 7
    # ins_size=2
    iget-boolean v0, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->curIsMicMuted Z
    if-ne v0, v6, +003h
    return-void 
    iput-boolean v6, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->curIsMicMuted Z
    const-string v0, "mainWaveform"
    const-string v1, "btnMic"
    const/4 v2, 0
    if-eqz v6, +031h
    iget-object v6, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnMic Landroid/widget/Button;
    if-nez v6, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireContext()Landroid/content/Context;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_brainstorm_mic_off I
    invoke-static v3, v4, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context; I)Landroid/graphics/drawable/Drawable;
    move-result-object v3
    invoke-virtual v6, v3, Landroid/widget/Button;->setForeground(Landroid/graphics/drawable/Drawable;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnMic Landroid/widget/Button;
    if-nez v6, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v2
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_brainstorm_circle_button_white I
    invoke-virtual v6, v1, Landroid/widget/Button;->setBackgroundResource(I)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->mainWaveform Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    if-nez v6, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v6
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->stopAnimating()V
    goto +2fh
    iget-object v6, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnMic Landroid/widget/Button;
    if-nez v6, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireContext()Landroid/content/Context;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_brainstorm_mic I
    invoke-static v3, v4, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context; I)Landroid/graphics/drawable/Drawable;
    move-result-object v3
    invoke-virtual v6, v3, Landroid/widget/Button;->setForeground(Landroid/graphics/drawable/Drawable;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->btnMic Landroid/widget/Button;
    if-nez v6, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v2
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_brainstorm_circle_button_white I
    invoke-virtual v6, v1, Landroid/widget/Button;->setBackgroundResource(I)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->mainWaveform Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    if-nez v6, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v6
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->startAnimating()V
    return-void 
.end method

.method private final updateParticipantStates(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)void
    .registers 6
    # ins_size=2
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->resolveSphereState(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, updateParticipantStates: aiState=
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAiParticipantState()Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", userState="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getUserParticipantState()Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", subTask="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubTask()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v5
    const/4 v3, 0
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v5
    goto +2h
    move-object v5, v3
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v2, ", jsState="
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string v2, "DiscussingFragment"
    invoke-virtual v1, v2, v5, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->curSphereState Ljava/lang/String;
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +013h
    iput-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->curSphereState Ljava/lang/String;
    iget-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->sphereController Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;
    if-nez v5, +009h
    const-string/jumbo v5, sphereController
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v5
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->setState(Ljava/lang/String;)V
    return-void 
.end method

.method private final updateSubtitleEmptyHint(boolean)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleEmptyHint Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    if-nez v0, +009h
    const-string/jumbo v0, subtitleEmptyHint
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    if-eqz v2, +004h
    const/4 v2, 0
    goto +3h
    const/16 v2, 8
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->setVisibility(I)V
    return-void 
.end method

.method private final updateSubtitleList(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)void
    .registers 32
    # ins_size=2
    move-object/from16 v7, v30
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAttachments()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    const/16 v2, 10
    invoke-static v0, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v1, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +010h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v2
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toHashSet(Ljava/lang/Iterable;)Ljava/util/HashSet;
    move-result-object v0
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAttachments()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +00eh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->historySubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;
    invoke-virtual v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->appendOrUpdateAttachment(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)V
    goto -11h
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->historySubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;
    check-cast v0, Ljava/util/Set;
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->pruneAttachmentsExcept(Ljava/util/Set;)V
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubtitleHistory()Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v1
    invoke-interface v0, v1, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/ListIterator;->hasPrevious()Z
    move-result v1
    const/4 v8, 0
    const/4 v9, 1
    const/4 v10, 0
    if-eqz v1, +017h
    invoke-interface v0, Ljava/util/ListIterator;->previous()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getRole()Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;->Assistant Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    if-ne v2, v3, +004h
    move v2, v9
    goto +2h
    move v2, v8
    if-eqz v2, -01bh
    goto +2h
    move-object v1, v10
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->historySubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getBotTranscript()Ljava/lang/String;
    move-result-object v2
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getId()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v10
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getAttachedSubTaskId()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v10
    invoke-virtual v0, v2, v3, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->setLiveBot(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubtitleHistory()Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v1
    invoke-interface v0, v1, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/ListIterator;->hasPrevious()Z
    move-result v1
    if-eqz v1, +017h
    invoke-interface v0, Ljava/util/ListIterator;->previous()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getRole()Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;->User Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    if-ne v2, v3, +004h
    move v2, v9
    goto +2h
    move v2, v8
    if-eqz v2, -018h
    goto +2h
    move-object v1, v10
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v10
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->historySubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getCurrentTranscript()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->setLiveUser(Ljava/lang/String; Ljava/lang/String;)Z
    move-result v11
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubtitleHistory()Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +0a2h
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v13, v0
    check-cast v13, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getAttachedSubTaskId()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto -13h
    invoke-virtual v13, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getSubTaskTerminalState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v6
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubTask()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v0
    if-eqz v0, +00dh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v0, v10
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getFinishedSubTasks()Ljava/util/Map;
    move-result-object v1
    invoke-interface v1, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    if-eqz v6, +02ah
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    const-string v16, ""
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v21, 0
    invoke-virtual v13, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getSubTaskFailureReason()Ljava/lang/String;
    move-result-object v22
    const-wide/16 v23, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 3932
    const/16 v29, 0
    move-object v14, v0
    move-object v15, v2
    move-object/from16 v20, v6
    invoke-direct/range v14 ... v29, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const-string/jumbo v1, terminal-stamped
    move-object v3, v1
    goto +32h
    if-eqz v0, +006h
    const-string v1, "active"
    move-object v14, v0
    goto -7h
    if-eqz v1, +007h
    const-string v0, "finished-cache"
    move-object v3, v0
    move-object v14, v1
    goto +25h
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    const-string v16, ""
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    sget-object v20, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Creating Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    const/16 v21, 0
    const/16 v22, 0
    const-wide/16 v23, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 4060
    const/16 v29, 0
    move-object v14, v0
    move-object v15, v2
    invoke-direct/range v14 ... v29, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState; Ljava/lang/String; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const-string v1, "placeholder"
    goto -32h
    invoke-virtual v13, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getId()Ljava/lang/String;
    move-result-object v1
    move-object/from16 v0, v30
    move-object v4, v14
    move-object/from16 v5, v31
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->logSubTaskBadgeRoute(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->historySubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, v14, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->updateSubTaskBadgeOnMessage(Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;)V
    goto/16 -0a4h
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->historySubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAiParticipantState()Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->Thinking Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    if-ne v1, v2, +010h
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getBotTranscript()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +004h
    move v1, v9
    goto +2h
    move v1, v8
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->setThinkingVisible(Z)Z
    move-result v0
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->historySubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;
    invoke-virtual v1, v10, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->setFooter(Ljava/lang/String;)V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->historySubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->getTotalItemCount()I
    move-result v1
    if-nez v1, +003h
    move v8, v9
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateSubtitleEmptyHint(Z)V
    const-string/jumbo v2, rvHistorySubtitle
    if-nez v11, +004h
    if-eqz v0, +015h
    if-lez v1, +013h
    iget-boolean v0, v7, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->isDragging Z
    if-nez v0, +00fh
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->rvHistorySubtitle Landroidx/recyclerview/widget/RecyclerView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v10
    add-int/lit8 v3, v1, -1
    invoke-virtual v0, v3, Landroidx/recyclerview/widget/RecyclerView;->smoothScrollToPosition(I)V
    invoke-virtual/range v31, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isSubtitleMode()Z
    move-result v0
    if-eqz v0, +015h
    if-lez v1, +013h
    iget-boolean v0, v7, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->isUserScrolling Z
    if-nez v0, +00fh
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->rvHistorySubtitle Landroidx/recyclerview/widget/RecyclerView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v10, v0
    sub-int/2addr v1, v9
    invoke-virtual v10, v1, Landroidx/recyclerview/widget/RecyclerView;->scrollToPosition(I)V
    return-void 
.end method

.method private final updateSubtitleListIfNeeded(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)void
    .registers 12
    # ins_size=2
    new-instance v9, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubtitleHistory()Ljava/util/List;
    move-result-object v1
    invoke-virtual v11, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAttachments()Ljava/util/List;
    move-result-object v2
    invoke-virtual v11, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubTask()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v3
    invoke-virtual v11, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getFinishedSubTasks()Ljava/util/Map;
    move-result-object v4
    invoke-virtual v11, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getBotTranscript()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v11, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getCurrentTranscript()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v11, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAiParticipantState()Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    move-result-object v7
    invoke-virtual v11, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->isSubtitleMode()Z
    move-result v8
    move-object v0, v9
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;-><init>(Ljava/util/List; Ljava/util/List; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Z)V
    iget-object v0, v10, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->lastSubtitleRenderSnapshot Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    iput-object v9, v10, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->lastSubtitleRenderSnapshot Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;
    invoke-direct v10, v11, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateSubtitleList(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)V
    return-void 
.end method

.method private final updateSubtitleTopGradient()void
    .registers 5
    # ins_size=1
    iget-boolean v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->curIsSubtitleMode Z
    const/4 v1, 0
    const/4 v2, 0
    if-eqz v0, +016h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->rvHistorySubtitle Landroidx/recyclerview/widget/RecyclerView;
    if-nez v0, +009h
    const-string/jumbo v0, rvHistorySubtitle
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v3, -1
    invoke-virtual v0, v3, Landroidx/recyclerview/widget/RecyclerView;->canScrollVertically(I)Z
    move-result v0
    if-eqz v0, +004h
    const/4 v0, 1
    goto +2h
    move v0, v2
    iget-object v3, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleTopGradient Landroid/view/View;
    if-nez v3, +009h
    const-string/jumbo v3, subtitleTopGradient
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    if-eqz v0, +003h
    goto +3h
    const/16 v2, 8
    invoke-virtual v1, v2, Landroid/view/View;->setVisibility(I)V
    return-void 
.end method

.method private final updateTaskDoneHold(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)void
    .registers 10
    # ins_size=2
    invoke-static Lkotlin/collections/CollectionsKt;->createListBuilder()Ljava/util/List;
    move-result-object v0
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubTask()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v1, +01ah
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v5
    sget-object v6, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Done Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    if-ne v5, v6, +004h
    move v5, v4
    goto +2h
    move v5, v3
    if-eqz v5, +003h
    goto +2h
    move-object v1, v2
    if-eqz v1, +009h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getFinishedSubTasks()Ljava/util/Map;
    move-result-object v9
    invoke-interface v9, Ljava/util/Map;->values()Ljava/util/Collection;
    move-result-object v9
    check-cast v9, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v9
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +01ah
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object v6, v5
    check-cast v6, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getState()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v6
    sget-object v7, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->Done Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    if-ne v6, v7, +004h
    move v6, v4
    goto +2h
    move v6, v3
    if-eqz v6, -018h
    invoke-interface v1, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v9
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +010h
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getSourceTaskId()Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -13h
    invoke-static v0, Lkotlin/collections/CollectionsKt;->build(Ljava/util/List;)Ljava/util/List;
    move-result-object v9
    check-cast v9, Ljava/lang/Iterable;
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v9
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +013h
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->seenBottomTerminalTaskIds Ljava/util/Set;
    invoke-interface v3, v1, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v1
    xor-int/2addr v1, v4
    if-eqz v1, -014h
    move-object v2, v0
    check-cast v2, Ljava/lang/String;
    if-nez v2, +003h
    return-void 
    iget-object v9, v8, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->seenBottomTerminalTaskIds Ljava/util/Set;
    check-cast v9, Ljava/util/Collection;
    invoke-interface v9, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    iput-object v2, v8, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomTaskDoneTaskId Ljava/lang/String;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    iget-wide v3, v8, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->taskDoneHoldMs J
    add-long/2addr v0, v3
    iput-wide v0, v8, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomTaskDoneUntilMs J
    iget-object v9, v8, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomTaskDoneClearRunnable Ljava/lang/Runnable;
    if-eqz v9, +007h
    iget-object v0, v8, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->displaySwitchHandler Landroid/os/Handler;
    invoke-virtual v0, v9, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    new-instance v9, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda2;
    invoke-direct v9, v8, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Ljava/lang/String;)V
    iput-object v9, v8, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomTaskDoneClearRunnable Ljava/lang/Runnable;
    iget-object v0, v8, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->displaySwitchHandler Landroid/os/Handler;
    iget-wide v1, v8, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->taskDoneHoldMs J
    invoke-virtual v0, v9, v1, v2, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method private static final updateTaskDoneHold$lambda$66(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment  java.lang.String)void
    .registers 7
    # ins_size=2
    const/4 v0, 0
    iput-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomTaskDoneClearRunnable Ljava/lang/Runnable;
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomTaskDoneTaskId Ljava/lang/String;
    invoke-static v1, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +02ah
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    iget-wide v3, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomTaskDoneUntilMs J
    cmp-long v6, v1, v3
    if-ltz v6, +020h
    iget-object v6, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    if-nez v6, +009h
    const-string/jumbo v6, viewModel
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v6
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->getUiState()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v6
    invoke-interface v6, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->resolveBottomStatus(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;)Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus;
    move-result-object v6
    const/4 v0, 1
    invoke-direct v5, v6, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->updateBottomStatusText(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomStatus; Z)V
    return-void 
.end method

.method private final updateTimeoutState(com.bytedance.trae.conversation.brainstorm.model.TimeoutState  int)void
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->topBar Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;
    if-nez v0, +009h
    const-string/jumbo v0, topBar
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->updateTimeoutState(Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->curTimeoutState Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    return-void 
.end method

.method private final updateTimer(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)void
    .registers 6
    # ins_size=2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSessionElapsedMs()J
    move-result-wide v0
    const/16 v5, 1000
    int-to-long v2, v5
    div-long v2, v0, v2
    long-to-int v5, v2
    iget v2, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->curTimerSeconds I
    if-ne v2, v5, +003h
    return-void 
    iput v5, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->curTimerSeconds I
    iget-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->topBar Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;
    if-nez v5, +009h
    const-string/jumbo v5, topBar
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v5, 0
    invoke-virtual v5, v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->updateTimer(J)V
    return-void 
.end method

.method private final updateWaveformAnimating(boolean)void
    .registers 4
    # ins_size=2
    const/4 v0, 0
    const-string v1, "mainWaveform"
    if-eqz v3, +013h
    iget-boolean v3, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->curIsMicMuted Z
    if-nez v3, +00fh
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->mainWaveform Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v3
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->startAnimating()V
    goto +dh
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->mainWaveform Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v3
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->stopAnimating()V
    return-void 
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->trae_fragment_brainstorm_discuss I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onDestroyView()void
    .registers 4
    # ins_size=1
    invoke-super v3, Landroidx/fragment/app/Fragment;->onDestroyView()V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->pendingDisplaySwitch Ljava/lang/Runnable;
    if-eqz v0, +007h
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->displaySwitchHandler Landroid/os/Handler;
    invoke-virtual v1, v0, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    const/4 v0, 0
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->pendingDisplaySwitch Ljava/lang/Runnable;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomTaskDoneClearRunnable Ljava/lang/Runnable;
    if-eqz v1, +007h
    iget-object v2, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->displaySwitchHandler Landroid/os/Handler;
    invoke-virtual v2, v1, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomTaskDoneClearRunnable Ljava/lang/Runnable;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->taskRunningLongRunnable Ljava/lang/Runnable;
    if-eqz v1, +007h
    iget-object v2, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->displaySwitchHandler Landroid/os/Handler;
    invoke-virtual v2, v1, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->taskRunningLongRunnable Ljava/lang/Runnable;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleModeHideRunnable Ljava/lang/Runnable;
    if-eqz v1, +007h
    iget-object v2, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->displaySwitchHandler Landroid/os/Handler;
    invoke-virtual v2, v1, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleModeHideRunnable Ljava/lang/Runnable;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bottomStatusText Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    if-nez v1, +008h
    const-string v1, "bottomStatusText"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v0
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->stopShimmer()V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->subtitleEmptyHint Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;
    if-nez v1, +009h
    const-string/jumbo v1, subtitleEmptyHint
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v0
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;->stopShimmer()V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->mainWaveform Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    if-nez v1, +008h
    const-string v1, "mainWaveform"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v0
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->stopAnimating()V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->sphereController Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;
    if-nez v1, +009h
    const-string/jumbo v1, sphereController
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v0
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->destroy()V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->enterMediaPlayer Landroid/media/MediaPlayer;
    if-eqz v1, +025h
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v1, Landroid/media/MediaPlayer;->isPlaying()Z
    move-result v2
    if-eqz v2, +005h
    invoke-virtual v1, Landroid/media/MediaPlayer;->stop()V
    invoke-virtual v1, Landroid/media/MediaPlayer;->release()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    goto +ch
    move-exception v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->box-impl(Ljava/lang/Object;)Lkotlin/Result;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->enterMediaPlayer Landroid/media/MediaPlayer;
    return-void 
    :try_start_0x6a
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v2, v3, v4, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    new-instance v4, Landroidx/lifecycle/ViewModelProvider;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    const-string/jumbo v1, requireActivity(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroidx/lifecycle/ViewModelStoreOwner;
    invoke-direct v4, v0, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V
    const-class v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-virtual v4, v0, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    iput-object v4, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->viewModel Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->bindViews(Landroid/view/View;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->setupBottomStatusView()V
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->setupTopBar()V
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->setupSphereWebView()V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->setupBottomButtons(Landroid/view/View;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->setupSubtitleRecyclerView()V
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->seedSubtitleHistoryFromState()V
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->observeState()V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v4
    instance-of v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    if-eqz v0, +005h
    check-cast v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    goto +2h
    const/4 v4, 0
    const/4 v0, 0
    if-eqz v4, +00ah
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->isRestoredFromMinimized()Z
    move-result v4
    const/4 v1, 1
    if-ne v4, v1, +003h
    move v0, v1
    if-nez v0, +014h
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->playEnterSound()V
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    const-string/jumbo v1, requireContext(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;->playSoftImpact(Landroid/content/Context;)V
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceExceptionGuard;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoiceExceptionGuard;
    check-cast v3, Landroid/view/ViewGroup;
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;->DISCUSSING_ENTERED Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
    invoke-virtual v4, v3, v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceExceptionGuard;->checkAndToast(Landroid/view/ViewGroup; Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;)Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;
    return-void 
.end method
