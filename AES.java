package Sample;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.security.*;
import java.io.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {
    private static SecretKeySpec secretKey;
    private static byte[] key;
    private static final String ALGORITHM = "AES";

    public void prepareSecreteKey(String myKey) {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String strToEncrypt, String secret) {
        try {
            prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public String decrypt(String strToDecrypt, String secret) {
        try {
            prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        final String secretKey = "ansh";
        
        FileReader fr = new FileReader("C:\\Users\\user\\Documents\\encrypt.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        File rslt = new File("C:\\Users\\user\\Documents\\result.txt");       
        FileWriter fw = new FileWriter(rslt);
        while((line=br.readLine())!=null) {
        	 AES aes = new AES();
             String estr = aes.encrypt(line, secretKey);
             String dstr = aes.decrypt(estr, secretKey);  
             fw.write("Encrypted message : "+estr+"\n");
             fw.write("Decrypted message : "+dstr+"\n");
        }
        fw.close(); 
    }
}
