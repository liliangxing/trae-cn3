package com.bytedance.android.monitorV2.lynx.impl.blank;

import android.util.Base64;
import com.bytedance.android.monitorV2.constant.MonitorConstant;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.forest.model.PreloadConfig;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BlankViewRegionChecker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001$B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J0\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003H\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J>\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0010J \u0010 \u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J \u0010!\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\"2\u0006\u0010#\u001a\u00020\tH\u0002R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003`\nX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\r0\fj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/impl/blank/BlankViewRegionChecker;", "", "width", "", "height", "sampleWidth", "(III)V", "allElements", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "bitmap", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "validChildNode", "", "validElements", "addRegion", "", "left", "top", "right", "bottom", "mark", "check", "Lcom/bytedance/android/monitorV2/lynx/impl/blank/BlankViewRegionChecker$CheckResult;", "compressWithGZip", "byteArray", "", "element", "childNode", "markElement", "increment", "", "key", "CheckResult", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class BlankViewRegionChecker {
    private final HashMap<String, Integer> allElements;
    private final ArrayList<Integer[]> bitmap;
    private final int height;
    private final int sampleWidth;
    private boolean validChildNode;
    private final HashMap<String, Integer> validElements;
    private final int width;

    public BlankViewRegionChecker(int i, int i2, int i3) {
        this.width = i;
        this.height = i2;
        this.sampleWidth = i3;
        this.bitmap = new ArrayList<>();
        this.allElements = new HashMap<>();
        this.validElements = new HashMap<>();
    }

    public /* synthetic */ BlankViewRegionChecker(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i4 & 4) != 0 ? Math.max(1, (int) (Math.max(i, i2) / 100.0f)) : i3);
    }

    /* compiled from: BlankViewRegionChecker.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\f\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\u0015\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\fHÆ\u0003J\u0015\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\fHÆ\u0003J\t\u0010'\u001a\u00020\u000fHÆ\u0003J{\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010)\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\bHÖ\u0001J\t\u0010,\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014¨\u0006-"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/impl/blank/BlankViewRegionChecker$CheckResult;", "", "effectiveAreaRatio", "", "maxBlankAreaRatio", "blankBitmap", "", "blankBitmapWidth", "", "blankBitmapHeight", "validViewCount", MonitorConstant.BLANK_ALL_ELEMENTS, "", "validElements", "validChildNode", "", "(FFLjava/lang/String;IIILjava/util/Map;Ljava/util/Map;Z)V", "getBlankBitmap", "()Ljava/lang/String;", "getBlankBitmapHeight", "()I", "getBlankBitmapWidth", "getEffectiveAreaRatio", "()F", "getElements", "()Ljava/util/Map;", "getMaxBlankAreaRatio", "getValidChildNode", "()Z", "getValidElements", "getValidViewCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* data */ class CheckResult {
        private final String blankBitmap;
        private final int blankBitmapHeight;
        private final int blankBitmapWidth;
        private final float effectiveAreaRatio;
        private final Map<String, Integer> elements;
        private final float maxBlankAreaRatio;
        private final boolean validChildNode;
        private final Map<String, Integer> validElements;
        private final int validViewCount;

        public CheckResult() {
            this(0.0f, 0.0f, null, 0, 0, 0, null, null, false, 511, null);
        }

        /* renamed from: component1, reason: from getter */
        public final float getEffectiveAreaRatio() {
            return this.effectiveAreaRatio;
        }

        /* renamed from: component2, reason: from getter */
        public final float getMaxBlankAreaRatio() {
            return this.maxBlankAreaRatio;
        }

        /* renamed from: component3, reason: from getter */
        public final String getBlankBitmap() {
            return this.blankBitmap;
        }

        /* renamed from: component4, reason: from getter */
        public final int getBlankBitmapWidth() {
            return this.blankBitmapWidth;
        }

        /* renamed from: component5, reason: from getter */
        public final int getBlankBitmapHeight() {
            return this.blankBitmapHeight;
        }

        /* renamed from: component6, reason: from getter */
        public final int getValidViewCount() {
            return this.validViewCount;
        }

        public final Map<String, Integer> component7() {
            return this.elements;
        }

        public final Map<String, Integer> component8() {
            return this.validElements;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getValidChildNode() {
            return this.validChildNode;
        }

        public final CheckResult copy(float effectiveAreaRatio, float maxBlankAreaRatio, String blankBitmap, int blankBitmapWidth, int blankBitmapHeight, int validViewCount, Map<String, Integer> elements, Map<String, Integer> validElements, boolean validChildNode) {
            Intrinsics.checkNotNullParameter(blankBitmap, "blankBitmap");
            Intrinsics.checkNotNullParameter(elements, "elements");
            Intrinsics.checkNotNullParameter(validElements, "validElements");
            return new CheckResult(effectiveAreaRatio, maxBlankAreaRatio, blankBitmap, blankBitmapWidth, blankBitmapHeight, validViewCount, elements, validElements, validChildNode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CheckResult)) {
                return false;
            }
            CheckResult checkResult = (CheckResult) other;
            return Float.compare(this.effectiveAreaRatio, checkResult.effectiveAreaRatio) == 0 && Float.compare(this.maxBlankAreaRatio, checkResult.maxBlankAreaRatio) == 0 && Intrinsics.areEqual(this.blankBitmap, checkResult.blankBitmap) && this.blankBitmapWidth == checkResult.blankBitmapWidth && this.blankBitmapHeight == checkResult.blankBitmapHeight && this.validViewCount == checkResult.validViewCount && Intrinsics.areEqual(this.elements, checkResult.elements) && Intrinsics.areEqual(this.validElements, checkResult.validElements) && this.validChildNode == checkResult.validChildNode;
        }

        public int hashCode() {
            return (((((((((((((((Float.hashCode(this.effectiveAreaRatio) * 31) + Float.hashCode(this.maxBlankAreaRatio)) * 31) + this.blankBitmap.hashCode()) * 31) + Integer.hashCode(this.blankBitmapWidth)) * 31) + Integer.hashCode(this.blankBitmapHeight)) * 31) + Integer.hashCode(this.validViewCount)) * 31) + this.elements.hashCode()) * 31) + this.validElements.hashCode()) * 31) + Boolean.hashCode(this.validChildNode);
        }

        public String toString() {
            return "CheckResult(effectiveAreaRatio=" + this.effectiveAreaRatio + ", maxBlankAreaRatio=" + this.maxBlankAreaRatio + ", blankBitmap=" + this.blankBitmap + ", blankBitmapWidth=" + this.blankBitmapWidth + ", blankBitmapHeight=" + this.blankBitmapHeight + ", validViewCount=" + this.validViewCount + ", elements=" + this.elements + ", validElements=" + this.validElements + ", validChildNode=" + this.validChildNode + ')';
        }

        public CheckResult(float f, float f2, String blankBitmap, int i, int i2, int i3, Map<String, Integer> elements, Map<String, Integer> validElements, boolean z) {
            Intrinsics.checkNotNullParameter(blankBitmap, "blankBitmap");
            Intrinsics.checkNotNullParameter(elements, "elements");
            Intrinsics.checkNotNullParameter(validElements, "validElements");
            this.effectiveAreaRatio = f;
            this.maxBlankAreaRatio = f2;
            this.blankBitmap = blankBitmap;
            this.blankBitmapWidth = i;
            this.blankBitmapHeight = i2;
            this.validViewCount = i3;
            this.elements = elements;
            this.validElements = validElements;
            this.validChildNode = z;
        }

        public final float getEffectiveAreaRatio() {
            return this.effectiveAreaRatio;
        }

        public final float getMaxBlankAreaRatio() {
            return this.maxBlankAreaRatio;
        }

        public final String getBlankBitmap() {
            return this.blankBitmap;
        }

        public final int getBlankBitmapWidth() {
            return this.blankBitmapWidth;
        }

        public final int getBlankBitmapHeight() {
            return this.blankBitmapHeight;
        }

        public final int getValidViewCount() {
            return this.validViewCount;
        }

        public /* synthetic */ CheckResult(float f, float f2, String str, int i, int i2, int i3, Map map, Map map2, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 0.0f : f, (i4 & 2) == 0 ? f2 : 0.0f, (i4 & 4) != 0 ? "" : str, (i4 & 8) != 0 ? 0 : i, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? 0 : i3, (i4 & 64) != 0 ? MapsKt.emptyMap() : map, (i4 & 128) != 0 ? MapsKt.emptyMap() : map2, (i4 & 256) == 0 ? z : false);
        }

        public final Map<String, Integer> getElements() {
            return this.elements;
        }

        public final Map<String, Integer> getValidElements() {
            return this.validElements;
        }

        public final boolean getValidChildNode() {
            return this.validChildNode;
        }
    }

    public final void mark(int left, int top, int right, int bottom, int mark, String element, boolean childNode) {
        Intrinsics.checkNotNullParameter(element, "element");
        addRegion(left, top, right, bottom, mark);
        markElement(mark, element, childNode);
    }

    public final CheckResult check() {
        int i;
        int i2;
        float f;
        BlankViewRegionChecker blankViewRegionChecker;
        String str;
        int i3;
        BlankViewRegionChecker blankViewRegionChecker2 = this;
        int i4 = blankViewRegionChecker2.width;
        if (i4 <= 0 || (i = blankViewRegionChecker2.height) <= 0) {
            return new CheckResult(0.0f, 0.0f, null, 0, 0, 0, null, null, false, 511, null);
        }
        int i5 = blankViewRegionChecker2.sampleWidth;
        int i6 = ((i - 1) / i5) + 1;
        int i7 = ((i4 - 1) / i5) + 1;
        int i8 = i6 * i7;
        int i9 = i7 - 1;
        int i10 = i6 - 1;
        byte[] bArr = new byte[(i8 >> 3) + 1];
        Iterator it = blankViewRegionChecker2.bitmap.iterator();
        int i11 = 0;
        int i12 = i9;
        int i13 = i10;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (it.hasNext()) {
            Integer[] numArr = (Integer[]) it.next();
            int max = Math.max(i11, numArr[i11].intValue() / blankViewRegionChecker2.sampleWidth);
            Iterator it2 = it;
            int max2 = Math.max(i11, numArr[1].intValue() / blankViewRegionChecker2.sampleWidth);
            int min = Math.min(i9, numArr[2].intValue() / blankViewRegionChecker2.sampleWidth);
            int i17 = i16;
            int min2 = Math.min(i10, numArr[3].intValue() / blankViewRegionChecker2.sampleWidth);
            if (numArr[4].intValue() == 1) {
                if (max2 <= min2) {
                    int i18 = max2;
                    while (true) {
                        if (max <= min) {
                            int i19 = max;
                            while (true) {
                                int i20 = (i7 * i18) + i19;
                                int i21 = i20 >> 3;
                                int i22 = (7 - i20) & 7;
                                byte b = bArr[i21];
                                if (((b >>> i22) & 1) == 0) {
                                    i3 = i8;
                                    bArr[i21] = (byte) (b | ((byte) (1 << i22)));
                                    i17++;
                                } else {
                                    i3 = i8;
                                }
                                if (i19 == min) {
                                    break;
                                }
                                i19++;
                                i8 = i3;
                            }
                        } else {
                            i3 = i8;
                        }
                        if (i18 == min2) {
                            break;
                        }
                        i18++;
                        i8 = i3;
                    }
                } else {
                    i3 = i8;
                }
                i12 = Math.min(i12, max);
                i14 = Math.max(i14, min);
                i13 = Math.min(i13, max2);
                i15 = Math.max(i15, min2);
            } else {
                i3 = i8;
            }
            i16 = i17;
            i11 = 0;
            blankViewRegionChecker2 = this;
            it = it2;
            i8 = i3;
        }
        int i23 = i8;
        int i24 = i16;
        if (((Integer) CollectionsKt.maxOrNull((Iterable) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(i12 * i6), Integer.valueOf((i9 - i14) * i6), Integer.valueOf(i13 * i7), Integer.valueOf((i10 - i15) * i7)}))) != null) {
            i2 = i23;
            f = (r0.intValue() * 1.0f) / i2;
        } else {
            i2 = i23;
            f = 0.0f;
        }
        float f2 = f;
        float f3 = (i24 * 1.0f) / i2;
        if (Switches.blankBitmap.isEnabled()) {
            blankViewRegionChecker = this;
            try {
                str = blankViewRegionChecker.compressWithGZip(bArr);
            } catch (Throwable th) {
                MonitorLog.e("HybridMonitor", "Failed to generate blank bitmap string", th);
            }
            return new CheckResult(f3, f2, str, i7, i6, blankViewRegionChecker.bitmap.size(), blankViewRegionChecker.allElements, blankViewRegionChecker.validElements, blankViewRegionChecker.validChildNode);
        }
        blankViewRegionChecker = this;
        str = "";
        return new CheckResult(f3, f2, str, i7, i6, blankViewRegionChecker.bitmap.size(), blankViewRegionChecker.allElements, blankViewRegionChecker.validElements, blankViewRegionChecker.validChildNode);
    }

    private final String compressWithGZip(byte[] byteArray) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(byteArray);
        gZIPOutputStream.close();
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(byteOutpu…eArray(), Base64.NO_WRAP)");
        return encodeToString;
    }

    private final void addRegion(int left, int top, int right, int bottom, int mark) {
        if (mark != 0) {
            this.bitmap.add(new Integer[]{Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom), Integer.valueOf(mark)});
        }
    }

    private final void markElement(int mark, String element, boolean childNode) {
        if (childNode && mark == 1) {
            this.validChildNode = true;
        }
        if (mark == 1) {
            increment(this.validElements, element);
        }
        increment(this.allElements, element);
    }

    private final void increment(Map<String, Integer> map, String str) {
        Integer num = map.get(str);
        if (num == null) {
            num = 0;
        }
        map.put(str, Integer.valueOf(num.intValue() + 1));
    }
}
