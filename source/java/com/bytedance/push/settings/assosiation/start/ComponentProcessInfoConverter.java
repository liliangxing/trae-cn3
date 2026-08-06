package com.bytedance.push.settings.assosiation.start;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;

/* loaded from: classes4.dex */
public class ComponentProcessInfoConverter implements ITypeConverter<ComponentProcessInfo>, IDefaultValueProvider<ComponentProcessInfo> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public ComponentProcessInfo create() {
        return new ComponentProcessInfo(null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    public ComponentProcessInfo to(String str) {
        return new ComponentProcessInfo(str);
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(ComponentProcessInfo componentProcessInfo) {
        return componentProcessInfo.toString();
    }
}
