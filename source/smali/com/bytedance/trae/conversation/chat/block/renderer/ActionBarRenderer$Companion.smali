# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer$Companion;
.super Ljava/lang/Object;
.source "ActionBarRenderer.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer$Companion;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getCachedDrawable(com.bytedance.trae.conversation.chat.block.renderer.ActionBarRenderer$Companion  android.content.Context  int)android.graphics.drawable.Drawable
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer$Companion;->getCachedDrawable(Landroid/content/Context; I)Landroid/graphics/drawable/Drawable;
    move-result-object v0
    return-object v0
.end method

.method private final getCachedDrawable(android.content.Context  int)android.graphics.drawable.Drawable
    .registers 6
    # ins_size=3
    invoke-static Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->access$getDrawableCache$cp()Ljava/util/HashMap;
    move-result-object v0
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/graphics/drawable/Drawable$ConstantState;
    const-string v1, "mutate(...)"
    if-eqz v0, +012h
    invoke-virtual v4, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-virtual v0, v4, Landroid/graphics/drawable/Drawable$ConstantState;->newDrawable(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    move-result-object v4
    invoke-virtual v4, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;
    move-result-object v4
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v4
    invoke-static v4, v5, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context; I)Landroid/graphics/drawable/Drawable;
    move-result-object v0
    if-nez v0, +00ah
    invoke-static v4, v5, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context; I)Landroid/graphics/drawable/Drawable;
    move-result-object v4
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    return-object v4
    invoke-virtual v0, Landroid/graphics/drawable/Drawable;->getConstantState()Landroid/graphics/drawable/Drawable$ConstantState;
    move-result-object v4
    if-eqz v4, +00fh
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    invoke-static Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->access$getDrawableCache$cp()Ljava/util/HashMap;
    move-result-object v2
    check-cast v2, Ljava/util/Map;
    invoke-interface v2, v5, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v0, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;
    move-result-object v4
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v4
.end method
