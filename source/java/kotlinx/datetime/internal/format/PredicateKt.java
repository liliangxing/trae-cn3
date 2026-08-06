package kotlinx.datetime.internal.format;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.BuildConfig;

/* compiled from: Predicate.kt */
@Metadata(m4d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0004H\u0000¨\u0006\u0005"}, m5d2 = {"conjunctionPredicate", "Lkotlinx/datetime/internal/format/Predicate;", "T", "predicates", BuildConfig.FLAVOR, "kotlinx-datetime_release"}, m6k = 2, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class PredicateKt {
    public static final <T> Predicate<T> conjunctionPredicate(List<? extends Predicate<? super T>> predicates) {
        Intrinsics.checkNotNullParameter(predicates, "predicates");
        return predicates.isEmpty() ? Truth.INSTANCE : predicates.size() == 1 ? (Predicate) CollectionsKt.single((List) predicates) : new ConjunctionPredicate(predicates);
    }
}
