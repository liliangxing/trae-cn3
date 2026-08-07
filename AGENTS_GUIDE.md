# AI Agent 操作指引（必读）

> **如果你是 AI Agent，请在做任何修改之前完整阅读本文件。**
> **最后更新：2026-08-07（v23 打包验证后）**

---

## 1. 核心原则：Java 是唯一源码

**自定义代码只存 Java，不存 Smali。**

```
你修改的文件              构建过程                              最终产物
source/java/*.java  →  javac → dx → baksmali  →  *.smali  →  替换 dex  →  APK
（唯一源码）              （编译链，中间产物）     （临时文件）   （签名打包）
```

- 你只修改 `source/java/` 下的 Java 文件
- Smali 是编译生成的中间产物，不存仓库、不手动修改
- 如果你看到 `source/smali/` 下有自定义类的 .smali 文件，**那是错误的**，应该删除

---

## 2. 仓库里有什么、在哪里

### 2.1 目录结构

| 目录 | 内容 | 你能改吗 |
|------|------|---------|
| `source/java/com/bytedance/trae/conversation/extract/` | 4 个手写 Java 文件 | **可以改，这是你的工作区** |
| `source/stubs/` | 14 个 stub 类（编译依赖用） | 一般不改，除非编译报错缺类 |
| `source/java/` 其余部分 | 37,983 个 jadx 反编译的 Java 文件 | **不要改**（仅供阅读原版逻辑） |
| `source/smali/` | 原版 APK 的 Smali 文件 | **不要改**（打包时原样使用） |
| `source/res/` | 修改过的资源文件 | 可以改 |
| `BUILD_SCRIPT/` | 构建规范文档 | 可以改 |
| `build.sh` | 自动化构建脚本 | 可以改 |

### 2.2 自定义 Java 文件清单

| 文件 | 路径 | 作用 |
|------|------|------|
| `ExtractHelper.java` | `source/java/com/bytedance/trae/conversation/extract/` | 主入口：数据库查询 + API 回退 + Markdown 生成 |
| `ApiMessageFetcher.java` | 同上 | 从服务器 API 拉取消息（含 SSL TrustManager 内部类） |
| `FileLogger.java` | 同上 | 文件日志工具 |
| `GitHubPusher.java` | 同上 | 异步推送到 GitHub |

### 2.3 stub 类清单（14 个，在 `source/stubs/`）

stub 类是空壳类，只为让 javac 编译通过，**不参与最终 APK**。

| stub 类 | 为什么要它 |
|---------|-----------|
| `com.bytedance.trae.TraeApplication` | ExtractHelper 调用 `TraeApplication.Companion.getInst()` 获取 Context |
| `com.bytedance.trae.common.activity.SimpleWebViewActivity` | ExtractHelper 用它打开预览 |
| `com.bytedance.trae.conversation.BuildConfig` | GitHubPusher 调用 `BuildConfig.getGITHUB_TOKEN()` |
| `com.bytedance.trae.im.database.ChatMessageDao` | ExtractHelper 查询消息 |
| `com.bytedance.trae.im.database.ChatMessageEntity` | 消息实体类 |
| `com.bytedance.trae.im.database.ConversationDetailDao` | 备用查询 DAO |
| `com.bytedance.trae.im.database.ConversationDetailEntity` | 对话详情实体类 |
| `com.bytedance.trae.im.database.DatabaseManager` | 数据库单例 |
| `com.bytedance.trae.im.database.DatabaseOpenHelper` | SQLite 打开助手 |
| `com.bytedance.trae.login.api.AccountInfo` | 账号信息 |
| `com.bytedance.trae.login.api.ILoginService` | 登录服务接口 |
| `com.bytedance.trae.network.TraeHttpConnection` | API base URL |
| `com.bytedance.trae.service.SdkCommonHttpImpl` | API token 获取 |
| `com.ss.android.ugc.aweme.framework.services.ServiceManager` | 服务管理器 |

> **两个关键 stub 修复（v23 打包时发现的坑）：**
> 1. `TraeApplication` **不能继承 Context**（Context 是抽象类，有大量抽象方法）。改为普通类，`getInst()` 返回 `Object`，调用方自己强转。
> 2. `DatabaseManager.getDatabase()` 返回类型必须是 `DatabaseOpenHelper`（不能是 `Object`），否则 javac 报类型不兼容。

### 2.4 其他修改过的 Smali 文件（原版小改动）

| 文件 | 路径 | 改动 |
|------|------|------|
| MenuPopupWindow.smali | `source/smali/.../widget/` | 添加"提取对话"菜单点击 |
| MenuPopupWindow$OnMenuClickListener.smali | 同上 | 添加 `onExtractClick()` 方法 |
| MenuPopupWindow$$ExternalSyntheticLambda5.smali | 同上 | 新增：点击监听器 |
| ConversationActivity$initTitleBar$3$1.smali | `source/smali/.../conversation/` | 对话页面接入提取 |

> 这些是原版 APK 反编译后做了小改动（加菜单项），不是自定义类，所以仍以 Smali 形式存储。
> **注意：** `TaskFragment.smali` 在原版 APK 的 `smali_classes5` 中已有修改版，不需要额外同步。

---

## 3. 如何修改代码

### 3.1 修改 Java 文件

直接编辑 `source/java/com/bytedance/trae/conversation/extract/` 下的 `.java` 文件。

**改完后必须重新编译成 Smali 才能打包 APK。** 见第 4 节。

### 3.2 为什么不能直接存 Smali？

1. Smali 不可读，维护困难
2. Java 是单一源码，避免 Smali 和 Java 不一致
3. 从 Java 编译 Smali 是确定性过程，不会引入人为错误
4. 如果你发现仓库里有自定义类的 .smali 文件，**请删除它**，只保留 .java

---

## 4. 如何从 Java 编译 Smali 并打包 APK

> **以下所有命令均在 v23 打包中真实执行并验证通过（2026-08-07）。**
> **有 `build.sh` 自动化脚本可用，但建议先手动跑一遍理解流程。**

### 4.1 安装工具

```bash
# 1. 安装基础工具
apt-get update -qq
apt-get install -y -qq apktool default-jdk android-sdk-build-tools

# 2. 下载新版 apktool（apt 版本 2.5.0 有 bug，必须用 2.9.3）
wget -q "https://github.com/iBotPeaches/Apktool/releases/download/v2.9.3/apktool_2.9.3.jar" -O /data/user/work/apktool.jar

# 3. 下载 uber-apk-signer（签名工具）
wget -q "https://github.com/patrickfav/uber-apk-signer/releases/download/v1.3.0/uber-apk-signer-1.3.0.jar" -O /data/user/work/uber-apk-signer.jar

# 4. 下载 baksmali（dex→smali 反编译工具）
wget -q "https://bitbucket.org/JesusFreke/smali/downloads/baksmali-2.5.2.jar" -O /data/user/work/baksmali.jar

# 5. 生成签名证书（如果还没有）
keytool -genkey -v -keystore /data/user/work/trae3.keystore \
  -alias trae3 -keyalg RSA -keysize 2048 -validity 10000 \
  -storepass trae123 -keypass trae123 \
  -dname "CN=TRAE3, OU=Dev, O=ByteDance, L=Beijing, ST=Beijing, C=CN"
```

### 4.2 工具路径速查

| 工具 | 路径 |
|------|------|
| apktool (jar) | `/data/user/work/apktool.jar`（用 `java -jar` 调用） |
| baksmali | `/data/user/work/baksmali.jar`（用 `java -jar` 调用） |
| uber-apk-signer | `/data/user/work/uber-apk-signer.jar`（用 `java -jar` 调用） |
| keystore | `/data/user/work/trae3.keystore`（密码 `trae123`） |
| android.jar | `/usr/lib/android-sdk/platforms/android-23/android.jar` |
| dx (替代 d8) | `/usr/lib/android-sdk/build-tools/debian/dx` |
| javac | 系统自带（`apt install default-jdk`） |

> **注意：** 环境里可能没有 `d8`，用 `dx` 代替。`dx --dex --output=out.dex classes/` 等价于 `d8 --output=out.dex classes/*.class`。

### 4.3 编译 Java → Smali

> **v24 重要修复：** 如果代码用了 `MediaStore.Downloads`（API 29+），必须先创建 MediaStore stub。
> 否则 javac 报 `cannot find symbol: MediaStore.Downloads`，编译失败，APK 中还是旧代码。

```bash
REPO=/data/user/work/trae-cn3-repo
ANDROID_JAR=/usr/lib/android-sdk/platforms/android-23/android.jar

# 0. 创建 MediaStore.Downloads stub（API 29+ 功能，API 23 android.jar 没有）
mkdir -p /data/user/work/mediastub/src/android/provider
cat > /data/user/work/mediastub/src/android/provider/MediaStore.java << 'STUB'
package android.provider;
import android.net.Uri;
public final class MediaStore {
    public static final class Downloads {
        public static final String DISPLAY_NAME = "_display_name";
        public static final String MIME_TYPE = "mime_type";
        public static final String RELATIVE_PATH = "relative_path";
        public static final Uri EXTERNAL_CONTENT_URI = Uri.parse("content://media/external/downloads");
    }
}
STUB
mkdir -p /data/user/work/mediastub/classes
javac -source 8 -target 8 -cp "$ANDROID_JAR" \
  -d /data/user/work/mediastub/classes \
  /data/user/work/mediastub/src/android/provider/MediaStore.java
cd /data/user/work/mediastub/classes
jar cf /data/user/work/mediastub/mediastub.jar .

# 1. 编译 stub 类（MediaStore stub 放 classpath 最前面）
mkdir -p /data/user/work/stubs/classes
javac -source 8 -target 8 \
  -cp "/data/user/work/mediastub/mediastub.jar:$ANDROID_JAR" \
  -d /data/user/work/stubs/classes \
  $(find "$REPO/source/stubs" -name "*.java")

# 2. 打包 stub 为 jar
cd /data/user/work/stubs/classes
jar cf /data/user/work/stubs/stubs.jar .

# 3. 编译自定义 Java 文件（MediaStore stub 放 classpath 最前面）
mkdir -p /data/user/work/build/classes
javac -source 8 -target 8 \
  -cp "/data/user/work/mediastub/mediastub.jar:$ANDROID_JAR:/data/user/work/stubs/stubs.jar" \
  -d /data/user/work/build/classes \
  "$REPO/source/java/com/bytedance/trae/conversation/extract/"*.java

# 4. 用 dx 转 dex
/usr/lib/android-sdk/build-tools/debian/dx --dex \
  --output=/data/user/work/build/classes.dex \
  /data/user/work/build/classes

# 5. 用 apktool 反编译 dex 为 smali（如果没有独立 baksmali.jar，用 apktool 代替）
# 方法 A：有 baksmali.jar
# java -jar /data/user/work/baksmali.jar d /data/user/work/build/classes.dex -o /data/user/work/build/smali
#
# 方法 B：没有 baksmali.jar，用 apktool（创建 dummy APK 再反编译）
mkdir -p /data/user/work/dummy_apk
unzip -o /workspace/trae_cn3_v23.apk AndroidManifest.xml -d /data/user/work/dummy_apk/
cp /data/user/work/build/classes.dex /data/user/work/dummy_apk/
cd /data/user/work/dummy_apk
zip -q /data/user/work/build/dummy.apk AndroidManifest.xml classes.dex
java -jar /data/user/work/apktool.jar d /data/user/work/build/dummy.apk \
  -o /data/user/work/build/smali -f
```

编译成功后在 `/data/user/work/build/smali/smali/com/bytedance/trae/conversation/extract/` 下应有 5 个文件：
- `ExtractHelper.smali`
- `ApiMessageFetcher.smali`
- `ApiMessageFetcher$1.smali`（匿名内部类，SSL TrustManager）
- `FileLogger.smali`
- `GitHubPusher.smali`

### 4.4 替换 dex 并打包 APK

> **重要发现（v23 打包）：** apktool 2.9.3 编译 dex 没问题，但资源编译会因 framework apk 太旧报错
> （`attribute android:dataExtractionRules not found`）。
> **解决方案：** 用 apktool 只编译 dex，然后手动替换到原始 APK 中。

```bash
DECODED=/data/user/work/trae_cn3_decoded
ORIGINAL_APK=/workspace/trae_cn3_v22.apk  # 上一个版本的 APK

# 1. 解包原始 APK
rm -rf "$DECODED"
java -jar /data/user/work/apktool.jar d "$ORIGINAL_APK" -o "$DECODED" -f

# 2. 替换自定义 Smali
cp /data/user/work/build/smali/com/bytedance/trae/conversation/extract/*.smali \
   "$DECODED/smali_classes9/com/bytedance/trae/conversation/extract/"

# 3. 删除 build 缓存
rm -rf "$DECODED/build"

# 4. 用 apktool 编译（只需 dex，资源编译会失败但 dex 已生成）
java -jar /data/user/work/apktool.jar b "$DECODED" -o /tmp/dummy.apk 2>&1 || true

# 5. 验证 dex 已生成
ls -la "$DECODED/build/apk/classes9.dex"

# 6. 复制原始 APK，删除旧签名，替换 dex
cp "$ORIGINAL_APK" /workspace/trae_cn3_v23.apk
zip -d /workspace/trae_cn3_v23.apk "META-INF/*"

# 7. 替换 classes9.dex
cd "$DECODED/build/apk/"
zip -0 /workspace/trae_cn3_v23.apk classes9.dex

# 8. 恢复 META-INF/services（删除签名时被误删）
mkdir -p /tmp/meta_restore && cd /tmp/meta_restore
unzip -o "$ORIGINAL_APK" "META-INF/services/*" -d .
zip /workspace/trae_cn3_v23.apk META-INF/services/*
```

### 4.5 签名（关键！）

```bash
java -jar /data/user/work/uber-apk-signer.jar \
  -a /workspace/trae_cn3_v23.apk \
  --out /workspace \
  --ks /data/user/work/trae3.keystore \
  --ksAlias trae3 \
  --ksPass trae123 \
  --ksKeyPass trae123 \
  --allowResign
```

> **绝对不能用 jarsigner！** 它只生成 v1 签名，Android 7.0+ 会闪退（package info is null）。
> **必须看到 `signature verified [v2, v3]` 才算成功。**

签名后会生成 `trae_cn3_v23-aligned-signed.apk`，重命名为 `trae_cn3_v23.apk` 即可。

### 4.6 验证

```bash
# 验证签名
java -jar /data/user/work/uber-apk-signer.jar -a /workspace/trae_cn3_v23.apk -y

# 验证完整性
unzip -t /workspace/trae_cn3_v23.apk

# 验证 dex 内容
mkdir -p /tmp/verify && cd /tmp/verify
unzip -o /workspace/trae_cn3_v23.apk classes9.dex -d .
java -jar /data/user/work/baksmali.jar d classes9.dex -o verify_smali
find verify_smali -name "*.smali" -path "*/extract/*" | sort

# 验证关键参数
grep "before_limit" verify_smali/com/bytedance/trae/conversation/extract/ApiMessageFetcher.smali
# 应该输出: const-string v1, "&before_limit=10&after_limit=0&include_anchor=true"
```

---

## 5. 自动化构建脚本

仓库根目录有 `build.sh`，可一键完成上述全部步骤：

```bash
# 用法
./build.sh /workspace/trae_cn3_v22.apk /workspace/trae_cn3_v24.apk
# 参数1：输入 APK（上一个版本）
# 参数2：输出 APK 路径
```

脚本会自动：解包 → 编译 Java → 替换 dex → 恢复 services → 签名 → 验证。

---

## 6. 常见错误与避坑

### 6.1 "package info is null" 闪退
**原因：** 只签了 v1（用了 jarsigner）
**解决：** 用 uber-apk-signer，确保输出 `[v2, v3]`

### 6.2 VerifyError 闪退
**原因：** Smali 寄存器类型冲突（如果你手写了 Smali）
**解决：** 不要手写 Smali，从 Java 编译

### 6.3 apktool 资源编译失败
**原因：** apt 安装的 apktool 2.5.0 的 aapt 不支持 `$` 开头的资源名；apktool 2.9.3 的 framework apk 太旧不认识 `dataExtractionRules`
**解决：** 用 apktool 只编译 dex（`b` 命令），然后手动替换 `classes9.dex` 到原始 APK 中。详见第 4.4 节。

### 6.4 META-INF/services 被误删
**原因：** `zip -d apk "META-INF/*"` 删除签名时，把 services 目录也删了
**解决：** 从原始 APK 提取 `META-INF/services/*` 并重新打包回去

### 6.5 打包出来代码没变
**原因：** apktool 用了 `build/` 缓存
**解决：** 打包前 `rm -rf decoded_project/build`

### 6.6 Smali 文件冲突
**原因：** 同一个类在多个 `smali_classes*` 目录下都有
**解决：** 自定义类只放在 `smali_classes9/`

### 6.7 API 返回 400
**原因：** `before_limit` 参数值不对
**解决：** 必须用 `before_limit=10`

### 6.8 GitHubPusher 推送失败
**原因：** Token 已失效（GitHub 会自动吊销泄露的 token）
**解决：** 生成新 Token，更新到 `BuildConfig.java` stub

### 6.9 编译 Java 报错找不到类
**原因：** 缺少 stub 类
**解决：** stub 类在 `source/stubs/` 目录下。如果还缺类，创建新 stub 并加入仓库。

### 6.10 dx 找不到
**原因：** 环境里没有 d8，只有 dx
**解决：** `apt install android-sdk-build-tools`，然后用 `/usr/lib/android-sdk/build-tools/debian/dx --dex`

### 6.11 keystore 不存在或签名不同
**原因：** 新环境没有 keystore，或者 keystore 是新生成的（SHA256 不同）
**解决：** 如果是新 keystore，安装前需要先卸载旧版本 APK（签名不同无法覆盖安装）

### 6.12 编译报错 cannot find symbol: MediaStore.Downloads
**原因：** 代码使用了 `MediaStore.Downloads`（API 29+），但 android.jar 是 API 23（`/usr/lib/android-sdk/platforms/android-23/android.jar`）
**解决：** 创建 `MediaStore` stub 类（含 `Downloads` 内部类），编译时把 stub jar 放在 classpath **最前面**（在 android.jar 之前）。stub 只用于编译，运行时用系统的 MediaStore。详见第 4.3 节。

### 6.13 提交了代码但 APK 中没生效
**原因：** 编译失败（如 6.12），但构建脚本可能没有 `set -e` 或错误被 `|| true` 吞掉，导致用了旧 dex
**解决：** 每次打包后必须验证 APK 中的 smali 包含新代码（用 apktool 反编译 APK，grep 关键字）

---

## 7. 需要哪些工具

| 工具 | 用途 | 安装方式 |
|------|------|---------|
| Java JDK 11 | 运行工具 + 编译 Java | `apt install default-jdk` |
| apktool 2.9.3 | APK 解包/编译 dex | `wget` 下载 jar（不要用 apt 版） |
| baksmali 2.5.2 | dex→smali | `wget` 下载 jar |
| uber-apk-signer 1.3.0 | APK 签名（v2/v3） | `wget` 下载 jar |
| dx | .class→.dex | `apt install android-sdk-build-tools` |
| android.jar | Android 框架类 | `apt install android-sdk-platform`（如果没有） |
| keytool | 生成 keystore | JDK 自带 |
| zip/unzip | APK 文件操作 | 系统自带 |

> **不需要任何特殊 skill、MCP 工具或浏览器自动化。** 只需要基本的文件读写和 bash 执行能力。

---

## 8. 完整搭建文档

从原始 APK 到修改到打包到反编译的完整过程，见：

**`搭建指南/trae_cn3-APK逆向修改与Smali转Java完整指南.md`**

---

## 9. 文件完整性检查清单

确认以下文件都在：

**Java 源码（必须）：**
- [ ] `source/java/com/bytedance/trae/conversation/extract/ExtractHelper.java`
- [ ] `source/java/com/bytedance/trae/conversation/extract/ApiMessageFetcher.java`
- [ ] `source/java/com/bytedance/trae/conversation/extract/FileLogger.java`
- [ ] `source/java/com/bytedance/trae/conversation/extract/GitHubPusher.java`

**stub 类（必须，14 个）：**
- [ ] `source/stubs/com/bytedance/trae/TraeApplication.java`
- [ ] `source/stubs/com/bytedance/trae/common/activity/SimpleWebViewActivity.java`
- [ ] `source/stubs/com/bytedance/trae/conversation/BuildConfig.java`
- [ ] `source/stubs/com/bytedance/trae/im/database/ChatMessageDao.java`
- [ ] `source/stubs/com/bytedance/trae/im/database/ChatMessageEntity.java`
- [ ] `source/stubs/com/bytedance/trae/im/database/ConversationDetailDao.java`
- [ ] `source/stubs/com/bytedance/trae/im/database/ConversationDetailEntity.java`
- [ ] `source/stubs/com/bytedance/trae/im/database/DatabaseManager.java`
- [ ] `source/stubs/com/bytedance/trae/im/database/DatabaseOpenHelper.java`
- [ ] `source/stubs/com/bytedance/trae/login/api/AccountInfo.java`
- [ ] `source/stubs/com/bytedance/trae/login/api/ILoginService.java`
- [ ] `source/stubs/com/bytedance/trae/network/TraeHttpConnection.java`
- [ ] `source/stubs/com/bytedance/trae/service/SdkCommonHttpImpl.java`
- [ ] `source/stubs/com/ss/android/ugc/aweme/framework/services/ServiceManager.java`

**构建文件（必须）：**
- [ ] `build.sh`（自动化构建脚本）
- [ ] `BUILD_SCRIPT/APK_BUILD_SPEC.md`
- [ ] `AGENTS_GUIDE.md`（本文件）

**不应存在的文件（如果有请删除）：**
- [ ] ~~`source/smali/.../extract/ExtractHelper.smali`~~
- [ ] ~~`source/smali/.../extract/ApiMessageFetcher.smali`~~
- [ ] ~~`source/smali/.../extract/ApiMessageFetcher$1.smali`~~
- [ ] ~~`source/smali/.../extract/FileLogger.smali`~~
- [ ] ~~`source/smali/.../extract/GitHubPusher.smali`~~

一键检查命令：
```bash
echo "=== 应该存在的 Java 文件 ==="
for f in ExtractHelper ApiMessageFetcher FileLogger GitHubPusher; do
  p="source/java/com/bytedance/trae/conversation/extract/$f.java"
  [ -f "$p" ] && echo "  OK  $p" || echo "  缺失 $p"
done

echo "=== stub 类检查 ==="
find source/stubs -name "*.java" | wc -l
# 应该输出 14

echo "=== 不应该存在的 Smali 文件 ==="
for f in ExtractHelper ApiMessageFetcher FileLogger GitHubPusher; do
  p="source/smali/com/bytedance/trae/conversation/extract/$f.smali"
  [ -f "$p" ] && echo "  错误！存在 $p（应删除）" || echo "  OK  $p 不存在"
done

echo "=== build.sh 是否存在 ==="
[ -f "build.sh" ] && echo "  OK" || echo "  缺失"
```

---

## 10. 版本历史

| 版本 | 日期 | 说明 |
|------|------|------|
| v22 | 2026-08-06 | 首个 Java→Smali 编译打包版本 |
| v23 | 2026-08-07 | 从远程仓库代码重新打包，验证全流程可复现 |
| v23-release | 2026-08-07 | 提交 build.sh + 14 个 stub 类，修复 GitHubPusher 仓库名为 trae-cn3，发布 GitHub Release |
| v24 | 2026-08-07 | 修复 MediaStore.Downloads 编译失败问题（API 23→29 stub），重新打包含提交 6539434 的改动 |
