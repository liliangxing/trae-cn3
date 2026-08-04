# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
.field public final synthetic f$1:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$2:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
.field public final synthetic f$3:Landroidx/compose/runtime/MutableState;


.method public synthetic constructor <init>(com.bytedance.trae.kmp.ui.KmpClickHandler  kotlin.jvm.functions.Function1  com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode  androidx.compose.runtime.MutableState)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda2;->f$1 Lkotlin/jvm/functions/Function1;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda2;->f$2 Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda2;->f$3 Landroidx/compose/runtime/MutableState;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda2;->f$1 Lkotlin/jvm/functions/Function1;
    iget-object v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda2;->f$2 Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    iget-object v3, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda2;->f$3 Landroidx/compose/runtime/MutableState;
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$r8$lambda$K4GClkJSEd9uI7ADRqZG-F-8BUM(Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode; Landroidx/compose/runtime/MutableState;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
