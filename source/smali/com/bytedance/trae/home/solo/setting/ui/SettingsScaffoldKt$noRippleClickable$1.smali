# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/ui/SettingsScaffoldKt$noRippleClickable$1;
.super Ljava/lang/Object;
.source "SettingsScaffold.kt"

.implements Lkotlin/jvm/functions/Function3;

.field final synthetic $clickHandler:Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
.field final synthetic $onClick:Lkotlin/jvm/functions/Function0;


.method public static synthetic $r8$lambda$2zxFRgzDBd6cAIQmmYWPyVTbCss(com.bytedance.trae.kmp.ui.KmpClickHandler  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsScaffoldKt$noRippleClickable$1;->invoke$lambda$2$lambda$1(Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.kmp.ui.KmpClickHandler  kotlin.jvm.functions.Function0)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsScaffoldKt$noRippleClickable$1;->$clickHandler Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsScaffoldKt$noRippleClickable$1;->$onClick Lkotlin/jvm/functions/Function0;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final invoke$lambda$2$lambda$1(com.bytedance.trae.kmp.ui.KmpClickHandler  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;->tryHandle(Lkotlin/jvm/functions/Function0;)Z
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public final invoke(androidx.compose.ui.Modifier  androidx.compose.runtime.Composer  int)androidx.compose.ui.Modifier
    .registers 13
    # ins_size=4
    const-string v0, "$this$composed"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const v0, 918065666
    invoke-interface v11, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v1
    if-eqz v1, +008h
    const/4 v1, -1
    const-string v2, "com.bytedance.trae.home.solo.setting.ui.noRippleClickable.<anonymous> (SettingsScaffold.kt:65)"
    invoke-static v0, v12, v1, v2, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    const v12, 414186839
    invoke-interface v11, v12, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v11, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v12
    sget-object v0, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v0, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v0
    if-ne v12, v0, +009h
    invoke-static Landroidx/compose/foundation/interaction/InteractionSourceKt;->MutableInteractionSource()Landroidx/compose/foundation/interaction/MutableInteractionSource;
    move-result-object v12
    invoke-interface v11, v12, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object v1, v12
    check-cast v1, Landroidx/compose/foundation/interaction/MutableInteractionSource;
    invoke-interface v11, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const v12, 414189587
    invoke-interface v11, v12, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    iget-object v12, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsScaffoldKt$noRippleClickable$1;->$clickHandler Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    invoke-interface v11, v12, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v12
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsScaffoldKt$noRippleClickable$1;->$onClick Lkotlin/jvm/functions/Function0;
    invoke-interface v11, v0, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v0
    or-int/2addr v12, v0
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsScaffoldKt$noRippleClickable$1;->$clickHandler Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    iget-object v6, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsScaffoldKt$noRippleClickable$1;->$onClick Lkotlin/jvm/functions/Function0;
    invoke-interface v11, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v7
    if-nez v12, +00ah
    sget-object v12, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v12, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v12
    if-ne v7, v12, +00ah
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsScaffoldKt$noRippleClickable$1$$ExternalSyntheticLambda0;
    invoke-direct v7, v0, v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsScaffoldKt$noRippleClickable$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Lkotlin/jvm/functions/Function0;)V
    invoke-interface v11, v7, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object v6, v7
    check-cast v6, Lkotlin/jvm/functions/Function0;
    invoke-interface v11, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const/16 v7, 28
    const/4 v8, 0
    move-object v0, v10
    invoke-static/range v0 ... v8, Landroidx/compose/foundation/ClickableKt;->clickable-O2vRcR0$default(Landroidx/compose/ui/Modifier; Landroidx/compose/foundation/interaction/MutableInteractionSource; Landroidx/compose/foundation/Indication; Z Ljava/lang/String; Landroidx/compose/ui/semantics/Role; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v10
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v12
    if-eqz v12, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v11, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    return-object v10
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object  java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=4
    check-cast v1, Landroidx/compose/ui/Modifier;
    check-cast v2, Landroidx/compose/runtime/Composer;
    check-cast v3, Ljava/lang/Number;
    invoke-virtual v3, Ljava/lang/Number;->intValue()I
    move-result v3
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsScaffoldKt$noRippleClickable$1;->invoke(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/Modifier;
    move-result-object v1
    return-object v1
.end method
