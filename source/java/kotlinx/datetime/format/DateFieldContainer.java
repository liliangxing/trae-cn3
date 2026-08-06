package kotlinx.datetime.format;

import kotlin.Metadata;

/* compiled from: LocalDateFormat.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b`\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkotlinx/datetime/format/DateFieldContainer;", "", "year", "", "getYear", "()Ljava/lang/Integer;", "setYear", "(Ljava/lang/Integer;)V", "monthNumber", "getMonthNumber", "setMonthNumber", "dayOfMonth", "getDayOfMonth", "setDayOfMonth", "isoDayOfWeek", "getIsoDayOfWeek", "setIsoDayOfWeek", "kotlinx-datetime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes8.dex */
public interface DateFieldContainer {
    Integer getDayOfMonth();

    Integer getIsoDayOfWeek();

    Integer getMonthNumber();

    Integer getYear();

    void setDayOfMonth(Integer num);

    void setIsoDayOfWeek(Integer num);

    void setMonthNumber(Integer num);

    void setYear(Integer num);
}
