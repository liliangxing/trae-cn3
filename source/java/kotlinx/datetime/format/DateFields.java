package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlinx.datetime.internal.format.GenericFieldSpec;
import kotlinx.datetime.internal.format.PropertyAccessor;
import kotlinx.datetime.internal.format.UnsignedFieldSpec;
import net.openid.appauth.BuildConfig;

/* compiled from: LocalDateFormat.kt */
@Metadata(m4d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006\u0012"}, m5d2 = {"Lkotlinx/datetime/format/DateFields;", BuildConfig.FLAVOR, "<init>", "()V", "year", "Lkotlinx/datetime/internal/format/GenericFieldSpec;", "Lkotlinx/datetime/format/DateFieldContainer;", BuildConfig.FLAVOR, "getYear", "()Lkotlinx/datetime/internal/format/GenericFieldSpec;", "month", "Lkotlinx/datetime/internal/format/UnsignedFieldSpec;", "getMonth", "()Lkotlinx/datetime/internal/format/UnsignedFieldSpec;", "dayOfMonth", "getDayOfMonth", "isoDayOfWeek", "getIsoDayOfWeek", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
final class DateFields {
    public static final DateFields INSTANCE = new DateFields();
    private static final GenericFieldSpec<DateFieldContainer, Integer> year = new GenericFieldSpec<>(new PropertyAccessor(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.DateFields$year$1
        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object obj) {
            return ((DateFieldContainer) obj).getYear();
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object obj, Object obj2) {
            ((DateFieldContainer) obj).setYear((Integer) obj2);
        }
    }), null, null, null, 14, null);
    private static final UnsignedFieldSpec<DateFieldContainer> month = new UnsignedFieldSpec<>(new PropertyAccessor(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.DateFields$month$1
        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object obj) {
            return ((DateFieldContainer) obj).getMonthNumber();
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object obj, Object obj2) {
            ((DateFieldContainer) obj).setMonthNumber((Integer) obj2);
        }
    }), 1, 12, null, null, null, 56, null);
    private static final UnsignedFieldSpec<DateFieldContainer> dayOfMonth = new UnsignedFieldSpec<>(new PropertyAccessor(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.DateFields$dayOfMonth$1
        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object obj) {
            return ((DateFieldContainer) obj).getDayOfMonth();
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object obj, Object obj2) {
            ((DateFieldContainer) obj).setDayOfMonth((Integer) obj2);
        }
    }), 1, 31, null, null, null, 56, null);
    private static final UnsignedFieldSpec<DateFieldContainer> isoDayOfWeek = new UnsignedFieldSpec<>(new PropertyAccessor(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.DateFields$isoDayOfWeek$1
        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object obj) {
            return ((DateFieldContainer) obj).getIsoDayOfWeek();
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object obj, Object obj2) {
            ((DateFieldContainer) obj).setIsoDayOfWeek((Integer) obj2);
        }
    }), 1, 7, null, null, null, 56, null);

    private DateFields() {
    }

    public final GenericFieldSpec<DateFieldContainer, Integer> getYear() {
        return year;
    }

    public final UnsignedFieldSpec<DateFieldContainer> getMonth() {
        return month;
    }

    public final UnsignedFieldSpec<DateFieldContainer> getDayOfMonth() {
        return dayOfMonth;
    }

    public final UnsignedFieldSpec<DateFieldContainer> getIsoDayOfWeek() {
        return isoDayOfWeek;
    }
}
