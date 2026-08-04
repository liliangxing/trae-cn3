# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$1:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$2:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$3:Landroidx/compose/runtime/MutableState;
.field public final synthetic f$4:Landroidx/compose/runtime/MutableState;


.method public synthetic constructor <init>(kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  androidx.compose.runtime.MutableState  androidx.compose.runtime.MutableState)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda0;->f$0 Lkotlin/jvm/functions/Function0;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda0;->f$1 Lkotlin/jvm/functions/Function0;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda0;->f$2 Lkotlin/jvm/functions/Function1;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda0;->f$3 Landroidx/compose/runtime/MutableState;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda0;->f$4 Landroidx/compose/runtime/MutableState;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda0;->f$0 Lkotlin/jvm/functions/Function0;
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda0;->f$1 Lkotlin/jvm/functions/Function0;
    iget-object v2, v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda0;->f$2 Lkotlin/jvm/functions/Function1;
    iget-object v3, v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda0;->f$3 Landroidx/compose/runtime/MutableState;
    iget-object v4, v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda0;->f$4 Landroidx/compose/runtime/MutableState;
    move-object v5, v7
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$r8$lambda$bexuXizylmO6pmC98SgSWIcAarU(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Landroidx/compose/runtime/MutableState; Landroidx/compose/runtime/MutableState; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;)Lkotlin/Unit;
    move-result-object v7
    return-object v7
.end method
