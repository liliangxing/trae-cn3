package androidx.savedstate;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SavedState.android.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001aC\u0010\u0002\u001a\u00060\u0001j\u0002`\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0019\b\u0002\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001a7\u0010\u0002\u001a\u00060\u0001j\u0002`\u00032\n\u0010\u0004\u001a\u00060\u0001j\u0002`\u00032\u0019\b\u0002\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000*\n\u0010\u0000\"\u00020\u00012\u00020\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"SavedState", "Landroid/os/Bundle;", "savedState", "Landroidx/savedstate/SavedState;", "initialState", "", "", "", "builderAction", "Lkotlin/Function1;", "Landroidx/savedstate/SavedStateWriter;", "", "Lkotlin/ExtensionFunctionType;", "savedstate"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "androidx/savedstate/SavedStateKt")
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
final /* synthetic */ class SavedStateKt__SavedState_androidKt {
    public static final Bundle savedState(Map<String, ? extends Object> map, Function1<? super SavedStateWriter, Unit> function1) {
        Pair[] pairArr;
        Intrinsics.checkNotNullParameter(map, "initialState");
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        if (map.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                arrayList.add(TuplesKt.to(entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        function1.invoke(SavedStateWriter.m3108boximpl(SavedStateWriter.m3110constructorimpl(bundleOf)));
        return bundleOf;
    }

    public static final Bundle savedState(Bundle bundle, Function1<? super SavedStateWriter, Unit> function1) {
        Intrinsics.checkNotNullParameter(bundle, "initialState");
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        Bundle bundle2 = new Bundle(bundle);
        function1.invoke(SavedStateWriter.m3108boximpl(SavedStateWriter.m3110constructorimpl(bundle2)));
        return bundle2;
    }

    public static /* synthetic */ Bundle savedState$default(Bundle bundle, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<SavedStateWriter, Unit>() { // from class: androidx.savedstate.SavedStateKt__SavedState_androidKt$savedState$3
                /* renamed from: invoke-xApjlu4, reason: not valid java name */
                public final void m3021invokexApjlu4(Bundle bundle2) {
                    Intrinsics.checkNotNullParameter(bundle2, "<this>");
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    m3021invokexApjlu4(((SavedStateWriter) obj2).getSource());
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(bundle, "initialState");
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        Bundle bundle2 = new Bundle(bundle);
        function1.invoke(SavedStateWriter.m3108boximpl(SavedStateWriter.m3110constructorimpl(bundle2)));
        return bundle2;
    }

    public static /* synthetic */ Bundle savedState$default(Map map, Function1 function1, int i, Object obj) {
        Pair[] pairArr;
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i & 2) != 0) {
            function1 = new Function1<SavedStateWriter, Unit>() { // from class: androidx.savedstate.SavedStateKt__SavedState_androidKt$savedState$1
                /* renamed from: invoke-xApjlu4, reason: not valid java name */
                public final void m3020invokexApjlu4(Bundle bundle) {
                    Intrinsics.checkNotNullParameter(bundle, "<this>");
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    m3020invokexApjlu4(((SavedStateWriter) obj2).getSource());
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(map, "initialState");
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        if (map.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(TuplesKt.to((String) entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        function1.invoke(SavedStateWriter.m3108boximpl(SavedStateWriter.m3110constructorimpl(bundleOf)));
        return bundleOf;
    }
}
