# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda15;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
.field public final synthetic f$2:Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;
.field public final synthetic f$3:I


.method public synthetic constructor <init>(java.lang.String  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  com.bytedance.trae.home.solo.setting.ui.SettingsTextBadgeStyle  int)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda15;->f$0 Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda15;->f$1 Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda15;->f$2 Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;
    iput v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda15;->f$3 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=3
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda15;->f$0 Ljava/lang/String;
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda15;->f$1 Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
    iget-object v2, v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda15;->f$2 Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;
    iget v3, v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$$ExternalSyntheticLambda15;->f$3 I
    move-object v4, v7
    check-cast v4, Landroidx/compose/runtime/Composer;
    check-cast v8, Ljava/lang/Integer;
    invoke-virtual v8, Ljava/lang/Integer;->intValue()I
    move-result v5
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->$r8$lambda$Kl6ELPJ2KK0IB-klT1-rDTszT_Q(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v7
    return-object v7
.end method
