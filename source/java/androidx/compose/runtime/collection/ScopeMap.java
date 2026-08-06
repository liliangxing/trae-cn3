package androidx.compose.runtime.collection;

import androidx.autofill.HintConstants;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScopeMap.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u001d\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0001¢\u0006\u0004\b\u0016\u0010\u0013J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ;\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000f0\u001eH\u0086\b¢\u0006\u0004\b!\u0010\"J;\u0010#\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00028\u00002!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00180\u001eH\u0086\b¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u000f¢\u0006\u0004\b'\u0010(J\u001d\u0010)\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001¢\u0006\u0004\b*\u0010+J5\u0010,\u001a\u00020\u000f2#\b\u0004\u0010-\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00180\u001eH\u0086\b¢\u0006\u0004\b.\u0010/J*\u00100\u001a\u00020\u000f2\u0018\u0010-\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u001801H\u0086\b¢\u0006\u0004\b2\u00103J\u0015\u00104\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00028\u0001¢\u0006\u0004\b5\u00106J\u001f\u00107\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010908¢\u0006\u0004\b:\u0010;J\u0013\u0010<\u001a\u00020\u00182\b\u0010=\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010>\u001a\u00020\u000bHÖ\u0001J\t\u0010?\u001a\u00020@HÖ\u0001R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0088\u0001\u0004¨\u0006A"}, d2 = {"Landroidx/compose/runtime/collection/ScopeMap;", "Key", "", "Scope", "map", "Landroidx/collection/MutableScatterMap;", "constructor-impl", "(Landroidx/collection/MutableScatterMap;)Landroidx/collection/MutableScatterMap;", "getMap", "()Landroidx/collection/MutableScatterMap;", "size", "", "getSize-impl", "(Landroidx/collection/MutableScatterMap;)I", "add", "", "key", "scope", "add-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Ljava/lang/Object;)V", "set", "value", "set-impl", "contains", "", "element", "contains-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Z", "forEachScopeOf", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "forEachScopeOf-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "anyScopeOf", "anyScopeOf-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "clear", "clear-impl", "(Landroidx/collection/MutableScatterMap;)V", "remove", "remove-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Ljava/lang/Object;)Z", "removeScopeIf", "predicate", "removeScopeIf-impl", "(Landroidx/collection/MutableScatterMap;Lkotlin/jvm/functions/Function1;)V", "removeIf", "Lkotlin/Function2;", "removeIf-impl", "(Landroidx/collection/MutableScatterMap;Lkotlin/jvm/functions/Function2;)V", "removeScope", "removeScope-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)V", "asMap", "", "", "asMap-impl", "(Landroidx/collection/MutableScatterMap;)Ljava/util/Map;", "equals", "other", "hashCode", "toString", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ScopeMap<Key, Scope> {
    private final MutableScatterMap<Object, Object> map;

    /* renamed from: box-impl */
    public static final /* synthetic */ ScopeMap m4208boximpl(MutableScatterMap mutableScatterMap) {
        return new ScopeMap(mutableScatterMap);
    }

    /* renamed from: constructor-impl */
    public static <Key, Scope> MutableScatterMap<Object, Object> m4210constructorimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap;
    }

    /* renamed from: equals-impl */
    public static boolean m4213equalsimpl(MutableScatterMap<Object, Object> mutableScatterMap, Object obj) {
        return (obj instanceof ScopeMap) && Intrinsics.areEqual(mutableScatterMap, ((ScopeMap) obj).getMap());
    }

    /* renamed from: equals-impl0 */
    public static final boolean m4214equalsimpl0(MutableScatterMap<Object, Object> mutableScatterMap, MutableScatterMap<Object, Object> mutableScatterMap2) {
        return Intrinsics.areEqual(mutableScatterMap, mutableScatterMap2);
    }

    /* renamed from: hashCode-impl */
    public static int m4217hashCodeimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap.hashCode();
    }

    /* renamed from: toString-impl */
    public static String m4223toStringimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return "ScopeMap(map=" + mutableScatterMap + ')';
    }

    public boolean equals(Object other) {
        return m4213equalsimpl(this.map, other);
    }

    public int hashCode() {
        return m4217hashCodeimpl(this.map);
    }

    public String toString() {
        return m4223toStringimpl(this.map);
    }

    /* renamed from: unbox-impl, reason: from getter */
    public final /* synthetic */ MutableScatterMap getMap() {
        return this.map;
    }

    private /* synthetic */ ScopeMap(MutableScatterMap mutableScatterMap) {
        this.map = mutableScatterMap;
    }

    /* renamed from: constructor-impl$default */
    public static /* synthetic */ MutableScatterMap m4211constructorimpl$default(MutableScatterMap mutableScatterMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            mutableScatterMap = ScatterMapKt.mutableScatterMapOf();
        }
        return m4210constructorimpl(mutableScatterMap);
    }

    public final MutableScatterMap<Object, Object> getMap() {
        return this.map;
    }

    /* renamed from: getSize-impl */
    public static final int m4216getSizeimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap.get_size();
    }

    /* renamed from: set-impl */
    public static final void m4222setimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key, Scope scope) {
        mutableScatterMap.set(key, scope);
    }

    /* renamed from: contains-impl */
    public static final boolean m4212containsimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key) {
        return mutableScatterMap.containsKey(key);
    }

    /* renamed from: forEachScopeOf-impl */
    public static final void m4215forEachScopeOfimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key, Function1<? super Scope, Unit> function1) {
        Object obj = mutableScatterMap.get(key);
        if (obj == null) {
            return;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            function1.invoke(objArr[(i << 3) + i3]);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        } else {
            function1.invoke(obj);
        }
    }

    /* renamed from: clear-impl */
    public static final void m4209clearimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        mutableScatterMap.clear();
    }

    /* renamed from: remove-impl */
    public static final boolean m4218removeimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key, Scope scope) {
        Object obj = mutableScatterMap.get(key);
        if (obj == null) {
            return false;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            boolean remove = mutableScatterSet.remove(scope);
            if (remove && mutableScatterSet.isEmpty()) {
                mutableScatterMap.remove(key);
            }
            return remove;
        }
        if (!Intrinsics.areEqual(obj, scope)) {
            return false;
        }
        mutableScatterMap.remove(key);
        return true;
    }

    /* renamed from: asMap-impl */
    public static final Map<Key, Set<Scope>> m4207asMapimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        Set mutableSetOf;
        HashMap hashMap = new HashMap();
        MutableScatterMap<Object, Object> mutableScatterMap2 = mutableScatterMap;
        Object[] objArr = mutableScatterMap2.keys;
        Object[] objArr2 = mutableScatterMap2.values;
        long[] jArr = mutableScatterMap2.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8;
                    int i3 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i << 3) + i4;
                            Object obj = objArr[i5];
                            Object obj2 = objArr2[i5];
                            HashMap hashMap2 = hashMap;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                mutableSetOf = ((MutableScatterSet) obj2).asSet();
                            } else {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                mutableSetOf = SetsKt.mutableSetOf(new Object[]{obj2});
                            }
                            hashMap2.put(obj, mutableSetOf);
                            i2 = 8;
                        }
                        j >>= i2;
                    }
                    if (i3 != i2) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r6v1, types: [androidx.collection.MutableScatterSet] */
    /* renamed from: add-impl */
    public static final void m4205addimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key, Scope scope) {
        int findInsertIndex = mutableScatterMap.findInsertIndex(key);
        boolean z = findInsertIndex < 0;
        Scope scope2 = z ? null : mutableScatterMap.values[findInsertIndex];
        if (scope2 != null) {
            if (scope2 instanceof MutableScatterSet) {
                Intrinsics.checkNotNull(scope2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                ((MutableScatterSet) scope2).add(scope);
            } else if (scope2 != scope) {
                ?? mutableScatterSet = new MutableScatterSet(0, 1, null);
                Intrinsics.checkNotNull(scope2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                mutableScatterSet.add(scope2);
                mutableScatterSet.add(scope);
                scope = mutableScatterSet;
            }
            scope = scope2;
        }
        if (z) {
            int i = ~findInsertIndex;
            mutableScatterMap.keys[i] = key;
            mutableScatterMap.values[i] = scope;
            return;
        }
        mutableScatterMap.values[findInsertIndex] = scope;
    }

    /* renamed from: anyScopeOf-impl */
    public static final boolean m4206anyScopeOfimpl(MutableScatterMap<Object, Object> mutableScatterMap, Key key, Function1<? super Scope, Boolean> function1) {
        Object obj = mutableScatterMap.get(key);
        if (obj != null) {
            if (obj instanceof MutableScatterSet) {
                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
                Object[] objArr = mutableScatterSet.elements;
                long[] jArr = mutableScatterSet.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        long j = jArr[i];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            for (int i3 = 0; i3 < i2; i3++) {
                                if (((255 & j) < 128) && ((Boolean) function1.invoke(objArr[(i << 3) + i3])).booleanValue()) {
                                    return true;
                                }
                                j >>= 8;
                            }
                            if (i2 != 8) {
                                break;
                            }
                        }
                        if (i == length) {
                            break;
                        }
                        i++;
                    }
                }
            } else if (((Boolean) function1.invoke(obj)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: removeScopeIf-impl */
    public static final void m4221removeScopeIfimpl(MutableScatterMap<Object, Object> mutableScatterMap, Function1<? super Scope, Boolean> function1) {
        long[] jArr;
        int i;
        long[] jArr2;
        int i2;
        int i3;
        int i4;
        long j;
        int i5;
        boolean booleanValue;
        int i6;
        long[] jArr3 = mutableScatterMap.metadata;
        int length = jArr3.length - 2;
        if (length < 0) {
            return;
        }
        int i7 = 0;
        while (true) {
            long j2 = jArr3[i7];
            char c = 7;
            long j3 = -9187201950435737472L;
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i8 = 8;
                int i9 = 8 - ((~(i7 - length)) >>> 31);
                int i10 = 0;
                while (i10 < i9) {
                    if ((j2 & 255) < 128) {
                        int i11 = (i7 << 3) + i10;
                        Object obj = mutableScatterMap.keys[i11];
                        Object obj2 = mutableScatterMap.values[i11];
                        if (obj2 instanceof MutableScatterSet) {
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                            Object[] objArr = mutableScatterSet.elements;
                            long[] jArr4 = mutableScatterSet.metadata;
                            int length2 = jArr4.length - 2;
                            jArr2 = jArr3;
                            i2 = length;
                            if (length2 >= 0) {
                                int i12 = 0;
                                while (true) {
                                    long j4 = jArr4[i12];
                                    i4 = i9;
                                    long[] jArr5 = jArr4;
                                    j = -9187201950435737472L;
                                    if ((((~j4) << c) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i13 = 8 - ((~(i12 - length2)) >>> 31);
                                        int i14 = 0;
                                        while (i14 < i13) {
                                            if ((j4 & 255) < 128) {
                                                int i15 = (i12 << 3) + i14;
                                                i6 = i7;
                                                if (((Boolean) function1.invoke(objArr[i15])).booleanValue()) {
                                                    mutableScatterSet.removeElementAt(i15);
                                                }
                                            } else {
                                                i6 = i7;
                                            }
                                            j4 >>= 8;
                                            i14++;
                                            i7 = i6;
                                        }
                                        i3 = i7;
                                        if (i13 != 8) {
                                            break;
                                        }
                                    } else {
                                        i3 = i7;
                                    }
                                    if (i12 == length2) {
                                        break;
                                    }
                                    i12++;
                                    i9 = i4;
                                    jArr4 = jArr5;
                                    i7 = i3;
                                    c = 7;
                                }
                            } else {
                                i3 = i7;
                                i4 = i9;
                                j = -9187201950435737472L;
                            }
                            booleanValue = mutableScatterSet.isEmpty();
                        } else {
                            jArr2 = jArr3;
                            i2 = length;
                            i3 = i7;
                            i4 = i9;
                            j = j3;
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                            booleanValue = ((Boolean) function1.invoke(obj2)).booleanValue();
                        }
                        if (booleanValue) {
                            mutableScatterMap.removeValueAt(i11);
                        }
                        i5 = 8;
                    } else {
                        jArr2 = jArr3;
                        i2 = length;
                        i3 = i7;
                        i4 = i9;
                        j = j3;
                        i5 = i8;
                    }
                    j2 >>= i5;
                    i10++;
                    i8 = i5;
                    j3 = j;
                    jArr3 = jArr2;
                    length = i2;
                    i9 = i4;
                    i7 = i3;
                    c = 7;
                }
                jArr = jArr3;
                int i16 = length;
                int i17 = i7;
                if (i9 != i8) {
                    return;
                }
                length = i16;
                i = i17;
            } else {
                jArr = jArr3;
                i = i7;
            }
            if (i == length) {
                return;
            }
            i7 = i + 1;
            jArr3 = jArr;
        }
    }

    /* renamed from: removeIf-impl */
    public static final void m4219removeIfimpl(MutableScatterMap<Object, Object> mutableScatterMap, Function2<? super Key, ? super Scope, Boolean> function2) {
        long[] jArr;
        int i;
        long[] jArr2;
        int i2;
        int i3;
        long j;
        long j2;
        int i4;
        boolean booleanValue;
        long[] jArr3;
        long[] jArr4;
        long[] jArr5 = mutableScatterMap.metadata;
        int length = jArr5.length - 2;
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            long j3 = jArr5[i5];
            long j4 = -9187201950435737472L;
            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8;
                int i7 = 8 - ((~(i5 - length)) >>> 31);
                int i8 = 0;
                while (i8 < i7) {
                    if ((j3 & 255) < 128) {
                        int i9 = (i5 << 3) + i8;
                        Object obj = mutableScatterMap.keys[i9];
                        Object obj2 = mutableScatterMap.values[i9];
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                        if (obj2 instanceof MutableScatterSet) {
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                            Object[] objArr = mutableScatterSet.elements;
                            long[] jArr6 = mutableScatterSet.metadata;
                            int length2 = jArr6.length - 2;
                            jArr2 = jArr5;
                            i2 = length;
                            if (length2 >= 0) {
                                int i10 = 0;
                                while (true) {
                                    long j5 = jArr6[i10];
                                    i3 = i5;
                                    j = j3;
                                    j2 = -9187201950435737472L;
                                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i11 = 8 - ((~(i10 - length2)) >>> 31);
                                        int i12 = 0;
                                        while (i12 < i11) {
                                            if ((j5 & 255) < 128) {
                                                int i13 = (i10 << 3) + i12;
                                                jArr4 = jArr6;
                                                if (((Boolean) function2.invoke(obj, objArr[i13])).booleanValue()) {
                                                    mutableScatterSet.removeElementAt(i13);
                                                }
                                            } else {
                                                jArr4 = jArr6;
                                            }
                                            j5 >>= 8;
                                            i12++;
                                            jArr6 = jArr4;
                                        }
                                        jArr3 = jArr6;
                                        if (i11 != 8) {
                                            break;
                                        }
                                    } else {
                                        jArr3 = jArr6;
                                    }
                                    if (i10 == length2) {
                                        break;
                                    }
                                    i10++;
                                    jArr6 = jArr3;
                                    i5 = i3;
                                    j3 = j;
                                }
                            } else {
                                i3 = i5;
                                j = j3;
                                j2 = -9187201950435737472L;
                            }
                            booleanValue = mutableScatterSet.isEmpty();
                        } else {
                            jArr2 = jArr5;
                            i2 = length;
                            i3 = i5;
                            j = j3;
                            j2 = j4;
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                            booleanValue = ((Boolean) function2.invoke(obj, obj2)).booleanValue();
                        }
                        if (booleanValue) {
                            mutableScatterMap.removeValueAt(i9);
                        }
                        i4 = 8;
                    } else {
                        jArr2 = jArr5;
                        i2 = length;
                        i3 = i5;
                        j = j3;
                        j2 = j4;
                        i4 = i6;
                    }
                    j3 = j >> i4;
                    i8++;
                    i6 = i4;
                    j4 = j2;
                    jArr5 = jArr2;
                    length = i2;
                    i5 = i3;
                }
                jArr = jArr5;
                int i14 = length;
                int i15 = i5;
                if (i7 != i6) {
                    return;
                }
                length = i14;
                i = i15;
            } else {
                jArr = jArr5;
                i = i5;
            }
            if (i == length) {
                return;
            }
            i5 = i + 1;
            jArr5 = jArr;
        }
    }

    /* renamed from: removeScope-impl */
    public static final void m4220removeScopeimpl(MutableScatterMap<Object, Object> mutableScatterMap, Scope scope) {
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    boolean z = true;
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        Object obj = mutableScatterMap.keys[i4];
                        Object obj2 = mutableScatterMap.values[i4];
                        if (obj2 instanceof MutableScatterSet) {
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                            mutableScatterSet.remove(scope);
                            z = mutableScatterSet.isEmpty();
                        } else if (obj2 != scope) {
                            z = false;
                        }
                        if (z) {
                            mutableScatterMap.removeValueAt(i4);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }
}
