# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;
.super Landroidx/fragment/app/Fragment;
.source "DebugLoginDevicesFragment.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$Companion;
.field private adapter:Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter;
.field private isLoading:Z
.field private progressLoading:Landroid/widget/ProgressBar;
.field private rvDevices:Landroidx/recyclerview/widget/RecyclerView;
.field private tvEmpty:Landroid/widget/TextView;


.method public static synthetic $r8$lambda$0mTw3oqjyLtJHUXSBAsbcLBlMF0(com.bytedance.trae.home.solo.setting.DebugLoginDevicesFragment  com.bytedance.trae.login.api.LoginDeviceListResult)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->fetchDevices$lambda$2$lambda$1(Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment; Lcom/bytedance/trae/login/api/LoginDeviceListResult;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$2-T6ifXcy---DbaZBL1ob1_yp1s(com.bytedance.trae.home.solo.setting.DebugLoginDevicesFragment)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->fetchDevices$lambda$4$lambda$3(Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$9P_Ya_fj5nB6sbI4RTwWbcRk9zk(com.bytedance.trae.home.solo.setting.DebugLoginDevicesFragment  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->fetchDevices$lambda$4(Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$tpbsihTLEjfbmYD7xVKKMXgMayI(com.bytedance.trae.home.solo.setting.DebugLoginDevicesFragment  com.bytedance.trae.login.api.LoginDeviceListResult)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->fetchDevices$lambda$2(Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment; Lcom/bytedance/trae/login/api/LoginDeviceListResult;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ugUbgjvI0OXxK_n_HGQ5qo76bsw(com.bytedance.trae.home.solo.setting.DebugLoginDevicesFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->onViewCreated$lambda$0(Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->Companion Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroidx/fragment/app/Fragment;-><init>()V
    return-void 
.end method

.method private final fetchDevices()void
    .registers 4
    # ins_size=1
    iget-boolean v0, v3, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->isLoading Z
    if-eqz v0, +003h
    return-void 
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-nez v0, +018h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    invoke-direct v3, v0, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->showDevices(Ljava/util/List;)V
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/home/R$string;->trae_setting_debug_login_devices_load_failed I
    const/4 v2, 0
    invoke-static v0, v1, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    return-void 
    const/4 v1, 1
    iput-boolean v1, v3, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->isLoading Z
    invoke-direct v3, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->setLoading(Z)V
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$$ExternalSyntheticLambda2;
    invoke-direct v1, v3, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;)V
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$$ExternalSyntheticLambda3;
    invoke-direct v2, v3, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;)V
    invoke-interface v0, v1, v2, Lcom/bytedance/trae/login/api/ILoginService;->listLoginDevices(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private static final fetchDevices$lambda$2(com.bytedance.trae.home.solo.setting.DebugLoginDevicesFragment  com.bytedance.trae.login.api.LoginDeviceListResult)kotlin.Unit
    .registers 4
    # ins_size=2
    const-string/jumbo v0, result
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->getView()Landroid/view/View;
    move-result-object v0
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$$ExternalSyntheticLambda4;
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment; Lcom/bytedance/trae/login/api/LoginDeviceListResult;)V
    invoke-virtual v0, v1, Landroid/view/View;->post(Ljava/lang/Runnable;)Z
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final fetchDevices$lambda$2$lambda$1(com.bytedance.trae.home.solo.setting.DebugLoginDevicesFragment  com.bytedance.trae.login.api.LoginDeviceListResult)void
    .registers 3
    # ins_size=2
    const/4 v0, 0
    iput-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->isLoading Z
    invoke-direct v1, v0, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->setLoading(Z)V
    invoke-virtual v2, Lcom/bytedance/trae/login/api/LoginDeviceListResult;->getDevices()Ljava/util/List;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->showDevices(Ljava/util/List;)V
    return-void 
.end method

.method private static final fetchDevices$lambda$4(com.bytedance.trae.home.solo.setting.DebugLoginDevicesFragment  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->getView()Landroid/view/View;
    move-result-object v2
    if-eqz v2, +00ah
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$$ExternalSyntheticLambda1;
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;)V
    invoke-virtual v2, v0, Landroid/view/View;->post(Ljava/lang/Runnable;)Z
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final fetchDevices$lambda$4$lambda$3(com.bytedance.trae.home.solo.setting.DebugLoginDevicesFragment)void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    iput-boolean v0, v2, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->isLoading Z
    invoke-direct v2, v0, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->setLoading(Z)V
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    invoke-direct v2, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->showDevices(Ljava/util/List;)V
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->getContext()Landroid/content/Context;
    move-result-object v2
    sget v1, Lcom/bytedance/trae/home/R$string;->trae_setting_debug_login_devices_load_failed I
    invoke-static v2, v1, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private static final onViewCreated$lambda$0(com.bytedance.trae.home.solo.setting.DebugLoginDevicesFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    return-void 
.end method

.method private final setLoading(boolean)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->progressLoading Landroid/widget/ProgressBar;
    if-eqz v0, +00bh
    if-eqz v2, +004h
    const/4 v2, 0
    goto +3h
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    return-void 
.end method

.method private final showDevices(java.util.List)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->adapter Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter;
    if-nez v0, +008h
    const-string v0, "adapter"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, v5, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter;->submitList(Ljava/util/List;)V
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->tvEmpty Landroid/widget/TextView;
    const/4 v1, 0
    const/16 v2, 8
    if-eqz v0, +00eh
    invoke-interface v5, Ljava/util/List;->isEmpty()Z
    move-result v3
    if-eqz v3, +004h
    move v3, v1
    goto +2h
    move v3, v2
    invoke-virtual v0, v3, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->rvDevices Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v0, +00ch
    invoke-interface v5, Ljava/util/List;->isEmpty()Z
    move-result v5
    if-eqz v5, +003h
    move v1, v2
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    return-void 
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/home/R$layout;->fragment_debug_login_devices I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    const-string v3, "inflate(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public onDestroyView()void
    .registers 2
    # ins_size=1
    invoke-super v1, Landroidx/fragment/app/Fragment;->onDestroyView()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->progressLoading Landroid/widget/ProgressBar;
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->rvDevices Landroidx/recyclerview/widget/RecyclerView;
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->tvEmpty Landroid/widget/TextView;
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, v3, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    sget v3, Lcom/bytedance/trae/home/R$id;->progress_loading I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/ProgressBar;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->progressLoading Landroid/widget/ProgressBar;
    sget v3, Lcom/bytedance/trae/home/R$id;->rv_login_devices I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->rvDevices Landroidx/recyclerview/widget/RecyclerView;
    sget v3, Lcom/bytedance/trae/home/R$id;->tv_empty I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/TextView;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->tvEmpty Landroid/widget/TextView;
    sget v3, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$$ExternalSyntheticLambda0;
    invoke-direct v3, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter;
    invoke-direct v2, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->adapter Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter;
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->rvDevices Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v2, +010h
    new-instance v3, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-direct v3, v0, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v2, v3, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->rvDevices Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v2, +011h
    iget-object v3, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->adapter Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter;
    if-nez v3, +008h
    const-string v3, "adapter"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v3, 0
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v2, v3, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->fetchDevices()V
    return-void 
.end method
