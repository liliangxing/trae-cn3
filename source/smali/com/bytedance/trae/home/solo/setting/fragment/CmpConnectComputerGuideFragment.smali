# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/fragment/CmpConnectComputerGuideFragment;
.super Lcom/bytedance/trae/kmp/cmp/TraeCmpSheetContentFragment;
.source "CmpConnectComputerGuideFragment.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/fragment/CmpConnectComputerGuideFragment$Companion;
.field private final titleResId:I


.method public static synthetic $r8$lambda$6M8jAOrGw8_hRoV8pF7ZeUaj9ys(com.bytedance.trae.home.solo.setting.fragment.CmpConnectComputerGuideFragment  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/fragment/CmpConnectComputerGuideFragment;->RenderCmpContent$lambda$0(Lcom/bytedance/trae/home/solo/setting/fragment/CmpConnectComputerGuideFragment; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpConnectComputerGuideFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpConnectComputerGuideFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpConnectComputerGuideFragment;->Companion Lcom/bytedance/trae/home/solo/setting/fragment/CmpConnectComputerGuideFragment$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpSheetContentFragment;-><init>()V
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_setting_add_device_title I
    iput v0, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpConnectComputerGuideFragment;->titleResId I
    return-void 
.end method

.method private static final RenderCmpContent$lambda$0(com.bytedance.trae.home.solo.setting.fragment.CmpConnectComputerGuideFragment  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 4
    # ins_size=4
    or-int/lit8 v1, v1, 1
    invoke-static v1, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v1
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpConnectComputerGuideFragment;->RenderCmpContent(Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method protected RenderCmpContent(androidx.compose.runtime.Composer  int)void
    .registers 6
    # ins_size=3
    const v0, 1565142123
    invoke-interface v4, v0, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v4
    and-int/lit8 v1, v5, 1
    if-nez v1, +00dh
    invoke-interface v4, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v1
    if-nez v1, +003h
    goto +5h
    invoke-interface v4, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    goto +1ch
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v1
    if-eqz v1, +008h
    const/4 v1, -1
    const-string v2, "com.bytedance.trae.home.solo.setting.fragment.CmpConnectComputerGuideFragment.RenderCmpContent (CmpConnectComputerGuideFragment.kt:11)"
    invoke-static v0, v5, v1, v2, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    const/4 v0, 0
    const/4 v1, 3
    const/4 v2, 0
    invoke-static v2, v2, v4, v0, v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt;->ConnectComputerGuideScreen(Lcom/bytedance/trae/kmp/host/KmpHostInfo; Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I I)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v4, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v4
    if-eqz v4, +00ah
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpConnectComputerGuideFragment$$ExternalSyntheticLambda0;
    invoke-direct v0, v3, v5, Lcom/bytedance/trae/home/solo/setting/fragment/CmpConnectComputerGuideFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/fragment/CmpConnectComputerGuideFragment; I)V
    invoke-interface v4, v0, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method protected getTitleResId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpConnectComputerGuideFragment;->titleResId I
    return v0
.end method
