package com.bytedance.upc;

import kotlin.Metadata;

/* compiled from: IUpcCertService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/upc/IUpcCertService;", "", "businessService", "Lcom/bytedance/upc/IUpcCertBusinessService;", "initService", "Lcom/bytedance/upc/IUpcCertInitServive;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public interface IUpcCertService {

    /* compiled from: IUpcCertService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static IUpcCertBusinessService businessService(IUpcCertService iUpcCertService) {
            return null;
        }

        public static IUpcCertInitServive initService(IUpcCertService iUpcCertService) {
            return null;
        }
    }

    IUpcCertBusinessService businessService();

    IUpcCertInitServive initService();
}
