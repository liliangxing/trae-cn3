package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlinx.datetime.format.UnicodeFormat;
import net.openid.appauth.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Unicode.kt */
@Metadata(m4d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m5d2 = {"Lkotlinx/datetime/format/UnknownUnicodeDirective;", "Lkotlinx/datetime/format/UnicodeFormat$Directive;", "formatLetter", BuildConfig.FLAVOR, "formatLength", BuildConfig.FLAVOR, "<init>", "(CI)V", "getFormatLetter", "()C", "getFormatLength", "()I", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class UnknownUnicodeDirective extends UnicodeFormat.Directive {
    private final int formatLength;
    private final char formatLetter;

    public UnknownUnicodeDirective(char c, int i) {
        super(null);
        this.formatLetter = c;
        this.formatLength = i;
    }

    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
    public int getFormatLength() {
        return this.formatLength;
    }

    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
    public char getFormatLetter() {
        return this.formatLetter;
    }
}
