# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda5;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:F


.method public synthetic constructor <init>(float)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda5;->f$0 F
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda5;->f$0 F
    check-cast v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1;->$r8$lambda$lyMhUvI-_4IQ08TvErUCQxB8Ti0(F Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
