package com.facebook.imagepipeline.utils;

import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* compiled from: LazySet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a4\u0010\u0005\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0086\n¢\u0006\u0002\u0010\n\u001a<\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\r\u001a\u0002H\u0002H\u0086\n¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"lazySet", "Lcom/facebook/imagepipeline/utils/LazySet;", "T", "initializer", "Lkotlin/Function0;", "getValue", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Lcom/facebook/imagepipeline/utils/LazySet;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", CustomDataTagHandler.VALUE_ATTRIBUTE, "(Lcom/facebook/imagepipeline/utils/LazySet;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "imagepipeline_noasanRelease"}, k = 2, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class LazySetKt {
    public static final <T> LazySet<T> lazySet(Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "initializer");
        return new LazySetImpl(function0, null, 2, null);
    }

    public static final <T> void setValue(LazySet<T> lazySet, Object obj, KProperty<?> kProperty, T t) {
        Intrinsics.checkParameterIsNotNull(lazySet, "$this$setValue");
        Intrinsics.checkParameterIsNotNull(kProperty, "property");
        lazySet.setValue(t);
    }

    public static final <T> T getValue(LazySet<T> lazySet, Object obj, KProperty<?> kProperty) {
        Intrinsics.checkParameterIsNotNull(lazySet, "$this$getValue");
        Intrinsics.checkParameterIsNotNull(kProperty, "property");
        return lazySet.getValue();
    }
}
