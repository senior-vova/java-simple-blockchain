import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Chain {
	private static ArrayList<Block> chain = new ArrayList<Block>();

	public Chain() {
		Timestamp ts = this.getTimeStamp();
		BlockData data = new BlockData("", "", 0);
		Block genesisBlock = new Block(ts, "", data); 
		chain.add(genesisBlock);
	}

	public void AddBlock(BlockData data) {
		Timestamp ts = this.getTimeStamp();
		String prevHash = chain.get(chain.size() - 1).hash;
		Block block = new Block(ts, prevHash, data);
		chain.add(block);
	}
	
	private Timestamp getTimeStamp() {
		LocalDateTime now = LocalDateTime.now();
		Timestamp timestamp = Timestamp.valueOf(now);
		return timestamp;
	}
	
	public boolean isValid() {
		for (int i = 1; i < chain.size(); i++) {
			Block currBlock = chain.get(i);
			Block prevBlock = chain.get(i - 1);
			
			if (currBlock.prevHash != prevBlock.hash) {
				return false;
			}
		}
		
		return true;
	}
}
