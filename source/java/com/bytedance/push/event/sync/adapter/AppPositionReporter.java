package com.bytedance.push.event.sync.adapter;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.WindowManager;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.appstatus.AppStatusObserverForChildProcess;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.push.settings.signal.sync.SignalReportConfig;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AppPositionReporter extends AbsSignalReporterAdapter implements Observer {
    private final String TAG = "AppPositionReporter";

    @Override // com.bytedance.push.event.sync.adapter.AbsSignalReporterAdapter
    String getSignalName() {
        return ISignalReportConstants.SIGNAL_NAME_APP_POSITION;
    }

    @Override // com.bytedance.push.event.sync.adapter.AbsSignalReporterAdapter
    public void startSignalReport(String str, SignalReportConfig signalReportConfig) {
        super.startSignalReport(str, signalReportConfig);
        if (AppStatusObserverForChildProcess.getIns().hasForeGround()) {
            reportAppPositionSignal();
        } else {
            AppStatusObserverForChildProcess.getIns().addObserver(this);
        }
    }

    private void reportAppPositionSignal() {
        Rect launchSourceBounds = ActivityLifecycleObserver.getIns().getLaunchSourceBounds();
        if (launchSourceBounds != null) {
            Point deviceTotalSize = getDeviceTotalSize(AppProvider.getApp());
            int i = deviceTotalSize.x;
            int i2 = deviceTotalSize.y;
            Logger.m268d("AppPositionReporter", "[reportAppPositionSignal]deviceWidth:" + i + " deviceHeight:" + i2 + " icon_widget:" + launchSourceBounds.width() + " icon_height:" + launchSourceBounds.height());
            JSONObject jSONObject = new JSONObject();
            add(jSONObject, ISignalReportConstants.KEY_ICON_LEFT, launchSourceBounds.left);
            add(jSONObject, ISignalReportConstants.KEY_ICON_TOP, launchSourceBounds.top);
            add(jSONObject, ISignalReportConstants.KEY_ICON_RIGHT, launchSourceBounds.right);
            add(jSONObject, ISignalReportConstants.KEY_ICON_BOTTOM, launchSourceBounds.bottom);
            add(jSONObject, ISignalReportConstants.KEY_ICON_WIDTH, launchSourceBounds.width());
            add(jSONObject, ISignalReportConstants.KEY_ICON_HEIGHT, launchSourceBounds.height());
            add(jSONObject, ISignalReportConstants.KEY_DEVICE_WIDTH, i);
            add(jSONObject, ISignalReportConstants.KEY_DEVICE_HEIGHT, i2);
            PushSupporter.get().getSignalReportService().getISignalReporter().reportSignal(this.mSignalReportConfig, getSignalName(), this.mTriggerScene, jSONObject);
        }
    }

    private Point getDeviceTotalSize(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (((Boolean) obj).booleanValue()) {
            return;
        }
        AppStatusObserverForChildProcess.getIns().deleteObserver(this);
        reportAppPositionSignal();
    }
}
