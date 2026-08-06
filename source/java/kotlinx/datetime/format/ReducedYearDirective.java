package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.datetime.internal.format.ReducedIntFieldDirective;
import net.openid.appauth.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalDateFormat.kt */
@Metadata(m4d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, m5d2 = {"Lkotlinx/datetime/format/ReducedYearDirective;", "Lkotlinx/datetime/internal/format/ReducedIntFieldDirective;", "Lkotlinx/datetime/format/DateFieldContainer;", "base", BuildConfig.FLAVOR, "isYearOfEra", BuildConfig.FLAVOR, "<init>", "(IZ)V", "getBase", "()I", "builderRepresentation", BuildConfig.FLAVOR, "getBuilderRepresentation", "()Ljava/lang/String;", "equals", "other", BuildConfig.FLAVOR, "hashCode", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ReducedYearDirective extends ReducedIntFieldDirective<DateFieldContainer> {
    private final int base;
    private final boolean isYearOfEra;

    public /* synthetic */ ReducedYearDirective(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? false : z);
    }

    public final int getBase() {
        return this.base;
    }

    public ReducedYearDirective(int i, boolean z) {
        super(DateFields.INSTANCE.getYear(), 2, i);
        this.base = i;
        this.isYearOfEra = z;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public String getBuilderRepresentation() {
        String str = "yearTwoDigits(" + this.base + ')';
        return this.isYearOfEra ? str + " /** TODO: the original format had an `y` directive, so the behavior is different on years earlier than 1 AD. See the [kotlinx.datetime.format.byUnicodePattern] documentation for details. */" : str;
    }

    public boolean equals(Object other) {
        if (other instanceof ReducedYearDirective) {
            ReducedYearDirective reducedYearDirective = (ReducedYearDirective) other;
            if (this.base == reducedYearDirective.base && this.isYearOfEra == reducedYearDirective.isYearOfEra) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.base) * 31) + Boolean.hashCode(this.isYearOfEra);
    }
}
