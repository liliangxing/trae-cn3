# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/ConversationActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "ConversationActivity.kt"

.field private static final AGENT_FLOW_TAG:Ljava/lang/String;
.field private static final CHECK_POINT_TAG:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/ConversationActivity$Companion;
.field public static final EXTRA_ANCHOR_CREATED_AT_MS:Ljava/lang/String;
.field public static final EXTRA_CONVERSATION:Ljava/lang/String;
.field public static final EXTRA_CONVERSATION_ID:Ljava/lang/String;
.field public static final EXTRA_ENTER_FROM:Ljava/lang/String;
.field public static final EXTRA_ICON_TYPE:Ljava/lang/String;
.field public static final EXTRA_MODE:Ljava/lang/String;
.field public static final EXTRA_PENDING_CONNECT_DEVICE_TYPE:Ljava/lang/String;
.field public static final EXTRA_START_SERVER_URL:Ljava/lang/String;
.field private static final KEYBOARD_VISIBLE_THRESHOLD:F
.field private static final KEY_LAST_CHAT_MODE:Ljava/lang/String;
.field private static final MANAGED_PROMPT_RETRY_DELAY_MS:J
.field private static final TAG:Ljava/lang/String;
.field private anchorCreatedAtMs:Ljava/lang/String;
.field private binding:Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
.field private brainstormMicCheckEndMs:J
.field private brainstormMicCheckStartMs:J
.field private final brainstormPermissionLauncher:Landroidx/activity/result/ActivityResultLauncher;
.field private final brainstormResultLauncher:Landroidx/activity/result/ActivityResultLauncher;
.field private final checkpointKeyboardLayoutListener:Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;
.field private final checkpointOverlayLocation:[I
.field private final checkpointVisibleFrame:Landroid/graphics/Rect;
.field private final cliStatusChangeListener:Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;
.field private final conversationChangeListener:Lcom/bytedance/trae/im/service/IMService$ConversationChangeListener;
.field private final conversationDao$delegate:Lkotlin/Lazy;
.field private final deleteConversationListener:Lcom/bytedance/trae/conversation/ConversationActivity$deleteConversationListener$1;
.field private final deleteMessageListener:Lcom/bytedance/trae/conversation/ConversationActivity$deleteMessageListener$1;
.field private final draftByMode:Ljava/util/Map;
.field private final gitHubConnectorManager$delegate:Lkotlin/Lazy;
.field private final gitSelectionViewModel$delegate:Lkotlin/Lazy;
.field private hasEnteredBackground:Z
.field private hasReportedStreamShow:Z
.field private hasScrolledToAnchorCreatedAt:Z
.field private iLaunchedActiveBrainstorm:Z
.field private initialChatMode:Lcom/bytedance/trae/conversation/widget/ChatMode;
.field private isCheckpointDialogVisible:Z
.field private isCheckpointKeyboardListenerRegistered:Z
.field private isNewConversation:Z
.field private lastSendContext:Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
.field private loadingDialog:Landroid/app/Dialog;
.field private managedPromptResolutionJob:Lkotlinx/coroutines/Job;
.field private menuPopupWindow:Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;
.field private newFeaturePromptSheet:Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
.field private notificationPermissionRequested:Z
.field private pendingConnectDeviceFlowActive:Z
.field private pendingConnectDeviceType:Lcom/bytedance/trae/conversation/devices/DeviceProductType;
.field private pendingTriggerTracker:Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;
.field private final previewWebViewLauncher:Landroidx/activity/result/ActivityResultLauncher;
.field private final remoteDeleteMessagePushListener:Lcom/bytedance/trae/im/service/IMService$RemoteDeleteMessagePushListener;
.field private final revertMessageListener:Lcom/bytedance/trae/conversation/ConversationActivity$revertMessageListener$1;
.field private final selectedDeviceByMode:Ljava/util/Map;
.field private showingCheckpointToolCallId:Ljava/lang/String;
.field private snapToBottomAfterLatestPageSubmit:Z
.field private streamingChatModel:Ljava/lang/String;
.field private streamingMessageId:Ljava/lang/String;
.field private streamingStartTimeMs:J
.field private suppressNaturalGuideForPendingConnect:Z
.field private viewModel:Lcom/bytedance/trae/conversation/ConversationViewModel;
.field private voiceDiscussionAttemptTracker:Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
.field private final voiceMinimizedBackCallback:Lcom/bytedance/trae/conversation/ConversationActivity$voiceMinimizedBackCallback$1;
.field private wasUserInitiatedCancel:Z


.method public static synthetic $r8$lambda$-gpp8ZXuQNifiUP5ZrGrIXJfDoc(com.bytedance.trae.conversation.ConversationActivity  com.bytedance.trae.conversation.widget.ChatMode)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->initWelcomeFragment$lambda$60(Lcom/bytedance/trae/conversation/ConversationActivity; Lcom/bytedance/trae/conversation/widget/ChatMode;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$0HIxQEJwueruwv16yWhc16sT91A(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->onCreate$lambda$26(Lcom/bytedance/trae/conversation/ConversationActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$20aI1dF2SBGpXHrhhrLZRwKQ7Mc(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->observeViewModel$lambda$42(Lcom/bytedance/trae/conversation/ConversationActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$2FUTxfKEmNztcr7qRgy_dFVNDVo(com.bytedance.trae.conversation.ConversationActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->initTitleBar$lambda$48(Lcom/bytedance/trae/conversation/ConversationActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$2bvD0hq6S-diC89f17A0XjDXAhI(com.bytedance.trae.conversation.ConversationActivity  androidx.activity.result.ActivityResult)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->brainstormResultLauncher$lambda$6(Lcom/bytedance/trae/conversation/ConversationActivity; Landroidx/activity/result/ActivityResult;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$2hyuzfK5QD5Uwzl0WrIiiB6FVWw(com.bytedance.trae.conversation.ConversationActivity  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->onCreate$lambda$30(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$3uJcscyW5B2jj4EnvAcUIJ4YTDc(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->initInputFragment$lambda$78$lambda$76(Lcom/bytedance/trae/conversation/ConversationActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$6dqdmktIKUqudSBhjow9Js00xpI(com.bytedance.trae.im.service.IMService$DeleteMessagePushPayload  com.bytedance.trae.conversation.ConversationActivity)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->remoteDeleteMessagePushListener$lambda$9$lambda$8(Lcom/bytedance/trae/im/service/IMService$DeleteMessagePushPayload; Lcom/bytedance/trae/conversation/ConversationActivity;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$7T_TgTHns71nOq9bjsKRrc61_Q0(com.bytedance.trae.conversation.ConversationActivity  kotlin.jvm.functions.Function1)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->initInputFragment$lambda$78$lambda$74(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$8cN10ydbbjIhSYlXK2nNIiidoiY(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->showDeleteDialog$lambda$55(Lcom/bytedance/trae/conversation/ConversationActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$AAaNENuJSYbV-pQyFanIuPuiLJo(com.bytedance.trae.conversation.ConversationActivity  java.lang.String  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->initInputFragment$lambda$65(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$C_-ZL_B9lAdg2su7ezq6IW9qXR8(com.bytedance.trae.conversation.ConversationActivity  kotlin.jvm.internal.Ref$ObjectRef)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->showNewFeaturePrompt$lambda$94(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/jvm/internal/Ref$ObjectRef;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$HiOlHWWFwxCWnWZpte_sfRnDI3U(com.bytedance.trae.conversation.ConversationActivity  com.bytedance.trae.im.service.Mode  java.util.List  java.lang.String  java.lang.String)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->sendQuery$lambda$63(Lcom/bytedance/trae/conversation/ConversationActivity; Lcom/bytedance/trae/im/service/Mode; Ljava/util/List; Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$IhxoKz0-zbonGy22Cl49AW4t6VY(com.bytedance.trae.conversation.ConversationActivity)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->checkConfirmRequired$lambda$41(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$JEkmSeGyl1-XLasZlsUM9k9EG5M(com.bytedance.trae.conversation.ConversationActivity  androidx.activity.result.ActivityResult)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->previewWebViewLauncher$lambda$7(Lcom/bytedance/trae/conversation/ConversationActivity; Landroidx/activity/result/ActivityResult;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$L8295BFOo4209U6nhGI90OszxWU(com.bytedance.trae.conversation.ConversationActivity)com.bytedance.trae.conversation.git.GitHubConnectorManager
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->gitHubConnectorManager_delegate$lambda$2(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$LRZgk_oHaEqAou40CIk9v7sSJA8(com.bytedance.trae.conversation.ConversationActivity)boolean
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->onCreate$lambda$27(Lcom/bytedance/trae/conversation/ConversationActivity;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$L_3UpvwxnfDeQtgB3-gBuZvrXts(com.bytedance.trae.conversation.ConversationActivity  com.bytedance.trae.im.service.IMService$CliStatusChangePayload)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->cliStatusChangeListener$lambda$11(Lcom/bytedance/trae/conversation/ConversationActivity; Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$MhAcFfD7V6N8LHr3tsy6uOf0qUM(com.bytedance.trae.conversation.ConversationActivity  com.bytedance.trae.conversation.devices.DeviceProductType)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->showNewFeaturePrompt$lambda$91(Lcom/bytedance/trae/conversation/ConversationActivity; Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$NSQg5or1cO4JRmv1yvABJxFQSlI(com.bytedance.trae.conversation.ConversationActivity  java.util.Map)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->brainstormPermissionLauncher$lambda$4(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/util/Map;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$N_mj7D1Mq4AVab5NA86MG6q_Ns4(com.bytedance.trae.conversation.ConversationActivity  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->initInputFragment$lambda$66(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$NmoO3jG_dcnayv1JwVCka_kBTxo(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->initInputFragment$lambda$78$lambda$75(Lcom/bytedance/trae/conversation/ConversationActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$OtglFqgCAiwRRUSbawY05NU3J_g(com.bytedance.trae.conversation.ConversationActivity  java.lang.String  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->onCreate$lambda$31(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$QGPNTYc13V3Ej70iwDkJ1ij-qjo(com.bytedance.trae.conversation.ConversationActivity)com.bytedance.trae.im.database.ConversationDao
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->conversationDao_delegate$lambda$0(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/im/database/ConversationDao;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$QIrszbT4p8KxUKsIoG5jcjON5Fc(com.bytedance.trae.conversation.widget.ChatMode  com.bytedance.trae.conversation.ConversationActivity  java.util.List)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->showCliSelectionDialog$lambda$80(Lcom/bytedance/trae/conversation/widget/ChatMode; Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$RpilJSpO_XKit-qEbqaxDfHeZ78(com.bytedance.trae.conversation.ConversationActivity  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->onCreate$lambda$29(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Ssv4qaohEAi22c7uhxQ43sm4qFc(com.bytedance.trae.conversation.ConversationActivity)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->requestNotificationPermissionIfNeeded$lambda$36(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$UTR7uur_lDsSbmQBwXRhgmm2PhM(com.bytedance.trae.conversation.ConversationActivity  kotlin.jvm.internal.Ref$ObjectRef  com.bytedance.trae.conversation.devices.MobileDevice)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->showNewFeaturePrompt$lambda$93(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/jvm/internal/Ref$ObjectRef; Lcom/bytedance/trae/conversation/devices/MobileDevice;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$WPhZy0pA4vXlWtldUWlzpAOOKE4(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->onCreate$lambda$34(Lcom/bytedance/trae/conversation/ConversationActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$WdO1RKnYmhyDlQ2KjGQutzbmgDc(com.bytedance.trae.conversation.ConversationActivity  java.lang.String  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->initCheckpointDialog$lambda$45(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$WtHQ-GcaCRCtvjsY7g1KaqEoE_0(com.bytedance.trae.conversation.ConversationActivity  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->onCreate$lambda$32(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$X9AcGfGJMR3uRv2uJYk6FXh6UmA(com.bytedance.trae.conversation.ConversationActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->onCreate$lambda$22(Lcom/bytedance/trae/conversation/ConversationActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$XaFY5ReG7YiyMKVxbIXNQH6PVVw(com.bytedance.trae.conversation.ConversationActivity)boolean
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->initInputFragment$lambda$64(Lcom/bytedance/trae/conversation/ConversationActivity;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$b6YcYJg1Fn-xcPYIlJv1XpHwZhA(com.bytedance.trae.conversation.ConversationActivity  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->showRenameDialog$lambda$54(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$cPf9FSjl_h8ypoL3F1JaeeYpPPU(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->requestBrainstormPermissions$lambda$104(Lcom/bytedance/trae/conversation/ConversationActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$eLWQJrmzDREl70YcwQYE_VazfrA(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->initInputFragment$lambda$78(Lcom/bytedance/trae/conversation/ConversationActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$eXsoirlYu5vVT-HspIAc0ly8gNE(com.bytedance.trae.conversation.ConversationActivity  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->onCreate$lambda$35(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$exY_HQFXIyvelvwdqoAPMh53Ip4(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->onCreate$lambda$24(Lcom/bytedance/trae/conversation/ConversationActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$fbi84EmZp8CtkGqqj3ZqU8w14ss(com.bytedance.trae.conversation.ConversationActivity  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->showEndVoiceDiscussionDialog$lambda$116(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$gnY9y5_9iNXII9lrbkzCD17VpxU(com.bytedance.trae.conversation.ConversationActivity  com.bytedance.trae.im.service.IMService$ConversationChangeEvent)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->conversationChangeListener$lambda$14(Lcom/bytedance/trae/conversation/ConversationActivity; Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$hFhwZvMD2pZfvo5Q5hRvjyzTRnc(com.bytedance.trae.conversation.ConversationActivity  com.bytedance.trae.im.service.IMService$DeleteMessagePushPayload)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->remoteDeleteMessagePushListener$lambda$9(Lcom/bytedance/trae/conversation/ConversationActivity; Lcom/bytedance/trae/im/service/IMService$DeleteMessagePushPayload;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$i52DXBfWeHttZn9ijeJwNHaCMIU(com.bytedance.trae.im.service.IMService$CliStatusChangePayload  com.bytedance.trae.conversation.ConversationActivity)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->cliStatusChangeListener$lambda$11$lambda$10(Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload; Lcom/bytedance/trae/conversation/ConversationActivity;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$ino8TeTcn1TDciUfSGPHkR4tv14(com.bytedance.trae.conversation.ConversationActivity)android.content.Context
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->initCheckpointDialog$lambda$43(Lcom/bytedance/trae/conversation/ConversationActivity;)Landroid/content/Context;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$j0F8Mpkl86VyHRltG9ERFNdF5QM(com.bytedance.trae.conversation.ConversationActivity  kotlin.jvm.internal.Ref$ObjectRef)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->showNewFeaturePrompt$lambda$92(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/jvm/internal/Ref$ObjectRef;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$jA9RbvGqlWnnntYEqryaMxlcbMc(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->initInputFragment$lambda$67(Lcom/bytedance/trae/conversation/ConversationActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$jIJk-JgUNflm4YgFmj5WXrvhayQ(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->onCreate$lambda$24$lambda$23(Lcom/bytedance/trae/conversation/ConversationActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$jnMGS-YSrEfRLKjDHkxMbSYgw9U(com.bytedance.trae.im.service.IMService$ConversationChangeEvent  com.bytedance.trae.conversation.ConversationActivity)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->conversationChangeListener$lambda$14$lambda$13(Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent; Lcom/bytedance/trae/conversation/ConversationActivity;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$kLj_FAusZTKMDoE-ZHOj2PGAdMo(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->initInputFragment$lambda$78$lambda$72(Lcom/bytedance/trae/conversation/ConversationActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$kYEwOCyqAQUEO18k1Fi5VaKulyE(com.bytedance.trae.conversation.ConversationActivity  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->initInputFragment$lambda$69(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$kdb5XfLGjGqhccREyy6hAwajPEg(com.bytedance.trae.conversation.ConversationActivity  java.lang.String  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->onCreate$lambda$33(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$nkqxBwZYStdiVDA2zFLc7ezWInY(com.bytedance.trae.conversation.ConversationActivity  com.bytedance.trae.conversation.widget.ChatMode  com.bytedance.trae.conversation.devices.SelectedDeviceItem)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->showCliSelectionDialog$lambda$79(Lcom/bytedance/trae/conversation/ConversationActivity; Lcom/bytedance/trae/conversation/widget/ChatMode; Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ojVBEYDsefQFWf8G2pBftvlckNQ(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->requestBrainstormPermissions$lambda$105(Lcom/bytedance/trae/conversation/ConversationActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$shB4RcdrTB4h6w0cwtWtTzsT4F8(com.bytedance.trae.conversation.ConversationActivity)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->checkpointKeyboardLayoutListener$lambda$1(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$t4X2YNnG8Fp_LnO2_-4CWI9mtBs(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->initCheckpointDialog$lambda$44(Lcom/bytedance/trae/conversation/ConversationActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$tISj7kY5Ipm7xAcqXvFDj-ffYGQ(com.bytedance.trae.conversation.ConversationActivity)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->initInputFragment$lambda$78$lambda$77(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$tUf3aO0t8RhXq6lQvqcqmI2fyGY(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->applyMinimizedVoiceVisibility$lambda$115(Lcom/bytedance/trae/conversation/ConversationActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$tcDYdBp1Wcn0JnAEPpd6kIwWxiw(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->onCreate$lambda$26$lambda$25(Lcom/bytedance/trae/conversation/ConversationActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$umzg_GJY3OB470yps2V7iAZBUlA(com.bytedance.trae.conversation.ConversationActivity  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->handleStartServerIntent$lambda$120(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$uuHccM_Ovmf77hiSrY7GyCvP_44(com.bytedance.trae.conversation.ConversationActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->initTitleBar$lambda$46(Lcom/bytedance/trae/conversation/ConversationActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$vFPPSJcAmZqA-WU3GXUz-lwHaTU(com.bytedance.trae.conversation.ConversationActivity  com.bytedance.trae.conversation.devices.SelectedDeviceItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->initInputFragment$lambda$78$lambda$73(Lcom/bytedance/trae/conversation/ConversationActivity; Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$vm_QqgGOZ-5nM6iiFCkIc4KATdQ(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->initInputFragment$lambda$70(Lcom/bytedance/trae/conversation/ConversationActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$xfsz7C-aLNkwL7kJtFD3GvjaqpQ(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->executePendingConnectDevice$lambda$100(Lcom/bytedance/trae/conversation/ConversationActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$y0A72qf34x_yec6zsM4JPVZaRx4(com.bytedance.trae.conversation.ConversationActivity  int  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->initTitleBar$lambda$53(Lcom/bytedance/trae/conversation/ConversationActivity; I Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$zHJN0ZW7EIX9bsjgNlzn38xs_sk(com.bytedance.trae.conversation.ConversationActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->initTitleBar$lambda$49(Lcom/bytedance/trae/conversation/ConversationActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$zcZeUppVnRiCPbnyiz0cE57TD-g(com.bytedance.trae.conversation.ConversationActivity)com.bytedance.trae.conversation.git.GitSelectionViewModel
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->gitSelectionViewModel_delegate$lambda$3(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/ConversationActivity;->Companion Lcom/bytedance/trae/conversation/ConversationActivity$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda31;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda31;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->conversationDao$delegate Lkotlin/Lazy;
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->draftByMode Ljava/util/Map;
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->selectedDeviceByMode Ljava/util/Map;
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->initialChatMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    new-instance v0, Landroid/graphics/Rect;
    invoke-direct v0, Landroid/graphics/Rect;-><init>()V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->checkpointVisibleFrame Landroid/graphics/Rect;
    const/4 v0, 2
    new-array v0, v0, [I
    iput-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->checkpointOverlayLocation [I
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda32;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda32;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->checkpointKeyboardLayoutListener Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda34;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda34;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->gitHubConnectorManager$delegate Lkotlin/Lazy;
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda35;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda35;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->gitSelectionViewModel$delegate Lkotlin/Lazy;
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda36;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda36;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    const-string v1, "registerForActivityResult(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->brainstormPermissionLauncher Landroidx/activity/result/ActivityResultLauncher;
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$voiceMinimizedBackCallback$1;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity$voiceMinimizedBackCallback$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->voiceMinimizedBackCallback Lcom/bytedance/trae/conversation/ConversationActivity$voiceMinimizedBackCallback$1;
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda37;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda37;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v3, v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->brainstormResultLauncher Landroidx/activity/result/ActivityResultLauncher;
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda38;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda38;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v3, v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->previewWebViewLauncher Landroidx/activity/result/ActivityResultLauncher;
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$deleteMessageListener$1;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity$deleteMessageListener$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->deleteMessageListener Lcom/bytedance/trae/conversation/ConversationActivity$deleteMessageListener$1;
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda39;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda39;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->remoteDeleteMessagePushListener Lcom/bytedance/trae/im/service/IMService$RemoteDeleteMessagePushListener;
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda40;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda40;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->cliStatusChangeListener Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$deleteConversationListener$1;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity$deleteConversationListener$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->deleteConversationListener Lcom/bytedance/trae/conversation/ConversationActivity$deleteConversationListener$1;
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda41;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda41;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->conversationChangeListener Lcom/bytedance/trae/im/service/IMService$ConversationChangeListener;
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$revertMessageListener$1;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity$revertMessageListener$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->revertMessageListener Lcom/bytedance/trae/conversation/ConversationActivity$revertMessageListener$1;
    return-void 
.end method

.method public static final synthetic access$applyMinimizedVoiceVisibility(com.bytedance.trae.conversation.ConversationActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationActivity;->applyMinimizedVoiceVisibility()V
    return-void 
.end method

.method public static final synthetic access$checkConfirmRequired(com.bytedance.trae.conversation.ConversationActivity  com.bytedance.trae.im.model.ParsedChatMessage  java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->checkConfirmRequired(Lcom/bytedance/trae/im/model/ParsedChatMessage; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$dismissPluginAuthBottomSheetIfShowing(com.bytedance.trae.conversation.ConversationActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationActivity;->dismissPluginAuthBottomSheetIfShowing()V
    return-void 
.end method

.method public static final synthetic access$flushPendingTriggerTracker(com.bytedance.trae.conversation.ConversationActivity  java.lang.String  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->flushPendingTriggerTracker(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$getAnchorCreatedAtMs$p(com.bytedance.trae.conversation.ConversationActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->anchorCreatedAtMs Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getBinding$p(com.bytedance.trae.conversation.ConversationActivity)com.bytedance.trae.conversation.databinding.TraeActivityConversationBinding
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    return-object v0
.end method

.method public static final synthetic access$getConversationDao(com.bytedance.trae.conversation.ConversationActivity)com.bytedance.trae.im.database.ConversationDao
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationActivity;->getConversationDao()Lcom/bytedance/trae/im/database/ConversationDao;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getDetailFragment(com.bytedance.trae.conversation.ConversationActivity)com.bytedance.trae.conversation.chat.ConversationDetailFragment
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationActivity;->getDetailFragment()Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getGitHubConnectorManager(com.bytedance.trae.conversation.ConversationActivity)com.bytedance.trae.conversation.git.GitHubConnectorManager
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationActivity;->getGitHubConnectorManager()Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getHasReportedStreamShow$p(com.bytedance.trae.conversation.ConversationActivity)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->hasReportedStreamShow Z
    return v0
.end method

.method public static final synthetic access$getHasScrolledToAnchorCreatedAt$p(com.bytedance.trae.conversation.ConversationActivity)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->hasScrolledToAnchorCreatedAt Z
    return v0
.end method

.method public static final synthetic access$getInputFragment(com.bytedance.trae.conversation.ConversationActivity)com.bytedance.trae.conversation.widget.InputFragment
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getLastSendContext$p(com.bytedance.trae.conversation.ConversationActivity)com.bytedance.trae.conversation.tracker.AISendMessageContext
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->lastSendContext Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    return-object v0
.end method

.method public static final synthetic access$getMenuPopupWindow$p(com.bytedance.trae.conversation.ConversationActivity)com.bytedance.trae.conversation.widget.MenuPopupWindow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->menuPopupWindow Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;
    return-object v0
.end method

.method public static final synthetic access$getSelectedDeviceByMode$p(com.bytedance.trae.conversation.ConversationActivity)java.util.Map
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->selectedDeviceByMode Ljava/util/Map;
    return-object v0
.end method

.method public static final synthetic access$getSnapToBottomAfterLatestPageSubmit$p(com.bytedance.trae.conversation.ConversationActivity)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->snapToBottomAfterLatestPageSubmit Z
    return v0
.end method

.method public static final synthetic access$getStreamingChatModel$p(com.bytedance.trae.conversation.ConversationActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->streamingChatModel Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getStreamingMessageId$p(com.bytedance.trae.conversation.ConversationActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->streamingMessageId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getStreamingStartTimeMs$p(com.bytedance.trae.conversation.ConversationActivity)long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->streamingStartTimeMs J
    return-wide v0
.end method

.method public static final synthetic access$getViewModel$p(com.bytedance.trae.conversation.ConversationActivity)com.bytedance.trae.conversation.ConversationViewModel
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    return-object v0
.end method

.method public static final synthetic access$getWasUserInitiatedCancel$p(com.bytedance.trae.conversation.ConversationActivity)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->wasUserInitiatedCancel Z
    return v0
.end method

.method public static final synthetic access$hideLoading(com.bytedance.trae.conversation.ConversationActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationActivity;->hideLoading()V
    return-void 
.end method

.method public static final synthetic access$hideWelcomeScreen(com.bytedance.trae.conversation.ConversationActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationActivity;->hideWelcomeScreen()V
    return-void 
.end method

.method public static final synthetic access$isCheckpointDialogVisible$p(com.bytedance.trae.conversation.ConversationActivity)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->isCheckpointDialogVisible Z
    return v0
.end method

.method public static final synthetic access$isNewConversation$p(com.bytedance.trae.conversation.ConversationActivity)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->isNewConversation Z
    return v0
.end method

.method public static final synthetic access$performForceLogout(com.bytedance.trae.conversation.ConversationActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationActivity;->performForceLogout()V
    return-void 
.end method

.method public static final synthetic access$prepareNewFeaturePrompt(com.bytedance.trae.conversation.ConversationActivity  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->prepareNewFeaturePrompt(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$resolveManagedPromptsWhileResumed(com.bytedance.trae.conversation.ConversationActivity  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->resolveManagedPromptsWhileResumed(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$sendQuery(com.bytedance.trae.conversation.ConversationActivity  java.lang.String  java.lang.String  java.util.List)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->sendQuery(Ljava/lang/String; Ljava/lang/String; Ljava/util/List;)V
    return-void 
.end method

.method public static final synthetic access$setCheckpointDialogVisible$p(com.bytedance.trae.conversation.ConversationActivity  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->isCheckpointDialogVisible Z
    return-void 
.end method

.method public static final synthetic access$setHasReportedStreamShow$p(com.bytedance.trae.conversation.ConversationActivity  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->hasReportedStreamShow Z
    return-void 
.end method

.method public static final synthetic access$setHasScrolledToAnchorCreatedAt$p(com.bytedance.trae.conversation.ConversationActivity  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->hasScrolledToAnchorCreatedAt Z
    return-void 
.end method

.method public static final synthetic access$setILaunchedActiveBrainstorm$p(com.bytedance.trae.conversation.ConversationActivity  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->iLaunchedActiveBrainstorm Z
    return-void 
.end method

.method public static final synthetic access$setShowingCheckpointToolCallId$p(com.bytedance.trae.conversation.ConversationActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->showingCheckpointToolCallId Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setSnapToBottomAfterLatestPageSubmit$p(com.bytedance.trae.conversation.ConversationActivity  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->snapToBottomAfterLatestPageSubmit Z
    return-void 
.end method

.method public static final synthetic access$setStreamingChatModel$p(com.bytedance.trae.conversation.ConversationActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->streamingChatModel Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setStreamingMessageId$p(com.bytedance.trae.conversation.ConversationActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->streamingMessageId Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$showDeleteDialog(com.bytedance.trae.conversation.ConversationActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationActivity;->showDeleteDialog()V
    return-void 
.end method

.method public static final synthetic access$showEndVoiceDiscussionDialog(com.bytedance.trae.conversation.ConversationActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationActivity;->showEndVoiceDiscussionDialog()V
    return-void 
.end method

.method public static final synthetic access$showRenameDialog(com.bytedance.trae.conversation.ConversationActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationActivity;->showRenameDialog()V
    return-void 
.end method

.method public static final synthetic access$updateConversationTitleInfo(com.bytedance.trae.conversation.ConversationActivity  com.bytedance.trae.im.service.Conversation)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->updateConversationTitleInfo(Lcom/bytedance/trae/im/service/Conversation;)V
    return-void 
.end method

.method private final applyMinimizedVoiceVisibility()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->isMinimized()Z
    move-result v0
    if-eqz v0, +008h
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->iLaunchedActiveBrainstorm Z
    if-eqz v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    invoke-virtual v3, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    const-string v2, "InputFragment"
    invoke-virtual v1, v2, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v1
    instance-of v2, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;
    if-eqz v2, +005h
    check-cast v1, Lcom/bytedance/trae/conversation/widget/InputFragment;
    goto +2h
    const/4 v1, 0
    if-eqz v1, +00ah
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda12;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda12;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setOnMaximizeBrainstormClick(Lkotlin/jvm/functions/Function0;)V
    if-eqz v1, +005h
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->setMinimizedVoiceMode(Z)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->voiceMinimizedBackCallback Lcom/bytedance/trae/conversation/ConversationActivity$voiceMinimizedBackCallback$1;
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$voiceMinimizedBackCallback$1;->setEnabled(Z)V
    return-void 
.end method

.method private static final applyMinimizedVoiceVisibility$lambda$115(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationActivity;->maximizeBrainstorm()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final autoSelectConnectedDevice(com.bytedance.trae.conversation.devices.MobileDevice  com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConnectionAction)void
    .registers 16
    # ins_size=3
    invoke-virtual v14, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v14, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->getSelectedCliType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v3
    invoke-virtual v14, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getIdeVersion()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->getDestinationMode()Lcom/bytedance/trae/conversation/widget/ChatMode;
    move-result-object v14
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    const/4 v12, 1
    if-ne v14, v0, +004h
    move v9, v12
    goto +3h
    const/4 v14, 0
    move v9, v14
    new-instance v14, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    const/4 v4, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v10, 224
    const/4 v11, 0
    move-object v0, v14
    invoke-direct/range v0 ... v11, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->getDestinationMode()Lcom/bytedance/trae/conversation/widget/ChatMode;
    move-result-object v15
    iget-object v0, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->selectedDeviceByMode Ljava/util/Map;
    invoke-interface v0, v15, v14, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v0, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v14, Lcom/bytedance/trae/conversation/ConversationViewModel;->setSelectedDevice(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)V
    invoke-virtual v13, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string v2, "InputFragment"
    invoke-virtual v0, v2, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    instance-of v2, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;
    if-eqz v2, +005h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/widget/InputFragment;
    if-eqz v1, +005h
    invoke-virtual v1, v14, Lcom/bytedance/trae/conversation/widget/InputFragment;->setSelectedDevice(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)V
    sget-object v14, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v15, v14, +007h
    if-eqz v1, +005h
    invoke-virtual v1, v12, Lcom/bytedance/trae/conversation/widget/InputFragment;->setMultipleProducts(Z)V
    return-void 
.end method

.method private static final brainstormPermissionLauncher$lambda$4(com.bytedance.trae.conversation.ConversationActivity  java.util.Map)void
    .registers 7
    # ins_size=2
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v6, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v6
    invoke-interface v6, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +039h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/Map$Entry;
    invoke-interface v0, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-interface v0, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "Brainstorm permission result: "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, " = "
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "ConversationActivity"
    invoke-virtual v2, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto -3ch
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    iput-wide v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->brainstormMicCheckEndMs J
    invoke-direct v5, Lcom/bytedance/trae/conversation/ConversationActivity;->launchBrainstormActivity()V
    return-void 
.end method

.method private static final brainstormResultLauncher$lambda$6(com.bytedance.trae.conversation.ConversationActivity  androidx.activity.result.ActivityResult)void
    .registers 11
    # ins_size=2
    invoke-virtual v10, Landroidx/activity/result/ActivityResult;->getResultCode()I
    move-result v0
    const/4 v1, -1
    if-ne v0, v1, +0dbh
    iget-boolean v0, v9, Lcom/bytedance/trae/conversation/ConversationActivity;->isNewConversation Z
    const-string/jumbo v1, viewModel
    const/4 v2, 0
    if-eqz v0, +01ah
    iget-object v0, v9, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v0, +008h
    const-string v0, "binding"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getSegmentedSelectedIndex()I
    move-result v0
    if-nez v0, +005h
    sget-object v0, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    goto +48h
    sget-object v0, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    goto +45h
    invoke-static Lcom/bytedance/trae/im/service/Mode;->getEntries()Lkotlin/enums/EnumEntries;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +02eh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v4
    iget-object v5, v9, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v5, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v5
    invoke-interface v5, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v2
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -02fh
    goto +2h
    move-object v3, v2
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/im/service/Mode;
    if-nez v0, +004h
    sget-object v0, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "brainstorm relay mode: "
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v5, "ConversationActivity"
    invoke-virtual v3, v5, v4, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v10, Landroidx/activity/result/ActivityResult;->getData()Landroid/content/Intent;
    move-result-object v3
    if-eqz v3, +009h
    const-string v4, "extra_messages_text"
    invoke-virtual v3, v4, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v2
    invoke-virtual v10, Landroidx/activity/result/ActivityResult;->getData()Landroid/content/Intent;
    move-result-object v4
    if-eqz v4, +009h
    const-string v6, "extra_session_id"
    invoke-virtual v4, v6, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v2
    invoke-virtual v10, Landroidx/activity/result/ActivityResult;->getData()Landroid/content/Intent;
    move-result-object v10
    if-eqz v10, +009h
    const-string v6, "extra_parent_conversation_id"
    invoke-virtual v10, v6, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    goto +2h
    move-object v10, v2
    move-object v6, v3
    check-cast v6, Ljava/lang/CharSequence;
    const/4 v7, 0
    const/4 v8, 1
    if-eqz v6, +00bh
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    if-eqz v6, +003h
    goto +3h
    move v6, v7
    goto +2h
    move v6, v8
    if-nez v6, +01dh
    move-object v6, v4
    check-cast v6, Ljava/lang/CharSequence;
    if-eqz v6, +008h
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    if-eqz v6, +003h
    move v7, v8
    if-nez v7, +00fh
    iget-object v9, v9, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v9, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v9
    invoke-virtual v2, v3, v0, v4, v10, Lcom/bytedance/trae/conversation/ConversationViewModel;->handleBrainstormResult(Ljava/lang/String; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String;)V
    goto +8h
    sget-object v9, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v10, "Brainstorm result is empty"
    invoke-virtual v9, v5, v10, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final buildSendMessageContext(com.bytedance.trae.im.service.Mode  int)com.bytedance.trae.conversation.tracker.AISendMessageContext
    .registers 34
    # ins_size=3
    new-instance v15, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    move-object v0, v15
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v16, 0
    move-object/from16 v30, v15
    move/from16 v15, v16
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const v28, 134217727
    const/16 v29, 0
    invoke-direct/range v0 ... v29, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;-><init>(Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Z Z I I Ljava/lang/String; I I I I I I I I I I I I Ljava/lang/String; I I I I I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object/from16 v0, v31
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v2, 0
    if-nez v1, +009h
    const-string/jumbo v1, viewModel
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->getSelectedDevice()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v1, +006h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v2
    if-nez v2, +004h
    const/4 v1, -1
    goto +9h
    sget-object v1, Lcom/bytedance/trae/conversation/ConversationActivity$WhenMappings;->$EnumSwitchMapping$3 [I
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->ordinal()I
    move-result v2
    aget v1, v1, v2
    const/4 v2, 1
    if-eq v1, v2, +011h
    const/4 v3, 2
    if-eq v1, v3, +00bh
    const/4 v3, 3
    if-eq v1, v3, +005h
    const-string v1, ""
    goto +9h
    const-string v1, "local_ide"
    goto +6h
    const-string v1, "cloud"
    goto +3h
    const-string v1, "local"
    move-object/from16 v3, v30
    invoke-virtual v3, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->setEnvDeployment(Ljava/lang/String;)V
    invoke-direct/range v31, Lcom/bytedance/trae/conversation/ConversationActivity;->getGitSelectionViewModel()Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getSelectedRepo()Landroidx/lifecycle/LiveData;
    move-result-object v1
    invoke-virtual v1, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v1
    if-eqz v1, +003h
    goto +2h
    const/4 v2, 0
    invoke-virtual v3, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->setHasGit(Z)V
    if-eqz v2, +007h
    const-string v1, "github"
    invoke-virtual v3, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->setGitType(Ljava/lang/String;)V
    invoke-direct/range v31, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->consumeAsrCount()I
    move-result v1
    invoke-virtual v3, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->setAsrCount(I)V
    move/from16 v1, v33
    invoke-virtual v3, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->setPluginCount(I)V
    return-object v3
.end method

.method static synthetic buildSendMessageContext$default(com.bytedance.trae.conversation.ConversationActivity  com.bytedance.trae.im.service.Mode  int  int  java.lang.Object)com.bytedance.trae.conversation.tracker.AISendMessageContext
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->buildSendMessageContext(Lcom/bytedance/trae/im/service/Mode; I)Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    move-result-object v0
    return-object v0
.end method

.method private final canStartBrainstormForDevice(com.bytedance.trae.conversation.devices.SelectedDeviceItem)boolean
    .registers 6
    # ins_size=2
    if-eqz v5, +008h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    if-nez v0, +004h
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    const/4 v2, 1
    if-eq v0, v1, +003h
    return v2
    sget-object v0, Lcom/bytedance/trae/conversation/network/BrainstormingSettings;->INSTANCE Lcom/bytedance/trae/conversation/network/BrainstormingSettings;
    const/4 v1, 0
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getIdeVersion()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v1
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/network/BrainstormingSettings;->isBelowConfiguredV2MinIdeVersion(Ljava/lang/String;)Z
    move-result v0
    if-nez v0, +003h
    return v2
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "canStartBrainstormForDevice: blocked by desktop ide version, cliId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getId()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v1
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", ideVersion="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    if-eqz v5, +006h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getIdeVersion()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string v1, "ConversationActivity"
    invoke-virtual v0, v1, v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    move-object v5, v4
    check-cast v5, Landroid/content/Context;
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_desktop_upgrade_required I
    const/4 v1, 0
    invoke-static v5, v0, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v5
    invoke-virtual v5, Landroid/widget/Toast;->show()V
    return v1
.end method

.method private final checkConfirmRequired(com.bytedance.trae.im.model.ParsedChatMessage  java.lang.String  java.lang.String)void
    .registers 21
    # ins_size=4
    move-object/from16 v0, v17
    invoke-static/range v18, Lcom/bytedance/trae/im/service/IMMessageKt;->getItems(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Ljava/util/List;
    move-result-object v1
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->isCheckpointDialogVisible Z
    const/16 v3, 8
    const-string v4, "getSupportFragmentManager(...)"
    const-string v5, "binding"
    const-string v6, "CheckPointDialog"
    const/4 v7, 1
    const/4 v8, 0
    const/4 v9, 0
    if-eqz v2, +134h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v10, Ljava/lang/StringBuilder;
    const-string v11, "checkConfirmRequired: isCheckpointDialogVisible, showingCheckpointToolCallId="
    invoke-direct v10, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v11, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->showingCheckpointToolCallId Ljava/lang/String;
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v2, v6, v10, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    move-object v2, v1
    check-cast v2, Ljava/lang/Iterable;
    instance-of v10, v2, Ljava/util/Collection;
    if-eqz v10, +00dh
    move-object v10, v2
    check-cast v10, Ljava/util/Collection;
    invoke-interface v10, Ljava/util/Collection;->isEmpty()Z
    move-result v10
    if-eqz v10, +004h
    move v10, v8
    goto +2eh
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, -00ah
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v12
    if-eqz v12, +015h
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v11
    if-eqz v11, +00ah
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ConfirmInfo;->isWaitingConfirm()Z
    move-result v11
    if-ne v11, v7, +004h
    move v11, v7
    goto +2h
    move v11, v8
    if-eqz v11, +004h
    move v11, v7
    goto +2h
    move v11, v8
    if-eqz v11, -026h
    move v10, v7
    if-eqz v10, +00ah
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "checkConfirmRequired: items is isWaitingConfirm"
    invoke-virtual v1, v6, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iget-object v10, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->showingCheckpointToolCallId Ljava/lang/String;
    if-eqz v10, +096h
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, +01ch
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    move-object v12, v11
    check-cast v12, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v12
    if-eqz v12, +007h
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getId()Ljava/lang/String;
    move-result-object v12
    goto +2h
    move-object v12, v9
    invoke-static v12, v10, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v12
    if-eqz v12, -01dh
    goto +2h
    move-object v11, v9
    check-cast v11, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v2
    goto +2h
    move-object v2, v9
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ConfirmInfo;->getConfirmStatus()Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v9
    if-eqz v2, +00ah
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ConfirmInfo;->isEnterpriseCommandBlacklist()Z
    move-result v2
    if-ne v2, v7, +004h
    move v2, v7
    goto +2h
    move v2, v8
    const-string v12, " confirmStatus="
    const-string v13, "checkConfirmRequired: showing toolCallId="
    if-nez v2, +02eh
    if-eqz v11, +00bh
    const-string/jumbo v2, unconfirmed
    invoke-static v11, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +023h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", keep dialog"
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v6, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v14, Ljava/lang/StringBuilder;
    invoke-direct v14, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v14, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", dismiss"
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v2, v6, v10, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->Companion Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$Companion;
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v10
    invoke-static v10, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$Companion;->dismissIfShowing(Landroidx/fragment/app/FragmentManager;)V
    invoke-direct/range v17, Lcom/bytedance/trae/conversation/ConversationActivity;->dismissPluginAuthBottomSheetIfShowing()V
    iput-boolean v8, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->isCheckpointDialogVisible Z
    iput-object v9, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->showingCheckpointToolCallId Ljava/lang/String;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v2, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v9
    iget-object v2, v2, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->checkpointOverlayContainer Landroidx/fragment/app/FragmentContainerView;
    const/4 v10, 0
    invoke-virtual v2, v10, Landroidx/fragment/app/FragmentContainerView;->setTranslationY(F)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v2, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v9
    iget-object v2, v2, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->checkpointOverlayContainer Landroidx/fragment/app/FragmentContainerView;
    invoke-virtual v2, v3, Landroidx/fragment/app/FragmentContainerView;->setVisibility(I)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v2, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v9
    iget-object v2, v2, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->inputFragmentContainer Landroidx/fragment/app/FragmentContainerView;
    invoke-virtual v2, v8, Landroidx/fragment/app/FragmentContainerView;->setVisibility(I)V
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v2
    if-eqz v2, +00ah
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "checkConfirmRequired: skip history message"
    invoke-virtual v1, v6, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    invoke-interface v1, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +108h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v12, v2
    check-cast v12, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v2
    if-eqz v2, +0f5h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ConfirmInfo;->isWaitingConfirm()Z
    move-result v2
    if-eqz v2, +0efh
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v2
    if-nez v2, +004h
    goto/16 +0e7h
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getId()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v8
    goto +2h
    move v2, v7
    if-eqz v2, +003h
    goto -35h
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getId()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v9
    move-object v10, v2
    check-cast v10, Ljava/lang/CharSequence;
    if-eqz v10, +00bh
    invoke-interface v10, Ljava/lang/CharSequence;->length()I
    move-result v11
    if-nez v11, +003h
    goto +3h
    move v11, v8
    goto +2h
    move v11, v7
    if-eqz v11, +00ah
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v10, "checkConfirmRequired: skip empty toolCallId"
    invoke-virtual v2, v6, v10, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    goto -5ah
    if-eqz v10, +00bh
    invoke-interface v10, Ljava/lang/CharSequence;->length()I
    move-result v10
    if-nez v10, +003h
    goto +3h
    move v10, v8
    goto +2h
    move v10, v7
    if-nez v10, +029h
    iget-object v10, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v10, +009h
    const-string/jumbo v10, viewModel
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v9
    invoke-virtual v10, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->shouldShowCheckpoint(Ljava/lang/String;)Z
    move-result v10
    if-nez v10, +018h
    sget-object v10, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v11, Ljava/lang/StringBuilder;
    const-string v12, "checkConfirmRequired: skip duplicate toolCallId="
    invoke-direct v11, v12, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v10, v6, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    goto/16 -08eh
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v1, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v9
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->inputFragmentContainer Landroidx/fragment/app/FragmentContainerView;
    invoke-virtual v1, v3, Landroidx/fragment/app/FragmentContainerView;->setVisibility(I)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v1, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v9
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->checkpointOverlayContainer Landroidx/fragment/app/FragmentContainerView;
    invoke-virtual v1, v8, Landroidx/fragment/app/FragmentContainerView;->setVisibility(I)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v8, "checkConfirmRequired: showCheckpointDialog item="
    invoke-direct v3, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v8, ", taskId="
    invoke-virtual v3, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    move-object/from16 v13, v19
    invoke-virtual v3, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v8, ", conversationId="
    invoke-virtual v3, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    move-object/from16 v14, v20
    invoke-virtual v3, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v6, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v11
    invoke-static v11, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v15
    invoke-static v0, v9, v7, v9, Lcom/bytedance/trae/conversation/ConversationActivity;->resolveCurrentChatMode$default(Lcom/bytedance/trae/conversation/ConversationActivity; Lcom/bytedance/trae/im/service/Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->getValue()Ljava/lang/String;
    move-result-object v16
    invoke-virtual/range v10 ... v16, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->showCheckpointDialog(Landroidx/fragment/app/FragmentManager; Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    iput-boolean v7, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->isCheckpointDialogVisible Z
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->showingCheckpointToolCallId Ljava/lang/String;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v1, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v9, v1
    iget-object v1, v9, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->checkpointOverlayContainer Landroidx/fragment/app/FragmentContainerView;
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda14;
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda14;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v1, v2, Landroidx/fragment/app/FragmentContainerView;->post(Ljava/lang/Runnable;)Z
    goto +7h
    move-object/from16 v13, v19
    move-object/from16 v14, v20
    goto/16 -10ah
    return-void 
.end method

.method private static final checkConfirmRequired$lambda$41(com.bytedance.trae.conversation.ConversationActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationActivity;->syncCheckpointOverlayWithKeyboard()V
    return-void 
.end method

.method private static final checkpointKeyboardLayoutListener$lambda$1(com.bytedance.trae.conversation.ConversationActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationActivity;->syncCheckpointOverlayWithKeyboard()V
    return-void 
.end method

.method private static final cliStatusChangeListener$lambda$11(com.bytedance.trae.conversation.ConversationActivity  com.bytedance.trae.im.service.IMService$CliStatusChangePayload)void
    .registers 3
    # ins_size=2
    const-string v0, "payload"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda15;
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda15;-><init>(Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload; Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    return-void 
.end method

.method private static final cliStatusChangeListener$lambda$11$lambda$10(com.bytedance.trae.im.service.IMService$CliStatusChangePayload  com.bytedance.trae.conversation.ConversationActivity)void
    .registers 11
    # ins_size=2
    invoke-virtual v9, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->getAvailable()Z
    move-result v0
    const-string v1, "binding"
    const/4 v2, 1
    const/4 v3, 2
    const-string v4, "local"
    const-string/jumbo v5, viewModel
    const/4 v6, 0
    const/4 v7, 0
    if-nez v0, +079h
    iget-object v0, v10, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v7
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v8
    if-eqz v8, +009h
    invoke-static v8, v4, v6, v3, v7, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +2h
    move v2, v6
    if-eqz v2, +003h
    return-void 
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v9, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->getCliId()Ljava/lang/String;
    move-result-object v9
    invoke-static v0, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +003h
    return-void 
    iget-object v9, v10, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v9, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v7
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    sget v0, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_title_bar_computer_offline I
    invoke-virtual v9, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setConversationDetailSubtitleIcon(I)V
    iget-object v9, v10, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v9, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v7
    invoke-virtual v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->getSessionTurnStatus()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v9
    invoke-interface v9, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;
    sget-object v0, Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;->STREAMING Lcom/bytedance/trae/conversation/ConversationViewModel$SessionTurnStatus;
    if-ne v9, v0, +064h
    iget-object v9, v10, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v9, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v7, v9
    invoke-virtual v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->handleCliDisconnected()V
    invoke-direct v10, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v9
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Input Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    invoke-virtual v9, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->switchInputState(Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;)V
    check-cast v10, Landroid/content/Context;
    sget v9, Lcom/bytedance/trae/multilanguage/R$string;->trae_device_disconnected I
    invoke-static v10, v9, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; I)V
    goto +46h
    iget-object v0, v10, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v7
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +009h
    invoke-static v5, v4, v6, v3, v7, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +2h
    move v2, v6
    if-eqz v2, +003h
    return-void 
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v9, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->getCliId()Ljava/lang/String;
    move-result-object v9
    invoke-static v0, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +003h
    return-void 
    iget-object v9, v10, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v9, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v7, v9
    iget-object v9, v7, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    sget v10, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_title_bar_computer_online I
    invoke-virtual v9, v10, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setConversationDetailSubtitleIcon(I)V
    return-void 
.end method

.method public static com_bytedance_trae_conversation_ConversationActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.conversation.ConversationActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationActivity;->com_bytedance_trae_conversation_ConversationActivity__onStop$___twin___()V
    invoke-static Lcom/bytedance/sysoptimizer/EnterTransitionCrashOptimizer;->getContext()Landroid/content/Context;
    move-result-object v0
    if-eqz v0, +013h
    check-cast v1, Landroid/app/Activity;
    invoke-virtual v1, Landroid/app/Activity;->getWindow()Landroid/view/Window;
    move-result-object v1
    invoke-virtual v1, Landroid/view/Window;->getDecorView()Landroid/view/View;
    move-result-object v1
    invoke-virtual v1, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;
    move-result-object v1
    invoke-virtual v1, Landroid/view/ViewTreeObserver;->dispatchOnPreDraw()Z
    return-void 
    :try_start_0xb
.end method

.method private static final conversationChangeListener$lambda$14(com.bytedance.trae.conversation.ConversationActivity  com.bytedance.trae.im.service.IMService$ConversationChangeEvent)void
    .registers 11
    # ins_size=2
    const-string v0, "event"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;->getConversationId()Ljava/lang/String;
    move-result-object v0
    iget-object v1, v9, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v2, 0
    if-nez v1, +009h
    const-string/jumbo v1, viewModel
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +03ch
    invoke-virtual v10, Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;->getChangeType()Ljava/lang/String;
    move-result-object v0
    const-string v1, "delete"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +028h
    invoke-virtual v10, Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;->getConversationId()Ljava/lang/String;
    move-result-object v10
    if-eqz v10, +021h
    move-object v0, v9
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v3, v0
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    move-object v4, v0
    check-cast v4, Lkotlin/coroutines/CoroutineContext;
    const/4 v5, 0
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$conversationChangeListener$1$1$1;
    invoke-direct v0, v9, v10, v2, Lcom/bytedance/trae/conversation/ConversationActivity$conversationChangeListener$1$1$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v6, v0
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 2
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda11;
    invoke-direct v0, v10, v9, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda11;-><init>(Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent; Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v9, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    return-void 
.end method

.method private static final conversationChangeListener$lambda$14$lambda$13(com.bytedance.trae.im.service.IMService$ConversationChangeEvent  com.bytedance.trae.conversation.ConversationActivity)void
    .registers 3
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;->getConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v1
    if-eqz v1, +013h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->updateConversation(Lcom/bytedance/trae/im/service/Conversation;)V
    invoke-direct v2, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->updateConversationTitleInfo(Lcom/bytedance/trae/im/service/Conversation;)V
    return-void 
.end method

.method private static final conversationDao_delegate$lambda$0(com.bytedance.trae.conversation.ConversationActivity)com.bytedance.trae.im.database.ConversationDao
    .registers 4
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +00eh
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, "anonymous"
    new-instance v1, Lcom/bytedance/trae/im/database/ConversationDao;
    sget-object v2, Lcom/bytedance/trae/im/database/DatabaseManager;->INSTANCE Lcom/bytedance/trae/im/database/DatabaseManager;
    check-cast v3, Landroid/content/Context;
    invoke-virtual v2, v3, v0, Lcom/bytedance/trae/im/database/DatabaseManager;->getDatabase(Landroid/content/Context; Ljava/lang/String;)Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    move-result-object v3
    invoke-direct v1, v3, Lcom/bytedance/trae/im/database/ConversationDao;-><init>(Lcom/bytedance/trae/im/database/DatabaseOpenHelper;)V
    return-object v1
.end method

.method private final createVoiceDiscussionAttempt()com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker
    .registers 23
    # ins_size=1
    move-object/from16 v0, v22
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const-string/jumbo v2, viewModel
    const/4 v3, 0
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->getSelectedDevice()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v1, +008h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v1
    if-nez v1, +004h
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    move-object v5, v1
    invoke-direct/range v22, Lcom/bytedance/trae/conversation/ConversationActivity;->resolveTaskModeForCurrentConversation()Lcom/bytedance/trae/im/service/Mode;
    move-result-object v6
    new-instance v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    new-instance v21, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v4
    invoke-virtual v4, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v13
    const-string/jumbo v4, toString(...)
    invoke-static v13, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v14
    new-instance v16, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v4, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v3
    invoke-virtual v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v4
    invoke-interface v4, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v3
    if-nez v4, +004h
    const-string v4, ""
    move-object v7, v4
    const/4 v8, 0
    iget-object v4, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v4, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v3
    invoke-virtual v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v2, +006h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +00bh
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    const/4 v2, 1
    move v9, v2
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$Companion;->hasSeenIntro$conversation_mainlandRelease()Z
    move-result v10
    const/16 v11, 8
    const/4 v12, 0
    move-object/from16 v4, v16
    invoke-direct/range v4 ... v12, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;-><init>(Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Ljava/lang/String; Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 1016
    const/16 v20, 0
    move-object/from16 v7, v21
    move-object v8, v13
    move-wide v9, v14
    move-object/from16 v11, v16
    move-object v13, v2
    move-object v14, v3
    move-object v15, v4
    move-object/from16 v16, v5
    invoke-direct/range v7 ... v20, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;-><init>(Ljava/lang/String; J Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext; Ljava/util/Map; Ljava/util/Set; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 14
    const/4 v13, 0
    move-object v7, v1
    move-object/from16 v8, v21
    invoke-direct/range v7 ... v13, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;-><init>(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->CLICK Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->recordStage(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;)Z
    return-object v1
.end method

.method private final currentLoggedInUserId()java.lang.String
    .registers 4
    # ins_size=1
    const/4 v0, 0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v3
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationActivity;
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v1, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v1, +024h
    invoke-interface v1, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v1
    if-eqz v1, +01eh
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->isLogin()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v1, v0
    if-eqz v1, +014h
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +00eh
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    goto +2h
    move-object v1, v0
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    goto +ch
    move-exception v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    check-cast v0, Ljava/lang/String;
    return-object v0
    :try_start_0x1
.end method

.method private final defaultRemoteDevice()com.bytedance.trae.conversation.devices.SelectedDeviceItem
    .registers 14
    # ins_size=1
    new-instance v12, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    const-string v1, ""
    const-string v2, ""
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 496
    const/4 v11, 0
    move-object v0, v12
    invoke-direct/range v0 ... v11, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v12
.end method

.method private final dismissPluginAuthBottomSheetIfShowing()void
    .registers 5
    # ins_size=1
    invoke-virtual v4, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string v1, "PluginAuthorizationBottomSheet"
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;
    if-eqz v1, +010h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "CheckPointDialog"
    const-string v3, "dismissPluginAuthBottomSheetIfShowing: dismissing"
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->dismissAllowingStateLoss()V
    return-void 
.end method

.method private final executePendingConnectDevice()void
    .registers 16
    # ins_size=1
    iget-object v9, v15, Lcom/bytedance/trae/conversation/ConversationActivity;->pendingConnectDeviceType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    if-nez v9, +003h
    return-void 
    invoke-virtual v15, Lcom/bytedance/trae/conversation/ConversationActivity;->isFinishing()Z
    move-result v0
    if-nez v0, +0a7h
    invoke-virtual v15, Lcom/bytedance/trae/conversation/ConversationActivity;->isDestroyed()Z
    move-result v0
    if-nez v0, +0a1h
    invoke-virtual v15, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z
    move-result v0
    if-nez v0, +097h
    invoke-virtual v15, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string v1, "BillingUpgradePromptBottomSheet"
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    if-nez v0, +08bh
    invoke-virtual v15, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string v10, "DeviceFlowContainerBottomSheet"
    invoke-virtual v0, v10, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    if-eqz v0, +004h
    goto/16 +07dh
    const/4 v0, 0
    iput-object v0, v15, Lcom/bytedance/trae/conversation/ConversationActivity;->pendingConnectDeviceType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    const/4 v0, 1
    iput-boolean v0, v15, Lcom/bytedance/trae/conversation/ConversationActivity;->pendingConnectDeviceFlowActive Z
    sget-object v11, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->Companion Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$Companion;
    new-instance v12, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
    new-instance v13, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;
    new-instance v14, Lcom/bytedance/trae/conversation/devices/BindingTarget;
    sget-object v0, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CliListRepository;->getCachedDevices()Ljava/util/List;
    move-result-object v0
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowExistingDeviceIdsKt;->mobileDeviceIdsByProduct(Ljava/util/List;)Ljava/util/Map;
    move-result-object v0
    invoke-interface v0, v9, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/Set;
    if-nez v0, +006h
    invoke-static Lkotlin/collections/SetsKt;->emptySet()Ljava/util/Set;
    move-result-object v0
    move-object v2, v0
    const-string/jumbo v3, site_message
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 56
    const/4 v8, 0
    move-object v0, v14
    move-object v1, v9
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/devices/BindingTarget;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/Set; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v13, v14, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;-><init>(Lcom/bytedance/trae/conversation/devices/BindingTarget;)V
    check-cast v13, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    new-instance v14, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    new-instance v6, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda27;
    invoke-direct v6, v15, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda27;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    const/16 v7, 31
    move-object v0, v14
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v12, v13, v14, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;-><init>(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute; Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;)V
    invoke-virtual v11, v12, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$Companion;->newInstance(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual v15, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v2
    invoke-virtual v0, v2, v10, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->showNow(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    invoke-virtual v15, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v2
    invoke-virtual v2, v10, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v2
    if-eq v2, v0, +018h
    iput-boolean v1, v15, Lcom/bytedance/trae/conversation/ConversationActivity;->pendingConnectDeviceFlowActive Z
    iput-object v9, v15, Lcom/bytedance/trae/conversation/ConversationActivity;->pendingConnectDeviceType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    goto +12h
    move-exception v0
    iput-boolean v1, v15, Lcom/bytedance/trae/conversation/ConversationActivity;->pendingConnectDeviceFlowActive Z
    iput-object v9, v15, Lcom/bytedance/trae/conversation/ConversationActivity;->pendingConnectDeviceType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string/jumbo v2, show pending connect device flow failed
    check-cast v0, Ljava/lang/Throwable;
    const-string v3, "ConversationActivity"
    invoke-virtual v1, v3, v2, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x89
.end method

.method private static final executePendingConnectDevice$lambda$100(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 2
    # ins_size=1
    const/4 v0, 0
    iput-boolean v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->pendingConnectDeviceFlowActive Z
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final exitAnchorWindowAndShowLatestPage()boolean
    .registers 4
    # ins_size=1
    const/4 v0, 1
    iput-boolean v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->snapToBottomAfterLatestPageSubmit Z
    iget-object v1, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v2, 0
    if-nez v1, +009h
    const-string/jumbo v1, viewModel
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->exitAnchorWindowAndLoadLatest()Z
    move-result v1
    if-nez v1, +006h
    const/4 v0, 0
    iput-boolean v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->snapToBottomAfterLatestPageSubmit Z
    return v0
    iput-object v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->anchorCreatedAtMs Ljava/lang/String;
    iput-boolean v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->hasScrolledToAnchorCreatedAt Z
    return v0
.end method

.method private final findUserMessageId(java.lang.String)java.lang.String
    .registers 7
    # ins_size=2
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getMessages()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v2
    invoke-interface v0, v2, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/ListIterator;->hasPrevious()Z
    move-result v3
    if-eqz v3, +017h
    invoke-interface v2, Ljava/util/ListIterator;->previous()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -014h
    invoke-interface v2, Ljava/util/ListIterator;->nextIndex()I
    move-result v6
    goto +2h
    const/4 v6, -1
    const-string v2, ""
    if-lez v6, +037h
    const/4 v3, 0
    invoke-interface v0, v3, v6, Ljava/util/List;->subList(I I)Ljava/util/List;
    move-result-object v6
    invoke-interface v6, Ljava/util/List;->size()I
    move-result v0
    invoke-interface v6, v0, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/ListIterator;->hasPrevious()Z
    move-result v0
    if-eqz v0, +017h
    invoke-interface v6, Ljava/util/ListIterator;->previous()Ljava/lang/Object;
    move-result-object v0
    move-object v3, v0
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getRole()Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v4, user
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -018h
    goto +2h
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    goto +2h
    move-object v2, v1
    return-object v2
.end method

.method private final flushPendingTriggerTracker(java.lang.String  java.lang.String)void
    .registers 20
    # ins_size=3
    move-object/from16 v0, v17
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->pendingTriggerTracker Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;
    if-nez v1, +003h
    return-void 
    const/4 v2, 0
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->pendingTriggerTracker Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->getEventContext()Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    move-result-object v3
    const/4 v4, 0
    const-string v2, ""
    if-nez v18, +004h
    move-object v5, v2
    goto +3h
    move-object/from16 v5, v18
    if-nez v19, +004h
    move-object v6, v2
    goto +3h
    move-object/from16 v6, v19
    const/4 v7, 0
    const/16 v8, 9
    const/4 v9, 0
    invoke-static/range v3 ... v9, Lcom/bytedance/trae/conversation/tracker/AIEventContext;->copy$default(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    move-result-object v11
    sget-object v10, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->getSendContext()Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    move-result-object v12
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->getChatMode()Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    move-result-object v13
    const/4 v14, 0
    const/16 v15, 8
    const/16 v16, 0
    invoke-static/range v10 ... v16, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackTrigger$default(Lcom/bytedance/trae/conversation/tracker/TraeAITracker; Lcom/bytedance/trae/conversation/tracker/AIEventContext; Lcom/bytedance/trae/conversation/tracker/AISendMessageContext; Lcom/bytedance/trae/conversation/tracker/SoloChatMode; Ljava/util/Map; I Ljava/lang/Object;)V
    return-void 
.end method

.method private final getConversationDao()com.bytedance.trae.im.database.ConversationDao
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->conversationDao$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/database/ConversationDao;
    return-object v0
.end method

.method private final getDetailFragment()com.bytedance.trae.conversation.chat.ConversationDetailFragment
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string v1, "ConversationDetailFragment"
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    if-eqz v1, +005h
    check-cast v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method private final getGitHubConnectorManager()com.bytedance.trae.conversation.git.GitHubConnectorManager
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->gitHubConnectorManager$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;
    return-object v0
.end method

.method private final getGitSelectionViewModel()com.bytedance.trae.conversation.git.GitSelectionViewModel
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->gitSelectionViewModel$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    return-object v0
.end method

.method private final getInputFragment()com.bytedance.trae.conversation.widget.InputFragment
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string v1, "InputFragment"
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    const-string v1, "null cannot be cast to non-null type com.bytedance.trae.conversation.widget.InputFragment"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/conversation/widget/InputFragment;
    return-object v0
.end method

.method private static final gitHubConnectorManager_delegate$lambda$2(com.bytedance.trae.conversation.ConversationActivity)com.bytedance.trae.conversation.git.GitHubConnectorManager
    .registers 4
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;
    check-cast v3, Landroid/content/Context;
    const/4 v1, 0
    const/4 v2, 2
    invoke-direct v0, v3, v1, v2, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;-><init>(Landroid/content/Context; Lcom/bytedance/trae/conversation/git/GitHubConnectConfig; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
.end method

.method private static final gitSelectionViewModel_delegate$lambda$3(com.bytedance.trae.conversation.ConversationActivity)com.bytedance.trae.conversation.git.GitSelectionViewModel
    .registers 2
    # ins_size=1
    new-instance v0, Landroidx/lifecycle/ViewModelProvider;
    check-cast v1, Landroidx/lifecycle/ViewModelStoreOwner;
    invoke-direct v0, v1, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V
    const-class v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-virtual v0, v1, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    return-object v1
.end method

.method private final handleGitError()void
    .registers 8
    # ins_size=1
    invoke-direct v7, Lcom/bytedance/trae/conversation/ConversationActivity;->showLoading()V
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final handlePushNewIntent(java.lang.String  android.content.Intent)void
    .registers 6
    # ins_size=3
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    invoke-virtual v3, Lcom/bytedance/trae/conversation/ConversationActivity;->finish()V
    new-instance v0, Landroid/content/Intent;
    move-object v1, v3
    check-cast v1, Landroid/content/Context;
    const-class v2, Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v0, v1, v2, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    invoke-virtual v0, v5, Landroid/content/Intent;->putExtras(Landroid/content/Intent;)Landroid/content/Intent;
    const-string v5, "extra_conversation_id"
    invoke-virtual v0, v5, v4, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method

.method private final handleStartServerIntent(android.content.Intent)void
    .registers 7
    # ins_size=2
    if-nez v6, +003h
    return-void 
    const-string v0, "extra_start_server_url"
    invoke-virtual v6, v0, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v3
    goto +2h
    move v2, v4
    if-nez v2, +021h
    invoke-virtual v6, v0, Landroid/content/Intent;->removeExtra(Ljava/lang/String;)V
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_doc_preview_start_server_message I
    new-array v0, v4, [Ljava/lang/Object;
    aput-object v1, v0, v3
    invoke-virtual v5, v6, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    const-string v0, "getString(...)"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper;->INSTANCE Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper;
    move-object v1, v5
    check-cast v1, Landroidx/activity/ComponentActivity;
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda33;
    invoke-direct v2, v5, v6, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda33;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String;)V
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper;->showIfNeeded(Landroidx/activity/ComponentActivity; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private static final handleStartServerIntent$lambda$120(com.bytedance.trae.conversation.ConversationActivity  java.lang.String)kotlin.Unit
    .registers 19
    # ins_size=2
    move-object/from16 v0, v17
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->isNewConversation Z
    const-string/jumbo v2, viewModel
    const/4 v3, 0
    if-eqz v1, +01bh
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v1, +008h
    const-string v1, "binding"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getSegmentedSelectedIndex()I
    move-result v1
    if-nez v1, +005h
    sget-object v1, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    goto +3h
    sget-object v1, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    move-object v7, v1
    goto +46h
    invoke-static Lcom/bytedance/trae/im/service/Mode;->getEntries()Lkotlin/enums/EnumEntries;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +02eh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v5
    iget-object v6, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v6, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v3
    invoke-virtual v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v6
    invoke-interface v6, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v6
    goto +2h
    move-object v6, v3
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, -02fh
    goto +2h
    move-object v4, v3
    move-object v1, v4
    check-cast v1, Lcom/bytedance/trae/im/service/Mode;
    if-nez v1, -042h
    sget-object v1, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    goto -46h
    new-instance v1, Lcom/google/gson/Gson;
    invoke-direct v1, Lcom/google/gson/Gson;-><init>()V
    invoke-static Lkotlin/collections/CollectionsKt;->createListBuilder()Ljava/util/List;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/conversation/model/QueryItem;->Companion Lcom/bytedance/trae/conversation/model/QueryItem$Companion;
    move-object/from16 v6, v18
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/model/QueryItem$Companion;->text(Ljava/lang/String;)Lcom/bytedance/trae/conversation/model/QueryItem;
    move-result-object v5
    invoke-interface v4, v5, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-static v4, Lkotlin/collections/CollectionsKt;->build(Ljava/util/List;)Ljava/util/List;
    move-result-object v4
    invoke-virtual v1, v4, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    invoke-direct/range v17, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getSelectedModelForRequest()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v8
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v3
    const/4 v5, 2
    const/4 v9, 0
    invoke-static v0, v7, v9, v5, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->buildSendMessageContext$default(Lcom/bytedance/trae/conversation/ConversationActivity; Lcom/bytedance/trae/im/service/Mode; I I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    move-result-object v5
    iput-object v5, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->lastSendContext Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    iput-boolean v9, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->hasReportedStreamShow Z
    iput-boolean v9, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->wasUserInitiatedCancel Z
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v9
    iput-wide v9, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->streamingStartTimeMs J
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->streamingMessageId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->streamingChatModel Ljava/lang/String;
    new-instance v9, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;
    new-instance v15, Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    const/4 v11, 0
    iget-object v10, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v10, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v3
    invoke-virtual v10, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v10
    invoke-interface v10, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Ljava/lang/String;
    if-nez v10, +004h
    const-string v10, ""
    move-object v12, v10
    const/4 v13, 0
    if-nez v4, +004h
    const-string v4, "auto"
    move-object v14, v4
    const/4 v4, 5
    const/16 v16, 0
    move-object v10, v15
    move-object v3, v15
    move v15, v4
    invoke-direct/range v10 ... v16, Lcom/bytedance/trae/conversation/tracker/AIEventContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v0, v7, Lcom/bytedance/trae/conversation/ConversationActivity;->resolveCurrentChatMode(Lcom/bytedance/trae/im/service/Mode;)Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    move-result-object v4
    invoke-direct v9, v3, v5, v4, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;-><init>(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Lcom/bytedance/trae/conversation/tracker/AISendMessageContext; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    iput-object v9, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->pendingTriggerTracker Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +007h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v4, 0
    goto +2h
    move-object v4, v0
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const/4 v9, 0
    const/16 v10, 16
    const/4 v11, 0
    move-object/from16 v5, v18
    move-object v6, v1
    invoke-static/range v4 ... v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->sendMessage$default(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/Mode; Lcom/bytedance/trae/conversation/network/RemoteModelItem; Z I Ljava/lang/Object;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final hideLoading()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->loadingDialog Landroid/app/Dialog;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/app/Dialog;->dismiss()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->loadingDialog Landroid/app/Dialog;
    return-void 
.end method

.method private final hideWelcomeScreen()void
    .registers 6
    # ins_size=1
    iget-boolean v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->isNewConversation Z
    if-nez v0, +003h
    return-void 
    const/4 v0, 0
    iput-boolean v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->isNewConversation Z
    invoke-direct v5, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v1
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->setNewConversation(Z)V
    iget-object v1, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    const/4 v2, 0
    const-string v3, "binding"
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->welcomeFragmentContainer Landroidx/fragment/app/FragmentContainerView;
    const/16 v4, 8
    invoke-virtual v1, v4, Landroidx/fragment/app/FragmentContainerView;->setVisibility(I)V
    iget-object v1, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v1
    iget-object v1, v2, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->detailFragmentContainer Landroidx/fragment/app/FragmentContainerView;
    invoke-virtual v1, v0, Landroidx/fragment/app/FragmentContainerView;->setVisibility(I)V
    invoke-direct v5, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->hideTaskTemplates()V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string v1, "WelcomeFragment"
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    if-eqz v0, +011h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    invoke-virtual v1, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v1
    invoke-virtual v1, v0, Landroidx/fragment/app/FragmentTransaction;->remove(Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentTransaction;->commitNowAllowingStateLoss()V
    return-void 
.end method

.method private final initCheckpointDialog()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda43;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda43;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->init(Lkotlin/jvm/functions/Function0;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->checkpoint_overlay_container I
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->setContainerId(I)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda45;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda45;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->setOnDismissAction(Lkotlin/jvm/functions/Function0;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$initCheckpointDialog$3;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$initCheckpointDialog$3;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->setInteractionCallback(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda46;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda46;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->setOnFileClick(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final initCheckpointDialog$lambda$43(com.bytedance.trae.conversation.ConversationActivity)android.content.Context
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationActivity;->getApplicationContext()Landroid/content/Context;
    move-result-object v1
    const-string v0, "getApplicationContext(...)"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v1
.end method

.method private static final initCheckpointDialog$lambda$44(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    const-string v1, "binding"
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->checkpointOverlayContainer Landroidx/fragment/app/FragmentContainerView;
    const/4 v3, 0
    invoke-virtual v0, v3, Landroidx/fragment/app/FragmentContainerView;->setTranslationY(F)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->checkpointOverlayContainer Landroidx/fragment/app/FragmentContainerView;
    const/16 v3, 8
    invoke-virtual v0, v3, Landroidx/fragment/app/FragmentContainerView;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->inputFragmentContainer Landroidx/fragment/app/FragmentContainerView;
    const/4 v1, 0
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentContainerView;->setVisibility(I)V
    iput-boolean v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->isCheckpointDialogVisible Z
    iput-object v2, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->showingCheckpointToolCallId Ljava/lang/String;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method

.method private static final initCheckpointDialog$lambda$45(com.bytedance.trae.conversation.ConversationActivity  java.lang.String  java.lang.String)kotlin.Unit
    .registers 4
    # ins_size=3
    const-string v0, "filePath"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->openFile(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final initInputFragment()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v1, +008h
    const-string v1, "binding"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->voiceRecordingOverlay Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setVoiceRecordingOverlay(Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda16;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda16;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setTaskRunning(Lkotlin/jvm/functions/Function0;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda17;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda17;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setOnSendAudioText(Lkotlin/jvm/functions/Function2;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda18;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda18;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setOnSendText(Lkotlin/jvm/functions/Function1;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda19;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda19;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setOnInputFocus(Lkotlin/jvm/functions/Function0;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda20;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda20;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setOnTemplateClick(Lkotlin/jvm/functions/Function1;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda21;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda21;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setOnChatNewClick(Lkotlin/jvm/functions/Function0;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda23;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda23;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setOnReady(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private static final initInputFragment$lambda$64(com.bytedance.trae.conversation.ConversationActivity)boolean
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->isTaskRunning()Z
    move-result v0
    return v0
.end method

.method private static final initInputFragment$lambda$65(com.bytedance.trae.conversation.ConversationActivity  java.lang.String  java.lang.String)kotlin.Unit
    .registers 10
    # ins_size=3
    const-string v0, "query"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, text
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/conversation/ConversationActivity;->sendQuery$default(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; I Ljava/lang/Object;)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method

.method private static final initInputFragment$lambda$66(com.bytedance.trae.conversation.ConversationActivity  java.lang.String)kotlin.Unit
    .registers 9
    # ins_size=2
    const-string/jumbo v0, text
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$3$1;
    const/4 v4, 0
    invoke-direct v0, v7, v8, v4, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$3$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method

.method private static final initInputFragment$lambda$67(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/conversation/ConversationActivity;->exitAnchorWindowAndShowLatestPage()Z
    move-result v0
    if-nez v0, +00bh
    invoke-direct v1, Lcom/bytedance/trae/conversation/ConversationActivity;->getDetailFragment()Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    move-result-object v1
    if-eqz v1, +005h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->forceScrollToBottom()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final initInputFragment$lambda$69(com.bytedance.trae.conversation.ConversationActivity  java.lang.String)kotlin.Unit
    .registers 10
    # ins_size=2
    const-string/jumbo v0, template
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/google/gson/Gson;
    invoke-direct v0, Lcom/google/gson/Gson;-><init>()V
    invoke-static Lkotlin/collections/CollectionsKt;->createListBuilder()Ljava/util/List;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/model/QueryItem;->Companion Lcom/bytedance/trae/conversation/model/QueryItem$Companion;
    invoke-virtual v2, v9, Lcom/bytedance/trae/conversation/model/QueryItem$Companion;->text(Ljava/lang/String;)Lcom/bytedance/trae/conversation/model/QueryItem;
    move-result-object v2
    invoke-interface v1, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-static v1, Lkotlin/collections/CollectionsKt;->build(Ljava/util/List;)Ljava/util/List;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const/4 v5, 0
    const/4 v6, 4
    const/4 v7, 0
    move-object v2, v8
    move-object v4, v9
    invoke-static/range v2 ... v7, Lcom/bytedance/trae/conversation/ConversationActivity;->sendQuery$default(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; I Ljava/lang/Object;)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
.end method

.method private static final initInputFragment$lambda$70(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->voiceDiscussionAttemptTracker Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    if-eqz v0, +00ah
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->ACTIVITY_NOT_SHOWN Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    const-string/jumbo v2, replaced_by_new_click
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->finish(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome; Ljava/lang/String;)Z
    invoke-direct v4, Lcom/bytedance/trae/conversation/ConversationActivity;->createVoiceDiscussionAttempt()Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    move-result-object v0
    iput-object v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->voiceDiscussionAttemptTracker Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    sget-object v1, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->snapshot()Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getAttemptId()Ljava/lang/String;
    move-result-object v2
    const-string v3, "discussion_button_click"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackAsrDiscuss(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v1, +009h
    const-string/jumbo v1, viewModel
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->getSelectedDevice()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    invoke-direct v4, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->canStartBrainstormForDevice(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)Z
    move-result v1
    if-eqz v1, +00bh
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->ELIGIBILITY_PASSED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->recordStage(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;)Z
    invoke-direct v4, Lcom/bytedance/trae/conversation/ConversationActivity;->requestBrainstormPermissions()V
    goto +8h
    sget-object v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->BLOCKED_IDE_VERSION Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    const-string v1, "desktop_ide_version_below_minimum"
    invoke-virtual v0, v4, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->finish(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome; Ljava/lang/String;)Z
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method

.method private static final initInputFragment$lambda$78(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const-string/jumbo v1, viewModel
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    iget-object v3, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->initialChatMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->setMode(Lcom/bytedance/trae/conversation/widget/ChatMode;)V
    iget-boolean v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->isNewConversation Z
    if-eqz v0, +008h
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->initialChatMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->updateModeTab(Lcom/bytedance/trae/conversation/widget/ChatMode;)V
    goto +47h
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v0, +034h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v3
    const-string v4, "code"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    goto +3h
    sget-object v3, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v0
    sget-object v4, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00ch
    invoke-direct v5, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    sget-object v3, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->setMode(Lcom/bytedance/trae/conversation/widget/ChatMode;)V
    goto +8h
    invoke-direct v5, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->setMode(Lcom/bytedance/trae/conversation/widget/ChatMode;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getSelectedDevice()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v0, +016h
    iget-object v3, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->selectedDeviceByMode Ljava/util/Map;
    invoke-direct v5, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getCurrentMode()Lcom/bytedance/trae/conversation/widget/ChatMode;
    move-result-object v4
    invoke-interface v3, v4, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-direct v5, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v3
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->setSelectedDevice(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)V
    invoke-direct v5, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    iget-object v3, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v2
    invoke-virtual v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v3
    invoke-interface v3, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->setConversationId(Ljava/lang/String;)V
    invoke-direct v5, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    new-instance v3, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda48;
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda48;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->setOnDeviceClick(Lkotlin/jvm/functions/Function0;)V
    invoke-direct v5, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    new-instance v3, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda49;
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda49;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->setOnSelectedDeviceChanged(Lkotlin/jvm/functions/Function1;)V
    invoke-direct v5, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    new-instance v3, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda50;
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda50;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->setOnRequestSkillProjectCheck(Lkotlin/jvm/functions/Function1;)V
    invoke-direct v5, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    new-instance v3, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda51;
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda51;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->setOnAuthFailed(Lkotlin/jvm/functions/Function0;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v2
    invoke-virtual v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/Conversation;
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v4
    goto +2h
    move v0, v3
    if-nez v0, +038h
    invoke-direct v5, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    invoke-virtual v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->setCloudEnabled(Z)V
    if-eqz v1, +010h
    invoke-direct v5, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    invoke-virtual v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->setBottomContextualBarVisible(Z)V
    invoke-direct v5, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    invoke-virtual v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->setDeviceFolderBarVisible(Z)V
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v2
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00ah
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +2h
    move v3, v4
    if-nez v3, +01dh
    invoke-direct v5, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v1
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->setCloudName(Ljava/lang/String;)V
    goto +14h
    invoke-direct v5, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->setCloudEnabled(Z)V
    invoke-direct v5, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda52;
    invoke-direct v1, v5, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda52;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setOnCloudClick(Lkotlin/jvm/functions/Function0;)V
    invoke-direct v5, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    iget-boolean v1, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->isNewConversation Z
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->setNewConversation(Z)V
    iget-boolean v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->isNewConversation Z
    if-eqz v0, +009h
    invoke-direct v5, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->showTaskTemplates()V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v0, +008h
    const-string v0, "binding"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda53;
    invoke-direct v1, v5, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda53;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v0, v1, Landroidx/constraintlayout/widget/ConstraintLayout;->post(Ljava/lang/Runnable;)Z
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
.end method

.method private static final initInputFragment$lambda$78$lambda$72(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationActivity;->showCliSelectionDialog()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final initInputFragment$lambda$78$lambda$73(com.bytedance.trae.conversation.ConversationActivity  com.bytedance.trae.conversation.devices.SelectedDeviceItem)kotlin.Unit
    .registers 4
    # ins_size=2
    const-string v0, "device"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->selectedDeviceByMode Ljava/util/Map;
    invoke-direct v2, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getCurrentMode()Lcom/bytedance/trae/conversation/widget/ChatMode;
    move-result-object v1
    invoke-interface v0, v1, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v2, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v2, +009h
    const-string/jumbo v2, viewModel
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->setSelectedDevice(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final initInputFragment$lambda$78$lambda$74(com.bytedance.trae.conversation.ConversationActivity  kotlin.jvm.functions.Function1)kotlin.Unit
    .registers 9
    # ins_size=2
    const-string v0, "onResult"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$7$4$1;
    const/4 v4, 0
    invoke-direct v0, v7, v8, v4, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$7$4$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method

.method private static final initInputFragment$lambda$78$lambda$75(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 3
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
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_codebase_error_oauth_authorized_failed I
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v0
    const-string v1, "getString(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/content/Context;
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    invoke-static v2, v0, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/Toast;->show()V
    goto +4h
    invoke-direct v2, Lcom/bytedance/trae/conversation/ConversationActivity;->handleGitError()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final initInputFragment$lambda$78$lambda$76(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationActivity;->showCliSelectionDialog()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final initInputFragment$lambda$78$lambda$77(com.bytedance.trae.conversation.ConversationActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    const-string v0, "InputFragment"
    invoke-virtual v1, v0, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v1
    instance-of v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;
    if-eqz v0, +005h
    check-cast v1, Lcom/bytedance/trae/conversation/widget/InputFragment;
    goto +2h
    const/4 v1, 0
    if-eqz v1, +005h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->showDeviceTipsPopWindow()V
    return-void 
.end method

.method private final initTitleBar()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    const-string v2, "binding"
    if-eqz v0, +006h
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->updateConversationTitleInfo(Lcom/bytedance/trae/im/service/Conversation;)V
    goto +eh
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->showNewConversationHeader()V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v3, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda54;
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda54;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v3, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda56;
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda56;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    const/4 v4, 0
    invoke-virtual v0, v4, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnRightActionClickListener(I Landroid/view/View$OnClickListener;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v3, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda57;
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda57;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    const/4 v4, 1
    invoke-virtual v0, v4, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnRightActionClickListener(I Landroid/view/View$OnClickListener;)V
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->updateModeTab(Lcom/bytedance/trae/conversation/widget/ChatMode;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda58;
    invoke-direct v1, v5, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda58;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnSegmentedTabSelectedListener(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final initTitleBar$lambda$46(com.bytedance.trae.conversation.ConversationActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationActivity;->getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;
    move-result-object v0
    invoke-virtual v0, Landroidx/activity/OnBackPressedDispatcher;->onBackPressed()V
    return-void 
.end method

.method private static final initTitleBar$lambda$48(com.bytedance.trae.conversation.ConversationActivity  android.view.View)void
    .registers 4
    # ins_size=2
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->isMinimized()Z
    move-result v3
    if-eqz v3, +00ah
    iget-boolean v3, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->iLaunchedActiveBrainstorm Z
    if-eqz v3, +006h
    invoke-direct v2, Lcom/bytedance/trae/conversation/ConversationActivity;->showEndVoiceDiscussionDialog()V
    return-void 
    invoke-virtual v2, Lcom/bytedance/trae/conversation/ConversationActivity;->finish()V
    new-instance v3, Landroid/content/Intent;
    move-object v0, v2
    check-cast v0, Landroid/content/Context;
    const-class v1, Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v3, v0, v1, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v1
    const-string v0, "extra_mode"
    invoke-virtual v3, v0, v1, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v0, "extra_enter_from"
    const-string v1, "history_chat"
    invoke-virtual v3, v0, v1, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method

.method private static final initTitleBar$lambda$49(com.bytedance.trae.conversation.ConversationActivity  android.view.View)void
    .registers 13
    # ins_size=2
    iget-object v0, v11, Lcom/bytedance/trae/conversation/ConversationActivity;->menuPopupWindow Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +00ah
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->isShowing()Z
    move-result v0
    if-ne v0, v1, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +00ah
    iget-object v11, v11, Lcom/bytedance/trae/conversation/ConversationActivity;->menuPopupWindow Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;
    if-eqz v11, +005h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->dismiss()V
    return-void 
    iget-object v0, v11, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const-string/jumbo v3, viewModel
    const/4 v4, 0
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v4
    const-string v5, "code"
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    xor-int/lit8 v8, v0, 1
    iget-object v0, v11, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->supportsPin()Z
    move-result v0
    if-eqz v0, +00eh
    sget-object v0, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->INSTANCE Lcom/bytedance/trae/settings/api/feature/FeatureCapability;
    sget-object v5, Lcom/bytedance/trae/settings/api/feature/Feature;->TASK_LIST_PIN Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-virtual v0, v5, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->isEnabled(Lcom/bytedance/trae/settings/api/feature/Feature;)Z
    move-result v0
    if-eqz v0, +004h
    move v9, v1
    goto +2h
    move v9, v2
    iget-object v0, v11, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v0, +010h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->isPinned()Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    move v10, v0
    goto +2h
    move v10, v2
    new-instance v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;
    move-object v6, v11
    check-cast v6, Landroid/content/Context;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;
    invoke-direct v1, v11, Lcom/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    move-object v7, v1
    check-cast v7, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;
    move-object v5, v0
    invoke-direct/range v5 ... v10, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;-><init>(Landroid/content/Context; Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener; Z Z Z)V
    iput-object v0, v11, Lcom/bytedance/trae/conversation/ConversationActivity;->menuPopupWindow Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;
    invoke-virtual v0, v12, v2, v2, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->showAsDropDown(Landroid/view/View; I I)V
    sget-object v12, Lcom/bytedance/trae/conversation/tracker/InputTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/InputTracker;
    iget-object v11, v11, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v11, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v4, v11
    invoke-virtual v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v11
    invoke-interface v11, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Ljava/lang/String;
    if-nez v11, +004h
    const-string v11, ""
    invoke-virtual v12, v11, Lcom/bytedance/trae/conversation/tracker/InputTracker;->trackMenuClick(Ljava/lang/String;)V
    return-void 
.end method

.method private static final initTitleBar$lambda$53(com.bytedance.trae.conversation.ConversationActivity  int  java.lang.String)kotlin.Unit
    .registers 8
    # ins_size=3
    const-string v0, "<unused var>"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v6, +005h
    sget-object v6, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    goto +3h
    sget-object v6, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v7, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v6, v7, +005h
    sget-object v7, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    goto +3h
    sget-object v7, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/InputTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/InputTracker;
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    const-string v2, "code"
    if-ne v6, v1, +005h
    const-string v1, "mtc"
    goto +2h
    move-object v1, v2
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/tracker/InputTracker;->trackModeSwitchClick(Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string v1, "InputFragment"
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;
    const/4 v3, 0
    if-eqz v1, +005h
    check-cast v0, Lcom/bytedance/trae/conversation/widget/InputFragment;
    goto +2h
    move-object v0, v3
    if-eqz v0, +018h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->saveDraft()Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;
    move-result-object v1
    if-eqz v1, +012h
    iget-object v4, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->draftByMode Ljava/util/Map;
    invoke-interface v4, v7, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->getCurrentDevice()Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    move-result-object v1
    if-eqz v1, +007h
    iget-object v4, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->selectedDeviceByMode Ljava/util/Map;
    invoke-interface v4, v7, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->clearInput()V
    iget-object v7, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const-string/jumbo v1, viewModel
    if-nez v7, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v7, v3
    invoke-virtual v7, v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->setMode(Lcom/bytedance/trae/conversation/widget/ChatMode;)V
    sget-object v7, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->INSTANCE Lcom/bytedance/trae/conversation/AccountSettingsKeva;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v7
    sget-object v4, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v6, v4, +003h
    goto +4h
    const-string/jumbo v2, work
    const-string v4, "last_selected_chat_mode"
    invoke-virtual v7, v4, v2, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v0, +005h
    invoke-virtual v0, v6, Lcom/bytedance/trae/conversation/widget/InputFragment;->switchMode(Lcom/bytedance/trae/conversation/widget/ChatMode;)V
    iget-object v7, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->draftByMode Ljava/util/Map;
    invoke-interface v7, v6, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;
    if-eqz v7, +008h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->getCurrentDevice()Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    move-result-object v2
    if-nez v2, +010h
    iget-object v2, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->selectedDeviceByMode Ljava/util/Map;
    invoke-interface v2, v6, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-nez v2, +006h
    invoke-direct v5, Lcom/bytedance/trae/conversation/ConversationActivity;->defaultRemoteDevice()Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    move-result-object v2
    if-eqz v7, +007h
    if-eqz v0, +005h
    invoke-virtual v0, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->restoreDraft(Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;)V
    if-eqz v7, +007h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->getCurrentDevice()Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    move-result-object v7
    goto +2h
    move-object v7, v3
    if-nez v7, +007h
    if-eqz v0, +005h
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setSelectedDevice(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)V
    iget-object v7, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->selectedDeviceByMode Ljava/util/Map;
    invoke-interface v7, v6, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v7, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v7, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v7, v3
    invoke-virtual v7, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->setSelectedDevice(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v5
    const-string v7, "WelcomeFragment"
    invoke-virtual v5, v7, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v5
    instance-of v7, v5, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;
    if-eqz v7, +005h
    move-object v3, v5
    check-cast v3, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;
    if-eqz v3, +005h
    invoke-virtual v3, v6, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->setMode(Lcom/bytedance/trae/conversation/widget/ChatMode;)V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
.end method

.method private final initWelcomeFragment()void
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string v1, "WelcomeFragment"
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;
    const/4 v2, 0
    if-eqz v1, +005h
    check-cast v0, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;
    goto +2h
    move-object v0, v2
    if-nez v0, +003h
    return-void 
    iget-object v1, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v1, +008h
    const-string v1, "binding"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v1
    iget-object v1, v2, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getSegmentedSelectedIndex()I
    move-result v1
    if-nez v1, +005h
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    goto +3h
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->setMode(Lcom/bytedance/trae/conversation/widget/ChatMode;)V
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda24;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda24;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->setOnModeSwipe(Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private static final initWelcomeFragment$lambda$60(com.bytedance.trae.conversation.ConversationActivity  com.bytedance.trae.conversation.widget.ChatMode)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string/jumbo v0, targetMode
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->isNewConversation Z
    if-eqz v0, +005h
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->updateModeTab(Lcom/bytedance/trae/conversation/widget/ChatMode;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final isCommittedNewFeaturePrompt(com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet)boolean
    .registers 4
    # ins_size=2
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->isAdded()Z
    move-result v0
    if-eqz v0, +010h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string v1, "DeviceFlowContainerBottomSheet"
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    if-ne v0, v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    return v3
.end method

.method private final isManagedPromptHostReady()boolean
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/ConversationActivity;->isFinishing()Z
    move-result v0
    if-nez v0, +03ch
    invoke-virtual v2, Lcom/bytedance/trae/conversation/ConversationActivity;->isDestroyed()Z
    move-result v0
    if-nez v0, +036h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/ConversationActivity;->getLifecycle()Landroidx/lifecycle/Lifecycle;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/Lifecycle;->getCurrentState()Landroidx/lifecycle/Lifecycle$State;
    move-result-object v0
    sget-object v1, Landroidx/lifecycle/Lifecycle$State;->RESUMED Landroidx/lifecycle/Lifecycle$State;
    invoke-virtual v0, v1, Landroidx/lifecycle/Lifecycle$State;->isAtLeast(Landroidx/lifecycle/Lifecycle$State;)Z
    move-result v0
    if-eqz v0, +026h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z
    move-result v0
    if-nez v0, +01ch
    invoke-virtual v2, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string v1, "BillingUpgradePromptBottomSheet"
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    if-nez v0, +010h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string v1, "DeviceFlowContainerBottomSheet"
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method private final isTouchOnInputArea(android.view.MotionEvent)boolean
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    const/4 v1, 0
    const-string v2, "binding"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->checkpointOverlayContainer Landroidx/fragment/app/FragmentContainerView;
    invoke-virtual v0, Landroidx/fragment/app/FragmentContainerView;->getVisibility()I
    move-result v0
    if-nez v0, +00eh
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->checkpointOverlayContainer Landroidx/fragment/app/FragmentContainerView;
    goto +ch
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->inputFragmentContainer Landroidx/fragment/app/FragmentContainerView;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v0, Landroidx/fragment/app/FragmentContainerView;->getVisibility()I
    move-result v1
    if-eqz v1, +004h
    const/4 v4, 0
    return v4
    new-instance v1, Landroid/graphics/Rect;
    invoke-direct v1, Landroid/graphics/Rect;-><init>()V
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentContainerView;->getGlobalVisibleRect(Landroid/graphics/Rect;)Z
    invoke-virtual v4, Landroid/view/MotionEvent;->getRawX()F
    move-result v0
    float-to-int v0, v0
    invoke-virtual v4, Landroid/view/MotionEvent;->getRawY()F
    move-result v4
    float-to-int v4, v4
    invoke-virtual v1, v0, v4, Landroid/graphics/Rect;->contains(I I)Z
    move-result v4
    return v4
.end method

.method private final launchBrainstormActivity()void
    .registers 25
    # ins_size=1
    move-object/from16 v0, v24
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->voiceDiscussionAttemptTracker Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const-string/jumbo v3, viewModel
    if-nez v2, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    iget-object v5, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v5, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v5, 0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v5
    invoke-interface v5, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/String;
    if-nez v5, +01ch
    iget-object v5, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v5, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v5, 0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v5
    invoke-interface v5, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v5
    goto +2h
    const/4 v5, 0
    iget-object v6, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v6, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v6, 0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->getSelectedDevice()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v6
    invoke-interface v6, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    const/4 v7, 1
    if-eqz v6, +013h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getId()Ljava/lang/String;
    move-result-object v8
    if-eqz v8, +00dh
    move-object v9, v8
    check-cast v9, Ljava/lang/CharSequence;
    invoke-static v9, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v9
    xor-int/2addr v9, v7
    if-eqz v9, +003h
    goto +2h
    const/4 v8, 0
    if-eqz v6, +008h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v9
    if-nez v9, +004h
    sget-object v9, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-direct/range v24, Lcom/bytedance/trae/conversation/ConversationActivity;->resolveTaskModeForCurrentConversation()Lcom/bytedance/trae/im/service/Mode;
    move-result-object v10
    if-eqz v6, +013h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getSelectedDirectory()Ljava/lang/String;
    move-result-object v11
    if-eqz v11, +00dh
    move-object v12, v11
    check-cast v12, Ljava/lang/CharSequence;
    invoke-static v12, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v12
    xor-int/2addr v12, v7
    if-eqz v12, +003h
    goto +2h
    const/4 v11, 0
    iget-object v12, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v12, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v12, 0
    invoke-virtual v12, v10, v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->resolveParentAgentTypeForSubTask(Lcom/bytedance/trae/im/service/Mode; Lcom/bytedance/trae/im/service/CliType;)Ljava/lang/String;
    move-result-object v12
    sget-object v13, Lcom/bytedance/trae/conversation/brainstorm/VoiceDiscussionPhase2Policy;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/VoiceDiscussionPhase2Policy;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/brainstorm/VoiceDiscussionPhase2Policy;->isAttachmentSubTaskEnabled()Z
    move-result v13
    const/4 v14, 0
    if-eqz v13, +00ch
    iget-boolean v15, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->isNewConversation Z
    if-eqz v15, +008h
    sget-object v15, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-ne v9, v15, +004h
    move v15, v7
    goto +2h
    move v15, v14
    invoke-direct/range v24, Lcom/bytedance/trae/conversation/ConversationActivity;->getGitSelectionViewModel()Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    move-result-object v16
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getSelectedRepo()Landroidx/lifecycle/LiveData;
    move-result-object v16
    invoke-virtual/range v16, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v16
    check-cast v16, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    if-eqz v16, +017h
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getRepoUrl()Ljava/lang/String;
    move-result-object v16
    if-eqz v16, +011h
    move-object/from16 v17, v16
    check-cast v17, Ljava/lang/CharSequence;
    invoke-static/range v17, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v17
    xor-int/lit8 v17, v17, 1
    if-eqz v17, +005h
    move-object/from16 v4, v16
    goto +2h
    const/4 v4, 0
    invoke-direct/range v24, Lcom/bytedance/trae/conversation/ConversationActivity;->getGitSelectionViewModel()Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    move-result-object v17
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getSelectedBranch()Landroidx/lifecycle/LiveData;
    move-result-object v17
    invoke-virtual/range v17, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v17
    check-cast v17, Lcom/bytedance/trae/conversation/git/BranchItem;
    if-eqz v17, +017h
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/git/BranchItem;->getName()Ljava/lang/String;
    move-result-object v17
    if-eqz v17, +011h
    move-object/from16 v18, v17
    check-cast v18, Ljava/lang/CharSequence;
    invoke-static/range v18, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v18
    xor-int/lit8 v18, v18, 1
    if-eqz v18, +005h
    move-object/from16 v7, v17
    goto +2h
    const/4 v7, 0
    invoke-direct v0, v6, Lcom/bytedance/trae/conversation/ConversationActivity;->canStartBrainstormForDevice(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)Z
    move-result v6
    if-nez v6, +00ch
    if-eqz v1, +009h
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->BLOCKED_IDE_VERSION Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    const-string v3, "desktop_ide_version_below_minimum"
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->finish(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome; Ljava/lang/String;)Z
    return-void 
    if-eqz v15, +020h
    sget-object v6, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    if-ne v10, v6, +01ch
    if-eqz v4, +01ah
    if-nez v7, +018h
    move-object v2, v0
    check-cast v2, Landroid/content/Context;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_git_please_select_branch I
    invoke-static v2, v3, v14, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/Toast;->show()V
    if-eqz v1, +009h
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->PREREQUISITE_FAILED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    const-string v3, "remote_code_branch_not_selected"
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->finish(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome; Ljava/lang/String;)Z
    return-void 
    const/4 v6, 1
    iput-boolean v6, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->iLaunchedActiveBrainstorm Z
    if-eqz v1, +007h
    sget-object v6, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->ACTIVITY_LAUNCH_REQUESTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v1, v6, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->recordStage(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;)Z
    iget-object v6, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->brainstormResultLauncher Landroidx/activity/result/ActivityResultLauncher;
    new-instance v14, Landroid/content/Intent;
    move-object/from16 v19, v6
    move-object v6, v0
    check-cast v6, Landroid/content/Context;
    move/from16 v20, v13
    const-class v13, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    invoke-direct v14, v6, v13, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    if-eqz v1, +079h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->snapshot()Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    move-result-object v1
    if-eqz v1, +073h
    const-string v6, "extra_voice_discussion_attempt_id"
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getAttemptId()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v14, v6, v13, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v6, "extra_voice_discussion_attempt_start_elapsed_ms"
    move-object v13, v3
    move-object/from16 v21, v4
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getStartedAtElapsedMs()J
    move-result-wide v3
    invoke-virtual v14, v6, v3, v4, Landroid/content/Intent;->putExtra(Ljava/lang/String; J)Landroid/content/Intent;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getStageElapsedMs()Ljava/util/Map;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->CLICK Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-interface v3, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/Long;
    const-wide/16 v22, -1
    if-eqz v3, +007h
    invoke-virtual v3, Ljava/lang/Long;->longValue()J
    move-result-wide v3
    goto +3h
    move-wide/from16 v3, v22
    const-string v6, "extra_voice_discussion_attempt_click_ms"
    invoke-virtual v14, v6, v3, v4, Landroid/content/Intent;->putExtra(Ljava/lang/String; J)Landroid/content/Intent;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getStageElapsedMs()Ljava/util/Map;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->ELIGIBILITY_PASSED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-interface v3, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/Long;
    if-eqz v3, +007h
    invoke-virtual v3, Ljava/lang/Long;->longValue()J
    move-result-wide v3
    goto +3h
    move-wide/from16 v3, v22
    const-string v6, "extra_voice_discussion_attempt_eligibility_passed_ms"
    invoke-virtual v14, v6, v3, v4, Landroid/content/Intent;->putExtra(Ljava/lang/String; J)Landroid/content/Intent;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getStageElapsedMs()Ljava/util/Map;
    move-result-object v1
    sget-object v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->ACTIVITY_LAUNCH_REQUESTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getValue()Ljava/lang/String;
    move-result-object v3
    invoke-interface v1, v3, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Long;
    if-eqz v1, +006h
    invoke-virtual v1, Ljava/lang/Long;->longValue()J
    move-result-wide v22
    move-wide/from16 v3, v22
    const-string v1, "extra_voice_discussion_attempt_activity_launch_requested_ms"
    invoke-virtual v14, v1, v3, v4, Landroid/content/Intent;->putExtra(Ljava/lang/String; J)Landroid/content/Intent;
    goto +4h
    move-object v13, v3
    move-object/from16 v21, v4
    move-object v1, v2
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00bh
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    if-nez v1, +007h
    const-string v1, "extra_session_id"
    invoke-virtual v14, v1, v2, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    move-object v1, v5
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00ch
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +4h
    const/16 v17, 0
    goto +3h
    const/16 v17, 1
    if-nez v17, +007h
    const-string v1, "extra_parent_conversation_id"
    invoke-virtual v14, v1, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v1, "extra_mic_check_start_ms"
    iget-wide v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->brainstormMicCheckStartMs J
    invoke-virtual v14, v1, v2, v3, Landroid/content/Intent;->putExtra(Ljava/lang/String; J)Landroid/content/Intent;
    const-string v1, "extra_mic_check_end_ms"
    iget-wide v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->brainstormMicCheckEndMs J
    invoke-virtual v14, v1, v2, v3, Landroid/content/Intent;->putExtra(Ljava/lang/String; J)Landroid/content/Intent;
    if-eqz v8, +007h
    const-string v1, "extra_sub_task_cli_id"
    invoke-virtual v14, v1, v8, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v1, "extra_sub_task_cli_type"
    invoke-virtual v9, Lcom/bytedance/trae/im/service/CliType;->name()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v14, v1, v2, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v1, "extra_sub_task_mode"
    invoke-virtual v10, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v14, v1, v2, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v1, "extra_sub_task_parent_agent_type"
    invoke-virtual v14, v1, v12, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    if-eqz v11, +007h
    const-string v1, "extra_sub_task_workspace_dir"
    invoke-virtual v14, v1, v11, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    if-eqz v15, +029h
    sget-object v1, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    if-ne v10, v1, +025h
    if-eqz v21, +023h
    if-eqz v7, +021h
    const-string v1, "extra_source_repo_url"
    move-object/from16 v4, v21
    invoke-virtual v14, v1, v4, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v1, +006h
    invoke-static v13, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->parseGitDisplayName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +007h
    const-string v2, "extra_source_repo_name"
    invoke-virtual v14, v2, v1, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v1, "extra_source_branch_name"
    invoke-virtual v14, v1, v7, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v1, "extra_create_remote_parent_session"
    invoke-virtual v14, v1, v15, Landroid/content/Intent;->putExtra(Ljava/lang/String; Z)Landroid/content/Intent;
    const-string v1, "extra_attachment_sub_task_enabled"
    move/from16 v2, v20
    invoke-virtual v14, v1, v2, Landroid/content/Intent;->putExtra(Ljava/lang/String; Z)Landroid/content/Intent;
    const-string v1, "extra_minimize_disabled"
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->isNewConversation Z
    invoke-virtual v14, v1, v2, Landroid/content/Intent;->putExtra(Ljava/lang/String; Z)Landroid/content/Intent;
    move-object/from16 v1, v19
    invoke-virtual v1, v14, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    const/4 v1, 0
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->voiceDiscussionAttemptTracker Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    return-void 
.end method

.method private final maximizeBrainstorm()void
    .registers 7
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    const-string/jumbo v1, restore_click
    const-string v2, "minimized"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->reportWindowStateClick(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v0, 1
    iput-boolean v0, v6, Lcom/bytedance/trae/conversation/ConversationActivity;->iLaunchedActiveBrainstorm Z
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->getCliConversationId()Ljava/lang/String;
    move-result-object v1
    iget-object v2, v6, Lcom/bytedance/trae/conversation/ConversationActivity;->brainstormResultLauncher Landroidx/activity/result/ActivityResultLauncher;
    new-instance v3, Landroid/content/Intent;
    move-object v4, v6
    check-cast v4, Landroid/content/Context;
    const-class v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    invoke-direct v3, v4, v5, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const-string v4, "extra_restore_from_holder"
    invoke-virtual v3, v4, v0, Landroid/content/Intent;->putExtra(Ljava/lang/String; Z)Landroid/content/Intent;
    move-object v4, v1
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00ah
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    const/4 v0, 0
    if-nez v0, +007h
    const-string v0, "extra_session_id"
    invoke-virtual v3, v0, v1, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v2, v3, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    return-void 
.end method

.method private final observeBrainstormEnded()void
    .registers 8
    # ins_size=1
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeBrainstormEnded$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeBrainstormEnded$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final observeManagedPrompts()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->managedPromptResolutionJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-interface v0, Lkotlinx/coroutines/Job;->isActive()Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    if-eqz v1, +003h
    return-void 
    move-object v0, v3
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    check-cast v0, Lkotlinx/coroutines/CoroutineScope;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/ConversationActivity;->getLifecycle()Landroidx/lifecycle/Lifecycle;
    move-result-object v1
    const-string v2, "<get-lifecycle>(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeManagedPrompts$1;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity$observeManagedPrompts$1;-><init>(Ljava/lang/Object;)V
    check-cast v2, Lkotlin/jvm/functions/Function1;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptLifecycleKt;->launchManagedPromptResolutionWhenResumed(Lkotlinx/coroutines/CoroutineScope; Landroidx/lifecycle/Lifecycle; Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->managedPromptResolutionJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final observeMinimizedVoice()void
    .registers 8
    # ins_size=1
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeMinimizedVoice$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeMinimizedVoice$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final observeStarbucks()void
    .registers 8
    # ins_size=1
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeStarbucks$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/conversation/ConversationActivity$observeStarbucks$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final observeViewModel()void
    .registers 10
    # ins_size=1
    move-object v0, v9
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$1;
    const/4 v8, 0
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$2;
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$2;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$3;
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$3;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4;
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$5;
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$5;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$6;
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$6;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$7;
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$7;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$8;
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$8;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$9;
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$9;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$10;
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$10;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$11;
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$11;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$12;
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$12;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$13;
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$13;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$14;
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$14;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15;
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$15;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$16;
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$16;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$17;
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$17;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$18;
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$18;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$19;
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$19;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$20;
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$20;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$21;
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$21;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-direct v9, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda30;
    invoke-direct v2, v9, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda30;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->setOnPauseClickListener(Lkotlin/jvm/functions/Function0;)V
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23;
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$23;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$24;
    invoke-direct v1, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$24;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$25;
    invoke-direct v0, v9, v8, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$25;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final observeViewModel$lambda$42(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 2
    # ins_size=1
    const/4 v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->wasUserInitiatedCancel Z
    iget-object v1, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v1, +009h
    const-string/jumbo v1, viewModel
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->cancelCurrentTask()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onCreate$lambda$22(com.bytedance.trae.conversation.ConversationActivity  android.view.View)void
    .registers 5
    # ins_size=2
    iget-object v4, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    const-string v0, "binding"
    const/4 v1, 0
    if-nez v4, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v1
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->layoutLoadError Landroid/widget/LinearLayout;
    const/16 v2, 8
    invoke-virtual v4, v2, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v4, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v1
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->detailFragmentContainer Landroidx/fragment/app/FragmentContainerView;
    const/4 v2, 0
    invoke-virtual v4, v2, Landroidx/fragment/app/FragmentContainerView;->setVisibility(I)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v4, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v1
    iget-object v4, v4, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->inputFragmentContainer Landroidx/fragment/app/FragmentContainerView;
    invoke-virtual v4, v2, Landroidx/fragment/app/FragmentContainerView;->setVisibility(I)V
    iget-object v3, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v3, +009h
    const-string/jumbo v3, viewModel
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->retryLoad()V
    return-void 
.end method

.method private static final onCreate$lambda$24(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda42;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda42;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->loadMoreMessages(Lkotlin/jvm/functions/Function0;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final onCreate$lambda$24$lambda$23(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    const-string v0, "ConversationDetailFragment"
    invoke-virtual v1, v0, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v1
    instance-of v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    if-eqz v0, +005h
    check-cast v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    goto +2h
    const/4 v1, 0
    if-eqz v1, +006h
    const/4 v0, 0
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->setLoadingMore(Z)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onCreate$lambda$26(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda60;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda60;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->loadNewerAnchorMessages(Lkotlin/jvm/functions/Function0;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final onCreate$lambda$26$lambda$25(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/conversation/ConversationActivity;->getDetailFragment()Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    move-result-object v1
    if-eqz v1, +006h
    const/4 v0, 0
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->setLoadingNewer(Z)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onCreate$lambda$27(com.bytedance.trae.conversation.ConversationActivity)boolean
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationActivity;->exitAnchorWindowAndShowLatestPage()Z
    move-result v0
    return v0
.end method

.method private static final onCreate$lambda$29(com.bytedance.trae.conversation.ConversationActivity  java.lang.String)kotlin.Unit
    .registers 18
    # ins_size=2
    move-object/from16 v0, v16
    move-object/from16 v8, v17
    const-string v1, "assistantMessageId"
    invoke-static v8, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v1, 1
    const/4 v9, 0
    invoke-static v0, v9, v1, v9, Lcom/bytedance/trae/conversation/ConversationActivity;->resolveCurrentChatMode$default(Lcom/bytedance/trae/conversation/ConversationActivity; Lcom/bytedance/trae/im/service/Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    move-result-object v10
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getSelectedModelForRequest()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v11
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const-string/jumbo v12, viewModel
    if-nez v1, +006h
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v9
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->getMessages()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    move-object v13, v1
    check-cast v13, Ljava/util/List;
    move-object v1, v13
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +014h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -015h
    goto +2h
    move-object v2, v9
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-eqz v2, +007h
    invoke-static v2, Lcom/bytedance/trae/im/service/IMMessageKt;->getTaskId(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v9
    const-string v2, ""
    if-nez v1, +004h
    move-object v14, v2
    goto +2h
    move-object v14, v1
    new-instance v15, Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    const/4 v3, 0
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v1, +006h
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v9
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    if-nez v1, +004h
    move-object v4, v2
    goto +2h
    move-object v4, v1
    if-eqz v11, +008h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    const-string v1, "auto"
    move-object v5, v1
    const/4 v6, 1
    const/4 v7, 0
    move-object v1, v15
    move-object v2, v3
    move-object v3, v4
    move-object/from16 v4, v17
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/tracker/AIEventContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v1, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    invoke-virtual v1, v15, v14, v10, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackRetryClick(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Ljava/lang/String; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    const/4 v1, 0
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->hasReportedStreamShow Z
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v2
    iput-wide v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->streamingStartTimeMs J
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->wasUserInitiatedCancel Z
    iput-object v9, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->streamingMessageId Ljava/lang/String;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->streamingChatModel Ljava/lang/String;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +006h
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v9
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    move-object/from16 v1, v17
    move-object v2, v13
    move-object v3, v11
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->retryMessage$default(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/conversation/network/RemoteModelItem; Z I Ljava/lang/Object;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final onCreate$lambda$30(com.bytedance.trae.conversation.ConversationActivity  java.lang.String)kotlin.Unit
    .registers 6
    # ins_size=2
    const-string v0, "assistantMessageId"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v0
    if-eqz v0, +005h
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    invoke-direct v4, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->getSelectedModelForRequest()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v0
    const/4 v1, 0
    iput-boolean v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->hasReportedStreamShow Z
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v2
    iput-wide v2, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->streamingStartTimeMs J
    iput-boolean v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->wasUserInitiatedCancel Z
    const/4 v1, 0
    iput-object v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->streamingMessageId Ljava/lang/String;
    iput-object v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->streamingChatModel Ljava/lang/String;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const-string/jumbo v3, viewModel
    if-nez v2, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v1
    iget-object v4, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v4, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v4
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->getMessages()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v4
    invoke-interface v4, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/util/List;
    const/4 v1, 1
    invoke-virtual v2, v5, v4, v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->retryMessage(Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/conversation/network/RemoteModelItem; Z)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method

.method private static final onCreate$lambda$31(com.bytedance.trae.conversation.ConversationActivity  java.lang.String  java.lang.String)kotlin.Unit
    .registers 4
    # ins_size=3
    const-string v0, "messageId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, resultType
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->trackFeedback(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onCreate$lambda$32(com.bytedance.trae.conversation.ConversationActivity  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "messageId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->trackCopy(Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onCreate$lambda$33(com.bytedance.trae.conversation.ConversationActivity  java.lang.String  java.lang.String)kotlin.Unit
    .registers 4
    # ins_size=3
    const-string v0, "messageId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "content"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->submitReport(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onCreate$lambda$34(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->hideKeyboard()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final onCreate$lambda$35(com.bytedance.trae.conversation.ConversationActivity  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "conversationId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->dismissUpgradeReminder(Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderUpdateActionSpy;->INSTANCE Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderUpdateActionSpy;
    const/4 v0, 0
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderUpdateActionSpy;->record(Z)Z
    move-result v2
    if-nez v2, +016h
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v2
    if-eqz v2, +009h
    move-object v2, v1
    check-cast v2, Landroid/content/Context;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->openAppInPlayStore(Landroid/content/Context;)V
    goto +6h
    sget-object v1, Lcom/bytedance/trae/update/AppUpdateChecker;->INSTANCE Lcom/bytedance/trae/update/AppUpdateChecker;
    invoke-virtual v1, v0, Lcom/bytedance/trae/update/AppUpdateChecker;->checkUpdate(Z)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final openAppInPlayStore(android.content.Context)void
    .registers 8
    # ins_size=2
    const-string v0, "android.intent.action.VIEW"
    const-string v1, "market://details?id="
    invoke-virtual v7, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    move-result-object v2
    const/high16 v3, 268435456
    new-instance v4, Landroid/content/Intent;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v1
    invoke-direct v4, v0, v1, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    const-string v1, "com.android.vending"
    invoke-virtual v4, v1, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v4, v3, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    invoke-virtual v7, v4, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    goto +1fh
    new-instance v1, Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "https://play.google.com/store/apps/details?id="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v2
    invoke-direct v1, v0, v2, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    invoke-virtual v1, v3, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    invoke-virtual v7, v1, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    return-void 
    :try_start_0xa
.end method

.method private final openFile(java.lang.String  java.lang.String)void
    .registers 24
    # ins_size=3
    move-object/from16 v1, v21
    move-object/from16 v0, v22
    const-string v2, "CheckPointDialog"
    const-string v3, "files"
    const-string v4, "openFile filePath: "
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ", conversation: "
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    iget-object v6, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const-string/jumbo v7, viewModel
    const/4 v8, 0
    if-nez v6, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v8
    invoke-virtual v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v6
    invoke-interface v6, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v5, v2, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v4, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v8
    invoke-virtual v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v4
    invoke-interface v4, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v8
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +011h
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +003h
    goto +3h
    move-object v14, v0
    goto +fh
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    goto -fh
    sget-object v9, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->Companion Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$Companion;
    move-object v10, v1
    check-cast v10, Landroid/content/Context;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v8
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v8
    const-string v3, ""
    if-nez v0, +004h
    move-object v11, v3
    goto +2h
    move-object v11, v0
    const/4 v12, 0
    if-nez v4, +004h
    move-object v13, v3
    goto +2h
    move-object v13, v4
    invoke-static/range v23, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v8
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +005h
    move-object/from16 v16, v3
    goto +3h
    move-object/from16 v16, v8
    const-wide/16 v17, 0
    const/16 v19, 132
    const/16 v20, 0
    move-object/from16 v15, v23
    invoke-static/range v9 ... v20, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$Companion;->start$default(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$Companion; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J I Ljava/lang/Object;)V
    goto +bh
    move-exception v0
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v4, "openFile error"
    check-cast v0, Ljava/lang/Throwable;
    invoke-virtual v3, v2, v4, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0xa
    :try_start_0x23
    :try_start_0xa9
.end method

.method private final performForceLogout()void
    .registers 5
    # ins_size=1
    move-object v0, v4
    check-cast v0, Landroid/content/Context;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->login_error_refresh_token_expired I
    const/4 v2, 1
    invoke-static v0, v1, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    sget-object v0, Lcom/bytedance/trae/im/database/DatabaseManager;->INSTANCE Lcom/bytedance/trae/im/database/DatabaseManager;
    invoke-virtual v0, Lcom/bytedance/trae/im/database/DatabaseManager;->onUserLogout()V
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-nez v0, +003h
    return-void 
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$performForceLogout$1;
    invoke-direct v1, Lcom/bytedance/trae/conversation/ConversationActivity$performForceLogout$1;-><init>()V
    check-cast v1, Lcom/bytedance/trae/login/api/IAccountCallback;
    const-string/jumbo v3, risk_control
    invoke-interface v0, v2, v1, v3, Lcom/bytedance/trae/login/api/ILoginService;->logout(Z Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String;)V
    return-void 
.end method

.method private final prepareNewFeaturePrompt(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 26
    # ins_size=3
    move-object/from16 v0, v24
    move-object/from16 v1, v25
    instance-of v2, v1, Lcom/bytedance/trae/conversation/ConversationActivity$prepareNewFeaturePrompt$1;
    if-eqz v2, +014h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/ConversationActivity$prepareNewFeaturePrompt$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/ConversationActivity$prepareNewFeaturePrompt$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +00ah
    iget v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$prepareNewFeaturePrompt$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$prepareNewFeaturePrompt$1;->label I
    move-object/from16 v3, v23
    goto +8h
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationActivity$prepareNewFeaturePrompt$1;
    move-object/from16 v3, v23
    invoke-direct v2, v3, v1, Lcom/bytedance/trae/conversation/ConversationActivity$prepareNewFeaturePrompt$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$prepareNewFeaturePrompt$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    iget v5, v2, Lcom/bytedance/trae/conversation/ConversationActivity$prepareNewFeaturePrompt$1;->label I
    const/4 v6, 1
    const/4 v7, 0
    if-eqz v5, +01eh
    if-ne v5, v6, +014h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity$prepareNewFeaturePrompt$1;->L$1 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    iget-object v2, v2, Lcom/bytedance/trae/conversation/ConversationActivity$prepareNewFeaturePrompt$1;->L$0 Ljava/lang/Object;
    check-cast v2, Ljava/lang/String;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v22, v1
    move-object v1, v0
    move-object v0, v2
    move-object/from16 v2, v22
    goto +37h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;->INSTANCE Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;
    invoke-static v1, v7, v6, v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;->getConfig$default(Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->getEnable()Z
    move-result v5
    if-eqz v5, +09ah
    invoke-direct/range v23, Lcom/bytedance/trae/conversation/ConversationActivity;->currentLoggedInUserId()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +004h
    goto/16 +08eh
    sget-object v5, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v5
    iput-object v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity$prepareNewFeaturePrompt$1;->L$0 Ljava/lang/Object;
    iput-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$prepareNewFeaturePrompt$1;->L$1 Ljava/lang/Object;
    iput v6, v2, Lcom/bytedance/trae/conversation/ConversationActivity$prepareNewFeaturePrompt$1;->label I
    invoke-virtual v5, v2, Lcom/bytedance/trae/conversation/CliListRepository;->getOnboardingState(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v4, +003h
    return-object v4
    check-cast v2, Lcom/bytedance/trae/conversation/OnboardingStateResult;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/OnboardingStateResult;->getState()Lcom/bytedance/trae/conversation/OnboardingState;
    move-result-object v4
    invoke-virtual v2, Lcom/bytedance/trae/conversation/OnboardingStateResult;->isSuccess()Z
    move-result v2
    if-eqz v2, +06fh
    if-nez v4, +003h
    goto +6bh
    sget-object v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;
    sget-object v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->INSTANCE Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->snapshot(Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;)Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;
    move-result-object v9
    const/4 v10, 0
    sget-object v0, Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;->INSTANCE Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;->eligibleNewFeaturePromptProducts()Ljava/util/Set;
    move-result-object v11
    invoke-static Lkotlin/collections/SetsKt;->createSetBuilder()Ljava/util/Set;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/OnboardingState;->getHasRegisteredWork()Z
    move-result v2
    if-eqz v2, +007h
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-interface v0, v2, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    invoke-virtual v4, Lcom/bytedance/trae/conversation/OnboardingState;->getHasRegisteredIDE()Z
    move-result v2
    if-eqz v2, +007h
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->IDE Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-interface v0, v2, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/collections/SetsKt;->build(Ljava/util/Set;)Ljava/util/Set;
    move-result-object v12
    const/4 v13, 0
    const/4 v14, 0
    const-wide/16 v15, 0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/OnboardingState;->getHasConversation()Z
    move-result v17
    const-wide/16 v18, 0
    const/16 v20, 185
    const/16 v21, 0
    invoke-static/range v9 ... v21, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->copy$default(Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState; Ljava/util/Set; Ljava/util/Set; Ljava/util/Set; Ljava/util/Set; Ljava/util/Map; J Z J I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;
    move-result-object v9
    const-wide/16 v11, 0
    const/4 v13, 4
    move-object v10, v1
    invoke-static/range v8 ... v14, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;->choosePrompt$default(Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy; Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState; Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig; J I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptDecision;
    move-result-object v0
    if-nez v0, +003h
    return-object v7
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;
    sget-object v5, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptDecision;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v6
    invoke-virtual v5, v6, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;->managedCandidate$conversation_mainlandRelease(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    move-result-object v9
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptDecision;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v10
    invoke-virtual v4, Lcom/bytedance/trae/conversation/OnboardingState;->getHasRegisteredWork()Z
    move-result v11
    invoke-virtual v4, Lcom/bytedance/trae/conversation/OnboardingState;->getHasRegisteredIDE()Z
    move-result v12
    move-object v8, v2
    move-object v13, v1
    invoke-direct/range v8 ... v13, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;-><init>(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z Z Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;)V
    return-object v2
    return-object v7
.end method

.method private static final previewWebViewLauncher$lambda$7(com.bytedance.trae.conversation.ConversationActivity  androidx.activity.result.ActivityResult)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, result
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroidx/activity/result/ActivityResult;->getResultCode()I
    move-result v0
    const/4 v1, -1
    if-ne v0, v1, +009h
    invoke-virtual v3, Landroidx/activity/result/ActivityResult;->getData()Landroid/content/Intent;
    move-result-object v3
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->handleStartServerIntent(Landroid/content/Intent;)V
    return-void 
.end method

.method private final recordNewFeaturePromptShown(java.lang.String  com.bytedance.trae.conversation.ConversationActivity$PreparedNewFeaturePrompt)void
    .registers 12
    # ins_size=3
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v9
    check-cast v0, Lcom/bytedance/trae/conversation/ConversationActivity;
    sget-object v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->INSTANCE Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v3
    invoke-virtual v11, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->getConfig()Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    move-result-object v4
    const-wide/16 v5, 0
    const/16 v7, 8
    const/4 v8, 0
    move-object v2, v10
    invoke-static/range v1 ... v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->markShown$default(Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig; J I Ljava/lang/Object;)V
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v10, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    goto +ch
    move-exception v10
    sget-object v11, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v10, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v10
    invoke-static v10, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    invoke-static v10, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v10
    if-eqz v10, +00bh
    sget-object v11, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v0, "ConversationActivity"
    const-string v1, "persist new feature prompt state failed"
    invoke-virtual v11, v0, v1, v10, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x0
.end method

.method private final registerCheckpointKeyboardListener()void
    .registers 3
    # ins_size=1
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->isCheckpointKeyboardListenerRegistered Z
    if-eqz v0, +003h
    return-void 
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v0, +008h
    const-string v0, "binding"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    move-result-object v0
    invoke-virtual v0, Landroidx/constraintlayout/widget/ConstraintLayout;->getViewTreeObserver()Landroid/view/ViewTreeObserver;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->checkpointKeyboardLayoutListener Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;
    invoke-virtual v0, v1, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    const/4 v0, 1
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->isCheckpointKeyboardListenerRegistered Z
    return-void 
.end method

.method private static final remoteDeleteMessagePushListener$lambda$9(com.bytedance.trae.conversation.ConversationActivity  com.bytedance.trae.im.service.IMService$DeleteMessagePushPayload)void
    .registers 3
    # ins_size=2
    const-string v0, "payload"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda0;
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/im/service/IMService$DeleteMessagePushPayload; Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    return-void 
.end method

.method private static final remoteDeleteMessagePushListener$lambda$9$lambda$8(com.bytedance.trae.im.service.IMService$DeleteMessagePushPayload  com.bytedance.trae.conversation.ConversationActivity)void
    .registers 6
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/trae/im/service/IMService$DeleteMessagePushPayload;->getConversationId()Ljava/lang/String;
    move-result-object v0
    iget-object v1, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v2, 0
    const-string/jumbo v3, viewModel
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +017h
    iget-object v5, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v5, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v5
    invoke-virtual v4, Lcom/bytedance/trae/im/service/IMService$DeleteMessagePushPayload;->getConversationId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, Lcom/bytedance/trae/im/service/IMService$DeleteMessagePushPayload;->getMessageIds()Ljava/util/List;
    move-result-object v4
    invoke-virtual v2, v5, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->deleteCachedMessages(Ljava/lang/String; Ljava/util/List;)V
    return-void 
    iget-object v5, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v5, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v5
    invoke-virtual v4, Lcom/bytedance/trae/im/service/IMService$DeleteMessagePushPayload;->getConversationId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, Lcom/bytedance/trae/im/service/IMService$DeleteMessagePushPayload;->getMessageIds()Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/util/Collection;
    invoke-virtual v2, v5, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->deleteMessagesAndReplies(Ljava/lang/String; Ljava/util/Collection;)V
    return-void 
.end method

.method private final requestBrainstormPermissions()void
    .registers 6
    # ins_size=1
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    iput-wide v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->brainstormMicCheckStartMs J
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper;
    move-object v1, v5
    check-cast v1, Landroid/content/Context;
    iget-object v2, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->brainstormPermissionLauncher Landroidx/activity/result/ActivityResultLauncher;
    new-instance v3, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda28;
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda28;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    new-instance v4, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda29;
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda29;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper;->requestPermissions(Landroid/content/Context; Landroidx/activity/result/ActivityResultLauncher; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private static final requestBrainstormPermissions$lambda$104(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 3
    # ins_size=1
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    iput-wide v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->brainstormMicCheckEndMs J
    invoke-direct v2, Lcom/bytedance/trae/conversation/ConversationActivity;->launchBrainstormActivity()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final requestBrainstormPermissions$lambda$105(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 3
    # ins_size=1
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    iput-wide v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->brainstormMicCheckEndMs J
    iget-object v2, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->voiceDiscussionAttemptTracker Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    if-eqz v2, +009h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;->PERMISSION_DENIED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome;
    const-string v1, "permission_rationale_denied"
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->finish(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptOutcome; Ljava/lang/String;)Z
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private final requestNotificationPermissionIfNeeded()void
    .registers 5
    # ins_size=1
    iget-boolean v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->notificationPermissionRequested Z
    if-eqz v0, +003h
    return-void 
    const/4 v0, 1
    iput-boolean v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->notificationPermissionRequested Z
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v0, +008h
    const-string v0, "binding"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda44;
    invoke-direct v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda44;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    const-wide/16 v2, 2000
    invoke-virtual v0, v1, v2, v3, Landroidx/constraintlayout/widget/ConstraintLayout;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method private static final requestNotificationPermissionIfNeeded$lambda$36(com.bytedance.trae.conversation.ConversationActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationActivity;->isFinishing()Z
    move-result v0
    if-nez v0, +00dh
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationActivity;->isDestroyed()Z
    move-result v1
    if-nez v1, +007h
    sget-object v1, Lcom/bytedance/trae/push/api/IPushService;->Companion Lcom/bytedance/trae/push/api/IPushService$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/push/api/IPushService$Companion;->requestNotificationPermission()V
    return-void 
.end method

.method private final resolveCurrentChatMode(com.bytedance.trae.im.service.Mode)com.bytedance.trae.conversation.tracker.SoloChatMode
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +01ch
    const-string/jumbo v3, work
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->WORK Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    goto +eh
    const-string v3, "code"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->CODE Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    goto +3h
    sget-object v3, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->DEFAULT Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    return-object v3
    if-nez v3, +004h
    const/4 v3, -1
    goto +9h
    sget-object v0, Lcom/bytedance/trae/conversation/ConversationActivity$WhenMappings;->$EnumSwitchMapping$2 [I
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Mode;->ordinal()I
    move-result v3
    aget v3, v0, v3
    const/4 v0, 1
    if-eq v3, v0, +00bh
    const/4 v0, 2
    if-eq v3, v0, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->DEFAULT Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    goto +6h
    sget-object v3, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->CODE Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    goto +3h
    sget-object v3, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->WORK Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    return-object v3
.end method

.method static synthetic resolveCurrentChatMode$default(com.bytedance.trae.conversation.ConversationActivity  com.bytedance.trae.im.service.Mode  int  java.lang.Object)com.bytedance.trae.conversation.tracker.SoloChatMode
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->resolveCurrentChatMode(Lcom/bytedance/trae/im/service/Mode;)Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    move-result-object v0
    return-object v0
.end method

.method private final resolveManagedPromptsWhileResumed(kotlin.coroutines.Continuation)java.lang.Object
    .registers 25
    # ins_size=2
    move-object/from16 v0, v24
    instance-of v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;
    if-eqz v1, +014h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;
    iget v2, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +00ah
    iget v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->label I
    move-object/from16 v2, v23
    goto +8h
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;
    move-object/from16 v2, v23
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->label I
    const/4 v5, 2
    const/4 v6, 3
    const/4 v7, 1
    const-wide/16 v8, 500
    packed-switch v4, +0000370h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$2 Ljava/lang/Object;
    check-cast v4, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$1 Ljava/lang/Object;
    check-cast v11, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$0 Ljava/lang/Object;
    check-cast v12, Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v13, v4
    move v4, v6
    goto/16 +33dh
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$5 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$4 Ljava/lang/Object;
    check-cast v11, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$3 Ljava/lang/Object;
    check-cast v12, Ljava/lang/String;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$2 Ljava/lang/Object;
    check-cast v13, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v14, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$1 Ljava/lang/Object;
    check-cast v14, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v15, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$0 Ljava/lang/Object;
    check-cast v15, Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +29bh
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$2 Ljava/lang/Object;
    check-cast v4, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$1 Ljava/lang/Object;
    check-cast v11, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$0 Ljava/lang/Object;
    check-cast v12, Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v13, v4
    move v4, v6
    const/4 v0, 0
    goto/16 +30ch
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$4 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$3 Ljava/lang/Object;
    check-cast v11, Ljava/lang/String;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$2 Ljava/lang/Object;
    check-cast v12, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$1 Ljava/lang/Object;
    check-cast v13, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v14, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$0 Ljava/lang/Object;
    check-cast v14, Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +1b5h
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$2 Ljava/lang/Object;
    check-cast v4, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$1 Ljava/lang/Object;
    check-cast v11, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$0 Ljava/lang/Object;
    check-cast v12, Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +112h
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$2 Ljava/lang/Object;
    check-cast v4, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$1 Ljava/lang/Object;
    check-cast v11, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$0 Ljava/lang/Object;
    check-cast v12, Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v13, v11
    move-object v14, v12
    move-object v12, v4
    goto/16 +07fh
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$2 Ljava/lang/Object;
    check-cast v4, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$1 Ljava/lang/Object;
    check-cast v11, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$0 Ljava/lang/Object;
    check-cast v12, Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +10h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v0, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v0, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    new-instance v4, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v4, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    move-object v11, v0
    move-object v12, v2
    invoke-interface v1, Lkotlin/coroutines/Continuation;->getContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/JobKt;->isActive(Lkotlin/coroutines/CoroutineContext;)Z
    move-result v0
    if-eqz v0, +2b8h
    invoke-direct v12, Lcom/bytedance/trae/conversation/ConversationActivity;->currentLoggedInUserId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +005h
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    sget-object v13, Lcom/bytedance/trae/conversation/prompt/ManagedPromptArbitrationPolicy;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptArbitrationPolicy;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v14
    sget-object v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;
    invoke-virtual v10, v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->snapshot(Ljava/lang/String;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    move-result-object v16
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Preparing;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Preparing;
    move-object/from16 v17, v0
    check-cast v17, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Preparing;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Preparing;
    move-object/from16 v18, v0
    check-cast v18, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
    invoke-virtual/range v13 ... v18, Lcom/bytedance/trae/conversation/prompt/ManagedPromptArbitrationPolicy;->decide(J Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState; Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState; Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision;
    move-result-object v0
    instance-of v0, v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$CoolingDown;
    if-eqz v0, +005h
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    invoke-direct v12, Lcom/bytedance/trae/conversation/ConversationActivity;->shouldDelayManagedPromptsForPendingConnect()Z
    move-result v0
    if-eqz v0, +011h
    iput-object v12, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$0 Ljava/lang/Object;
    iput-object v11, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$1 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$2 Ljava/lang/Object;
    iput v7, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->label I
    invoke-static v8, v9, v1, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, -048h
    return-object v3
    sget-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;
    iput-object v12, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$0 Ljava/lang/Object;
    iput-object v11, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$1 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$2 Ljava/lang/Object;
    iput v5, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->label I
    const-wide/16 v13, 30000
    invoke-virtual v0, v13, v14, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->awaitReady(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, -07fh
    return-object v3
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    if-nez v0, +015h
    iput-object v14, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$0 Ljava/lang/Object;
    iput-object v13, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$1 Ljava/lang/Object;
    iput-object v12, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$2 Ljava/lang/Object;
    iput v6, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->label I
    invoke-static v8, v9, v1, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    move-object v4, v12
    move-object v11, v13
    move-object v12, v14
    goto -78h
    invoke-direct v14, Lcom/bytedance/trae/conversation/ConversationActivity;->currentLoggedInUserId()Ljava/lang/String;
    move-result-object v11
    if-nez v11, +005h
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    sget-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->candidateSnapshot$conversation_mainlandRelease()Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;
    move-result-object v0
    iget-boolean v4, v14, Lcom/bytedance/trae/conversation/ConversationActivity;->isNewConversation Z
    if-eqz v4, +012h
    iget-boolean v4, v14, Lcom/bytedance/trae/conversation/ConversationActivity;->suppressNaturalGuideForPendingConnect Z
    if-nez v4, +00eh
    sget-object v4, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptEntryPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptEntryPolicy;
    sget-object v10, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptEntry;->NEW_CHAT Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptEntry;
    invoke-virtual v4, v10, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptEntryPolicy;->canRequestNaturalPrompt(Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptEntry;)Z
    move-result v4
    if-eqz v4, +004h
    move v4, v7
    goto +2h
    const/4 v4, 0
    sget-object v15, Lcom/bytedance/trae/conversation/prompt/ManagedPromptArbitrationPolicy;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptArbitrationPolicy;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v16
    sget-object v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;
    invoke-virtual v10, v11, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->snapshot(Ljava/lang/String;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    move-result-object v18
    invoke-virtual v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;->getState()Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
    move-result-object v19
    if-eqz v4, +007h
    sget-object v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Preparing;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Preparing;
    check-cast v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
    goto +5h
    sget-object v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Ineligible;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Ineligible;
    check-cast v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
    move-object/from16 v20, v10
    invoke-virtual/range v15 ... v20, Lcom/bytedance/trae/conversation/prompt/ManagedPromptArbitrationPolicy;->decide(J Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState; Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState; Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision;
    move-result-object v10
    invoke-virtual v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;->getState()Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
    move-result-object v15
    sget-object v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$WaitForBilling;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$WaitForBilling;
    invoke-static v10, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +018h
    iput-object v14, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$0 Ljava/lang/Object;
    iput-object v13, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$1 Ljava/lang/Object;
    iput-object v12, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$2 Ljava/lang/Object;
    const/4 v0, 4
    iput v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->label I
    invoke-static v8, v9, v1, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    move-object v4, v12
    move-object v11, v13
    move-object v12, v14
    const/4 v6, 3
    goto/16 -0deh
    instance-of v6, v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$CoolingDown;
    if-nez v6, +1dbh
    sget-object v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$NothingToShow;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$NothingToShow;
    invoke-static v10, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +004h
    goto/16 +1d1h
    instance-of v6, v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$Show;
    if-eqz v6, +04eh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator$CandidateSnapshot;->getPromptData()Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    move-result-object v0
    if-nez v0, +005h
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->NotShown Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    goto +ah
    sget-object v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;
    move-object v15, v14
    check-cast v15, Landroidx/fragment/app/FragmentActivity;
    invoke-virtual v6, v15, v11, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->showCandidate$conversation_mainlandRelease(Landroidx/fragment/app/FragmentActivity; Ljava/lang/String; Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    move-result-object v0
    sget-object v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptAttemptPolicy;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptAttemptPolicy;
    check-cast v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$Show;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$Show;->getCandidate()Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    move-result-object v10
    invoke-virtual v6, v10, v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptAttemptPolicy;->afterAttempt(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate; Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptRoundAction;
    move-result-object v0
    sget-object v6, Lcom/bytedance/trae/conversation/ConversationActivity$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptRoundAction;->ordinal()I
    move-result v0
    aget v0, v6, v0
    if-eq v0, v7, +023h
    if-eq v0, v5, +011h
    const/4 v6, 3
    if-ne v0, v6, +008h
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Ineligible;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Ineligible;
    check-cast v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
    move-object v15, v0
    goto +22h
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    iput-object v14, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$0 Ljava/lang/Object;
    iput-object v13, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$1 Ljava/lang/Object;
    iput-object v12, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$2 Ljava/lang/Object;
    const/4 v0, 5
    iput v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->label I
    invoke-static v8, v9, v1, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, -05eh
    return-object v3
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$WaitForGuide;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$WaitForGuide;
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +173h
    if-eqz v4, +16eh
    invoke-direct v14, Lcom/bytedance/trae/conversation/ConversationActivity;->currentLoggedInUserId()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v11, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +162h
    iget-object v0, v13, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;
    if-nez v0, +029h
    iput-object v14, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$0 Ljava/lang/Object;
    iput-object v13, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$1 Ljava/lang/Object;
    iput-object v12, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$2 Ljava/lang/Object;
    iput-object v11, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$3 Ljava/lang/Object;
    iput-object v15, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$4 Ljava/lang/Object;
    const/4 v0, 6
    iput v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->label I
    invoke-direct v14, v11, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->prepareNewFeaturePrompt(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    move-object v4, v15
    check-cast v0, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;
    if-eqz v0, +008h
    iput-object v0, v13, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    move-object/from16 v21, v4
    move-object v15, v14
    goto +5h
    move-object/from16 v21, v4
    move-object v15, v14
    const/4 v0, 0
    move-object v14, v13
    move-object v13, v12
    move-object v12, v11
    goto +4h
    move-object/from16 v21, v15
    goto -ch
    if-eqz v0, +00eh
    new-instance v4, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Eligible;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->getCandidate()Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    move-result-object v6
    invoke-direct v4, v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Eligible;-><init>(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;)V
    check-cast v4, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
    goto +5h
    sget-object v4, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Ineligible;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState$Ineligible;
    check-cast v4, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;
    move-object/from16 v22, v4
    sget-object v17, Lcom/bytedance/trae/conversation/prompt/ManagedPromptArbitrationPolicy;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptArbitrationPolicy;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v18
    sget-object v4, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;
    invoke-virtual v4, v12, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->snapshot(Ljava/lang/String;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    move-result-object v20
    invoke-virtual/range v17 ... v22, Lcom/bytedance/trae/conversation/prompt/ManagedPromptArbitrationPolicy;->decide(J Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState; Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState; Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidateState;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision;
    move-result-object v11
    instance-of v4, v11, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$CoolingDown;
    if-nez v4, +107h
    sget-object v4, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$NothingToShow;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$NothingToShow;
    invoke-static v11, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +004h
    goto/16 +0fdh
    sget-object v4, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$WaitForBilling;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$WaitForBilling;
    invoke-static v11, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +0d9h
    sget-object v4, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$WaitForGuide;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$WaitForGuide;
    invoke-static v11, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +004h
    goto/16 +0cfh
    instance-of v4, v11, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$Show;
    if-eqz v4, +0c5h
    if-eqz v0, +0c0h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->getCandidate()Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    move-result-object v4
    move-object v6, v11
    check-cast v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$Show;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$Show;->getCandidate()Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    move-result-object v6
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +004h
    move-object v4, v0
    goto +2h
    const/4 v4, 0
    if-eqz v4, +0aah
    invoke-direct v15, Lcom/bytedance/trae/conversation/ConversationActivity;->isManagedPromptHostReady()Z
    move-result v0
    if-nez v0, +01dh
    iput-object v15, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$0 Ljava/lang/Object;
    iput-object v14, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$1 Ljava/lang/Object;
    iput-object v13, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$2 Ljava/lang/Object;
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$3 Ljava/lang/Object;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$4 Ljava/lang/Object;
    const/16 v0, 8
    iput v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->label I
    invoke-static v8, v9, v1, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    move-object v4, v13
    move-object v11, v14
    move-object v12, v15
    goto/16 -126h
    iget-object v0, v13, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v0, Ljava/util/List;
    if-nez v0, +03dh
    sget-object v0, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v0
    iput-object v15, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$0 Ljava/lang/Object;
    iput-object v14, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$1 Ljava/lang/Object;
    iput-object v13, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$2 Ljava/lang/Object;
    iput-object v12, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$3 Ljava/lang/Object;
    iput-object v11, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$4 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$5 Ljava/lang/Object;
    const/16 v6, 9
    iput v6, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->label I
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/CliListRepository;->refreshDiscoverableDevices(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    move-object v6, v0
    check-cast v6, Lcom/bytedance/trae/conversation/DeviceDiscoveryRefreshResult;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/DeviceDiscoveryRefreshResult;->isSuccess()Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    const/4 v0, 0
    check-cast v0, Lcom/bytedance/trae/conversation/DeviceDiscoveryRefreshResult;
    if-eqz v0, +00bh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/DeviceDiscoveryRefreshResult;->getDevices()Ljava/util/List;
    move-result-object v0
    if-eqz v0, +005h
    iput-object v0, v13, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    goto +2h
    const/4 v0, 0
    if-nez v0, +005h
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    move-object v6, v12
    move-object v12, v15
    invoke-direct v12, v4, v0, v6, Lcom/bytedance/trae/conversation/ConversationActivity;->showNewFeaturePrompt(Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt; Ljava/util/List; Ljava/lang/String;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    move-result-object v0
    sget-object v4, Lcom/bytedance/trae/conversation/prompt/ManagedPromptAttemptPolicy;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptAttemptPolicy;
    check-cast v11, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$Show;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDecision$Show;->getCandidate()Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    move-result-object v6
    invoke-virtual v4, v6, v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptAttemptPolicy;->afterAttempt(Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate; Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptRoundAction;
    move-result-object v0
    sget-object v4, Lcom/bytedance/trae/conversation/ConversationActivity$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptRoundAction;->ordinal()I
    move-result v0
    aget v0, v4, v0
    if-eq v0, v7, +029h
    if-eq v0, v5, +00ch
    const/4 v4, 3
    if-ne v0, v4, +003h
    goto +22h
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    const/4 v4, 3
    iput-object v12, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$0 Ljava/lang/Object;
    iput-object v14, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$1 Ljava/lang/Object;
    iput-object v13, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$2 Ljava/lang/Object;
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$3 Ljava/lang/Object;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$4 Ljava/lang/Object;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$5 Ljava/lang/Object;
    const/16 v0, 10
    iput v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->label I
    invoke-static v8, v9, v1, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    move-object v11, v14
    goto +25h
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    const/4 v4, 3
    iput-object v15, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$0 Ljava/lang/Object;
    iput-object v14, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$1 Ljava/lang/Object;
    iput-object v13, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$2 Ljava/lang/Object;
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$3 Ljava/lang/Object;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->L$4 Ljava/lang/Object;
    const/4 v6, 7
    iput v6, v1, Lcom/bytedance/trae/conversation/ConversationActivity$resolveManagedPromptsWhileResumed$1;->label I
    invoke-static v8, v9, v1, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v3, +003h
    return-object v3
    move-object v11, v14
    move-object v12, v15
    move v6, v4
    move-object v4, v13
    goto/16 -2afh
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    nop 
    packed-switch-payload 0 1 2 3 4 5 6 7 8 9 a
.end method

.method private final resolveTaskModeForCurrentConversation()com.bytedance.trae.im.service.Mode
    .registers 6
    # ins_size=1
    iget-boolean v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->isNewConversation Z
    const/4 v1, 0
    if-eqz v0, +01bh
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v0, +008h
    const-string v0, "binding"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getSegmentedSelectedIndex()I
    move-result v0
    if-nez v0, +005h
    sget-object v0, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    goto +3h
    sget-object v0, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    return-object v0
    invoke-static Lcom/bytedance/trae/im/service/Mode;->getEntries()Lkotlin/enums/EnumEntries;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +031h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v3
    iget-object v4, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v4, +009h
    const-string/jumbo v4, viewModel
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v1
    invoke-virtual v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v4
    invoke-interface v4, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v1
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -032h
    move-object v1, v2
    check-cast v1, Lcom/bytedance/trae/im/service/Mode;
    if-nez v1, +004h
    sget-object v1, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    return-object v1
.end method

.method private final sendQuery(java.lang.String  java.lang.String  java.util.List)void
    .registers 13
    # ins_size=4
    iget-boolean v0, v9, Lcom/bytedance/trae/conversation/ConversationActivity;->isNewConversation Z
    const-string/jumbo v1, viewModel
    const/4 v2, 0
    if-eqz v0, +02fh
    iget-object v0, v9, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v0, +008h
    const-string v0, "binding"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getSegmentedSelectedIndex()I
    move-result v0
    if-nez v0, +005h
    sget-object v0, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    goto +3h
    sget-object v0, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    sget-object v3, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->INSTANCE Lcom/bytedance/trae/conversation/AccountSettingsKeva;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    if-ne v0, v4, +005h
    const-string v4, "code"
    goto +4h
    const-string/jumbo v4, work
    const-string v5, "last_selected_chat_mode"
    invoke-virtual v3, v5, v4, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    goto +45h
    invoke-static Lcom/bytedance/trae/im/service/Mode;->getEntries()Lkotlin/enums/EnumEntries;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +02eh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v4
    iget-object v5, v9, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v5, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v5
    invoke-interface v5, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v2
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -02fh
    goto +2h
    move-object v3, v2
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/im/service/Mode;
    if-nez v0, +004h
    sget-object v0, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    move-object v5, v0
    iget-object v0, v9, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    if-nez v0, +071h
    sget-object v0, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    if-ne v5, v0, +06dh
    iget-object v0, v9, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getSelectedDevice()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    goto +2h
    move-object v0, v2
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-eq v0, v3, +04fh
    iget-object v0, v9, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getSelectedDevice()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v2
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-eq v2, v0, +033h
    invoke-direct v9, Lcom/bytedance/trae/conversation/ConversationActivity;->getGitSelectionViewModel()Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getSelectedRepo()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    if-eqz v0, +025h
    invoke-direct v9, Lcom/bytedance/trae/conversation/ConversationActivity;->getGitSelectionViewModel()Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getSelectedBranch()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    if-nez v0, +017h
    move-object v10, v9
    check-cast v10, Landroid/content/Context;
    sget v11, Lcom/bytedance/trae/multilanguage/R$string;->trae_git_please_select_branch I
    const/4 v12, 0
    invoke-static v10, v11, v12, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v10
    invoke-virtual v10, Landroid/widget/Toast;->show()V
    invoke-direct v9, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v10
    invoke-virtual v10, v12, Lcom/bytedance/trae/conversation/widget/InputFragment;->setSendingState(Z)V
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper;->INSTANCE Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper;
    move-object v1, v9
    check-cast v1, Landroidx/activity/ComponentActivity;
    new-instance v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda47;
    move-object v3, v2
    move-object v4, v9
    move-object v6, v12
    move-object v7, v11
    move-object v8, v10
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda47;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lcom/bytedance/trae/im/service/Mode; Ljava/util/List; Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper;->showIfNeeded(Landroidx/activity/ComponentActivity; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method static synthetic sendQuery$default(com.bytedance.trae.conversation.ConversationActivity  java.lang.String  java.lang.String  java.util.List  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v3
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->sendQuery(Ljava/lang/String; Ljava/lang/String; Ljava/util/List;)V
    return-void 
.end method

.method private static final sendQuery$lambda$63(com.bytedance.trae.conversation.ConversationActivity  com.bytedance.trae.im.service.Mode  java.util.List  java.lang.String  java.lang.String)kotlin.Unit
    .registers 21
    # ins_size=5
    move-object/from16 v0, v16
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const-string/jumbo v2, viewModel
    const/4 v3, 0
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/ConversationActivity;->getGitSelectionViewModel()Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getSelectedRepo()Landroidx/lifecycle/LiveData;
    move-result-object v4
    invoke-virtual v4, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getRepoUrl()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v3
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->setSelectedRepoUrl(Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/ConversationActivity;->getGitSelectionViewModel()Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getSelectedRepo()Landroidx/lifecycle/LiveData;
    move-result-object v4
    invoke-virtual v4, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->setSelectedRepo(Lcom/bytedance/trae/conversation/git/GitRepoItem;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    iget-object v4, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v4, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v3
    iget-object v5, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v5, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v3
    invoke-virtual v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->getSelectedRepoUrl()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->parseGitDisplayName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->setSelectedRepoName(Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/ConversationActivity;->getGitSelectionViewModel()Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getSelectedBranch()Landroidx/lifecycle/LiveData;
    move-result-object v4
    invoke-virtual v4, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/git/BranchItem;
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/git/BranchItem;->getName()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v3
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel;->setSelectedBranchName(Ljava/lang/String;)V
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getSelectedModelForRequest()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v8
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v3
    invoke-interface/range v18, Ljava/util/List;->size()I
    move-result v4
    move-object/from16 v7, v17
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->buildSendMessageContext(Lcom/bytedance/trae/im/service/Mode; I)Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    move-result-object v4
    iput-object v4, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->lastSendContext Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    const/4 v5, 0
    iput-boolean v5, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->hasReportedStreamShow Z
    iput-boolean v5, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->wasUserInitiatedCancel Z
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v5
    iput-wide v5, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->streamingStartTimeMs J
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->streamingMessageId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->streamingChatModel Ljava/lang/String;
    invoke-direct/range v16 ... v17, Lcom/bytedance/trae/conversation/ConversationActivity;->resolveCurrentChatMode(Lcom/bytedance/trae/im/service/Mode;)Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    move-result-object v5
    new-instance v6, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;
    new-instance v15, Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    const/4 v10, 0
    iget-object v9, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v9, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v3
    invoke-virtual v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v9
    invoke-interface v9, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Ljava/lang/String;
    if-nez v9, +004h
    const-string v9, ""
    move-object v11, v9
    const/4 v12, 0
    if-nez v1, +004h
    const-string v1, "auto"
    move-object v13, v1
    const/4 v14, 5
    const/4 v1, 0
    move-object v9, v15
    move-object v3, v15
    move-object v15, v1
    invoke-direct/range v9 ... v15, Lcom/bytedance/trae/conversation/tracker/AIEventContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v6, v3, v4, v5, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;-><init>(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Lcom/bytedance/trae/conversation/tracker/AISendMessageContext; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    iput-object v6, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->pendingTriggerTracker Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;
    move-object/from16 v1, v18
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +018h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/widget/PluginTagItem;
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/PluginTagItem;->getId()Ljava/lang/String;
    move-result-object v3
    const-string v6, "plugin"
    invoke-virtual v5, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->getValue()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v4, v3, v6, v9, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackPluginInclude(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    goto -1bh
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +007h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v4, 0
    goto +2h
    move-object v4, v0
    const/4 v9, 0
    const/16 v10, 16
    const/4 v11, 0
    move-object/from16 v5, v19
    move-object/from16 v6, v20
    move-object/from16 v7, v17
    invoke-static/range v4 ... v11, Lcom/bytedance/trae/conversation/ConversationViewModel;->sendMessage$default(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/Mode; Lcom/bytedance/trae/conversation/network/RemoteModelItem; Z I Ljava/lang/Object;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final setTitleBarInteraction(boolean)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    const/4 v1, 0
    const-string v2, "binding"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    invoke-virtual v0, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setInteractionEnabled(Z)V
    if-eqz v4, +005h
    const/high16 v4, 1065353216
    goto +3h
    const/high16 v4, 1056964608
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    invoke-virtual v0, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setAlpha(F)V
    return-void 
.end method

.method private final shouldDelayManagedPromptsForPendingConnect()boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->pendingConnectDeviceType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    if-nez v0, +009h
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->pendingConnectDeviceFlowActive Z
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    return v0
.end method

.method private final showCliSelectionDialog()void
    .registers 15
    # ins_size=1
    iget-object v0, v14, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const-string/jumbo v1, viewModel
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getCurrentMode()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/widget/ChatMode;
    iget-object v3, v14, Lcom/bytedance/trae/conversation/ConversationActivity;->selectedDeviceByMode Ljava/util/Map;
    invoke-interface v3, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v3, +00bh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getId()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    goto +3h
    move-object v2, v3
    goto +19h
    iget-object v3, v14, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v2
    invoke-virtual v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->getSelectedDevice()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    if-eqz v1, +006h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getId()Ljava/lang/String;
    move-result-object v2
    sget-object v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->Companion Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$Companion;
    new-instance v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
    new-instance v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;
    sget-object v5, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v0, v5, +004h
    const/4 v5, 1
    goto +2h
    const/4 v5, 0
    invoke-direct v4, v0, v2, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;-><init>(Lcom/bytedance/trae/conversation/widget/ChatMode; Ljava/lang/String; Z)V
    check-cast v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    new-instance v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    new-instance v6, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda25;
    invoke-direct v6, v14, v0, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda25;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lcom/bytedance/trae/conversation/widget/ChatMode;)V
    new-instance v7, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda26;
    invoke-direct v7, v0, v14, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda26;-><init>(Lcom/bytedance/trae/conversation/widget/ChatMode; Lcom/bytedance/trae/conversation/ConversationActivity;)V
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 60
    const/4 v13, 0
    move-object v5, v2
    invoke-direct/range v5 ... v13, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v3, v4, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;-><init>(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute; Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;)V
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$Companion;->newInstance(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    move-result-object v0
    invoke-virtual v14, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    const-string v2, "DeviceFlowContainerBottomSheet"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    return-void 
.end method

.method private static final showCliSelectionDialog$lambda$79(com.bytedance.trae.conversation.ConversationActivity  com.bytedance.trae.conversation.widget.ChatMode  com.bytedance.trae.conversation.devices.SelectedDeviceItem)kotlin.Unit
    .registers 4
    # ins_size=3
    const-string v0, "device"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->selectedDeviceByMode Ljava/util/Map;
    invoke-interface v0, v2, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->setSelectedDevice(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)V
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v2, v0, +00dh
    invoke-direct v1, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getShowProductType()Z
    move-result v0
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->setMultipleProducts(Z)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/ConversationActivity;->getInputFragment()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v1
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->setSelectedDevice(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final showCliSelectionDialog$lambda$80(com.bytedance.trae.conversation.widget.ChatMode  com.bytedance.trae.conversation.ConversationActivity  java.util.List)kotlin.Unit
    .registers 6
    # ins_size=3
    const-string v0, "devices"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    const/4 v1, 0
    const-string/jumbo v2, viewModel
    if-ne v3, v0, +00fh
    iget-object v3, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v3, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    invoke-virtual v1, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->syncCodeSelectedDeviceWithItems(Ljava/util/List;)V
    goto +dh
    iget-object v3, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v3, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    invoke-virtual v1, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->syncSelectedDeviceWithItems(Ljava/util/List;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private final showDeleteDialog()void
    .registers 23
    # ins_size=1
    move-object/from16 v0, v22
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v1, +009h
    const-string/jumbo v1, viewModel
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    if-nez v1, +003h
    return-void 
    sget-object v2, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->Companion Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;
    move-object v3, v0
    check-cast v3, Landroid/content/Context;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_dialog_delete_title I
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v1
    move-object v4, v1
    const-string v8, "getString(...)"
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_dialog_delete_message I
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v1
    move-object v5, v1
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_dialog_btn_cancel I
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v1
    move-object v6, v1
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_dialog_btn_delete I
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v1
    move-object v7, v1
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda13;
    move-object/from16 v18, v1
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda13;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    const/16 v19, 0
    const v20, 98272
    const/16 v21, 0
    invoke-static/range v2 ... v21, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;->delete$default(Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I I Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->show()V
    return-void 
.end method

.method private static final showDeleteDialog$lambda$55(com.bytedance.trae.conversation.ConversationActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->deleteConversation()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final showEndVoiceDiscussionDialog()void
    .registers 29
    # ins_size=1
    move-object/from16 v0, v28
    new-instance v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    move-object v2, v0
    check-cast v2, Landroid/content/Context;
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_switch_session_confirm_title I
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v3
    move-object v5, v3
    const-string v4, "getString(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_switch_session_confirm_message I
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v6
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_switch_session_exit I
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v3
    move-object v10, v3
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_switch_session_continue I
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v3
    move-object v9, v3
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    move-object v4, v3
    const/4 v7, 0
    const/4 v8, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    new-instance v7, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda22;
    move-object/from16 v24, v7
    invoke-direct v7, v0, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda22;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    const/16 v25, 0
    const v26, 1572812
    const/16 v27, 0
    const/4 v7, 0
    invoke-direct/range v4 ... v27, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; F Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I I I Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Z Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;-><init>(Landroid/content/Context; Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;)V
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->show()V
    return-void 
.end method

.method private static final showEndVoiceDiscussionDialog$lambda$116(com.bytedance.trae.conversation.ConversationActivity  java.lang.String)kotlin.Unit
    .registers 8
    # ins_size=2
    check-cast v6, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v6, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v6
    move-object v0, v6
    check-cast v0, Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v2, 0
    new-instance v6, Lcom/bytedance/trae/conversation/ConversationActivity$showEndVoiceDiscussionDialog$1$1;
    const/4 v7, 0
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/ConversationActivity$showEndVoiceDiscussionDialog$1$1;-><init>(Lkotlin/coroutines/Continuation;)V
    move-object v3, v6
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method

.method private final showLoading()void
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/conversation/ConversationActivity;->loadingDialog Landroid/app/Dialog;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +00ah
    invoke-virtual v0, Landroid/app/Dialog;->isShowing()Z
    move-result v0
    if-ne v0, v1, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +003h
    return-void 
    new-instance v0, Landroid/widget/ProgressBar;
    move-object v3, v6
    check-cast v3, Landroid/content/Context;
    invoke-direct v0, v3, Landroid/widget/ProgressBar;-><init>(Landroid/content/Context;)V
    invoke-virtual v0, v1, Landroid/widget/ProgressBar;->setIndeterminate(Z)V
    new-instance v1, Landroid/widget/FrameLayout;
    invoke-direct v1, v3, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    const/16 v4, 24
    int-to-float v4, v4
    invoke-virtual v1, Landroid/widget/FrameLayout;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    invoke-virtual v5, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v5
    iget v5, v5, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v4, v5
    float-to-int v4, v4
    invoke-virtual v1, v4, v4, v4, v4, Landroid/widget/FrameLayout;->setPadding(I I I I)V
    check-cast v0, Landroid/view/View;
    new-instance v4, Landroid/widget/FrameLayout$LayoutParams;
    const/4 v5, -2
    invoke-direct v4, v5, v5, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    const/16 v5, 17
    iput v5, v4, Landroid/widget/FrameLayout$LayoutParams;->gravity I
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v0, v4, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v0, Landroid/app/Dialog;
    invoke-direct v0, v3, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V
    check-cast v1, Landroid/view/View;
    invoke-virtual v0, v1, Landroid/app/Dialog;->setContentView(Landroid/view/View;)V
    invoke-virtual v0, v2, Landroid/app/Dialog;->setCancelable(Z)V
    invoke-virtual v0, Landroid/app/Dialog;->getWindow()Landroid/view/Window;
    move-result-object v1
    if-eqz v1, +008h
    const v2, 17170445
    invoke-virtual v1, v2, Landroid/view/Window;->setBackgroundDrawableResource(I)V
    invoke-virtual v0, Landroid/app/Dialog;->show()V
    iput-object v0, v6, Lcom/bytedance/trae/conversation/ConversationActivity;->loadingDialog Landroid/app/Dialog;
    return-void 
.end method

.method private final showNewFeaturePrompt(com.bytedance.trae.conversation.ConversationActivity$PreparedNewFeaturePrompt  java.util.List  java.lang.String)com.bytedance.trae.conversation.prompt.ManagedPromptDisplayOutcome
    .registers 21
    # ins_size=4
    move-object/from16 v1, v17
    move-object/from16 v2, v18
    move-object/from16 v3, v20
    invoke-direct/range v17, Lcom/bytedance/trae/conversation/ConversationActivity;->currentLoggedInUserId()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +005h
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->NotShown Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    return-object v0
    invoke-direct/range v17, Lcom/bytedance/trae/conversation/ConversationActivity;->isManagedPromptHostReady()Z
    move-result v0
    if-nez v0, +005h
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->TemporarilyBlocked Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    return-object v0
    new-instance v4, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v4, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    sget-object v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->Companion Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$Companion;
    new-instance v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
    new-instance v6, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v7
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->getHasRegisteredWork()Z
    move-result v8
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;->getHasRegisteredIDE()Z
    move-result v9
    move-object/from16 v10, v19
    invoke-direct v6, v7, v10, v8, v9, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/List; Z Z)V
    check-cast v6, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    new-instance v15, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    const/4 v8, 0
    const/4 v9, 0
    new-instance v10, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda7;
    invoke-direct v10, v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    new-instance v11, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda8;
    invoke-direct v11, v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/jvm/internal/Ref$ObjectRef;)V
    new-instance v12, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda9;
    invoke-direct v12, v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/jvm/internal/Ref$ObjectRef;)V
    new-instance v13, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda10;
    invoke-direct v13, v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda10;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/jvm/internal/Ref$ObjectRef;)V
    const/4 v14, 3
    const/16 v16, 0
    move-object v7, v15
    move-object v2, v15
    move-object/from16 v15, v16
    invoke-direct/range v7 ... v15, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v5, v6, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;-><init>(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute; Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;)V
    invoke-virtual v0, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$Companion;->newInstance(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    move-result-object v0
    iput-object v0, v4, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    iget-object v0, v4, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    const-string/jumbo v2, sheet
    const/4 v5, 0
    if-nez v0, +007h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v5
    goto +5h
    iget-object v0, v4, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->newFeaturePromptSheet Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    iget-object v0, v4, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    if-nez v0, +007h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v5
    goto +5h
    iget-object v0, v4, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v6
    const-string v7, "DeviceFlowContainerBottomSheet"
    invoke-virtual v0, v6, v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->showNow(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    iget-object v0, v4, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    if-nez v0, +007h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v5
    goto +5h
    iget-object v0, v4, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->isCommittedNewFeaturePrompt(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;)Z
    move-result v0
    if-eqz v0, +00ah
    move-object/from16 v6, v18
    invoke-direct v1, v3, v6, Lcom/bytedance/trae/conversation/ConversationActivity;->recordNewFeaturePromptShown(Ljava/lang/String; Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;)V
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->Shown Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    goto +34h
    move-object/from16 v6, v18
    iput-object v5, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->newFeaturePromptSheet Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->NotShown Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    goto +2dh
    move-exception v0
    goto +4h
    move-exception v0
    move-object/from16 v6, v18
    sget-object v7, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v8, "ConversationActivity"
    const-string/jumbo v9, show new feature prompt failed
    invoke-virtual v7, v8, v9, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    iget-object v0, v4, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    if-nez v0, +007h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v5
    goto +5h
    iget-object v0, v4, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->isCommittedNewFeaturePrompt(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;)Z
    move-result v0
    if-eqz v0, +008h
    invoke-direct v1, v3, v6, Lcom/bytedance/trae/conversation/ConversationActivity;->recordNewFeaturePromptShown(Ljava/lang/String; Lcom/bytedance/trae/conversation/ConversationActivity$PreparedNewFeaturePrompt;)V
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->Shown Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    goto +5h
    iput-object v5, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->newFeaturePromptSheet Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->NotShown Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    return-object v0
    :try_start_0x78
    :try_start_0xa3
.end method

.method private static final showNewFeaturePrompt$lambda$91(com.bytedance.trae.conversation.ConversationActivity  com.bytedance.trae.conversation.devices.DeviceProductType)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "confirmedProduct"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->IDE Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    if-ne v2, v0, +005h
    invoke-direct v1, Lcom/bytedance/trae/conversation/ConversationActivity;->switchToCodeMode()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final showNewFeaturePrompt$lambda$92(com.bytedance.trae.conversation.ConversationActivity  kotlin.jvm.internal.Ref$ObjectRef)kotlin.Unit
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->newFeaturePromptSheet Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    iget-object v1, v4, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    const/4 v2, 0
    if-nez v1, +00ah
    const-string/jumbo v4, sheet
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v2
    goto +5h
    iget-object v4, v4, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +004h
    iput-object v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->newFeaturePromptSheet Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private static final showNewFeaturePrompt$lambda$93(com.bytedance.trae.conversation.ConversationActivity  kotlin.jvm.internal.Ref$ObjectRef  com.bytedance.trae.conversation.devices.MobileDevice)kotlin.Unit
    .registers 6
    # ins_size=3
    const-string v0, "newDevice"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionPolicy;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionPolicy;->actionFor(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->getDestinationMode()Lcom/bytedance/trae/conversation/widget/ChatMode;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/ConversationActivity$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->ordinal()I
    move-result v1
    aget v1, v2, v1
    const/4 v2, 1
    if-eq v1, v2, +00fh
    const/4 v2, 2
    if-ne v1, v2, +006h
    invoke-direct v3, Lcom/bytedance/trae/conversation/ConversationActivity;->switchToCodeMode()V
    goto +ah
    new-instance v3, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v3, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v3
    invoke-direct v3, Lcom/bytedance/trae/conversation/ConversationActivity;->switchToWorkMode()V
    invoke-direct v3, v5, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->autoSelectConnectedDevice(Lcom/bytedance/trae/conversation/devices/MobileDevice; Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;->getOpenDeviceSelection()Z
    move-result v5
    if-eqz v5, +005h
    invoke-direct v3, Lcom/bytedance/trae/conversation/ConversationActivity;->showCliSelectionDialog()V
    iget-object v5, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->newFeaturePromptSheet Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    iget-object v0, v4, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    const/4 v1, 0
    if-nez v0, +00ah
    const-string/jumbo v4, sheet
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v1
    goto +5h
    iget-object v4, v4, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    invoke-static v5, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +004h
    iput-object v1, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->newFeaturePromptSheet Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private static final showNewFeaturePrompt$lambda$94(com.bytedance.trae.conversation.ConversationActivity  kotlin.jvm.internal.Ref$ObjectRef)kotlin.Unit
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->newFeaturePromptSheet Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    iget-object v1, v4, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    const/4 v2, 0
    if-nez v1, +00ah
    const-string/jumbo v4, sheet
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v2
    goto +5h
    iget-object v4, v4, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +004h
    iput-object v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->newFeaturePromptSheet Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private final showRenameDialog()void
    .registers 14
    # ins_size=1
    iget-object v0, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversation()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getTitle()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    const-string v1, ""
    move-object v5, v1
    sget-object v2, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->Companion Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;
    move-object v3, v13
    check-cast v3, Landroid/content/Context;
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_dialog_rename_title I
    invoke-virtual v13, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v4
    const-string v0, "getString(...)"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_dialog_rename_hint I
    invoke-virtual v13, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v6
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_dialog_btn_cancel I
    invoke-virtual v13, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_dialog_btn_confirm I
    invoke-virtual v13, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v9, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda59;
    invoke-direct v9, v13, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda59;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    const/4 v10, 0
    const/16 v11, 128
    const/4 v12, 0
    invoke-static/range v2 ... v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;->rename$default(Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->show()V
    return-void 
.end method

.method private static final showRenameDialog$lambda$54(com.bytedance.trae.conversation.ConversationActivity  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=2
    move-object v0, v2
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-nez v0, +010h
    iget-object v1, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v1, +009h
    const-string/jumbo v1, viewModel
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->renameConversation(Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final showWelcomeScreen()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    const/4 v1, 0
    const-string v2, "binding"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->welcomeFragmentContainer Landroidx/fragment/app/FragmentContainerView;
    const/4 v3, 0
    invoke-virtual v0, v3, Landroidx/fragment/app/FragmentContainerView;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->detailFragmentContainer Landroidx/fragment/app/FragmentContainerView;
    const/16 v1, 8
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentContainerView;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/ConversationActivity;->initWelcomeFragment()V
    return-void 
.end method

.method private final submitReport(java.lang.String  java.lang.String)void
    .registers 14
    # ins_size=3
    iget-object v0, v11, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    if-nez v0, +004h
    const-string v0, ""
    move-object v4, v0
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v2, 1
    if-nez v0, +004h
    move v0, v2
    goto +2h
    const/4 v0, 0
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    invoke-static v0, v1, v2, v1, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackReportClick$default(Lcom/bytedance/trae/conversation/tracker/TraeAITracker; Ljava/lang/String; I Ljava/lang/Object;)V
    move-object v0, v11
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    check-cast v0, Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v8, 0
    new-instance v9, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;
    const/4 v7, 0
    move-object v2, v9
    move-object v3, v11
    move-object v5, v12
    move-object v6, v13
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v12, v9
    check-cast v12, Lkotlin/jvm/functions/Function2;
    const/4 v9, 3
    const/4 v10, 0
    move-object v5, v0
    move-object v6, v1
    move-object v7, v8
    move-object v8, v12
    invoke-static/range v5 ... v10, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final switchToCodeMode()void
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const-string/jumbo v1, viewModel
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getCurrentMode()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    sget-object v3, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v0, v3, +003h
    return-void 
    invoke-virtual v6, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string v3, "InputFragment"
    invoke-virtual v0, v3, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    instance-of v3, v0, Lcom/bytedance/trae/conversation/widget/InputFragment;
    if-eqz v3, +005h
    check-cast v0, Lcom/bytedance/trae/conversation/widget/InputFragment;
    goto +2h
    move-object v0, v2
    if-eqz v0, +01ch
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->saveDraft()Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;
    move-result-object v3
    if-eqz v3, +016h
    iget-object v4, v6, Lcom/bytedance/trae/conversation/ConversationActivity;->draftByMode Ljava/util/Map;
    sget-object v5, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-interface v4, v5, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/InputFragment$ModeDraft;->getCurrentDevice()Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    move-result-object v3
    if-eqz v3, +009h
    iget-object v4, v6, Lcom/bytedance/trae/conversation/ConversationActivity;->selectedDeviceByMode Ljava/util/Map;
    sget-object v5, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-interface v4, v5, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->clearInput()V
    iget-object v3, v6, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v2
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel;->setMode(Lcom/bytedance/trae/conversation/widget/ChatMode;)V
    if-eqz v0, +007h
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->switchMode(Lcom/bytedance/trae/conversation/widget/ChatMode;)V
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-direct v6, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->updateModeTab(Lcom/bytedance/trae/conversation/widget/ChatMode;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string v1, "WelcomeFragment"
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;
    if-eqz v1, +005h
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;
    if-eqz v2, +007h
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->setMode(Lcom/bytedance/trae/conversation/widget/ChatMode;)V
    return-void 
.end method

.method private final switchToWorkMode()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getCurrentMode()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v0, v1, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->updateModeTab(Lcom/bytedance/trae/conversation/widget/ChatMode;)V
    return-void 
.end method

.method private final syncCheckpointOverlayWithKeyboard()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    const/4 v1, 0
    const-string v2, "binding"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->checkpointOverlayContainer Landroidx/fragment/app/FragmentContainerView;
    const-string v3, "checkpointOverlayContainer"
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, Landroidx/fragment/app/FragmentContainerView;->getVisibility()I
    move-result v3
    const/4 v4, 0
    if-nez v3, +066h
    invoke-virtual v0, Landroidx/fragment/app/FragmentContainerView;->getHeight()I
    move-result v3
    if-nez v3, +003h
    goto +5eh
    iget-object v3, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v3, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    move-result-object v1
    const-string v2, "getRoot(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->checkpointVisibleFrame Landroid/graphics/Rect;
    invoke-virtual v1, v2, Landroidx/constraintlayout/widget/ConstraintLayout;->getWindowVisibleDisplayFrame(Landroid/graphics/Rect;)V
    invoke-virtual v1, Landroidx/constraintlayout/widget/ConstraintLayout;->getRootView()Landroid/view/View;
    move-result-object v1
    invoke-virtual v1, Landroid/view/View;->getHeight()I
    move-result v1
    iget-object v2, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->checkpointVisibleFrame Landroid/graphics/Rect;
    iget v2, v2, Landroid/graphics/Rect;->bottom I
    sub-int v2, v1, v2
    int-to-float v2, v2
    int-to-float v1, v1
    const v3, 1041865114
    mul-float/2addr v1, v3
    cmpl-float v1, v2, v1
    const/4 v2, 1
    if-lez v1, +004h
    move v1, v2
    goto +2h
    const/4 v1, 0
    if-nez v1, +006h
    invoke-virtual v0, v4, Landroidx/fragment/app/FragmentContainerView;->setTranslationY(F)V
    return-void 
    iget-object v1, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->checkpointOverlayLocation [I
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentContainerView;->getLocationOnScreen([I)V
    iget-object v1, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->checkpointOverlayLocation [I
    aget v1, v1, v2
    int-to-float v1, v1
    invoke-virtual v0, Landroidx/fragment/app/FragmentContainerView;->getTranslationY()F
    move-result v2
    sub-float/2addr v1, v2
    invoke-virtual v0, Landroidx/fragment/app/FragmentContainerView;->getHeight()I
    move-result v2
    int-to-float v2, v2
    add-float/2addr v1, v2
    iget-object v2, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->checkpointVisibleFrame Landroid/graphics/Rect;
    iget v2, v2, Landroid/graphics/Rect;->bottom I
    int-to-float v2, v2
    sub-float/2addr v1, v2
    cmpl-float v2, v1, v4
    if-lez v2, +003h
    neg-float v4, v1
    invoke-virtual v0, v4, Landroidx/fragment/app/FragmentContainerView;->setTranslationY(F)V
    return-void 
    invoke-virtual v0, v4, Landroidx/fragment/app/FragmentContainerView;->setTranslationY(F)V
    return-void 
.end method

.method private final trackCopy(java.lang.String)void
    .registers 13
    # ins_size=2
    iget-object v0, v11, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    if-nez v0, +004h
    const-string v0, ""
    move-object v4, v0
    const/4 v0, 1
    invoke-static v11, v1, v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->resolveCurrentChatMode$default(Lcom/bytedance/trae/conversation/ConversationActivity; Lcom/bytedance/trae/im/service/Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    new-instance v9, Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    const/4 v3, 0
    const/4 v6, 0
    const/16 v7, 9
    const/4 v8, 0
    move-object v2, v9
    move-object v5, v12
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/tracker/AIEventContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/4 v7, 0
    const/4 v12, 2
    const/4 v10, 0
    move-object v5, v1
    move-object v6, v9
    move-object v8, v0
    move v9, v12
    invoke-static/range v5 ... v10, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackCopyClick$default(Lcom/bytedance/trae/conversation/tracker/TraeAITracker; Lcom/bytedance/trae/conversation/tracker/AIEventContext; Ljava/lang/String; Lcom/bytedance/trae/conversation/tracker/SoloChatMode; I Ljava/lang/Object;)V
    return-void 
.end method

.method private final trackFeedback(java.lang.String  java.lang.String)void
    .registers 15
    # ins_size=3
    iget-object v0, v12, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->getConversationId()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    const-string v2, ""
    if-nez v0, +004h
    move-object v5, v2
    goto +2h
    move-object v5, v0
    invoke-direct v12, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->findUserMessageId(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    const/4 v0, 1
    invoke-static v12, v1, v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->resolveCurrentChatMode$default(Lcom/bytedance/trae/conversation/ConversationActivity; Lcom/bytedance/trae/im/service/Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    move-result-object v11
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    new-instance v1, Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    const/4 v4, 0
    iget-object v3, v12, Lcom/bytedance/trae/conversation/ConversationActivity;->streamingChatModel Ljava/lang/String;
    if-nez v3, +004h
    move-object v7, v2
    goto +2h
    move-object v7, v3
    const/4 v8, 1
    const/4 v9, 0
    move-object v3, v1
    move-object v6, v10
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/tracker/AIEventContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v6, v0
    move-object v7, v1
    move-object v8, v14
    move-object v9, v13
    invoke-virtual/range v6 ... v11, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackFeedbackClick(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method

.method private final unregisterCheckpointKeyboardListener()void
    .registers 3
    # ins_size=1
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->isCheckpointKeyboardListenerRegistered Z
    if-nez v0, +003h
    return-void 
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v0, +008h
    const-string v0, "binding"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    move-result-object v0
    invoke-virtual v0, Landroidx/constraintlayout/widget/ConstraintLayout;->getViewTreeObserver()Landroid/view/ViewTreeObserver;
    move-result-object v0
    invoke-virtual v0, Landroid/view/ViewTreeObserver;->isAlive()Z
    move-result v1
    if-eqz v1, +007h
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->checkpointKeyboardLayoutListener Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;
    invoke-virtual v0, v1, Landroid/view/ViewTreeObserver;->removeOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    const/4 v0, 0
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->isCheckpointKeyboardListenerRegistered Z
    return-void 
.end method

.method private final updateConversationTitleInfo(com.bytedance.trae.im.service.Conversation)void
    .registers 10
    # ins_size=2
    iget-object v0, v8, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    const-string v1, "binding"
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->showConversationDetailHeader()V
    iget-object v0, v8, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    invoke-virtual v9, Lcom/bytedance/trae/im/service/Conversation;->getTitle()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v3
    const-string v4, ""
    if-eqz v3, +009h
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_new_task I
    invoke-virtual v8, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v3
    goto +8h
    invoke-virtual v9, Lcom/bytedance/trae/im/service/Conversation;->getTitle()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    move-object v3, v4
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setConversationDetailTitle(Ljava/lang/CharSequence;)V
    invoke-virtual v9, Lcom/bytedance/trae/im/service/Conversation;->getDisplayEnvironment()Ljava/lang/String;
    move-result-object v0
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v3
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    const-string/jumbo v3, viewModel
    if-eqz v0, +02eh
    iget-object v0, v8, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v9, Lcom/bytedance/trae/im/service/Conversation;->getDisplayGitUri()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v0, v9, Lcom/bytedance/trae/conversation/ConversationViewModel;->parseGitDisplayName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    iget-object v0, v8, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    iget-object v0, v2, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_input_cloud I
    invoke-virtual v8, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    check-cast v9, Ljava/lang/CharSequence;
    sget v2, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_title_bar_cloud I
    invoke-virtual v0, v1, v9, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setConversationDetailSubtitle(Ljava/lang/CharSequence; Ljava/lang/CharSequence; I)V
    goto/16 +10ah
    invoke-virtual v9, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v0
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    const-string v5, "online"
    if-eqz v0, +088h
    sget-object v0, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CliListRepository;->getCacheClis()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +018h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v6, v3
    check-cast v6, Lcom/bytedance/trae/im/service/Cli;
    invoke-virtual v6, Lcom/bytedance/trae/im/service/Cli;->getId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v9, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v7
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, -019h
    goto +2h
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/im/service/Cli;
    invoke-virtual v9, Lcom/bytedance/trae/im/service/Conversation;->getOwnerProjectAbsolutePath()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +020h
    invoke-virtual v9, Lcom/bytedance/trae/im/service/Conversation;->getOwnerProjectWorkSpaceStatus()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +18h
    sget-object v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil;->INSTANCE Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil;
    move-object v4, v8
    check-cast v4, Landroid/content/Context;
    invoke-virtual v9, Lcom/bytedance/trae/im/service/Conversation;->getOwnerProjectAbsolutePath()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v9, Lcom/bytedance/trae/im/service/Conversation;->getOwnerProjectWorkSpaceStatus()Ljava/lang/String;
    move-result-object v7
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v0, v4, v6, v7, Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil;->getProjectName(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Cli;->getStatus()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v2
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget v0, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_title_bar_computer_online I
    goto +3h
    sget v0, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_title_bar_computer_offline I
    iget-object v5, v8, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v5, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v5
    iget-object v1, v2, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v3, +008h
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Cli;->getName()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +006h
    invoke-virtual v9, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v1, v2, v4, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setConversationDetailSubtitle(Ljava/lang/CharSequence; Ljava/lang/CharSequence; I)V
    goto/16 +072h
    sget-object v0, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CliListRepository;->getCacheClis()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +018h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v6, v4
    check-cast v6, Lcom/bytedance/trae/im/service/Cli;
    invoke-virtual v6, Lcom/bytedance/trae/im/service/Cli;->getId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v9, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v7
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, -019h
    goto +2h
    move-object v4, v2
    check-cast v4, Lcom/bytedance/trae/im/service/Cli;
    iget-object v0, v8, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v9, Lcom/bytedance/trae/im/service/Conversation;->getDisplayWorkspace()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->parseWorkspaceDisplayName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Cli;->getStatus()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v2
    invoke-static v3, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +005h
    sget v3, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_title_bar_computer_online I
    goto +3h
    sget v3, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_title_bar_computer_offline I
    iget-object v5, v8, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v5, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v5
    iget-object v1, v2, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v4, +008h
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Cli;->getName()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +006h
    invoke-virtual v9, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v1, v2, v0, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setConversationDetailSubtitle(Ljava/lang/CharSequence; Ljava/lang/CharSequence; I)V
    return-void 
.end method

.method private final updateModeTab(com.bytedance.trae.conversation.widget.ChatMode)void
    .registers 7
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/ConversationActivity$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/ChatMode;->ordinal()I
    move-result v6
    aget v6, v0, v6
    const-string v0, "binding"
    const/4 v1, 1
    const/4 v2, 0
    const/4 v3, 2
    const/4 v4, 0
    if-eq v6, v1, +018h
    if-ne v6, v3, +010h
    iget-object v6, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v6, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v4
    iget-object v6, v6, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    invoke-static v6, v1, v2, v3, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setSegmentedSelectedIndex$default(Lcom/bytedance/trae/common/widget/TraeTitleBar; I Z I Ljava/lang/Object;)V
    goto +14h
    new-instance v6, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v6, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v6
    iget-object v6, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v6, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v4
    iget-object v6, v6, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    invoke-static v6, v2, v2, v3, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setSegmentedSelectedIndex$default(Lcom/bytedance/trae/common/widget/TraeTitleBar; I Z I Ljava/lang/Object;)V
    return-void 
.end method

.method public com_bytedance_trae_conversation_ConversationActivity__onStop$___twin___()void
    .registers 2
    # ins_size=1
    invoke-super v1, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    const/4 v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->hasEnteredBackground Z
    return-void 
.end method

.method public dispatchTouchEvent(android.view.MotionEvent)boolean
    .registers 6
    # ins_size=2
    const-string v0, "ev"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Landroid/view/MotionEvent;->getAction()I
    move-result v0
    if-nez v0, +045h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/ConversationActivity;->getCurrentFocus()Landroid/view/View;
    move-result-object v0
    instance-of v1, v0, Landroid/widget/EditText;
    if-eqz v1, +03dh
    new-instance v1, Landroid/graphics/Rect;
    invoke-direct v1, Landroid/graphics/Rect;-><init>()V
    check-cast v0, Landroid/widget/EditText;
    invoke-virtual v0, v1, Landroid/widget/EditText;->getGlobalVisibleRect(Landroid/graphics/Rect;)Z
    invoke-virtual v5, Landroid/view/MotionEvent;->getRawX()F
    move-result v2
    float-to-int v2, v2
    invoke-virtual v5, Landroid/view/MotionEvent;->getRawY()F
    move-result v3
    float-to-int v3, v3
    invoke-virtual v1, v2, v3, Landroid/graphics/Rect;->contains(I I)Z
    move-result v1
    if-nez v1, +023h
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/ConversationActivity;->isTouchOnInputArea(Landroid/view/MotionEvent;)Z
    move-result v1
    if-nez v1, +01dh
    invoke-virtual v0, Landroid/widget/EditText;->clearFocus()V
    const-string v1, "input_method"
    invoke-virtual v4, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v1
    instance-of v2, v1, Landroid/view/inputmethod/InputMethodManager;
    if-eqz v2, +005h
    check-cast v1, Landroid/view/inputmethod/InputMethodManager;
    goto +2h
    const/4 v1, 0
    if-eqz v1, +00ah
    invoke-virtual v0, Landroid/widget/EditText;->getWindowToken()Landroid/os/IBinder;
    move-result-object v0
    const/4 v2, 0
    invoke-virtual v1, v0, v2, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder; I)Z
    invoke-super v4, v5, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z
    move-result v5
    return v5
.end method

.method public final getInitialChatMode()com.bytedance.trae.conversation.widget.ChatMode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->initialChatMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    return-object v0
.end method

.method public final getPreviewWebViewLauncher()androidx.activity.result.ActivityResultLauncher
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->previewWebViewLauncher Landroidx/activity/result/ActivityResultLauncher;
    return-object v0
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 15
    # ins_size=2
    invoke-super v13, v14, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    invoke-virtual v13, Lcom/bytedance/trae/conversation/ConversationActivity;->getLayoutInflater()Landroid/view/LayoutInflater;
    move-result-object v0
    invoke-static v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->inflate(Landroid/view/LayoutInflater;)Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    move-result-object v0
    const-string v1, "inflate(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    const-string v1, "binding"
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    move-result-object v0
    check-cast v0, Landroid/view/View;
    invoke-virtual v13, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->setContentView(Landroid/view/View;)V
    invoke-direct v13, Lcom/bytedance/trae/conversation/ConversationActivity;->registerCheckpointKeyboardListener()V
    sget-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->prewarm()V
    sget-object v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->init()V
    new-instance v0, Landroidx/lifecycle/ViewModelProvider;
    move-object v3, v13
    check-cast v3, Landroidx/lifecycle/ViewModelStoreOwner;
    invoke-direct v0, v3, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V
    const-class v3, Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v0, v3, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/ConversationViewModel;
    iput-object v0, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/ConversationActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v3, "extra_conversation"
    invoke-virtual v0, v3, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;
    move-result-object v0
    instance-of v3, v0, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v3, +005h
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    goto +2h
    move-object v0, v2
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +00ch
    invoke-virtual v13, Lcom/bytedance/trae/conversation/ConversationActivity;->getIntent()Landroid/content/Intent;
    move-result-object v3
    const-string v4, "extra_conversation_id"
    invoke-virtual v3, v4, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v13, Lcom/bytedance/trae/conversation/ConversationActivity;->getIntent()Landroid/content/Intent;
    move-result-object v4
    const-string v5, "extra_anchor_created_at_ms"
    invoke-virtual v4, v5, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    iput-object v4, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->anchorCreatedAtMs Ljava/lang/String;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/ConversationActivity;->getIntent()Landroid/content/Intent;
    move-result-object v4
    const-string v5, "extra_pending_connect_device_type"
    invoke-virtual v4, v5, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +025h
    sget-object v5, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v5, v13
    check-cast v5, Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->valueOf(Ljava/lang/String;)Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    goto +ch
    move-exception v4
    sget-object v5, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +003h
    move-object v4, v2
    check-cast v4, Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    goto +2h
    move-object v4, v2
    iput-object v4, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->pendingConnectDeviceType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    const/4 v5, 0
    const/4 v6, 1
    if-eqz v4, +004h
    move v4, v6
    goto +2h
    move v4, v5
    iput-boolean v4, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->suppressNaturalGuideForPendingConnect Z
    iget-object v4, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    const-string/jumbo v7, viewModel
    if-nez v4, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v2
    iget-object v8, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->anchorCreatedAtMs Ljava/lang/String;
    invoke-virtual v4, v3, v0, v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->init(Ljava/lang/String; Lcom/bytedance/trae/im/service/Conversation; Ljava/lang/String;)Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v4
    if-nez v0, +003h
    move-object v0, v4
    iget-object v8, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v8, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v2
    invoke-virtual v8, Lcom/bytedance/trae/conversation/ConversationViewModel;->isNewConversation()Z
    move-result v8
    iput-boolean v8, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->isNewConversation Z
    invoke-direct v13, Lcom/bytedance/trae/conversation/ConversationActivity;->observeManagedPrompts()V
    iget-boolean v8, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->isNewConversation Z
    const-string/jumbo v9, task_list
    const-string v10, "extra_enter_from"
    const-string v11, ""
    if-eqz v8, +026h
    invoke-virtual v13, Lcom/bytedance/trae/conversation/ConversationActivity;->getIntent()Landroid/content/Intent;
    move-result-object v3
    invoke-virtual v3, v10, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    goto +2h
    move-object v11, v3
    check-cast v11, Ljava/lang/CharSequence;
    invoke-interface v11, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +004h
    move v3, v6
    goto +2h
    move v3, v5
    if-eqz v3, +003h
    goto +2h
    move-object v9, v11
    check-cast v9, Ljava/lang/String;
    sget-object v3, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;
    invoke-virtual v3, v9, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->trackPageView(Ljava/lang/String;)V
    goto/16 +060h
    invoke-virtual v13, Lcom/bytedance/trae/conversation/ConversationActivity;->getIntent()Landroid/content/Intent;
    move-result-object v8
    invoke-virtual v8, v10, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    move-object v8, v11
    check-cast v8, Ljava/lang/CharSequence;
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v10
    if-nez v10, +004h
    move v10, v6
    goto +2h
    move v10, v5
    if-eqz v10, +003h
    goto +2h
    move-object v9, v8
    check-cast v9, Ljava/lang/String;
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getLatestTaskStatus()Ljava/lang/String;
    move-result-object v8
    goto +2h
    move-object v8, v2
    if-nez v8, +003h
    move-object v8, v11
    sget-object v10, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v8, v10, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v8
    const-string/jumbo v10, toLowerCase(...)
    invoke-static v8, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v8, Ljava/lang/CharSequence;
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v12
    if-nez v12, +004h
    move v12, v6
    goto +2h
    move v12, v5
    if-eqz v12, +016h
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getStatus()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v2
    if-nez v4, +003h
    move-object v4, v11
    sget-object v8, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v4, v8, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v8, Ljava/lang/String;
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;
    if-nez v3, +003h
    move-object v3, v11
    invoke-virtual v4, v3, v8, v9, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->trackTaskDetailPageView(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v0, +086h
    iget-object v3, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v3, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v2
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->shouldCheckIdeProject(Lcom/bytedance/trae/im/service/Conversation;)Z
    move-result v3
    if-eqz v3, +013h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +00dh
    iget-object v4, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v4, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v2
    invoke-virtual v4, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->createTaskCheck(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +061h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v4
    sget-object v7, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v7, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v7
    invoke-static v4, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +008h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getOwnerProjectId()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +02fh
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +3h
    move v4, v5
    goto +2h
    move v4, v6
    if-nez v4, +01bh
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v4
    sget-object v7, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v7, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v7
    invoke-static v4, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +009h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +3h
    move v0, v5
    goto +2h
    move v0, v6
    if-eqz v0, +01bh
    move-object v0, v13
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v7, v0
    check-cast v7, Lkotlinx/coroutines/CoroutineScope;
    const/4 v8, 0
    const/4 v9, 0
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;
    invoke-direct v0, v3, v13, v2, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    move-object v10, v0
    check-cast v10, Lkotlin/jvm/functions/Function2;
    const/4 v11, 3
    const/4 v12, 0
    invoke-static/range v7 ... v12, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    if-nez v14, +046h
    invoke-virtual v13, Lcom/bytedance/trae/conversation/ConversationActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v14
    invoke-virtual v14, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v14
    sget v0, Lcom/bytedance/trae/conversation/R$id;->detail_fragment_container I
    sget-object v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->Companion Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$Companion;->newInstance()Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    move-result-object v3
    check-cast v3, Landroidx/fragment/app/Fragment;
    const-string v4, "ConversationDetailFragment"
    invoke-virtual v14, v0, v3, v4, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment; Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v14
    sget v0, Lcom/bytedance/trae/conversation/R$id;->input_fragment_container I
    sget-object v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->Companion Lcom/bytedance/trae/conversation/widget/InputFragment$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/InputFragment$Companion;->newInstance()Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v3
    check-cast v3, Landroidx/fragment/app/Fragment;
    const-string v4, "InputFragment"
    invoke-virtual v14, v0, v3, v4, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment; Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v14
    const-string/jumbo v0, replace(...)
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-boolean v0, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->isNewConversation Z
    if-eqz v0, +011h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->welcome_fragment_container I
    sget-object v3, Lcom/bytedance/trae/conversation/widget/WelcomeFragment;->Companion Lcom/bytedance/trae/conversation/widget/WelcomeFragment$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/WelcomeFragment$Companion;->newInstance()Lcom/bytedance/trae/conversation/widget/WelcomeFragment;
    move-result-object v3
    check-cast v3, Landroidx/fragment/app/Fragment;
    const-string v4, "WelcomeFragment"
    invoke-virtual v14, v0, v3, v4, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment; Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    invoke-virtual v14, Landroidx/fragment/app/FragmentTransaction;->commitNow()V
    iget-boolean v14, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->isNewConversation Z
    if-eqz v14, +005h
    invoke-direct v13, Lcom/bytedance/trae/conversation/ConversationActivity;->showWelcomeScreen()V
    invoke-virtual v13, Lcom/bytedance/trae/conversation/ConversationActivity;->getIntent()Landroid/content/Intent;
    move-result-object v14
    const-string v0, "extra_mode"
    invoke-virtual v14, v0, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v14
    const-string v0, "code"
    if-eqz v14, +00eh
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v14
    if-eqz v14, +005h
    sget-object v14, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    goto +1bh
    sget-object v14, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    goto +18h
    sget-object v14, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->INSTANCE Lcom/bytedance/trae/conversation/AccountSettingsKeva;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v14
    const-string v3, "last_selected_chat_mode"
    invoke-virtual v14, v3, v2, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v14
    if-eqz v14, +005h
    sget-object v14, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    goto +3h
    sget-object v14, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    iput-object v14, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->initialChatMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-direct v13, Lcom/bytedance/trae/conversation/ConversationActivity;->initInputFragment()V
    invoke-direct v13, Lcom/bytedance/trae/conversation/ConversationActivity;->initTitleBar()V
    invoke-direct v13, Lcom/bytedance/trae/conversation/ConversationActivity;->initCheckpointDialog()V
    invoke-direct v13, Lcom/bytedance/trae/conversation/ConversationActivity;->observeViewModel()V
    iget-object v14, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->anchorCreatedAtMs Ljava/lang/String;
    check-cast v14, Ljava/lang/CharSequence;
    if-eqz v14, +008h
    invoke-static v14, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v14
    if-eqz v14, +003h
    move v5, v6
    if-nez v5, +00bh
    invoke-direct v13, Lcom/bytedance/trae/conversation/ConversationActivity;->getDetailFragment()Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    move-result-object v14
    if-eqz v14, +005h
    invoke-virtual v14, v6, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->setAnchorLoading(Z)V
    invoke-direct v13, Lcom/bytedance/trae/conversation/ConversationActivity;->observeMinimizedVoice()V
    invoke-direct v13, Lcom/bytedance/trae/conversation/ConversationActivity;->observeBrainstormEnded()V
    invoke-virtual v13, Lcom/bytedance/trae/conversation/ConversationActivity;->getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;
    move-result-object v14
    move-object v0, v13
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    iget-object v3, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->voiceMinimizedBackCallback Lcom/bytedance/trae/conversation/ConversationActivity$voiceMinimizedBackCallback$1;
    check-cast v3, Landroidx/activity/OnBackPressedCallback;
    invoke-virtual v14, v0, v3, Landroidx/activity/OnBackPressedDispatcher;->addCallback(Landroidx/lifecycle/LifecycleOwner; Landroidx/activity/OnBackPressedCallback;)V
    iget-boolean v14, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->isNewConversation Z
    if-eqz v14, +005h
    invoke-direct v13, Lcom/bytedance/trae/conversation/ConversationActivity;->observeStarbucks()V
    sget-object v14, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    iget-object v3, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->conversationChangeListener Lcom/bytedance/trae/im/service/IMService$ConversationChangeListener;
    invoke-virtual v14, v3, Lcom/bytedance/trae/im/service/IMService;->addConversationChangeListener(Lcom/bytedance/trae/im/service/IMService$ConversationChangeListener;)V
    sget-object v14, Lcom/bytedance/trae/conversation/chat/MessageManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/MessageManager;
    iget-object v3, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->deleteMessageListener Lcom/bytedance/trae/conversation/ConversationActivity$deleteMessageListener$1;
    check-cast v3, Lcom/bytedance/trae/conversation/chat/MessageManager$IDeleteMessage;
    invoke-virtual v14, v3, Lcom/bytedance/trae/conversation/chat/MessageManager;->addDeleteMessageListener(Lcom/bytedance/trae/conversation/chat/MessageManager$IDeleteMessage;)V
    sget-object v14, Lcom/bytedance/trae/conversation/chat/MessageManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/MessageManager;
    iget-object v3, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->deleteConversationListener Lcom/bytedance/trae/conversation/ConversationActivity$deleteConversationListener$1;
    check-cast v3, Lcom/bytedance/trae/conversation/chat/MessageManager$IDeleteConversation;
    invoke-virtual v14, v3, Lcom/bytedance/trae/conversation/chat/MessageManager;->addDeleteConversationListener(Lcom/bytedance/trae/conversation/chat/MessageManager$IDeleteConversation;)V
    sget-object v14, Lcom/bytedance/trae/conversation/chat/MessageManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/MessageManager;
    iget-object v3, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->revertMessageListener Lcom/bytedance/trae/conversation/ConversationActivity$revertMessageListener$1;
    check-cast v3, Lcom/bytedance/trae/conversation/chat/MessageManager$IRevertMessage;
    invoke-virtual v14, v3, Lcom/bytedance/trae/conversation/chat/MessageManager;->addRevertMessageListener(Lcom/bytedance/trae/conversation/chat/MessageManager$IRevertMessage;)V
    sget-object v14, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    iget-object v3, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->cliStatusChangeListener Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;
    invoke-virtual v14, v3, Lcom/bytedance/trae/im/service/IMService;->addCliStatusChangeListener(Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;)V
    sget-object v14, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    iget-object v3, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->remoteDeleteMessagePushListener Lcom/bytedance/trae/im/service/IMService$RemoteDeleteMessagePushListener;
    invoke-virtual v14, v3, Lcom/bytedance/trae/im/service/IMService;->addRemoteDeleteMessagePushListener(Lcom/bytedance/trae/im/service/IMService$RemoteDeleteMessagePushListener;)V
    iget-object v14, v13, Lcom/bytedance/trae/conversation/ConversationActivity;->binding Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;
    if-nez v14, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v14, v2
    iget-object v14, v14, Lcom/bytedance/trae/conversation/databinding/TraeActivityConversationBinding;->btnRetryLoad Landroid/widget/Button;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda55;
    invoke-direct v1, v13, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda55;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v14, v1, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v13, Lcom/bytedance/trae/conversation/ConversationActivity;->getDetailFragment()Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    move-result-object v14
    if-eqz v14, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda62;
    invoke-direct v1, v13, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda62;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v14, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->setOnLoadMore(Lkotlin/jvm/functions/Function0;)V
    invoke-direct v13, Lcom/bytedance/trae/conversation/ConversationActivity;->getDetailFragment()Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    move-result-object v14
    if-eqz v14, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda63;
    invoke-direct v1, v13, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda63;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v14, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->setOnLoadNewer(Lkotlin/jvm/functions/Function0;)V
    invoke-direct v13, Lcom/bytedance/trae/conversation/ConversationActivity;->getDetailFragment()Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    move-result-object v14
    if-eqz v14, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda64;
    invoke-direct v1, v13, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda64;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v14, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->setOnJumpToBottomClick(Lkotlin/jvm/functions/Function0;)V
    invoke-direct v13, Lcom/bytedance/trae/conversation/ConversationActivity;->getDetailFragment()Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    move-result-object v14
    if-eqz v14, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda1;
    invoke-direct v1, v13, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v14, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->setOnRetryClick(Lkotlin/jvm/functions/Function1;)V
    invoke-direct v13, Lcom/bytedance/trae/conversation/ConversationActivity;->getDetailFragment()Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    move-result-object v14
    if-eqz v14, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda2;
    invoke-direct v1, v13, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v14, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->setOnUseExpressPassClick(Lkotlin/jvm/functions/Function1;)V
    invoke-direct v13, Lcom/bytedance/trae/conversation/ConversationActivity;->getDetailFragment()Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    move-result-object v14
    if-eqz v14, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda3;
    invoke-direct v1, v13, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v14, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->setOnFeedbackClick(Lkotlin/jvm/functions/Function2;)V
    invoke-direct v13, Lcom/bytedance/trae/conversation/ConversationActivity;->getDetailFragment()Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    move-result-object v14
    if-eqz v14, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda4;
    invoke-direct v1, v13, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v14, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->setOnCopyClick(Lkotlin/jvm/functions/Function1;)V
    invoke-direct v13, Lcom/bytedance/trae/conversation/ConversationActivity;->getDetailFragment()Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    move-result-object v14
    if-eqz v14, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda5;
    invoke-direct v1, v13, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v14, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->setOnReportClick(Lkotlin/jvm/functions/Function2;)V
    invoke-direct v13, Lcom/bytedance/trae/conversation/ConversationActivity;->getDetailFragment()Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    move-result-object v14
    if-eqz v14, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda6;
    invoke-direct v1, v13, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v14, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->setOnUserScrolled(Lkotlin/jvm/functions/Function0;)V
    invoke-direct v13, Lcom/bytedance/trae/conversation/ConversationActivity;->getDetailFragment()Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    move-result-object v14
    if-eqz v14, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda61;
    invoke-direct v1, v13, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda61;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    invoke-virtual v14, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->setOnUpgradeReminderClick(Lkotlin/jvm/functions/Function1;)V
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v14
    move-object v3, v14
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v14, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$15;
    invoke-direct v14, v2, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$15;-><init>(Lkotlin/coroutines/Continuation;)V
    move-object v6, v14
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v14
    move-object v3, v14
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    new-instance v14, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$16;
    invoke-direct v14, v2, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$16;-><init>(Lkotlin/coroutines/Continuation;)V
    move-object v6, v14
    check-cast v6, Lkotlin/jvm/functions/Function2;
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-direct v13, Lcom/bytedance/trae/conversation/ConversationActivity;->requestNotificationPermissionIfNeeded()V
    return-void 
    :try_start_0x7f
.end method

.method protected onDestroy()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/conversation/ConversationActivity;->hideLoading()V
    invoke-direct v3, Lcom/bytedance/trae/conversation/ConversationActivity;->unregisterCheckpointKeyboardListener()V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->release()V
    sget-object v0, Lcom/bytedance/trae/push/api/ActiveConversationTracker;->INSTANCE Lcom/bytedance/trae/push/api/ActiveConversationTracker;
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/bytedance/trae/push/api/ActiveConversationTracker;->setActiveConversationId(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->conversationChangeListener Lcom/bytedance/trae/im/service/IMService$ConversationChangeListener;
    invoke-virtual v0, v2, Lcom/bytedance/trae/im/service/IMService;->removeConversationChangeListener(Lcom/bytedance/trae/im/service/IMService$ConversationChangeListener;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/MessageManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/MessageManager;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->deleteMessageListener Lcom/bytedance/trae/conversation/ConversationActivity$deleteMessageListener$1;
    check-cast v2, Lcom/bytedance/trae/conversation/chat/MessageManager$IDeleteMessage;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/chat/MessageManager;->removeDeleteMessageListener(Lcom/bytedance/trae/conversation/chat/MessageManager$IDeleteMessage;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/MessageManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/MessageManager;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->deleteConversationListener Lcom/bytedance/trae/conversation/ConversationActivity$deleteConversationListener$1;
    check-cast v2, Lcom/bytedance/trae/conversation/chat/MessageManager$IDeleteConversation;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/chat/MessageManager;->removeDeleteConversationListener(Lcom/bytedance/trae/conversation/chat/MessageManager$IDeleteConversation;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/MessageManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/MessageManager;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->revertMessageListener Lcom/bytedance/trae/conversation/ConversationActivity$revertMessageListener$1;
    check-cast v2, Lcom/bytedance/trae/conversation/chat/MessageManager$IRevertMessage;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/chat/MessageManager;->removeRevertMessageListener(Lcom/bytedance/trae/conversation/chat/MessageManager$IRevertMessage;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->cliStatusChangeListener Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;
    invoke-virtual v0, v2, Lcom/bytedance/trae/im/service/IMService;->removeCliStatusChangeListener(Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->newFeaturePromptSheet Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->dismissAllowingStateLoss()V
    iput-object v1, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->newFeaturePromptSheet Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->remoteDeleteMessagePushListener Lcom/bytedance/trae/im/service/IMService$RemoteDeleteMessagePushListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/im/service/IMService;->removeRemoteDeleteMessagePushListener(Lcom/bytedance/trae/im/service/IMService$RemoteDeleteMessagePushListener;)V
    invoke-super v3, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onDestroy()V
    return-void 
.end method

.method protected onNewIntent(android.content.Intent)void
    .registers 10
    # ins_size=2
    const-string v0, "intent"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v8, v9, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onNewIntent(Landroid/content/Intent;)V
    const-string v0, "conversation_id"
    invoke-virtual v9, v0, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    move v1, v3
    goto +2h
    move v1, v2
    if-nez v1, +006h
    invoke-direct v8, v0, v9, Lcom/bytedance/trae/conversation/ConversationActivity;->handlePushNewIntent(Ljava/lang/String; Landroid/content/Intent;)V
    return-void 
    invoke-virtual v9, Landroid/content/Intent;->getData()Landroid/net/Uri;
    move-result-object v9
    if-nez v9, +003h
    return-void 
    invoke-virtual v9, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v0
    const-string v1, "oauth"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +01ch
    invoke-virtual v9, Landroid/net/Uri;->getPath()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +00dh
    const-string v4, "/plugin-connector/callback"
    const/4 v5, 2
    invoke-static v0, v4, v3, v5, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-ne v0, v2, +004h
    move v0, v2
    goto +2h
    move v0, v3
    if-eqz v0, +008h
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-virtual v0, v9, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->handleCallback(Landroid/net/Uri;)V
    return-void 
    invoke-virtual v9, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v0
    const-string v4, "github-connector-callback"
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    const-string v0, "error"
    invoke-virtual v9, v0, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    move-object v4, v0
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    move v4, v3
    goto +2h
    move v4, v2
    if-nez v4, +019h
    move-object v9, v8
    check-cast v9, Landroid/content/Context;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_github_error_oauth_authorized_failed I
    new-array v2, v2, [Ljava/lang/Object;
    aput-object v0, v2, v3
    invoke-virtual v8, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v9, v0, v3, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v9
    invoke-virtual v9, Landroid/widget/Toast;->show()V
    return-void 
    move-object v0, v8
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$onNewIntent$1;
    invoke-direct v0, v8, v9, v1, Lcom/bytedance/trae/conversation/ConversationActivity$onNewIntent$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Landroid/net/Uri; Lkotlin/coroutines/Continuation;)V
    move-object v5, v0
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method protected onResume()void
    .registers 5
    # ins_size=1
    invoke-super v4, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onResume()V
    iget-boolean v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->isNewConversation Z
    if-eqz v0, +009h
    invoke-direct v4, Lcom/bytedance/trae/conversation/ConversationActivity;->getGitSelectionViewModel()Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->fetchRepos()V
    invoke-direct v4, Lcom/bytedance/trae/conversation/ConversationActivity;->executePendingConnectDevice()V
    invoke-direct v4, Lcom/bytedance/trae/conversation/ConversationActivity;->applyMinimizedVoiceVisibility()V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->isMinimized()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +026h
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->isMicMuted()Z
    move-result v0
    if-eqz v0, +011h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->stopAudioCapture()V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;
    move-object v2, v4
    check-cast v2, Landroid/content/Context;
    const/4 v3, 1
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;->update(Landroid/content/Context; Z)V
    goto +eh
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;
    move-object v2, v4
    check-cast v2, Landroid/content/Context;
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;->update(Landroid/content/Context; Z)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->startAudioCapture()V
    sget-object v0, Lcom/bytedance/trae/im/network/INetworkDepend;->Companion Lcom/bytedance/trae/im/network/INetworkDepend$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/im/network/INetworkDepend$Companion;->getInstance()Lcom/bytedance/trae/im/network/INetworkDepend;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/im/network/INetworkDepend;->checkAlive()V
    iget-boolean v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->hasEnteredBackground Z
    if-eqz v0, +012h
    iput-boolean v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->hasEnteredBackground Z
    iget-object v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->viewModel Lcom/bytedance/trae/conversation/ConversationViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ConversationViewModel;->refreshMessagesOnResume()V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->com_bytedance_trae_conversation_ConversationActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    return-void 
.end method

.method public final setInitialChatMode(com.bytedance.trae.conversation.widget.ChatMode)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/ConversationActivity;->initialChatMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    return-void 
.end method

.method public final submitMessages(java.util.List)void
    .registers 9
    # ins_size=2
    const-string v0, "messages"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v7, Lcom/bytedance/trae/conversation/ConversationActivity;->getDetailFragment()Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
    move-result-object v1
    if-eqz v1, +00ah
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    move-object v2, v8
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->submitMessages$default(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; Ljava/util/List; Z Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)V
    return-void 
.end method
