package com.bytedance.trae.conversation.brainstorm.health;

import com.bytedance.trae.im.model.ConfirmInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: RtcLowAudioDetector.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0003\u0016\u0017\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;", "", "<init>", "()V", "samples", "", "Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Sample;", "windowStartMs", "", "consecutiveLowWindows", "", "onAudioSample", "Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;", "linearVolume", "vad", "timestampMs", "recentUserSubtitle", "", "reset", "", "evaluateWindow", "clearWindow", "Companion", "Evaluation", "Sample", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class RtcLowAudioDetector {
    public static final long ASR_FALLBACK_MS = 2500;
    public static final double AVG_THRESHOLD = 76.0d;
    public static final int CONFIRM_WINDOW_COUNT = 3;
    public static final long HEALTH_WINDOW_MS = 2000;
    public static final float LOW_FRAME_RATIO = 0.8f;
    public static final int MAX_THRESHOLD = 100;
    public static final int MIN_ASR_FALLBACK_VAD_FRAMES = 4;
    public static final int MIN_VAD_FRAMES = 6;
    private int consecutiveLowWindows;
    private final List<Sample> samples = new ArrayList();
    private long windowStartMs;

    /* compiled from: RtcLowAudioDetector.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\rHÆ\u0003JY\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0006HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;", "", ConfirmInfo.STATUS_CONFIRMED, "", "windowHit", "hitCount", "", "avgVolume", "", "maxVolume", "voicedSize", "totalSize", "lowRatio", "", "<init>", "(ZZIDIIIF)V", "getConfirmed", "()Z", "getWindowHit", "getHitCount", "()I", "getAvgVolume", "()D", "getMaxVolume", "getVoicedSize", "getTotalSize", "getLowRatio", "()F", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Evaluation {
        private final double avgVolume;
        private final boolean confirmed;
        private final int hitCount;
        private final float lowRatio;
        private final int maxVolume;
        private final int totalSize;
        private final int voicedSize;
        private final boolean windowHit;

        /* renamed from: component1, reason: from getter */
        public final boolean getConfirmed() {
            return this.confirmed;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getWindowHit() {
            return this.windowHit;
        }

        /* renamed from: component3, reason: from getter */
        public final int getHitCount() {
            return this.hitCount;
        }

        /* renamed from: component4, reason: from getter */
        public final double getAvgVolume() {
            return this.avgVolume;
        }

        /* renamed from: component5, reason: from getter */
        public final int getMaxVolume() {
            return this.maxVolume;
        }

        /* renamed from: component6, reason: from getter */
        public final int getVoicedSize() {
            return this.voicedSize;
        }

        /* renamed from: component7, reason: from getter */
        public final int getTotalSize() {
            return this.totalSize;
        }

        /* renamed from: component8, reason: from getter */
        public final float getLowRatio() {
            return this.lowRatio;
        }

        public final Evaluation copy(boolean confirmed, boolean windowHit, int hitCount, double avgVolume, int maxVolume, int voicedSize, int totalSize, float lowRatio) {
            return new Evaluation(confirmed, windowHit, hitCount, avgVolume, maxVolume, voicedSize, totalSize, lowRatio);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Evaluation)) {
                return false;
            }
            Evaluation evaluation = (Evaluation) other;
            return this.confirmed == evaluation.confirmed && this.windowHit == evaluation.windowHit && this.hitCount == evaluation.hitCount && Double.compare(this.avgVolume, evaluation.avgVolume) == 0 && this.maxVolume == evaluation.maxVolume && this.voicedSize == evaluation.voicedSize && this.totalSize == evaluation.totalSize && Float.compare(this.lowRatio, evaluation.lowRatio) == 0;
        }

        public int hashCode() {
            return (((((((((((((Boolean.hashCode(this.confirmed) * 31) + Boolean.hashCode(this.windowHit)) * 31) + Integer.hashCode(this.hitCount)) * 31) + Double.hashCode(this.avgVolume)) * 31) + Integer.hashCode(this.maxVolume)) * 31) + Integer.hashCode(this.voicedSize)) * 31) + Integer.hashCode(this.totalSize)) * 31) + Float.hashCode(this.lowRatio);
        }

        public String toString() {
            return "Evaluation(confirmed=" + this.confirmed + ", windowHit=" + this.windowHit + ", hitCount=" + this.hitCount + ", avgVolume=" + this.avgVolume + ", maxVolume=" + this.maxVolume + ", voicedSize=" + this.voicedSize + ", totalSize=" + this.totalSize + ", lowRatio=" + this.lowRatio + ')';
        }

        public Evaluation(boolean z, boolean z2, int i, double d, int i2, int i3, int i4, float f) {
            this.confirmed = z;
            this.windowHit = z2;
            this.hitCount = i;
            this.avgVolume = d;
            this.maxVolume = i2;
            this.voicedSize = i3;
            this.totalSize = i4;
            this.lowRatio = f;
        }

        public final boolean getConfirmed() {
            return this.confirmed;
        }

        public final boolean getWindowHit() {
            return this.windowHit;
        }

        public final int getHitCount() {
            return this.hitCount;
        }

        public final double getAvgVolume() {
            return this.avgVolume;
        }

        public final int getMaxVolume() {
            return this.maxVolume;
        }

        public final int getVoicedSize() {
            return this.voicedSize;
        }

        public final int getTotalSize() {
            return this.totalSize;
        }

        public final float getLowRatio() {
            return this.lowRatio;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RtcLowAudioDetector.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Sample;", "", "linearVolume", "", "vad", "<init>", "(II)V", "getLinearVolume", "()I", "getVad", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Sample {
        private final int linearVolume;
        private final int vad;

        public static /* synthetic */ Sample copy$default(Sample sample, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = sample.linearVolume;
            }
            if ((i3 & 2) != 0) {
                i2 = sample.vad;
            }
            return sample.copy(i, i2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getLinearVolume() {
            return this.linearVolume;
        }

        /* renamed from: component2, reason: from getter */
        public final int getVad() {
            return this.vad;
        }

        public final Sample copy(int linearVolume, int vad) {
            return new Sample(linearVolume, vad);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Sample)) {
                return false;
            }
            Sample sample = (Sample) other;
            return this.linearVolume == sample.linearVolume && this.vad == sample.vad;
        }

        public int hashCode() {
            return (Integer.hashCode(this.linearVolume) * 31) + Integer.hashCode(this.vad);
        }

        public String toString() {
            return "Sample(linearVolume=" + this.linearVolume + ", vad=" + this.vad + ')';
        }

        public Sample(int i, int i2) {
            this.linearVolume = i;
            this.vad = i2;
        }

        public final int getLinearVolume() {
            return this.linearVolume;
        }

        public final int getVad() {
            return this.vad;
        }
    }

    public final Evaluation onAudioSample(int linearVolume, int vad, long timestampMs, boolean recentUserSubtitle) {
        if (this.windowStartMs == 0) {
            this.windowStartMs = timestampMs;
        }
        this.samples.add(new Sample(linearVolume, vad));
        if (timestampMs - this.windowStartMs < 2000) {
            return null;
        }
        return evaluateWindow(recentUserSubtitle);
    }

    public final void reset() {
        this.samples.clear();
        this.windowStartMs = 0L;
        this.consecutiveLowWindows = 0;
    }

    private final Evaluation evaluateWindow(boolean recentUserSubtitle) {
        int i;
        int i2;
        Integer num;
        if (this.samples.isEmpty()) {
            reset();
            return new Evaluation(false, false, 0, 0.0d, 0, 0, 0, 0.0f);
        }
        List<Sample> list = this.samples;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((Sample) next).getVad() == 1) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (!(arrayList2.size() >= 6 || (recentUserSubtitle && arrayList2.size() >= 4))) {
            this.consecutiveLowWindows = 0;
            Iterator<T> it2 = this.samples.iterator();
            if (it2.hasNext()) {
                Integer valueOf = Integer.valueOf(((Sample) it2.next()).getLinearVolume());
                while (it2.hasNext()) {
                    Integer valueOf2 = Integer.valueOf(((Sample) it2.next()).getLinearVolume());
                    if (valueOf.compareTo(valueOf2) < 0) {
                        valueOf = valueOf2;
                    }
                }
                num = valueOf;
            } else {
                num = null;
            }
            Integer num2 = num;
            Evaluation evaluation = new Evaluation(false, false, 0, 0.0d, num2 != null ? num2.intValue() : 0, arrayList2.size(), this.samples.size(), 0.0f);
            clearWindow();
            return evaluation;
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            arrayList4.add(Integer.valueOf(((Sample) it3.next()).getLinearVolume()));
        }
        double averageOfInt = CollectionsKt.averageOfInt(arrayList4);
        Iterator<T> it4 = this.samples.iterator();
        if (!it4.hasNext()) {
            throw new NoSuchElementException();
        }
        int linearVolume = ((Sample) it4.next()).getLinearVolume();
        loop3: while (true) {
            i = linearVolume;
            while (it4.hasNext()) {
                linearVolume = ((Sample) it4.next()).getLinearVolume();
                if (i < linearVolume) {
                    break;
                }
            }
        }
        if ((arrayList3 instanceof Collection) && arrayList3.isEmpty()) {
            i2 = 0;
        } else {
            Iterator it5 = arrayList3.iterator();
            i2 = 0;
            while (it5.hasNext()) {
                if ((((double) ((Sample) it5.next()).getLinearVolume()) < 76.0d) && (i2 = i2 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        float size = i2 / arrayList2.size();
        boolean z = averageOfInt < 76.0d && i < 100 && size >= 0.8f;
        int i3 = z ? this.consecutiveLowWindows + 1 : 0;
        this.consecutiveLowWindows = i3;
        boolean z2 = i3 >= 3;
        if (z2) {
            this.consecutiveLowWindows = 0;
        }
        Evaluation evaluation2 = new Evaluation(z2, z, i3, averageOfInt, i, arrayList2.size(), this.samples.size(), size);
        clearWindow();
        return evaluation2;
    }

    private final void clearWindow() {
        this.samples.clear();
        this.windowStartMs = 0L;
    }
}
