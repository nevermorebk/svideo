package com.homedirect.insurrance.common.utils;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/**
 * Created by trungdovan on 14/02/2017.
 */
public class MD5 {

  public static String hashData(String data) {
    try {
      MessageDigest hash = MessageDigest.getInstance("MD5");
      hash.update(data.getBytes(Charset.forName("UTF-8")));
      byte[] temp = hash.digest();
      return convertToHex(temp);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return "";
  }

  public static String Md5Enrypt(String md5) {
    try {
      java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
      byte[] array = md.digest(md5.getBytes());
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < array.length; ++i) {
        sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
      }
      return sb.toString();
    } catch (java.security.NoSuchAlgorithmException e) {
    }
    return null;
  }

  private static String convertToHex(byte[] data) {
    StringBuilder buf = new StringBuilder();

    for (byte e : data) {
      int halfbyte = e >>> 4 & 0xF;
      int two_halfs = 0;
      do {
        if ((0 <= halfbyte) && (halfbyte <= 9)) {
          buf.append((char) (48 + halfbyte));
        } else {
          buf.append((char) (97 + (halfbyte - 10)));
        }
        halfbyte = e & 0xF;
      } while (two_halfs++ < 1);
    }
    return buf.toString();
  }
}
