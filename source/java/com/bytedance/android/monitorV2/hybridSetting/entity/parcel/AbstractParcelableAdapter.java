package com.bytedance.android.monitorV2.hybridSetting.entity.parcel;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbstractParcelableAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016JL\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\b\"\u0006\b\u0000\u0010\t\u0018\u00012\u0006\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u0002H\t0\rH\u0084\bø\u0001\u0000¢\u0006\u0002\u0010\u0010JE\u0010\u0011\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\u0012\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u0002H\t0\rH\u0084\bø\u0001\u0000J]\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u0015\u0018\u00010\u0014\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u00152\u0006\u0010\n\u001a\u00020\u000b2-\u0010\f\u001a)\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u00150\u00160\rH\u0084\bø\u0001\u0000JE\u0010\u0017\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\u0018\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u0002H\t0\rH\u0084\bø\u0001\u0000JD\u0010\f\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u0002H\t0\rH\u0084\bø\u0001\u0000¢\u0006\u0002\u0010\u001aJg\u0010\u001b\u001a\u00020\u001c\"\u0004\b\u0000\u0010\t2\u0006\u0010\u001d\u001a\u00020\u000b2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\b26\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u0011H\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001c0 H\u0084\bø\u0001\u0000¢\u0006\u0002\u0010!Jb\u0010\"\u001a\u00020\u001c\"\u0004\b\u0000\u0010\t2\u0006\u0010\u001d\u001a\u00020\u000b2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\u001226\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u0011H\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001c0 H\u0084\bø\u0001\u0000Jz\u0010#\u001a\u00020\u001c\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u00152\u0006\u0010\u001d\u001a\u00020\u000b2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u0015\u0018\u00010\u00142B\u0010\u001f\u001a>\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001d\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u00150$¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001c0 H\u0084\bø\u0001\u0000Jb\u0010&\u001a\u00020\u001c\"\u0004\b\u0000\u0010\t2\u0006\u0010\u001d\u001a\u00020\u000b2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\u001826\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u0011H\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001c0 H\u0084\bø\u0001\u0000J\u0086\u0001\u0010\u001f\u001a\u00020\u001c\"\u0004\b\u0000\u0010\t2\u0006\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u0001H\t2#\u0010'\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u0001H\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020(0\r26\u0010)\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u0011H\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001c0 H\u0084\bø\u0001\u0000¢\u0006\u0002\u0010*R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006+"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/entity/parcel/AbstractParcelableAdapter;", "Landroid/os/Parcelable;", "()V", "VALUE_NON_NULL", "", "VALUE_NULL", "describeContents", "readArrayValue", "", ExifInterface.GPS_DIRECTION_TRUE, "source", "Landroid/os/Parcel;", "readValue", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Landroid/os/Parcel;Lkotlin/jvm/functions/Function1;)[Ljava/lang/Object;", "readListValue", "", "readMapValue", "", "R", "Lkotlin/Pair;", "readSetValue", "", "readNonNullValue", "(Landroid/os/Parcel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeArrayValue", "", "dest", "value", "writeValue", "Lkotlin/Function2;", "(Landroid/os/Parcel;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "writeListValue", "writeMapValue", "", "entry", "writeSetValue", "isNull", "", "writeNonNullValue", "(Landroid/os/Parcel;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AbstractParcelableAdapter implements Parcelable {
    public final int VALUE_NON_NULL = 1;
    public final int VALUE_NULL;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected final <T> void writeValue(Parcel dest, T value, Function1<? super T, Boolean> isNull, Function2<? super Parcel, ? super T, Unit> writeNonNullValue) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Intrinsics.checkNotNullParameter(isNull, "isNull");
        Intrinsics.checkNotNullParameter(writeNonNullValue, "writeNonNullValue");
        int i = isNull.invoke(value).booleanValue() ? this.VALUE_NULL : this.VALUE_NON_NULL;
        dest.writeInt(i);
        if (this.VALUE_NON_NULL == i) {
            Intrinsics.checkNotNull(value);
            writeNonNullValue.invoke(dest, value);
        }
    }

    protected final <T> T readValue(Parcel source, Function1<? super Parcel, ? extends T> readNonNullValue) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(readNonNullValue, "readNonNullValue");
        if (this.VALUE_NULL == source.readInt()) {
            return null;
        }
        return readNonNullValue.invoke(source);
    }

    protected final <T> void writeArrayValue(Parcel dest, T[] value, Function2<? super Parcel, ? super T, Unit> writeValue) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Intrinsics.checkNotNullParameter(writeValue, "writeValue");
        int length = value != null ? value.length : 0;
        dest.writeInt(length);
        if (length > 0) {
            Intrinsics.checkNotNull(value);
            for (T t : value) {
                writeValue.invoke(dest, t);
            }
        }
    }

    protected final /* synthetic */ <T> T[] readArrayValue(Parcel source, Function1<? super Parcel, ? extends T> readValue) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(readValue, "readValue");
        int readInt = source.readInt();
        if (readInt == 0) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(0, "T?");
        T[] tArr = (T[]) new Object[readInt];
        for (int i = 0; i < readInt; i++) {
            tArr[i] = readValue.invoke(source);
        }
        return tArr;
    }

    protected final <T, R> void writeMapValue(Parcel dest, Map<T, ? extends R> value, Function2<? super Parcel, ? super Map.Entry<? extends T, ? extends R>, Unit> writeValue) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Intrinsics.checkNotNullParameter(writeValue, "writeValue");
        int size = value != null ? value.size() : 0;
        dest.writeInt(size);
        if (size > 0) {
            Intrinsics.checkNotNull(value);
            Iterator<T> it = value.entrySet().iterator();
            while (it.hasNext()) {
                writeValue.invoke(dest, (Map.Entry) it.next());
            }
        }
    }

    protected final <T, R> Map<T, R> readMapValue(Parcel source, Function1<? super Parcel, ? extends Pair<? extends T, ? extends R>> readValue) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(readValue, "readValue");
        int readInt = source.readInt();
        if (readInt == 0) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < readInt; i++) {
            Pair<? extends T, ? extends R> invoke = readValue.invoke(source);
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    protected final <T> void writeSetValue(Parcel dest, Set<? extends T> value, Function2<? super Parcel, ? super T, Unit> writeValue) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Intrinsics.checkNotNullParameter(writeValue, "writeValue");
        int size = value != null ? value.size() : 0;
        dest.writeInt(size);
        if (size > 0) {
            Intrinsics.checkNotNull(value);
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                writeValue.invoke(dest, it.next());
            }
        }
    }

    protected final <T> Set<T> readSetValue(Parcel source, Function1<? super Parcel, ? extends T> readValue) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(readValue, "readValue");
        int readInt = source.readInt();
        if (readInt == 0) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i = 0; i < readInt; i++) {
            linkedHashSet.add(readValue.invoke(source));
        }
        return linkedHashSet;
    }

    protected final <T> void writeListValue(Parcel dest, List<? extends T> value, Function2<? super Parcel, ? super T, Unit> writeValue) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Intrinsics.checkNotNullParameter(writeValue, "writeValue");
        int size = value != null ? value.size() : 0;
        dest.writeInt(size);
        if (size > 0) {
            Intrinsics.checkNotNull(value);
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                writeValue.invoke(dest, it.next());
            }
        }
    }

    protected final <T> List<T> readListValue(Parcel source, Function1<? super Parcel, ? extends T> readValue) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(readValue, "readValue");
        int readInt = source.readInt();
        if (readInt == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readInt; i++) {
            arrayList.add(readValue.invoke(source));
        }
        return arrayList;
    }
}
