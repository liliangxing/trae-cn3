package com.ss.android.ugc.aweme.framework.services;

/* loaded from: classes7.dex */
public class SingletonProvider<T> implements ServiceProvider<T> {
    volatile T service;
    ServiceProvider<T> serviceProvider;

    public SingletonProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    @Override // com.ss.android.ugc.aweme.framework.services.ServiceProvider
    public synchronized T get() {
        if (this.service == null) {
            this.service = this.serviceProvider.get();
        }
        return this.service;
    }
}
