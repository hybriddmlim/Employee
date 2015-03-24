package webapp.escape;

public class Screen {
	public static final int BLACK    = 40;
	public static final int RED      = 41;
	public static final int GREEN    = 42;
	public static final int YELLOW   = 43;
	public static final int BLUE     = 44;
	public static final int MAGENTA  = 45;
	public static final int CYAN     = 46;
	public static final int WHITE    = 47;
	
	
	public static void clear() {
		System.out.print("\033[2J");
		System.out.flush();
	}
	
	public static void cursorPosition(int line, int col) {
		if(line<0 || col<0)
			throw new RuntimeException("position error" + line + "" + col);
		
		System.out.print("\033[" + line + ";" + col + "H");
		System.out.flush();
	}
	
	
	public static void background(Background color) {
		background(color.value);
	}
	
	public static void foreground(Foreground color) {
		foreground(color.value);
	}
	
	public static void reset() {
		System.out.print("\033[0m");
		System.out.flush();
	}
	
	public static void background(int color) {

		if (color<40 || color>47)
			throw new RuntimeException("background Color value error" + color);
		
		System.out.print("\033[" +color + "m");
		System.out.flush();
	}
	
	public static void foreground(int color) {
		color -= 10;
		if (color<30 || color>37)
			throw new RuntimeException("foreground Color value error" + color);

		System.out.print("\033[" + color + "m");
		System.out.flush();
	}

	synchronized public static void print(int line, int col, char c) {
		cursorPosition(line, col);
		System.out.print(c);
		System.out.flush();
	}
	
	
}
