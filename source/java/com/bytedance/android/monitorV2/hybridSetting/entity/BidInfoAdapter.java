package com.bytedance.android.monitorV2.hybridSetting.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfoAdapter;
import com.bytedance.android.monitorV2.hybridSetting.entity.parcel.AbstractParcelableAdapter;
import com.bytedance.android.monitorV2.util.ConvertUtil;
import com.bytedance.apm.battery.dao.DBHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BidInfoAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nB\u000f\b\u0012\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rB\u0005¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfoAdapter;", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/parcel/AbstractParcelableAdapter;", "settingId", "", "bidConfigs", "", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfoAdapter$BidConfigAdapter;", "bidRegexs", "", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidRegex;", "(J[Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfoAdapter$BidConfigAdapter;Ljava/util/List;)V", DBHelper.BATTERY_COL_SOURCE, "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "[Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfoAdapter$BidConfigAdapter;", "adapter2BidInfo", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfo;", "writeToParcel", "", "dest", "flags", "", "BidConfigAdapter", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class BidInfoAdapter extends AbstractParcelableAdapter {
    private BidConfigAdapter[] bidConfigs;
    private List<? extends BidRegex> bidRegexs;
    private long settingId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<BidInfoAdapter> CREATOR = new Parcelable.Creator<BidInfoAdapter>() { // from class: com.bytedance.android.monitorV2.hybridSetting.entity.BidInfoAdapter$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BidInfoAdapter createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, DBHelper.BATTERY_COL_SOURCE);
            return new BidInfoAdapter(source, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BidInfoAdapter[] newArray(int size) {
            return new BidInfoAdapter[size];
        }
    };

    public /* synthetic */ BidInfoAdapter(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    @JvmStatic
    public static final BidInfoAdapter adapter2BidInfoAdapter(long j, BidInfo bidInfo) {
        return INSTANCE.adapter2BidInfoAdapter(j, bidInfo);
    }

    /* compiled from: BidInfoAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfoAdapter$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfoAdapter;", "adapter2BidInfoAdapter", "settingId", "", "bidInfo", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfo;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BidInfoAdapter adapter2BidInfoAdapter(long settingId, BidInfo bidInfo) {
            Intrinsics.checkNotNullParameter(bidInfo, "bidInfo");
            BidConfigAdapter[] bidConfigAdapterArr = new BidConfigAdapter[bidInfo.bidInfoMap.size()];
            int i = 0;
            for (BidInfo.BidConfig bidConfig : bidInfo.bidInfoMap.values()) {
                BidConfigAdapter.Companion companion = BidConfigAdapter.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(bidConfig, "item");
                bidConfigAdapterArr[i] = companion.adapter2BidConfigAdapter(bidConfig);
                i++;
            }
            return new BidInfoAdapter(settingId, bidConfigAdapterArr, bidInfo.regexList);
        }
    }

    public BidInfoAdapter() {
    }

    public BidInfoAdapter(long j, BidConfigAdapter[] bidConfigAdapterArr, List<? extends BidRegex> list) {
        this();
        this.settingId = j;
        this.bidConfigs = bidConfigAdapterArr;
        this.bidRegexs = list;
    }

    private BidInfoAdapter(Parcel parcel) {
        this();
        BidConfigAdapter[] bidConfigAdapterArr;
        this.settingId = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = null;
        if (readInt == 0) {
            bidConfigAdapterArr = null;
        } else {
            bidConfigAdapterArr = new BidConfigAdapter[readInt];
            for (int i = 0; i < readInt; i++) {
                BidConfigAdapter createFromParcel = BidConfigAdapter.CREATOR.createFromParcel(parcel);
                Intrinsics.checkNotNullExpressionValue(createFromParcel, "CREATOR.createFromParcel(src)");
                bidConfigAdapterArr[i] = createFromParcel;
            }
        }
        this.bidConfigs = bidConfigAdapterArr;
        int readInt2 = parcel.readInt();
        if (readInt2 != 0) {
            arrayList = new ArrayList();
            for (int i2 = 0; i2 < readInt2; i2++) {
                String readString = parcel.readString();
                Intrinsics.checkNotNull(readString);
                String readString2 = parcel.readString();
                Intrinsics.checkNotNull(readString2);
                arrayList.add(new LazyBidRegex(readString, readString2));
            }
        }
        this.bidRegexs = arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.settingId);
        BidConfigAdapter[] bidConfigAdapterArr = this.bidConfigs;
        int length = bidConfigAdapterArr != null ? bidConfigAdapterArr.length : 0;
        dest.writeInt(length);
        if (length > 0) {
            Intrinsics.checkNotNull(bidConfigAdapterArr);
            for (BidConfigAdapter bidConfigAdapter : bidConfigAdapterArr) {
                bidConfigAdapter.writeToParcel(dest, flags);
            }
        }
        List<? extends BidRegex> list = this.bidRegexs;
        int size = list != null ? list.size() : 0;
        dest.writeInt(size);
        if (size > 0) {
            Intrinsics.checkNotNull(list);
            for (BidRegex bidRegex : list) {
                dest.writeString(bidRegex.getBid());
                dest.writeString(bidRegex instanceof LazyBidRegex ? ((LazyBidRegex) bidRegex).getRegStr() : bidRegex.getRegex().toString());
            }
        }
    }

    public final BidInfo adapter2BidInfo() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        BidConfigAdapter[] bidConfigAdapterArr = this.bidConfigs;
        if (bidConfigAdapterArr != null) {
            for (BidConfigAdapter bidConfigAdapter : bidConfigAdapterArr) {
                BidInfo.BidConfig adapter2BidConfig = bidConfigAdapter.adapter2BidConfig(this.settingId);
                String str = adapter2BidConfig.bid;
                Intrinsics.checkNotNullExpressionValue(str, "bidConfig.bid");
                linkedHashMap.put(str, adapter2BidConfig);
            }
        }
        BidInfo bidInfo = new BidInfo();
        bidInfo.bidInfoMap = linkedHashMap;
        List list = this.bidRegexs;
        if (list != null) {
            bidInfo.regexList = list;
        }
        return bidInfo;
    }

    /* compiled from: BidInfoAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B-\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tB\u000f\b\u0012\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB\u0005¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfoAdapter$BidConfigAdapter;", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/parcel/AbstractParcelableAdapter;", "bid", "", "hitSample", "", "eventSample", "", "", "(Ljava/lang/String;JLjava/util/Map;)V", DBHelper.BATTERY_COL_SOURCE, "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "adapter2BidConfig", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfo$BidConfig;", "settingId", "writeToParcel", "", "dest", "flags", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class BidConfigAdapter extends AbstractParcelableAdapter {
        private String bid;
        private Map<String, Integer> eventSample;
        private long hitSample;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Parcelable.Creator<BidConfigAdapter> CREATOR = new Parcelable.Creator<BidConfigAdapter>() { // from class: com.bytedance.android.monitorV2.hybridSetting.entity.BidInfoAdapter$BidConfigAdapter$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BidInfoAdapter.BidConfigAdapter createFromParcel(Parcel source) {
                Intrinsics.checkNotNullParameter(source, DBHelper.BATTERY_COL_SOURCE);
                return new BidInfoAdapter.BidConfigAdapter(source, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BidInfoAdapter.BidConfigAdapter[] newArray(int size) {
                return new BidInfoAdapter.BidConfigAdapter[size];
            }
        };

        public /* synthetic */ BidConfigAdapter(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        @JvmStatic
        public static final BidConfigAdapter adapter2BidConfigAdapter(BidInfo.BidConfig bidConfig) {
            return INSTANCE.adapter2BidConfigAdapter(bidConfig);
        }

        /* compiled from: BidInfoAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfoAdapter$BidConfigAdapter$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfoAdapter$BidConfigAdapter;", "adapter2BidConfigAdapter", "bidConfig", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfo$BidConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final BidConfigAdapter adapter2BidConfigAdapter(BidInfo.BidConfig bidConfig) {
                Intrinsics.checkNotNullParameter(bidConfig, "bidConfig");
                String str = bidConfig.bid;
                Intrinsics.checkNotNullExpressionValue(str, "bidConfig.bid");
                return new BidConfigAdapter(str, bidConfig.hitSample, bidConfig.eventNameSample);
            }
        }

        public BidConfigAdapter() {
            String str = BidInfo.DEFAULT;
            Intrinsics.checkNotNullExpressionValue(str, "DEFAULT");
            this.bid = str;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public BidConfigAdapter(String str, long j, Map<String, Integer> map) {
            this();
            Intrinsics.checkNotNullParameter(str, "bid");
            this.bid = str;
            this.hitSample = j;
            this.eventSample = map;
        }

        private BidConfigAdapter(Parcel parcel) {
            this();
            LinkedHashMap linkedHashMap;
            String readString = parcel.readString();
            Intrinsics.checkNotNull(readString);
            this.bid = readString;
            this.hitSample = parcel.readLong();
            int readInt = parcel.readInt();
            if (readInt == 0) {
                linkedHashMap = null;
            } else {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (int i = 0; i < readInt; i++) {
                    String readString2 = parcel.readString();
                    Intrinsics.checkNotNull(readString2);
                    Pair pair = new Pair(readString2, Integer.valueOf(parcel.readInt()));
                    linkedHashMap2.put(pair.getFirst(), pair.getSecond());
                }
                linkedHashMap = linkedHashMap2;
            }
            this.eventSample = linkedHashMap;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.bid);
            dest.writeLong(this.hitSample);
            Map<String, Integer> map = this.eventSample;
            int size = map != null ? map.size() : 0;
            dest.writeInt(size);
            if (size > 0) {
                Intrinsics.checkNotNull(map);
                Iterator<T> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    dest.writeString((String) entry.getKey());
                    dest.writeInt(((Number) entry.getValue()).intValue());
                }
            }
        }

        public final BidInfo.BidConfig adapter2BidConfig(long settingId) {
            BidInfo.BidConfig bidConfig = new BidInfo.BidConfig();
            bidConfig.bid = this.bid;
            bidConfig.settingId = settingId;
            bidConfig.hitSample = this.hitSample;
            bidConfig.eventNameSample = this.eventSample;
            ConvertUtil.convertSample(bidConfig, this.hitSample, 46);
            return bidConfig;
        }
    }
}
