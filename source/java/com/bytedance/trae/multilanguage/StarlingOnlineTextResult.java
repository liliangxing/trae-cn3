package com.bytedance.trae.multilanguage;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StarlingOnlineTextUpdater.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/multilanguage/StarlingOnlineTextResult;", "", "language", "Lcom/bytedance/trae/multilanguage/I18nLanguage;", "stringCount", "", "url", "", "version", "<init>", "(Lcom/bytedance/trae/multilanguage/I18nLanguage;ILjava/lang/String;Ljava/lang/String;)V", "getLanguage", "()Lcom/bytedance/trae/multilanguage/I18nLanguage;", "getStringCount", "()I", "getUrl", "()Ljava/lang/String;", "getVersion", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "multilanguage_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class StarlingOnlineTextResult {
    private final I18nLanguage language;
    private final int stringCount;
    private final String url;
    private final String version;

    public static /* synthetic */ StarlingOnlineTextResult copy$default(StarlingOnlineTextResult starlingOnlineTextResult, I18nLanguage i18nLanguage, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i18nLanguage = starlingOnlineTextResult.language;
        }
        if ((i2 & 2) != 0) {
            i = starlingOnlineTextResult.stringCount;
        }
        if ((i2 & 4) != 0) {
            str = starlingOnlineTextResult.url;
        }
        if ((i2 & 8) != 0) {
            str2 = starlingOnlineTextResult.version;
        }
        return starlingOnlineTextResult.copy(i18nLanguage, i, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final I18nLanguage getLanguage() {
        return this.language;
    }

    /* renamed from: component2, reason: from getter */
    public final int getStringCount() {
        return this.stringCount;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component4, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final StarlingOnlineTextResult copy(I18nLanguage language, int stringCount, String url, String version) {
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(url, "url");
        return new StarlingOnlineTextResult(language, stringCount, url, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StarlingOnlineTextResult)) {
            return false;
        }
        StarlingOnlineTextResult starlingOnlineTextResult = (StarlingOnlineTextResult) other;
        return this.language == starlingOnlineTextResult.language && this.stringCount == starlingOnlineTextResult.stringCount && Intrinsics.areEqual(this.url, starlingOnlineTextResult.url) && Intrinsics.areEqual(this.version, starlingOnlineTextResult.version);
    }

    public int hashCode() {
        int hashCode = ((((this.language.hashCode() * 31) + Integer.hashCode(this.stringCount)) * 31) + this.url.hashCode()) * 31;
        String str = this.version;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "StarlingOnlineTextResult(language=" + this.language + ", stringCount=" + this.stringCount + ", url=" + this.url + ", version=" + this.version + ')';
    }

    public StarlingOnlineTextResult(I18nLanguage language, int i, String url, String str) {
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(url, "url");
        this.language = language;
        this.stringCount = i;
        this.url = url;
        this.version = str;
    }

    public final I18nLanguage getLanguage() {
        return this.language;
    }

    public final int getStringCount() {
        return this.stringCount;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getVersion() {
        return this.version;
    }
}
