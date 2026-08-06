package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.datetime.internal.DecimalFraction;

/* JADX INFO: Add missing generic type declarations: [Target] */
/* compiled from: FieldFormatDirective.kt */
@Metadata(m6k = 3, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
/* synthetic */ class DecimalFractionFieldFormatDirective$formatter$1<Target> extends FunctionReferenceImpl implements Function1<Target, DecimalFraction> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DecimalFractionFieldFormatDirective$formatter$1(Object obj) {
        super(1, obj, Accessor.class, "getterNotNull", "getterNotNull(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ DecimalFraction invoke(Object obj) {
        return invoke2((DecimalFractionFieldFormatDirective$formatter$1<Target>) obj);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final DecimalFraction invoke2(Target target) {
        return (DecimalFraction) ((Accessor) this.receiver).getterNotNull(target);
    }
}
