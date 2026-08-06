package com.bytedance.trae.conversation.devices;

import com.bytedance.trae.conversation.devices.BindingGuideStableState;
import com.bytedance.trae.conversation.devices.BindingGuideState;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DeviceBindingPolicy.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u0006\u0010\u0016\u001a\u00020\u000bJ\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;", "", "target", "Lcom/bytedance/trae/conversation/devices/BindingTarget;", "<init>", "(Lcom/bytedance/trae/conversation/devices/BindingTarget;)V", "value", "", "lockedDeviceId", "getLockedDeviceId", "()Ljava/lang/String;", "Lcom/bytedance/trae/conversation/devices/BindingGuideState;", "currentState", "getCurrentState", "()Lcom/bytedance/trae/conversation/devices/BindingGuideState;", "successConsumed", "", "onRefreshSucceeded", "Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;", "devices", "", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "onRefreshFailed", "consumeSucceededDevice", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BindingGuideStateMachine {
    private BindingGuideState currentState;
    private String lockedDeviceId;
    private boolean successConsumed;
    private final BindingTarget target;

    public BindingGuideStateMachine(BindingTarget bindingTarget) {
        Intrinsics.checkNotNullParameter(bindingTarget, "target");
        this.target = bindingTarget;
        String deviceId = bindingTarget.getDeviceId();
        this.lockedDeviceId = (deviceId == null || !(StringsKt.isBlank(deviceId) ^ true)) ? null : deviceId;
        this.currentState = new BindingGuideStableState.WaitingForDesktop(this.lockedDeviceId);
    }

    public final String getLockedDeviceId() {
        return this.lockedDeviceId;
    }

    public final BindingGuideState getCurrentState() {
        return this.currentState;
    }

    public final BindingGuideStableState onRefreshSucceeded(List<MobileDevice> devices) {
        BindingGuideStableState.WaitingForAuthorization waitingForAuthorization;
        Object obj;
        Intrinsics.checkNotNullParameter(devices, "devices");
        BindingGuideStableState displayState = this.currentState.getDisplayState();
        Object obj2 = null;
        BindingGuideStableState.Succeeded succeeded = displayState instanceof BindingGuideStableState.Succeeded ? (BindingGuideStableState.Succeeded) displayState : null;
        if (succeeded != null) {
            return succeeded;
        }
        if (this.lockedDeviceId == null) {
            Iterator<T> it = devices.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                MobileDevice mobileDevice = (MobileDevice) obj;
                if (mobileDevice.getProductType() == this.target.getProductType() && !this.target.getExistingDeviceIds().contains(mobileDevice.getId()) && mobileDevice.isOnline()) {
                    break;
                }
            }
            MobileDevice mobileDevice2 = (MobileDevice) obj;
            this.lockedDeviceId = mobileDevice2 != null ? mobileDevice2.getId() : null;
        }
        String str = this.lockedDeviceId;
        Iterator<T> it2 = devices.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            MobileDevice mobileDevice3 = (MobileDevice) next;
            if (Intrinsics.areEqual(mobileDevice3.getId(), str) && mobileDevice3.getProductType() == this.target.getProductType()) {
                obj2 = next;
                break;
            }
        }
        MobileDevice mobileDevice4 = (MobileDevice) obj2;
        if (mobileDevice4 == null) {
            waitingForAuthorization = new BindingGuideStableState.WaitingForDesktop(str);
        } else if (mobileDevice4.isPaired()) {
            waitingForAuthorization = new BindingGuideStableState.Succeeded(mobileDevice4);
        } else if (!mobileDevice4.isOnline()) {
            waitingForAuthorization = new BindingGuideStableState.WaitingForDesktop(str);
        } else {
            waitingForAuthorization = new BindingGuideStableState.WaitingForAuthorization(mobileDevice4.getId());
        }
        this.currentState = waitingForAuthorization;
        return waitingForAuthorization;
    }

    public final BindingGuideState onRefreshFailed() {
        BindingGuideState.RefreshFailed refreshFailed = new BindingGuideState.RefreshFailed(this.currentState.getDisplayState());
        this.currentState = refreshFailed;
        return refreshFailed;
    }

    public final MobileDevice consumeSucceededDevice() {
        if (this.successConsumed) {
            return null;
        }
        BindingGuideStableState displayState = this.currentState.getDisplayState();
        BindingGuideStableState.Succeeded succeeded = displayState instanceof BindingGuideStableState.Succeeded ? (BindingGuideStableState.Succeeded) displayState : null;
        if (succeeded == null) {
            return null;
        }
        this.successConsumed = true;
        return succeeded.getDevice();
    }
}
