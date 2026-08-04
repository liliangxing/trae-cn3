# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment;
.super Lcom/bytedance/trae/kmp/cmp/TraeCmpSheetContentFragment;
.source "CmpDeviceManagementFragment.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$Companion;
.field private final titleResId:I


.method public static synthetic $r8$lambda$9V1FqV3KHtYq2oFEweNZqJFEFIg(com.bytedance.trae.home.solo.setting.fragment.CmpDeviceManagementFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment;->RenderCmpContent$lambda$1$lambda$0(Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$9bE7khaPOzJtIBa0mMTyc6zSA2I(com.bytedance.trae.home.solo.setting.fragment.CmpDeviceManagementFragment  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment;->RenderCmpContent$lambda$3(Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment;->Companion Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpSheetContentFragment;-><init>()V
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_setting_device_management I
    iput v0, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment;->titleResId I
    return-void 
.end method

.method private static final RenderCmpContent$lambda$1$lambda$0(com.bytedance.trae.home.solo.setting.fragment.CmpDeviceManagementFragment)kotlin.Unit
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment;->getParentFragment()Landroidx/fragment/app/Fragment;
    move-result-object v1
    instance-of v0, v1, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;
    if-eqz v0, +005h
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;
    goto +2h
    const/4 v1, 0
    if-eqz v1, +00bh
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;->getNavigator()Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;
    move-result-object v1
    if-eqz v1, +005h
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;->openConnectComputerGuide()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final RenderCmpContent$lambda$3(com.bytedance.trae.home.solo.setting.fragment.CmpDeviceManagementFragment  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 4
    # ins_size=4
    or-int/lit8 v1, v1, 1
    invoke-static v1, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v1
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment;->RenderCmpContent(Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public static final synthetic access$refreshDeviceCache(com.bytedance.trae.home.solo.setting.fragment.CmpDeviceManagementFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment;->refreshDeviceCache()V
    return-void 
.end method

.method private final refreshDeviceCache()void
    .registers 8
    # ins_size=1
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    const-string v1, "getViewLifecycleOwner(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$refreshDeviceCache$1;
    const/4 v4, 0
    invoke-direct v0, v4, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$refreshDeviceCache$1;-><init>(Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method protected RenderCmpContent(androidx.compose.runtime.Composer  int)void
    .registers 13
    # ins_size=3
    const v0, 1673377835
    invoke-interface v11, v0, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v11
    and-int/lit8 v1, v12, 6
    const/4 v2, 2
    const/4 v3, 4
    if-nez v1, +00dh
    invoke-interface v11, v10, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +004h
    move v1, v3
    goto +2h
    move v1, v2
    or-int/2addr v1, v12
    goto +2h
    move v1, v12
    and-int/lit8 v4, v1, 3
    if-ne v4, v2, +00eh
    invoke-interface v11, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v2
    if-nez v2, +003h
    goto +6h
    invoke-interface v11, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    goto/16 +07fh
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v2
    if-eqz v2, +008h
    const/4 v2, -1
    const-string v4, "com.bytedance.trae.home.solo.setting.fragment.CmpDeviceManagementFragment.RenderCmpContent (CmpDeviceManagementFragment.kt:16)"
    invoke-static v0, v1, v2, v4, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/kmp/network/AndroidKmpHttpClientFactory;->INSTANCE Lcom/bytedance/trae/kmp/network/AndroidKmpHttpClientFactory;
    invoke-virtual v0, Lcom/bytedance/trae/kmp/network/AndroidKmpHttpClientFactory;->get()Lcom/bytedance/trae/kmp/network/KmpHttpClient;
    move-result-object v0
    const/4 v2, 0
    const v4, -574149969
    invoke-interface v11, v4, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    and-int/lit8 v1, v1, 14
    const/4 v4, 1
    const/4 v5, 0
    if-ne v1, v3, +004h
    move v6, v4
    goto +2h
    move v6, v5
    invoke-interface v11, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v7
    if-nez v6, +00ah
    sget-object v6, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v6, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v6
    if-ne v7, v6, +00ah
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$$ExternalSyntheticLambda0;
    invoke-direct v7, v10, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment;)V
    invoke-interface v11, v7, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object v6, v7
    check-cast v6, Lkotlin/jvm/functions/Function0;
    invoke-interface v11, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v7, -574143712
    invoke-interface v11, v7, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    if-ne v1, v3, +003h
    goto +2h
    move v4, v5
    invoke-interface v11, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v1
    if-nez v4, +00ah
    sget-object v3, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v3, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v3
    if-ne v1, v3, +00ch
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$RenderCmpContent$2$1;
    invoke-direct v1, v10, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$RenderCmpContent$2$1;-><init>(Ljava/lang/Object;)V
    check-cast v1, Lkotlin/reflect/KFunction;
    invoke-interface v11, v1, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v1, Lkotlin/reflect/KFunction;
    invoke-interface v11, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    move-object v4, v1
    check-cast v4, Lkotlin/jvm/functions/Function0;
    const/4 v5, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 50
    move-object v1, v0
    move-object v3, v6
    move-object v6, v7
    move-object v7, v11
    invoke-static/range v1 ... v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt;->DeviceManagementScreen(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lcom/bytedance/trae/kmp/host/KmpHostInfo; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I I)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v11, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v11
    if-eqz v11, +00ah
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$$ExternalSyntheticLambda1;
    invoke-direct v0, v10, v12, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment; I)V
    invoke-interface v11, v0, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method protected getTitleResId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment;->titleResId I
    return v0
.end method
