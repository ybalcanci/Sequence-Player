import javax.sound.midi.*;

public class RecamanSequencePlayer{

    public static void main(String[] args) {
		int durationOfEachNote = 400; // in ms
		
		RecamanSequence rs = new RecamanSequence(100);
		int[] notes = rs.getNoteSequence();
	
		// Code to play sounds
		// https://stackoverflow.com/questions/16462854/midi-beginner-need-to-play-one-note
		try{
			/* Create a new Sythesizer and open it. Most of 
			* the methods you will want to use to expand on this 
			* example can be found in the Java documentation here: 
			* https://docs.oracle.com/javase/7/docs/api/javax/sound/midi/Synthesizer.html
			*/
			Synthesizer midiSynth = MidiSystem.getSynthesizer(); 
			midiSynth.open();
		
			//get and load default instrument and channel lists
			Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
			MidiChannel[] mChannels = midiSynth.getChannels();
		
			midiSynth.loadInstrument(instr[0]);//load an instrument
		
			for(int note : notes){
				mChannels[0].noteOn(note, 100);//On channel 0, play note number 60 with velocity 100 
				try {
					Thread.sleep(durationOfEachNote); // wait time in milliseconds to control duration
				} catch( InterruptedException e ) { }
				mChannels[0].noteOff(note);//turn of the note
			}
			
		} catch (MidiUnavailableException e) {}
	}

}  