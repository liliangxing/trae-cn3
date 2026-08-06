package com.bytedance.trae.im.service.tenant;

import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.timonbase.scene.PageDataManager;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TenantUserConfigModels.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0006HÂ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J\t\u0010-\u001a\u00020\u000eHÆ\u0003J\t\u0010.\u001a\u00020\fHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0085\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00102\u001a\u00020\n2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\fHÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030#8F¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u00066"}, d2 = {"Lcom/bytedance/trae/im/service/tenant/McpWhitelistItem;", "", "name", "", "command", "rawArg", "Lcom/google/gson/JsonElement;", "argsHash", "configJson", "enable", "", TimonPipeline.KEY_SOURCE, "", "mtime", "", PageDataManager.EXTRA_STATUS, DBData.FIELD_TYPE, IWeixinService.ResponseConstants.URL, "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonElement;Ljava/lang/String;Ljava/lang/String;ZIJILjava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getCommand", "getArgsHash", "getConfigJson", "getEnable", "()Z", "getSource", "()I", "getMtime", "()J", "getStatus", "getType", "getUrl", "arg", "", "getArg", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class McpWhitelistItem {

    @SerializedName("args_hash")
    private final String argsHash;

    @SerializedName("command")
    private final String command;

    @SerializedName("config_json")
    private final String configJson;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("mtime")
    private final long mtime;

    @SerializedName("name")
    private final String name;

    @SerializedName("arg")
    private final JsonElement rawArg;

    @SerializedName(TimonPipeline.KEY_SOURCE)
    private final int source;

    @SerializedName(PageDataManager.EXTRA_STATUS)
    private final int status;

    @SerializedName(alternate = {"mcp_type"}, value = DBData.FIELD_TYPE)
    private final String type;

    @SerializedName(IWeixinService.ResponseConstants.URL)
    private final String url;

    public McpWhitelistItem() {
        this(null, null, null, null, null, false, 0, 0L, 0, null, null, 2047, null);
    }

    /* renamed from: component3, reason: from getter */
    private final JsonElement getRawArg() {
        return this.rawArg;
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component10, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component11, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCommand() {
        return this.command;
    }

    /* renamed from: component4, reason: from getter */
    public final String getArgsHash() {
        return this.argsHash;
    }

    /* renamed from: component5, reason: from getter */
    public final String getConfigJson() {
        return this.configJson;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component7, reason: from getter */
    public final int getSource() {
        return this.source;
    }

    /* renamed from: component8, reason: from getter */
    public final long getMtime() {
        return this.mtime;
    }

    /* renamed from: component9, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    public final McpWhitelistItem copy(String name, String command, JsonElement rawArg, String argsHash, String configJson, boolean enable, int source, long mtime, int status, String type, String url) {
        return new McpWhitelistItem(name, command, rawArg, argsHash, configJson, enable, source, mtime, status, type, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof McpWhitelistItem)) {
            return false;
        }
        McpWhitelistItem mcpWhitelistItem = (McpWhitelistItem) other;
        return Intrinsics.areEqual(this.name, mcpWhitelistItem.name) && Intrinsics.areEqual(this.command, mcpWhitelistItem.command) && Intrinsics.areEqual(this.rawArg, mcpWhitelistItem.rawArg) && Intrinsics.areEqual(this.argsHash, mcpWhitelistItem.argsHash) && Intrinsics.areEqual(this.configJson, mcpWhitelistItem.configJson) && this.enable == mcpWhitelistItem.enable && this.source == mcpWhitelistItem.source && this.mtime == mcpWhitelistItem.mtime && this.status == mcpWhitelistItem.status && Intrinsics.areEqual(this.type, mcpWhitelistItem.type) && Intrinsics.areEqual(this.url, mcpWhitelistItem.url);
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.command;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        JsonElement jsonElement = this.rawArg;
        int hashCode3 = (hashCode2 + (jsonElement == null ? 0 : jsonElement.hashCode())) * 31;
        String str3 = this.argsHash;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.configJson;
        int hashCode5 = (((((((((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + Boolean.hashCode(this.enable)) * 31) + Integer.hashCode(this.source)) * 31) + Long.hashCode(this.mtime)) * 31) + Integer.hashCode(this.status)) * 31;
        String str5 = this.type;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.url;
        return hashCode6 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("McpWhitelistItem(name=");
        sb.append(this.name).append(", command=").append(this.command).append(", rawArg=").append(this.rawArg).append(", argsHash=").append(this.argsHash).append(", configJson=").append(this.configJson).append(", enable=").append(this.enable).append(", source=").append(this.source).append(", mtime=").append(this.mtime).append(", status=").append(this.status).append(", type=").append(this.type).append(", url=").append(this.url).append(')');
        return sb.toString();
    }

    public McpWhitelistItem(String str, String str2, JsonElement jsonElement, String str3, String str4, boolean z, int i, long j, int i2, String str5, String str6) {
        this.name = str;
        this.command = str2;
        this.rawArg = jsonElement;
        this.argsHash = str3;
        this.configJson = str4;
        this.enable = z;
        this.source = i;
        this.mtime = j;
        this.status = i2;
        this.type = str5;
        this.url = str6;
    }

    public /* synthetic */ McpWhitelistItem(String str, String str2, JsonElement jsonElement, String str3, String str4, boolean z, int i, long j, int i2, String str5, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : jsonElement, (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? null : str4, (i3 & 32) != 0 ? false : z, (i3 & 64) != 0 ? 0 : i, (i3 & 128) != 0 ? 0L : j, (i3 & StatusBarUtils.FLAG_NOTCH_SUPPORT) == 0 ? i2 : 0, (i3 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? null : str5, (i3 & 1024) == 0 ? str6 : null);
    }

    public final String getName() {
        return this.name;
    }

    public final String getCommand() {
        return this.command;
    }

    public final String getArgsHash() {
        return this.argsHash;
    }

    public final String getConfigJson() {
        return this.configJson;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getSource() {
        return this.source;
    }

    public final long getMtime() {
        return this.mtime;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final List<String> getArg() {
        List<String> stringListFromArrayOrJsonString;
        stringListFromArrayOrJsonString = TenantUserConfigModelsKt.stringListFromArrayOrJsonString(this.rawArg);
        return stringListFromArrayOrJsonString;
    }
}
