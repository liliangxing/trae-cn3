# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet$Companion;
.super Ljava/lang/Object;
.source "BrainstormSummarySheet.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet$Companion;-><init>()V
    return-void 
.end method

.method public final newInstance(com.bytedance.trae.conversation.brainstorm.model.BrainstormSummary)com.bytedance.trae.conversation.brainstorm.widget.BrainstormSummarySheet
    .registers 3
    # ins_size=2
    const-string/jumbo v0, summary
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet;-><init>()V
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet;->access$setSummary$p(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormSummarySheet; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;)V
    return-object v0
.end method
