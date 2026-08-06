package com.ss.bytertc.base.media.camera;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import androidx.core.content.ContextCompat;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class VideoDeviceMonitorAndroid {
    private static final String TAG = "VideoDeviceMonitorAndroid";
    private long mNativeHandle;
    private final BroadcastReceiver mUsbReceiver = new BroadcastReceiver() { // from class: com.ss.bytertc.base.media.camera.VideoDeviceMonitorAndroid.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
            if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action)) {
                VideoDeviceMonitorAndroid.this.processorAttached(usbDevice);
            } else if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(action)) {
                VideoDeviceMonitorAndroid.this.processorDetached(usbDevice);
            }
        }
    };
    private final Context mContext = ContextUtils.getApplicationContext();

    private static native void nativeOnUsbCameraChanged(long nativeHandle, boolean isAttached);

    VideoDeviceMonitorAndroid(long nativeHandle) {
        this.mNativeHandle = nativeHandle;
    }

    public void registerUsbAction() {
        RXLogging.w(TAG, "registerUsbAction");
        if (this.mUsbReceiver == null || this.mContext == null) {
            RXLogging.w(TAG, "registerUsbAction fail");
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
            intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
            m203xa66973e6(this.mContext, this.mUsbReceiver, intentFilter);
        } catch (Exception e) {
            RXLogging.e(TAG, "registerUsbAction exception: " + e.getMessage());
        }
    }

    public void unregisterUsbAction() {
        Context context;
        RXLogging.w(TAG, "unregisterUsbAction");
        BroadcastReceiver broadcastReceiver = this.mUsbReceiver;
        if (broadcastReceiver == null || (context = this.mContext) == null) {
            RXLogging.w(TAG, "unregisterUsbAction fail");
            return;
        }
        try {
            m204x96a9737f(context, broadcastReceiver);
        } catch (Exception e) {
            RXLogging.e(TAG, "unregisterUsbAction exception: " + e.getMessage());
        }
    }

    private Boolean isUsbCamera(UsbDevice usbDevice) {
        RXLogging.w(TAG, "isUsbCamera");
        Boolean bool = false;
        if (usbDevice.getDeviceClass() != 14) {
            if (usbDevice.getDeviceClass() == 239) {
                for (int i = 0; i < usbDevice.getInterfaceCount(); i++) {
                    if (usbDevice.getInterface(i).getInterfaceClass() != 14) {
                    }
                }
            }
            RXLogging.w(TAG, "DeviceClass: " + usbDevice.getDeviceClass() + " result: " + bool);
            return bool;
        }
        bool = true;
        RXLogging.w(TAG, "DeviceClass: " + usbDevice.getDeviceClass() + " result: " + bool);
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processorAttached(final UsbDevice usbDevice) {
        if (!isUsbCamera(usbDevice).booleanValue()) {
            RXLogging.w(TAG, "processorAttached, is not Usb camera");
        } else {
            nativeOnUsbCameraChanged(this.mNativeHandle, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processorDetached(final UsbDevice usbDevice) {
        if (!isUsbCamera(usbDevice).booleanValue()) {
            RXLogging.w(TAG, "processorDetached, is not Usb camera");
        } else {
            nativeOnUsbCameraChanged(this.mNativeHandle, false);
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_ss_bytertc_base_media_camera_VideoDeviceMonitorAndroid_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m203xa66973e6(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context2 = context;
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context3 = context;
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    /* renamed from: INVOKEVIRTUAL_com_ss_bytertc_base_media_camera_VideoDeviceMonitorAndroid_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m204x96a9737f(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}
