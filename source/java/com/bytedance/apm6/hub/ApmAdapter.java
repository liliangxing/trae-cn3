package com.bytedance.apm6.hub;

import com.bytedance.apm6.commonevent.config.CommonEventConfigService;
import com.bytedance.apm6.consumer.slardar.SlardarResponseService;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService;
import com.bytedance.apm6.foundation.context.ApmContextAdapter;
import com.bytedance.apm6.frequency.FrequencyMonitorConfigService;
import com.bytedance.apm6.hub.config.CommonEventConfigManager;
import com.bytedance.apm6.hub.config.CpuOnlineConfigManager;
import com.bytedance.apm6.hub.config.FluencyConfigManager;
import com.bytedance.apm6.hub.config.FrequencyConfigManager;
import com.bytedance.apm6.hub.config.JavaAllocConfigManager;
import com.bytedance.apm6.hub.config.MemoryConfigManager;
import com.bytedance.apm6.hub.config.SlardarHandlerConfigManager;
import com.bytedance.apm6.memory.IMapsCollectService;
import com.bytedance.apm6.memory.config.MemoryConfigService;
import com.bytedance.apm6.monitor.MonitorableInterceptor;
import com.bytedance.apm6.service.device.IDeviceInfoService;
import com.bytedance.apm6.service.encrypt.EncryptService;
import com.bytedance.services.apm.api.IEncrypt;
import com.bytedance.services.apm.api.IHttpService;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class ApmAdapter implements ApmContextAdapter {
    /* JADX INFO: Access modifiers changed from: protected */
    public IDeviceInfoService createDeviceInfoService() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract EncryptService createEncryptRequestServiceImpl();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract IEncrypt createEncryptServiceImpl();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract IHttpService createHttpService();

    /* JADX INFO: Access modifiers changed from: protected */
    public IMapsCollectService createMapsCollectService() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SlardarResponseService createSlardarResponseService() {
        return null;
    }

    @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
    public JSONObject getDynamicHeaderExtras() {
        return null;
    }

    public abstract MonitorableInterceptor getInterceptor();

    /* JADX INFO: Access modifiers changed from: protected */
    public long getInternalComponentInitDelayMills() {
        return 0L;
    }

    @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
    public Map<String, String> getParamsExtras() {
        return null;
    }

    @Override // com.bytedance.apm6.foundation.context.ApmContextAdapter
    public JSONObject getStableHeaderExtras() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SlardarHandlerConfigService createSlardarHandlerConfigService() {
        return new SlardarHandlerConfigManager(getOutsideConfig());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CommonEventConfigService createCommonEventConfigService() {
        return new CommonEventConfigManager();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CpuOnlineConfigManager createCpuConfigService() {
        return new CpuOnlineConfigManager();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FluencyConfigManager createFluencyConfigService() {
        return new FluencyConfigManager();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MemoryConfigService createMemoryConfigService() {
        return new MemoryConfigManager();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JavaAllocConfigManager createJavaAllocConfigService() {
        return new JavaAllocConfigManager();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FrequencyMonitorConfigService createFrequencyConfigService() {
        return new FrequencyConfigManager();
    }
}
