package com.bytedance.watson.assist.core;

import android.content.Context;
import com.bytedance.watson.assist.api.IAssistStat;

/* loaded from: classes6.dex */
public abstract class BaseInfoManager {
    protected IAssistStat mAssistStat;
    protected Context mContext;

    public void end() {
    }

    public void start() {
    }

    public BaseInfoManager(Context context, IAssistStat iAssistStat) {
        this.mContext = context;
        this.mAssistStat = iAssistStat;
    }
}
