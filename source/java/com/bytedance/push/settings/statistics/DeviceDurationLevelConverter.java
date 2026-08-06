package com.bytedance.push.settings.statistics;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import com.bytedance.push.utils.GsonUtils;
import com.bytedance.push.utils.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DeviceDurationLevelConverter implements ITypeConverter<DeviceDurationLevelModel>, IDefaultValueProvider<DeviceDurationLevelModel> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public DeviceDurationLevelModel create() {
        return new DeviceDurationLevelModel();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    /* renamed from: to */
    public DeviceDurationLevelModel mo236to(String str) {
        DeviceDurationLevelModel deviceDurationLevelModel = (DeviceDurationLevelModel) GsonUtils.from(str, DeviceDurationLevelModel.class);
        if (deviceDurationLevelModel != null) {
            return deviceDurationLevelModel;
        }
        Logger.m271e("DeviceDurationLevelConverter", "deviceDurationLevelModel from json is null,return default object");
        return create();
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(DeviceDurationLevelModel deviceDurationLevelModel) {
        return GsonUtils.toJson(deviceDurationLevelModel);
    }
}
