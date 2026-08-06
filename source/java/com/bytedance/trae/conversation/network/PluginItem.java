package com.bytedance.trae.conversation.network;

import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b+\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B¹\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00105\u001a\u00020\u000eHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u00109\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010(JÀ\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u0010;J\u0013\u0010<\u001a\u00020\u000e2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020?HÖ\u0001J\t\u0010@\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010)\u001a\u0004\b*\u0010(¨\u0006A"}, d2 = {"Lcom/bytedance/trae/conversation/network/PluginItem;", "", "pluginId", "", "name", "originPluginName", "dirName", "displayName", "description", "iconUrl", "version", "registry", "marketplacePluginId", "enabled", "", "connectorJson", "disabledAbilities", "", "createdAt", "", "updatedAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;)V", "getPluginId", "()Ljava/lang/String;", "getName", "getOriginPluginName", "getDirName", "getDisplayName", "getDescription", "getIconUrl", "getVersion", "getRegistry", "getMarketplacePluginId", "getEnabled", "()Z", "getConnectorJson", "getDisabledAbilities", "()Ljava/util/List;", "getCreatedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/trae/conversation/network/PluginItem;", "equals", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class PluginItem {

    @SerializedName("connector_json")
    private final String connectorJson;

    @SerializedName("created_at")
    private final Long createdAt;

    @SerializedName("description")
    private final String description;

    @SerializedName("dir_name")
    private final String dirName;

    @SerializedName("disabled_abilities")
    private final List<String> disabledAbilities;

    @SerializedName(IGoogleService.ResponseKey.DISPLAY_NAME)
    private final String displayName;

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("marketplace_plugin_id")
    private final String marketplacePluginId;

    @SerializedName("name")
    private final String name;

    @SerializedName("origin_plugin_name")
    private final String originPluginName;

    @SerializedName("plugin_id")
    private final String pluginId;

    @SerializedName("registry")
    private final String registry;

    @SerializedName("updated_at")
    private final Long updatedAt;

    @SerializedName("version")
    private final String version;

    public PluginItem() {
        this(null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, 32767, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPluginId() {
        return this.pluginId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getMarketplacePluginId() {
        return this.marketplacePluginId;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: component12, reason: from getter */
    public final String getConnectorJson() {
        return this.connectorJson;
    }

    public final List<String> component13() {
        return this.disabledAbilities;
    }

    /* renamed from: component14, reason: from getter */
    public final Long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component15, reason: from getter */
    public final Long getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getOriginPluginName() {
        return this.originPluginName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDirName() {
        return this.dirName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component7, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component8, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component9, reason: from getter */
    public final String getRegistry() {
        return this.registry;
    }

    public final PluginItem copy(String pluginId, String name, String originPluginName, String dirName, String displayName, String description, String iconUrl, String version, String registry, String marketplacePluginId, boolean enabled, String connectorJson, List<String> disabledAbilities, Long createdAt, Long updatedAt) {
        Intrinsics.checkNotNullParameter(pluginId, "pluginId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(disabledAbilities, "disabledAbilities");
        return new PluginItem(pluginId, name, originPluginName, dirName, displayName, description, iconUrl, version, registry, marketplacePluginId, enabled, connectorJson, disabledAbilities, createdAt, updatedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PluginItem)) {
            return false;
        }
        PluginItem pluginItem = (PluginItem) other;
        return Intrinsics.areEqual(this.pluginId, pluginItem.pluginId) && Intrinsics.areEqual(this.name, pluginItem.name) && Intrinsics.areEqual(this.originPluginName, pluginItem.originPluginName) && Intrinsics.areEqual(this.dirName, pluginItem.dirName) && Intrinsics.areEqual(this.displayName, pluginItem.displayName) && Intrinsics.areEqual(this.description, pluginItem.description) && Intrinsics.areEqual(this.iconUrl, pluginItem.iconUrl) && Intrinsics.areEqual(this.version, pluginItem.version) && Intrinsics.areEqual(this.registry, pluginItem.registry) && Intrinsics.areEqual(this.marketplacePluginId, pluginItem.marketplacePluginId) && this.enabled == pluginItem.enabled && Intrinsics.areEqual(this.connectorJson, pluginItem.connectorJson) && Intrinsics.areEqual(this.disabledAbilities, pluginItem.disabledAbilities) && Intrinsics.areEqual(this.createdAt, pluginItem.createdAt) && Intrinsics.areEqual(this.updatedAt, pluginItem.updatedAt);
    }

    public int hashCode() {
        int hashCode = ((this.pluginId.hashCode() * 31) + this.name.hashCode()) * 31;
        String str = this.originPluginName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.dirName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.displayName;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.description;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.iconUrl;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.version;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.registry;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.marketplacePluginId;
        int hashCode9 = (((hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31) + Boolean.hashCode(this.enabled)) * 31;
        String str9 = this.connectorJson;
        int hashCode10 = (((hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31) + this.disabledAbilities.hashCode()) * 31;
        Long l = this.createdAt;
        int hashCode11 = (hashCode10 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.updatedAt;
        return hashCode11 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PluginItem(pluginId=");
        sb.append(this.pluginId).append(", name=").append(this.name).append(", originPluginName=").append(this.originPluginName).append(", dirName=").append(this.dirName).append(", displayName=").append(this.displayName).append(", description=").append(this.description).append(", iconUrl=").append(this.iconUrl).append(", version=").append(this.version).append(", registry=").append(this.registry).append(", marketplacePluginId=").append(this.marketplacePluginId).append(", enabled=").append(this.enabled).append(", connectorJson=");
        sb.append(this.connectorJson).append(", disabledAbilities=").append(this.disabledAbilities).append(", createdAt=").append(this.createdAt).append(", updatedAt=").append(this.updatedAt).append(')');
        return sb.toString();
    }

    public PluginItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, String str11, List<String> list, Long l, Long l2) {
        Intrinsics.checkNotNullParameter(str, "pluginId");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(list, "disabledAbilities");
        this.pluginId = str;
        this.name = str2;
        this.originPluginName = str3;
        this.dirName = str4;
        this.displayName = str5;
        this.description = str6;
        this.iconUrl = str7;
        this.version = str8;
        this.registry = str9;
        this.marketplacePluginId = str10;
        this.enabled = z;
        this.connectorJson = str11;
        this.disabledAbilities = list;
        this.createdAt = l;
        this.updatedAt = l2;
    }

    public final String getPluginId() {
        return this.pluginId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOriginPluginName() {
        return this.originPluginName;
    }

    public final String getDirName() {
        return this.dirName;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getRegistry() {
        return this.registry;
    }

    public final String getMarketplacePluginId() {
        return this.marketplacePluginId;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getConnectorJson() {
        return this.connectorJson;
    }

    public /* synthetic */ PluginItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, String str11, List list, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) == 0 ? str2 : "", (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : str9, (i & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? null : str10, (i & 1024) != 0 ? true : z, (i & 2048) != 0 ? null : str11, (i & 4096) != 0 ? CollectionsKt.emptyList() : list, (i & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? null : l, (i & 16384) == 0 ? l2 : null);
    }

    public final List<String> getDisabledAbilities() {
        return this.disabledAbilities;
    }

    public final Long getCreatedAt() {
        return this.createdAt;
    }

    public final Long getUpdatedAt() {
        return this.updatedAt;
    }
}
