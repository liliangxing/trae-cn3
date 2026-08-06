package com.bytedance.sdk.open.aweme.init;

import android.content.Context;

/* loaded from: classes5.dex */
public class DouYinSdkContext {
    private static volatile DouYinSdkContext INSTANCE;
    private Context mContext = null;
    private String clientKey = null;
    private boolean isBoe = false;
    private boolean isPpe = false;
    private String boeProd = null;
    private String ppeProd = null;
    private boolean useClientTicket = false;

    private DouYinSdkContext() {
    }

    public static DouYinSdkContext inst() {
        if (INSTANCE == null) {
            synchronized (DouYinSdkContext.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DouYinSdkContext();
                }
            }
        }
        return INSTANCE;
    }

    public String getBoeProd() {
        return this.boeProd;
    }

    public String getClientKey() {
        return this.clientKey;
    }

    public Context getContext() {
        Context context = this.mContext;
        if (context != null) {
            return context;
        }
        throw new RuntimeException("please init config");
    }

    public String getPpeProd() {
        return this.ppeProd;
    }

    public boolean isBoe() {
        return this.isBoe;
    }

    public boolean isPpe() {
        return this.isPpe;
    }

    public boolean isUseClientTicket() {
        return this.useClientTicket;
    }

    public void setBoe(boolean z) {
        this.isBoe = z;
    }

    public void setBoeProd(String str) {
        this.boeProd = str;
    }

    public void setClientKey(String str) {
        this.clientKey = str;
    }

    public void setContext(Context context) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
    }

    public void setPpe(boolean z) {
        this.isPpe = z;
    }

    public void setPpeProd(String str) {
        this.ppeProd = str;
    }

    public void setUseClientTicket(boolean z) {
        this.useClientTicket = z;
    }
}
