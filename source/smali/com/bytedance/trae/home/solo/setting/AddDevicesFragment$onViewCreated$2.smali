# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment$onViewCreated$2;
.super Ljava/lang/Object;
.source "AddDevicesFragment.kt"

.implements Lcom/bytedance/trae/common/widget/UrlSpanTextView$OnClickListener;

.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;


.method constructor <init>(com.bytedance.trae.home.solo.setting.AddDevicesFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment$onViewCreated$2;->this$0 Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onUrlClick(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, url
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v2
    if-eqz v2, +005h
    const-string v2, "https://trae.ai"
    goto +3h
    const-string v2, "https://trae.cn"
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment$onViewCreated$2;->this$0 Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;
    invoke-static v0, v2, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->access$openUrl(Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment; Ljava/lang/String;)V
    return-void 
.end method
