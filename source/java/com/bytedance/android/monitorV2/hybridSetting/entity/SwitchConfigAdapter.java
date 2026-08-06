package com.bytedance.android.monitorV2.hybridSetting.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.hybridSetting.entity.parcel.AbstractParcelableAdapter;
import com.bytedance.apm.battery.dao.DBHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SwitchConfigAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0005¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/entity/SwitchConfigAdapter;", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/parcel/AbstractParcelableAdapter;", "config", "", "(J)V", DBHelper.BATTERY_COL_SOURCE, "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "adapter2SwitchConfig", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/SwitchConfig;", "writeToParcel", "", "dest", "flags", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class SwitchConfigAdapter extends AbstractParcelableAdapter {
    private long config;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<SwitchConfigAdapter> CREATOR = new Parcelable.Creator<SwitchConfigAdapter>() { // from class: com.bytedance.android.monitorV2.hybridSetting.entity.SwitchConfigAdapter$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SwitchConfigAdapter createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, DBHelper.BATTERY_COL_SOURCE);
            return new SwitchConfigAdapter(source, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SwitchConfigAdapter[] newArray(int size) {
            return new SwitchConfigAdapter[size];
        }
    };

    public /* synthetic */ SwitchConfigAdapter(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    @JvmStatic
    public static final SwitchConfigAdapter adapter2SwitchConfigAdapter(SwitchConfig switchConfig) {
        return INSTANCE.adapter2SwitchConfigAdapter(switchConfig);
    }

    /* compiled from: SwitchConfigAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/entity/SwitchConfigAdapter$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/SwitchConfigAdapter;", "adapter2SwitchConfigAdapter", "switchConfig", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/SwitchConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SwitchConfigAdapter adapter2SwitchConfigAdapter(SwitchConfig switchConfig) {
            Intrinsics.checkNotNullParameter(switchConfig, "switchConfig");
            return new SwitchConfigAdapter(switchConfig.mConfig);
        }
    }

    public SwitchConfigAdapter() {
    }

    public SwitchConfigAdapter(long j) {
        this();
        this.config = j;
    }

    private SwitchConfigAdapter(Parcel parcel) {
        this();
        this.config = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.config);
    }

    public final SwitchConfig adapter2SwitchConfig() {
        SwitchConfig switchConfig = new SwitchConfig();
        switchConfig.mConfig = this.config;
        Switches.resetAll(this.config);
        return switchConfig;
    }
}
