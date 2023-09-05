package com.warship.test.javabase.encryption;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStore.PasswordProtection;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.cert.Certificate;
import java.util.Base64;

import javax.crypto.Cipher;

/**
 * RSA <br>
 * keytool -genkeypair -alias warship -storepass f8G6lq -keypass t4u90f -keyalg RSA -keystore warship.jks
 * <br>
 * keytool -importkeystore -srckeystore warship.jks -destkeystore warship.jks -deststoretype pkcs12
 * <br>
 * 
 * @author Adam
 * @date 2021/01/27
 */
final class RSA {

    /**
     * 生成密钥对
     * 
     * @return
     * @throws Exception
     */
    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048, new SecureRandom());
        return generator.generateKeyPair();
    }

    /**
     * 根据文件生成密钥对
     * 
     * @param file
     * @return
     * @throws Exception
     */
    public static KeyPair generateKeyPair(String file) throws Exception {
        return generateKeyPair(new File(file));
    }

    /**
     * 根据文件生成密钥对
     * 
     * @param file
     * @return
     * @throws Exception
     */
    public static KeyPair generateKeyPair(File file) throws Exception {
        return generateKeyPair(new FileInputStream(file));
    }

    /**
     * 根据流生成密钥对
     * 
     * @param stream
     * @return
     * @throws Exception
     */
    //C:\Users\Administrator>keytool -genkeypair -alias warship -storepass @!pk)@)$BW -keypass @!KpBWjkqp24 -keyalg RSA -keystore warship.jks
    public static KeyPair generateKeyPair(InputStream stream) throws Exception {
//        KeyStore keyStore = KeyStore.getInstance("JCEKS");
//        keyStore.load(stream, "@!pk)@)$BW".toCharArray());// storepass
//        PasswordProtection keyPassword = new PasswordProtection("@!KpBWjkqp24".toCharArray());// keypass
//        PrivateKeyEntry privateKeyEntry = (PrivateKeyEntry)keyStore.getEntry("warship", keyPassword);
//        Certificate cert = keyStore.getCertificate("warship");
//        PublicKey publicKey = cert.getPublicKey();
//        PrivateKey privateKey = privateKeyEntry.getPrivateKey();
//        return new KeyPair(publicKey, privateKey);

        KeyStore keyStore = KeyStore.getInstance("JCEKS");
        keyStore.load(stream, "f8G6lq".toCharArray());// storepass
        PasswordProtection keyPassword = new PasswordProtection("t4u90f".toCharArray());// keypass
        PrivateKeyEntry privateKeyEntry = (PrivateKeyEntry)keyStore.getEntry("warship", keyPassword);
        Certificate cert = keyStore.getCertificate("warship");
        PublicKey publicKey = cert.getPublicKey();
        PrivateKey privateKey = privateKeyEntry.getPrivateKey();
        return new KeyPair(publicKey, privateKey);
    }

    /**::
     * 加密
     * 
     * @param plainText
     *            文本
     * @param publicKey
     *            公钥
     * @return
     * @throws Exception
     */
    public static String encrypt(String plainText, PublicKey publicKey) throws Exception {
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] cipherText = encryptCipher.doFinal(plainText.getBytes(UTF_8));
        return Base64.getEncoder().encodeToString(cipherText);
    }

    /**
     * 解密
     * 
     * @param cipherText
     *            密文
     * @param privateKey
     *            私钥
     * @return
     * @throws Exception
     */
    public static String decrypt(String cipherText, PrivateKey privateKey) throws Exception {
        byte[] bytes = Base64.getDecoder().decode(cipherText);
        Cipher decriptCipher = Cipher.getInstance("RSA");
        decriptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(decriptCipher.doFinal(bytes), UTF_8);
    }

    /**
     * 生成签名
     * 
     * @param plainText
     *            文本
     * @param privateKey
     *            私钥
     * @return
     * @throws Exception
     */
    public static String sign(String plainText, PrivateKey privateKey) throws Exception {
        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        privateSignature.initSign(privateKey);
        privateSignature.update(plainText.getBytes(UTF_8));
        byte[] signature = privateSignature.sign();
        return Base64.getEncoder().encodeToString(signature);
    }

    /**
     * 校验签名
     * 
     * @param plainText
     *            文本
     * @param signature
     *            签名
     * @param publicKey
     *            公钥
     * @return
     * @throws Exception
     */
    public static boolean verify(String plainText, String signature, PublicKey publicKey) throws Exception {
        Signature publicSignature = Signature.getInstance("SHA256withRSA");
        publicSignature.initVerify(publicKey);
        publicSignature.update(plainText.getBytes(UTF_8));
        byte[] signatureBytes = Base64.getDecoder().decode(signature);
        return publicSignature.verify(signatureBytes);
    }

    /**
     * 将密钥写入文件
     * 
     * @param key
     *            密钥
     * @param alias
     *            别名
     * @param dir
     *            文件路径
     * @param file
     *            文件名
     * @throws Exception
     */
    public static void writeKey(Key key, String alias, String dir, String file) throws Exception {
        writeKey(key, alias, new File(dir, file));
    }

    /**
     * 将密钥写入文件
     * 
     * @param key
     *            密钥
     * @param alias
     *            别名
     * @param file
     *            文件
     * @throws Exception
     */
    public static void writeKey(Key key, String alias, File file) throws Exception {
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        int LINE_LEN = 76;
        String LINE_SEP = System.getProperty("line.separator");
        String keyAlias = alias.toUpperCase();
        String keyContent = Base64.getEncoder().encodeToString(key.getEncoded());
        char[] keyChars = keyContent.toCharArray();
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), UTF_8));
        // key head
        out.write("-----BEGIN RSA " + keyAlias + " KEY-----");
        out.write(LINE_SEP);
        // key content
        for (int i = 0, len = keyChars.length; i < len; i++) {
            int num = i + 1;
            char c = keyChars[i];
            out.write(c);
            if (num % LINE_LEN == 0) {
                out.write(LINE_SEP);
            }
        }
        out.write(LINE_SEP);
        // key tail
        out.write("-----END RSA " + keyAlias + " KEY-----");
        // end
        out.flush();
        out.close();
    }

    public static void main(String... arg) throws Exception {
        // First generate a public/private key pair
        KeyPair pair = generateKeyPair();
        // KeyPair pair = getKeyPairFromKeyStore();

        // Our secret message
        String message = "the answer to life the universe and everything";

        // Encrypt the message
        String cipherText = encrypt(message, pair.getPublic());

        // Now decrypt it
        String decipheredMessage = decrypt(cipherText, pair.getPrivate());
        System.out.println(decipheredMessage);

        // Let's sign our message
        String signature = sign("foobar", pair.getPrivate());

        // Let's check the signature
        boolean isCorrect = verify("foobar", signature, pair.getPublic());
        System.out.println("Signature correct: " + isCorrect);
    }

}
