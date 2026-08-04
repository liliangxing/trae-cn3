# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/model/QueryItem;
.super Ljava/lang/Object;
.source "QueryItem.kt"

.field private static final COMMAND_TYPE_PLUGIN:Ljava/lang/String;
.field private static final COMMAND_TYPE_SKILL:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/model/QueryItem$Companion;
.field public static final TYPE_ATTACHMENT:Ljava/lang/String;
.field public static final TYPE_IMAGE:Ljava/lang/String;
.field public static final TYPE_SLASH_COMMAND:Ljava/lang/String;
.field public static final TYPE_TEXT:Ljava/lang/String;
.field private final data:Ljava/lang/Object;
.field private final type:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/model/QueryItem$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/model/QueryItem$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/model/QueryItem;->Companion Lcom/bytedance/trae/conversation/model/QueryItem$Companion;
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.Object)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, type
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "data"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/model/QueryItem;->type Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/model/QueryItem;->data Ljava/lang/Object;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.model.QueryItem  java.lang.String  java.lang.Object  int  java.lang.Object)com.bytedance.trae.conversation.model.QueryItem
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/model/QueryItem;->type Ljava/lang/String;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/model/QueryItem;->data Ljava/lang/Object;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/model/QueryItem;->copy(Ljava/lang/String; Ljava/lang/Object;)Lcom/bytedance/trae/conversation/model/QueryItem;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/model/QueryItem;->type Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/model/QueryItem;->data Ljava/lang/Object;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.Object)com.bytedance.trae.conversation.model.QueryItem
    .registers 4
    # ins_size=3
    const-string/jumbo v0, type
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "data"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/model/QueryItem;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/model/QueryItem;-><init>(Ljava/lang/String; Ljava/lang/Object;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/model/QueryItem;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/model/QueryItem;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/model/QueryItem;->type Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/model/QueryItem;->type Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/model/QueryItem;->data Ljava/lang/Object;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/model/QueryItem;->data Ljava/lang/Object;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getData()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/model/QueryItem;->data Ljava/lang/Object;
    return-object v0
.end method

.method public final getType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/model/QueryItem;->type Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/model/QueryItem;->type Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/model/QueryItem;->data Ljava/lang/Object;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "QueryItem(type="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/model/QueryItem;->type Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", data="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/model/QueryItem;->data Ljava/lang/Object;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
