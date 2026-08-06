package com.bytedance.frameworks.baselib.network.connectionclass;

/* loaded from: classes2.dex */
public class CdnConnectionClassManager extends ConnectionClassManager {

    /* loaded from: classes2.dex */
    private static class CdnConnectionClassManaagerHolder {
        public static final CdnConnectionClassManager instance = new CdnConnectionClassManager();

        private CdnConnectionClassManaagerHolder() {
        }
    }

    public static CdnConnectionClassManager getInstance() {
        return CdnConnectionClassManaagerHolder.instance;
    }

    private CdnConnectionClassManager() {
    }
}
