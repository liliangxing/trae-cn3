package com.bytedance.trae.home.solo.setting;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.trae.conversation.devices.MobileDevice;
import com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: SettingsDeviceListViewModel.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 E2\u00020\u0001:\u0003EFGB\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020,J\u0016\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u0015J\u0006\u00101\u001a\u00020,J\u000e\u00102\u001a\u00020,2\u0006\u0010/\u001a\u00020\u0015J\u0006\u00103\u001a\u00020,J\u0006\u00104\u001a\u00020,J\u0006\u00105\u001a\u00020,J\u000e\u00106\u001a\u00020,2\u0006\u00107\u001a\u00020\u0005J\b\u00108\u001a\u00020,H\u0014J\u000e\u00109\u001a\u00020,H\u0082@¢\u0006\u0002\u0010:J\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020<0\u000bH\u0002J\u0018\u0010=\u001a\u00020,2\u0006\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u0015H\u0002J\u0018\u0010>\u001a\u00020,2\u0006\u0010/\u001a\u00020\u00152\u0006\u0010?\u001a\u00020\u0005H\u0002J\u0018\u0010@\u001a\u00020,2\u0006\u0010/\u001a\u00020\u00152\u0006\u0010A\u001a\u00020&H\u0002J\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00050\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u000e8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0010R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0010R\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0010R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00150!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020&0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/bytedance/trae/home/solo/setting/SettingsDeviceRepository;", "fetchOnInit", "", "<init>", "(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceRepository;Z)V", "()V", "_devices", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;", "devices", "Landroidx/lifecycle/LiveData;", "getDevices", "()Landroidx/lifecycle/LiveData;", "_isLoading", "kotlin.jvm.PlatformType", "isLoading", "_newOnlineDevice", "", "newOnlineDevice", "getNewOnlineDevice", "_renameFailed", "renameFailed", "getRenameFailed", "_unbindFailed", "unbindFailed", "getUnbindFailed", "pollingJob", "Lkotlinx/coroutines/Job;", "previousPairedDeviceIds", "", "pendingRenames", "", "Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingRename;", "pendingUnbinds", "Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;", "nextRenameRequestId", "", "nextUnbindRequestId", "newDeviceNotificationsEnabled", "fetchDevices", "", "startPolling", "renameDevice", "cliId", "newName", "onRenameFailureToastShown", "unbindDevice", "onUnbindFailureToastShown", "stopPolling", "onNewDeviceToastShown", "setNewDeviceNotificationsEnabled", "enabled", "onCleared", "refreshDevicesAfterMutation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapDevices", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "updateDeviceName", "updateDevicePairing", "isPaired", "restorePairing", "pendingUnbind", "applyPendingRenames", "items", "applyPendingUnbinds", "Companion", "PendingRename", "PendingUnbind", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsDeviceListViewModel extends ViewModel {
    private static final long POLL_INTERVAL_MS = 5000;
    private final MutableLiveData<List<SettingsDeviceItem>> _devices;
    private final MutableLiveData<Boolean> _isLoading;
    private final MutableLiveData<String> _newOnlineDevice;
    private final MutableLiveData<Boolean> _renameFailed;
    private final MutableLiveData<Boolean> _unbindFailed;
    private volatile boolean newDeviceNotificationsEnabled;
    private long nextRenameRequestId;
    private long nextUnbindRequestId;
    private final Map<String, PendingRename> pendingRenames;
    private final Map<String, PendingUnbind> pendingUnbinds;
    private Job pollingJob;
    private Set<String> previousPairedDeviceIds;
    private final SettingsDeviceRepository repository;
    public static final int $stable = 8;

    public SettingsDeviceListViewModel(SettingsDeviceRepository settingsDeviceRepository, boolean z) {
        Intrinsics.checkNotNullParameter(settingsDeviceRepository, "repository");
        this.repository = settingsDeviceRepository;
        this._devices = new MutableLiveData<>();
        this._isLoading = new MutableLiveData<>(true);
        this._newOnlineDevice = new MutableLiveData<>();
        this._renameFailed = new MutableLiveData<>();
        this._unbindFailed = new MutableLiveData<>();
        this.previousPairedDeviceIds = SetsKt.emptySet();
        this.pendingRenames = new LinkedHashMap();
        this.pendingUnbinds = new LinkedHashMap();
        this.newDeviceNotificationsEnabled = true;
        if (z) {
            fetchDevices();
        }
    }

    public SettingsDeviceListViewModel() {
        this(DefaultSettingsDeviceRepository.INSTANCE, true);
    }

    public final LiveData<List<SettingsDeviceItem>> getDevices() {
        return this._devices;
    }

    public final LiveData<Boolean> isLoading() {
        return this._isLoading;
    }

    public final LiveData<String> getNewOnlineDevice() {
        return this._newOnlineDevice;
    }

    public final LiveData<Boolean> getRenameFailed() {
        return this._renameFailed;
    }

    public final LiveData<Boolean> getUnbindFailed() {
        return this._unbindFailed;
    }

    public final void fetchDevices() {
        this._isLoading.setValue(true);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SettingsDeviceListViewModel$fetchDevices$1(this, null), 3, (Object) null);
    }

    public final void startPolling() {
        stopPolling();
        this.pollingJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SettingsDeviceListViewModel$startPolling$1(this, null), 3, (Object) null);
    }

    public final void renameDevice(String cliId, String newName) {
        Object obj;
        Intrinsics.checkNotNullParameter(cliId, "cliId");
        Intrinsics.checkNotNullParameter(newName, "newName");
        List list = (List) this._devices.getValue();
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((SettingsDeviceItem) obj).getId(), cliId)) {
                    break;
                }
            }
        }
        SettingsDeviceItem settingsDeviceItem = (SettingsDeviceItem) obj;
        if (settingsDeviceItem == null || !settingsDeviceItem.isPaired() || Intrinsics.areEqual(settingsDeviceItem.getName(), newName)) {
            return;
        }
        long j = this.nextRenameRequestId + 1;
        this.nextRenameRequestId = j;
        this.pendingRenames.put(cliId, new PendingRename(settingsDeviceItem.getName(), newName, j));
        updateDeviceName(cliId, newName);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SettingsDeviceListViewModel$renameDevice$1(this, cliId, newName, j, null), 3, (Object) null);
    }

    public final void onRenameFailureToastShown() {
        this._renameFailed.setValue((Object) null);
    }

    public final void unbindDevice(String cliId) {
        Intrinsics.checkNotNullParameter(cliId, "cliId");
        List list = (List) this._devices.getValue();
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        Iterator it = list.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(((SettingsDeviceItem) it.next()).getId(), cliId)) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        SettingsDeviceItem settingsDeviceItem = (SettingsDeviceItem) list.get(i);
        if (settingsDeviceItem.isPaired()) {
            long j = this.nextUnbindRequestId + 1;
            this.nextUnbindRequestId = j;
            this.pendingUnbinds.put(cliId, new PendingUnbind(SettingsDeviceItem.copy$default(settingsDeviceItem, null, null, false, null, false, 15, null), i, j));
            updateDevicePairing(cliId, false);
            this.previousPairedDeviceIds = SetsKt.minus(this.previousPairedDeviceIds, cliId);
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SettingsDeviceListViewModel$unbindDevice$1(this, cliId, j, null), 3, (Object) null);
        }
    }

    public final void onUnbindFailureToastShown() {
        this._unbindFailed.setValue((Object) null);
    }

    public final void stopPolling() {
        Job job = this.pollingJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.pollingJob = null;
    }

    public final void onNewDeviceToastShown() {
        this._newOnlineDevice.setValue((Object) null);
    }

    public final void setNewDeviceNotificationsEnabled(boolean enabled) {
        this.newDeviceNotificationsEnabled = enabled;
        if (enabled) {
            return;
        }
        this._newOnlineDevice.setValue((Object) null);
    }

    protected void onCleared() {
        super.onCleared();
        stopPolling();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object refreshDevicesAfterMutation(Continuation<? super Unit> continuation) {
        Object fetchDevices = this.repository.fetchDevices(new Function1() { // from class: com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit refreshDevicesAfterMutation$lambda$2;
                refreshDevicesAfterMutation$lambda$2 = SettingsDeviceListViewModel.refreshDevicesAfterMutation$lambda$2(SettingsDeviceListViewModel.this, (List) obj);
                return refreshDevicesAfterMutation$lambda$2;
            }
        }, continuation);
        return fetchDevices == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? fetchDevices : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit refreshDevicesAfterMutation$lambda$2(SettingsDeviceListViewModel settingsDeviceListViewModel, List list) {
        Intrinsics.checkNotNullParameter(list, "devices");
        List<SettingsDeviceItem> mapDevices = settingsDeviceListViewModel.mapDevices(list);
        settingsDeviceListViewModel.previousPairedDeviceIds = SettingsDeviceMapperKt.pairedDeviceIds(mapDevices);
        settingsDeviceListViewModel._devices.postValue(mapDevices);
        settingsDeviceListViewModel._isLoading.postValue(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SettingsDeviceItem> mapDevices(List<MobileDevice> devices) {
        return applyPendingUnbinds(applyPendingRenames(SettingsDeviceMapperKt.toSettingsDeviceItems(devices)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDeviceName(String cliId, String newName) {
        MutableLiveData<List<SettingsDeviceItem>> mutableLiveData = this._devices;
        List list = (List) mutableLiveData.getValue();
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List<SettingsDeviceItem> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (SettingsDeviceItem settingsDeviceItem : list2) {
            if (Intrinsics.areEqual(settingsDeviceItem.getId(), cliId)) {
                settingsDeviceItem = SettingsDeviceItem.copy$default(settingsDeviceItem, null, newName, false, null, false, 29, null);
            }
            arrayList.add(settingsDeviceItem);
        }
        mutableLiveData.setValue(arrayList);
    }

    private final void updateDevicePairing(String cliId, boolean isPaired) {
        MutableLiveData<List<SettingsDeviceItem>> mutableLiveData = this._devices;
        List list = (List) mutableLiveData.getValue();
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List<SettingsDeviceItem> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (SettingsDeviceItem settingsDeviceItem : list2) {
            if (Intrinsics.areEqual(settingsDeviceItem.getId(), cliId)) {
                settingsDeviceItem = SettingsDeviceItem.copy$default(settingsDeviceItem, null, null, false, null, isPaired, 15, null);
            }
            arrayList.add(settingsDeviceItem);
        }
        mutableLiveData.setValue(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void restorePairing(String cliId, PendingUnbind pendingUnbind) {
        List list = (List) this._devices.getValue();
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List mutableList = CollectionsKt.toMutableList(list);
        Iterator it = mutableList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(((SettingsDeviceItem) it.next()).getId(), cliId)) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            mutableList.set(i, SettingsDeviceItem.copy$default((SettingsDeviceItem) mutableList.get(i), null, null, false, null, true, 15, null));
        } else {
            mutableList.add(RangesKt.coerceIn(pendingUnbind.getOriginalIndex(), 0, mutableList.size()), SettingsDeviceItem.copy$default(pendingUnbind.getOptimisticItem(), null, null, false, null, true, 15, null));
        }
        this._devices.setValue(mutableList);
    }

    private final List<SettingsDeviceItem> applyPendingRenames(List<SettingsDeviceItem> items) {
        ArrayList arrayList = new ArrayList();
        List<SettingsDeviceItem> list = items;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (SettingsDeviceItem settingsDeviceItem : list) {
            PendingRename pendingRename = this.pendingRenames.get(settingsDeviceItem.getId());
            if (pendingRename != null) {
                if (Intrinsics.areEqual(settingsDeviceItem.getName(), pendingRename.getNewName())) {
                    arrayList.add(settingsDeviceItem.getId());
                } else {
                    settingsDeviceItem = SettingsDeviceItem.copy$default(settingsDeviceItem, null, pendingRename.getNewName(), false, null, false, 29, null);
                }
            }
            arrayList2.add(settingsDeviceItem);
        }
        ArrayList arrayList3 = arrayList2;
        Map<String, PendingRename> map = this.pendingRenames;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            map.remove((String) it.next());
        }
        return arrayList3;
    }

    private final List<SettingsDeviceItem> applyPendingUnbinds(List<SettingsDeviceItem> items) {
        List<SettingsDeviceItem> list = items;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            SettingsDeviceItem settingsDeviceItem = (SettingsDeviceItem) next;
            if (!settingsDeviceItem.isPaired() && this.pendingUnbinds.containsKey(settingsDeviceItem.getId())) {
                z = true;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((SettingsDeviceItem) it2.next()).getId());
        }
        Map<String, PendingUnbind> map = this.pendingUnbinds;
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            map.remove((String) it3.next());
        }
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (SettingsDeviceItem settingsDeviceItem2 : list) {
            if (this.pendingUnbinds.containsKey(settingsDeviceItem2.getId())) {
                settingsDeviceItem2 = SettingsDeviceItem.copy$default(settingsDeviceItem2, null, null, false, null, false, 15, null);
            }
            arrayList4.add(settingsDeviceItem2);
        }
        List<SettingsDeviceItem> mutableList = CollectionsKt.toMutableList(arrayList4);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it4 = mutableList.iterator();
        while (it4.hasNext()) {
            linkedHashSet.add(((SettingsDeviceItem) it4.next()).getId());
        }
        LinkedHashSet linkedHashSet2 = linkedHashSet;
        for (PendingUnbind pendingUnbind : CollectionsKt.sortedWith(this.pendingUnbinds.values(), new Comparator() { // from class: com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel$applyPendingUnbinds$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((SettingsDeviceListViewModel.PendingUnbind) t).getOriginalIndex()), Integer.valueOf(((SettingsDeviceListViewModel.PendingUnbind) t2).getOriginalIndex()));
            }
        })) {
            if (linkedHashSet2.add(pendingUnbind.getOptimisticItem().getId())) {
                mutableList.add(RangesKt.coerceIn(pendingUnbind.getOriginalIndex(), 0, mutableList.size()), pendingUnbind.getOptimisticItem());
            }
        }
        return mutableList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SettingsDeviceListViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingRename;", "", "oldName", "", "newName", "requestId", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getOldName", "()Ljava/lang/String;", "getNewName", "getRequestId", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class PendingRename {
        private final String newName;
        private final String oldName;
        private final long requestId;

        public static /* synthetic */ PendingRename copy$default(PendingRename pendingRename, String str, String str2, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pendingRename.oldName;
            }
            if ((i & 2) != 0) {
                str2 = pendingRename.newName;
            }
            if ((i & 4) != 0) {
                j = pendingRename.requestId;
            }
            return pendingRename.copy(str, str2, j);
        }

        /* renamed from: component1, reason: from getter */
        public final String getOldName() {
            return this.oldName;
        }

        /* renamed from: component2, reason: from getter */
        public final String getNewName() {
            return this.newName;
        }

        /* renamed from: component3, reason: from getter */
        public final long getRequestId() {
            return this.requestId;
        }

        public final PendingRename copy(String oldName, String newName, long requestId) {
            Intrinsics.checkNotNullParameter(oldName, "oldName");
            Intrinsics.checkNotNullParameter(newName, "newName");
            return new PendingRename(oldName, newName, requestId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingRename)) {
                return false;
            }
            PendingRename pendingRename = (PendingRename) other;
            return Intrinsics.areEqual(this.oldName, pendingRename.oldName) && Intrinsics.areEqual(this.newName, pendingRename.newName) && this.requestId == pendingRename.requestId;
        }

        public int hashCode() {
            return (((this.oldName.hashCode() * 31) + this.newName.hashCode()) * 31) + Long.hashCode(this.requestId);
        }

        public String toString() {
            return "PendingRename(oldName=" + this.oldName + ", newName=" + this.newName + ", requestId=" + this.requestId + ')';
        }

        public PendingRename(String str, String str2, long j) {
            Intrinsics.checkNotNullParameter(str, "oldName");
            Intrinsics.checkNotNullParameter(str2, "newName");
            this.oldName = str;
            this.newName = str2;
            this.requestId = j;
        }

        public final String getOldName() {
            return this.oldName;
        }

        public final String getNewName() {
            return this.newName;
        }

        public final long getRequestId() {
            return this.requestId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SettingsDeviceListViewModel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;", "", "optimisticItem", "Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;", "originalIndex", "", "requestId", "", "<init>", "(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;IJ)V", "getOptimisticItem", "()Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;", "getOriginalIndex", "()I", "getRequestId", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class PendingUnbind {
        private final SettingsDeviceItem optimisticItem;
        private final int originalIndex;
        private final long requestId;

        public static /* synthetic */ PendingUnbind copy$default(PendingUnbind pendingUnbind, SettingsDeviceItem settingsDeviceItem, int i, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                settingsDeviceItem = pendingUnbind.optimisticItem;
            }
            if ((i2 & 2) != 0) {
                i = pendingUnbind.originalIndex;
            }
            if ((i2 & 4) != 0) {
                j = pendingUnbind.requestId;
            }
            return pendingUnbind.copy(settingsDeviceItem, i, j);
        }

        /* renamed from: component1, reason: from getter */
        public final SettingsDeviceItem getOptimisticItem() {
            return this.optimisticItem;
        }

        /* renamed from: component2, reason: from getter */
        public final int getOriginalIndex() {
            return this.originalIndex;
        }

        /* renamed from: component3, reason: from getter */
        public final long getRequestId() {
            return this.requestId;
        }

        public final PendingUnbind copy(SettingsDeviceItem optimisticItem, int originalIndex, long requestId) {
            Intrinsics.checkNotNullParameter(optimisticItem, "optimisticItem");
            return new PendingUnbind(optimisticItem, originalIndex, requestId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingUnbind)) {
                return false;
            }
            PendingUnbind pendingUnbind = (PendingUnbind) other;
            return Intrinsics.areEqual(this.optimisticItem, pendingUnbind.optimisticItem) && this.originalIndex == pendingUnbind.originalIndex && this.requestId == pendingUnbind.requestId;
        }

        public int hashCode() {
            return (((this.optimisticItem.hashCode() * 31) + Integer.hashCode(this.originalIndex)) * 31) + Long.hashCode(this.requestId);
        }

        public String toString() {
            return "PendingUnbind(optimisticItem=" + this.optimisticItem + ", originalIndex=" + this.originalIndex + ", requestId=" + this.requestId + ')';
        }

        public PendingUnbind(SettingsDeviceItem settingsDeviceItem, int i, long j) {
            Intrinsics.checkNotNullParameter(settingsDeviceItem, "optimisticItem");
            this.optimisticItem = settingsDeviceItem;
            this.originalIndex = i;
            this.requestId = j;
        }

        public final SettingsDeviceItem getOptimisticItem() {
            return this.optimisticItem;
        }

        public final int getOriginalIndex() {
            return this.originalIndex;
        }

        public final long getRequestId() {
            return this.requestId;
        }
    }
}
