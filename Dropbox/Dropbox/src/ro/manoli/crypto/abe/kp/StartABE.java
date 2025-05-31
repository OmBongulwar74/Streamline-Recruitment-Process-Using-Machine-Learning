package ro.manoli.crypto.abe.kp;

import java.util.Arrays;

/**
 * 
 * @author Indira
 *
 */
public class StartABE {
	public static void startAbe(byte[] c,String sign) {
		ABE abe = new ABE();
		System.out.println("abe" + abe);
		try {
			Entity root = abe.getRootEntity();
			System.out.println("" + root);
//read file
			
		//	byte[] c = "Indira".getBytes();
			String s = root.sign(sign);
			System.out.println("Valid = " + abe.validateSignature(new String[] { "#level1N=14", "l1=a" }, sign, s));

			byte[] ciphertext = abe.encrypt(c, new String[] { "a", "b", "c", "level1=A", "level2=B", "level3=C",
					"level4=D", "#level1N=10", "#level2N=3", "#level3N=1", "#level4N=5" });
			
			 
			 //File Write Logic
			 
		/*	Entity manager = root.derive("(and (< level1N 13) b)"); 
			String signature = manager.sign("Indira");
			System.out.println("Valid = " + abe.validateSignature(new String[] { "#level1N=14" }, "Indira", signature));*/
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static void DecryptAbe(byte[] c,String sign) {
		ABE abe = new ABE();
		Entity root = abe.getRootEntity();
	byte[] data = root.decrypt(c);
	
	/*assert c == data;
	 System.out.println(Arrays.toString(data));*/
	}	
}
