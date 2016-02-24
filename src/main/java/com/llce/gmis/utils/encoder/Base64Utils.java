package com.llce.gmis.utils.encoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.codec.binary.Base64;

/**
 * An utility class for Base64 encoding and decoding.
 * @author 
 */
public class Base64Utils {
    
	/**
	 * Encode an object to base64 string.
	 */
	public static String encode(Object o) {
		ByteArrayOutputStream out = null;
        try {
        	out = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(o);
            byte[] data = out.toByteArray();
            return Base64.encodeBase64String(data);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } finally {
        	try { out.close(); } catch (Exception e) { }
        }
    }
    
    /**
     * Decode an object from base64 string.
     */
    public static Object decode(String str) {
    	ByteArrayInputStream in = null;
        try {
            byte[] bytes = Base64.decodeBase64(str);
            in = new ByteArrayInputStream(bytes);
            ObjectInputStream q = new  ObjectInputStream(in);
            return q.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
        	try { in.close(); } catch (Exception e) { }
        }
    }
}
