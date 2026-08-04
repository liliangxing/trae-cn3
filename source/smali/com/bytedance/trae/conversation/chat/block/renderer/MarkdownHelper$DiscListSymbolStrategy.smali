# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$DiscListSymbolStrategy;
.super Ljava/lang/Object;
.source "MarkdownHelper.kt"

.implements Lcom/larus/business/markdown/api/model/ListSymbolStrategy;

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$DiscListSymbolStrategy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$DiscListSymbolStrategy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$DiscListSymbolStrategy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$DiscListSymbolStrategy;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$DiscListSymbolStrategy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public orderedSymbol(int)com.larus.business.markdown.api.model.OrderedSymbol
    .registers 2
    # ins_size=2
    sget-object v1, Lcom/larus/business/markdown/api/model/OrderedSymbol;->DECIMAL Lcom/larus/business/markdown/api/model/OrderedSymbol;
    return-object v1
.end method

.method public unorderedSymbol(int)com.larus.business.markdown.api.model.UnorderedSymbol
    .registers 2
    # ins_size=2
    sget-object v1, Lcom/larus/business/markdown/api/model/UnorderedSymbol;->DISC Lcom/larus/business/markdown/api/model/UnorderedSymbol;
    return-object v1
.end method
