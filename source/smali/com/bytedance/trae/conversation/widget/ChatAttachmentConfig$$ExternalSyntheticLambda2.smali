# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function4;


.method public synthetic constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object  java.lang.Object  java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=5
    check-cast v1, Lcom/bytedance/trae/conversation/widget/ChatMode;
    check-cast v2, Ljava/lang/Boolean;
    invoke-virtual v2, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    check-cast v3, Ljava/lang/Boolean;
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    check-cast v4, Ljava/lang/String;
    invoke-static v1, v2, v3, v4, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig;->$r8$lambda$fWJfUEanWjztoK7hPCNTCPV8PRc(Lcom/bytedance/trae/conversation/widget/ChatMode; Z Z Ljava/lang/String;)Z
    move-result v1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    return-object v1
.end method
