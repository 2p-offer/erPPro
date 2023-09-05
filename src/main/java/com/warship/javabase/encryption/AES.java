package com.warship.test.javabase.encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * AES
 * 
 * @author Adam
 * @date 2021/01/27
 */
final class AES {

    static private final String ENCODING = "UTF-8";
    static private final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    static private final String AES = "AES";

    /**
     * 
     * @param plainText
     * @param key
     * @return
     * @throws Exception
     */
    public static String encrypt(String plainText, String key) throws Exception {
        byte[] textByte = plainText.getBytes(ENCODING);
        byte[] keyByte = getKeyBytes(key);
        SecretKeySpec sks = new SecretKeySpec(keyByte, AES);
        IvParameterSpec ips = new IvParameterSpec(keyByte);
        Cipher cp = Cipher.getInstance(TRANSFORMATION);
        cp.init(Cipher.ENCRYPT_MODE, sks, ips);
        byte[] cipherText = cp.doFinal(textByte);
        return new String(Base64.encodeBase64(cipherText));
    }

    /**
     * 
     * @param cipherText
     * @param key
     * @return
     * @throws Exception
     */
    public static String decrypt(String cipherText, String key) throws Exception {
        byte[] textByte = Base64.decodeBase64(cipherText.getBytes("UTF8"));
        byte[] keyByte = getKeyBytes(key);
        SecretKeySpec sks = new SecretKeySpec(keyByte, AES);
        IvParameterSpec ips = new IvParameterSpec(keyByte);
        Cipher cp = Cipher.getInstance(TRANSFORMATION);
        cp.init(Cipher.DECRYPT_MODE, sks, ips);
        byte[] plainText = cp.doFinal(textByte);
        return new String(plainText, ENCODING);
    }

    /**
     * 
     * @param key
     * @return
     */
    private static byte[] getKeyBytes(String key) throws Exception {
        byte[] keyBytes = new byte[16];
        byte[] parameterKeyBytes = key.getBytes(ENCODING);
        System.arraycopy(parameterKeyBytes, 0, keyBytes, 0, Math.min(parameterKeyBytes.length, keyBytes.length));
        return keyBytes;
    }

}
