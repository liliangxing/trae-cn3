package com.bytedance.bdturing.livedetect.camera;

import com.bytedance.bdturing.utils.JsonUtils;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CameraImageHandleTask extends Thread {
    private CameraFrameDataCallBack mCallBack;
    private ArrayBlockingQueue<ImageRawData> mImageQueue = new ArrayBlockingQueue<>(1);
    private AtomicBoolean canAddElement = new AtomicBoolean(true);
    private AtomicBoolean canceled = new AtomicBoolean(false);

    public CameraImageHandleTask(CameraFrameDataCallBack cameraFrameDataCallBack) {
        this.mCallBack = cameraFrameDataCallBack;
        setName("turing_live_detect");
    }

    public void putImage(ImageRawData imageRawData) {
        try {
            if (this.mImageQueue.isEmpty() && imageRawData != null && this.canAddElement.get()) {
                this.mImageQueue.put(imageRawData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (!this.canceled.get()) {
            try {
                ImageRawData take = this.mImageQueue.take();
                this.canAddElement.set(false);
                long currentTimeMillis = System.currentTimeMillis();
                ImageDataWrapper buildBitmap = ImageUtil.buildBitmap(take);
                JSONObject jSONObject = new JSONObject();
                JsonUtils.putValue(jSONObject, "convert_camera_data_time_use", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                if (this.mCallBack != null && buildBitmap != null && buildBitmap.bitmap != null) {
                    this.mCallBack.onFrameData(buildBitmap, jSONObject);
                }
                this.canAddElement.set(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void release() {
        this.mCallBack = null;
        this.canceled.set(true);
        this.canAddElement.set(true);
        ArrayBlockingQueue<ImageRawData> arrayBlockingQueue = this.mImageQueue;
        if (arrayBlockingQueue != null) {
            arrayBlockingQueue.clear();
        }
        interrupt();
    }
}
