# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;
.super Ljava/lang/Object;
.source "PluginListCache.kt"

.field private final loadedAt:J
.field private final plugins:Ljava/util/List;


.method public constructor <init>(java.util.List  long)void
    .registers 5
    # ins_size=4
    const-string v0, "plugins"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;->plugins Ljava/util/List;
    iput-wide v3, v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;->loadedAt J
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.plugin.PluginListCache$InstalledCacheEntry  java.util.List  long  int  java.lang.Object)com.bytedance.trae.conversation.plugin.PluginListCache$InstalledCacheEntry
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;->plugins Ljava/util/List;
    and-int/lit8 v4, v4, 2
    if-eqz v4, +004h
    iget-wide v2, v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;->loadedAt J
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;->copy(Ljava/util/List; J)Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;->plugins Ljava/util/List;
    return-object v0
.end method

.method public final component2()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;->loadedAt J
    return-wide v0
.end method

.method public final copy(java.util.List  long)com.bytedance.trae.conversation.plugin.PluginListCache$InstalledCacheEntry
    .registers 5
    # ins_size=4
    const-string v0, "plugins"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;-><init>(Ljava/util/List; J)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;->plugins Ljava/util/List;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;->plugins Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;->loadedAt J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;->loadedAt J
    cmp-long v8, v3, v5
    if-eqz v8, +003h
    return v2
    return v0
.end method

.method public final getLoadedAt()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;->loadedAt J
    return-wide v0
.end method

.method public final getPlugins()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;->plugins Ljava/util/List;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;->plugins Ljava/util/List;
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;->loadedAt J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "InstalledCacheEntry(plugins="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;->plugins Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", loadedAt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/plugin/PluginListCache$InstalledCacheEntry;->loadedAt J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
