package com.warship.test.javabase.encryption;

public class Test {

    public static void main(String[] args) throws Exception {

        CryptoUtil.init();
//
////        CryptoUtil.init(new FileInputStream(new File("C:/Users/w/Desktop/tmp/encryption/warship.jks")));
//        try {
//
//            //DES  TEST
//            //  CLIEnt = work
//            String guding = "gujidingwenjiank";
//            String DESKey = "fdafdafdasdafdas";
//
//            String  encodeDESData = CryptoUtil.encryptAES(guding, DESKey);
//
//            System.out.println("encodeData:  " + encodeDESData);
////            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
////            @SuppressWarnings("deprecation")
////            byte[] publicKeyByte = com.alibaba.fastjson2.util.Base64
////                    .decodeFast("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAshajrdQC618UAWnGG+4ZlN/QhW0HJZHljcSNzc6sti9yl4NEKz1O5gAfiX3Q68bvtnJr7E40Txecmwa+A2ksBKno39YEaxOQYJwrp3NVHleDInloNWOEYK3hp1dBjgjei69uIOLPZJvmM1xvdNEg65thhzSihCgq3vWALsIAF3cJxXFiNZwathW/RjG8zA8Ca1/VzMjne9avse1PQzGpjJLTnVdsVb7BLqmckPORzu4CIqLFBloYHTX1tnH3Fz9Po2dyQ50DRpRfqINIY8KFvXe+6qLpXzm/gw5+pOnhtbev+60mzzq3WzxlmtR+lwghf+mKoWF7evRa4dLgRHzlsQIDAQAB");
////            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKeyByte);
////            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
//
//            String encodeAESData = CryptoUtil.encryptRSA(DESKey);
//            System.out.println("encodeAESData:" + encodeAESData);
//
//
//
//
//
//
//
//            String decodeDESData = CryptoUtil.decryptAES(encodeDESData, decodeAESData);
//            System.out.println("decodeData:  " + decodeDESData);
//
//            /**
//             * MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAshajrdQC618UAWnGG+4ZlN/QhW0HJZHl
//             * jcSNzc6sti9yl4NEKz1O5gAfiX3Q68bvtnJr7E40Txecmwa+A2ksBKno39YEaxOQYJwrp3NVHleD
//             * InloNWOEYK3hp1dBjgjei69uIOLPZJvmM1xvdNEg65thhzSihCgq3vWALsIAF3cJxXFiNZwathW/
//             * RjG8zA8Ca1/VzMjne9avse1PQzGpjJLTnVdsVb7BLqmckPORzu4CIqLFBloYHTX1tnH3Fz9Po2dy
//             * Q50DRpRfqINIY8KFvXe+6qLpXzm/gw5+pOnhtbev+60mzzq3WzxlmtR+lwghf+mKoWF7evRa4dLg
//             * RHzlsQIDAQAB
//             */
//            //
////            if (!checkLicense(encodeAESData, encodeData)) {
////
////                return;
////            }
////
////            byte[] ipPB = null;
////            String ipText = Base64.getEncoder().encodeToString(ipPB);
////            byte[] ipSrc = Base64.getDecoder().decode(ipPB);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


            String DESKey = "OdKyzEtY8LuUofJfdssdsds";
        String s = CryptoUtil.encryptRSA(DESKey);
        System.out.println("encryptRsa :" + s);


        // SERVER - work
        String encodeAESData = "BTvNNp42ssYPTKV0";
        encodeAESData = "OdKyzEt+Y8LuUofJfFzUNia/o8dVMghUBmKHstSIg06YHVpGTS2nVccj4GCF+nLL";
        String decodeAESData = CryptoUtil.decryptRSA(s);
        System.out.println("decodeAESData:" + decodeAESData);
    }

    /**
     * ��֤���
     *
     * @param lickey
     * @param licdata
     * @return
     */
    public static boolean checkLicense(String lickey,
                                       String licdata) {
        try {
            if (lickey == null || lickey.trim().length() == 0 || licdata == null || licdata.trim().length() == 0) {
                return false;
            }
            String dataKey = CryptoUtil.decryptRSA(lickey);
            String lictext = CryptoUtil.decryptAES(licdata, dataKey);
            if (lictext == null || lictext.trim().length() == 0) {
                System.out.println("false");
                System.err.println("======lictext====:" + lictext);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
