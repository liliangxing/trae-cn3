package com.bytedance.android.monitorV2.hybridSetting.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.monitorV2.hybridSetting.entity.parcel.AbstractParcelableAdapter;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheckFilter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B=\b\u0017\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u000f\b\u0012\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eRB\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u00032\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/entity/CheckFilter;", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/parcel/AbstractParcelableAdapter;", "filter", "", "", "", "category", "id", "(Ljava/util/Map;Ljava/util/List;Ljava/lang/String;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "<set-?>", "getCategory", "()Ljava/util/List;", "getFilter", "()Ljava/util/Map;", "getId", "()Ljava/lang/String;", "writeToParcel", "", "dest", RouterConstants.QUERY_KEY_FLAGS, "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class CheckFilter extends AbstractParcelableAdapter {
    private List<String> category;
    private Map<String, ? extends List<String>> filter;
    private String id;
    public static final Parcelable.Creator<CheckFilter> CREATOR = new Parcelable.Creator<CheckFilter>() { // from class: com.bytedance.android.monitorV2.hybridSetting.entity.CheckFilter$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CheckFilter createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new CheckFilter(source, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CheckFilter[] newArray(int size) {
            return new CheckFilter[size];
        }
    };

    public CheckFilter() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ CheckFilter(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CheckFilter(Map<String, ? extends List<String>> filter) {
        this(filter, null, null, 6, null);
        Intrinsics.checkNotNullParameter(filter, "filter");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CheckFilter(Map<String, ? extends List<String>> filter, List<String> category) {
        this(filter, category, null, 4, null);
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(category, "category");
    }

    public final Map<String, List<String>> getFilter() {
        return this.filter;
    }

    public final List<String> getCategory() {
        return this.category;
    }

    public final String getId() {
        return this.id;
    }

    public /* synthetic */ CheckFilter(HashMap hashMap, ArrayList arrayList, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new HashMap() : hashMap, (i & 2) != 0 ? new ArrayList() : arrayList, (i & 4) != 0 ? "" : str);
    }

    public CheckFilter(Map<String, ? extends List<String>> filter, List<String> category, String id) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(id, "id");
        this.filter = filter;
        this.category = category;
        this.id = id;
    }

    private CheckFilter(Parcel parcel) {
        LinkedHashMap linkedHashMap;
        ArrayList arrayList;
        int readInt = parcel.readInt();
        ArrayList arrayList2 = null;
        if (readInt == 0) {
            linkedHashMap = null;
        } else {
            linkedHashMap = new LinkedHashMap();
            for (int i = 0; i < readInt; i++) {
                String readString = parcel.readString();
                Intrinsics.checkNotNull(readString);
                int readInt2 = parcel.readInt();
                if (readInt2 == 0) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList();
                    for (int i2 = 0; i2 < readInt2; i2++) {
                        String readString2 = parcel.readString();
                        Intrinsics.checkNotNull(readString2);
                        arrayList.add(readString2);
                    }
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                Pair pair = new Pair(readString, arrayList);
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
        }
        this.filter = linkedHashMap == null ? new HashMap() : linkedHashMap;
        int readInt3 = parcel.readInt();
        if (readInt3 != 0) {
            arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < readInt3; i3++) {
                String readString3 = parcel.readString();
                Intrinsics.checkNotNull(readString3);
                arrayList2.add(readString3);
            }
        }
        this.category = arrayList2 == null ? new ArrayList() : arrayList2;
        String readString4 = parcel.readString();
        Intrinsics.checkNotNull(readString4);
        this.id = readString4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Map<String, ? extends List<String>> map = this.filter;
        int size = map != null ? map.size() : 0;
        dest.writeInt(size);
        if (size > 0) {
            Intrinsics.checkNotNull(map);
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                dest.writeString((String) entry.getKey());
                List list = (List) entry.getValue();
                int size2 = list != null ? list.size() : 0;
                dest.writeInt(size2);
                if (size2 > 0) {
                    Intrinsics.checkNotNull(list);
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        dest.writeString((String) it2.next());
                    }
                }
            }
        }
        List<String> list2 = this.category;
        int size3 = list2 != null ? list2.size() : 0;
        dest.writeInt(size3);
        if (size3 > 0) {
            Intrinsics.checkNotNull(list2);
            Iterator<T> it3 = list2.iterator();
            while (it3.hasNext()) {
                dest.writeString((String) it3.next());
            }
        }
        dest.writeString(this.id);
    }
}
