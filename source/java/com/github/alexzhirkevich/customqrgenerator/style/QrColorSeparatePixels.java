package com.github.alexzhirkevich.customqrgenerator.style;

import com.lynx.tasm.animation.AnimationConstant;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrColorSeparatePixels.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bæ\u0080\u0001\u0018\u00002\u00020\u0001:\u0001\bJ)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H¦\u0002¨\u0006\t"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrColorSeparatePixels;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "invoke", "", "i", "j", AnimationConstant.PROP_STR_WIDTH, AnimationConstant.PROP_STR_HEIGHT, "Random", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface QrColorSeparatePixels extends QrColor {
    @Override // com.github.alexzhirkevich.customqrgenerator.style.QrColor
    int invoke(int i, int j, int width, int height);

    /* compiled from: QrColorSeparatePixels.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001J)\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0096\u0002J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrColorSeparatePixels$Random;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColorSeparatePixels;", "colors", "", "", "", "(Ljava/util/Map;)V", "getColors", "()Ljava/util/Map;", "sorted", "", "Lkotlin/Pair;", "sum", "component1", "copy", "equals", "", "other", "", "hashCode", "invoke", "i", "j", AnimationConstant.PROP_STR_WIDTH, AnimationConstant.PROP_STR_HEIGHT, "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class Random implements QrColorSeparatePixels {
        private final Map<Integer, Float> colors;
        private final List<Pair<Integer, Float>> sorted;
        private final float sum;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Random copy$default(Random random, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = random.colors;
            }
            return random.copy(map);
        }

        public final Map<Integer, Float> component1() {
            return this.colors;
        }

        public final Random copy(Map<Integer, Float> colors) {
            Intrinsics.checkNotNullParameter(colors, "colors");
            return new Random(colors);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Random) && Intrinsics.areEqual(this.colors, ((Random) other).colors);
        }

        public int hashCode() {
            return this.colors.hashCode();
        }

        public String toString() {
            return "Random(colors=" + this.colors + ')';
        }

        public Random(Map<Integer, Float> map) {
            Intrinsics.checkNotNullParameter(map, "colors");
            this.colors = map;
            this.sorted = CollectionsKt.sortedWith(MapsKt.toList(map), new Comparator() { // from class: com.github.alexzhirkevich.customqrgenerator.style.QrColorSeparatePixels$Random$special$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues((Float) ((Pair) t).getSecond(), (Float) ((Pair) t2).getSecond());
                }
            });
            this.sum = CollectionsKt.sumOfFloat(map.values());
        }

        public final Map<Integer, Float> getColors() {
            return this.colors;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrColorSeparatePixels, com.github.alexzhirkevich.customqrgenerator.style.QrColor
        public int invoke(int i, int j, int width, int height) {
            if (this.colors.isEmpty()) {
                return 0;
            }
            float nextFloat = kotlin.random.Random.Default.nextFloat() * this.sum;
            float f = 0.0f;
            for (Pair<Integer, Float> pair : this.sorted) {
                int intValue = ((Number) pair.component1()).intValue();
                f += ((Number) pair.component2()).floatValue();
                if (f > nextFloat) {
                    return intValue;
                }
            }
            return ((Number) ((Pair) CollectionsKt.last(this.sorted)).getFirst()).intValue();
        }
    }
}
