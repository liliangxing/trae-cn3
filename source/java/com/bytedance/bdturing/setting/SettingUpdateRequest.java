package com.bytedance.bdturing.setting;

import com.bytedance.applog.server.Api;
import com.bytedance.bdturing.ttnet.HttpClient;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.random.URandomKt;
import kotlin.text.Charsets;
import kotlin.text.UStringsKt;
import org.json.JSONObject;

/* compiled from: SettingUpdateRequest.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ$\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J(\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0012H\u0002J\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/bdturing/setting/SettingUpdateRequest;", "", "mUrl", "", "params", "", "mCallback", "Lcom/bytedance/bdturing/setting/SettingUpdateRequest$Callback;", "mHttpClient", "Lcom/bytedance/bdturing/ttnet/HttpClient;", "(Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/bdturing/setting/SettingUpdateRequest$Callback;Lcom/bytedance/bdturing/ttnet/HttpClient;)V", "decryptReponseWithAes256gcm", Api.KEY_ENCRYPT_RESP_KEY, "", Api.KEY_ENCRYPT_RESP_IV, "responseStream", "Ljava/io/InputStream;", "generateKey", "Lkotlin/Pair;", "keySeed", "ivSeed", "getKeyIvSeeds", "startGetResponse", "", "Callback", "setting_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class SettingUpdateRequest {
    private final Callback mCallback;
    private final HttpClient mHttpClient;
    private final String mUrl;
    private final Map<Object, Object> params;

    /* compiled from: SettingUpdateRequest.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/bdturing/setting/SettingUpdateRequest$Callback;", "", "onResponse", "", "responseCode", "", "responseContent", "", "duration", "", "setting_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface Callback {
        void onResponse(int responseCode, String responseContent, long duration);
    }

    public SettingUpdateRequest(String str, Map<Object, Object> map, Callback callback, HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(str, "mUrl");
        Intrinsics.checkNotNullParameter(map, "params");
        Intrinsics.checkNotNullParameter(callback, "mCallback");
        Intrinsics.checkNotNullParameter(httpClient, "mHttpClient");
        this.mUrl = str;
        this.params = map;
        this.mCallback = callback;
        this.mHttpClient = httpClient;
    }

    private final Pair<String, String> getKeyIvSeeds() {
        Random Random = RandomKt.Random(System.nanoTime());
        return new Pair<>(UStringsKt.toString-V7xB4Y4(URandomKt.nextUInt(Random), 16), UStringsKt.toString-V7xB4Y4(URandomKt.nextUInt(Random), 16));
    }

    public final void startGetResponse() {
        long currentTimeMillis = System.currentTimeMillis();
        String str = "";
        Pair<String, String> keyIvSeeds = getKeyIvSeeds();
        this.params.put(Api.KEY_ENCRYPT_RESP_KEY, keyIvSeeds.getFirst());
        this.params.put(Api.KEY_ENCRYPT_RESP_IV, keyIvSeeds.getSecond());
        Pair<byte[], byte[]> generateKey = generateKey((String) keyIvSeeds.getFirst(), (String) keyIvSeeds.getSecond());
        Object first = generateKey.getFirst();
        Object second = generateKey.getSecond();
        int i = -1;
        try {
            try {
                String jSONObject = new JSONObject(this.params).toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(params).toString()");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("Content-type", "application/json;tt-data=g");
                HttpClient httpClient = this.mHttpClient;
                String str2 = this.mUrl;
                byte[] bytes = jSONObject.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                byte[] post = httpClient.post(str2, linkedHashMap, bytes);
                if (post == null || post.length <= 0) {
                    i = 204;
                } else {
                    i = 200;
                    str = decryptReponseWithAes256gcm((byte[]) first, (byte[]) second, new ByteArrayInputStream(post));
                }
            } catch (Exception e) {
                i = 500;
                e.printStackTrace();
            }
        } finally {
            this.mCallback.onResponse(i, str, System.currentTimeMillis() - currentTimeMillis);
        }
    }

    private final Pair<byte[], byte[]> generateKey(String keySeed, String ivSeed) {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = keySeed.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] digest = messageDigest.digest(bytes);
        MessageDigest messageDigest2 = MessageDigest.getInstance("MD5");
        byte[] bytes2 = ivSeed.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        byte[] digest2 = messageDigest2.digest(bytes2);
        return new Pair<>(digest, digest2 != null ? ArraysKt.copyOfRange(digest2, 0, 12) : null);
    }

    private final String decryptReponseWithAes256gcm(byte[] key, byte[] iv, InputStream responseStream) {
        if (key == null || iv == null) {
            return TextStreamsKt.readText(new InputStreamReader(responseStream));
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, new IvParameterSpec(iv).getIV());
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, secretKeySpec, gCMParameterSpec);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(cipher.doFinal(ByteStreamsKt.readBytes(responseStream))));
        try {
            String readText = TextStreamsKt.readText(new InputStreamReader(gZIPInputStream));
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(gZIPInputStream, (Throwable) null);
            return readText;
        } finally {
        }
    }
}
