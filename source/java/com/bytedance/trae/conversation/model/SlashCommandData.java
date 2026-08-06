package com.bytedance.trae.conversation.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.constant.b;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QueryItem.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bHÆ\u0003Ju\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR$\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lcom/bytedance/trae/conversation/model/SlashCommandData;", "", "id", "", b.y, "displayName", DBDefinition.ICON_URL, "commandType", "content", "filePath", "parameters", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getId", "()Ljava/lang/String;", "getCommand", "getDisplayName", "getIconUrl", "getCommandType", "getContent", "getFilePath", "getParameters", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SlashCommandData {

    @SerializedName(b.y)
    private final String command;

    @SerializedName("command_type")
    private final String commandType;

    @SerializedName("content")
    private final String content;

    @SerializedName("display_name")
    private final String displayName;

    @SerializedName("file_path")
    private final String filePath;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("id")
    private final String id;

    @SerializedName("parameters")
    private final Map<String, Object> parameters;

    public SlashCommandData() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCommand() {
        return this.command;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCommandType() {
        return this.commandType;
    }

    /* renamed from: component6, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component7, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    public final Map<String, Object> component8() {
        return this.parameters;
    }

    public final SlashCommandData copy(String id, String command, String displayName, String iconUrl, String commandType, String content, String filePath, Map<String, ? extends Object> parameters) {
        return new SlashCommandData(id, command, displayName, iconUrl, commandType, content, filePath, parameters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SlashCommandData)) {
            return false;
        }
        SlashCommandData slashCommandData = (SlashCommandData) other;
        return Intrinsics.areEqual(this.id, slashCommandData.id) && Intrinsics.areEqual(this.command, slashCommandData.command) && Intrinsics.areEqual(this.displayName, slashCommandData.displayName) && Intrinsics.areEqual(this.iconUrl, slashCommandData.iconUrl) && Intrinsics.areEqual(this.commandType, slashCommandData.commandType) && Intrinsics.areEqual(this.content, slashCommandData.content) && Intrinsics.areEqual(this.filePath, slashCommandData.filePath) && Intrinsics.areEqual(this.parameters, slashCommandData.parameters);
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.command;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.displayName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.iconUrl;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.commandType;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.content;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.filePath;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Map<String, Object> map = this.parameters;
        return hashCode7 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "SlashCommandData(id=" + this.id + ", command=" + this.command + ", displayName=" + this.displayName + ", iconUrl=" + this.iconUrl + ", commandType=" + this.commandType + ", content=" + this.content + ", filePath=" + this.filePath + ", parameters=" + this.parameters + ')';
    }

    public SlashCommandData(String str, String str2, String str3, String str4, String str5, String str6, String str7, Map<String, ? extends Object> map) {
        this.id = str;
        this.command = str2;
        this.displayName = str3;
        this.iconUrl = str4;
        this.commandType = str5;
        this.content = str6;
        this.filePath = str7;
        this.parameters = map;
    }

    public /* synthetic */ SlashCommandData(String str, String str2, String str3, String str4, String str5, String str6, String str7, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) == 0 ? map : null);
    }

    public final String getId() {
        return this.id;
    }

    public final String getCommand() {
        return this.command;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getCommandType() {
        return this.commandType;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final Map<String, Object> getParameters() {
        return this.parameters;
    }
}
