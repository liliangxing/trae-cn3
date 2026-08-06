package com.bytedance.salamander.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.bytedance.rts.foundation.RTSFloatKt;
import com.bytedance.rts.foundation.RTSIntKt;
import com.bytedance.salamander.adapter.Salamander;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FoundationUIKitScreenImpl.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/salamander/adapter/ScreenImpl;", "", "()V", "Companion", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public class ScreenImpl {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(0 == true ? 1 : 0);
    private static DisplayMetrics displayMetrics;

    /* compiled from: FoundationUIKitScreenImpl.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/salamander/adapter/ScreenImpl$Companion;", "", "()V", "displayMetrics", "Landroid/util/DisplayMetrics;", "height", "", "nativeScale", "scale", "width", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public double width() {
            IntCompanionObject intCompanionObject = IntCompanionObject.INSTANCE;
            DisplayMetrics displayMetrics = ScreenImpl.displayMetrics;
            Intrinsics.checkNotNull(displayMetrics);
            return RTSIntKt.toFloat64(intCompanionObject, displayMetrics.widthPixels);
        }

        public double height() {
            IntCompanionObject intCompanionObject = IntCompanionObject.INSTANCE;
            DisplayMetrics displayMetrics = ScreenImpl.displayMetrics;
            Intrinsics.checkNotNull(displayMetrics);
            return RTSIntKt.toFloat64(intCompanionObject, displayMetrics.heightPixels);
        }

        public double scale() {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            DisplayMetrics displayMetrics = ScreenImpl.displayMetrics;
            Intrinsics.checkNotNull(displayMetrics);
            return RTSFloatKt.toFloat64(floatCompanionObject, displayMetrics.density);
        }

        public double nativeScale() {
            IntCompanionObject intCompanionObject = IntCompanionObject.INSTANCE;
            DisplayMetrics displayMetrics = ScreenImpl.displayMetrics;
            Intrinsics.checkNotNull(displayMetrics);
            return RTSIntKt.toFloat64(intCompanionObject, displayMetrics.densityDpi) / 160.0d;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Salamander.Companion companion = Salamander.INSTANCE;
        Intrinsics.checkNotNull(companion);
        Context application = companion.getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type android.content.Context{ com.bytedance.salamander.adapter.IndexKt.Context }");
        Resources resources = application.getResources();
        displayMetrics = resources != null ? resources.getDisplayMetrics() : null;
    }
}
