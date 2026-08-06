package com.bytedance.crash.looper;

import android.os.Message;
import com.bytedance.apm.block.ILooperObserver;
import com.bytedance.apm.block.LooperObserverMonitor;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import java.io.File;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LooperMessageRecorder implements ILooperObserver {
    private static final LooperMessageRecorder sInstance = new LooperMessageRecorder();
    private boolean mIsStarted;
    private final LooperMessageManager mMessageManager = new LooperMessageManager();

    public static LooperMessageRecorder getInstance() {
        return sInstance;
    }

    public synchronized void start() {
        if (this.mIsStarted) {
            return;
        }
        this.mIsStarted = true;
        this.mMessageManager.start();
        LooperObserverMonitor.init(null);
        LooperObserverMonitor.addMessageObserver(this);
    }

    public void stop() {
        this.mIsStarted = false;
        this.mMessageManager.stop();
        LooperObserverMonitor.removeMessageObserver(this);
    }

    @Override // com.bytedance.apm.block.ILooperObserver
    public void messageDispatchStarting(String str) {
        this.mMessageManager.onMessage(null);
    }

    @Override // com.bytedance.apm.block.ILooperObserver
    public void messageDispatched(String str, Message message) {
        this.mMessageManager.onMessage(message);
    }

    public void dumpMessages(File file) {
        this.mMessageManager.dumpMessages(file);
    }

    public static void load(JSONObject jSONObject, File file) {
        loadFile(jSONObject, LooperMessageConfig.getCurrentJsonFile(file));
        loadFile(jSONObject, LooperMessageConfig.getHistoryJsonFile(file));
        loadFile(jSONObject, LooperMessageConfig.getPendingJsonFile(file));
        loadFile(jSONObject, LooperMessageConfig.getBlockStackJsonFile(file));
    }

    private static void loadFile(JSONObject jSONObject, File file) {
        try {
            String readUtf8File = FileSystemUtils.readUtf8File(file);
            if (readUtf8File != null) {
                JSONUtils.combineJson(jSONObject, new JSONObject(readUtf8File));
            }
        } catch (Exception unused) {
        }
    }
}
