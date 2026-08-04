# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda7;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;
.field public final synthetic f$1:Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
.field public final synthetic f$2:Ljava/lang/String;
.field public final synthetic f$3:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$4:Lkotlin/jvm/functions/Function2;
.field public final synthetic f$5:I


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.viewmodel.SettingsGroup  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function2  int)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda7;->f$1 Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda7;->f$2 Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda7;->f$3 Lkotlin/jvm/functions/Function1;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda7;->f$4 Lkotlin/jvm/functions/Function2;
    iput v6, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda7;->f$5 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=3
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;
    iget-object v1, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda7;->f$1 Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
    iget-object v2, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda7;->f$2 Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda7;->f$3 Lkotlin/jvm/functions/Function1;
    iget-object v4, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda7;->f$4 Lkotlin/jvm/functions/Function2;
    iget v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda7;->f$5 I
    move-object v6, v9
    check-cast v6, Landroidx/compose/runtime/Composer;
    check-cast v10, Ljava/lang/Integer;
    invoke-virtual v10, Ljava/lang/Integer;->intValue()I
    move-result v7
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->$r8$lambda$wzSOPH9hdgfeiSKhctqoadP7Itc(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function2; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v9
    return-object v9
.end method
