package com.khubla.pdxreader.util;

import java.io.IOException;
import java.nio.charset.Charset;

import com.google.common.io.LittleEndianDataInputStream;

/**
 * @author tom
 */
public class StringUtil {
   public static String ByteArrayToString(byte[] bytes) {
      final StringBuilder builder = new StringBuilder();
      for (final byte b : bytes) {
         builder.append(String.format("%02x", b));
      }
      return builder.toString();
   }

   /**
    * read a fixed length string from a byte buffer
    */
   public static String readString(byte[] data, Charset charset) throws IOException {
     /*String result = new String(data, java.nio.charset.Charset.forName("windows-1251"));
     return result.trim();*/
      /*final StringBuilder stringBuilder = new StringBuilder();
      int i = 0;
      while ((data[i] != 0) && (i < (data.length - 1))) {
         stringBuilder.append((char) data[i++]);
      }
      return stringBuilder.toString().trim();*/
      //byte[] buffer = new byte[data.length]; 
      int len = 0;
      while ((data[len] != 0) && (len < (data.length - 1))) {
         len++;
      }
      if (charset == null)
        return new String(data, 0, len);
      else
        return new String(data, 0, len, charset);
   }

   /**
    * read a null terminated string from a LittleEndianDataInputStream
    */
   public static String readString(LittleEndianDataInputStream littleEndianDataInputStream) throws IOException {
      final StringBuilder stringBuilder = new StringBuilder();
      int c = littleEndianDataInputStream.readUnsignedByte();
      while (c != 0) {
         stringBuilder.append((char) c);
         c = littleEndianDataInputStream.readUnsignedByte();
      }
      return stringBuilder.toString();
   }
}
