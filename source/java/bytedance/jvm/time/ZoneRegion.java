package bytedance.jvm.time;

import bytedance.jvm.time.zone.ZoneRules;
import bytedance.jvm.time.zone.ZoneRulesException;
import bytedance.jvm.time.zone.ZoneRulesProvider;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ZoneRegion extends ZoneId implements Serializable {
    private static final long serialVersionUID = 8386373296231747096L;

    /* renamed from: id */
    private final String f95id;
    private final transient ZoneRules rules;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneRegion ofId(String str, boolean z) {
        ZoneRules zoneRules;
        Objects.requireNonNull(str, "zoneId");
        checkName(str);
        try {
            zoneRules = ZoneRulesProvider.getRules(str, true);
        } catch (ZoneRulesException e) {
            if (z) {
                throw e;
            }
            zoneRules = null;
        }
        return new ZoneRegion(str, zoneRules);
    }

    private static void checkName(String str) {
        int length = str.length();
        if (length < 2) {
            throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + str);
        }
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && ((charAt != '/' || i == 0) && ((charAt < '0' || charAt > '9' || i == 0) && ((charAt != '~' || i == 0) && ((charAt != '.' || i == 0) && ((charAt != '_' || i == 0) && ((charAt != '+' || i == 0) && (charAt != '-' || i == 0))))))))) {
                throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZoneRegion(String str, ZoneRules zoneRules) {
        this.f95id = str;
        this.rules = zoneRules;
    }

    @Override // bytedance.jvm.time.ZoneId
    public String getId() {
        return this.f95id;
    }

    @Override // bytedance.jvm.time.ZoneId
    public ZoneRules getRules() {
        ZoneRules zoneRules = this.rules;
        return zoneRules != null ? zoneRules : ZoneRulesProvider.getRules(this.f95id, false);
    }

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.ZoneId
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(7);
        writeExternal(dataOutput);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.f95id);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneId readExternal(DataInput dataInput) throws IOException {
        return ZoneId.m113of(dataInput.readUTF(), false);
    }
}
