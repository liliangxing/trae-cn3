package com.bytedance.ies.bullet.service.receiver.headset;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeadSetReceiver.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/bullet/service/receiver/headset/HeadSetReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "listenerMaps", "", "", "Lcom/bytedance/ies/bullet/service/receiver/headset/IHeadSetListener;", "notifyBTHeadsetConnectionChange", "", "isConnect", "", "notifyWiredHeadsetConnectionChange", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "registerListener", "containerId", "listener", "unRegisterListener", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class HeadSetReceiver extends BroadcastReceiver {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EVENT_NAME_HEAD_SET_PLUG = "campaign.onHeadsetPlug";
    private static final int STATE_UNKNOWN = -1;
    private static final int STATE_WIRED_HEADSET_PLUGGED = 1;
    private static final String TAG = "HeadSetReceiver";
    private final Map<String, IHeadSetListener> listenerMaps = new LinkedHashMap();

    /* compiled from: HeadSetReceiver.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/service/receiver/headset/HeadSetReceiver$Companion;", "", "()V", "EVENT_NAME_HEAD_SET_PLUG", "", "STATE_UNKNOWN", "", "STATE_WIRED_HEADSET_PLUGGED", "TAG", "getIntentFilter", "Landroid/content/IntentFilter;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IntentFilter getIntentFilter() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
            return intentFilter;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        BulletLogger.onLog$default(BulletLogger.INSTANCE, "onReceive broadcast receiver, action=" + (intent != null ? intent.getAction() : null), null, 2, null);
        if (intent == null || (action = intent.getAction()) == null) {
            return;
        }
        int hashCode = action.hashCode();
        if (hashCode == -1676458352) {
            if (action.equals("android.intent.action.HEADSET_PLUG")) {
                int intExtra = intent.getIntExtra("state", -1);
                BulletLogger.onLog$default(BulletLogger.INSTANCE, "action = ACTION_HEADSET_PLUG, state=" + intExtra + ", device=" + intent.getStringExtra("name") + ", hasMicrophone=" + intent.getIntExtra("microphone", -1), null, 2, null);
                notifyWiredHeadsetConnectionChange(intExtra == 1);
                return;
            }
            return;
        }
        if (hashCode == 545516589 && action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
            int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
            String stringExtra = intent.getStringExtra("android.bluetooth.device.extra.DEVICE");
            BulletLogger.onLog$default(BulletLogger.INSTANCE, "action = ACTION_CONNECTION_STATE_CHANGED, state=" + intExtra2 + ", device=" + stringExtra, null, 2, null);
            if (intExtra2 == 0) {
                BulletLogger.onLog$default(BulletLogger.INSTANCE, "BT headset connection state change, device=" + stringExtra + ", disconnected", null, 2, null);
                notifyBTHeadsetConnectionChange(false);
            } else {
                if (intExtra2 != 2) {
                    return;
                }
                BulletLogger.onLog$default(BulletLogger.INSTANCE, "BT headset connection state change, device=" + stringExtra + ", connected", null, 2, null);
                notifyBTHeadsetConnectionChange(true);
            }
        }
    }

    private final void notifyWiredHeadsetConnectionChange(boolean isConnect) {
        synchronized (this.listenerMaps) {
            Iterator<Map.Entry<String, IHeadSetListener>> it = this.listenerMaps.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().onPlug(isConnect, HeadSetType.WIRED);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void notifyBTHeadsetConnectionChange(boolean isConnect) {
        synchronized (this.listenerMaps) {
            Iterator<Map.Entry<String, IHeadSetListener>> it = this.listenerMaps.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().onPlug(isConnect, HeadSetType.BLUETOOTH);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void registerListener(String containerId, IHeadSetListener listener) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.listenerMaps) {
            if (!this.listenerMaps.containsKey(containerId)) {
                this.listenerMaps.put(containerId, listener);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void unRegisterListener(String containerId) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        synchronized (this.listenerMaps) {
            this.listenerMaps.remove(containerId);
        }
    }
}
