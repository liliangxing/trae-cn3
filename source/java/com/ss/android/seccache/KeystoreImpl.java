package com.ss.android.seccache;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.KeyGenerator;

/* loaded from: classes7.dex */
public class KeystoreImpl {
    private static final String ANDROID_KEY_STORE_NAME = "AndroidKeyStore";
    public static final KeystoreImpl INSTANCE = SingleHolder.sInstance;
    private static final String KEY_ALIAS = "SecCache";
    private static final String TAG = "KeystoreImpl";

    /* loaded from: classes7.dex */
    private static class SingleHolder {
        static final KeystoreImpl sInstance = new KeystoreImpl();

        private SingleHolder() {
        }
    }

    private void initKeys() throws KeyStoreException, NoSuchAlgorithmException, IOException, NoSuchProviderException, InvalidAlgorithmParameterException, UnrecoverableEntryException, CertificateException {
        boolean z;
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        if (!keyStore.containsAlias(KEY_ALIAS)) {
            initValidKeys();
            return;
        }
        try {
            z = keyStore.getEntry(KEY_ALIAS, null) instanceof KeyStore.SecretKeyEntry;
        } catch (NullPointerException | UnrecoverableKeyException e) {
            Log.e(TAG, "Failed to get key store entry", e);
            z = false;
        }
        if (z) {
            return;
        }
        keyStore.deleteEntry(KEY_ALIAS);
        initValidKeys();
    }

    private void initValidKeys() {
        generateKeysForAPIMOrGreater();
    }

    private void generateKeysForAPIMOrGreater() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            keyGenerator.init(new KeyGenParameterSpec.Builder(KEY_ALIAS, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setRandomizedEncryptionRequired(false).build());
            keyGenerator.generateKey();
        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException e) {
            e.printStackTrace();
        }
    }

    public Key getSecretKeyAPIMorGreater() throws NoSuchAlgorithmException, IOException, KeyStoreException, UnrecoverableEntryException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        Key key = keyStore.getKey(KEY_ALIAS, null);
        if (key != null) {
            return key;
        }
        initKeys();
        return keyStore.getKey(KEY_ALIAS, null);
    }
}
