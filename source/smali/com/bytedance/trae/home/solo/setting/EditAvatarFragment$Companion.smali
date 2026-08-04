# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment$Companion;
.super Ljava/lang/Object;
.source "EditAvatarFragment.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment$Companion;-><init>()V
    return-void 
.end method

.method public final newInstance(android.net.Uri)com.bytedance.trae.home.solo.setting.EditAvatarFragment
    .registers 5
    # ins_size=2
    const-string/jumbo v0, uri
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;-><init>()V
    new-instance v2, Landroid/os/Bundle;
    invoke-direct v2, Landroid/os/Bundle;-><init>()V
    check-cast v4, Landroid/os/Parcelable;
    invoke-virtual v2, v0, v4, Landroid/os/Bundle;->putParcelable(Ljava/lang/String; Landroid/os/Parcelable;)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/EditAvatarFragment;->setArguments(Landroid/os/Bundle;)V
    return-object v1
.end method
