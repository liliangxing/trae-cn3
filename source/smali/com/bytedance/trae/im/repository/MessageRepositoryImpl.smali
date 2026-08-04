# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;
.super Ljava/lang/Object;
.source "MessageRepository.kt"

.implements Lcom/bytedance/trae/im/repository/MessageRepository;

.field public static final BATCH_SIZE:I
.field public static final Companion:Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$Companion;
.field private final batchSize:I
.field private final dao:Lcom/bytedance/trae/im/database/ChatMessageDao;
.field private final pendingMap:Ljava/util/HashMap;
.field private final singleThreadDispatcher:Lkotlinx/coroutines/CoroutineDispatcher;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;->Companion Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$Companion;
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.im.database.ChatMessageDao  int)void
    .registers 4
    # ins_size=3
    const-string v0, "dao"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;->dao Lcom/bytedance/trae/im/database/ChatMessageDao;
    iput v3, v1, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;->batchSize I
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v2
    const/4 v3, 1
    invoke-virtual v2, v3, Lkotlinx/coroutines/CoroutineDispatcher;->limitedParallelism(I)Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;->singleThreadDispatcher Lkotlinx/coroutines/CoroutineDispatcher;
    new-instance v2, Ljava/util/HashMap;
    invoke-direct v2, Ljava/util/HashMap;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;->pendingMap Ljava/util/HashMap;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.im.database.ChatMessageDao  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    const/16 v2, 20
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;-><init>(Lcom/bytedance/trae/im/database/ChatMessageDao; I)V
    return-void 
.end method

.method public static final synthetic access$getBatchSize$p(com.bytedance.trae.im.repository.MessageRepositoryImpl)int
    .registers 1
    # ins_size=1
    iget v0, v0, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;->batchSize I
    return v0
.end method

.method public static final synthetic access$getPendingMap$p(com.bytedance.trae.im.repository.MessageRepositoryImpl)java.util.HashMap
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;->pendingMap Ljava/util/HashMap;
    return-object v0
.end method

.method public static final synthetic access$writePending(com.bytedance.trae.im.repository.MessageRepositoryImpl  java.lang.String  com.bytedance.trae.im.repository.MessageRepositoryImpl$PendingThought)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;->writePending(Ljava/lang/String; Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;)V
    return-void 
.end method

.method private final writePending(java.lang.String  com.bytedance.trae.im.repository.MessageRepositoryImpl$PendingThought)void
    .registers 9
    # ins_size=3
    iget-object v0, v6, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;->dao Lcom/bytedance/trae/im/database/ChatMessageDao;
    invoke-virtual v8, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;->getMessageId()Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v3, thought
    invoke-virtual v8, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;->getBatchIndex()I
    move-result v4
    invoke-virtual v8, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;->getBuffer()Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v1, toString(...)
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v1, v7
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/im/database/ChatMessageDao;->insert(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String;)J
    invoke-virtual v8, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;->getBuffer()Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-static v7, Lkotlin/text/StringsKt;->clear(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;
    const/4 v7, 0
    invoke-virtual v8, v7, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;->setFragmentCount(I)V
    invoke-virtual v8, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;->getBatchIndex()I
    move-result v7
    add-int/lit8 v7, v7, 1
    invoke-virtual v8, v7, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;->setBatchIndex(I)V
    return-void 
.end method

.method public appendThought(java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 13
    # ins_size=5
    iget-object v0, v8, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;->singleThreadDispatcher Lkotlinx/coroutines/CoroutineDispatcher;
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v7, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    move-object v4, v11
    move-object v5, v10
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;-><init>(Lcom/bytedance/trae/im/repository/MessageRepositoryImpl; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v7, v12, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v10
    if-ne v9, v10, +003h
    return-object v9
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
.end method

.method public flushThought(java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=4
    iget-object v4, v2, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;->singleThreadDispatcher Lkotlinx/coroutines/CoroutineDispatcher;
    check-cast v4, Lkotlin/coroutines/CoroutineContext;
    new-instance v0, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$flushThought$2;
    const/4 v1, 0
    invoke-direct v0, v2, v3, v1, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$flushThought$2;-><init>(Lcom/bytedance/trae/im/repository/MessageRepositoryImpl; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v0, Lkotlin/jvm/functions/Function2;
    invoke-static v4, v0, v5, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    if-ne v3, v4, +003h
    return-object v3
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method
