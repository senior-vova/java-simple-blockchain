
public class Main {

	public static void main(String[] args) {
		Chain blockchain = new Chain();
		
		BlockData data1 = new BlockData("Vanya", "Ivan", 100);
		blockchain.AddBlock(data1);
		
		BlockData data2 = new BlockData("John", "Sergey", 400);
		blockchain.AddBlock(data2);
		
		BlockData data3 = new BlockData("Nurlan", "Vanya", 300);
		blockchain.AddBlock(data3);
		
		System.out.println("\nBlockchain validation...");
		if (blockchain.isValid()) {
			System.out.println("Blockchain is valid");
		}else {
			System.out.println("Blockchain is not valid");
		}
	}

}
