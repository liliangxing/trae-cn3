package com.bytedance.trae.conversation.devices;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.CliListRepository;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: DeviceListViewModel.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\rJ\"\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\r2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0010J\u0018\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u00102\b\b\u0002\u0010$\u001a\u00020\rJ\u0006\u0010%\u001a\u00020\rJ&\u0010&\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00182\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\t8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_devices", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/bytedance/trae/conversation/devices/DeviceItem;", "locations", "Landroidx/lifecycle/LiveData;", "getLocations", "()Landroidx/lifecycle/LiveData;", "_isLoading", "", "isLoading", "preselectedDeviceId", "", "getPreselectedDeviceId", "()Ljava/lang/String;", "setPreselectedDeviceId", "(Ljava/lang/String;)V", "repository", "Lcom/bytedance/trae/conversation/CliListRepository;", "deviceListRevision", "", "dispatchedDeviceListRevision", "sessionSelectedDeviceId", "ensureDevicesLoaded", "", "context", "Landroid/content/Context;", "isCodeMode", "fetchDevices", "selectedDeviceId", "selectLocation", "id", "dispatchDeviceListChanged", "shouldDispatchDeviceListChanged", "logFetchResult", "rawCliCount", "devices", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceListViewModel extends ViewModel {
    private static final int MAX_LOG_ITEMS = 5;
    private static final String TAG = "DeviceListViewModel";
    private int deviceListRevision;
    private int dispatchedDeviceListRevision;
    private String preselectedDeviceId;
    private String sessionSelectedDeviceId;
    private final MutableLiveData<List<DeviceItem>> _devices = new MutableLiveData<>();
    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>(true);
    private final CliListRepository repository = CliListRepository.INSTANCE.getInstance();

    public final LiveData<List<DeviceItem>> getLocations() {
        return this._devices;
    }

    public final LiveData<Boolean> isLoading() {
        return this._isLoading;
    }

    public final String getPreselectedDeviceId() {
        return this.preselectedDeviceId;
    }

    public final void setPreselectedDeviceId(String str) {
        this.preselectedDeviceId = str;
    }

    public final void ensureDevicesLoaded(Context context, boolean isCodeMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this._devices.getValue() != null) {
            this._isLoading.setValue(false);
        } else {
            fetchDevices$default(this, context, isCodeMode, null, 4, null);
        }
    }

    public static /* synthetic */ void fetchDevices$default(DeviceListViewModel deviceListViewModel, Context context, boolean z, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        deviceListViewModel.fetchDevices(context, z, str);
    }

    public final void fetchDevices(Context context, boolean isCodeMode, String selectedDeviceId) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (selectedDeviceId != null) {
            if (!(!StringsKt.isBlank(selectedDeviceId))) {
                selectedDeviceId = null;
            }
            if (selectedDeviceId != null) {
                this.sessionSelectedDeviceId = selectedDeviceId;
            }
        }
        this._isLoading.setValue(true);
        TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
        StringBuilder append = new StringBuilder("offline_device_fetch_start: isCodeMode=").append(isCodeMode).append(", preselectedId=");
        String str = this.preselectedDeviceId;
        String deviceLogId = str != null ? DeviceItemKt.toDeviceLogId(str) : null;
        if (deviceLogId == null) {
            deviceLogId = "";
        }
        traeLogUtil.i(TAG, append.append(deviceLogId).toString());
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new DeviceListViewModel$fetchDevices$3(this, context, isCodeMode, null), 3, (Object) null);
    }

    public static /* synthetic */ void selectLocation$default(DeviceListViewModel deviceListViewModel, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        deviceListViewModel.selectLocation(str, z);
    }

    public final void selectLocation(String id, boolean dispatchDeviceListChanged) {
        DeviceItem copy;
        Intrinsics.checkNotNullParameter(id, "id");
        List list = (List) this._devices.getValue();
        if (list == null) {
            return;
        }
        this.sessionSelectedDeviceId = id;
        if (dispatchDeviceListChanged) {
            this.deviceListRevision++;
        }
        MutableLiveData<List<DeviceItem>> mutableLiveData = this._devices;
        List<DeviceItem> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (DeviceItem deviceItem : list2) {
            copy = deviceItem.copy((r20 & 1) != 0 ? deviceItem.id : null, (r20 & 2) != 0 ? deviceItem.name : null, (r20 & 4) != 0 ? deviceItem.model : null, (r20 & 8) != 0 ? deviceItem.iconResId : 0, (r20 & 16) != 0 ? deviceItem.isOnline : false, (r20 & 32) != 0 ? deviceItem.isSelected : Intrinsics.areEqual(deviceItem.getId(), id), (r20 & 64) != 0 ? deviceItem.type : null, (r20 & 128) != 0 ? deviceItem.ideVersion : null, (r20 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? deviceItem.isPaired : false);
            arrayList.add(copy);
        }
        mutableLiveData.setValue(arrayList);
    }

    public final boolean shouldDispatchDeviceListChanged() {
        int i = this.dispatchedDeviceListRevision;
        int i2 = this.deviceListRevision;
        if (i == i2) {
            return false;
        }
        this.dispatchedDeviceListRevision = i2;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logFetchResult(boolean isCodeMode, int rawCliCount, List<DeviceItem> devices) {
        int i;
        Object obj;
        int i2;
        int i3;
        int i4;
        List<DeviceItem> list = devices;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            DeviceItem deviceItem = (DeviceItem) next;
            if ((deviceItem.getType() == CliType.REMOTE || deviceItem.isOnline()) ? false : true) {
                arrayList.add(next);
            }
        }
        String joinToString$default = CollectionsKt.joinToString$default(CollectionsKt.take(arrayList, 5), (CharSequence) null, "[", "]", 0, (CharSequence) null, new Function1() { // from class: com.bytedance.trae.conversation.devices.DeviceListViewModel$$ExternalSyntheticLambda0
            public final Object invoke(Object obj2) {
                CharSequence logFetchResult$lambda$4;
                logFetchResult$lambda$4 = DeviceListViewModel.logFetchResult$lambda$4((DeviceItem) obj2);
                return logFetchResult$lambda$4;
            }
        }, 25, (Object) null);
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (it2.hasNext()) {
                obj = it2.next();
                if (((DeviceItem) obj).isSelected()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        DeviceItem deviceItem2 = (DeviceItem) obj;
        String deviceLogSummary = deviceItem2 != null ? DeviceItemKt.toDeviceLogSummary(deviceItem2) : null;
        if (deviceLogSummary == null) {
            deviceLogSummary = "";
        }
        TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
        StringBuilder append = new StringBuilder("offline_device_fetch_result: isCodeMode=").append(isCodeMode).append(", rawCliCount=").append(rawCliCount).append(", total=").append(devices.size()).append(", remote=");
        boolean z = list instanceof Collection;
        if (z && list.isEmpty()) {
            i2 = 0;
        } else {
            Iterator<T> it3 = list.iterator();
            i2 = 0;
            while (it3.hasNext()) {
                if ((((DeviceItem) it3.next()).getType() == CliType.REMOTE) && (i2 = i2 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        StringBuilder append2 = append.append(i2).append(", local=");
        if (z && list.isEmpty()) {
            i3 = 0;
        } else {
            Iterator<T> it4 = list.iterator();
            i3 = 0;
            while (it4.hasNext()) {
                if ((((DeviceItem) it4.next()).getType() == CliType.LOCAL) && (i3 = i3 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        StringBuilder append3 = append2.append(i3).append(", ide=");
        if (z && list.isEmpty()) {
            i4 = 0;
        } else {
            Iterator<T> it5 = list.iterator();
            i4 = 0;
            while (it5.hasNext()) {
                if ((((DeviceItem) it5.next()).getType() == CliType.IDE) && (i4 = i4 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        StringBuilder append4 = append3.append(i4).append(", offline=");
        if (!z || !list.isEmpty()) {
            int i5 = 0;
            for (DeviceItem deviceItem3 : list) {
                if (((deviceItem3.getType() == CliType.REMOTE || deviceItem3.isOnline()) ? false : true) && (i5 = i5 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
            i = i5;
        }
        traeLogUtil.i(TAG, append4.append(i).append(", selected=").append(deviceLogSummary).append(", offlineCandidates=").append(joinToString$default).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence logFetchResult$lambda$4(DeviceItem deviceItem) {
        Intrinsics.checkNotNullParameter(deviceItem, "it");
        return DeviceItemKt.toDeviceLogSummary(deviceItem);
    }
}
