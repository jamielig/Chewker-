package jwtc.android.chess.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import jwtc.android.chess.constants.ColorSchemes;
import jwtc.chess.board.ChessBoard;

public class ChessSquareView extends View {
    private int pos;
    private boolean selected;

    private static Paint paint = new Paint();

    public ChessSquareView(Context context, int pos) {
        super(context);
        this.pos = pos;
        selected = false;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
        this.invalidate();
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        this.invalidate();
    }

    public boolean getSelected() {
        return this.selected;
    }

    public void onDraw(Canvas canvas) {
        if (selected) {
            paint.setColor(ColorSchemes.getHightlight());
        } else {
            final int fieldColor = (pos & 1) == 0 ? (((pos >> 3) & 1) == 0 ? ChessBoard.WHITE : ChessBoard.BLACK) : (((pos >> 3) & 1) == 0 ? ChessBoard.BLACK : ChessBoard.WHITE);
            paint.setColor(fieldColor == ChessBoard.WHITE ? ColorSchemes.getLight() : ColorSchemes.getDark());
        }
        canvas.drawRect(new Rect(0, 0, getWidth(), getHeight()), paint);
    }
}
