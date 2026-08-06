package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes8.dex */
public interface Dns {
    public static final Dns SYSTEM = new Dns() { // from class: okhttp3.Dns.1
        @Override // okhttp3.Dns
        public List<InetAddress> lookup(String str) throws UnknownHostException {
            if (str == null) {
                throw new UnknownHostException("hostname == null");
            }
            try {
                return Arrays.asList(InetAddress.getAllByName(str));
            } catch (NullPointerException e) {
                UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                unknownHostException.initCause(e);
                throw unknownHostException;
            } catch (SecurityException e2) {
                UnknownHostException unknownHostException2 = new UnknownHostException("Permission denied for dns lookup of " + str);
                unknownHostException2.initCause(e2);
                throw unknownHostException2;
            }
        }
    };

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
