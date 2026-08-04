# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoutePolicy;
.super Ljava/lang/Object;
.source "PendingDeepLinkRoutePolicy.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoutePolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoutePolicy;
    invoke-direct v0, Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoutePolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoutePolicy;->INSTANCE Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoutePolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final resolve(java.lang.String  java.lang.String)com.bytedance.trae.home.zlink.PendingDeepLinkRoute
    .registers 5
    # ins_size=3
    const-string v0, "conversation"
    const/4 v1, 1
    invoke-static v3, v0, v1, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v3
    if-eqz v3, +019h
    const/4 v3, 0
    if-eqz v4, +00dh
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/2addr v0, v1
    if-eqz v0, +003h
    goto +2h
    move-object v4, v3
    new-instance v3, Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute$Conversation;
    invoke-direct v3, v4, Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute$Conversation;-><init>(Ljava/lang/String;)V
    check-cast v3, Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute;
    goto +5h
    sget-object v3, Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute$RoutedByZlink;->INSTANCE Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute$RoutedByZlink;
    check-cast v3, Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute;
    return-object v3
.end method
