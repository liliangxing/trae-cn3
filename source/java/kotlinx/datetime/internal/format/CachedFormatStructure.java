package kotlinx.datetime.internal.format;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.parser.ParserStructure;
import net.openid.appauth.BuildConfig;

/* compiled from: FormatStructure.kt */
@Metadata(m4d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m5d2 = {"Lkotlinx/datetime/internal/format/CachedFormatStructure;", "T", "Lkotlinx/datetime/internal/format/ConcatenatedFormatStructure;", "formats", BuildConfig.FLAVOR, "Lkotlinx/datetime/internal/format/NonConcatenatedFormatStructure;", "<init>", "(Ljava/util/List;)V", "cachedFormatter", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "cachedParser", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "formatter", "parser", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class CachedFormatStructure<T> extends ConcatenatedFormatStructure<T> {
    private final FormatterStructure<T> cachedFormatter;
    private final ParserStructure<T> cachedParser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CachedFormatStructure(List<? extends NonConcatenatedFormatStructure<? super T>> formats) {
        super(formats);
        Intrinsics.checkNotNullParameter(formats, "formats");
        this.cachedFormatter = super.formatter();
        this.cachedParser = super.parser();
    }

    @Override // kotlinx.datetime.internal.format.ConcatenatedFormatStructure, kotlinx.datetime.internal.format.FormatStructure
    public FormatterStructure<T> formatter() {
        return this.cachedFormatter;
    }

    @Override // kotlinx.datetime.internal.format.ConcatenatedFormatStructure, kotlinx.datetime.internal.format.FormatStructure
    public ParserStructure<T> parser() {
        return this.cachedParser;
    }
}
