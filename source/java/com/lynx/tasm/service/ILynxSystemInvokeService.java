package com.lynx.tasm.service;

import android.content.ClipData;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaMetadataRetriever;
import android.os.RemoteException;
import android.view.View;

/* loaded from: classes7.dex */
public interface ILynxSystemInvokeService extends IServiceProvider {
    String extractMetadata(MediaMetadataRetriever mediaMetadataRetriever, int i);

    String getLocale();

    Camera openCamera(int i) throws RuntimeException;

    boolean registerSensorListener(SensorManager sensorManager, SensorEventListener sensorEventListener, Sensor sensor, int i);

    void releaseCamera(Camera camera);

    void setPrimaryClip(ClipData clipData) throws RemoteException;

    Bitmap takeScreenshot(View view, Bitmap.Config config);

    void unregisterSensorListener(SensorManager sensorManager, SensorEventListener sensorEventListener);

    @Override // com.lynx.tasm.service.IServiceProvider
    default Class<? extends IServiceProvider> getServiceClass() {
        return ILynxSystemInvokeService.class;
    }
}
