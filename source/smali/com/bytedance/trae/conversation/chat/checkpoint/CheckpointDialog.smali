# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
.super Landroidx/fragment/app/Fragment;
.source "CheckpointDialog.kt"

.field private static final CHECK_POINT_TAG:Ljava/lang/String;
.field private static final CLOSE_BUTTON_LEGACY_SHADOW_ELEVATION_DP:F
.field private static final CLOSE_BUTTON_SHADOW_ALPHA:I
.field private static final CLOSE_BUTTON_SHADOW_ELEVATION_DP:F
.field public static final Companion:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$Companion;
.field private static final INPUT_MAX_LENGTH:I
.field private static final OTHER_OPTION_ID:Ljava/lang/String;
.field private static final QUESTION_COLLAPSED_FULL_LINES:I
.field private static final QUESTION_COLLAPSED_TEXT_LENGTH_THRESHOLD:I
.field private static final QUESTION_LINE_HEIGHT_DP:I
.field private static final QUESTION_PARTIAL_VISIBLE_LINE_RATIO:F
.field private static final SINGLE_SELECT_FEEDBACK_MS:J
.field public static final TAG:Ljava/lang/String;
.field private actionGroup:Landroid/widget/LinearLayout;
.field private btnCancel:Landroid/widget/TextView;
.field private btnClose:Landroid/widget/FrameLayout;
.field private btnCustomSend:Landroid/widget/FrameLayout;
.field private btnHeaderNext:Landroid/widget/FrameLayout;
.field private btnHeaderPrev:Landroid/widget/FrameLayout;
.field private btnNext:Landroid/widget/TextView;
.field private btnPrev:Landroid/widget/TextView;
.field private callback:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;
.field private confirmInfo:Lcom/bytedance/trae/im/model/ConfirmInfo;
.field private contentView:Landroid/view/View;
.field private conversationId:Ljava/lang/String;
.field private currentPageIndex:I
.field private customCheckContainer:Landroid/widget/FrameLayout;
.field private etCustomAnswer:Landroid/widget/EditText;
.field private headerNavGroup:Landroid/widget/LinearLayout;
.field private inputContainer:Landroid/view/View;
.field private ivCustomCheck:Landroid/widget/ImageView;
.field private ivCustomEdit:Landroid/widget/ImageView;
.field private ivCustomSend:Landroid/widget/ImageView;
.field private ivHeaderNext:Landroid/widget/ImageView;
.field private ivHeaderPrev:Landroid/widget/ImageView;
.field private normalContent:Landroid/widget/LinearLayout;
.field private onDismissAction:Lkotlin/jvm/functions/Function0;
.field private onFileClick:Lkotlin/jvm/functions/Function1;
.field private optionAdapter:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;
.field private final pageResults:Ljava/util/List;
.field private pages:Ljava/util/List;
.field private planItem:Lcom/bytedance/trae/im/model/ParsedPlanItem;
.field private questionLayoutListener:Landroid/view/View$OnLayoutChangeListener;
.field private questionsJson:Ljava/lang/String;
.field private resolvedPluginDisplayName:Ljava/lang/String;
.field private rvOptions:Landroidx/recyclerview/widget/RecyclerView;
.field private taskId:Ljava/lang/String;
.field private tvProgress:Landroid/widget/TextView;
.field private tvQuestion:Landroid/widget/TextView;
.field private tvScrollView:Landroidx/core/widget/NestedScrollView;


.method public static synthetic $r8$lambda$2HhP9VyTeX5y-QAjauoMJxD8AnM(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->setupListeners$lambda$5(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$2RzkrqtJv6oV56Fo90jLLjSTrDQ(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->addCustomInputView$lambda$28(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$9ImfTdc9k4EAGDqNhufoVfjPO3U(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->renderPage$lambda$19(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$GtYqybLUIljRoy_F1Fx6ukpdo6k(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->setupListeners$lambda$7(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$OOVLldU9yqqrV6UEXV-cNCGAVo0(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  android.widget.TextView  int  android.view.KeyEvent)boolean
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->addCustomInputView$lambda$26(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Landroid/widget/TextView; I Landroid/view/KeyEvent;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$TAuc11XNB2FuO2uVHInJt1e74fo(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  com.bytedance.trae.im.model.ParsedPlanItem  java.lang.String  android.view.View)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->setupListeners$lambda$3(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$UcmYprq0ZYUtpx5DektT_vxgq0E(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  int)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->renderPage$lambda$17$lambda$16(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; I)V
    return-void 
.end method

.method public static synthetic $r8$lambda$UirLPKGaeg-he9YCYED_V71UIOs(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  com.bytedance.trae.conversation.chat.checkpoint.CheckpointPage  android.view.View  boolean)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->addCustomInputView$lambda$25(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage; Landroid/view/View; Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$XIP0rIlVmOzRJ-ysWVM53RL3UEY(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  com.bytedance.trae.conversation.chat.checkpoint.CheckpointPage  com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator  boolean)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->renderPage$lambda$15(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage; Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Z)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$XK5N6GxihGptZzszUkxv5vAM9UU(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  int  com.bytedance.trae.conversation.chat.checkpoint.CheckpointOption)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->renderPage$lambda$17(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; I Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ZNnxbRc8H0IExWCbV5NizaHvj1g(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  com.bytedance.trae.im.model.ParsedPlanItem  java.lang.String  android.view.View)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->setupListeners$lambda$2(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$aDOwuz9Qtbx0OS2aD3sPSS8I6tU(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->setupQuestionScrolling$lambda$1(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$bdDGUdPLh_H7sx-3cAeJ1cpMTCQ(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  java.lang.String  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->renderPage$lambda$21(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$nQ56IE66cQD9EiZyk_Cyn3qrlI8(android.widget.EditText)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->showKeyboard$lambda$29(Landroid/widget/EditText;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$pQ2hPJr_IhSq1Z8uu0ZrFiLUe4I(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  java.lang.String  com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$setQuestionText$listener$1)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->setQuestionText$lambda$22(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$setQuestionText$listener$1;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$sGC_DgNrIr42pLc54JlBIPq4k0I(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->setupListeners$lambda$4(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$v1FsxLQ-U66ldDmTNlPfxEqhk8k(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->renderPage$lambda$20(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$xYe4IFoo1f7YUf8_6OrD1keZChU(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->addCustomInputView$lambda$27(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$z35a0enCixqcDvDC_dcYk-81gjw(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->setupListeners$lambda$6(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->Companion Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Landroidx/fragment/app/Fragment;-><init>()V
    const-string v0, ""
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->taskId Ljava/lang/String;
    const-string v0, "[]"
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->questionsJson Ljava/lang/String;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pages Ljava/util/List;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pageResults Ljava/util/List;
    return-void 
.end method

.method public static final synthetic access$applyQuestionViewportIfReady(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  java.lang.String)boolean
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->applyQuestionViewportIfReady(Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$clearSingleSelectionForCustomInputIfNeeded(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  com.bytedance.trae.conversation.chat.checkpoint.CheckpointPage)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->clearSingleSelectionForCustomInputIfNeeded(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;)V
    return-void 
.end method

.method public static final synthetic access$dismiss(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->dismiss()V
    return-void 
.end method

.method public static final synthetic access$getQuestionLayoutListener$p(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog)android.view.View$OnLayoutChangeListener
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->questionLayoutListener Landroid/view/View$OnLayoutChangeListener;
    return-object v0
.end method

.method public static final synthetic access$getTvQuestion$p(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog)android.widget.TextView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    return-object v0
.end method

.method public static final synthetic access$setCallback$p(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  com.bytedance.trae.conversation.chat.checkpoint.CheckpointInteractionCallback)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->callback Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;
    return-void 
.end method

.method public static final synthetic access$setConfirmInfo$p(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  com.bytedance.trae.im.model.ConfirmInfo)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->confirmInfo Lcom/bytedance/trae/im/model/ConfirmInfo;
    return-void 
.end method

.method public static final synthetic access$setConversationId$p(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->conversationId Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setOnDismissAction$p(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->onDismissAction Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public static final synthetic access$setOnFileClick$p(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->onFileClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public static final synthetic access$setPages$p(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  java.util.List)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pages Ljava/util/List;
    return-void 
.end method

.method public static final synthetic access$setPlanItem$p(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  com.bytedance.trae.im.model.ParsedPlanItem)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->planItem Lcom/bytedance/trae/im/model/ParsedPlanItem;
    return-void 
.end method

.method public static final synthetic access$setQuestionLayoutListener$p(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  android.view.View$OnLayoutChangeListener)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->questionLayoutListener Landroid/view/View$OnLayoutChangeListener;
    return-void 
.end method

.method public static final synthetic access$setQuestionsJson$p(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->questionsJson Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setTaskId$p(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->taskId Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$updateActionArea(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  com.bytedance.trae.conversation.chat.checkpoint.CheckpointPage  com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator  boolean)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->updateActionArea(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage; Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Z)V
    return-void 
.end method

.method public static final synthetic access$updateCustomInputState(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  com.bytedance.trae.conversation.chat.checkpoint.CheckpointPage)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->updateCustomInputState(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;)V
    return-void 
.end method

.method private final addCustomInputView(com.bytedance.trae.conversation.chat.checkpoint.CheckpointPage  java.lang.String  com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator  boolean)void
    .registers 14
    # ins_size=5
    invoke-direct v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->removeCustomInputView()V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->requireContext()Landroid/content/Context;
    move-result-object v0
    invoke-static v0, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$layout;->trae_item_checkpoint_input I
    iget-object v2, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->rvOptions Landroidx/recyclerview/widget/RecyclerView;
    const/4 v3, 0
    const-string/jumbo v4, rvOptions
    if-nez v2, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v3
    invoke-virtual v2, Landroidx/recyclerview/widget/RecyclerView;->getParent()Landroid/view/ViewParent;
    move-result-object v2
    const-string v5, "null cannot be cast to non-null type android.view.ViewGroup"
    invoke-static v2, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/view/ViewGroup;
    const/4 v6, 0
    invoke-virtual v0, v1, v2, v6, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v0
    iput-object v0, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->inputContainer Landroid/view/View;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->et_custom_answer I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/EditText;
    iput-object v1, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->etCustomAnswer Landroid/widget/EditText;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_custom_send I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/FrameLayout;
    iput-object v1, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnCustomSend Landroid/widget/FrameLayout;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->checkbox_container I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/FrameLayout;
    iput-object v1, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->customCheckContainer Landroid/widget/FrameLayout;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_custom_edit I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/ImageView;
    iput-object v1, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->ivCustomEdit Landroid/widget/ImageView;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_check I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/ImageView;
    iput-object v1, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->ivCustomCheck Landroid/widget/ImageView;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_custom_send I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/ImageView;
    iput-object v1, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->ivCustomSend Landroid/widget/ImageView;
    if-eqz v11, +00bh
    iget-object v1, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->etCustomAnswer Landroid/widget/EditText;
    if-eqz v1, +007h
    check-cast v11, Ljava/lang/CharSequence;
    invoke-virtual v1, v11, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V
    iget-object v11, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->etCustomAnswer Landroid/widget/EditText;
    const/4 v1, 1
    if-eqz v11, +012h
    new-array v2, v1, [Landroid/text/InputFilter$LengthFilter;
    new-instance v7, Landroid/text/InputFilter$LengthFilter;
    const/16 v8, 500
    invoke-direct v7, v8, Landroid/text/InputFilter$LengthFilter;-><init>(I)V
    aput-object v7, v2, v6
    check-cast v2, [Landroid/text/InputFilter;
    invoke-virtual v11, v2, Landroid/widget/EditText;->setFilters([Landroid/text/InputFilter;)V
    iget-object v11, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->etCustomAnswer Landroid/widget/EditText;
    if-eqz v11, +00ah
    new-instance v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda15;
    invoke-direct v2, v9, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda15;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;)V
    invoke-virtual v11, v2, Landroid/widget/EditText;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V
    iget-object v11, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->etCustomAnswer Landroid/widget/EditText;
    if-eqz v11, +00ch
    new-instance v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$addCustomInputView$3;
    invoke-direct v2, v9, v10, v12, v13, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$addCustomInputView$3;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage; Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Z)V
    check-cast v2, Landroid/text/TextWatcher;
    invoke-virtual v11, v2, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V
    iget-object v11, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->etCustomAnswer Landroid/widget/EditText;
    if-eqz v11, +00ah
    new-instance v12, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda16;
    invoke-direct v12, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda16;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;)V
    invoke-virtual v11, v12, Landroid/widget/EditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V
    iget-object v11, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnCustomSend Landroid/widget/FrameLayout;
    if-eqz v11, +00ah
    new-instance v12, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda17;
    invoke-direct v12, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda17;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;)V
    invoke-virtual v11, v12, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v11, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda18;
    invoke-direct v11, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda18;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;)V
    invoke-virtual v0, v11, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v11, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->rvOptions Landroidx/recyclerview/widget/RecyclerView;
    if-nez v11, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v11, v3
    invoke-virtual v11, Landroidx/recyclerview/widget/RecyclerView;->getParent()Landroid/view/ViewParent;
    move-result-object v11
    invoke-static v11, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v11, Landroid/view/ViewGroup;
    iget-object v12, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->rvOptions Landroidx/recyclerview/widget/RecyclerView;
    if-nez v12, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v12
    check-cast v3, Landroid/view/View;
    invoke-virtual v11, v3, Landroid/view/ViewGroup;->indexOfChild(Landroid/view/View;)I
    move-result v12
    add-int/2addr v12, v1
    invoke-virtual v11, v0, v12, Landroid/view/ViewGroup;->addView(Landroid/view/View; I)V
    invoke-direct v9, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->clearSingleSelectionForCustomInputIfNeeded(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;)V
    invoke-direct v9, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->updateCustomInputState(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;)V
    return-void 
.end method

.method private static final addCustomInputView$lambda$25(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  com.bytedance.trae.conversation.chat.checkpoint.CheckpointPage  android.view.View  boolean)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->updateCustomInputState(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;)V
    return-void 
.end method

.method private static final addCustomInputView$lambda$26(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  android.widget.TextView  int  android.view.KeyEvent)boolean
    .registers 4
    # ins_size=4
    const/4 v1, 4
    const/4 v3, 0
    if-ne v2, v1, +016h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnCustomSend Landroid/widget/FrameLayout;
    const/4 v2, 1
    if-eqz v1, +00ah
    invoke-virtual v1, Landroid/widget/FrameLayout;->isEnabled()Z
    move-result v1
    if-ne v1, v2, +004h
    move v1, v2
    goto +2h
    move v1, v3
    if-eqz v1, +006h
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->submitCustomInput()V
    move v3, v2
    return v3
.end method

.method private static final addCustomInputView$lambda$27(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnCustomSend Landroid/widget/FrameLayout;
    const/4 v0, 0
    if-eqz v3, +00ah
    invoke-virtual v3, Landroid/widget/FrameLayout;->isEnabled()Z
    move-result v3
    const/4 v1, 1
    if-ne v3, v1, +003h
    move v0, v1
    if-eqz v0, +005h
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->submitCustomInput()V
    return-void 
.end method

.method private static final addCustomInputView$lambda$28(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->etCustomAnswer Landroid/widget/EditText;
    if-eqz v1, +005h
    invoke-virtual v1, Landroid/widget/EditText;->requestFocus()Z
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->etCustomAnswer Landroid/widget/EditText;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->showKeyboard(Landroid/widget/EditText;)V
    return-void 
.end method

.method private final advanceToNextPageOrSubmit()void
    .registers 16
    # ins_size=1
    iget-object v0, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->planItem Lcom/bytedance/trae/im/model/ParsedPlanItem;
    const/4 v1, 0
    if-eqz v0, +00eh
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v2
    if-eqz v2, +008h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v2
    move-object v5, v2
    goto +2h
    move-object v5, v1
    iget v2, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->currentPageIndex I
    iget-object v3, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pages Ljava/util/List;
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v3
    const/4 v4, 1
    sub-int/2addr v3, v4
    const-string v6, "CheckPointDialog"
    if-ge v2, v3, +024h
    iget v0, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->currentPageIndex I
    add-int/2addr v0, v4
    iput v0, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->currentPageIndex I
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[Dialog] advanceToNextPage: page="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v2, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->currentPageIndex I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v6, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget v0, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->currentPageIndex I
    invoke-direct v15, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->renderPage(I)V
    goto/16 +20dh
    iget-object v2, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pages Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +014h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    move-object v8, v7
    check-cast v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->isSupplementaryPage()Z
    move-result v8
    xor-int/2addr v8, v4
    if-eqz v8, -012h
    invoke-interface v3, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -17h
    check-cast v3, Ljava/util/List;
    iget-object v2, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pages Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +010h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    move-object v8, v7
    check-cast v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->isSupplementaryPage()Z
    move-result v8
    if-eqz v8, -011h
    goto +2h
    move-object v7, v1
    check-cast v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    if-eqz v7, +018h
    iget-object v2, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pages Ljava/util/List;
    invoke-interface v2, v7, Ljava/util/List;->indexOf(Ljava/lang/Object;)I
    move-result v2
    iget-object v7, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pageResults Ljava/util/List;
    invoke-static v7, v2, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPageResult;
    if-eqz v2, +008h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPageResult;->getCustomInput()Ljava/lang/String;
    move-result-object v2
    move-object v10, v2
    goto +2h
    move-object v10, v1
    iget-object v2, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pageResults Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    instance-of v7, v2, Ljava/util/Collection;
    const/4 v8, 0
    if-eqz v7, +00dh
    move-object v7, v2
    check-cast v7, Ljava/util/Collection;
    invoke-interface v7, Ljava/util/Collection;->isEmpty()Z
    move-result v7
    if-eqz v7, +004h
    move v2, v8
    goto +39h
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, -00ah
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPageResult;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPageResult;->getSelectedLabels()Ljava/util/List;
    move-result-object v9
    check-cast v9, Ljava/util/Collection;
    invoke-interface v9, Ljava/util/Collection;->isEmpty()Z
    move-result v9
    xor-int/2addr v9, v4
    if-nez v9, +019h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPageResult;->getCustomInput()Ljava/lang/String;
    move-result-object v7
    check-cast v7, Ljava/lang/CharSequence;
    if-eqz v7, +00bh
    invoke-static v7, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v7
    if-eqz v7, +003h
    goto +3h
    move v7, v8
    goto +2h
    move v7, v4
    if-nez v7, +003h
    goto +3h
    move v7, v8
    goto +2h
    move v7, v4
    if-eqz v7, -031h
    move v2, v4
    const-string v7, ""
    const-string v9, ", toolName="
    if-nez v2, +07bh
    move-object v2, v3
    check-cast v2, Ljava/lang/Iterable;
    instance-of v11, v2, Ljava/util/Collection;
    if-eqz v11, +00dh
    move-object v11, v2
    check-cast v11, Ljava/util/Collection;
    invoke-interface v11, Ljava/util/Collection;->isEmpty()Z
    move-result v11
    if-eqz v11, +004h
    move v2, v4
    goto +1ch
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, -00ah
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->getOptions()Ljava/util/List;
    move-result-object v11
    invoke-interface v11, Ljava/util/List;->isEmpty()Z
    move-result v11
    if-nez v11, -014h
    move v2, v8
    if-eqz v2, +04ch
    if-nez v10, +04ah
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[Dialog] submit: Confirm (no answers), planItemId="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getId()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v1
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v6, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v2, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->callback Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;
    if-eqz v2, +0feh
    new-instance v11, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Confirm;
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getId()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v4, v7
    goto +2h
    move-object v4, v1
    iget-object v6, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->taskId Ljava/lang/String;
    iget-object v7, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->conversationId Ljava/lang/String;
    const/4 v8, 0
    const/16 v9, 16
    const/4 v10, 0
    move-object v3, v11
    invoke-direct/range v3 ... v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Confirm;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v11, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    invoke-interface v2, v11, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;->onDecision(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;)V
    goto/16 +0deh
    check-cast v3, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    const/16 v11, 10
    invoke-static v3, v11, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v11
    invoke-direct v2, v11, Ljava/util/ArrayList;-><init>(I)V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    move v11, v8
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v12
    if-eqz v12, +061h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v12
    add-int/lit8 v13, v11, 1
    if-gez v11, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v12, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    iget-object v14, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pageResults Ljava/util/List;
    invoke-static v14, v11, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPageResult;
    if-eqz v11, +008h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPageResult;->getSelectedLabels()Ljava/util/List;
    move-result-object v14
    if-nez v14, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v14
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPageResult;->getCustomInput()Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v1
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->getOptions()Ljava/util/List;
    move-result-object v12
    check-cast v12, Ljava/util/Collection;
    invoke-interface v12, Ljava/util/Collection;->isEmpty()Z
    move-result v12
    xor-int/2addr v12, v4
    if-eqz v12, +021h
    move-object v12, v11
    check-cast v12, Ljava/lang/CharSequence;
    if-eqz v12, +00bh
    invoke-static v12, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v12
    if-eqz v12, +003h
    goto +3h
    move v12, v8
    goto +2h
    move v12, v4
    if-nez v12, +010h
    check-cast v14, Ljava/util/Collection;
    const-string v12, "__other__"
    invoke-static v14, v12, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection; Ljava/lang/Object;)Ljava/util/List;
    move-result-object v12
    check-cast v12, Ljava/lang/Iterable;
    invoke-static v12, Lkotlin/collections/CollectionsKt;->distinct(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v14
    new-instance v12, Lcom/bytedance/trae/conversation/chat/checkpoint/AnswerEntry;
    invoke-direct v12, v14, v11, Lcom/bytedance/trae/conversation/chat/checkpoint/AnswerEntry;-><init>(Ljava/util/List; Ljava/lang/String;)V
    invoke-interface v2, v12, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    move v11, v13
    goto -64h
    check-cast v2, Ljava/util/List;
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v11, Ljava/lang/StringBuilder;
    const-string v12, "[Dialog] submit: SubmitAnswer, planItemId="
    invoke-direct v11, v12, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getId()Ljava/lang/String;
    move-result-object v12
    goto +2h
    move-object v12, v1
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v11, ", answers="
    invoke-virtual v9, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v11
    invoke-virtual v9, v11, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v11, ", supplementary="
    invoke-virtual v9, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    if-eqz v10, +003h
    goto +2h
    move v4, v8
    invoke-virtual v9, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v6, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v11, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->callback Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;
    if-eqz v11, +01fh
    new-instance v12, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getId()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v4, v7
    goto +2h
    move-object v4, v1
    iget-object v6, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->taskId Ljava/lang/String;
    iget-object v7, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->conversationId Ljava/lang/String;
    iget-object v8, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->questionsJson Ljava/lang/String;
    move-object v3, v12
    move-object v9, v2
    invoke-direct/range v3 ... v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Ljava/lang/String;)V
    check-cast v12, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    invoke-interface v11, v12, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;->onDecision(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;)V
    invoke-direct v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->dismiss()V
    return-void 
.end method

.method private final applyCloseButtonShadow()void
    .registers 7
    # ins_size=1
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v1, 28
    if-lt v0, v1, +005h
    const/high16 v0, 1084227584
    goto +3h
    const/high16 v0, 1073741824
    iget-object v2, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnClose Landroid/widget/FrameLayout;
    const/4 v3, 0
    const-string v4, "btnClose"
    if-nez v2, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v3
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    invoke-virtual v5, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v5
    iget v5, v5, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v0, v5
    invoke-virtual v2, v0, Landroid/widget/FrameLayout;->setElevation(F)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnClose Landroid/widget/FrameLayout;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    const/4 v2, 0
    invoke-virtual v0, v2, Landroid/widget/FrameLayout;->setTranslationZ(F)V
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    if-lt v0, v1, +020h
    const/16 v0, 13
    const/4 v1, 0
    invoke-static v0, v1, v1, v1, Landroid/graphics/Color;->argb(I I I I)I
    move-result v0
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnClose Landroid/widget/FrameLayout;
    if-nez v1, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    invoke-virtual v1, v0, Landroid/widget/FrameLayout;->setOutlineAmbientShadowColor(I)V
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnClose Landroid/widget/FrameLayout;
    if-nez v1, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v1
    invoke-virtual v3, v0, Landroid/widget/FrameLayout;->setOutlineSpotShadowColor(I)V
    return-void 
.end method

.method private final applyFigmaTextMetrics()void
    .registers 6
    # ins_size=1
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    iget-object v1, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    const-string/jumbo v2, tvQuestion
    const/4 v3, 0
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    sget-object v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;->INSTANCE Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;->defaultMedium()Landroid/graphics/Typeface;
    move-result-object v4
    invoke-virtual v1, v4, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    iget-object v1, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    const/16 v2, 24
    int-to-float v2, v2
    mul-float/2addr v2, v0
    float-to-int v2, v2
    invoke-static v1, v2, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    iget-object v1, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvProgress Landroid/widget/TextView;
    if-nez v1, +009h
    const-string/jumbo v1, tvProgress
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v3
    const/16 v2, 20
    int-to-float v2, v2
    mul-float/2addr v2, v0
    float-to-int v0, v2
    invoke-static v1, v0, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    const/4 v1, 3
    new-array v1, v1, [Landroid/widget/TextView;
    iget-object v2, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnCancel Landroid/widget/TextView;
    if-nez v2, +008h
    const-string v2, "btnCancel"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v3
    const/4 v4, 0
    aput-object v2, v1, v4
    iget-object v2, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnPrev Landroid/widget/TextView;
    if-nez v2, +008h
    const-string v2, "btnPrev"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v3
    const/4 v4, 1
    aput-object v2, v1, v4
    iget-object v2, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnNext Landroid/widget/TextView;
    if-nez v2, +008h
    const-string v2, "btnNext"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v2
    const/4 v2, 2
    aput-object v3, v1, v2
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +015h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Landroid/widget/TextView;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;->INSTANCE Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;->defaultMedium()Landroid/graphics/Typeface;
    move-result-object v3
    invoke-virtual v2, v3, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    invoke-static v2, v0, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    goto -18h
    return-void 
.end method

.method private final applyQuestionCollapsedViewport()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, tvQuestion
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    check-cast v0, Landroid/view/View;
    const/4 v2, -2
    invoke-direct v4, v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->setViewHeight(Landroid/view/View; I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    const-string/jumbo v2, tvScrollView
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    check-cast v0, Landroid/view/View;
    invoke-direct v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->questionCollapsedHeightPx()I
    move-result v3
    invoke-direct v4, v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->setViewHeight(Landroid/view/View; I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v3, 1
    invoke-virtual v0, v3, Landroidx/core/widget/NestedScrollView;->setVerticalFadingEdgeEnabled(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    const/16 v0, 24
    invoke-direct v4, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->dp(I)I
    move-result v0
    invoke-virtual v1, v0, Landroidx/core/widget/NestedScrollView;->setFadingEdgeLength(I)V
    return-void 
.end method

.method private final applyQuestionViewportIfReady(java.lang.String)boolean
    .registers 7
    # ins_size=2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->isAdded()Z
    move-result v0
    const/4 v1, 1
    if-eqz v0, +06dh
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    const-string/jumbo v2, tvQuestion
    const/4 v3, 0
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    invoke-virtual v0, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v3
    invoke-static v0, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +003h
    goto +4dh
    iget-object v6, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    if-nez v6, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v3
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->measureNaturalLineCount(Landroid/widget/TextView;)I
    move-result v6
    const/4 v0, 0
    if-gtz v6, +003h
    return v0
    const/4 v4, 5
    if-le v6, v4, +006h
    invoke-direct v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->applyQuestionCollapsedViewport()V
    goto +36h
    iget-object v6, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    if-nez v6, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v3
    invoke-virtual v6, v0, Landroid/widget/TextView;->setVerticalFadingEdgeEnabled(Z)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    const-string/jumbo v4, tvScrollView
    if-nez v6, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v3
    invoke-virtual v6, v0, Landroidx/core/widget/NestedScrollView;->setVerticalFadingEdgeEnabled(Z)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    if-nez v6, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v3
    check-cast v6, Landroid/view/View;
    const/4 v0, -2
    invoke-direct v5, v6, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->setViewHeight(Landroid/view/View; I)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    if-nez v6, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v6
    check-cast v3, Landroid/view/View;
    invoke-direct v5, v3, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->setViewHeight(Landroid/view/View; I)V
    return v1
.end method

.method private final bindViews(android.view.View)void
    .registers 5
    # ins_size=2
    sget v0, Lcom/bytedance/trae/conversation/R$id;->normal_content I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const-string v1, "findViewById(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/LinearLayout;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->normalContent Landroid/widget/LinearLayout;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->header_nav_group I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/LinearLayout;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->headerNavGroup Landroid/widget/LinearLayout;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_progress I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvProgress Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_question I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->title_scroll_view I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroidx/core/widget/NestedScrollView;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->rv_options I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->rvOptions Landroidx/recyclerview/widget/RecyclerView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_header_prev I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/FrameLayout;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnHeaderPrev Landroid/widget/FrameLayout;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_header_next I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/FrameLayout;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnHeaderNext Landroid/widget/FrameLayout;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_header_prev I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ImageView;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->ivHeaderPrev Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_header_next I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ImageView;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->ivHeaderNext Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_close I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/FrameLayout;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnClose Landroid/widget/FrameLayout;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_cancel I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnCancel Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_prev I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnPrev Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_next I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnNext Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->action_group I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Landroid/widget/LinearLayout;
    iput-object v4, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->actionGroup Landroid/widget/LinearLayout;
    iget-object v4, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->rvOptions Landroidx/recyclerview/widget/RecyclerView;
    const/4 v0, 0
    if-nez v4, +009h
    const-string/jumbo v4, rvOptions
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v0
    new-instance v1, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->requireContext()Landroid/content/Context;
    move-result-object v2
    invoke-direct v1, v2, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v4, v1, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->normalContent Landroid/widget/LinearLayout;
    const-string v1, "normalContent"
    if-nez v4, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v0
    const/4 v2, 0
    invoke-virtual v4, v2, Landroid/widget/LinearLayout;->setClipChildren(Z)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->normalContent Landroid/widget/LinearLayout;
    if-nez v4, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v4
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setClipToPadding(Z)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->applyCloseButtonShadow()V
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->applyFigmaTextMetrics()V
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->setupQuestionScrolling()V
    return-void 
.end method

.method private final clearSingleSelectionForCustomInputIfNeeded(com.bytedance.trae.conversation.chat.checkpoint.CheckpointPage)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->etCustomAnswer Landroid/widget/EditText;
    if-eqz v0, +00dh
    invoke-virtual v0, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 1
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    move v0, v1
    xor-int/2addr v0, v1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->getMultiSelect()Z
    move-result v3
    if-nez v3, +00bh
    if-eqz v0, +009h
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->optionAdapter Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;
    if-eqz v3, +005h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->clearSelection()Z
    return-void 
.end method

.method private final dismiss()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "CheckPointDialog"
    const-string v2, "[Dialog] dismiss"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->onDismissAction Lkotlin/jvm/functions/Function0;
    const/4 v1, 0
    iput-object v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->onDismissAction Lkotlin/jvm/functions/Function0;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    invoke-virtual v1, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v1
    move-object v2, v3
    check-cast v2, Landroidx/fragment/app/Fragment;
    invoke-virtual v1, v2, Landroidx/fragment/app/FragmentTransaction;->remove(Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v1
    invoke-virtual v1, Landroidx/fragment/app/FragmentTransaction;->commitAllowingStateLoss()I
    if-eqz v0, +005h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private final dp(int)int
    .registers 3
    # ins_size=2
    int-to-float v2, v2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v2, v0
    float-to-int v2, v2
    return v2
.end method

.method private final handleBackPress()void
    .registers 7
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[Dialog] handleBackPress: planItemId="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->planItem Lcom/bytedance/trae/im/model/ParsedPlanItem;
    const/4 v3, 0
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getId()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v3
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", toolName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->planItem Lcom/bytedance/trae/im/model/ParsedPlanItem;
    if-eqz v2, +00dh
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v3
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "CheckPointDialog"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->planItem Lcom/bytedance/trae/im/model/ParsedPlanItem;
    if-eqz v0, +00dh
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v3
    iget-object v2, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->callback Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;
    if-eqz v2, +01ah
    new-instance v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Skip;
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getId()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +004h
    const-string v3, ""
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->taskId Ljava/lang/String;
    iget-object v5, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->conversationId Ljava/lang/String;
    invoke-direct v4, v3, v1, v0, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Skip;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    check-cast v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    invoke-interface v2, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;->onDecision(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->dismiss()V
    return-void 
.end method

.method private final hideKeyboard(android.view.View)void
    .registers 4
    # ins_size=2
    invoke-virtual v3, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    const-string v1, "input_method"
    invoke-virtual v0, v1, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Landroid/view/inputmethod/InputMethodManager;
    if-eqz v1, +005h
    check-cast v0, Landroid/view/inputmethod/InputMethodManager;
    goto +2h
    const/4 v0, 0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v1
    if-eqz v1, +00eh
    invoke-virtual v1, Landroidx/fragment/app/FragmentActivity;->getCurrentFocus()Landroid/view/View;
    move-result-object v1
    if-eqz v1, +008h
    invoke-virtual v1, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;
    move-result-object v1
    if-nez v1, +006h
    invoke-virtual v3, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;
    move-result-object v1
    if-eqz v0, +006h
    const/4 v3, 0
    invoke-virtual v0, v1, v3, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder; I)Z
    return-void 
.end method

.method private final measureNaturalLineCount(android.widget.TextView)int
    .registers 7
    # ins_size=2
    invoke-virtual v6, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;
    move-result-object v0
    const/4 v1, 0
    if-nez v0, +003h
    return v1
    invoke-virtual v6, Landroid/widget/TextView;->getWidth()I
    move-result v2
    invoke-virtual v6, Landroid/widget/TextView;->getCompoundPaddingLeft()I
    move-result v3
    sub-int/2addr v2, v3
    invoke-virtual v6, Landroid/widget/TextView;->getCompoundPaddingRight()I
    move-result v3
    sub-int/2addr v2, v3
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +004h
    const/4 v3, 1
    goto +2h
    move v3, v1
    if-nez v3, +037h
    if-gtz v2, +003h
    goto +33h
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v3
    invoke-virtual v6, Landroid/widget/TextView;->getPaint()Landroid/text/TextPaint;
    move-result-object v4
    invoke-static v0, v1, v3, v4, v2, Landroid/text/StaticLayout$Builder;->obtain(Ljava/lang/CharSequence; I I Landroid/text/TextPaint; I)Landroid/text/StaticLayout$Builder;
    move-result-object v0
    sget-object v1, Landroid/text/Layout$Alignment;->ALIGN_NORMAL Landroid/text/Layout$Alignment;
    invoke-virtual v0, v1, Landroid/text/StaticLayout$Builder;->setAlignment(Landroid/text/Layout$Alignment;)Landroid/text/StaticLayout$Builder;
    move-result-object v0
    invoke-virtual v6, Landroid/widget/TextView;->getIncludeFontPadding()Z
    move-result v1
    invoke-virtual v0, v1, Landroid/text/StaticLayout$Builder;->setIncludePad(Z)Landroid/text/StaticLayout$Builder;
    move-result-object v0
    invoke-virtual v6, Landroid/widget/TextView;->getLineSpacingExtra()F
    move-result v1
    invoke-virtual v6, Landroid/widget/TextView;->getLineSpacingMultiplier()F
    move-result v6
    invoke-virtual v0, v1, v6, Landroid/text/StaticLayout$Builder;->setLineSpacing(F F)Landroid/text/StaticLayout$Builder;
    move-result-object v6
    invoke-virtual v6, Landroid/text/StaticLayout$Builder;->build()Landroid/text/StaticLayout;
    move-result-object v6
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v6, Landroid/text/StaticLayout;->getLineCount()I
    move-result v6
    return v6
    return v1
.end method

.method private final navigateToPreviousPage()void
    .registers 5
    # ins_size=1
    iget v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->currentPageIndex I
    const-string v1, "CheckPointDialog"
    if-lez v0, +033h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "[Dialog] previous clicked, page "
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->currentPageIndex I
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, " -> "
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->currentPageIndex I
    add-int/lit8 v3, v3, -1
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->saveCurrentPageResult()V
    iget v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->currentPageIndex I
    add-int/lit8 v0, v0, -1
    iput v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->currentPageIndex I
    invoke-direct v4, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->renderPage(I)V
    goto +8h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "[Dialog] previous clicked, already at first page"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final questionCollapsedHeightPx()int
    .registers 3
    # ins_size=1
    const/16 v0, 24
    int-to-float v0, v0
    const/high16 v1, 1085800448
    mul-float/2addr v0, v1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v0, v1
    float-to-int v0, v0
    return v0
.end method

.method private final removeContentView()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->contentView Landroid/view/View;
    const/4 v1, 0
    if-eqz v0, +013h
    invoke-virtual v0, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v2
    instance-of v3, v2, Landroid/view/ViewGroup;
    if-eqz v3, +005h
    check-cast v2, Landroid/view/ViewGroup;
    goto +2h
    move-object v2, v1
    if-eqz v2, +005h
    invoke-virtual v2, v0, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V
    iput-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->contentView Landroid/view/View;
    return-void 
.end method

.method private final removeCustomInputView()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->inputContainer Landroid/view/View;
    const/4 v1, 0
    if-eqz v0, +013h
    invoke-virtual v0, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v2
    instance-of v3, v2, Landroid/view/ViewGroup;
    if-eqz v3, +005h
    check-cast v2, Landroid/view/ViewGroup;
    goto +2h
    move-object v2, v1
    if-eqz v2, +005h
    invoke-virtual v2, v0, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V
    iput-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->inputContainer Landroid/view/View;
    iput-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->etCustomAnswer Landroid/widget/EditText;
    iput-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnCustomSend Landroid/widget/FrameLayout;
    iput-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->customCheckContainer Landroid/widget/FrameLayout;
    iput-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->ivCustomEdit Landroid/widget/ImageView;
    iput-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->ivCustomCheck Landroid/widget/ImageView;
    iput-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->ivCustomSend Landroid/widget/ImageView;
    return-void 
.end method

.method private final renderPage(int)void
    .registers 18
    # ins_size=2
    move-object/from16 v0, v16
    move/from16 v1, v17
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pages Ljava/util/List;
    invoke-interface v2, v1, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->planItem Lcom/bytedance/trae/im/model/ParsedPlanItem;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    if-eqz v3, +009h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->INSTANCE Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;
    invoke-virtual v5, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->getCreator(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
    move-result-object v5
    goto +2h
    const/4 v5, 0
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v6
    goto +2h
    const/4 v6, 0
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v9, "[Dialog] renderPage: index="
    invoke-direct v8, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, ", question="
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->getQuestion()Ljava/lang/String;
    move-result-object v9
    const/16 v10, 50
    invoke-static v9, v10, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v9
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, ", options="
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->getOptions()Ljava/util/List;
    move-result-object v9
    invoke-interface v9, Ljava/util/List;->size()I
    move-result v9
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, ", multiSelect="
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->getMultiSelect()Z
    move-result v9
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, ", allowCustomInput="
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->getAllowCustomInput()Z
    move-result v9
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, ", creator="
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    if-eqz v5, +00dh
    invoke-virtual v5, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v9
    if-eqz v9, +007h
    invoke-virtual v9, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v9
    goto +2h
    const/4 v9, 0
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    const-string v9, "CheckPointDialog"
    invoke-virtual v7, v9, v8, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    const-string v7, "AskUserQuestion"
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    const/4 v8, 1
    const/4 v9, 0
    if-nez v7, +012h
    if-eqz v5, +00ah
    invoke-interface v5, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;->showCloseButton()Z
    move-result v10
    if-ne v10, v8, +004h
    move v10, v8
    goto +2h
    move v10, v9
    if-eqz v10, +003h
    goto +3h
    move v10, v9
    goto +2h
    move v10, v8
    iget-object v11, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnClose Landroid/widget/FrameLayout;
    if-nez v11, +008h
    const-string v11, "btnClose"
    invoke-static v11, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v11, 0
    const/16 v12, 8
    if-eqz v10, +004h
    move v13, v9
    goto +2h
    move v13, v12
    invoke-virtual v11, v13, Landroid/widget/FrameLayout;->setVisibility(I)V
    const-string/jumbo v11, requireContext(...)
    if-eqz v5, +00eh
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->requireContext()Landroid/content/Context;
    move-result-object v13
    invoke-static v13, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v5, v13, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;->getHeaderLabel(Landroid/content/Context;)Ljava/lang/String;
    move-result-object v13
    goto +2h
    const/4 v13, 0
    invoke-direct v0, v13, v7, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->updateHeader(Ljava/lang/String; Z I)V
    if-nez v10, +015h
    iget-object v10, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->headerNavGroup Landroid/widget/LinearLayout;
    if-nez v10, +008h
    const-string v10, "headerNavGroup"
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v10, 0
    invoke-virtual v10, Landroid/widget/LinearLayout;->getVisibility()I
    move-result v10
    if-nez v10, +003h
    goto +3h
    move v10, v9
    goto +2h
    move v10, v8
    invoke-direct v0, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->updateTitleTopMargin(Z)V
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->removeContentView()V
    const-string/jumbo v10, tvScrollView
    const-string/jumbo v13, tvQuestion
    if-eqz v3, +09fh
    if-eqz v5, +09dh
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->requireContext()Landroid/content/Context;
    move-result-object v14
    invoke-static v14, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v5, v14, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;->getTitle(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/lang/String;
    move-result-object v14
    move-object v15, v14
    check-cast v15, Ljava/lang/CharSequence;
    invoke-interface v15, Ljava/lang/CharSequence;->length()I
    move-result v15
    if-nez v15, +004h
    move v15, v8
    goto +2h
    move v15, v9
    if-eqz v15, +02ah
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->getQuestion()Ljava/lang/String;
    move-result-object v15
    check-cast v15, Ljava/lang/CharSequence;
    invoke-interface v15, Ljava/lang/CharSequence;->length()I
    move-result v15
    if-nez v15, +004h
    move v15, v8
    goto +2h
    move v15, v9
    if-eqz v15, +019h
    iget-object v14, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    if-nez v14, +006h
    invoke-static v13, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v14, 0
    invoke-virtual v14, v12, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v14, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    if-nez v14, +006h
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v14, 0
    invoke-virtual v14, v12, Landroidx/core/widget/NestedScrollView;->setVisibility(I)V
    goto +2fh
    iget-object v15, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    if-nez v15, +006h
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v15, 0
    invoke-virtual v15, v9, Landroidx/core/widget/NestedScrollView;->setVisibility(I)V
    iget-object v10, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    if-nez v10, +006h
    invoke-static v13, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v10, 0
    invoke-virtual v10, v9, Landroid/widget/TextView;->setVisibility(I)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->getQuestion()Ljava/lang/String;
    move-result-object v10
    check-cast v10, Ljava/lang/CharSequence;
    invoke-interface v10, Ljava/lang/CharSequence;->length()I
    move-result v10
    if-lez v10, +004h
    move v10, v8
    goto +2h
    move v10, v9
    if-eqz v10, +006h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->getQuestion()Ljava/lang/String;
    move-result-object v14
    invoke-direct v0, v14, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->setQuestionText(Ljava/lang/String;)V
    invoke-interface v5, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;->getTitleTextColorRes()I
    move-result v10
    iget-object v14, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    if-nez v14, +006h
    invoke-static v13, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v14, 0
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->requireContext()Landroid/content/Context;
    move-result-object v15
    if-eqz v10, +003h
    goto +3h
    sget v10, Lcom/bytedance/trae/conversation/R$color;->trae_checkpoint_text_primary I
    invoke-static v15, v10, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v10
    invoke-virtual v14, v10, Landroid/widget/TextView;->setTextColor(I)V
    iget-object v10, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    if-nez v10, +006h
    invoke-static v13, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v10, 0
    invoke-interface v5, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;->getTitleLetterSpacing()F
    move-result v13
    invoke-virtual v10, v13, Landroid/widget/TextView;->setLetterSpacing(F)V
    goto +1eh
    iget-object v14, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    if-nez v14, +006h
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v14, 0
    invoke-virtual v14, v9, Landroidx/core/widget/NestedScrollView;->setVisibility(I)V
    iget-object v10, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    if-nez v10, +006h
    invoke-static v13, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v10, 0
    invoke-virtual v10, v9, Landroid/widget/TextView;->setVisibility(I)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->getQuestion()Ljava/lang/String;
    move-result-object v10
    invoke-direct v0, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->setQuestionText(Ljava/lang/String;)V
    iget-object v10, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pageResults Ljava/util/List;
    invoke-static v10, v1, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPageResult;
    if-eqz v10, +010h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPageResult;->getSelectedLabels()Ljava/util/List;
    move-result-object v13
    if-eqz v13, +00ah
    check-cast v13, Ljava/lang/Iterable;
    invoke-static v13, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v13
    if-nez v13, +006h
    invoke-static Lkotlin/collections/SetsKt;->emptySet()Ljava/util/Set;
    move-result-object v13
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->getOptions()Ljava/util/List;
    move-result-object v14
    check-cast v14, Ljava/lang/Iterable;
    invoke-interface v14, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v14
    invoke-interface v14, Ljava/util/Iterator;->hasNext()Z
    move-result v15
    if-eqz v15, +014h
    invoke-interface v14, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;->getLabel()Ljava/lang/String;
    move-result-object v4
    invoke-interface v13, v4, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v4
    invoke-virtual v15, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;->setSelected(Z)V
    goto -17h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->getOptions()Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    xor-int/2addr v4, v8
    const-string/jumbo v13, rvOptions
    if-eqz v4, +046h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->rvOptions Landroidx/recyclerview/widget/RecyclerView;
    if-nez v4, +006h
    invoke-static v13, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v4, 0
    invoke-virtual v4, v9, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    new-instance v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->getMultiSelect()Z
    move-result v9
    new-instance v12, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda2;
    invoke-direct v12, v0, v2, v5, v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage; Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Z)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->getMultiSelect()Z
    move-result v14
    if-nez v14, +008h
    new-instance v14, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda3;
    invoke-direct v14, v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; I)V
    goto +2h
    const/4 v14, 0
    invoke-direct v4, v9, v12, v14, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;-><init>(Z Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1;)V
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->optionAdapter Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->rvOptions Landroidx/recyclerview/widget/RecyclerView;
    if-nez v1, +006h
    invoke-static v13, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    iget-object v4, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->optionAdapter Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;
    check-cast v4, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v1, v4, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->optionAdapter Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;
    if-eqz v1, +009h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->getOptions()Ljava/util/List;
    move-result-object v4
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->submitList(Ljava/util/List;)V
    const/4 v1, 0
    goto +fh
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->rvOptions Landroidx/recyclerview/widget/RecyclerView;
    if-nez v1, +006h
    invoke-static v13, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    invoke-virtual v1, v12, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    const/4 v1, 0
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->optionAdapter Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->getOptions()Ljava/util/List;
    move-result-object v4
    invoke-interface v4, Ljava/util/List;->isEmpty()Z
    move-result v4
    if-eqz v4, +08dh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->getAllowCustomInput()Z
    move-result v4
    if-nez v4, +087h
    if-eqz v3, +085h
    if-eqz v5, +083h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->onFileClick Lkotlin/jvm/functions/Function1;
    invoke-interface v5, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;->setFileClickListener(Lkotlin/jvm/functions/Function1;)V
    iget-object v4, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->resolvedPluginDisplayName Ljava/lang/String;
    invoke-interface v5, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;->setResolvedDisplayName(Ljava/lang/String;)V
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->requireContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v9, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->confirmInfo Lcom/bytedance/trae/im/model/ConfirmInfo;
    invoke-interface v5, v4, v3, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;->createContentView(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/im/model/ConfirmInfo;)Landroid/view/View;
    move-result-object v3
    iget-object v4, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->rvOptions Landroidx/recyclerview/widget/RecyclerView;
    if-nez v4, +006h
    invoke-static v13, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v1
    invoke-virtual v4, Landroidx/recyclerview/widget/RecyclerView;->getParent()Landroid/view/ViewParent;
    move-result-object v4
    const-string v9, "null cannot be cast to non-null type android.view.ViewGroup"
    invoke-static v4, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Landroid/view/ViewGroup;
    iget-object v9, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->rvOptions Landroidx/recyclerview/widget/RecyclerView;
    if-nez v9, +006h
    invoke-static v13, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v1
    check-cast v9, Landroid/view/View;
    invoke-virtual v4, v9, Landroid/view/ViewGroup;->indexOfChild(Landroid/view/View;)I
    move-result v9
    new-instance v11, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v12, -1
    const/4 v13, -2
    invoke-direct v11, v12, v13, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-interface v5, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;->getContentTopMarginRes()I
    move-result v12
    if-eqz v12, +00bh
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->getResources()Landroid/content/res/Resources;
    move-result-object v13
    invoke-virtual v13, v12, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v12
    goto +12h
    invoke-interface v5, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;->getContentTopMarginDp()I
    move-result v12
    int-to-float v12, v12
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->getResources()Landroid/content/res/Resources;
    move-result-object v13
    invoke-virtual v13, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v13
    iget v13, v13, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v12, v13
    float-to-int v12, v12
    iput v12, v11, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    add-int/2addr v9, v8
    check-cast v11, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v3, v9, v11, Landroid/view/ViewGroup;->addView(Landroid/view/View; I Landroid/view/ViewGroup$LayoutParams;)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->contentView Landroid/view/View;
    invoke-interface v5, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;->hideDefaultButtons()Z
    move-result v4
    if-eqz v4, +014h
    new-instance v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda4;
    invoke-direct v4, v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Ljava/lang/String;)V
    new-instance v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda5;
    invoke-direct v8, v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Ljava/lang/String;)V
    new-instance v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda6;
    invoke-direct v9, v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Ljava/lang/String;)V
    invoke-interface v5, v3, v4, v8, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;->bindActions(Landroid/view/View; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->getAllowCustomInput()Z
    move-result v3
    if-eqz v3, +00eh
    if-eqz v10, +007h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPageResult;->getCustomInput()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v1
    invoke-direct v0, v2, v4, v5, v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->addCustomInputView(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Z)V
    goto +4h
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->removeCustomInputView()V
    invoke-direct v0, v2, v5, v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->updateActionArea(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage; Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Z)V
    return-void 
.end method

.method private static final renderPage$lambda$15(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  com.bytedance.trae.conversation.chat.checkpoint.CheckpointPage  com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator  boolean)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->saveCurrentPageResult()V
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->updateActionArea(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage; Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Z)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final renderPage$lambda$17(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  int  com.bytedance.trae.conversation.chat.checkpoint.CheckpointOption)kotlin.Unit
    .registers 4
    # ins_size=3
    const-string v0, "<unused var>"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->getView()Landroid/view/View;
    move-result-object v3
    if-eqz v3, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda8;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; I)V
    const-wide/16 v1, 250
    invoke-virtual v3, v0, v1, v2, Landroid/view/View;->postDelayed(Ljava/lang/Runnable; J)Z
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final renderPage$lambda$17$lambda$16(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  int)void
    .registers 3
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->isAdded()Z
    move-result v0
    if-eqz v0, +00ch
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->currentPageIndex I
    if-ne v0, v2, +008h
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->saveCurrentPageResult()V
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->advanceToNextPageOrSubmit()V
    return-void 
.end method

.method private static final renderPage$lambda$19(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  java.lang.String)kotlin.Unit
    .registers 12
    # ins_size=2
    iget-object v0, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->callback Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;
    if-eqz v0, +025h
    new-instance v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Confirm;
    iget-object v1, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->planItem Lcom/bytedance/trae/im/model/ParsedPlanItem;
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getId()Ljava/lang/String;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    if-nez v1, +004h
    const-string v1, ""
    move-object v2, v1
    iget-object v4, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->taskId Ljava/lang/String;
    iget-object v5, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->conversationId Ljava/lang/String;
    const/4 v6, 0
    const/16 v7, 16
    const/4 v8, 0
    move-object v1, v9
    move-object v3, v11
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Confirm;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    invoke-interface v0, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;->onDecision(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;)V
    invoke-direct v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->dismiss()V
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
.end method

.method private static final renderPage$lambda$20(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  java.lang.String)kotlin.Unit
    .registers 7
    # ins_size=2
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->callback Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;
    if-eqz v0, +01eh
    new-instance v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Skip;
    iget-object v2, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->planItem Lcom/bytedance/trae/im/model/ParsedPlanItem;
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getId()Ljava/lang/String;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    if-nez v2, +004h
    const-string v2, ""
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->taskId Ljava/lang/String;
    iget-object v4, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->conversationId Ljava/lang/String;
    invoke-direct v1, v2, v6, v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Skip;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    invoke-interface v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;->onDecision(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;)V
    invoke-direct v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->dismiss()V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
.end method

.method private static final renderPage$lambda$21(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  java.lang.String  java.lang.String)kotlin.Unit
    .registers 11
    # ins_size=3
    iget-object v0, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->callback Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;
    if-eqz v0, +022h
    new-instance v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Confirm;
    iget-object v1, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->planItem Lcom/bytedance/trae/im/model/ParsedPlanItem;
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getId()Ljava/lang/String;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    if-nez v1, +004h
    const-string v1, ""
    move-object v2, v1
    iget-object v4, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->taskId Ljava/lang/String;
    iget-object v5, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->conversationId Ljava/lang/String;
    move-object v1, v7
    move-object v3, v9
    move-object v6, v10
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Confirm;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    check-cast v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    invoke-interface v0, v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;->onDecision(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->dismiss()V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
.end method

.method private final saveCurrentPageResult()void
    .registers 10
    # ins_size=1
    iget-object v0, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->optionAdapter Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->getSelectedOptions()Ljava/util/List;
    move-result-object v0
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iget-object v1, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->etCustomAnswer Landroid/widget/EditText;
    const/4 v2, 0
    if-eqz v1, +01ah
    invoke-virtual v1, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v1
    if-eqz v1, +014h
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +00eh
    move-object v3, v1
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/lit8 v3, v3, 1
    if-eqz v3, +003h
    move-object v2, v1
    iget v1, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->currentPageIndex I
    check-cast v0, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    const/16 v4, 10
    invoke-static v0, v4, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v4
    invoke-direct v3, v4, Ljava/util/ArrayList;-><init>(I)V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +010h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;->getLabel()Ljava/lang/String;
    move-result-object v4
    invoke-interface v3, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v3, Ljava/util/List;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPageResult;
    invoke-direct v0, v1, v3, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPageResult;-><init>(I Ljava/util/List; Ljava/lang/String;)V
    iget v1, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->currentPageIndex I
    iget-object v2, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pageResults Ljava/util/List;
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v2
    if-ge v1, v2, +00ah
    iget-object v1, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pageResults Ljava/util/List;
    iget v2, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->currentPageIndex I
    invoke-interface v1, v2, v0, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    goto +26h
    iget-object v1, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pageResults Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v1
    iget v2, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->currentPageIndex I
    if-ge v1, v2, +018h
    iget-object v1, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pageResults Ljava/util/List;
    new-instance v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPageResult;
    iget-object v2, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pageResults Ljava/util/List;
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v3
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 6
    const/4 v7, 0
    move-object v2, v8
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPageResult;-><init>(I Ljava/util/List; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v1, v8, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -1fh
    iget-object v1, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pageResults Ljava/util/List;
    invoke-interface v1, v0, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method private final setQuestionText(java.lang.String)void
    .registers 8
    # ins_size=2
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->questionLayoutListener Landroid/view/View$OnLayoutChangeListener;
    const-string/jumbo v1, tvQuestion
    const/4 v2, 0
    if-eqz v0, +00dh
    iget-object v3, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v2
    invoke-virtual v3, v0, Landroid/widget/TextView;->removeOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V
    iput-object v2, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->questionLayoutListener Landroid/view/View$OnLayoutChangeListener;
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    move-object v3, v7
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    const/4 v3, 0
    invoke-virtual v0, v3, v3, Landroid/widget/TextView;->scrollTo(I I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    const-string/jumbo v4, tvScrollView
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v3, v3, Landroidx/core/widget/NestedScrollView;->scrollTo(I I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    const v5, 2147483647
    invoke-virtual v0, v5, Landroid/widget/TextView;->setMaxLines(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v3, Landroid/widget/TextView;->setVerticalFadingEdgeEnabled(Z)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v3, Landroidx/core/widget/NestedScrollView;->setVerticalFadingEdgeEnabled(Z)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    check-cast v0, Landroid/view/View;
    const/4 v3, -2
    invoke-direct v6, v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->setViewHeight(Landroid/view/View; I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    check-cast v0, Landroid/view/View;
    invoke-direct v6, v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->setViewHeight(Landroid/view/View; I)V
    invoke-virtual v7, Ljava/lang/String;->length()I
    move-result v0
    const/16 v3, 120
    if-le v0, v3, +005h
    invoke-direct v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->applyQuestionCollapsedViewport()V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$setQuestionText$listener$1;
    invoke-direct v0, v6, v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$setQuestionText$listener$1;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Ljava/lang/String;)V
    move-object v3, v0
    check-cast v3, Landroid/view/View$OnLayoutChangeListener;
    iput-object v3, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->questionLayoutListener Landroid/view/View$OnLayoutChangeListener;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    if-nez v4, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v2
    invoke-virtual v4, v3, Landroid/widget/TextView;->addOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V
    iget-object v3, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v3
    new-instance v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda1;
    invoke-direct v1, v6, v7, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$setQuestionText$listener$1;)V
    invoke-virtual v2, v1, Landroid/widget/TextView;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final setQuestionText$lambda$22(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  java.lang.String  com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$setQuestionText$listener$1)void
    .registers 5
    # ins_size=3
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->applyQuestionViewportIfReady(Ljava/lang/String;)Z
    move-result v3
    if-eqz v3, +01ah
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    const/4 v0, 0
    if-nez v3, +009h
    const-string/jumbo v3, tvQuestion
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v0
    move-object v1, v4
    check-cast v1, Landroid/view/View$OnLayoutChangeListener;
    invoke-virtual v3, v1, Landroid/widget/TextView;->removeOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->questionLayoutListener Landroid/view/View$OnLayoutChangeListener;
    if-ne v3, v4, +004h
    iput-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->questionLayoutListener Landroid/view/View$OnLayoutChangeListener;
    return-void 
.end method

.method private final setViewHeight(android.view.View  int)void
    .registers 5
    # ins_size=3
    invoke-virtual v3, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    iget v1, v0, Landroid/view/ViewGroup$LayoutParams;->height I
    if-eq v1, v4, +007h
    iput v4, v0, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v3, v0, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method private final setupListeners()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->planItem Lcom/bytedance/trae/im/model/ParsedPlanItem;
    const/4 v1, 0
    if-eqz v0, +00dh
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v1
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnClose Landroid/widget/FrameLayout;
    if-nez v3, +008h
    const-string v3, "btnClose"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v1
    new-instance v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda0;
    invoke-direct v4, v5, v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String;)V
    invoke-virtual v3, v4, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnCancel Landroid/widget/TextView;
    if-nez v3, +008h
    const-string v3, "btnCancel"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v1
    new-instance v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda10;
    invoke-direct v4, v5, v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda10;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String;)V
    invoke-virtual v3, v4, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnHeaderPrev Landroid/widget/FrameLayout;
    if-nez v0, +008h
    const-string v0, "btnHeaderPrev"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda11;
    invoke-direct v2, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda11;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;)V
    invoke-virtual v0, v2, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnHeaderNext Landroid/widget/FrameLayout;
    if-nez v0, +008h
    const-string v0, "btnHeaderNext"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda12;
    invoke-direct v2, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda12;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;)V
    invoke-virtual v0, v2, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnPrev Landroid/widget/TextView;
    if-nez v0, +008h
    const-string v0, "btnPrev"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda13;
    invoke-direct v2, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda13;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;)V
    invoke-virtual v0, v2, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnNext Landroid/widget/TextView;
    if-nez v0, +008h
    const-string v0, "btnNext"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda14;
    invoke-direct v0, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda14;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;)V
    invoke-virtual v1, v0, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupListeners$lambda$2(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  com.bytedance.trae.im.model.ParsedPlanItem  java.lang.String  android.view.View)void
    .registers 7
    # ins_size=4
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "CheckPointDialog"
    const-string v1, "[Dialog] btnClose clicked, skip decision"
    invoke-virtual v6, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v6, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->callback Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;
    if-eqz v6, +01ch
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Skip;
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getId()Ljava/lang/String;
    move-result-object v4
    goto +2h
    const/4 v4, 0
    if-nez v4, +004h
    const-string v4, ""
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->taskId Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->conversationId Ljava/lang/String;
    invoke-direct v0, v4, v5, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Skip;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    invoke-interface v6, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;->onDecision(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->dismiss()V
    return-void 
.end method

.method private static final setupListeners$lambda$3(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  com.bytedance.trae.im.model.ParsedPlanItem  java.lang.String  android.view.View)void
    .registers 7
    # ins_size=4
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "CheckPointDialog"
    const-string v1, "[Dialog] btnCancel clicked, skip decision"
    invoke-virtual v6, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v6, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->callback Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;
    if-eqz v6, +01ch
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Skip;
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getId()Ljava/lang/String;
    move-result-object v4
    goto +2h
    const/4 v4, 0
    if-nez v4, +004h
    const-string v4, ""
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->taskId Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->conversationId Ljava/lang/String;
    invoke-direct v0, v4, v5, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Skip;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    invoke-interface v6, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;->onDecision(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->dismiss()V
    return-void 
.end method

.method private static final setupListeners$lambda$4(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->navigateToPreviousPage()V
    return-void 
.end method

.method private static final setupListeners$lambda$5(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  android.view.View)void
    .registers 4
    # ins_size=2
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "[Dialog] btnHeaderNext clicked, currentPage="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->currentPageIndex I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", totalPages="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pages Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "CheckPointDialog"
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->saveCurrentPageResult()V
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->advanceToNextPageOrSubmit()V
    return-void 
.end method

.method private static final setupListeners$lambda$6(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->navigateToPreviousPage()V
    return-void 
.end method

.method private static final setupListeners$lambda$7(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  android.view.View)void
    .registers 4
    # ins_size=2
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "[Dialog] btnNext clicked, currentPage="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->currentPageIndex I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", totalPages="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pages Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "CheckPointDialog"
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->saveCurrentPageResult()V
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->advanceToNextPageOrSubmit()V
    return-void 
.end method

.method private final setupQuestionScrolling()void
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    const-string/jumbo v1, tvQuestion
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v2, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    const/4 v3, 0
    invoke-virtual v0, v3, Landroid/widget/TextView;->setVerticalScrollBarEnabled(Z)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v3, Landroid/widget/TextView;->setVerticalFadingEdgeEnabled(Z)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    const v4, 2147483647
    invoke-virtual v0, v4, Landroid/widget/TextView;->setMaxLines(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    const-string/jumbo v4, tvScrollView
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    const/4 v5, 1
    invoke-virtual v0, v5, Landroidx/core/widget/NestedScrollView;->setClipChildren(Z)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v5, Landroidx/core/widget/NestedScrollView;->setClipToPadding(Z)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v3, Landroidx/core/widget/NestedScrollView;->setVerticalScrollBarEnabled(Z)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v5, Landroidx/core/widget/NestedScrollView;->setVerticalFadingEdgeEnabled(Z)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    const/16 v3, 24
    invoke-direct v6, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->dp(I)I
    move-result v3
    invoke-virtual v0, v3, Landroidx/core/widget/NestedScrollView;->setFadingEdgeLength(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v5, Landroidx/core/widget/NestedScrollView;->setOverScrollMode(I)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda9;
    invoke-direct v0, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;)V
    iget-object v3, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    if-nez v3, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v2
    invoke-virtual v3, v0, Landroidx/core/widget/NestedScrollView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    iget-object v3, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvQuestion Landroid/widget/TextView;
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v3
    invoke-virtual v2, v0, Landroid/widget/TextView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    return-void 
.end method

.method private static final setupQuestionScrolling$lambda$1(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  android.view.View  android.view.MotionEvent)boolean
    .registers 8
    # ins_size=3
    invoke-virtual v7, Landroid/view/MotionEvent;->getActionMasked()I
    move-result v6
    const/4 v0, 0
    const/4 v1, 1
    if-eq v6, v1, +00bh
    invoke-virtual v7, Landroid/view/MotionEvent;->getActionMasked()I
    move-result v6
    const/4 v7, 3
    if-eq v6, v7, +004h
    move v6, v1
    goto +2h
    move v6, v0
    iget-object v7, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    const/4 v2, 0
    const-string/jumbo v3, tvScrollView
    if-nez v7, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v7, v2
    const/4 v4, -1
    invoke-virtual v7, v4, Landroidx/core/widget/NestedScrollView;->canScrollVertically(I)Z
    move-result v7
    if-nez v7, +010h
    iget-object v7, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    if-nez v7, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v7, v2
    invoke-virtual v7, v1, Landroidx/core/widget/NestedScrollView;->canScrollVertically(I)Z
    move-result v7
    if-eqz v7, +014h
    iget-object v5, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    if-nez v5, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v5
    invoke-virtual v2, Landroidx/core/widget/NestedScrollView;->getParent()Landroid/view/ViewParent;
    move-result-object v5
    if-eqz v5, +005h
    invoke-interface v5, v6, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V
    return v0
.end method

.method private final showKeyboard(android.widget.EditText)void
    .registers 3
    # ins_size=2
    if-nez v2, +003h
    return-void 
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda7;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda7;-><init>(Landroid/widget/EditText;)V
    invoke-virtual v2, v0, Landroid/widget/EditText;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final showKeyboard$lambda$29(android.widget.EditText)void
    .registers 3
    # ins_size=1
    invoke-virtual v2, Landroid/widget/EditText;->getContext()Landroid/content/Context;
    move-result-object v0
    const-string v1, "input_method"
    invoke-virtual v0, v1, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Landroid/view/inputmethod/InputMethodManager;
    if-eqz v1, +005h
    check-cast v0, Landroid/view/inputmethod/InputMethodManager;
    goto +2h
    const/4 v0, 0
    if-eqz v0, +008h
    check-cast v2, Landroid/view/View;
    const/4 v1, 1
    invoke-virtual v0, v2, v1, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View; I)Z
    return-void 
.end method

.method private final submitCustomInput()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->saveCurrentPageResult()V
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->advanceToNextPageOrSubmit()V
    return-void 
.end method

.method private final updateActionArea(com.bytedance.trae.conversation.chat.checkpoint.CheckpointPage  com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator  boolean)void
    .registers 14
    # ins_size=4
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v12, +00ah
    invoke-interface v12, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;->hideDefaultButtons()Z
    move-result v2
    if-ne v2, v0, +004h
    move v2, v0
    goto +2h
    move v2, v1
    const-string v3, "actionGroup"
    const/16 v4, 8
    const/4 v5, 0
    if-eqz v2, +00fh
    iget-object v11, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->actionGroup Landroid/widget/LinearLayout;
    if-nez v11, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v5, v11
    invoke-virtual v5, v4, Landroid/widget/LinearLayout;->setVisibility(I)V
    return-void 
    const-string/jumbo v2, requireContext(...)
    const-string v6, "btnCancel"
    const-string v7, "btnNext"
    if-eqz v12, +02fh
    iget-object v8, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnCancel Landroid/widget/TextView;
    if-nez v8, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v5
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->requireContext()Landroid/content/Context;
    move-result-object v9
    invoke-static v9, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v12, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;->getSecondaryButtonText(Landroid/content/Context;)Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    invoke-virtual v8, v9, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-interface v12, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;->getPrimaryButtonBackgroundRes()I
    move-result v8
    iget-object v9, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnNext Landroid/widget/TextView;
    if-nez v9, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v5
    if-eqz v8, +003h
    goto +3h
    sget v8, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_checkpoint_btn_primary I
    invoke-virtual v9, v8, Landroid/widget/TextView;->setBackgroundResource(I)V
    goto +eh
    iget-object v8, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnNext Landroid/widget/TextView;
    if-nez v8, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v5
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_checkpoint_btn_primary I
    invoke-virtual v8, v9, Landroid/widget/TextView;->setBackgroundResource(I)V
    iget-object v8, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnNext Landroid/widget/TextView;
    if-nez v8, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v5
    iget v7, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->currentPageIndex I
    iget-object v9, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pages Ljava/util/List;
    invoke-interface v9, Ljava/util/List;->size()I
    move-result v9
    sub-int/2addr v9, v0
    if-ne v7, v9, +039h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->getOptions()Ljava/util/List;
    move-result-object v7
    invoke-interface v7, Ljava/util/List;->isEmpty()Z
    move-result v7
    if-eqz v7, +023h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->getAllowCustomInput()Z
    move-result v7
    if-nez v7, +01dh
    if-eqz v12, +00fh
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->requireContext()Landroid/content/Context;
    move-result-object v7
    invoke-static v7, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v12, v7, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;->getPrimaryButtonText(Landroid/content/Context;)Ljava/lang/String;
    move-result-object v12
    if-nez v12, +017h
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_submit I
    invoke-virtual v10, v12, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->getString(I)Ljava/lang/String;
    move-result-object v12
    const-string v2, "getString(...)"
    invoke-static v12, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +ah
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_submit I
    invoke-virtual v10, v12, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->getString(I)Ljava/lang/String;
    move-result-object v12
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    check-cast v12, Ljava/lang/CharSequence;
    goto +ch
    sget v12, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_next I
    invoke-virtual v10, v12, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->getString(I)Ljava/lang/String;
    move-result-object v12
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    check-cast v12, Ljava/lang/CharSequence;
    invoke-virtual v8, v12, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const-string v12, "btnPrev"
    if-eqz v13, +06ah
    iget-object v13, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnCancel Landroid/widget/TextView;
    if-nez v13, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v13, v5
    invoke-virtual v13, v4, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v13, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnPrev Landroid/widget/TextView;
    if-nez v13, +006h
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v13, v5
    invoke-virtual v13, v4, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v12, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->optionAdapter Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;
    if-eqz v12, +013h
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->getSelectedOptions()Ljava/util/List;
    move-result-object v12
    if-eqz v12, +00dh
    check-cast v12, Ljava/util/Collection;
    invoke-interface v12, Ljava/util/Collection;->isEmpty()Z
    move-result v12
    xor-int/2addr v12, v0
    if-ne v12, v0, +004h
    move v12, v0
    goto +2h
    move v12, v1
    iget-object v13, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->etCustomAnswer Landroid/widget/EditText;
    if-eqz v13, +00dh
    invoke-virtual v13, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v13
    if-eqz v13, +007h
    invoke-virtual v13, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v13
    goto +2h
    move-object v13, v5
    check-cast v13, Ljava/lang/CharSequence;
    if-eqz v13, +00bh
    invoke-static v13, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v13
    if-eqz v13, +003h
    goto +3h
    move v13, v1
    goto +2h
    move v13, v0
    xor-int/2addr v13, v0
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->getMultiSelect()Z
    move-result v11
    if-eqz v11, +007h
    if-nez v12, +006h
    if-eqz v13, +003h
    goto +2h
    move v0, v1
    iget-object v11, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->actionGroup Landroid/widget/LinearLayout;
    if-nez v11, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v5, v11
    if-eqz v0, +003h
    goto +2h
    move v1, v4
    invoke-virtual v5, v1, Landroid/widget/LinearLayout;->setVisibility(I)V
    goto +28h
    iget-object v11, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnCancel Landroid/widget/TextView;
    if-nez v11, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v11, v5
    invoke-virtual v11, v1, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v11, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnPrev Landroid/widget/TextView;
    if-nez v11, +006h
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v11, v5
    iget v12, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->currentPageIndex I
    if-lez v12, +003h
    move v4, v1
    invoke-virtual v11, v4, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v11, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->actionGroup Landroid/widget/LinearLayout;
    if-nez v11, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v5, v11
    invoke-virtual v5, v1, Landroid/widget/LinearLayout;->setVisibility(I)V
    return-void 
.end method

.method private final updateCustomInputState(com.bytedance.trae.conversation.chat.checkpoint.CheckpointPage)void
    .registers 9
    # ins_size=2
    iget-object v0, v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->etCustomAnswer Landroid/widget/EditText;
    const/4 v1, 0
    if-eqz v0, +00dh
    invoke-virtual v0, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v3
    goto +2h
    move v0, v2
    xor-int/2addr v0, v2
    iget-object v4, v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->etCustomAnswer Landroid/widget/EditText;
    if-eqz v4, +009h
    invoke-virtual v4, Landroid/widget/EditText;->hasFocus()Z
    move-result v4
    if-ne v4, v2, +003h
    goto +2h
    move v2, v3
    iget-object v4, v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnCustomSend Landroid/widget/FrameLayout;
    const/16 v5, 8
    if-eqz v4, +00dh
    if-nez v2, +007h
    if-eqz v0, +003h
    goto +3h
    move v2, v5
    goto +2h
    move v2, v3
    invoke-virtual v4, v2, Landroid/widget/FrameLayout;->setVisibility(I)V
    iget-object v2, v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnCustomSend Landroid/widget/FrameLayout;
    if-eqz v2, +005h
    invoke-virtual v2, v0, Landroid/widget/FrameLayout;->setEnabled(Z)V
    iget-object v2, v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnCustomSend Landroid/widget/FrameLayout;
    if-eqz v2, +007h
    const/high16 v4, 1065353216
    invoke-virtual v2, v4, Landroid/widget/FrameLayout;->setAlpha(F)V
    iget-object v2, v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnCustomSend Landroid/widget/FrameLayout;
    if-eqz v2, +00ch
    if-eqz v0, +005h
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_checkpoint_btn_primary I
    goto +3h
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_checkpoint_send_disabled I
    invoke-virtual v2, v4, Landroid/widget/FrameLayout;->setBackgroundResource(I)V
    iget-object v2, v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->ivCustomSend Landroid/widget/ImageView;
    if-eqz v2, +018h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->requireContext()Landroid/content/Context;
    move-result-object v4
    if-eqz v0, +005h
    sget v6, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_onaccent I
    goto +3h
    sget v6, Lcom/bytedance/trae/conversation/R$color;->trae_checkpoint_icon_disabled I
    invoke-static v4, v6, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    invoke-static v4, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;
    move-result-object v4
    invoke-virtual v2, v4, Landroid/widget/ImageView;->setImageTintList(Landroid/content/res/ColorStateList;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;->getMultiSelect()Z
    move-result v8
    if-eqz v8, +023h
    iget-object v8, v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->ivCustomEdit Landroid/widget/ImageView;
    if-eqz v8, +005h
    invoke-virtual v8, v5, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->customCheckContainer Landroid/widget/FrameLayout;
    if-eqz v8, +00ch
    if-eqz v0, +005h
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_checkpoint_checkbox_checked I
    goto +3h
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_checkpoint_checkbox_unchecked I
    invoke-virtual v8, v1, Landroid/widget/FrameLayout;->setBackgroundResource(I)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->ivCustomCheck Landroid/widget/ImageView;
    if-eqz v8, +01fh
    if-eqz v0, +003h
    goto +2h
    move v3, v5
    invoke-virtual v8, v3, Landroid/widget/ImageView;->setVisibility(I)V
    goto +16h
    iget-object v8, v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->customCheckContainer Landroid/widget/FrameLayout;
    if-eqz v8, +005h
    invoke-virtual v8, v1, Landroid/widget/FrameLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->ivCustomEdit Landroid/widget/ImageView;
    if-eqz v8, +005h
    invoke-virtual v8, v3, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->ivCustomCheck Landroid/widget/ImageView;
    if-eqz v8, +005h
    invoke-virtual v8, v5, Landroid/widget/ImageView;->setVisibility(I)V
    return-void 
.end method

.method private final updateHeader(java.lang.String  boolean  int)void
    .registers 12
    # ins_size=4
    const/4 v0, 0
    const/4 v1, 1
    if-nez v10, +00fh
    if-nez v9, +00dh
    iget-object v2, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pages Ljava/util/List;
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v2
    if-le v2, v1, +003h
    goto +3h
    move v2, v0
    goto +2h
    move v2, v1
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->headerNavGroup Landroid/widget/LinearLayout;
    const/4 v4, 0
    if-nez v3, +008h
    const-string v3, "headerNavGroup"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v4
    const/16 v5, 8
    if-eqz v2, +004h
    move v6, v0
    goto +2h
    move v6, v5
    invoke-virtual v3, v6, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvProgress Landroid/widget/TextView;
    const-string/jumbo v6, tvProgress
    if-nez v3, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v4
    if-eqz v2, +004h
    move v2, v0
    goto +2h
    move v2, v5
    invoke-virtual v3, v2, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v2, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnHeaderPrev Landroid/widget/FrameLayout;
    const-string v3, "btnHeaderPrev"
    if-nez v2, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v4
    if-eqz v10, +004h
    move v7, v0
    goto +2h
    move v7, v5
    invoke-virtual v2, v7, Landroid/widget/FrameLayout;->setVisibility(I)V
    iget-object v2, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnHeaderNext Landroid/widget/FrameLayout;
    const-string v7, "btnHeaderNext"
    if-nez v2, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v4
    if-eqz v10, +003h
    move v5, v0
    invoke-virtual v2, v5, Landroid/widget/FrameLayout;->setVisibility(I)V
    iget-object v2, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnHeaderPrev Landroid/widget/FrameLayout;
    if-nez v2, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v4
    if-lez v11, +004h
    move v3, v1
    goto +2h
    move v3, v0
    invoke-virtual v2, v3, Landroid/widget/FrameLayout;->setEnabled(Z)V
    iget-object v2, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->btnHeaderNext Landroid/widget/FrameLayout;
    if-nez v2, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v4
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pages Ljava/util/List;
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v3
    sub-int/2addr v3, v1
    if-ge v11, v3, +004h
    move v3, v1
    goto +2h
    move v3, v0
    invoke-virtual v2, v3, Landroid/widget/FrameLayout;->setEnabled(Z)V
    if-lez v11, +005h
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_icon_icon_default I
    goto +3h
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_icon_icon_disabled I
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->ivHeaderPrev Landroid/widget/ImageView;
    if-nez v3, +008h
    const-string v3, "ivHeaderPrev"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v4
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->requireContext()Landroid/content/Context;
    move-result-object v5
    invoke-static v5, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-static v2, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;
    move-result-object v2
    invoke-virtual v3, v2, Landroid/widget/ImageView;->setImageTintList(Landroid/content/res/ColorStateList;)V
    iget-object v2, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pages Ljava/util/List;
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v2
    sub-int/2addr v2, v1
    if-ge v11, v2, +005h
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_icon_icon_default I
    goto +3h
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_icon_icon_disabled I
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->ivHeaderNext Landroid/widget/ImageView;
    if-nez v3, +008h
    const-string v3, "ivHeaderNext"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v4
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->requireContext()Landroid/content/Context;
    move-result-object v5
    invoke-static v5, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-static v2, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;
    move-result-object v2
    invoke-virtual v3, v2, Landroid/widget/ImageView;->setImageTintList(Landroid/content/res/ColorStateList;)V
    iget-object v2, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvProgress Landroid/widget/TextView;
    if-nez v2, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v4, v2
    if-nez v10, +015h
    iget-object v10, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pages Ljava/util/List;
    invoke-interface v10, Ljava/util/List;->size()I
    move-result v10
    if-le v10, v1, +003h
    goto +bh
    if-eqz v9, +005h
    check-cast v9, Ljava/lang/CharSequence;
    goto +24h
    const-string v9, ""
    check-cast v9, Ljava/lang/CharSequence;
    goto +1fh
    sget v9, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_progress I
    const/4 v10, 2
    new-array v10, v10, [Ljava/lang/Object;
    add-int/2addr v11, v1
    invoke-static v11, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v11
    aput-object v11, v10, v0
    iget-object v11, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pages Ljava/util/List;
    invoke-interface v11, Ljava/util/List;->size()I
    move-result v11
    invoke-static v11, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v11
    aput-object v11, v10, v1
    invoke-virtual v8, v9, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    invoke-virtual v4, v9, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method private final updateTitleTopMargin(boolean)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    const-string/jumbo v1, tvScrollView
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Landroidx/core/widget/NestedScrollView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v0
    instance-of v3, v0, Landroid/view/ViewGroup$MarginLayoutParams;
    if-eqz v3, +005h
    check-cast v0, Landroid/view/ViewGroup$MarginLayoutParams;
    goto +2h
    move-object v0, v2
    if-nez v0, +003h
    return-void 
    if-eqz v5, +012h
    const/16 v5, 16
    int-to-float v5, v5
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    invoke-virtual v3, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v3
    iget v3, v3, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v5, v3
    float-to-int v5, v5
    goto +2h
    const/4 v5, 0
    iget v3, v0, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin I
    if-eq v3, v5, +012h
    iput v5, v0, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin I
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->tvScrollView Landroidx/core/widget/NestedScrollView;
    if-nez v5, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v5
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v0, Landroidx/core/widget/NestedScrollView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method public final getResolvedPluginDisplayName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->resolvedPluginDisplayName Ljava/lang/String;
    return-object v0
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->trae_dialog_human_checkpoint I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    const-string v3, "inflate(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 6
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v3, v4, v5, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "[Dialog] onViewCreated: pages="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pages Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", taskId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->taskId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", toolName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->planItem Lcom/bytedance/trae/im/model/ParsedPlanItem;
    const/4 v2, 0
    if-eqz v1, +00dh
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v2
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "CheckPointDialog"
    invoke-virtual v5, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v4, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v5
    instance-of v0, v5, Landroid/view/View;
    if-eqz v0, +005h
    move-object v2, v5
    check-cast v2, Landroid/view/View;
    if-eqz v2, +006h
    const/4 v5, 0
    invoke-virtual v2, v5, Landroid/view/View;->setBackgroundColor(I)V
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->bindViews(Landroid/view/View;)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->setupListeners()V
    iget-object v5, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->pages Ljava/util/List;
    check-cast v5, Ljava/util/Collection;
    invoke-interface v5, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    xor-int/lit8 v5, v5, 1
    if-eqz v5, +007h
    iget v5, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->currentPageIndex I
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->renderPage(I)V
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->hideKeyboard(Landroid/view/View;)V
    return-void 
.end method

.method public final setResolvedPluginDisplayName(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->resolvedPluginDisplayName Ljava/lang/String;
    return-void 
.end method
