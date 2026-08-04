# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Ljava/io/File;
.field public final synthetic f$1:Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;


.method public synthetic constructor <init>(java.io.File  com.bytedance.trae.home.solo.setting.SettingsViewModel)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$$ExternalSyntheticLambda3;->f$0 Ljava/io/File;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$$ExternalSyntheticLambda3;->f$1 Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$$ExternalSyntheticLambda3;->f$0 Ljava/io/File;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1$$ExternalSyntheticLambda3;->f$1 Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    check-cast v3, Ljava/lang/Long;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$uploadAvatar$1;->$r8$lambda$O7a6eLQfCDciU7piY2KORCXh6GI(Ljava/io/File; Lcom/bytedance/trae/home/solo/setting/SettingsViewModel; Ljava/lang/Long;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
