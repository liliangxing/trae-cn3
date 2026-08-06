package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Add missing generic type declarations: [T, E] */
/* compiled from: FormatStructure.kt */
@Metadata(m6k = 3, m7mv = {2, 0, 0}, m9xi = 48)
/* renamed from: kotlinx.datetime.internal.format.OptionalFormatStructure$PropertyWithDefault$isDefaultComparisonPredicate$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public /* synthetic */ class C0098x66a7504a<E, T> extends FunctionReferenceImpl implements Function1<T, E> {
    public C0098x66a7504a(Object obj) {
        super(1, obj, Accessor.class, "getter", "getter(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final E invoke(T t) {
        return (E) ((Accessor) this.receiver).getter(t);
    }
}
