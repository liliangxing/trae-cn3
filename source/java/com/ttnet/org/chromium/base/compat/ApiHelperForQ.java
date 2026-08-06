package com.ttnet.org.chromium.base.compat;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.hardware.biometrics.BiometricManager;
import android.net.NetworkCapabilities;
import android.net.TransportInfo;
import android.net.Uri;
import android.os.FileUtils;
import android.os.PowerManager;
import android.provider.MediaStore;
import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import android.view.MotionEvent;
import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.task.AsyncTask;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class ApiHelperForQ {
    private ApiHelperForQ() {
    }

    public static void requestCellInfoUpdate(TelephonyManager telephonyManager, final Callback<List<CellInfo>> callback) {
        telephonyManager.requestCellInfoUpdate(AsyncTask.THREAD_POOL_EXECUTOR, new TelephonyManager.CellInfoCallback() { // from class: com.ttnet.org.chromium.base.compat.ApiHelperForQ.1
            @Override // android.telephony.TelephonyManager.CellInfoCallback
            public void onCellInfo(List<CellInfo> list) {
                Callback.this.onResult(list);
            }
        });
    }

    public static boolean bindIsolatedService(Context context, Intent intent, int i, String str, Executor executor, ServiceConnection serviceConnection) {
        return context.bindIsolatedService(intent, i, str, executor, serviceConnection);
    }

    public static void updateServiceGroup(Context context, ServiceConnection serviceConnection, int i, int i2) {
        context.updateServiceGroup(serviceConnection, i, i2);
    }

    public static int getClassification(MotionEvent motionEvent) {
        return motionEvent.getClassification();
    }

    public static BiometricManager getBiometricManagerSystemService(Context context) {
        return (BiometricManager) context.getSystemService(BiometricManager.class);
    }

    public static void startForeground(Service service, int i, Notification notification, int i2) {
        service.startForeground(i, notification, i2);
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        return FileUtils.copy(inputStream, outputStream);
    }

    public static Uri setIncludePending(Uri uri) {
        return MediaStore.setIncludePending(uri);
    }

    public static Set<String> getExternalVolumeNames(Context context) {
        return MediaStore.getExternalVolumeNames(context);
    }

    public static int canAuthenticate(BiometricManager biometricManager) {
        return biometricManager.canAuthenticate();
    }

    public static TransportInfo getTransportInfo(NetworkCapabilities networkCapabilities) {
        return networkCapabilities.getTransportInfo();
    }

    public static int getCurrentThermalStatus(PowerManager powerManager) {
        return powerManager.getCurrentThermalStatus();
    }
}
