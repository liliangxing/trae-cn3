package org.bouncycastle.crypto.params;

import com.ss.bduploader.BDVideoUploaderBase;
import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* loaded from: classes8.dex */
public class X448KeyGenerationParameters extends KeyGenerationParameters {
    public X448KeyGenerationParameters(SecureRandom secureRandom) {
        super(secureRandom, BDVideoUploaderBase.KeyIsDynamicSliceLowSize);
    }
}
