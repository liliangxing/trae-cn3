package com.bytedance.rts.foundation;

import com.bytedance.push.frontier.interfaze.IFrontierMonitor;
import kotlin.Metadata;
import kotlin.UnsignedKt;
import kotlin.comparisons.UComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.random.Random;

/* compiled from: RTSMath.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/rts/foundation/Math;", "", "()V", "Companion", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class Math {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: E */
    public static final double f114E = 2.718281828459045d;
    private static final double LN10;
    private static final double LN2;
    private static final double LOG10E;
    private static final double LOG2E;

    /* renamed from: PI */
    public static final double f115PI = 3.141592653589793d;
    private static final double SQRT1_2;
    private static final double SQRT2;

    /* compiled from: RTSMath.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J\u0016\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J\u0016\u0010 \u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004J\u0016\u0010 \u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015J#\u0010 \u001a\u00020!2\u0006\u0010\u0014\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020!ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#J\u0016\u0010$\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004J\u0016\u0010$\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015J#\u0010$\u001a\u00020!2\u0006\u0010\u0014\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020!ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010#J\u0016\u0010&\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004J\u0016\u0010&\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0015J\u0016\u0010&\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0004J\u0016\u0010&\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015J\u0016\u0010&\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020'2\u0006\u0010\u001a\u001a\u00020\u0004J\u0016\u0010&\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020'2\u0006\u0010\u001a\u001a\u00020\u0015J#\u0010&\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J#\u0010&\u001a\u00020!2\u0006\u0010\u0014\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u0015ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010#J\u0006\u0010+\u001a\u00020\u0004J\u000e\u0010,\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010.\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010/\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00060"}, d2 = {"Lcom/bytedance/rts/foundation/Math$Companion;", "", "()V", "E", "", "LN10", "getLN10", "()D", "LN2", "getLN2", "LOG10E", "getLOG10E", "LOG2E", "getLOG2E", "PI", "SQRT1_2", "getSQRT1_2", "SQRT2", "getSQRT2", "abs", "x", "", "acos", "asin", "atan", "atan2", "y", "ceil", "cos", "exp", "floor", IFrontierMonitor.KEY_LOG, "max", "Lkotlin/UInt;", "max-YcLip9I", "(II)I", "min", "min-YcLip9I", "pow", "", "pow-qim9Vi0", "(ID)D", "pow-mPSJhXU", "random", "round", "sin", "sqrt", "tan", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final double getLN10() {
            return Math.LN10;
        }

        public final double getLN2() {
            return Math.LN2;
        }

        public final double getLOG2E() {
            return Math.LOG2E;
        }

        public final double getLOG10E() {
            return Math.LOG10E;
        }

        public final double getSQRT1_2() {
            return Math.SQRT1_2;
        }

        public final double getSQRT2() {
            return Math.SQRT2;
        }

        public final int abs(int x) {
            return java.lang.Math.abs(x);
        }

        public final double abs(double x) {
            return java.lang.Math.abs(x);
        }

        public final int pow(int x, int y) {
            return (int) java.lang.Math.pow(x, y);
        }

        public final double pow(double x, double y) {
            return java.lang.Math.pow(x, y);
        }

        public final double pow(int x, double y) {
            return java.lang.Math.pow(x, y);
        }

        public final double pow(double x, int y) {
            return java.lang.Math.pow(x, y);
        }

        /* renamed from: pow-mPSJhXU, reason: not valid java name */
        public final int m819powmPSJhXU(int x, int y) {
            return UnsignedKt.doubleToUInt(java.lang.Math.pow(UnsignedKt.uintToDouble(x), y));
        }

        /* renamed from: pow-qim9Vi0, reason: not valid java name */
        public final double m820powqim9Vi0(int x, double y) {
            return java.lang.Math.pow(UnsignedKt.uintToDouble(x), y);
        }

        public final long pow(long x, int y) {
            return (long) java.lang.Math.pow(x, y);
        }

        public final double pow(long x, double y) {
            return java.lang.Math.pow(x, y);
        }

        public final double random() {
            return Random.Default.nextDouble();
        }

        public final double floor(double x) {
            return java.lang.Math.floor(x);
        }

        public final double round(double x) {
            return java.lang.Math.rint(x);
        }

        public final double ceil(double x) {
            return java.lang.Math.ceil(x);
        }

        public final double max(double x, double y) {
            return java.lang.Math.max(x, y);
        }

        public final int max(int x, int y) {
            return java.lang.Math.max(x, y);
        }

        /* renamed from: max-YcLip9I, reason: not valid java name */
        public final int m817maxYcLip9I(int x, int y) {
            return UComparisonsKt.maxOf-J1ME1BU(x, y);
        }

        public final double min(double x, double y) {
            return java.lang.Math.min(x, y);
        }

        public final int min(int x, int y) {
            return java.lang.Math.min(x, y);
        }

        /* renamed from: min-YcLip9I, reason: not valid java name */
        public final int m818minYcLip9I(int x, int y) {
            return UComparisonsKt.minOf-J1ME1BU(x, y);
        }

        public final double sin(double x) {
            return java.lang.Math.sin(x);
        }

        public final double cos(double x) {
            return java.lang.Math.cos(x);
        }

        public final double tan(double x) {
            return java.lang.Math.tan(x);
        }

        public final double asin(double x) {
            return java.lang.Math.asin(x);
        }

        public final double acos(double x) {
            return java.lang.Math.acos(x);
        }

        public final double atan(double x) {
            return java.lang.Math.atan(x);
        }

        public final double atan2(double y, double x) {
            return java.lang.Math.atan2(y, x);
        }

        public final double exp(double x) {
            return java.lang.Math.exp(x);
        }

        public final double log(double x) {
            return java.lang.Math.log(x);
        }

        public final double sqrt(double x) {
            return java.lang.Math.sqrt(x);
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        LN10 = java.lang.Math.log(10.0d);
        LN2 = java.lang.Math.log(2.0d);
        LOG2E = 1.0d / java.lang.Math.log(2.0d);
        LOG10E = 1.0d / java.lang.Math.log(10.0d);
        SQRT1_2 = companion.sqrt(0.5d);
        SQRT2 = companion.sqrt(2.0d);
    }
}
