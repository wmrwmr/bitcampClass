package chapter07;

public class Speaker {
	private int volumeRate;

	public void showCurrentState() {
		System.out.println("볼륨 크기: " + volumeRate);

	}

	public void setVolume(int vol) {
		volumeRate = vol;
	}
}
