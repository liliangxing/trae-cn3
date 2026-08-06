package org.jetbrains.compose.resources;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Qualifier.kt */
@InternalResourceApi
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lorg/jetbrains/compose/resources/LanguageQualifier;", "Lorg/jetbrains/compose/resources/Qualifier;", "language", "", "<init>", "(Ljava/lang/String;)V", "getLanguage", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "library_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes9.dex */
public final /* data */ class LanguageQualifier implements Qualifier {
    public static final int $stable = 0;
    private final String language;

    public static /* synthetic */ LanguageQualifier copy$default(LanguageQualifier languageQualifier, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = languageQualifier.language;
        }
        return languageQualifier.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    public final LanguageQualifier copy(String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        return new LanguageQualifier(language);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LanguageQualifier) && Intrinsics.areEqual(this.language, ((LanguageQualifier) other).language);
    }

    public int hashCode() {
        return this.language.hashCode();
    }

    public String toString() {
        return "LanguageQualifier(language=" + this.language + ")";
    }

    public LanguageQualifier(String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        this.language = language;
    }

    public final String getLanguage() {
        return this.language;
    }
}
