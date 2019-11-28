public class RecamanSequence{
	
	private int numOfElementsToCalculate;
	private int[] sequence;
	private int[] noteSequence;
	
	public RecamanSequence(int numOfElementsToCalculate){
		this.numOfElementsToCalculate = numOfElementsToCalculate;
		sequence = new int[numOfElementsToCalculate];
		noteSequence = new int[numOfElementsToCalculate];
		calculateSequence();
	}
	
	public int[] getSequence(){
		return sequence;
	}
	
	public int[] getNoteSequence(){
		return noteSequence;
	}
	
	public void calculateSequence(){
		sequence[0] = 0;
		for(int i = 1; i < numOfElementsToCalculate; i++){
			int currentNumberNeg = sequence[i - 1] - i;
			if(currentNumberNeg <= 0 || isANumberUsed(currentNumberNeg, i))
				sequence[i] = sequence[i - 1] + i;
			else
				sequence[i] = currentNumberNeg;
			noteSequence[i] = sequence[i] % 48;
		}
	}

	public boolean isANumberUsed(int num, int currentArraySize){
		boolean used = false;
		for(int i = 0; i < currentArraySize; i++){
			if(sequence[i] == num)
				return true;
		}
		return false;
	}
	
	public void printSequence(){
		for(int num : sequence){
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	public void printNoteSequence(){
		for(int num : noteSequence){
			System.out.print(num + " ");
		}
		System.out.println();
	}

}  