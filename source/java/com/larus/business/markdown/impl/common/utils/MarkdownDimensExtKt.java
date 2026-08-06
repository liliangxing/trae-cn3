package com.larus.business.markdown.impl.common.utils;

import android.app.Application;
import android.content.res.Resources;
import com.larus.business.markdown.api.MarkdownService;
import com.larus.business.markdown.impl.C1327R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: MarkdownDimensExt.kt */
@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0010\b\n\u0003\b\u008e\u0001\u001a\u0012\u0010\u008d\u0001\u001a\u00020\u00012\t\b\u0001\u0010\u008e\u0001\u001a\u00020\u0001\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0006\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\u0007\u0010\u0003\"\u001b\u0010\t\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\n\u0010\u0003\"\u001b\u0010\f\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\r\u0010\u0003\"\u001b\u0010\u000f\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0010\u0010\u0003\"\u001b\u0010\u0012\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0013\u0010\u0003\"\u001b\u0010\u0015\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0016\u0010\u0003\"\u001b\u0010\u0018\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u0019\u0010\u0003\"\u001b\u0010\u001b\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001c\u0010\u0003\"\u001b\u0010\u001e\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0005\u001a\u0004\b\u001f\u0010\u0003\"\u001b\u0010!\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0005\u001a\u0004\b\"\u0010\u0003\"\u001b\u0010$\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0005\u001a\u0004\b%\u0010\u0003\"\u001b\u0010'\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0005\u001a\u0004\b(\u0010\u0003\"\u001b\u0010*\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0005\u001a\u0004\b+\u0010\u0003\"\u001b\u0010-\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0005\u001a\u0004\b.\u0010\u0003\"\u001b\u00100\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0005\u001a\u0004\b1\u0010\u0003\"\u001b\u00103\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0005\u001a\u0004\b4\u0010\u0003\"\u001b\u00106\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0005\u001a\u0004\b7\u0010\u0003\"\u001b\u00109\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0005\u001a\u0004\b:\u0010\u0003\"\u001b\u0010<\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u0005\u001a\u0004\b=\u0010\u0003\"\u001b\u0010?\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u0005\u001a\u0004\b@\u0010\u0003\"\u001b\u0010B\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u0005\u001a\u0004\bC\u0010\u0003\"\u001b\u0010E\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u0005\u001a\u0004\bF\u0010\u0003\"\u001b\u0010H\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0005\u001a\u0004\bI\u0010\u0003\"\u001b\u0010K\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0005\u001a\u0004\bL\u0010\u0003\"\u001b\u0010N\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u0005\u001a\u0004\bO\u0010\u0003\"\u001b\u0010Q\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\u0005\u001a\u0004\bR\u0010\u0003\"\u001b\u0010T\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u0005\u001a\u0004\bU\u0010\u0003\"\u001b\u0010W\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\u0005\u001a\u0004\bX\u0010\u0003\"\u001b\u0010Z\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010\u0005\u001a\u0004\b[\u0010\u0003\"\u001b\u0010]\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b_\u0010\u0005\u001a\u0004\b^\u0010\u0003\"\u001b\u0010`\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bb\u0010\u0005\u001a\u0004\ba\u0010\u0003\"\u001b\u0010c\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\be\u0010\u0005\u001a\u0004\bd\u0010\u0003\"\u001b\u0010f\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bh\u0010\u0005\u001a\u0004\bg\u0010\u0003\"\u001b\u0010i\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bk\u0010\u0005\u001a\u0004\bj\u0010\u0003\"\u001b\u0010l\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bn\u0010\u0005\u001a\u0004\bm\u0010\u0003\"\u001b\u0010o\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bq\u0010\u0005\u001a\u0004\bp\u0010\u0003\"\u001b\u0010r\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bt\u0010\u0005\u001a\u0004\bs\u0010\u0003\"\u001b\u0010u\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bw\u0010\u0005\u001a\u0004\bv\u0010\u0003\"\u001b\u0010x\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bz\u0010\u0005\u001a\u0004\by\u0010\u0003\"\u001b\u0010{\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b}\u0010\u0005\u001a\u0004\b|\u0010\u0003\"\u001c\u0010~\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\r\n\u0005\b\u0080\u0001\u0010\u0005\u001a\u0004\b\u007f\u0010\u0003\"\u001e\u0010\u0081\u0001\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0083\u0001\u0010\u0005\u001a\u0005\b\u0082\u0001\u0010\u0003\"\u001e\u0010\u0084\u0001\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0086\u0001\u0010\u0005\u001a\u0005\b\u0085\u0001\u0010\u0003\"\u001e\u0010\u0087\u0001\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0089\u0001\u0010\u0005\u001a\u0005\b\u0088\u0001\u0010\u0003\"\u001e\u0010\u008a\u0001\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008c\u0001\u0010\u0005\u001a\u0005\b\u008b\u0001\u0010\u0003¨\u0006\u008f\u0001"}, d2 = {"dp_0_5", "", "getDp_0_5", "()I", "dp_0_5$delegate", "Lkotlin/Lazy;", "dp_1", "getDp_1", "dp_1$delegate", "dp_10", "getDp_10", "dp_10$delegate", "dp_104", "getDp_104", "dp_104$delegate", "dp_11", "getDp_11", "dp_11$delegate", "dp_12", "getDp_12", "dp_12$delegate", "dp_120", "getDp_120", "dp_120$delegate", "dp_122", "getDp_122", "dp_122$delegate", "dp_14", "getDp_14", "dp_14$delegate", "dp_146", "getDp_146", "dp_146$delegate", "dp_16", "getDp_16", "dp_16$delegate", "dp_164", "getDp_164", "dp_164$delegate", "dp_17", "getDp_17", "dp_17$delegate", "dp_18", "getDp_18", "dp_18$delegate", "dp_180", "getDp_180", "dp_180$delegate", "dp_19", "getDp_19", "dp_19$delegate", "dp_2", "getDp_2", "dp_2$delegate", "dp_20", "getDp_20", "dp_20$delegate", "dp_200", "getDp_200", "dp_200$delegate", "dp_22", "getDp_22", "dp_22$delegate", "dp_24", "getDp_24", "dp_24$delegate", "dp_250", "getDp_250", "dp_250$delegate", "dp_26", "getDp_26", "dp_26$delegate", "dp_28", "getDp_28", "dp_28$delegate", "dp_294", "getDp_294", "dp_294$delegate", "dp_3", "getDp_3", "dp_3$delegate", "dp_32", "getDp_32", "dp_32$delegate", "dp_330", "getDp_330", "dp_330$delegate", "dp_34", "getDp_34", "dp_34$delegate", "dp_36", "getDp_36", "dp_36$delegate", "dp_375", "getDp_375", "dp_375$delegate", "dp_4", "getDp_4", "dp_4$delegate", "dp_40", "getDp_40", "dp_40$delegate", "dp_44", "getDp_44", "dp_44$delegate", "dp_45", "getDp_45", "dp_45$delegate", "dp_48", "getDp_48", "dp_48$delegate", "dp_5", "getDp_5", "dp_5$delegate", "dp_50", "getDp_50", "dp_50$delegate", "dp_52", "getDp_52", "dp_52$delegate", "dp_56", "getDp_56", "dp_56$delegate", "dp_58", "getDp_58", "dp_58$delegate", "dp_6", "getDp_6", "dp_6$delegate", "dp_60", "getDp_60", "dp_60$delegate", "dp_70", "getDp_70", "dp_70$delegate", "dp_76", "getDp_76", "dp_76$delegate", "dp_8", "getDp_8", "dp_8$delegate", "resDimensionPixelSize", "id", "markdown-impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class MarkdownDimensExtKt {
    private static final Lazy dp_0_5$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_0_5$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2824invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_0_5));
        }
    });
    private static final Lazy dp_1$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_1$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2825invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_1));
        }
    });
    private static final Lazy dp_2$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_2$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2840invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_2));
        }
    });
    private static final Lazy dp_3$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_3$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2849invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_3));
        }
    });
    private static final Lazy dp_4$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_4$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2855invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_4));
        }
    });
    private static final Lazy dp_5$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_5$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2860invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_5));
        }
    });
    private static final Lazy dp_6$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_6$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2865invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_6));
        }
    });
    private static final Lazy dp_8$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_8$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2869invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_8));
        }
    });
    private static final Lazy dp_10$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_10$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2826invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_10));
        }
    });
    private static final Lazy dp_11$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_11$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2828invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_11));
        }
    });
    private static final Lazy dp_12$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_12$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2829invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_12));
        }
    });
    private static final Lazy dp_14$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_14$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2832invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_14));
        }
    });
    private static final Lazy dp_16$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_16$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2834invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_16));
        }
    });
    private static final Lazy dp_17$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_17$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2836invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_17));
        }
    });
    private static final Lazy dp_18$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_18$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2837invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_18));
        }
    });
    private static final Lazy dp_19$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_19$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2839invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_19));
        }
    });
    private static final Lazy dp_20$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_20$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2841invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_20));
        }
    });
    private static final Lazy dp_22$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_22$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2843invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_22));
        }
    });
    private static final Lazy dp_24$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_24$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2844invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_24));
        }
    });
    private static final Lazy dp_26$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_26$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2846invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_26));
        }
    });
    private static final Lazy dp_28$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_28$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2847invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_28));
        }
    });
    private static final Lazy dp_32$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_32$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2850invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_32));
        }
    });
    private static final Lazy dp_34$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_34$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2852invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_34));
        }
    });
    private static final Lazy dp_36$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_36$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2853invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_36));
        }
    });
    private static final Lazy dp_40$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_40$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2856invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_40));
        }
    });
    private static final Lazy dp_44$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_44$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2857invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_44));
        }
    });
    private static final Lazy dp_45$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_45$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2858invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_45));
        }
    });
    private static final Lazy dp_48$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_48$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2859invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_48));
        }
    });
    private static final Lazy dp_50$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_50$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2861invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_50));
        }
    });
    private static final Lazy dp_52$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_52$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2862invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_52));
        }
    });
    private static final Lazy dp_56$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_56$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2863invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_52));
        }
    });
    private static final Lazy dp_58$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_58$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2864invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_58));
        }
    });
    private static final Lazy dp_60$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_60$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2866invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_60));
        }
    });
    private static final Lazy dp_70$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_70$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2867invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_70));
        }
    });
    private static final Lazy dp_76$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_76$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2868invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_76));
        }
    });
    private static final Lazy dp_104$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_104$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2827invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_104));
        }
    });
    private static final Lazy dp_120$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_120$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2830invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_120));
        }
    });
    private static final Lazy dp_122$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_122$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2831invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_122));
        }
    });
    private static final Lazy dp_146$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_146$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2833invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_146));
        }
    });
    private static final Lazy dp_164$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_164$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2835invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_164));
        }
    });
    private static final Lazy dp_180$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_180$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2838invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_180));
        }
    });
    private static final Lazy dp_200$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_200$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2842invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_200));
        }
    });
    private static final Lazy dp_250$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_250$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2845invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_250));
        }
    });
    private static final Lazy dp_294$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_294$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2848invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_294));
        }
    });
    private static final Lazy dp_330$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_330$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2851invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_330));
        }
    });
    private static final Lazy dp_375$delegate = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt$dp_375$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2854invoke() {
            return Integer.valueOf(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_375));
        }
    });

    public static final int getDp_0_5() {
        return ((Number) dp_0_5$delegate.getValue()).intValue();
    }

    public static final int getDp_1() {
        return ((Number) dp_1$delegate.getValue()).intValue();
    }

    public static final int getDp_2() {
        return ((Number) dp_2$delegate.getValue()).intValue();
    }

    public static final int getDp_3() {
        return ((Number) dp_3$delegate.getValue()).intValue();
    }

    public static final int getDp_4() {
        return ((Number) dp_4$delegate.getValue()).intValue();
    }

    public static final int getDp_5() {
        return ((Number) dp_5$delegate.getValue()).intValue();
    }

    public static final int getDp_6() {
        return ((Number) dp_6$delegate.getValue()).intValue();
    }

    public static final int getDp_8() {
        return ((Number) dp_8$delegate.getValue()).intValue();
    }

    public static final int getDp_10() {
        return ((Number) dp_10$delegate.getValue()).intValue();
    }

    public static final int getDp_11() {
        return ((Number) dp_11$delegate.getValue()).intValue();
    }

    public static final int getDp_12() {
        return ((Number) dp_12$delegate.getValue()).intValue();
    }

    public static final int getDp_14() {
        return ((Number) dp_14$delegate.getValue()).intValue();
    }

    public static final int getDp_16() {
        return ((Number) dp_16$delegate.getValue()).intValue();
    }

    public static final int getDp_17() {
        return ((Number) dp_17$delegate.getValue()).intValue();
    }

    public static final int getDp_18() {
        return ((Number) dp_18$delegate.getValue()).intValue();
    }

    public static final int getDp_19() {
        return ((Number) dp_19$delegate.getValue()).intValue();
    }

    public static final int getDp_20() {
        return ((Number) dp_20$delegate.getValue()).intValue();
    }

    public static final int getDp_22() {
        return ((Number) dp_22$delegate.getValue()).intValue();
    }

    public static final int getDp_24() {
        return ((Number) dp_24$delegate.getValue()).intValue();
    }

    public static final int getDp_26() {
        return ((Number) dp_26$delegate.getValue()).intValue();
    }

    public static final int getDp_28() {
        return ((Number) dp_28$delegate.getValue()).intValue();
    }

    public static final int getDp_32() {
        return ((Number) dp_32$delegate.getValue()).intValue();
    }

    public static final int getDp_34() {
        return ((Number) dp_34$delegate.getValue()).intValue();
    }

    public static final int getDp_36() {
        return ((Number) dp_36$delegate.getValue()).intValue();
    }

    public static final int getDp_40() {
        return ((Number) dp_40$delegate.getValue()).intValue();
    }

    public static final int getDp_44() {
        return ((Number) dp_44$delegate.getValue()).intValue();
    }

    public static final int getDp_45() {
        return ((Number) dp_45$delegate.getValue()).intValue();
    }

    public static final int getDp_48() {
        return ((Number) dp_48$delegate.getValue()).intValue();
    }

    public static final int getDp_50() {
        return ((Number) dp_50$delegate.getValue()).intValue();
    }

    public static final int getDp_52() {
        return ((Number) dp_52$delegate.getValue()).intValue();
    }

    public static final int getDp_56() {
        return ((Number) dp_56$delegate.getValue()).intValue();
    }

    public static final int getDp_58() {
        return ((Number) dp_58$delegate.getValue()).intValue();
    }

    public static final int getDp_60() {
        return ((Number) dp_60$delegate.getValue()).intValue();
    }

    public static final int getDp_70() {
        return ((Number) dp_70$delegate.getValue()).intValue();
    }

    public static final int getDp_76() {
        return ((Number) dp_76$delegate.getValue()).intValue();
    }

    public static final int getDp_104() {
        return ((Number) dp_104$delegate.getValue()).intValue();
    }

    public static final int getDp_120() {
        return ((Number) dp_120$delegate.getValue()).intValue();
    }

    public static final int getDp_122() {
        return ((Number) dp_122$delegate.getValue()).intValue();
    }

    public static final int getDp_146() {
        return ((Number) dp_146$delegate.getValue()).intValue();
    }

    public static final int getDp_164() {
        return ((Number) dp_164$delegate.getValue()).intValue();
    }

    public static final int getDp_180() {
        return ((Number) dp_180$delegate.getValue()).intValue();
    }

    public static final int getDp_200() {
        return ((Number) dp_200$delegate.getValue()).intValue();
    }

    public static final int getDp_250() {
        return ((Number) dp_250$delegate.getValue()).intValue();
    }

    public static final int getDp_294() {
        return ((Number) dp_294$delegate.getValue()).intValue();
    }

    public static final int getDp_330() {
        return ((Number) dp_330$delegate.getValue()).intValue();
    }

    public static final int getDp_375() {
        return ((Number) dp_375$delegate.getValue()).intValue();
    }

    public static final int resDimensionPixelSize(int i) {
        Resources resources;
        Application application = MarkdownService.INSTANCE.getApplication();
        if (application == null || (resources = application.getResources()) == null) {
            return 0;
        }
        return resources.getDimensionPixelSize(i);
    }
}
