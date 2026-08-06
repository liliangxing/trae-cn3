package kotlinx.datetime;

import bytedance.jvm.time.Month;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.BuildConfig;

/* compiled from: Month.kt */
@Metadata(m4d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0006\u001a\u00060\u0003j\u0002`\u00022\u0006\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\u0010\u0007\"\u0019\u0010\u0000\u001a\u00020\u0001*\u00060\u0003j\u0002`\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, m5d2 = {"number", BuildConfig.FLAVOR, "Lkotlinx/datetime/Month;", "Lbytedance/jvm/time/Month;", "getNumber", "(Lbytedance/jvm/time/Month;)I", "Month", "(I)Lbytedance/jvm/time/Month;", "kotlinx-datetime_release"}, m6k = 2, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class MonthKt {

    /* compiled from: Month.kt */
    @Metadata(m6k = 3, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<Month> entries$0 = EnumEntriesKt.enumEntries(Month.values());
    }

    public static final int getNumber(Month month) {
        Intrinsics.checkNotNullParameter(month, "<this>");
        return month.ordinal() + 1;
    }

    public static final Month Month(int i) {
        boolean z = false;
        if (1 <= i && i < 13) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return (Month) EntriesMappings.entries$0.get(i - 1);
    }
}
