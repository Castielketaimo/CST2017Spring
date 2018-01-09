package lab08;


public class Piece
{

private static final int PIECE_NONE   = 0;
private static final int PIECE_PAWN   = 1;
private static final int PIECE_KNIGHT = 2;
private static final int PIECE_BISHOP = 3;
private static final int PIECE_ROOK   = 4;
private static final int PIECE_QUEEN  = 5;
private static final int PIECE_KING   = 6;

private boolean isBlack   = false;
private int     pieceType = PIECE_NONE;




	public void draw()
	{
		System.out.println("New piece");
	}

	public Piece(boolean isBlack, int row, int column)
	{
		this.isBlack   = isBlack;
		if ((row == 1) || (row == 6)) {
			this.setType(Piece.PIECE_PAWN);
		} else if ((row > 1) && (row < 6)) {
			this.setType(Piece.PIECE_NONE);
		} else // row 0 or 7 - populate with pieces
		{
			if ((column == 0) || (column == 7)) {
				this.setType(Piece.PIECE_ROOK);
			} else if ((column == 1) || (column == 6)) {
				this.setType(Piece.PIECE_KNIGHT);
			} else if ((column == 2) || (column == 5)) {
				this.setType(Piece.PIECE_BISHOP);
			} else if (column == 3) {
				this.setType(Piece.PIECE_QUEEN);
			} else // king
			{
				this.setType(Piece.PIECE_KING);
			}
		}
	}

	public void setBlack(boolean isBlack)
	{
		this.isBlack = isBlack;
	}

	public boolean getBlack()
	{
		
		return this.isBlack;
	}

	public void setType(int newType)
	{
		this.pieceType = newType;
	}

	public int getType()
	{
		return this.pieceType;
	}


}
