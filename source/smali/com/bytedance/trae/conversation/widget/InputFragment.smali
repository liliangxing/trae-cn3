# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/InputFragment;
.super Landroidx/fragment/app/Fragment;
.source "InputFragment.kt"

.field private static final CUSTOM_LONG_PRESS_TIMEOUT_MS:J
.field public static final Companion:Lcom/bytedance/trae/conversation/widget/InputFragment$Companion;
.field private static final HOLD_TO_TALK_DEBOUNCE_MS:J
.field private static final KEY_DEVICE_TIPS_SHOWN:Ljava/lang/String;
.field private static final PLEASE_SPEAK_DELAY_MS:J
.field private static final REQUEST_CODE_RECORD_AUDIO:I
.field public static final TAG:Ljava/lang/String;
.field private TAG$1:Ljava/lang/String;
.field private _binding:Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
.field private asrCount:I
.field private final benefitSwitchListener:Lcom/bytedance/trae/conversation/widget/InputFragment$benefitSwitchListener$1;
.field private bottomBarVisible:Z
.field private final cameraPermissionLauncher:Landroidx/activity/result/ActivityResultLauncher;
.field private final contextualBarVisibilityState:Lcom/bytedance/trae/conversation/widget/InputContextualBarVisibilityState;
.field private currentCliType:Lcom/bytedance/trae/im/service/CliType;
.field private currentConversationId:Ljava/lang/String;
.field private currentDevice:Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
.field private currentInputState:Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
.field private currentMode:Lcom/bytedance/trae/conversation/widget/ChatMode;
.field private deviceTipsPopWindow:Landroid/widget/PopupWindow;
.field private expressPassPopDismissRunnable:Ljava/lang/Runnable;
.field private expressPassPopWindow:Landroid/widget/PopupWindow;
.field private expressPassTogglePopWindow:Landroid/widget/PopupWindow;
.field private final filePickerLauncher:Landroidx/activity/result/ActivityResultLauncher;
.field private gitViewModel:Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
.field private hasMultipleProducts:Z
.field private holdToTalkState:Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
.field private infinite:Z
.field private initInputText:Ljava/lang/String;
.field private final inputKeyboardLayoutListener:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;
.field private final inputViewModel$delegate:Lkotlin/Lazy;
.field private isCheckingSkillProject:Z
.field private isExpressPassVisible:Z
.field private isKeyboardListenerRegistered:Z
.field private isKeyboardVisible:Z
.field private isKeyboardVisibleForTemplates:Z
.field private isLongPressCancelled:Z
.field private isLongPressRecording:Z
.field private isNewConversation:Z
.field private isTaskRunning:Lkotlin/jvm/functions/Function0;
.field private final keyboardLayoutListener:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;
.field private lastHoldToTalkPressTime:J
.field private final longPressHandler:Landroid/os/Handler;
.field private longPressRunnable:Ljava/lang/Runnable;
.field private final mediaChooseLauncher:Landroidx/activity/result/ActivityResultLauncher;
.field private needTranscript:Z
.field private onAttachmentSelected:Lkotlin/jvm/functions/Function1;
.field private onAuthFailed:Lkotlin/jvm/functions/Function0;
.field private onChatNewClick:Lkotlin/jvm/functions/Function0;
.field private onCloudClick:Lkotlin/jvm/functions/Function0;
.field private onDeviceClick:Lkotlin/jvm/functions/Function0;
.field private onFileSelected:Lkotlin/jvm/functions/Function1;
.field private onGitHubClick:Lkotlin/jvm/functions/Function0;
.field private onImageSelected:Lkotlin/jvm/functions/Function1;
.field private onInputFocus:Lkotlin/jvm/functions/Function0;
.field private onMaximizeBrainstormClick:Lkotlin/jvm/functions/Function0;
.field private onPauseClickListener:Lkotlin/jvm/functions/Function0;
.field private onReady:Lkotlin/jvm/functions/Function0;
.field private onRecordingStateChanged:Lkotlin/jvm/functions/Function1;
.field private onRequestSkillProjectCheck:Lkotlin/jvm/functions/Function1;
.field private onSelectedDeviceChanged:Lkotlin/jvm/functions/Function1;
.field private onSendAudioText:Lkotlin/jvm/functions/Function2;
.field private onSendText:Lkotlin/jvm/functions/Function1;
.field private onSwitchMode:Lkotlin/jvm/functions/Function1;
.field private onTemplateClick:Lkotlin/jvm/functions/Function1;
.field private pendingCameraUri:Landroid/net/Uri;
.field private final remainingChangedListener:Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$OnRemainingChangedListener;
.field private selectedRemoteModel:Lcom/bytedance/trae/conversation/network/RemoteModelItem;
.field private final takePictureLauncher:Landroidx/activity/result/ActivityResultLauncher;
.field private taskTemplateAdapter:Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter;
.field private taskTemplatesRecyclerView:Landroidx/recyclerview/widget/RecyclerView;
.field private tooltipArrowRunnable:Ljava/lang/Runnable;
.field private tooltipDismissRunnable:Ljava/lang/Runnable;
.field private tooltipPopView:Landroid/view/View;
.field private final voiceChatListener:Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;
.field private voiceChatSessionManager:Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
.field private voiceLoadingView:Landroid/view/View;
.field private voiceRecordingOverlay:Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;


.method public static synthetic $r8$lambda$-SYfsRWa_F9sXLiSnAhZhOsbE1w(com.bytedance.trae.conversation.widget.InputFragment  boolean  long  long)void
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->remainingChangedListener$lambda$2$lambda$1(Lcom/bytedance/trae/conversation/widget/InputFragment; Z J J)V
    return-void 
.end method

.method public static synthetic $r8$lambda$1-YkAL1T_1noLOAuve9FuVlf5So(com.bytedance.trae.conversation.widget.InputFragment  androidx.activity.result.ActivityResult)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->mediaChooseLauncher$lambda$8(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroidx/activity/result/ActivityResult;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$3PkxPNSEG_f-tcSTxm6QSYzjQXU(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.network.TaskTemplateRepository$TaskTemplateModel)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->showTaskTemplates$lambda$74(Lcom/bytedance/trae/conversation/widget/InputFragment; Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$4Wqv6vpU0kDgi-oe1kwi7ZASPcA(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.git.GitRepoItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupGitObservers$lambda$23(Lcom/bytedance/trae/conversation/widget/InputFragment; Lcom/bytedance/trae/conversation/git/GitRepoItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$4cxrAgfLTeQe82gu8c6DUHSXwLs(com.bytedance.trae.conversation.widget.InputFragment)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->showExpressPassToggleTooltip$lambda$109(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$51NsNlJlw4A0bEmbJJXOqIdVDmk(com.bytedance.trae.conversation.widget.InputFragment  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupFileTooLargeObserver$lambda$16(Lcom/bytedance/trae/conversation/widget/InputFragment; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$6W9th1UHq2hJ5YG9EDXdZjsICD4(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$40(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$86aaXQ0PyUoNQJWaYsHCD2xR6l0(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$35(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$8qSqNU5Y85UO9z1hRkNTmV5AVE4(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.widget.AttachmentItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupAttachmentsRecyclerView$lambda$18(Lcom/bytedance/trae/conversation/widget/InputFragment; Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$9vXzlv5PhaDO2yRNpGtNYvIuJUo(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.git.GitConnectionState)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupGitObservers$lambda$22(Lcom/bytedance/trae/conversation/widget/InputFragment; Lcom/bytedance/trae/conversation/git/GitConnectionState;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ALQIOKlpcuow_l5yxLvXlRBkMSg(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.network.SkillItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->showSkillsBottomSheet$lambda$68(Lcom/bytedance/trae/conversation/widget/InputFragment; Lcom/bytedance/trae/conversation/network/SkillItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$BAQ7SHorQs88u7lyr4g6yPmYPxQ(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.git.GitRepoItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$58$lambda$57$lambda$55(Lcom/bytedance/trae/conversation/widget/InputFragment; Lcom/bytedance/trae/conversation/git/GitRepoItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$CKgb6quububzsJndWUHJBA2B8Rg(com.bytedance.trae.conversation.widget.InputFragment  java.util.List)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupInputWatcher$lambda$21(Lcom/bytedance/trae/conversation/widget/InputFragment; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$CNvrZRTSaX2NQlOJLn1-WWpxZzc(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$63(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$EALLn0M3aOeB_UboRc2DVbUlunM(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupExpressPassBenefit$lambda$17(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$EKUHxmruAt0V9j_dyTjY7VGcHtI(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$39(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$GNk-fQDHVZJJfIln3wwaYHD_-OQ(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$50(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Ga4LLevyMyWh7AcCfalN7UuHAHI(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$61(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$LuUHCYkIVGTtVhIbswhNIl83D6o(com.bytedance.trae.conversation.widget.InputFragment)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->inputKeyboardLayoutListener$lambda$3(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$MO-a9-ux7CTdVNS_13pssjdocB0(com.bytedance.trae.conversation.widget.InputFragment  java.util.List)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$54$lambda$53$lambda$51(Lcom/bytedance/trae/conversation/widget/InputFragment; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$M_N5D4grA7JOchBNBRGa42iMpSw(com.bytedance.trae.conversation.widget.InputFragment)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->keyboardLayoutListener$lambda$4(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$PHcp8_5iohuaXaRb6FishGZU7SQ(com.bytedance.trae.conversation.widget.InputFragment)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$48$lambda$46(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Rzmwogsf5Km0jFYv19MmPyEmFxU(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.network.RemoteModelItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$54$lambda$53$lambda$52(Lcom/bytedance/trae/conversation/widget/InputFragment; Lcom/bytedance/trae/conversation/network/RemoteModelItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$SO60K7-MJmseE52VmuDPEvBO3W8(android.widget.PopupWindow)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->dismissDeviceTipsPopWindow$lambda$116(Landroid/widget/PopupWindow;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$SYAW3QXZhFNjRkgvvn8Xc2nbhsk(com.bytedance.trae.conversation.widget.InputFragment  java.lang.Boolean)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->takePictureLauncher$lambda$7(Lcom/bytedance/trae/conversation/widget/InputFragment; Ljava/lang/Boolean;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Tc2r8W2rhY6h2Wl7-ZyuWxy8o4M(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->showExpressPassPopWindow$lambda$100(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$U0E_d1oxOxV_zbHrzQg5Sf_U5GA(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$41(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$VH-ls3tmCx9e6h2Kms1qyMjajNM(com.bytedance.trae.conversation.widget.InputFragment  android.widget.ImageView  android.view.View  float)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->showExpressPassToggleTooltip$lambda$108(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/widget/ImageView; Landroid/view/View; F)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Wdnc5tdit_wGVqEQDKhaNG8CLwM(com.bytedance.trae.conversation.widget.InputFragment  java.util.List)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->filePickerLauncher$lambda$11(Lcom/bytedance/trae/conversation/widget/InputFragment; Ljava/util/List;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Zpdc22gR1OBuCIsCzJqclypBo70(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$25(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$_z0keMowc0FUUAGENUFEbYpPIO4(com.bytedance.trae.conversation.widget.InputFragment  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$49(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$bhOZVoFRlDPZyelLsngd34btF8U(com.bytedance.trae.conversation.widget.InputFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$35$lambda$34$lambda$33$lambda$32(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$dHcGembzJZttbGd7miMbhsZb5hg(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.widget.AttachmentItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupAttachmentsRecyclerView$lambda$19(Lcom/bytedance/trae/conversation/widget/InputFragment; Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$gAerkVayly0AmZxJ0R-DE0uCqrQ(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->showDeviceTipsPopWindow$lambda$113(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$hF65EuSYrnhux1QEcSiMH2Ia80s(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$43(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/view/View;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$i8jxYm6MYCbrHu9BSs3S08AqRRc(com.bytedance.trae.conversation.widget.InputFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$58$lambda$57$lambda$56(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$iHQskepQRY_IqrsD85z7va29pKE(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$38(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$iNxQsVj3oJUU6Vfd8LOeNF2tBsc(com.bytedance.trae.conversation.widget.InputFragment  java.lang.Boolean)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->cameraPermissionLauncher$lambda$5(Lcom/bytedance/trae/conversation/widget/InputFragment; Ljava/lang/Boolean;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$iTlyERx4aK60UPUN9hhmcpRq1AE(com.bytedance.trae.conversation.widget.InputFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->ensureRecordAudioPermission$lambda$94(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$iwvbYnSRWQ35CsytynerbsnM3cw(com.bytedance.trae.conversation.widget.InputFragment  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$48(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$lkVdaCFalCBoQ2BIt0xpv-I6OOs(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$45(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/view/View;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$lvLsqHqdyqt8PTwWDwRxrqX29po(com.bytedance.trae.conversation.widget.InputFragment  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$44(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$mQLM6jU74vm_nQ28Qcx4ef2sunA(com.bytedance.trae.conversation.widget.InputFragment  android.view.View  boolean)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->onViewCreated$lambda$13(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/view/View; Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$mRa828J6gvC017Uf8UeOlglkKtU(com.bytedance.trae.conversation.widget.InputFragment  java.lang.String  kotlin.Unit)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupFileTooLargeObserver$lambda$14(Lcom/bytedance/trae/conversation/widget/InputFragment; Ljava/lang/String; Lkotlin/Unit;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$mfUAf2VpN1lCyrHACQYzTp6PSrc(com.bytedance.trae.conversation.widget.InputFragment  long  long  boolean)void
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->remainingChangedListener$lambda$2(Lcom/bytedance/trae/conversation/widget/InputFragment; J J Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$mpwjVdT8FDauMCee3oJl0c57LDE(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$54(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$oEm9nx723j76jpSyHS5WiK5BDfg(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$62(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$osS_hdzoP1fDrqc_l79ZlBvWdDo(com.bytedance.trae.conversation.widget.InputFragment  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$42(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$pB6AIKOscO4zmXiHXZlOgUHoJO4(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.git.BranchItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$61$lambda$60$lambda$59(Lcom/bytedance/trae/conversation/widget/InputFragment; Lcom/bytedance/trae/conversation/git/BranchItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$pZ-xfHYXWvFCogSL69XlpxdZzUw(com.bytedance.trae.conversation.widget.InputFragment)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->showExpressPassPopWindow$lambda$102(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$q5ZOntE-ylijlI-4UPbJ7FSxkPc(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$26(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$qYJYX6fIcbUMIQJ7qTkxiuBNJdA(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.devices.SelectedDeviceItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->checkHistoricalIdeProjectThenShowSkills$lambda$65(Lcom/bytedance/trae/conversation/widget/InputFragment; Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$qekqcDsAc2WF3BpsKLnZYGNPOts(com.bytedance.trae.conversation.widget.InputAttachmentAdapter  com.bytedance.trae.conversation.widget.InputFragment  java.util.List)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupAttachmentsRecyclerView$lambda$20(Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter; Lcom/bytedance/trae/conversation/widget/InputFragment; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$si-PohAB5rB-iUrZAznFET6nmWU(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$58(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$skyNPrvIHALCUrtXiZvhWBPfcU4(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.network.PluginItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$35$lambda$34$lambda$33$lambda$29(Lcom/bytedance/trae/conversation/widget/InputFragment; Lcom/bytedance/trae/conversation/network/PluginItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$t-L92Fs0RaBlsMs70Egn75aT-ns(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.git.BranchItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupGitObservers$lambda$24(Lcom/bytedance/trae/conversation/widget/InputFragment; Lcom/bytedance/trae/conversation/git/BranchItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$uNKhy8QQZxZt0M9-wPICJgY_NV0(com.bytedance.trae.conversation.widget.InputFragment  java.lang.String  kotlin.Unit)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupFileTooLargeObserver$lambda$15(Lcom/bytedance/trae/conversation/widget/InputFragment; Ljava/lang/String; Lkotlin/Unit;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$wP5XQEUC3-H7mJdwqC0Aedg1cYI(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.widget.ChatAttachmentDialog  com.bytedance.trae.conversation.widget.ChatAttachmentDialog$AttachmentType)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners$lambda$35$lambda$34$lambda$33(Lcom/bytedance/trae/conversation/widget/InputFragment; Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog; Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$wauxIsvBWFrMBhXGKWOJwAn5oa8(android.view.View  int  int  int  int)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->onViewCreated$lambda$12(Landroid/view/View; I I I I)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->Companion Lcom/bytedance/trae/conversation/widget/InputFragment$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 6
    # ins_size=1
    invoke-direct v5, Landroidx/fragment/app/Fragment;-><init>()V
    const-string v0, "InputFragment"
    iput-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->TAG$1 Ljava/lang/String;
    move-object v0, v5
    check-cast v0, Landroidx/fragment/app/Fragment;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$special$$inlined$viewModels$default$1;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$special$$inlined$viewModels$default$1;-><init>(Landroidx/fragment/app/Fragment;)V
    check-cast v1, Lkotlin/jvm/functions/Function0;
    const-class v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    invoke-static v2, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/widget/InputFragment$special$$inlined$viewModels$default$2;
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$special$$inlined$viewModels$default$2;-><init>(Lkotlin/jvm/functions/Function0;)V
    check-cast v3, Lkotlin/jvm/functions/Function0;
    new-instance v4, Lcom/bytedance/trae/conversation/widget/InputFragment$special$$inlined$viewModels$default$3;
    invoke-direct v4, v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$special$$inlined$viewModels$default$3;-><init>(Lkotlin/jvm/functions/Function0; Landroidx/fragment/app/Fragment;)V
    check-cast v4, Lkotlin/jvm/functions/Function0;
    invoke-static v0, v2, v3, v4, Landroidx/fragment/app/FragmentViewModelLazyKt;->createViewModelLazy(Landroidx/fragment/app/Fragment; Lkotlin/reflect/KClass; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->inputViewModel$delegate Lkotlin/Lazy;
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    iput-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Empty Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    iput-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentInputState Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;->Normal Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    iput-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->holdToTalkState Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    iput-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->longPressHandler Landroid/os/Handler;
    const/4 v0, 1
    iput-boolean v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->needTranscript Z
    sget-object v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v1
    iput-object v1, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->selectedRemoteModel Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    iput-object v1, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentCliType Lcom/bytedance/trae/im/service/CliType;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;
    invoke-direct v1, v5, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    iput-object v1, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->voiceChatListener Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputContextualBarVisibilityState;
    const/4 v2, 0
    const/4 v3, 0
    invoke-direct v1, v2, v0, v3, Lcom/bytedance/trae/conversation/widget/InputContextualBarVisibilityState;-><init>(Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v1, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->contextualBarVisibilityState Lcom/bytedance/trae/conversation/widget/InputContextualBarVisibilityState;
    const-string v0, ""
    iput-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->initInputText Ljava/lang/String;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda32;
    invoke-direct v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda32;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    iput-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->remainingChangedListener Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$OnRemainingChangedListener;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$benefitSwitchListener$1;
    invoke-direct v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment$benefitSwitchListener$1;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    iput-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->benefitSwitchListener Lcom/bytedance/trae/conversation/widget/InputFragment$benefitSwitchListener$1;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda34;
    invoke-direct v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda34;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    iput-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->inputKeyboardLayoutListener Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda35;
    invoke-direct v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda35;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    iput-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->keyboardLayoutListener Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$RequestPermission;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$RequestPermission;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda36;
    invoke-direct v1, v5, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda36;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v5, v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    const-string v1, "registerForActivityResult(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->cameraPermissionLauncher Landroidx/activity/result/ActivityResultLauncher;
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$TakePicture;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$TakePicture;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda37;
    invoke-direct v2, v5, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda37;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v5, v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->takePictureLauncher Landroidx/activity/result/ActivityResultLauncher;
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda38;
    invoke-direct v2, v5, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda38;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v5, v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->mediaChooseLauncher Landroidx/activity/result/ActivityResultLauncher;
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$OpenMultipleDocuments;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$OpenMultipleDocuments;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda39;
    invoke-direct v2, v5, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda39;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v5, v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->filePickerLauncher Landroidx/activity/result/ActivityResultLauncher;
    return-void 
.end method

.method public static final synthetic access$currentInputStateNameForMetrics(com.bytedance.trae.conversation.widget.InputFragment)java.lang.String
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentInputStateNameForMetrics()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getBinding(com.bytedance.trae.conversation.widget.InputFragment)com.bytedance.trae.conversation.databinding.TraeFragmentInputBinding
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getCurrentDevice$p(com.bytedance.trae.conversation.widget.InputFragment)com.bytedance.trae.conversation.devices.SelectedDeviceItem
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    return-object v0
.end method

.method public static final synthetic access$getHoldToTalkState$p(com.bytedance.trae.conversation.widget.InputFragment)com.bytedance.trae.conversation.widget.InputFragment$HoldToTalkState
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->holdToTalkState Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    return-object v0
.end method

.method public static final synthetic access$getInfinite$p(com.bytedance.trae.conversation.widget.InputFragment)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->infinite Z
    return v0
.end method

.method public static final synthetic access$getNeedTranscript$p(com.bytedance.trae.conversation.widget.InputFragment)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->needTranscript Z
    return v0
.end method

.method public static final synthetic access$getVoiceChatSessionManager$p(com.bytedance.trae.conversation.widget.InputFragment)com.bytedance.trae.conversation.voice.TranscriptionVoiceManager
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->voiceChatSessionManager Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    return-object v0
.end method

.method public static final synthetic access$get_binding$p(com.bytedance.trae.conversation.widget.InputFragment)com.bytedance.trae.conversation.databinding.TraeFragmentInputBinding
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    return-object v0
.end method

.method public static final synthetic access$hasUploadedAttachments(com.bytedance.trae.conversation.widget.InputFragment)boolean
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->hasUploadedAttachments()Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$hideVoiceLoading(com.bytedance.trae.conversation.widget.InputFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->hideVoiceLoading()V
    return-void 
.end method

.method public static final synthetic access$resetInputBar(com.bytedance.trae.conversation.widget.InputFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->resetInputBar()V
    return-void 
.end method

.method public static final synthetic access$setAsrCount$p(com.bytedance.trae.conversation.widget.InputFragment  int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->asrCount I
    return-void 
.end method

.method public static final synthetic access$setExpressPassVisible$p(com.bytedance.trae.conversation.widget.InputFragment  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->isExpressPassVisible Z
    return-void 
.end method

.method public static final synthetic access$setHoldToTalkState$p(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.widget.InputFragment$HoldToTalkState)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->holdToTalkState Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    return-void 
.end method

.method public static final synthetic access$showExpressPassPopWindow(com.bytedance.trae.conversation.widget.InputFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->showExpressPassPopWindow()V
    return-void 
.end method

.method public static final synthetic access$updateHoldToTalkUI(com.bytedance.trae.conversation.widget.InputFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateHoldToTalkUI()V
    return-void 
.end method

.method private final audioRecordingRelease()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->voiceChatSessionManager Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    const/4 v1, 0
    const-string/jumbo v2, voiceChatSessionManager
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->isRunning()Z
    move-result v0
    if-eqz v0, +00fh
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->voiceChatSessionManager Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    const/4 v0, 1
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->stop(Z)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->initInputText Ljava/lang/String;
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->inputBottom Landroid/widget/RelativeLayout;
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/RelativeLayout;->setVisibility(I)V
    iput-boolean v1, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->isLongPressRecording Z
    iput-boolean v1, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->isLongPressCancelled Z
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->resetInputBar()V
    return-void 
.end method

.method private static final cameraPermissionLauncher$lambda$5(com.bytedance.trae.conversation.widget.InputFragment  java.lang.Boolean)void
    .registers 3
    # ins_size=2
    invoke-virtual v2, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    if-nez v2, +011h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_media_choose_camera_permission_denied I
    const/4 v0, 0
    invoke-static v1, v2, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v1
    invoke-virtual v1, Landroid/widget/Toast;->show()V
    return-void 
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->openCamera()V
    return-void 
.end method

.method private final canSend()boolean
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->hasInputMessage()Z
    move-result v0
    if-nez v0, +00bh
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->hasUploadedAttachments()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    return v0
.end method

.method private final checkHistoricalIdeProjectThenShowSkills()void
    .registers 3
    # ins_size=1
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->isCheckingSkillProject Z
    if-eqz v0, +003h
    return-void 
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->onRequestSkillProjectCheck Lkotlin/jvm/functions/Function1;
    if-nez v0, +006h
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->showCurrentDeviceOfflineToast()V
    return-void 
    const/4 v1, 1
    iput-boolean v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->isCheckingSkillProject Z
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda6;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private static final checkHistoricalIdeProjectThenShowSkills$lambda$65(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.devices.SelectedDeviceItem)kotlin.Unit
    .registers 4
    # ins_size=2
    const/4 v0, 0
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->isCheckingSkillProject Z
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    if-eqz v0, +03ah
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->isAdded()Z
    move-result v0
    if-nez v0, +003h
    goto +32h
    sget-object v0, Lcom/bytedance/trae/conversation/skill/SkillEntryPolicy;->INSTANCE Lcom/bytedance/trae/conversation/skill/SkillEntryPolicy;
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/skill/SkillEntryPolicy;->canOpenCheckedIdeSkills(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)Z
    move-result v0
    if-eqz v0, +025h
    if-eqz v3, +026h
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->setSelectedDevice(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvFolderName Landroid/widget/TextView;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getProjectName()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +003h
    goto +9h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getSelectedDirectory()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->parseWorkspaceDisplayName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->showSkillsBottomSheetForDevice(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)V
    goto +4h
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->showCheckedIdeSkillsUnavailableToast(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private final createImageUri()android.net.Uri
    .registers 7
    # ins_size=1
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
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
    const-string/jumbo v4, trae_media_choose_
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
    goto +2h
    const/4 v0, 0
    return-object v0
    :try_start_0x37
.end method

.method private final currentEnvironmentKey()java.lang.String
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v1, +008h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v1
    if-nez v1, +004h
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentCliType Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->environmentKey(Lcom/bytedance/trae/im/service/CliType;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final currentInputStateNameForMetrics()java.lang.String
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentInputState Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->name()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    const-string v2, "ROOT"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toLowerCase(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method private final currentModeKey()java.lang.String
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v1, Lcom/bytedance/trae/conversation/widget/InputFragment$WhenMappings;->$EnumSwitchMapping$5 [I
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->ordinal()I
    move-result v0
    aget v0, v1, v0
    const/4 v1, 1
    if-eq v0, v1, +00eh
    const/4 v1, 2
    if-ne v0, v1, +005h
    const-string v0, "mtc"
    goto +9h
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    const-string v0, "code"
    return-object v0
.end method

.method private static final dismissDeviceTipsPopWindow$lambda$116(android.widget.PopupWindow)void
    .registers 1
    # ins_size=1
    invoke-virtual v0, Landroid/widget/PopupWindow;->dismiss()V
    return-void 
.end method

.method private final dismissExpressPassPopWindow()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->expressPassPopWindow Landroid/widget/PopupWindow;
    const/4 v1, 0
    if-eqz v0, +007h
    invoke-virtual v0, Landroid/widget/PopupWindow;->getContentView()Landroid/view/View;
    move-result-object v0
    goto +2h
    move-object v0, v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->expressPassPopDismissRunnable Ljava/lang/Runnable;
    if-eqz v2, +009h
    if-eqz v0, +005h
    invoke-virtual v0, v2, Landroid/view/View;->removeCallbacks(Ljava/lang/Runnable;)Z
    iput-object v1, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->expressPassPopDismissRunnable Ljava/lang/Runnable;
    if-eqz v0, +00bh
    invoke-virtual v0, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/view/ViewPropertyAnimator;->cancel()V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->expressPassPopWindow Landroid/widget/PopupWindow;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/widget/PopupWindow;->dismiss()V
    iput-object v1, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->expressPassPopWindow Landroid/widget/PopupWindow;
    return-void 
    :try_start_0x0
.end method

.method private final dismissExpressPassToggleTooltip()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->tooltipPopView Landroid/view/View;
    if-eqz v0, +010h
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->tooltipArrowRunnable Ljava/lang/Runnable;
    if-eqz v1, +005h
    invoke-virtual v0, v1, Landroid/view/View;->removeCallbacks(Ljava/lang/Runnable;)Z
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->tooltipDismissRunnable Ljava/lang/Runnable;
    if-eqz v1, +005h
    invoke-virtual v0, v1, Landroid/view/View;->removeCallbacks(Ljava/lang/Runnable;)Z
    const/4 v0, 0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->tooltipArrowRunnable Ljava/lang/Runnable;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->tooltipDismissRunnable Ljava/lang/Runnable;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->expressPassTogglePopWindow Landroid/widget/PopupWindow;
    if-eqz v1, +011h
    invoke-virtual v1, Landroid/widget/PopupWindow;->getContentView()Landroid/view/View;
    move-result-object v1
    if-eqz v1, +00bh
    invoke-virtual v1, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;
    move-result-object v1
    if-eqz v1, +005h
    invoke-virtual v1, Landroid/view/ViewPropertyAnimator;->cancel()V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->expressPassTogglePopWindow Landroid/widget/PopupWindow;
    if-eqz v1, +005h
    invoke-virtual v1, Landroid/widget/PopupWindow;->dismiss()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->expressPassTogglePopWindow Landroid/widget/PopupWindow;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->tooltipPopView Landroid/view/View;
    return-void 
    :try_start_0x0
.end method

.method private final ensureRecordAudioPermission()boolean
    .registers 15
    # ins_size=1
    invoke-virtual v14, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    const-string v1, "android.permission.RECORD_AUDIO"
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->checkSelfPermission(Landroid/content/Context; Ljava/lang/String;)I
    move-result v0
    const/4 v1, 1
    const/4 v2, 0
    if-nez v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +003h
    return v1
    sget-object v3, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->Companion Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v4
    const-string/jumbo v0, requireContext(...)
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v5, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_permission_microphone I
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_microphone_title I
    sget v7, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_microphone_message I
    sget v8, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_allow I
    sget v9, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_deny I
    new-instance v10, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda5;
    invoke-direct v10, v14, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    const/4 v11, 0
    const/16 v12, 128
    const/4 v13, 0
    invoke-static/range v3 ... v13, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;->showForPermission$default(Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion; Landroid/content/Context; I I I I I Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;
    return v2
.end method

.method private static final ensureRecordAudioPermission$lambda$94(com.bytedance.trae.conversation.widget.InputFragment)kotlin.Unit
    .registers 3
    # ins_size=1
    const-string v0, "android.permission.RECORD_AUDIO"
    filled-new-array v0, [Ljava/lang/String;
    move-result-object v0
    const/16 v1, 10001
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->requestPermissions([Ljava/lang/String; I)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final filePickerLauncher$lambda$11(com.bytedance.trae.conversation.widget.InputFragment  java.util.List)void
    .registers 8
    # ins_size=2
    const-string/jumbo v0, uris
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v7, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v0, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v0
    move-object v1, v7
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const/4 v2, 0
    move v3, v2
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +020h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Landroid/net/Uri;
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->isCanAddAttachment()Z
    move-result v5
    if-eqz v5, +00dh
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v5
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v5, v4, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->addAttachment(Landroid/net/Uri; Landroid/content/Context;)V
    goto -20h
    add-int/lit8 v3, v3, 1
    goto -23h
    if-lez v3, +022h
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_attachment_count_limit I
    const/4 v3, 1
    new-array v3, v3, [Ljava/lang/Object;
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getWorkAttachmentTotalCount()J
    move-result-wide v4
    invoke-static v4, v5, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v4
    aput-object v4, v3, v2
    invoke-virtual v6, v1, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v0, v1, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    invoke-static v7, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Landroid/net/Uri;
    if-eqz v7, +009h
    iget-object v6, v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->onFileSelected Lkotlin/jvm/functions/Function1;
    if-eqz v6, +005h
    invoke-interface v6, v7, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private final getBinding()com.bytedance.trae.conversation.databinding.TraeFragmentInputBinding
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    return-object v0
.end method

.method private final getInputViewModel()com.bytedance.trae.conversation.widget.InputAttachmentListModel
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->inputViewModel$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    return-object v0
.end method

.method private final getQueryFileName(com.bytedance.trae.conversation.widget.AttachmentItem)java.lang.String
    .registers 5
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getFileName()Ljava/lang/String;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +012h
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    if-eqz v0, +003h
    return-object v0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getMimeType()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +018h
    invoke-static Landroid/webkit/MimeTypeMap;->getSingleton()Landroid/webkit/MimeTypeMap;
    move-result-object v0
    invoke-virtual v0, v4, Landroid/webkit/MimeTypeMap;->getExtensionFromMimeType(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +00eh
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +003h
    move-object v1, v4
    if-nez v1, +005h
    const-string v4, "attachment"
    goto +10h
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v0, "attachment."
    invoke-direct v4, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    return-object v4
.end method

.method private final handleLongPressTouch(android.view.MotionEvent)void
    .registers 7
    # ins_size=2
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->voiceRecordingOverlay Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;
    if-nez v0, +003h
    return-void 
    invoke-virtual v6, Landroid/view/MotionEvent;->getAction()I
    move-result v1
    const/4 v2, 3
    const/4 v3, 1
    if-eq v1, v3, +027h
    const/4 v4, 2
    if-eq v1, v4, +006h
    if-eq v1, v2, +022h
    goto/16 +078h
    iget-boolean v1, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->isLongPressRecording Z
    if-eqz v1, +074h
    invoke-virtual v6, Landroid/view/MotionEvent;->getRawX()F
    move-result v1
    invoke-virtual v6, Landroid/view/MotionEvent;->getRawY()F
    move-result v6
    invoke-virtual v0, v6, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->shouldCancel(F)Z
    move-result v2
    if-eqz v2, +008h
    sget-object v2, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;->CANCELING Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;
    invoke-virtual v0, v2, v1, v6, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->updateState(Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState; F F)V
    goto +5fh
    sget-object v2, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;->SPEAKING Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;
    invoke-virtual v0, v2, v1, v6, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->updateState(Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState; F F)V
    goto +59h
    iget-boolean v1, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->isLongPressRecording Z
    if-eqz v1, +056h
    invoke-virtual v6, Landroid/view/MotionEvent;->getRawY()F
    move-result v1
    invoke-virtual v6, Landroid/view/MotionEvent;->getAction()I
    move-result v6
    const/4 v4, 0
    if-eq v6, v2, +00bh
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->shouldCancel(F)Z
    move-result v6
    if-eqz v6, +003h
    goto +3h
    move v6, v4
    goto +2h
    move v6, v3
    iput-boolean v4, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->isLongPressRecording Z
    iput-boolean v6, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->isLongPressCancelled Z
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->hide()V
    if-eqz v6, +00fh
    iput-boolean v4, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->needTranscript Z
    invoke-direct v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->audioRecordingRelease()V
    sget-object v6, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    const-string v0, "asr_recog_cancel"
    invoke-virtual v6, v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackAsrRecog(Ljava/lang/String;)V
    goto +2ah
    iput-boolean v3, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->needTranscript Z
    iget-object v6, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->voiceChatSessionManager Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    const-string/jumbo v0, voiceChatSessionManager
    const/4 v1, 0
    if-nez v6, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v1
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->isRunning()Z
    move-result v6
    if-eqz v6, +010h
    invoke-direct v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->showVoiceLoading()V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->voiceChatSessionManager Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    if-nez v6, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v1
    invoke-static v6, v4, v3, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->stop$default(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Z I Ljava/lang/Object;)V
    sget-object v6, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    const-string v0, "asr_recog_keep"
    invoke-virtual v6, v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackAsrRecog(Ljava/lang/String;)V
    return-void 
.end method

.method private final hasFailedAttachments()boolean
    .registers 6
    # ins_size=1
    invoke-direct v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getAttachments()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    instance-of v1, v0, Ljava/util/Collection;
    const/4 v2, 0
    if-eqz v1, +00ch
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    goto +20h
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +017h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUploadStatus()Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    move-result-object v1
    sget-object v3, Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;->Error Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    const/4 v4, 1
    if-ne v1, v3, +004h
    move v1, v4
    goto +2h
    move v1, v2
    if-eqz v1, -018h
    move v2, v4
    return v2
.end method

.method private final hasUploadedAttachments()boolean
    .registers 6
    # ins_size=1
    invoke-direct v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getAttachments()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    const/4 v2, 1
    xor-int/2addr v1, v2
    const/4 v3, 0
    if-eqz v1, +034h
    check-cast v0, Ljava/lang/Iterable;
    instance-of v1, v0, Ljava/util/Collection;
    if-eqz v1, +00dh
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +004h
    move v0, v2
    goto +1fh
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, -00ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUploadStatus()Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    move-result-object v1
    sget-object v4, Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;->Success Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    if-ne v1, v4, +004h
    move v1, v2
    goto +2h
    move v1, v3
    if-nez v1, -017h
    move v0, v3
    if-eqz v0, +003h
    goto +2h
    move v2, v3
    return v2
.end method

.method private final hasUploadingAttachments()boolean
    .registers 7
    # ins_size=1
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getAttachments()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    instance-of v1, v0, Ljava/util/Collection;
    const/4 v2, 0
    if-eqz v1, +00ch
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    goto +29h
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +020h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUploadStatus()Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;->Uploading Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    const/4 v5, 1
    if-eq v3, v4, +00dh
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUploadStatus()Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    move-result-object v1
    sget-object v3, Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;->Pending Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    if-ne v1, v3, +003h
    goto +3h
    move v1, v2
    goto +2h
    move v1, v5
    if-eqz v1, -021h
    move v2, v5
    return v2
.end method

.method private final hideVoiceLoading()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->voiceLoadingView Landroid/view/View;
    if-nez v0, +003h
    return-void 
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v1
    const/4 v2, 0
    if-eqz v1, +00dh
    invoke-virtual v1, Landroidx/fragment/app/FragmentActivity;->getWindow()Landroid/view/Window;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Landroid/view/Window;->getDecorView()Landroid/view/View;
    move-result-object v1
    goto +2h
    move-object v1, v2
    instance-of v3, v1, Landroid/view/ViewGroup;
    if-eqz v3, +005h
    check-cast v1, Landroid/view/ViewGroup;
    goto +2h
    move-object v1, v2
    if-eqz v1, +005h
    invoke-virtual v1, v0, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V
    iput-object v2, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->voiceLoadingView Landroid/view/View;
    return-void 
    :try_start_0x0
.end method

.method private static final inputKeyboardLayoutListener$lambda$3(com.bytedance.trae.conversation.widget.InputFragment)void
    .registers 8
    # ins_size=1
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->getView()Landroid/view/View;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    new-instance v1, Landroid/graphics/Rect;
    invoke-direct v1, Landroid/graphics/Rect;-><init>()V
    invoke-virtual v0, v1, Landroid/view/View;->getWindowVisibleDisplayFrame(Landroid/graphics/Rect;)V
    invoke-virtual v0, Landroid/view/View;->getRootView()Landroid/view/View;
    move-result-object v0
    invoke-virtual v0, Landroid/view/View;->getHeight()I
    move-result v0
    iget v1, v1, Landroid/graphics/Rect;->bottom I
    sub-int v1, v0, v1
    iget-boolean v2, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->isKeyboardVisible Z
    int-to-double v3, v1
    int-to-double v0, v0
    const-wide v5, 4594572339843380019
    mul-double/2addr v0, v5
    cmpl-double v0, v3, v0
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    iput-boolean v0, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->isKeyboardVisible Z
    if-eq v0, v2, +02bh
    if-eqz v0, +016h
    iget-object v0, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    if-eqz v0, +025h
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    if-eqz v0, +021h
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_input_hint_keyboard I
    invoke-virtual v7, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getString(I)Ljava/lang/String;
    move-result-object v7
    check-cast v7, Ljava/lang/CharSequence;
    invoke-virtual v0, v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->setHint(Ljava/lang/CharSequence;)V
    goto +14h
    iget-object v0, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    if-eqz v0, +011h
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    if-eqz v0, +00dh
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_input_hint I
    invoke-virtual v7, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getString(I)Ljava/lang/String;
    move-result-object v7
    check-cast v7, Ljava/lang/CharSequence;
    invoke-virtual v0, v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->setHint(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method private final isManualModelSelectionSupported()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 1
    return v0
.end method

.method private final isModelSelectorTaskLocked()boolean
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentInputState Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    sget-object v1, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Sending Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    const/4 v2, 1
    if-eq v0, v1, +026h
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentInputState Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    sget-object v1, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Sended Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    if-eq v0, v1, +020h
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentInputState Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    sget-object v1, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Stopped Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    if-eq v0, v1, +01ah
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->isTaskRunning Lkotlin/jvm/functions/Function0;
    const/4 v1, 0
    if-eqz v0, +010h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    if-ne v0, v2, +004h
    move v0, v2
    goto +2h
    move v0, v1
    if-eqz v0, +003h
    goto +2h
    move v2, v1
    return v2
.end method

.method private final isNetworkAvailable()boolean
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    const-string v1, "connectivity"
    invoke-virtual v0, v1, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Landroid/net/ConnectivityManager;
    if-eqz v1, +005h
    check-cast v0, Landroid/net/ConnectivityManager;
    goto +2h
    const/4 v0, 0
    const/4 v1, 0
    if-nez v0, +003h
    return v1
    invoke-virtual v0, Landroid/net/ConnectivityManager;->getActiveNetwork()Landroid/net/Network;
    move-result-object v2
    if-nez v2, +003h
    return v1
    invoke-virtual v0, v2, Landroid/net/ConnectivityManager;->getNetworkCapabilities(Landroid/net/Network;)Landroid/net/NetworkCapabilities;
    move-result-object v0
    if-nez v0, +003h
    return v1
    const/16 v1, 12
    invoke-virtual v0, v1, Landroid/net/NetworkCapabilities;->hasCapability(I)Z
    move-result v0
    return v0
    const/4 v0, 1
    return v0
    :try_start_0x0
.end method

.method private static final keyboardLayoutListener$lambda$4(com.bytedance.trae.conversation.widget.InputFragment)void
    .registers 8
    # ins_size=1
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->getView()Landroid/view/View;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    new-instance v1, Landroid/graphics/Rect;
    invoke-direct v1, Landroid/graphics/Rect;-><init>()V
    invoke-virtual v0, v1, Landroid/view/View;->getWindowVisibleDisplayFrame(Landroid/graphics/Rect;)V
    invoke-virtual v0, Landroid/view/View;->getRootView()Landroid/view/View;
    move-result-object v0
    invoke-virtual v0, Landroid/view/View;->getHeight()I
    move-result v0
    iget v1, v1, Landroid/graphics/Rect;->bottom I
    sub-int v1, v0, v1
    iget-boolean v2, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->isKeyboardVisibleForTemplates Z
    int-to-double v3, v1
    int-to-double v0, v0
    const-wide v5, 4594572339843380019
    mul-double/2addr v0, v5
    cmpl-double v0, v3, v0
    const/4 v1, 0
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    move v0, v1
    iput-boolean v0, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->isKeyboardVisibleForTemplates Z
    if-eq v0, v2, +039h
    if-eqz v0, +00ch
    iget-object v7, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->taskTemplatesRecyclerView Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v7, +033h
    const/16 v0, 8
    invoke-virtual v7, v0, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    goto +2ch
    iget-boolean v0, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->isNewConversation Z
    if-eqz v0, +029h
    iget-object v0, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-eq v0, v2, +01bh
    iget-object v0, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->taskTemplatesRecyclerView Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v0, +00dh
    invoke-virtual v0, Landroidx/recyclerview/widget/RecyclerView;->getAdapter()Landroidx/recyclerview/widget/RecyclerView$Adapter;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Landroidx/recyclerview/widget/RecyclerView$Adapter;->getItemCount()I
    move-result v0
    goto +2h
    move v0, v1
    if-lez v0, +009h
    iget-object v7, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->taskTemplatesRecyclerView Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v7, +005h
    invoke-virtual v7, v1, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    return-void 
.end method

.method private static final mediaChooseLauncher$lambda$8(com.bytedance.trae.conversation.widget.InputFragment  androidx.activity.result.ActivityResult)void
    .registers 6
    # ins_size=2
    invoke-virtual v5, Landroidx/activity/result/ActivityResult;->getResultCode()I
    move-result v0
    const/4 v1, -1
    if-ne v0, v1, +05eh
    invoke-virtual v5, Landroidx/activity/result/ActivityResult;->getData()Landroid/content/Intent;
    move-result-object v5
    if-eqz v5, +00ah
    const-string/jumbo v0, trae_media_choose_result_selected
    invoke-virtual v5, v0, Landroid/content/Intent;->getParcelableArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;
    move-result-object v5
    goto +2h
    const/4 v5, 0
    move-object v0, v5
    check-cast v0, Ljava/util/Collection;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-nez v0, +03eh
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v0, v1, +00dh
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v0
    move-object v1, v5
    check-cast v1, Ljava/util/List;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->addImages(Ljava/util/List;)V
    goto +25h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->TAG$1 Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "mediaChooseLauncher:"
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, Ljava/util/ArrayList;->size()I
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v0
    move-object v1, v5
    check-cast v1, Ljava/util/List;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->addImageAttachments(Ljava/util/List;)V
    iget-object v4, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->onImageSelected Lkotlin/jvm/functions/Function1;
    if-eqz v4, +005h
    invoke-interface v4, v5, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private static final onViewCreated$lambda$12(android.view.View  int  int  int  int)void
    .registers 5
    # ins_size=5
    invoke-virtual v0, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v1
    if-eqz v1, +015h
    const/4 v2, 1
    invoke-virtual v0, v2, Landroid/view/View;->canScrollVertically(I)Z
    move-result v3
    if-nez v3, +00bh
    const/4 v3, -1
    invoke-virtual v0, v3, Landroid/view/View;->canScrollVertically(I)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    const/4 v2, 0
    invoke-interface v1, v2, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V
    return-void 
.end method

.method private static final onViewCreated$lambda$13(com.bytedance.trae.conversation.widget.InputFragment  android.view.View  boolean)void
    .registers 3
    # ins_size=3
    if-eqz v2, +009h
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onInputFocus Lkotlin/jvm/functions/Function0;
    if-eqz v0, +005h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private final openCamera()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->createImageUri()Landroid/net/Uri;
    move-result-object v0
    if-nez v0, +014h
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_media_choose_camera_create_failed I
    const/4 v2, 0
    invoke-static v0, v1, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    return-void 
    iput-object v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->pendingCameraUri Landroid/net/Uri;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->takePictureLauncher Landroidx/activity/result/ActivityResultLauncher;
    invoke-virtual v1, v0, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    return-void 
.end method

.method private final preloadPlugins(com.bytedance.trae.conversation.devices.SelectedDeviceItem)void
    .registers 11
    # ins_size=2
    invoke-virtual v10, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    const/4 v2, 1
    const/4 v3, 0
    if-ne v0, v1, +004h
    move v0, v2
    goto +2h
    move v0, v3
    const/4 v1, 0
    if-eqz v0, +004h
    move-object v0, v10
    goto +2h
    move-object v0, v1
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    invoke-virtual v10, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-ne v4, v5, +003h
    goto +2h
    move v2, v3
    if-eqz v2, +003h
    goto +2h
    move-object v10, v1
    if-eqz v10, +007h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getSelectedDirectory()Ljava/lang/String;
    move-result-object v10
    goto +2h
    move-object v10, v1
    move-object v2, v9
    check-cast v2, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v2, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v2
    move-object v4, v2
    check-cast v4, Lkotlin/coroutines/CoroutineContext;
    const/4 v5, 0
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputFragment$preloadPlugins$1;
    invoke-direct v2, v0, v10, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$preloadPlugins$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v6, v2
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 2
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final registerKeyboardListener()void
    .registers 3
    # ins_size=1
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->isKeyboardListenerRegistered Z
    if-nez v0, +016h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getView()Landroid/view/View;
    move-result-object v0
    if-eqz v0, +00dh
    invoke-virtual v0, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;
    move-result-object v0
    if-eqz v0, +007h
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->keyboardLayoutListener Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;
    invoke-virtual v0, v1, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    const/4 v0, 1
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->isKeyboardListenerRegistered Z
    return-void 
.end method

.method private static final remainingChangedListener$lambda$2(com.bytedance.trae.conversation.widget.InputFragment  long  long  boolean)void
    .registers 15
    # ins_size=6
    invoke-virtual v9, Lcom/bytedance/trae/conversation/widget/InputFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    if-eqz v0, +00fh
    new-instance v8, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda4;
    move-object v1, v8
    move-object v2, v9
    move v3, v14
    move-wide v4, v12
    move-wide v6, v10
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment; Z J J)V
    invoke-virtual v0, v8, Landroidx/fragment/app/FragmentActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    return-void 
.end method

.method private static final remainingChangedListener$lambda$2$lambda$1(com.bytedance.trae.conversation.widget.InputFragment  boolean  long  long)void
    .registers 14
    # ins_size=6
    const-string v0, "express_pass_switch_tips"
    const-string v1, "ExpressPassBenefitManager"
    const-string/jumbo v2, runOnUiThread:
    iget-object v3, v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    if-nez v3, +003h
    return-void 
    sget-object v3, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v3
    const/16 v4, 8
    const/4 v5, 0
    if-eqz v3, +00eh
    iput-boolean v5, v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->isExpressPassVisible Z
    invoke-direct v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v8
    iget-object v8, v8, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    invoke-virtual v8, v4, Landroid/widget/ImageView;->setVisibility(I)V
    return-void 
    iput-boolean v9, v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->infinite Z
    new-instance v9, Ljava/lang/StringBuilder;
    invoke-direct v9, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->infinite Z
    invoke-virtual v9, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v9
    const/16 v3, 32
    invoke-virtual v9, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v10, v11, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v12, v13, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-static v1, v9, Lcom/facebook/common/logging/FLog;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-boolean v9, v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->infinite Z
    const-wide/16 v12, 0
    const/4 v6, 1
    if-nez v9, +009h
    cmp-long v9, v10, v12
    if-lez v9, +003h
    goto +3h
    move v9, v5
    goto +2h
    move v9, v6
    invoke-direct v8, v9, Lcom/bytedance/trae/conversation/widget/InputFragment;->showExpressPassBtn(Z)V
    if-eqz v9, +01eh
    iget-object v7, v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->deviceTipsPopWindow Landroid/widget/PopupWindow;
    if-nez v7, +01ah
    sget-object v7, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v7
    invoke-virtual v7, v0, v5, Lcom/bytedance/keva/Keva;->getBoolean(Ljava/lang/String; Z)Z
    move-result v7
    if-nez v7, +00eh
    sget-object v7, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v7
    invoke-virtual v7, v0, v6, Lcom/bytedance/keva/Keva;->storeBoolean(Ljava/lang/String; Z)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->showExpressPassPopWindow()V
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v9, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v2, v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->infinite Z
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    sget-object v2, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->getNotifyCount()J
    move-result-wide v2
    invoke-virtual v0, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v1, v0, Lcom/facebook/common/logging/FLog;->d(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v9, +06eh
    iget-boolean v9, v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->infinite Z
    if-nez v9, +06ah
    sget-object v9, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->getNotifyCount()J
    move-result-wide v0
    cmp-long v9, v10, v0
    if-gez v9, +060h
    sget-object v9, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->INSTANCE Lcom/bytedance/trae/conversation/AccountSettingsKeva;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v9
    const-string v0, "express_pass_benefit_close_time"
    invoke-virtual v9, v0, v12, v13, Lcom/bytedance/keva/Keva;->getLong(Ljava/lang/String; J)J
    move-result-wide v0
    cmp-long v9, v0, v12
    if-eqz v9, +01ch
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v12
    sub-long/2addr v12, v0
    sget-object v9, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->getNotifyInterval()J
    move-result-wide v0
    cmp-long v9, v12, v0
    if-lez v9, +003h
    goto +bh
    invoke-direct v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v8
    iget-object v8, v8, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llExpressPassBenefit Landroid/widget/LinearLayout;
    invoke-virtual v8, v4, Landroid/widget/LinearLayout;->setVisibility(I)V
    goto +3eh
    invoke-virtual v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->getContext()Landroid/content/Context;
    move-result-object v9
    if-eqz v9, +026h
    invoke-direct v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v12
    iget-object v12, v12, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvExpressPassBenefit Landroid/widget/TextView;
    sget-object v13, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual v9, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v9
    const-string v0, "getResources(...)"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->imkit_fast_pass_remaining I
    new-array v1, v6, [Ljava/lang/Object;
    invoke-static v10, v11, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v10
    aput-object v10, v1, v5
    invoke-virtual v13, v9, v0, v1, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    invoke-virtual v12, v9, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v8
    iget-object v8, v8, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llExpressPassBenefit Landroid/widget/LinearLayout;
    invoke-virtual v8, v5, Landroid/widget/LinearLayout;->setVisibility(I)V
    goto +ah
    invoke-direct v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v8
    iget-object v8, v8, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llExpressPassBenefit Landroid/widget/LinearLayout;
    invoke-virtual v8, v4, Landroid/widget/LinearLayout;->setVisibility(I)V
    return-void 
    :try_start_0x7
.end method

.method private final resetInputBar()void
    .registers 6
    # ins_size=1
    invoke-direct v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->inputBottom Landroid/widget/RelativeLayout;
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/RelativeLayout;->setVisibility(I)V
    invoke-direct v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->bottomContextualBar Landroid/widget/FrameLayout;
    invoke-virtual v0, Landroid/widget/FrameLayout;->getVisibility()I
    move-result v0
    const/high16 v2, 1065353216
    const/4 v3, 1
    if-nez v0, +01bh
    invoke-direct v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->bottomContextualBar Landroid/widget/FrameLayout;
    const-string v4, "bottomContextualBar"
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/view/ViewGroup;
    invoke-direct v5, v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->setViewGroupEnabled(Landroid/view/ViewGroup; Z)V
    invoke-direct v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->bottomContextualBar Landroid/widget/FrameLayout;
    invoke-virtual v0, v2, Landroid/widget/FrameLayout;->setAlpha(F)V
    invoke-direct v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llDeviceFolderBar Landroid/widget/LinearLayout;
    invoke-virtual v0, Landroid/widget/LinearLayout;->getVisibility()I
    move-result v0
    if-nez v0, +01bh
    invoke-direct v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llDeviceFolderBar Landroid/widget/LinearLayout;
    const-string v4, "llDeviceFolderBar"
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/view/ViewGroup;
    invoke-direct v5, v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->setViewGroupEnabled(Landroid/view/ViewGroup; Z)V
    invoke-direct v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llDeviceFolderBar Landroid/widget/LinearLayout;
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setAlpha(F)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->onRecordingStateChanged Lkotlin/jvm/functions/Function1;
    if-eqz v0, +009h
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private final resolveModelFunctions(com.bytedance.trae.im.service.CliType)java.util.List
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v3, v0, +00ah
    const-string/jumbo v3, solo_agent
    invoke-static v3, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    goto +4dh
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-ne v3, v0, +010h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v0, v1, +00ah
    const-string/jumbo v3, solo_agent_lite
    invoke-static v3, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    goto +3bh
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-ne v3, v0, +010h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v0, v1, +00ah
    const-string/jumbo v3, solo_work_lite
    invoke-static v3, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    goto +29h
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-ne v3, v0, +010h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v0, v1, +00ah
    const-string/jumbo v3, solo_agent_remote
    invoke-static v3, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    goto +17h
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-ne v3, v0, +010h
    iget-object v3, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v3, v0, +00ah
    const-string/jumbo v3, solo_work_remote
    invoke-static v3, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v3
    return-object v3
.end method

.method private final saveSelectedModel(com.bytedance.trae.conversation.network.RemoteModelItem  boolean)void
    .registers 6
    # ins_size=3
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->isManualModelSelectionSupported()Z
    move-result v0
    if-nez v0, +017h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getId()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentEnvironmentKey()Ljava/lang/String;
    move-result-object v0
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentModeKey()Ljava/lang/String;
    move-result-object v1
    if-eqz v5, +007h
    sget-object v5, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;
    invoke-virtual v5, v0, v1, v4, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->saveModeSelection(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/network/RemoteModelItem;)V
    sget-object v5, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentConversationId Ljava/lang/String;
    invoke-virtual v5, v0, v1, v2, v4, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->saveSessionSelection(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/network/RemoteModelItem;)V
    return-void 
.end method

.method private final setViewGroupEnabled(android.view.ViewGroup  boolean)void
    .registers 7
    # ins_size=3
    invoke-virtual v5, Landroid/view/ViewGroup;->getChildCount()I
    move-result v0
    const/4 v1, 0
    if-ge v1, v0, +018h
    invoke-virtual v5, v1, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;
    move-result-object v2
    invoke-virtual v2, v6, Landroid/view/View;->setEnabled(Z)V
    invoke-virtual v2, v6, Landroid/view/View;->setClickable(Z)V
    instance-of v3, v2, Landroid/view/ViewGroup;
    if-eqz v3, +007h
    check-cast v2, Landroid/view/ViewGroup;
    invoke-direct v4, v2, v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->setViewGroupEnabled(Landroid/view/ViewGroup; Z)V
    add-int/lit8 v1, v1, 1
    goto -17h
    return-void 
.end method

.method private final setupAttachmentsRecyclerView()void
    .registers 6
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda1;
    invoke-direct v1, v5, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda2;
    invoke-direct v2, v5, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1;)V
    invoke-direct v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->rvAttachments Landroidx/recyclerview/widget/RecyclerView;
    new-instance v2, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v3
    const/4 v4, 0
    invoke-direct v2, v3, v4, v4, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context; I Z)V
    check-cast v2, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v1, v2, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    invoke-direct v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->rvAttachments Landroidx/recyclerview/widget/RecyclerView;
    move-object v2, v0
    check-cast v2, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v1, v2, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    invoke-direct v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getAttachments()Landroidx/lifecycle/LiveData;
    move-result-object v1
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda3;
    invoke-direct v3, v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter; Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$sam$androidx_lifecycle_Observer$0;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v0, Landroidx/lifecycle/Observer;
    invoke-virtual v1, v2, v0, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    return-void 
.end method

.method private static final setupAttachmentsRecyclerView$lambda$18(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.widget.AttachmentItem)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "item"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v1
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->removeAttachment(Lcom/bytedance/trae/conversation/widget/AttachmentItem;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final setupAttachmentsRecyclerView$lambda$19(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.widget.AttachmentItem)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "item"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v0
    iget-object v1, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->retryUpload(Lcom/bytedance/trae/conversation/widget/AttachmentItem; Lcom/bytedance/trae/conversation/widget/ChatMode;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final setupAttachmentsRecyclerView$lambda$20(com.bytedance.trae.conversation.widget.InputAttachmentAdapter  com.bytedance.trae.conversation.widget.InputFragment  java.util.List)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter;->submitList(Ljava/util/List;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->rvAttachments Landroidx/recyclerview/widget/RecyclerView;
    invoke-interface v2, Ljava/util/List;->isEmpty()Z
    move-result v1
    if-eqz v1, +005h
    const/16 v1, 8
    goto +2h
    const/4 v1, 0
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final setupClickListeners()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnSendText Landroid/widget/ImageView;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda8;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnPause Landroid/widget/ImageView;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda19;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda19;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnPlus Landroid/widget/ImageView;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda20;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda20;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda21;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda21;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnChatNew Landroid/widget/ImageView;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda23;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda23;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnMicrophone Landroid/widget/ImageView;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda24;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda24;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnHoldToTalk Landroid/widget/ImageView;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda25;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda25;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvHoldToTalk Landroid/widget/TextView;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda26;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda26;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnMicrophone Landroid/widget/ImageView;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda27;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda27;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnMicrophone Landroid/widget/ImageView;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda28;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda28;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda9;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->inputBottom Landroid/widget/RelativeLayout;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda10;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda10;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v0, v1, Landroid/widget/RelativeLayout;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda12;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda12;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llCloudContent Landroid/widget/LinearLayout;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda13;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda13;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->modelSelector Landroid/widget/LinearLayout;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda14;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda14;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnGithub Landroid/widget/LinearLayout;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda15;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda15;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnBranch Landroid/widget/LinearLayout;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda16;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda16;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnDevice Landroid/widget/LinearLayout;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda17;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda17;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnSelectFolder Landroid/widget/LinearLayout;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda18;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda18;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupClickListeners$lambda$25(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->send()V
    return-void 
.end method

.method private static final setupClickListeners$lambda$26(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    sget-object v1, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Stopped Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->switchInputState(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onPauseClickListener Lkotlin/jvm/functions/Function0;
    if-eqz v0, +005h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private static final setupClickListeners$lambda$35(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 7
    # ins_size=2
    iget-object v6, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    const/4 v0, 0
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v6
    goto +2h
    move-object v6, v0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    const/4 v2, 1
    const/4 v3, 0
    if-ne v6, v1, +004h
    move v6, v2
    goto +2h
    move v6, v3
    iget-object v1, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v1
    goto +2h
    move-object v1, v0
    sget-object v4, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v1, v4, +003h
    goto +2h
    move v2, v3
    iget-object v1, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v1, +006h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getIdeVersion()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->Companion Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$Companion;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v1, v3, v6, v2, v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$Companion;->newInstance(Lcom/bytedance/trae/conversation/widget/ChatMode; Z Z Ljava/lang/String;)Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;
    move-result-object v6
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda0;
    invoke-direct v0, v5, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment; Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;)V
    invoke-virtual v6, v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->setOnAttachmentSelected(Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v5
    const-string v0, "getParentFragmentManager(...)"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, v5, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->showOnce(Landroidx/fragment/app/FragmentManager;)Z
    return-void 
.end method

.method private static final setupClickListeners$lambda$35$lambda$34$lambda$33(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.widget.ChatAttachmentDialog  com.bytedance.trae.conversation.widget.ChatAttachmentDialog$AttachmentType)kotlin.Unit
    .registers 14
    # ins_size=3
    const-string/jumbo v0, type
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual v13, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->ordinal()I
    move-result v1
    aget v0, v0, v1
    const/4 v1, 1
    if-eq v0, v1, +238h
    const/4 v2, 2
    const/4 v3, 0
    if-eq v0, v2, +1e6h
    const/4 v2, 3
    if-eq v0, v2, +0b9h
    const/4 v2, 4
    if-eq v0, v2, +079h
    const/4 v2, 5
    if-eq v0, v2, +00bh
    iget-object v11, v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->onAttachmentSelected Lkotlin/jvm/functions/Function1;
    if-eqz v11, +22ah
    invoke-interface v11, v13, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto/16 +225h
    iget-object v13, v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v13, v0, +032h
    invoke-direct v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v13
    invoke-virtual v13, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->isCanAddAttachment()Z
    move-result v13
    if-nez v13, +028h
    invoke-virtual v12, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->requireContext()Landroid/content/Context;
    move-result-object v13
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_attachment_count_limit I
    new-array v1, v1, [Ljava/lang/Object;
    invoke-direct v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getWorkAttachmentTotalCount()J
    move-result-wide v4
    invoke-static v4, v5, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v11
    aput-object v11, v1, v3
    invoke-virtual v12, v0, v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    check-cast v11, Ljava/lang/CharSequence;
    invoke-static v13, v11, v3, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v11
    invoke-virtual v11, Landroid/widget/Toast;->show()V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
    invoke-virtual v12, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->requireContext()Landroid/content/Context;
    move-result-object v13
    const-string v0, "android.permission.CAMERA"
    invoke-static v13, v0, Landroidx/core/content/ContextCompat;->checkSelfPermission(Landroid/content/Context; Ljava/lang/String;)I
    move-result v13
    if-eqz v13, +026h
    sget-object v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->Companion Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->requireContext()Landroid/content/Context;
    move-result-object v1
    const-string/jumbo v12, requireContext(...)
    invoke-static v1, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_permission_camera I
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_camera_title I
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_camera_message I
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_allow I
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_permission_deny I
    new-instance v7, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda58;
    invoke-direct v7, v11, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda58;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    const/4 v8, 0
    const/16 v9, 128
    const/4 v10, 0
    invoke-static/range v0 ... v10, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;->showForPermission$default(Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion; Landroid/content/Context; I I I I I Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;
    goto/16 +1bfh
    invoke-direct v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->openCamera()V
    goto/16 +1bah
    invoke-direct v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v13
    invoke-virtual v13, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->isCanAddAttachment()Z
    move-result v13
    if-nez v13, +028h
    invoke-virtual v12, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->requireContext()Landroid/content/Context;
    move-result-object v13
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_attachment_count_limit I
    new-array v1, v1, [Ljava/lang/Object;
    invoke-direct v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getWorkAttachmentTotalCount()J
    move-result-wide v4
    invoke-static v4, v5, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v11
    aput-object v11, v1, v3
    invoke-virtual v12, v0, v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    check-cast v11, Ljava/lang/CharSequence;
    invoke-static v13, v11, v3, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v11
    invoke-virtual v11, Landroid/widget/Toast;->show()V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
    iget-object v11, v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->filePickerLauncher Landroidx/activity/result/ActivityResultLauncher;
    const-string v12, "*/*"
    filled-new-array v12, [Ljava/lang/String;
    move-result-object v12
    invoke-virtual v11, v12, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    goto/16 +17dh
    iget-object v13, v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v13, v0, +032h
    invoke-direct v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v13
    invoke-virtual v13, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->isCanAddAttachment()Z
    move-result v13
    if-nez v13, +028h
    invoke-virtual v12, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->requireContext()Landroid/content/Context;
    move-result-object v13
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_attachment_count_limit I
    new-array v1, v1, [Ljava/lang/Object;
    invoke-direct v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getWorkAttachmentTotalCount()J
    move-result-wide v4
    invoke-static v4, v5, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v11
    aput-object v11, v1, v3
    invoke-virtual v12, v0, v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    check-cast v11, Ljava/lang/CharSequence;
    invoke-static v13, v11, v3, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v11
    invoke-virtual v11, Landroid/widget/Toast;->show()V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
    new-instance v13, Landroid/content/Intent;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->requireContext()Landroid/content/Context;
    move-result-object v12
    const-class v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseActivity;
    invoke-direct v13, v12, v0, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    invoke-direct v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v12
    invoke-virtual v12, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getSelectedMediaItems()Ljava/util/List;
    move-result-object v12
    check-cast v12, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    const-wide/16 v4, 0
    if-eqz v2, +01ah
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v6, v2
    check-cast v6, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getId()J
    move-result-wide v6
    cmp-long v4, v6, v4
    if-lez v4, +004h
    move v4, v1
    goto +2h
    move v4, v3
    if-eqz v4, -01ah
    invoke-interface v0, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1fh
    check-cast v0, Ljava/util/List;
    move-object v12, v0
    check-cast v12, Ljava/util/Collection;
    invoke-interface v12, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    xor-int/2addr v1, v2
    if-eqz v1, +00dh
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, v12, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    const-string/jumbo v12, trae_media_choose_extra_initial_selected
    invoke-virtual v13, v12, v1, Landroid/content/Intent;->putParcelableArrayListExtra(Ljava/lang/String; Ljava/util/ArrayList;)Landroid/content/Intent;
    iget-object v12, v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v12, v1, +011h
    invoke-direct v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v12
    invoke-virtual v12, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getRemainCount()J
    move-result-wide v1
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v12
    int-to-long v6, v12
    add-long/2addr v1, v6
    goto +9h
    invoke-direct v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v12
    invoke-virtual v12, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getCodeImageMaxCount()J
    move-result-wide v1
    sget-object v12, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v3, v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->TAG$1 Ljava/lang/String;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v7, "PHOTO::"
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getRemainCount()J
    move-result-wide v7
    invoke-virtual v6, v7, v8, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v6
    const/16 v7, 32
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v7
    int-to-long v7, v7
    invoke-virtual v6, v7, v8, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v12, v3, v6, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v12, trae_media_choose_max_count
    invoke-virtual v13, v12, v1, v2, Landroid/content/Intent;->putExtra(Ljava/lang/String; J)Landroid/content/Intent;
    iget-object v12, v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    const-string/jumbo v2, trae_media_choose_single_size
    if-ne v12, v1, +035h
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +00eh
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getSizeBytes()J
    move-result-wide v0
    add-long/2addr v4, v0
    goto -11h
    invoke-direct v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v12
    invoke-virtual v12, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getWorkSingleImageSize()J
    move-result-wide v0
    invoke-virtual v13, v2, v0, v1, Landroid/content/Intent;->putExtra(Ljava/lang/String; J)Landroid/content/Intent;
    invoke-direct v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v12
    invoke-virtual v12, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getWorkAttachmentRemainTotalSize()J
    move-result-wide v0
    add-long/2addr v0, v4
    const-string/jumbo v12, trae_media_choose_max_total_size
    invoke-virtual v13, v12, v0, v1, Landroid/content/Intent;->putExtra(Ljava/lang/String; J)Landroid/content/Intent;
    goto +ch
    invoke-direct v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v12
    invoke-virtual v12, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getCodeImageSize()J
    move-result-wide v0
    invoke-virtual v13, v2, v0, v1, Landroid/content/Intent;->putExtra(Ljava/lang/String; J)Landroid/content/Intent;
    iget-object v11, v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->mediaChooseLauncher Landroidx/activity/result/ActivityResultLauncher;
    invoke-virtual v11, v13, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    goto +52h
    iget-object v13, v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    const/4 v0, 0
    if-eqz v13, +018h
    invoke-virtual v13, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v2
    sget-object v4, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-ne v2, v4, +004h
    move v2, v1
    goto +2h
    move v2, v3
    if-eqz v2, +003h
    goto +2h
    move-object v13, v0
    if-eqz v13, +007h
    invoke-virtual v13, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getId()Ljava/lang/String;
    move-result-object v13
    goto +2h
    move-object v13, v0
    iget-object v2, v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v2, +016h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-ne v4, v5, +003h
    goto +2h
    move v1, v3
    if-eqz v1, +003h
    goto +2h
    move-object v2, v0
    if-eqz v2, +006h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getSelectedDirectory()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->Companion Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$Companion;
    invoke-virtual v1, v13, v0, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$Companion;->newInstance(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;
    move-result-object v13
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda57;
    invoke-direct v0, v11, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda57;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v13, v0, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->setOnPluginSelected(Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v11
    const-class v12, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;
    const-string v12, "PluginsBottomSheet"
    invoke-virtual v13, v11, v12, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    goto +4h
    invoke-direct v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->showSkillsForCurrentDevice()V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
.end method

.method private static final setupClickListeners$lambda$35$lambda$34$lambda$33$lambda$29(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.network.PluginItem)kotlin.Unit
    .registers 6
    # ins_size=2
    const-string v0, "plugin"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/widget/PluginTagItem;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/network/PluginItem;->getName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v5, Lcom/bytedance/trae/conversation/network/PluginItem;->getDisplayName()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +006h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/network/PluginItem;->getName()Ljava/lang/String;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_chat_attachment_plugins I
    invoke-virtual v5, Lcom/bytedance/trae/conversation/network/PluginItem;->getIconUrl()Ljava/lang/String;
    move-result-object v5
    invoke-direct v0, v1, v2, v3, v5, Lcom/bytedance/trae/conversation/widget/PluginTagItem;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String;)V
    sget-object v5, Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;->Normal Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    iput-object v5, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->holdToTalkState Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v5
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v5, v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->insertPluginTag(Lcom/bytedance/trae/conversation/widget/PluginTagItem;)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateHoldToTalkUI()V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method

.method private static final setupClickListeners$lambda$35$lambda$34$lambda$33$lambda$32(com.bytedance.trae.conversation.widget.InputFragment)kotlin.Unit
    .registers 2
    # ins_size=1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->cameraPermissionLauncher Landroidx/activity/result/ActivityResultLauncher;
    const-string v0, "android.permission.CAMERA"
    invoke-virtual v1, v0, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final setupClickListeners$lambda$38(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 8
    # ins_size=2
    sget-object v7, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v7
    if-eqz v7, +00eh
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v6
    iget-object v6, v6, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    const/16 v7, 8
    invoke-virtual v6, v7, Landroid/widget/ImageView;->setVisibility(I)V
    return-void 
    iget-boolean v7, v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->infinite Z
    const-string v0, "im_input_flash_icon_click"
    const-string v1, "identity"
    const-string/jumbo v2, status
    const/4 v3, 1
    if-eqz v7, +023h
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v7
    iget-object v7, v7, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_input_bar_express_999 I
    invoke-virtual v7, v4, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-direct v6, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->showExpressPassToggleTooltip(Z)V
    new-instance v6, Lorg/json/JSONObject;
    invoke-direct v6, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v6, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const/16 v7, 100
    invoke-virtual v6, v1, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v7, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v7, v0, v6, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    goto +44h
    sget-object v7, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->isOpenAutoUseExpressPass()Z
    move-result v7
    xor-int/2addr v7, v3
    sget-object v4, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    invoke-virtual v4, v7, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->saveAutoUseExpressPass(Z)V
    if-eqz v7, +00eh
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v4
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->ic_input_bar_use_express_pass I
    invoke-virtual v4, v5, Landroid/widget/ImageView;->setImageResource(I)V
    goto +ch
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v4
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->ic_input_bar_no_use_express_pass I
    invoke-virtual v4, v5, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->showExpressPassToggleTooltip(Z)V
    new-instance v6, Lorg/json/JSONObject;
    invoke-direct v6, Lorg/json/JSONObject;-><init>()V
    if-eqz v7, +006h
    invoke-virtual v6, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    goto +5h
    const/4 v7, 0
    invoke-virtual v6, v2, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-static Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;->getUserPayIdentity()I
    move-result v7
    invoke-virtual v6, v1, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v7, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v7, v0, v6, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x2e
    :try_start_0x69
.end method

.method private static final setupClickListeners$lambda$39(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onChatNewClick Lkotlin/jvm/functions/Function0;
    if-eqz v0, +005h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private static final setupClickListeners$lambda$40(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 3
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->hasInputMessage()Z
    move-result v2
    if-eqz v2, +003h
    return-void 
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/InputTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/InputTracker;
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->isNewConversation Z
    if-eqz v0, +005h
    const-string v0, "new_task"
    goto +4h
    const-string/jumbo v0, task_detail
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/tracker/InputTracker;->trackVoiceInputClick(Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;->HOLD Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->holdToTalkState Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateHoldToTalkUI()V
    sget-object v1, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    const-string v2, "asr_button_click"
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackAsrRecog(Ljava/lang/String;)V
    return-void 
.end method

.method private static final setupClickListeners$lambda$41(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    sget-object v1, Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;->Normal Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->holdToTalkState Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateHoldToTalkUI()V
    return-void 
.end method

.method private static final setupClickListeners$lambda$42(com.bytedance.trae.conversation.widget.InputFragment  android.view.View  android.view.MotionEvent)boolean
    .registers 8
    # ins_size=3
    invoke-virtual v7, Landroid/view/MotionEvent;->getActionMasked()I
    move-result v6
    const/4 v0, 1
    if-eqz v6, +021h
    if-eq v6, v0, +014h
    const/4 v1, 2
    if-eq v6, v1, +006h
    const/4 v1, 3
    if-eq v6, v1, +00eh
    goto +2bh
    iget-boolean v6, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->isLongPressRecording Z
    if-eqz v6, +028h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v5, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->handleLongPressTouch(Landroid/view/MotionEvent;)V
    goto +20h
    iget-boolean v6, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->isLongPressRecording Z
    if-eqz v6, +01dh
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v5, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->handleLongPressTouch(Landroid/view/MotionEvent;)V
    goto +15h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v6
    iget-wide v1, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->lastHoldToTalkPressTime J
    sub-long v1, v6, v1
    const-wide/16 v3, 300
    cmp-long v1, v1, v3
    if-gez v1, +003h
    return v0
    iput-wide v6, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->lastHoldToTalkPressTime J
    invoke-direct v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->startLongPressRecording()V
    return v0
.end method

.method private static final setupClickListeners$lambda$43(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)boolean
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->hasInputMessage()Z
    move-result v1
    if-eqz v1, +004h
    const/4 v0, 0
    return v0
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->startLongPressRecording()V
    const/4 v0, 1
    return v0
.end method

.method private static final setupClickListeners$lambda$44(com.bytedance.trae.conversation.widget.InputFragment  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->isLongPressRecording Z
    if-eqz v1, +00ah
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->handleLongPressTouch(Landroid/view/MotionEvent;)V
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method private static final setupClickListeners$lambda$45(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)boolean
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->hasInputMessage()Z
    move-result v1
    if-nez v1, +013h
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->hasFocus()Z
    move-result v1
    if-nez v1, +007h
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->startLongPressRecording()V
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method private static final setupClickListeners$lambda$48(com.bytedance.trae.conversation.widget.InputFragment  android.view.View  android.view.MotionEvent)boolean
    .registers 7
    # ins_size=3
    invoke-virtual v6, Landroid/view/MotionEvent;->getActionMasked()I
    move-result v5
    const/4 v0, 0
    const/4 v1, 1
    if-eqz v5, +02eh
    if-eq v5, v1, +015h
    const/4 v2, 2
    if-eq v5, v2, +006h
    const/4 v2, 3
    if-eq v5, v2, +00fh
    goto +48h
    iget-boolean v5, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->isLongPressRecording Z
    if-eqz v5, +008h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->handleLongPressTouch(Landroid/view/MotionEvent;)V
    move v0, v1
    goto +3ch
    iget-object v5, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->longPressRunnable Ljava/lang/Runnable;
    if-eqz v5, +007h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->longPressHandler Landroid/os/Handler;
    invoke-virtual v0, v5, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    const/4 v5, 0
    iput-object v5, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->longPressRunnable Ljava/lang/Runnable;
    iget-boolean v5, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->isLongPressRecording Z
    if-eqz v5, -010h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->handleLongPressTouch(Landroid/view/MotionEvent;)V
    goto -18h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->hasInputMessage()Z
    move-result v5
    if-nez v5, +020h
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v5
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->hasFocus()Z
    move-result v5
    if-nez v5, +014h
    new-instance v5, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda48;
    invoke-direct v5, v4, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda48;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    iput-object v5, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->longPressRunnable Ljava/lang/Runnable;
    iget-object v4, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->longPressHandler Landroid/os/Handler;
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const-wide/16 v2, 250
    invoke-virtual v4, v5, v2, v3, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    goto -3ch
    return v0
.end method

.method private static final setupClickListeners$lambda$48$lambda$46(com.bytedance.trae.conversation.widget.InputFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->startLongPressRecording()V
    return-void 
.end method

.method private static final setupClickListeners$lambda$49(com.bytedance.trae.conversation.widget.InputFragment  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->isLongPressRecording Z
    if-eqz v1, +00ah
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->handleLongPressTouch(Landroid/view/MotionEvent;)V
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method private static final setupClickListeners$lambda$50(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onCloudClick Lkotlin/jvm/functions/Function0;
    if-eqz v0, +005h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private static final setupClickListeners$lambda$54(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 9
    # ins_size=2
    invoke-direct v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->isModelSelectorTaskLocked()Z
    move-result v8
    if-eqz v8, +003h
    return-void 
    iget-object v8, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v8, +008h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    if-nez v0, +004h
    iget-object v0, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentCliType Lcom/bytedance/trae/im/service/CliType;
    move-object v3, v0
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->Companion Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$Companion;
    iget-object v0, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->selectedRemoteModel Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getId()Ljava/lang/String;
    move-result-object v2
    iget-object v4, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    const/4 v0, 0
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getId()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v0
    if-nez v5, +004h
    const-string v5, ""
    if-eqz v8, +008h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getIdeVersion()Ljava/lang/String;
    move-result-object v8
    move-object v6, v8
    goto +2h
    move-object v6, v0
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$Companion;->newInstance(Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/conversation/widget/ChatMode; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;
    move-result-object v8
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda45;
    invoke-direct v0, v7, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda45;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v8, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->setOnModelListLoaded(Lkotlin/jvm/functions/Function1;)V
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda46;
    invoke-direct v0, v7, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda46;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v8, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->setOnModelSelected(Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v7
    const-string v0, "ModelSelectBottomSheet"
    invoke-virtual v8, v7, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    return-void 
.end method

.method private static final setupClickListeners$lambda$54$lambda$53$lambda$51(com.bytedance.trae.conversation.widget.InputFragment  java.util.List)kotlin.Unit
    .registers 4
    # ins_size=2
    const-string v0, "models"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->selectedRemoteModel Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-virtual v0, v1, v3, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->resolveValidSelection(Lcom/bytedance/trae/conversation/network/RemoteModelItem; Ljava/util/List;)Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getId()Ljava/lang/String;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->selectedRemoteModel Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +03ch
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    if-nez v0, +005h
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
    iput-object v3, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->selectedRemoteModel Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentConversationId Ljava/lang/String;
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00bh
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    invoke-direct v2, v3, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->saveSelectedModel(Lcom/bytedance/trae/conversation/network/RemoteModelItem; Z)V
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvModelName Landroid/widget/TextView;
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->isManualModelSelectionSupported()Z
    move-result v2
    if-eqz v2, +009h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getDisplayName()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    goto +dh
    sget-object v2, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getDisplayName()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final setupClickListeners$lambda$54$lambda$53$lambda$52(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.network.RemoteModelItem)kotlin.Unit
    .registers 4
    # ins_size=2
    const-string v0, "model"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    if-nez v0, +005h
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
    iput-object v3, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->selectedRemoteModel Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    const/4 v1, 1
    invoke-direct v2, v3, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->saveSelectedModel(Lcom/bytedance/trae/conversation/network/RemoteModelItem; Z)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvModelName Landroid/widget/TextView;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getDisplayName()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v2, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final setupClickListeners$lambda$58(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 3
    # ins_size=2
    sget-object v2, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->Companion Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$Companion;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-nez v0, +008h
    const-string v0, "gitViewModel"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getSelectedRepo()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$Companion;->newInstance(Lcom/bytedance/trae/conversation/git/GitRepoItem;)Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    move-result-object v2
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda44;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda44;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->setOnRepoSelected(Lkotlin/jvm/functions/Function1;)V
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda54;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda54;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->setOnAuthFailed(Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    const-string v0, "GitRepoSelectBottomSheet"
    invoke-virtual v2, v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    return-void 
.end method

.method private static final setupClickListeners$lambda$58$lambda$57$lambda$55(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.git.GitRepoItem)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string/jumbo v0, repo
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-nez v1, +008h
    const-string v1, "gitViewModel"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->selectRepo(Lcom/bytedance/trae/conversation/git/GitRepoItem;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final setupClickListeners$lambda$58$lambda$57$lambda$56(com.bytedance.trae.conversation.widget.InputFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onAuthFailed Lkotlin/jvm/functions/Function0;
    if-eqz v0, +005h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final setupClickListeners$lambda$61(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 3
    # ins_size=2
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    const/4 v0, 0
    if-nez v2, +008h
    const-string v2, "gitViewModel"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getSelectedBranch()Landroidx/lifecycle/LiveData;
    move-result-object v2
    invoke-virtual v2, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/git/BranchItem;
    if-eqz v2, +006h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/git/BranchItem;->getId()Ljava/lang/String;
    move-result-object v0
    sget-object v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->Companion Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$Companion;
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$Companion;->newInstance(Ljava/lang/String;)Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    move-result-object v2
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda50;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda50;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->setOnBranchSelected(Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    const-string v0, "BranchSelectBottomSheet"
    invoke-virtual v2, v1, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    return-void 
.end method

.method private static final setupClickListeners$lambda$61$lambda$60$lambda$59(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.git.BranchItem)kotlin.Unit
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-nez v0, +008h
    const-string v0, "gitViewModel"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->selectBranch(Lcom/bytedance/trae/conversation/git/BranchItem;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final setupClickListeners$lambda$62(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onDeviceClick Lkotlin/jvm/functions/Function0;
    if-eqz v0, +005h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private static final setupClickListeners$lambda$63(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 9
    # ins_size=2
    iget-object v8, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-nez v8, +003h
    return-void 
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    const/4 v3, 0
    if-ne v0, v2, +018h
    iget-boolean v0, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->isNewConversation Z
    if-nez v0, +00eh
    sget-object v0, Lcom/bytedance/trae/conversation/IDEProjectAvailabilityPolicy;->INSTANCE Lcom/bytedance/trae/conversation/IDEProjectAvailabilityPolicy;
    invoke-virtual v0, v8, Lcom/bytedance/trae/conversation/IDEProjectAvailabilityPolicy;->isUnavailable(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)Z
    move-result v0
    if-eqz v0, +006h
    invoke-direct v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->showCurrentDeviceOfflineToast()V
    goto +2fh
    const/4 v0, 0
    const/4 v1, 2
    invoke-static v7, v8, v0, v1, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->showIDEProjectPicker$default(Lcom/bytedance/trae/conversation/widget/InputFragment; Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Z I Ljava/lang/Object;)V
    goto +29h
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->Companion Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$Companion;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    iget-object v8, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getSelectedDirectory()Ljava/lang/String;
    move-result-object v8
    move-object v3, v8
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$Companion;->newInstance$default(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$Companion; Ljava/lang/String; Lcom/bytedance/trae/conversation/widget/ChatMode; Ljava/lang/String; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    move-result-object v8
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$setupClickListeners$19$1;
    invoke-direct v0, v7, Lcom/bytedance/trae/conversation/widget/InputFragment$setupClickListeners$19$1;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    check-cast v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;
    invoke-virtual v8, v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->setOnDirectorySelectedListener(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v7
    const-string v0, "DirectoryBottomSheet"
    invoke-virtual v8, v7, v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    return-void 
.end method

.method private final setupExpressPassBenefit()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v0
    if-eqz v0, +017h
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    const/16 v1, 8
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setVisibility(I)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llExpressPassBenefit Landroid/widget/LinearLayout;
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setVisibility(I)V
    return-void 
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->ivExpressPassBenefitClose Landroid/widget/ImageView;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda30;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda30;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-nez v0, +01fh
    sget-object v0, Lcom/bytedance/trae/conversation/LoginUtils;->INSTANCE Lcom/bytedance/trae/conversation/LoginUtils;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/LoginUtils;->shouldSkipTocCommercialFeatures()Z
    move-result v0
    if-nez v0, +017h
    sget-object v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->remainingChangedListener Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$OnRemainingChangedListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->addRemainingChangedListener(Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$OnRemainingChangedListener;)V
    sget-object v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->benefitSwitchListener Lcom/bytedance/trae/conversation/widget/InputFragment$benefitSwitchListener$1;
    check-cast v1, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$OnBenefitSwitchListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->addBenefitSwitchListener(Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$OnBenefitSwitchListener;)V
    sget-object v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->fetchUserPayIdentity()V
    return-void 
.end method

.method private static final setupExpressPassBenefit$lambda$17(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 4
    # ins_size=2
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v2
    iget-object v2, v2, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llExpressPassBenefit Landroid/widget/LinearLayout;
    const/16 v3, 8
    invoke-virtual v2, v3, Landroid/widget/LinearLayout;->setVisibility(I)V
    sget-object v2, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->INSTANCE Lcom/bytedance/trae/conversation/AccountSettingsKeva;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v2
    const-string v3, "express_pass_benefit_close_time"
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    invoke-virtual v2, v3, v0, v1, Lcom/bytedance/keva/Keva;->storeLong(Ljava/lang/String; J)V
    return-void 
.end method

.method private final setupFileTooLargeObserver()void
    .registers 8
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-direct v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getSingleSize()J
    move-result-wide v1
    const/16 v3, 1024
    int-to-long v3, v3
    div-long/2addr v1, v3
    div-long/2addr v1, v3
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, "MB"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getFileTooLarge()Landroidx/lifecycle/LiveData;
    move-result-object v2
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v5
    new-instance v6, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda11;
    invoke-direct v6, v7, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda11;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$sam$androidx_lifecycle_Observer$0;
    invoke-direct v0, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v0, Landroidx/lifecycle/Observer;
    invoke-virtual v2, v5, v0, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-direct v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getWorkAttachmentTotalSize()J
    move-result-wide v5
    div-long/2addr v5, v3
    div-long/2addr v5, v3
    invoke-virtual v0, v5, v6, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getTotalSizeTooLarge()Landroidx/lifecycle/LiveData;
    move-result-object v1
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda22;
    invoke-direct v3, v7, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda22;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$sam$androidx_lifecycle_Observer$0;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v0, Landroidx/lifecycle/Observer;
    invoke-virtual v1, v2, v0, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    invoke-direct v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getUploadError()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda33;
    invoke-direct v2, v7, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda33;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    new-instance v3, Lcom/bytedance/trae/conversation/widget/InputFragment$sam$androidx_lifecycle_Observer$0;
    invoke-direct v3, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v3, Landroidx/lifecycle/Observer;
    invoke-virtual v0, v1, v3, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    return-void 
.end method

.method private static final setupFileTooLargeObserver$lambda$14(com.bytedance.trae.conversation.widget.InputFragment  java.lang.String  kotlin.Unit)kotlin.Unit
    .registers 7
    # ins_size=3
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v6
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_file_too_large_message I
    const/4 v1, 1
    new-array v2, v1, [Ljava/lang/Object;
    const/4 v3, 0
    aput-object v5, v2, v3
    invoke-virtual v4, v0, v2, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v6, v4, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v4
    invoke-virtual v4, Landroid/widget/Toast;->show()V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method

.method private static final setupFileTooLargeObserver$lambda$15(com.bytedance.trae.conversation.widget.InputFragment  java.lang.String  kotlin.Unit)kotlin.Unit
    .registers 7
    # ins_size=3
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v6
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_total_size_too_large_message I
    const/4 v1, 1
    new-array v2, v1, [Ljava/lang/Object;
    const/4 v3, 0
    aput-object v5, v2, v3
    invoke-virtual v4, v0, v2, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v6, v4, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v4
    invoke-virtual v4, Landroid/widget/Toast;->show()V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method

.method private static final setupFileTooLargeObserver$lambda$16(com.bytedance.trae.conversation.widget.InputFragment  java.lang.String)kotlin.Unit
    .registers 4
    # ins_size=2
    check-cast v3, Ljava/lang/CharSequence;
    const/4 v0, 1
    if-eqz v3, +00bh
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    move v1, v0
    if-nez v1, +00dh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    invoke-static v2, v3, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/Toast;->show()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private final setupGitObservers()void
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    const/4 v1, 0
    const-string v2, "gitViewModel"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getGitConnectionState()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda51;
    invoke-direct v4, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda51;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    new-instance v5, Lcom/bytedance/trae/conversation/widget/InputFragment$sam$androidx_lifecycle_Observer$0;
    invoke-direct v5, v4, Lcom/bytedance/trae/conversation/widget/InputFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v5, Landroidx/lifecycle/Observer;
    invoke-virtual v0, v3, v5, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getSelectedRepo()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda52;
    invoke-direct v4, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda52;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    new-instance v5, Lcom/bytedance/trae/conversation/widget/InputFragment$sam$androidx_lifecycle_Observer$0;
    invoke-direct v5, v4, Lcom/bytedance/trae/conversation/widget/InputFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v5, Landroidx/lifecycle/Observer;
    invoke-virtual v0, v3, v5, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getSelectedBranch()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda53;
    invoke-direct v2, v6, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda53;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    new-instance v3, Lcom/bytedance/trae/conversation/widget/InputFragment$sam$androidx_lifecycle_Observer$0;
    invoke-direct v3, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v3, Landroidx/lifecycle/Observer;
    invoke-virtual v0, v1, v3, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    return-void 
.end method

.method private static final setupGitObservers$lambda$22(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.git.GitConnectionState)kotlin.Unit
    .registers 16
    # ins_size=2
    const-string v0, "optString(...)"
    const-string v1, ""
    sget-object v2, Lcom/bytedance/trae/conversation/git/GitConnectionState;->DISCONNECTED Lcom/bytedance/trae/conversation/git/GitConnectionState;
    if-ne v15, v2, +015h
    invoke-direct v14, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v15
    iget-object v15, v15, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvRepoName Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_connect_github I
    invoke-virtual v14, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->getString(I)Ljava/lang/String;
    move-result-object v14
    check-cast v14, Ljava/lang/CharSequence;
    invoke-virtual v15, v14, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto/16 +0beh
    iget-object v15, v14, Lcom/bytedance/trae/conversation/widget/InputFragment;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    const-string v2, "gitViewModel"
    const/4 v3, 0
    if-nez v15, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v3
    invoke-virtual v15, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getSelectedRepo()Landroidx/lifecycle/LiveData;
    move-result-object v15
    invoke-virtual v15, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v15
    if-eqz v15, +024h
    iget-object v15, v14, Lcom/bytedance/trae/conversation/widget/InputFragment;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-nez v15, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v3
    invoke-virtual v15, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getSelectedRepo()Landroidx/lifecycle/LiveData;
    move-result-object v15
    invoke-virtual v15, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    if-eqz v15, +007h
    invoke-virtual v15, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getId()Ljava/lang/String;
    move-result-object v15
    goto +2h
    move-object v15, v3
    check-cast v15, Ljava/lang/CharSequence;
    invoke-static v15, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v15
    if-eqz v15, +087h
    sget-object v15, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->INSTANCE Lcom/bytedance/trae/conversation/AccountSettingsKeva;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v15
    const-string/jumbo v4, selected_repo
    invoke-virtual v15, v4, v1, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v15
    move-object v4, v15
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +3h
    const/4 v4, 0
    goto +2h
    const/4 v4, 1
    if-nez v4, +046h
    new-instance v4, Lorg/json/JSONObject;
    invoke-direct v4, v15, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    new-instance v15, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    const-string v5, "id"
    invoke-virtual v4, v5, v1, Lorg/json/JSONObject;->optString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v5, title
    invoke-virtual v4, v5, v1, Lorg/json/JSONObject;->optString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v5, subtitle
    invoke-virtual v4, v5, v1, Lorg/json/JSONObject;->optString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v5, repoUrl
    invoke-virtual v4, v5, v1, Lorg/json/JSONObject;->optString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 48
    const/4 v13, 0
    move-object v5, v15
    invoke-direct/range v5 ... v13, Lcom/bytedance/trae/conversation/git/GitRepoItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iget-object v0, v14, Lcom/bytedance/trae/conversation/widget/InputFragment;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v0
    invoke-virtual v3, v15, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->updateSelectRepo(Lcom/bytedance/trae/conversation/git/GitRepoItem;)V
    goto +24h
    invoke-direct v14, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v15
    iget-object v15, v15, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvRepoName Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_input_select_repo I
    invoke-virtual v14, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v15, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto +12h
    invoke-direct v14, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v15
    iget-object v15, v15, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvRepoName Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_input_select_repo I
    invoke-virtual v14, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->getString(I)Ljava/lang/String;
    move-result-object v14
    check-cast v14, Ljava/lang/CharSequence;
    invoke-virtual v15, v14, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
    :try_start_0x1b
    :try_start_0x22
.end method

.method private static final setupGitObservers$lambda$23(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.git.GitRepoItem)kotlin.Unit
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-eqz v4, +02bh
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvRepoName Landroid/widget/TextView;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getSubtitle()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v1, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v4
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvRepoName Landroid/widget/TextView;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v4, v1, Landroid/widget/TextView;->setTextColor(I)V
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateBranchEnabled(Z)V
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateGithubEnabled(Z)V
    goto +2ch
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v4
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvRepoName Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_input_select_repo I
    invoke-virtual v3, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v4, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v4
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvRepoName Landroid/widget/TextView;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v4, v1, Landroid/widget/TextView;->setTextColor(I)V
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateGithubEnabled(Z)V
    const/4 v4, 0
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateBranchEnabled(Z)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateBranchColor()V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private static final setupGitObservers$lambda$24(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.git.BranchItem)kotlin.Unit
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    const-string v1, "gitViewModel"
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getSelectedRepo()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    if-eqz v0, +043h
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getSelectedRepo()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getRepoUrl()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v2
    if-eqz v0, +027h
    if-eqz v4, +025h
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvBranchName Landroid/widget/TextView;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/git/BranchItem;->getName()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v0, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v4
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvBranchName Landroid/widget/TextView;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v4, v0, Landroid/widget/TextView;->setTextColor(I)V
    goto +47h
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v4
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvBranchName Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_input_select_branch I
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v4, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-nez v4, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v2
    invoke-virtual v4, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getSelectedRepo()Landroidx/lifecycle/LiveData;
    move-result-object v4
    invoke-virtual v4, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v4
    if-eqz v4, +021h
    iget-object v4, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-nez v4, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v2
    invoke-virtual v4, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getSelectedRepo()Landroidx/lifecycle/LiveData;
    move-result-object v4
    invoke-virtual v4, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    if-eqz v4, +006h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getRepoUrl()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +007h
    const/4 v4, 1
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateBranchEnabled(Z)V
    goto +5h
    const/4 v4, 0
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateBranchEnabled(Z)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateBranchColor()V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private final setupInputWatcher()void
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$setupInputWatcher$1;
    invoke-direct v1, v4, Lcom/bytedance/trae/conversation/widget/InputFragment$setupInputWatcher$1;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    check-cast v1, Landroid/text/TextWatcher;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->addTextChangedListener(Landroid/text/TextWatcher;)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getAttachments()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda7;
    invoke-direct v2, v4, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    new-instance v3, Lcom/bytedance/trae/conversation/widget/InputFragment$sam$androidx_lifecycle_Observer$0;
    invoke-direct v3, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v3, Landroidx/lifecycle/Observer;
    invoke-virtual v0, v1, v3, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    return-void 
.end method

.method private static final setupInputWatcher$lambda$21(com.bytedance.trae.conversation.widget.InputFragment  java.util.List)kotlin.Unit
    .registers 3
    # ins_size=2
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentInputState Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Sending Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    if-eq v2, v0, +03bh
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentInputState Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Sended Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    if-eq v2, v0, +035h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentInputState Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Stopped Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    if-ne v2, v0, +003h
    goto +2dh
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->canSend()Z
    move-result v2
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnSendText Landroid/widget/ImageView;
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setEnabled(Z)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnSendText Landroid/widget/ImageView;
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setClickable(Z)V
    if-eqz v2, +008h
    sget-object v2, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Input Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setInputState(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V
    goto +ch
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->hasInputMessage()Z
    move-result v2
    if-nez v2, +007h
    sget-object v2, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Empty Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setInputState(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final showCheckedIdeSkillsUnavailableToast(com.bytedance.trae.conversation.devices.SelectedDeviceItem)void
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/skill/SkillEntryPolicy;->INSTANCE Lcom/bytedance/trae/conversation/skill/SkillEntryPolicy;
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/skill/SkillEntryPolicy;->unavailableToastForCheckedIdeSkills(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)Lcom/bytedance/trae/conversation/skill/SkillEntryUnavailableToast;
    move-result-object v3
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$WhenMappings;->$EnumSwitchMapping$4 [I
    invoke-virtual v3, Lcom/bytedance/trae/conversation/skill/SkillEntryUnavailableToast;->ordinal()I
    move-result v3
    aget v3, v0, v3
    const/4 v0, 1
    if-eq v3, v0, +00eh
    const/4 v0, 2
    if-ne v3, v0, +005h
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_device_currently_offline I
    goto +9h
    new-instance v3, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v3, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v3
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_device_workspace_closed I
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    const/4 v1, 0
    invoke-static v0, v3, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v3
    invoke-virtual v3, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private final showCurrentDeviceOfflineToast()void
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_device_currently_offline I
    const/4 v2, 0
    invoke-static v0, v1, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private static final showDeviceTipsPopWindow$lambda$113(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->dismissDeviceTipsPopWindow()V
    return-void 
.end method

.method private final showExpressPassBtn(boolean)void
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v0
    const/16 v1, 8
    const/4 v2, 0
    if-eqz v0, +00eh
    iput-boolean v2, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->isExpressPassVisible Z
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v4
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    invoke-virtual v4, v1, Landroid/widget/ImageView;->setVisibility(I)V
    return-void 
    iput-boolean v4, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->isExpressPassVisible Z
    if-eqz v4, +03bh
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v4
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    invoke-virtual v4, v2, Landroid/widget/ImageView;->setVisibility(I)V
    iget-boolean v4, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->infinite Z
    if-eqz v4, +00eh
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v4
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->ic_input_bar_express_999 I
    invoke-virtual v4, v0, Landroid/widget/ImageView;->setImageResource(I)V
    goto +2ah
    sget-object v4, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->isOpenAutoUseExpressPass()Z
    move-result v4
    if-eqz v4, +00eh
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v4
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->ic_input_bar_use_express_pass I
    invoke-virtual v4, v0, Landroid/widget/ImageView;->setImageResource(I)V
    goto +16h
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v4
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->ic_input_bar_no_use_express_pass I
    invoke-virtual v4, v0, Landroid/widget/ImageView;->setImageResource(I)V
    goto +ah
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v4
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    invoke-virtual v4, v1, Landroid/widget/ImageView;->setVisibility(I)V
    return-void 
.end method

.method private final showExpressPassPopWindow()void
    .registers 12
    # ins_size=1
    const-string v0, "defaultArrowCenterPx:"
    iget-object v1, v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    if-nez v1, +003h
    return-void 
    invoke-direct v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->dismissExpressPassPopWindow()V
    invoke-virtual v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->density F
    invoke-virtual v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    invoke-static v2, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/conversation/R$layout;->trae_express_pass_pop_window I
    const/4 v4, 0
    invoke-virtual v2, v3, v4, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup;)Landroid/view/View;
    move-result-object v2
    invoke-virtual v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->getContext()Landroid/content/Context;
    move-result-object v3
    const-string v5, "getResources(...)"
    const/4 v6, 0
    if-eqz v3, +022h
    sget v7, Lcom/bytedance/trae/conversation/R$id;->tv_express_pass_title I
    invoke-virtual v2, v7, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v7
    check-cast v7, Landroid/widget/TextView;
    if-eqz v7, +018h
    sget-object v8, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual v3, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    invoke-static v3, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v9, Lcom/bytedance/trae/multilanguage/R$string;->imkit_fast_pass_onbording_title I
    new-array v10, v6, [Ljava/lang/Object;
    invoke-virtual v8, v3, v9, v10, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v7, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->getContext()Landroid/content/Context;
    move-result-object v3
    if-eqz v3, +022h
    sget v7, Lcom/bytedance/trae/conversation/R$id;->tv_express_pass_subtitle I
    invoke-virtual v2, v7, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v7
    check-cast v7, Landroid/widget/TextView;
    if-eqz v7, +018h
    sget-object v8, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual v3, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    invoke-static v3, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->imkit_fast_pass_onbording_desc I
    new-array v9, v6, [Ljava/lang/Object;
    invoke-virtual v8, v3, v5, v9, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v7, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v3, Lcom/bytedance/trae/conversation/R$id;->express_pass_close I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    if-eqz v3, +00ah
    new-instance v5, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda40;
    invoke-direct v5, v11, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda40;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v3, v5, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v3, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v5
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;-><init>(Landroid/content/Context;)V
    check-cast v3, Landroid/graphics/drawable/Drawable;
    invoke-virtual v2, v3, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V
    const/4 v3, 1
    invoke-virtual v2, v3, v4, Landroid/view/View;->setLayerType(I Landroid/graphics/Paint;)V
    invoke-static v6, v6, Landroid/view/View$MeasureSpec;->makeMeasureSpec(I I)I
    move-result v4
    invoke-static v6, v6, Landroid/view/View$MeasureSpec;->makeMeasureSpec(I I)I
    move-result v5
    invoke-virtual v2, v4, v5, Landroid/view/View;->measure(I I)V
    invoke-virtual v2, Landroid/view/View;->getMeasuredWidth()I
    move-result v4
    invoke-virtual v2, Landroid/view/View;->getMeasuredHeight()I
    move-result v5
    invoke-direct v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v6
    iget-object v6, v6, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    const-string v7, "btnExpressPass"
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, Landroid/widget/ImageView;->isAttachedToWindow()Z
    move-result v7
    if-nez v7, +003h
    return-void 
    const/high16 v7, 1112801280
    mul-float/2addr v7, v1
    const/16 v8, 16
    int-to-float v8, v8
    mul-float/2addr v8, v1
    float-to-int v8, v8
    int-to-float v8, v8
    sub-float/2addr v8, v7
    float-to-int v7, v8
    const-string v8, "ExpressPassBenefitManager"
    new-instance v9, Ljava/lang/StringBuilder;
    invoke-direct v9, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, Landroid/widget/ImageView;->getWidth()I
    move-result v0
    invoke-virtual v9, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v8, v0, Lcom/facebook/common/logging/FLog;->d(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Landroid/widget/PopupWindow;
    invoke-direct v0, v2, v4, v5, v3, Landroid/widget/PopupWindow;-><init>(Landroid/view/View; I I Z)V
    invoke-virtual v0, v3, Landroid/widget/PopupWindow;->setOutsideTouchable(Z)V
    const/16 v3, 32
    int-to-float v3, v3
    mul-float/2addr v3, v1
    float-to-int v3, v3
    add-int/2addr v5, v3
    neg-int v3, v5
    check-cast v6, Landroid/view/View;
    invoke-virtual v0, v6, v7, v3, Landroid/widget/PopupWindow;->showAsDropDown(Landroid/view/View; I I)V
    iput-object v0, v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->expressPassPopWindow Landroid/widget/PopupWindow;
    const/4 v0, 0
    invoke-virtual v2, v0, Landroid/view/View;->setAlpha(F)V
    const/high16 v3, 1086324736
    mul-float/2addr v1, v3
    invoke-virtual v2, v1, Landroid/view/View;->setTranslationY(F)V
    invoke-virtual v2, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;
    move-result-object v1
    const/high16 v3, 1065353216
    invoke-virtual v1, v3, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;
    move-result-object v1
    invoke-virtual v1, v0, Landroid/view/ViewPropertyAnimator;->translationY(F)Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    const-wide/16 v3, 220
    invoke-virtual v0, v3, v4, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    new-instance v1, Landroid/view/animation/DecelerateInterpolator;
    invoke-direct v1, Landroid/view/animation/DecelerateInterpolator;-><init>()V
    check-cast v1, Landroid/animation/TimeInterpolator;
    invoke-virtual v0, v1, Landroid/view/ViewPropertyAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    invoke-virtual v0, Landroid/view/ViewPropertyAnimator;->start()V
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda41;
    invoke-direct v0, v11, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda41;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    iput-object v0, v11, Lcom/bytedance/trae/conversation/widget/InputFragment;->expressPassPopDismissRunnable Ljava/lang/Runnable;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const-wide/16 v3, 2000
    invoke-virtual v2, v0, v3, v4, Landroid/view/View;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
    :try_start_0x2
    :try_start_0x2c
.end method

.method private static final showExpressPassPopWindow$lambda$100(com.bytedance.trae.conversation.widget.InputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->dismissExpressPassPopWindow()V
    return-void 
.end method

.method private static final showExpressPassPopWindow$lambda$102(com.bytedance.trae.conversation.widget.InputFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->dismissExpressPassPopWindow()V
    return-void 
.end method

.method private final showExpressPassToggleTooltip(boolean)void
    .registers 12
    # ins_size=2
    const-string v0, "btnExpressPass"
    iget-object v1, v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    if-nez v1, +003h
    return-void 
    invoke-direct v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->dismissExpressPassToggleTooltip()V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->density F
    invoke-virtual v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    invoke-static v2, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/conversation/R$layout;->trae_express_pass_toggle_tooltip I
    const/4 v4, 0
    invoke-virtual v2, v3, v4, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup;)Landroid/view/View;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v5
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;-><init>(Landroid/content/Context;)V
    const/high16 v5, 1094713344
    invoke-virtual v3, v5, v1, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->setCornerRadius(F F)V
    check-cast v3, Landroid/graphics/drawable/Drawable;
    invoke-virtual v2, v3, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V
    const/4 v3, 1
    invoke-virtual v2, v3, v4, Landroid/view/View;->setLayerType(I Landroid/graphics/Paint;)V
    sget v4, Lcom/bytedance/trae/conversation/R$id;->tv_toggle_text I
    invoke-virtual v2, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    check-cast v4, Landroid/widget/TextView;
    iget-boolean v6, v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->infinite Z
    const-string v7, "getResources(...)"
    const/4 v8, 0
    if-eqz v6, +01fh
    invoke-virtual v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->getContext()Landroid/content/Context;
    move-result-object v11
    if-eqz v11, +03ah
    sget-object v6, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual v11, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v11
    invoke-static v11, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v7, Lcom/bytedance/trae/multilanguage/R$string;->imkit_fast_pass_999 I
    new-array v9, v8, [Ljava/lang/Object;
    invoke-virtual v6, v11, v7, v9, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    check-cast v11, Ljava/lang/CharSequence;
    invoke-virtual v4, v11, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto +22h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->getContext()Landroid/content/Context;
    move-result-object v6
    if-eqz v6, +01dh
    sget-object v9, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual v6, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v6
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v11, +005h
    sget v11, Lcom/bytedance/trae/multilanguage/R$string;->imkit_fast_pass_activated I
    goto +3h
    sget v11, Lcom/bytedance/trae/multilanguage/R$string;->imkit_fast_pass_disabled I
    new-array v7, v8, [Ljava/lang/Object;
    invoke-virtual v9, v6, v11, v7, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    check-cast v11, Ljava/lang/CharSequence;
    invoke-virtual v4, v11, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-static v8, v8, Landroid/view/View$MeasureSpec;->makeMeasureSpec(I I)I
    move-result v11
    invoke-static v8, v8, Landroid/view/View$MeasureSpec;->makeMeasureSpec(I I)I
    move-result v4
    invoke-virtual v2, v11, v4, Landroid/view/View;->measure(I I)V
    invoke-virtual v2, Landroid/view/View;->getMeasuredWidth()I
    move-result v11
    invoke-virtual v2, Landroid/view/View;->getMeasuredHeight()I
    move-result v4
    invoke-direct v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v6
    iget-object v6, v6, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, Landroid/widget/ImageView;->isAttachedToWindow()Z
    move-result v7
    if-nez v7, +003h
    return-void 
    iput-object v2, v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->tooltipPopView Landroid/view/View;
    new-instance v7, Landroid/widget/PopupWindow;
    invoke-direct v7, v2, v11, v4, v3, Landroid/widget/PopupWindow;-><init>(Landroid/view/View; I I Z)V
    invoke-virtual v7, v3, Landroid/widget/PopupWindow;->setOutsideTouchable(Z)V
    new-instance v11, Landroid/graphics/drawable/ColorDrawable;
    invoke-direct v11, v8, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v11, Landroid/graphics/drawable/Drawable;
    invoke-virtual v7, v11, Landroid/widget/PopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    mul-float/2addr v5, v1
    invoke-virtual v7, v5, Landroid/widget/PopupWindow;->setElevation(F)V
    invoke-direct v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v11
    iget-object v11, v11, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 2
    new-array v0, v0, [I
    invoke-virtual v11, v0, Landroid/widget/ImageView;->getLocationInWindow([I)V
    const/16 v3, 18
    int-to-float v3, v3
    mul-float/2addr v3, v1
    float-to-int v3, v3
    aget v0, v0, v8
    sub-int/2addr v3, v0
    const/16 v0, 32
    int-to-float v0, v0
    mul-float/2addr v0, v1
    float-to-int v0, v0
    add-int/2addr v4, v0
    neg-int v0, v4
    check-cast v11, Landroid/view/View;
    invoke-virtual v7, v11, v3, v0, Landroid/widget/PopupWindow;->showAsDropDown(Landroid/view/View; I I)V
    iput-object v7, v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->expressPassTogglePopWindow Landroid/widget/PopupWindow;
    new-instance v11, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda42;
    invoke-direct v11, v10, v6, v2, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda42;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/widget/ImageView; Landroid/view/View; F)V
    iput-object v11, v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->tooltipArrowRunnable Ljava/lang/Runnable;
    invoke-virtual v2, v11, Landroid/view/View;->post(Ljava/lang/Runnable;)Z
    const/4 v11, 0
    invoke-virtual v2, v11, Landroid/view/View;->setAlpha(F)V
    const/high16 v0, 1086324736
    mul-float/2addr v1, v0
    invoke-virtual v2, v1, Landroid/view/View;->setTranslationY(F)V
    invoke-virtual v2, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    const/high16 v1, 1065353216
    invoke-virtual v0, v1, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    invoke-virtual v0, v11, Landroid/view/ViewPropertyAnimator;->translationY(F)Landroid/view/ViewPropertyAnimator;
    move-result-object v11
    const-wide/16 v0, 220
    invoke-virtual v11, v0, v1, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;
    move-result-object v11
    new-instance v0, Landroid/view/animation/DecelerateInterpolator;
    invoke-direct v0, Landroid/view/animation/DecelerateInterpolator;-><init>()V
    check-cast v0, Landroid/animation/TimeInterpolator;
    invoke-virtual v11, v0, Landroid/view/ViewPropertyAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)Landroid/view/ViewPropertyAnimator;
    move-result-object v11
    invoke-virtual v11, Landroid/view/ViewPropertyAnimator;->start()V
    new-instance v11, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda43;
    invoke-direct v11, v10, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda43;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    iput-object v11, v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->tooltipDismissRunnable Ljava/lang/Runnable;
    invoke-static v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const-wide/16 v0, 2000
    invoke-virtual v2, v11, v0, v1, Landroid/view/View;->postDelayed(Ljava/lang/Runnable; J)Z
    goto +4h
    invoke-direct v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->dismissExpressPassToggleTooltip()V
    return-void 
    :try_start_0x2
    :try_start_0x49
.end method

.method private static final showExpressPassToggleTooltip$lambda$108(com.bytedance.trae.conversation.widget.InputFragment  android.widget.ImageView  android.view.View  float)void
    .registers 7
    # ins_size=4
    iget-object v3, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    if-nez v3, +003h
    return-void 
    const/4 v3, 2
    new-array v0, v3, [I
    invoke-virtual v4, v0, Landroid/widget/ImageView;->getLocationOnScreen([I)V
    new-array v3, v3, [I
    invoke-virtual v5, v3, Landroid/view/View;->getLocationOnScreen([I)V
    const/4 v1, 0
    aget v0, v0, v1
    int-to-float v0, v0
    invoke-virtual v4, Landroid/widget/ImageView;->getWidth()I
    move-result v4
    int-to-float v4, v4
    const/high16 v2, 1073741824
    div-float/2addr v4, v2
    add-float/2addr v0, v4
    aget v3, v3, v1
    int-to-float v3, v3
    sub-float/2addr v0, v3
    invoke-virtual v5, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;
    move-result-object v3
    instance-of v4, v3, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;
    if-eqz v4, +005h
    check-cast v3, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;
    goto +2h
    const/4 v3, 0
    if-eqz v3, +006h
    div-float/2addr v0, v6
    invoke-virtual v3, v0, v6, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->setArrowCenterX(F F)V
    return-void 
.end method

.method private static final showExpressPassToggleTooltip$lambda$109(com.bytedance.trae.conversation.widget.InputFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->dismissExpressPassToggleTooltip()V
    return-void 
.end method

.method private final showIDEProjectPicker(com.bytedance.trae.conversation.devices.SelectedDeviceItem  boolean)void
    .registers 6
    # ins_size=3
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->Companion Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getProjectId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$Companion;->newInstance(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputFragment$showIDEProjectPicker$1;
    invoke-direct v1, v3, v4, v5, Lcom/bytedance/trae/conversation/widget/InputFragment$showIDEProjectPicker$1;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment; Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Z)V
    check-cast v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$OnProjectSelectedListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->setProjectSelected(Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$OnProjectSelectedListener;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v4
    const-string v5, "IDEProjectBottomSheet"
    invoke-virtual v0, v4, v5, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    return-void 
.end method

.method static synthetic showIDEProjectPicker$default(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.devices.SelectedDeviceItem  boolean  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->showIDEProjectPicker(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Z)V
    return-void 
.end method

.method private final showSkillsBottomSheet(java.lang.String  java.lang.String  java.lang.String  boolean  java.lang.String)void
    .registers 14
    # ins_size=6
    sget-object v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->Companion Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$Companion;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->getSkillsForRequest()Ljava/lang/String;
    move-result-object v6
    iget-object v1, v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v1, +01ah
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v1
    if-eqz v1, +014h
    sget-object v2, Lcom/bytedance/trae/conversation/AgentResolver;->INSTANCE Lcom/bytedance/trae/conversation/AgentResolver;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v4, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v3, v4, +005h
    sget-object v3, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    goto +3h
    sget-object v3, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v2, v3, v1, Lcom/bytedance/trae/conversation/AgentResolver;->resolveDefaultAgentType(Lcom/bytedance/trae/im/service/Mode; Lcom/bytedance/trae/im/service/CliType;)Ljava/lang/String;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    move-object v7, v1
    move-object v1, v9
    move-object v2, v10
    move-object v3, v11
    move v4, v12
    move-object v5, v13
    invoke-virtual/range v0 ... v7, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$Companion;->newInstance(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;
    move-result-object v9
    new-instance v10, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda31;
    invoke-direct v10, v8, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda31;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v9, v10, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->setOnSkillSelected(Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v10
    const-class v11, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;
    const-string v11, "SkillsBottomSheet"
    invoke-virtual v9, v10, v11, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    return-void 
.end method

.method static synthetic showSkillsBottomSheet$default(com.bytedance.trae.conversation.widget.InputFragment  java.lang.String  java.lang.String  java.lang.String  boolean  java.lang.String  int  java.lang.Object)void
    .registers 14
    # ins_size=8
    and-int/lit8 v12, v12, 16
    if-eqz v12, +003h
    const/4 v11, 0
    move-object v5, v11
    move-object v0, v6
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    move v4, v10
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->showSkillsBottomSheet(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String;)V
    return-void 
.end method

.method private static final showSkillsBottomSheet$lambda$68(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.network.SkillItem)kotlin.Unit
    .registers 5
    # ins_size=2
    const-string v0, "networkSkill"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/widget/SkillItem;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/SkillItem;->getSkillId()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    const-string v1, ""
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/SkillItem;->getName()Ljava/lang/String;
    move-result-object v4
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->ic_input_skill I
    invoke-direct v0, v1, v4, v2, Lcom/bytedance/trae/conversation/widget/SkillItem;-><init>(Ljava/lang/String; Ljava/lang/String; I)V
    sget-object v4, Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;->Normal Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    iput-object v4, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->holdToTalkState Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v4
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->insertSkillTag(Lcom/bytedance/trae/conversation/widget/SkillItem;)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateHoldToTalkUI()V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private final showSkillsBottomSheetForDevice(com.bytedance.trae.conversation.devices.SelectedDeviceItem)void
    .registers 18
    # ins_size=2
    if-eqz v17, +007h
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const/4 v0, -1
    goto +9h
    sget-object v1, Lcom/bytedance/trae/conversation/widget/InputFragment$WhenMappings;->$EnumSwitchMapping$3 [I
    invoke-virtual v0, Lcom/bytedance/trae/im/service/CliType;->ordinal()I
    move-result v0
    aget v0, v1, v0
    const/4 v1, 1
    if-eq v0, v1, +02ch
    const/4 v1, 2
    if-eq v0, v1, +012h
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 16
    const/4 v9, 0
    move-object/from16 v2, v16
    invoke-static/range v2 ... v9, Lcom/bytedance/trae/conversation/widget/InputFragment;->showSkillsBottomSheet$default(Lcom/bytedance/trae/conversation/widget/InputFragment; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; I Ljava/lang/Object;)V
    move-object/from16 v8, v16
    goto +2dh
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getId()Ljava/lang/String;
    move-result-object v11
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getSelectedDirectory()Ljava/lang/String;
    move-result-object v12
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getProjectId()Ljava/lang/String;
    move-result-object v13
    const/4 v14, 1
    move-object/from16 v8, v16
    iget-object v15, v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentConversationId Ljava/lang/String;
    move-object/from16 v10, v16
    invoke-direct/range v10 ... v15, Lcom/bytedance/trae/conversation/widget/InputFragment;->showSkillsBottomSheet(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String;)V
    goto +16h
    move-object/from16 v8, v16
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getSelectedDirectory()Ljava/lang/String;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 16
    const/4 v7, 0
    move-object/from16 v0, v16
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->showSkillsBottomSheet$default(Lcom/bytedance/trae/conversation/widget/InputFragment; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method private final showSkillsForCurrentDevice()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    sget-object v1, Lcom/bytedance/trae/conversation/skill/SkillEntryPolicy;->INSTANCE Lcom/bytedance/trae/conversation/skill/SkillEntryPolicy;
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->isNewConversation Z
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/conversation/skill/SkillEntryPolicy;->actionFor(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Z)Lcom/bytedance/trae/conversation/skill/SkillEntryAction;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/widget/InputFragment$WhenMappings;->$EnumSwitchMapping$2 [I
    invoke-virtual v1, Lcom/bytedance/trae/conversation/skill/SkillEntryAction;->ordinal()I
    move-result v1
    aget v1, v2, v1
    const/4 v2, 1
    if-eq v1, v2, +028h
    const/4 v3, 2
    if-eq v1, v3, +011h
    const/4 v0, 3
    if-ne v1, v0, +008h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    invoke-direct v4, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->showSkillsBottomSheetForDevice(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)V
    goto +1eh
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v1, v3, +006h
    invoke-direct v4, v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->showIDEProjectPicker(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Z)V
    goto +8h
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->showCurrentDeviceOfflineToast()V
    goto +4h
    invoke-direct v4, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->showSkillsBottomSheetForDevice(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)V
    return-void 
.end method

.method private static final showTaskTemplates$lambda$74(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.network.TaskTemplateRepository$TaskTemplateModel)kotlin.Unit
    .registers 4
    # ins_size=2
    const-string/jumbo v0, template
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->hideKeyboard()V
    const/4 v0, 1
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->setSendingState(Z)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v0, v1, +046h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-nez v0, +008h
    const-string v0, "gitViewModel"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getSelectedRepo()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    if-eqz v0, +026h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->getGitPrompt()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v0
    if-nez v0, +00eh
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->onTemplateClick Lkotlin/jvm/functions/Function1;
    if-eqz v0, +02dh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->getGitPrompt()Ljava/lang/String;
    move-result-object v3
    invoke-interface v0, v3, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto +24h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->onTemplateClick Lkotlin/jvm/functions/Function1;
    if-eqz v0, +021h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->getPrompt()Ljava/lang/String;
    move-result-object v3
    invoke-interface v0, v3, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto +18h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->onTemplateClick Lkotlin/jvm/functions/Function1;
    if-eqz v0, +015h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->getPrompt()Ljava/lang/String;
    move-result-object v3
    invoke-interface v0, v3, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto +ch
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->onTemplateClick Lkotlin/jvm/functions/Function1;
    if-eqz v0, +009h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->getPrompt()Ljava/lang/String;
    move-result-object v3
    invoke-interface v0, v3, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->hideTaskTemplates()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private final showVoiceLoading()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->voiceLoadingView Landroid/view/View;
    if-eqz v0, +003h
    return-void 
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Landroidx/fragment/app/FragmentActivity;->getWindow()Landroid/view/Window;
    move-result-object v0
    invoke-virtual v0, Landroid/view/Window;->getDecorView()Landroid/view/View;
    move-result-object v0
    instance-of v1, v0, Landroid/view/ViewGroup;
    if-eqz v1, +005h
    check-cast v0, Landroid/view/ViewGroup;
    goto +2h
    const/4 v0, 0
    if-nez v0, +003h
    return-void 
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    invoke-static v1, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/conversation/R$layout;->loading_progress_bar_voice I
    const/4 v3, 0
    invoke-virtual v1, v2, v0, v3, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v1
    invoke-virtual v0, v1, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    iput-object v1, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->voiceLoadingView Landroid/view/View;
    return-void 
    :try_start_0x0
.end method

.method private final startLongPressRecording()void
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->isNetworkAvailable()Z
    move-result v0
    const-string/jumbo v1, start_failed
    const/4 v2, 0
    if-nez v0, +01bh
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->voice_network_unavailable I
    invoke-static v0, v3, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->Companion Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Companion;
    const-string v2, "network_unavailable"
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentInputStateNameForMetrics()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Companion;->reportImmediateAttemptEnd(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    const/4 v0, 1
    iput-boolean v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->isLongPressRecording Z
    iput-boolean v2, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->isLongPressCancelled Z
    iput-boolean v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->needTranscript Z
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->ensureRecordAudioPermission()Z
    move-result v0
    if-eqz v0, +023h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->voiceRecordingOverlay Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->show()V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->voiceChatSessionManager Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    if-nez v0, +009h
    const-string/jumbo v0, voiceChatSessionManager
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    iget-object v1, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->voiceChatListener Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;
    check-cast v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Listener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->start(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Listener;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    const-string v1, "asr_recog_start"
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackAsrRecog(Ljava/lang/String;)V
    goto +ch
    sget-object v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->Companion Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Companion;
    const-string v2, "permission_not_granted"
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentInputStateNameForMetrics()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Companion;->reportImmediateAttemptEnd(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private static final takePictureLauncher$lambda$7(com.bytedance.trae.conversation.widget.InputFragment  java.lang.Boolean)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->pendingCameraUri Landroid/net/Uri;
    const/4 v1, 0
    iput-object v1, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->pendingCameraUri Landroid/net/Uri;
    invoke-virtual v4, Ljava/lang/Boolean;->booleanValue()Z
    move-result v4
    if-eqz v4, +03dh
    if-eqz v0, +03bh
    iget-object v4, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v4, v1, +020h
    sget-object v4, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;->Companion Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    const-string/jumbo v2, requireContext(...)
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, v1, v0, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$Companion;->queryMediaItem(Landroid/content/Context; Landroid/net/Uri;)Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    move-result-object v4
    if-eqz v4, +030h
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v3
    invoke-static v4, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v4
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->addImages(Ljava/util/List;)V
    goto +23h
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v4
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v3
    invoke-virtual v3, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v3
    const-string v1, "getApplicationContext(...)"
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, v0, v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->addAttachment(Landroid/net/Uri; Landroid/content/Context;)V
    goto +eh
    if-eqz v0, +00dh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v3
    invoke-virtual v3, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v3
    invoke-virtual v3, v0, v1, v1, Landroid/content/ContentResolver;->delete(Landroid/net/Uri; Ljava/lang/String; [Ljava/lang/String;)I
    return-void 
    :try_start_0x48
.end method

.method private final unregisterKeyboardListener()void
    .registers 3
    # ins_size=1
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->isKeyboardListenerRegistered Z
    if-eqz v0, +016h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getView()Landroid/view/View;
    move-result-object v0
    if-eqz v0, +00dh
    invoke-virtual v0, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;
    move-result-object v0
    if-eqz v0, +007h
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->keyboardLayoutListener Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;
    invoke-virtual v0, v1, Landroid/view/ViewTreeObserver;->removeOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    const/4 v0, 0
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->isKeyboardListenerRegistered Z
    return-void 
.end method

.method private final updateBranchColor()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    const-string v1, "gitViewModel"
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getSelectedRepo()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    if-eqz v0, +095h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getSelectedRepo()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getRepoUrl()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v2
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v0
    if-nez v0, +073h
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnBranch Landroid/widget/LinearLayout;
    const/4 v3, 1
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setEnabled(Z)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnBranch Landroid/widget/LinearLayout;
    const/high16 v3, 1065353216
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setAlpha(F)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getSelectedBranch()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    if-nez v0, +02ch
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvBranchName Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_input_select_branch I
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->imgSelectBranch Landroid/widget/ImageView;
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->git_branches_pupple I
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvBranchName Landroid/widget/TextView;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_brand I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v0, v1, Landroid/widget/TextView;->setTextColor(I)V
    goto +5eh
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->imgSelectBranch Landroid/widget/ImageView;
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->git_branches_enable I
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvBranchName Landroid/widget/TextView;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v0, v1, Landroid/widget/TextView;->setTextColor(I)V
    goto +3fh
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvBranchName Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_input_select_branch I
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnBranch Landroid/widget/LinearLayout;
    const/high16 v1, 1056964608
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setAlpha(F)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnBranch Landroid/widget/LinearLayout;
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setEnabled(Z)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvBranchName Landroid/widget/TextView;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v0, v1, Landroid/widget/TextView;->setTextColor(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->imgSelectBranch Landroid/widget/ImageView;
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->git_branches I
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setImageResource(I)V
    return-void 
.end method

.method private final updateBranchEnabled(boolean)void
    .registers 4
    # ins_size=2
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnBranch Landroid/widget/LinearLayout;
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setEnabled(Z)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnBranch Landroid/widget/LinearLayout;
    if-eqz v3, +005h
    const/high16 v1, 1065353216
    goto +3h
    const/high16 v1, 1056964608
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setAlpha(F)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->imgSelectBranch Landroid/widget/ImageView;
    if-eqz v3, +005h
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->git_branches_enable I
    goto +3h
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->git_branches I
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setImageResource(I)V
    if-nez v3, +016h
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v3
    iget-object v3, v3, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvBranchName Landroid/widget/TextView;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v3, v0, Landroid/widget/TextView;->setTextColor(I)V
    goto +14h
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v3
    iget-object v3, v3, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvBranchName Landroid/widget/TextView;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v3, v0, Landroid/widget/TextView;->setTextColor(I)V
    return-void 
.end method

.method private final updateContextualBar()void
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->contextualBarVisibilityState Lcom/bytedance/trae/conversation/widget/InputContextualBarVisibilityState;
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v0, +004h
    move v4, v2
    goto +2h
    move v4, v3
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/widget/InputContextualBarVisibilityState;->shouldShowForDevice(Z)Z
    move-result v1
    const/16 v4, 8
    if-eqz v1, +153h
    if-nez v0, +004h
    goto/16 +14fh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v1
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-ne v1, v5, +067h
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->bottomContextualBar Landroid/widget/FrameLayout;
    invoke-virtual v0, v3, Landroid/widget/FrameLayout;->setVisibility(I)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llCloudContent Landroid/widget/LinearLayout;
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llCloud Landroid/widget/LinearLayout;
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llDeviceFolderBar Landroid/widget/LinearLayout;
    invoke-virtual v0, v4, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvCloudName Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_input_cloud I
    invoke-virtual v6, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->ivCloudIcon Landroid/widget/ImageView;
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->ic_input_bar_remote I
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setImageResource(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v0, v1, +003h
    goto +2h
    move v2, v3
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnGithub Landroid/widget/LinearLayout;
    if-eqz v2, +004h
    move v1, v3
    goto +2h
    move v1, v4
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnBranch Landroid/widget/LinearLayout;
    if-eqz v2, +003h
    goto +2h
    move v3, v4
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setVisibility(I)V
    goto/16 +0deh
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->bottomContextualBar Landroid/widget/FrameLayout;
    invoke-virtual v1, v3, Landroid/widget/FrameLayout;->setVisibility(I)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llDeviceFolderBar Landroid/widget/LinearLayout;
    invoke-virtual v1, v3, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llCloudContent Landroid/widget/LinearLayout;
    invoke-virtual v1, v4, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llCloud Landroid/widget/LinearLayout;
    invoke-virtual v1, v4, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-boolean v1, v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->hasMultipleProducts Z
    if-eqz v1, +034h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-ne v1, v2, +017h
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->ivDeviceBadge Landroid/widget/ImageView;
    invoke-virtual v1, v3, Landroid/widget/ImageView;->setVisibility(I)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->ivDeviceBadge Landroid/widget/ImageView;
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->ic_device_badge_lite I
    invoke-virtual v1, v2, Landroid/widget/ImageView;->setImageResource(I)V
    goto +1fh
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->ivDeviceBadge Landroid/widget/ImageView;
    invoke-virtual v1, v3, Landroid/widget/ImageView;->setVisibility(I)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->ivDeviceBadge Landroid/widget/ImageView;
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->ic_device_badge_ide I
    invoke-virtual v1, v2, Landroid/widget/ImageView;->setImageResource(I)V
    goto +ah
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->ivDeviceBadge Landroid/widget/ImageView;
    invoke-virtual v1, v4, Landroid/widget/ImageView;->setVisibility(I)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvDeviceName Landroid/widget/TextView;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getName()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    const-string v4, "getString(...)"
    if-ne v1, v2, +020h
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvFolderName Landroid/widget/TextView;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getProjectName()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +005h
    check-cast v0, Ljava/lang/CharSequence;
    goto +ch
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_input_select_folder I
    invoke-virtual v6, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v1, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto +22h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getSelectedDirectory()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v6, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->parseWorkspaceDisplayName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvFolderName Landroid/widget/TextView;
    if-eqz v0, +005h
    check-cast v0, Ljava/lang/CharSequence;
    goto +ch
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_input_select_folder I
    invoke-virtual v6, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v1, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-eq v0, v1, +00ch
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnChatNew Landroid/widget/ImageView;
    invoke-virtual v0, v3, Landroid/widget/ImageView;->setVisibility(I)V
    goto +ah
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnSendText Landroid/widget/ImageView;
    invoke-virtual v0, v3, Landroid/widget/ImageView;->setVisibility(I)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateModelSelectorVisibility()V
    return-void 
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->bottomContextualBar Landroid/widget/FrameLayout;
    invoke-virtual v0, v4, Landroid/widget/FrameLayout;->setVisibility(I)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateModelSelectorVisibility()V
    return-void 
.end method

.method private final updateGithubEnabled(boolean)void
    .registers 3
    # ins_size=2
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnGithub Landroid/widget/LinearLayout;
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setEnabled(Z)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnGithub Landroid/widget/LinearLayout;
    if-eqz v2, +005h
    const/high16 v2, 1065353216
    goto +3h
    const/high16 v2, 1056964608
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setAlpha(F)V
    return-void 
.end method

.method private final updateHoldToTalkUI()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->holdToTalkState Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    sget-object v1, Lcom/bytedance/trae/conversation/widget/InputFragment$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;->ordinal()I
    move-result v0
    aget v0, v1, v0
    const/4 v1, 1
    const/4 v2, 0
    const/16 v3, 8
    if-eq v0, v1, +042h
    const/4 v1, 2
    if-ne v0, v1, +039h
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnHoldToTalk Landroid/widget/ImageView;
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnMicrophone Landroid/widget/ImageView;
    invoke-virtual v0, v3, Landroid/widget/ImageView;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvHoldToTalk Landroid/widget/TextView;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->modelSelector Landroid/widget/LinearLayout;
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    invoke-virtual v0, v3, Landroid/widget/ImageView;->setVisibility(I)V
    goto +66h
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnHoldToTalk Landroid/widget/ImageView;
    invoke-virtual v0, v3, Landroid/widget/ImageView;->setVisibility(I)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->hasInputMessage()Z
    move-result v0
    if-nez v0, +010h
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->hasInputTag()Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move v1, v2
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnMicrophone Landroid/widget/ImageView;
    if-eqz v1, +004h
    move v1, v3
    goto +2h
    move v1, v2
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvHoldToTalk Landroid/widget/TextView;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateModelSelectorVisibility()V
    sget-object v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v0
    if-nez v0, +010h
    iget-boolean v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->isExpressPassVisible Z
    if-eqz v0, +00ch
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setVisibility(I)V
    goto +ah
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnExpressPass Landroid/widget/ImageView;
    invoke-virtual v0, v3, Landroid/widget/ImageView;->setVisibility(I)V
    return-void 
.end method

.method private final updateModelSelectorVisibility()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    if-nez v0, +003h
    return-void 
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvModelName Landroid/widget/TextView;
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->isManualModelSelectionSupported()Z
    move-result v1
    if-eqz v1, +00bh
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->selectedRemoteModel Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getDisplayName()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    goto +dh
    sget-object v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getDisplayName()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->modelSelector Landroid/widget/LinearLayout;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->holdToTalkState Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    sget-object v2, Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;->Normal Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    if-ne v1, v2, +004h
    const/4 v1, 0
    goto +3h
    const/16 v1, 8
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->isModelSelectorTaskLocked()Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->modelSelector Landroid/widget/LinearLayout;
    invoke-virtual v1, v0, Landroid/widget/LinearLayout;->setEnabled(Z)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->modelSelector Landroid/widget/LinearLayout;
    invoke-virtual v1, v0, Landroid/widget/LinearLayout;->setClickable(Z)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->modelSelector Landroid/widget/LinearLayout;
    if-eqz v0, +005h
    const/high16 v0, 1065353216
    goto +3h
    const/high16 v0, 1056964608
    invoke-virtual v1, v0, Landroid/widget/LinearLayout;->setAlpha(F)V
    return-void 
.end method

.method private final updateRepoIconForLoginPlatform()void
    .registers 4
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +00dh
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getLoginPlatform()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    const-string v1, "bytecloud"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +01ah
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->ivRepoIcon Landroid/widget/ImageView;
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->ic_input_bar_bytecloud I
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->ivRepoIcon Landroid/widget/ImageView;
    const/high16 v1, -16777216
    sget-object v2, Landroid/graphics/PorterDuff$Mode;->SRC_IN Landroid/graphics/PorterDuff$Mode;
    invoke-virtual v0, v1, v2, Landroid/widget/ImageView;->setColorFilter(I Landroid/graphics/PorterDuff$Mode;)V
    return-void 
.end method

.method public final addRevertMessage(com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 11
    # ins_size=2
    const-string v0, "message"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getQuery()Ljava/util/List;
    move-result-object v10
    if-nez v10, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v10
    check-cast v10, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01ah
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/im/model/MessagePart;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v3, text
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -018h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v10, Ljava/util/ArrayList;
    invoke-direct v10, Ljava/util/ArrayList;-><init>()V
    check-cast v10, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +02bh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/MessagePart;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v1
    const/4 v2, 0
    if-eqz v1, +018h
    const-string v3, "content"
    invoke-virtual v1, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    if-eqz v1, +010h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v1, v2
    if-eqz v1, +006h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, -029h
    invoke-interface v10, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2eh
    check-cast v10, Ljava/util/List;
    move-object v0, v10
    check-cast v0, Ljava/lang/Iterable;
    const-string v10, ""
    move-object v1, v10
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 62
    const/4 v8, 0
    invoke-static/range v0 ... v8, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    move-object v0, v10
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +005h
    invoke-virtual v9, v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->setInputText(Ljava/lang/String;)V
    return-void 
.end method

.method public final cancelTask(boolean)void
    .registers 3
    # ins_size=2
    if-eqz v2, +008h
    sget-object v2, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Input Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->switchInputState(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V
    goto +ch
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentInputState Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Stopped Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    if-ne v2, v0, +007h
    sget-object v2, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Input Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->switchInputState(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V
    return-void 
.end method

.method public final clearInput()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getText()Landroid/text/Editable;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, Landroid/text/Editable;->clear()V
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->clearAttachments()V
    return-void 
.end method

.method public final consumeAsrCount()int
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->asrCount I
    const/4 v1, 0
    iput v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->asrCount I
    return v0
.end method

.method public final dismissDeviceTipsPopWindow()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->deviceTipsPopWindow Landroid/widget/PopupWindow;
    if-nez v0, +003h
    return-void 
    const/4 v1, 0
    iput-object v1, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->deviceTipsPopWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->getContentView()Landroid/view/View;
    move-result-object v1
    if-nez v1, +009h
    move-object v1, v4
    check-cast v1, Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-virtual v0, Landroid/widget/PopupWindow;->dismiss()V
    return-void 
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-virtual v2, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v2
    iget v2, v2, Landroid/util/DisplayMetrics;->density F
    invoke-virtual v1, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;
    move-result-object v1
    const/4 v3, 0
    invoke-virtual v1, v3, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;
    move-result-object v1
    const/high16 v3, 1082130432
    mul-float/2addr v2, v3
    invoke-virtual v1, v2, Landroid/view/ViewPropertyAnimator;->translationY(F)Landroid/view/ViewPropertyAnimator;
    move-result-object v1
    const-wide/16 v2, 180
    invoke-virtual v1, v2, v3, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;
    move-result-object v1
    new-instance v2, Landroid/view/animation/AccelerateInterpolator;
    invoke-direct v2, Landroid/view/animation/AccelerateInterpolator;-><init>()V
    check-cast v2, Landroid/animation/TimeInterpolator;
    invoke-virtual v1, v2, Landroid/view/ViewPropertyAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)Landroid/view/ViewPropertyAnimator;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda49;
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda49;-><init>(Landroid/widget/PopupWindow;)V
    invoke-virtual v1, v2, Landroid/view/ViewPropertyAnimator;->withEndAction(Ljava/lang/Runnable;)Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    invoke-virtual v0, Landroid/view/ViewPropertyAnimator;->start()V
    return-void 
.end method

.method public final getAsrCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->asrCount I
    return v0
.end method

.method public final getCurrentInputState()com.bytedance.trae.conversation.widget.InputFragment$InputState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentInputState Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    return-object v0
.end method

.method public final getCurrentMode()com.bytedance.trae.conversation.widget.ChatMode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    return-object v0
.end method

.method public final getInputPayload()com.bytedance.trae.conversation.widget.InputFragment$InputPayload
    .registers 18
    # ins_size=1
    move-object/from16 v0, v17
    invoke-direct/range v17, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getContentSegments()Ljava/util/List;
    move-result-object v1
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/List;
    invoke-direct/range v17, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getUploadedImages()Ljava/util/List;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    const/4 v6, 0
    if-eqz v5, +01bh
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUploadedOid()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +009h
    sget-object v7, Lcom/bytedance/trae/conversation/model/QueryItem;->Companion Lcom/bytedance/trae/conversation/model/QueryItem$Companion;
    const/4 v8, 2
    invoke-static v7, v5, v6, v8, v6, Lcom/bytedance/trae/conversation/model/QueryItem$Companion;->image$default(Lcom/bytedance/trae/conversation/model/QueryItem$Companion; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/model/QueryItem;
    move-result-object v6
    if-eqz v6, -01ah
    invoke-interface v4, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1fh
    check-cast v4, Ljava/util/List;
    invoke-direct/range v17, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getUploadedFiles()Ljava/util/List;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    new-instance v5, Ljava/util/ArrayList;
    invoke-direct v5, Ljava/util/ArrayList;-><init>()V
    check-cast v5, Ljava/util/Collection;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +037h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUploadedOid()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +004h
    move-object v7, v6
    goto +22h
    invoke-direct v0, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->getQueryFileName(Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Ljava/lang/String;
    move-result-object v11
    sget-object v9, Lcom/bytedance/trae/conversation/model/QueryItem;->Companion Lcom/bytedance/trae/conversation/model/QueryItem$Companion;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string/jumbo v10, trae-res://remote_resource/
    invoke-direct v7, v10, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    const-wide/16 v12, 0
    const/4 v14, 0
    const/16 v15, 12
    const/16 v16, 0
    invoke-static/range v9 ... v16, Lcom/bytedance/trae/conversation/model/QueryItem$Companion;->attachment$default(Lcom/bytedance/trae/conversation/model/QueryItem$Companion; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/model/QueryItem;
    move-result-object v7
    if-eqz v7, -035h
    invoke-interface v5, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -3ah
    check-cast v5, Ljava/util/List;
    new-instance v3, Lcom/google/gson/Gson;
    invoke-direct v3, Lcom/google/gson/Gson;-><init>()V
    invoke-static Lkotlin/collections/CollectionsKt;->createListBuilder()Ljava/util/List;
    move-result-object v6
    invoke-interface v1, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +07ch
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment;
    instance-of v8, v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Text;
    if-eqz v8, +012h
    sget-object v8, Lcom/bytedance/trae/conversation/model/QueryItem;->Companion Lcom/bytedance/trae/conversation/model/QueryItem$Companion;
    check-cast v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Text;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Text;->getContent()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v8, v7, Lcom/bytedance/trae/conversation/model/QueryItem$Companion;->text(Ljava/lang/String;)Lcom/bytedance/trae/conversation/model/QueryItem;
    move-result-object v7
    invoke-interface v6, v7, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -1fh
    instance-of v8, v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Skill;
    if-eqz v8, +01eh
    sget-object v8, Lcom/bytedance/trae/conversation/model/QueryItem;->Companion Lcom/bytedance/trae/conversation/model/QueryItem$Companion;
    check-cast v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Skill;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Skill;->getSkillItem()Lcom/bytedance/trae/conversation/widget/SkillItem;
    move-result-object v9
    invoke-virtual v9, Lcom/bytedance/trae/conversation/widget/SkillItem;->getId()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Skill;->getSkillItem()Lcom/bytedance/trae/conversation/widget/SkillItem;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/SkillItem;->getName()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v8, v9, v7, Lcom/bytedance/trae/conversation/model/QueryItem$Companion;->skill(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/model/QueryItem;
    move-result-object v7
    invoke-interface v6, v7, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -3fh
    instance-of v8, v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Plugin;
    if-eqz v8, +038h
    move-object v8, v2
    check-cast v8, Ljava/util/Collection;
    check-cast v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Plugin;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Plugin;->getPluginItem()Lcom/bytedance/trae/conversation/widget/PluginTagItem;
    move-result-object v9
    invoke-interface v8, v9, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    sget-object v8, Lcom/bytedance/trae/conversation/model/QueryItem;->Companion Lcom/bytedance/trae/conversation/model/QueryItem$Companion;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Plugin;->getPluginItem()Lcom/bytedance/trae/conversation/widget/PluginTagItem;
    move-result-object v9
    invoke-virtual v9, Lcom/bytedance/trae/conversation/widget/PluginTagItem;->getId()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Plugin;->getPluginItem()Lcom/bytedance/trae/conversation/widget/PluginTagItem;
    move-result-object v10
    invoke-virtual v10, Lcom/bytedance/trae/conversation/widget/PluginTagItem;->getId()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Plugin;->getPluginItem()Lcom/bytedance/trae/conversation/widget/PluginTagItem;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/conversation/widget/PluginTagItem;->getDisplayName()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Plugin;->getPluginItem()Lcom/bytedance/trae/conversation/widget/PluginTagItem;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/PluginTagItem;->getIconUrl()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v8, v9, v10, v11, v7, Lcom/bytedance/trae/conversation/model/QueryItem$Companion;->plugin(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/model/QueryItem;
    move-result-object v7
    invoke-interface v6, v7, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -79h
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    iget-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v7, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v1, v7, +010h
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +013h
    invoke-interface v6, v4, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    goto +eh
    check-cast v5, Ljava/util/Collection;
    invoke-interface v5, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +005h
    invoke-interface v6, v5, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    invoke-static v6, Lkotlin/collections/CollectionsKt;->build(Ljava/util/List;)Ljava/util/List;
    move-result-object v1
    invoke-virtual v3, v1, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    new-instance v3, Lcom/bytedance/trae/conversation/widget/InputFragment$InputPayload;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v3, v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$InputPayload;-><init>(Ljava/lang/String; Ljava/util/List;)V
    return-object v3
.end method

.method public final getOnAttachmentSelected()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->onAttachmentSelected Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnAuthFailed()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->onAuthFailed Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getOnChatNewClick()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->onChatNewClick Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getOnCloudClick()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->onCloudClick Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getOnDeviceClick()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->onDeviceClick Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getOnFileSelected()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->onFileSelected Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnGitHubClick()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->onGitHubClick Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getOnImageSelected()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->onImageSelected Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnInputFocus()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->onInputFocus Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getOnMaximizeBrainstormClick()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->onMaximizeBrainstormClick Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getOnPauseClickListener()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->onPauseClickListener Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getOnReady()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->onReady Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getOnRecordingStateChanged()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->onRecordingStateChanged Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnRequestSkillProjectCheck()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->onRequestSkillProjectCheck Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnSelectedDeviceChanged()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->onSelectedDeviceChanged Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnSendAudioText()kotlin.jvm.functions.Function2
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->onSendAudioText Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public final getOnSendText()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->onSendText Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnSwitchMode()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->onSwitchMode Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnTemplateClick()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->onTemplateClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getQuery(java.lang.String)java.lang.String
    .registers 16
    # ins_size=2
    const-string v0, "input"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v14, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getUploadedImages()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    const/4 v3, 0
    if-eqz v2, +01bh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUploadedOid()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +009h
    sget-object v4, Lcom/bytedance/trae/conversation/model/QueryItem;->Companion Lcom/bytedance/trae/conversation/model/QueryItem$Companion;
    const/4 v5, 2
    invoke-static v4, v2, v3, v5, v3, Lcom/bytedance/trae/conversation/model/QueryItem$Companion;->image$default(Lcom/bytedance/trae/conversation/model/QueryItem$Companion; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/model/QueryItem;
    move-result-object v3
    if-eqz v3, -01ah
    invoke-interface v1, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1fh
    check-cast v1, Ljava/util/List;
    invoke-direct v14, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getUploadedFiles()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +036h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUploadedOid()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +004h
    move-object v4, v3
    goto +21h
    invoke-direct v14, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getQueryFileName(Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Ljava/lang/String;
    move-result-object v8
    sget-object v6, Lcom/bytedance/trae/conversation/model/QueryItem;->Companion Lcom/bytedance/trae/conversation/model/QueryItem$Companion;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v7, trae-res://remote_resource/
    invoke-direct v4, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    const-wide/16 v9, 0
    const/4 v11, 0
    const/16 v12, 12
    const/4 v13, 0
    invoke-static/range v6 ... v13, Lcom/bytedance/trae/conversation/model/QueryItem$Companion;->attachment$default(Lcom/bytedance/trae/conversation/model/QueryItem$Companion; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/model/QueryItem;
    move-result-object v4
    if-eqz v4, -034h
    invoke-interface v2, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -39h
    check-cast v2, Ljava/util/List;
    new-instance v0, Lcom/google/gson/Gson;
    invoke-direct v0, Lcom/google/gson/Gson;-><init>()V
    invoke-static Lkotlin/collections/CollectionsKt;->createListBuilder()Ljava/util/List;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/conversation/model/QueryItem;->Companion Lcom/bytedance/trae/conversation/model/QueryItem$Companion;
    invoke-virtual v4, v15, Lcom/bytedance/trae/conversation/model/QueryItem$Companion;->text(Ljava/lang/String;)Lcom/bytedance/trae/conversation/model/QueryItem;
    move-result-object v15
    invoke-interface v3, v15, Ljava/util/List;->add(Ljava/lang/Object;)Z
    iget-object v15, v14, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v4, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v15, v4, +010h
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v15
    xor-int/lit8 v15, v15, 1
    if-eqz v15, +013h
    invoke-interface v3, v1, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    goto +eh
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v15
    xor-int/lit8 v15, v15, 1
    if-eqz v15, +005h
    invoke-interface v3, v2, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    invoke-static v3, Lkotlin/collections/CollectionsKt;->build(Ljava/util/List;)Ljava/util/List;
    move-result-object v15
    invoke-virtual v0, v15, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v15
    const-string/jumbo v0, toJson(...)
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v15
.end method

.method public final getSelectedModelForRequest()com.bytedance.trae.conversation.network.RemoteModelItem
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->selectedRemoteModel Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->isManualModelSelectionSupported()Z
    move-result v1
    if-eqz v1, +018h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getId()Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +003h
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method public final getSelectedModelNameForRequest()java.lang.String
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->selectedRemoteModel Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v0
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->isManualModelSelectionSupported()Z
    move-result v1
    if-eqz v1, +01ah
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->selectedRemoteModel Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getId()Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +003h
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method public final getSkillsForRequest()java.lang.String
    .registers 7
    # ins_size=1
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->getSelectedModelForRequest()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v0
    return-object v0
    iget-object v0, v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    if-nez v0, +004h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentCliType Lcom/bytedance/trae/im/service/CliType;
    invoke-direct v6, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->resolveModelFunctions(Lcom/bytedance/trae/im/service/CliType;)Ljava/util/List;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi;->Companion Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    const/4 v4, 0
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getId()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v4
    const-string v5, ""
    if-nez v3, +003h
    move-object v3, v5
    invoke-virtual v2, v0, v3, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->getCachedModelsForUi(Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    if-eqz v0, +022h
    move-object v1, v0
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +010h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isDefault()Z
    move-result v3
    if-eqz v3, -011h
    goto +2h
    move-object v2, v4
    check-cast v2, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    if-nez v2, +00dh
    if-eqz v0, +00ah
    invoke-static v0, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    goto +2h
    move-object v2, v4
    if-eqz v2, +006h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +003h
    goto +2h
    move-object v5, v4
    return-object v5
.end method

.method public final getTAG()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->TAG$1 Ljava/lang/String;
    return-object v0
.end method

.method public final getVoiceRecordingOverlay()com.bytedance.trae.conversation.widget.VoiceRecordingOverlay
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->voiceRecordingOverlay Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;
    return-object v0
.end method

.method public final hasInputMessage()boolean
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getText()Landroid/text/Editable;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +011h
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v2, 1
    if-lez v0, +004h
    move v0, v2
    goto +2h
    move v0, v1
    if-ne v0, v2, +003h
    move v1, v2
    return v1
.end method

.method public final hideKeyboard()void
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    const-string v1, "input_method"
    invoke-virtual v0, v1, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Landroid/view/inputmethod/InputMethodManager;
    if-eqz v1, +005h
    check-cast v0, Landroid/view/inputmethod/InputMethodManager;
    goto +2h
    const/4 v0, 0
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getWindowToken()Landroid/os/IBinder;
    move-result-object v1
    if-eqz v0, +006h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder; I)Z
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->clearFocus()V
    return-void 
.end method

.method public final hideTaskTemplates()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->taskTemplatesRecyclerView Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v0, +007h
    const/16 v1, 8
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->unregisterKeyboardListener()V
    return-void 
.end method

.method public final isNewConversation()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->isNewConversation Z
    return v0
.end method

.method public final isTaskRunning()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->isTaskRunning Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final loadGitRepos()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-nez v0, +008h
    const-string v0, "gitViewModel"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->loadRepos()V
    return-void 
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 4
    # ins_size=4
    const-string v3, "inflater"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 0
    invoke-static v1, v2, v3, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v1
    const-string v2, "getRoot(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method public onDestroyView()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->remainingChangedListener Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$OnRemainingChangedListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->removeRemainingChangedListener(Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$OnRemainingChangedListener;)V
    sget-object v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->benefitSwitchListener Lcom/bytedance/trae/conversation/widget/InputFragment$benefitSwitchListener$1;
    check-cast v1, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$OnBenefitSwitchListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->removeBenefitSwitchListener(Lcom/bytedance/trae/conversation/ExpressPassBenefitManager$OnBenefitSwitchListener;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getView()Landroid/view/View;
    move-result-object v0
    if-eqz v0, +00dh
    invoke-virtual v0, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;
    move-result-object v0
    if-eqz v0, +007h
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->inputKeyboardLayoutListener Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;
    invoke-virtual v0, v1, Landroid/view/ViewTreeObserver;->removeOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->unregisterKeyboardListener()V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->dismissDeviceTipsPopWindow()V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->dismissExpressPassToggleTooltip()V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->dismissExpressPassPopWindow()V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->longPressRunnable Ljava/lang/Runnable;
    if-eqz v0, +007h
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->longPressHandler Landroid/os/Handler;
    invoke-virtual v1, v0, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    const/4 v0, 0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->longPressRunnable Ljava/lang/Runnable;
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->hideVoiceLoading()V
    invoke-super v2, Landroidx/fragment/app/Fragment;->onDestroyView()V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->voiceChatSessionManager Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    if-nez v1, +009h
    const-string/jumbo v1, voiceChatSessionManager
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v0
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->release()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->taskTemplatesRecyclerView Landroidx/recyclerview/widget/RecyclerView;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->taskTemplateAdapter Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    return-void 
.end method

.method public onRequestPermissionsResult(int  java.lang.String[]  int[])void
    .registers 5
    # ins_size=4
    const-string v0, "permissions"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "grantResults"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, v3, v4, Landroidx/fragment/app/Fragment;->onRequestPermissionsResult(I [Ljava/lang/String; [I)V
    const/16 v3, 10001
    if-ne v2, v3, +022h
    array-length v2, v4
    const/4 v3, 1
    const/4 v0, 0
    if-nez v2, +004h
    move v2, v3
    goto +2h
    move v2, v0
    xor-int/2addr v2, v3
    if-eqz v2, +007h
    aget v2, v4, v0
    if-nez v2, +003h
    goto +2h
    move v3, v0
    if-nez v3, +00fh
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_mic_permission_denied I
    invoke-static v2, v3, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method public final onStreaming(boolean)void
    .registers 3
    # ins_size=2
    if-eqz v2, +014h
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->canSend()Z
    move-result v2
    if-eqz v2, +008h
    sget-object v2, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Input Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setInputState(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V
    goto +12h
    sget-object v2, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Empty Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setInputState(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V
    goto +ch
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentInputState Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Stopped Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    if-eq v2, v0, +007h
    sget-object v2, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Sended Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->switchInputState(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v2, v3, v4, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    new-instance v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    const/4 v0, 0
    const/4 v1, 1
    invoke-direct v4, v0, v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;-><init>(Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v4, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->voiceChatSessionManager Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    new-instance v4, Landroidx/lifecycle/ViewModelProvider;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    const-string/jumbo v1, requireActivity(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroidx/lifecycle/ViewModelStoreOwner;
    invoke-direct v4, v0, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V
    const-class v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-virtual v4, v0, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    iput-object v4, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    iget-object v4, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->setMode(Lcom/bytedance/trae/conversation/widget/ChatMode;)V
    sget-object v4, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Empty Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->setInputState(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupAttachmentsRecyclerView()V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v4
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda55;
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda55;-><init>()V
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->setOnScrollChangeListener(Landroid/view/View$OnScrollChangeListener;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupInputWatcher()V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupGitObservers()V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupClickListeners()V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v4
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda56;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda56;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateRepoIconForLoginPlatform()V
    const/4 v4, 0
    invoke-direct v2, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateBranchEnabled(Z)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupFileTooLargeObserver()V
    invoke-virtual v3, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;
    move-result-object v3
    iget-object v4, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->inputKeyboardLayoutListener Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;
    invoke-virtual v3, v4, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setupExpressPassBenefit()V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->onReady Lkotlin/jvm/functions/Function0;
    if-eqz v3, +005h
    invoke-interface v3, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method public final parseWorkspaceDisplayName(java.lang.String)java.lang.String
    .registers 13
    # ins_size=2
    move-object v0, v12
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    const/4 v3, 0
    if-eqz v0, +003h
    return-object v3
    const/16 v5, 92
    const/16 v6, 47
    const/4 v7, 0
    const/4 v8, 4
    const/4 v9, 0
    move-object v4, v12
    invoke-static/range v4 ... v9, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; C C Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v12
    new-array v0, v2, [C
    const/16 v4, 47
    aput-char v4, v0, v1
    invoke-static v12, v0, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v12
    move-object v5, v12
    check-cast v5, Ljava/lang/CharSequence;
    new-array v6, v2, [C
    aput-char v4, v6, v1
    const/4 v8, 0
    const/4 v9, 6
    const/4 v10, 0
    invoke-static/range v5 ... v10, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [C Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v12
    invoke-interface v12, Ljava/util/List;->size()I
    move-result v0
    invoke-interface v12, v0, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/ListIterator;->hasPrevious()Z
    move-result v0
    if-eqz v0, +017h
    invoke-interface v12, Ljava/util/ListIterator;->previous()Ljava/lang/Object;
    move-result-object v0
    move-object v4, v0
    check-cast v4, Ljava/lang/String;
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +004h
    move v4, v2
    goto +2h
    move v4, v1
    if-eqz v4, -018h
    move-object v3, v0
    check-cast v3, Ljava/lang/String;
    return-object v3
.end method

.method public final resetSendButton()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->canSend()Z
    move-result v0
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnSendText Landroid/widget/ImageView;
    invoke-virtual v1, v0, Landroid/widget/ImageView;->setEnabled(Z)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnSendText Landroid/widget/ImageView;
    invoke-virtual v1, v0, Landroid/widget/ImageView;->setClickable(Z)V
    return-void 
.end method

.method public final restoreDraft(com.bytedance.trae.conversation.widget.InputFragment$ModeDraft)void
    .registers 5
    # ins_size=2
    const-string v0, "draft"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->getEditable()Ljava/lang/CharSequence;
    move-result-object v1
    sget-object v2, Landroid/widget/TextView$BufferType;->EDITABLE Landroid/widget/TextView$BufferType;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->setText(Ljava/lang/CharSequence; Landroid/widget/TextView$BufferType;)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getText()Landroid/text/Editable;
    move-result-object v1
    if-eqz v1, +007h
    invoke-interface v1, Landroid/text/Editable;->length()I
    move-result v1
    goto +2h
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->setSelection(I)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->getCurrentSkill()Lcom/bytedance/trae/conversation/widget/SkillItem;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->setCurrentSkill(Lcom/bytedance/trae/conversation/widget/SkillItem;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->getAttachments()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +00dh
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->getAttachments()Ljava/util/List;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->setAttachments(Ljava/util/List;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->getCurrentDevice()Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    move-result-object v0
    if-eqz v0, +00ah
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->getCurrentDevice()Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    move-result-object v4
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->setSelectedDevice(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)V
    goto +bh
    const/4 v4, 0
    iput-object v4, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    sget-object v4, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    iput-object v4, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentCliType Lcom/bytedance/trae/im/service/CliType;
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateModelSelectorVisibility()V
    return-void 
.end method

.method public final restoreSelectedModelFromCache()void
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->isManualModelSelectionSupported()Z
    move-result v0
    if-eqz v0, +013h
    sget-object v0, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentEnvironmentKey()Ljava/lang/String;
    move-result-object v1
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentModeKey()Ljava/lang/String;
    move-result-object v2
    iget-object v3, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentConversationId Ljava/lang/String;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->loadSelection(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v0
    goto +7h
    sget-object v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v0
    iput-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->selectedRemoteModel Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateModelSelectorVisibility()V
    return-void 
.end method

.method public final saveDraft()com.bytedance.trae.conversation.widget.InputFragment$ModeDraft
    .registers 8
    # ins_size=1
    invoke-direct v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getText()Landroid/text/Editable;
    move-result-object v0
    if-nez v0, +004h
    const/4 v0, 0
    return-object v0
    new-instance v1, Landroid/text/SpannableStringBuilder;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-direct v1, v0, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V
    invoke-direct v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getSelectedSkill()Lcom/bytedance/trae/conversation/widget/SkillItem;
    move-result-object v0
    invoke-direct v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getAttachments()Landroidx/lifecycle/LiveData;
    move-result-object v2
    invoke-virtual v2, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/List;
    if-nez v2, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +01ah
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUploadStatus()Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    move-result-object v5
    sget-object v6, Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;->Success Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    if-ne v5, v6, +004h
    const/4 v5, 1
    goto +2h
    const/4 v5, 0
    if-eqz v5, -018h
    invoke-interface v3, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v3, Ljava/util/List;
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;
    check-cast v1, Ljava/lang/CharSequence;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    invoke-direct v2, v1, v0, v3, v4, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;-><init>(Ljava/lang/CharSequence; Lcom/bytedance/trae/conversation/widget/SkillItem; Ljava/util/List; Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)V
    return-object v2
.end method

.method public final send()void
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getText()Landroid/text/Editable;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputViewModel()Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getAttachments()Landroidx/lifecycle/LiveData;
    move-result-object v1
    invoke-virtual v1, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/List;
    if-nez v1, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    const/4 v2, 1
    xor-int/2addr v1, v2
    const/4 v3, 0
    if-eqz v1, +036h
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->hasUploadingAttachments()Z
    move-result v1
    if-eqz v1, +016h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_attachment_uploading I
    invoke-virtual v4, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v0, v1, v3, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    return-void 
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->hasFailedAttachments()Z
    move-result v1
    if-eqz v1, +016h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_attachment_upload_failed I
    invoke-virtual v4, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v0, v1, v3, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    return-void 
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +003h
    move v3, v2
    if-nez v3, +014h
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->hasUploadedAttachments()Z
    move-result v1
    if-nez v1, +00eh
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->hasInputTag()Z
    move-result v1
    if-eqz v1, +00fh
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->hideKeyboard()V
    invoke-virtual v4, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setSendingState(Z)V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->onSendText Lkotlin/jvm/functions/Function1;
    if-eqz v1, +005h
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final setBottomContextualBarVisible(boolean)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->contextualBarVisibilityState Lcom/bytedance/trae/conversation/widget/InputContextualBarVisibilityState;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/widget/InputContextualBarVisibilityState;->setRequestedVisible(Z)V
    if-eqz v2, +006h
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateContextualBar()V
    goto +fh
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v2
    iget-object v2, v2, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->bottomContextualBar Landroid/widget/FrameLayout;
    const/16 v0, 8
    invoke-virtual v2, v0, Landroid/widget/FrameLayout;->setVisibility(I)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateModelSelectorVisibility()V
    return-void 
.end method

.method public final setCloudEnabled(boolean)void
    .registers 3
    # ins_size=2
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llCloudContent Landroid/widget/LinearLayout;
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setEnabled(Z)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llCloudContent Landroid/widget/LinearLayout;
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setClickable(Z)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llCloudContent Landroid/widget/LinearLayout;
    if-eqz v2, +005h
    const/high16 v2, 1065353216
    goto +3h
    const/high16 v2, 1056964608
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setAlpha(F)V
    return-void 
.end method

.method public final setCloudName(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "name"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->tvCloudName Landroid/widget/TextView;
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method public final setConversationId(java.lang.String)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentConversationId Ljava/lang/String;
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentConversationId Ljava/lang/String;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->restoreSelectedModelFromCache()V
    return-void 
.end method

.method public final setCurrentInputState(com.bytedance.trae.conversation.widget.InputFragment$InputState)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentInputState Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    return-void 
.end method

.method public final setCurrentMode(com.bytedance.trae.conversation.widget.ChatMode)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    return-void 
.end method

.method public final setDeviceFolderBarVisible(boolean)void
    .registers 3
    # ins_size=2
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llDeviceFolderBar Landroid/widget/LinearLayout;
    if-eqz v2, +004h
    const/4 v2, 0
    goto +3h
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setVisibility(I)V
    return-void 
.end method

.method public final setInputState(com.bytedance.trae.conversation.widget.InputFragment$InputState)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, state
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v3, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentInputState Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    if-nez v0, +003h
    return-void 
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnChatNew Landroid/widget/ImageView;
    const/16 v1, 8
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setVisibility(I)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnSendText Landroid/widget/ImageView;
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setVisibility(I)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->sending Landroid/widget/ProgressBar;
    invoke-virtual v0, v1, Landroid/widget/ProgressBar;->setVisibility(I)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnPause Landroid/widget/ImageView;
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setVisibility(I)V
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$WhenMappings;->$EnumSwitchMapping$7 [I
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->ordinal()I
    move-result v3
    aget v3, v0, v3
    const/4 v0, 1
    const/4 v1, 0
    if-eq v3, v0, +03ch
    const/4 v0, 2
    if-eq v3, v0, +02fh
    const/4 v0, 3
    if-eq v3, v0, +022h
    const/4 v0, 4
    if-eq v3, v0, +015h
    const/4 v0, 5
    if-ne v3, v0, +00ch
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v3
    iget-object v3, v3, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->sending Landroid/widget/ProgressBar;
    invoke-virtual v3, v1, Landroid/widget/ProgressBar;->setVisibility(I)V
    goto +46h
    new-instance v3, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v3, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v3
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v3
    iget-object v3, v3, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnPause Landroid/widget/ImageView;
    invoke-virtual v3, v1, Landroid/widget/ImageView;->setVisibility(I)V
    goto +36h
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v3
    iget-object v3, v3, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->sending Landroid/widget/ProgressBar;
    invoke-virtual v3, v1, Landroid/widget/ProgressBar;->setVisibility(I)V
    goto +2ch
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v3
    iget-object v3, v3, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnSendText Landroid/widget/ImageView;
    invoke-virtual v3, v1, Landroid/widget/ImageView;->setVisibility(I)V
    goto +22h
    iget-object v3, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-eq v3, v0, +00ch
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v3
    iget-object v3, v3, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnChatNew Landroid/widget/ImageView;
    invoke-virtual v3, v1, Landroid/widget/ImageView;->setVisibility(I)V
    goto +ah
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v3
    iget-object v3, v3, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnSendText Landroid/widget/ImageView;
    invoke-virtual v3, v1, Landroid/widget/ImageView;->setVisibility(I)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateModelSelectorVisibility()V
    return-void 
.end method

.method public final setInputText(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, text
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    move-object v1, v3
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v3, Ljava/lang/String;->length()I
    move-result v3
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->setSelection(I)V
    return-void 
.end method

.method public final setMinimizedVoiceMode(boolean)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    if-nez v0, +003h
    return-void 
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->fullInputContainer Landroid/widget/LinearLayout;
    const/16 v1, 8
    const/4 v2, 0
    if-eqz v5, +004h
    move v3, v1
    goto +2h
    move v3, v2
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->minimizedVoiceBar Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;
    if-eqz v5, +003h
    move v1, v2
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->setVisibility(I)V
    if-eqz v5, +020h
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v5
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->minimizedVoiceBar Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    const-string v1, "getViewLifecycleOwner(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, v0, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->bindHolder(Landroidx/lifecycle/LifecycleOwner;)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v5
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->minimizedVoiceBar Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->onMaximizeBrainstormClick Lkotlin/jvm/functions/Function0;
    invoke-virtual v5, v0, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->setOnMaximizeClick(Lkotlin/jvm/functions/Function0;)V
    goto +14h
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v5
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->minimizedVoiceBar Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->unbind()V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v5
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->minimizedVoiceBar Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;
    const/4 v0, 0
    invoke-virtual v5, v0, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->setOnMaximizeClick(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public final setMode(com.bytedance.trae.conversation.widget.ChatMode)void
    .registers 6
    # ins_size=2
    const-string v0, "mode"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v5, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    if-nez v0, +003h
    return-void 
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->isManualModelSelectionSupported()Z
    move-result v0
    if-eqz v0, +013h
    sget-object v0, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentEnvironmentKey()Ljava/lang/String;
    move-result-object v1
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentModeKey()Ljava/lang/String;
    move-result-object v2
    iget-object v3, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentConversationId Ljava/lang/String;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->loadSelection(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v0
    goto +7h
    sget-object v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v0
    iput-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->selectedRemoteModel Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    iget-boolean v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->isNewConversation Z
    const/4 v1, 2
    const/4 v2, 1
    const/16 v3, 8
    if-eqz v0, +071h
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$WhenMappings;->$EnumSwitchMapping$5 [I
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/ChatMode;->ordinal()I
    move-result v5
    aget v5, v0, v5
    const/4 v0, 0
    if-eq v5, v2, +038h
    if-ne v5, v1, +030h
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v5
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llCloud Landroid/widget/LinearLayout;
    invoke-virtual v5, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v5
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llCloudContent Landroid/widget/LinearLayout;
    invoke-virtual v5, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v5
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llDeviceFolderBar Landroid/widget/LinearLayout;
    invoke-virtual v5, v3, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v5
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnGithub Landroid/widget/LinearLayout;
    invoke-virtual v5, v3, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v5
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnBranch Landroid/widget/LinearLayout;
    invoke-virtual v5, v3, Landroid/widget/LinearLayout;->setVisibility(I)V
    goto +47h
    new-instance v5, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v5, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v5
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v5
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llCloud Landroid/widget/LinearLayout;
    invoke-virtual v5, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v5
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llCloudContent Landroid/widget/LinearLayout;
    invoke-virtual v5, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v5
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->llDeviceFolderBar Landroid/widget/LinearLayout;
    invoke-virtual v5, v3, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v5
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnGithub Landroid/widget/LinearLayout;
    invoke-virtual v5, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v5
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnBranch Landroid/widget/LinearLayout;
    invoke-virtual v5, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    goto +13h
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v5
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnGithub Landroid/widget/LinearLayout;
    invoke-virtual v5, v3, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v5
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->btnBranch Landroid/widget/LinearLayout;
    invoke-virtual v5, v3, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateModelSelectorVisibility()V
    sget-object v5, Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy;->INSTANCE Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy;
    iget-boolean v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->isNewConversation Z
    iget-object v3, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v3, +008h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v3
    if-nez v3, +004h
    iget-object v3, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentCliType Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v5, v0, v3, Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy;->actionForModeChange(Z Lcom/bytedance/trae/im/service/CliType;)Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;
    move-result-object v5
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$WhenMappings;->$EnumSwitchMapping$6 [I
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;->ordinal()I
    move-result v5
    aget v5, v0, v5
    if-eq v5, v2, +014h
    if-eq v5, v1, +00fh
    const/4 v0, 3
    if-ne v5, v0, +006h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->showTaskTemplates()V
    goto +ah
    new-instance v5, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v5, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v5
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->hideTaskTemplates()V
    return-void 
.end method

.method public final setMultipleProducts(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->hasMultipleProducts Z
    return-void 
.end method

.method public final setNewConversation(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->isNewConversation Z
    return-void 
.end method

.method public final setOnAttachmentSelected(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onAttachmentSelected Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setOnAuthFailed(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onAuthFailed Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final setOnChatNewClick(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onChatNewClick Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final setOnCloudClick(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onCloudClick Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final setOnDeviceClick(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onDeviceClick Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final setOnFileSelected(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onFileSelected Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setOnGitHubClick(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onGitHubClick Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final setOnImageSelected(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onImageSelected Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setOnInputFocus(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onInputFocus Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final setOnMaximizeBrainstormClick(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onMaximizeBrainstormClick Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final setOnPauseClickListener(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onPauseClickListener Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final setOnReady(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onReady Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final setOnRecordingStateChanged(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onRecordingStateChanged Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setOnRequestSkillProjectCheck(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onRequestSkillProjectCheck Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setOnSelectedDeviceChanged(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onSelectedDeviceChanged Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setOnSendAudioText(kotlin.jvm.functions.Function2)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onSendAudioText Lkotlin/jvm/functions/Function2;
    return-void 
.end method

.method public final setOnSendText(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onSendText Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setOnSwitchMode(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onSwitchMode Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setOnTemplateClick(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->onTemplateClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setSelectedDevice(com.bytedance.trae.conversation.devices.SelectedDeviceItem)void
    .registers 7
    # ins_size=2
    const-string v0, "device"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    iput-object v6, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v1
    iput-object v1, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentCliType Lcom/bytedance/trae/im/service/CliType;
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->preloadPlugins(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)V
    invoke-direct v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->isManualModelSelectionSupported()Z
    move-result v1
    if-eqz v1, +013h
    sget-object v1, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;
    invoke-direct v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentEnvironmentKey()Ljava/lang/String;
    move-result-object v2
    invoke-direct v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentModeKey()Ljava/lang/String;
    move-result-object v3
    iget-object v4, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentConversationId Ljava/lang/String;
    invoke-virtual v1, v2, v3, v4, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->loadSelection(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v1
    goto +7h
    sget-object v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v1
    iput-object v1, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->selectedRemoteModel Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    iget-object v1, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentInputState Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v5, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setInputState(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V
    iget-object v1, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    if-nez v1, +003h
    return-void 
    invoke-direct v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->updateContextualBar()V
    sget-object v1, Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy;->INSTANCE Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy;
    iget-boolean v2, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->isNewConversation Z
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v6
    invoke-virtual v1, v2, v0, v6, Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy;->actionForDeviceChange(Z Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/CliType;)Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;
    move-result-object v6
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$WhenMappings;->$EnumSwitchMapping$6 [I
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;->ordinal()I
    move-result v6
    aget v6, v0, v6
    const/4 v0, 1
    if-eq v6, v0, +015h
    const/4 v0, 2
    if-eq v6, v0, +00fh
    const/4 v0, 3
    if-ne v6, v0, +006h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->showTaskTemplates()V
    goto +ah
    new-instance v6, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v6, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v6
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->hideTaskTemplates()V
    return-void 
.end method

.method public final setSendingState(boolean)void
    .registers 2
    # ins_size=2
    if-eqz v1, +008h
    sget-object v1, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Sending Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setInputState(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V
    goto +12h
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->canSend()Z
    move-result v1
    if-eqz v1, +008h
    sget-object v1, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Input Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setInputState(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V
    goto +6h
    sget-object v1, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Empty Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setInputState(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V
    return-void 
.end method

.method public final setTAG(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->TAG$1 Ljava/lang/String;
    return-void 
.end method

.method public final setTaskRunning(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->isTaskRunning Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final setVoiceRecordingOverlay(com.bytedance.trae.conversation.widget.VoiceRecordingOverlay)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->voiceRecordingOverlay Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;
    return-void 
.end method

.method public final showDeviceTipsPopWindow()void
    .registers 14
    # ins_size=1
    const-string v0, "device_tips_shown"
    iget-object v1, v13, Lcom/bytedance/trae/conversation/widget/InputFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    if-nez v1, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->INSTANCE Lcom/bytedance/trae/conversation/AccountSettingsKeva;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v1
    const/4 v2, 0
    invoke-virtual v1, v0, v2, Lcom/bytedance/keva/Keva;->getBoolean(Ljava/lang/String; Z)Z
    move-result v1
    if-eqz v1, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->INSTANCE Lcom/bytedance/trae/conversation/AccountSettingsKeva;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v1
    const/4 v3, 1
    invoke-virtual v1, v0, v3, Lcom/bytedance/keva/Keva;->storeBoolean(Ljava/lang/String; Z)V
    invoke-virtual v13, Lcom/bytedance/trae/conversation/widget/InputFragment;->dismissDeviceTipsPopWindow()V
    invoke-virtual v13, Lcom/bytedance/trae/conversation/widget/InputFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    invoke-virtual v13, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    invoke-static v1, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v1
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->trae_device_tips_pop_window I
    const/4 v5, 0
    invoke-virtual v1, v4, v5, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup;)Landroid/view/View;
    move-result-object v1
    sget v4, Lcom/bytedance/trae/conversation/R$id;->iv_close I
    invoke-virtual v1, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    if-eqz v4, +00ah
    new-instance v5, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda29;
    invoke-direct v5, v13, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda29;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-virtual v4, v5, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    const/16 v4, 246
    int-to-float v4, v4
    mul-float/2addr v4, v0
    float-to-int v4, v4
    const/high16 v5, 1073741824
    invoke-static v4, v5, Landroid/view/View$MeasureSpec;->makeMeasureSpec(I I)I
    move-result v4
    invoke-static v2, v2, Landroid/view/View$MeasureSpec;->makeMeasureSpec(I I)I
    move-result v5
    invoke-virtual v1, v4, v5, Landroid/view/View;->measure(I I)V
    invoke-virtual v1, Landroid/view/View;->getMeasuredWidth()I
    move-result v4
    invoke-virtual v1, Landroid/view/View;->getMeasuredHeight()I
    move-result v5
    new-instance v6, Landroid/widget/PopupWindow;
    invoke-direct v6, v1, v4, v5, v3, Landroid/widget/PopupWindow;-><init>(Landroid/view/View; I I Z)V
    invoke-virtual v6, v3, Landroid/widget/PopupWindow;->setOutsideTouchable(Z)V
    new-instance v3, Landroid/graphics/drawable/ColorDrawable;
    invoke-direct v3, v2, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v3, Landroid/graphics/drawable/Drawable;
    invoke-virtual v6, v3, Landroid/widget/PopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    const/4 v3, 0
    invoke-virtual v6, v3, Landroid/widget/PopupWindow;->setElevation(F)V
    invoke-virtual v6, v2, Landroid/widget/PopupWindow;->setAnimationStyle(I)V
    invoke-direct v13, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v7
    iget-object v7, v7, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->ivCloudIcon Landroid/widget/ImageView;
    const-string v8, "ivCloudIcon"
    invoke-static v7, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v8, 2
    new-array v9, v8, [I
    invoke-virtual v7, v9, Landroid/widget/ImageView;->getLocationInWindow([I)V
    aget v10, v9, v2
    invoke-virtual v7, Landroid/widget/ImageView;->getWidth()I
    move-result v11
    div-int/2addr v11, v8
    add-int/2addr v10, v11
    const/16 v8, 53
    int-to-float v8, v8
    mul-float/2addr v8, v0
    float-to-int v8, v8
    const/16 v11, 16
    int-to-float v11, v11
    mul-float/2addr v11, v0
    float-to-int v11, v11
    invoke-virtual v13, Lcom/bytedance/trae/conversation/widget/InputFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v12
    invoke-virtual v12, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v12
    iget v12, v12, Landroid/util/DisplayMetrics;->widthPixels I
    sub-int/2addr v10, v8
    sub-int/2addr v12, v11
    sub-int/2addr v12, v4
    invoke-static v10, v11, v12, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v4
    aget v2, v9, v2
    sub-int/2addr v4, v2
    invoke-virtual v7, Landroid/widget/ImageView;->getHeight()I
    move-result v2
    add-int/2addr v5, v2
    neg-int v2, v5
    check-cast v7, Landroid/view/View;
    invoke-virtual v6, v7, v4, v2, Landroid/widget/PopupWindow;->showAsDropDown(Landroid/view/View; I I)V
    iput-object v6, v13, Lcom/bytedance/trae/conversation/widget/InputFragment;->deviceTipsPopWindow Landroid/widget/PopupWindow;
    invoke-virtual v1, v3, Landroid/view/View;->setAlpha(F)V
    const/high16 v2, 1086324736
    mul-float/2addr v0, v2
    invoke-virtual v1, v0, Landroid/view/View;->setTranslationY(F)V
    invoke-virtual v1, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    const/high16 v1, 1065353216
    invoke-virtual v0, v1, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    invoke-virtual v0, v3, Landroid/view/ViewPropertyAnimator;->translationY(F)Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    const-wide/16 v1, 220
    invoke-virtual v0, v1, v2, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    new-instance v1, Landroid/view/animation/DecelerateInterpolator;
    invoke-direct v1, Landroid/view/animation/DecelerateInterpolator;-><init>()V
    check-cast v1, Landroid/animation/TimeInterpolator;
    invoke-virtual v0, v1, Landroid/view/ViewPropertyAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    invoke-virtual v0, Landroid/view/ViewPropertyAnimator;->start()V
    return-void 
    :try_start_0x2
.end method

.method public final showTaskTemplates()void
    .registers 9
    # ins_size=1
    iget-object v0, v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->_binding Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    if-nez v0, +003h
    return-void 
    iget-boolean v0, v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->isNewConversation Z
    if-nez v0, +006h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->hideTaskTemplates()V
    return-void 
    iget-object v0, v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentDevice Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    const/4 v1, 0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    goto +2h
    move-object v0, v1
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v0, v2, +006h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->hideTaskTemplates()V
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;->isShow()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;->getCacheTaskTemplates()Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v0
    instance-of v2, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v2, +005h
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    goto +2h
    move-object v0, v1
    if-eqz v0, +015h
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    if-eqz v0, +00fh
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/network/TaskTemplatesData;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/TaskTemplatesData;->getTemplates()Ljava/util/List;
    move-result-object v0
    goto +2h
    move-object v0, v1
    move-object v2, v0
    check-cast v2, Ljava/util/Collection;
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    move v2, v3
    goto +2h
    move v2, v4
    if-eqz v2, +006h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->hideTaskTemplates()V
    return-void 
    iget-object v2, v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v5, Lcom/bytedance/trae/conversation/widget/InputFragment$WhenMappings;->$EnumSwitchMapping$5 [I
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/ChatMode;->ordinal()I
    move-result v2
    aget v2, v5, v2
    if-eq v2, v4, +00fh
    const/4 v5, 2
    if-ne v2, v5, +006h
    const-string/jumbo v2, work
    goto +9h
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    const-string v2, "code"
    sget-object v5, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;
    invoke-virtual v5, v0, v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;->toTaskTemplateModels(Ljava/util/List; Ljava/lang/String;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v2
    if-eqz v2, +006h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->hideTaskTemplates()V
    return-void 
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/InputTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/InputTracker;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v5
    invoke-virtual v2, v5, Lcom/bytedance/trae/conversation/tracker/InputTracker;->trackShowcaseShow(I)V
    iget-object v2, v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->taskTemplatesRecyclerView Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v2, +012h
    if-eqz v2, +005h
    invoke-virtual v2, v3, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v1, v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->taskTemplateAdapter Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter;
    if-eqz v1, +005h
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter;->submitList(Ljava/util/List;)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->registerKeyboardListener()V
    return-void 
    invoke-direct v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v2
    iget-object v2, v2, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->vsTaskTemplates Landroid/view/ViewStub;
    invoke-virtual v2, Landroid/view/ViewStub;->inflate()Landroid/view/View;
    move-result-object v2
    instance-of v5, v2, Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v5, +006h
    move-object v5, v2
    check-cast v5, Landroidx/recyclerview/widget/RecyclerView;
    goto +2h
    move-object v5, v1
    if-nez v5, +00bh
    sget v5, Lcom/bytedance/trae/conversation/R$id;->rv_task_templates I
    invoke-virtual v2, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Landroidx/recyclerview/widget/RecyclerView;
    iput-object v5, v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->taskTemplatesRecyclerView Landroidx/recyclerview/widget/RecyclerView;
    if-nez v5, +003h
    return-void 
    new-instance v2, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter;
    new-instance v6, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda47;
    invoke-direct v6, v8, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda47;-><init>(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    invoke-direct v2, v6, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter;-><init>(Lkotlin/jvm/functions/Function1;)V
    iput-object v2, v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->taskTemplateAdapter Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter;
    new-instance v6, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->getContext()Landroid/content/Context;
    move-result-object v7
    invoke-direct v6, v7, v4, v3, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context; I Z)V
    check-cast v6, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v5, v6, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    invoke-virtual v5, v1, Landroidx/recyclerview/widget/RecyclerView;->setItemAnimator(Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;)V
    move-object v1, v2
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v5, v1, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    sget v3, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_12 I
    invoke-virtual v1, v3, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v1
    new-instance v3, Lcom/bytedance/trae/conversation/widget/InputFragment$showTaskTemplates$1;
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$showTaskTemplates$1;-><init>(I)V
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;
    invoke-virtual v5, v3, Landroidx/recyclerview/widget/RecyclerView;->addItemDecoration(Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;)V
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter;->submitList(Ljava/util/List;)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/widget/InputFragment;->registerKeyboardListener()V
    return-void 
.end method

.method public final switchInputSended()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentInputState Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    sget-object v1, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Stopped Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    if-ne v0, v1, +007h
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Sended Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->setInputState(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V
    return-void 
.end method

.method public final switchInputState(com.bytedance.trae.conversation.widget.InputFragment$InputState)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, state
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Sending Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    if-eq v2, v0, +01dh
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Sended Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    if-eq v2, v0, +019h
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Stopped Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    if-ne v2, v0, +003h
    goto +13h
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->canSend()Z
    move-result v2
    if-eqz v2, +008h
    sget-object v2, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Input Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setInputState(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V
    goto +ah
    sget-object v2, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Empty Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setInputState(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V
    goto +4h
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setInputState(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V
    return-void 
.end method

.method public final switchMode(com.bytedance.trae.conversation.widget.ChatMode)void
    .registers 3
    # ins_size=2
    const-string v0, "mode"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->currentMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v0, v2, +003h
    return-void 
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setMode(Lcom/bytedance/trae/conversation/widget/ChatMode;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->onSwitchMode Lkotlin/jvm/functions/Function1;
    if-eqz v0, +005h
    invoke-interface v0, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method
