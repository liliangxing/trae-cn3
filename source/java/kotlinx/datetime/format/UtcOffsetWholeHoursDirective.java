package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.UnsignedIntFieldFormatDirective;
import net.openid.appauth.BuildConfig;

/* compiled from: UtcOffsetFormat.kt */
@Metadata(m4d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, m5d2 = {"Lkotlinx/datetime/format/UtcOffsetWholeHoursDirective;", "Lkotlinx/datetime/internal/format/UnsignedIntFieldFormatDirective;", "Lkotlinx/datetime/format/UtcOffsetFieldContainer;", "padding", "Lkotlinx/datetime/format/Padding;", "<init>", "(Lkotlinx/datetime/format/Padding;)V", "builderRepresentation", BuildConfig.FLAVOR, "getBuilderRepresentation", "()Ljava/lang/String;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class UtcOffsetWholeHoursDirective extends UnsignedIntFieldFormatDirective<UtcOffsetFieldContainer> {
    private final Padding padding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UtcOffsetWholeHoursDirective(Padding padding) {
        super(OffsetFields.INSTANCE.getTotalHoursAbs(), padding == Padding.ZERO ? 2 : 1, padding == Padding.SPACE ? 2 : null);
        Intrinsics.checkNotNullParameter(padding, "padding");
        this.padding = padding;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public String getBuilderRepresentation() {
        return "offsetHours(" + DateTimeFormatKt.toKotlinCode(this.padding) + ')';
    }

    public boolean equals(Object other) {
        return (other instanceof UtcOffsetWholeHoursDirective) && this.padding == ((UtcOffsetWholeHoursDirective) other).padding;
    }

    public int hashCode() {
        return this.padding.hashCode();
    }
}
