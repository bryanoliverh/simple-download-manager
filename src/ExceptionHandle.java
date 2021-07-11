public class ExceptionHandle extends Exception {
    private final int fileSize;
    public ExceptionHandle(int fileSize){
        super("Angka ");
        this.fileSize = fileSize;
    }
    public String getMessage() {
        return super.getMessage() + fileSize + " tidak habis bila dibagi 3.";
    }
}