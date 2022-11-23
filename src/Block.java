import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class Block {
	public String hash;
	public String prevHash;
	public BlockData data;
	public Timestamp timestamp;

	public Block(Timestamp timestamp, String prevHash, BlockData data) {
		this.prevHash = prevHash;
		this.data = data;
		this.timestamp = timestamp;
		this.hash = this.generateHash(prevHash, timestamp);
		this.LogBlock();
	}
	
	private String generateHash(String prevHash, Timestamp timestamp) {
		try {
			String strForHash = prevHash + String.valueOf(timestamp);
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(strForHash.getBytes(StandardCharsets.UTF_8));
			
			return String.valueOf(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		    throw new RuntimeException();
		}
	}
	
	private void LogBlock() {
		System.out.println("\nNew block:");
		System.out.print("Date: ");
		System.out.println(this.timestamp);
		System.out.print("Prev Hash: ");
		System.out.println(this.prevHash);
		System.out.print("Hash: ");
		System.out.println(this.hash);
	}
}
