package com.bytedance.crash.protector;

import android.os.Build;
import android.util.Pair;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.NpthLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CrashProtectorConfig {
    private static final String LOG_TAG = "NPTH_PROT";
    private ArrayList<String> mBlackList;
    private ArrayList<String> mWhiteList;
    private static final byte[] MAGIC_NUMBER = {80, 82, 79, 84};
    private static final byte[] MAGIC_VERSION = {48, 48, 52};
    private static final byte[] ENDIAN_TAG = {120, 86, 52, 18};
    private static final Pattern sScopePattern = Pattern.compile("^com\\.bytedance(\\.\\w+)*$");
    private static JSONObject sScopeList = null;
    private static JSONObject sConfigList = null;
    private ArrayList<String> mEnabledScopeList = new ArrayList<>();
    private byte[] mConfigData = null;
    private int mConfigSize = 0;
    private boolean mIs64BitRuntime = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum ElfTag {
        ELF_BUILD_ID,
        ELF_PATH,
        ELF_NAME
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum SymbolTag {
        SYMBOL_ALL,
        SYMBOL_OFFSET,
        SYMBOL_NAME
    }

    public byte[] getConfigData() {
        return this.mConfigData;
    }

    public int getConfigSize() {
        return this.mConfigSize;
    }

    public boolean isConfigEnabled(JSONObject jSONObject) {
        return isScopeEnabled(jSONObject.optString("scope"));
    }

    public boolean isScopeEnabled(String str) {
        if (!isValidScopeName(str)) {
            return false;
        }
        Iterator<String> it = this.mEnabledScopeList.iterator();
        while (it.hasNext()) {
            if (it.next().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean addConfig(JSONObject jSONObject) {
        if (sScopeList == null) {
            sScopeList = new JSONObject();
        }
        if (sConfigList == null) {
            sConfigList = new JSONObject();
        }
        try {
            String optString = jSONObject.optString("scope");
            if (!optString.isEmpty() && optString.startsWith("com.bytedance.")) {
                sConfigList.put(optString, jSONObject);
                sScopeList.put(optString, 1);
                return true;
            }
            return false;
        } catch (Exception e) {
            NpthLog.e(LOG_TAG, e.getMessage());
            return false;
        }
    }

    public static void updateConfig(JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        if (jSONObject != null) {
            jSONObject2 = jSONObject.optJSONObject("scope_list");
            jSONObject3 = jSONObject.optJSONObject("config_list");
        } else {
            jSONObject2 = null;
            jSONObject3 = null;
        }
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        if (jSONObject3 == null) {
            jSONObject3 = new JSONObject();
        }
        try {
            JSONObject jSONObject4 = sConfigList;
            if (jSONObject4 != null) {
                Iterator<String> keys = jSONObject4.keys();
                while (keys.hasNext()) {
                    JSONObject optJSONObject = sConfigList.optJSONObject(keys.next());
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("scope");
                        jSONObject3.put(optString, optJSONObject);
                        jSONObject2.put(optString, 1);
                    }
                }
            }
            jSONObject2.put("com.bytedance.__default__", 1);
            jSONObject3.put("__default__.unwindstack.maps", "{ \"scope\": \"com.bytedance.__default__.unwindstack.maps\",\"signals\": [\"SIGSEGV\"], \"backtraces\":[ { \"elf_name\": \"libunwindstack.so\", \"symbol_name\": \"_ZN11unwindstack6Global19FindAndReadVariableEPNS_4MapsEPKc\", \"return_from_current_stack\": 1 }, { \"elf_name\": \"libunwindstack.so\", \"symbol_name\": \"_ZN11unwindstack15GlobalDebugImplINS_7DexFileEmNS_8Uint64_AEE14ForEachSymfileIZNS3_15GetFunctionNameEPNS_4MapsEmPNS_12SharedStringEPmEUlPS1_E_EEbS6_mT_\" }, { \"elf_name\": \"libunwindstack.so\", \"symbol_name\": \"_ZN11unwindstack15GlobalDebugImplINS_7DexFileEmNS_8Uint64_AEE15GetFunctionNameEPNS_4MapsEmPNS_12SharedStringEPm\" }, { \"elf_name\": \"libunwindstack.so\", \"symbol_name\": \"_ZN11unwindstack8Unwinder14FillInDexFrameEv\" } ] } ");
        } catch (Exception e) {
            NpthLog.e(LOG_TAG, e.getMessage());
        }
        sScopeList = jSONObject2;
        sConfigList = jSONObject3;
        NpthLog.i(LOG_TAG, "update config");
    }

    public boolean parse() {
        return parse(sScopeList, sConfigList);
    }

    private boolean parse(JSONObject jSONObject, JSONObject jSONObject2) {
        if (!parseScopeListInfo(jSONObject)) {
            return false;
        }
        this.mIs64BitRuntime = NativeBridge.is64BitRuntime();
        BufferWriter bufferWriter = new BufferWriter();
        bufferWriter.write(MAGIC_NUMBER);
        bufferWriter.write(MAGIC_VERSION);
        bufferWriter.writeByte(this.mIs64BitRuntime ? 2 : 1);
        bufferWriter.write(ENDIAN_TAG);
        int prependInt32 = bufferWriter.prependInt32(0);
        int prependInt322 = bufferWriter.prependInt32(0);
        bufferWriter.align(8);
        int position = bufferWriter.position();
        int writeConfigListInfo = writeConfigListInfo(bufferWriter, jSONObject2);
        NpthLog.i(LOG_TAG, "config count: " + writeConfigListInfo);
        if (writeConfigListInfo <= 0) {
            return false;
        }
        bufferWriter.writeInt32At(prependInt322, bufferWriter.position() - position);
        bufferWriter.writeInt32At(prependInt32, writeConfigListInfo);
        writeCheckSum(bufferWriter);
        this.mConfigData = bufferWriter.data();
        this.mConfigSize = bufferWriter.position();
        return true;
    }

    private void writeCheckSum(BufferWriter bufferWriter) {
        byte[] bArr = new byte[8];
        bufferWriter.align(8);
        byte[] data = bufferWriter.data();
        int position = bufferWriter.position();
        for (int i = 0; i < position; i += 8) {
            for (int i2 = 0; i2 < 8; i2++) {
                bArr[i2] = (byte) (bArr[i2] ^ data[i + i2]);
            }
        }
        bufferWriter.write(bArr);
    }

    private boolean parseScopeListInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        Iterator<String> keys = jSONObject.keys();
        this.mWhiteList = new ArrayList<>();
        this.mBlackList = new ArrayList<>();
        while (true) {
            if (keys.hasNext()) {
                String next = keys.next();
                if (isValidScopeName(next)) {
                    if (jSONObject.optInt(next) != 0) {
                        this.mWhiteList.add(next);
                    } else {
                        this.mBlackList.add(next);
                    }
                }
            } else {
                NpthLog.i(LOG_TAG, "white list size: " + this.mWhiteList.size());
                return !this.mWhiteList.isEmpty();
            }
        }
    }

    private int writeConfigListInfo(BufferWriter bufferWriter, JSONObject jSONObject) {
        int i = 0;
        if (jSONObject == null) {
            return 0;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            if (optJSONObject == null) {
                String optString = jSONObject.optString(next);
                if (!optString.isEmpty()) {
                    try {
                        optJSONObject = new JSONObject(optString);
                    } catch (Throwable unused) {
                    }
                }
                if (optJSONObject == null) {
                }
            }
            if (writeConfigInfo(bufferWriter, optJSONObject)) {
                i++;
            }
        }
        return i;
    }

    private boolean writeConfigInfo(BufferWriter bufferWriter, JSONObject jSONObject) {
        boolean z;
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString("scope");
        if (!matchesScope(optString, this.mBlackList, this.mWhiteList)) {
            return false;
        }
        int optInt = jSONObject.optInt("min_api_level", 0);
        int optInt2 = jSONObject.optInt("max_api_level", 100);
        if (Build.VERSION.SDK_INT < optInt || Build.VERSION.SDK_INT > optInt2) {
            return false;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("api_levels");
        if (optJSONArray != null) {
            int i = 0;
            while (true) {
                if (i >= optJSONArray.length()) {
                    z = false;
                    break;
                }
                if (Build.VERSION.SDK_INT == optJSONArray.optInt(i)) {
                    z = true;
                    break;
                }
                i++;
            }
            if (!z) {
                return false;
            }
        }
        ConfigInfo configInfo = new ConfigInfo();
        configInfo.scope = optString;
        String optString2 = jSONObject.optString("abi", "both");
        if (!optString2.equals("both") && ((!this.mIs64BitRuntime || !optString2.equals("arm64-v8a")) && (this.mIs64BitRuntime || !optString2.equals("armeabi-v7a")))) {
            return false;
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("signals");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                int signalStringToNumber = signalStringToNumber(optJSONArray2.optString(i2));
                if (signalStringToNumber != 0) {
                    configInfo.signal |= 1 << signalStringToNumber;
                }
            }
        }
        configInfo.abortMsg = jSONObject.optString("abort_message");
        configInfo.maxResumeCount = jSONObject.optInt("max_resume_count", 3);
        configInfo.intervalTimeMs = jSONObject.optInt("interval_time_ms", 3000);
        configInfo.returnFrameIndex = jSONObject.optInt("return_frame_index");
        if (jSONObject.optInt("dump_all") != 0) {
            configInfo.flag |= 1;
        }
        int optInt3 = jSONObject.optInt("max_ignore_depth_before_meet_first_match");
        if (optInt3 < 0) {
            optInt3 = 0;
        } else if (optInt3 > 255) {
            optInt3 = 255;
        }
        configInfo.maxIgnoreDepth = optInt3;
        if (!parseFramesInfo(configInfo, jSONObject.optJSONArray("backtraces"))) {
            return false;
        }
        parseRegsInfo(configInfo, jSONObject.optJSONObject("registers"));
        configInfo.encode(bufferWriter);
        this.mEnabledScopeList.add(optString);
        NpthLog.i(LOG_TAG, "add scope: " + optString);
        return true;
    }

    public static int signalStringToNumber(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1849149425:
                if (str.equals("SIGBUS")) {
                    c = 0;
                    break;
                }
                break;
            case -1849145750:
                if (str.equals("SIGFPE")) {
                    c = 1;
                    break;
                }
                break;
            case -1849142984:
                if (str.equals("SIGILL")) {
                    c = 2;
                    break;
                }
                break;
            case -1849132964:
                if (str.equals("SIGSYS")) {
                    c = 3;
                    break;
                }
                break;
            case -1489105324:
                if (str.equals("SIGABRT")) {
                    c = 4;
                    break;
                }
                break;
            case -1488651809:
                if (str.equals("SIGPIPE")) {
                    c = 5;
                    break;
                }
                break;
            case -1488566542:
                if (str.equals("SIGSEGV")) {
                    c = 6;
                    break;
                }
                break;
            case -1488524450:
                if (str.equals("SIGTRAP")) {
                    c = 7;
                    break;
                }
                break;
            case -274378251:
                if (str.equals("SIGSTKFLT")) {
                    c = '\b';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 7;
            case 1:
                return 8;
            case 2:
                return 4;
            case 3:
                return 31;
            case 4:
                return 6;
            case 5:
                return 13;
            case 6:
                return 11;
            case 7:
                return 5;
            case '\b':
                return 16;
            default:
                return 0;
        }
    }

    public static boolean isValidRegLabel(String str) {
        if (str.length() != 2) {
            return false;
        }
        char lowerCase = Character.toLowerCase(str.charAt(0));
        int charAt = str.charAt(1) - '0';
        if (charAt < 0) {
            return false;
        }
        return (charAt < 8 && (lowerCase == 'x' || lowerCase == 'w' || lowerCase == 'd' || lowerCase == 's')) || (charAt < 4 && lowerCase == 'r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0052, code lost:
    
        if (r4 != 's') goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean parseRegsInfo(ConfigInfo configInfo, JSONObject jSONObject) {
        Long hexStringToLong;
        long optLong;
        if (jSONObject == null) {
            return false;
        }
        configInfo.regs = new ArrayList<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next.length() == 2) {
                char lowerCase = Character.toLowerCase(next.charAt(0));
                int charAt = next.charAt(1) - '0';
                if (charAt >= 0) {
                    if (this.mIs64BitRuntime) {
                        if (charAt < 8 && (lowerCase == 'x' || lowerCase == 'w' || lowerCase == 'd' || lowerCase == 's')) {
                            charAt += 34;
                            hexStringToLong = hexStringToLong(jSONObject.opt(next));
                            if (hexStringToLong == null) {
                                optLong = hexStringToLong.longValue();
                            } else if (lowerCase == 'd') {
                                optLong = Double.doubleToLongBits(jSONObject.optDouble(next));
                            } else if (lowerCase == 's') {
                                optLong = Float.floatToIntBits((float) jSONObject.optDouble(next));
                            } else {
                                optLong = jSONObject.optLong(next);
                            }
                            if (lowerCase != 'w' || lowerCase == 's' || lowerCase == 'r') {
                                optLong &= BodyPartID.bodyIdMax;
                            }
                            if (optLong == 0) {
                                configInfo.regs.add(new Pair<>(Integer.valueOf(charAt), Long.valueOf(optLong)));
                            }
                        }
                    } else if (charAt < 4 && lowerCase == 'r') {
                        hexStringToLong = hexStringToLong(jSONObject.opt(next));
                        if (hexStringToLong == null) {
                        }
                        if (lowerCase != 'w') {
                        }
                        optLong &= BodyPartID.bodyIdMax;
                        if (optLong == 0) {
                        }
                    }
                }
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    private boolean parseFramesInfo(ConfigInfo configInfo, JSONArray jSONArray) {
        ElfTag elfTag;
        byte[] bytes;
        boolean z;
        JSONArray jSONArray2 = jSONArray;
        boolean z2 = 0;
        if (jSONArray2 == null) {
            return false;
        }
        int length = jSONArray.length();
        int i = 255;
        if (length > 255) {
            length = 255;
        }
        configInfo.framesCount = length;
        configInfo.frameList = new BufferWriter();
        BufferWriter bufferWriter = configInfo.frameList;
        configInfo.elfList = new BufferWriter();
        BufferWriter bufferWriter2 = configInfo.elfList;
        int i2 = -1;
        int i3 = 0;
        int i4 = -1;
        while (i3 < length) {
            JSONObject optJSONObject = jSONArray2.optJSONObject(i3);
            if (i4 == i2 && optJSONObject.optInt("return_from_current_stack") != 0) {
                i4 = i3;
            }
            String optString = optJSONObject.optString("elf_build_id");
            String optString2 = optJSONObject.optString("elf_path");
            String optString3 = optJSONObject.optString("elf_name");
            if (!optString.isEmpty()) {
                optString = optString.replace(" ", "");
                int length2 = optString.length() / 2;
                bytes = new byte[length2];
                for (int i5 = z2; i5 < length2; i5++) {
                    int i6 = i5 * 2;
                    try {
                        bytes[i5] = (byte) (Integer.parseInt(optString.substring(i6, i6 + 2), 16) & i);
                    } catch (Throwable unused) {
                        return z2;
                    }
                }
                elfTag = ElfTag.ELF_BUILD_ID;
            } else if (!optString2.isEmpty()) {
                if (optString2.charAt(z2) != '/') {
                    return z2;
                }
                elfTag = ElfTag.ELF_PATH;
                bytes = optString2.getBytes();
            } else {
                if (optString3.isEmpty()) {
                    return z2;
                }
                elfTag = ElfTag.ELF_NAME;
                bytes = optString3.getBytes();
            }
            if (bytes == null || bytes.length >= 256) {
                return z2;
            }
            byte[] data = bufferWriter2.data();
            int i7 = z2;
            while (i7 < bufferWriter2.position()) {
                byte b = data[i7];
                byte b2 = data[i7 + 1];
                if (b == elfTag.ordinal() && b2 == bytes.length) {
                    int i8 = 0;
                    while (true) {
                        if (i8 >= bytes.length) {
                            z = true;
                            break;
                        }
                        if (data[i7 + 2 + i8] != bytes[i8]) {
                            z = false;
                            break;
                        }
                        i8++;
                    }
                    if (z) {
                        break;
                    }
                }
                i7 += b2 + 3;
            }
            if (i7 > bufferWriter2.position()) {
                return false;
            }
            if (i7 == bufferWriter2.position()) {
                configInfo.elfListCount++;
                bufferWriter2.writeByte(elfTag.ordinal());
                bufferWriter2.writeByte(bytes.length);
                bufferWriter2.write(bytes);
                bufferWriter2.writeByte(0);
            }
            bufferWriter.writeUleb128(i7);
            if (optJSONObject.optInt("redacted_match") != 0) {
                bufferWriter.writeByte(SymbolTag.SYMBOL_ALL.ordinal());
            } else if (optJSONObject.has("offset_start")) {
                if (optString.isEmpty()) {
                    return false;
                }
                Long hexStringToLong = hexStringToLong(optJSONObject.opt("offset_start"));
                if (hexStringToLong == null) {
                    hexStringToLong = Long.valueOf(optJSONObject.optLong("offset_start"));
                }
                Long hexStringToLong2 = hexStringToLong(optJSONObject.opt("offset_next"));
                if (hexStringToLong2 == null) {
                    hexStringToLong2 = Long.valueOf(optJSONObject.optLong("offset_next"));
                }
                if (hexStringToLong.longValue() == 0 || hexStringToLong2.longValue() == 0 || hexStringToLong.longValue() >= hexStringToLong2.longValue()) {
                    return false;
                }
                bufferWriter.writeByte(SymbolTag.SYMBOL_OFFSET.ordinal());
                bufferWriter.writeUleb128(hexStringToLong.longValue());
                bufferWriter.writeUleb128(hexStringToLong2.longValue());
            } else {
                String optString4 = optJSONObject.optString("symbol_name");
                if (optString4.isEmpty()) {
                    return false;
                }
                bufferWriter.writeByte(SymbolTag.SYMBOL_NAME.ordinal());
                bufferWriter.writeString(optString4);
            }
            i3++;
            jSONArray2 = jSONArray;
            z2 = 0;
            i = 255;
            i2 = -1;
        }
        if (i4 == i2) {
            configInfo.flag |= 2;
            return true;
        }
        configInfo.returnFrameIndex = i4;
        return true;
    }

    private static Long hexStringToLong(Object obj) {
        if (obj == null || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        if (str.isEmpty()) {
            return null;
        }
        if (str.startsWith("0x") || str.startsWith("0X")) {
            try {
                return Long.valueOf(Long.parseLong(str.substring(2), 16));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    private static boolean matchesScope(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (!isValidScopeName(str)) {
            return false;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (str.startsWith(arrayList.get(i)) && (arrayList.get(i).length() == str.length() || str.charAt(arrayList.get(i).length()) == '.')) {
                return false;
            }
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            if (str.startsWith(arrayList2.get(i2)) && (arrayList2.get(i2).length() == str.length() || str.charAt(arrayList2.get(i2).length()) == '.')) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidScopeName(String str) {
        return str.length() < 256 && sScopePattern.matcher(str).matches();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class ConfigInfo {
        String abortMsg;
        BufferWriter elfList;
        BufferWriter frameList;
        String scope;
        int flag = 0;
        int elfListCount = 0;
        int returnFrameIndex = 0;
        int maxIgnoreDepth = 0;
        int framesCount = 0;
        int maxResumeCount = 0;
        int intervalTimeMs = 0;
        long signal = 0;
        ArrayList<Pair<Integer, Long>> regs = null;

        ConfigInfo() {
        }

        public void encode(BufferWriter bufferWriter) {
            bufferWriter.align(8);
            int position = bufferWriter.position();
            int i = 0;
            int prependInt32 = bufferWriter.prependInt32(0);
            bufferWriter.writeInt32(this.flag);
            bufferWriter.writeByte(this.scope.getBytes().length);
            bufferWriter.writeByte(this.elfListCount);
            bufferWriter.writeByte(this.returnFrameIndex);
            bufferWriter.writeByte(this.maxIgnoreDepth);
            bufferWriter.writeByte(this.framesCount);
            ArrayList<Pair<Integer, Long>> arrayList = this.regs;
            bufferWriter.writeByte(arrayList == null ? 0 : arrayList.size());
            bufferWriter.writeInt32(this.maxResumeCount);
            bufferWriter.writeInt32(this.intervalTimeMs);
            bufferWriter.writeInt64(this.signal);
            int prependInt322 = bufferWriter.prependInt32(0);
            int prependInt323 = bufferWriter.prependInt32(0);
            int prependInt324 = bufferWriter.prependInt32(0);
            int prependInt325 = bufferWriter.prependInt32(0);
            int prependInt326 = bufferWriter.prependInt32(0);
            int prependInt327 = bufferWriter.prependInt32(0);
            bufferWriter.writeInt32At(prependInt322, bufferWriter.position() - position);
            bufferWriter.write(this.scope.getBytes());
            bufferWriter.writeByte(0);
            String str = this.abortMsg;
            if (str != null && !str.isEmpty()) {
                bufferWriter.writeInt32At(prependInt323, bufferWriter.position() - position);
                bufferWriter.write(this.abortMsg.getBytes());
                bufferWriter.writeByte(0);
            }
            bufferWriter.writeInt32At(prependInt324, bufferWriter.position() - position);
            bufferWriter.write(this.elfList.data(), 0, this.elfList.position());
            bufferWriter.writeInt32At(prependInt325, bufferWriter.position() - position);
            bufferWriter.write(this.frameList.data(), 0, this.frameList.position());
            ArrayList<Pair<Integer, Long>> arrayList2 = this.regs;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                bufferWriter.writeInt32At(prependInt326, bufferWriter.position() - position);
                for (int i2 = 0; i2 < this.regs.size(); i2++) {
                    bufferWriter.writeByte(((Integer) this.regs.get(i2).first).intValue());
                }
                if (CrashProtectorConfig.this.mIs64BitRuntime) {
                    bufferWriter.align(8);
                    bufferWriter.writeInt32At(prependInt327, bufferWriter.position() - position);
                    while (i < this.regs.size()) {
                        bufferWriter.writeInt64(((Long) this.regs.get(i).second).longValue());
                        i++;
                    }
                } else {
                    bufferWriter.align(4);
                    bufferWriter.writeInt32At(prependInt327, bufferWriter.position() - position);
                    while (i < this.regs.size()) {
                        bufferWriter.writeInt32(((Long) this.regs.get(i).second).intValue());
                        i++;
                    }
                }
            }
            bufferWriter.align(8);
            bufferWriter.writeInt32At(prependInt32, bufferWriter.position() - position);
        }
    }
}
