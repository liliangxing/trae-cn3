package com.bytedance.push.settings.permission.boot;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import com.bytedance.push.utils.GsonUtils;
import com.bytedance.push.utils.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SysDialogShowHistoryConverter implements ITypeConverter<SysDialogShowHistoryModel>, IDefaultValueProvider<SysDialogShowHistoryModel> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public SysDialogShowHistoryModel create() {
        return new SysDialogShowHistoryModel();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    /* renamed from: to */
    public SysDialogShowHistoryModel mo236to(String str) {
        SysDialogShowHistoryModel sysDialogShowHistoryModel = (SysDialogShowHistoryModel) GsonUtils.from(str, SysDialogShowHistoryModel.class);
        if (sysDialogShowHistoryModel != null) {
            return sysDialogShowHistoryModel;
        }
        Logger.m271e("SysDialogShowHistoryConverter", "sysDialogShowHistoryModel from json is null,return default object");
        return create();
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(SysDialogShowHistoryModel sysDialogShowHistoryModel) {
        return GsonUtils.toJson(sysDialogShowHistoryModel);
    }
}
