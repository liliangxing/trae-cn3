package okhttp3.ttnet;

import java.net.InetAddress;
import java.util.List;

/* loaded from: classes8.dex */
public class TTNetDnsResult {
    private final String mDnsInfoJson;
    private final List<InetAddress> mInetAddressList;

    public TTNetDnsResult(List<InetAddress> list, String str) {
        this.mInetAddressList = list;
        this.mDnsInfoJson = str;
    }

    public List<InetAddress> getInetAddressList() {
        return this.mInetAddressList;
    }

    public String getDnsInfoJson() {
        return this.mDnsInfoJson;
    }
}
