package com.bytedance.applog.strategy;

import com.bytedance.applog.log.AbsSingleton;

/* loaded from: classes3.dex */
public class DefaultReportDropStrategy implements IReportDropStrategy {
    private static final AbsSingleton<IReportDropStrategy> DEFAULT_STRATEGY = new AbsSingleton<IReportDropStrategy>() { // from class: com.bytedance.applog.strategy.DefaultReportDropStrategy.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.applog.log.AbsSingleton
        public IReportDropStrategy create(Object... objArr) {
            return new DefaultReportDropStrategy();
        }
    };

    @Override // com.bytedance.applog.strategy.IReportDropStrategy
    public int getMaxRetryTimes() {
        return -1;
    }

    @Override // com.bytedance.applog.strategy.IReportDropStrategy
    public long getTimeoutInMills() {
        return 1209600000L;
    }

    public static IReportDropStrategy getDefault() {
        return DEFAULT_STRATEGY.get(new Object[0]);
    }
}
