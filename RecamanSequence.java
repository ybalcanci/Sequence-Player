public class RecamanSequence extends Sequence{

	public RecamanSequence(int numOfElementsToCalculate){
		super(numOfElementsToCalculate);
		calculateSequence();
	}

	public RecamanSequence(int numOfElementsToCalculate, int modulusOfElementsConvertingToNote){
		super(numOfElementsToCalculate, modulusOfElementsConvertingToNote);
		calculateSequence();
	}

	public RecamanSequence(int numOfElementsToCalculate, int modulusOfElementsConvertingToNote, int noteOffset){
		super(numOfElementsToCalculate, modulusOfElementsConvertingToNote, noteOffset);
		calculateSequence();
	}

	private void calculateSequence(){
		int[] sequence = getSequence();
		int[] noteSequence = getNoteSequence();
		sequence[0] = 0;
		for(int i = 1; i < getNumOfElementsToCalculate(); i++){
			int currentNumberNeg = sequence[i - 1] - i;
			if(currentNumberNeg <= 0 || isANumberUsed(currentNumberNeg, i))
				sequence[i] = sequence[i - 1] + i;
			else
				sequence[i] = currentNumberNeg;
			noteSequence[i] = ( sequence[i] % getModulusOfElementsConvertingToNote() ) + getNoteOffset();
		}
	}

	private boolean isANumberUsed(int num, int currentArraySize){
		int[] sequence = getSequence();
		for(int i = 0; i < currentArraySize; i++){
			if(sequence[i] == num)
				return true;
		}
		return false;
	}

}  