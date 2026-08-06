package com.bytedance.common.wschannel.channel;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.tools.SafelyLibraryLoader;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WsChannelDependAdapter implements IWsChannelDepend {
    public static WsChannelDependAdapter INSTANCE = new WsChannelDependAdapter();

    @Override // com.bytedance.common.wschannel.channel.IWsChannelDepend
    public void setAdapter(IWsChannelDepend iWsChannelDepend) {
    }

    private WsChannelDependAdapter() {
    }

    public static WsChannelDependAdapter inst() {
        return INSTANCE;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelDepend
    public boolean loggerDebug() {
        return Logger.debug();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelDepend
    public void loggerD(String str, String str2) {
        Logger.m190d(str, str2);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelDepend
    public void loadLibrary(Context context, String str) {
        SafelyLibraryLoader.loadLibrary(context, str);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelDepend
    public int getNetworkType(Context context) {
        return NetworkUtils.getNetworkType(context).getValue();
    }
}
