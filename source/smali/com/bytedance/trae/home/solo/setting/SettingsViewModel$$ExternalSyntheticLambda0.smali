# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.SettingsViewModel)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    check-cast v2, Lcom/bytedance/trae/login/api/AccountInfo;
    invoke-static v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->$r8$lambda$PO5Rt1zPXJp_Pl8OW9tfLEdixVQ(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel; Lcom/bytedance/trae/login/api/AccountInfo;)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
