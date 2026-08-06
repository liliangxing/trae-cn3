package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.UtcOffset;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.internal.format.BasicFormatStructure;
import kotlinx.datetime.internal.format.FormatStructure;
import kotlinx.datetime.internal.format.SignedFormatStructure;
import net.openid.appauth.BuildConfig;

/* compiled from: UtcOffsetFormat.kt */
@Metadata(m4d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\f\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¨\u0006\u0010"}, m5d2 = {"Lkotlinx/datetime/format/AbstractWithOffsetBuilder;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithUtcOffset;", "addFormatStructureForOffset", BuildConfig.FLAVOR, "structure", "Lkotlinx/datetime/internal/format/FormatStructure;", "Lkotlinx/datetime/format/UtcOffsetFieldContainer;", "offsetHours", "padding", "Lkotlinx/datetime/format/Padding;", "offsetMinutesOfHour", "offsetSecondsOfMinute", "offset", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/UtcOffset;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public interface AbstractWithOffsetBuilder extends DateTimeFormatBuilder.WithUtcOffset {
    void addFormatStructureForOffset(FormatStructure<? super UtcOffsetFieldContainer> structure);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
    void offset(DateTimeFormat<UtcOffset> format);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
    void offsetHours(Padding padding);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
    void offsetMinutesOfHour(Padding padding);

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
    void offsetSecondsOfMinute(Padding padding);

    /* compiled from: UtcOffsetFormat.kt */
    @Metadata(m6k = 3, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class DefaultImpls {
        public static void offsetHours(AbstractWithOffsetBuilder abstractWithOffsetBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            abstractWithOffsetBuilder.addFormatStructureForOffset(new SignedFormatStructure(new BasicFormatStructure(new UtcOffsetWholeHoursDirective(padding)), true));
        }

        public static void offsetMinutesOfHour(AbstractWithOffsetBuilder abstractWithOffsetBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            abstractWithOffsetBuilder.addFormatStructureForOffset(new BasicFormatStructure(new UtcOffsetMinuteOfHourDirective(padding)));
        }

        public static void offsetSecondsOfMinute(AbstractWithOffsetBuilder abstractWithOffsetBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            abstractWithOffsetBuilder.addFormatStructureForOffset(new BasicFormatStructure(new UtcOffsetSecondOfMinuteDirective(padding)));
        }

        public static void offset(AbstractWithOffsetBuilder abstractWithOffsetBuilder, DateTimeFormat<UtcOffset> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            if (format instanceof UtcOffsetFormat) {
                abstractWithOffsetBuilder.addFormatStructureForOffset(((UtcOffsetFormat) format).getActualFormat());
            }
        }
    }
}
