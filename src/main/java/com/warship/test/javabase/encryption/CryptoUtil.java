package com.warship.test.javabase.encryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyPair;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 加密帮助类
 * 
 * @author Adam
 * @date 2021/01/28
 */
public final class CryptoUtil{

   protected final static Logger log = LoggerFactory.getLogger(CryptoUtil.class);

   private static KeyPair rsaKey = null;

   /**
    * 加密帮助类初始化
    */
   public static void init(){
      //initRSAKey(CryptoUtil.class.getResourceAsStream("E:/svn_new_2/WarShip/gow.jks"));
      try{
         initRSAKey(new FileInputStream("C:/Users/w/Desktop/tmp/encryption/warship.jks"));
      }catch(FileNotFoundException e){
         log.error("CryptoUtil.init.FileNotFoundException", e);
      }
      //RSA.writeKey(rsaKey.getPublic(), "warship", new File("E:/svn_new_2/WarShip/warshipPub.txt"));
      //catch(Exception e){
      //    log.error("CryptoUtil.init.Exception", e);
      //}
   }

   /**
    * 加密帮助类初始化
    * 
    * @param rsaStream
    */
   public static void init(InputStream rsaStream){
      if(null != rsaKey || null == rsaStream){
         return;
      }
      initRSAKey(rsaStream);
   }

   /**
    * RSA KeyPair 初始化
    * 
    * @param rsaStream
    */
   private static void initRSAKey(InputStream rsaStream){
      try{
         rsaKey = RSA.generateKeyPair(rsaStream);
         log.info("CryptoUtil init RSA KeyPair successfully.");
      }catch(Exception e){
         rsaKey = null;
         log.error("CryptoUtil init RSA KeyPair error", e);
      }
   }

   /**
    * RSA 是否可用
    * 
    * @return
    */
   private static boolean enableRSA(){
      return null != rsaKey;
   }

   /**
    * AES 加密
    * 
    * @param plainText
    *            文本
    * @param key
    *            密匙
    * @return
    * @throws Exception
    */
   public static String encryptAES(String plainText,
                                   String key)
         throws Exception{
      return AES.encrypt(plainText, key);
   }

   /**
    * AES 解密
    * 
    * @param cipherText
    *            密文
    * @param key
    *            密匙
    * @return
    * @throws Exception
    */
   public static String decryptAES(String cipherText,
                                   String key)
         throws Exception{
      return AES.decrypt(cipherText, key);
   }

   /**
    * RSA 加密
    * 
    * @param plainText
    *            文本
    * @return
    * @throws Exception
    */
   public static String encryptRSA(String plainText)
         throws Exception{
      if(!enableRSA()){
         throw new IllegalStateException("CryptoUtil RSA KeyPair unavailable!");
      }
      return RSA.encrypt(plainText, rsaKey.getPublic());
   }

   /**
    * RSA 解密
    * 
    * @param cipherText
    *            密文
    * @return
    * @throws Exception
    */
   public static String decryptRSA(String cipherText)
         throws Exception{
      if(!enableRSA()){
         throw new IllegalStateException("CryptoUtil RSA KeyPair unavailable!");
      }
      return RSA.decrypt(cipherText, rsaKey.getPrivate());
   }

   /**
    * RSA 生成签名
    * 
    * @param plainText
    *            文本
    * @return
    * @throws Exception
    */
   public static String signRSA(String plainText)
         throws Exception{
      if(!enableRSA()){
         throw new IllegalStateException("CryptoUtil RSA KeyPair unavailable!");
      }
      return RSA.sign(plainText, rsaKey.getPrivate());
   }

   /**
    * RSA 校验签名
    * 
    * @param plainText
    *            文本
    * @param signature
    *            签名
    * @return
    * @throws Exception
    */
   public static boolean verifyRSA(String plainText,
                                   String signature)
         throws Exception{
      if(!enableRSA()){
         throw new IllegalStateException("CryptoUtil RSA KeyPair unavailable!");
      }
      return RSA.verify(plainText, signature, rsaKey.getPublic());
   }

   /**
    * RSA 密钥写入文件
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
   public static void writeRSAKey(Key key,
                                  String alias,
                                  String dir,
                                  String file)
         throws Exception{
      writeRSAKey(key, alias, new File(dir, file));
   }

   /**
    * RSA 密钥写入文件
    * 
    * @param key
    *            密钥
    * @param alias
    *            别名
    * @param file
    *            文件
    * @throws Exception
    */
   public static void writeRSAKey(Key key,
                                  String alias,
                                  File file)
         throws Exception{
      RSA.writeKey(key, alias, file);
   }

}
