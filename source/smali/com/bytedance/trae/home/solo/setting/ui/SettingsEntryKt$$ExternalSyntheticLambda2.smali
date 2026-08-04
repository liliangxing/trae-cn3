# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
.field public final synthetic f$1:Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
.field public final synthetic f$2:Ljava/lang/String;
.field public final synthetic f$3:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$4:Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
.field public final synthetic f$5:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$6:I


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.viewmodel.SettingsItem  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  java.lang.String  kotlin.jvm.functions.Function0  com.bytedance.trae.kmp.ui.KmpClickHandler  kotlin.jvm.functions.Function1  int)void
    .registers 8
    # ins_size=8
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda2;->f$1 Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda2;->f$2 Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda2;->f$3 Lkotlin/jvm/functions/Function0;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda2;->f$4 Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda2;->f$5 Lkotlin/jvm/functions/Function1;
    iput v7, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda2;->f$6 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 12
    # ins_size=3
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    iget-object v1, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda2;->f$1 Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
    iget-object v2, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda2;->f$2 Ljava/lang/String;
    iget-object v3, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda2;->f$3 Lkotlin/jvm/functions/Function0;
    iget-object v4, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda2;->f$4 Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    iget-object v5, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda2;->f$5 Lkotlin/jvm/functions/Function1;
    iget v6, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda2;->f$6 I
    move-object v7, v10
    check-cast v7, Landroidx/compose/runtime/Composer;
    check-cast v11, Ljava/lang/Integer;
    invoke-virtual v11, Ljava/lang/Integer;->intValue()I
    move-result v8
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->$r8$lambda$xgCP3CP7Z6vE5lc3AaHcLJlXwR8(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Lkotlin/jvm/functions/Function1; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v10
    return-object v10
.end method
