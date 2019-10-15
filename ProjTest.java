import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class ProjTest {
 


public ProjTest() 
{
try{		String array[]=new String[3];
  	array[0]="Arabian2.wav";
  	array[1]="Arabian2.wav";
  	array[2]="Arabian2.wav";
  	int count=1;
  	while(count<=2){
  	
    AudioInputStream stream = AudioSystem.getAudioInputStream(new File(array[(int)( Math.random() * 3 )]));

    AudioFormat format = stream.getFormat();
    if (format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
      format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, format
          .getSampleRate(), format.getSampleSizeInBits() * 2, format
          .getChannels(), format.getFrameSize() * 2, format.getFrameRate(),
          true); // big endian
      stream = AudioSystem.getAudioInputStream(format, stream);
    }

    DataLine.Info info = new DataLine.Info(Clip.class, stream.getFormat(),
        ((int) stream.getFrameLength() * format.getFrameSize()));
    Clip clip = (Clip) AudioSystem.getLine(info);

    clip.open(stream);

    clip.start();
   Thread.sleep(clip.getMicrosecondLength()/1000);
  count++;}
  }catch(Exception ex){}
	
	}

}//end of class
