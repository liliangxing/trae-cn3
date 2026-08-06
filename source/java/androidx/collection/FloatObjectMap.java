package androidx.collection;

import androidx.autofill.HintConstants;
import androidx.collection.internal.ContainerHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FloatObjectMap.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J&\u0010\u0018\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\u001bH\u0086\bø\u0001\u0000J\u0006\u0010\u001d\u001a\u00020\u0019J&\u0010\u001d\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\u001bH\u0086\bø\u0001\u0000J\u0011\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001cH\u0086\nJ\u000e\u0010 \u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001cJ\u0013\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00028\u0000¢\u0006\u0002\u0010#J\u0006\u0010$\u001a\u00020\u0005J&\u0010$\u001a\u00020\u00052\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\u001bH\u0086\bø\u0001\u0000J\u0013\u0010%\u001a\u00020\u00192\b\u0010&\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0016\u0010'\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001cH\u0080\b¢\u0006\u0002\b(JD\u0010)\u001a\u00020*26\u0010+\u001a2\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020*0\u001bH\u0086\bø\u0001\u0000J/\u0010.\u001a\u00020*2!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020*0/H\u0081\bø\u0001\u0000J/\u00101\u001a\u00020*2!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020*0/H\u0086\bø\u0001\u0000J/\u00102\u001a\u00020*2!\u0010+\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020*0/H\u0086\bø\u0001\u0000J\u0018\u00103\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001f\u001a\u00020\u001cH\u0086\u0002¢\u0006\u0002\u00104J\u001b\u00105\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u00106\u001a\u00028\u0000¢\u0006\u0002\u00107J'\u00108\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u001c2\f\u00106\u001a\b\u0012\u0004\u0012\u00028\u000009H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010:J\b\u0010;\u001a\u00020\u0005H\u0016J\u0006\u0010<\u001a\u00020\u0019J\u0006\u0010=\u001a\u00020\u0019J:\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020A2\b\b\u0002\u0010C\u001a\u00020A2\b\b\u0002\u0010D\u001a\u00020\u00052\b\b\u0002\u0010E\u001a\u00020AH\u0007Jx\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020A2\b\b\u0002\u0010C\u001a\u00020A2\b\b\u0002\u0010D\u001a\u00020\u00052\b\b\u0002\u0010E\u001a\u00020A28\b\u0004\u0010F\u001a2\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020A0\u001bH\u0087\bø\u0001\u0000J\u0006\u0010G\u001a\u00020\u0019J\b\u0010H\u001a\u00020?H\u0016R\u0018\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u0018\u0010\u0007\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\u0011\u0010\t\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u00020\r8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0003R\u0018\u0010\u000f\u001a\u00020\u00108\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0003R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000bR\"\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00158\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u0017\u0012\u0004\b\u0016\u0010\u0003\u0082\u0001\u0001I\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006J"}, d2 = {"Landroidx/collection/FloatObjectMap;", "V", "", "()V", "_capacity", "", "get_capacity$collection$annotations", "_size", "get_size$collection$annotations", "capacity", "getCapacity", "()I", "keys", "", "getKeys$annotations", "metadata", "", "getMetadata$annotations", "size", "getSize", "values", "", "getValues$annotations", "[Ljava/lang/Object;", "all", "", "predicate", "Lkotlin/Function2;", "", "any", "contains", "key", "containsKey", "containsValue", "value", "(Ljava/lang/Object;)Z", "count", "equals", "other", "findKeyIndex", "findKeyIndex$collection", "forEach", "", "block", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "forEachIndexed", "Lkotlin/Function1;", "index", "forEachKey", "forEachValue", "get", "(F)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(FLjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(FLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "none", "toString", "Landroidx/collection/MutableFloatObjectMap;", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public abstract class FloatObjectMap<V> {
    public int _capacity;
    public int _size;
    public float[] keys;
    public long[] metadata;
    public Object[] values;

    public /* synthetic */ FloatObjectMap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }

    public static /* synthetic */ void get_capacity$collection$annotations() {
    }

    public static /* synthetic */ void get_size$collection$annotations() {
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final String joinToString(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        return joinToString$default(this, charSequence, null, null, 0, null, 30, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        return joinToString$default(this, charSequence, charSequence2, null, 0, null, 28, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, 0, null, 24, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, i, null, 16, null);
    }

    private FloatObjectMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = FloatSetKt.getEmptyFloatArray();
        this.values = ContainerHelpersKt.EMPTY_OBJECTS;
    }

    /* renamed from: getCapacity, reason: from getter */
    public final int get_capacity() {
        return this._capacity;
    }

    /* renamed from: getSize, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public final boolean any() {
        return this._size != 0;
    }

    public final boolean none() {
        return this._size == 0;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final V getOrElse(float key, Function0<? extends V> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        V v = get(key);
        return v == null ? (V) defaultValue.invoke() : v;
    }

    public final void forEachIndexed(Function1<? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        long[] jArr = this.metadata;
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
                        block.invoke(Integer.valueOf((i << 3) + i3));
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

    public final void forEach(Function2<? super Float, ? super V, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        float[] fArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
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
                        int i4 = (i << 3) + i3;
                        block.invoke(Float.valueOf(fArr[i4]), objArr[i4]);
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

    public final void forEachKey(Function1<? super Float, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        float[] fArr = this.keys;
        long[] jArr = this.metadata;
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
                        block.invoke(Float.valueOf(fArr[(i << 3) + i3]));
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

    public final void forEachValue(Function1<? super V, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
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
                        block.invoke(objArr[(i << 3) + i3]);
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

    public final int count() {
        return get_size();
    }

    public final boolean contains(float key) {
        return containsKey(key);
    }

    public static /* synthetic */ String joinToString$default(FloatObjectMap floatObjectMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i2 & 1) != 0) {
        }
        if ((i2 & 2) != 0) {
        }
        CharSequence charSequence5 = charSequence2;
        if ((i2 & 4) != 0) {
        }
        CharSequence charSequence6 = charSequence3;
        if ((i2 & 8) != 0) {
            i = -1;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
        }
        return floatObjectMap.joinToString(charSequence, charSequence5, charSequence6, i3, charSequence4);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated) {
        float[] fArr;
        float[] fArr2;
        int i;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        float[] fArr3 = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i3 = 0;
            loop0: while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8;
                    int i5 = 8 - ((~(i2 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j & 255) < 128) {
                            int i7 = (i2 << 3) + i6;
                            float f = fArr3[i7];
                            Object obj = objArr[i7];
                            fArr2 = fArr3;
                            if (i3 == limit) {
                                sb.append(truncated);
                                break loop0;
                            }
                            if (i3 != 0) {
                                sb.append(separator);
                            }
                            sb.append(f);
                            sb.append('=');
                            sb.append(obj);
                            i3++;
                            i = 8;
                        } else {
                            fArr2 = fArr3;
                            i = i4;
                        }
                        j >>= i;
                        i6++;
                        i4 = i;
                        fArr3 = fArr2;
                    }
                    fArr = fArr3;
                    if (i5 != i4) {
                        break;
                    }
                } else {
                    fArr = fArr3;
                }
                if (i2 == length) {
                    break;
                }
                i2++;
                fArr3 = fArr;
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }
        sb.append(postfix);
        String sb22 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb22, "toString(...)");
        return sb22;
    }

    public static /* synthetic */ String joinToString$default(FloatObjectMap floatObjectMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function2 function2, int i2, Object obj) {
        long[] jArr;
        long[] jArr2;
        int i3;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        CharSequence charSequence5 = (i2 & 1) != 0 ? ", " : charSequence;
        CharSequence charSequence6 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence7 = (i2 & 4) != 0 ? "" : charSequence3;
        int i4 = (i2 & 8) != 0 ? -1 : i;
        CharSequence charSequence8 = (i2 & 16) != 0 ? "..." : charSequence4;
        Intrinsics.checkNotNullParameter(charSequence5, "separator");
        Intrinsics.checkNotNullParameter(charSequence6, "prefix");
        Intrinsics.checkNotNullParameter(charSequence7, "postfix");
        Intrinsics.checkNotNullParameter(charSequence8, "truncated");
        Intrinsics.checkNotNullParameter(function2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence6);
        float[] fArr = floatObjectMap.keys;
        Object[] objArr = floatObjectMap.values;
        long[] jArr3 = floatObjectMap.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i5 = 0;
            int i6 = 0;
            loop0: while (true) {
                long j = jArr3[i5];
                int i7 = i5;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i8 = 8;
                    int i9 = 8 - ((~(i7 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j & 255) < 128) {
                            int i11 = (i7 << 3) + i10;
                            float f = fArr[i11];
                            Object obj2 = objArr[i11];
                            if (i6 == i4) {
                                sb.append(charSequence8);
                                break loop0;
                            }
                            if (i6 != 0) {
                                sb.append(charSequence5);
                            }
                            jArr2 = jArr3;
                            sb.append((CharSequence) function2.invoke(Float.valueOf(f), obj2));
                            i6++;
                            i3 = 8;
                        } else {
                            jArr2 = jArr3;
                            i3 = i8;
                        }
                        j >>= i3;
                        i10++;
                        i8 = i3;
                        jArr3 = jArr2;
                    }
                    jArr = jArr3;
                    if (i9 != i8) {
                        break;
                    }
                } else {
                    jArr = jArr3;
                }
                if (i7 == length) {
                    break;
                }
                i5 = i7 + 1;
                jArr3 = jArr;
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }
        sb.append(charSequence7);
        String sb22 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb22, "toString(...)");
        return sb22;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, Function2<? super Float, ? super V, ? extends CharSequence> transform) {
        float[] fArr;
        float[] fArr2;
        CharSequence charSequence = separator;
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        Intrinsics.checkNotNullParameter(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        float[] fArr3 = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            loop0: while (true) {
                long j = jArr[i];
                int i3 = i;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i3 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((j & 255) < 128) {
                            int i6 = (i3 << 3) + i5;
                            float f = fArr3[i6];
                            Object obj = objArr[i6];
                            fArr2 = fArr3;
                            if (i2 == limit) {
                                sb.append(truncated);
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb.append(charSequence);
                            }
                            sb.append((CharSequence) transform.invoke(Float.valueOf(f), obj));
                            i2++;
                        } else {
                            fArr2 = fArr3;
                        }
                        j >>= 8;
                        i5++;
                        charSequence = separator;
                        fArr3 = fArr2;
                    }
                    fArr = fArr3;
                    if (i4 != 8) {
                        break;
                    }
                } else {
                    fArr = fArr3;
                }
                if (i3 == length) {
                    break;
                }
                i = i3 + 1;
                charSequence = separator;
                fArr3 = fArr;
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }
        sb.append(postfix);
        String sb22 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb22, "toString(...)");
        return sb22;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0066, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof FloatObjectMap)) {
            return false;
        }
        FloatObjectMap floatObjectMap = (FloatObjectMap) other;
        if (floatObjectMap.get_size() != get_size()) {
            return false;
        }
        float[] fArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            loop0: while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            float f = fArr[i4];
                            Object obj = objArr[i4];
                            if (obj == null) {
                                if (floatObjectMap.get(f) != null || !floatObjectMap.containsKey(f)) {
                                    break loop0;
                                }
                            } else if (!Intrinsics.areEqual(obj, floatObjectMap.get(f))) {
                                return false;
                            }
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
        return true;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        float[] fArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i << 3) + i4;
                            float f = fArr[i5];
                            Object obj = objArr[i5];
                            sb.append(f);
                            sb.append("=");
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb.append(obj);
                            i2++;
                            if (i2 < this._size) {
                                sb.append(", ");
                            }
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        String sb2 = sb.append('}').toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0072, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final V get(float key) {
        int i;
        int hashCode = Float.hashCode(key) * ScatterMapKt.MurmurHashC1;
        int i2 = hashCode ^ (hashCode << 16);
        int i3 = i2 & 127;
        int i4 = this._capacity;
        int i5 = (i2 >>> 7) & i4;
        int i6 = 0;
        loop0: while (true) {
            long[] jArr = this.metadata;
            int i7 = i5 >> 3;
            int i8 = (i5 & 7) << 3;
            long j = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j2 = (i3 * ScatterMapKt.BitmaskLsb) ^ j;
            long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L);
            while (true) {
                if (!(j3 != 0)) {
                    break;
                }
                i = ((Long.numberOfTrailingZeros(j3) >> 3) + i5) & i4;
                if (this.keys[i] == key) {
                    break loop0;
                }
                j3 &= j3 - 1;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
        }
        if (i >= 0) {
            return (V) this.values[i];
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0072, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final V getOrDefault(float key, V defaultValue) {
        int i;
        int hashCode = Float.hashCode(key) * ScatterMapKt.MurmurHashC1;
        int i2 = hashCode ^ (hashCode << 16);
        int i3 = i2 & 127;
        int i4 = this._capacity;
        int i5 = (i2 >>> 7) & i4;
        int i6 = 0;
        loop0: while (true) {
            long[] jArr = this.metadata;
            int i7 = i5 >> 3;
            int i8 = (i5 & 7) << 3;
            long j = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j2 = (i3 * ScatterMapKt.BitmaskLsb) ^ j;
            long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L);
            while (true) {
                if (!(j3 != 0)) {
                    break;
                }
                i = ((Long.numberOfTrailingZeros(j3) >> 3) + i5) & i4;
                if (this.keys[i] == key) {
                    break loop0;
                }
                j3 &= j3 - 1;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
        }
        return i >= 0 ? (V) this.values[i] : defaultValue;
    }

    public final boolean all(Function2<? super Float, ? super V, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        float[] fArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            if (!((Boolean) predicate.invoke(Float.valueOf(fArr[i4]), objArr[i4])).booleanValue()) {
                                return false;
                            }
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
        return true;
    }

    public final boolean any(Function2<? super Float, ? super V, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        float[] fArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            if (((Boolean) predicate.invoke(Float.valueOf(fArr[i4]), objArr[i4])).booleanValue()) {
                                return true;
                            }
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
        return false;
    }

    public final int count(Function2<? super Float, ? super V, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        float[] fArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        int i = 0;
        if (length >= 0) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j) < 128) {
                            int i6 = (i2 << 3) + i5;
                            if (((Boolean) predicate.invoke(Float.valueOf(fArr[i6]), objArr[i6])).booleanValue()) {
                                i3++;
                            }
                        }
                        j >>= 8;
                    }
                    if (i4 != 8) {
                        return i3;
                    }
                }
                if (i2 == length) {
                    i = i3;
                    break;
                }
                i2++;
            }
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0072, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean containsKey(float key) {
        int i;
        int hashCode = Float.hashCode(key) * ScatterMapKt.MurmurHashC1;
        int i2 = hashCode ^ (hashCode << 16);
        int i3 = i2 & 127;
        int i4 = this._capacity;
        int i5 = (i2 >>> 7) & i4;
        int i6 = 0;
        loop0: while (true) {
            long[] jArr = this.metadata;
            int i7 = i5 >> 3;
            int i8 = (i5 & 7) << 3;
            long j = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j2 = (i3 * ScatterMapKt.BitmaskLsb) ^ j;
            long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L);
            while (true) {
                if (!(j3 != 0)) {
                    break;
                }
                i = ((Long.numberOfTrailingZeros(j3) >> 3) + i5) & i4;
                if (this.keys[i] == key) {
                    break loop0;
                }
                j3 &= j3 - 1;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
        }
        return i >= 0;
    }

    public final boolean containsValue(V value) {
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if (((255 & j) < 128) && Intrinsics.areEqual(value, objArr[(i << 3) + i3])) {
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
        return false;
    }

    public int hashCode() {
        float[] fArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        int i = 0;
        if (length >= 0) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j) < 128) {
                            int i6 = (i2 << 3) + i5;
                            float f = fArr[i6];
                            Object obj = objArr[i6];
                            i3 += (obj != null ? obj.hashCode() : 0) ^ Float.hashCode(f);
                        }
                        j >>= 8;
                    }
                    if (i4 != 8) {
                        return i3;
                    }
                }
                if (i2 == length) {
                    i = i3;
                    break;
                }
                i2++;
            }
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0070, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0072, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int findKeyIndex$collection(float key) {
        int hashCode = Float.hashCode(key) * ScatterMapKt.MurmurHashC1;
        int i = hashCode ^ (hashCode << 16);
        int i2 = i & 127;
        int i3 = this._capacity;
        int i4 = (i >>> 7) & i3;
        int i5 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i6 = i4 >> 3;
            int i7 = (i4 & 7) << 3;
            long j = ((jArr[i6 + 1] << (64 - i7)) & ((-i7) >> 63)) | (jArr[i6] >>> i7);
            long j2 = (i2 * ScatterMapKt.BitmaskLsb) ^ j;
            long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L);
            while (true) {
                if (!(j3 != 0)) {
                    break;
                }
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i4) & i3;
                if (this.keys[numberOfTrailingZeros] == key) {
                    return numberOfTrailingZeros;
                }
                j3 &= j3 - 1;
            }
            i5 += 8;
            i4 = (i4 + i5) & i3;
        }
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Function2<? super Float, ? super V, ? extends CharSequence> function2) {
        float[] fArr;
        float[] fArr2;
        CharSequence charSequence4 = charSequence;
        Intrinsics.checkNotNullParameter(charSequence4, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(function2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        float[] fArr3 = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i3 = 0;
            loop0: while (true) {
                long j = jArr[i2];
                int i4 = i2;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8 - ((~(i4 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j & 255) < 128) {
                            int i7 = (i4 << 3) + i6;
                            float f = fArr3[i7];
                            Object obj = objArr[i7];
                            fArr2 = fArr3;
                            if (i3 == i) {
                                sb.append((CharSequence) r5);
                                break loop0;
                            }
                            if (i3 != 0) {
                                sb.append(charSequence4);
                            }
                            sb.append((CharSequence) function2.invoke(Float.valueOf(f), obj));
                            i3++;
                        } else {
                            fArr2 = fArr3;
                        }
                        j >>= 8;
                        i6++;
                        charSequence4 = charSequence;
                        fArr3 = fArr2;
                    }
                    fArr = fArr3;
                    if (i5 != 8) {
                        break;
                    }
                } else {
                    fArr = fArr3;
                }
                if (i4 == length) {
                    break;
                }
                i2 = i4 + 1;
                charSequence4 = charSequence;
                fArr3 = fArr;
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }
        sb.append(charSequence3);
        String sb22 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb22, "toString(...)");
        return sb22;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Function2<? super Float, ? super V, ? extends CharSequence> function2) {
        float[] fArr;
        float[] fArr2;
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(function2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        float[] fArr3 = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            loop0: while (true) {
                long j = jArr[i];
                int i3 = i;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i3 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((j & 255) < 128) {
                            int i6 = (i3 << 3) + i5;
                            float f = fArr3[i6];
                            Object obj = objArr[i6];
                            fArr2 = fArr3;
                            if (i2 == -1) {
                                sb.append((CharSequence) r5);
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb.append(charSequence);
                            }
                            sb.append((CharSequence) function2.invoke(Float.valueOf(f), obj));
                            i2++;
                        } else {
                            fArr2 = fArr3;
                        }
                        j >>= 8;
                        i5++;
                        fArr3 = fArr2;
                    }
                    fArr = fArr3;
                    if (i4 != 8) {
                        break;
                    }
                } else {
                    fArr = fArr3;
                }
                if (i3 == length) {
                    break;
                }
                i = i3 + 1;
                fArr3 = fArr;
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }
        sb.append(charSequence3);
        String sb22 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb22, "toString(...)");
        return sb22;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, Function2<? super Float, ? super V, ? extends CharSequence> function2) {
        float[] fArr;
        float[] fArr2;
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(function2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        float[] fArr3 = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            loop0: while (true) {
                long j = jArr[i];
                int i3 = i;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i3 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((j & 255) < 128) {
                            int i6 = (i3 << 3) + i5;
                            float f = fArr3[i6];
                            Object obj = objArr[i6];
                            fArr2 = fArr3;
                            if (i2 == -1) {
                                sb.append((CharSequence) r5);
                                break loop0;
                            }
                            if (i2 != 0) {
                                sb.append(charSequence);
                            }
                            sb.append((CharSequence) function2.invoke(Float.valueOf(f), obj));
                            i2++;
                        } else {
                            fArr2 = fArr3;
                        }
                        j >>= 8;
                        i5++;
                        fArr3 = fArr2;
                    }
                    fArr = fArr3;
                    if (i4 != 8) {
                        break;
                    }
                } else {
                    fArr = fArr3;
                }
                if (i3 == length) {
                    break;
                }
                i = i3 + 1;
                fArr3 = fArr;
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }
        sb.append((CharSequence) r4);
        String sb22 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb22, "toString(...)");
        return sb22;
    }

    public final String joinToString(CharSequence charSequence, Function2<? super Float, ? super V, ? extends CharSequence> function2) {
        int i;
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(function2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        float[] fArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i3 = 0;
            loop0: while (true) {
                long j = jArr[i2];
                int i4 = i2;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i4 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            int i8 = (i4 << 3) + i7;
                            float f = fArr[i8];
                            Object obj = objArr[i8];
                            if (i3 == -1) {
                                sb.append((CharSequence) r5);
                                break loop0;
                            }
                            if (i3 != 0) {
                                sb.append(charSequence);
                            }
                            sb.append((CharSequence) function2.invoke(Float.valueOf(f), obj));
                            i3++;
                            i = 8;
                        } else {
                            i = i5;
                        }
                        j >>= i;
                        i7++;
                        i5 = i;
                    }
                    if (i6 != i5) {
                        break;
                    }
                }
                if (i4 == length) {
                    break;
                }
                i2 = i4 + 1;
            }
        }
        sb.append((CharSequence) r3);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final String joinToString(Function2<? super Float, ? super V, ? extends CharSequence> function2) {
        int i;
        Intrinsics.checkNotNullParameter(function2, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        float[] fArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i3 = 0;
            loop0: while (true) {
                long j = jArr[i2];
                int i4 = i2;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i4 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            int i8 = (i4 << 3) + i7;
                            float f = fArr[i8];
                            Object obj = objArr[i8];
                            if (i3 == -1) {
                                sb.append((CharSequence) r5);
                                break loop0;
                            }
                            if (i3 != 0) {
                                sb.append((CharSequence) r2);
                            }
                            sb.append((CharSequence) function2.invoke(Float.valueOf(f), obj));
                            i3++;
                            i = 8;
                        } else {
                            i = i5;
                        }
                        j >>= i;
                        i7++;
                        i5 = i;
                    }
                    if (i6 != i5) {
                        break;
                    }
                }
                if (i4 == length) {
                    break;
                }
                i2 = i4 + 1;
            }
        }
        sb.append((CharSequence) r3);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
