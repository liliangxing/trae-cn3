# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactRenderPlan;
.super Ljava/lang/Object;
.source "ArtifactRenderPlan.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactRenderPlan;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactRenderPlan;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactRenderPlan;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactRenderPlan;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactRenderPlan;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final splitChangedCodes(com.bytedance.trae.im.model.ChangedFileData)com.bytedance.trae.conversation.chat.block.renderer.ChangedCodeRenderPlan
    .registers 12
    # ins_size=2
    const/4 v0, 0
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ChangedFileData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v1
    goto +2h
    move-object v1, v0
    if-nez v1, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    invoke-interface v1, Ljava/util/List;->isEmpty()Z
    move-result v2
    if-eqz v2, +00ch
    new-instance v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ChangedCodeRenderPlan;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    invoke-direct v11, v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ChangedCodeRenderPlan;-><init>(Ljava/util/List; Lcom/bytedance/trae/im/model/ChangedFileData;)V
    return-object v11
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    const/4 v5, 1
    if-eqz v4, +01bh
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v6, v4
    check-cast v6, Lcom/bytedance/trae/im/model/FileDiffInfo;
    invoke-virtual v6, Lcom/bytedance/trae/im/model/FileDiffInfo;->getHtmlRender()Ljava/lang/Boolean;
    move-result-object v6
    invoke-static v5, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v5
    invoke-static v6, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, -01ah
    invoke-interface v2, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1fh
    check-cast v2, Ljava/util/List;
    invoke-interface v2, Ljava/util/List;->isEmpty()Z
    move-result v3
    if-eqz v3, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ChangedCodeRenderPlan;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    invoke-direct v0, v1, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ChangedCodeRenderPlan;-><init>(Ljava/util/List; Lcom/bytedance/trae/im/model/ChangedFileData;)V
    return-object v0
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +01bh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v6, v4
    check-cast v6, Lcom/bytedance/trae/im/model/FileDiffInfo;
    invoke-virtual v6, Lcom/bytedance/trae/im/model/FileDiffInfo;->getHtmlRender()Ljava/lang/Boolean;
    move-result-object v6
    invoke-static v5, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v7
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, -019h
    invoke-interface v3, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1eh
    check-cast v3, Ljava/util/List;
    invoke-interface v3, Ljava/util/List;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    goto +5ah
    if-eqz v11, +059h
    const/4 v5, 0
    move-object v0, v3
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const/4 v4, 0
    move v6, v4
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +016h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/im/model/FileDiffInfo;
    invoke-virtual v7, Lcom/bytedance/trae/im/model/FileDiffInfo;->getInsertLineCount()Ljava/lang/Integer;
    move-result-object v7
    if-eqz v7, +007h
    invoke-virtual v7, Ljava/lang/Integer;->intValue()I
    move-result v7
    goto +2h
    move v7, v4
    add-int/2addr v6, v7
    goto -19h
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    move v1, v4
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +016h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/im/model/FileDiffInfo;
    invoke-virtual v7, Lcom/bytedance/trae/im/model/FileDiffInfo;->getDeleteLineCount()Ljava/lang/Integer;
    move-result-object v7
    if-eqz v7, +007h
    invoke-virtual v7, Ljava/lang/Integer;->intValue()I
    move-result v7
    goto +2h
    move v7, v4
    add-int/2addr v1, v7
    goto -19h
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    const/4 v8, 1
    const/4 v9, 0
    new-instance v0, Lcom/bytedance/trae/im/model/ArtifactDiffInfo;
    move-object v4, v0
    invoke-direct/range v4 ... v9, Lcom/bytedance/trae/im/model/ArtifactDiffInfo;-><init>(Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v11, v0, v3, Lcom/bytedance/trae/im/model/ChangedFileData;->copy(Lcom/bytedance/trae/im/model/ArtifactDiffInfo; Ljava/util/List;)Lcom/bytedance/trae/im/model/ChangedFileData;
    move-result-object v0
    new-instance v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ChangedCodeRenderPlan;
    invoke-direct v11, v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ChangedCodeRenderPlan;-><init>(Ljava/util/List; Lcom/bytedance/trae/im/model/ChangedFileData;)V
    return-object v11
.end method
