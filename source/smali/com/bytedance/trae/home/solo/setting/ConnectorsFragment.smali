# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;
.super Landroidx/fragment/app/Fragment;
.source "ConnectorsFragment.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$Companion;
.field private cardGithub:Landroid/widget/LinearLayout;
.field private cardManageGithub:Landroid/widget/LinearLayout;
.field private final connectLauncher:Landroidx/activity/result/ActivityResultLauncher;
.field private connectorManager:Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;
.field private isOperating:Z
.field private final modifyLauncher:Landroidx/activity/result/ActivityResultLauncher;
.field private switchGithub:Landroidx/appcompat/widget/SwitchCompat;


.method public static synthetic $r8$lambda$DAtqgN27dvKmY9S2a5jjHMExDgw(com.bytedance.trae.home.solo.setting.ConnectorsFragment  androidx.activity.result.ActivityResult)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->connectLauncher$lambda$0(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment; Landroidx/activity/result/ActivityResult;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$L-LlaoSKteZSj3O2L3gxIMhJbTY(com.bytedance.trae.home.solo.setting.ConnectorsFragment  androidx.activity.result.ActivityResult)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->modifyLauncher$lambda$1(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment; Landroidx/activity/result/ActivityResult;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$ZnPoQtZPZ-NuuXr0idlIhaHeyos(com.bytedance.trae.home.solo.setting.ConnectorsFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->onViewCreated$lambda$2(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$kOv8JIfC3KCjBiuoPfh-Xk878KE(com.bytedance.trae.home.solo.setting.ConnectorsFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->onViewCreated$lambda$3(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$pV7v_u0TdtbtLBRamzE2qek93Ow(com.bytedance.trae.home.solo.setting.ConnectorsFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->onViewCreated$lambda$4(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->Companion Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Landroidx/fragment/app/Fragment;-><init>()V
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$$ExternalSyntheticLambda3;
    invoke-direct v1, v3, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;)V
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    const-string v1, "registerForActivityResult(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v3, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->connectLauncher Landroidx/activity/result/ActivityResultLauncher;
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$$ExternalSyntheticLambda4;
    invoke-direct v2, v3, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;)V
    invoke-virtual v3, v0, v2, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v3, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->modifyLauncher Landroidx/activity/result/ActivityResultLauncher;
    return-void 
.end method

.method public static final synthetic access$getCardManageGithub$p(com.bytedance.trae.home.solo.setting.ConnectorsFragment)android.widget.LinearLayout
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->cardManageGithub Landroid/widget/LinearLayout;
    return-object v0
.end method

.method public static final synthetic access$getConnectorManager$p(com.bytedance.trae.home.solo.setting.ConnectorsFragment)com.bytedance.trae.conversation.git.GitHubConnectorManager
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->connectorManager Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;
    return-object v0
.end method

.method public static final synthetic access$getSwitchGithub$p(com.bytedance.trae.home.solo.setting.ConnectorsFragment)androidx.appcompat.widget.SwitchCompat
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->switchGithub Landroidx/appcompat/widget/SwitchCompat;
    return-object v0
.end method

.method public static final synthetic access$setInteractionEnabled(com.bytedance.trae.home.solo.setting.ConnectorsFragment  boolean)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->setInteractionEnabled(Z)V
    return-void 
.end method

.method public static final synthetic access$setOperating$p(com.bytedance.trae.home.solo.setting.ConnectorsFragment  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->isOperating Z
    return-void 
.end method

.method private final connect()void
    .registers 5
    # ins_size=1
    const/4 v0, 0
    invoke-direct v4, v0, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->setInteractionEnabled(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->connectLauncher Landroidx/activity/result/ActivityResultLauncher;
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->Companion Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    const-string/jumbo v3, requireContext(...)
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$Companion;->newConnectIntent(Landroid/content/Context;)Landroid/content/Intent;
    move-result-object v1
    invoke-virtual v0, v1, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    return-void 
.end method

.method private static final connectLauncher$lambda$0(com.bytedance.trae.home.solo.setting.ConnectorsFragment  androidx.activity.result.ActivityResult)void
    .registers 3
    # ins_size=2
    invoke-virtual v2, Landroidx/activity/result/ActivityResult;->getResultCode()I
    move-result v2
    const/4 v0, -1
    if-ne v2, v0, +005h
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->refreshGitHubStatus()V
    const/4 v2, 1
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->setInteractionEnabled(Z)V
    return-void 
.end method

.method private final disconnect()void
    .registers 8
    # ins_size=1
    const/4 v0, 1
    iput-boolean v0, v7, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->isOperating Z
    const/4 v0, 0
    invoke-direct v7, v0, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->setInteractionEnabled(Z)V
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;-><init>(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final modifyLauncher$lambda$1(com.bytedance.trae.home.solo.setting.ConnectorsFragment  androidx.activity.result.ActivityResult)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->refreshGitHubStatus()V
    return-void 
.end method

.method private final onGitHubCardTapped()void
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->isOperating Z
    if-eqz v0, +003h
    return-void 
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->switchGithub Landroidx/appcompat/widget/SwitchCompat;
    if-nez v0, +009h
    const-string/jumbo v0, switchGithub
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Landroidx/appcompat/widget/SwitchCompat;->isChecked()Z
    move-result v0
    if-nez v0, +006h
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->connect()V
    goto +4h
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->disconnect()V
    return-void 
.end method

.method private final onManageGitHubTapped()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->modifyLauncher Landroidx/activity/result/ActivityResultLauncher;
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->Companion Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    const-string/jumbo v3, requireContext(...)
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$Companion;->newModifyIntent(Landroid/content/Context;)Landroid/content/Intent;
    move-result-object v1
    invoke-virtual v0, v1, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    return-void 
.end method

.method private static final onViewCreated$lambda$2(com.bytedance.trae.home.solo.setting.ConnectorsFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    return-void 
.end method

.method private static final onViewCreated$lambda$3(com.bytedance.trae.home.solo.setting.ConnectorsFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->onGitHubCardTapped()V
    return-void 
.end method

.method private static final onViewCreated$lambda$4(com.bytedance.trae.home.solo.setting.ConnectorsFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->onManageGitHubTapped()V
    return-void 
.end method

.method private final refreshGitHubStatus()void
    .registers 8
    # ins_size=1
    iget-boolean v0, v7, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->isOperating Z
    if-eqz v0, +003h
    return-void 
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$refreshGitHubStatus$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$refreshGitHubStatus$1;-><init>(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final setInteractionEnabled(boolean)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->cardGithub Landroid/widget/LinearLayout;
    const-string v1, "cardGithub"
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v4, Landroid/widget/LinearLayout;->setClickable(Z)V
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->cardGithub Landroid/widget/LinearLayout;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v4, Landroid/widget/LinearLayout;->setFocusable(Z)V
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->cardManageGithub Landroid/widget/LinearLayout;
    const-string v1, "cardManageGithub"
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v4, Landroid/widget/LinearLayout;->setClickable(Z)V
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->cardManageGithub Landroid/widget/LinearLayout;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    invoke-virtual v2, v4, Landroid/widget/LinearLayout;->setFocusable(Z)V
    return-void 
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/home/R$layout;->fragment_connectors I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 7
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v4, v5, v6, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    sget v6, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-virtual v5, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$$ExternalSyntheticLambda0;
    invoke-direct v0, v4, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;)V
    invoke-virtual v6, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    const-class v6, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v6
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v6, v0, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/login/api/ILoginService;
    const/4 v0, 0
    if-eqz v6, +00dh
    invoke-interface v6, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v6
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/bytedance/trae/login/api/AccountInfo;->getLoginPlatform()Ljava/lang/String;
    move-result-object v6
    goto +2h
    move-object v6, v0
    const-string v1, "bytecloud"
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    const/16 v1, 8
    if-eqz v6, +024h
    sget v6, Lcom/bytedance/trae/home/R$id;->card_github I
    invoke-virtual v5, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    check-cast v6, Landroid/widget/LinearLayout;
    invoke-virtual v6, v1, Landroid/widget/LinearLayout;->setVisibility(I)V
    sget v6, Lcom/bytedance/trae/home/R$id;->divider_github I
    invoke-virtual v5, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    if-eqz v6, +005h
    invoke-virtual v6, v1, Landroid/view/View;->setVisibility(I)V
    sget v6, Lcom/bytedance/trae/home/R$id;->card_manage_github I
    invoke-virtual v5, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    check-cast v5, Landroid/widget/LinearLayout;
    invoke-virtual v5, v1, Landroid/widget/LinearLayout;->setVisibility(I)V
    return-void 
    new-instance v6, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    const-string/jumbo v3, requireContext(...)
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 2
    invoke-direct v6, v2, v0, v3, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;-><init>(Landroid/content/Context; Lcom/bytedance/trae/conversation/git/GitHubConnectConfig; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v6, v4, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->connectorManager Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;
    sget v6, Lcom/bytedance/trae/home/R$id;->switch_github I
    invoke-virtual v5, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    const-string v2, "findViewById(...)"
    invoke-static v6, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Landroidx/appcompat/widget/SwitchCompat;
    iput-object v6, v4, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->switchGithub Landroidx/appcompat/widget/SwitchCompat;
    sget v6, Lcom/bytedance/trae/home/R$id;->card_github I
    invoke-virtual v5, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Landroid/widget/LinearLayout;
    iput-object v6, v4, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->cardGithub Landroid/widget/LinearLayout;
    sget v6, Lcom/bytedance/trae/home/R$id;->card_manage_github I
    invoke-virtual v5, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    invoke-static v5, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Landroid/widget/LinearLayout;
    iput-object v5, v4, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->cardManageGithub Landroid/widget/LinearLayout;
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->switchGithub Landroidx/appcompat/widget/SwitchCompat;
    if-nez v5, +009h
    const-string/jumbo v5, switchGithub
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v0
    const/4 v6, 4
    invoke-virtual v5, v6, Landroidx/appcompat/widget/SwitchCompat;->setVisibility(I)V
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->cardManageGithub Landroid/widget/LinearLayout;
    const-string v6, "cardManageGithub"
    if-nez v5, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v0
    invoke-virtual v5, v1, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->cardGithub Landroid/widget/LinearLayout;
    if-nez v5, +008h
    const-string v5, "cardGithub"
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v0
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$$ExternalSyntheticLambda1;
    invoke-direct v1, v4, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;)V
    invoke-virtual v5, v1, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->cardManageGithub Landroid/widget/LinearLayout;
    if-nez v5, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v5
    new-instance v5, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$$ExternalSyntheticLambda2;
    invoke-direct v5, v4, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;)V
    invoke-virtual v0, v5, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v4, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->refreshGitHubStatus()V
    return-void 
.end method
