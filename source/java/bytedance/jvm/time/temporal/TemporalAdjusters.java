package bytedance.jvm.time.temporal;

import bytedance.jvm.time.DayOfWeek;
import bytedance.jvm.time.LocalDate;
import java.util.Objects;
import java.util.function.UnaryOperator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class TemporalAdjusters {
    private TemporalAdjusters() {
    }

    public static TemporalAdjuster ofDateAdjuster(final UnaryOperator<LocalDate> unaryOperator) {
        Objects.requireNonNull(unaryOperator, "dateBasedAdjuster");
        return new TemporalAdjuster() { // from class: bytedance.jvm.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda6
            @Override // bytedance.jvm.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                Temporal with;
                with = temporal.with((LocalDate) unaryOperator.apply(LocalDate.from((TemporalAccessor) temporal)));
                return with;
            }
        };
    }

    public static TemporalAdjuster firstDayOfMonth() {
        return new TemporalAdjuster() { // from class: bytedance.jvm.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda1
            @Override // bytedance.jvm.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                Temporal with;
                with = temporal.with(ChronoField.DAY_OF_MONTH, 1L);
                return with;
            }
        };
    }

    public static TemporalAdjuster lastDayOfMonth() {
        return new TemporalAdjuster() { // from class: bytedance.jvm.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda11
            @Override // bytedance.jvm.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                Temporal with;
                with = temporal.with(ChronoField.DAY_OF_MONTH, temporal.range(ChronoField.DAY_OF_MONTH).getMaximum());
                return with;
            }
        };
    }

    public static TemporalAdjuster firstDayOfNextMonth() {
        return new TemporalAdjuster() { // from class: bytedance.jvm.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda12
            @Override // bytedance.jvm.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                Temporal plus;
                plus = temporal.with(ChronoField.DAY_OF_MONTH, 1L).plus(1L, ChronoUnit.MONTHS);
                return plus;
            }
        };
    }

    public static TemporalAdjuster firstDayOfYear() {
        return new TemporalAdjuster() { // from class: bytedance.jvm.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda5
            @Override // bytedance.jvm.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                Temporal with;
                with = temporal.with(ChronoField.DAY_OF_YEAR, 1L);
                return with;
            }
        };
    }

    public static TemporalAdjuster lastDayOfYear() {
        return new TemporalAdjuster() { // from class: bytedance.jvm.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda4
            @Override // bytedance.jvm.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                Temporal with;
                with = temporal.with(ChronoField.DAY_OF_YEAR, temporal.range(ChronoField.DAY_OF_YEAR).getMaximum());
                return with;
            }
        };
    }

    public static TemporalAdjuster firstDayOfNextYear() {
        return new TemporalAdjuster() { // from class: bytedance.jvm.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda9
            @Override // bytedance.jvm.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                Temporal plus;
                plus = temporal.with(ChronoField.DAY_OF_YEAR, 1L).plus(1L, ChronoUnit.YEARS);
                return plus;
            }
        };
    }

    public static TemporalAdjuster firstInMonth(DayOfWeek dayOfWeek) {
        return dayOfWeekInMonth(1, dayOfWeek);
    }

    public static TemporalAdjuster lastInMonth(DayOfWeek dayOfWeek) {
        return dayOfWeekInMonth(-1, dayOfWeek);
    }

    public static TemporalAdjuster dayOfWeekInMonth(final int i, DayOfWeek dayOfWeek) {
        Objects.requireNonNull(dayOfWeek, "dayOfWeek");
        final int value = dayOfWeek.getValue();
        if (i >= 0) {
            return new TemporalAdjuster() { // from class: bytedance.jvm.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda2
                @Override // bytedance.jvm.time.temporal.TemporalAdjuster
                public final Temporal adjustInto(Temporal temporal) {
                    Temporal plus;
                    int i2 = value;
                    int i3 = i;
                    plus = temporal.with(ChronoField.DAY_OF_MONTH, 1L).plus((int) ((((i2 - temporal.get(ChronoField.DAY_OF_WEEK)) + 7) % 7) + ((i3 - 1) * 7)), ChronoUnit.DAYS);
                    return plus;
                }
            };
        }
        return new TemporalAdjuster() { // from class: bytedance.jvm.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda3
            @Override // bytedance.jvm.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                return TemporalAdjusters.lambda$dayOfWeekInMonth$8(value, i, temporal);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Temporal lambda$dayOfWeekInMonth$8(int i, int i2, Temporal temporal) {
        Temporal with = temporal.with(ChronoField.DAY_OF_MONTH, temporal.range(ChronoField.DAY_OF_MONTH).getMaximum());
        int i3 = i - with.get(ChronoField.DAY_OF_WEEK);
        if (i3 == 0) {
            i3 = 0;
        } else if (i3 > 0) {
            i3 -= 7;
        }
        return with.plus((int) (i3 - (((-i2) - 1) * 7)), ChronoUnit.DAYS);
    }

    public static TemporalAdjuster next(DayOfWeek dayOfWeek) {
        final int value = dayOfWeek.getValue();
        return new TemporalAdjuster() { // from class: bytedance.jvm.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda10
            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: bytedance.jvm.time.temporal.TemporalAdjusters.lambda$next$9(int, bytedance.jvm.time.temporal.Temporal):bytedance.jvm.time.temporal.Temporal
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
                Caused by: java.lang.NullPointerException
                	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:489)
                	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:492)
                	at jadx.core.dex.instructions.mods.TernaryInsn.rebindArgs(TernaryInsn.java:88)
                	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:492)
                	at jadx.core.utils.BlockUtils.replaceInsn(BlockUtils.java:1109)
                	at jadx.core.utils.BlockUtils.replaceInsn(BlockUtils.java:1118)
                	at jadx.core.dex.visitors.InlineMethods.inlineMethod(InlineMethods.java:113)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:72)
                	... 1 more
                */
            @Override // bytedance.jvm.time.temporal.TemporalAdjuster
            public final bytedance.jvm.time.temporal.Temporal adjustInto(bytedance.jvm.time.temporal.Temporal r2) {
                /*
                    r1 = this;
                    int r0 = r1
                    bytedance.jvm.time.temporal.Temporal r2 = bytedance.jvm.time.temporal.TemporalAdjusters.lambda$next$9(r0, r2)
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: bytedance.jvm.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda10.adjustInto(bytedance.jvm.time.temporal.Temporal):bytedance.jvm.time.temporal.Temporal");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Temporal lambda$next$9(int i, Temporal temporal) {
        return temporal.plus(temporal.get(ChronoField.DAY_OF_WEEK) - i >= 0 ? 7 - r0 : -r0, ChronoUnit.DAYS);
    }

    public static TemporalAdjuster nextOrSame(DayOfWeek dayOfWeek) {
        final int value = dayOfWeek.getValue();
        return new TemporalAdjuster() { // from class: bytedance.jvm.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda7
            @Override // bytedance.jvm.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                return TemporalAdjusters.lambda$nextOrSame$10(value, temporal);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Temporal lambda$nextOrSame$10(int i, Temporal temporal) {
        int i2 = temporal.get(ChronoField.DAY_OF_WEEK);
        if (i2 == i) {
            return temporal;
        }
        return temporal.plus(i2 - i >= 0 ? 7 - r0 : -r0, ChronoUnit.DAYS);
    }

    public static TemporalAdjuster previous(DayOfWeek dayOfWeek) {
        final int value = dayOfWeek.getValue();
        return new TemporalAdjuster() { // from class: bytedance.jvm.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda8
            @Override // bytedance.jvm.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                Temporal minus;
                int i = value;
                minus = temporal.minus(r2 - r3.get(ChronoField.DAY_OF_WEEK) >= 0 ? 7 - i : -i, ChronoUnit.DAYS);
                return minus;
            }
        };
    }

    public static TemporalAdjuster previousOrSame(DayOfWeek dayOfWeek) {
        final int value = dayOfWeek.getValue();
        return new TemporalAdjuster() { // from class: bytedance.jvm.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda0
            @Override // bytedance.jvm.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                return TemporalAdjusters.lambda$previousOrSame$12(value, temporal);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Temporal lambda$previousOrSame$12(int i, Temporal temporal) {
        int i2 = temporal.get(ChronoField.DAY_OF_WEEK);
        if (i2 == i) {
            return temporal;
        }
        return temporal.minus(i - i2 >= 0 ? 7 - r2 : -r2, ChronoUnit.DAYS);
    }
}
