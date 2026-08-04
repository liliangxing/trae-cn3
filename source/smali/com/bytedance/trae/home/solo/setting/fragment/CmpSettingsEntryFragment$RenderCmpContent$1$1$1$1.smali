# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;
.super Lkotlin/coroutines/jvm/internal/RestrictedSuspendLambda;
.source "CmpSettingsEntryFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $contentScrollState:Landroidx/compose/foundation/ScrollState;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;


.method constructor <init>(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment  androidx.compose.foundation.ScrollState  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;->this$0 Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;->$contentScrollState Landroidx/compose/foundation/ScrollState;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/RestrictedSuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;->this$0 Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;->$contentScrollState Landroidx/compose/foundation/ScrollState;
    invoke-direct v0, v1, v2, v5, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;-><init>(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment; Landroidx/compose/foundation/ScrollState; Lkotlin/coroutines/Continuation;)V
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public final invoke(androidx.compose.ui.input.pointer.AwaitPointerEventScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;->invoke(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v12, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;->label I
    const/4 v2, 2
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v1, +021h
    if-eq v1, v4, +017h
    if-ne v1, v2, +00dh
    iget-object v1, v12, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;->L$0 Ljava/lang/Object;
    check-cast v1, Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v5, v1
    move-object v1, v0
    move-object v0, v12
    goto +57h
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    iget-object v1, v12, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;->L$0 Ljava/lang/Object;
    check-cast v1, Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ch
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v13, v12, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;->L$0 Ljava/lang/Object;
    move-object v1, v13
    check-cast v1, Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;
    const/4 v6, 0
    const/4 v7, 0
    move-object v8, v12
    check-cast v8, Lkotlin/coroutines/Continuation;
    const/4 v9, 2
    const/4 v10, 0
    iput-object v1, v12, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;->L$0 Ljava/lang/Object;
    iput v4, v12, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;->label I
    move-object v5, v1
    invoke-static/range v5 ... v10, Landroidx/compose/foundation/gestures/TapGestureDetectorKt;->awaitFirstDown$default(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope; Z Landroidx/compose/ui/input/pointer/PointerEventPass; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v0, +003h
    return-object v0
    iget-object v13, v12, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;->this$0 Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;
    invoke-static v13, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->access$cmpSheet(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;)Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;
    move-result-object v13
    if-eqz v13, +010h
    iget-object v5, v12, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;->$contentScrollState Landroidx/compose/foundation/ScrollState;
    invoke-virtual v5, Landroidx/compose/foundation/ScrollState;->getValue()I
    move-result v5
    if-lez v5, +004h
    move v5, v4
    goto +2h
    move v5, v3
    invoke-virtual v13, v5, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;->onContentGestureStarted(Z)V
    move-object v13, v12
    move-object v5, v13
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput-object v1, v13, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;->L$0 Ljava/lang/Object;
    iput v2, v13, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;->label I
    const/4 v6, 0
    invoke-static v1, v6, v5, v4, v6, Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;->awaitPointerEvent$default(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope; Landroidx/compose/ui/input/pointer/PointerEventPass; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v0, +003h
    return-object v0
    move-object v11, v0
    move-object v0, v13
    move-object v13, v5
    move-object v5, v1
    move-object v1, v11
    check-cast v13, Landroidx/compose/ui/input/pointer/PointerEvent;
    invoke-virtual v13, Landroidx/compose/ui/input/pointer/PointerEvent;->getChanges()Ljava/util/List;
    move-result-object v13
    check-cast v13, Ljava/lang/Iterable;
    instance-of v6, v13, Ljava/util/Collection;
    if-eqz v6, +00dh
    move-object v6, v13
    check-cast v6, Ljava/util/Collection;
    invoke-interface v6, Ljava/util/Collection;->isEmpty()Z
    move-result v6
    if-eqz v6, +004h
    move v13, v3
    goto +18h
    invoke-interface v13, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v13
    invoke-interface v13, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, -00ah
    invoke-interface v13, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Landroidx/compose/ui/input/pointer/PointerInputChange;
    invoke-virtual v6, Landroidx/compose/ui/input/pointer/PointerInputChange;->getPressed()Z
    move-result v6
    if-eqz v6, -010h
    move v13, v4
    if-nez v13, +010h
    iget-object v13, v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;->this$0 Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;
    invoke-static v13, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->access$cmpSheet(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;)Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;
    move-result-object v13
    if-eqz v13, +005h
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;->onContentGestureEnded()V
    sget-object v13, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v13
    move-object v13, v0
    move-object v0, v1
    move-object v1, v5
    goto -55h
.end method
