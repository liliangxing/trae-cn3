# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1;
.super Ljava/lang/Object;
.source "CmpSettingsEntryFragment.kt"

.implements Landroidx/compose/ui/input/pointer/PointerInputEventHandler;

.field final synthetic $contentScrollState:Landroidx/compose/foundation/ScrollState;
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;


.method constructor <init>(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment  androidx.compose.foundation.ScrollState)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1;->this$0 Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1;->$contentScrollState Landroidx/compose/foundation/ScrollState;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final invoke(androidx.compose.ui.input.pointer.PointerInputScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1;->this$0 Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;
    iget-object v2, v4, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1;->$contentScrollState Landroidx/compose/foundation/ScrollState;
    const/4 v3, 0
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1$1;-><init>(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment; Landroidx/compose/foundation/ScrollState; Lkotlin/coroutines/Continuation;)V
    check-cast v0, Lkotlin/jvm/functions/Function2;
    invoke-static v5, v0, v6, Landroidx/compose/foundation/gestures/ForEachGestureKt;->awaitEachGesture(Landroidx/compose/ui/input/pointer/PointerInputScope; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v6
    if-ne v5, v6, +003h
    return-object v5
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
.end method
