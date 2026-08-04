# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda6;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/kmp/network/KmpHttpClient;
.field public final synthetic f$1:Lcom/bytedance/trae/kmp/host/KmpHostInfo;


.method public synthetic constructor <init>(com.bytedance.trae.kmp.network.KmpHttpClient  com.bytedance.trae.kmp.host.KmpHostInfo)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda6;->f$0 Lcom/bytedance/trae/kmp/network/KmpHttpClient;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda6;->f$1 Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda6;->f$0 Lcom/bytedance/trae/kmp/network/KmpHttpClient;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$$ExternalSyntheticLambda6;->f$1 Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    check-cast v3, Landroidx/lifecycle/viewmodel/CreationExtras;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt;->$r8$lambda$kRJWmVXoyHPS85_To35iOJwJ4NM(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lcom/bytedance/trae/kmp/host/KmpHostInfo; Landroidx/lifecycle/viewmodel/CreationExtras;)Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;
    move-result-object v3
    return-object v3
.end method
