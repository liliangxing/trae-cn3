package androidx.compose.p002ui.graphics;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import android.os.Build;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: AndroidBlendMode.android.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\t\u001a\u00020\n*\u00020\u0002H\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\u0011\u0010\r\u001a\u00020\u0002*\u00020\nH\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/BlendMode;", "isSupported-s9anfk8", "(I)Z", "toPorterDuffMode", "Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode-s9anfk8", "(I)Landroid/graphics/PorterDuff$Mode;", "toAndroidBlendMode", "Landroid/graphics/BlendMode;", "toAndroidBlendMode-s9anfk8", "(I)Landroid/graphics/BlendMode;", "toComposeBlendMode", "(Landroid/graphics/BlendMode;)I", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class AndroidBlendMode_androidKt {

    /* compiled from: AndroidBlendMode.android.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BlendMode.values().length];
            try {
                iArr[BlendMode.CLEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BlendMode.SRC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BlendMode.DST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BlendMode.SRC_OVER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BlendMode.DST_OVER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[BlendMode.SRC_IN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[BlendMode.DST_IN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[BlendMode.SRC_OUT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[BlendMode.DST_OUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[BlendMode.SRC_ATOP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[BlendMode.DST_ATOP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[BlendMode.XOR.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[BlendMode.PLUS.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[BlendMode.MODULATE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[BlendMode.SCREEN.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[BlendMode.OVERLAY.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[BlendMode.DARKEN.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[BlendMode.LIGHTEN.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[BlendMode.COLOR_DODGE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[BlendMode.COLOR_BURN.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[BlendMode.HARD_LIGHT.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[BlendMode.SOFT_LIGHT.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[BlendMode.DIFFERENCE.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[BlendMode.EXCLUSION.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[BlendMode.MULTIPLY.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[BlendMode.HUE.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[BlendMode.SATURATION.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[BlendMode.COLOR.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[BlendMode.LUMINOSITY.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: isSupported-s9anfk8, reason: not valid java name */
    public static final boolean m4684isSupporteds9anfk8(int i) {
        return Build.VERSION.SDK_INT >= 29 || BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4778getSrcOver0nO6VwU()) || m4686toPorterDuffModes9anfk8(i) != PorterDuff.Mode.SRC_OVER;
    }

    /* renamed from: toPorterDuffMode-s9anfk8, reason: not valid java name */
    public static final PorterDuff.Mode m4686toPorterDuffModes9anfk8(int i) {
        if (BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4751getClear0nO6VwU())) {
            return PorterDuff.Mode.CLEAR;
        }
        if (BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4774getSrc0nO6VwU())) {
            return PorterDuff.Mode.SRC;
        }
        if (BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4757getDst0nO6VwU())) {
            return PorterDuff.Mode.DST;
        }
        if (BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4778getSrcOver0nO6VwU())) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4761getDstOver0nO6VwU())) {
            return PorterDuff.Mode.DST_OVER;
        }
        if (BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4776getSrcIn0nO6VwU())) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4759getDstIn0nO6VwU())) {
            return PorterDuff.Mode.DST_IN;
        }
        if (BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4777getSrcOut0nO6VwU())) {
            return PorterDuff.Mode.SRC_OUT;
        }
        if (BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4760getDstOut0nO6VwU())) {
            return PorterDuff.Mode.DST_OUT;
        }
        if (BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4775getSrcAtop0nO6VwU())) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        if (BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4758getDstAtop0nO6VwU())) {
            return PorterDuff.Mode.DST_ATOP;
        }
        if (BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4779getXor0nO6VwU())) {
            return PorterDuff.Mode.XOR;
        }
        if (BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4770getPlus0nO6VwU())) {
            return PorterDuff.Mode.ADD;
        }
        if (BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4772getScreen0nO6VwU())) {
            return PorterDuff.Mode.SCREEN;
        }
        if (BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4769getOverlay0nO6VwU())) {
            return PorterDuff.Mode.OVERLAY;
        }
        if (BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4755getDarken0nO6VwU())) {
            return PorterDuff.Mode.DARKEN;
        }
        if (BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4765getLighten0nO6VwU())) {
            return PorterDuff.Mode.LIGHTEN;
        }
        if (BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4767getModulate0nO6VwU())) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    /* renamed from: toAndroidBlendMode-s9anfk8, reason: not valid java name */
    public static final BlendMode m4685toAndroidBlendModes9anfk8(int i) {
        return BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4751getClear0nO6VwU()) ? BlendMode.CLEAR : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4774getSrc0nO6VwU()) ? BlendMode.SRC : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4757getDst0nO6VwU()) ? BlendMode.DST : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4778getSrcOver0nO6VwU()) ? BlendMode.SRC_OVER : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4761getDstOver0nO6VwU()) ? BlendMode.DST_OVER : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4776getSrcIn0nO6VwU()) ? BlendMode.SRC_IN : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4759getDstIn0nO6VwU()) ? BlendMode.DST_IN : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4777getSrcOut0nO6VwU()) ? BlendMode.SRC_OUT : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4760getDstOut0nO6VwU()) ? BlendMode.DST_OUT : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4775getSrcAtop0nO6VwU()) ? BlendMode.SRC_ATOP : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4758getDstAtop0nO6VwU()) ? BlendMode.DST_ATOP : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4779getXor0nO6VwU()) ? BlendMode.XOR : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4770getPlus0nO6VwU()) ? BlendMode.PLUS : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4767getModulate0nO6VwU()) ? BlendMode.MODULATE : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4772getScreen0nO6VwU()) ? BlendMode.SCREEN : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4769getOverlay0nO6VwU()) ? BlendMode.OVERLAY : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4755getDarken0nO6VwU()) ? BlendMode.DARKEN : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4765getLighten0nO6VwU()) ? BlendMode.LIGHTEN : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4754getColorDodge0nO6VwU()) ? BlendMode.COLOR_DODGE : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4753getColorBurn0nO6VwU()) ? BlendMode.COLOR_BURN : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4763getHardlight0nO6VwU()) ? BlendMode.HARD_LIGHT : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4773getSoftlight0nO6VwU()) ? BlendMode.SOFT_LIGHT : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4756getDifference0nO6VwU()) ? BlendMode.DIFFERENCE : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4762getExclusion0nO6VwU()) ? BlendMode.EXCLUSION : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4768getMultiply0nO6VwU()) ? BlendMode.MULTIPLY : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4764getHue0nO6VwU()) ? BlendMode.HUE : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4771getSaturation0nO6VwU()) ? BlendMode.SATURATION : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4752getColor0nO6VwU()) ? BlendMode.COLOR : BlendMode.m4747equalsimpl0(i, BlendMode.INSTANCE.m4766getLuminosity0nO6VwU()) ? BlendMode.LUMINOSITY : BlendMode.SRC_OVER;
    }

    public static final int toComposeBlendMode(BlendMode blendMode) {
        switch (WhenMappings.$EnumSwitchMapping$0[blendMode.ordinal()]) {
            case 1:
                return BlendMode.INSTANCE.m4751getClear0nO6VwU();
            case 2:
                return BlendMode.INSTANCE.m4774getSrc0nO6VwU();
            case 3:
                return BlendMode.INSTANCE.m4757getDst0nO6VwU();
            case 4:
                return BlendMode.INSTANCE.m4778getSrcOver0nO6VwU();
            case 5:
                return BlendMode.INSTANCE.m4761getDstOver0nO6VwU();
            case 6:
                return BlendMode.INSTANCE.m4776getSrcIn0nO6VwU();
            case 7:
                return BlendMode.INSTANCE.m4759getDstIn0nO6VwU();
            case 8:
                return BlendMode.INSTANCE.m4777getSrcOut0nO6VwU();
            case 9:
                return BlendMode.INSTANCE.m4760getDstOut0nO6VwU();
            case 10:
                return BlendMode.INSTANCE.m4775getSrcAtop0nO6VwU();
            case 11:
                return BlendMode.INSTANCE.m4758getDstAtop0nO6VwU();
            case 12:
                return BlendMode.INSTANCE.m4779getXor0nO6VwU();
            case 13:
                return BlendMode.INSTANCE.m4770getPlus0nO6VwU();
            case 14:
                return BlendMode.INSTANCE.m4767getModulate0nO6VwU();
            case 15:
                return BlendMode.INSTANCE.m4772getScreen0nO6VwU();
            case 16:
                return BlendMode.INSTANCE.m4769getOverlay0nO6VwU();
            case 17:
                return BlendMode.INSTANCE.m4755getDarken0nO6VwU();
            case 18:
                return BlendMode.INSTANCE.m4765getLighten0nO6VwU();
            case 19:
                return BlendMode.INSTANCE.m4754getColorDodge0nO6VwU();
            case 20:
                return BlendMode.INSTANCE.m4753getColorBurn0nO6VwU();
            case 21:
                return BlendMode.INSTANCE.m4763getHardlight0nO6VwU();
            case 22:
                return BlendMode.INSTANCE.m4773getSoftlight0nO6VwU();
            case 23:
                return BlendMode.INSTANCE.m4756getDifference0nO6VwU();
            case 24:
                return BlendMode.INSTANCE.m4762getExclusion0nO6VwU();
            case 25:
                return BlendMode.INSTANCE.m4768getMultiply0nO6VwU();
            case 26:
                return BlendMode.INSTANCE.m4764getHue0nO6VwU();
            case 27:
                return BlendMode.INSTANCE.m4771getSaturation0nO6VwU();
            case 28:
                return BlendMode.INSTANCE.m4752getColor0nO6VwU();
            case 29:
                return BlendMode.INSTANCE.m4766getLuminosity0nO6VwU();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
