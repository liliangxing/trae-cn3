package com.bytedance.push.process.manager;

import android.content.Context;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.process.cross.CrossProcessHelper;
import com.bytedance.common.push.BaseJson;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.BDPush;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.alive.AliveKeeperProxy;
import com.bytedance.push.appstatus.AppStatusObserverForChildProcess;
import com.bytedance.push.interfaze.IProcessManagerService;
import com.bytedance.push.log.MessageLogClientManager;
import com.bytedance.push.settings.StatisticsSettings;
import com.bytedance.push.settings.delay.start.DelayStartChildProcessSettingsModel;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.setting.PushSetting;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ProcessManagerService extends BaseJson implements IProcessManagerService {
    public static final int DELAY_TO_BACKGROUND = 1;
    public static final int DELAY_TO_BACKGROUND_WITH_TIMEOUT = 2;
    public static final int DELAY_UNTIL_HOST_START = 3;
    public static final int NOT_DELAY = 0;
    public static final int UNKNOWN = -1;
    private Context mContext;
    private int mDelayStartChildProcessMode;
    private DelayStartChildProcessSettingsModel mDelayStartChildProcessSettingsModel;
    private ProcessEnum mWorkerProcessEnum;
    private long mDelayStartChildProcessTimeoutInMill = StatisticsSettings.DEFAULT_STATS_INTERVAL;
    private final String TAG = "ProcessManagerService";
    private boolean mAllowStartChildProcess = true;
    private boolean mHasStartNonMainProcess = false;
    private final AtomicBoolean mStarted = new AtomicBoolean(false);

    public ProcessManagerService(Context context) {
        this.mDelayStartChildProcessMode = -1;
        this.mContext = context;
        if (PushCommonSupport.getInstance().getPushConfigurationService().keepOldInitTimeCost()) {
            initSettingsInternal();
        }
        if (PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration.disableAutoStartChildProcess()) {
            Logger.m268d("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerServiceset mDelayStartChildProcessMode to DELAY_UNTIL_HOST_START because com.bytedance.common.push.interfaze.IPushCommonConfiguration.disableAutoStartChildProcess is true");
            this.mDelayStartChildProcessMode = 3;
        }
        init();
    }

    private void init() {
        boolean z = this.mDelayStartChildProcessMode == 0;
        this.mAllowStartChildProcess = z;
        if (z) {
            this.mWorkerProcessEnum = ProcessEnum.PUSH;
        } else {
            this.mWorkerProcessEnum = ProcessEnum.MAIN;
        }
        Logger.m268d("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerService mAllowStartChildProcess is " + this.mAllowStartChildProcess + " because mDelayStartChildProcessMode is " + this.mDelayStartChildProcessMode);
    }

    @Override // com.bytedance.push.interfaze.IProcessManagerService
    public boolean allowStartNonMainProcess() {
        checkDelayStartChildProcessSettings();
        return this.mAllowStartChildProcess;
    }

    @Override // com.bytedance.push.interfaze.IProcessManagerService
    public boolean settingsAllowStartNonMainProcess() {
        checkDelayStartChildProcessSettings();
        return this.mDelayStartChildProcessMode == 0;
    }

    @Override // com.bytedance.push.interfaze.IProcessManagerService
    public List<Integer> needDisableChannelWhenStrictMode() {
        checkDelayStartChildProcessSettings();
        if (this.mDelayStartChildProcessSettingsModel == null) {
            initSettingsInternal();
        }
        return this.mDelayStartChildProcessSettingsModel.needDisableChannel;
    }

    private void checkDelayStartChildProcessSettings() {
        if (PushCommonSupport.getInstance().getPushConfigurationService().keepOldInitTimeCost()) {
            return;
        }
        initSettingsInternal();
    }

    private void initSettingsInternal() {
        Logger.m268d("ProcessManagerService", "[initSettingsInternal]mDelayStartChildProcessSettingsModel:" + this.mDelayStartChildProcessSettingsModel);
        if (this.mDelayStartChildProcessSettingsModel == null) {
            this.mDelayStartChildProcessSettingsModel = PushSetting.getInstance().getPushOnLineSettings().getDelayStartChildProcessSettings();
            boolean depthsInMainProcess = PushServiceManager.get().getIAllianceService().depthsInMainProcess(this.mContext);
            Logger.m268d("ProcessManagerService", "[initSettingsInternal]depthsInMainProcess:" + depthsInMainProcess + " mDelayStartChildProcessMode:" + this.mDelayStartChildProcessMode);
            if (this.mDelayStartChildProcessMode == -1) {
                if (depthsInMainProcess) {
                    this.mDelayStartChildProcessMode = 3;
                } else {
                    this.mDelayStartChildProcessMode = this.mDelayStartChildProcessSettingsModel.delayStartChildProcessMode;
                }
            }
            this.mDelayStartChildProcessTimeoutInMill = this.mDelayStartChildProcessSettingsModel.delayStartChildProcessTimeoutInMill;
            init();
        }
    }

    @Override // com.bytedance.push.interfaze.IProcessManagerService
    public void onMainProcessStart(Context context) {
        if (ToolUtils.isMainProcess(context) && this.mStarted.compareAndSet(false, true)) {
            checkDelayStartChildProcessSettings();
            Logger.m268d("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerService onMainProcessStart, mDelayStartChildProcessMode is " + this.mDelayStartChildProcessMode + " cur is isInBackGround:" + AppStatusObserverForChildProcess.sIsInBackGround());
            int i = this.mDelayStartChildProcessMode;
            if (i == 2 || i == 1) {
                if (i == 2) {
                    Logger.m268d("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerService-->startNonMainProcess after background with timeout: " + this.mDelayStartChildProcessTimeoutInMill);
                    PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.process.manager.ProcessManagerService.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Logger.m268d("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerService-->startNonMainProcess because timeout");
                            BDPush.getPushService().startNonMainProcess();
                        }
                    }, this.mDelayStartChildProcessTimeoutInMill);
                }
                AppStatusObserverForChildProcess.getIns().addObserver(new Observer() { // from class: com.bytedance.push.process.manager.ProcessManagerService.2
                    @Override // java.util.Observer
                    public void update(Observable observable, Object obj) {
                        if (((Boolean) obj).booleanValue()) {
                            if (!ProcessManagerService.this.mHasStartNonMainProcess) {
                                Logger.m268d("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerService-->startNonMainProcess because enter background");
                                BDPush.getPushService().startNonMainProcess();
                            } else {
                                Logger.m268d("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerService-->not startNonMainProcess because mHasStartNonMainProcess");
                            }
                            AppStatusObserverForChildProcess.getIns().deleteObserver(this);
                        }
                    }
                });
            }
        }
    }

    @Override // com.bytedance.push.interfaze.IProcessManagerService
    public void onProcessInit(Context context) {
        Logger.m268d("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerService onProcessInit");
        boolean z = ToolUtils.isMessageProcess(context) || ToolUtils.isPushServiceProcess(context);
        if (ToolUtils.isMainProcess(context) || ToolUtils.isMessageProcess(context) || ToolUtils.isPushServiceProcess(context)) {
            CrossProcessHelper.getInstance().registerMethodObserver(new ProcessManagerMethodObserver());
            if (!z || this.mAllowStartChildProcess) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(ProcessManagerMethodObserver.METHOD_NAME_ALLOW_START_NON_MAIN_PROCESS);
            CrossProcessHelper.getInstance().callMethod(ProcessEnum.MAIN, ProcessManagerMethodObserver.METHOD_NAME, arrayList, true);
        }
    }

    @Override // com.bytedance.push.interfaze.IProcessManagerService
    public int getDelayStartChildProcessMode() {
        return this.mDelayStartChildProcessMode;
    }

    @Override // com.bytedance.push.interfaze.IProcessManagerService
    public synchronized void startNonMainProcess() {
        if (this.mHasStartNonMainProcess) {
            return;
        }
        if (ToolUtils.isMainProcess(this.mContext)) {
            this.mHasStartNonMainProcess = true;
            if (allowStartNonMainProcess()) {
                return;
            }
            this.mAllowStartChildProcess = true;
            Logger.m268d("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerService-->startNonMainProcess");
            Logger.m268d("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerService-->startNonMainProcess: enableMessageReceiver");
            AliveKeeperProxy.inst(this.mContext).enableMessageReceiver(true);
            Logger.m268d("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerService-->startNonMainProcess: start MessageLogClientManager");
            MessageLogClientManager.start(this.mContext);
            Logger.m268d("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerService-->startNonMainProcess: start old redbadge pull strategy");
            Logger.m268d("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerService-->startNonMainProcess: try register mi_push and u_m if needed");
            PushSupporter.get().getSenderService().startNonMainProcess(this.mContext);
        }
    }

    @Override // com.bytedance.push.interfaze.IProcessManagerService
    public boolean curIsWorkerProcess(Context context) {
        return this.mWorkerProcessEnum == ToolUtils.getCurProcess(context);
    }

    @Override // com.bytedance.push.interfaze.IProcessManagerService
    public void allowStartNonMainProcessCallback(boolean z, long j) {
        Logger.m268d("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerService-->allowStartNonMainProcessCallback: allowStartNonMainProcess is " + z + " mainProcessStartTimeStamp is " + j);
        if (z) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, "process", ToolUtils.getCurProcessNameSuffix(this.mContext));
        add(jSONObject, "target_process", ToolUtils.getCurProcessNameSuffix(this.mContext));
        add(jSONObject, "delay_time", System.currentTimeMillis() - j);
        PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3("bdpush_delay_start_child_process_error", jSONObject);
    }

    @Override // com.bytedance.push.interfaze.IProcessManagerService
    public ProcessEnum getWorkerProcessEnum(Context context) {
        return this.mWorkerProcessEnum;
    }
}
