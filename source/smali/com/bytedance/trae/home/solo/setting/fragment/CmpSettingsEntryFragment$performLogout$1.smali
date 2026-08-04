# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$performLogout$1;
.super Ljava/lang/Object;
.source "CmpSettingsEntryFragment.kt"

.implements Lcom/bytedance/trae/login/api/IAccountCallback;

.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;


.method constructor <init>(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$performLogout$1;->this$0 Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onDeviceOverLimit(java.lang.String  java.util.Map)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public onFailed(com.bytedance.trae.login.api.LoginPlatform  int  java.lang.String  java.lang.String  java.lang.Throwable  java.lang.String  java.lang.Integer  java.lang.String  java.util.Map)void
    .registers 10
    # ins_size=10
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$performLogout$1;->this$0 Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;
    invoke-static v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->access$dismissSheet(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;)V
    return-void 
.end method

.method public onSuccess(com.bytedance.trae.login.api.LoginPlatform  java.lang.String  java.lang.Boolean)void
    .registers 4
    # ins_size=4
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$performLogout$1;->this$0 Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;
    invoke-static v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->access$dismissSheet(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;)V
    return-void 
.end method
