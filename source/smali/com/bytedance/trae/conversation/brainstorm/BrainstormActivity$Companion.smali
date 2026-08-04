# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$Companion;
.super Ljava/lang/Object;
.source "BrainstormActivity.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$Companion;-><init>()V
    return-void 
.end method

.method public final hasSeenIntro$conversation_mainlandRelease()boolean
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->INSTANCE Lcom/bytedance/trae/conversation/AccountSettingsKeva;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "brainstorm_has_seen_intro"
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getBoolean(Ljava/lang/String; Z)Z
    move-result v0
    return v0
.end method
