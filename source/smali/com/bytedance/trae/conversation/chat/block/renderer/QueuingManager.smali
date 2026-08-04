# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;
.super Ljava/lang/Object;
.source "QueuingManager.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;
.field private static final manager:Ljava/util/HashMap;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;
    new-instance v0, Ljava/util/HashMap;
    invoke-direct v0, Ljava/util/HashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;->manager Ljava/util/HashMap;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getManager()java.util.HashMap
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;->manager Ljava/util/HashMap;
    return-object v0
.end method

.method public final hasMessageId(java.lang.String)boolean
    .registers 3
    # ins_size=2
    const-string v0, "messageId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;->manager Ljava/util/HashMap;
    check-cast v0, Ljava/util/Map;
    invoke-interface v0, v2, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v2
    return v2
.end method

.method public final hasUsedPayRight(java.lang.String  java.lang.String)boolean
    .registers 5
    # ins_size=3
    const-string v0, "messageId"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    if-nez v4, +003h
    return v0
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;->manager Ljava/util/HashMap;
    invoke-virtual v1, v3, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/util/HashSet;
    if-eqz v3, +00ah
    invoke-virtual v3, v4, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z
    move-result v3
    const/4 v4, 1
    if-ne v3, v4, +003h
    move v0, v4
    return v0
.end method

.method public final usePayRight(java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=3
    const-string v0, "messageId"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v4, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;->manager Ljava/util/HashMap;
    check-cast v0, Ljava/util/Map;
    invoke-interface v0, v3, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    if-nez v1, +00ah
    new-instance v1, Ljava/util/HashSet;
    invoke-direct v1, Ljava/util/HashSet;-><init>()V
    invoke-interface v0, v3, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    check-cast v1, Ljava/util/HashSet;
    invoke-virtual v1, v4, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z
    return-void 
.end method
