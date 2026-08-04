# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Landroidx/compose/ui/unit/Density;
.field public final synthetic f$1:Landroidx/compose/runtime/MutableState;
.field public final synthetic f$2:Landroidx/compose/runtime/MutableState;


.method public synthetic constructor <init>(androidx.compose.ui.unit.Density  androidx.compose.runtime.MutableState  androidx.compose.runtime.MutableState)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda1;->f$0 Landroidx/compose/ui/unit/Density;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda1;->f$1 Landroidx/compose/runtime/MutableState;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda1;->f$2 Landroidx/compose/runtime/MutableState;
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=3
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda1;->f$0 Landroidx/compose/ui/unit/Density;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda1;->f$1 Landroidx/compose/runtime/MutableState;
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda1;->f$2 Landroidx/compose/runtime/MutableState;
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    check-cast v5, Ljava/lang/Float;
    invoke-virtual v5, Ljava/lang/Float;->floatValue()F
    move-result v5
    invoke-static v0, v1, v2, v4, v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$r8$lambda$YZVlmr0xeK0V7089cVIVFLABv4E(Landroidx/compose/ui/unit/Density; Landroidx/compose/runtime/MutableState; Landroidx/compose/runtime/MutableState; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey; F)Lkotlin/Unit;
    move-result-object v4
    return-object v4
.end method
