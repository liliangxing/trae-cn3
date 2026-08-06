package com.ss.android.socialbase.appdownloader.util.parser.zip;

import com.bytedance.android.sdk.bdticketguard.TicketGuardApiKt;
import java.io.Serializable;
import java.util.zip.ZipException;

/* loaded from: classes7.dex */
public class UnsupportedZipFeatureException extends ZipException {
    private static final long serialVersionUID = 20161221;
    private final transient ZipEntry entry;
    private final Feature reason;

    public UnsupportedZipFeatureException(Feature feature, ZipEntry zipEntry) {
        super("unsupported feature " + feature + " used in entry " + zipEntry.getName());
        this.reason = feature;
        this.entry = zipEntry;
    }

    public Feature getFeature() {
        return this.reason;
    }

    public ZipEntry getEntry() {
        return this.entry;
    }

    /* loaded from: classes7.dex */
    public static class Feature implements Serializable {
        private final String name;
        public static final Feature ENCRYPTION = new Feature(TicketGuardApiKt.INIT_STATUS_ENCRYPTION);
        public static final Feature METHOD = new Feature("compression method");
        public static final Feature DATA_DESCRIPTOR = new Feature("data descriptor");

        private Feature(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }
}
