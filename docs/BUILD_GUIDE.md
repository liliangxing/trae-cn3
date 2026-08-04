# TRAE Android APK 重编译指南

## 前提条件

- JDK 17+
- Android SDK (for aapt2, apksigner)
- smali/baksmali 3.0.3+
- Python 3.10+ (for provided scripts)

## 目录结构

```
├── source/smali/com/bytedance/trae/   # 6732 business classes
├── docs/TRAE-Android-API-Documentation.md
└── original-apk/                       # 提取的第三方库 + 资源
    ├── classes2.dex ~ classes9.dex    # 第三方库DEX
    ├── lib/                           # Native .so files
    ├── res/                           # Android resources
    ├── AndroidManifest.xml
    └── META-INF/                      # Signing info
```

## 重编译步骤

### 1. 提取第三方代码（保留不动）

```bash
mkdir -p original-apk
cd original-apk
unzip ../trae_mobile_v0.0.16.apk -d .
# 只保留非 TRAE 业务代码
```

### 2. 用反编译的业务代码替换DEX

```bash
# 反编译原始APK获取全部smali
java -jar baksmali.jar disassemble classes.dex -o smali_all/
java -jar baksmali.jar disassemble classes4.dex -o smali4_all/
java -jar baksmali.jar disassemble classes5.dex -o smali5_all/

# 用我们的可读smali替换 TRAE 业务代码
rm -rf smali_all/com/bytedance/trae/
rm -rf smali4_all/com/bytedance/trae/
rm -rf smali5_all/com/bytedance/trae/

cp -r source/smali/com/bytedance/trae/ smali_all/com/bytedance/trae/
cp -r source/smali/com/bytedance/trae/ smali4_all/com/bytedance/trae/
cp -r source/smali/com/bytedance/trae/ smali5_all/com/bytedance/trae/

# 重新汇编
java -jar smali.jar assemble smali_all/ -o classes.dex
java -jar smali.jar assemble smali4_all/ -o classes4.dex
java -jar smali.jar assemble smali5_all/ -o classes5.dex
```

### 3. 重打包APK

```bash
# 创建临时目录
mkdir -p rebuild/
cp -r original-apk/* rebuild/
cp classes.dex classes4.dex classes5.dex rebuild/

# 打包为ZIP (APK)
cd rebuild/
zip -r ../trae_rebuilt.apk . -x "META-INF/*"
```

### 4. 对齐 & 签名

```bash
# ZIP对齐
zipalign -f 4 trae_rebuilt.apk trae_aligned.apk

# V1+V2 签名（需要keystore）
apksigner sign --ks release.jks --ks-pass pass:xxx \
  --key-pass pass:xxx --out trae_release.apk trae_aligned.apk
```

## 已知限制

1. **Native库**: lib/arm64-v8a/ 下的 .so 文件（libLynx, libjsc, libpython等）无法从源码重建
2. **第三方SDK**: Argus, Pitaya, SLARDAR 等字节内部SDK保持原样
3. **签名**: 重建的APK签名与原始不同，需要重新登录账号
4. **API调用**: 字节Passport SDK需要设备注册（device_register），然后才能调用登录/发码接口

## API 测试

业务代码中的网络调用使用 `com.bytedance.trae.network.*` 包。核心入口:

- `NetworkClient` — 所有HTTP请求的统一入口
- `AuthInterceptor` — 注入认证头
- `ApiProvider` — 定义retrofit接口

注意：后端会验证 x-gorgon / x-khronos 签名头，这些头只能由运行在真实设备上的 Bytedance SDK 生成。直接 HTTP 请求会被拒绝。
