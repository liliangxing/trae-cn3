package kotlinx.datetime.format;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.internal.ToKotlinCodeKt;
import kotlinx.datetime.internal.format.AlternativesParsingFormatStructure;
import kotlinx.datetime.internal.format.BasicFormatStructure;
import kotlinx.datetime.internal.format.CachedFormatStructure;
import kotlinx.datetime.internal.format.ConcatenatedFormatStructure;
import kotlinx.datetime.internal.format.ConstantFormatStructure;
import kotlinx.datetime.internal.format.FormatStructure;
import kotlinx.datetime.internal.format.NonConcatenatedFormatStructure;
import kotlinx.datetime.internal.format.OptionalFormatStructure;
import kotlinx.datetime.internal.format.SignedFormatStructure;
import net.openid.appauth.BuildConfig;

/* compiled from: DateTimeFormatBuilder.kt */
@Metadata(m4d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0000\u001ac\u0010\b\u001a\u00020\u0001\"\b\b\u0000\u0010\t*\u00020\n*\u0002H\t2/\u0010\u000b\u001a\u001b\u0012\u0017\b\u0001\u0012\u0013\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000e0\f\"\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00010\r2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u0010\u001a<\u0010\u0011\u001a\u00020\u0001\"\b\b\u0000\u0010\t*\u00020\n*\u0002H\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u0015\u001a\u0012\u0010\u0016\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018\u001a6\u0010\u0019\u001a\u00020\u0013\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u001a2\u001c\u0010\u001b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0013\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001d0\u001c0\u0007H\u0000\"\u000e\u0010\u001e\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m5d2 = {"secondFractionInternal", BuildConfig.FLAVOR, "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithTime;", "minLength", BuildConfig.FLAVOR, "maxLength", "grouping", BuildConfig.FLAVOR, "alternativeParsing", "T", "Lkotlinx/datetime/format/DateTimeFormatBuilder;", "alternativeFormats", BuildConfig.FLAVOR, "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "primaryFormat", "(Lkotlinx/datetime/format/DateTimeFormatBuilder;[Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "optional", "ifZero", BuildConfig.FLAVOR, "format", "(Lkotlinx/datetime/format/DateTimeFormatBuilder;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "char", "value", BuildConfig.FLAVOR, "builderString", "Lkotlinx/datetime/internal/format/FormatStructure;", "constants", "Lkotlin/Pair;", "Lkotlinx/datetime/internal/format/CachedFormatStructure;", "CODE_INDENT", "kotlinx-datetime_release"}, m6k = 2, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class DateTimeFormatBuilderKt {
    private static final String CODE_INDENT = "    ";

    public static final void secondFractionInternal(DateTimeFormatBuilder.WithTime withTime, int i, int i2, List<Integer> grouping) {
        Intrinsics.checkNotNullParameter(withTime, "<this>");
        Intrinsics.checkNotNullParameter(grouping, "grouping");
        if (withTime instanceof AbstractWithTimeBuilder) {
            ((AbstractWithTimeBuilder) withTime).addFormatStructureForTime(new BasicFormatStructure(new FractionalSecondDirective(i, i2, grouping)));
        }
    }

    public static final <T extends DateTimeFormatBuilder> void alternativeParsing(T t, Function1<? super T, Unit>[] alternativeFormats, Function1<? super T, Unit> primaryFormat) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(alternativeFormats, "alternativeFormats");
        Intrinsics.checkNotNullParameter(primaryFormat, "primaryFormat");
        if (t instanceof AbstractDateTimeFormatBuilder) {
            ((AbstractDateTimeFormatBuilder) t).appendAlternativeParsingImpl((Function1[]) Arrays.copyOf(alternativeFormats, alternativeFormats.length), (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(primaryFormat, 1));
            return;
        }
        throw new IllegalStateException("impossible");
    }

    public static /* synthetic */ void optional$default(DateTimeFormatBuilder dateTimeFormatBuilder, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = BuildConfig.FLAVOR;
        }
        optional(dateTimeFormatBuilder, str, function1);
    }

    public static final <T extends DateTimeFormatBuilder> void optional(T t, String ifZero, Function1<? super T, Unit> format) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(ifZero, "ifZero");
        Intrinsics.checkNotNullParameter(format, "format");
        if (t instanceof AbstractDateTimeFormatBuilder) {
            ((AbstractDateTimeFormatBuilder) t).appendOptionalImpl(ifZero, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(format, 1));
            return;
        }
        throw new IllegalStateException("impossible");
    }

    /* renamed from: char */
    public static final void m1967char(DateTimeFormatBuilder dateTimeFormatBuilder, char c) {
        Intrinsics.checkNotNullParameter(dateTimeFormatBuilder, "<this>");
        dateTimeFormatBuilder.chars(String.valueOf(c));
    }

    public static final <T> String builderString(FormatStructure<? super T> formatStructure, List<? extends Pair<String, ? extends CachedFormatStructure<?>>> constants) {
        Intrinsics.checkNotNullParameter(formatStructure, "<this>");
        Intrinsics.checkNotNullParameter(constants, "constants");
        if (formatStructure instanceof BasicFormatStructure) {
            return ((BasicFormatStructure) formatStructure).getDirective().getBuilderRepresentation();
        }
        if (formatStructure instanceof ConstantFormatStructure) {
            ConstantFormatStructure constantFormatStructure = (ConstantFormatStructure) formatStructure;
            if (constantFormatStructure.getString().length() == 1) {
                return "char(" + ToKotlinCodeKt.toKotlinCode(constantFormatStructure.getString().charAt(0)) + ')';
            }
            return "chars(" + ToKotlinCodeKt.toKotlinCode(constantFormatStructure.getString()) + ')';
        }
        if (formatStructure instanceof SignedFormatStructure) {
            SignedFormatStructure signedFormatStructure = (SignedFormatStructure) formatStructure;
            if ((signedFormatStructure.getFormat() instanceof BasicFormatStructure) && (((BasicFormatStructure) signedFormatStructure.getFormat()).getDirective() instanceof UtcOffsetWholeHoursDirective)) {
                return ((UtcOffsetWholeHoursDirective) ((BasicFormatStructure) signedFormatStructure.getFormat()).getDirective()).getBuilderRepresentation();
            }
            StringBuilder sb = new StringBuilder();
            if (signedFormatStructure.getWithPlusSign()) {
                StringBuilder append = sb.append("withSharedSign(outputPlus = true) {");
                Intrinsics.checkNotNullExpressionValue(append, "append(...)");
                Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append(...)");
            } else {
                StringBuilder append2 = sb.append("withSharedSign {");
                Intrinsics.checkNotNullExpressionValue(append2, "append(...)");
                Intrinsics.checkNotNullExpressionValue(append2.append('\n'), "append(...)");
            }
            StringBuilder append3 = sb.append(StringsKt.prependIndent(builderString(signedFormatStructure.getFormat(), constants), CODE_INDENT));
            Intrinsics.checkNotNullExpressionValue(append3, "append(...)");
            Intrinsics.checkNotNullExpressionValue(append3.append('\n'), "append(...)");
            sb.append("}");
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }
        if (formatStructure instanceof OptionalFormatStructure) {
            StringBuilder sb3 = new StringBuilder();
            OptionalFormatStructure optionalFormatStructure = (OptionalFormatStructure) formatStructure;
            if (Intrinsics.areEqual(optionalFormatStructure.getOnZero(), BuildConfig.FLAVOR)) {
                StringBuilder append4 = sb3.append("optional {");
                Intrinsics.checkNotNullExpressionValue(append4, "append(...)");
                Intrinsics.checkNotNullExpressionValue(append4.append('\n'), "append(...)");
            } else {
                StringBuilder append5 = sb3.append("optional(" + ToKotlinCodeKt.toKotlinCode(optionalFormatStructure.getOnZero()) + ") {");
                Intrinsics.checkNotNullExpressionValue(append5, "append(...)");
                Intrinsics.checkNotNullExpressionValue(append5.append('\n'), "append(...)");
            }
            String builderString = builderString(optionalFormatStructure.getFormat(), constants);
            if ((builderString.length() > 0 ? 1 : 0) != 0) {
                StringBuilder append6 = sb3.append(StringsKt.prependIndent(builderString, CODE_INDENT));
                Intrinsics.checkNotNullExpressionValue(append6, "append(...)");
                Intrinsics.checkNotNullExpressionValue(append6.append('\n'), "append(...)");
            }
            sb3.append("}");
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "toString(...)");
            return sb4;
        }
        if (formatStructure instanceof AlternativesParsingFormatStructure) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("alternativeParsing(");
            AlternativesParsingFormatStructure alternativesParsingFormatStructure = (AlternativesParsingFormatStructure) formatStructure;
            for (FormatStructure<T> formatStructure2 : alternativesParsingFormatStructure.getFormats()) {
                StringBuilder append7 = sb5.append("{");
                Intrinsics.checkNotNullExpressionValue(append7, "append(...)");
                Intrinsics.checkNotNullExpressionValue(append7.append('\n'), "append(...)");
                String builderString2 = builderString(formatStructure2, constants);
                if (builderString2.length() > 0) {
                    StringBuilder append8 = sb5.append(StringsKt.prependIndent(builderString2, CODE_INDENT));
                    Intrinsics.checkNotNullExpressionValue(append8, "append(...)");
                    Intrinsics.checkNotNullExpressionValue(append8.append('\n'), "append(...)");
                }
                sb5.append("}, ");
            }
            if (sb5.charAt(sb5.length() - 2) == ',') {
                while (r1 < 2) {
                    Intrinsics.checkNotNullExpressionValue(sb5.deleteCharAt(sb5.length() - 1), "deleteCharAt(...)");
                    r1++;
                }
            }
            StringBuilder append9 = sb5.append(") {");
            Intrinsics.checkNotNullExpressionValue(append9, "append(...)");
            Intrinsics.checkNotNullExpressionValue(append9.append('\n'), "append(...)");
            StringBuilder append10 = sb5.append(StringsKt.prependIndent(builderString(alternativesParsingFormatStructure.getMainFormat(), constants), CODE_INDENT));
            Intrinsics.checkNotNullExpressionValue(append10, "append(...)");
            Intrinsics.checkNotNullExpressionValue(append10.append('\n'), "append(...)");
            sb5.append("}");
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "toString(...)");
            return sb6;
        }
        if (!(formatStructure instanceof ConcatenatedFormatStructure)) {
            throw new NoWhenBranchMatchedException();
        }
        StringBuilder sb7 = new StringBuilder();
        ConcatenatedFormatStructure concatenatedFormatStructure = (ConcatenatedFormatStructure) formatStructure;
        if (!concatenatedFormatStructure.getFormats().isEmpty()) {
            int i = 0;
            while (i < concatenatedFormatStructure.getFormats().size()) {
                Iterator<? extends Pair<String, ? extends CachedFormatStructure<?>>> it = constants.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Pair<String, ? extends CachedFormatStructure<?>> next = it.next();
                        List<NonConcatenatedFormatStructure<?>> formats = next.getSecond().getFormats();
                        if (concatenatedFormatStructure.getFormats().size() - i >= formats.size()) {
                            int size = formats.size();
                            for (int i2 = 0; i2 < size; i2++) {
                                if (!Intrinsics.areEqual(concatenatedFormatStructure.getFormats().get(i + i2), formats.get(i2))) {
                                    break;
                                }
                            }
                            sb7.append(next.getFirst());
                            i += formats.size();
                            if (i < concatenatedFormatStructure.getFormats().size()) {
                                Intrinsics.checkNotNullExpressionValue(sb7.append('\n'), "append(...)");
                            }
                        }
                    } else {
                        if (i == concatenatedFormatStructure.getFormats().size() - 1) {
                            sb7.append(builderString((FormatStructure) CollectionsKt.last((List) concatenatedFormatStructure.getFormats()), constants));
                        } else {
                            StringBuilder append11 = sb7.append(builderString(concatenatedFormatStructure.getFormats().get(i), constants));
                            Intrinsics.checkNotNullExpressionValue(append11, "append(...)");
                            Intrinsics.checkNotNullExpressionValue(append11.append('\n'), "append(...)");
                        }
                        i++;
                    }
                }
            }
        }
        String sb8 = sb7.toString();
        Intrinsics.checkNotNullExpressionValue(sb8, "toString(...)");
        return sb8;
    }
}
