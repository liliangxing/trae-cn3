# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/praise/PraiseDialogLocalConditionImpl;
.super Ljava/lang/Object;
.source "PraiseDialogLocalConditionImpl.kt"

.implements Lcom/bytedance/praisedialoglib/depend/IPraiseDialogLocalConditionConfig;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public isCurDemo()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->INSTANCE Lcom/bytedance/trae/praise/PraiseDialogTrigger;
    invoke-virtual v0, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->isIgnoreUgRule()Z
    move-result v0
    return v0
.end method

.method public isMatchLocalCondition()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->INSTANCE Lcom/bytedance/trae/praise/PraiseDialogTrigger;
    invoke-virtual v0, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->shouldShow()Z
    move-result v0
    return v0
.end method
