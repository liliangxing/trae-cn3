package com.huawei.hms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import com.huawei.hms.common.sqlite.HMSCursorWrapper;
import com.huawei.hms.support.log.HMSLog;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    private static final String TAG = "DataHolder";
    public static final String TYPE_BOOLEAN = "type_boolean";
    public static final String TYPE_BYTE_ARRAY = "type_byte_array";
    public static final String TYPE_DOUBLE = "type_double";
    public static final String TYPE_FLOAT = "type_float";
    public static final String TYPE_INT = "type_int";
    public static final String TYPE_LONG = "type_long";
    public static final String TYPE_STRING = "type_string";
    private String[] columns;
    private Bundle columnsBundle;
    private CursorWindow[] cursorWindows;
    private int dataCount;
    private boolean isInstance;
    private boolean mClosed;
    private Bundle metadata;
    private int[] perCursorCounts;
    private int statusCode;
    private int version;
    public static final Parcelable.Creator<DataHolder> CREATOR = new DataHolderCreator();
    private static final Builder BUILDER = new DataHolderBuilderCreator(new String[0], null);

    /* loaded from: classes6.dex */
    public static class Builder {
        private String[] a;
        private final ArrayList<HashMap<String, Object>> b;
        private final String c;
        private final HashMap<Object, Integer> d;

        /* JADX WARN: Multi-variable type inference failed */
        public DataHolder build(int i) {
            return new DataHolder(this, i, (Bundle) null);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder setDataForContentValuesHashMap(HashMap<String, Object> hashMap) {
            int i;
            boolean z;
            Object obj;
            Preconditions.checkNotNull(hashMap, "contentValuesHashMap cannot be null");
            String str = this.c;
            if (str != null && (obj = hashMap.get(str)) != null) {
                Integer num = this.d.get(obj);
                if (num != null) {
                    i = num.intValue();
                    z = true;
                    if (!z) {
                        this.b.remove(i);
                        this.b.add(i, hashMap);
                    } else {
                        this.b.add(hashMap);
                    }
                    return this;
                }
                this.d.put(obj, Integer.valueOf(this.b.size()));
            }
            i = 0;
            z = false;
            if (!z) {
            }
            return this;
        }

        public Builder withRow(ContentValues contentValues) {
            Preconditions.checkNotNull(contentValues, "contentValues cannot be null");
            HashMap<String, Object> hashMap = new HashMap<>(contentValues.size());
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            return setDataForContentValuesHashMap(hashMap);
        }

        private Builder(String[] strArr, String str) {
            Preconditions.checkNotNull(strArr, "builderColumnsP cannot be null");
            this.a = strArr;
            this.b = new ArrayList<>();
            this.c = str;
            this.d = new HashMap<>();
        }

        public DataHolder build(int i, Bundle bundle) {
            return new DataHolder(this, i, bundle, -1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(String[] strArr, String str, DataHolderBuilderCreator dataHolderBuilderCreator) {
            this(strArr, null);
        }
    }

    /* loaded from: classes6.dex */
    public static class DataHolderException extends RuntimeException {
        public DataHolderException(String str) {
            super(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder builder(String[] strArr) {
        return new Builder(strArr, (String) null);
    }

    public static DataHolder empty(int i) {
        return new DataHolder(BUILDER, i, (Bundle) null);
    }

    private static CursorWindow[] getCursorWindows(HMSCursorWrapper hMSCursorWrapper) {
        int i;
        ArrayList arrayList = new ArrayList();
        try {
            int count = hMSCursorWrapper.getCount();
            CursorWindow window = hMSCursorWrapper.getWindow();
            if (window == null || window.getStartPosition() != 0) {
                i = 0;
            } else {
                window.acquireReference();
                hMSCursorWrapper.setWindow(null);
                arrayList.add(window);
                i = window.getNumRows();
            }
            arrayList.addAll(iterCursorWrapper(hMSCursorWrapper, i, count));
            return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
        } catch (Throwable th) {
            try {
                HMSLog.e(TAG, "fail to getCursorWindows: " + th.getMessage());
                return new CursorWindow[0];
            } finally {
                hMSCursorWrapper.close();
            }
        }
    }

    private static ArrayList<CursorWindow> iterCursorWindow(Builder builder, int i, List list) {
        CursorWindow cursorWindow;
        boolean z;
        ArrayList<CursorWindow> arrayList = new ArrayList<>();
        CursorWindow cursorWindow2 = new CursorWindow((String) null);
        cursorWindow2.setNumColumns(builder.a.length);
        arrayList.add(cursorWindow2);
        for (int i2 = 0; i2 < i; i2++) {
            try {
                if (!cursorWindow2.allocRow()) {
                    HMSLog.d(TAG, "Failed to allocate a row");
                    cursorWindow = new CursorWindow((String) null);
                    try {
                        cursorWindow.setStartPosition(i2);
                        cursorWindow.setNumColumns(builder.a.length);
                        if (!cursorWindow.allocRow()) {
                            HMSLog.e(TAG, "Failed to retry to allocate a row");
                            return arrayList;
                        }
                        arrayList.add(cursorWindow);
                        cursorWindow2 = cursorWindow;
                    } catch (RuntimeException unused) {
                        Iterator<CursorWindow> it = arrayList.iterator();
                        while (it.hasNext()) {
                            it.next().close();
                        }
                        HMSLog.w(TAG, "iter CursorWindow failed, RuntimeException occured.");
                        cursorWindow2 = cursorWindow;
                    }
                }
                HashMap hashMap = (HashMap) list.get(i2);
                z = true;
                for (int i3 = 0; i3 < builder.a.length && (z = putValue(cursorWindow2, hashMap.get(builder.a[i3]), i2, i3)); i3++) {
                }
            } catch (RuntimeException unused2) {
                cursorWindow = cursorWindow2;
            }
            if (!z) {
                HMSLog.d(TAG, "fail to put data for row " + i2);
                cursorWindow2.freeLastRow();
                CursorWindow cursorWindow3 = new CursorWindow((String) null);
                cursorWindow3.setStartPosition(i2);
                cursorWindow3.setNumColumns(builder.a.length);
                arrayList.add(cursorWindow3);
                break;
            }
            continue;
        }
        return arrayList;
    }

    private static ArrayList<CursorWindow> iterCursorWrapper(HMSCursorWrapper hMSCursorWrapper, int i, int i2) {
        ArrayList<CursorWindow> arrayList = new ArrayList<>();
        while (i < i2 && hMSCursorWrapper.moveToPosition(i)) {
            CursorWindow window = hMSCursorWrapper.getWindow();
            if (window == null) {
                window = new CursorWindow((String) null);
                window.setStartPosition(i);
                hMSCursorWrapper.fillWindow(i, window);
            } else {
                window.acquireReference();
                hMSCursorWrapper.setWindow(null);
            }
            if (window.getNumRows() == 0) {
                break;
            }
            arrayList.add(window);
            i = window.getNumRows() + window.getStartPosition();
        }
        return arrayList;
    }

    private static boolean putValue(CursorWindow cursorWindow, Object obj, int i, int i2) throws IllegalArgumentException {
        if (obj == null) {
            return cursorWindow.putNull(i, i2);
        }
        if (obj instanceof Boolean) {
            return cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1L : 0L, i, i2);
        }
        if (obj instanceof Integer) {
            return cursorWindow.putLong(((Integer) obj).intValue(), i, i2);
        }
        if (obj instanceof Long) {
            return cursorWindow.putLong(((Long) obj).longValue(), i, i2);
        }
        if (obj instanceof Float) {
            return cursorWindow.putDouble(((Float) obj).floatValue(), i, i2);
        }
        if (obj instanceof Double) {
            return cursorWindow.putDouble(((Double) obj).doubleValue(), i, i2);
        }
        if (obj instanceof String) {
            return cursorWindow.putString((String) obj, i, i2);
        }
        if (obj instanceof byte[]) {
            return cursorWindow.putBlob((byte[]) obj, i, i2);
        }
        throw new IllegalArgumentException("unsupported type for column: " + obj);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (!this.mClosed) {
            for (CursorWindow cursorWindow : this.cursorWindows) {
                cursorWindow.close();
            }
            this.mClosed = true;
        }
    }

    public final void collectColumsAndCount() {
        this.columnsBundle = new Bundle();
        String[] strArr = this.columns;
        int i = 0;
        if (strArr != null && strArr.length != 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.columns;
                if (i2 >= strArr2.length) {
                    break;
                }
                this.columnsBundle.putInt(strArr2[i2], i2);
                i2++;
            }
            CursorWindow[] cursorWindowArr = this.cursorWindows;
            if (cursorWindowArr != null && cursorWindowArr.length != 0) {
                this.perCursorCounts = new int[cursorWindowArr.length];
                int i3 = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr2 = this.cursorWindows;
                    if (i < cursorWindowArr2.length) {
                        this.perCursorCounts[i] = i3;
                        i3 = cursorWindowArr2[i].getStartPosition() + this.cursorWindows[i].getNumRows();
                        i++;
                    } else {
                        this.dataCount = i3;
                        return;
                    }
                }
            } else {
                this.dataCount = 0;
            }
        } else {
            this.dataCount = 0;
        }
    }

    public final void copyToBuffer(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        checkAvailable(str, i);
        this.cursorWindows[i2].copyStringToBuffer(i, this.columnsBundle.getInt(str), charArrayBuffer);
    }

    protected final void finalize() throws Throwable {
        if (this.isInstance && this.cursorWindows.length > 0 && !isClosed()) {
            close();
        }
        super.finalize();
    }

    public final int getCount() {
        return this.dataCount;
    }

    public final Bundle getMetadata() {
        return this.metadata;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final Object getValue(String str, int i, int i2, String str2) {
        str2.hashCode();
        str2.hashCode();
        char c = 65535;
        switch (str2.hashCode()) {
            case -1092271849:
                if (str2.equals(TYPE_FLOAT)) {
                    c = 0;
                    break;
                }
                break;
            case -870070237:
                if (str2.equals(TYPE_BOOLEAN)) {
                    c = 1;
                    break;
                }
                break;
            case -675993238:
                if (str2.equals(TYPE_INT)) {
                    c = 2;
                    break;
                }
                break;
            case 445002870:
                if (str2.equals(TYPE_DOUBLE)) {
                    c = 3;
                    break;
                }
                break;
            case 519136353:
                if (str2.equals(TYPE_LONG)) {
                    c = 4;
                    break;
                }
                break;
            case 878975158:
                if (str2.equals(TYPE_STRING)) {
                    c = 5;
                    break;
                }
                break;
            case 1300508295:
                if (str2.equals(TYPE_BYTE_ARRAY)) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                checkAvailable(str, i);
                return Float.valueOf(this.cursorWindows[i2].getFloat(i, this.columnsBundle.getInt(str)));
            case 1:
                checkAvailable(str, i);
                return Boolean.valueOf(this.cursorWindows[i2].getLong(i, this.columnsBundle.getInt(str)) == 1);
            case 2:
                checkAvailable(str, i);
                return Integer.valueOf(this.cursorWindows[i2].getInt(i, this.columnsBundle.getInt(str)));
            case 3:
                checkAvailable(str, i);
                return Double.valueOf(this.cursorWindows[i2].getDouble(i, this.columnsBundle.getInt(str)));
            case 4:
                checkAvailable(str, i);
                return Long.valueOf(this.cursorWindows[i2].getLong(i, this.columnsBundle.getInt(str)));
            case 5:
                checkAvailable(str, i);
                return this.cursorWindows[i2].getString(i, this.columnsBundle.getInt(str));
            case 6:
                checkAvailable(str, i);
                return this.cursorWindows[i2].getBlob(i, this.columnsBundle.getInt(str));
            default:
                return null;
        }
    }

    public final int getWindowIndex(int i) {
        int[] iArr;
        int i2 = 0;
        Preconditions.checkArgument(i >= 0 || i < this.dataCount, "rowIndex is out of index:" + i);
        while (true) {
            iArr = this.perCursorCounts;
            if (i2 >= iArr.length) {
                break;
            }
            if (i < iArr[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == iArr.length ? i2 - 1 : i2;
    }

    public final boolean hasColumn(String str) {
        return this.columnsBundle.containsKey(str);
    }

    public final boolean hasNull(String str, int i, int i2) {
        checkAvailable(str, i);
        return this.cursorWindows[i2].getType(i, this.columnsBundle.getInt(str)) == 0;
    }

    public final synchronized boolean isClosed() {
        return this.mClosed;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        if (parcel == null) {
            return;
        }
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.columns, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.cursorWindows, i, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.version);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        if ((i & 1) != 0) {
            close();
        }
    }

    private void checkAvailable(String str, int i) {
        String str2;
        Bundle bundle = this.columnsBundle;
        if (bundle != null && bundle.containsKey(str)) {
            if (isClosed()) {
                str2 = "buffer has been closed";
            } else {
                str2 = (i < 0 || i >= this.dataCount) ? "row is out of index:" + i : "";
            }
        } else {
            str2 = "cannot find column: " + str;
        }
        Preconditions.checkArgument(str2.isEmpty(), str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.isInstance = true;
        this.version = i;
        this.columns = strArr;
        this.cursorWindows = cursorWindowArr;
        this.statusCode = i2;
        this.metadata = bundle;
        collectColumsAndCount();
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        Preconditions.checkNotNull(strArr, "columnsP cannot be null");
        Preconditions.checkNotNull(cursorWindowArr, "cursorWindowP cannot be null");
        this.mClosed = false;
        this.isInstance = true;
        this.version = 1;
        this.columns = strArr;
        this.cursorWindows = cursorWindowArr;
        this.statusCode = i;
        this.metadata = bundle;
        collectColumsAndCount();
    }

    private DataHolder(HMSCursorWrapper hMSCursorWrapper, int i, Bundle bundle) {
        this(hMSCursorWrapper.getColumnNames(), getCursorWindows(hMSCursorWrapper), i, bundle);
    }

    public DataHolder(Cursor cursor, int i, Bundle bundle) {
        this(new HMSCursorWrapper(cursor), i, bundle);
    }

    private DataHolder(Builder builder, int i, Bundle bundle) {
        this(builder.a, getCursorWindows(builder, -1), i, (Bundle) null);
    }

    private DataHolder(Builder builder, int i, Bundle bundle, int i2) {
        this(builder.a, getCursorWindows(builder, -1), i, bundle);
    }

    private static CursorWindow[] getCursorWindows(Builder builder, int i) {
        if (builder.a.length == 0) {
            return new CursorWindow[0];
        }
        if (i < 0 || i >= builder.b.size()) {
            i = builder.b.size();
        }
        ArrayList<CursorWindow> iterCursorWindow = iterCursorWindow(builder, i, builder.b.subList(0, i));
        return (CursorWindow[]) iterCursorWindow.toArray(new CursorWindow[iterCursorWindow.size()]);
    }
}
