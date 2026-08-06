package kotlinx.datetime;

import bytedance.jvm.time.DayOfWeek;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.BuildConfig;

/* compiled from: DayOfWeek.kt */
@Metadata(m4d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0006\u001a\u00060\u0003j\u0002`\u00022\u0006\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\u0010\u0007\"\u0019\u0010\u0000\u001a\u00020\u0001*\u00060\u0003j\u0002`\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, m5d2 = {"isoDayNumber", BuildConfig.FLAVOR, "Lkotlinx/datetime/DayOfWeek;", "Lbytedance/jvm/time/DayOfWeek;", "getIsoDayNumber", "(Lbytedance/jvm/time/DayOfWeek;)I", "DayOfWeek", "(I)Lbytedance/jvm/time/DayOfWeek;", "kotlinx-datetime_release"}, m6k = 2, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class DayOfWeekKt {

    /* compiled from: DayOfWeek.kt */
    @Metadata(m6k = 3, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<DayOfWeek> entries$0 = EnumEntriesKt.enumEntries(DayOfWeek.values());
    }

    public static final int getIsoDayNumber(DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "<this>");
        return dayOfWeek.ordinal() + 1;
    }

    public static final DayOfWeek DayOfWeek(int i) {
        boolean z = false;
        if (1 <= i && i < 8) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException(("Expected ISO day-of-week number in 1..7, got " + i).toString());
        }
        return (DayOfWeek) EntriesMappings.entries$0.get(i - 1);
    }
}
