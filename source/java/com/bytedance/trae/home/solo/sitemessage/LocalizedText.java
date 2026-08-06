package com.bytedance.trae.home.solo.sitemessage;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.utils.LocaleManager;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SiteMessageApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0015\u001a\u00020\u0016H×\u0001J\t\u0010\u0017\u001a\u00020\u0003H×\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;", "", "en", "", LocaleManager.LANGUAGE_JA, "zhCn", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEn", "()Ljava/lang/String;", "getJa", "getZhCn", "localized", "getLocalized", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class LocalizedText {
    public static final int $stable = 0;

    @SerializedName("en")
    private final String en;

    @SerializedName(LocaleManager.LANGUAGE_JA)
    private final String ja;

    @SerializedName("zh-cn")
    private final String zhCn;

    public LocalizedText() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ LocalizedText copy$default(LocalizedText localizedText, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = localizedText.en;
        }
        if ((i & 2) != 0) {
            str2 = localizedText.ja;
        }
        if ((i & 4) != 0) {
            str3 = localizedText.zhCn;
        }
        return localizedText.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEn() {
        return this.en;
    }

    /* renamed from: component2, reason: from getter */
    public final String getJa() {
        return this.ja;
    }

    /* renamed from: component3, reason: from getter */
    public final String getZhCn() {
        return this.zhCn;
    }

    public final LocalizedText copy(String en, String ja, String zhCn) {
        return new LocalizedText(en, ja, zhCn);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalizedText)) {
            return false;
        }
        LocalizedText localizedText = (LocalizedText) other;
        return Intrinsics.areEqual(this.en, localizedText.en) && Intrinsics.areEqual(this.ja, localizedText.ja) && Intrinsics.areEqual(this.zhCn, localizedText.zhCn);
    }

    public int hashCode() {
        String str = this.en;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.ja;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.zhCn;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "LocalizedText(en=" + this.en + ", ja=" + this.ja + ", zhCn=" + this.zhCn + ')';
    }

    public LocalizedText(String str, String str2, String str3) {
        this.en = str;
        this.ja = str2;
        this.zhCn = str3;
    }

    public /* synthetic */ LocalizedText(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    public final String getEn() {
        return this.en;
    }

    public final String getJa() {
        return this.ja;
    }

    public final String getZhCn() {
        return this.zhCn;
    }

    public final String getLocalized() {
        String str;
        String effectiveLanguage = LocaleManager.INSTANCE.getEffectiveLanguage();
        if (StringsKt.startsWith$default(effectiveLanguage, LocaleManager.LANGUAGE_ZH, false, 2, (Object) null)) {
            str = this.zhCn;
            if (str == null && (str = this.en) == null) {
                return "";
            }
        } else if (StringsKt.startsWith$default(effectiveLanguage, LocaleManager.LANGUAGE_JA, false, 2, (Object) null)) {
            str = this.ja;
            if (str == null && (str = this.en) == null) {
                return "";
            }
        } else {
            str = this.en;
            if (str == null) {
                return "";
            }
        }
        return str;
    }
}
