package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: FormatStructure.kt */
@Metadata(m6k = 3, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
/* synthetic */ class OptionalFormatStructure$formatter$1<T> extends FunctionReferenceImpl implements Function1<T, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public OptionalFormatStructure$formatter$1(Object obj) {
        super(1, obj, Predicate.class, "test", "test(Ljava/lang/Object;)Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(T t) {
        return Boolean.valueOf(((Predicate) this.receiver).test(t));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return invoke((OptionalFormatStructure$formatter$1<T>) obj);
    }
}
