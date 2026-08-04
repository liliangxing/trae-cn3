# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;
.super Ljava/lang/Object;
.source "MessageRepository.kt"

.field private batchIndex:I
.field private final buffer:Ljava/lang/StringBuilder;
.field private fragmentCount:I
.field private final messageId:Ljava/lang/String;


.method public constructor <init>(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "messageId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;->messageId Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;->buffer Ljava/lang/StringBuilder;
    return-void 
.end method

.method public final getBatchIndex()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;->batchIndex I
    return v0
.end method

.method public final getBuffer()java.lang.StringBuilder
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;->buffer Ljava/lang/StringBuilder;
    return-object v0
.end method

.method public final getFragmentCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;->fragmentCount I
    return v0
.end method

.method public final getMessageId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final setBatchIndex(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;->batchIndex I
    return-void 
.end method

.method public final setFragmentCount(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;->fragmentCount I
    return-void 
.end method
