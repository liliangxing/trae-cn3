# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment$onViewCreated$2$1;
.super Ljava/lang/Object;
.source "TraeCmpContentFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic this$0:Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;


.method constructor <init>(com.bytedance.trae.kmp.cmp.TraeCmpContentFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment$onViewCreated$2$1;->this$0 Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Landroidx/compose/runtime/Composer;
    check-cast v2, Ljava/lang/Number;
    invoke-virtual v2, Ljava/lang/Number;->intValue()I
    move-result v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment$onViewCreated$2$1;->invoke(Landroidx/compose/runtime/Composer; I)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public final invoke(androidx.compose.runtime.Composer  int)void
    .registers 6
    # ins_size=3
    and-int/lit8 v0, v5, 3
    const/4 v1, 2
    if-ne v0, v1, +00dh
    invoke-interface v4, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v0
    if-nez v0, +003h
    goto +5h
    invoke-interface v4, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    goto +32h
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +00bh
    const/4 v0, -1
    const-string v1, "com.bytedance.trae.kmp.cmp.TraeCmpContentFragment.onViewCreated.<anonymous>.<anonymous> (TraeCmpContentFragment.kt:70)"
    const v2, -1909781802
    invoke-static v2, v5, v0, v1, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    new-instance v5, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment$onViewCreated$2$1$1;
    iget-object v0, v3, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment$onViewCreated$2$1;->this$0 Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;
    invoke-direct v5, v0, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment$onViewCreated$2$1$1;-><init>(Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;)V
    const/16 v0, 54
    const v1, 313320857
    const/4 v2, 1
    invoke-static v1, v2, v5, v4, v0, Landroidx/compose/runtime/internal/ComposableLambdaKt;->rememberComposableLambda(I Z Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Landroidx/compose/runtime/internal/ComposableLambda;
    move-result-object v5
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/16 v0, 48
    const/4 v1, 0
    invoke-static v1, v5, v4, v0, v2, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt;->TraeDesignTheme(Z Lkotlin/jvm/functions/Function2; Landroidx/compose/runtime/Composer; I I)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v4
    if-eqz v4, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    return-void 
.end method
