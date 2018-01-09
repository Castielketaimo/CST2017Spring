package lab08;

public class Square {
	private boolean isBlack;
	private int row;
	private int column;
	private Piece piece;

	/**
	 * @param isBlack
	 * @param row
	 * @param column
	 * @param piece
	 * @roseuid 41899DC80305
	 */
	public Square(boolean isBlack, int row, int column, Piece piece) {
		this.isBlack = isBlack;
		this.row = row;
		this.column = column;
		this.piece = piece;
	}

	/**
	 * @roseuid 41899D9C0316
	 */
	public void draw() {
		// 0,0 is bottom left square
		// 7,7 is top right square
		if ((row % 2) == (column % 2)) // diagonals are black
		{
			isBlack = true;
		} else {
			isBlack = false;
		}


		if (isBlack) {
			System.out.print("Black");
		} else {
			System.out.print("White");
		}
		System.out.print(" square, row ");
		System.out.print(row);
		System.out.print(" column ");
		System.out.print(column);
		System.out.print(" and piece is ");
		System.out.println(piece.getType());
	}
}
