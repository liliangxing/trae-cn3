# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/utils/logger/LogParameter;
.super Ljava/lang/Object;
.source "FormatLogBuilder.kt"

.field private eventType:Ljava/lang/String;
.field private linkID:Ljava/util/List;
.field private params:Ljava/util/Map;
.field private source:Ljava/lang/String;
.field private what:Ljava/lang/String;
.field private whereInfo:Ljava/lang/String;
.field private who:Ljava/lang/String;


.method public constructor <init>(java.lang.String  java.util.List  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.util.Map)void
    .registers 9
    # ins_size=8
    const-string/jumbo v0, what
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/utils/logger/LogParameter;->what Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/utils/logger/LogParameter;->linkID Ljava/util/List;
    iput-object v4, v1, Lcom/bytedance/trae/utils/logger/LogParameter;->eventType Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/utils/logger/LogParameter;->whereInfo Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/utils/logger/LogParameter;->who Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/utils/logger/LogParameter;->source Ljava/lang/String;
    iput-object v8, v1, Lcom/bytedance/trae/utils/logger/LogParameter;->params Ljava/util/Map;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.util.List  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.util.Map  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 17
    # ins_size=10
    and-int/lit8 v0, v15, 2
    const/4 v1, 0
    if-eqz v0, +004h
    move-object v0, v1
    goto +2h
    move-object v0, v9
    and-int/lit8 v2, v15, 4
    if-eqz v2, +004h
    move-object v2, v1
    goto +2h
    move-object v2, v10
    and-int/lit8 v3, v15, 8
    if-eqz v3, +004h
    move-object v3, v1
    goto +2h
    move-object v3, v11
    and-int/lit8 v4, v15, 16
    if-eqz v4, +004h
    move-object v4, v1
    goto +2h
    move-object v4, v12
    and-int/lit8 v5, v15, 32
    if-eqz v5, +004h
    move-object v5, v1
    goto +2h
    move-object v5, v13
    and-int/lit8 v6, v15, 64
    if-eqz v6, +003h
    goto +2h
    move-object v1, v14
    move-object v9, v7
    move-object v10, v8
    move-object v11, v0
    move-object v12, v2
    move-object v13, v3
    move-object v14, v4
    move-object v15, v5
    move-object/from16 v16, v1
    invoke-direct/range v9 ... v16, Lcom/bytedance/trae/utils/logger/LogParameter;-><init>(Ljava/lang/String; Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map;)V
    return-void 
.end method

.method public final getEventType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/utils/logger/LogParameter;->eventType Ljava/lang/String;
    return-object v0
.end method

.method public final getLinkID()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/utils/logger/LogParameter;->linkID Ljava/util/List;
    return-object v0
.end method

.method public final getParams()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/utils/logger/LogParameter;->params Ljava/util/Map;
    return-object v0
.end method

.method public final getSource()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/utils/logger/LogParameter;->source Ljava/lang/String;
    return-object v0
.end method

.method public final getWhat()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/utils/logger/LogParameter;->what Ljava/lang/String;
    return-object v0
.end method

.method public final getWhereInfo()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/utils/logger/LogParameter;->whereInfo Ljava/lang/String;
    return-object v0
.end method

.method public final getWho()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/utils/logger/LogParameter;->who Ljava/lang/String;
    return-object v0
.end method

.method public final setEventType(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/utils/logger/LogParameter;->eventType Ljava/lang/String;
    return-void 
.end method

.method public final setLinkID(java.util.List)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/utils/logger/LogParameter;->linkID Ljava/util/List;
    return-void 
.end method

.method public final setParams(java.util.Map)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/utils/logger/LogParameter;->params Ljava/util/Map;
    return-void 
.end method

.method public final setSource(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/utils/logger/LogParameter;->source Ljava/lang/String;
    return-void 
.end method

.method public final setWhat(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/utils/logger/LogParameter;->what Ljava/lang/String;
    return-void 
.end method

.method public final setWhereInfo(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/utils/logger/LogParameter;->whereInfo Ljava/lang/String;
    return-void 
.end method

.method public final setWho(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/utils/logger/LogParameter;->who Ljava/lang/String;
    return-void 
.end method
