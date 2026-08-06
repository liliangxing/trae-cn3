package androidx.compose.p001ui.spatial;

import androidx.compose.p001ui.unit.IntOffset;
import kotlin.Metadata;

/* compiled from: RectManager.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0013\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\r\u0010\u0011\u001a\u00020\u0006*\u00020\u0001H\u0080\b\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001f\u0010\n\u001a\u00020\u0001*\u00020\u00068Â\u0002X\u0082\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\n\u0010\r\"\u001f\u0010\u000e\u001a\u00020\u0001*\u00020\u00068Â\u0002X\u0082\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\r¨\u0006\u0012"}, d2 = {"isSet", "", "Landroidx/compose/ui/unit/IntOffset;", "isSet--gyyYBs", "(J)Z", "analyzeComponents", "", "Landroidx/compose/ui/graphics/Matrix;", "analyzeComponents-58bKbWc", "([F)I", "isIdentity", "isIdentity$annotations", "(I)V", "(I)Z", "hasNonTranslationComponents", "getHasNonTranslationComponents$annotations", "getHasNonTranslationComponents", "toInt", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class RectManagerKt {
    private static final boolean getHasNonTranslationComponents(int i) {
        return (i & 2) == 0;
    }

    private static /* synthetic */ void getHasNonTranslationComponents$annotations(int i) {
    }

    private static final boolean isIdentity(int i) {
        return i == 3;
    }

    private static /* synthetic */ void isIdentity$annotations(int i) {
    }

    public static final int toInt(boolean z) {
        return z ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isSet--gyyYBs, reason: not valid java name */
    public static final boolean m1893isSetgyyYBs(long j) {
        return !IntOffset.m2807equalsimpl0(j, IntOffset.INSTANCE.m2818getMaxnOccac());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0085  */
    /* renamed from: analyzeComponents-58bKbWc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int m1892analyzeComponents58bKbWc(float[] fArr) {
        int i;
        int i2 = 0;
        if (fArr.length < 16) {
            return 0;
        }
        if (fArr[0] == 1.0f) {
            if (fArr[1] == 0.0f) {
                if (fArr[2] == 0.0f) {
                    if (fArr[4] == 0.0f) {
                        if (fArr[5] == 1.0f) {
                            if (fArr[6] == 0.0f) {
                                if (fArr[8] == 0.0f) {
                                    if (fArr[9] == 0.0f) {
                                        if (fArr[10] == 1.0f) {
                                            i = 1;
                                            if (fArr[12] != 0.0f) {
                                                if (fArr[13] == 0.0f) {
                                                    if (fArr[14] == 0.0f) {
                                                        if (fArr[15] == 1.0f) {
                                                            i2 = 1;
                                                        }
                                                    }
                                                }
                                            }
                                            return (i << 1) | i2;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        i = 0;
        if (fArr[12] != 0.0f) {
        }
        return (i << 1) | i2;
    }
}
