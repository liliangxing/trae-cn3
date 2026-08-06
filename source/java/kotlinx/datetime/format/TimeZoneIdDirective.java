package kotlinx.datetime.format;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.StringFieldFormatDirective;
import net.openid.appauth.BuildConfig;

/* compiled from: DateTimeComponents.kt */
@Metadata(m4d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, m5d2 = {"Lkotlinx/datetime/format/TimeZoneIdDirective;", "Lkotlinx/datetime/internal/format/StringFieldFormatDirective;", "Lkotlinx/datetime/format/DateTimeComponentsContents;", "knownZones", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "(Ljava/util/Set;)V", "builderRepresentation", "getBuilderRepresentation", "()Ljava/lang/String;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class TimeZoneIdDirective extends StringFieldFormatDirective<DateTimeComponentsContents> {
    private final Set<String> knownZones;

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public String getBuilderRepresentation() {
        return "timeZoneId()";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeZoneIdDirective(Set<String> knownZones) {
        super(DateTimeComponentsKt.getTimeZoneField(), knownZones);
        Intrinsics.checkNotNullParameter(knownZones, "knownZones");
        this.knownZones = knownZones;
    }

    public boolean equals(Object other) {
        return (other instanceof TimeZoneIdDirective) && Intrinsics.areEqual(((TimeZoneIdDirective) other).knownZones, this.knownZones);
    }

    public int hashCode() {
        return this.knownZones.hashCode();
    }
}
