package webapp.escape;
/*
30	Black
31	Red
32	Green
33	Yellow
34	Blue
35	Magenta
36	Cyan
37	White
 */


public enum Foreground {
	BLACK(30),
	RED(31),
	GREEN(32),
	YELLOW(33),
	BLUE(34),
	MAGENTA(35),
	CYAN(36),
	WHITE(37);
	
	final int value;
	
	private Foreground(int value) {
		this.value=value;
	}

	
}
