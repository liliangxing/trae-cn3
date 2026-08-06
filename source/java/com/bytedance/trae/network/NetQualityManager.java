package com.bytedance.trae.network;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetQualityManager.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u000b\u001a\u00020\u0007*\u00020\fH\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fJ\u0006\u0010\u0012\u001a\u00020\u0007J\u0016\u0010\u0013\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015H\u0007J\u0016\u0010\u0016\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/network/NetQualityManager;", "", "<init>", "()V", "TAG", "", "currentNetworkStatus", "Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;", "NETWORK_STATUS_VALUES", "", "[Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;", "toNetworkStatus", "", "mConnectionTypeLiveData", "Landroidx/lifecycle/MutableLiveData;", "provide", "", "type", "getCurrentNetworkStatus", "register", "observer", "Landroidx/lifecycle/Observer;", "unRegister", "NetworkStatus", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class NetQualityManager {
    public static final NetQualityManager INSTANCE = new NetQualityManager();
    private static final String TAG = "NetQualityManager";
    private static NetworkStatus currentNetworkStatus = NetworkStatus.NET_DEFAULT;
    private static final NetworkStatus[] NETWORK_STATUS_VALUES = NetworkStatus.values();
    private static final MutableLiveData<NetworkStatus> mConnectionTypeLiveData = new MutableLiveData<>();

    private NetQualityManager() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: NetQualityManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/network/NetQualityManager$NetworkStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FAKE", NetworkStackConstant.UNKNOWN_TYPE, NetworkStackConstant.ERR_DISCONNECTED, "POOR_2G", "GOOD_2G", "NORMAL_3G", "POOR_4G", "NORMAL_4G", "GOOD_4G", "EXCELLENT_4G", "NET_DEFAULT", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class NetworkStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ NetworkStatus[] $VALUES;
        private final int value;
        public static final NetworkStatus FAKE = new NetworkStatus("FAKE", 0, -1);
        public static final NetworkStatus UNKNOWN = new NetworkStatus(NetworkStackConstant.UNKNOWN_TYPE, 1, 0);
        public static final NetworkStatus DISCONNECTED = new NetworkStatus(NetworkStackConstant.ERR_DISCONNECTED, 2, 1);
        public static final NetworkStatus POOR_2G = new NetworkStatus("POOR_2G", 3, 2);
        public static final NetworkStatus GOOD_2G = new NetworkStatus("GOOD_2G", 4, 3);
        public static final NetworkStatus NORMAL_3G = new NetworkStatus("NORMAL_3G", 5, 4);
        public static final NetworkStatus POOR_4G = new NetworkStatus("POOR_4G", 6, 5);
        public static final NetworkStatus NORMAL_4G = new NetworkStatus("NORMAL_4G", 7, 6);
        public static final NetworkStatus GOOD_4G = new NetworkStatus("GOOD_4G", 8, 7);
        public static final NetworkStatus EXCELLENT_4G = new NetworkStatus("EXCELLENT_4G", 9, 8);
        public static final NetworkStatus NET_DEFAULT = new NetworkStatus("NET_DEFAULT", 10, -10000);

        private static final /* synthetic */ NetworkStatus[] $values() {
            return new NetworkStatus[]{FAKE, UNKNOWN, DISCONNECTED, POOR_2G, GOOD_2G, NORMAL_3G, POOR_4G, NORMAL_4G, GOOD_4G, EXCELLENT_4G, NET_DEFAULT};
        }

        public static EnumEntries<NetworkStatus> getEntries() {
            return $ENTRIES;
        }

        private NetworkStatus(String str, int i, int i2) {
            this.value = i2;
        }

        public final int getValue() {
            return this.value;
        }

        static {
            NetworkStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static NetworkStatus valueOf(String str) {
            return (NetworkStatus) Enum.valueOf(NetworkStatus.class, str);
        }

        public static NetworkStatus[] values() {
            return (NetworkStatus[]) $VALUES.clone();
        }
    }

    private final NetworkStatus toNetworkStatus(int i) {
        NetworkStatus networkStatus;
        NetworkStatus[] networkStatusArr = NETWORK_STATUS_VALUES;
        int length = networkStatusArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                networkStatus = null;
                break;
            }
            networkStatus = networkStatusArr[i2];
            if (networkStatus.getValue() == i) {
                break;
            }
            i2++;
        }
        return networkStatus == null ? NetworkStatus.UNKNOWN : networkStatus;
    }

    public final void provide(int type) {
        if (AppHost.Companion.isDebug()) {
            Log.d(TAG, "Net work quality is : " + type);
        }
        currentNetworkStatus = toNetworkStatus(type);
        mConnectionTypeLiveData.postValue(toNetworkStatus(type));
        IApplog.Companion.setHeaderInfo("network_quality", Integer.valueOf(type));
    }

    public final NetworkStatus getCurrentNetworkStatus() {
        return currentNetworkStatus;
    }

    public final void register(Observer<NetworkStatus> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        mConnectionTypeLiveData.observeForever(observer);
    }

    public final void unRegister(Observer<NetworkStatus> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        mConnectionTypeLiveData.removeObserver(observer);
    }
}
