# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/skill/SkillsEmptyStateTextPolicy;
.super Ljava/lang/Object;
.source "SkillsEmptyStateTextPolicy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/skill/SkillsEmptyStateTextPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/skill/SkillsEmptyStateTextPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/skill/SkillsEmptyStateTextPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/skill/SkillsEmptyStateTextPolicy;->INSTANCE Lcom/bytedance/trae/conversation/skill/SkillsEmptyStateTextPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final emptyStateTextRes(boolean)int
    .registers 2
    # ins_size=2
    if-eqz v1, +005h
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_skills_empty_ide I
    goto +3h
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_skills_empty I
    return v1
.end method
