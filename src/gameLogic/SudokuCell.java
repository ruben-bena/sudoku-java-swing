public class SudokuCell {

    private int value;
    private boolean canBeChanged;

    public SudokuCell() {
        this.value = 0;
        this.canBeChanged = false;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isCanBeChanged() {
        return canBeChanged;
    }

    public void setCanBeChanged(boolean canBeChanged) {
        this.canBeChanged = canBeChanged;
    }

    
}
