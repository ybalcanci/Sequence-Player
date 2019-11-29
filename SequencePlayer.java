/**
 * Program to play a given sequence with Java MIDI.
 *
 * @author Yasin Balcanci
 * @version 1.0
 * @since 2019-11-28
 */

import javax.sound.midi.*;

public class SequencePlayer {

	public static void main(String[] args) {
		int durationOfEachNote = 400; // in ms

		RecamanSequence rs = new RecamanSequence(200, 48, 16);
		int[] notes = rs.getNoteSequence();

		playSequence(notes, durationOfEachNote);
	}

	/**
	 * This method plays a given sequence
	 * @param sequence This is the sequence to play.
	 * @param noteDuration This is the duration each note will be played.
	 */
	private static void playSequence(int[] sequence, int noteDuration) {
		// Code to play sounds
		// https://stackoverflow.com/questions/16462854/midi-beginner-need-to-play-one-note
		try {
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

			for (int note : sequence) {
				mChannels[0].noteOn(note, 100);//On channel 0, play note with velocity 100 
				System.out.print(note + " ");
				try {
					Thread.sleep(noteDuration); // wait time in milliseconds to control duration
				} catch (InterruptedException e) {
				}
				mChannels[0].noteOff(note);//turn of the note
			}

		} catch (MidiUnavailableException e) {
		}
	}
}  