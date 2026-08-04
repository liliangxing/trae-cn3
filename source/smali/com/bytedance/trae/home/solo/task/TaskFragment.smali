# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/task/TaskFragment;
.super Landroidx/fragment/app/Fragment;
.source "TaskFragment.kt"

.field public static final $stable:I
.field private actionPopup:Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
.field private adapter:Lcom/bytedance/trae/home/solo/task/TaskAdapter;
.field private defaultTaskListItemAnimator:Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;
.field private filterPopup:Landroid/widget/PopupWindow;
.field private final fpsTracer:Lcom/bytedance/apm/trace/fps/FpsTracer;
.field private hasSuspendByPeerCrashFixed:Z
.field private isFilterOpen:Z
.field private isFirstResume:Z
.field private isSearchHeaderRendered:Z
.field private operationIconVisibilityBeforeSearch:I
.field private shouldScrollToTop:Z
.field private suppressNextTopChangedScrollTaskId:Ljava/lang/String;
.field private swipeRefresh:Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;
.field private topTaskId:Ljava/lang/String;
.field private viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;


.method public static synthetic $r8$lambda$-6-GroGTyFqkNFhHl--LkSiSveg(com.bytedance.trae.home.solo.task.TaskFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupFilterItems$lambda$20(Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$0Me2H8UVS0Sm7LYpBEBuVPnMyJA(com.bytedance.trae.home.solo.task.TaskFragment  com.bytedance.trae.home.solo.task.DeviceInfo  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupFilterItems$lambda$22(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lcom/bytedance/trae/home/solo/task/DeviceInfo; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$1tP9WtNy4i3dGTnVrNYRMe1iGho(com.bytedance.trae.home.solo.task.TaskFragment  android.widget.ImageView)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showFilterPopup$lambda$17$lambda$16(Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroid/widget/ImageView;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$5K601pHhOC-bxn6SzvMt5iCOgcs(com.bytedance.trae.home.solo.task.TaskFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupHeader$lambda$13(Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$5S7W8JNV0jPetmKguIzdZLItyqc(kotlin.jvm.functions.Function0  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showRenameDialog$lambda$40(Lkotlin/jvm/functions/Function0; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$6oDt_cu3ZPBz9DLhhNqLalHEnfE(com.bytedance.trae.home.solo.task.TaskFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupFilterItems$lambda$21(Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$8homNJbzFXFIUFqDO-6Bhh4HH_s()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/home/solo/task/TaskFragment;->showActionPopup$lambda$37$lambda$36$lambda$35()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$B4fKk7rvJBfI3oda2Vp0MuqSP_0(com.bytedance.trae.home.solo.task.TaskFragment  com.bytedance.trae.home.solo.task.TaskModel  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupRecyclerView$lambda$31(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lcom/bytedance/trae/home/solo/task/TaskModel; Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$BO0c-hQyX1j8MmMUde7dNYmhNmI(com.bytedance.trae.home.solo.task.TaskFragment  com.bytedance.trae.home.solo.task.TaskModel  float  float)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupRecyclerView$lambda$28(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lcom/bytedance/trae/home/solo/task/TaskModel; F F)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$InybVxIk8v0jXNzQJ6PNfQfu0lE(com.bytedance.trae.home.solo.task.TaskFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupHeader$lambda$14(Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$JG3SUt8GkiX67wAh8i9pahZYaLc(com.bytedance.trae.home.solo.task.TaskFragment  com.bytedance.trae.home.solo.task.TaskModel  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupRecyclerView$lambda$30(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lcom/bytedance/trae/home/solo/task/TaskModel; Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Jbgh7seuglANjVzNdOApL2N-wLw(com.bytedance.trae.home.solo.task.TaskModel)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupRecyclerView$lambda$27(Lcom/bytedance/trae/home/solo/task/TaskModel;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Mkepj8_OrjEt_rCX24v5apyGmoQ(com.bytedance.trae.home.solo.task.TaskFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupHeader$lambda$11(Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$NAmbT-lz_b1jnAHBK0zDTjDMaFg(com.bytedance.trae.home.solo.task.TaskFragment  com.bytedance.trae.home.solo.task.TaskModel)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showActionPopup$lambda$37$lambda$34(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lcom/bytedance/trae/home/solo/task/TaskModel;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$POcVu037s_1kpKqaJyoCw1fZ8fg(com.bytedance.trae.home.solo.task.TaskFragment  com.bytedance.trae.home.solo.task.TaskModel)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showActionPopup$lambda$37$lambda$36(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lcom/bytedance/trae/home/solo/task/TaskModel;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Qupsv8xJW88nDe2hdzEY3wj-jk0(com.bytedance.trae.home.solo.task.TaskFragment  java.lang.String  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showRenameDialog$lambda$39(Lcom/bytedance/trae/home/solo/task/TaskFragment; Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$RJKXKAVEnnU9VYP6nNheTTk85T4(com.bytedance.trae.home.solo.task.TaskModel  com.bytedance.trae.home.solo.task.TaskFragment)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showActionPopup$lambda$37$lambda$32(Lcom/bytedance/trae/home/solo/task/TaskModel; Lcom/bytedance/trae/home/solo/task/TaskFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$RTb0jacbAFxQyZRuYM4SRT_bubU(com.bytedance.trae.home.solo.task.TaskFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->onViewCreated$lambda$3(Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$RkqCiZTdo_AlKTfMB5kDGa3QyBY(com.bytedance.trae.home.solo.task.TaskFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->onViewCreated$lambda$0(Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$TwbtPn8KtPMyp4ST_JnPqqdJmNg(com.bytedance.trae.home.solo.task.TaskFragment  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showDeleteDialog$lambda$41(Lcom/bytedance/trae/home/solo/task/TaskFragment; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$UebE9c19xcEGdBjHBdcnmIbNrUY(com.bytedance.trae.home.solo.task.TaskFragment  android.view.View  android.widget.ImageView  android.view.View)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupHeader$lambda$10(Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroid/view/View; Landroid/widget/ImageView; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$W0D_GAMYir5sftTsiiCO4Qaq6eE(com.bytedance.trae.home.solo.task.TaskFragment  android.widget.EditText)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requestSearchInputFocus$lambda$15(Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroid/widget/EditText;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$ZGJXpSCkEr92-OEUap67yfj8d2E(com.bytedance.trae.home.solo.task.TaskFragment  com.bytedance.trae.home.solo.task.TaskModel  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupRecyclerView$lambda$29(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lcom/bytedance/trae/home/solo/task/TaskModel; Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ZMHNXDZANnrTyPAwtg4ZA4UdT1k(com.bytedance.trae.home.solo.task.TaskFragment)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupRecyclerView$lambda$24(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$algrCfpJyqkZ2GCgQNEWh_P9V3M(kotlin.jvm.functions.Function0  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showDeleteDialog$lambda$42(Lkotlin/jvm/functions/Function0; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$fI5XBjzPIv64ubrZ7kLugtulSCc(com.bytedance.trae.home.solo.task.TaskFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->onViewCreated$lambda$5(Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$o-AUZ-J0rI592irKFqy5FGIfegM(com.bytedance.trae.home.solo.task.TaskFragment  com.bytedance.trae.home.solo.task.TaskModel  int)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupRecyclerView$lambda$26(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lcom/bytedance/trae/home/solo/task/TaskModel; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ovlNyKSx8671MWRkWgZZ2swHIGU()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/home/solo/task/TaskFragment;->showActionPopup$lambda$37$lambda$34$lambda$33()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Landroidx/fragment/app/Fragment;-><init>()V
    new-instance v0, Lcom/bytedance/apm/trace/fps/FpsTracer;
    const-string/jumbo v1, task_list
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/apm/trace/fps/FpsTracer;-><init>(Ljava/lang/String; Z)V
    iput-object v0, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment;->fpsTracer Lcom/bytedance/apm/trace/fps/FpsTracer;
    const/4 v0, 1
    iput-boolean v0, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment;->isFirstResume Z
    const/16 v0, 8
    iput v0, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment;->operationIconVisibilityBeforeSearch I
    return-void 
.end method

.method public static final synthetic access$getAdapter$p(com.bytedance.trae.home.solo.task.TaskFragment)com.bytedance.trae.home.solo.task.TaskAdapter
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->adapter Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    return-object v0
.end method

.method public static final synthetic access$getShouldScrollToTop$p(com.bytedance.trae.home.solo.task.TaskFragment)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->shouldScrollToTop Z
    return v0
.end method

.method public static final synthetic access$getSuppressNextTopChangedScrollTaskId$p(com.bytedance.trae.home.solo.task.TaskFragment)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->suppressNextTopChangedScrollTaskId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getSwipeRefresh$p(com.bytedance.trae.home.solo.task.TaskFragment)androidx.swiperefreshlayout.widget.SwipeRefreshLayout
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->swipeRefresh Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;
    return-object v0
.end method

.method public static final synthetic access$getTopTaskId$p(com.bytedance.trae.home.solo.task.TaskFragment)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->topTaskId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getViewModel$p(com.bytedance.trae.home.solo.task.TaskFragment)com.bytedance.trae.home.solo.task.TaskViewModel
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    return-object v0
.end method

.method public static final synthetic access$loadAvatar(com.bytedance.trae.home.solo.task.TaskFragment  com.facebook.drawee.view.SimpleDraweeView)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->loadAvatar(Lcom/facebook/drawee/view/SimpleDraweeView;)V
    return-void 
.end method

.method public static final synthetic access$renderSearchHeader(com.bytedance.trae.home.solo.task.TaskFragment  android.view.View  boolean  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment;->renderSearchHeader(Landroid/view/View; Z Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$renderTaskContent(com.bytedance.trae.home.solo.task.TaskFragment  com.bytedance.trae.home.solo.task.TaskFragment$TaskContentState  androidx.recyclerview.widget.RecyclerView  android.view.View  android.view.View  android.view.View  android.widget.TextView  android.view.View)void
    .registers 8
    # ins_size=8
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/home/solo/task/TaskFragment;->renderTaskContent(Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState; Landroidx/recyclerview/widget/RecyclerView; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View;)V
    return-void 
.end method

.method public static final synthetic access$setShouldScrollToTop$p(com.bytedance.trae.home.solo.task.TaskFragment  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->shouldScrollToTop Z
    return-void 
.end method

.method public static final synthetic access$setSuppressNextTopChangedScrollTaskId$p(com.bytedance.trae.home.solo.task.TaskFragment  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->suppressNextTopChangedScrollTaskId Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setTaskListItemAnimationsSuppressed(com.bytedance.trae.home.solo.task.TaskFragment  androidx.recyclerview.widget.RecyclerView  boolean)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setTaskListItemAnimationsSuppressed(Landroidx/recyclerview/widget/RecyclerView; Z)V
    return-void 
.end method

.method public static final synthetic access$setTopTaskId$p(com.bytedance.trae.home.solo.task.TaskFragment  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->topTaskId Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$titleForFilter(com.bytedance.trae.home.solo.task.TaskFragment  com.bytedance.trae.home.solo.task.FilterOption)java.lang.String
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->titleForFilter(Lcom/bytedance/trae/home/solo/task/FilterOption;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final dismissFilterPopup()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->filterPopup Landroid/widget/PopupWindow;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/widget/PopupWindow;->dismiss()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->filterPopup Landroid/widget/PopupWindow;
    return-void 
.end method

.method private final fixSuspendByPeerCrash(android.content.Context)void
    .registers 8
    # ins_size=2
    iget-boolean v0, v6, Lcom/bytedance/trae/home/solo/task/TaskFragment;->hasSuspendByPeerCrashFixed Z
    if-eqz v0, +003h
    return-void 
    const/4 v0, 1
    iput-boolean v0, v6, Lcom/bytedance/trae/home/solo/task/TaskFragment;->hasSuspendByPeerCrashFixed Z
    invoke-static v7, Lcom/ss/android/common/util/ToolUtils;->isMainProcess(Landroid/content/Context;)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v0
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isTestChannel()Z
    move-result v1
    sget-object v2, Lcom/bytedance/trae/home/solo/task/FixCrashSettingsService;->INSTANCE Lcom/bytedance/trae/home/solo/task/FixCrashSettingsService;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/FixCrashSettingsService;->isFixSuspendByPeerCrashEnable()Z
    move-result v2
    if-nez v0, +006h
    if-nez v1, +004h
    if-eqz v2, +031h
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, runInternal, isDebug: 
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v4, ", isTestChannel: "
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isFixSuspendByPeerCrashEnable: "
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "fixSuspendByPeerCrash"
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-static v7, v0, Lcom/bytedance/sysoptimizer/SuspendByPeerOpt;->start(Landroid/content/Context; Z)I
    return-void 
.end method

.method private final hideKeyboard(android.widget.EditText)void
    .registers 5
    # ins_size=2
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getContext()Landroid/content/Context;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +009h
    const-string v2, "input_method"
    invoke-virtual v0, v2, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    goto +2h
    move-object v0, v1
    instance-of v2, v0, Landroid/view/inputmethod/InputMethodManager;
    if-eqz v2, +005h
    move-object v1, v0
    check-cast v1, Landroid/view/inputmethod/InputMethodManager;
    if-eqz v1, +00ah
    invoke-virtual v4, Landroid/widget/EditText;->getWindowToken()Landroid/os/IBinder;
    move-result-object v0
    const/4 v2, 0
    invoke-virtual v1, v0, v2, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder; I)Z
    invoke-virtual v4, Landroid/widget/EditText;->clearFocus()V
    return-void 
.end method

.method private final loadAvatar(com.facebook.drawee.view.SimpleDraweeView)void
    .registers 4
    # ins_size=2
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
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getAvatarUrl()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    if-nez v1, +00ah
    invoke-static v0, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v0
    invoke-virtual v3, v0, Lcom/facebook/drawee/view/SimpleDraweeView;->setImageURI(Landroid/net/Uri;)V
    goto +6h
    sget v0, Lcom/bytedance/trae/home/R$drawable;->trae_default_avatar I
    invoke-virtual v3, v0, Lcom/facebook/drawee/view/SimpleDraweeView;->setActualImageResource(I)V
    return-void 
.end method

.method private final observeCustomActivity()void
    .registers 10
    # ins_size=1
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getView()Landroid/view/View;
    move-result-object v0
    if-eqz v0, +031h
    sget v1, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-nez v0, +003h
    goto +25h
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getTaskOperationIconView()Lcom/facebook/drawee/view/SimpleDraweeView;
    move-result-object v1
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v2
    const-string v3, "getViewLifecycleOwner(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1;
    const/4 v6, 0
    invoke-direct v2, v9, v0, v1, v6, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lcom/bytedance/trae/common/widget/TraeTitleBar; Lcom/facebook/drawee/view/SimpleDraweeView; Lkotlin/coroutines/Continuation;)V
    move-object v6, v2
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final observeViewModel()void
    .registers 19
    # ins_size=1
    move-object/from16 v9, v18
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getView()Landroid/view/View;
    move-result-object v0
    const/4 v10, 0
    if-eqz v0, +00ah
    sget v1, Lcom/bytedance/trae/home/R$id;->layout_empty_state I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    move-object v3, v0
    goto +2h
    move-object v3, v10
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getView()Landroid/view/View;
    move-result-object v0
    if-eqz v0, +00ah
    sget v1, Lcom/bytedance/trae/home/R$id;->layout_task_search_loading I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    move-object v4, v0
    goto +2h
    move-object v4, v10
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getView()Landroid/view/View;
    move-result-object v0
    if-eqz v0, +00ah
    sget v1, Lcom/bytedance/trae/home/R$id;->layout_task_search_empty_state I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    move-object v5, v0
    goto +2h
    move-object v5, v10
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getView()Landroid/view/View;
    move-result-object v0
    if-eqz v0, +00ch
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_task_search_empty_text I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    move-object v6, v0
    goto +2h
    move-object v6, v10
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getView()Landroid/view/View;
    move-result-object v0
    if-eqz v0, +00ch
    sget v1, Lcom/bytedance/trae/home/R$id;->rv_tasks I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView;
    move-object v2, v0
    goto +2h
    move-object v2, v10
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getView()Landroid/view/View;
    move-result-object v0
    if-eqz v0, +00ah
    sget v1, Lcom/bytedance/trae/home/R$id;->layout_network_error I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    move-object v7, v0
    goto +2h
    move-object v7, v10
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    const-string v11, "getViewLifecycleOwner(...)"
    invoke-static v0, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v12, v0
    check-cast v12, Lkotlinx/coroutines/CoroutineScope;
    const/4 v13, 0
    const/4 v14, 0
    new-instance v15, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;
    const/4 v8, 0
    move-object v0, v15
    move-object/from16 v1, v18
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroidx/recyclerview/widget/RecyclerView; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Lkotlin/coroutines/Continuation;)V
    check-cast v15, Lkotlin/jvm/functions/Function2;
    const/16 v16, 3
    const/16 v17, 0
    invoke-static/range v12 ... v17, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    invoke-static v0, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2;
    invoke-direct v0, v9, v10, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    invoke-static v0, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$3;
    invoke-direct v0, v9, v10, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$3;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    invoke-static v0, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$4;
    invoke-direct v0, v9, v10, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$4;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-virtual/range v18, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    invoke-static v0, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$5;
    invoke-direct v0, v9, v10, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$5;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-direct/range v18, Lcom/bytedance/trae/home/solo/task/TaskFragment;->observeCustomActivity()V
    return-void 
.end method

.method private static final onViewCreated$lambda$0(com.bytedance.trae.home.solo.task.TaskFragment  android.view.View)void
    .registers 4
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v3
    invoke-virtual v3, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z
    move-result v3
    if-nez v3, +03eh
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v3
    const-string v0, "AccountSettingsBottomSheet"
    invoke-virtual v3, v0, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v3
    if-nez v3, +032h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v3
    const-string v1, "CmpAccountSettingsBottomSheet"
    invoke-virtual v3, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v3
    if-eqz v3, +003h
    goto +24h
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/platform/CmpPageSettings;->INSTANCE Lcom/bytedance/trae/home/solo/setting/platform/CmpPageSettings;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/platform/CmpPageSettings;->isSettingsEntryEnabled()Z
    move-result v3
    if-eqz v3, +010h
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;->Companion Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet$Companion;->newInstance()Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;
    move-result-object v3
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v2
    invoke-virtual v3, v2, v1, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    goto +eh
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->Companion Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$Companion;->newInstance()Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;
    move-result-object v3
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v2
    invoke-virtual v3, v2, v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    return-void 
.end method

.method private static final onViewCreated$lambda$3(com.bytedance.trae.home.solo.task.TaskFragment  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->retry()V
    return-void 
.end method

.method private static final onViewCreated$lambda$5(com.bytedance.trae.home.solo.task.TaskFragment  android.view.View)void
    .registers 4
    # ins_size=2
    new-instance v3, Landroid/content/Intent;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    const-string v1, "com.bytedance.trae.conversation.ConversationActivity"
    invoke-static v1, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    move-result-object v1
    invoke-direct v3, v0, v1, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const-string v0, "extra_enter_from"
    const-string/jumbo v1, task_list
    invoke-virtual v3, v0, v1, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v2, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method

.method private final renderSearchHeader(android.view.View  boolean  java.lang.String)void
    .registers 11
    # ins_size=4
    sget v0, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-virtual v8, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    sget v1, Lcom/bytedance/trae/home/R$id;->layout_task_search_header I
    invoke-virtual v8, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/home/R$id;->et_task_search I
    invoke-virtual v8, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/EditText;
    sget v3, Lcom/bytedance/trae/home/R$id;->btn_task_search_clear I
    invoke-virtual v8, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/home/R$id;->fab_add I
    invoke-virtual v8, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v8
    const/4 v4, 1
    const/16 v5, 8
    const/4 v6, 0
    if-eqz v9, +037h
    iget-boolean v9, v7, Lcom/bytedance/trae/home/solo/task/TaskFragment;->isSearchHeaderRendered Z
    if-nez v9, +00dh
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->isTaskOperationIconVisible()Z
    move-result v9
    if-eqz v9, +004h
    move v9, v6
    goto +2h
    move v9, v5
    iput v9, v7, Lcom/bytedance/trae/home/solo/task/TaskFragment;->operationIconVisibilityBeforeSearch I
    iput-boolean v4, v7, Lcom/bytedance/trae/home/solo/task/TaskFragment;->isSearchHeaderRendered Z
    const/4 v9, 4
    invoke-virtual v0, v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setVisibility(I)V
    invoke-virtual v1, v6, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v8, v5, Landroid/view/View;->setVisibility(I)V
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v7, v2, v10, Lcom/bytedance/trae/home/solo/task/TaskFragment;->syncSearchInputText(Landroid/widget/EditText; Ljava/lang/String;)V
    check-cast v10, Ljava/lang/CharSequence;
    invoke-interface v10, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-lez v8, +003h
    goto +2h
    move v4, v6
    if-eqz v4, +003h
    move v5, v6
    invoke-virtual v3, v5, Landroid/view/View;->setVisibility(I)V
    invoke-direct v7, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requestSearchInputFocus(Landroid/widget/EditText;)V
    goto +27h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const-string v9, ""
    invoke-direct v7, v2, v9, Lcom/bytedance/trae/home/solo/task/TaskFragment;->syncSearchInputText(Landroid/widget/EditText; Ljava/lang/String;)V
    invoke-virtual v3, v5, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v1, v5, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v0, v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setVisibility(I)V
    iget-boolean v9, v7, Lcom/bytedance/trae/home/solo/task/TaskFragment;->isSearchHeaderRendered Z
    if-eqz v9, +00bh
    iget v9, v7, Lcom/bytedance/trae/home/solo/task/TaskFragment;->operationIconVisibilityBeforeSearch I
    if-nez v9, +003h
    goto +2h
    move v4, v6
    invoke-virtual v0, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTaskOperationIconVisible(Z)V
    invoke-virtual v8, v6, Landroid/view/View;->setVisibility(I)V
    iput-boolean v6, v7, Lcom/bytedance/trae/home/solo/task/TaskFragment;->isSearchHeaderRendered Z
    invoke-direct v7, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->hideKeyboard(Landroid/widget/EditText;)V
    return-void 
.end method

.method private final renderTaskContent(com.bytedance.trae.home.solo.task.TaskFragment$TaskContentState  androidx.recyclerview.widget.RecyclerView  android.view.View  android.view.View  android.view.View  android.widget.TextView  android.view.View)void
    .registers 24
    # ins_size=8
    move-object/from16 v0, v16
    move-object/from16 v1, v18
    move-object/from16 v2, v19
    move-object/from16 v3, v20
    move-object/from16 v4, v21
    move-object/from16 v5, v22
    move-object/from16 v6, v23
    invoke-virtual/range v17, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->getQuery()Ljava/lang/String;
    move-result-object v7
    check-cast v7, Ljava/lang/CharSequence;
    invoke-static v7, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual/range v17, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchMode()Z
    move-result v8
    const/4 v9, 1
    const/4 v10, 0
    if-eqz v8, +012h
    move-object v8, v7
    check-cast v8, Ljava/lang/CharSequence;
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-lez v8, +004h
    move v8, v9
    goto +2h
    move v8, v10
    if-eqz v8, +004h
    move v8, v9
    goto +2h
    move v8, v10
    invoke-virtual/range v17, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->getHasError()Z
    move-result v11
    const/16 v12, 8
    if-eqz v11, +025h
    if-nez v8, +023h
    if-eqz v6, +005h
    invoke-virtual v6, v10, Landroid/view/View;->setVisibility(I)V
    if-eqz v1, +005h
    invoke-virtual v1, v12, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    if-eqz v2, +005h
    invoke-virtual v2, v12, Landroid/view/View;->setVisibility(I)V
    if-eqz v3, +005h
    invoke-virtual v3, v12, Landroid/view/View;->setVisibility(I)V
    if-eqz v4, +005h
    invoke-virtual v4, v12, Landroid/view/View;->setVisibility(I)V
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->swipeRefresh Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;
    if-eqz v1, +005h
    invoke-virtual v1, v12, Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;->setVisibility(I)V
    return-void 
    if-eqz v6, +005h
    invoke-virtual v6, v12, Landroid/view/View;->setVisibility(I)V
    sget-object v6, Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;->INSTANCE Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;
    invoke-virtual/range v17, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchMode()Z
    move-result v11
    invoke-virtual/range v17, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->getQuery()Ljava/lang/String;
    move-result-object v13
    invoke-virtual/range v17, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchLoading()Z
    move-result v14
    invoke-virtual/range v17, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->getSearchResults()Ljava/util/List;
    move-result-object v15
    invoke-virtual v6, v11, v13, v14, v15, Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;->isSearchPending(Z Ljava/lang/String; Z Ljava/util/List;)Z
    move-result v6
    if-eqz v6, +01eh
    iget-object v5, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->swipeRefresh Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;
    if-eqz v5, +005h
    invoke-virtual v5, v12, Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;->setVisibility(I)V
    if-eqz v1, +005h
    invoke-virtual v1, v12, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    if-eqz v2, +005h
    invoke-virtual v2, v12, Landroid/view/View;->setVisibility(I)V
    if-eqz v4, +005h
    invoke-virtual v4, v12, Landroid/view/View;->setVisibility(I)V
    if-eqz v3, +005h
    invoke-virtual v3, v10, Landroid/view/View;->setVisibility(I)V
    return-void 
    if-eqz v3, +005h
    invoke-virtual v3, v12, Landroid/view/View;->setVisibility(I)V
    if-eqz v8, +034h
    invoke-virtual/range v17, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->getTasks()Ljava/util/List;
    move-result-object v3
    invoke-interface v3, Ljava/util/List;->isEmpty()Z
    move-result v3
    if-eqz v3, +02ah
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->swipeRefresh Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;
    if-eqz v3, +005h
    invoke-virtual v3, v12, Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;->setVisibility(I)V
    if-eqz v1, +005h
    invoke-virtual v1, v12, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    if-eqz v2, +005h
    invoke-virtual v2, v12, Landroid/view/View;->setVisibility(I)V
    if-eqz v5, +011h
    sget v1, Lcom/bytedance/trae/home/R$string;->solo_task_search_empty_format I
    new-array v2, v9, [Ljava/lang/Object;
    aput-object v7, v2, v10
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v5, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    if-eqz v4, +005h
    invoke-virtual v4, v10, Landroid/view/View;->setVisibility(I)V
    return-void 
    if-eqz v4, +005h
    invoke-virtual v4, v12, Landroid/view/View;->setVisibility(I)V
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->swipeRefresh Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;
    if-eqz v3, +005h
    invoke-virtual v3, v10, Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;->setVisibility(I)V
    invoke-virtual/range v17, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->getTasks()Ljava/util/List;
    move-result-object v3
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    xor-int/2addr v3, v9
    if-eqz v3, +00dh
    if-eqz v1, +005h
    invoke-virtual v1, v10, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    if-eqz v2, +010h
    invoke-virtual v2, v12, Landroid/view/View;->setVisibility(I)V
    goto +bh
    if-eqz v1, +005h
    invoke-virtual v1, v12, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    if-eqz v2, +005h
    invoke-virtual v2, v10, Landroid/view/View;->setVisibility(I)V
    return-void 
.end method

.method private final requestSearchInputFocus(android.widget.EditText)void
    .registers 3
    # ins_size=2
    invoke-virtual v2, Landroid/widget/EditText;->hasFocus()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda20;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda20;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroid/widget/EditText;)V
    invoke-virtual v2, v0, Landroid/widget/EditText;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final requestSearchInputFocus$lambda$15(com.bytedance.trae.home.solo.task.TaskFragment  android.widget.EditText)void
    .registers 4
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->isAdded()Z
    move-result v0
    if-eqz v0, +03bh
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->isSearchMode()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    if-nez v0, +003h
    goto +1dh
    invoke-virtual v3, Landroid/widget/EditText;->requestFocus()Z
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    const-string v0, "input_method"
    invoke-virtual v2, v0, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v2
    instance-of v0, v2, Landroid/view/inputmethod/InputMethodManager;
    if-eqz v0, +005h
    move-object v1, v2
    check-cast v1, Landroid/view/inputmethod/InputMethodManager;
    if-eqz v1, +008h
    check-cast v3, Landroid/view/View;
    const/4 v2, 1
    invoke-virtual v1, v3, v2, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View; I)Z
    return-void 
.end method

.method private final setTaskListItemAnimationsSuppressed(androidx.recyclerview.widget.RecyclerView  boolean)void
    .registers 3
    # ins_size=3
    if-nez v1, +003h
    return-void 
    if-eqz v2, +010h
    invoke-virtual v1, Landroidx/recyclerview/widget/RecyclerView;->getItemAnimator()Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;
    move-result-object v2
    if-eqz v2, +005h
    invoke-virtual v2, Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;->endAnimations()V
    const/4 v2, 0
    invoke-virtual v1, v2, Landroidx/recyclerview/widget/RecyclerView;->setItemAnimator(Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;)V
    goto +ch
    invoke-virtual v1, Landroidx/recyclerview/widget/RecyclerView;->getItemAnimator()Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;
    move-result-object v2
    if-nez v2, +007h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->defaultTaskListItemAnimator Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;
    invoke-virtual v1, v2, Landroidx/recyclerview/widget/RecyclerView;->setItemAnimator(Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;)V
    return-void 
.end method

.method private final setupFilterItems(android.view.View)void
    .registers 15
    # ins_size=2
    iget-object v0, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    const/4 v1, 0
    const-string/jumbo v2, viewModel
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->getDevices()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    move-object v3, v0
    check-cast v3, Ljava/lang/Iterable;
    instance-of v4, v3, Ljava/util/Collection;
    const/4 v5, 1
    const/4 v6, 0
    if-eqz v4, +00dh
    move-object v7, v3
    check-cast v7, Ljava/util/Collection;
    invoke-interface v7, Ljava/util/Collection;->isEmpty()Z
    move-result v7
    if-eqz v7, +004h
    move v7, v6
    goto +22h
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, -00ah
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/home/solo/task/DeviceInfo;
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getType()Ljava/lang/String;
    move-result-object v8
    sget-object v9, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v9, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v9
    invoke-static v8, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, -01ah
    move v7, v5
    if-eqz v4, +00dh
    move-object v4, v3
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    if-eqz v4, +004h
    move v3, v6
    goto +22h
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, -00ah
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/home/solo/task/DeviceInfo;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getType()Ljava/lang/String;
    move-result-object v4
    sget-object v8, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v8, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v8
    invoke-static v4, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -01ah
    move v3, v5
    if-eqz v7, +005h
    if-eqz v3, +003h
    goto +2h
    move v5, v6
    iget-object v3, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    if-nez v3, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->getSelectedFilter()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/task/FilterOption;
    sget v2, Lcom/bytedance/trae/home/R$id;->ll_device_container I
    invoke-virtual v14, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/LinearLayout;
    sget v3, Lcom/bytedance/trae/home/R$id;->iv_check_all I
    invoke-virtual v14, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    instance-of v4, v1, Lcom/bytedance/trae/home/solo/task/FilterOption$All;
    const/16 v7, 8
    if-eqz v4, +004h
    move v4, v6
    goto +2h
    move v4, v7
    invoke-virtual v3, v4, Landroid/view/View;->setVisibility(I)V
    if-eqz v5, +010h
    const/16 v3, 12
    int-to-float v3, v3
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-virtual v4, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v4
    iget v4, v4, Landroid/util/DisplayMetrics;->density F
    goto +ch
    int-to-float v3, v7
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-virtual v4, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v4
    iget v4, v4, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v3, v4
    float-to-int v3, v3
    sget v4, Lcom/bytedance/trae/home/R$id;->iv_check_cloud I
    invoke-virtual v14, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    instance-of v8, v1, Lcom/bytedance/trae/home/solo/task/FilterOption$Cloud;
    if-eqz v8, +004h
    move v8, v6
    goto +2h
    move v8, v7
    invoke-virtual v4, v8, Landroid/view/View;->setVisibility(I)V
    sget v4, Lcom/bytedance/trae/home/R$id;->item_cloud I
    invoke-virtual v14, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    invoke-virtual v4, Landroid/view/View;->getPaddingLeft()I
    move-result v8
    invoke-virtual v4, Landroid/view/View;->getPaddingRight()I
    move-result v9
    invoke-virtual v4, v8, v3, v9, v3, Landroid/view/View;->setPadding(I I I I)V
    sget v4, Lcom/bytedance/trae/home/R$id;->item_all I
    invoke-virtual v14, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    new-instance v8, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda5;
    invoke-direct v8, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V
    invoke-virtual v4, v8, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v4, Lcom/bytedance/trae/home/R$id;->item_all I
    invoke-virtual v14, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    invoke-virtual v4, Landroid/view/View;->getPaddingLeft()I
    move-result v8
    invoke-virtual v4, Landroid/view/View;->getPaddingRight()I
    move-result v9
    invoke-virtual v4, v8, v3, v9, v3, Landroid/view/View;->setPadding(I I I I)V
    sget v3, Lcom/bytedance/trae/home/R$id;->item_cloud I
    invoke-virtual v14, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v14
    new-instance v3, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda6;
    invoke-direct v3, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V
    invoke-virtual v14, v3, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;
    move-result-object v14
    invoke-static v14, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v14
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +0dah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/home/solo/task/DeviceInfo;
    sget v4, Lcom/bytedance/trae/home/R$layout;->item_filter_device I
    move-object v8, v2
    check-cast v8, Landroid/view/ViewGroup;
    invoke-virtual v14, v4, v8, v6, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v4
    sget v8, Lcom/bytedance/trae/home/R$id;->tv_device_name I
    invoke-virtual v4, v8, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v8
    check-cast v8, Landroid/widget/TextView;
    sget v9, Lcom/bytedance/trae/home/R$id;->iv_device_icon I
    invoke-virtual v4, v9, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v9
    check-cast v9, Landroid/widget/ImageView;
    sget v10, Lcom/bytedance/trae/home/R$id;->iv_check_device I
    invoke-virtual v4, v10, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v10
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getName()Ljava/lang/String;
    move-result-object v11
    check-cast v11, Ljava/lang/CharSequence;
    invoke-virtual v8, v11, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->isOnline()Z
    move-result v8
    if-nez v8, +007h
    sget v8, Lcom/bytedance/trae/home/R$drawable;->ic_solo_filter_computer_off I
    invoke-virtual v9, v8, Landroid/widget/ImageView;->setImageResource(I)V
    sget v8, Lcom/bytedance/trae/home/R$id;->ll_product_tag I
    invoke-virtual v4, v8, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v8
    sget v9, Lcom/bytedance/trae/home/R$id;->tv_product_type I
    invoke-virtual v4, v9, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v9
    check-cast v9, Landroid/widget/TextView;
    if-nez v5, +006h
    invoke-virtual v8, v7, Landroid/view/View;->setVisibility(I)V
    goto +5eh
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getType()Ljava/lang/String;
    move-result-object v11
    sget-object v12, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v12, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v12
    invoke-static v11, v12, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v11
    if-eqz v11, +01fh
    invoke-virtual v8, v6, Landroid/view/View;->setVisibility(I)V
    sget v11, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_trae_work I
    invoke-virtual v8, v11, Landroid/view/View;->setBackgroundResource(I)V
    const-string v8, "TRAE Work"
    check-cast v8, Ljava/lang/CharSequence;
    invoke-virtual v9, v8, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;
    move-result-object v8
    sget v11, Lcom/bytedance/trae/home/R$color;->solo_filter_tag_trae_work I
    invoke-static v8, v11, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v8
    invoke-virtual v9, v8, Landroid/widget/TextView;->setTextColor(I)V
    goto +31h
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getType()Ljava/lang/String;
    move-result-object v11
    sget-object v12, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v12, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v12
    invoke-static v11, v12, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v11
    if-eqz v11, +01fh
    invoke-virtual v8, v6, Landroid/view/View;->setVisibility(I)V
    sget v11, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_trae_ide I
    invoke-virtual v8, v11, Landroid/view/View;->setBackgroundResource(I)V
    const-string v8, "TRAE IDE"
    check-cast v8, Ljava/lang/CharSequence;
    invoke-virtual v9, v8, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;
    move-result-object v8
    sget v11, Lcom/bytedance/trae/home/R$color;->solo_filter_tag_trae_ide I
    invoke-static v8, v11, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v8
    invoke-virtual v9, v8, Landroid/widget/TextView;->setTextColor(I)V
    goto +4h
    invoke-virtual v8, v7, Landroid/view/View;->setVisibility(I)V
    instance-of v8, v1, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;
    if-eqz v8, +015h
    move-object v8, v1
    check-cast v8, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;->getCliId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getCliId()Ljava/lang/String;
    move-result-object v9
    invoke-static v8, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +004h
    move v8, v6
    goto +2h
    move v8, v7
    invoke-virtual v10, v8, Landroid/view/View;->setVisibility(I)V
    sget v8, Lcom/bytedance/trae/home/R$id;->item_device I
    invoke-virtual v4, v8, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v8
    new-instance v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda7;
    invoke-direct v9, v13, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lcom/bytedance/trae/home/solo/task/DeviceInfo;)V
    invoke-virtual v8, v9, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v2, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto/16 -0dch
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getView()Landroid/view/View;
    move-result-object v14
    if-eqz v14, +00fh
    sget v0, Lcom/bytedance/trae/home/R$id;->iv_avatar I
    invoke-virtual v14, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v14
    check-cast v14, Lcom/facebook/drawee/view/SimpleDraweeView;
    if-eqz v14, +005h
    invoke-direct v13, v14, Lcom/bytedance/trae/home/solo/task/TaskFragment;->loadAvatar(Lcom/facebook/drawee/view/SimpleDraweeView;)V
    return-void 
.end method

.method private static final setupFilterItems$lambda$20(com.bytedance.trae.home.solo.task.TaskFragment  android.view.View)void
    .registers 3
    # ins_size=2
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    if-nez v2, +009h
    const-string/jumbo v2, viewModel
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    sget-object v0, Lcom/bytedance/trae/home/solo/task/FilterOption$All;->INSTANCE Lcom/bytedance/trae/home/solo/task/FilterOption$All;
    check-cast v0, Lcom/bytedance/trae/home/solo/task/FilterOption;
    invoke-virtual v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->setFilter(Lcom/bytedance/trae/home/solo/task/FilterOption;)V
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getView()Landroid/view/View;
    move-result-object v2
    if-eqz v2, +017h
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_title I
    invoke-virtual v2, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/TextView;
    if-eqz v2, +00dh
    sget v0, Lcom/bytedance/trae/home/R$string;->solo_task_title I
    invoke-virtual v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v2, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->dismissFilterPopup()V
    return-void 
.end method

.method private static final setupFilterItems$lambda$21(com.bytedance.trae.home.solo.task.TaskFragment  android.view.View)void
    .registers 3
    # ins_size=2
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    if-nez v2, +009h
    const-string/jumbo v2, viewModel
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    sget-object v0, Lcom/bytedance/trae/home/solo/task/FilterOption$Cloud;->INSTANCE Lcom/bytedance/trae/home/solo/task/FilterOption$Cloud;
    check-cast v0, Lcom/bytedance/trae/home/solo/task/FilterOption;
    invoke-virtual v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->setFilter(Lcom/bytedance/trae/home/solo/task/FilterOption;)V
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getView()Landroid/view/View;
    move-result-object v2
    if-eqz v2, +017h
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_title I
    invoke-virtual v2, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/TextView;
    if-eqz v2, +00dh
    sget v0, Lcom/bytedance/trae/home/R$string;->solo_filter_cloud I
    invoke-virtual v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v2, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->dismissFilterPopup()V
    return-void 
.end method

.method private static final setupFilterItems$lambda$22(com.bytedance.trae.home.solo.task.TaskFragment  com.bytedance.trae.home.solo.task.DeviceInfo  android.view.View)void
    .registers 6
    # ins_size=3
    iget-object v5, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    if-nez v5, +009h
    const-string/jumbo v5, viewModel
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v5, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getCliId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/home/solo/task/FilterOption;
    invoke-virtual v5, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->setFilter(Lcom/bytedance/trae/home/solo/task/FilterOption;)V
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getView()Landroid/view/View;
    move-result-object v5
    if-eqz v5, +015h
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_title I
    invoke-virtual v5, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    check-cast v5, Landroid/widget/TextView;
    if-eqz v5, +00bh
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getName()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v5, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v3, Lcom/bytedance/trae/home/solo/task/TaskFragment;->dismissFilterPopup()V
    return-void 
.end method

.method private final setupHeader(android.view.View)void
    .registers 8
    # ins_size=2
    sget v0, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-virtual v7, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    sget v1, Lcom/bytedance/trae/home/R$id;->iv_chevron I
    invoke-virtual v7, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/ImageView;
    sget v2, Lcom/bytedance/trae/home/R$id;->ll_title_filter I
    invoke-virtual v7, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/home/R$id;->et_task_search I
    invoke-virtual v7, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/EditText;
    sget v4, Lcom/bytedance/trae/home/R$id;->btn_task_search_clear I
    invoke-virtual v7, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    sget v5, Lcom/bytedance/trae/home/R$id;->btn_task_search_exit I
    invoke-virtual v7, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v7
    new-instance v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda1;
    invoke-direct v5, v6, v2, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroid/view/View; Landroid/widget/ImageView;)V
    invoke-virtual v0, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnTaskTitleClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda2;
    invoke-direct v1, v6, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnTaskSearchClickListener(Landroid/view/View$OnClickListener;)V
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    check-cast v3, Landroid/widget/TextView;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$setupHeader$$inlined$doAfterTextChanged$1;
    invoke-direct v0, v6, Lcom/bytedance/trae/home/solo/task/TaskFragment$setupHeader$$inlined$doAfterTextChanged$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V
    check-cast v0, Landroid/text/TextWatcher;
    invoke-virtual v3, v0, Landroid/widget/TextView;->addTextChangedListener(Landroid/text/TextWatcher;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda3;
    invoke-direct v0, v6, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V
    invoke-virtual v4, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda4;
    invoke-direct v0, v6, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V
    invoke-virtual v7, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupHeader$lambda$10(com.bytedance.trae.home.solo.task.TaskFragment  android.view.View  android.widget.ImageView  android.view.View)void
    .registers 4
    # ins_size=4
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->adapter Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    if-nez v3, +008h
    const-string v3, "adapter"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v3, 0
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->closeOpenItem()V
    iget-boolean v3, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->isFilterOpen Z
    if-eqz v3, +006h
    invoke-direct v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->dismissFilterPopup()V
    goto +ah
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showFilterPopup(Landroid/view/View; Landroid/widget/ImageView;)V
    return-void 
.end method

.method private static final setupHeader$lambda$11(com.bytedance.trae.home.solo.task.TaskFragment  android.view.View)void
    .registers 3
    # ins_size=2
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->adapter Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    const/4 v0, 0
    if-nez v2, +008h
    const-string v2, "adapter"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v0
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->closeOpenItem()V
    invoke-direct v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->dismissFilterPopup()V
    iget-object v1, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    if-nez v1, +009h
    const-string/jumbo v1, viewModel
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->enterSearchMode()V
    return-void 
.end method

.method private static final setupHeader$lambda$13(com.bytedance.trae.home.solo.task.TaskFragment  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->clearSearchQuery()V
    return-void 
.end method

.method private static final setupHeader$lambda$14(com.bytedance.trae.home.solo.task.TaskFragment  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->exitSearchMode()V
    return-void 
.end method

.method private final setupRecyclerView(android.view.View)void
    .registers 11
    # ins_size=2
    sget v0, Lcom/bytedance/trae/home/R$id;->rv_tasks I
    invoke-virtual v10, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const-string v1, "findViewById(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView;
    iget-object v1, v9, Lcom/bytedance/trae/home/solo/task/TaskFragment;->fpsTracer Lcom/bytedance/apm/trace/fps/FpsTracer;
    invoke-virtual v1, v0, Lcom/bytedance/apm/trace/fps/FpsTracer;->startRecyclerView(Landroidx/recyclerview/widget/RecyclerView;)V
    sget v1, Lcom/bytedance/trae/home/R$id;->swipe_refresh I
    invoke-virtual v10, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v10
    check-cast v10, Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;
    iput-object v10, v9, Lcom/bytedance/trae/home/solo/task/TaskFragment;->swipeRefresh Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;
    if-eqz v10, +00ah
    new-instance v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda13;
    invoke-direct v1, v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda13;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V
    invoke-virtual v10, v1, Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;->setOnRefreshListener(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;)V
    new-instance v10, Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    new-instance v3, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda14;
    invoke-direct v3, v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda14;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V
    new-instance v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda15;
    invoke-direct v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda15;-><init>()V
    new-instance v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda16;
    invoke-direct v5, v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda16;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V
    new-instance v6, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda17;
    invoke-direct v6, v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda17;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V
    new-instance v7, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda18;
    invoke-direct v7, v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda18;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V
    new-instance v8, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda19;
    invoke-direct v8, v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda19;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V
    move-object v2, v10
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/home/solo/task/TaskAdapter;-><init>(Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function3; Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2;)V
    iput-object v10, v9, Lcom/bytedance/trae/home/solo/task/TaskFragment;->adapter Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    new-instance v10, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    invoke-direct v10, v1, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V
    check-cast v10, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v0, v10, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/task/TaskFragment;->adapter Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    if-nez v10, +008h
    const-string v10, "adapter"
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v10, 0
    check-cast v10, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v0, v10, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    invoke-virtual v0, Landroidx/recyclerview/widget/RecyclerView;->getItemAnimator()Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;
    move-result-object v10
    iput-object v10, v9, Lcom/bytedance/trae/home/solo/task/TaskFragment;->defaultTaskListItemAnimator Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;
    new-instance v10, Lcom/bytedance/trae/home/solo/task/TaskFragment$setupRecyclerView$8;
    invoke-direct v10, v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$setupRecyclerView$8;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V
    check-cast v10, Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;
    invoke-virtual v0, v10, Landroidx/recyclerview/widget/RecyclerView;->addOnScrollListener(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V
    return-void 
.end method

.method private static final setupRecyclerView$lambda$24(com.bytedance.trae.home.solo.task.TaskFragment)void
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->refreshTasks()V
    return-void 
.end method

.method private static final setupRecyclerView$lambda$26(com.bytedance.trae.home.solo.task.TaskFragment  com.bytedance.trae.home.solo.task.TaskModel  int)kotlin.Unit
    .registers 38
    # ins_size=3
    move-object/from16 v0, v35
    const-string/jumbo v1, task
    move-object/from16 v2, v36
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/task/TaskModel;->getStatus()Lcom/bytedance/trae/home/solo/task/TaskStatus;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/TaskStatus;->getLabel()Ljava/lang/String;
    move-result-object v4
    sget-object v5, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v4, v5, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v5, toLowerCase(...)
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move/from16 v6, v37
    invoke-virtual v1, v3, v4, v6, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->trackTaskCardClick(Ljava/lang/String; Ljava/lang/String; I)V
    new-instance v1, Landroid/content/Intent;
    invoke-virtual/range v35, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;
    move-result-object v3
    const-class v4, Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v1, v3, v4, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/task/TaskModel;->getSearchAnchorCreatedAtMs()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +007h
    const-string v4, "extra_anchor_created_at_ms"
    invoke-virtual v1, v4, v3, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v3, "extra_enter_from"
    const-string/jumbo v4, task_list
    invoke-virtual v1, v3, v4, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    if-nez v3, +009h
    const-string/jumbo v3, viewModel
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v3, 0
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->getConversation(Ljava/lang/String;)Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v3
    if-nez v3, +06bh
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/task/TaskModel;->getTitle()Ljava/lang/String;
    move-result-object v13
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/task/TaskModel;->getCliId()Ljava/lang/String;
    move-result-object v12
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/task/TaskModel;->getMode()Ljava/lang/String;
    move-result-object v16
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/task/TaskModel;->getCliType()Ljava/lang/String;
    move-result-object v18
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/task/TaskModel;->getStatus()Lcom/bytedance/trae/home/solo/task/TaskStatus;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskStatus;->getStatusCode()I
    move-result v3
    invoke-static v3, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v17
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned()Z
    move-result v3
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/task/TaskModel;->getPinnedAt()Ljava/lang/String;
    move-result-object v32
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/task/TaskModel;->getUpdatedAt()Ljava/lang/String;
    move-result-object v23
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/task/TaskModel;->getIconType()Lcom/bytedance/trae/home/solo/task/TaskIconType;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/TaskIconType;->name()Ljava/lang/String;
    move-result-object v4
    sget-object v6, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v4, v6, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v4
    move-object/from16 v25, v4
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v4, Lcom/bytedance/trae/im/service/Conversation;
    move-object v6, v4
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v24, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v31
    const v33, 16445854
    const/16 v34, 0
    invoke-direct/range v6 ... v34, Lcom/bytedance/trae/im/service/Conversation;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ConversationSource; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v3, v4
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    const-string v5, "extra_icon_type"
    const-string v6, "extra_conversation"
    if-eqz v4, +014h
    check-cast v3, Ljava/io/Serializable;
    invoke-virtual v1, v6, v3, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/io/Serializable;)Landroid/content/Intent;
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/task/TaskModel;->getIconType()Lcom/bytedance/trae/home/solo/task/TaskIconType;
    move-result-object v2
    check-cast v2, Ljava/io/Serializable;
    invoke-virtual v1, v5, v2, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/io/Serializable;)Landroid/content/Intent;
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->startActivity(Landroid/content/Intent;)V
    goto +33h
    sget-object v4, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v4
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v4, v7, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +024h
    sget-object v4, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v4
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v4, v7, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Lcom/bytedance/trae/im/service/Conversation;->setEnvironment(Ljava/lang/String;)V
    check-cast v3, Ljava/io/Serializable;
    invoke-virtual v1, v6, v3, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/io/Serializable;)Landroid/content/Intent;
    invoke-virtual/range v36, Lcom/bytedance/trae/home/solo/task/TaskModel;->getIconType()Lcom/bytedance/trae/home/solo/task/TaskIconType;
    move-result-object v2
    check-cast v2, Ljava/io/Serializable;
    invoke-virtual v1, v5, v2, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/io/Serializable;)Landroid/content/Intent;
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->startActivity(Landroid/content/Intent;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final setupRecyclerView$lambda$27(com.bytedance.trae.home.solo.task.TaskModel)kotlin.Unit
    .registers 2
    # ins_size=1
    const-string/jumbo v0, task
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->trackTaskCardSlide(Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final setupRecyclerView$lambda$28(com.bytedance.trae.home.solo.task.TaskFragment  com.bytedance.trae.home.solo.task.TaskModel  float  float)kotlin.Unit
    .registers 5
    # ins_size=4
    const-string/jumbo v0, task
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showActionPopup(Lcom/bytedance/trae/home/solo/task/TaskModel; F F)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final setupRecyclerView$lambda$29(com.bytedance.trae.home.solo.task.TaskFragment  com.bytedance.trae.home.solo.task.TaskModel  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 6
    # ins_size=3
    const-string/jumbo v0, task
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "closeAction"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned()Z
    move-result v0
    const/4 v1, 0
    const-string/jumbo v2, viewModel
    if-eqz v0, +00fh
    iget-object v3, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    if-nez v3, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    invoke-virtual v1, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->unpinConversation(Lcom/bytedance/trae/home/solo/task/TaskModel;)V
    goto +13h
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v0
    iput-object v0, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment;->suppressNextTopChangedScrollTaskId Ljava/lang/String;
    iget-object v3, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    if-nez v3, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    invoke-virtual v1, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->pinConversation(Lcom/bytedance/trae/home/solo/task/TaskModel;)V
    invoke-interface v5, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private static final setupRecyclerView$lambda$30(com.bytedance.trae.home.solo.task.TaskFragment  com.bytedance.trae.home.solo.task.TaskModel  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 5
    # ins_size=3
    const-string/jumbo v0, task
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "closeAction"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->trackTaskRenameClick(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->getTitle()Ljava/lang/String;
    move-result-object v3
    invoke-direct v2, v0, v3, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showRenameDialog(Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function0;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final setupRecyclerView$lambda$31(com.bytedance.trae.home.solo.task.TaskFragment  com.bytedance.trae.home.solo.task.TaskModel  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 5
    # ins_size=3
    const-string/jumbo v0, task
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "closeAction"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->trackTaskDeleteClick(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v3
    invoke-direct v2, v3, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showDeleteDialog(Ljava/lang/String; Lkotlin/jvm/functions/Function0;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private final setupTaskTitleBar(android.view.View)com.bytedance.trae.common.widget.TraeTitleBar
    .registers 12
    # ins_size=2
    sget v0, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-virtual v11, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v11
    move-object v9, v11
    check-cast v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    invoke-virtual v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;->showTaskListHeader()V
    sget v0, Lcom/bytedance/trae/home/R$string;->solo_task_title I
    invoke-virtual v9, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTitle(I)V
    sget v1, Lcom/bytedance/trae/home/R$id;->ll_title_filter I
    sget v2, Lcom/bytedance/trae/home/R$id;->tv_title I
    sget v3, Lcom/bytedance/trae/home/R$id;->iv_chevron I
    sget v4, Lcom/bytedance/trae/home/R$id;->btn_task_search_entry I
    sget v5, Lcom/bytedance/trae/home/R$id;->fl_avatar_container I
    sget v6, Lcom/bytedance/trae/home/R$id;->iv_avatar I
    sget v7, Lcom/bytedance/trae/home/R$id;->iv_bytecloud_badge I
    sget v8, Lcom/bytedance/trae/home/R$id;->iv_operation_icon I
    move-object v0, v9
    invoke-virtual/range v0 ... v8, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTaskHeaderViewIds(I I I I I I I I)V
    sget v0, Lcom/bytedance/trae/home/R$drawable;->ic_solo_drop_down I
    invoke-virtual v9, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTaskTitleTrailingIcon(I)V
    sget v0, Lcom/bytedance/trae/home/R$drawable;->ic_task_search I
    invoke-virtual v9, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTaskSearchIcon(I)V
    sget v0, Lcom/bytedance/trae/home/R$string;->solo_task_search_entry_content_description I
    invoke-virtual v10, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v9, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTaskSearchContentDescription(Ljava/lang/CharSequence;)V
    sget-object v0, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->INSTANCE Lcom/bytedance/trae/settings/api/feature/FeatureCapability;
    sget-object v1, Lcom/bytedance/trae/settings/api/feature/Feature;->TASK_LIST_SEARCH Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-virtual v0, v1, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->isEnabled(Lcom/bytedance/trae/settings/api/feature/Feature;)Z
    move-result v0
    invoke-virtual v9, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTaskSearchButtonVisible(Z)V
    sget v0, Lcom/bytedance/trae/home/R$drawable;->trae_ic_bytecloud_badge_small I
    invoke-virtual v9, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTaskAvatarBadgeImageResource(I)V
    const-string v0, "apply(...)"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v9
.end method

.method private final showActionPopup(com.bytedance.trae.home.solo.task.TaskModel  float  float)void
    .registers 29
    # ins_size=4
    move-object/from16 v0, v25
    move-object/from16 v1, v26
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->actionPopup Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
    if-eqz v2, +005h
    invoke-virtual v2, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->dismiss()V
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->adapter Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    if-nez v2, +008h
    const-string v2, "adapter"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->closeOpenItem()V
    invoke-static Lkotlin/collections/CollectionsKt;->createListBuilder()Ljava/util/List;
    move-result-object v2
    invoke-virtual/range v26, Lcom/bytedance/trae/home/solo/task/TaskModel;->getSupportsPin()Z
    move-result v3
    const-string v4, "getString(...)"
    if-eqz v3, +043h
    sget-object v3, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->INSTANCE Lcom/bytedance/trae/settings/api/feature/FeatureCapability;
    sget-object v5, Lcom/bytedance/trae/settings/api/feature/Feature;->TASK_LIST_PIN Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-virtual v3, v5, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->isEnabled(Lcom/bytedance/trae/settings/api/feature/Feature;)Z
    move-result v3
    if-eqz v3, +039h
    new-instance v3, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
    invoke-virtual/range v26, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned()Z
    move-result v5
    if-eqz v5, +005h
    sget v5, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_context_menu_unpin I
    goto +3h
    sget v5, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_context_menu_pin I
    move v6, v5
    invoke-virtual/range v26, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned()Z
    move-result v5
    if-eqz v5, +005h
    sget v5, Lcom/bytedance/trae/home/R$string;->solo_context_menu_unpin I
    goto +3h
    sget v5, Lcom/bytedance/trae/home/R$string;->solo_context_menu_pin I
    invoke-virtual v0, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v7, v5
    check-cast v7, Ljava/lang/CharSequence;
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    sget v11, Lcom/bytedance/trae/home/R$id;->menu_pin I
    new-instance v12, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda24;
    invoke-direct v12, v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda24;-><init>(Lcom/bytedance/trae/home/solo/task/TaskModel; Lcom/bytedance/trae/home/solo/task/TaskFragment;)V
    const/16 v13, 28
    const/4 v14, 0
    move-object v5, v3
    invoke-direct/range v5 ... v14, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;-><init>(I Ljava/lang/CharSequence; Z Ljava/lang/Integer; Ljava/lang/Integer; I Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v2, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    new-instance v3, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
    sget v16, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_context_menu_rename I
    sget v5, Lcom/bytedance/trae/home/R$string;->solo_context_menu_rename I
    invoke-virtual v0, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object/from16 v17, v5
    check-cast v17, Ljava/lang/CharSequence;
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    sget v21, Lcom/bytedance/trae/home/R$id;->menu_rename I
    new-instance v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda25;
    invoke-direct v5, v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda25;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lcom/bytedance/trae/home/solo/task/TaskModel;)V
    const/16 v23, 28
    const/16 v24, 0
    move-object v15, v3
    move-object/from16 v22, v5
    invoke-direct/range v15 ... v24, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;-><init>(I Ljava/lang/CharSequence; Z Ljava/lang/Integer; Ljava/lang/Integer; I Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v2, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    new-instance v3, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
    sget v7, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_context_menu_delete I
    sget v5, Lcom/bytedance/trae/home/R$string;->solo_context_menu_delete I
    invoke-virtual v0, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v8, v5
    check-cast v8, Ljava/lang/CharSequence;
    const/4 v9, 1
    const/4 v10, 0
    const/4 v11, 0
    sget v12, Lcom/bytedance/trae/home/R$id;->menu_delete I
    new-instance v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda26;
    invoke-direct v13, v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda26;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lcom/bytedance/trae/home/solo/task/TaskModel;)V
    const/16 v14, 24
    const/4 v15, 0
    move-object v6, v3
    invoke-direct/range v6 ... v15, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;-><init>(I Ljava/lang/CharSequence; Z Ljava/lang/Integer; Ljava/lang/Integer; I Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v2, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-static v2, Lkotlin/collections/CollectionsKt;->build(Ljava/util/List;)Ljava/util/List;
    move-result-object v18
    new-instance v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
    invoke-virtual/range v25, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    const-string/jumbo v3, requireContext(...)
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/16 v19, 0
    const/16 v20, 4
    const/16 v21, 0
    move-object/from16 v16, v1
    move-object/from16 v17, v2
    invoke-direct/range v16 ... v21, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;-><init>(Landroid/content/Context; Ljava/util/List; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual/range v25, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireView()Landroid/view/View;
    move-result-object v2
    const-string/jumbo v3, requireView(...)
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move/from16 v3, v27
    move/from16 v4, v28
    invoke-virtual v1, v2, v3, v4, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->showNear(Landroid/view/View; F F)V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->actionPopup Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
    return-void 
.end method

.method private static final showActionPopup$lambda$37$lambda$32(com.bytedance.trae.home.solo.task.TaskModel  com.bytedance.trae.home.solo.task.TaskFragment)kotlin.Unit
    .registers 5
    # ins_size=2
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned()Z
    move-result v0
    const/4 v1, 0
    const-string/jumbo v2, viewModel
    if-eqz v0, +00fh
    iget-object v4, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    if-nez v4, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v4
    invoke-virtual v1, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->unpinConversation(Lcom/bytedance/trae/home/solo/task/TaskModel;)V
    goto +13h
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v0
    iput-object v0, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment;->suppressNextTopChangedScrollTaskId Ljava/lang/String;
    iget-object v4, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    if-nez v4, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v4
    invoke-virtual v1, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->pinConversation(Lcom/bytedance/trae/home/solo/task/TaskModel;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private static final showActionPopup$lambda$37$lambda$34(com.bytedance.trae.home.solo.task.TaskFragment  com.bytedance.trae.home.solo.task.TaskModel)kotlin.Unit
    .registers 4
    # ins_size=2
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->getTitle()Ljava/lang/String;
    move-result-object v3
    new-instance v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda23;
    invoke-direct v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda23;-><init>()V
    invoke-direct v2, v0, v3, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showRenameDialog(Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function0;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final showActionPopup$lambda$37$lambda$34$lambda$33()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final showActionPopup$lambda$37$lambda$36(com.bytedance.trae.home.solo.task.TaskFragment  com.bytedance.trae.home.solo.task.TaskModel)kotlin.Unit
    .registers 3
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v2
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda27;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda27;-><init>()V
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showDeleteDialog(Ljava/lang/String; Lkotlin/jvm/functions/Function0;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final showActionPopup$lambda$37$lambda$36$lambda$35()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final showDeleteDialog(java.lang.String  kotlin.jvm.functions.Function0)void
    .registers 24
    # ins_size=3
    move-object/from16 v0, v21
    sget-object v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->Companion Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;
    invoke-virtual/range v21, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;
    move-result-object v3
    move-object v2, v3
    const-string/jumbo v4, requireContext(...)
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/home/R$string;->solo_dialog_delete_title I
    invoke-virtual v0, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;
    move-result-object v4
    move-object v3, v4
    const-string v7, "getString(...)"
    invoke-static v4, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/home/R$string;->solo_dialog_delete_message I
    invoke-virtual v0, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;
    move-result-object v5
    move-object v4, v5
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v5, Lcom/bytedance/trae/home/R$string;->solo_dialog_btn_cancel I
    invoke-virtual v0, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;
    move-result-object v6
    move-object v5, v6
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v6, Lcom/bytedance/trae/home/R$string;->solo_dialog_btn_delete I
    invoke-virtual v0, v6, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;
    move-result-object v8
    move-object v6, v8
    invoke-static v8, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    new-instance v7, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda21;
    move-object/from16 v17, v7
    move-object/from16 v8, v22
    invoke-direct v7, v0, v8, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda21;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment; Ljava/lang/String;)V
    const/16 v18, 0
    const v19, 98272
    const/16 v20, 0
    const/4 v7, 0
    const/4 v8, 0
    invoke-static/range v1 ... v20, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;->delete$default(Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I I Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda22;
    move-object/from16 v3, v23
    invoke-direct v2, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda22;-><init>(Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->show()V
    return-void 
.end method

.method private static final showDeleteDialog$lambda$41(com.bytedance.trae.home.solo.task.TaskFragment  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->deleteConversation(Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final showDeleteDialog$lambda$42(kotlin.jvm.functions.Function0  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private final showFilterPopup(android.view.View  android.widget.ImageView)void
    .registers 9
    # ins_size=3
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    invoke-static v0, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/home/R$layout;->dialog_task_filter I
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup;)Landroid/view/View;
    move-result-object v0
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->density F
    const/16 v2, 200
    int-to-float v2, v2
    mul-float/2addr v2, v1
    float-to-int v2, v2
    new-instance v3, Landroid/widget/PopupWindow;
    const/4 v4, -2
    const/4 v5, 1
    invoke-direct v3, v0, v4, v4, v5, Landroid/widget/PopupWindow;-><init>(Landroid/view/View; I I Z)V
    const/high16 v4, 1090519040
    mul-float/2addr v4, v1
    invoke-virtual v3, v4, Landroid/widget/PopupWindow;->setElevation(F)V
    invoke-virtual v3, v5, Landroid/widget/PopupWindow;->setOutsideTouchable(Z)V
    new-instance v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda12;
    invoke-direct v4, v6, v8, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda12;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroid/widget/ImageView;)V
    invoke-virtual v3, v4, Landroid/widget/PopupWindow;->setOnDismissListener(Landroid/widget/PopupWindow$OnDismissListener;)V
    iput-object v3, v6, Lcom/bytedance/trae/home/solo/task/TaskFragment;->filterPopup Landroid/widget/PopupWindow;
    invoke-virtual v0, v2, Landroid/view/View;->setMinimumWidth(I)V
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v6, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupFilterItems(Landroid/view/View;)V
    iput-boolean v5, v6, Lcom/bytedance/trae/home/solo/task/TaskFragment;->isFilterOpen Z
    const/high16 v0, 1127481344
    invoke-virtual v8, v0, Landroid/widget/ImageView;->setRotation(F)V
    const/16 v8, 8
    int-to-float v8, v8
    mul-float/2addr v8, v1
    float-to-int v8, v8
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/task/TaskFragment;->filterPopup Landroid/widget/PopupWindow;
    if-eqz v0, +006h
    const/4 v1, 0
    invoke-virtual v0, v7, v1, v8, Landroid/widget/PopupWindow;->showAsDropDown(Landroid/view/View; I I)V
    return-void 
.end method

.method private static final showFilterPopup$lambda$17$lambda$16(com.bytedance.trae.home.solo.task.TaskFragment  android.widget.ImageView)void
    .registers 3
    # ins_size=2
    const/4 v0, 0
    iput-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->isFilterOpen Z
    const/4 v1, 0
    invoke-virtual v2, v1, Landroid/widget/ImageView;->setRotation(F)V
    return-void 
.end method

.method private final showRenameDialog(java.lang.String  java.lang.String  kotlin.jvm.functions.Function0)void
    .registers 15
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->Companion Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    const-string/jumbo v2, requireContext(...)
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/home/R$string;->solo_dialog_rename_title I
    invoke-virtual v11, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;
    move-result-object v2
    const-string v3, "getString(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v4, 0
    sget v5, Lcom/bytedance/trae/home/R$string;->solo_dialog_btn_cancel I
    invoke-virtual v11, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v6, Lcom/bytedance/trae/home/R$string;->solo_dialog_btn_confirm I
    invoke-virtual v11, v6, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v7, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda0;
    invoke-direct v7, v11, v12, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment; Ljava/lang/String;)V
    const/4 v8, 0
    const/16 v9, 136
    const/4 v10, 0
    move-object v3, v13
    invoke-static/range v0 ... v10, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;->rename$default(Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    move-result-object v12
    new-instance v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda11;
    invoke-direct v13, v14, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda11;-><init>(Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v12, v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V
    invoke-virtual v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->show()V
    return-void 
.end method

.method private static final showRenameDialog$lambda$39(com.bytedance.trae.home.solo.task.TaskFragment  java.lang.String  java.lang.String)kotlin.Unit
    .registers 5
    # ins_size=3
    move-object v0, v4
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
    if-nez v0, +012h
    iput-boolean v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->shouldScrollToTop Z
    iget-object v2, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    if-nez v2, +009h
    const-string/jumbo v2, viewModel
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    invoke-virtual v2, v3, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->renameConversation(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final showRenameDialog$lambda$40(kotlin.jvm.functions.Function0  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private final syncSearchInputText(android.widget.EditText  java.lang.String)void
    .registers 4
    # ins_size=3
    invoke-virtual v2, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00fh
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v2, v0, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v3, Ljava/lang/String;->length()I
    move-result v3
    invoke-virtual v2, v3, Landroid/widget/EditText;->setSelection(I)V
    return-void 
.end method

.method private final titleForFilter(com.bytedance.trae.home.solo.task.FilterOption)java.lang.String
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/home/solo/task/FilterOption$All;->INSTANCE Lcom/bytedance/trae/home/solo/task/FilterOption$All;
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    const-string v1, "getString(...)"
    if-eqz v0, +00ch
    sget v3, Lcom/bytedance/trae/home/R$string;->solo_task_title I
    invoke-virtual v2, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +1dh
    sget-object v0, Lcom/bytedance/trae/home/solo/task/FilterOption$Cloud;->INSTANCE Lcom/bytedance/trae/home/solo/task/FilterOption$Cloud;
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00ch
    sget v3, Lcom/bytedance/trae/home/R$string;->solo_filter_cloud I
    invoke-virtual v2, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +bh
    instance-of v0, v3, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;
    if-eqz v0, +009h
    check-cast v3, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;->getName()Ljava/lang/String;
    move-result-object v3
    return-object v3
    new-instance v3, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v3, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v3
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/home/R$layout;->fragment_task I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onDestroyView()void
    .registers 3
    # ins_size=1
    invoke-super v2, Landroidx/fragment/app/Fragment;->onDestroyView()V
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->filterPopup Landroid/widget/PopupWindow;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/widget/PopupWindow;->dismiss()V
    const/4 v0, 0
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->filterPopup Landroid/widget/PopupWindow;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->actionPopup Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
    if-eqz v1, +005h
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->dismiss()V
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment;->actionPopup Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
    return-void 
.end method

.method public onPause()void
    .registers 2
    # ins_size=1
    invoke-super v1, Landroidx/fragment/app/Fragment;->onPause()V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    if-eqz v0, +00eh
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->stopPolling()V
    return-void 
.end method

.method public onResume()void
    .registers 12
    # ins_size=1
    invoke-super v11, Landroidx/fragment/app/Fragment;->onResume()V
    iget-object v0, v11, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    if-eqz v0, +0e9h
    const/4 v1, 0
    const-string/jumbo v2, viewModel
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->forceLoadTasks()V
    iget-object v0, v11, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->loadDevices()V
    iget-object v0, v11, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->startPollingIfNeeded()V
    iget-boolean v0, v11, Lcom/bytedance/trae/home/solo/task/TaskFragment;->isFirstResume Z
    if-eqz v0, +005h
    const-string v0, "new_create"
    goto +3h
    const-string v0, ""
    move-object v5, v0
    const/4 v0, 0
    iput-boolean v0, v11, Lcom/bytedance/trae/home/solo/task/TaskFragment;->isFirstResume Z
    iget-object v3, v11, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    if-nez v3, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->getTasks()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/List;
    sget-object v3, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v4
    check-cast v1, Ljava/lang/Iterable;
    instance-of v2, v1, Ljava/util/Collection;
    if-eqz v2, +00dh
    move-object v6, v1
    check-cast v6, Ljava/util/Collection;
    invoke-interface v6, Ljava/util/Collection;->isEmpty()Z
    move-result v6
    if-eqz v6, +004h
    move v6, v0
    goto +27h
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    move v7, v0
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +01ch
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/home/solo/task/TaskModel;
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/task/TaskModel;->getCliType()Ljava/lang/String;
    move-result-object v8
    const-string v9, "local_ide"
    invoke-static v8, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, -016h
    add-int/lit8 v7, v7, 1
    if-gez v7, -01ah
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    goto -1fh
    move v6, v7
    if-eqz v2, +00dh
    move-object v7, v1
    check-cast v7, Ljava/util/Collection;
    invoke-interface v7, Ljava/util/Collection;->isEmpty()Z
    move-result v7
    if-eqz v7, +004h
    move v7, v0
    goto +27h
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    move v8, v0
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +01ch
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/home/solo/task/TaskModel;
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/task/TaskModel;->getCliType()Ljava/lang/String;
    move-result-object v9
    const-string v10, "local"
    invoke-static v9, v10, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, -016h
    add-int/lit8 v8, v8, 1
    if-gez v8, -01ah
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    goto -1fh
    move v7, v8
    if-eqz v2, +00dh
    move-object v2, v1
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    if-eqz v2, +004h
    move v8, v0
    goto +25h
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, -00ah
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/home/solo/task/TaskModel;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskModel;->getCliType()Ljava/lang/String;
    move-result-object v2
    const-string v8, "remote"
    invoke-static v2, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -016h
    add-int/lit8 v0, v0, 1
    if-gez v0, -01ah
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    goto -1fh
    invoke-virtual/range v3 ... v8, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->trackTaskListPageView(I Ljava/lang/String; I I I)V
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 16
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v13, v14, v15, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    new-instance v15, Landroidx/lifecycle/ViewModelProvider;
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    const-string/jumbo v1, requireActivity(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroidx/lifecycle/ViewModelStoreOwner;
    invoke-direct v15, v0, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V
    const-class v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-virtual v15, v0, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v15
    check-cast v15, Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    iput-object v15, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-direct v13, v14, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupTaskTitleBar(Landroid/view/View;)Lcom/bytedance/trae/common/widget/TraeTitleBar;
    move-result-object v15
    invoke-direct v13, v14, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupRecyclerView(Landroid/view/View;)V
    invoke-direct v13, v14, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupHeader(Landroid/view/View;)V
    invoke-direct v13, Lcom/bytedance/trae/home/solo/task/TaskFragment;->observeViewModel()V
    invoke-virtual v15, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getTaskAvatarView()Lcom/facebook/drawee/view/SimpleDraweeView;
    move-result-object v0
    invoke-direct v13, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->loadAvatar(Lcom/facebook/drawee/view/SimpleDraweeView;)V
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v1, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/api/ILoginService;
    const/4 v2, 0
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v1
    goto +2h
    move-object v1, v2
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->getLoginPlatform()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v2
    const-string v4, "bytecloud"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    invoke-virtual v15, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTaskAvatarBadgeVisible(Z)V
    new-instance v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda8;
    invoke-direct v4, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V
    invoke-virtual v15, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnTaskAvatarClickListener(Landroid/view/View$OnClickListener;)V
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->getAccountType()Lcom/bytedance/trae/login/api/AccountType;
    move-result-object v1
    goto +2h
    move-object v1, v2
    sget-object v4, Lcom/bytedance/trae/login/api/AccountType;->TOB Lcom/bytedance/trae/login/api/AccountType;
    const/4 v5, 1
    const/4 v6, 0
    if-ne v1, v4, +004h
    move v1, v5
    goto +2h
    move v1, v6
    if-eqz v1, +005h
    invoke-virtual v15, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTaskEnterpriseMode(Z)V
    sget v15, Lcom/bytedance/trae/home/R$id;->fl_avatar_container I
    invoke-virtual v14, v15, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v15
    check-cast v15, Landroid/view/ViewGroup;
    if-nez v3, +05dh
    if-nez v1, +05bh
    new-instance v1, Landroid/view/View;
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;
    move-result-object v3
    invoke-direct v1, v3, Landroid/view/View;-><init>(Landroid/content/Context;)V
    sget v3, Lcom/bytedance/trae/home/R$id;->v_unread_dot I
    invoke-virtual v1, v3, Landroid/view/View;->setId(I)V
    invoke-virtual v1, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    invoke-virtual v3, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v3
    iget v3, v3, Landroid/util/DisplayMetrics;->density F
    const/16 v4, 8
    int-to-float v5, v4
    mul-float/2addr v5, v3
    float-to-int v3, v5
    new-instance v5, Landroid/widget/FrameLayout$LayoutParams;
    const v7, 8388661
    invoke-direct v5, v3, v3, v7, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    iput v3, v5, Landroid/widget/FrameLayout$LayoutParams;->topMargin I
    invoke-virtual v5, v3, Landroid/widget/FrameLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v5, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget v3, Lcom/bytedance/trae/home/R$drawable;->bg_solo_notification_dot I
    invoke-virtual v1, v3, Landroid/view/View;->setBackgroundResource(I)V
    invoke-virtual v1, v4, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v15, v1, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v15
    const-string v3, "getViewLifecycleOwner(...)"
    invoke-static v15, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v15, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v15
    move-object v7, v15
    check-cast v7, Lkotlinx/coroutines/CoroutineScope;
    const/4 v8, 0
    const/4 v9, 0
    new-instance v15, Lcom/bytedance/trae/home/solo/task/TaskFragment$onViewCreated$2;
    invoke-direct v15, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$onViewCreated$2;-><init>(Landroid/view/View; Lkotlin/coroutines/Continuation;)V
    move-object v10, v15
    check-cast v10, Lkotlin/jvm/functions/Function2;
    const/4 v11, 3
    const/4 v12, 0
    invoke-static/range v7 ... v12, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v15
    new-instance v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$onViewCreated$3;
    invoke-direct v1, v13, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$onViewCreated$3;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lcom/facebook/drawee/view/SimpleDraweeView;)V
    check-cast v1, Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;
    invoke-virtual v15, v1, v6, Landroidx/fragment/app/FragmentManager;->registerFragmentLifecycleCallbacks(Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks; Z)V
    sget v15, Lcom/bytedance/trae/home/R$id;->btn_retry_network I
    invoke-virtual v14, v15, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v15
    if-eqz v15, +00ah
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda9;
    invoke-direct v0, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V
    invoke-virtual v15, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v15, Lcom/bytedance/trae/home/R$id;->fab_add I
    invoke-virtual v14, v15, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v14
    new-instance v15, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda10;
    invoke-direct v15, v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda10;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V
    invoke-virtual v14, v15, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;
    move-result-object v14
    const-string/jumbo v15, requireContext(...)
    invoke-static v14, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v13, v14, Lcom/bytedance/trae/home/solo/task/TaskFragment;->fixSuspendByPeerCrash(Landroid/content/Context;)V
    return-void 
.end method
