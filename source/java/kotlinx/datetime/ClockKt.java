package kotlinx.datetime;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ComparableTimeMark;
import kotlin.time.TimeSource;

/* compiled from: Clock.kt */
@Metadata(m4d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0007\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\b"}, m5d2 = {"todayIn", "Lkotlinx/datetime/LocalDate;", "Lkotlinx/datetime/Clock;", "timeZone", "Lkotlinx/datetime/TimeZone;", "asTimeSource", "Lkotlin/time/TimeSource$WithComparableMarks;", "todayAt", "kotlinx-datetime_release"}, m6k = 2, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ClockKt {
    public static final LocalDate todayIn(Clock clock, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(clock, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return TimeZoneKt.toLocalDateTime(clock.now(), timeZone).getDate();
    }

    public static final TimeSource.WithComparableMarks asTimeSource(final Clock clock) {
        Intrinsics.checkNotNullParameter(clock, "<this>");
        return new TimeSource.WithComparableMarks() { // from class: kotlinx.datetime.ClockKt$asTimeSource$1
            @Override // kotlin.time.TimeSource
            public ComparableTimeMark markNow() {
                return new InstantTimeMark(Clock.this.now(), Clock.this);
            }
        };
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use Clock.todayIn instead", replaceWith = @ReplaceWith(expression = "this.todayIn(timeZone)", imports = {}))
    public static final LocalDate todayAt(Clock clock, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(clock, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return todayIn(clock, timeZone);
    }
}
