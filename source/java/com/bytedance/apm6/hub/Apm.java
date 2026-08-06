package com.bytedance.apm6.hub;

import com.bytedance.apm.FluencyMonitorManager;
import com.bytedance.apm.ZstdCompressService;
import com.bytedance.apm.ZstdDictManager;
import com.bytedance.apm.config.FluencyConfigService;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.data.p004ui.ActionRecord;
import com.bytedance.apm.launch.LaunchModeTrigger;
import com.bytedance.apm.trace.LaunchTrace;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.commonevent.config.CommonEventConfigService;
import com.bytedance.apm6.consumer.slardar.SlardarHandler;
import com.bytedance.apm6.consumer.slardar.SlardarResponseService;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService;
import com.bytedance.apm6.consumer.slardar.weedout.WeedOutItem;
import com.bytedance.apm6.consumer.slardar.weedout.WeedOutListener;
import com.bytedance.apm6.consumer.slardar.weedout.WeedOutManager;
import com.bytedance.apm6.cpu.collect.CpuCollectManager;
import com.bytedance.apm6.cpu.config.CpuConfigService;
import com.bytedance.apm6.cpu.service.CurrentCpuDataHolder;
import com.bytedance.apm6.disk.DiskCollector;
import com.bytedance.apm6.disk.config.DiskConfigService;
import com.bytedance.apm6.foundation.ActivityLifeManager;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.foundation.safety.EnhancedLogger;
import com.bytedance.apm6.frequency.FrequencyMonitor;
import com.bytedance.apm6.frequency.FrequencyMonitorConfigService;
import com.bytedance.apm6.hub.config.DiskConfigManager;
import com.bytedance.apm6.hub.config.FdConfigManager;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.java_alloc.JavaAllocCollector;
import com.bytedance.apm6.java_alloc.JavaAllocConfigService;
import com.bytedance.apm6.memory.IMapsCollectService;
import com.bytedance.apm6.memory.MemoryCollector;
import com.bytedance.apm6.memory.config.MemoryConfigService;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.p005fd.FdCollector;
import com.bytedance.apm6.p005fd.config.IFdConfigService;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.service.ServiceCreator;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.device.IDeviceInfoService;
import com.bytedance.apm6.service.encrypt.EncryptService;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.perf.ICpuDataService;
import com.bytedance.apm6.service.perf.IPerfFilterManager;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.services.apm.api.IActivityLifeManager;
import com.bytedance.services.apm.api.IEncrypt;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMonitorLogManager;
import com.bytedance.services.apm.api.IMonitorLogQueryCallback;
import com.bytedance.services.apm.api.IZstdCompress;
import com.bytedance.services.apm.api.IZstdDict;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Apm {
    private static final String LOG_TAG = "APM-Hub";
    private static volatile boolean inited;

    public static synchronized void init(ApmAdapter apmAdapter) {
        synchronized (Apm.class) {
            if (inited) {
                return;
            }
            inited = true;
            initWithMainThread(apmAdapter);
            initWithOtherThread(apmAdapter);
        }
    }

    public static synchronized Runnable initWithAsync(final ApmAdapter apmAdapter) {
        synchronized (Apm.class) {
            if (inited) {
                return null;
            }
            inited = true;
            initWithMainThread(apmAdapter);
            return new Runnable() { // from class: com.bytedance.apm6.hub.Apm.1
                @Override // java.lang.Runnable
                public void run() {
                    Apm.initWithOtherThread(ApmAdapter.this);
                }
            };
        }
    }

    private static void initWithMainThread(ApmAdapter apmAdapter) {
        ApmContext.setApmContextAdapter(apmAdapter);
        ApmContext.setStartId(System.currentTimeMillis());
        ApmContext.setInitTimeStamp(System.currentTimeMillis());
        if (ApmContext.isDebugMode()) {
            Logger.m119d(LOG_TAG, "APM init start in process " + apmAdapter.getProcessName());
        }
        Logger.setLoggerImpl(new EnhancedLogger());
        ServiceManager.registerService((Class<ActivityLifeManager>) ActivityLifecycleService.class, new ActivityLifeManager());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initWithOtherThread(final ApmAdapter apmAdapter) {
        ServiceManager.registerService(IHttpService.class, (ServiceCreator) new ServiceCreator<IHttpService>() { // from class: com.bytedance.apm6.hub.Apm.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.apm6.service.ServiceCreator
            public IHttpService create() {
                return ApmAdapter.this.createHttpService();
            }
        });
        ServiceManager.registerService(SlardarHandlerConfigService.class, (ServiceCreator) new ServiceCreator<SlardarHandlerConfigService>() { // from class: com.bytedance.apm6.hub.Apm.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.apm6.service.ServiceCreator
            public SlardarHandlerConfigService create() {
                return ApmAdapter.this.createSlardarHandlerConfigService();
            }
        });
        ServiceManager.registerService(CommonEventConfigService.class, (ServiceCreator) new ServiceCreator<CommonEventConfigService>() { // from class: com.bytedance.apm6.hub.Apm.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.apm6.service.ServiceCreator
            public CommonEventConfigService create() {
                return ApmAdapter.this.createCommonEventConfigService();
            }
        });
        ServiceManager.registerService(CpuConfigService.class, (ServiceCreator) new ServiceCreator<CpuConfigService>() { // from class: com.bytedance.apm6.hub.Apm.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.apm6.service.ServiceCreator
            public CpuConfigService create() {
                return ApmAdapter.this.createCpuConfigService();
            }
        });
        ServiceManager.registerService(FluencyConfigService.class, (ServiceCreator) new ServiceCreator<FluencyConfigService>() { // from class: com.bytedance.apm6.hub.Apm.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.apm6.service.ServiceCreator
            public FluencyConfigService create() {
                return ApmAdapter.this.createFluencyConfigService();
            }
        });
        ServiceManager.registerService(FrequencyMonitorConfigService.class, (ServiceCreator) new ServiceCreator<FrequencyMonitorConfigService>() { // from class: com.bytedance.apm6.hub.Apm.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.apm6.service.ServiceCreator
            public FrequencyMonitorConfigService create() {
                return ApmAdapter.this.createFrequencyConfigService();
            }
        });
        ServiceManager.registerService(ActivityLifecycleService.class, (ServiceCreator) new ServiceCreator<ActivityLifecycleService>() { // from class: com.bytedance.apm6.hub.Apm.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.apm6.service.ServiceCreator
            public ActivityLifecycleService create() {
                return new ActivityLifeManager();
            }
        });
        ServiceManager.registerService(IEncrypt.class, (ServiceCreator) new ServiceCreator<IEncrypt>() { // from class: com.bytedance.apm6.hub.Apm.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.apm6.service.ServiceCreator
            public IEncrypt create() {
                return ApmAdapter.this.createEncryptServiceImpl();
            }
        });
        ServiceManager.registerService(EncryptService.class, (ServiceCreator) new ServiceCreator<EncryptService>() { // from class: com.bytedance.apm6.hub.Apm.10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.apm6.service.ServiceCreator
            public EncryptService create() {
                return ApmAdapter.this.createEncryptRequestServiceImpl();
            }
        });
        ServiceManager.registerService(IPerfFilterManager.class, (ServiceCreator) new ServiceCreator<IPerfFilterManager>() { // from class: com.bytedance.apm6.hub.Apm.11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.apm6.service.ServiceCreator
            public IPerfFilterManager create() {
                return PerfFilterManager.getInstance();
            }
        });
        ServiceManager.registerService(IZstdCompress.class, (ServiceCreator) new ServiceCreator<IZstdCompress>() { // from class: com.bytedance.apm6.hub.Apm.12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.apm6.service.ServiceCreator
            public IZstdCompress create() {
                return new ZstdCompressService();
            }
        });
        ServiceManager.registerService(IZstdDict.class, (ServiceCreator) new ServiceCreator<IZstdDict>() { // from class: com.bytedance.apm6.hub.Apm.13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.apm6.service.ServiceCreator
            public IZstdDict create() {
                return new ZstdDictManager();
            }
        });
        new ActivityLifeManager();
        ServiceManager.registerService(MemoryConfigService.class, (ServiceCreator) new ServiceCreator<MemoryConfigService>() { // from class: com.bytedance.apm6.hub.Apm.14
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.apm6.service.ServiceCreator
            public MemoryConfigService create() {
                return ApmAdapter.this.createMemoryConfigService();
            }
        });
        ServiceManager.registerService(JavaAllocConfigService.class, (ServiceCreator) new ServiceCreator<JavaAllocConfigService>() { // from class: com.bytedance.apm6.hub.Apm.15
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.apm6.service.ServiceCreator
            public JavaAllocConfigService create() {
                return ApmAdapter.this.createJavaAllocConfigService();
            }
        });
        ServiceManager.registerService(IMapsCollectService.class, (ServiceCreator) new ServiceCreator<IMapsCollectService>() { // from class: com.bytedance.apm6.hub.Apm.16
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.apm6.service.ServiceCreator
            public IMapsCollectService create() {
                return ApmAdapter.this.createMapsCollectService();
            }
        });
        ServiceManager.registerService(IDeviceInfoService.class, (ServiceCreator) new ServiceCreator<IDeviceInfoService>() { // from class: com.bytedance.apm6.hub.Apm.17
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.apm6.service.ServiceCreator
            public IDeviceInfoService create() {
                return ApmAdapter.this.createDeviceInfoService();
            }
        });
        ServiceManager.registerService(DiskConfigService.class, (ServiceCreator) new ServiceCreator<DiskConfigService>() { // from class: com.bytedance.apm6.hub.Apm.18
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.apm6.service.ServiceCreator
            public DiskConfigService create() {
                return new DiskConfigManager();
            }
        });
        ServiceManager.registerService(ICpuDataService.class, (ServiceCreator) new ServiceCreator<ICpuDataService>() { // from class: com.bytedance.apm6.hub.Apm.19
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.apm6.service.ServiceCreator
            public ICpuDataService create() {
                return CurrentCpuDataHolder.getInstance();
            }
        });
        ServiceManager.registerService(SlardarResponseService.class, (ServiceCreator) new ServiceCreator<SlardarResponseService>() { // from class: com.bytedance.apm6.hub.Apm.20
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.apm6.service.ServiceCreator
            public SlardarResponseService create() {
                return ApmAdapter.this.createSlardarResponseService();
            }
        });
        ServiceManager.registerService(IFdConfigService.class, (ServiceCreator) new ServiceCreator<IFdConfigService>() { // from class: com.bytedance.apm6.hub.Apm.21
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.apm6.service.ServiceCreator
            public IFdConfigService create() {
                return new FdConfigManager();
            }
        });
        com.bytedance.news.common.service.manager.ServiceManager.registerService(IActivityLifeManager.class, new com.bytedance.news.common.service.manager.ServiceCreator<IActivityLifeManager>() { // from class: com.bytedance.apm6.hub.Apm.22
            /* renamed from: create, reason: merged with bridge method [inline-methods] */
            public IActivityLifeManager m418create() {
                return ActivityLifeObserver.getInstance();
            }
        });
        com.bytedance.news.common.service.manager.ServiceManager.registerService(IMonitorLogManager.class, new com.bytedance.news.common.service.manager.ServiceCreator<IMonitorLogManager>() { // from class: com.bytedance.apm6.hub.Apm.23
            /* renamed from: create, reason: merged with bridge method [inline-methods] */
            public IMonitorLogManager m419create() {
                return new IMonitorLogManager() { // from class: com.bytedance.apm6.hub.Apm.23.1
                    public void deleteLegacyLogByIds(String str, String str2) {
                    }

                    public void getLegacyLog(long j, long j2, String str, IMonitorLogQueryCallback iMonitorLogQueryCallback) {
                    }

                    public List<JSONObject> getRecentUiActionRecords() {
                        return ActionRecord.getInstance().getRecords();
                    }
                };
            }
        });
        ConfigManager.getInstance().init();
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(new AsyncTask(apmAdapter.getInternalComponentInitDelayMills()) { // from class: com.bytedance.apm6.hub.Apm.24
            @Override // java.lang.Runnable
            public void run() {
                Monitor.registerHandler(SlardarHandler.getInstance());
                MemoryCollector.getInstance().init();
                JavaAllocCollector.getInstance().init();
                if (ApmContext.isMainProcess()) {
                    DiskCollector.getInstance().init();
                }
                CpuCollectManager.getInstance().init();
                FluencyMonitorManager.getInstance().init();
                FrequencyMonitor.getInstance().init();
                if (ApmContext.isMainProcess()) {
                    LaunchModeTrigger.init();
                    com.bytedance.apm.ApmContext.setAppLaunchStartTimestamp(LaunchTrace.getTraceStartTime());
                }
                if (ApmContext.isMainProcess()) {
                    FdCollector.getInstance().init();
                }
            }
        });
        initWeedOut();
    }

    private static void initWeedOut() {
        WeedOutManager.getInstance().register(new WeedOutListener() { // from class: com.bytedance.apm6.hub.Apm.25
            @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutListener
            public void onWeedOut(List<WeedOutItem> list) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                for (WeedOutItem weedOutItem : list) {
                    try {
                        jSONObject2.put("before_size_" + weedOutItem.getName(), weedOutItem.getBeforeSize());
                        jSONObject2.put("after_size_" + weedOutItem.getName(), weedOutItem.getAfterSize());
                        jSONObject.put("strategy", weedOutItem.getName());
                        if (weedOutItem.isReachTopOfToday()) {
                            jSONObject.put("reach_top_today", weedOutItem.isReachTopOfToday());
                        }
                    } catch (Exception unused) {
                    }
                }
                CommonEventDeliverer.monitorEvent("apm_db_size", jSONObject, jSONObject2, null);
            }
        });
    }

    public static void pause() {
        SlardarHandler.getInstance().pause();
        CpuCollectManager.getInstance().pause();
        MemoryCollector.getInstance().pause();
    }

    public static void resume() {
        SlardarHandler.getInstance().resume();
        CpuCollectManager.getInstance().resume();
        MemoryCollector.getInstance().resume();
    }
}
