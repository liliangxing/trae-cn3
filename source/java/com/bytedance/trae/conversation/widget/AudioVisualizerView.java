package com.bytedance.trae.conversation.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.sdk.xbridge.cn.calendar.reducer.ReducerConstants;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.trae.home.solo.setting.SettingsTracker;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;

/* compiled from: AudioVisualizerView.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 :2\u00020\u0001:\u00029:B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0007J\u0006\u0010$\u001a\u00020\"J\u0006\u0010%\u001a\u00020\"J\u000e\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u000bJ(\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0014J\u0010\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u0007H\u0002J\u0010\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u000201H\u0014J\u0010\u00102\u001a\u00020\"2\u0006\u00103\u001a\u00020\u000bH\u0002J\u0018\u00104\u001a\u00020\"2\u0006\u00105\u001a\u00020\u00162\u0006\u00100\u001a\u000201H\u0002J\u0010\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0002J\b\u00108\u001a\u00020\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "density", "", "barWidth", "gapWidth", "sideMargin", "minBarHeight", "maxBarHeight", "visualizerWidth", "waveGroupNumber", "amplitude", "Ljava/util/LinkedList;", "lastTime", "", "barParams", "", "Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;", "barCount", "startAlphaSize", "endAlphaSize", "paint", "Landroid/graphics/Paint;", "isRunning", "", "setBarColor", "", "color", "startAnimation", "stopAnimation", "setAmplitude", "value", "onSizeChanged", "w", "h", "oldw", "oldh", "ensureCapacity", "capacity", "onDraw", "canvas", "Landroid/graphics/Canvas;", "genBarData", "currAmp", "drawBars", "stage", "paintAlpha", "index", "getAmplitude", "BarParam", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AudioVisualizerView extends View {
    private static final int BAR_TYPE_OTHER = 2;
    private static final int BAR_TYPE_SIDE = 1;
    private static final int BAR_TYPE_TOP = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int GROUP_TYPE_OTHER = 2;
    private static final int GROUP_TYPE_SIDE = 1;
    private static final int GROUP_TYPE_TOP = 0;
    private final LinkedList<Float> amplitude;
    private int barCount;
    private final Map<Integer, BarParam> barParams;
    private final float barWidth;
    private final float density;
    private int endAlphaSize;
    private final float gapWidth;
    private boolean isRunning;
    private long lastTime;
    private final float maxBarHeight;
    private final float minBarHeight;
    private final Paint paint;
    private float sideMargin;
    private int startAlphaSize;
    private float visualizerWidth;
    private int waveGroupNumber;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AudioVisualizerView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AudioVisualizerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AudioVisualizerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioVisualizerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        float f = getResources().getDisplayMetrics().density;
        this.density = f;
        float f2 = f * 3.0f;
        this.barWidth = f2;
        this.gapWidth = 2.0f * f;
        this.sideMargin = 40.0f * f;
        this.minBarHeight = 3.0f * f;
        this.maxBarHeight = f * 48.0f;
        this.amplitude = new LinkedList<>();
        this.barParams = new LinkedHashMap();
        this.startAlphaSize = 5;
        this.endAlphaSize = 5;
        Paint paint = new Paint(1);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(f2);
        paint.setColor(-1);
        this.paint = paint;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AudioVisualizerView.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J;\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014¨\u0006%"}, d2 = {"Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$BarParam;", "", "barType", "", "groupType", "barHeight", "", "curBarHeight", SettingsTracker.BINDING_ACTION_CHANGE, "<init>", "(IIFFF)V", "getBarType", "()I", "setBarType", "(I)V", "getGroupType", "setGroupType", "getBarHeight", "()F", "setBarHeight", "(F)V", "getCurBarHeight", "setCurBarHeight", "getChange", "setChange", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class BarParam {
        private float barHeight;
        private int barType;
        private float change;
        private float curBarHeight;
        private int groupType;

        public BarParam() {
            this(0, 0, 0.0f, 0.0f, 0.0f, 31, null);
        }

        public static /* synthetic */ BarParam copy$default(BarParam barParam, int i, int i2, float f, float f2, float f3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = barParam.barType;
            }
            if ((i3 & 2) != 0) {
                i2 = barParam.groupType;
            }
            int i4 = i2;
            if ((i3 & 4) != 0) {
                f = barParam.barHeight;
            }
            float f4 = f;
            if ((i3 & 8) != 0) {
                f2 = barParam.curBarHeight;
            }
            float f5 = f2;
            if ((i3 & 16) != 0) {
                f3 = barParam.change;
            }
            return barParam.copy(i, i4, f4, f5, f3);
        }

        /* renamed from: component1, reason: from getter */
        public final int getBarType() {
            return this.barType;
        }

        /* renamed from: component2, reason: from getter */
        public final int getGroupType() {
            return this.groupType;
        }

        /* renamed from: component3, reason: from getter */
        public final float getBarHeight() {
            return this.barHeight;
        }

        /* renamed from: component4, reason: from getter */
        public final float getCurBarHeight() {
            return this.curBarHeight;
        }

        /* renamed from: component5, reason: from getter */
        public final float getChange() {
            return this.change;
        }

        public final BarParam copy(int barType, int groupType, float barHeight, float curBarHeight, float change) {
            return new BarParam(barType, groupType, barHeight, curBarHeight, change);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BarParam)) {
                return false;
            }
            BarParam barParam = (BarParam) other;
            return this.barType == barParam.barType && this.groupType == barParam.groupType && Float.compare(this.barHeight, barParam.barHeight) == 0 && Float.compare(this.curBarHeight, barParam.curBarHeight) == 0 && Float.compare(this.change, barParam.change) == 0;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.barType) * 31) + Integer.hashCode(this.groupType)) * 31) + Float.hashCode(this.barHeight)) * 31) + Float.hashCode(this.curBarHeight)) * 31) + Float.hashCode(this.change);
        }

        public String toString() {
            return "BarParam(barType=" + this.barType + ", groupType=" + this.groupType + ", barHeight=" + this.barHeight + ", curBarHeight=" + this.curBarHeight + ", change=" + this.change + ')';
        }

        public BarParam(int i, int i2, float f, float f2, float f3) {
            this.barType = i;
            this.groupType = i2;
            this.barHeight = f;
            this.curBarHeight = f2;
            this.change = f3;
        }

        public /* synthetic */ BarParam(int i, int i2, float f, float f2, float f3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 2 : i, (i3 & 2) == 0 ? i2 : 2, (i3 & 4) != 0 ? 0.0f : f, (i3 & 8) != 0 ? 0.0f : f2, (i3 & 16) != 0 ? 0.0f : f3);
        }

        public final int getBarType() {
            return this.barType;
        }

        public final void setBarType(int i) {
            this.barType = i;
        }

        public final int getGroupType() {
            return this.groupType;
        }

        public final void setGroupType(int i) {
            this.groupType = i;
        }

        public final float getBarHeight() {
            return this.barHeight;
        }

        public final void setBarHeight(float f) {
            this.barHeight = f;
        }

        public final float getCurBarHeight() {
            return this.curBarHeight;
        }

        public final void setCurBarHeight(float f) {
            this.curBarHeight = f;
        }

        public final float getChange() {
            return this.change;
        }

        public final void setChange(float f) {
            this.change = f;
        }
    }

    public final void setBarColor(int color) {
        this.paint.setColor(color);
        invalidate();
    }

    public final void startAnimation() {
        this.isRunning = true;
        this.lastTime = 0L;
        postInvalidateDelayed(10L);
    }

    public final void stopAnimation() {
        this.isRunning = false;
        this.lastTime = 0L;
        for (BarParam barParam : this.barParams.values()) {
            barParam.setCurBarHeight(0.0f);
            barParam.setChange(0.0f);
        }
        invalidate();
    }

    public final void setAmplitude(float value) {
        this.amplitude.offer(Float.valueOf(value));
        if (this.amplitude.size() > 10) {
            this.amplitude.poll();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        float f = w - (this.sideMargin * 2);
        float f2 = (this.barWidth + this.gapWidth) * 5;
        int i = (int) (f / f2);
        this.waveGroupNumber = i;
        if (i % 2 == 0) {
            this.waveGroupNumber = i - 1;
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(this.waveGroupNumber, 3);
        this.waveGroupNumber = coerceAtLeast;
        this.visualizerWidth = coerceAtLeast * f2;
        int i2 = coerceAtLeast * 5;
        this.barCount = i2;
        ensureCapacity(i2);
    }

    private final void ensureCapacity(int capacity) {
        if (this.barParams.get(Integer.valueOf(capacity)) != null) {
            return;
        }
        this.barParams.clear();
        int i = 1;
        if (1 > capacity) {
            return;
        }
        while (true) {
            this.barParams.put(Integer.valueOf(i), new BarParam(0, 0, 0.0f, 0.0f, 0.0f, 31, null));
            if (i == capacity) {
                return;
            } else {
                i++;
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.isRunning) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = elapsedRealtime - this.lastTime;
            if (j >= 400) {
                this.lastTime = elapsedRealtime;
                float amplitude = getAmplitude();
                if (j >= 800) {
                    amplitude = 0.0f;
                    j = 0;
                } else {
                    j -= FConstants.DECOMPRESS_FAIL_CODE;
                }
                genBarData(amplitude);
            }
            drawBars(j, canvas);
            postInvalidateDelayed(10L);
        }
    }

    private final void genBarData(float currAmp) {
        float nextFloat;
        float f;
        float f2;
        int i;
        int i2 = 2;
        int i3 = this.waveGroupNumber / 2;
        int i4 = i3 + 3;
        int i5 = 1;
        int nextInt = Random.Default.nextInt(i3, RangesKt.coerceAtMost(i4, this.waveGroupNumber + 1));
        int i6 = this.waveGroupNumber;
        if (1 > i6) {
            return;
        }
        int i7 = 1;
        while (true) {
            int i8 = 0;
            if (i7 == nextInt) {
                f2 = 1.0f;
            } else {
                if (((i7 > nextInt + 1 || nextInt + (-1) > i7) ? 0 : i5) != 0) {
                    nextFloat = Random.Default.nextFloat() * 0.2f;
                    f = 0.6f;
                } else {
                    nextFloat = Random.Default.nextFloat() * 0.1f;
                    f = 0.4f;
                }
                f2 = nextFloat + f;
            }
            if (i7 == nextInt) {
                i = 0;
            } else {
                i = ((i3 > i7 || i7 > RangesKt.coerceAtMost(i4, this.waveGroupNumber)) ? 0 : i5) != 0 ? i5 : i2;
            }
            int i9 = 5;
            int nextInt2 = Random.Default.nextInt(i2, 5);
            float coerceAtLeast = RangesKt.coerceAtLeast(this.maxBarHeight * currAmp * f2, this.minBarHeight);
            float f3 = coerceAtLeast * 0.7f;
            float coerceAtLeast2 = RangesKt.coerceAtLeast(f3 * f2, this.minBarHeight);
            float coerceAtLeast3 = RangesKt.coerceAtLeast(f3 * 0.7f * f2, this.minBarHeight);
            int i10 = 1;
            while (i10 < 6) {
                int i11 = ((i7 - 1) * i9) + i10;
                BarParam barParam = this.barParams.get(Integer.valueOf(i11));
                if (barParam != null) {
                    barParam.setGroupType(i);
                }
                if (i10 == nextInt2) {
                    BarParam barParam2 = this.barParams.get(Integer.valueOf(i11));
                    if (barParam2 != null) {
                        barParam2.setBarType(i8);
                    }
                    BarParam barParam3 = this.barParams.get(Integer.valueOf(i11));
                    if (barParam3 != null) {
                        barParam3.setBarHeight(coerceAtLeast);
                    }
                } else {
                    if (((i10 > nextInt2 + 1 || nextInt2 + (-1) > i10) ? i8 : 1) != 0) {
                        BarParam barParam4 = this.barParams.get(Integer.valueOf(i11));
                        if (barParam4 != null) {
                            barParam4.setBarType(1);
                        }
                        BarParam barParam5 = this.barParams.get(Integer.valueOf(i11));
                        if (barParam5 != null) {
                            barParam5.setBarHeight(coerceAtLeast2);
                        }
                    } else {
                        BarParam barParam6 = this.barParams.get(Integer.valueOf(i11));
                        if (barParam6 != null) {
                            barParam6.setBarType(2);
                        }
                        BarParam barParam7 = this.barParams.get(Integer.valueOf(i11));
                        if (barParam7 != null) {
                            barParam7.setBarHeight(coerceAtLeast3);
                        }
                    }
                }
                i10++;
                i8 = 0;
                i9 = 5;
            }
            if (i7 == i6) {
                return;
            }
            i7++;
            i2 = 2;
            i5 = 1;
        }
    }

    private final void drawBars(long stage, Canvas canvas) {
        int i = 2;
        float f = 2;
        float width = (getWidth() - this.visualizerWidth) / f;
        int i2 = this.barCount;
        if (1 > i2) {
            return;
        }
        int i3 = 1;
        while (true) {
            BarParam barParam = this.barParams.get(Integer.valueOf(i3));
            if (barParam != null) {
                boolean z = false;
                boolean z2 = barParam.getGroupType() == 0 && barParam.getBarType() == 0;
                boolean z3 = (barParam.getGroupType() == 0 && barParam.getBarType() == 1) || (barParam.getGroupType() == 1 && barParam.getBarType() == 0);
                boolean z4 = (barParam.getGroupType() == 0 && barParam.getBarType() == i) || (barParam.getGroupType() == 1 && barParam.getBarType() == 1);
                boolean z5 = (barParam.getGroupType() == 1 && barParam.getBarType() == i) || barParam.getGroupType() == i;
                if (!(0 <= stage && stage < 50)) {
                    if (!(50 <= stage && stage < 100)) {
                        if (!(100 <= stage && stage < 150)) {
                            if (!(150 <= stage && stage < 200)) {
                                if (!(200 <= stage && stage < 250)) {
                                    if (!(250 <= stage && stage < 300)) {
                                        if (!(300 <= stage && stage < 350)) {
                                            if (350 <= stage && stage < 400) {
                                                z = true;
                                            }
                                            if (z && z5) {
                                                barParam.setChange((this.minBarHeight - barParam.getBarHeight()) / 20);
                                            }
                                        } else if (z4) {
                                            barParam.setChange((this.minBarHeight - barParam.getBarHeight()) / 20);
                                        }
                                    } else if (z3) {
                                        barParam.setChange((this.minBarHeight - barParam.getBarHeight()) / 20);
                                    }
                                } else if (z2) {
                                    barParam.setChange((this.minBarHeight - barParam.getBarHeight()) / 20);
                                }
                            } else if (z5) {
                                barParam.setChange((barParam.getBarHeight() - (barParam.getCurBarHeight() > 0.0f ? barParam.getCurBarHeight() : this.minBarHeight)) / 20);
                            }
                        } else if (z4) {
                            barParam.setChange((barParam.getBarHeight() - (barParam.getCurBarHeight() > 0.0f ? barParam.getCurBarHeight() : this.minBarHeight)) / 20);
                        }
                    } else if (z3) {
                        barParam.setChange((barParam.getBarHeight() - (barParam.getCurBarHeight() > 0.0f ? barParam.getCurBarHeight() : this.minBarHeight)) / 20);
                    }
                } else if (z2) {
                    barParam.setChange((barParam.getBarHeight() - (barParam.getCurBarHeight() > 0.0f ? barParam.getCurBarHeight() : this.minBarHeight)) / 20);
                }
                float coerceAtLeast = RangesKt.coerceAtLeast(barParam.getCurBarHeight() + barParam.getChange(), this.minBarHeight);
                barParam.setCurBarHeight(coerceAtLeast);
                float height = (getHeight() - coerceAtLeast) / f;
                width += this.barWidth + this.gapWidth;
                this.paint.setAlpha(paintAlpha(i3));
                canvas.drawLine(width, height, width, height + coerceAtLeast, this.paint);
            }
            if (i3 == i2) {
                return;
            }
            i3++;
            i = 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int paintAlpha(int index) {
        float f;
        int i = this.startAlphaSize;
        int i2 = this.endAlphaSize;
        int i3 = this.barCount;
        if (i != 0) {
            if (1 <= index && index <= i) {
                f = index / i;
                if (i2 != 0) {
                    if ((i3 - i2) + 1 <= index && index <= i3) {
                        f = (i3 - index) / i2;
                    }
                }
                return RangesKt.coerceIn((int) (f * ReducerConstants.REQUEST_CODE), 0, ReducerConstants.REQUEST_CODE);
            }
        }
        f = 1.0f;
        if (i2 != 0) {
        }
        return RangesKt.coerceIn((int) (f * ReducerConstants.REQUEST_CODE), 0, ReducerConstants.REQUEST_CODE);
    }

    private final float getAmplitude() {
        Float maxOrNull = CollectionsKt.maxOrNull(this.amplitude);
        float floatValue = maxOrNull != null ? maxOrNull.floatValue() : 0.0f;
        this.amplitude.clear();
        return floatValue;
    }

    /* compiled from: AudioVisualizerView.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/conversation/widget/AudioVisualizerView$Companion;", "", "<init>", "()V", "optAmplitude", "", "before", "", "BAR_TYPE_TOP", "", "BAR_TYPE_SIDE", "BAR_TYPE_OTHER", "GROUP_TYPE_TOP", "GROUP_TYPE_SIDE", "GROUP_TYPE_OTHER", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final float optAmplitude(double before) {
            return RangesKt.coerceAtMost(((float) (before > 0.8d ? 1.0d : Math.sin(before * 3.141592653589793d))) * 2.5f, 1.0f);
        }
    }
}
