package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b,\b\u0086\b\u0018\u0000 >2\u00020\u0001:\u0001>B\u00ad\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010/\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u00107\u001a\u00020\u0007HÆ\u0003J¸\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020\u00072\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u000bHÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u001bR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\t\u0010\u001dR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u0010\u0010\u001dR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u001b¨\u0006?"}, d2 = {"Lcom/bytedance/trae/conversation/network/RemoteModelItem;", "", "id", "", "name", "displayName", "isBuiltin", "", "multimodal", "isPreset", "configSource", "", "provider", "customModelId", "iconLight", "iconDark", "isInternalUsageLimit", "features", "rawModel", "Lcom/google/gson/JsonObject;", "isDefault", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/google/gson/JsonObject;Z)V", "getId", "()Ljava/lang/String;", "getName", "getDisplayName", "()Z", "getMultimodal", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getConfigSource", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getProvider", "getCustomModelId", "getIconLight", "getIconDark", "getFeatures", "getRawModel", "()Lcom/google/gson/JsonObject;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/google/gson/JsonObject;Z)Lcom/bytedance/trae/conversation/network/RemoteModelItem;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class RemoteModelItem {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer configSource;
    private final String customModelId;
    private final String displayName;
    private final String features;
    private final String iconDark;
    private final String iconLight;
    private final String id;
    private final boolean isBuiltin;
    private final boolean isDefault;
    private final Boolean isInternalUsageLimit;
    private final Boolean isPreset;
    private final Boolean multimodal;
    private final String name;
    private final String provider;
    private final JsonObject rawModel;

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getIconLight() {
        return this.iconLight;
    }

    /* renamed from: component11, reason: from getter */
    public final String getIconDark() {
        return this.iconDark;
    }

    /* renamed from: component12, reason: from getter */
    public final Boolean getIsInternalUsageLimit() {
        return this.isInternalUsageLimit;
    }

    /* renamed from: component13, reason: from getter */
    public final String getFeatures() {
        return this.features;
    }

    /* renamed from: component14, reason: from getter */
    public final JsonObject getRawModel() {
        return this.rawModel;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getIsDefault() {
        return this.isDefault;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsBuiltin() {
        return this.isBuiltin;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getMultimodal() {
        return this.multimodal;
    }

    /* renamed from: component6, reason: from getter */
    public final Boolean getIsPreset() {
        return this.isPreset;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getConfigSource() {
        return this.configSource;
    }

    /* renamed from: component8, reason: from getter */
    public final String getProvider() {
        return this.provider;
    }

    /* renamed from: component9, reason: from getter */
    public final String getCustomModelId() {
        return this.customModelId;
    }

    public final RemoteModelItem copy(String id, String name, String displayName, boolean isBuiltin, Boolean multimodal, Boolean isPreset, Integer configSource, String provider, String customModelId, String iconLight, String iconDark, Boolean isInternalUsageLimit, String features, JsonObject rawModel, boolean isDefault) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        return new RemoteModelItem(id, name, displayName, isBuiltin, multimodal, isPreset, configSource, provider, customModelId, iconLight, iconDark, isInternalUsageLimit, features, rawModel, isDefault);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemoteModelItem)) {
            return false;
        }
        RemoteModelItem remoteModelItem = (RemoteModelItem) other;
        return Intrinsics.areEqual(this.id, remoteModelItem.id) && Intrinsics.areEqual(this.name, remoteModelItem.name) && Intrinsics.areEqual(this.displayName, remoteModelItem.displayName) && this.isBuiltin == remoteModelItem.isBuiltin && Intrinsics.areEqual(this.multimodal, remoteModelItem.multimodal) && Intrinsics.areEqual(this.isPreset, remoteModelItem.isPreset) && Intrinsics.areEqual(this.configSource, remoteModelItem.configSource) && Intrinsics.areEqual(this.provider, remoteModelItem.provider) && Intrinsics.areEqual(this.customModelId, remoteModelItem.customModelId) && Intrinsics.areEqual(this.iconLight, remoteModelItem.iconLight) && Intrinsics.areEqual(this.iconDark, remoteModelItem.iconDark) && Intrinsics.areEqual(this.isInternalUsageLimit, remoteModelItem.isInternalUsageLimit) && Intrinsics.areEqual(this.features, remoteModelItem.features) && Intrinsics.areEqual(this.rawModel, remoteModelItem.rawModel) && this.isDefault == remoteModelItem.isDefault;
    }

    public int hashCode() {
        int hashCode = ((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.displayName.hashCode()) * 31) + Boolean.hashCode(this.isBuiltin)) * 31;
        Boolean bool = this.multimodal;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isPreset;
        int hashCode3 = (hashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.configSource;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.provider;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.customModelId;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.iconLight;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.iconDark;
        int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool3 = this.isInternalUsageLimit;
        int hashCode9 = (hashCode8 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str5 = this.features;
        int hashCode10 = (hashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        JsonObject jsonObject = this.rawModel;
        return ((hashCode10 + (jsonObject != null ? jsonObject.hashCode() : 0)) * 31) + Boolean.hashCode(this.isDefault);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RemoteModelItem(id=");
        sb.append(this.id).append(", name=").append(this.name).append(", displayName=").append(this.displayName).append(", isBuiltin=").append(this.isBuiltin).append(", multimodal=").append(this.multimodal).append(", isPreset=").append(this.isPreset).append(", configSource=").append(this.configSource).append(", provider=").append(this.provider).append(", customModelId=").append(this.customModelId).append(", iconLight=").append(this.iconLight).append(", iconDark=").append(this.iconDark).append(", isInternalUsageLimit=");
        sb.append(this.isInternalUsageLimit).append(", features=").append(this.features).append(", rawModel=").append(this.rawModel).append(", isDefault=").append(this.isDefault).append(')');
        return sb.toString();
    }

    public RemoteModelItem(String id, String name, String displayName, boolean z, Boolean bool, Boolean bool2, Integer num, String str, String str2, String str3, String str4, Boolean bool3, String str5, JsonObject jsonObject, boolean z2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        this.id = id;
        this.name = name;
        this.displayName = displayName;
        this.isBuiltin = z;
        this.multimodal = bool;
        this.isPreset = bool2;
        this.configSource = num;
        this.provider = str;
        this.customModelId = str2;
        this.iconLight = str3;
        this.iconDark = str4;
        this.isInternalUsageLimit = bool3;
        this.features = str5;
        this.rawModel = jsonObject;
        this.isDefault = z2;
    }

    public /* synthetic */ RemoteModelItem(String str, String str2, String str3, boolean z, Boolean bool, Boolean bool2, Integer num, String str4, String str5, String str6, String str7, Boolean bool3, String str8, JsonObject jsonObject, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? str2 : str3, (i & 8) != 0 ? true : z, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : bool2, (i & 64) != 0 ? null : num, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? null : str6, (i & 1024) != 0 ? null : str7, (i & 2048) != 0 ? null : bool3, (i & 4096) != 0 ? null : str8, (i & 8192) != 0 ? null : jsonObject, (i & 16384) != 0 ? false : z2);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final boolean isBuiltin() {
        return this.isBuiltin;
    }

    public final Boolean getMultimodal() {
        return this.multimodal;
    }

    public final Boolean isPreset() {
        return this.isPreset;
    }

    public final Integer getConfigSource() {
        return this.configSource;
    }

    public final String getProvider() {
        return this.provider;
    }

    public final String getCustomModelId() {
        return this.customModelId;
    }

    public final String getIconLight() {
        return this.iconLight;
    }

    public final String getIconDark() {
        return this.iconDark;
    }

    public final Boolean isInternalUsageLimit() {
        return this.isInternalUsageLimit;
    }

    public final String getFeatures() {
        return this.features;
    }

    public final JsonObject getRawModel() {
        return this.rawModel;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    /* compiled from: Models.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;", "", "<init>", "()V", "auto", "Lcom/bytedance/trae/conversation/network/RemoteModelItem;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RemoteModelItem auto() {
            return new RemoteModelItem("auto", "TRAE Auto Model", "TRAE Auto Model", true, null, null, null, null, null, null, null, null, null, null, false, 32752, null);
        }
    }
}
