public class Sequence{

	private int numOfElementsToCalculate;
	private int[] sequence;
	private int[] noteSequence;
	private int modulusOfElementsConvertingToNote;
	private int noteOffset;

	/**
	 * Constructor
	 * @param numOfElementsToCalculate This is the number of elements to calculate in the sequence.
	 */
	public Sequence(int numOfElementsToCalculate){
		this.numOfElementsToCalculate = numOfElementsToCalculate;
		this.sequence = new int[numOfElementsToCalculate];
		this.noteSequence = new int[numOfElementsToCalculate];
		this.modulusOfElementsConvertingToNote = numOfElementsToCalculate;
		this.noteOffset = 0;
	}
	/**
	 * Constructor
	 * @param numOfElementsToCalculate This is the number of elements to calculate in the sequence.
	 * @param modulusOfElementsConvertingToNote This is the modulus value for each element in the noteSequence will
	 *                                          be modulo of the corresponding value in sequnce.
	 */
	public Sequence(int numOfElementsToCalculate, int modulusOfElementsConvertingToNote){
		this.numOfElementsToCalculate = numOfElementsToCalculate;
		this.sequence = new int[numOfElementsToCalculate];
		this.noteSequence = new int[numOfElementsToCalculate];
		this.modulusOfElementsConvertingToNote = modulusOfElementsConvertingToNote;
		this.noteOffset = 0;
	}

	/**
	 * Constructor
	 * @param numOfElementsToCalculate This is the number of elements to calculate in the sequence.
	 * @param modulusOfElementsConvertingToNote This is the modulus value for each element in the noteSequence will
	 *                                          be modulo of the corresponding value in sequnce.
	 * @param noteOffset This value will be added to each value in the sequence while converting
	 *                   them the notes.
	 */
	public Sequence(int numOfElementsToCalculate, int modulusOfElementsConvertingToNote, int noteOffset){
		this.numOfElementsToCalculate = numOfElementsToCalculate;
		this.sequence = new int[numOfElementsToCalculate];
		this.noteSequence = new int[numOfElementsToCalculate];
		this.modulusOfElementsConvertingToNote = modulusOfElementsConvertingToNote;
		this.noteOffset = noteOffset;
	}

	public int getNumOfElementsToCalculate() {
		return numOfElementsToCalculate;
	}

	public int[] getSequence(){
		return sequence;
	}
	
	public int[] getNoteSequence(){
		return noteSequence;
	}
	
	public int getNoteOffset(){
		return noteOffset;
	}
	
	public int getModulusOfElementsConvertingToNote(){
		return modulusOfElementsConvertingToNote;
	}
	
	public void setNoteOffset(int noteOffset){
		this.noteOffset = noteOffset;
	}
	
	public void setModulusOfElementsConvertingToNote(int modulusOfElementsConvertingToNote){
		this.modulusOfElementsConvertingToNote = modulusOfElementsConvertingToNote;
	}

	/**
	 * Prints the sequence.
	 */
	public void printSequence(){
		for(int num : sequence){
			System.out.print(num + " ");
		}
		System.out.println();
	}

	/**
	 * Prints the noteSequence.
	 */
	public void printNoteSequence(){
		for(int num : noteSequence){
			System.out.print(num + " ");
		}
		System.out.println();
	}

}  