package ru.clevertec.git.hashGenerator;


import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class HashMD5 implements HashMD5I{
    public String generator (String hash)  {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return ""; // TODO: 12.01.23
        }
        md5.update(hash.getBytes(StandardCharsets.UTF_8));
        String s = Hex.encodeHexString(md5.digest());
        System.out.println("s = " + s);
        return s;
    }
}
