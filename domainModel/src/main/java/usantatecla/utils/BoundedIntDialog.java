package usantatecla.utils;

public class BoundedIntDialog {

	private final ClosedInterval LIMITS;
	private static final String ERROR_MESSAGE = "Invalid number";

	public BoundedIntDialog(int min, int max){
		this.LIMITS = new ClosedInterval(min, max);
	}

	public int read(String message) {
		assert message != null;

		boolean ok = false;
		int value;
		do {
			value = Console.instance().readInt(message + "? " + this.LIMITS + ": ");
			ok = this.LIMITS.isIncluded(value);
			if (!ok) {
				Console.instance().writeln(BoundedIntDialog.ERROR_MESSAGE);
			}
		} while(!ok);
		return value;
	}
    
}