package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.NamedEnumIntFieldFormatDirective;
import net.openid.appauth.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalTimeFormat.kt */
@Metadata(m4d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, m5d2 = {"Lkotlinx/datetime/format/AmPmMarkerDirective;", "Lkotlinx/datetime/internal/format/NamedEnumIntFieldFormatDirective;", "Lkotlinx/datetime/format/TimeFieldContainer;", "Lkotlinx/datetime/format/AmPmMarker;", "amString", BuildConfig.FLAVOR, "pmString", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "builderRepresentation", "getBuilderRepresentation", "()Ljava/lang/String;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class AmPmMarkerDirective extends NamedEnumIntFieldFormatDirective<TimeFieldContainer, AmPmMarker> {
    private final String amString;
    private final String pmString;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmPmMarkerDirective(String amString, String pmString) {
        super(TimeFields.INSTANCE.getAmPm(), MapsKt.mapOf(TuplesKt.m12to(AmPmMarker.f122AM, amString), TuplesKt.m12to(AmPmMarker.f123PM, pmString)), "AM/PM marker");
        Intrinsics.checkNotNullParameter(amString, "amString");
        Intrinsics.checkNotNullParameter(pmString, "pmString");
        this.amString = amString;
        this.pmString = pmString;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public String getBuilderRepresentation() {
        return "amPmMarker(" + this.amString + ", " + this.pmString + ')';
    }

    public boolean equals(Object other) {
        if (other instanceof AmPmMarkerDirective) {
            AmPmMarkerDirective amPmMarkerDirective = (AmPmMarkerDirective) other;
            if (Intrinsics.areEqual(this.amString, amPmMarkerDirective.amString) && Intrinsics.areEqual(this.pmString, amPmMarkerDirective.pmString)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.amString.hashCode() * 31) + this.pmString.hashCode();
    }
}
