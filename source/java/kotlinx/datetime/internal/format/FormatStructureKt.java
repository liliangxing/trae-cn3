package kotlinx.datetime.internal.format;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import net.openid.appauth.BuildConfig;

/* compiled from: FormatStructure.kt */
@Metadata(m4d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0002¨\u0006\u0006"}, m5d2 = {"basicFormats", BuildConfig.FLAVOR, "Lkotlinx/datetime/internal/format/FieldFormatDirective;", "T", "format", "Lkotlinx/datetime/internal/format/FormatStructure;", "kotlinx-datetime_release"}, m6k = 2, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class FormatStructureKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> List<FieldFormatDirective<T>> basicFormats(FormatStructure<? super T> formatStructure) {
        List createListBuilder = CollectionsKt.createListBuilder();
        basicFormats$lambda$2$rec(createListBuilder, formatStructure);
        return CollectionsKt.build(createListBuilder);
    }

    private static final <T> void basicFormats$lambda$2$rec(List<FieldFormatDirective<T>> list, FormatStructure<? super T> formatStructure) {
        if (formatStructure instanceof BasicFormatStructure) {
            list.add(((BasicFormatStructure) formatStructure).getDirective());
            return;
        }
        if (!(formatStructure instanceof ConcatenatedFormatStructure)) {
            if (formatStructure instanceof ConstantFormatStructure) {
                return;
            }
            if (formatStructure instanceof SignedFormatStructure) {
                basicFormats$lambda$2$rec(list, ((SignedFormatStructure) formatStructure).getFormat());
                return;
            }
            if (formatStructure instanceof AlternativesParsingFormatStructure) {
                AlternativesParsingFormatStructure alternativesParsingFormatStructure = (AlternativesParsingFormatStructure) formatStructure;
                basicFormats$lambda$2$rec(list, alternativesParsingFormatStructure.getMainFormat());
                Iterator<T> it = alternativesParsingFormatStructure.getFormats().iterator();
                while (it.hasNext()) {
                    basicFormats$lambda$2$rec(list, (FormatStructure) it.next());
                }
                return;
            }
            if (!(formatStructure instanceof OptionalFormatStructure)) {
                throw new NoWhenBranchMatchedException();
            }
            basicFormats$lambda$2$rec(list, ((OptionalFormatStructure) formatStructure).getFormat());
            return;
        }
        Iterator<T> it2 = ((ConcatenatedFormatStructure) formatStructure).getFormats().iterator();
        while (it2.hasNext()) {
            basicFormats$lambda$2$rec(list, (NonConcatenatedFormatStructure) it2.next());
        }
    }
}
