# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Ljava/lang/String;


.method public synthetic constructor <init>(java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->$r8$lambda$CeHP22gpoqmdyjv2zoTAXv8X9NQ(Ljava/lang/String;)Z
    move-result v0
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    return-object v0
.end method
