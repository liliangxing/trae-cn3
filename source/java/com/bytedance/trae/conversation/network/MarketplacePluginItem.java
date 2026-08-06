package com.bytedance.trae.conversation.network;

import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003JC\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006!"}, d2 = {"Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;", "", "pluginId", "", "name", "displayName", "iconUrl", "i18n", "Lcom/bytedance/trae/conversation/network/MarketplacePluginI18n;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/conversation/network/MarketplacePluginI18n;)V", "getPluginId", "()Ljava/lang/String;", "getName", "getDisplayName", "getIconUrl", "getI18n", "()Lcom/bytedance/trae/conversation/network/MarketplacePluginI18n;", "localizedDisplayName", "locale", "Ljava/util/Locale;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class MarketplacePluginItem {

    @SerializedName(IGoogleService.ResponseKey.DISPLAY_NAME)
    private final String displayName;

    @SerializedName("i18n")
    private final MarketplacePluginI18n i18n;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("name")
    private final String name;

    @SerializedName("plugin_id")
    private final String pluginId;

    public MarketplacePluginItem() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ MarketplacePluginItem copy$default(MarketplacePluginItem marketplacePluginItem, String str, String str2, String str3, String str4, MarketplacePluginI18n marketplacePluginI18n, int i, Object obj) {
        if ((i & 1) != 0) {
            str = marketplacePluginItem.pluginId;
        }
        if ((i & 2) != 0) {
            str2 = marketplacePluginItem.name;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = marketplacePluginItem.displayName;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = marketplacePluginItem.iconUrl;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            marketplacePluginI18n = marketplacePluginItem.i18n;
        }
        return marketplacePluginItem.copy(str, str5, str6, str7, marketplacePluginI18n);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPluginId() {
        return this.pluginId;
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
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component5, reason: from getter */
    public final MarketplacePluginI18n getI18n() {
        return this.i18n;
    }

    public final MarketplacePluginItem copy(String pluginId, String name, String displayName, String iconUrl, MarketplacePluginI18n i18n) {
        Intrinsics.checkNotNullParameter(pluginId, "pluginId");
        return new MarketplacePluginItem(pluginId, name, displayName, iconUrl, i18n);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarketplacePluginItem)) {
            return false;
        }
        MarketplacePluginItem marketplacePluginItem = (MarketplacePluginItem) other;
        return Intrinsics.areEqual(this.pluginId, marketplacePluginItem.pluginId) && Intrinsics.areEqual(this.name, marketplacePluginItem.name) && Intrinsics.areEqual(this.displayName, marketplacePluginItem.displayName) && Intrinsics.areEqual(this.iconUrl, marketplacePluginItem.iconUrl) && Intrinsics.areEqual(this.i18n, marketplacePluginItem.i18n);
    }

    public int hashCode() {
        int hashCode = this.pluginId.hashCode() * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.displayName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.iconUrl;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        MarketplacePluginI18n marketplacePluginI18n = this.i18n;
        return hashCode4 + (marketplacePluginI18n != null ? marketplacePluginI18n.hashCode() : 0);
    }

    public String toString() {
        return "MarketplacePluginItem(pluginId=" + this.pluginId + ", name=" + this.name + ", displayName=" + this.displayName + ", iconUrl=" + this.iconUrl + ", i18n=" + this.i18n + ')';
    }

    public MarketplacePluginItem(String str, String str2, String str3, String str4, MarketplacePluginI18n marketplacePluginI18n) {
        Intrinsics.checkNotNullParameter(str, "pluginId");
        this.pluginId = str;
        this.name = str2;
        this.displayName = str3;
        this.iconUrl = str4;
        this.i18n = marketplacePluginI18n;
    }

    public /* synthetic */ MarketplacePluginItem(String str, String str2, String str3, String str4, MarketplacePluginI18n marketplacePluginI18n, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) == 0 ? marketplacePluginI18n : null);
    }

    public final String getPluginId() {
        return this.pluginId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final MarketplacePluginI18n getI18n() {
        return this.i18n;
    }

    public static /* synthetic */ String localizedDisplayName$default(MarketplacePluginItem marketplacePluginItem, Locale locale, int i, Object obj) {
        if ((i & 1) != 0) {
            locale = Locale.getDefault();
        }
        return marketplacePluginItem.localizedDisplayName(locale);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00f4 A[EDGE_INSN: B:28:0x00f4->B:29:0x00f4 BREAK  A[LOOP:0: B:12:0x00b5->B:48:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[LOOP:0: B:12:0x00b5->B:48:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String localizedDisplayName(Locale locale) {
        String str;
        String str2;
        String obj;
        Map<String, String> displayNames;
        String str3;
        Intrinsics.checkNotNullParameter(locale, "locale");
        String languageTag = locale.toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(languageTag, "toLanguageTag(...)");
        Locale locale2 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale2, "ROOT");
        String lowerCase = languageTag.toLowerCase(locale2);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String language = locale.getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        Locale locale3 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale3, "ROOT");
        String lowerCase2 = language.toLowerCase(locale3);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        String country = locale.getCountry();
        Intrinsics.checkNotNullExpressionValue(country, "getCountry(...)");
        Locale locale4 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale4, "ROOT");
        String lowerCase3 = country.toLowerCase(locale4);
        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
        List createListBuilder = CollectionsKt.createListBuilder();
        createListBuilder.add(lowerCase);
        if (lowerCase2.length() > 0) {
            if (lowerCase3.length() > 0) {
                createListBuilder.add(lowerCase2 + '-' + lowerCase3);
                createListBuilder.add(lowerCase2 + '_' + lowerCase3);
            }
        }
        createListBuilder.add(lowerCase2);
        createListBuilder.add("en");
        Iterator it = CollectionsKt.build(createListBuilder).iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                str2 = null;
                break;
            }
            String str4 = (String) it.next();
            MarketplacePluginI18n marketplacePluginI18n = this.i18n;
            if (marketplacePluginI18n != null && (displayNames = marketplacePluginI18n.getDisplayNames()) != null && (str3 = displayNames.get(str4)) != null && (str2 = StringsKt.trim(str3).toString()) != null) {
                if (str2.length() > 0) {
                    if (str2 == null) {
                        break;
                    }
                }
            }
            str2 = null;
            if (str2 == null) {
            }
        }
        if (str2 != null) {
            return str2;
        }
        String str5 = this.displayName;
        if (str5 != null && (obj = StringsKt.trim(str5).toString()) != null) {
            if (obj.length() > 0) {
                str = obj;
            }
        }
        if (str != null) {
            return str;
        }
        String str6 = this.name;
        return str6 == null ? "" : str6;
    }
}
