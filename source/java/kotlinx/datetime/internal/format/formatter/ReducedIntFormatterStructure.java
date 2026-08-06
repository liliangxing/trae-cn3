package kotlinx.datetime.internal.format.formatter;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.internal.MathKt;
import net.openid.appauth.BuildConfig;

/* compiled from: FormatterOperation.kt */
@Metadata(m4d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B+\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ)\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\n\u0010\r\u001a\u00060\u000fj\u0002`\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0012R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m5d2 = {"Lkotlinx/datetime/internal/format/formatter/ReducedIntFormatterStructure;", "T", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "number", "Lkotlin/Function1;", BuildConfig.FLAVOR, "digits", "base", "<init>", "(Lkotlin/jvm/functions/Function1;II)V", "format", BuildConfig.FLAVOR, "obj", "builder", "Lkotlin/text/Appendable;", "Ljava/lang/Appendable;", "minusNotRequired", BuildConfig.FLAVOR, "(Ljava/lang/Object;Ljava/lang/Appendable;Z)V", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ReducedIntFormatterStructure<T> implements FormatterStructure<T> {
    private final int base;
    private final int digits;
    private final Function1<T, Integer> number;

    /* JADX WARN: Multi-variable type inference failed */
    public ReducedIntFormatterStructure(Function1<? super T, Integer> number, int i, int i2) {
        Intrinsics.checkNotNullParameter(number, "number");
        this.number = number;
        this.digits = i;
        this.base = i2;
    }

    @Override // kotlinx.datetime.internal.format.formatter.FormatterStructure
    public void format(T obj, Appendable builder, boolean minusNotRequired) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        int intValue = this.number.invoke(obj).intValue();
        int i = MathKt.getPOWERS_OF_TEN()[this.digits];
        int i2 = intValue - this.base;
        if (i2 >= 0 && i2 < i) {
            String valueOf = String.valueOf(intValue % MathKt.getPOWERS_OF_TEN()[this.digits]);
            StringsKt.append(builder, StringsKt.repeat("0", Math.max(0, this.digits - valueOf.length())), valueOf);
        } else {
            if (intValue >= 0) {
                builder.append("+");
            }
            builder.append(String.valueOf(intValue));
        }
    }
}
