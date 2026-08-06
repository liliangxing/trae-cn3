package com.bytedance.timonbase.scene.lifecycle;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForegroundHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J\t\u0010\u0014\u001a\u00020\nHÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0006H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006!"}, d2 = {"Lcom/bytedance/timonbase/scene/lifecycle/ForegroundState;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "pid", "", "foreground", "", "time", "", "(IZJ)V", "getForeground", "()Z", "getPid", "()I", "getTime", "()J", "component1", "component2", "component3", "copy", "describeContents", "equals", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "", "writeToParcel", "", RouterConstants.QUERY_KEY_FLAGS, "CREATOR", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final /* data */ class ForegroundState implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean foreground;
    private final int pid;
    private final long time;

    public static /* synthetic */ ForegroundState copy$default(ForegroundState foregroundState, int i, boolean z, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = foregroundState.pid;
        }
        if ((i2 & 2) != 0) {
            z = foregroundState.foreground;
        }
        if ((i2 & 4) != 0) {
            j = foregroundState.time;
        }
        return foregroundState.copy(i, z, j);
    }

    /* renamed from: component1, reason: from getter */
    public final int getPid() {
        return this.pid;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getForeground() {
        return this.foreground;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    public final ForegroundState copy(int pid, boolean foreground, long time) {
        return new ForegroundState(pid, foreground, time);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForegroundState)) {
            return false;
        }
        ForegroundState foregroundState = (ForegroundState) other;
        return this.pid == foregroundState.pid && this.foreground == foregroundState.foreground && this.time == foregroundState.time;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = Integer.hashCode(this.pid) * 31;
        boolean z = this.foreground;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((hashCode + i) * 31) + Long.hashCode(this.time);
    }

    public String toString() {
        return "ForegroundState(pid=" + this.pid + ", foreground=" + this.foreground + ", time=" + this.time + ")";
    }

    public ForegroundState(int i, boolean z, long j) {
        this.pid = i;
        this.foreground = z;
        this.time = j;
    }

    public final boolean getForeground() {
        return this.foreground;
    }

    public final int getPid() {
        return this.pid;
    }

    public final long getTime() {
        return this.time;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ForegroundState(Parcel parcel) {
        this(parcel.readInt(), parcel.readByte() != ((byte) 0), parcel.readLong());
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeInt(this.pid);
        parcel.writeByte(this.foreground ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.time);
    }

    /* compiled from: ForegroundHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/timonbase/scene/lifecycle/ForegroundState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/bytedance/timonbase/scene/lifecycle/ForegroundState;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/bytedance/timonbase/scene/lifecycle/ForegroundState;", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* renamed from: com.bytedance.timonbase.scene.lifecycle.ForegroundState$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion implements Parcelable.Creator<ForegroundState> {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ForegroundState createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new ForegroundState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ForegroundState[] newArray(int size) {
            return new ForegroundState[size];
        }
    }
}
