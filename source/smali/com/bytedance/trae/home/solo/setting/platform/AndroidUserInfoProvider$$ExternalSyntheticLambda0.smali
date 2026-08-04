# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroidx/lifecycle/Observer;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.platform.AndroidUserInfoProvider)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;
    return-void 
.end method

.method public final onChanged(java.lang.Object)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/UserProfileState;
    invoke-static v0, v2, Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;->$r8$lambda$GZCML2yQyRsh_ZNx6ff-EoX6V2Y(Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider; Lcom/bytedance/trae/home/solo/setting/UserProfileState;)V
    return-void 
.end method
