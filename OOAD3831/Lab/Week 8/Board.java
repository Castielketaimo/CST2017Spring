package lab08;

public class Board {

	final int NUMBER_ROWS_PER_BOARD = 8;
	final int NUMBER_COLUMNS_PER_BOARD = 8;
	final int NUMBER_SQUARES_PER_BOARD = NUMBER_ROWS_PER_BOARD * NUMBER_COLUMNS_PER_BOARD;

	private Square[][] squares = new Square[NUMBER_ROWS_PER_BOARD][NUMBER_COLUMNS_PER_BOARD];

	public void draw() {
		int row, column = 0;
		boolean isBlack = false;
		Piece piece;

		System.out.println("New board");

		for (row = 0; row < NUMBER_ROWS_PER_BOARD; row++) {
			for (column = 0; column < NUMBER_ROWS_PER_BOARD; column++) {
				piece = new Piece(true, row, column);
				piece.setBlack(true);

				squares[row][column] = new Square(isBlack, row, column, piece);
				squares[row][column].draw();
			}
		}

	}

}