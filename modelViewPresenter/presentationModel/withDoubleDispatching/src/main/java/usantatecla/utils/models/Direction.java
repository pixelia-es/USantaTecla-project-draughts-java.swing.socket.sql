package usantatecla.utils.models;

public enum Direction {

	VERTICAL,
	HORIZONTAL,
	MAIN_DIAGONAL,
	INVERSE_DIAGONAL,
	DIAGONAL,
	NULL;

	public boolean isNull() {
		return this == Direction.NULL;
	}	

}
