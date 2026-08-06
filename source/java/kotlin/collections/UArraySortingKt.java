package kotlin.collections;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.BuildConfig;

/* compiled from: UArraySorting.kt */
@Metadata(m4d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0012\u0010\u0013\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0014\u0010\u0015\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001e\u0010\u000b\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001f\u0010\u0010\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b \u0010\u0015\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b!\u0010\u001a¨\u0006\""}, m5d2 = {"partition", BuildConfig.FLAVOR, "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "quickSort", BuildConfig.FLAVOR, "quickSort-4UcCI2c", "([BII)V", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort-Aa5vz7o", "([SII)V", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "quickSort-oBK06Vg", "([III)V", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "quickSort--nroSd4", "([JII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-Aa5vz7o", "sortArray-oBK06Vg", "sortArray--nroSd4", "kotlin-stdlib"}, m6k = 2, m7mv = {2, 1, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class UArraySortingKt {
    /* renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m837partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte m455getw2LRezQ = UByteArray.m455getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int m455getw2LRezQ2 = UByteArray.m455getw2LRezQ(bArr, i) & UByte.MAX_VALUE;
                i3 = m455getw2LRezQ & UByte.MAX_VALUE;
                if (Intrinsics.compare(m455getw2LRezQ2, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m455getw2LRezQ(bArr, i2) & UByte.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte m455getw2LRezQ3 = UByteArray.m455getw2LRezQ(bArr, i);
                UByteArray.m460setVurrAj0(bArr, i, UByteArray.m455getw2LRezQ(bArr, i2));
                UByteArray.m460setVurrAj0(bArr, i2, m455getw2LRezQ3);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m841quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int m837partition4UcCI2c = m837partition4UcCI2c(bArr, i, i2);
        int i3 = m837partition4UcCI2c - 1;
        if (i < i3) {
            m841quickSort4UcCI2c(bArr, i, i3);
        }
        if (m837partition4UcCI2c < i2) {
            m841quickSort4UcCI2c(bArr, m837partition4UcCI2c, i2);
        }
    }

    /* renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m838partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short m718getMh2AYeg = UShortArray.m718getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int m718getMh2AYeg2 = UShortArray.m718getMh2AYeg(sArr, i) & UShort.MAX_VALUE;
                i3 = m718getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(m718getMh2AYeg2, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m718getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short m718getMh2AYeg3 = UShortArray.m718getMh2AYeg(sArr, i);
                UShortArray.m723set01HTLdE(sArr, i, UShortArray.m718getMh2AYeg(sArr, i2));
                UShortArray.m723set01HTLdE(sArr, i2, m718getMh2AYeg3);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m842quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int m838partitionAa5vz7o = m838partitionAa5vz7o(sArr, i, i2);
        int i3 = m838partitionAa5vz7o - 1;
        if (i < i3) {
            m842quickSortAa5vz7o(sArr, i, i3);
        }
        if (m838partitionAa5vz7o < i2) {
            m842quickSortAa5vz7o(sArr, m838partitionAa5vz7o, i2);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0012 */
    /* JADX WARN: Incorrect condition in loop: B:8:0x001f */
    /* renamed from: partition-oBK06Vg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final int m839partitionoBK06Vg(int[] iArr, int i, int i2) {
        int compare;
        int compare2;
        int m534getpVg5ArA = UIntArray.m534getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (compare < 0) {
                i++;
            }
            while (compare2 > 0) {
                i2--;
            }
            if (i <= i2) {
                int m534getpVg5ArA2 = UIntArray.m534getpVg5ArA(iArr, i);
                UIntArray.m539setVXSXFK8(iArr, i, UIntArray.m534getpVg5ArA(iArr, i2));
                UIntArray.m539setVXSXFK8(iArr, i2, m534getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m843quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int m839partitionoBK06Vg = m839partitionoBK06Vg(iArr, i, i2);
        int i3 = m839partitionoBK06Vg - 1;
        if (i < i3) {
            m843quickSortoBK06Vg(iArr, i, i3);
        }
        if (m839partitionoBK06Vg < i2) {
            m843quickSortoBK06Vg(iArr, m839partitionoBK06Vg, i2);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0012 */
    /* JADX WARN: Incorrect condition in loop: B:8:0x001f */
    /* renamed from: partition--nroSd4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final int m836partitionnroSd4(long[] jArr, int i, int i2) {
        int compare;
        int compare2;
        long m613getsVKNKU = ULongArray.m613getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (compare < 0) {
                i++;
            }
            while (compare2 > 0) {
                i2--;
            }
            if (i <= i2) {
                long m613getsVKNKU2 = ULongArray.m613getsVKNKU(jArr, i);
                ULongArray.m618setk8EXiF4(jArr, i, ULongArray.m613getsVKNKU(jArr, i2));
                ULongArray.m618setk8EXiF4(jArr, i2, m613getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m840quickSortnroSd4(long[] jArr, int i, int i2) {
        int m836partitionnroSd4 = m836partitionnroSd4(jArr, i, i2);
        int i3 = m836partitionnroSd4 - 1;
        if (i < i3) {
            m840quickSortnroSd4(jArr, i, i3);
        }
        if (m836partitionnroSd4 < i2) {
            m840quickSortnroSd4(jArr, m836partitionnroSd4, i2);
        }
    }

    /* renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m845sortArray4UcCI2c(byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m841quickSort4UcCI2c(array, i, i2 - 1);
    }

    /* renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m846sortArrayAa5vz7o(short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m842quickSortAa5vz7o(array, i, i2 - 1);
    }

    /* renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m847sortArrayoBK06Vg(int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m843quickSortoBK06Vg(array, i, i2 - 1);
    }

    /* renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m844sortArraynroSd4(long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m840quickSortnroSd4(array, i, i2 - 1);
    }
}
