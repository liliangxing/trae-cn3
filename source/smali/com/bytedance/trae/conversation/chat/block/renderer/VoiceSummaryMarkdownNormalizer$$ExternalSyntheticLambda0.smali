# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lkotlin/jvm/internal/Ref$ObjectRef;
.field public final synthetic f$1:Lkotlin/jvm/internal/Ref$IntRef;


.method public synthetic constructor <init>(kotlin.jvm.internal.Ref$ObjectRef  kotlin.jvm.internal.Ref$IntRef)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer$$ExternalSyntheticLambda0;->f$0 Lkotlin/jvm/internal/Ref$ObjectRef;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer$$ExternalSyntheticLambda0;->f$1 Lkotlin/jvm/internal/Ref$IntRef;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer$$ExternalSyntheticLambda0;->f$0 Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer$$ExternalSyntheticLambda0;->f$1 Lkotlin/jvm/internal/Ref$IntRef;
    check-cast v3, Ljava/lang/String;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer;->$r8$lambda$W5QuaMMNOe0ckjW8Bj7P656x6VY(Lkotlin/jvm/internal/Ref$ObjectRef; Lkotlin/jvm/internal/Ref$IntRef; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method
