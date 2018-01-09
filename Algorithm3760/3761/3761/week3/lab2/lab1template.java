public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long stime = System.currentTimeMillis();
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Getry\\workspace\\AlgoLab\\src\\MathLab2\\Dict.txt"));
			String filehold = br.readLine();
			br.close();
			String[] fileArray = filehold.split(" ");
			int[] countArray = new int[fileArray.length];

			for(int i = 0; i < fileArray.length; i++) {
				for(int j = i + 1; j < fileArray.length; j++){
					if(tech1(fileArray[i], fileArray[j])){
						countArray[i] = countArray[i] + 1;
						countArray[j] = countArray[j] + 1;

					}
				}
			}

			int maxAmount = 0;
			int maxIndex = 0;
			for(int i = 0; i < countArray.length; i++ ) {
				if(maxAmount < countArray[i]){
					maxIndex = i;
					maxAmount = countArray[i];

				}

			}
			long etime = System.currentTimeMillis();

			System.out.println(fileArray[maxIndex] + " with " + maxAmount + " appearances ");
			System.out.println("Took " + ((etime - stime)/1000) + " seconds");

		} catch (Exception e) {

		}



	}


	public static boolean tech1(String word1, String word2) {
		if(word1.length() != word2.length())
			return false;

		StringBuilder temp = new StringBuilder(word2);

		for(int i = 0; i < word1.length(); i++) {
			for(int j = 0; j < temp.length(); j++) {
				if(word1.charAt(i) == temp.charAt(j)){
					temp.deleteCharAt(j);
					break;
				}
			}
		}


		if(temp.length() == 0) {
			return true;
		}
		else{
			return false;
		}
	}

	public static boolean tech2 (String word1, String word2) {
		if(word1.length() != word2.length()) {
			return false;
		}

		char [] word1Array = word1.toCharArray();
		char [] word2Array = word2.toCharArray();

		Arrays.sort(word1Array);
		Arrays.sort(word2Array);

		for(int i = 0; i < word1Array.length; i++) {
			if (word1Array[i] != word2Array[i]) {
				return false;
			}
		}
		return true;
	}

	public static boolean tech3(String word1, String word2) {
		if(word1.length() != word2.length() ) {
			return false;
		}

		int[] vector = new int[128];
		for(int i = 0; i < word1.length(); i++) {
			vector[word1.charAt(i)]++;
			vector[word2.charAt(i)]--;
		}
		for(int j = 0; j < 128; j++) {
			if(vector[j] != 0) {
				return false;
			}

		}
		return true;
	}

}
