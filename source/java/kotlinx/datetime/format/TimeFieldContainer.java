package kotlinx.datetime.format;

import com.bytedance.sdk.account.induce.FrequencyController;
import kotlin.Metadata;
import kotlinx.datetime.internal.DecimalFraction;

/* compiled from: LocalTimeFormat.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lkotlinx/datetime/format/TimeFieldContainer;", "", FrequencyController.RangeType.MINUTE, "", "getMinute", "()Ljava/lang/Integer;", "setMinute", "(Ljava/lang/Integer;)V", "second", "getSecond", "setSecond", "nanosecond", "getNanosecond", "setNanosecond", FrequencyController.RangeType.HOUR, "getHour", "setHour", "hourOfAmPm", "getHourOfAmPm", "setHourOfAmPm", "amPm", "Lkotlinx/datetime/format/AmPmMarker;", "getAmPm", "()Lkotlinx/datetime/format/AmPmMarker;", "setAmPm", "(Lkotlinx/datetime/format/AmPmMarker;)V", "value", "Lkotlinx/datetime/internal/DecimalFraction;", "fractionOfSecond", "getFractionOfSecond", "()Lkotlinx/datetime/internal/DecimalFraction;", "setFractionOfSecond", "(Lkotlinx/datetime/internal/DecimalFraction;)V", "kotlinx-datetime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes8.dex */
public interface TimeFieldContainer {
    AmPmMarker getAmPm();

    DecimalFraction getFractionOfSecond();

    Integer getHour();

    Integer getHourOfAmPm();

    Integer getMinute();

    Integer getNanosecond();

    Integer getSecond();

    void setAmPm(AmPmMarker amPmMarker);

    void setFractionOfSecond(DecimalFraction decimalFraction);

    void setHour(Integer num);

    void setHourOfAmPm(Integer num);

    void setMinute(Integer num);

    void setNanosecond(Integer num);

    void setSecond(Integer num);

    /* compiled from: LocalTimeFormat.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class DefaultImpls {
        public static DecimalFraction getFractionOfSecond(TimeFieldContainer timeFieldContainer) {
            Integer nanosecond = timeFieldContainer.getNanosecond();
            if (nanosecond != null) {
                return new DecimalFraction(nanosecond.intValue(), 9);
            }
            return null;
        }

        public static void setFractionOfSecond(TimeFieldContainer timeFieldContainer, DecimalFraction decimalFraction) {
            timeFieldContainer.setNanosecond(decimalFraction != null ? Integer.valueOf(decimalFraction.fractionalPartWithNDigits(9)) : null);
        }
    }
}
